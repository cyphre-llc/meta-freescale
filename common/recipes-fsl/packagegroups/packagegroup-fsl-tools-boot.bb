# Copyright 2015 Freescale Semiconductor, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Package group containing tools commonly desired on boot up."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


inherit packagegroup

FSL_X11_UTILS = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)}"

RDEPENDS_${PN} = " \
    bash \
    busybox \
    e2fsprogs-mke2fs \
    mtd-utils \
    mtd-utils-ubifs \
    mtd-utils-jffs2 \
    fsl-rc-local \
    mdadm \
    hdparm \
    packagegroup-fsl-tools-core-ext2 \
    packagegroup-fsl-tools-graphics \
    fbset \
    ${FSL_X11_UTILS} \
"
