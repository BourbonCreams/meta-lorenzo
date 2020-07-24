
SUMMARY = "A pure Python interface for the Raspberry Pi camera module."
HOMEPAGE = "http://picamera.readthedocs.io/"
AUTHOR = "Dave Jones <dave@waveform.org.uk>"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a5f6282f39d52726bdc1e51d5c4b95c9"

SRC_URI = "https://files.pythonhosted.org/packages/79/c4/80afe871d82ab1d5c9d8f0c0258228a8a0ed96db07a78ef17e7fba12fda8/picamera-1.13.tar.gz"
SRC_URI[md5sum] = "47e815b0f21bba2a91ab3c4cd36c6f90"
SRC_URI[sha256sum] = "890815aa01e4d855a6a95dd3ad0953b872a6b954982106407df0c5a31a163e50"

S = "${WORKDIR}/picamera-1.13"

RDEPENDS_${PN} = "python3 "

inherit setuptools

export READTHEDOCS = "True"

do_install(){
    # Install file for Python3 too
    install -d ${D}/usr
    install -d ${D}/usr/lib
    install -d ${D}/usr/lib/python3.5
    install -d ${D}/usr/lib/python3.5/site-packages
    install -d ${D}/usr/lib/python3.5/site-packages/picamera

    cp -r "${WORKDIR}/sysroot-destdir/usr/lib/python2.7/site-packages/picamera" "${D}/usr/lib/python3.5/site-packages"
}
