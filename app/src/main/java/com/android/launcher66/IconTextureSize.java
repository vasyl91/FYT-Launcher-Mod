package com.android.launcher66;

/**
 * The size of an icon's bitmap when the launcher activity has not set it yet.
 *
 * <p>The rule: a texture is never 0 or negative pixels wide. {@code Launcher.app_icon_size} is
 * calculated by the launcher activity; in a process that was started for a broadcast alone it is 0, and
 * {@code Bitmap.createBitmap} then throws "width and height must be &gt; 0". The activity's own
 * figure is 6.6 % of the longer side of the screen (its {@code orientationDimension}); the same figure
 * is used until the activity gives its own. Plain Java, so a JUnit test covers it.
 */
public final class IconTextureSize {
    /** The activity's share of the longer side of the screen for an app icon, in percent. */
    static final double APP_ICON_PERCENT = 6.6;

    private IconTextureSize() {
    }

    /** {@code width} when it is a real size, else {@code fallback}; never less than 1. */
    public static int or(int width, int fallback) {
        if (width > 0) {
            return width;
        }
        return Math.max(1, fallback);
    }

    /** The activity's app icon size computed from a screen's size in pixels. */
    public static int fallbackPx(int screenWidthPx, int screenHeightPx) {
        int longer = Math.max(screenWidthPx, screenHeightPx);
        return Math.max(1, (int) (APP_ICON_PERCENT / 100.0 * longer));
    }
}
