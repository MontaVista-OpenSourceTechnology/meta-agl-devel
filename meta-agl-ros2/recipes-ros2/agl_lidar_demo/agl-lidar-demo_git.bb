SUMMARY = "AGL LiDAR Demo (Flutter)"
DESCRIPTION = "Top-down LiDAR / camera / perception dashboard over rosbridge. \
Ships a recorded clip (LiDAR + detections + two compressed cameras) for an offline demo."
AUTHOR = "Shaurya Rane"
HOMEPAGE = "https://github.com/shauryarane05/agl-lidar-hmi-app"
BUGTRACKER = "https://github.com/shauryarane05/agl-lidar-hmi-app/issues"
SECTION = "graphics"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

RECIPE_MAINTAINER = "Shaurya Rane <ssranevjti@gmail.com>"

SRCREV = "2274f87d993c1e413f3a6c17104275ee2118cb88"
SRCREV:localdev = "${AUTOREV}"
SRC_URI = "git://github.com/shauryarane05/agl-lidar-hmi-app.git;branch=main;protocol=https;destsuffix=agl-lidar-demo \
           file://agl-lidar-demo.service \
"

S = "${UNPACKDIR}/agl-lidar-demo"

inherit flutter-app agl-app systemd

PUBSPEC_APPNAME = "agl_lidar_demo"
PUBSPEC_IGNORE_LOCKFILE = "1"
FLUTTER_BUILD_ARGS = "bundle -v"

AGL_APP_TEMPLATE = "agl-app-flutter"
AGL_APP_NAME = "AGL LiDAR Demo"
AGL_APP_ID = "agl_lidar_demo"

SYSTEMD_SERVICE:${PN} = "agl-lidar-demo.service"

do_install:append() {
    install -d ${D}${datadir}/${BPN}/rosbag/carla_lidar
    install -m 0644 ${S}/rosbag/carla_lidar/metadata.yaml ${D}${datadir}/${BPN}/rosbag/carla_lidar/
    install -m 0644 ${S}/rosbag/carla_lidar/*.db3         ${D}${datadir}/${BPN}/rosbag/carla_lidar/
    install -d ${D}${bindir}
    install -m 0755 ${S}/scripts/run-demo-bag.sh ${D}${bindir}/agl-lidar-demo.sh
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/agl-lidar-demo.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} += "${datadir}/${BPN}/rosbag ${systemd_system_unitdir}"

RDEPENDS:${PN} += " \
    flutter-auto \
    agl-flutter-env \
    ros2cli \
    ros2launch \
    ros2bag \
    rosbag2-storage-default-plugins \
    rosbridge-server \
    vision-msgs \
    lidar-detector \
"
