package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

/**
 * How the notification badges look now: whether they are shown, the corner, the size, the radius, the colour of the
 * badge (the settings' accent while none was chosen) and whether it has an outline. Read from the preferences
 * ({@link BadgeModel} keeps one and makes it again when a setting changes). These are the launcher's own settings, not the
 * creator's, so "Stock layout" does not turn them off.
 */
final class BadgeStyle {

    static final int DEFAULT_CORNER = 50;

    final boolean enabled;
    final BadgeGeometry.Position position;
    final BadgeGeometry.Size size;
    final int corner;
    final int color;
    final boolean outline;

    BadgeStyle(boolean enabled, BadgeGeometry.Position position, BadgeGeometry.Size size, int corner, int color,
               boolean outline) {
        this.enabled = enabled;
        this.position = position;
        this.size = size;
        this.corner = Math.max(0, Math.min(100, corner));
        this.color = color;
        this.outline = outline;
    }

    static BadgeStyle load(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int color = prefs.contains(Keys.BADGES_COLOR) ? (0xff000000 | prefs.getInt(Keys.BADGES_COLOR, 0))
                : ThemeAccent.color(context);
        return new BadgeStyle(prefs.getBoolean(Keys.BADGES_ENABLED, true),
                BadgeGeometry.Position.parse(prefs.getString(Keys.BADGES_POSITION, "top_right")),
                BadgeGeometry.Size.parse(prefs.getString(Keys.BADGES_SIZE, "medium")),
                prefs.getInt(Keys.BADGES_CORNER, DEFAULT_CORNER), color, prefs.getBoolean(Keys.BADGES_OUTLINE, false));
    }

    /** Whether a key is one of the badge settings. */
    static boolean isBadgeSetting(String key) {
        return Keys.BADGES_ENABLED.equals(key) || Keys.BADGES_POSITION.equals(key) || Keys.BADGES_SIZE.equals(key)
                || Keys.BADGES_CORNER.equals(key) || Keys.BADGES_COLOR.equals(key) || Keys.BADGES_OUTLINE.equals(key)
                || ThemeAccent.KEY.equals(key) || Keys.USER_LAYOUT.equals(key);
    }
}
