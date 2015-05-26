# Copyright 2015 Freescale Semiconductor, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Package group with tools for graphics."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


inherit packagegroup

FSL_X11_UTILS = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)}"

RDEPENDS_${PN} = " \
    fbset \
    evtest \
    ${FSL_X11_UTILS} \
"
