SUMMARY = "ss-romaccesslibrary for AGL software"
DESCRIPTION = "ss-romaccesslibrary to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=service/system;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/system/rom_access_library"

DEPENDS += " \
    ns-frameworkunified \
    ns-commonlibrary \
    ns-memorygpioaccesslibrary \
"
RDEPENDS_${PN} += " \
    ns-frameworkunified \
    ns-commonlibrary \
    ns-memorygpioaccesslibrary \
"

inherit agl-basesystem-common

EXTRA_MAKEFILE = " -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}"

FILES_${PN} += "${libdir}/*"
