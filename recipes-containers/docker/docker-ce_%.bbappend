FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://daemon.json \
"

do_install:append() {
    sed 's/docker.socket/docker.socket containerd.service docker-data.service/' ${D}/${systemd_system_unitdir}/docker.service > ${WORKDIR}/docker.service
    install -m 644 ${WORKDIR}/docker.service ${D}${systemd_system_unitdir}/
    install -d ${D}${sysconfdir}/docker
    install -m 644 ${WORKDIR}/daemon.json ${D}${sysconfdir}/docker
}
