SUMMARY = "ss-resourcemanager for AGL software"
DESCRIPTION = "ss-resourcemanager to build AGL software"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/${MAKE_DIR}/LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

inherit agl-basesystem-common
FILES_${PN} += " \
    /usr/agl/lib/* \
"
FILES_${PN}-dev += "/usr/agl/include/*"
 
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;subpath=systemservice/;branch=master"
SRCREV = "${AUTOREV}"

PV = "1.0.0+gitr${SRCPV}"
S = "${WORKDIR}/git"

# Common Dependencies
DEPENDS += " \
    os-rpclibrary-tool-native \
    ss-interfaceunified \
    ns-frameworkunified \
    ns-commonlibrary \
    os-rpclibrary \
    os-eventlibrary \
    libsoctemperature-hal \
"
RDEPENDS_${PN} += " \
    ns-frameworkunified \
    ss-interfaceunified \
    ns-commonlibrary \
    ns-frameworkunified \
    os-rpclibrary \
    os-eventlibrary \
    libsoctemperature-hal \
"

EXTRA_MAKEFILE=" -f Makefile.client"
EXTRA_OEMAKE += "${EXTRA_MAKEFILE}  -j 1 'CXX=${CXX} -Wl,--warn-unresolved-symbols' 'CC=${CC} -Wl,--warn-unresolved-symbols'"
MAKE_DIR ="resource_manager"

