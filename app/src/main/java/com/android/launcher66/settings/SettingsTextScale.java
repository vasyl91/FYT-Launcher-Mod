package com.android.launcher66.settings;

/**
 * "Settings text size": how large the text of the settings is, from 70 to 150 per cent of what it is now, in steps of
 * 10, 100 by default (the owner, 2026-11-27).
 *
 * <p>The rules:
 * <ul>
 *   <li>It is the first row of "Layout", a slider; a new value is taken when the finger is lifted, and the settings are
 *       made again with it, at the place of the list they were at.</li>
 *   <li>It multiplies the font scale of the settings' activity (SettingsActivity.attachBaseContext, on FYT units and
 *       elsewhere), so every text in sp follows: the rows, the dialogs, the colour picker, the lists of apps.</li>
 *   <li>Not the screens of the creator with their rectangles (CreatorScreen, CreatorAppStats): they are drawn to the
 *       launcher's own scale, so they get a context with the multiplier taken out
 *       (SettingsActivity.withoutTextScale).</li>
 *   <li>A text is never cut: it wraps; a button grows only when its text no longer fits.</li>
 *   <li>At 100 the settings are what they were: nothing is changed in their context.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
public final class SettingsTextScale {

    /** The preference key; an int, per cent. */
    public static final String KEY = "settings_text_scale";
    public static final int MIN = 70;
    public static final int MAX = 150;
    public static final int STEP = 10;
    public static final int DEFAULT = 100;

    private SettingsTextScale() {
    }

    /** A stored or chosen value held to the range, on a step. */
    public static int percent(int value) {
        int v = Math.max(MIN, Math.min(MAX, value));
        return MIN + Math.round((v - MIN) / (float) STEP) * STEP;
    }

    /** The factor for the font scale. */
    public static float factor(int percent) {
        return percent(percent) / 100f;
    }

    /** The slider's place for a value, 0 at {@link #MIN}. */
    public static int progress(int percent) {
        return (percent(percent) - MIN) / STEP;
    }

    /** The value at a place of the slider. */
    public static int fromProgress(int progress) {
        return percent(MIN + progress * STEP);
    }

    /** The slider's last place. */
    public static int maxProgress() {
        return (MAX - MIN) / STEP;
    }
}
