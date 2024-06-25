FILESEXTRAPATHS:prepend := "${THISDIR}/flutter-gallery:"

# Override SRC_URI to handle branch rename to "main"
SRC_URI = "git://github.com/flutter/gallery.git;lfs=0;branch=main;protocol=https;destsuffix=git"

# Add our desired systemd unit
SRC_URI += "file://flutter-gallery.service"

inherit systemd

do_install:append() {
    install -D -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}/${BPN}.service
}

RDEPENDS:${PN} += "agl-flutter-env"

SYSTEMD_SERVICE:${PN} = "flutter-gallery.service"
