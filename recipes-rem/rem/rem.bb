DESCRIPTION = "Roon Extension Manager"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "\
    file://entrypoint-spotify.json \
    file://rem.service \
    file://rem.sh \
    file://80-audio-cd.rules \
"

inherit systemd useradd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-g 1000 rem;-g 991 docker"
USERADD_PARAM:${PN} = "-u 1000 -g 1000 -G 991 -d /home/rem -r -s /bin/sh rem"

SYSTEMD_SERVICE:${PN} = "rem.service"

FILES:${PN} += "/home/rem"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/rem.sh ${D}${bindir}
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/rem.service ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/80-audio-cd.rules ${D}${sysconfdir}/udev/rules.d
    install -d -o rem -g rem ${D}/home/rem
    install -d -o rem -g rem ${D}/home/rem/repos
    install -m 0644 -o rem -g rem ${WORKDIR}/entrypoint-spotify.json ${D}/home/rem/repos
}
