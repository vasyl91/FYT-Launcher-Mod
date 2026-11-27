package com.android.launcher66;

/**
 * Whether the app drawer can be reached, and when "Swipe up to open the app drawer" is forced on.
 *
 * <p>The rule: the drawer must always have a way to be opened. Its button is on the horizontal bar; when that bar
 * is not displayed or has no drawer button, the swipe up is the way, so it is on and cannot be turned off
 * ({@link #swipeUpRequired}); the setting's stored value is kept, the launcher uses the stored value or the
 * requirement. Pure Java, so that it has a test.
 */
public final class DrawerAccess {

    private DrawerAccess() {
    }

    /** The swipe up is the only way to the drawer: no horizontal bar, or the bar without its button. */
    public static boolean swipeUpRequired(boolean displayHorizontalBar, boolean drawerButtonHidden) {
        return !displayHorizontalBar || drawerButtonHidden;
    }

    /** What the launcher does: the setting's value, or the requirement. */
    public static boolean swipeUpActive(boolean stored, boolean displayHorizontalBar, boolean drawerButtonHidden) {
        return stored || swipeUpRequired(displayHorizontalBar, drawerButtonHidden);
    }
}
