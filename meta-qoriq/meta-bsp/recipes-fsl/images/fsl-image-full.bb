# copy the manifest and the license text for each package to image
COPY_LIC_MANIFEST = "1"
COPY_LIC_DIRS = "1"

include fsl-image-core.bb

CORE_SPECIFIC = " \
    fm-ucode-image \
    rcw-image \
    hypervisor-image \
    hv-cfg-image \
"
CORE_SPECIFIC_e500v2 = ""
CORE_SPECIFIC_e6500 = " fm-ucode-image"
CORE_SPECIFIC_e6500-64b = " fm-ucode-image"
CORE_SPECIFIC_remove_t1042rdb-pi = "hv-cfg-image"
CORE_SPECIFIC_remove_t1042rdb-pi-64b = "hv-cfg-image"
CORE_SPECIFIC_ls102xa = ""
CORE_SPECIFIC_remove_t1024rdb = "hv-cfg-image"
CORE_SPECIFIC_remove_t1024rdb-64b = "hv-cfg-image"
CORE_SPECIFIC_remove_t1024qds = "hv-cfg-image"
CORE_SPECIFIC_remove_t1024qds-64b = "hv-cfg-image"

MACHINE_SPECIFIC = ""
MACHINE_SPECIFIC_b4420qds = " rcw-image"
MACHINE_SPECIFIC_b4420qds-64b = " rcw-image"
MACHINE_SPECIFIC_b4860qds = " rcw-image"
MACHINE_SPECIFIC_b4860qds-64b = " rcw-image"
MACHINE_SPECIFIC_p1022ds = " packagegroup-fsl-x11"
MACHINE_SPECIFIC_p1023rdb = " fm-ucode-image"
MACHINE_SPECIFIC_t1042rdb-pi = " packagegroup-fsl-x11"
MACHINE_SPECIFIC_t1042rdb-pi-64b = " packagegroup-fsl-x11"
MACHINE_SPECIFIC_t4240qds = " rcw-image"
MACHINE_SPECIFIC_t4240qds-64b = " rcw-image"

SOC_SPECIFIC = ""
SOC_SPECIFIC_ls102xa = " \
    rcw-image \
"

IMAGE_INSTALL += " \
    kernel-devicetree \
    kernel-image \
    packagegroup-core-buildessential \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-core-nfs-server \
    packagegroup-core-tools-debug \
    packagegroup-fsl-core \
    packagegroup-fsl-extend \
    packagegroup-fsl-monitor \
    u-boot-qoriq-images \
    ${@multilib_pkg_extend(d, "binutils")} \
    ${@multilib_pkg_extend(d, "cpp")} \
    ${@multilib_pkg_extend(d, "glibc-dev")} \
    ${@multilib_pkg_extend(d, "glibc-utils")} \
    ${@multilib_pkg_extend(d, "g++")} \
    ${@multilib_pkg_extend(d, "gcc")} \
    ${@multilib_pkg_extend(d, "gcov")} \
    ${@multilib_pkg_extend(d, "libgcov-dev")} \
    ${@multilib_pkg_extend(d, "ldd")} \
    ${@multilib_pkg_extend(d, "libgcc")} \
    ${@multilib_pkg_extend(d, "libgcc-dev")} \
    ${@multilib_pkg_extend(d, "valgrind")} \
    ${CORE_SPECIFIC} \
    ${MACHINE_SPECIFIC} \
    ${SOC_SPECIFIC} \
"

IMAGE_INSTALL_remove_ls102xa = " \
     u-boot-qoriq-images \
"

IMAGE_FSTYPES = "tar.gz"
