# Copyright (C) 2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION_imx = "Freescale Package group for mutlimedia audio specific to i.MX."

# i.MX specific Plugins
MACHINE_ALSA_PACKAGES_mx6 = "${@base_contains('DISTRO_FEATURES', 'alsa', 'fsl-alsa-plugins', '', d)}"
MACHINE_ALSA_PACKAGES_mx7 = "${@base_contains('DISTRO_FEATURES', 'alsa', 'fsl-alsa-plugins', '', d)}"
