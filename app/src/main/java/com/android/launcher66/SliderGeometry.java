package com.android.launcher66;

/**
 * The sizes of the music widget's position slider, from the height of its row.
 *
 * <p>The rules (the owner's, 2026-11-25, D-81): the knob is a round one 60 % of the row's height, never below 2 px,
 * so that it is never cut; the line is a quarter of the knob's diameter thick, never below 2 dp, so that it is a
 * line and not a bar; the line and the knob are centred in the row, and the row is as high as the slider
 * ({@code MusicWidgetSizer} sets it). Pure Java, so that it has a test.
 */
final class SliderGeometry {

    /** The knob's diameter as a share of the row's height. */
    static final float KNOB_SHARE = 0.6f;
    /** The line's thickness as a share of the knob's diameter. */
    static final float LINE_SHARE = 0.25f;
    /** The thinnest line, in dp. */
    static final float MIN_LINE_DP = 2f;

    private SliderGeometry() {
    }

    /** The knob's diameter in pixels. */
    static int knobPx(int rowPx) {
        return Math.max(2, Math.round(rowPx * KNOB_SHARE));
    }

    /** The line's thickness in pixels for a knob of that diameter and a screen of that density. */
    static int linePx(int knobPx, float density) {
        int minimum = Math.max(1, Math.round(MIN_LINE_DP * density));
        return Math.max(minimum, Math.round(knobPx * LINE_SHARE));
    }
}
