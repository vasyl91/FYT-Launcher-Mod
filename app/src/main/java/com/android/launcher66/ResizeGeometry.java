package com.android.launcher66;

/**
 * The resize frame of a freeform widget and the widget's rectangle, each from the other ("Freeform widgets",
 * AppWidgetResizeFrame).
 *
 * <p>The rules (the owner on the A55, 2026-11-27: the frame ran away from the widget while it was resized):
 * <ul>
 *   <li>The frame lies round the widget by its own padding ({@code framePadding}) less the widget's padding on each
 *       side; a widget drawn scaled ({@code scale}, a widget fitted to its cells) has no padding of its own counted and
 *       is as large as it is drawn. {@link #widgetOf} and {@link #frameOf} are exact inverses (to the pixel, with a
 *       scale of 1).</li>
 *   <li>While the frame is dragged, the widget takes what the page allows (its least size, the page's edges, the free
 *       cells), and the frame is put back round the widget at once, in the same move: the two never part.</li>
 * </ul>
 * The frame is in the drag layer's coordinates; the widget in its container's, which lies at {@code offsetX, offsetY}
 * in the drag layer. Pure Java, so that it has a test.
 */
final class ResizeGeometry {

    private ResizeGeometry() {
    }

    /**
     * The widget's rectangle {left, top, width, height} in its container for a frame {x, y, width, height}.
     *
     * @param pad the widget's padding {left, top, right, bottom}
     */
    static int[] widgetOf(int[] frame, int framePadding, int[] pad, float scale, int offsetX, int offsetY) {
        float s = scale > 0f ? scale : 1f;
        int left = frame[0] + framePadding - pad[0] - offsetX;
        int top = frame[1] + framePadding - pad[1] - offsetY;
        int width = Math.round((frame[2] - 2 * framePadding + pad[0] + pad[2]) / s);
        int height = Math.round((frame[3] - 2 * framePadding + pad[1] + pad[3]) / s);
        return new int[] {left, top, Math.max(1, width), Math.max(1, height)};
    }

    /** The frame {x, y, width, height} in the drag layer round a widget's rectangle {left, top, width, height}. */
    static int[] frameOf(int[] widget, int framePadding, int[] pad, float scale, int offsetX, int offsetY) {
        float s = scale > 0f ? scale : 1f;
        int x = widget[0] - framePadding + pad[0] + offsetX;
        int y = widget[1] - framePadding + pad[1] + offsetY;
        int width = Math.round(widget[2] * s) + 2 * framePadding - pad[0] - pad[2];
        int height = Math.round(widget[3] * s) + 2 * framePadding - pad[1] - pad[3];
        return new int[] {x, y, width, height};
    }
}
