require conf/machine/include/qoriq.inc

MACHINE_EXTRA_RRECOMMENDS += "udev-rules-qoriq"

SERIAL_CONSOLES ?= "115200;ttyS0 115200;ttyS1 115200;ttyEHV0"
SERIAL_CONSOLES_CHECK ?= "${SERIAL_CONSOLES}"

MACHINEOVERRIDES .= ":qoriq-ppc"
