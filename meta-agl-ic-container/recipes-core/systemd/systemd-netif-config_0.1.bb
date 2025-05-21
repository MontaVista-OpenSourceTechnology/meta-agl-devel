SUMMARY     = "Systemd network interface configuration"
DESCRIPTION = "Systemd network interface preset configurations \
              "
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://20-wired.network \
    file://20-can.network \
    file://21-usb.network \
    "

do_install() {
    install -D -m0644 ${WORKDIR}/20-wired.network ${D}${sysconfdir}/systemd/network/20-wired.network
    install -D -m0644 ${WORKDIR}/20-can.network ${D}${sysconfdir}/systemd/network/20-can.network
    install -D -m0644 ${WORKDIR}/21-usb.network ${D}${sysconfdir}/systemd/network/21-usb.network
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

ALLOW_EMPTY:${PN} = "1"

PACKAGE_BEFORE_PN += " \
    ${PN}-eth \
    ${PN}-can \
    ${PN}-usbeth \
"

FILES:${PN}-eth = " \
    ${sysconfdir}/systemd/network/20-wired.network \
"
FILES:${PN}-can = " \
    ${sysconfdir}/systemd/network/20-can.network \
"
FILES:${PN}-usbeth = " \
    ${sysconfdir}/systemd/network/21-usb.network \
"
FILES:${PN} = " \
    ${sysconfdir}/systemd/network/* \
"

RDEPENDS:${PN} = " \
    ${PN}-eth \
    ${PN}-can \
    ${PN}-usbeth \
"
