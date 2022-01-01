SUMMARY = "The REM OS image"

LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb

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

IMAGE_INSTALL_append = " \
    kernel-modules \
    ${SOFTWARE_COMPONENTS} \
"

IMAGE_INSTALL_append_raspberrypi3 = " \
    packagegroup-base-bluetooth \
"

IMAGE_FSTYPES = "ext4 tar.bz2 wic wic.bz2"
