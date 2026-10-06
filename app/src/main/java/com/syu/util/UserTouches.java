package com.syu.util;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * When the user last touched the launcher or one of the PiP panes, and which app it was.
 *
 * com.syu.ms takes the sound channel the moment a known media app reaches the top, whether the
 * user tapped it or it came up by itself (a pane being started, Spotify resuming on its own). The
 * channel logic in NotificationListener cannot tell the two apart from the channel change alone;
 * a touch shortly before it can.
 *
 * The panes are windows of the launcher's own process, so every touch on an app shown in a pane
 * passes through the pane's root view first (see {@link #observingFrame}).
 */
public final class UserTouches {

    /** Answers which app was touched, from the event's position in the pane. */
    public interface PackageAt {
        String packageAt(float x, float y);
    }

    private static volatile long sLastTouchMs;
    private static volatile String sLastPackage;

    private UserTouches() {
    }

    /** A touch on the launcher, or on the pane showing {@code pkg} (null when unknown). */
    public static void note(String pkg) {
        sLastTouchMs = SystemClock.elapsedRealtime();
        sLastPackage = pkg;
    }

    /** Milliseconds since the last touch, Long.MAX_VALUE when there was none. */
    public static long sinceLastTouchMs() {
        long at = sLastTouchMs;
        return at == 0L ? Long.MAX_VALUE : SystemClock.elapsedRealtime() - at;
    }

    /** The app the last touch was on, null for the launcher itself. */
    public static String lastPackage() {
        return sLastPackage;
    }

    /** A pane root that records every touch going through it, without taking any. */
    static FrameLayout observingFrame(Context context, PackageAt packageAt) {
        return new FrameLayout(context) {
            @Override
            public boolean dispatchTouchEvent(MotionEvent ev) {
                int action = ev.getActionMasked();
                if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP) {
                    String pkg = null;
                    try {
                        pkg = packageAt.packageAt(ev.getX(), ev.getY());
                    } catch (Throwable ignored) {
                    }
                    note(pkg);
                }
                return super.dispatchTouchEvent(ev);
            }
        };
    }
}
