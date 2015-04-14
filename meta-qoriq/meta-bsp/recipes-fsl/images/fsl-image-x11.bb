DESCRIPTION = "freescale image with a very basic X11 image with a terminal"

inherit core-image distro_features_check

include fsl-image-minimal.bb

IMAGE_FEATURES += "splash x11-base ssh-server-openssh"

IMAGE_INSTALL += " \
    alsa-utils \
    can-utils \
    iproute2 \
    lmsensors-sensors \
    mtd-utils \
    nfs-utils \
    openssh-sftp-server \
    strongswan \
"

IMAGE_FSTYPES = "ext2.gz.u-boot"

REQUIRED_DISTRO_FEATURES = "x11"

