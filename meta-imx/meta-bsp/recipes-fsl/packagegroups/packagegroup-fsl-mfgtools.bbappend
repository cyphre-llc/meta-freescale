
# Copyright 2015 Freescale Semiconductor, Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale Package group for common tools specific to i.MX."

RDEPENDS_${PN}_append_imx = " \
    coreutils \
    mmc-utils \
    fsl-rc-local \
"
