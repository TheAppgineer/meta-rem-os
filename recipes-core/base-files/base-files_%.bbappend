do_install_append() {
    echo "" >> ${D}${sysconfdir}/profile
    echo "export SYSTEMD_PAGER=" >> ${D}${sysconfdir}/profile
}
