SUMMARY = "The REM OS image"

LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb

KERNEL_MODULES = " \
    kernel-module-br-netfilter \
    kernel-module-cdrom \
    kernel-module-nf-conntrack-netlink \
    kernel-module-nft-masq \
    kernel-module-snd \
    kernel-module-snd-aloop \
    kernel-module-snd-pcm \
    kernel-module-snd-timer \
    kernel-module-sr-mod \
    kernel-module-usb-storage \
    kernel-module-xfs \
    kernel-module-xt-masquerade \
"

SOFTWARE_COMPONENTS = " \
    alsa-utils \
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

IMAGE_FEATURES_append = " ssh-server-openssh"

IMAGE_FSTYPES = "ext4 tar.bz2 wic wic.bz2"
