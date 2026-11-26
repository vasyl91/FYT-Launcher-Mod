package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.core.content.ContextCompat;

import com.android.launcher66.settings.Keys;

/**
 * The colour of the names under the icons of the home screen, of the folders' icons and of the bars' icons that are
 * {@code BubbleTextView}s.
 *
 * <p>The rule (the owner, 2026-11-25): "Set icon text color" is a creator setting. With the creator on and a colour
 * chosen the names have it; without one, or with "Stock layout", they are white, as the layouts and
 * {@code R.color.workspace_icon_text_color} give them ({@link CreatorPrefs}). The colour is opaque. The names of the
 * apps in an open folder keep their own colour unless the folders have a background of their own (D4).
 */
final class IconTextColor {

    private IconTextColor() {
    }

    /** The colour of the names on the home screen's icons now. */
    static int workspace(SharedPreferences prefs, Context context) {
        int white = ContextCompat.getColor(context, R.color.workspace_icon_text_color);
        return resolve(CreatorPrefs.of(prefs), white);
    }

    /** The chosen colour, opaque, or {@code white} when there is none or the creator is off. */
    static int resolve(CreatorPrefs prefs, int white) {
        return resolve(prefs, Keys.WORKSPACE_TEXT_COLOR, white);
    }

    /** The colour of the names under the app drawer's icons ("App drawer": "Set icon text color"), white without one. */
    static int drawer(SharedPreferences prefs, int white) {
        return resolve(CreatorPrefs.of(prefs), Keys.ALL_APPS_TEXT_COLOR, white);
    }

    /** The colour stored under {@code key}, opaque, or {@code white} when there is none or the creator is off. */
    static int resolve(CreatorPrefs prefs, String key, int white) {
        if (!prefs.contains(key)) {
            return white;
        }
        return 0xff000000 | prefs.getInt(key, white);
    }
}
