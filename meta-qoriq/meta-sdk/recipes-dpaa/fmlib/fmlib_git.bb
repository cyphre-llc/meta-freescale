DESCRIPTION = "Frame Manager User Space Library"
LICENSE = "BSD & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3f16fa8e677e45af3127c5c4bafc3c00"

DEPENDS += "virtual/kernel"
DEPENDS_virtclass-native = ""

SRC_URI = "git://git.freescale.com/ppc/sdk/fmlib.git;nobranch=1"
SRCREV = "661d7822aa182f720029134008d7e1db07b0d504"

S = "${WORKDIR}/git"

TARGET_ARCH_FMLIB = "${DEFAULTTUNE}"
TARGET_ARCH_FMLIB_e5500 = "ppc32e5500"
TARGET_ARCH_FMLIB_e6500 = "ppc32e6500"
COMPATIBLE_HOST_qoriq-ppc = ".*"
COMPATIBLE_HOST ?= "(none)"

EXTRA_OEMAKE = "DESTDIR=${D} PREFIX=${prefix} LIB_DEST_DIR=${libdir} \
    CROSS_COMPILE=${TARGET_PREFIX} KERNEL_SRC=${STAGING_KERNEL_DIR}"

FMLIB_TARGET = "libfm-${TARGET_ARCH_FMLIB}"
FMLIB_TARGET_t1 = "libfm-${TARGET_ARCH_FMLIB}-fmv3"
do_compile () {
    oe_runmake ${FMLIB_TARGET}.a
}

do_compile_virtclass-native () {
}

do_install () {
    oe_runmake install-${FMLIB_TARGET}
}

do_install_virtclass-native () {
    install -d ${D}/${includedir}
    cp -rf ${S}/include/* ${D}/${includedir}
}

BBCLASSEXTEND = "native"