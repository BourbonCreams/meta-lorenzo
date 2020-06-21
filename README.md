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
