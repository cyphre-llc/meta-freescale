DESCRIPTION = "Ethernet Configuration Files"
LICENSE = "BSD & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ed5eddbfbb84af5089ea94c382d423c"

SRC_URI = "git://git.freescale.com/ppc/sdk/eth-config.git;branch=sdk-v1.7.x"
SRCREV = "8040e0b1a7cb18cecfe0c7657d42f59f222b7930"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "D=${D}"

do_install() {
    oe_runmake install
}

COMPATIBLE_MACHINE = "(qoriq-ppc)"
