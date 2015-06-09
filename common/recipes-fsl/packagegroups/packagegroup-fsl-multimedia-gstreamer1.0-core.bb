# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by freescale to provide set of packages for GStreamer1.x Plugins"
SUMMARY = "Freescale Package group for multimedia Gstreamer1.x Plugins"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

MACHINE_GSTREAMER_1_0_EXTRA_INSTALL ?= ""
MACHINE_GSTREAMER_1_0_PLUGIN ?= ""

RDEPENDS_${PN} += " \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-base-meta \
    ${MACHINE_GSTREAMER_1_0_EXTRA_INSTALL} \
    ${MACHINE_GSTREAMER_1_0_PLUGIN} \
"
