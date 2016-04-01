SUMMARY = "Simple lxdm Init Script"
SECTION = "x11"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

SRC_URI = "\
    file://lxdm \
    file://lxdm.conf \
    file://lxdm.service \
"
S = "${WORKDIR}"

inherit allarch update-rc.d systemd

INITSCRIPT_NAME = "lxdm"
INITSCRIPT_PARAMS = "start 80 5 . stop 80 0 1 2 3 6 ."
INITSCRIPT_PARAMS_shr = "start 90 5 . stop 90 0 1 2 3 6 ."

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install lxdm ${D}${sysconfdir}/init.d

    if ${@base_contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${sysconfdir}/default
        install -d ${D}${systemd_unitdir}/system
        install lxdm.conf ${D}${sysconfdir}/default/lxdm
        install -m 0644 ${WORKDIR}/lxdm.service ${D}${systemd_unitdir}/system
    fi
}

RDEPENDS_${PN} = "lxdm"

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "lxdm.service"

FILES_${PN} += "${sysconfdir}/default/lxdm"

