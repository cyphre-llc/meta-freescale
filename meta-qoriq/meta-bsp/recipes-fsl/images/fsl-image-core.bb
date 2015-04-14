include fsl-image-flash.bb
include fsl-image.inc

# common opensource packages
IMAGE_INSTALL += " \
    packagegroup-fsl-core \
"

ROOTFS_POSTPROCESS_COMMAND += "rootfs_delete_uImage; "
