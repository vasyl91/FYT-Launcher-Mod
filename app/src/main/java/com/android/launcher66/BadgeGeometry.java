package com.android.launcher66;

/**
 * The shape and the place of a notification badge on an icon.
 *
 * <p>The rules (the owner's, 2026-11-25): the badge's height is a share of the icon's height where it lies
 * ({@link Size}: a fifth, a quarter or a third; the bars have other icon sizes than the home screen); its width is the
 * height, or the width of its text and its padding when that is more, so that "99+" is not squeezed; the
 * corner radius follows the slider, 0 a square and 100 a circle (a radius of half the height); and the badge
 * lies in a corner of the icon's rectangle, inside it. Pure Java, so that it has a test.
 */
final class BadgeGeometry {

    enum Size {
        SMALL(1f / 5f), MEDIUM(1f / 4f), LARGE(1f / 3f);

        final float share;

        Size(float share) {
            this.share = share;
        }

        static Size parse(String value) {
            if ("small".equals(value)) {
                return SMALL;
            }
            return "large".equals(value) ? LARGE : MEDIUM;
        }
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

    /** The badge's height for an icon of this height. */
    static float height(Size size, float iconHeightPx) {
        return Math.max(1f, size.share * iconHeightPx);
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
     * The badge's rectangle {left, top, right, bottom} in a corner of the icon's rectangle, inside it. A badge wider
     * or higher than the icon is cut to it.
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
