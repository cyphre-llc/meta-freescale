require conf/machine/include/soc-family.inc

# The default provider
PREFERRED_PROVIDER_u-boot ?= "u-boot-qoriq"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-qoriq"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-qoriq"

# The default version 
PREFERRED_VERSION_ptpd = "2.3.0"
PREFERRED_VERSION_valgrind_e500v2 = "3.8.1+fsl"

# The default setting 
MACHINE_FEATURES = "keyboard pci ext2 ext3 serial"
MACHINE_EXTRA_RRECOMMENDS += "udev-extraconf kernel-modules"

IMAGE_CLASSES ?= "image_types_uboot"
KERNEL_IMAGETYPE ?= "uImage"

SERIAL_CONSOLES ?= "115200;ttyS0 115200;ttyS1 115200;ttyEHV0"
SERIAL_CONSOLES_CHECK ?= "${SERIAL_CONSOLES}"

USE_VT = "0"

MACHINEOVERRIDES .= ":qoriq-ppc"

MKUBIFS_ARGS ??= "-m 512 -e 15360 -c 3600"
UBINIZE_ARGS ??= "-m 512 -p 16KiB -s 512"
