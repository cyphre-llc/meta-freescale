FILESEXTRAPATHS_prepend := "${THISDIR}/gcc-linaro-4.9:"

SRC_URI_append = "\
    file://gcc-cse.c-set-src_volatile-for-all-non-volatile.patch \
"
