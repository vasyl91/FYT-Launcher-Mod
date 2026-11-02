package com.syu.util;

/**
 * Limits of the divider of the dual PiP. The user's split is a proportion and stays one; what is
 * limited here is only the width it is applied as. A pane is never narrower than a quarter of the
 * total (as before) and never narrower than the smallest PiP the creator allows, which matters
 * when the PiP itself was cut to its minimum width. Pure Java so it is unit-tested on the JVM.
 */
public final class DualSplitBounds {

    public static final float MIN_RATIO = 0.25f;

    private DualSplitBounds() {
    }

    /**
     * @param total      width of both panes together
     * @param minPanePx  smallest width of one pane
     * @return {smallest, largest} width of the left pane. The right one is {@code total - left},
     *         so both panes have the same minimum; when there is no room for two of them they get
     *         half each.
     */
    public static int[] leftRange(int total, int minPanePx) {
        int min = Math.max(Math.round(total * MIN_RATIO), minPanePx);
        min = Math.min(min, total / 2);
        return new int[] {min, total - min};
    }

    /** The left pane's width for the saved proportion; the proportion itself is not changed. */
    public static int leftWidth(int total, float ratio, int minPanePx) {
        int[] range = leftRange(total, minPanePx);
        return Math.max(range[0], Math.min(Math.round(total * ratio), range[1]));
    }
}
