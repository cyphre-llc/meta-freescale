require recipes-bsp/u-boot/u-boot.inc                                                                                            
inherit fsl-u-boot-localversion

DESCRIPTION = "U-boot provided by Freescale with focus on QorIQ boards"
HOMEPAGE = "http://u-boot.sf.net"
SECTION = "bootloaders"
PROVIDES = "virtual/bootloader u-boot"
LICENSE = "GPLv2 & BSD-3-Clause & BSD-2-Clause & LGPL-2.0 & LGPL-2.1"
LIC_FILES_CHKSUM = " \
    file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://Licenses/bsd-2-clause.txt;md5=6a31f076f5773aabd8ff86191ad6fdd5 \
    file://Licenses/bsd-3-clause.txt;md5=4a1190eac56a9db675d58ebe86eaf50c \
    file://Licenses/lgpl-2.0.txt;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
    file://Licenses/lgpl-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
"

PV_append = "+fslgit"
INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "libgcc virtual/${TARGET_PREFIX}gcc"
DEPENDS_append_qoriq-ppc = " boot-format-native"
DEPENDS_append_qoriq-arm = " change-file-endianess-native dtc-native tcl-native"

inherit deploy

SRC_URI = "git://git.freescale.com/ppc/sdk/u-boot.git;branch=sdk-v1.9.x"
SRCREV = "eb3d4fc5759729d7af71ac31ebf6a7e8d0e79da3"

python () {
    if d.getVar("TCMODE", True) == "external-fsl":
        return

    ml = d.getVar("MULTILIB_VARIANTS", True)
    arch = d.getVar("OVERRIDES", True)

    if "e5500-64b:" in arch or "e6500-64b:" in arch:
        if not "lib32" in ml:
            raise bb.parse.SkipPackage("Building the u-boot for this arch requires multilib to be enabled")
        sys_multilib = 'powerpc' + d.getVar('TARGET_VENDOR') + 'mllib32-' + d.getVar('HOST_OS')
        d.setVar('DEPENDS_append', ' lib32-gcc-cross-powerpc lib32-libgcc')
        d.setVar('PATH_append', ':' + d.getVar('STAGING_BINDIR_NATIVE') + '/' + sys_multilib)
        d.setVar('TOOLCHAIN_OPTIONS_append', '/../lib32-' + d.getVar("MACHINE"))
        d.setVar("WRAP_TARGET_PREFIX", sys_multilib + '-')
}

WRAP_TARGET_PREFIX ?= "${TARGET_PREFIX}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LOCALVERSION = "+SDKv${@d.getVar('SDK_VERSION', True).partition(' ')[0]}"

USRC ?= ""
S = '${@base_conditional("USRC", "", "${WORKDIR}/git", "${USRC}", d)}'

EXTRA_OEMAKE = 'CROSS_COMPILE=${WRAP_TARGET_PREFIX} CC="${WRAP_TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

do_compile_append_qoriq-ppc () {
    # some board's final nand/spi/sdcard binary was not named as u-boot.bin
    unset i j
    if [ "x${UBOOT_CONFIG}" != "x" ]; then
        for config in ${UBOOT_MACHINE}; do
            i=`expr $i + 1`;
            UBOOT_SOURCE=${UBOOT_BINARY}
            if echo ${config} |egrep -v "SECBOOT|SECURE" |egrep -qi "SDCARD|SPIFLASH|NAND"; then
                if echo ${config} |egrep -qi "NAND";then
                    if echo ${config} |egrep -qi "^(BSC|C29|P10|P2020RDB)";then
                        UBOOT_SOURCE=u-boot-with-spl.bin
                    elif echo ${config} |egrep -qi "^(B4|T1|T2|T4)";then
                        UBOOT_SOURCE=u-boot-with-spl-pbl.bin
                    elif echo ${config} |egrep -qi "^(P2041|P3|P4|P5)";then
                        UBOOT_SOURCE=u-boot.pbl
                    fi
                elif echo ${config} |egrep -qi "SPIFLASH";then
                    if echo ${config} |egrep -qi "^(P10|P2020RDB)";then
                        UBOOT_SOURCE=u-boot-with-spl.bin
                    elif echo ${config} |egrep -qi "^(T1|T2)";then
                        UBOOT_SOURCE=u-boot-with-spl-pbl.bin
                    elif echo ${config} |egrep -qi "^(B4|P2041|P3|P4|P5|T4)";then
                        UBOOT_SOURCE=u-boot.pbl
                    fi
                elif echo ${config} |egrep -qi "SDCARD";then
                    if echo ${config} |egrep -qi "^(P10|P2020RDB)";then
                        UBOOT_SOURCE=u-boot-with-spl.bin
                    elif echo ${config} |egrep -qi "^(B4|T1|T2|T4)";then
                        UBOOT_SOURCE=u-boot-with-spl-pbl.bin
                    elif echo ${config} |egrep -qi "^(P2041|P3|P4|P5)";then
                        UBOOT_SOURCE=u-boot.pbl
                    fi
                fi
                for type in ${UBOOT_CONFIG}; do
                    j=`expr $j + 1`;
                    if [ $j -eq $i ]; then
                        cp ${S}/${config}/${UBOOT_SOURCE} ${S}/${config}/u-boot-${type}.${UBOOT_SUFFIX}
                        # use boot-format to regenerate spi image if BOOTFORMAT_CONFIG is not empty
                        if echo ${config} |egrep -qi "SPIFLASH" && [ -n "${BOOTFORMAT_CONFIG}" ];then
                            ${STAGING_BINDIR_NATIVE}/boot_format \
                            ${STAGING_DATADIR_NATIVE}/boot_format/${BOOTFORMAT_CONFIG} \
                            ${S}/${config}/${UBOOT_SOURCE} -spi ${S}/${config}/u-boot-${type}.${UBOOT_SUFFIX}
                        fi
                    fi
                done
                unset  j
            fi
        done
        unset i
    fi
}

do_compile_append_qoriq-arm () {
    unset i j
    if [ "x${UBOOT_CONFIG}" != "x" ]; then
        for config in ${UBOOT_MACHINE}; do
            i=`expr $i + 1`;
            for type in ${UBOOT_CONFIG}; do
                j=`expr $j + 1`;
                if [ $j -eq $i ]; then
                    case "${config}" in
                        *nand* | *sdcard*)
                            cp ${config}/u-boot-with-spl-pbl.bin ${config}/u-boot-${type}.${UBOOT_SUFFIX};;
                        *spi*) 
                            tclsh ${STAGING_BINDIR_NATIVE}/byte_swap.tcl ${config}/u-boot-dtb.bin ${config}/u-boot.swap.bin 8
                            cp ${config}/u-boot.swap.bin ${config}/u-boot-${type}.${UBOOT_SUFFIX};;
                    esac
                fi
            done
            unset j
        done
        unset i
    fi
}

do_install_append_qoriq (){
    unset i j
    if [ "x${UBOOT_CONFIG}" != "x" ]; then
        for config in ${UBOOT_MACHINE}; do
            i=`expr $i + 1`;
            for type in ${UBOOT_CONFIG}; do
                j=`expr $j + 1`;
                if [ $j -eq $i ]; then
                    ln -sfT u-boot-${type}-${PV}-${PR}.${UBOOT_SUFFIX} ${D}/boot/u-boot-${type}.${UBOOT_SUFFIX}
                fi
            done
            unset  j
        done
        unset i
    fi
}

do_deploy_append_qoriq (){
    unset i j
    if [ "x${UBOOT_CONFIG}" != "x" ]; then
        for config in ${UBOOT_MACHINE}; do
            i=`expr $i + 1`;
            for type in ${UBOOT_CONFIG}; do
                j=`expr $j + 1`;
                if [ $j -eq $i ]; then
                    ln -sfT u-boot-${type}-${PV}-${PR}.${UBOOT_SUFFIX} ${DEPLOYDIR}/u-boot-${type}.${UBOOT_SUFFIX}
                fi
            done
            unset  j
        done
        unset i
    fi
}
addtask deploy after do_install

PACKAGES += "${PN}-images"
FILES_${PN}-images += "/boot"
COMPATIBLE_MACHINE = "(qoriq)"
