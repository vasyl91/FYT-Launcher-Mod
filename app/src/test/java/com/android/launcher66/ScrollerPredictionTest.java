package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScrollerPredictionTest {

    /** PagedView.ScrollInterpolator. */
    private static float interpolate(float t) {
        t -= 1.0f;
        return t * t * t * t * t + 1;
    }

    /** What Scroller.computeScrollOffset() does for a scroll in progress. */
    private static int scroller(int startX, int finalX, int passedMs, int durationMs) {
        if (passedMs >= durationMs) {
            return finalX;
        }
        final float reciprocal = 1.0f / (float) durationMs;
        final float x = interpolate(passedMs * reciprocal);
        return startX + Math.round(x * (finalX - startX));
    }

    private static int predicted(int startX, int finalX, int passedMs, int durationMs) {
        final float p = passedMs < durationMs ? interpolate(ScrollerPrediction.progress(passedMs, durationMs)) : 1f;
        return ScrollerPrediction.x(startX, finalX, passedMs, durationMs, p);
    }

    @Test
    void theScrollStartsAtItsStartX() {
        assertEquals(1200, predicted(1200, 2400, 0, 270));
    }

    @Test
    void theScrollEndsAtItsFinalX() {
        assertEquals(2400, predicted(1200, 2400, 270, 270));
        assertEquals(2400, predicted(1200, 2400, 300, 270));
    }

    @Test
    void aScrollWithoutDurationIsAtItsFinalXAtOnce() {
        assertEquals(2400, ScrollerPrediction.x(1200, 2400, 0, 0, 0f));
        assertEquals(2400, ScrollerPrediction.x(1200, 2400, 5, -1, 0.5f));
    }

    @Test
    void everyFrameMatchesTheScrollerPixelForPixel() {
        final int[][] scrolls = {
                {0, 1280, 270}, {1280, 0, 270}, {640, 1920, 450}, {1900, 700, 123}, {-120, 0, 90},
                {1280, 2560, 1}, {3, 4, 300}, {0, 1920, 1000},
        };
        for (int[] s : scrolls) {
            for (int passed = 0; passed <= s[2] + 16; passed++) {
                assertEquals(scroller(s[0], s[1], passed, s[2]), predicted(s[0], s[1], passed, s[2]),
                        "scroll " + s[0] + " -> " + s[1] + " in " + s[2] + " ms, at " + passed);
            }
        }
    }

    @Test
    void theScrollMovesTheRightWayInBothDirections() {
        assertTrue(predicted(0, 1280, 60, 270) > 0);
        assertTrue(predicted(1280, 0, 60, 270) < 1280);
        assertTrue(predicted(0, 1280, 60, 270) <= predicted(0, 1280, 120, 270));
        assertTrue(predicted(1280, 0, 60, 270) >= predicted(1280, 0, 120, 270));
    }

    @Test
    void progressIsTheScrollersOwnFloatArithmetic() {
        assertEquals(60 * (1.0f / 270f), ScrollerPrediction.progress(60, 270), 0f);
    }
}
