
SUMMARY = "Official Dropbox API Client"
HOMEPAGE = "http://www.dropbox.com/developers"
AUTHOR = "Dropbox <dev-platform@dropbox.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef3219362ea5e452a18031af12f35eb6"

SRC_URI = "https://files.pythonhosted.org/packages/85/33/bffd4a7596f3280f8bd2796b4f09c5c701b99d5c8e68715351cc2b3eeca8/dropbox-10.3.0.tar.gz"
SRC_URI[md5sum] = "f6d1a30af7e202237d660213d22e48a7"
SRC_URI[sha256sum] = "5f296f13ee7c358ab41779a73c4922ed81199447566c1a4c8fbf23dbcda25e20"

S = "${WORKDIR}/dropbox-10.3.0"

RDEPENDS_${PN} = "python-requests python-six"

inherit setuptools
