SUMMARY = "The REM OS image"

LICENSE = "MIT"

require recipes-core/images/core-image-base.bb

SOFTWARE_COMPONENTS = " \
    docker-ce \
    docker-data-service \
    parted \
    rem \
    tzdata \
    xfsprogs \
"

IMAGE_INSTALL:append = " \
    ${SOFTWARE_COMPONENTS} \
"

IMAGE_FSTYPES = "ext4 tar.bz2 wic wic.bz2"
