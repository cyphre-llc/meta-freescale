SUMMARY = "Reset Configuration Word"
DESCRIPTION = "Reset Configuration Word - hardware boot-time parameters for the QorIQ targets"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://rcw.py;beginline=8;endline=28;md5=9ba0b28922dd187b06b6c8ebcfdd208e"

DEPENDS_qoriq-arm += "change-file-endianess-native"

inherit deploy

SRCBRANCH = "sdk-v1.7.x"
SRCREV = "3e89f378ed70e9b856756de8c3dbdfccb045fa0c"
SRC_URI = "git://git.freescale.com/ppc/sdk/rcw.git;branch=${SRCBRANCH} \
    file://rcw-make-BOARDS-DESTDIR-overidable-in-Makefile.patch \
"

S = "${WORKDIR}/git"

do_install () {
    oe_runmake install

    M=`echo ${MACHINE} | sed s/-64b//g`
    if [ "t1042rdb" = "${M}" ] || [ "t1042rdb-pi" = "${M}" ];then
        M=t1042rdb_pi
    fi
    install -d ${D}/boot/rcw
    cp -r ${S}/${M}/${M}/* ${D}/boot/rcw
}

do_deploy () {
    M=`echo ${MACHINE} | sed s/-64b//g`
    if [ "t1042rdb" = "${M}" ] || [ "t1042rdb-pi" = "${M}" ];then
        M=t1042rdb_pi
    fi
    install -d ${DEPLOYDIR}/rcw
    cp -r ${S}/${M}/${M}/* ${DEPLOYDIR}/rcw
}
addtask deploy after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot"

COMPATIBLE_HOST_qoriq = ".*"
COMPATIBLE_MACHINE = "(qoriq)"

PACKAGE_ARCH = "${MACHINE_ARCH}"
