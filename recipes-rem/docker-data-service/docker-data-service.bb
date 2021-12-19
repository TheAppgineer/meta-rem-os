DESCRIPTION = "docker-data systemd service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "\
    file://docker-data.service \
    file://mount-xfs.sh \
"

inherit systemd

SYSTEMD_SERVICE_${PN} = "docker-data.service"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/docker-data.service ${D}${systemd_unitdir}/system
    install -d ${D}${bindir_native}
    install -m 0755 ${WORKDIR}/mount-xfs.sh ${D}${bindir_native}/mount-xfs.sh
}
