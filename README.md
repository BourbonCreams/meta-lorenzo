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
7. Python Computer Vision app: a movement detector app uses OpenCV to detect movement in an area using background subtraction. Whenever it detects a movement, it can upload pictures to a DropBox account. By default Dropbox is disabled in the `/home/root/conf.json` file. It can be enabled and a Dropbox token is needed to tell the app where to upload these pictures.

## Service to launch Python app on boot
There is a service installed called `movement-detector` which will automatically launch the Python app to detect movement (with background subtraction) as soon as the board boots up. Currently this feature does not fully work as the GTK complains with `Cannot open display`.
 
## Known issues
Although the application does not run as it should on boot, it is possible to run it and see the graphical output by connecting to the Raspberry Pi via ssh (point 4 of `Included packages`) with X11 forwarding enabled (`-X` flag) and by launching the same command as the service, which is `python3 pi_surveillance.py -c conf.json`. This will open a window showing the output of the camera with its text overlays.

## Python app sample output
After connecting via ssh with X11 forwarding enabled and after running the app, this is the result:
![alt text](https://github.com/BourbonCreams/meta-lorenzo/blob/master/screenshot.jpg?raw=true)
