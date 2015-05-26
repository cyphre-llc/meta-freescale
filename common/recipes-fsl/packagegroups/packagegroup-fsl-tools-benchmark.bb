# Copyright 2015 Freescale Semiconductor, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Package group containing benchmark tools."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


inherit packagegroup

FSL_NEON = "${@bb.utils.contains('TUNE_FEATURES', 'neon', 'cpuburn-neon', '', d)}"

RDEPENDS_${PN} = " \
    lmbench \
    bonnie++ \
    dbench \
    fio \
    iozone3 \
    iperf \
    nbench-byte \
    tiobench \
    ${FSL_NEON} \
"
