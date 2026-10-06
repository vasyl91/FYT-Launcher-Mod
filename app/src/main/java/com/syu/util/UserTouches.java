package com.syu.util;

import android.hardware.input.InputManager;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;

import com.android.launcher66.LauncherApplication;

/**
 * When the user last touched the screen.
 *
 * com.syu.ms takes the sound channel the moment a known media app reaches the top, whether the
 * user tapped it or it came up by itself (a pane being started, Spotify resuming on its own). The
 * channel logic in NotificationListener cannot tell the two apart from the channel change alone;
 * a touch shortly before it can.
 *
 * The launcher's own views do not see a tap on an app in a PiP pane: on Android 10 the input
 * dispatcher sends it straight to the window on the pane's virtual display. So the touches are
 * watched with an input monitor on the main display (the hidden InputManager.monitorGestureInput(),
 * as SystemUI's edge back gesture does), which gets every touch on the screen, panes and
 * full-screen apps included, without taking any of them. It needs MONITOR_INPUT, i.e. a platform
 * signed launcher; without it {@link #isMonitoring()} stays false and callers must not rely on a
 * missing touch meaning "not the user".
 */
public final class UserTouches {

    private static final String TAG = "UserTouches";

    private static volatile long sLastTouchMs;
    private static volatile boolean sMonitoring;
    private static Object sMonitor;              // android.view.InputMonitor, kept alive
    private static TouchReceiver sReceiver;
    private static HandlerThread sThread;

    private UserTouches() {
    }

    /** A touch (or key) the launcher saw itself. */
    public static void note() {
        sLastTouchMs = SystemClock.elapsedRealtime();
    }

    /** Milliseconds since the last touch, Long.MAX_VALUE when there was none. */
    public static long sinceLastTouchMs() {
        long at = sLastTouchMs;
        return at == 0L ? Long.MAX_VALUE : SystemClock.elapsedRealtime() - at;
    }

    /** Every touch on the screen is seen, so no recent touch really means no user. */
    public static boolean isMonitoring() {
        return sMonitoring;
    }

    /** Starts the input monitor once per process; only with system privileges. */
    public static synchronized void start() {
        if (sMonitoring || sThread != null) {
            return;
        }
        if (!LauncherApplication.hasSystemPrivileges()) {
            return;
        }
        HandlerThread thread = new HandlerThread("UserTouches");
        try {
            Object im = InputManager.class.getMethod("getInstance").invoke(null);
            Object monitor = im.getClass()
                    .getMethod("monitorGestureInput", String.class, int.class)
                    .invoke(im, "launcher66-user-touches", Display.DEFAULT_DISPLAY);
            InputChannel channel = (InputChannel) monitor.getClass()
                    .getMethod("getInputChannel").invoke(monitor);
            // Its own thread: a monitor that is slow to finish its events would hold the input
            // dispatcher up, and the launcher's main thread does stall now and then.
            thread.start();
            sReceiver = new TouchReceiver(channel, thread);
            sMonitor = monitor;
            sThread = thread;
            sMonitoring = true;
            Log.i(TAG, "Input monitor started");
        } catch (Throwable t) {
            thread.quit();
            Log.w(TAG, "Input monitor not available, touches on the panes are not seen: " + t);
        }
    }

    private static final class TouchReceiver extends InputEventReceiver {
        TouchReceiver(InputChannel channel, HandlerThread thread) {
            super(channel, thread.getLooper());
        }

        @Override
        public void onInputEvent(InputEvent event) {
            try {
                if (event instanceof MotionEvent) {
                    int action = ((MotionEvent) event).getActionMasked();
                    if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
                        note();
                    }
                }
            } finally {
                // Always, or the dispatcher waits on this monitor.
                finishInputEvent(event, false);
            }
        }
    }
}
