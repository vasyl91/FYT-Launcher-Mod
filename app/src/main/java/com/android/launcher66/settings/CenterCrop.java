package com.android.launcher66.settings;

/**
 * Which part of a picture fills a view without stretching it, free of android.* so that it has a test.
 *
 * <p>The rule: <b>the picture is never stretched.</b> It is scaled by the larger of the two ratios (view to picture,
 * across and down), so that it covers the view, and the middle of it is shown ("center crop"). The part of the picture
 * that is drawn therefore has the view's proportions, whatever the view's size: the background selector's view
 * changes size with a turn of the screen and while it is laid out, and the part follows it at every draw.
 */
public final class CenterCrop {

    private CenterCrop() {
    }

    /**
     * The part of a picture of {@code srcW} x {@code srcH} drawn into a view of {@code dstW} x {@code dstH}, as
     * {left, top, right, bottom} in the picture's pixels. The whole picture for a view or a picture without a size.
     */
    public static int[] source(int srcW, int srcH, int dstW, int dstH) {
        if (srcW <= 0 || srcH <= 0 || dstW <= 0 || dstH <= 0) {
            return new int[] {0, 0, Math.max(0, srcW), Math.max(0, srcH)};
        }
        // The picture's part has the view's proportions: as wide as the picture, or as high, whichever is cut less
        if ((long) srcW * dstH > (long) srcH * dstW) {
            // Wider than the view: the middle across, the full height
            int width = (int) Math.round((double) srcH * dstW / dstH);
            int left = (srcW - width) / 2;
            return new int[] {left, 0, left + width, srcH};
        }
        // Higher than the view (or the same): the middle down, the full width
        int height = (int) Math.round((double) srcW * dstH / dstW);
        int top = (srcH - height) / 2;
        return new int[] {0, top, srcW, top + height};
    }
}
