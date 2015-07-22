require conf/distro/poky.conf

# This is the default distro configuration.

# Comment out the 2 lines below to use bluez4.
DISTRO_FEATURES_append_mx6 = " bluez5"
DISTRO_FEATURES_append_mx7 = " bluez5"

# Preferred Providers
PREFERRED_PROVIDER_u-boot_mx5 = "u-boot-fslc"
PREFERRED_PROVIDER_u-boot_mx6 = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx7 = "u-boot-imx"

PREFERRED_PROVIDER_virtual/kernel_mx6 = "linux-imx"

# Preferred Versions
PREFERRED_VERSION_directfb-examples_mx6 = "1.7.0"

PREFERRED_VERSION_linux-imx_mx6 = "3.14.28"
PREFERRED_VERSION_mfgtool-linux-imx_mx6 = "3.14.28"
PREFERRED_VERSION_u-boot-imx_mx6 = "2014.04"
PREFERRED_VERSION_u-boot-imx-mfgtool_mx6 = "2014.04"

MACHINE_GSTREAMER_1_0_PLUGIN_mx6 = "gst1.0-fsl-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6q = "gst1.0-fsl-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6dl = "gst1.0-fsl-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6sl = "gst1.0-fsl-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6sx = "gst1.0-fsl-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx7 = "gst1.0-fsl-plugin"

SANITY_TESTED_DISTROS += " \
    Ubuntu-12.04 \n \
"
