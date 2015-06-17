# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION_imx = "Freescale Package group for GStreamer1.x test applications specific to i.MX."

IMX_GSTREAMER_1_0_TESTAPPS = " ${@base_contains("MACHINE_GSTREAMER_1_0_PLUGIN", "gst1.0-fsl-plugin", "gst1.0-fsl-plugin-gplay", "", d)} \
"

MACHINE_GSTREAMER_1_0_TESTAPPS_mx6 = "${IMX_GSTREAMER_1_0_TESTAPPS}"
MACHINE_GSTREAMER_1_0_TESTAPPS_mx7 = "${IMX_GSTREAMER_1_0_TESTAPPS}"
