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
 * <p>The pictures are taken of the bars' windows ({@link #snapshot}) and are shared by all pages; the
 * workspace gives them and takes them back.
 */
public final class PageBarGhost extends View {

    private static final String TAG = "PageBarGhost";

    private final Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
    private final Rect horizontalAt = new Rect();
    private final Rect verticalAt = new Rect();
    private Bitmap horizontal;
    private Bitmap vertical;
    /** The picture of the fuel statistics while the pages move (StatsPagePicture); drawn over the bars'. */
    private final Paint statsPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
    private final Rect statsAt = new Rect();
    private Bitmap stats;

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
    void show(Bitmap horizontal, Rect horizontalAt, Bitmap vertical, Rect verticalAt) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        if (horizontalAt != null) {
            this.horizontalAt.set(horizontalAt);
        }
        if (verticalAt != null) {
            this.verticalAt.set(verticalAt);
        }
        updateVisibility();
    }

    /** The pictures of the bars are let go of (the workspace recycles them); the view stays on its page. */
    void clear() {
        horizontal = null;
        vertical = null;
        updateVisibility();
    }

    /**
     * @param picture the picture of the fuel statistics
     * @param at      where it lies on the page: {left, top, right, bottom}
     * @param alpha   the transparency of the statistics' window, 0..1
     */
    void showStats(Bitmap picture, int[] at, float alpha) {
        stats = picture;
        statsAt.set(at[0], at[1], at[2], at[3]);
        statsPaint.setAlpha(Math.round(255 * Math.max(0f, Math.min(1f, alpha))));
        updateVisibility();
    }

    void clearStats() {
        stats = null;
        updateVisibility();
    }

    private void updateVisibility() {
        setVisibility(horizontal != null || vertical != null || stats != null ? VISIBLE : GONE);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        draw(canvas, vertical, verticalAt, paint);
        draw(canvas, horizontal, horizontalAt, paint);
        draw(canvas, stats, statsAt, statsPaint);
    }

    private void draw(Canvas canvas, Bitmap picture, Rect at, Paint paint) {
        if (picture == null || picture.isRecycled() || at.isEmpty()) {
            return;
        }
        // A picture kept by the graphics hardware cannot be drawn onto a plain canvas (a screenshot of the page)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && picture.getConfig() == Bitmap.Config.HARDWARE
                && !canvas.isHardwareAccelerated()) {
            return;
        }
        canvas.drawBitmap(picture, null, at, paint);
    }

    /**
     * A picture of a view as it is drawn now, whatever its own transparency (a bar's window that is put
     * away is fully transparent and still has its content). Null when the view has no size or cannot be
     * drawn.
     *
     * <p>From Android 9 the view is recorded and the picture made of the recording, which also holds what
     * the graphics hardware keeps (an album cover can be such a picture; drawing it onto a plain canvas
     * throws). Before, onto a plain canvas, and a view that cannot be drawn that way gives no picture.
     */
    public static Bitmap snapshot(View view) {
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
                return Bitmap.createBitmap(recording);
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
            return bitmap;
        } catch (RuntimeException | OutOfMemoryError e) {
            Log.w(TAG, "No picture of the bar: " + e);
            return null;
        }
    }
}
