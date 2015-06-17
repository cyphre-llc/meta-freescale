# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION_imx = "Freescale Package group for GStreamer1.x plugins specific to i.MX."

# i.MX specific Plugins

# Open source plugins specific to i.MX
IMX_GSTREAMER_1_0_EXTRA_INSTALL = " \
                                    gstreamer1.0-plugins-bad-meta \
                                    gstreamer1.0-rtsp-server \
"

MACHINE_GSTREAMER_1_0_EXTRA_INSTALL_mx6 = "${IMX_GSTREAMER_1_0_EXTRA_INSTALL}"
MACHINE_GSTREAMER_1_0_EXTRA_INSTALL_mx7 = "${IMX_GSTREAMER_1_0_EXTRA_INSTALL}"
