do_compile:append() {
    echo "cgroup_enable=memory swapaccount=1 $(cat ${WORKDIR}/cmdline.txt)" > ${WORKDIR}/cmdline.txt
}
