do_install:append() {
    echo "" >> ${D}${sysconfdir}/profile
    echo "export SYSTEMD_PAGER=" >> ${D}${sysconfdir}/profile
}
