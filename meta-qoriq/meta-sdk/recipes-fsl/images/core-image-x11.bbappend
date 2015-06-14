IMAGE_FEATURES += "ssh-server-openssh"

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
