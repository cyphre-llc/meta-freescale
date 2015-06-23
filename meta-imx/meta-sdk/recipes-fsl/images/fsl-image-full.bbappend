SUMMARY = "i.MX additions to the common recipe"
DESCRIPTION = "Additions specific to i.MX for graphics and multimedia."

LICENSE = "MIT"

IMAGE_FEATURES += " splash"
IMAGE_FEATURES += "${@base_contains('DISTRO_FEATURES', 'x11', \
                            ' package-management x11-base x11-sato hwcodecs', '', d)}"
IMAGE_FEATURES += "${@base_contains('DISTRO_FEATURES', 'wayland', \
                            base_contains('DISTRO_FEATURES', 'x11', '', ' package-management hwcodecs', d), \
                            '', d)}"
 
X11_EXTRA_IMAGE_FEATURES ?= "${@base_contains('DISTRO_FEATURES', 'x11', \
    ' tools-testapps', '', d)}"

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${X11_EXTRA_IMAGE_FEATURES} \
    nfs-server \
    tools-debug \
    tools-profile \
    ssh-server-dropbear \
    "

IMAGE_INSTALL_append_imx = " \
    packagegroup-fsl-graphics-minimal \
    packagegroup-fsl-graphics-tools \
    packagegroup-fsl-graphics-demos \
    packagegroup-fsl-graphics-benchmarks \
    packagegroup-fsl-multimedia-audio \
    packagegroup-fsl-multimedia-gstreamer1.0-core \
    packagegroup-fsl-multimedia-gstreamer1.0-testapps \
"

