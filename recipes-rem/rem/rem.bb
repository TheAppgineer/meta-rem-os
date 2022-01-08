DESCRIPTION = "Roon Extension Manager"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "\
    file://rem.service \
    file://rem.sh \
    file://80-audio-cd.rules \
"

inherit systemd

S = "${WORKDIR}"

SYSTEMD_SERVICE:${PN} = "rem.service"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/rem.sh ${D}${bindir}
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/rem.service ${D}${systemd_system_unitdir}
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/80-audio-cd.rules ${D}${sysconfdir}/udev/rules.d
    install -d ${D}${localstatedir}/lib/docker
}
