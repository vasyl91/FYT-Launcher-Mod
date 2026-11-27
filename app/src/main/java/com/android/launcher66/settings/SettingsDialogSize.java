package com.android.launcher66.settings;

/**
 * The size of the settings' larger dialogs: the background selector, the colour picker and the lists of apps (the
 * apps of the PiPs, of "Start on boot" / "Start on wake", of the statistics, of the cache), as shares of the window.
 *
 * <p>The rules (the owner, 2026-11-27):
 * <ul>
 *   <li>Landscape: all of them as large as each other, as wide as the colour picker was (0.7 of the width) and as high
 *       as the background selector now is (0.9 of the height, taller than its 0.8).</li>
 *   <li>Portrait: all of them as wide as the background selector (0.8 of the width); their heights stay as they were:
 *       the background selector 0.8, the colour picker 0.6, the lists of apps 0.9364 of the height.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
public final class SettingsDialogSize {

    public enum Kind { BACKGROUND, COLOR_PICKER, APP_LIST }

    static final float LANDSCAPE_WIDTH = 0.7f;
    static final float LANDSCAPE_HEIGHT = 0.9f;
    static final float PORTRAIT_WIDTH = 0.8f;

    private SettingsDialogSize() {
    }

    /** {width, height} as shares of the window. */
    public static float[] shares(Kind kind, boolean landscape) {
        if (landscape) {
            return new float[] {LANDSCAPE_WIDTH, LANDSCAPE_HEIGHT};
        }
        switch (kind) {
            case COLOR_PICKER:
                return new float[] {PORTRAIT_WIDTH, 0.6f};
            case APP_LIST:
                return new float[] {PORTRAIT_WIDTH, 0.9364f};
            case BACKGROUND:
            default:
                return new float[] {PORTRAIT_WIDTH, 0.8f};
        }
    }

    /** {width, height} in pixels for a window of this size; landscape when it is wider than high. */
    public static int[] pixels(Kind kind, int windowWidth, int windowHeight) {
        float[] share = shares(kind, windowWidth > windowHeight);
        return new int[] {Math.round(windowWidth * share[0]), Math.round(windowHeight * share[1])};
    }
}
