# Reverse engineered launcher for FYT 7862/8581 with launcher creator, night mode and fuel statistics.

So far tested only on 2000x1100 resolution.

List of modifications:
- Reworked music widget working with most of the music players.
- Launcher creator allowing to adjust launcher layout to user preferences.
- Fuel stats with possibility to display them on the main screen and in the chosen apps with specified by user position on the screen.
- Night Mode that determines sunrise and sunset depending on the location (also allows user to set the wallpaper and brightness for the day/night mode).
- Settings fragment with useful tweaks.
- Replaced part of deprecated code with the new one.
- Added 1920x720 resolution.

![](https://github.com/vasyl91/FYT-Launcher-Mod/blob/main/images/example_creator.gif)

[<img src="./images/1.png" width="50%">](./images/1.png)[<img src="./images/2.png" width="50%">](./images/2.png)

## Fuel ststistics

// TODO

## Generating app in Android Studio

1. Clone the repository. 
2. Replace `android.jar` in `C:\Users\<UserName>\AppData\Local\Android\Sdk\platforms\android-34` with the file from this [release](https://github.com/vasyl91/FYT-Launcher-Mod/releases/download/android-34-modded-jar/android-34.rar).
3. Open the repository and rebuild the project, if I haven't forgotten anything it should work.
4. To generate the app use `keystore.jks` located in `FYT-Launcher-Mod\app`. Choose exisiting android key alias with password `android`. 

To debug the app on FYT device, connect it with your PC. For android 11 and above try to connect with Wi-Fi, USB might be problematic. If you don't have much choice then try to use 4pin USB cable - in my case this one works fine). 
If you need the drivers please use [this ones](https://github.com/vasyl91/FYT-Launcher-Mod/releases/download/android-34-modded-jar/Unisoc+SPD+Driver.rar). 
Go to Developer options, click on the three dots in the top right corner and select the second option from the popup (both are in chineese).
[<img src="./images/3.png" width="50%">](./images/3.png)
Remember to enable USB debugging.

If you keep getting `unauthorized` while running `adb devices` and your device doesn't display the popup to confirm the connection then it means that you'll have to add adb keys manually.
That's tricky. Follow the steps below (requires root on FYT and your phone):
1. Connect your phone to Android Studio and confirm the connection. 
2. Go to `/data/misc/adb/` on your phone and copy it's content (should contain `adb_keys`).
3. Paste that file in the same directory on your FYT.
4. Install Termux terminal, open it and run the following commands `chmod 0640 /data/misc/adb/`, `chown system:shell /data/misc/adb/`, `chcon u:object_r:adb_keys_file:s0 /data/misc/adb/` (don't worry if you get some error with the last one).
