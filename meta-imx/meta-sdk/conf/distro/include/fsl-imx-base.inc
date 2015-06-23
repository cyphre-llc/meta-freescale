require conf/distro/poky.conf

# This is the default distro configuration.

# for now use bluez4 as default
# Comment out the 2 lines below to use bluez4.
#DISTRO_FEATURES_append_mx6 = " bluez5"
#DISTRO_FEATURES_append_mx7 = " bluez5"

# Preferred Providers
PREFERRED_PROVIDER_u-boot_mx5 = "u-boot-fslc"
PREFERRED_PROVIDER_u-boot_mx6 = "u-boot-imx"

PREFERRED_PROVIDER_virtual/kernel_mx6 = "linux-imx"

PREFERRED_PROVIDER_virtual/libgl_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgl_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgl_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgl_mx6sl= "mesa"

PREFERRED_PROVIDER_virtual/libgles1_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles2_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles2_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles2_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libgles1_mx6sl = "mesa"
PREFERRED_PROVIDER_virtual/libgles2_mx6sl = "mesa"

PREFERRED_PROVIDER_virtual/egl_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/egl_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/egl_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/egl_mx6sl = "imx-gpu-viv"

PREFERRED_PROVIDER_virtual/libgal-x11_mx6 = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libopenvg_mx6q = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libopenvg_mx6dl = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libopenvg_mx6sx = "imx-gpu-viv"
PREFERRED_PROVIDER_virtual/libopenvg_mx6sl = "imx-gpu-viv"

PREFERRED_PROVIDER_virtual/libg2d_mx6 = "imx-gpu-viv"

# Preferred Versions

FP_TAG = "${@base_contains("TUNE_FEATURES", "callconvention-hard", "-hfp", "-sfp", d)}"

PREFERRED_VERSION_imx-gpu-viv = "5.0.11.p4.4${FP_TAG}"
PREFERRED_VERSION_xf86-video-imxfb-vivante = "5.0.11.p4.4"

PREFERRED_VERSION_fsl-gpu-sdk_mx6 = "2.0"

PREFERRED_VERSION_imx-gpu-viv-kernel = "5.0.11.p4.4"

# set following because of override in meta-fsl-arm
PREFERRED_VERSION_directfb_mx6q = "1.7.4"
PREFERRED_VERSION_directfb_mx6dl = "1.7.4"
PREFERRED_VERSION_directfb_mx6sl = "1.7.4"
PREFERRED_VERSION_directfb_mx6sx = "1.7.4"

PREFERRED_VERSION_directfb-examples_mx6 = "1.7.0"
PREFERRED_VERSION_directfb-examples_mx6q = "1.7.0"
PREFERRED_VERSION_directfb-examples_mx6dl = "1.7.0"
PREFERRED_VERSION_directfb-examples_mx6s = "1.7.0"
PREFERRED_VERSION_directfb-examples_mx6sl = "1.7.0"
PREFERRED_VERSION_directfb-examples_mx6sx = "1.7.0"

# Use Wayland new version
PREFERRED_VERSION_wayland_mx6 = "1.6.0"
PREFERRED_VERSION_weston_mx6 = "1.6.0"
PREFERRED_VERSION_wayland-native = "1.6.0"

PREFERRED_VERSION_imx-lib_mx6 = "3.10.53-1.1.0"
PREFERRED_VERSION_imx-test = "3.14.28-1.0.0"
PREFERRED_VERSION_imx-vpu_mx6 = "5.4.28"
PREFERRED_VERSION_linux-imx_mx6 = "3.14.28"
PREFERRED_VERSION_mfgtool-linux-imx_mx6 = "3.14.28"
PREFERRED_VERSION_u-boot-imx_mx6 = "2014.04"
PREFERRED_VERSION_u-boot-imx-mfgtool_mx6 = "2014.04"
PREFERRED_VERSION_imx-uuc_mx6 = "0.5"

PREFERRED_VERSION_gst-fsl-plugin = "4.0.3"
PREFERRED_VERSION_libfslcodec = "4.0.3"
PREFERRED_VERSION_libfslparser = "4.0.3"
PREFERRED_VERSION_libfslvpuwrap = "1.0.58"

PREFERRED_VERSION_gst1.0-fsl-plugin = "4.0.3"

PREFERRED_VERSION_fsl-alsa-plugins = "1.0.25"
PREFERRED_VERSION_gst-plugins-gl = "0.10.3"

PREFERRED_VERSION_imx-kobs_mx6 = "3.14.28-1.0.0"
PREFERRED_VERSION_firmware-imx_mx6 = "3.14.28-1.0.0"
PREFERRED_VERSION_firmware-imx_mx5 = "3.14.28-1.0.0"

PREFERRED_VERSION_imx-lib_mx5 = "11.09.02"
PREFERRED_VERSION_imx-vpu_mx5 = "11.09.02"
