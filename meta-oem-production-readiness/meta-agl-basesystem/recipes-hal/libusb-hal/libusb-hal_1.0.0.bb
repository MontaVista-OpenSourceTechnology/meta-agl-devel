SUMMARY = "libusb_hal for AGL software"
DESCRIPTION = "install libusb_hal to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " ns-frameworkunified"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/hal/usb_hal"

inherit bshalmake

HAL_NAME = "usb_hal"
FILES_${PN} += "${libdir}/lib${HAL_NAME}.so"
