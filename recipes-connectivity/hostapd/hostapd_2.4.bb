HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
LICENSE = "GPLv2 | BSD"
LIC_FILES_CHKSUM = "file://README;md5=7f393579f8b109fe91f3b9765d26c7d3"
DEPENDS = "libnl openssl"
SUMMARY = "User space daemon for extended IEEE 802.11 management"

inherit update-rc.d systemd
INITSCRIPT_NAME = "hostapd"

SYSTEMD_SERVICE_${PN} = "hostapd.service"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"

DEFAULT_PREFERENCE = "-1"

SRC_URI = " \
    git://w1.fi/hostap.git;protocol=git;tag=hostap_2_4 \
    file://defconfig \
    file://init \
    file://0001-Add-DPAA-MACsec-API.patch \
"

S = "${WORKDIR}/git"

do_configure() {
    install -m 0644 ${S}/hostapd/dpaa_macsec_defconfig ${S}/hostapd/.config
}

do_compile() {
    export CFLAGS="-MMD -O2 -Wall -g -I${STAGING_INCDIR}/libnl3"
    make -C ${S}/hostapd
}

do_install() {
    install -d ${D}${sbindir} ${D}${sysconfdir}/init.d ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/hostapd/hostapd.conf ${D}${sysconfdir}
    install -m 0755 ${S}/hostapd/hostapd ${D}${sbindir}
    install -m 0755 ${S}/hostapd/hostapd_cli ${D}${sbindir}
    install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hostapd
}

CONFFILES_${PN} += "${sysconfdir}/hostapd.conf"
