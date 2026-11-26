package com.android.launcher66;

/**
 * What a swipe on the home screen is: up (the app drawer), down (the notifications) or nothing.
 *
 * <p>The rules (the owner's, 2026-11-25):
 * <ul>
 *   <li>It is a vertical swipe when it is steeper than {@link #MIN_ANGLE_DEG} from the horizontal. The pages are
 *       swiped sideways, and a swipe that is not clearly vertical stays theirs.</li>
 *   <li>It is long enough when it covers {@link #MIN_DISTANCE_SHARE} of the screen's shorter side, or fast enough
 *       when it goes at {@link #MIN_SPEED_DP_PER_S} dp a second: a short flick counts.</li>
 *   <li>The gesture does not start where something else owns the touch: an app's widget, an element of the user's
 *       layout, the music slider, the overview, the drawer, an open folder, or while an item is dragged
 *       ({@link #mayStart}).</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class HomeGesture {

    enum Result { UP, DOWN, NONE }

    /** The swipe must be steeper than this, in degrees from the horizontal. */
    static final double MIN_ANGLE_DEG = 60.0;
    /** The distance, as a share of the screen's shorter side, that is enough by itself. */
    static final float MIN_DISTANCE_SHARE = 0.12f;
    /** The vertical speed, in dp a second, that is enough by itself. */
    static final float MIN_SPEED_DP_PER_S = 1000f;

    private HomeGesture() {
    }

    /**
     * @param dx            the horizontal move from the touch down to the end, in pixels (right is positive)
     * @param dy            the vertical move (down is positive, as on the screen)
     * @param shortSidePx   the shorter side of the screen
     * @param speedDpPerS   the vertical speed at the end, in dp a second (the sign is ignored)
     */
    static Result classify(float dx, float dy, int shortSidePx, float speedDpPerS) {
        float absY = Math.abs(dy);
        if (!steep(dx, dy)) {
            return Result.NONE;
        }
        boolean far = shortSidePx > 0 && absY >= MIN_DISTANCE_SHARE * shortSidePx;
        boolean fast = Math.abs(speedDpPerS) >= MIN_SPEED_DP_PER_S;
        if (!far && !fast) {
            return Result.NONE;
        }
        return dy < 0f ? Result.UP : Result.DOWN;
    }

    /** Whether a move is steeper than {@link #MIN_ANGLE_DEG} from the horizontal: vertical enough to be a swipe up or down. */
    static boolean steep(float dx, float dy) {
        float absY = Math.abs(dy);
        if (absY == 0f) {
            return false;
        }
        return Math.toDegrees(Math.atan2(absY, Math.abs(dx))) > MIN_ANGLE_DEG;
    }

    /** Whether a swipe that begins here may be a gesture of the home screen at all. */
    static boolean mayStart(boolean onAppWidget, boolean onUserElement, boolean onSlider, boolean overview,
                            boolean drawerOpen, boolean folderOpen, boolean dragging) {
        return !(onAppWidget || onUserElement || onSlider || overview || drawerOpen || folderOpen || dragging);
    }

    /** Whether a gesture is wanted: the matching setting is on. */
    static boolean wanted(Result result, boolean swipeUpOn, boolean swipeDownOn) {
        return (result == Result.UP && swipeUpOn) || (result == Result.DOWN && swipeDownOn);
    }
}
