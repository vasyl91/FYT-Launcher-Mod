package com.android.launcher66;

/**
 * How a freely placed widget ("Freeform widgets", "Allow widgets to overlap") is laid out so that it is drawn exactly in
 * its frame.
 *
 * <p>The rules (the owner on the A55, 2026-11-27: the widget went past its frame, and the frame ran away from it):
 * <ul>
 *   <li>A widget's {@link WidgetFrame} is the rectangle the user sees it in, on the page. The drop, the resize frame,
 *       the cells it lies over and the database all count with that one rectangle.</li>
 *   <li>A widget is drawn scaled ({@code ScreenScale.widgetScale()}, 1.75 on an FYT unit, less on a phone), as in its
 *       cells: laid out at the frame's size divided by the scale, scaled about its centre and moved back by the
 *       centring translation, so that what is drawn starts at the frame's corner and is as large as the frame. A widget
 *       in its cells is drawn the same way; laid out at the frame's whole size with the scale and the translation of
 *       its cells left over, a freely placed one was drawn larger and elsewhere.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class FreeformLayout {

    /** The view's own rectangle in its container, before the scale. */
    final int x;
    final int y;
    final int width;
    final int height;
    /** The scale it is drawn with, about its centre, and the translation that brings its corner back to the frame's. */
    final float scale;
    final float translationX;
    final float translationY;

    private FreeformLayout(int x, int y, int width, int height, float scale, float translationX, float translationY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.scale = scale;
        this.translationX = translationX;
        this.translationY = translationY;
    }

    /**
     * @param left,top,frameWidth,frameHeight the frame, the rectangle the widget is seen in
     * @param scale the scale the widget is drawn with (1 for a view that is not scaled)
     */
    static FreeformLayout of(int left, int top, int frameWidth, int frameHeight, float scale) {
        float s = scale > 0f ? scale : 1f;
        int width = Math.max(1, Math.round(frameWidth / s));
        int height = Math.max(1, Math.round(frameHeight / s));
        // As ShortcutAndWidgetContainer centres a widget in its cells: scaled about its centre, moved back
        float tx = -(width - width * s) / 2f;
        float ty = -(height - height * s) / 2f;
        return new FreeformLayout(left, top, width, height, s, tx, ty);
    }

    /** The rectangle {left, top, width, height} it is drawn in: its own scaled about its centre, then moved. */
    int[] drawn() {
        float centerX = x + width / 2f + translationX;
        float centerY = y + height / 2f + translationY;
        float w = width * scale;
        float h = height * scale;
        return new int[] {Math.round(centerX - w / 2f), Math.round(centerY - h / 2f), Math.round(w), Math.round(h)};
    }

    /** The widget's size as its provider is told it: the size it is laid out at, in dp. */
    int[] sizeDp(float density) {
        float d = density > 0f ? density : 1f;
        return new int[] {Math.round(width / d), Math.round(height / d)};
    }
}
