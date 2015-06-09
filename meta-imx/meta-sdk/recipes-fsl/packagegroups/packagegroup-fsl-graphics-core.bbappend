# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SOC_TOOLS_GPU = ""
SOC_TOOLS_GPU_mx5 = " \
    ${@base_contains('DISTRO_FEATURES', 'x11', 'amd-gpu-x11-bin-mx51', 'amd-gpu-bin-mx51', d)} \
"
SOC_TOOLS_GPU_mx6 = " \
    imx-gpu-viv-g2d \
    imx-gpu-viv-tools \
    imx-gpu-viv-tools-apitrace \
    ${@base_contains('DISTRO_FEATURES', 'x11', \
                     'xserver-xorg-extension-viv-autohdmi', '', d)} \
"

# i.MX6 SoloLite do not support apitrace because of its dependency on gles2.

SOC_TOOLS_GPU_remove_mx6sl = " \
    imx-gpu-viv-tools-apitrace \
"
DFB_TOOLS_INSTALL = ""
DFB_TOOLS_INSTALL_mx6 = "${@base_contains('DISTRO_FEATURES', 'directfb', \
    'libvivante-dfb-mx6', '', d)}"

RDEPENDS_${PN}_append = " \
    ${SOC_TOOLS_GPU} \
    ${DFB_TOOLS_INSTALL} \
"
