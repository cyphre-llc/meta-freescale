IMAGE_FEATURES_qoriq += "ssh-server-openssh"

IMAGE_INSTALL_qoriq += " \
    alsa-utils \
    can-utils \
    iproute2 \
    lmsensors-sensors \
    mtd-utils \
    nfs-utils \
    openssh-sftp-server \
    strongswan \
"

IMAGE_FSTYPES_qoriq = "ext2.gz.u-boot"
