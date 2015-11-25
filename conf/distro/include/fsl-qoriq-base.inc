# Freescale QorIQ Distro default versions
PREFERRED_VERSION_qemu = "2.2.0+fsl"
PREFERRED_VERSION_make = "3.81"
PREFERRED_VERSION_ptpd = "2.3.1-rc2"
PREFERRED_VERSION_valgrind_e500v2 = "3.8.1+fsl"
PREFERRED_VERSION_openssl_qoriq-ppc = "1.0.1i"
PREFERRED_VERSION_hostapd = "2.4"

# When meta-openenbedded layer included, bitbake will complain that
# multiple providers are available for jpeg (jpeg, libjpeg-turbo)
PREFERRED_PROVIDER_jpeg ?= "jpeg"
PREFERRED_PROVIDER_jpeg-native ?= "jpeg-native"

QEMU_TARGETS_append_pn-qemu-native = " ppc64"
PREFERRED_PROVIDER_virtual/java-initial-native = "cacao-initial-native"
PREFERRED_PROVIDER_virtual/java-native = "jamvm-native"
PREFERRED_PROVIDER_virtual/javac-native = "ecj-bootstrap-native"
PREFERRED_VERSION_openjdk-6-jre = "6b27-1.12.8"
PREFERRED_VERSION_icedtea6-native = "1.8.11"
PREFERRED_VERSION_openjdk-7-jre = "25b30-2.3.12"
PREFERRED_VERSION_icedtea7-native = "2.1.3"
PREFERRED_PROVIDER_openjdk-6-jre = "openjdk-6-jre"
