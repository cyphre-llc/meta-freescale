FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

BUSYBOX_SPLIT_SUID = "0"

SRC_URI_append = " file://defconfig-fsl"

do_configure_prepend () {
    cp ${WORKDIR}/defconfig-fsl ${WORKDIR}/defconfig
}

