# On-target PCL perception node for the AGL LiDAR demo.
# Builds the lidar_detector ROS 2 package from the HMI app repo so detections
# can be computed live on the device instead of replayed from the bag.
inherit ros_distro_humble

DESCRIPTION = "PCL perception node: clusters CARLA LiDAR points into 3D detections for the AGL LiDAR HMI"
AUTHOR = "Shaurya Rane <ssranevjti@gmail.com>"
HOMEPAGE = "https://github.com/shauryarane05/agl-lidar-hmi-app"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

RECIPE_MAINTAINER = "Shaurya Rane <ssranevjti@gmail.com>"

ROS_CN = "lidar_detector"
ROS_BPN = "lidar_detector"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    visualization-msgs \
    vision-msgs \
    geometry-msgs \
    pcl-conversions \
    pcl \
"
ROS_BUILDTOOL_DEPENDS = "ament-cmake-native"
ROS_EXPORT_DEPENDS = "${ROS_BUILD_DEPENDS}"
ROS_BUILDTOOL_EXPORT_DEPENDS = ""
ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    visualization-msgs \
    vision-msgs \
    geometry-msgs \
    pcl-conversions \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/shauryarane05/agl-lidar-hmi-app;branch=main;protocol=https;destsuffix=agl-lidar-src"
SRCREV = "2274f87d993c1e413f3a6c17104275ee2118cb88"
S = "${UNPACKDIR}/agl-lidar-src/perception/lidar_detector"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
