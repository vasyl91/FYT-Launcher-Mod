package com.android.launcher66.settings;

import android.content.SharedPreferences;

import com.android.launcher66.BuildConfig;

/**
 * The four logcat settings as the capture sees them: the single place that reads them. A debug
 * build is a test build, so there every capture is on and the settings screen cannot switch one
 * off (see SettingsFragmentFirst); a release build follows what the user chose, all of them off
 * by default as in res/xml/launcher_preferences.xml.
 */
public final class LogcatSettings {

    private LogcatSettings() {}

    /** Keys.LOGCAT_SERVICE: a capture at the launcher's start. */
    public static boolean captureAtStart(SharedPreferences p) {
        return effective(isForced(), p.getBoolean(Keys.LOGCAT_SERVICE, false));
    }

    /** Keys.LOGCAT_SERVICE_WAKE: a capture at a wake from sleep. */
    public static boolean captureAtWake(SharedPreferences p) {
        return effective(isForced(), p.getBoolean(Keys.LOGCAT_SERVICE_WAKE, false));
    }

    /** Keys.LOGCAT_FULL: the whole log, through the VD host where the launcher is no system app. */
    public static boolean fullLog(SharedPreferences p) {
        return effective(isForced(), p.getBoolean(Keys.LOGCAT_FULL, false));
    }

    /** Keys.BOOT_LOGCAT: the capture of a cold start reaches back to the boot (with fullLog). */
    public static boolean bootLog(SharedPreferences p) {
        return effective(isForced(), p.getBoolean(Keys.BOOT_LOGCAT, false));
    }

    /** Whether the build decides the settings: debug, where they are all on and fixed. */
    public static boolean isForced() {
        return BuildConfig.DEBUG;
    }

    /** What a setting comes to: the build's choice when it forces them, else the stored one. */
    static boolean effective(boolean forced, boolean stored) {
        return forced || stored;
    }
}
