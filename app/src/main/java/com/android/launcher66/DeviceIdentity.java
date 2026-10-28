package com.android.launcher66;

import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;

import com.android.launcher66.FytPlatform.Chipset;
import com.android.launcher66.settings.Keys;

import android.SystemProperties;

/**
 * What the device is, by its chipset (see FytPlatform for the rules): whether it is an FYT unit,
 * whether it is a 7870, the line settings show. Found once and kept in the preferences, so a
 * start of the launcher process does not decide it again. Everything here reads system
 * properties and the static fields of Build, which touch neither disk nor the PackageManager, so
 * it is safe on the main thread.
 *
 * Only what concerns the device goes by this. What concerns the stock music player goes by its
 * package (StockSources, MusicService), as before.
 */
public final class DeviceIdentity {
    private static final String TAG = "DeviceIdentity";

    private DeviceIdentity() {}

    private static volatile Chipset sChipset;
    private static boolean sLoggedEarlyRead;

    /** Main thread, once per launcher process: takes the saved result or finds it out and saves it. */
    static void init(SharedPreferences prefs) {
        Chipset early = sChipset;
        Chipset saved = FytPlatform.fromSaved(prefs.getString(Keys.DEVICE_CHIPSET, null));
        if (prefs.getInt(Keys.DEVICE_CHIPSET_RULES, 0) == FytPlatform.RULES_VERSION && saved != null) {
            sChipset = saved;
            Log.i(TAG, "FYT platform: " + saved + " (saved)");
            if (early != null && early != saved) {
                Log.w(TAG, "Read as " + early + " before init(), the saved result is " + saved);
            }
            return;
        }
        Chipset found = detect();
        sChipset = found;
        prefs.edit()
                .putString(Keys.DEVICE_CHIPSET, found.name())
                .putInt(Keys.DEVICE_CHIPSET_RULES, FytPlatform.RULES_VERSION)
                .apply();
        Log.i(TAG, "FYT platform: " + found + ", detected from " + rawValues());
    }

    public static Chipset chipset() {
        Chipset chipset = sChipset;
        if (chipset == null) {
            // The wallpaper picker's process never calls init(), and an early read may come first.
            chipset = detect();
            sChipset = chipset;
            if (!sLoggedEarlyRead) {
                sLoggedEarlyRead = true;
                Log.d(TAG, "read before init(), detected without saving: " + chipset);
            }
        }
        return chipset;
    }

    public static boolean isFyt() {
        return chipset() != Chipset.NOT_FYT;
    }

    public static boolean is7870() {
        return chipset() == Chipset.FYT_7870;
    }

    /** The device and its Android for the settings; cheap, it is read again each time. */
    public static String deviceLine() {
        return FytPlatform.deviceLine(chipset(), Build.MANUFACTURER, Build.MODEL,
                SystemProperties.get("ro.fyt.platform"), Build.VERSION.SDK_INT, Build.VERSION.RELEASE);
    }

    private static Chipset detect() {
        String fytPlatform = SystemProperties.get("ro.fyt.platform");
        boolean fyt = FytPlatform.isFyt(
                SystemProperties.get("ro.product.board"),
                SystemProperties.get("ro.product.manufacturer"),
                fytPlatform,
                Build.DISPLAY,
                SystemProperties.get("ro.build.fytmanufacturer"));
        return FytPlatform.classify(fyt, fytPlatform,
                Build.MODEL, Build.BOARD, Build.PRODUCT, Build.DEVICE, Build.HARDWARE,
                SystemProperties.get("ro.board.platform"));
    }

    /** What the result was found from, for the log: so a new unit can be checked against the map. */
    private static String rawValues() {
        return "ro.fyt.platform=" + SystemProperties.get("ro.fyt.platform")
                + " board=" + Build.BOARD
                + " model=" + Build.MODEL
                + " product=" + Build.PRODUCT
                + " device=" + Build.DEVICE
                + " hardware=" + Build.HARDWARE
                + " ro.board.platform=" + SystemProperties.get("ro.board.platform")
                + " fytmanufacturer=" + SystemProperties.get("ro.build.fytmanufacturer");
    }
}
