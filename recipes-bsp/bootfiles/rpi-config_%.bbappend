do_deploy:append() {
    echo "dtoverlay=hifiberry-dacplusadc" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "force_eeprom_read=0" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "enable_uart=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
