SUMMARY = "i.MX additions to the common recipe"
DESCRIPTION = "Additions specific to i.MX for graphics and multimedia."

LICENSE = "MIT"

IMAGE_INSTALL_append_imx = " \
    packagegroup-fsl-graphics-minimal \
    packagegroup-fsl-graphics-tools \
    packagegroup-fsl-graphics-demos \
    packagegroup-fsl-graphics-benchmarks \
    packagegroup-fsl-multimedia-audio \
    packagegroup-fsl-multimedia-gstreamer1.0-core \
    packagegroup-fsl-multimedia-gstreamer1.0-testapps \
"
