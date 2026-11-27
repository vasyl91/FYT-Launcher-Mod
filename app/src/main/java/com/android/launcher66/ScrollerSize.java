package com.android.launcher66;

/**
 * How large the letter scroller of the app drawer and of the list of widgets is drawn (LetterScroller): its handle, its
 * track, the strip it is touched in and its bubble.
 *
 * <p>The rule (the owner on the 7862, 2026-11-27: the scroller was too thin there): its sizes are given in dp, and each dp
 * is at least the same share of the screen's shorter side as on the A55 ({@link #REFERENCE_SHORT_SIDE_DP}), where the
 * owner finds it right. A screen with few pixels per dp for its size (the 7862: 1.5 for 800 dp) gets the scroller as thick
 * against the screen as the A55 has it; a larger one never gets it thinner than its dp. Pure Java, so that it has a test.
 */
final class ScrollerSize {

    /** The A55's shorter side in dp (1080 px at 2.8125 px per dp). */
    static final float REFERENCE_SHORT_SIDE_DP = 384f;

    private ScrollerSize() {
    }

    /** The pixels a dp of the scroller is drawn with on a screen of this shorter side and density. */
    static float unit(int shortSidePx, float density) {
        float d = density > 0f ? density : 1f;
        if (shortSidePx <= 0) {
            return d;
        }
        return Math.max(d, shortSidePx / REFERENCE_SHORT_SIDE_DP);
    }
}
