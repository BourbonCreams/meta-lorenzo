SUMMARY = "Movement Detector app for Raspberry Pi and its camera module"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
file://COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

SRC_URI = "\
file://COPYING \
file://hello_world.py \
"

S = "${WORKDIR}"

do_install(){
    install -d ${D}${bindir}
    install -m 0755 hello_world.py ${D}${bindir}
}
