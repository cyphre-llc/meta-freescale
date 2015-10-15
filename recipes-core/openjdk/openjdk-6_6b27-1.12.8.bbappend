FILESEXTRAPATHS_prepend := "${THISDIR}/openjdk-6-6b27:"

ICEDTEAPATCHES += "file://icedtea-openjdk-remove-currency-data-generation-expi.patch;apply=no"
ICEDTEAPATCHES_append_e500v2 = " \
        file://icedtea-jdk-sizers-crosscompile-hack.patch;apply=no \
        "
ICEDTEAPATCHES_append_e500mc = " \
        file://icedtea-jdk-sizers-crosscompile-hack.patch;apply=no \
        "
DISTRIBUTION_PATCHES_append_e500v2 = " \
       patches/icedtea-jdk-sizers-crosscompile-hack.patch \
       "

DISTRIBUTION_PATCHES_append_e500mc = " \
       patches/icedtea-jdk-sizers-crosscompile-hack.patch \
       "

do_configure_append () {
    patch -p0 <${WORKDIR}/icedtea-openjdk-remove-currency-data-generation-expi.patch
    cd openjdk-ecj
    patch -p1 <${WORKDIR}/icedtea-openjdk-remove-currency-data-generation-expi.patch
    cd ..
}

