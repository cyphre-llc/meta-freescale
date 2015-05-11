SUMMARY = "utility for security boot"
LICENSE = "BSD"

# TODO: fix license - this file is not a license
LIC_FILES_CHKSUM = "file://RELEASENOTES;beginline=8;endline=43;md5=5a7b22a2c96b5f94e0498c5f413aa8d3"

DEPENDS += "openssl"

inherit kernel-arch

SRC_URI = "git://git.freescale.com/ppc/sdk/cst.git;nobranch=1"
SRCREV = "2d35e98539c0daa2bc8049e3bd44994d3d93bbe7"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" LD="${CC}"'

do_install () {
    oe_runmake install DESTDIR=${D} BIN_DEST_DIR=${bindir}
}

BBCLASSEXTEND = "native nativesdk"
PARALLEL_MAKE = ""

FILES_${PN}-dbg += "${bindir}/cst/.debug"
