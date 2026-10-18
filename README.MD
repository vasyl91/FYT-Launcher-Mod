# Reverse-engineered launcher for FYT 7862/8581 with a launcher creator, night mode and fuel statistics.

**Launcher Mod has been tested on Android 10 with a 2000x1200 resolution, as this is the only FYT device I own.**

It should work with all resolutions on Android 8 through 16 (see [Supported devices](#supported-devices)), as the FYT version (a system app) on FYT units, or as the standard version (a user app) on any device.

The FYT version declares `android:sharedUserId="android.uid.system"`, so it runs as the system itself (uid 1000). Android accepts that only from an APK signed with the same platform key as the firmware, and this one is signed with the public AOSP test key, which FYT firmware is built with. A firmware signed with its own platform key refuses it (`INSTALL_FAILED_SHARED_USER_INCOMPATIBLE`), whatever its Android version and whether it is rooted or not: the check is the signature, not a permission root could grant. On such a unit, and on any other device, use the standard version (see [Versions and updates](#versions-and-updates)): it gets the privileges it needs from root through the [FYT VDHost](vdhost/README.md) Magisk module, or from Shizuku without root. The PiPs work in it as windows, and pinned PiP works on FYT units as in the FYT version.

The check is the key, not the brand: some custom ROMs (unofficial builds in particular) are made with the same public AOSP test key, and the FYT version installs there as a system app too. It then works as on an FYT unit wherever the system is all it needs (the PiPs, the Baseline Profile, the status bar swipe area, the boot autostart, the full logcat), while what only an FYT unit has (pinned PiP, radio, CAN bus, FYT's music and navigation sources, skins) stays off: the launcher sees it is not on one. A ROM signed with its own platform key would need the launcher built and signed with that key, which only the ROM's maintainer has. **No such build exists yet**: on these ROMs use the standard version.

Both versions are the same app (`com.android.launcher66`), but Android does not let an update change the shared user id: the FYT version has to be uninstalled before installing the standard one, and the other way round (this wipes the launcher's data).

IMPORTANT: Note that some FYT devices do not support pinned PiP on the main screen. You can still use the launcher, but you'll have to turn off PiP in the launcher's settings (otherwise Google Maps will pop up every time you try to open the home page — if this happens, wipe the launcher's data or reinstall it).

[XDA Forums thread](https://xdaforums.com/t/reverse-engineered-launcher-for-fyt-7862-8581.4702542/)

List of modifications:
- Up to four PiPs on a single screen or across multiple screens, depending on user preference.
- ConstraintLayout that adapts the launcher to any given resolution and orientation.
- Universal music widget with a favorite button (requires Notification Listener permission) that works with most music players (including the stock one).
- Enabled widgets (upscaled for better interaction), shortcuts, and folders on the main screen. Reworked screen grid. Extra screens as well.
- Launcher creator allowing the launcher's layout to be adjusted to user preferences. All layout elements except the bottom bar can be turned off. Users can also specify which screen should be the main screen.
- Bottom bar with optional widgets.
- Auto-hide bottom bar option.
- Resizable bottom bar.
- Skins for widgets and bottom bar.
- Optional floating buttons for quickly switching apps between PiPs.
- Optional transparent overlay square on the status bar that detects swipes and allows scrolling between pages. This can be useful when the PiP view occupies most of the visible screen (privileged/system app only).
- Live fuel stats (requires Accessibility Service permission), with the option to display them on the main screen and in chosen apps, at a screen position specified by the user.
- Night Mode that determines sunrise and sunset based on location (also allows the user to manually adjust sunrise/sunset times, and set the wallpaper and brightness for day/night mode).
- Settings fragment with useful tweaks.
- Improved cold start (on some devices this [Magisk module](https://github.com/vasyl91/FYT-improved-cold-start/releases/latest) might make it even faster).
- Baseline profile implementation.
- Versatile logcat (best performance on privileged/system apps).
- New icon for the launcher and its settings, with a settings icon in the app drawer.
- "Update" feature allowing users to easily update the launcher from its settings.
- Replaced some deprecated code with newer implementations.

---

**Installation:**

For the first installation, download `installer.zip`, unpack it onto a FAT32-formatted USB flash drive, then connect the drive to your unit's USB port and wait — installation should start after a few seconds. Once installed, you can dirty-install updates (also via the built-in updater) or debug versions without using the USB drive again.

If installation doesn't start automatically, please try other USB ports. If it still doesn't start regardless of the USB port, it means either your device is not an FYT device, or it is an FYT device but runs Android 12 or higher (some brands don't allow installing apps via scripts from a USB drive).

This method installs the FYT version as a privileged system app, in place of the stock launcher: install it this way the first time. Where the script cannot run, or the firmware refuses the FYT version (see above), install the standard version like any other APK and give it root with the [FYT VDHost](vdhost/README.md) Magisk module or start Shizuku.

<a id="supported-devices"></a>**Supported devices:**

| Android | Installed as | Privileges from | Multiple PiPs | Pinned PiP | Tested |
|---|---|---|---|---|---|
| 8–9 | FYT version | the system (uid 1000) | ✅ Android's ActivityView | ✅ | ➖ |
| 10 | FYT version | the system (uid 1000) | ✅ Android's ActivityView | ✅ | ✅ FYT unit, 2000x1200 |
| 11–16 | FYT version | the system (uid 1000) | ✅ the launcher's own virtual displays | ✅ | ➖ |
| 8–10 | standard version | root ([FYT VDHost](vdhost/README.md) module) or Shizuku | ✅ virtual displays through the module or Shizuku | ✅ on FYT units | ➖ |
| 11–16 | standard version | root ([FYT VDHost](vdhost/README.md) module) | ✅ virtual displays through the module | ✅ on FYT units | ✅ Android 14, Xiaomi Redmi Note 8T |
| 11–16 | standard version | Shizuku | ✅ virtual displays through Shizuku ¹ | ✅ on FYT units | ✅ Android 16, Samsung Galaxy A55 |
| 8–16 | standard version | none | ❌ | ✅ on FYT units | ➖ |
| 8–16 | FYT version on a non-FYT ROM made with the AOSP test key | the system (uid 1000) | ✅ as the FYT version on the same Android | ❌ FYT units only | ➖ |

¹ Apps that protect their content (`FLAG_SECURE`: video streaming, banking) show black in a PiP, and the PiPs come up only once Shizuku has started (about half a minute after a boot, longer if it waits for Wi-Fi).

Without system privileges, root or Shizuku the launcher itself works everywhere; what needs them (the multiple PiPs, the status bar swipe area, the boot autostart, the full logcat) is hidden or does nothing.

---

**Google Maps bug**

Most FYT ROMs offer two ways of displaying apps on the launcher's screen. The most common one is "pinned Picture-in-Picture mode," with all its consequences for the app's UI behavior — in Google Maps' case, this switches the layout to minimal. This method doesn't provide the entry points needed to maintain a "full screen UI" for apps that support PiP mode.
The only reliable way I've found to prevent Google Maps from switching to its minimal UI requires root, LSPosed, and this [LSPosed module](https://github.com/vasyl91/Full-Interface-PiP/releases/latest). It successfully forces the app to keep its full UI inside FYT's Picture-in-Picture mode (remember to select Google Maps in the LSPosed "Enable module" section).
Check out this [XDA thread](https://xdaforums.com/t/kernel-fyt-7862-s-8581-optimized-root-prepared-magisk-edition.4610985/) if you want to root your device. Always make a full backup (AllAppUpdate.bin, config.txt, etc.) before flashing anything!

The second method displays apps in windowed mode as they normally appear: through Android's hidden ActivityView class (FYT version on Android 8–10; FYT did not modify it), otherwise through the launcher's own virtual displays. This doesn't affect the layout and needs no root in the FYT version. The multiple-PiP feature uses this method.


![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_creator.gif)

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/switch_buttons.gif)

---

**Gallery:**

<details>

[<img src="./images/1.png" width="50%">](./images/1.png) [<img src="./images/2.png" width="50%">](./images/2.png)
[<img src="./images/4.png" width="50%">](./images/4.png) [<img src="./images/5.png" width="50%">](./images/5.png)
[<img src="./images/6.png" width="50%">](./images/6.png) [<img src="./images/7.png" width="50%">](./images/7.png)
[<img src="./images/8.png" width="50%">](./images/8.png) [<img src="./images/9.png" width="50%">](./images/9.png)
[<img src="./images/s1.png" width="50%">](./images/s1.png) [<img src="./images/s2.png" width="50%">](./images/s2.png)
[<img src="./images/s3.png" width="50%">](./images/s3.png) [<img src="./images/s4.png" width="50%">](./images/s4.png)
[<img src="./images/s5.png" width="50%">](./images/s5.png) [<img src="./images/s6.png" width="50%">](./images/s6.png)
[<img src="./images/s7.png" width="50%">](./images/s7.png) [<img src="./images/s8.png" width="50%">](./images/s8.png)
[<img src="./images/v1.png" width="50%">](./images/v1.png) [<img src="./images/v2.png" width="50%">](./images/v2.png)
[<img src="./images/v3.png" width="50%">](./images/v3.png) [<img src="./images/v4.png" width="50%">](./images/v4.png)
[<img src="./images/v5.png" width="50%">](./images/v5.png) [<img src="./images/v6.png" width="50%">](./images/v6.png)
[<img src="./images/v7.png" width="50%">](./images/v7.png) [<img src="./images/v8.png" width="50%">](./images/v8.png)

</details>

**Music widget:**

<details>

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_music.gif)

</details>

---

**Night mode:**

<details>

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_night_mode.gif)

</details>

---

**Settings:**

<details>

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_settings.gif)

</details>

---

**In-app stats:**

<details>

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_inapp_stat.gif)

</details>

---

## Baseline Profiles

A Baseline Profile lists the code the launcher runs when it starts and in everyday use (pages, widgets, bars, PiPs), so that Android compiles it ahead of time instead of interpreting it at every start. It is generated with the [`:baselineprofile`](baselineProfile/README.md) module and ships inside every release APK. It is one file for both versions, which run the same code.

Android compiles it by itself only during idle maintenance (screen off, charging, long inactivity), which a head unit in a car practically never reaches. The launcher therefore does it itself, in the background and without restarting:

1. **After installing:** 90 s after the first start of a new APK, the profile is applied and the launcher compiled with it (`speed-profile`). The compiled code is used from the next launcher start.
2. **Usage refreshes:** meanwhile Android records the code your own setup uses in the same profile. The launcher is compiled again with it after 3, 14 and 30 days, each time once it has had at least 5, 10 and 10 sessions (a device restart, a wake-up from sleep, or a launcher restart at least 3 minutes after the previous session).

Its state and two resets (the refresh schedule only, or everything back to the profile in the APK) are in the launcher's settings.

| Installed as | Android | After installing | Usage refreshes | Reset | Compiled by |
|---|---|---|---|---|---|
| FYT version (system app) | 8–16 | ✅ | ✅ | ✅ | Android's package manager, asked by the launcher itself (uid 1000) |
| Standard version + [FYT VDHost](vdhost/README.md) module (root) | 8–16 | ✅ | ✅ | ✅ | the module's daemon (uid 1000) |
| Standard version + Shizuku | 8–16 | ✅ | ✅ | ✅ ¹ | Shizuku's service, as `adb shell cmd package compile -m speed-profile -f` would |
| Standard version, no root, no Shizuku | 8–16 | ❌ ² | ❌ ² | ❌ | – |
| Debug build (any version) | 8–16 | ❌ ³ | ❌ ³ | ❌ | – |

¹ On Android 8–13 Shizuku may not clear the recorded data: the profile from the APK is applied again on top of it.<br>
² Android's own idle maintenance applies the profile one day.<br>
³ Debug builds carry no Baseline Profile.

**Generating a new profile** (for developers, after larger code changes; see [baselineProfile/README.md](baselineProfile/README.md)) takes one test device, an FYT unit (FYT version) or any other device (standard version), connected over ADB:

| Android on the test device | Generating a profile |
|---|---|
| 8 | ❌ Macrobenchmark needs Android 9+ |
| 9–12 | ✅ with root (Magisk, root allowed for Shell) |
| 13–16 | ✅ without root |

---

## Versions and updates

Every release comes in two versions:

| File | Version | Where |
|---|---|---|
| `fyt_release_<version>.apk` | FYT version | FYT units only. A system app (signed with the platform key, `android:sharedUserId="android.uid.system"`), installed with `installer.zip`. |
| `standard_release_<version>.apk` | Standard version (called "phone" up to 1.2.1) | Any other Android 8+ device: phones, tablets, other head units. A user app; the privileged features come from the [FYT VDHost](vdhost/README.md) Magisk module (root) or Shizuku. |

The launcher's settings show which one is installed, under its version (e.g. "Release build · FYT version").

**Built-in update.** The updater downloads its own version's file (`fyt_release_` or `standard_release_` + the version) from the [latest release](https://github.com/vasyl91/FYT-Launcher-Mod/releases/latest). A debug build is offered the release of the same or a newer version, to install over it ("Press here to download and install release version …").

Versions up to 1.2.1 download `update<version>.apk` instead, whichever version they are. So that they still find their update, every release also carries the FYT version under that name: the [Release assets](.github/workflows/release-assets.yml) workflow adds it by itself when a release is published. It waits up to 10 minutes for `fyt_release_<version>.apk`, if the files are uploaded after publishing; otherwise run it by hand (Actions → Release assets → Run workflow, with the tag). A standard ("phone") 1.2.1 would download the FYT version and fail to install it: it has to be updated to the standard version by hand once.

Releases are tagged `v<version>` (e.g. `v1.2.2`): the updater reads the version from the tag.

---

## Fuel statistics

To get it working, you have to find the CAN bus codes. Without them, the enabled widget will show 0 by default. You can do this with the help of the CAN bus logging tool (check the guide in the launcher's settings) or look for the codes manually in the source code as described below.

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_stats.gif)

<details>

1. Go to Settings > Layout creator and check what the summary says under Fuel statistics:

[<img src="./images/s4.png" width="50%">](./images/s4.png)

2. It should contain the name of the class that the CAN bus runs by default — in my case, it's [`com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.java`](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/fuel_stats_example/RZC_BZ408IndexActi.java). Start with that class and inspect its subclasses if needed.

3. Keep in mind that the following instructions are just an example based on my case, meant as a hint of how to do it. Also, some units or CAN buses don't provide this functionality — if your CAN bus app doesn't display current fuel consumption and/or cruising range, then you can't use this widget.

4. In general, the codes you're looking for should be in the Java file located in the same folder as the class from step 1 (in my case, biaozhi408). Open that folder in, for example, Sublime, and search for `L/100KM`. If you find it, proceed to step 7. If not, follow the next steps.

5. Open the class from step 2 and look for the method that opens the next activity, which eventually contains what you need — there might be a few to check. `com.syu.carinfo.rzc.biaozhi408.RZC_BZ408IndexActi.java` contains an `onClickListener` with an intent:

```
                    Intent intent = new Intent();
                    intent.setClass(RZC_BZ408IndexActi.this, RZC_BZ408OilMileIndexActi.class);
```
That leads to the class `com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi.java`; keep looking there.

6. In [`RZC_BZ408OilMileIndexActi.java`](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/fuel_stats_example/RZC_BZ408OilMileIndexActi.java) you will find three tabs:

```
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage1").setIndicator("tabPage1").setContent(new Intent(this, (Class<?>) RZC_BZ408OilMilePage1Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage2").setIndicator("tabPage2").setContent(new Intent(this, (Class<?>) RZC_BZ408OilMilePage2Acti.class)));
        this.mTabHost.addTab(this.mTabHost.newTabSpec("tabPage3").setIndicator("tabPage3").setContent(new Intent(this, (Class<?>) RZC_BZ408OilMilePage3Acti.class)));
```
`RZC_BZ408OilMilePage1Acti.class` represents the window in the FYT CAN bus app that contains the fuel statistics.

7. Finally, proceed to [`com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMilePage1Acti.java`](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/fuel_stats_example/RZC_BZ408OilMilePage1Acti.java), where you'll find functions similar to these (I left only the crucial parts):

```
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override 
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                ....
                case 102:
                    RZC_BZ408OilMilePage1Acti.this.mUpdaterOilExpend();
                    break;
                case 103:
                    RZC_BZ408OilMilePage1Acti.this.mUpdaterDrivingMileage();
                    break;
                ....
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ....
        DataCanbus.PROXY.cmd(70, new int[]{51}, null, null);
    }

    @Override 
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        ....
    }

    @Override 
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        ....
    }

    public void mUpdaterOilExpend() {
        int value = DataCanbus.DATA[102];
        ....
    }

    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        ....
    }
```

8. The codes you're looking for are inside `DataCanbus.DATA[102]`, `DataCanbus.DATA[103]`, and `DataCanbus.PROXY.cmd(70, new int[]{51}, null, null);`. The launcher setting should be updated as follows:

    `Fuel: 102, Range: 103, cmdInt: 70, cmdArr: 51`

 If you have trouble identifying these codes, look in the containing folder for a file that holds the general code list for that particular car (it might NOT be available for every car! In my case, it's [`com.syu.carinfo.rzc.biaozhi408.Const_RZC4_PSA_ALL_DATA.java`](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/fuel_stats_example/Const_RZC4_PSA_ALL_DATA.java)).

9. If the widget still shows `0.0 L/100Km` and `0 Km`, or the readings are bizarre and inaccurate, your device probably uses different codes than the ones provided in this library. To get these codes, you'll have to unpack the CAN bus app installed on your head unit. 

10. To extract the APK file, install [Apk Analyzer](https://play.google.com/store/apps/details?id=sk.styk.martin.apkanalyzer&hl=en&pli=1) on your device. Open it and type `com.syu.canbus` in the search bar. Open the result, and in the next window press the three dots in the bottom-right corner, then press `Export APK`. Move the exported `com.syu.canbus.apk` to your PC.

11. To unpack the extracted APK, use the [APKRepatcher](https://github.com/vasyl91/APKRepatcher/releases/tag/Update2024) tool. Download it, then inside the APKRepatcher folder hold Shift, right-click an empty area, and open Command Prompt from the context menu. In Command Prompt, paste `java -jar APKRepatcher.jar` and press Enter. (Install Java on your PC if needed — just google it.)

12. In APKRepatcher, go to File > Open APK, select your `com.syu.canbus.apk`, and wait until it finishes. Then go to the directory `APKRepatcher\Projects\com.syu.canbus.apk\javaCode\classes.dex\sources\com\syu` and repeat step 2.


In my case, the CAN bus stops sending fuel consumption data when the speed drops below 40 km/h, so I added a function that attempts to ROUGHLY estimate fuel consumption, to provide some insight even though it's admittedly an inaccurate calculation. To use this, you'll need to find one additional code representing RPM — `U_ENGINE_SPEED = 148;` — found in [`Const_RZC4_PSA_ALL_DATA.java`](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/fuel_stats_example/Const_RZC4_PSA_ALL_DATA.java) mentioned earlier, and provide your car's details in the app settings.

</details>

---

## Debugging

1. Use the built-in logcat tool (see the launcher's settings) or get the logs using other software, e.g. [Logcat Reader](https://play.google.com/store/apps/details?id=com.dp.logcatapp&hl=en&pli=1). If you want to include LeakCanary and typical debug logs specific to BuildConfig.DEBUG download and install the latest debug version. For anything else the built-in logcat in the release version should be sufficient.
2. Open a new issue, provide your Android version and describe the error (with step-by-step instructions for reproducing it). Attach the logs.

I cannot guarantee that I'll fix every error.

---

## Generating app in Android Studio

1. Clone the repository. 

<details>

Skip this part for builds 1.1.8 and above.

Tampering with `android.jar` has been deprecated since build 1.1.7.

for builds up to 1.1.6 — replace `android.jar` in `C:\Users\<UserName>\AppData\Local\Android\Sdk\platforms\android-36` with the file from this [release](https://github.com/vasyl91/FYT-Launcher-Mod/releases/download/Android-36-modded-jar/android.jar).

for build 1.1.7 — use `android.jar` from this [repository](https://github.com/Reginer/aosp-android-jar); check `targetSdk` inside `app/build.gradle.kts` and choose the Android version you want to work with.

</details>

2. Open the project and choose the build you want to use.
3. To generate the app, use `keystore.jks` located in `FYT-Launcher-Mod\app`. Choose the existing `android` key alias with password `android`. 

To debug the app on an FYT device, connect it to your PC. As USB connection can be problematic, for Android 11 and above use ADB over Wi-Fi. On Android 10 with root access, use this guide - [ADB over Wi-Fi on Android 10 using Magisk](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/MagiskWiFiADB.MD).

USB configuration:

<details>

If you don't have much choice, try a 4-pin USB cable — in my case, this one works fine. 
If you need drivers, use [this one](https://github.com/vasyl91/FYT-Launcher-Mod/releases/download/android-34-modded-jar/Unisoc+SPD+Driver.rar). 
Go to Developer options, click the three dots in the top-right corner, and select the second option from the popup (both are in Chinese).
Remember to enable USB debugging.

[<img src="./images/3.png" width="50%">](./images/3.png)[<img src="./images/3.1.png" width="50%">](./images/3.1.png)

If you keep getting `unauthorized` while running `adb devices`, and your device doesn't show the popup to confirm the connection, you'll have to add the adb keys manually.
That's tricky and unfortunately requires root on both your FYT device and your phone. If you haven't given up, follow the steps below:
1. Connect your phone to your PC and confirm the connection. 
2. Go to `/data/misc/adb/` on your phone and copy its contents (should contain `adb_keys`).
3. Paste that file into the same directory on your FYT unit.
4. Install the Termux terminal on your FYT unit, open it, and run the following commands: `chmod 0640 /data/misc/adb/`, `chown system:shell /data/misc/adb/`, `chcon u:object_r:adb_keys_file:s0 /data/misc/adb/` (don't worry if you get errors with the last one).

</details>

---

## Modifying android.jar (Deprecated since 1.1.7)

<details>

1. Download the already-modified [android.jar](https://github.com/Reginer/aosp-android-jar) for the Android version you want to work on.
2. Download and run [Recaf](https://github.com/Col-E/Recaf).
3. Open `android.jar` in Recaf.
4. Open and decompile `IActivityManager.class`, located in `android/app`, using, e.g., the FernFlower decompiler.

[<img src="./images/IActivityManagerRecaf.png" width="50%">](./images/IActivityManagerRecaf.png)

5. Copy the contents of this file (omitting the first two lines: `// Decompiled with: DecompilerName` and `// Class Version: X`) and use it to create a Java file. Add `void setPinnedStackVisible(boolean bool);` to this file.

[<img src="./images/IActivityManagerJava.png" width="50%">](./images/IActivityManagerJava.png)

6. Download and run [Eclipse](https://eclipseide.org/).
7. In Eclipse, create a new Java project: `File` > `New` > `Java Project`.

[<img src="./images/IActivityManagerEclipse1.png" width="50%">](./images/IActivityManagerEclipse1.png)

8. Remove the project's content and paste in the already predefined [project files](https://github.com/vasyl91/FYT-Launcher-Mod/releases/download/Android-36-modded-jar/android_jar_eclipse.rar).

[<img src="./images/IActivityManagerEclipse2.png" width="50%">](./images/IActivityManagerEclipse2.png)

9. In Eclipse, refresh your project using `F5`, or right-click your project and select `Refresh`.
10. Then go to `Project` > `Properties` > `Java Build Path` > `Libraries` > `Add External JARs...`, choose `android.jar` from step 1, and press `Apply and Close`. Check that `Build automatically` is checked under the `Project` menu (it should be checked by default). Refresh your project again (ignore the errors shown at the bottom of the window).
11. Go to `C:\Users\<your_user-name>\eclipse-workspace\androidJar\target\classes\android\app` and copy `IActivityManager.class`.
12. Download [android_jar_mod.rar](https://github.com/vasyl91/FYT-Launcher-Mod/releases/download/Android-36-modded-jar/android_jar_mod.rar) and paste `IActivityManager.class` into `android_jar_mod\android\app`. Also paste `android.jar` from step 1 into `android_jar_mod\`.

[<img src="./images/IActivityManagerJar.png" width="50%">](./images/IActivityManagerJar.png)

13. Shift + right-click in the `android_jar_mod\` directory and open `PowerShell` from the context menu. Then run the commands provided in the `commands.txt` file in PowerShell (run each command one after another).
14. Finally, you can use the prepared `android.jar` from the `android_jar_mod\` directory to run your project, as described in the `Generating app in Android Studio` section.

</details>

---