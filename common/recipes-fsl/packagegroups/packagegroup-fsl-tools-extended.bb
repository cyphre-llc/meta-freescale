# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Freescale Package group for extended tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
    bc \
    chkconfig \
    cronie \
    db \
    debianutils \
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
    rt-tests \
    sqlite3 \
    strongswan \
    texinfo \
    unzip \
    usbutils \
    usbutils-ids \
    util-linux \
    watchdog \
    which \
    xz  \
    zip \
"