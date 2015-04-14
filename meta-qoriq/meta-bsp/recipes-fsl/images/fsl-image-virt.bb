# Copyright (C) 2012-2015 Freescale Semiconductor Inc.

include fsl-image-minimal.bb

# pkgconfig is here for qemu, and it's not in DEPENDS because of multilib 
# build issues. to fix later
IMAGE_INSTALL += " \
    packagegroup-fsl-core \
    kernel-image \
    libhugetlbfs \
    libvirt \
    libvirt-libvirtd \
    libvirt-virsh \
    lxc \
    pkgconfig \
    qemu \
"

IMAGE_FSTYPES = "tar.gz ext2.gz.u-boot"

# copy minimal rootfs image into kvm rootfs
ROOTFS_POSTPROCESS_COMMAND += "rootfs_copy_minimal_image;"

do_rootfs[depends] += "fsl-image-minimal:do_rootfs"
