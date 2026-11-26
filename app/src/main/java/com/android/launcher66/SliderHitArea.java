package com.android.launcher66;

/**
 * Where a touch belongs to the music widget's position slider.
 *
 * <p>The rule: the slider takes a touch that lands on its track or on its knob, each a little larger than it
 * is drawn, and no other. The track is a strip along the whole width of the slider, the knob a circle at the
 * knob's place; both grow by 30 % of the knob's diameter, 15 % on each side, so that a thin line (a quarter of the
 * knob) is not a target a finger has to hit exactly. Beside this area the touch goes to the widget and the pages
 * as before. The area may leave the slider's own bounds (the knob at an end, the track thinner than the grown
 * strip): {@link #outer} is the rectangle a touch delegate has to cover. Pure Java, so that it has a test.
 */
final class SliderHitArea {

    /** The growth of the area, as a share of the knob's diameter, over both sides together. */
    static final float GROWTH = 0.30f;

    private SliderHitArea() {
    }

    /** A rectangle in the slider's own coordinates (the slider's top left corner is 0,0). */
    static final class Rect {
        final float left;
        final float top;
        final float right;
        final float bottom;

        Rect(float left, float top, float right, float bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    private static float grow(float knobPx) {
        return knobPx * GROWTH / 2f;
    }

    private static float halfStrip(float trackPx, float knobPx) {
        return Math.max(trackPx, 0f) / 2f + grow(knobPx);
    }

    private static float knobRadius(float knobPx) {
        return Math.max(knobPx, 0f) / 2f + grow(knobPx);
    }

    /**
     * Whether a touch at x,y (the slider's coordinates) is on the track or the knob.
     *
     * @param width        the slider's width
     * @param height       the slider's height; the track and the knob are centred in it
     * @param trackPx      the thickness of the track as drawn
     * @param knobPx       the diameter of the knob as drawn
     * @param knobCenterX  where the knob's centre is now (its x in the slider)
     */
    static boolean contains(float x, float y, int width, int height, float trackPx, float knobPx,
                            float knobCenterX) {
        float cy = height / 2f;
        // the track: a strip along the whole width, a little thicker than drawn
        if (x >= 0f && x <= width && Math.abs(y - cy) <= halfStrip(trackPx, knobPx)) {
            return true;
        }
        // the knob: a circle, a little larger than drawn
        float dx = x - knobCenterX;
        float dy = y - cy;
        float r = knobRadius(knobPx);
        return dx * dx + dy * dy <= r * r;
    }

    /** The smallest rectangle that holds the whole area, for a touch delegate (it may reach beyond the slider). */
    static Rect outer(int width, int height, float trackPx, float knobPx) {
        float cy = height / 2f;
        float half = Math.max(halfStrip(trackPx, knobPx), knobRadius(knobPx));
        float g = grow(knobPx);
        return new Rect(-g - Math.max(knobPx, 0f) / 2f, cy - half, width + g + Math.max(knobPx, 0f) / 2f, cy + half);
    }
}
