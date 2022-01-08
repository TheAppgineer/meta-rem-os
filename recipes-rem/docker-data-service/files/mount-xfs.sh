#!/bin/sh

DEVICE=/dev/mmcblk0

if [ ! -b "${DEVICE}p3" ];then
    # Get start sector of last free block
    FREE_SECTOR=$(parted -m -s ${DEVICE} unit s print free | tail -1 | cut -d: -f2 | cut -ds -f1)

    # Round to multiple of 2048 sectors
    FREE_SECTOR=$(( ${FREE_SECTOR} % 2048 ? ${FREE_SECTOR} + 2048 : ${FREE_SECTOR} ))
    PARTITION_START_SECTOR=$(( ${FREE_SECTOR} / 2048 * 2048 ))

    # Add partition
    parted ${DEVICE} mkpart primary ${PARTITION_START_SECTOR}s 100%

    # Format new XFS partition
    mkfs.xfs -f -m bigtime=1 ${DEVICE}p3
fi

# Setup the Docker mountpoint
mount -t xfs -o pquota ${DEVICE}p3 /var/lib/docker
