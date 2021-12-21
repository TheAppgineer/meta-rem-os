do_deploy_append() {
    echo "dtoverlay=hifiberry-dacplusadc" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "force_eeprom_read=0" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
