# ADB over Wi-Fi on Android 10 using Magisk

This guide explains how to enable **ADB (Android Debug Bridge) over Wi-Fi** on Android 10 and older devices using **Magisk-WiFiADB**.

It is especially useful for devices where connecting a USB cable is difficult or impossible.

Once configured, the device can be connected to a computer over Wi-Fi and used with **Android Studio**, `adb`, `scrcpy`, and other ADB-based tools.

> **Important:** Android 10 and older use the classic ADB-over-TCP method. The modern **Wireless debugging** pairing feature was introduced with Android 11.

---

## Requirements

### Android device

* Android 10 or older
* Root access
* Magisk installed
* Magisk module support
* Wi-Fi connection

### Computer

* Windows, Linux, or macOS
* Android SDK Platform-Tools (`adb`)
* Connected to the **same Wi-Fi/LAN** as the Android device

A USB cable is **not required for normal operation** after the module has been installed.

---

## 1. Install Magisk-WiFiADB

Download the module:

**Repository:**
https://github.com/mrh929/magisk-wifiadb

**Releases:**
https://github.com/mrh929/magisk-wifiadb/releases

Install the downloaded ZIP through Magisk:

```text
Magisk
→ Modules
→ Install from storage
→ Select Magisk-WiFiADB ZIP
```

Enable the module and reboot the device.

Magisk-WiFiADB automatically enables ADB over TCP during boot.

---

## 2. Configure the ADB port (optional, use 5555 as ADB port if you don't need to configure it)

<details>

Configuration is optional.

The module supports a configurable TCP port through:

```text
ADB_PORT
```

For example:

```text
ADB_PORT=5555
```

The configuration file is:

```text
/data/adb/modules/magisk-wifiadb/config
```

For a simple setup, **5555** is recommended.

If you do not change the configuration, use the port configured by the module.

</details>

---

## 3. Find the Android device IP address — without USB or ADB

This is important when the device cannot be connected to the computer via USB.

You can find the IP address directly on the Android device.

### Android Wi-Fi settings

Open:

```text
→ FYT Settings
→ WLAN
→ Wi-Fi preferences
→ Advanced
```

or 

```text
→ Launcher's settings section
→ Device Settings (under Miscellaneous) 
→ About phone
```

Look for:

```text
IP address
```

For example:

```text
192.168.1.105
```

### If Android does not show the IP address

Check your router's connected-device/DHCP-client list and find the Android device there.

---

## 4. Connect from Windows PowerShell

Once you know the IP address and port (5555 for default configuration), combine them:

```text
IP:PORT
```

For example:

```text
192.168.1.105:5555
```

Open PowerShell and run:

```powershell
adb connect 192.168.1.105:5555
```

Successful output:

```text
connected to 192.168.1.105:5555
```

Verify the connection:

```powershell
adb devices
```

You should see:

```text
List of devices attached
192.168.1.105:5555    device
```

---

## 5. Connect from Linux/macOS Bash

Use the same connection command:

```bash
adb connect 192.168.1.105:5555
```

Then verify:

```bash
adb devices
```

Expected:

```text
List of devices attached
192.168.1.105:5555    device
```

---

## 6. Use the device with Android Studio

Once:

```bash
adb devices
```

shows:

```text
192.168.1.105:5555    device
```

the device is available through ADB.

Open Android Studio and select it from the device selector:

```text
Run
→ Select Device
```

The device should appear as an available Android device.

You do **not** need to use:

```text
Pair Devices Using Wi-Fi
```

That is the newer Android 11+ Wireless Debugging mechanism.

For Android 10, the connection is established using:

```bash
adb connect IP:PORT
```

---

## 7. After reboot

Magisk-WiFiADB is designed to enable ADB over TCP automatically during boot.

After restarting the Android device:

1. Wait until Android has fully booted.
2. Make sure Wi-Fi is connected.
3. Find the current IP address if it has changed.
4. Connect again:

### PowerShell

```powershell
adb connect 192.168.1.105:5555
```

### Bash

```bash
adb connect 192.168.1.105:5555
```

If your router uses DHCP, the Android device's IP address may change after reboot.

For a stable IP, configure a **DHCP reservation** for the Android device in your router.

---

## Quick Start

After the module has been installed:

```text
1. Connect Android device and computer to the same Wi-Fi
2. Find the Android device IP address
3. Use the configured ADB port (e.g. 5555)
4. Run adb connect IP:PORT
5. Verify with adb devices
6. Select the device in Android Studio
```

Example:

```text
Android IP: 192.168.1.105
ADB port:   5555
```

### Windows PowerShell

```powershell
adb connect 192.168.1.105:5555
adb devices
```

### Linux/macOS

```bash
adb connect 192.168.1.105:5555
adb devices
```

Expected:

```text
192.168.1.105:5555    device
```

The device is now connected to ADB entirely over Wi-Fi.

---

## Security

Classic ADB-over-TCP on Android 10 does not use the authenticated pairing mechanism introduced with Android 11's Wireless Debugging.

Use it only on a **trusted network**.

Do not expose the ADB port directly to the Internet or forward it through your router.

Changing the port does not make the connection secure.
