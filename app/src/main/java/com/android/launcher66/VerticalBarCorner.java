package com.android.launcher66;

/**
 * The corner of the vertical bar on every page when the horizontal bar is on the first page only: on the first
 * page the horizontal bar takes the corner and the vertical bar ends at it, on the other pages the vertical bar
 * has the whole height. Free of android.* so that the rules can be tested.
 *
 * <p>The rule: the vertical bar's window keeps the whole height on every page, and its bar leaves the corner
 * free (an inset of the corner's height, transparent, its touches handed to the launcher's window below) for as
 * long as the first page's horizontal bar lies across the vertical bar's strip. As soon as that bar has moved
 * off the strip the vertical bar grows into the corner, and as soon as it moves onto the strip again the bar
 * gives the corner back, each in a short animation while the pages move. Until 2026-11-16 the window took the
 * other page's frame only when the pages came to rest, and the bar jumped by the corner's height at the end of
 * the swipe (the owner, on the A55). Changing the height of the bar inside the window, not the window's, needs
 * no relayout of the window while the pages move.
 */
final class VerticalBarCorner {

    private VerticalBarCorner() {
    }

    /**
     * Whether the rule applies: the vertical bar on every page, the horizontal bar on the first page only and not
     * the auto-hide one (that has its own corner, the collapsed bar's button), in the user layout.
     */
    static boolean applies(boolean verticalBar, boolean verticalEveryPage, boolean horizontalEveryPage,
                           boolean autoHide, boolean userLayout) {
        return applies(verticalBar, verticalEveryPage, horizontalEveryPage, autoHide, userLayout, true);
    }

    /**
     * The same, with "Display horizontal bar": without the horizontal bar there is no corner to leave to it, and the
     * vertical bar has the whole height on every page (the owner on the A55, 2026-11-27: with the bar off the vertical
     * bar still kept its corner).
     */
    static boolean applies(boolean verticalBar, boolean verticalEveryPage, boolean horizontalEveryPage,
                           boolean autoHide, boolean userLayout, boolean horizontalDisplayed) {
        return horizontalDisplayed && userLayout && verticalBar && verticalEveryPage && !horizontalEveryPage && !autoHide;
    }

    /**
     * How far the first page lies from where it rests, on the screen: negative while it moves away to the left.
     *
     * @param firstPageScroll the scroll at which the pages rest on the first page
     * @param scroll          the scroll now
     */
    static int shift(int firstPageScroll, int scroll) {
        return firstPageScroll - scroll;
    }

    /**
     * Whether the first page's horizontal bar lies across the vertical bar's strip. Edges that only touch do not.
     *
     * @param horizontalLeft  the horizontal bar's left edge on the screen now (its place at rest plus the shift)
     * @param horizontalRight its right edge
     * @param barLeft         the vertical bar's left edge on the screen
     * @param barRight        its right edge
     */
    static boolean covered(int horizontalLeft, int horizontalRight, int barLeft, int barRight) {
        return horizontalLeft < barRight && horizontalRight > barLeft;
    }

    /** The corner's height: what the vertical bar is shorter on the first page than on the others. */
    static int inset(int heightOnOtherPages, int heightOnFirstPage) {
        return Math.max(0, heightOnOtherPages - heightOnFirstPage);
    }
}
