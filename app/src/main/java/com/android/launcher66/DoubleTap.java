package com.android.launcher66;

/**
 * Two taps on empty space of the home screen that make a double tap.
 *
 * <p>The rule: the second tap comes within the system's double tap timeout of the first and within the system's
 * double tap slop of it. A tap on an icon, a widget or an element is no tap here (the caller does not report it).
 * After a double tap the count starts over, so that a third tap is the first of the next pair. Pure Java, so
 * that it has a test; the caller gives it the times and distances of {@code ViewConfiguration}.
 */
final class DoubleTap {

    private long mLastTapMs = -1L;
    private float mLastX;
    private float mLastY;

    /**
     * A tap on empty space ended at {@code x, y} at {@code timeMs}.
     *
     * @param timeoutMs the longest time between the two taps ({@code ViewConfiguration.getDoubleTapTimeout()})
     * @param slopPx    the longest distance between them ({@code getScaledDoubleTapSlop()})
     * @return whether this tap completes a double tap
     */
    boolean onTap(long timeMs, float x, float y, long timeoutMs, float slopPx) {
        boolean second = mLastTapMs >= 0L
                && timeMs >= mLastTapMs
                && timeMs - mLastTapMs <= timeoutMs
                && Math.hypot(x - mLastX, y - mLastY) <= slopPx;
        if (second) {
            mLastTapMs = -1L;
            return true;
        }
        mLastTapMs = timeMs;
        mLastX = x;
        mLastY = y;
        return false;
    }

    /** Forgets the first tap: the touch became something else (a swipe, a long press, a drag). */
    void reset() {
        mLastTapMs = -1L;
    }
}
