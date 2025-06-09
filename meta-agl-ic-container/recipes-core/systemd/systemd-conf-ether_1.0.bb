SUMMARY = "Systemd usb ether configuration"
DESCRIPTION = "The configuration file for systemd that enable to usb ether interface."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "\
    file://20-eth.network \
"

do_install() {
    # Install CAN bus network configuration
    install -d ${D}${nonarch_base_libdir}/systemd/network/
    install -m 0644 ${WORKDIR}/20-eth.network ${D}${nonarch_base_libdir}/systemd/network/20-eth.network
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} = " \
    ${nonarch_base_libdir}/systemd/network/ \
"
