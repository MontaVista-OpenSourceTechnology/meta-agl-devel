CANBUS_NETWORK_CONFIG = "${@bb.utils.contains('AGL_FEATURES', 'agl-refhw-h3', 'canbus-can-fd.network', 'canbus-can.network', d)}"
