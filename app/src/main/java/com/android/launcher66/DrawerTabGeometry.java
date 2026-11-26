package com.android.launcher66;

/**
 * The measures and decisions of the drawer's strip of tabs ({@link DrawerTabStrip}) and of the swipes that change the
 * tab, without anything of Android, so that they have a test.
 *
 * <p>The rules (the owner's, 2026-11-25):
 * <ul>
 *   <li>The strip is 14% of the shorter side of the screen high. At most 2 tabs show side by side in portrait, 4 in
 *       landscape; a tab is that part of the bar wide (with fewer tabs than that the tabs share the bar, so that two tabs
 *       are not squeezed to a quarter each). More tabs scroll the bar sideways; scrolling changes no selection.</li>
 *   <li>The underline of the selected tab is 80% of the tab, centred, and moves smoothly: it is drawn at a
 *       <i>position</i> that is the tab's index, and in between while a page is dragged.</li>
 *   <li>A swipe on the list changes the tab when it is longer than 25% of the width or a fling in the same direction. A
 *       finger that goes left shows the next tab. Nothing happens past the first or the last tab.</li>
 * </ul>
 */
public final class DrawerTabGeometry {

    /** The strip's height as a part of the shorter side of the screen. */
    public static final float HEIGHT_SHARE = 0.14f;
    /** The underline's width as a part of the tab's. */
    public static final float UNDERLINE_SHARE = 0.8f;
    /** How far a swipe must go, as a part of the width, to change the tab. */
    public static final float SWIPE_SHARE = 0.25f;

    private DrawerTabGeometry() {
    }

    /** How many tabs show side by side at most. */
    public static int visibleTabs(boolean portrait) {
        return portrait ? 2 : 4;
    }

    public static int stripHeight(int screenWidth, int screenHeight) {
        return Math.round(Math.min(screenWidth, screenHeight) * HEIGHT_SHARE);
    }

    /** One tab's width: the bar shared by the tabs that show, at most {@link #visibleTabs} of them. */
    public static int tabWidth(int barWidth, int count, boolean portrait) {
        int shown = Math.max(1, Math.min(count, visibleTabs(portrait)));
        return barWidth / shown;
    }

    /** The left edge of the underline when the selection is at {@code position} (a tab's index, or between two). */
    public static float underlineLeft(float position, int tabWidth) {
        return position * tabWidth + tabWidth * (1f - UNDERLINE_SHARE) / 2f;
    }

    public static float underlineWidth(int tabWidth) {
        return tabWidth * UNDERLINE_SHARE;
    }

    /** The position kept between the first tab and the last. */
    public static float clampPosition(float position, int count) {
        return Math.max(0f, Math.min(position, Math.max(0, count - 1)));
    }

    /**
     * Where the bar is scrolled so that a tab is whole in it: as it is when the tab shows already, else by the least
     * that shows it.
     */
    public static int scrollToShow(int index, int tabWidth, int scrollX, int barWidth, int count) {
        int left = index * tabWidth;
        int right = left + tabWidth;
        int max = Math.max(0, count * tabWidth - barWidth);
        int target = scrollX;
        if (left < scrollX) {
            target = left;
        } else if (right > scrollX + barWidth) {
            target = right - barWidth;
        }
        return Math.max(0, Math.min(target, max));
    }

    /** Whether a drag has become a sideways one: farther than the slop and clearly more sideways than up or down. */
    public static boolean sideways(float dx, float dy, float slop) {
        return Math.abs(dx) > slop && Math.abs(dx) > 2f * Math.abs(dy);
    }

    /**
     * What a swipe of {@code dx} (the finger's way, positive to the right) at the speed {@code vx} does:
     * {@code +1} the next tab, {@code -1} the previous one, {@code 0} nothing (it was too short, or it was flicked back).
     */
    public static int swipeDirection(float dx, float vx, int width, float flingMin) {
        boolean far = Math.abs(dx) > width * SWIPE_SHARE;
        boolean fast = Math.abs(vx) > flingMin;
        boolean sameWay = dx == 0f || vx == 0f || (dx > 0f) == (vx > 0f);
        float way;
        if (far && (!fast || sameWay)) {
            way = dx;
        } else if (fast && sameWay && dx != 0f) {
            way = dx;
        } else {
            return 0;
        }
        return way < 0f ? 1 : -1;
    }

    /** The tab a swipe leads to, or {@code current} when there is none that way. */
    public static int target(int current, int direction, int count) {
        int next = current + direction;
        return next < 0 || next >= count ? current : next;
    }
}
