SUMMARY = "LXC ivi demo platform guest image"
LICENSE = "MIT"

require guest-image-minimal.bb

IMAGE_INSTALL:append = " \
    agl-compositor-init \
    agl-compositor \
    cluster-dashboard \
    packagegroup-agl-ic-demo-platform \
"
