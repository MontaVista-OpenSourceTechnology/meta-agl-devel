SUMMARY = "Unified AGL HMI Package Groups"
LICENSE = "Apache-2.0"

inherit packagegroup

RDEPENDS:${PN} += " \
    ucl-tools \
    ula-tools \
    uhmi-agl-wm \
    agl-compositor \
"
