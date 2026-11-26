package com.android.launcher66;

import android.content.SharedPreferences;

import com.android.launcher66.settings.Keys;

/**
 * The "Layout creator" switch ({@link Keys#USER_LAYOUT}) kept in a field the touch code can read at any time.
 *
 * <p>The rule: nothing that runs on a touch reads the preferences, and nothing that runs on a touch can find the
 * switch missing. {@code Workspace.determineScrollingStart} used to ask {@code mPrefs}, which was set only
 * when the first page was built, so a touch in the first second after a start (the A55 crash log, uptime 1.3 s)
 * threw a NullPointerException. The flag reads the value when it is made (the preference file is already
 * in memory: {@code LauncherApplication.attachBaseContext} loads it), follows every change of the key through a
 * listener, and {@link #refresh()} reads it again when a page is built. The preferences hold a listener weakly,
 * so the owner must keep this object in a field.
 */
final class UserLayoutFlag implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final SharedPreferences mPrefs;
    private volatile boolean mValue;

    UserLayoutFlag(SharedPreferences prefs) {
        mPrefs = prefs;
        mValue = prefs.getBoolean(Keys.USER_LAYOUT, false);
        prefs.registerOnSharedPreferenceChangeListener(this);
    }

    /** The switch as it was last read or changed. */
    boolean get() {
        return mValue;
    }

    /** Reads the switch again, for a page that is being built. */
    void refresh() {
        mValue = mPrefs.getBoolean(Keys.USER_LAYOUT, false);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        // A null key means the preferences were cleared (API 30+).
        if (key == null || Keys.USER_LAYOUT.equals(key)) {
            mValue = prefs.getBoolean(Keys.USER_LAYOUT, false);
        }
    }
}
