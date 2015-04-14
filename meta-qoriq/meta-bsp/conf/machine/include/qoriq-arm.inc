require conf/machine/include/soc-family.inc

# Freescale BSP default providers
PREFERRED_PROVIDER_u-boot ?= "u-boot-qoriq"
PREFERRED_PROVIDER_virtual/bootloader ?= "u-boot-qoriq"
PREFERRED_PROVIDER_virtual/kernel ?= "linux-qoriq"
PREFERRED_PROVIDER_eglibc ?= "eglibc"

# Define the default image type
IMAGE_CLASSES ?= "image_types_uboot"
KERNEL_IMAGETYPE ?= "uImage"

UBOOT_ENTRYPOINT = "0x80008000"

MACHINE_FEATURES = "pci ext2 ext3 serial"
MACHINE_EXTRA_RRECOMMENDS = "udev-extraconf"

DEFAULTTUNE = "cortexa7hf-neon"

SERIAL_CONSOLES ?= "115200;ttyS0 115200;ttyS1 115200;ttyEHV0 115200;ttyLP0 115200;ttyAMA0"
SERIAL_CONSOLES_CHECK ?= "${SERIAL_CONSOLES}"
USE_VT ?= "0"

MKUBIFS_ARGS ??= "-m 512 -e 15360 -c 3600"
UBINIZE_ARGS ??= "-m 512 -p 16KiB -s 512"

