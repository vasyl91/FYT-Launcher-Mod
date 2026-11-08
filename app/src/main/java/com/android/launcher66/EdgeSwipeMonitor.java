package com.android.launcher66;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * Watches the touches of the edge handle's area with an input monitor on the main display (the hidden
 * InputManager.monitorGestureInput(), as SystemUI's back gesture and {@code UserTouches} do). The monitor
 * sees every touch of the screen, panes and apps on virtual displays included, and takes none; the handle's
 * window takes no touch either, so the input dispatcher gives all of them to the window below, an app in a
 * pane with them, and the launcher does not have to hand anything on. When {@link EdgeMonitorTracker} sees the
 * swipe inwards, the pointers are taken away from the window below ({@code InputMonitor.pilferPointers()}:
 * it gets a cancel instead of a lift, as under SystemUI's back gesture) and the bar opens on the main thread.
 *
 * <p>Needs the system permission for input monitors, i.e. the platform signed launcher, and Android 10. The
 * monitor is created when the handle shows and disposed of when it hides or is released. The events come on a
 * thread of its own: a monitor that is slow to finish its events would hold the input dispatcher up, and the
 * main thread does stall now and then. Every event is finished, always.
 *
 * <p>The area is given from the main thread; the answers are made on the monitor's thread.
 */
final class EdgeSwipeMonitor {

    private static final String TAG = "EdgeSwipeMonitor";

    private final HandlerThread thread;
    private final Object monitor;
    private final Receiver receiver;
    private final Handler main;
    private final Runnable onSwipe;
    private final EdgeMonitorTracker tracker;

    private volatile int left;
    private volatile int top;
    private volatile int right;
    private volatile int bottom;
    private volatile boolean rightEdge;
    private volatile boolean disposed;

    private EdgeSwipeMonitor(HandlerThread thread, Object monitor, InputChannel channel, Handler main,
                             Runnable onSwipe, EdgeMonitorTracker tracker) {
        this.thread = thread;
        this.monitor = monitor;
        this.main = main;
        this.onSwipe = onSwipe;
        this.tracker = tracker;
        this.receiver = new Receiver(channel, thread.getLooper());
    }

    /**
     * Starts a monitor.
     *
     * @param onSwipe run on the main thread when the swipe inwards is recognised
     * @return null if the monitor is not available (no permission, a framework without it)
     */
    static EdgeSwipeMonitor start(Context context, Runnable onSwipe) {
        HandlerThread thread = new HandlerThread("launcher66-edge-handle");
        try {
            Object im = InputManager.class.getMethod("getInstance").invoke(null);
            Object monitor = im.getClass()
                    .getMethod("monitorGestureInput", String.class, int.class)
                    .invoke(im, "launcher66-edge-handle", Display.DEFAULT_DISPLAY);
            InputChannel channel = (InputChannel) monitor.getClass().getMethod("getInputChannel").invoke(monitor);
            thread.start();
            ViewConfiguration configuration = ViewConfiguration.get(context);
            EdgeMonitorTracker tracker = new EdgeMonitorTracker(configuration.getScaledTouchSlop(),
                    ViewConfiguration.getTapTimeout());
            return new EdgeSwipeMonitor(thread, monitor, channel, new Handler(Looper.getMainLooper()), onSwipe, tracker);
        } catch (Throwable t) {
            thread.quit();
            Log.w(TAG, "The input monitor of the edge handle is not available: " + t);
            return null;
        }
    }

    /** The area of the handle's window on the display; main thread. */
    void setArea(int left, int top, int right, int bottom, boolean rightEdge) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.rightEdge = rightEdge;
    }

    /** Stops the monitor and its thread. */
    void dispose() {
        if (disposed) {
            return;
        }
        disposed = true;
        try {
            receiver.dispose();
        } catch (Throwable t) {
            Log.w(TAG, "Disposing of the receiver failed: " + t);
        }
        try {
            monitor.getClass().getMethod("dispose").invoke(monitor);
        } catch (Throwable t) {
            Log.w(TAG, "Disposing of the input monitor failed: " + t);
        }
        thread.quit();
    }

    private void pilfer() {
        try {
            monitor.getClass().getMethod("pilferPointers").invoke(monitor);
        } catch (Throwable t) {
            Log.w(TAG, "pilferPointers failed, the app below keeps the gesture: " + t);
        }
    }

    private final class Receiver extends InputEventReceiver {
        Receiver(InputChannel channel, Looper looper) {
            super(channel, looper);
        }

        @Override
        public void onInputEvent(InputEvent event) {
            try {
                if (!disposed && event instanceof MotionEvent) {
                    handle((MotionEvent) event);
                }
            } finally {
                // Always, or the dispatcher waits on this monitor.
                finishInputEvent(event, false);
            }
        }

        private void handle(MotionEvent e) {
            int action = e.getActionMasked();
            float x = e.getRawX();
            float y = e.getRawY();
            boolean inArea = action == MotionEvent.ACTION_DOWN
                    && x >= left && x < right && y >= top && y < bottom;
            EdgeMonitorTracker.Result result = tracker.onEvent(action, x, y, e.getEventTime(),
                    e.getPointerCount(), inArea, rightEdge);
            if (result == EdgeMonitorTracker.Result.PILFER_AND_OPEN) {
                pilfer();
                Log.d(TAG, "Edge handle: swipe -> open (pilfered)");
                main.post(onSwipe);
            }
        }
    }
}
