# Copyright (C) 2015 Freescale Semiconductor

require fsl-image-minimal.bb

SUMMARY = "Small image to be used for Manufacturing"
DESCRIPTION = "Small image which only include essetional Manufacturing \
packages to deploy other big images to large physical media, such as \
usb stick, hard drive."

LICENSE = "MIT"

IMAGE_INSTALL_append = " \
    packagegroup-core-ssh-dropbear \
    packagegroup-fsl-mfgtools \
"

export IMAGE_BASENAME = "fsl-image-mfgtool"
