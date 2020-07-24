SUMMARY = "Movement Detector app for Raspberry Pi and its camera module"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "\
file://COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302 \
"

SRC_URI = "\
file://COPYING \
file://pi_surveillance.py \
file://conf.json \
file://pyimagesearch/__init__.py \
file://pyimagesearch/tempimage.py \
file://movement-detector.service \
"

#RDEPENDS_${PN} = "python3 python3-numpy python3-core python3-numbers python-picamera"
RDEPENDS_${PN} = "python3 python3-numpy python3-core python3-numbers"

inherit systemd

S = "${WORKDIR}"

do_install(){
    # Install python files
    install -d ${D}/home/
    install -d ${D}/home/root/
    install -d ${D}/home/root/pyimagesearch/

    install -m 0755 pi_surveillance.py ${D}/home/root/
    install -m 0755 conf.json ${D}/home/root/
    install -m 0755 pyimagesearch/__init__.py ${D}/home/root/pyimagesearch/
    install -m 0755 pyimagesearch/tempimage.py ${D}/home/root/pyimagesearch/

    # Install service
    install -d 0755 "${D}${systemd_unitdir}/system"
    install -m 0644 "${WORKDIR}/movement-detector.service" "${D}${systemd_unitdir}/system"
}

FILES_${PN} += " \
/home/root/pi_surveillance.py \
/home/root/conf.json \
/home/root/pyimagesearch/__init__.py \
/home/root/pyimagesearch/tempimage.py \
${systemd_unitdir}/system/movement-detector.service \
"

SYSTEMD_SERVICE_${PN} += "movement-detector.service"
