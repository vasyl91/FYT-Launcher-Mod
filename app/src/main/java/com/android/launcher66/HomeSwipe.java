package com.android.launcher66;

/**
 * The course of one touch on the home screen as a swipe up or down ({@link HomeGestures}): when it becomes a gesture,
 * when it fires, and when it can no longer be one.
 *
 * <p>The rules (the owner on the A55, 2026-11-27: a swipe down sometimes fired during a long press, and the drawer came
 * only when the finger was lifted):
 * <ul>
 *   <li>A touch is armed when it goes down where a gesture may start ({@link HomeGesture#mayStart}) and a gesture is
 *       on. It is disarmed for good by {@link #cancel()} (a drag began) and when the long press timeout has passed
 *       before the touch became a gesture: by then the touch is a long press, of an icon (a drag) or of the
 *       empty space (the overview), and a move after it is not a swipe.</li>
 *   <li>It becomes a gesture ({@link Step#TAKE}) when it has moved past the touch slop and steeper than
 *       {@link HomeGesture#MIN_ANGLE_DEG}, before the long press timeout.</li>
 *   <li>It fires as soon as it is long enough, on the move that reaches {@link HomeGesture#MIN_DISTANCE_SHARE} of the
 *       screen's shorter side, in a direction whose setting is on; not when the finger is lifted. A short fast flick
 *       fires when the finger is lifted, by its speed ({@link HomeGesture#classify}).</li>
 *   <li>It fires once per touch; the rest of the touch is still the gesture's, so the pages do not move.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class HomeSwipe {

    /** What a step of the touch did. */
    enum Step { NONE, TAKE, UP, DOWN }

    private final int mSlopPx;
    private final long mLongPressMs;

    private boolean mArmed;
    private boolean mTaking;
    private boolean mFired;
    private boolean mUpOn;
    private boolean mDownOn;
    private long mDownTime;
    private float mDownX;
    private float mDownY;
    private int mShortSidePx;

    HomeSwipe(int slopPx, long longPressMs) {
        mSlopPx = slopPx;
        mLongPressMs = longPressMs;
    }

    /** The touch went down; {@code armed} says whether a gesture may start there at all. */
    void down(long time, float x, float y, boolean armed, boolean upOn, boolean downOn, int shortSidePx) {
        mArmed = armed && (upOn || downOn);
        mTaking = false;
        mFired = false;
        mUpOn = upOn;
        mDownOn = downOn;
        mDownTime = time;
        mDownX = x;
        mDownY = y;
        mShortSidePx = shortSidePx;
    }

    /** A move: {@link Step#TAKE} when the touch becomes a gesture, UP or DOWN when it fires, else NONE. */
    Step move(long time, float x, float y) {
        float dx = x - mDownX;
        float dy = y - mDownY;
        if (!mTaking) {
            if (!mArmed) {
                return Step.NONE;
            }
            if (time - mDownTime >= mLongPressMs) {
                // A long press by now: not a swipe for the rest of this touch
                mArmed = false;
                return Step.NONE;
            }
            if (Math.abs(dy) > mSlopPx && HomeGesture.steep(dx, dy)) {
                mTaking = true;
                Step fired = fire(HomeGesture.classify(dx, dy, mShortSidePx, 0f));
                return fired == Step.NONE ? Step.TAKE : fired;
            }
            return Step.NONE;
        }
        return fire(HomeGesture.classify(dx, dy, mShortSidePx, 0f));
    }

    /** The finger is lifted: UP or DOWN when a short fast flick fires now, else NONE. */
    Step up(float x, float y, float speedDpPerS) {
        Step step = Step.NONE;
        if (mTaking) {
            step = fire(HomeGesture.classify(x - mDownX, y - mDownY, mShortSidePx, speedDpPerS));
        }
        reset();
        return step;
    }

    /** The touch can no longer be a gesture: a drag began, or it was cancelled. */
    void cancel() {
        reset();
    }

    /** Whether the touch is a gesture now (the pages leave it alone). */
    boolean taking() {
        return mTaking;
    }

    /** Whether the touch may still become a gesture. */
    boolean armed() {
        return mArmed;
    }

    /** Whether it has fired in this touch. */
    boolean fired() {
        return mFired;
    }

    /** The move from the touch down, for the log. */
    float dy(float y) {
        return y - mDownY;
    }

    private Step fire(HomeGesture.Result result) {
        if (mFired || !HomeGesture.wanted(result, mUpOn, mDownOn)) {
            return Step.NONE;
        }
        mFired = true;
        return result == HomeGesture.Result.UP ? Step.UP : Step.DOWN;
    }

    private void reset() {
        mArmed = false;
        mTaking = false;
    }
}
