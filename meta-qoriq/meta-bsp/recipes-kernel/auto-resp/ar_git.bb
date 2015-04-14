DESCRIPTION = "Auto Response Control Module"
LICENSE = "GPLv2 & BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=b5881ecf398da8a03a3f4c501e29d287"

DEPENDS="virtual/kernel"

inherit module

SRC_URI = "git://git.freescale.com/ppc/sdk/auto-resp.git;nobranch=1"
SRCREV =  "dbede76fb4020a370baa393f7c53af4c0db8f175"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} SYSROOT=${STAGING_DIR_TARGET}"
export KERNEL_PATH = "${STAGING_KERNEL_DIR}"

do_compile_prepend(){
    sed -i -e 's,EXTRA_CFLAGS += -I$(PWD),EXTRA_CFLAGS += -I${S},' ${S}/armodule/source/Makefile
}

do_install(){
    mkdir -p ${D}/usr/driver/auto-resp
    cp -rf ${S}/bin ${D}/usr/driver/auto-resp
}

FILES_${PN} += "/usr/driver/auto-resp"
INHIBIT_PACKAGE_STRIP = "1"

COMPATIBLE_MACHINE = "(t1040rdb|t1040rdb-64b|t1042rdb|t1042rdb-64b|t1042rdb-pi|t1042rdb-pi-64b)"
