FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

SRC_URI += "\
file://Who_is_the_Boss_5G.nmconnection \
"

do_install_append() {
    # Install netowrk config file
    install -m 0600 "${WORKDIR}/Who_is_the_Boss_5G.nmconnection" "${D}${sysconfdir}/NetworkManager/system-connections"
}
