package com.android.launcher66;

/**
 * Where the windows of the horizontal bar at the top lie, from the box the pages fill. A bar at the
 * top that is part of a page starts at the top of that box, below the status bar and the camera
 * cut-out, and does not enter the cut-out at the side. The windows of the auto-hide bar and of its
 * handle must start at the same place, so they take the box and not a fixed offset: the status bar
 * is a different height on every device, and in portrait a fixed zero put them under it.
 *
 * <p>Pure, no android classes: the rules are tested on the JVM.
 */
final class TopBarFrame {

    /** The position and the width of a window that gravity TOP | LEFT places. */
    static final class Overlay {
        final int x;
        final int y;
        final int width;

        Overlay(int x, int y, int width) {
            this.x = x;
            this.y = y;
            this.width = width;
        }
    }

    /** The offsets of a window that gravity TOP | LEFT (x from the left edge) or TOP | RIGHT (x from the right edge) places. */
    static final class Handle {
        final int x;
        final int y;

        Handle(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private TopBarFrame() {
    }

    /** The bar's window: the whole width of the box, from its top. */
    static Overlay overlay(int boxLeft, int boxTop, int boxRight) {
        return new Overlay(boxLeft, boxTop, Math.max(0, boxRight - boxLeft));
    }

    /**
     * The handle's window: x counts from the edge the handle is on, so that it stays out of the
     * cut-out at that side.
     *
     * @param screenWidth width of the display
     * @param right       the handle is on the right edge
     */
    static Handle handle(int boxLeft, int boxTop, int boxRight, int screenWidth, boolean right) {
        int x = right ? Math.max(0, screenWidth - boxRight) : Math.max(0, boxLeft);
        return new Handle(x, boxTop);
    }
}
