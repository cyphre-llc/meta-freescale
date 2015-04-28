DESCRIPTION = "A Linux-based utility supporting console multiplexing and demultiplexing"
LICENSE = "LGPL-2.1"
# TODO: add a dedicated COPYING file
LIC_FILES_CHKSUM = "file://mux_server.c;endline=9;md5=e59eeb0812bb88b7af2d932f2dc22aed"

SRC_URI = "http://git.freescale.com/source/mux-server-${PV}.tar.gz;name=mux_server"

SRC_URI[mux_server.md5sum] = "0f8650c65d1774563a8e4990ddb76f3e"
SRC_URI[mux_server.sha256sum] = "73409daf2f4821a5b7f292043ed6bb082a48dacd5d3b126184aed71f7d52a613"

EXTRA_OEMAKE='HOSTCC="${CC}"'

do_install () {
    install -d ${D}${bindir}
    install -m 755 mux_server ${D}${bindir}
}

BBCLASSEXTEND = "native nativesdk"

COMPATIBLE_MACHINE_qoriq = ".*"
