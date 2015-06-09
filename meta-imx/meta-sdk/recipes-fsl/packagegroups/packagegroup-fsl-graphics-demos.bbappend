# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

RDEPENDS_${PN}_append_mx6 = " imx-gpu-viv-demos fsl-gpu-sdk"

# FIXME: fsl-gpu-sdk is not supported for i.MX6 SoloLite due to lack of
# OpenVG support and is intended to add in future release. 

RDEPENDS_${PN}_remove_mx6sl = " \
    clutter-1.0-examples \
    fsl-gpu-sdk \
    "
