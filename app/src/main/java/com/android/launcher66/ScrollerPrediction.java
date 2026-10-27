package com.android.launcher66;

/**
 * Where an android.widget.Scroller started with startScroll() will be at a given time, worked out
 * with the formula of Scroller.computeScrollOffset() without touching the Scroller. Used to move
 * the PiP panes in the frame before the pages are drawn (Workspace.mPaneFrame); the result is the
 * same pixel the Scroller reports in the draw of that frame. Kept free of android.* so it can be
 * tested.
 */
final class ScrollerPrediction {

    private ScrollerPrediction() {}

    /** Scroller's own progress: passedMs * (1.0f / (float) durationMs). */
    static float progress(int passedMs, int durationMs) {
        return passedMs * (1.0f / (float) durationMs);
    }

    /**
     * Scroller's x for the frame.
     *
     * @param interpolated the interpolator's value for {@link #progress}; not used from the end of
     *                     the scroll on
     * @return finalX when passedMs >= durationMs (or durationMs <= 0), else
     *         startX + Math.round(interpolated * (finalX - startX))
     */
    static int x(int startX, int finalX, int passedMs, int durationMs, float interpolated) {
        if (durationMs <= 0 || passedMs >= durationMs) {
            return finalX;
        }
        return startX + Math.round(interpolated * (finalX - startX));
    }
}
