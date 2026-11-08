package com.android.launcher66.settings;

/**
 * The one rule for "two rectangles overlap" (R3), for the layout creators and for Helpers' layout alike. They overlap
 * only when they share an area greater than zero: a common edge or a common corner is not overlapping, so a
 * rectangle drawn against another one stays as drawn, the creator does not paint it red and does not ask. A touch of a
 * bar is a different rule and a collision still (Env, PipEdgeTrim, StatsBarFit). Pure Java, so that it has a test.
 */
public final class RectOverlap {

    private RectOverlap() {
    }

    public static boolean overlaps(float l1, float t1, float r1, float b1,
                                   float l2, float t2, float r2, float b2) {
        return l1 < r2 && l2 < r1 && t1 < b2 && t2 < b1;
    }
}
