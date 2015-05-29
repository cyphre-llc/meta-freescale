# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Freescale Package group for web system monitor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES = "${PN}"

FSL_WEBSERVER = "lighttpd lighttpd-module-cgi"

RDEPENDS_${PN} = "\
    packagegroup-core-x11-base \
    lmsensors-sensors \
    cairo \
    cairo-dev \
    rrdtool \
    web-sysmon \
"

RDEPENDS_${PN}_remove_ls102xa = "\
    web-sysmon \
"
