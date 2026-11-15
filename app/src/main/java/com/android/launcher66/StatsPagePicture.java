package com.android.launcher66;

/**
 * The fuel statistics of the home screen while the pages move, on Android 10 and older: a picture of them in
 * their page in place of their window.
 *
 * <p>The statistics are a window over the launcher, moved with the pages by a new position in every frame.
 * On the Android 10 units the window arrives a frame after the page, so while the pages move the statistics
 * trail behind their place (three earlier attempts to make the window keep up did not hold, the last one by
 * moving its surface directly; the owner took that one back). A picture that is a child of the page cannot
 * trail: it is drawn with the page.
 *
 * <p>The rule: while the pages move in the normal state, the page of the statistics shows a picture of them
 * where their window is, and the window is made invisible; it goes on being moved, so that it is in its
 * place when the pages stop. Then the window is shown again and the picture taken away a moment later. At
 * both ends the two are in the same place for a moment rather than neither, so nothing blinks. The window's
 * content, its place and its rule (D-16: only the bars move it, it takes no touch) are untouched; only what
 * is seen during a move changes. It is used where the trailing is: up to Android 10. Newer versions move
 * the window in step with the pages and keep it. Pure Java, so that it has a test.
 */
public final class StatsPagePicture {

    /** Android 10: the last version on which the window trails behind the pages. */
    static final int LAST_TRAILING_SDK = 29;

    /** How long the picture stays after the window is shown again, so that they overlap and nothing blinks. */
    public static final long OVERLAP_MS = 80L;

    /** A picture left up this long after its move began is taken away whatever happened to the move. */
    public static final long GIVE_UP_MS = 4000L;

    private StatsPagePicture() {
    }

    /**
     * @param sdk         Build.VERSION.SDK_INT
     * @param normalState the pages are at full size and nothing is dragged
     * @param shownOnHome the home screen's statistics window is shown
     */
    public static boolean applies(int sdk, boolean normalState, boolean shownOnHome) {
        return sdk <= LAST_TRAILING_SDK && normalState && shownOnHome;
    }

    /**
     * Where the picture lies in its page: {left, top, right, bottom}.
     *
     * @param xOnPage         the left edge of the statistics in their page
     * @param yOnScreen       their top edge on the screen
     * @param pageTopOnScreen the top edge of the page on the screen
     */
    public static int[] rectOnPage(int xOnPage, int yOnScreen, int pageTopOnScreen, int width, int height) {
        int top = yOnScreen - pageTopOnScreen;
        return new int[] {xOnPage, top, xOnPage + width, top + height};
    }
}
