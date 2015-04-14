inherit core-image fsl-utils

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    udev-extraconf \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
"
IMAGE_LINGUAS = ""

include fsl-image-deploy.inc

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FSTYPES = "tar.gz ext2.gz.u-boot jffs2 ubi"

ROOTFS_POSTPROCESS_COMMAND += "rootfs_add_sdk_version;"

