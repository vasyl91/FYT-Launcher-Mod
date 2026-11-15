package com.android.launcher66;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;

/**
 * The picture of the bars on a page after the first, while the pages are small (BarGhostRule).
 *
 * <p>It is a child of the page, like the layout with the bars is on the first page, so it becomes small with
 * the page and moves with it. It draws two pictures, each in the strip its bar has on the page (BarLayout),
 * and nothing else; it takes no touch, so the page below it behaves as without it.
 *
 * <p>The pictures are recordings of the bars' windows ({@link #record}) and are shared by all pages; the
 * workspace gives them and takes them back. A recording is drawn by the page itself, in its own frame: no
 * bitmap is made of it and nothing is rendered apart (making a bitmap of a recording renders it on the
 * graphics hardware of its own, which on the 7862 went with windows of the launcher vanishing while the
 * pages moved). Before Android 9 a recording cannot hold what the graphics hardware keeps, so the bar is
 * drawn into a plain bitmap there instead.
 */
final class PageBarGhost extends View {

    private static final String TAG = "PageBarGhost";

    /** One bar as it was drawn: a recording (Android 9 and later) or a bitmap (before). */
    static final class Shot {
        final Picture picture;
        final Bitmap bitmap;
        final int width;
        final int height;

        private Shot(Picture picture, Bitmap bitmap, int width, int height) {
            this.picture = picture;
            this.bitmap = bitmap;
            this.width = width;
            this.height = height;
        }

        /** Lets go of the bitmap, if there is one; a recording needs nothing. */
        void release() {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private final Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    private final Rect horizontalAt = new Rect();
    private final Rect verticalAt = new Rect();
    private Shot horizontal;
    private Shot vertical;

    PageBarGhost(Context context) {
        super(context);
        setWillNotDraw(false);
        setClickable(false);
        setFocusable(false);
        setImportantForAccessibility(IMPORTANT_FOR_ACCESSIBILITY_NO);
        setVisibility(GONE);
    }

    /**
     * @param horizontal   the picture of the horizontal bar, or null for a page without it
     * @param horizontalAt where it lies on the page
     * @param vertical     the picture of the vertical bar, or null for a page without it
     * @param verticalAt   where it lies on the page
     */
    void show(Shot horizontal, Rect horizontalAt, Shot vertical, Rect verticalAt) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        if (horizontalAt != null) {
            this.horizontalAt.set(horizontalAt);
        }
        if (verticalAt != null) {
            this.verticalAt.set(verticalAt);
        }
        setVisibility(horizontal != null || vertical != null ? VISIBLE : GONE);
        invalidate();
    }

    /** The pictures are let go of (the workspace releases them); the view stays on its page, hidden. */
    void clear() {
        horizontal = null;
        vertical = null;
        setVisibility(GONE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        draw(canvas, vertical, verticalAt);
        draw(canvas, horizontal, horizontalAt);
    }

    private void draw(Canvas canvas, Shot shot, Rect at) {
        if (shot == null || at.isEmpty()) {
            return;
        }
        if (shot.picture != null) {
            // A recording that holds what the graphics hardware keeps cannot be drawn onto a plain canvas
            // (a screenshot of the page): it is left out there
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P && shot.picture.requiresHardwareAcceleration()
                    && !canvas.isHardwareAccelerated()) {
                return;
            }
            // The strip is in the page's own measure, as the bar was: one scale for both axes (about 1), so
            // a bar of another height is cut, not stretched
            float scale = at.width() / (float) shot.width;
            int save = canvas.save();
            canvas.clipRect(at);
            canvas.translate(at.left, at.top);
            canvas.scale(scale, scale);
            canvas.drawPicture(shot.picture);
            canvas.restoreToCount(save);
            return;
        }
        if (shot.bitmap == null || shot.bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(shot.bitmap, null, at, paint);
    }

    /**
     * The bar as it is drawn now, whatever its own transparency (a bar's window that is put away is fully
     * transparent and still has its content). Null when the view has no size or cannot be drawn.
     */
    static Shot record(View view) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                Picture recording = new Picture();
                view.draw(recording.beginRecording(width, height));
                recording.endRecording();
                return new Shot(recording, null, width, height);
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
            return new Shot(null, bitmap, width, height);
        } catch (RuntimeException | OutOfMemoryError e) {
            Log.w(TAG, "No picture of the bar: " + e);
            return null;
        }
    }
}
