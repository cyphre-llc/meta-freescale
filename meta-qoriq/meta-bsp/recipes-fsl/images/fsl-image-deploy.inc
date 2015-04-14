# Copyright (C) 2012-2015 Freescale Semiconductor Inc.
#
# The FSL packages for deployment images

IMAGE_INSTALL_append = "\
    hypervisor \
    hypervisor-partman \
"
# special trick for e6500 to include 64bit hypervisor
IMAGE_INSTALL_remove_e6500 = " \
    hypervisor \
    hypervisor-partman \
"
IMAGE_INSTALL_remove_ls102xa = " \
    hypervisor \
    hypervisor-partman \
"

IMAGE_INSTALL_append_e6500 = " \
    ${@base_conditional("TCMODE", "external-fsl", "hypervisor", "lib64-hypervisor", d)} \
    ${@base_conditional("TCMODE", "external-fsl", "hypervisor-partman", "lib64-hypervisor-partman", d)} \
"

DEPLOY_PKGS = " \
    fm-ucode \
    hv-cfg \
    rcw \
"
DEPLOY_PKGS_append_qoriq = " u-boot"
DEPLOY_PKGS_e500v2 = ""

DEPLOY_PKGS_ls102xa = " \
    rcw \
    qe-ucode \
"


EXTRA_IMAGEDEPENDS_append = " cst-native ${DEPLOY_PKGS}"

# pkgs to be installed for specific board
EXTRA_IMAGEDEPENDS_append_ls1021aqds = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_ls1021atwr = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_p1021rdb = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_p1023rdb = " fm-ucode"
EXTRA_IMAGEDEPENDS_append_p1025twr = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1040rdb = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1040rdb-64b = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1024rdb = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1024rdb-64b = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1024qds = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1024qds-64b = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1042rdb = " qe-ucode"
EXTRA_IMAGEDEPENDS_append_t1042rdb-64b = " qe-ucode"

# pkgs to be excluded for specific board
EXTRA_IMAGEDEPENDS_remove_b4420qds = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_b4420qds-64b = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1042rdb-pi = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1042rdb-pi-64b = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1024rdb = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1024rdb-64b = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1024qds = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t1024qds-64b = "hv-cfg"
EXTRA_IMAGEDEPENDS_remove_t4160qds = "hv-cfg rcw"
EXTRA_IMAGEDEPENDS_remove_t4160qds-64b = "hv-cfg rcw"
