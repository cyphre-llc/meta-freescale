require recipes-kernel/linux/linux-qoriq.inc

SRC_URI = "git://git.freescale.com/ppc/sdk/linux.git;nobranch=1 \
    file://modify-defconfig-t1040-nr-cpus.patch \
    file://net-sctp-CVE-2014-0101.patch \
"

SRCREV = "f488de6741d5ba805b9fe813d2ddf32368d3a888"

SRC_URI_ls102xa = "git://sw-stash.freescale.net/scm/dnnpi/ls1-linux.git;branch=LS1-SDK-Rev2.0;protocol=http"
SRCREV_ls102xa = "aaa395f27e077f51c75c6aefc7bbec44732e9742"
