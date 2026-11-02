package com.android.launcher66.settings;

/**
 * Geometry rules for PiP and widget (date, music, radio) rectangles that a bigger bottom bar or the
 * left bar has started to cover. Instead of resetting the element to its default place (which
 * restarts the app inside a PiP and loses the user's layout of a widget), the covered edge is cut
 * back: the top-left corner stays where the user put it.
 *
 * <p>Pure Java on purpose (no Android imports) so the rules are unit-tested on the JVM. Everything
 * is in the coordinate space the creator saves in: the box the widgets live in, without the left
 * bar and without the status bar.
 */
public final class PipEdgeTrim {

    /** Bound that never trims. */
    public static final int NO_LIMIT = Integer.MAX_VALUE;

    private static final float LEFT_BAR_FRACTION = 0.071f;

    private PipEdgeTrim() {
    }

    /**
     * Cuts the rectangle back to {@code maxRight} / {@code maxBottom}; left and top never move.
     *
     * @return {left, top, right, bottom}, or null when the cut rectangle would be narrower than
     *         {@code minWidth}, lower than {@code minHeight}, or lay entirely beyond a limit - the
     *         caller then falls back to its old behaviour (reset / move).
     */
    public static int[] trim(int left, int top, int right, int bottom,
                             int maxRight, int maxBottom, int minWidth, int minHeight) {
        int newRight = Math.min(right, maxRight);
        int newBottom = Math.min(bottom, maxBottom);
        if (newRight - left < minWidth || newBottom - top < minHeight) {
            return null;
        }
        // A zero minimum must not let an empty or inverted rectangle through.
        if (newRight <= left || newBottom <= top) {
            return null;
        }
        return new int[] {left, top, newRight, newBottom};
    }

    /**
     * Largest bottom edge that neither overlaps nor touches the bar. The collision test counts
     * touching as overlap, so with a zero margin the edge has to stay one pixel above the bar.
     */
    public static int maxBottom(int barTop, int margin) {
        return barTop - Math.max(margin, 1);
    }

    /** Largest right edge with {@code right + leftBarWidth <= rootWidth - margin}. */
    public static int maxRight(int rootWidth, float leftBarWidth, int margin) {
        return (int) Math.floor(rootWidth - margin - leftBarWidth);
    }

    /**
     * Width of the left bar as its layouts draw it. Landscape: 7.1 % of the box width
     * (layout_constraintWidth_percent). Portrait: the XML uses "W,0.071", i.e. 7.1 % of the bar's
     * HEIGHT, which runs from the top of the box to the bottom bar.
     */
    public static float computeLeftBarWidth(boolean portrait, int rootWidth, int rootHeight, int barHeight) {
        if (portrait) {
            return Math.max(0, rootHeight - barHeight) * LEFT_BAR_FRACTION;
        }
        return rootWidth * LEFT_BAR_FRACTION;
    }

    /**
     * Minimum width of a PiP rectangle as the creator sets it: a dual PiP gets the full width, the
     * single ones share it by the number of enabled first..fourth PiPs (1 or 2).
     */
    public static int pipMinWidth(String key, int fullMinWidth,
                                  boolean first, boolean second, boolean third, boolean fourth) {
        if ("pipDual".equals(key)) {
            return fullMinWidth;
        }
        int count = 0;
        if (first) count++;
        if (second) count++;
        if (third) count++;
        if (fourth) count++;
        return fullMinWidth / Math.min(Math.max(1, count), 2);
    }

    /** Rectangles that are cut back at the bars instead of reset: the PiP ones plus date, music, radio. */
    public static boolean isTrimmableKey(String key) {
        return isPipKey(key) || "date".equals(key) || "music".equals(key) || "radio".equals(key);
    }

    public static boolean isPipKey(String key) {
        return "pipDual".equals(key) || "pipFirst".equals(key) || "pipSecond".equals(key)
                || "pipThird".equals(key) || "pipFourth".equals(key);
    }
}
