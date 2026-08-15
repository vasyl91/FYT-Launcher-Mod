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
 * openMultiplePips() replaces the Launcher's WindowHost with a brand new instance after only
 * calling dismiss() on the old one. dismiss() -> hardRemoveWindow(releaseAVs = false) deliberately
 * does NOT release the old ActivityViews, because ActivityView.release() releases its
 * VirtualDisplay, and releasing a display that still holds the embedded task destroys that task --
 * the app would come back cold instead of resuming its previous state. The price is that every
 * open/remove PiP cycle leaves an orphan VirtualDisplay behind for good (visible in logcat as a
 * growing list of "ActivityViewVirtualDisplay@..." entries in state OFF).
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
 *
 * Every entry serves its own INITIAL_GRACE_MS before the first query: during a takeover in flight
 * a display can momentarily report no stacks, and releasing on that reading is exactly the
 * cold-restart bug this grace period exists to prevent.
 *
 * All state is touched on the main thread only.
 */
public final class WindowHostAvReaper {

    private static final String TAG = "WindowHostAvReaper";

    /** How often the retired displays are re-checked. */
    private static final long CHECK_INTERVAL_MS = 400L;
    /** Per-entry grace period before its first check, so a takeover in flight is not misread. */
    private static final long INITIAL_GRACE_MS = 1500L;
    /** After this long we stop trying and leave the ActivityView alone (old behaviour). */
    private static final long GIVE_UP_MS = 30_000L;
    /** Hard cap on parked entries; the oldest is dropped past this point. */
    private static final int MAX_PENDING = 32;

    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    /** Stable Runnable identity so removeCallbacks() can actually cancel a scheduled poll. */
    private static final Runnable POLL = WindowHostAvReaper::poll;
    private static final List<Entry> pending = new ArrayList<>();
    private static boolean pollScheduled = false;

    private WindowHostAvReaper() { }

    private static final class Entry {
        final Object av;
        final int displayId;
        /** Not queried before this moment -- see INITIAL_GRACE_MS. */
        final long earliestCheck;
        final long deadline;

        Entry(Object av, int displayId) {
            final long now = SystemClock.uptimeMillis();
            this.av = av;
            this.displayId = displayId;
            this.earliestCheck = now + INITIAL_GRACE_MS;
            this.deadline = now + GIVE_UP_MS;
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

    /**
     * Forgets every parked ActivityView without releasing it -- same outcome as the give-up path,
     * so it can never destroy a live task. Call from Launcher#onDestroy(): the parked views hold
     * the Activity, and once that Activity is gone there is nothing left worth waiting for.
     */
    public static void dropAll() {
        MAIN.post(() -> {
            final int dropped = pending.size();
            pending.clear();
            MAIN.removeCallbacks(POLL);
            pollScheduled = false;
            if (dropped > 0) {
                Log.i(TAG, "dropAll: forgot " + dropped + " parked ActivityView(s), none released");
            }
        });
    }

    public static void releaseAll() {
        MAIN.post(() -> {
            final int n = pending.size();
            for (Entry e : pending) {
                releaseNow(e.av, e.displayId, "owner activity destroyed");
            }
            pending.clear();
            MAIN.removeCallbacks(POLL);
            pollScheduled = false;
            if (n > 0) Log.i(TAG, "releaseAll: released " + n + " parked ActivityView(s)");
        });
    }

    // =====================================================================================
    // Internals
    // =====================================================================================

    private static void retireOnMain(Object av) {
        if (av == null) return;
        Log.i(TAG, "retire enter id=" + System.identityHashCode(av));

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

        // Bounded memory: each parked entry keeps an ActivityView (and its Activity context)
        // reachable until it is resolved or times out.
        while (pending.size() >= MAX_PENDING) {
            Entry oldest = pending.remove(0);
            Log.w(TAG, "pending cap reached, dropping oldest displayId=" + oldest.displayId
                    + " (ActivityView left alive)");
        }

        pending.add(new Entry(av, displayId));
        Log.i(TAG, "retired ActivityView, displayId=" + displayId + " (pending=" + pending.size() + ")");
        schedulePoll(INITIAL_GRACE_MS);
    }

    private static void schedulePoll(long delayMs) {
        if (pollScheduled || pending.isEmpty()) return;
        pollScheduled = true;
        MAIN.postDelayed(POLL, delayMs);
    }

    private static void poll() {
        pollScheduled = false;
        if (pending.isEmpty()) return;

        long now = SystemClock.uptimeMillis();

        for (Iterator<Entry> it = pending.iterator(); it.hasNext(); ) {
            Entry e = it.next();

            // Grace period is per entry, not per poll: a poll scheduled for an older entry must
            // not query a freshly parked one before its own takeover has had time to complete.
            if (now < e.earliestCheck) continue;

            Boolean empty = isDisplayEmpty(e.displayId);
            if (empty == null) {
                // Abandoned without release: the ActivityView keeps its TaskStackListener
                // registered, which pins the owning Activity for good.
                Log.w(TAG, "ABANDONED id=" + System.identityHashCode(e.av)
                        + " displayId=" + e.displayId + " reason=cannot query stacks");
                it.remove();
                continue;
            }

            if (empty) {
                it.remove();
                releaseNow(e.av, e.displayId, "display empty");
                continue;
            }

            if (now >= e.deadline) {
                Log.w(TAG, "ABANDONED id=" + System.identityHashCode(e.av)
                        + " displayId=" + e.displayId + " reason=give-up after "
                        + (GIVE_UP_MS / 1000) + "s");
                it.remove();
            }
        }

        schedulePoll(CHECK_INTERVAL_MS);
    }

    private static void releaseNow(Object av, int displayId, String reason) {
        Log.i(TAG, "releaseNow id=" + System.identityHashCode(av)
                + " displayId=" + displayId + " reason=" + reason);
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

    // =====================================================================================
    // ActivityTaskManager query (name and shape of this API differ between platform versions)
    // =====================================================================================

    /** Resolved once: which ATM method answers "what lives on this display". */
    private static Method sStackQuery;
    /** True when sStackQuery takes a displayId and therefore returns a pre-filtered list. */
    private static boolean sStackQueryTakesDisplayId;
    private static boolean sStackQueryResolved;

    /**
     * @return TRUE when no stack/task lives on that display,
     *         FALSE when the display still hosts something,
     *         null when the question cannot be answered on this ROM.
     */
    private static Boolean isDisplayEmpty(int displayId) {
        if (displayId < 0) return Boolean.TRUE;
        try {
            Object atm = getActivityTaskManager();
            if (atm == null) return null;

            Method query = resolveStackQuery(atm);
            if (query == null) return null;

            Object result = sStackQueryTakesDisplayId
                    ? query.invoke(atm, displayId)
                    : query.invoke(atm);
            if (!(result instanceof List)) return null;

            for (Object info : (List<?>) result) {
                if (info == null) continue;

                // The *OnDisplay variants already filter; for the others, skip foreign displays.
                if (!sStackQueryTakesDisplayId) {
                    Integer infoDisplay = readIntField(info, "displayId");
                    if (infoDisplay == null || infoDisplay != displayId) continue;
                }

                if (hostsAnyTask(info)) return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (Throwable t) {
            Log.w(TAG, "isDisplayEmpty failed for displayId=" + displayId, t);
            return null;
        }
    }

    private static Object getActivityTaskManager() {
        try {
            Class<?> atmCls = Class.forName("android.app.ActivityTaskManager");
            Method getService = atmCls.getMethod("getService");
            return getService.invoke(null);
        } catch (Throwable t) {
            return null;
        }
    }

    /**
     * Android 10 exposes getAllStackInfos()/getAllStackInfosOnDisplay(int); Android 11 and newer
     * renamed those to getAllRootTaskInfos()/getAllRootTaskInfosOnDisplay(int). Try the
     * display-filtered variants first -- they are cheaper and need no displayId comparison.
     */
    private static Method resolveStackQuery(Object atm) {
        if (sStackQueryResolved) return sStackQuery;
        sStackQueryResolved = true;

        Class<?> cls = atm.getClass();
        String[] withDisplayId = { "getAllRootTaskInfosOnDisplay", "getAllStackInfosOnDisplay" };
        String[] noArgs        = { "getAllRootTaskInfos", "getAllStackInfos" };

        for (String name : withDisplayId) {
            try {
                Method m = cls.getMethod(name, int.class);
                m.setAccessible(true);
                sStackQuery = m;
                sStackQueryTakesDisplayId = true;
                Log.i(TAG, "using ActivityTaskManager." + name + "(int)");
                return sStackQuery;
            } catch (Throwable ignore) { }
        }
        for (String name : noArgs) {
            try {
                Method m = cls.getMethod(name);
                m.setAccessible(true);
                sStackQuery = m;
                sStackQueryTakesDisplayId = false;
                Log.i(TAG, "using ActivityTaskManager." + name + "()");
                return sStackQuery;
            } catch (Throwable ignore) { }
        }

        Log.w(TAG, "no usable ActivityTaskManager stack query on this platform; reaper is a no-op");
        return null;
    }

    /** StackInfo exposes taskIds; RootTaskInfo (R+) exposes childTaskIds. */
    private static boolean hostsAnyTask(Object info) {
        String[] candidates = { "taskIds", "childTaskIds" };
        for (String name : candidates) {
            try {
                Field f = info.getClass().getField(name);
                Object value = f.get(info);
                if (value instanceof int[]) {
                    return ((int[]) value).length > 0;
                }
            } catch (Throwable ignore) { }
        }
        // Shape not recognised -- assume the display is busy rather than risk a wrong release.
        return true;
    }

    private static Integer readIntField(Object obj, String name) {
        try {
            Field f = obj.getClass().getField(name);
            return f.getInt(obj);
        } catch (Throwable t) {
            return null;
        }
    }
}