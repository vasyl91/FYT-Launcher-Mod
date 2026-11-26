package com.android.launcher66;

import java.util.Locale;

/**
 * The rectangle of a widget on a page of the home screen when "Free widget placement" is on.
 *
 * <p>The rules:
 * <ul>
 *   <li>The frame is kept as fractions of the page's content area (left, top, right, bottom, each 0..1), not as
 *       pixels, so that it follows the area when the screen turns or the grid changes. {@link #toPixels} and
 *       {@link #ofPixels} go between the two.</li>
 *   <li>A frame always lies inside the page and is never smaller than the minimum size the widget's provider
 *       asks for ({@link #fit}); the part that would leave the page is pushed back, the size kept.</li>
 *   <li>The database keeps the cells too, for when the setting is turned off: {@link #snap} gives the cells
 *       nearest to the frame, at least one cell each way.</li>
 *   <li>The stored form is "left,top,right,bottom" with five decimals ({@link #format}, {@link #parse}); text that
 *       is not four numbers in order is no frame.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class WidgetFrame {

    final float left;
    final float top;
    final float right;
    final float bottom;

    WidgetFrame(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    float width() {
        return right - left;
    }

    float height() {
        return bottom - top;
    }

    /** The frame of a pixel rectangle in an area of the given size. */
    static WidgetFrame ofPixels(int pxLeft, int pxTop, int pxRight, int pxBottom, int areaW, int areaH) {
        float w = Math.max(1, areaW);
        float h = Math.max(1, areaH);
        return new WidgetFrame(pxLeft / w, pxTop / h, pxRight / w, pxBottom / h);
    }

    /** The pixel rectangle {left, top, right, bottom} of the frame in an area of the given size. */
    int[] toPixels(int areaW, int areaH) {
        return new int[] {Math.round(left * areaW), Math.round(top * areaH),
                Math.round(right * areaW), Math.round(bottom * areaH)};
    }

    /**
     * The frame inside the page and no smaller than the minimum: the size is raised to the minimum (but not above the
     * page), and a frame that leaves the page is pushed back with its size kept.
     *
     * @param minW the least width in pixels (0: none), {@code minH} the least height
     */
    WidgetFrame fit(int areaW, int areaH, int minW, int minH) {
        float w = Math.max(width(), areaW > 0 ? Math.min(1f, (float) minW / areaW) : 0f);
        float h = Math.max(height(), areaH > 0 ? Math.min(1f, (float) minH / areaH) : 0f);
        w = Math.min(1f, w);
        h = Math.min(1f, h);
        float l = Math.max(0f, Math.min(left, 1f - w));
        float t = Math.max(0f, Math.min(top, 1f - h));
        return new WidgetFrame(l, t, l + w, t + h);
    }

    /**
     * The cells nearest to the frame: {cellX, cellY, spanX, spanY} for an area divided into {@code countX} by
     * {@code countY} equal cells; at least one cell each way, inside the grid.
     */
    int[] snap(int countX, int countY) {
        int cx = Math.max(1, countX);
        int cy = Math.max(1, countY);
        int x0 = clamp(Math.round(left * cx), 0, cx - 1);
        int y0 = clamp(Math.round(top * cy), 0, cy - 1);
        int x1 = clamp(Math.round(right * cx), x0 + 1, cx);
        int y1 = clamp(Math.round(bottom * cy), y0 + 1, cy);
        return new int[] {x0, y0, x1 - x0, y1 - y0};
    }

    /** The frame that fills the given cells of an area divided into equal cells. */
    static WidgetFrame ofCells(int cellX, int cellY, int spanX, int spanY, int countX, int countY) {
        float cx = Math.max(1, countX);
        float cy = Math.max(1, countY);
        return new WidgetFrame(cellX / cx, cellY / cy, (cellX + spanX) / cx, (cellY + spanY) / cy);
    }

    private static int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(hi, v));
    }

    /** "left,top,right,bottom", five decimals, the point as the dot whatever the language. */
    String format() {
        return String.format(Locale.US, "%.5f,%.5f,%.5f,%.5f", left, top, right, bottom);
    }

    /** The frame of a stored text, or null when it is not four numbers with right after left and bottom after top. */
    static WidgetFrame parse(String text) {
        if (text == null) {
            return null;
        }
        String[] parts = text.split(",");
        if (parts.length != 4) {
            return null;
        }
        try {
            float l = Float.parseFloat(parts[0].trim());
            float t = Float.parseFloat(parts[1].trim());
            float r = Float.parseFloat(parts[2].trim());
            float b = Float.parseFloat(parts[3].trim());
            if (Float.isNaN(l + t + r + b) || Float.isInfinite(l + t + r + b) || r <= l || b <= t) {
                return null;
            }
            return new WidgetFrame(l, t, r, b);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
