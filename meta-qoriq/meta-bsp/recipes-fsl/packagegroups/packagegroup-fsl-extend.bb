SUMMARY = "extend packagegroup for fsl SDK"
LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = "\
    packagegroup-fsl-extend \
    ${@base_contains('DISTRO_FEATURES', 'alsa', 'packagegroup-fsl-extend-alsa', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'perl', 'packagegroup-fsl-extend-perl', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'ppp', 'packagegroup-fsl-extend-ppp', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'python', 'packagegroup-fsl-extend-python', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'usbhost', 'packagegroup-fsl-extend-usbhost', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'virtualization', 'packagegroup-fsl-extend-virtualization', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'db', 'packagegroup-fsl-extend-db', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'benchmark', 'packagegroup-fsl-extend-benchmark', '',d)} \
    packagegroup-fsl-extend-misc \
"

RDEPENDS_packagegroup-fsl-extend = "\
    ${@base_contains('DISTRO_FEATURES', 'alsa', 'packagegroup-fsl-extend-alsa', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'perl', 'packagegroup-fsl-extend-perl', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'ppp', 'packagegroup-fsl-extend-ppp', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'python', 'packagegroup-fsl-extend-python', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'usbhost', 'packagegroup-fsl-extend-usbhost', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'virtualization', 'packagegroup-fsl-extend-virtualization', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'db', 'packagegroup-fsl-extend-db', '',d)} \
    ${@base_contains('DISTRO_FEATURES', 'benchmark', 'packagegroup-fsl-extend-benchmark', '',d)} \
    packagegroup-fsl-extend-misc \
"

RDEPENDS_packagegroup-fsl-extend-alsa = "\
    alsa-utils \
"

RDEPENDS_packagegroup-fsl-extend-perl = "\
    perl \
    perl-misc \
    perl-modules \
    perl-module-re \
    perl-pod \
"

RDEPENDS_packagegroup-fsl-extend-ppp = "\
    ppp \
    ppp-dialin \
"

RDEPENDS_packagegroup-fsl-extend-python = "\
    python \
    python-misc \
    python-modules \
"

RDEPENDS_packagegroup-fsl-extend-usbhost = "\
    usbutils \
    usbutils-ids \
"

RDEPENDS_packagegroup-fsl-extend-virtualization += "\
    qemu \
"
RRECOMMENDS_packagegroup-fsl-extend-virtualization += "\
    lxc \
    libvirt \
    libvirt-libvirtd \
    libvirt-virsh \
"

RDEPENDS_packagegroup-fsl-extend-db = "\
    db \
    sqlite3 \
"

RDEPENDS_packagegroup-fsl-extend-misc = "\
    bind \
    bison \
    ccache \
    chkconfig \
    chrpath \
    curl \
    dhcp-client \
    diffstat \
    dtc \
    gettext-runtime \
    git \
    git-perltools \
    intltool \
    lsb \
    lsbinitscripts \
    lsbtest \
    lsof \
    man \
    man-pages \
    mdadm \
    oprofile \
    parted \
    perf \
    quilt \
    rpm \
    rt-tests \
    subversion \
    tcl \
    texinfo \
    u-boot-mkimage \
    unzip \
    valgrind \
    watchdog \
    which \
    xinetd \
    xz  \
    zip \
"
RRECOMMENDS_packagegroup-fsl-extend-misc = "\
    debianutils \
    libnfnetlink \
    nginx \
    ptpd \
    rng-tools \
    rp-pppoe \
    samba \
    strongswan \
    wget \
"
RRECOMMENDS_packagegroup-fsl-extend-misc_remove_ls102xa = "\
    nginx \
"

RDEPENDS_packagegroup-fsl-extend-benchmark = "\
"
RRECOMMENDS_packagegroup-fsl-extend-benchmark = "\
    bonnie++ \
    dbench \
    tiobench \
"
