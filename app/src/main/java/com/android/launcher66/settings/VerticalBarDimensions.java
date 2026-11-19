package com.android.launcher66.settings;

/**
 * The width of the vertical bar: one source for the bar of the first page, its window, the grid beside it,
 * the PiP panes, the statistics and the creators (all of them read {@code Launcher.calculatedVerticalBarWidth},
 * which is worked out here).
 *
 * <p><b>Rule.</b> With {@link Keys#RESIZABLE_VERTICAL_BAR} off, or with the slider at its default, the width is
 * the one the launcher has always had, to the pixel: in landscape 7.1 % of the screen's width, in portrait 7.1 %
 * of the screen's height less 14.2 % of it ({@link #legacyWidth}). With the switch on the width is the stored
 * share of the screen's longer edge, within {@link #MIN_SHARE} .. {@link #MAX_SHARE} (4 % .. 10 %). The share
 * is stored per orientation, like the height of the horizontal bar.
 *
 * <p>The slider moves in steps of 0.1 % of the longer edge. The default share in portrait (6.0918 %) is not on
 * that grid, so the step nearest to a default stands for the exact default and gives the legacy width.
 *
 * <p>Plain Java on purpose (no Android imports), tested on the JVM.
 */
public final class VerticalBarDimensions {

    /** The legacy share, 7.1 %: of the width in landscape, of the height above a 14.2 % bar in portrait. */
    public static final double LEGACY_SHARE = 0.071;
    /** The legacy height of the horizontal bar in the portrait formula, a share of the screen's height. */
    private static final float LEGACY_BAR_SHARE_PORTRAIT = 0.142f;

    /** Range of the slider: 4 % .. 10 % of the longer edge. */
    public static final float MIN_SHARE = 0.04f;
    public static final float MAX_SHARE = 0.10f;

    /** Defaults of the per-orientation keys: the legacy widths as a share of the longer edge. */
    public static final float DEFAULT_SHARE_LANDSCAPE = 0.071f;
    public static final float DEFAULT_SHARE_PORTRAIT = (float) (LEGACY_SHARE * (1 - LEGACY_BAR_SHARE_PORTRAIT));

    /** One slider step is 1/1000 of the longer edge, i.e. 0.1 %. */
    public static final int STEPS_PER_UNIT = 1000;
    public static final int MIN_STEP = Math.round(MIN_SHARE * STEPS_PER_UNIT);
    public static final int MAX_STEP = Math.round(MAX_SHARE * STEPS_PER_UNIT);

    private VerticalBarDimensions() {
    }

    public static float defaultShare(boolean portrait) {
        return portrait ? DEFAULT_SHARE_PORTRAIT : DEFAULT_SHARE_LANDSCAPE;
    }

    /** The preference key of the share for the orientation. */
    public static String widthKey(boolean portrait) {
        return portrait ? Keys.VERTICAL_BAR_WIDTH_PORT : Keys.VERTICAL_BAR_WIDTH_LAND;
    }

    /**
     * The width the launcher has always had (Launcher.calculateDimension(…, 7.1)).
     *
     * @param longEdge the screen's height in portrait, its width in landscape
     */
    public static int legacyWidth(boolean portrait, int longEdge) {
        if (longEdge <= 0) {
            return 0;
        }
        if (portrait) {
            int horizontalBar = (int) (longEdge * LEGACY_BAR_SHARE_PORTRAIT);
            return (int) ((7.1 / 100.0) * (longEdge - horizontalBar));
        }
        return (int) ((7.1 / 100.0) * longEdge);
    }

    /** A stored share within the range; the default for one that is not a number. */
    public static float sanitize(float share, boolean portrait) {
        if (Float.isNaN(share) || Float.isInfinite(share)) {
            return defaultShare(portrait);
        }
        return Math.max(MIN_SHARE, Math.min(MAX_SHARE, share));
    }

    /**
     * The width of the vertical bar in pixels.
     *
     * @param resizable   "Resizable vertical bar" is on (and the layout is the user layout)
     * @param storedShare the share stored for the orientation, the default when nothing is stored
     */
    public static int width(boolean portrait, int longEdge, boolean resizable, float storedShare) {
        if (longEdge <= 0) {
            return 0;
        }
        float share = sanitize(storedShare, portrait);
        if (!resizable || toStep(share) == toStep(defaultShare(portrait))) {
            return legacyWidth(portrait, longEdge);
        }
        // Through the float's shortest decimal (0.04f -> 0.04), so 4 % of 2000 is 80 and not 79.999…
        return Math.max(1, (int) (longEdge * Double.parseDouble(Float.toString(share))));
    }

    /** Slider step for a share (0.071f -> 71), within the slider's range. */
    public static int toStep(float share) {
        return Math.max(MIN_STEP, Math.min(MAX_STEP, Math.round(share * STEPS_PER_UNIT)));
    }

    /** Share for a slider step; the step nearest to the orientation's default gives that exact default. */
    public static float fromStep(int step, boolean portrait) {
        int clamped = Math.max(MIN_STEP, Math.min(MAX_STEP, step));
        float defaultValue = defaultShare(portrait);
        if (clamped == toStep(defaultValue)) {
            return defaultValue;
        }
        return clamped / (float) STEPS_PER_UNIT;
    }
}
