SUMMARY = "The REM OS development image"

LICENSE = "MIT"

require recipes-core/images/rem-os-image.bb

SOFTWARE_COMPONENTS_DEVELOP = " \
    alsa-utils \
    bash \
    nano \
"

IMAGE_INSTALL:append = "${SOFTWARE_COMPONENTS_DEVELOP}"

IMAGE_FEATURES:append = " ssh-server-openssh"
