package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.android.launcher66.BackgroundChoice;
import com.android.launcher66.ThemeAccent;
import com.android.launcher66.colorpicker.ColorPicker;

/**
 * Where a colour picker of the settings stores its colour: one place for a picker that is opened and for one the
 * settings bring back after a turn of the screen.
 *
 * <p>The rule (the owner, 2026-11-21): <b>"Select" (and "Default") store what they stored before the turn.</b> The
 * picker is a DialogFragment, so the FragmentManager creates it again after a turn, from its arguments; its callbacks
 * are not among them and were lost, so "Select" stored nothing after a turn. A picker is now bound by one of the
 * {@code bind…} methods, which also put where its colour goes into its arguments ({@link ColorPicker#storesUnder}),
 * and {@link #rebind} binds the pickers that came back the same way. Each kind has its tag in the FragmentManager.
 */
final class ColorPickerTargets {

    private static final String TAG = "ColorPickerTargets";

    /** "Statistics text color". */
    static final String TAG_STATS = "ColorPicker";
    /** "Widget text and button color" / "Horizontal bar text and button color". */
    static final String TAG_TINT = "TintPicker";
    /** "Set icon text color": the names under the icons (IconTextColor). */
    static final String TAG_ICON_TEXT = "IconTextPicker";
    /** "Set global theme color": the accent of the settings (ThemeAccent). */
    static final String TAG_ACCENT = "AccentPicker";
    /** "Badge color": the notification badges (BadgeStyle). */
    static final String TAG_BADGE = "BadgePicker";
    /** A background's own colour, from the background selector. */
    static final String TAG_BACKGROUND = "BackgroundColorPicker";

    private static final String STATS_COLOR = "stats_color";

    private ColorPickerTargets() {
    }

    /** "Statistics text color": stored as text under "stats_color", as it always was. */
    static void bindStats(ColorPicker picker, SharedPreferences prefs) {
        picker.storesUnder(STATS_COLOR, null);
        picker.setCallback(color -> prefs.edit()
                .putString(STATS_COLOR, String.format("#%06X", (0xFFFFFF & color)))
                .apply());
    }

    /** A tint: "Select" stores the opaque colour, "Default" forgets it (the views get their own look back). */
    static void bindTint(ColorPicker picker, SharedPreferences prefs, String colorKey) {
        picker.storesUnder(colorKey, null);
        picker.setCallback(color -> prefs.edit().putInt(colorKey, 0xFF000000 | color).apply());
        picker.setDefaultCallback(() -> prefs.edit().remove(colorKey).apply());
    }

    /**
     * The accent of the settings: "Select" stores the opaque colour, "Default" forgets it (the blue comes back). Whatever
     * shows the accent follows the stored colour through a preference listener, so that a picker brought back after a turn of
     * the screen needs nothing more than this (SettingsFragmentSecond.bindAccentChange).
     */
    static void bindAccent(ColorPicker picker, SharedPreferences prefs) {
        bindTint(picker, prefs, ThemeAccent.KEY);
    }

    /** A background's own colour: the colour with its transparency, and the choice of an own colour. */
    static void bindBackground(ColorPicker picker, Context app, String colorKey, String choiceKey) {
        picker.storesUnder(colorKey, choiceKey);
        picker.setCallback(color -> {
            PreferenceManager.getDefaultSharedPreferences(app).edit()
                    .putInt(colorKey, color)
                    .putString(choiceKey, BackgroundChoice.CUSTOM)
                    .apply();
            Log.i(TAG, "Own background colour stored under " + colorKey + ": #" + String.format("%08X", color));
        });
    }

    /** The settings were created again: the pickers that came back store their colour as before. */
    static void rebind(FragmentManager fragments, SharedPreferences prefs, Context app) {
        ColorPicker stats = find(fragments, TAG_STATS);
        if (stats != null) {
            bindStats(stats, prefs);
        }
        ColorPicker tint = find(fragments, TAG_TINT);
        if (tint != null && tint.storeKey() != null) {
            bindTint(tint, prefs, tint.storeKey());
        }
        ColorPicker iconText = find(fragments, TAG_ICON_TEXT);
        if (iconText != null && iconText.storeKey() != null) {
            bindTint(iconText, prefs, iconText.storeKey());
        }
        ColorPicker badge = find(fragments, TAG_BADGE);
        if (badge != null) {
            bindTint(badge, prefs, Keys.BADGES_COLOR);
        }
        ColorPicker accent = find(fragments, TAG_ACCENT);
        if (accent != null) {
            bindAccent(accent, prefs);
        }
        ColorPicker background = find(fragments, TAG_BACKGROUND);
        if (background != null && background.storeKey() != null && background.storeExtra() != null) {
            bindBackground(background, app, background.storeKey(), background.storeExtra());
        }
    }

    /** The picker of that tag that is shown; null when none. */
    static ColorPicker find(FragmentManager fragments, String tag) {
        Fragment fragment = fragments.findFragmentByTag(tag);
        return fragment instanceof ColorPicker && fragment.isAdded() && !fragment.isRemoving()
                ? (ColorPicker) fragment : null;
    }
}
