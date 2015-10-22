require recipes-connectivity/wpa-supplicant/wpa-supplicant.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=36b27801447e0662ee0138d17fe93880 \
                    file://README;beginline=1;endline=56;md5=7f393579f8b109fe91f3b9765d26c7d3 \
                    file://wpa_supplicant/wpa_supplicant.c;beginline=1;endline=12;md5=3430fda79f2ba1dd545f0b3c4d6e4d24"
RDEPENDS_${PN} += "libcrypto"

SRC_URI = "git://w1.fi/hostap.git;protocol=git \
           file://defconfig \
           file://wpa-supplicant.sh \
           file://wpa_supplicant.conf \
           file://wpa_supplicant.conf-sane \
           file://99_wpa_supplicant \
           file://0001-Add-DPAA-MACsec-API.patch \
          "
SRCREV = "bc04db9b06ea9c38441be9b6e7b2be24ce2f98a9"

S = "${WORKDIR}/git"

do_configure () {
        ${MAKE} -C wpa_supplicant clean
        install -m 0755 ${S}/wpa_supplicant/dpaa_macsec_defconfig wpa_supplicant/.config
        echo "CFLAGS +=\"-I${STAGING_INCDIR}/libnl3\"" >> wpa_supplicant/.config
        echo "DRV_CFLAGS +=\"-I${STAGING_INCDIR}/libnl3\"" >> wpa_supplicant/.config

        if echo "${PACKAGECONFIG}" | grep -qw "openssl"; then
                ssl=openssl
        elif echo "${PACKAGECONFIG}" | grep -qw "gnutls"; then
                ssl=gnutls
        fi
        if [ -n "$ssl" ]; then
                sed -i "s/%ssl%/$ssl/" wpa_supplicant/.config
        fi

        # For rebuild
        rm -f wpa_supplicant/*.d wpa_supplicant/dbus/*.d
}
