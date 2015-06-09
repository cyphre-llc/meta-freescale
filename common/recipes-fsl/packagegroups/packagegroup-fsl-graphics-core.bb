# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by freescale to add packages which provides core graphics support"
SUMMARY = "Freescale Package group for core graphics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Direct FB packages
DFB_PACKAGES = "${@base_contains('DISTRO_FEATURES', 'directfb', \
    'packagegroup-core-full-cmdline packagegroup-core-directfb', '', d)}"

# Wayland packages

WAYLAND_PACKAGES = "${@base_contains('DISTRO_FEATURES', 'x11', '', \
       base_contains('DISTRO_FEATURES', 'wayland','weston weston-init', '', d),d)}"

# X11 packages
X11_PACKAGES = "${@base_contains('DISTRO_FEATURES', 'x11', \
   'mesa xorg-minimal-fonts', '', d)}"

RDEPENDS_${PN} = " \
    ${DFB_PACKAGES} \
    ${WAYLAND_PACKAGES} \
    ${X11_PACKAGES} \
"
