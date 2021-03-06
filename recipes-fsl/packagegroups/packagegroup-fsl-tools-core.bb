# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Freescale Package group for core tools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS_${PN} = " \
    e2fsprogs \
    e2fsprogs-badblocks \
    e2fsprogs-e2fsck \
    e2fsprogs-tune2fs  \
    i2c-tools \
    kmod \
    libhugetlbfs \
    lmsensors-sensors \
    memtester \
    pkgconfig \
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

DPAA_PKGS = " \
    eth-config \
    fmc \
    qoriq-debug \
    usdpaa \
    hypervisor-partman \
"
DPAA_PKGS_e500v2 = ""
DPAA_PKGS_ls102xa = ""
DPAA_PKGS_remove_e6500 = "hypervisor-partman"
DPAA_PKGS_append_e6500 = " lib64-hypervisor-partman"

IPC_PKGS_qoriq = " \
    ipc-modules-multi \
    ipc-modules-single \
    ipc-ust \
"

RDEPENDS_${PN}_append_qoriq = "\
    apptrk \
    asf \
    merge-files \
    ${DPAA_PKGS} \
"
RDEPENDS_${PN}_remove_ls102xa ="apptrk"
RDEPENDS_${PN}_append_e500v2 = " testfloat"
RDEPENDS_${PN}_append_e6500-64b = " ceetm"
RDEPENDS_${PN}_append_c293pcie = " pkc-firmware skmm-ep"
RDEPENDS_${PN}_append_p1023rdb = " fmc eth-config"
RDEPENDS_${PN}_append_b4860qds = "${IPC_PKGS}"
RDEPENDS_${PN}_append_b4420qds = "${IPC_PKGS}"

# NOTE: Remove the conditional pkc-host inclusion and all traces of c29x_pkc
# DISTRO_FEATURE if pkc-host no longer requires customized cryptodev patches
RDEPENDS_${PN}_append_p4080ds = " \
    ${@base_contains('DISTRO_FEATURES', 'c29x_pkc', 'pkc-host', '', d)} \
    skmm-ep \
    skmm-host \
"

RDEPENDS_${PN}_append_t1040rdb = " \
    ar \
    ceetm \
    uio-seville \
"

RDEPENDS_${PN}_append_t1040rdb-64b = " \
    ar \
    ceetm \
    uio-seville \
"

RDEPENDS_${PN}_append_t1042rdb = " \
    ar \
    ceetm \
    uio-seville \
"

RDEPENDS_${PN}_append_t1042rdb-64b = " \
    ar \
    ceetm \
    uio-seville \
"

RDEPENDS_${PN}_append_t1042rdb-pi = " \
    ar \
"
RDEPENDS_${PN}_append_t1042rdb-pi-64b = " \
    ar \
"

RDEPENDS_${PN}_append_t4240qds = " \
    ${@base_contains('DISTRO_FEATURES', 'c29x_pkc', 'pkc-host', '', d)} \
    skmm-ep \
    skmm-host \
"
