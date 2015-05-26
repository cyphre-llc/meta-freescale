# Copyright 2015 Freescale Semiconductor, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Package group for tools commonly desired for an image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


inherit packagegroup

RDEPENDS_${PN} = " \
    dosfstools \
    i2c-tools \
    memtester \
    python-subprocess \
    python-datetime \
    python-json \
    procps \
    minicom \
    coreutils \
    elfutils \
    file \
    psmisc \
    sysfsutils \
    sysklogd \
    sysstat \
"
