# Introduction
This Yocto meta layer is made for the Raspberry Pi 3. My specific model is the B+.

Other needed layers:
1. poky
2. meta-openembedded
3. meta-raspberrypi

## How to copy to SD card
After the rpi-sdimg has been generated, insert an SD card and copy the generated image with:
```
sudo dd if=example-image-raspberrypi3-custom.rpi-sdimg of=/dev/sdc bs=10M status=progress
```

Note that `/dev/sdc` might be different, i.e. `/dev/sdb`.

A second and much easier option is to use [balenaEtcher](https://www.balena.io/etcher/).

## Included packages
Several useful packages/utilities are included:
1. nmtui: to connect to a network, simply run `nmtui` and follow the instructions on the screen
2. htop: run `htop` to see the several processes running and the status of the system (CPU usage, memory, etc)
3. python (v2.7 and v3.5): write and launch Python programs
4. ssh-server: after connecting the Raspberry Pi to a network, use nmtui (point 1) to connect to a network. Then use the assigned IP a client computer to connect to the Raspberry Pi via ssh
5. OpenCV (v3.4.3): a library for Computer Vision applications
6. raspistill and raspivid: launch them to take a picture or a video. Add the `--help` flag to check their parameters.

## Service to launch Python app on boot
There is a service installed called `movement-detector` which will automatically launch the Python app to detect movement (with background subtraction) as soon as the board boots up.

