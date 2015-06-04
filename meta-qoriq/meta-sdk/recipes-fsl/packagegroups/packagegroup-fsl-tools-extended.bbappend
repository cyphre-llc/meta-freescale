
MACHINE_SPECIFIC ?= ""
MACHINE_SPECIFIC_p1022ds = " packagegroup-fsl-graphics-minimal"
MACHINE_SPECIFIC_t1042rdb-pi = " packagegroup-fsl-graphics-minimal"
MACHINE_SPECIFIC_t1042rdb-pi-64b = " packagegroup-fsl-graphics-minimal"

RDEPENDS_${PN}_append_qoriq = "\
    kernel-devicetree \
    kernel-image \
    packagegroup-fsl-monitor \
    ${@multilib_pkg_extend(d, "binutils")} \
    ${@multilib_pkg_extend(d, "cpp")} \
    ${@multilib_pkg_extend(d, "glibc-dev")} \
    ${@multilib_pkg_extend(d, "glibc-utils")} \
    ${@multilib_pkg_extend(d, "g++")} \
    ${@multilib_pkg_extend(d, "gcc")} \
    ${@multilib_pkg_extend(d, "gcov")} \
    ${@multilib_pkg_extend(d, "ldd")} \
    ${@multilib_pkg_extend(d, "libgcc")} \
    ${@multilib_pkg_extend(d, "libgcc-dev")} \
    ${@multilib_pkg_extend(d, "valgrind")} \
    ${MACHINE_SPECIFIC} \
"

