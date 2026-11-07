package com.android.launcher66;

/**
 * Width of the window of the auto-hide edge handle. Pure, so that the rule has a test.
 */
final class EdgeHandleGeometry {

    private EdgeHandleGeometry() {
    }

    /**
     * @param stripWidth   width of the visible strip
     * @param verticalBarWidth width of the vertical bar for the current orientation, computed as a share of
     *                     the screen like the bar itself (7.1 %)
     * @return the width of the window that catches the swipe: as wide as the vertical bar, so that the
     *         swipe starts where the bar would be, and never narrower than the visible strip
     */
    static int touchWidth(int stripWidth, float verticalBarWidth) {
        return Math.max(stripWidth, Math.round(verticalBarWidth));
    }
}
