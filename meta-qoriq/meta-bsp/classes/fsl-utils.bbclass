rootfs_add_sdk_version () {
    if [ -n "${SDK_VERSION}" ]; then
        echo "${SDK_VERSION}" > ${IMAGE_ROOTFS}/etc/sdk-version
    fi
}

rootfs_delete_uImage() {
    find ${IMAGE_ROOTFS} -name uImage* | xargs rm -rf
}

rootfs_copy_minimal_image() {
    mkdir ${IMAGE_ROOTFS}/images
    cp ${DEPLOY_DIR_IMAGE}/fsl-image-minimal-${MACHINE}.ext2.gz ${IMAGE_ROOTFS}/images
}

