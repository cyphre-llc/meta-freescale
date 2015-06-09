require fsl-image-core.bb

SUMMARY = "Large image to be used for development and evaluation"
DESCRIPTION = "Large image which includes all the tested tools and \
Freescale-specific packages. It is a full Linux system rather than \
an embedded system for development and evaluation tasks."

LICENSE = "MIT"

IMAGE_INSTALL_append = " \
    packagegroup-core-buildessential \
    packagegroup-core-eclipse-debug \
    packagegroup-core-full-cmdline \
    packagegroup-core-nfs-server \
    packagegroup-core-tools-debug \
    packagegroup-fsl-networking-extended \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-virtualization \
    packagegroup-fsl-devtools \
    packagegroup-fsl-benchmark-extended \
    packagegroup-fsl-tools-extended \
"

IMAGE_INSTALL_append_imx = " \
    packagegroup-fsl-graphics-minimal \
    packagegroup-fsl-graphics-core \
    packagegroup-fsl-graphics-tools \
    packagegroup-fsl-graphics-demos \
    packagegroup-fsl-graphics-benchmarks \
    packagegroup-fsl-multimedia-audio \
    packagegroup-fsl-multimedia-gstreamer1.0-core \
    packagegroup-fsl-multimedia-gstreamer1.0-testapps \
"
IMAGE_INSTALL_append_qoriq = ""



export IMAGE_BASENAME = "fsl-image-full"

