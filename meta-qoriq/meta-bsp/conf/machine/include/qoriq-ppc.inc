require conf/machine/include/qoriq.inc

# The default version
PREFERRED_VERSION_ptpd = "2.3.1-rc2"
PREFERRED_VERSION_valgrind_e500v2 = "3.8.1+fsl"

SERIAL_CONSOLES ?= "115200;ttyS0 115200;ttyS1 115200;ttyEHV0"
SERIAL_CONSOLES_CHECK ?= "${SERIAL_CONSOLES}"

MACHINEOVERRIDES .= ":qoriq-ppc"
