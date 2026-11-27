package com.android.launcher66;

/**
 * The shape and the place of a notification badge on an icon.
 *
 * <p>The rules (the owner's, 2026-11-25 and 2026-11-27):
 * <ul>
 *   <li>The badge's height is a share of the icon's height as it is seen ({@link VisibleBounds}: not the picture's whole
 *       square), set with a slider from {@link #MIN_PERCENT} to {@link #MAX_PERCENT} per cent, {@link #DEFAULT_PERCENT} by
 *       default. The bars have other icon sizes than the home screen; the share is the same.</li>
 *   <li>The number's height is {@link #TEXT_SHARE} of the badge's.</li>
 *   <li>Its width is the height, or the width of its text and its padding when that is more, so that "99+" is not
 *       squeezed: a wider badge grows from its corner towards the icon's middle, and the number is in its middle.</li>
 *   <li>The corner radius follows its slider, 0 a square and 100 a circle (a radius of half the height).</li>
 *   <li>The badge lies in a corner of the seen icon, inside it.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
public final class BadgeGeometry {

    public static final int MIN_PERCENT = 15;
    public static final int MAX_PERCENT = 35;
    public static final int DEFAULT_PERCENT = 25;
    /** The number's text size, as a share of the badge's height. */
    static final float TEXT_SHARE = 0.85f;
    /** The room each side of the number, as a share of the badge's height. */
    static final float PADDING_SHARE = 0.2f;

    /** The slider's value held to its range. */
    public static int percent(int value) {
        return Math.max(MIN_PERCENT, Math.min(MAX_PERCENT, value));
    }

    enum Position {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT;

        static Position parse(String value) {
            if ("top_left".equals(value)) {
                return TOP_LEFT;
            }
            if ("bottom_left".equals(value)) {
                return BOTTOM_LEFT;
            }
            if ("bottom_right".equals(value)) {
                return BOTTOM_RIGHT;
            }
            return TOP_RIGHT;
        }
    }

    private BadgeGeometry() {
    }

    /** The badge's height for an icon seen this high, at a size of {@code percent} per cent (held to its range). */
    static float height(int percent, float iconHeightPx) {
        return Math.max(1f, percent(percent) / 100f * iconHeightPx);
    }

    /** The badge's width: its height, or its text and padding when they need more. */
    static float width(float heightPx, float textWidthPx, float paddingPx) {
        return Math.max(heightPx, textWidthPx + 2f * paddingPx);
    }

    /** The corner radius: 0 gives a square, 100 a circle (half the height). The slider is held to 0..100. */
    static float radius(int slider, float heightPx) {
        int s = Math.max(0, Math.min(100, slider));
        return heightPx / 2f * s / 100f;
    }

    /**
     * The badge's rectangle {left, top, right, bottom} in a corner of the icon's rectangle, inside it: its outer edges on
     * the corner's, so a wider badge reaches towards the icon's middle. A badge wider or higher than the icon is cut to
     * it.
     */
    static float[] place(Position position, float iconLeft, float iconTop, float iconRight, float iconBottom,
                         float widthPx, float heightPx) {
        float w = Math.min(widthPx, Math.max(0f, iconRight - iconLeft));
        float h = Math.min(heightPx, Math.max(0f, iconBottom - iconTop));
        boolean left = position == Position.TOP_LEFT || position == Position.BOTTOM_LEFT;
        boolean top = position == Position.TOP_LEFT || position == Position.TOP_RIGHT;
        float l = left ? iconLeft : iconRight - w;
        float t = top ? iconTop : iconBottom - h;
        return new float[] {l, t, l + w, t + h};
    }
}
