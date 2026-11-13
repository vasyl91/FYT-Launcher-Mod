package com.android.launcher66;

/**
 * Where the window of the vertical bar lies on the screen. The bar of the first page is a view of that page's
 * layout and has an exact rectangle there; the window that shows the same bar on the other pages must lie on that
 * rectangle, on the same side, whatever the bar layout's arithmetic gives. So the horizontal place and the width
 * come from the measured bar of the first page when it is known, and from {@link BarLayout} only before the
 * first measurement. The vertical place and the height always come from the layout (they depend on the page the
 * window is for: whether it has the horizontal bar and the button).
 *
 * <p>A measurement is trusted only while it lies inside the box of the page: a bar measured outside it is not
 * where any page's bar can be (a wrong reference once gave x = -3582 on a 1080 px screen), and then the layout
 * decides as before the first measurement. Pure Java, so that it has a test.
 */
final class VerticalWindowFrame {

    /** {x, y, w, h} on the screen. */
    static final class Frame {
        final int x;
        final int y;
        final int w;
        final int h;

        Frame(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        int[] toArray() {
            return new int[] {x, y, w, h};
        }
    }

    private VerticalWindowFrame() {
    }

    /**
     * @param pageBar      {left, right} of the first page's vertical bar on the screen, as if that page were shown,
     *                     or null before it was measured
     * @param band         {left, top, right, bottom} of the window from BarLayout.verticalWindow(), in the box
     * @param boxLeft      the box's left edge on the screen
     * @param boxTop       the box's top edge on the screen
     * @param boxRight     the box's right edge on the screen
     */
    static Frame of(int[] pageBar, int[] band, int boxLeft, int boxTop, int boxRight) {
        int y = boxTop + band[1];
        int h = band[3] - band[1];
        if (trusted(pageBar, boxLeft, boxRight)) {
            return new Frame(pageBar[0], y, pageBar[1] - pageBar[0], h);
        }
        return new Frame(boxLeft + band[0], y, band[2] - band[0], h);
    }

    /** Whether the measured bar is a bar of a page in this box: not empty, and inside the box (a pixel of slack). */
    static boolean trusted(int[] pageBar, int boxLeft, int boxRight) {
        return pageBar != null && pageBar[1] > pageBar[0]
                && pageBar[0] >= boxLeft - 1 && pageBar[1] <= boxRight + 1;
    }

    /**
     * The x of a window placed with gravity TOP | LEFT (from the left edge) or TOP | RIGHT (from the right edge).
     * Measured from the edge the bar is on, so that the side is kept even if the other edge's arithmetic is off.
     */
    static int offset(Frame frame, int displayWidth, boolean right) {
        return right ? Math.max(0, displayWidth - (frame.x + frame.w)) : frame.x;
    }
}
