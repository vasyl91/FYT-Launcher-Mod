package com.android.launcher66;

/**
 * When the launcher lets go of the views of the horizontal bar's widgets (the music widget's buttons, its title
 * and artist, the weather), free of android.* so that it has a test.
 *
 * <p>The rule: the views of a bar whose window stays are kept bound for as long as the window is there. That is
 * the bar on every page without auto-hide: its window lives with the launcher's window (PersistentBarWindow) and
 * nothing builds it again when an app comes and goes. They are let go only when the launcher's window goes. The
 * auto-hide bar's window is removed when an app is opened and bound again when it is shown, so its views are let
 * go then, as before. Until 2026-11-18 every app opened from an icon, the bar, a widget or the settings button
 * let go of the window's views too, and after the return the bar's buttons did nothing visible and its title,
 * artist and weather stayed as they were (the owner, 7862, log of 2026-11-16 18:42).
 */
final class BarViews {

    private BarViews() {
    }

    /**
     * @param autoHide   the horizontal bar hides itself
     * @param everyPage  the horizontal bar is on every page
     * @param widgetBar  the bar has the widgets
     * @param windowGone the launcher's window goes (the activity is destroyed)
     */
    static boolean release(boolean autoHide, boolean everyPage, boolean widgetBar, boolean windowGone) {
        if (!widgetBar || !(autoHide || everyPage)) {
            return false;   // the first page's own bar: its views live with the page
        }
        boolean windowStays = everyPage && !autoHide;
        return !windowStays || windowGone;
    }
}
