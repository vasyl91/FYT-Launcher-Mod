package com.android.launcher66.settings;

import android.content.Context;

import com.android.launcher66.R;

/**
 * What the four logcat settings (Keys.LOGCAT_SERVICE, LOGCAT_SERVICE_WAKE, LOGCAT_FULL and
 * BOOT_LOGCAT) are until the user changes them: off in a release build, on in a debug build.
 *
 * <p>launcher_preferences.xml and the code read the same resource, so they cannot disagree. The
 * XML default only reaches the preferences file when the settings screen is first shown, and
 * until then the code's own default decides, which is why every read of these keys passes on().
 * A stored value always wins; nothing is forced.
 */
public final class LogcatDefaults {
    private LogcatDefaults() { throw new AssertionError("No instances."); }

    public static boolean on(Context context) {
        return context.getResources().getBoolean(R.bool.logcat_on_by_default);
    }
}
