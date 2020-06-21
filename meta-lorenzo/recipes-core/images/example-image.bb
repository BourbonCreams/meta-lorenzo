# Based on core-image-base
require recipes-core/images/core-image-base.bb

# Only allow for machines which start with "rpi"
COMPATIBLE_MACHINE = "^rpi$"

# Change root password
inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P 21 root;"

# Enable UART
ENABLE_UART = "1"

# Install vim
IMAGE_INSTALL += "vim "

# Add timezone through tzdata
IMAGE_INSTALL += "tzdata tzdata-europe "

# Add networkmanager
IMAGE_INSTALL += "networkmanager networkmanager-nmtui networkmanager-bash-completion"

#Remove old image
RM_OLD_IMAGE = "1"

# Generate only SD card file type
IMAGE_FSTYPE = "rpi-sdimg"

# Print message once rootfs is completed
do_rootfs_append() {
    bb.warn("The rootfs is complete!")
}

# Add support for Wi-Fi and Bluetooth
IMAGE_INSTALL += "linux-firmware linux-firmware-bcm43430"

# Add ssh server
IMAGE_FEATURES += "ssh-server-dropbear"

# Install cpp hello world example file - sources version
IMAGE_INSTALL += "hello-world-cpp-sources"

# Install cpp hello world example file - makefile version
IMAGE_INSTALL += "hello-world-cpp-makefile"

# Install python file and service
IMAGE_INSTALL += "python-flask-hello-world"
