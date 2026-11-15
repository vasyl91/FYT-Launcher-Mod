package com.android.launcher66.settings;

/**
 * Which wallpaper the night mode sets for the day or for the night.
 *
 * <p>The rule: the launcher replaces the wallpaper only with a picture that was chosen for it.
 * <ul>
 * <li>"Use the default wallpapers" on: the built-in picture of the mode.</li>
 * <li>Off, and a picture was saved for the mode: that picture.</li>
 * <li>Off, and no picture was saved for the mode (or the saved one cannot be read any more): nothing. The
 * wallpaper stays as it is.</li>
 * </ul>
 * The third case used to set the built-in picture. On a device where the launcher cannot read the wallpaper
 * (Android 13 and later without a privileged host) "Save the day wallpaper" cannot save one, so switching
 * the defaults off there replaced the user's own wallpaper with the built-in one at the next sunrise or
 * sunset, and the user had no way to prevent it. The owner decided on 2026-11-15 that the wallpaper is left
 * alone in that case on every device. Pure Java, so that it has a test.
 */
final class NightWallpaperRule {

    enum Source {
        /** The built-in picture of the mode. */
        DEFAULT,
        /** The picture saved for the mode. */
        FILE,
        /** No change: the wallpaper stays as it is. */
        KEEP
    }

    private NightWallpaperRule() {
    }

    /**
     * @param useDefaults "Use the default wallpapers" is on
     * @param hasPicture  a picture is saved for the mode and can be used
     */
    static Source decide(boolean useDefaults, boolean hasPicture) {
        if (useDefaults) {
            return Source.DEFAULT;
        }
        return hasPicture ? Source.FILE : Source.KEEP;
    }
}
