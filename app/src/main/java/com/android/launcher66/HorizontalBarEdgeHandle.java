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
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handle of the auto-hide horizontal bar when the vertical bar is off: a thin, semi-transparent strip on
 * the left screen edge, as tall as the horizontal bar and level with it, with its two corners facing
 * the middle of the screen slightly rounded. A swipe to the right, or a tap on the strip itself,
 * reveals the bar.
 *
 * <p>It lives in its own TYPE_APPLICATION_OVERLAY window - the window type of the bar overlay -
 * so it stays above the widgets and the PiP panes. Vertically the window is framed exactly like the
 * bar overlay (same type, flags, gravity and height), so the strip is level with the bar. The
 * window is as wide as the vertical bar (computed as a share of the screen like the bar, see
 * {@link EdgeHandleGeometry}), so that a swipe to the right is easy to start: a transparent
 * margin beside the strip takes only that swipe ({@link HorizontalBarEdgeGesture} holds the rules).
 * Anything else that begins in the margin - a tap, a vertical drag, a long press - is handed to
 * the window of the launcher or of the pane that is under the finger, which is always one of the
 * launcher's own windows, so no permission or injected input is needed.
 *
 * <p>The window is added once and then only shown and hidden (a hidden root view hides the whole
 * window, input included). Workspace decides when; this class only draws, animates and reports
 * the gesture. Main thread only.
 */
final class HorizontalBarEdgeHandle {

    private static final String TAG = "HorizontalBarEdgeHandle";

    /** Width of the visible strip, as a share of the longer screen edge. */
    static final float STRIP_WIDTH_FRACTION = 0.01f;

    /** Radius of the two inner corners, as a share of the strip width. */
    private static final float CORNER_RADIUS_FRACTION = 0.4f;
    /** Alpha of the strip colour at rest and while touched (0-255). */
    private static final int IDLE_ALPHA = 0x73;      // ~45 %
    private static final int PRESSED_ALPHA = 0xBF;   // ~75 %

    /** The window a touch is handed to, and a name for the log. */
    static final class Target {
        final View view;
        final String name;
        final EdgePassRoute.TargetKind kind;
        /** The framework's ActivityView under the finger and its display; only for ACTIVITY_VIEW. */
        final View activityView;
        final int displayId;

        Target(View view, String name) {
            this(view, name, EdgePassRoute.TargetKind.LAUNCHER, null, -1);
        }

        Target(View view, String name, EdgePassRoute.TargetKind kind, View activityView, int displayId) {
            this.view = view;
            this.name = name;
            this.kind = kind;
            this.activityView = activityView;
            this.displayId = displayId;
        }
    }

    /** Finds what lies under a point (screen coordinates) among the launcher's own windows. */
    interface TargetFinder {
        Target find(int rawX, int rawY);
    }

    private final WindowManager windowManager;
    private final StripView view;
    private final EdgeHandlePass pass = new EdgeHandlePass();
    private WindowManager.LayoutParams params;
    private boolean attached = false;
    private boolean shown = false;
    private boolean addFailedLogged = false;

    private int touchWidth;
    private int barHeight;

    HorizontalBarEdgeHandle(Context context, Runnable onTrigger, TargetFinder finder) {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        view = new StripView(context, onTrigger, finder, this::onPassEnded);
        // No inset handling, on purpose: the bar overlay's inset listener only pads its content and
        // never resizes its window, so a window of exactly the bar height is what lines up with it.
    }

    /**
     * @param stripWidth width of the visible strip
     * @param touchWidth width of the window, i.e. the width of the vertical bar (never below the strip)
     * @param barHeight  height of the horizontal bar, which the strip matches
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
        pass.show();
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
        if (!pass.requestHide(view.isPassing())) {
            // A gesture has been handed on to the launcher and its replay is what moved the page,
            // which hid the handle. Cancelling it here would end it at its first move, in the middle
            // of that replay. The strip fades, the window stays touchable until the gesture ends
            // (onPassEnded), and then the hide is finished.
            view.animate().cancel();
            view.animate()
                    .alpha(0f)
                    .setStartDelay(0)
                    .setDuration(Math.max(1, durationMs))
                    .setInterpolator(new DecelerateInterpolator())
                    .start();
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

    /** The gesture that was handed on to the launcher ended: a hide that waited for it is finished. */
    private void onPassEnded() {
        if (!pass.passEnded() || !attached || shown) {
            return;
        }
        Log.d(TAG, "Edge handle: hidden after the gesture handed on ended");
        setTouchable(false);
        view.animate().cancel();
        view.setAlpha(0f);
        view.setVisibility(View.INVISIBLE);
    }

    /** Removes the window; the instance must not be used afterwards. */
    void release() {
        shown = false;
        pass.release();
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
        private final TargetFinder finder;
        private final Runnable onPassEnded;
        private final HorizontalBarEdgeGesture gesture;
        private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final Path path = new Path();
        private final RectF rect = new RectF();
        private final float[] radii = new float[8];
        private final int[] windowAt = new int[2];
        private final int[] targetAt = new int[2];

        private int stripWidth;
        private int rgb = 0xFFFFFF;
        private boolean pressed;

        /** The events of the gesture so far, kept until it is decided whom it belongs to. */
        private final List<MotionEvent> held = new ArrayList<>();
        private boolean tracking;
        private Target passing;
        private EdgePassRoute.Route route = EdgePassRoute.Route.VIEW_TREE;
        private final Runnable timeout = this::onTimeout;

        StripView(Context context, Runnable onTrigger, TargetFinder finder, Runnable onPassEnded) {
            super(context);
            this.onTrigger = onTrigger;
            this.finder = finder;
            this.onPassEnded = onPassEnded;
            this.gesture = new HorizontalBarEdgeGesture(
                    ViewConfiguration.get(context).getScaledTouchSlop(), ViewConfiguration.getTapTimeout());
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

        /** A gesture is being handed on to the launcher. */
        boolean isPassing() {
            return passing != null;
        }

        void cancelGesture() {
            removeCallbacks(timeout);
            if (passing != null) {
                MotionEvent cancel = MotionEvent.obtain(SystemClock.uptimeMillis(),
                        SystemClock.uptimeMillis(), MotionEvent.ACTION_CANCEL, 0f, 0f, 0);
                forward(cancel);
                cancel.recycle();
            }
            endGesture();
        }

        private void endGesture() {
            boolean wasPassing = passing != null;
            tracking = false;
            passing = null;
            for (MotionEvent e : held) {
                e.recycle();
            }
            held.clear();
            setStripPressed(false);
            if (wasPassing && onPassEnded != null) {
                onPassEnded.run();
            }
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

        @SuppressLint("ClickableViewAccessibility") // the tap is reported through trigger()
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    endGesture();
                    removeCallbacks(timeout);
                    boolean onStrip = event.getX() < stripWidth;
                    gesture.onDown(event.getX(), event.getY(), event.getEventTime(), onStrip);
                    held.add(MotionEvent.obtain(event));
                    tracking = true;
                    setStripPressed(onStrip);
                    long after = gesture.timeoutAfterMs();
                    if (after >= 0L) {
                        postDelayed(timeout, after);
                    }
                    return true;
                }

                case MotionEvent.ACTION_MOVE: {
                    if (passing != null) {
                        forward(event);
                        return true;
                    }
                    if (!tracking) {
                        return true;   // eaten: the bar is opening, or the gesture was handed on
                    }
                    held.add(MotionEvent.obtain(event));
                    decided(gesture.onMove(event.getX(), event.getY(), event.getEventTime()));
                    return true;
                }

                case MotionEvent.ACTION_UP: {
                    removeCallbacks(timeout);
                    if (passing != null) {
                        forward(event);
                        endGesture();
                        return true;
                    }
                    if (tracking) {
                        held.add(MotionEvent.obtain(event));
                        decided(gesture.onUp(event.getX(), event.getY(), event.getEventTime()));
                    }
                    endGesture();
                    return true;
                }

                case MotionEvent.ACTION_CANCEL:
                    cancelGesture();
                    return true;

                default:
                    // A second finger: not a gesture of the handle; it goes along when passing.
                    if (passing != null) {
                        forward(event);
                    }
                    return true;
            }
        }

        private void onTimeout() {
            if (tracking && passing == null) {
                decided(gesture.onTimeout(SystemClock.uptimeMillis()));
            }
        }

        private void decided(HorizontalBarEdgeGesture.Decision decision) {
            switch (decision) {
                case OPEN_BAR:
                    removeCallbacks(timeout);
                    Log.d(TAG, "Edge handle: open");
                    tracking = false;
                    setStripPressed(false);
                    trigger();
                    break;
                case PASS:
                    removeCallbacks(timeout);
                    startPassing();
                    break;
                default:
                    break;
            }
        }

        /**
         * Hands the gesture to what is under the finger: replays what was held, then goes live. The
         * events are moved to a list of their own first: replaying them moves the page, which hides
         * the handle and (see HorizontalBarEdgeHandle.hide) must not end this gesture under the loop.
         */
        private void startPassing() {
            setStripPressed(false);
            tracking = false;
            List<MotionEvent> replay = EdgeHandlePass.take(held);
            try {
                if (replay.isEmpty()) {
                    return;
                }
                MotionEvent first = replay.get(0);
                Target target = finder == null ? null
                        : finder.find(Math.round(first.getRawX()), Math.round(first.getRawY()));
                if (target == null || target.view == null || !target.view.isAttachedToWindow()) {
                    Log.d(TAG, "Edge handle: pass (nothing under the finger)");
                    return;
                }
                route = EdgePassRoute.of(Build.VERSION.SDK_INT, target.kind);
                if (route == EdgePassRoute.Route.DISPLAY_INJECT
                        && (target.activityView == null || target.displayId < 0)) {
                    route = EdgePassRoute.Route.VIEW_TREE;
                }
                Log.i(TAG, "Edge handle: pass to " + target.name + " via "
                        + (route == EdgePassRoute.Route.DISPLAY_INJECT ? "inject" : "view"));
                passing = target;
                boolean ended = false;
                // The original down time and positions: the target sees the gesture from its start.
                for (MotionEvent e : replay) {
                    if (passing != target) {
                        break;   // the gesture ended in the middle of the replay (a cancel)
                    }
                    forward(e);
                    int action = e.getActionMasked();
                    ended |= action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL;
                }
                if (ended && passing == target) {
                    endGesture();
                }
            } finally {
                for (MotionEvent e : replay) {
                    e.recycle();
                }
            }
        }

        /** The event, moved from this window's coordinates to the target window's. */
        private void forward(MotionEvent event) {
            Target target = passing;
            if (target == null || !target.view.isAttachedToWindow()) {
                return;
            }
            getLocationOnScreen(windowAt);
            if (route == EdgePassRoute.Route.DISPLAY_INJECT) {
                if (injectOnDisplay(target, event)) {
                    return;
                }
                route = EdgePassRoute.Route.VIEW_TREE;   // said once; the rest of the gesture goes the old way
            }
            target.view.getLocationOnScreen(targetAt);
            MotionEvent copy = MotionEvent.obtain(event);
            copy.offsetLocation(windowAt[0] - targetAt[0], windowAt[1] - targetAt[1]);
            try {
                target.view.dispatchTouchEvent(copy);
            } finally {
                copy.recycle();
            }
        }

        /**
         * The event, rebuilt in the coordinates of the ActivityView's display and injected there: from
         * Android 10 the input dispatcher sends a touch on that display to its window by itself, and
         * dispatching it to the view reaches no one. Rebuilt, not copied: before Android 12 the
         * dispatcher ignores the offset of a copy. Needs INJECT_EVENTS (the system uid has it).
         *
         * @return false when it could not be injected; the caller then uses the view tree
         */
        private boolean injectOnDisplay(Target target, MotionEvent event) {
            View av = target.activityView;
            if (av == null || !av.isAttachedToWindow()) {
                return false;
            }
            av.getLocationOnScreen(targetAt);
            final float dx = windowAt[0] - targetAt[0];
            final float dy = windowAt[1] - targetAt[1];
            final int count = event.getPointerCount();
            MotionEvent.PointerProperties[] props = new MotionEvent.PointerProperties[count];
            MotionEvent.PointerCoords[] coords = new MotionEvent.PointerCoords[count];
            for (int p = 0; p < count; p++) {
                props[p] = new MotionEvent.PointerProperties();
                event.getPointerProperties(p, props[p]);
                coords[p] = new MotionEvent.PointerCoords();
                event.getPointerCoords(p, coords[p]);
                coords[p].x += dx;
                coords[p].y += dy;
            }
            // The times are the ones the events came with: they come from uptimeMillis() and grow
            long downTime = event.getDownTime();
            long eventTime = Math.max(event.getEventTime(), downTime);
            MotionEvent out = MotionEvent.obtain(downTime, eventTime, event.getAction(), count, props, coords,
                    event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(),
                    event.getDeviceId(), event.getEdgeFlags(), InputDevice.SOURCE_TOUCHSCREEN, event.getFlags());
            try {
                return EdgeInject.inject(out, target.displayId);
            } finally {
                out.recycle();
            }
        }

        private void trigger() {
            performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            if (onTrigger != null) {
                onTrigger.run();
            }
        }
    }
}
