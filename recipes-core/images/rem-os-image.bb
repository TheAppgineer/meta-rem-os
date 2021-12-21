SUMMARY = "The REM OS image"

LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb

KERNEL_MODULES = " \
    kernel-modules \
"

SOFTWARE_COMPONENTS = " \
    avahi-utils \
    docker-ce \
    docker-data-service \
    libnss-mdns \
    parted \
    rem \
    tzdata \
    xfsprogs \
"

IMAGE_INSTALL_append = "${KERNEL_MODULES}${SOFTWARE_COMPONENTS}"

IMAGE_FSTYPES = "ext4 tar.bz2 wic wic.bz2"
