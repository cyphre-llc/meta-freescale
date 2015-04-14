FSL_PKGS = " \
    fmc \
    qoriq-debug \
    usdpaa \
"
FSL_PKGS_e500v2 = ""
FSL_PKGS_ls102xa = ""

# common packages
IMAGE_INSTALL += " \
    ${FSL_PKGS} \
    apptrk \
    asf \
    eth-config \
    merge-files \
    mux-server \
"

IMAGE_INSTALL_remove_ls102xa = " \
    apptrk \
    eth-config \
    mux-server \
"

# pkgs to be installed for each core
IMAGE_INSTALL_append_e500v2 = " \
    testfloat \
"

IMAGE_INSTALL_append_e6500-64b = " \
    ceetm \
"

# pkgs to be installed for each board
IMAGE_INSTALL_append_b4420qds = " \
    ipc-modules-multi \
    ipc-modules-single \
    ipc-ust \
"

IMAGE_INSTALL_append_b4860qds = " \
    ipc-modules-multi \
    ipc-modules-single \
    ipc-ust \
"

IMAGE_INSTALL_append_c293pcie = " \
    pkc-firmware \
    skmm-ep \
"

IMAGE_INSTALL_append_p1023rdb = " \
    fmc \
"

# NOTE: Remove the conditional pkc-host inclusion and all traces of c29x_pkc
# DISTRO_FEATURE if pkc-host no longer requires customized cryptodev patches
IMAGE_INSTALL_append_p4080ds = " \
    ${@base_contains('DISTRO_FEATURES', 'c29x_pkc', 'pkc-host', '', d)} \
    skmm-ep \
    skmm-host \
"

IMAGE_INSTALL_append_t1040rdb = " \
    ar \
    ceetm \
    uio-seville \
"

IMAGE_INSTALL_append_t1040rdb-64b = " \
    ar \
    ceetm \
    uio-seville \
"

IMAGE_INSTALL_append_t1042rdb = " \
    ar \
    ceetm \
    uio-seville \
"

IMAGE_INSTALL_append_t1042rdb-64b = " \
    ar \
    ceetm \
    uio-seville \
"

IMAGE_INSTALL_append_t1042rdb-pi = " \
    ar \
"
IMAGE_INSTALL_append_t1042rdb-pi-64b = " \
    ar \
"

IMAGE_INSTALL_append_t4240qds = " \
    ${@base_contains('DISTRO_FEATURES', 'c29x_pkc', 'pkc-host', '', d)} \
    skmm-ep \
    skmm-host \
"
