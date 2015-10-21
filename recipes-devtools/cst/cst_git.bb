SUMMARY = "utility for security boot"
LICENSE = "BSD"

# TODO: fix license - this file is not a license
LIC_FILES_CHKSUM = "file://include/common.h;beginline=8;endline=30;md5=573e4049ebb103e1cb3f63bc8aaf00b2"

DEPENDS += "openssl"

inherit kernel-arch

SRC_URI = "git://git.freescale.com/ppc/sdk/cst.git;branch=master"
SRCREV = "6f57c86c93cab0f4d0a40d83b685afa6932a6301"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" LD="${CC}"'

do_install () {
    oe_runmake install DESTDIR=${D} BIN_DEST_DIR=${bindir}
}

BBCLASSEXTEND = "native nativesdk"
PARALLEL_MAKE = ""

FILES_${PN}-dbg += "${bindir}/cst/.debug"
