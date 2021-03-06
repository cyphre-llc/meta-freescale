DESCRIPTION = "qe microcode binary"
LICENSE = "Freescale-EULA"
LIC_FILES_CHKSUM = "file://EULA;md5=60037ccba533a5995e8d1a838d85799c"

python () {
    if not d.getVar("QE_UCODE", True):
        PN = d.getVar("PN", True)
        FILE = os.path.basename(d.getVar("FILE", True))
        bb.debug(1, "To build %s, see %s for instructions on \
                 setting up your qe-ucode" % (PN, FILE))
        raise bb.parse.SkipPackage("because QE_UCODE is not set")
}

inherit deploy

SRC_URI = "git://git.freescale.com/ppc/sdk/qe-ucode.git;nobranch=1"
SRCREV= "49efc94b553de5c2a9bd28093592eff0068e161c"

S = "${WORKDIR}/git"

do_install () {
       install -d ${D}/boot
       install -m 644 ${QE_UCODE} ${D}/boot
}

do_deploy () {
       install -d ${DEPLOYDIR}/boot
       install -m 644 ${QE_UCODE} ${DEPLOYDIR}/boot
}
addtask deploy before do_build after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot/*"
COMPATIBLE_MACHINE = "(p1025|p1021|t1040|t1024|t1042|ls102xa)"
