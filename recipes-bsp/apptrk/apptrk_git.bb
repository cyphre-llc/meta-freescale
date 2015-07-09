SUMMARY = "Debug agent for Freescale CodeWarrior"
SECTION = "apptrk"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://COPYING;md5=95560debfde180684364319811cc1421"

DEPENDS = "elfutils"

inherit kernel-arch

SRC_URI = "git://git.freescale.com/ppc/sdk/apptrk.git;nobranch=1 \
    file://apptrk-install-create-all-components-of-DEST.patch \
    file://no-strip.patch \
"
SRCREV = "cbed10997c5e2a4aaa004fb0e1efec858bf1bbe1"

S = "${WORKDIR}/git"

CFLAGS_append = " -I${STAGING_INCDIR}"
CFLAGS_append_qoriq-ppc = " -ISource/Linux -ISource/Portable \
     -ISource/Linux_PA -ISource/PA -DPPC \
"
CFLAGS_append_powerpc64 = " -DENABLE_64BIT_SUPPORT"

EXTRA_OEMAKE = ""
do_install() {
    oe_runmake install DESTDIR=${D}
}
