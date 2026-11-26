package com.android.launcher66;

/**
 * Puts a window back where it was put when the system has moved it, and says how far.
 *
 * <p>The rule: a floating window that lies elsewhere than it was put is moved by the difference, measured
 * again after every layout of the window and after every move, never once for all. On the A55 (log of
 * 2026-11-24 15:43) the window of the vertical bar lay one bar's width inside the screen from the first page's
 * swipe until a restart, because it was checked only once, after its first layout. The correction is
 * counted from the position the system reports, so it is not added to the last one twice: a report equal to
 * the one the last correction started from means the system has not applied that correction yet, and
 * the check waits for the next report. At most {@link #MAX_ATTEMPTS} corrections are made for one frame, so
 * a system that keeps the window elsewhere does not start a loop. Pure Java, so that it has a test.
 */
final class WindowPlacement {

    /** The difference in pixels that is no difference (rounding of the position). */
    static final int TOLERANCE_PX = 1;
    /** Corrections made for one frame before the check gives up. */
    static final int MAX_ATTEMPTS = 5;

    private boolean mHasStale;
    private int mStaleX;
    private int mStaleY;
    private int mAttempts;

    /**
     * What to add to the window's parameters, {x offset, y}, so that the window lies at the expected place, or
     * null when nothing is to be done (it lies there, the last correction has not been applied yet, or the
     * attempts are used up).
     *
     * @param measuredX  the window's left edge on the screen, as the system reports it
     * @param measuredY  its top edge
     * @param expectedX  the left edge it was put at
     * @param expectedY  the top edge it was put at
     * @param right      whether the window's x is the distance from the right edge of the screen (gravity RIGHT),
     *                   which changes the sign of a shift to the right
     */
    int[] check(int measuredX, int measuredY, int expectedX, int expectedY, boolean right) {
        int dx = expectedX - measuredX;
        int dy = expectedY - measuredY;
        boolean offX = Math.abs(dx) > TOLERANCE_PX;
        boolean offY = Math.abs(dy) > TOLERANCE_PX;
        if (!offX && !offY) {
            mAttempts = 0;
            mHasStale = false;
            return null;
        }
        if (mHasStale && mStaleX == measuredX && mStaleY == measuredY) {
            return null;
        }
        if (mAttempts >= MAX_ATTEMPTS) {
            return null;
        }
        mAttempts++;
        mHasStale = true;
        mStaleX = measuredX;
        mStaleY = measuredY;
        return new int[] {offX ? (right ? -dx : dx) : 0, offY ? dy : 0};
    }

    /** A new frame was put: the old attempts and the old report mean nothing for it. */
    void frameChanged() {
        mAttempts = 0;
        mHasStale = false;
    }

    /** Corrections made for the current frame, for the log. */
    int attempts() {
        return mAttempts;
    }
}
