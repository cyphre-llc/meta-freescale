SUMMARY = "fsl x11 pkgs"
LICENSE = "MIT"

inherit packagegroup

XSERVER ?= ""

RDEPENDS_packagegroup-fsl-x11 = "\
    twm \
    ${XSERVER} \
    x11-common \
    xclock \
    xterm \
"

