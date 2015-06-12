SUMMARY = "i.MX additions to the common core recipe"
DESCRIPTION = "Additions specific to i.MX for graphics and multimedia."

LICENSE = "MIT"

IMAGE_INSTALL_append_imx = " \
    packagegroup-fsl-graphics-core \
"
