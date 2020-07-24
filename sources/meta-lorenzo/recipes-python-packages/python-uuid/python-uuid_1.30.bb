
SUMMARY = "UUID object and generation functions (Python 2.3 or higher)"
HOMEPAGE = "http://zesty.ca/python/"
AUTHOR = "Ka-Ping Yee <ping@zesty.ca>"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://setup.py;md5=8cb4defb6d306b47b67a50f356085276"

SRC_URI = "https://files.pythonhosted.org/packages/ce/63/f42f5aa951ebf2c8dac81f77a8edcc1c218640a2a35a03b9ff2d4aa64c3d/uuid-1.30.tar.gz"
SRC_URI[md5sum] = "639b310f1fe6800e4bf8aa1dd9333117"
SRC_URI[sha256sum] = "1f87cc004ac5120466f36c5beae48b4c48cc411968eed0eaecd3da82aa96193f"

S = "${WORKDIR}/uuid-1.30"

RDEPENDS_${PN} = ""

inherit setuptools
