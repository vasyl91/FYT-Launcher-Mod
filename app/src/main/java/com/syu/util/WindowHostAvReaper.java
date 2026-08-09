package com.syu.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Deferred release of ActivityViews that no longer belong to the live WindowHost.
 *
 * openMultiplePips() replaces mWindowHost with a brand new instance after only calling
 * dismiss() on the old one. dismiss() -> hardRemoveWindow(releaseAVs = false) deliberately does
 * NOT release the old ActivityViews, because ActivityView.release() releases its VirtualDisplay,
 * and releasing a display that still holds the embedded task destroys that task -- the app would
 * come back cold instead of resuming its previous state. The price is that every open/remove PiP
 * cycle leaves an orphan VirtualDisplay behind for good (visible in logcat as a growing list of
 * "ActivityViewVirtualDisplay@..." entries in state OFF).
 *
 * The retired ActivityView is parked here instead of being released. A poll on the main thread
 * asks ActivityTaskManager whether the retired ActivityView's VirtualDisplay still hosts any
 * stack/task:
 *
 *   - display already empty  -> the new pane has taken the task over; release is safe, do it.
 *   - display still busy     -> keep waiting.
 *   - still busy after GIVE_UP_MS, or the check itself is unavailable -> forget about it and
 *     leak exactly as the code did before. This class can never be worse than the old behaviour.
 *
 * It NEVER releases an ActivityView whose display still holds a task. That is the whole point.
 */
public final class WindowHostAvReaper {

    private static final String TAG = "WindowHostAvReaper";

    /** How often the retired displays are re-checked. */
    private static final long CHECK_INTERVAL_MS = 400L;
    /** Grace period before the first check, so a takeover in flight is not misread. */
    private static final long INITIAL_GRACE_MS = 1500L;
    /** After this long we stop trying and leave the ActivityView alone (old behaviour). */
    private static final long GIVE_UP_MS = 30_000L;

    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    private static final List<Entry> pending = new ArrayList<>();
    private static boolean pollScheduled = false;

    private WindowHostAvReaper() { }

    private static final class Entry {
        final Object av;
        final int displayId;
        final long deadline;

        Entry(Object av, int displayId) {
            this.av = av;
            this.displayId = displayId;
            this.deadline = SystemClock.uptimeMillis() + GIVE_UP_MS;
        }
    }

    // =====================================================================================
    // Public API
    // =====================================================================================

    public static void retire(Object av) {
        if (av == null) return;
        MAIN.post(() -> retireOnMain(av));
    }

    public static void retireAll(Collection<Object> avs) {
        if (avs == null || avs.isEmpty()) return;
        final List<Object> copy = new ArrayList<>(avs);
        MAIN.post(() -> {
            for (Object av : copy) retireOnMain(av);
        });
    }

    // =====================================================================================
    // Internals
    // =====================================================================================

    private static void retireOnMain(Object av) {
        if (av == null) return;

        detachFromParent(av);

        int displayId = WindowHostActivityView.getVirtualDisplayId(av);
        if (displayId < 0) {
            // Never got a VirtualDisplay (or it is already gone) -- nothing can be hosted on it.
            releaseNow(av, -1, "no virtual display");
            return;
        }

        for (Entry e : pending) {
            if (e.av == av) return; // already parked
        }

        pending.add(new Entry(av, displayId));
        Log.i(TAG, "retired ActivityView, displayId=" + displayId + " (pending=" + pending.size() + ")");
        schedulePoll(INITIAL_GRACE_MS);
    }

    private static void schedulePoll(long delayMs) {
        if (pollScheduled || pending.isEmpty()) return;
        pollScheduled = true;
        MAIN.postDelayed(WindowHostAvReaper::poll, delayMs);
    }

    private static void poll() {
        pollScheduled = false;
        if (pending.isEmpty()) return;

        long now = SystemClock.uptimeMillis();

        for (Iterator<Entry> it = pending.iterator(); it.hasNext(); ) {
            Entry e = it.next();

            Boolean empty = isDisplayEmpty(e.displayId);
            if (empty == null) {
                // Cannot tell -> behave exactly like the old code and stop tracking it.
                Log.w(TAG, "cannot query stacks for displayId=" + e.displayId + ", leaving ActivityView alone");
                it.remove();
                continue;
            }

            if (empty) {
                it.remove();
                releaseNow(e.av, e.displayId, "display empty");
                continue;
            }

            if (now >= e.deadline) {
                Log.w(TAG, "displayId=" + e.displayId + " still hosts a task after "
                        + (GIVE_UP_MS / 1000) + "s, giving up (ActivityView left alive)");
                it.remove();
            }
        }

        schedulePoll(CHECK_INTERVAL_MS);
    }

    private static void releaseNow(Object av, int displayId, String reason) {
        try {
            detachFromParent(av);
            WindowHostActivityView.release(av);
            Log.i(TAG, "released retired ActivityView (displayId=" + displayId + ", " + reason + ")");
        } catch (Throwable t) {
            Log.w(TAG, "release of retired ActivityView failed", t);
        }
    }

    private static void detachFromParent(Object av) {
        try {
            View v = WindowHostActivityView.asView(av);
            if (v == null) return;
            ViewParent p = v.getParent();
            if (p instanceof ViewGroup) ((ViewGroup) p).removeView(v);
        } catch (Throwable ignore) { }
    }

    /**
     * @return TRUE when no stack with at least one task lives on that display,
     *         FALSE when the display still hosts something,
     *         null when the question cannot be answered on this ROM.
     */
    private static Boolean isDisplayEmpty(int displayId) {
        if (displayId < 0) return Boolean.TRUE;
        try {
            Class<?> atmCls = Class.forName("android.app.ActivityTaskManager");
            Method getService = atmCls.getMethod("getService");
            Object atm = getService.invoke(null);
            if (atm == null) return null;

            Method getAllStackInfos = atm.getClass().getMethod("getAllStackInfos");
            getAllStackInfos.setAccessible(true);
            Object result = getAllStackInfos.invoke(atm);
            if (!(result instanceof List)) return null;

            for (Object stackInfo : (List<?>) result) {
                if (stackInfo == null) continue;

                Field fDisplay = stackInfo.getClass().getField("displayId");
                if (fDisplay.getInt(stackInfo) != displayId) continue;

                Field fTasks = stackInfo.getClass().getField("taskIds");
                Object taskIds = fTasks.get(stackInfo);
                if (taskIds instanceof int[] && ((int[]) taskIds).length > 0) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        } catch (Throwable t) {
            Log.w(TAG, "isDisplayEmpty failed for displayId=" + displayId, t);
            return null;
        }
    }
}
