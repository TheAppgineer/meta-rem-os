do_install:append() {
    # Mask the service so that containers can take control of Bluetooth
    install -d ${D}${sysconfdir}/systemd/system
    #ln -s /dev/null ${D}${sysconfdir}/systemd/system/bluetooth.service
}
