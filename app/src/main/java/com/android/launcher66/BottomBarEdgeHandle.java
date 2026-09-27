package com.android.launcher66;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

import java.util.Collections;

/**
 * Handle of the auto-hide bottom bar when the left bar is off: a thin, semi-transparent strip on
 * the left screen edge, as tall as the bottom bar and level with it, with its two corners facing
 * the middle of the screen slightly rounded. A tap or a swipe to the right reveals the bar.
 *
 * <p>It lives in its own TYPE_APPLICATION_OVERLAY window - the window type of the bar overlay -
 * so it stays above the widgets and the PiP panes. Vertically the window is framed exactly like the
 * bar overlay (same type, flags, gravity and height), so the strip is level with the bar. The
 * window is wider than the strip: a transparent margin beside it catches the touch as well.
 * Workspace sizes that margin so it never reaches a widget standing next to the strip; the strip
 * itself always stays on top.
 *
 * <p>The window is added once and then only shown and hidden (a hidden root view hides the whole
 * window, input included). Workspace decides when; this class only draws, animates and reports
 * the gesture. Main thread only.
 */
final class BottomBarEdgeHandle {

    private static final String TAG = "BottomBarEdgeHandle";

    /** Width of the visible strip, as a share of the longer screen edge. */
    static final float STRIP_WIDTH_FRACTION = 0.01f;
    /** Transparent touch margin beside the strip, as a share of the longer screen edge. */
    static final float TOUCH_MARGIN_FRACTION = 0.01f;

    /** Radius of the two inner corners, as a share of the strip width. */
    private static final float CORNER_RADIUS_FRACTION = 0.4f;
    /** Alpha of the strip colour at rest and while touched (0-255). */
    private static final int IDLE_ALPHA = 0x73;      // ~45 %
    private static final int PRESSED_ALPHA = 0xBF;   // ~75 %

    private final WindowManager windowManager;
    private final StripView view;
    private WindowManager.LayoutParams params;
    private boolean attached = false;
    private boolean shown = false;
    private boolean addFailedLogged = false;

    private int touchWidth;
    private int barHeight;

    BottomBarEdgeHandle(Context context, Runnable onTrigger) {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        view = new StripView(context, onTrigger);
        // No inset handling, on purpose: the bar overlay's inset listener only pads its content and
        // never resizes its window, so a window of exactly the bar height is what lines up with it.
    }

    /**
     * @param stripWidth width of the visible strip
     * @param touchWidth width of the window, i.e. the strip plus the transparent touch margin
     * @param barHeight  height of the bottom bar, which the strip matches
     * @param dark       black strip instead of a white one (the "black bar" setting)
     */
    void setGeometry(int stripWidth, int touchWidth, int barHeight, boolean dark) {
        this.touchWidth = Math.max(stripWidth, touchWidth);
        this.barHeight = barHeight;
        view.setStrip(stripWidth, dark);
        applyWindowSize();
    }

    /**
     * @param delayMs the fade-in starts this much later; the handle already takes touches meanwhile
     * @return true if the handle was hidden before.
     */
    boolean show(long durationMs, long delayMs) {
        if (!ensureAttached()) {
            return false;
        }
        boolean changed = !shown;
        shown = true;
        setTouchable(true);
        if (!changed && view.getVisibility() == View.VISIBLE && view.getAlpha() >= 1f) {
            return false; // already fully shown, keep whatever is running
        }
        view.animate().cancel();
        if (view.getVisibility() != View.VISIBLE) {
            view.setAlpha(0f);
            view.setVisibility(View.VISIBLE);
        }
        if (durationMs <= 0 && delayMs <= 0) {
            view.setAlpha(1f);
        } else {
            view.animate()
                    .alpha(1f)
                    .setStartDelay(Math.max(0, delayMs))
                    .setDuration(Math.max(1, durationMs))
                    .setInterpolator(new DecelerateInterpolator())
                    .start();
        }
        return changed;
    }

    /** @return true if the handle was shown before. */
    boolean hide(long durationMs) {
        boolean changed = shown;
        shown = false;
        if (!attached) {
            return changed;
        }
        view.cancelGesture();
        // Touches pass through at once, even while the strip is still fading out.
        setTouchable(false);
        view.animate().cancel();
        if (durationMs <= 0 || view.getVisibility() != View.VISIBLE) {
            view.setAlpha(0f);
            view.setVisibility(View.INVISIBLE);
        } else {
            view.animate()
                    .alpha(0f)
                    .setStartDelay(0)
                    .setDuration(durationMs)
                    .setInterpolator(new DecelerateInterpolator())
                    .withEndAction(() -> view.setVisibility(View.INVISIBLE))
                    .start();
        }
        return changed;
    }

    /** Removes the window; the instance must not be used afterwards. */
    void release() {
        shown = false;
        view.animate().cancel();
        view.cancelGesture();
        if (attached) {
            try {
                windowManager.removeViewImmediate(view);
            } catch (RuntimeException e) {
                Log.w(TAG, "Removing the edge handle failed", e);
            }
            attached = false;
        }
    }

    private boolean ensureAttached() {
        if (attached) {
            return true;
        }
        if (windowManager == null || touchWidth <= 0 || barHeight <= 0) {
            return false;
        }
        params = new WindowManager.LayoutParams(
                touchWidth,
                barHeight,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            params.layoutInDisplayCutoutMode =
                    WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        // Same flags, cutout mode and bottom gravity as the bar overlay window.
        params.gravity = Gravity.BOTTOM | Gravity.LEFT;
        // No system window animation: the strip fades itself, in step with the bar.
        params.windowAnimations = 0;
        params.setTitle(TAG);

        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        try {
            windowManager.addView(view, params);
            attached = true;
        } catch (RuntimeException e) {
            // Typically no overlay permission. Retried on the next show (e.g. after the user has
            // granted it and comes back), but the stack trace is logged only once.
            if (!addFailedLogged) {
                addFailedLogged = true;
                Log.e(TAG, "Adding the edge handle failed", e);
            } else {
                Log.w(TAG, "Adding the edge handle failed again: " + e);
            }
            params = null;
        }
        return attached;
    }

    private void applyWindowSize() {
        if (!attached || params == null) {
            return;
        }
        int width = touchWidth;
        int height = barHeight;
        if (params.width == width && params.height == height) {
            return;
        }
        params.width = width;
        params.height = height;
        updateLayout();
    }

    private void setTouchable(boolean touchable) {
        if (!attached || params == null) {
            return;
        }
        int flags = touchable
                ? params.flags & ~WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                : params.flags | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        if (flags == params.flags) {
            return;
        }
        params.flags = flags;
        updateLayout();
    }

    private void updateLayout() {
        try {
            windowManager.updateViewLayout(view, params);
        } catch (RuntimeException e) {
            Log.w(TAG, "Updating the edge handle failed", e);
        }
    }

    /**
     * The strip and the gesture. Draws the strip along the left edge of the window; the rest of
     * the window is the transparent touch margin.
     */
    @SuppressLint("ViewConstructor")
    private static final class StripView extends View {

        private final Runnable onTrigger;
        private final int touchSlop;
        private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final Path path = new Path();
        private final RectF rect = new RectF();
        private final float[] radii = new float[8];

        private int stripWidth;
        private int rgb = 0xFFFFFF;
        private boolean pressed;

        private float downX;
        private float downY;
        private boolean tracking;

        StripView(Context context, Runnable onTrigger) {
            super(context);
            this.onTrigger = onTrigger;
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            paint.setStyle(Paint.Style.FILL);
        }

        void setStrip(int width, boolean dark) {
            int newRgb = dark ? 0x000000 : 0xFFFFFF;
            if (width == stripWidth && newRgb == rgb) {
                return;
            }
            stripWidth = width;
            rgb = newRgb;
            invalidate();
        }

        void cancelGesture() {
            tracking = false;
            setStripPressed(false);
        }

        private void setStripPressed(boolean value) {
            if (pressed != value) {
                pressed = value;
                invalidate();
            }
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // With gesture navigation the left screen edge belongs to the system back gesture,
                // which would swallow the swipe to the right. The handle is far below the 200 dp the
                // system allows an app to exclude per edge.
                setSystemGestureExclusionRects(
                        Collections.singletonList(new Rect(0, 0, right - left, bottom - top)));
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int stripHeight = getHeight() - getPaddingBottom();
            if (stripWidth <= 0 || stripHeight <= 0) {
                return;
            }
            float radius = Math.min(stripWidth * CORNER_RADIUS_FRACTION, stripHeight / 2f);
            // Clockwise from top-left: only the top-right and bottom-right corners are rounded.
            radii[0] = 0f;     radii[1] = 0f;
            radii[2] = radius; radii[3] = radius;
            radii[4] = radius; radii[5] = radius;
            radii[6] = 0f;     radii[7] = 0f;
            rect.set(0f, 0f, stripWidth, stripHeight);
            path.reset();
            path.addRoundRect(rect, radii, Path.Direction.CW);
            paint.setColor(((pressed ? PRESSED_ALPHA : IDLE_ALPHA) << 24) | rgb);
            canvas.drawPath(path, paint);
        }

        @SuppressLint("ClickableViewAccessibility") // taps go through performClick()
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    tracking = true;
                    setStripPressed(true);
                    return true;

                case MotionEvent.ACTION_MOVE: {
                    if (!tracking) {
                        return true;
                    }
                    float dx = event.getX() - downX;
                    float dy = event.getY() - downY;
                    if (dx > touchSlop && dx > Math.abs(dy)) {
                        // Swipe to the right: reveal the bar right away, without waiting for UP.
                        tracking = false;
                        setStripPressed(false);
                        trigger();
                    } else if (Math.abs(dy) > touchSlop && Math.abs(dy) > Math.abs(dx)) {
                        // Mostly vertical: not a gesture of this handle.
                        tracking = false;
                        setStripPressed(false);
                    }
                    return true;
                }

                case MotionEvent.ACTION_UP: {
                    boolean tap = tracking
                            && Math.hypot(event.getX() - downX, event.getY() - downY) <= touchSlop;
                    tracking = false;
                    setStripPressed(false);
                    if (tap) {
                        performClick();
                    }
                    return true;
                }

                case MotionEvent.ACTION_CANCEL:
                    cancelGesture();
                    return true;

                default:
                    return true;
            }
        }

        @Override
        public boolean performClick() {
            super.performClick();
            trigger();
            return true;
        }

        private void trigger() {
            performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            if (onTrigger != null) {
                onTrigger.run();
            }
        }
    }
}
