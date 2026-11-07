package com.android.launcher66.settings;

/**
 * Where a double tap in a layout creator really hides the creator's bar. The tap and the hint that
 * tells the user about it ask this one rule, so the hint is never shown where the tap does nothing.
 */
public final class CreatorBarToggle {

    private CreatorBarToggle() {
    }

    /**
     * @param firstScreen whether this is the creator of the first page
     * @param autoHide    "Auto-hide horizontal bar"
     * @param everyPage   "Horizontal bar on every page"
     * @return true when a double tap shows or hides the bar. The first page toggles it only with
     *         auto-hide, because without it the real bar takes the strip. The other pages also
     *         toggle it without the bar on every page, because then nothing takes the strip there.
     */
    public static boolean canToggle(boolean firstScreen, boolean autoHide, boolean everyPage) {
        if (firstScreen) return autoHide;
        return autoHide || !everyPage;
    }
}
