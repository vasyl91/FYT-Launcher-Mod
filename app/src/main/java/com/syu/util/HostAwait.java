package com.syu.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.LauncherApplication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

/**
 * Waiting for a VD host that is on its way, so that nothing has to give up on it or ask again and
 * again. Without system rights the host is root's FYT VDHost daemon or Shizuku; on the 7870
 * (Android 13, Shizuku Next over wireless ADB) Shizuku starts minutes after the launcher, or
 * only when the user starts it. The consumers that used to look once and fall back (the log
 * capture, the PiP ensure after a wake, the accessibility and WRITE_SETTINGS steps) wait here
 * instead, with a limit of their own after which they do what they did before.
 *
 * No polling: the arrival is WindowHostVdClient's onHostChanged(true), the limit one delayed
 * message. This is not WindowHostVdClient.canHostPanes(): that one means "a host is there or
 * would be there", and stays as it is for the panes, which time out on a missing host on their
 * own (15 s); "on its way" only suits a caller that goes on by itself when the host comes.
 */
public final class HostAwait {
    private static final String TAG = "HostAwait";

    /** Shizuku started through wireless ADB after a boot comes a minute or two after the launcher. */
    public static final long WAIT_COLD_BOOT_MS = 180_000L;
    /** After a wake: Shizuku is usually running already and its binder is back within seconds. */
    public static final long WAIT_WAKE_MS = 60_000L;
    public static final long WAIT_SHORT_MS = 15_000L;

    /** How often awaitBlocking() looks at whether its caller still wants the host. */
    private static final long BLOCKING_STEP_MS = 500L;

    public interface Callback {
        /** Main thread. attached: a VD host is there; false: it did not come in time, or none is expected. */
        void onResult(boolean attached);
    }

    /** Whether the Shizuku app is installed: read off the main thread, see shizukuInstalled(). */
    private static volatile Boolean sShizukuInstalled;
    private static final AtomicBoolean sShizukuReadRunning = new AtomicBoolean();
    private static Handler sMain;

    private HostAwait() {}

    private static synchronized Handler main() {
        if (sMain == null) sMain = new Handler(Looper.getMainLooper());
        return sMain;
    }

    private static boolean onMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    // ---------------------------------------------------------------- is a host expected

    /**
     * The host is not there yet but may come: no system rights, nothing attached, and the module
     * installed or Shizuku installed (and not refused for good). Does not call the PackageManager
     * on the main thread, see shizukuInstalled().
     */
    public static boolean isExpected(Context context) {
        boolean systemUid = WindowHostVdClient.isSystemUid();
        boolean attached = WindowHostVdClient.current() != null;
        if (systemUid || attached) return false;
        return expected(false, false, WindowHostVdClient.isModuleInstalled(),
                shizukuInstalled(context), WindowHostVdShizuku.isDeniedForGood());
    }

    static boolean expected(boolean systemUid, boolean attached, boolean moduleInstalled,
                            boolean shizukuInstalled, boolean shizukuDeniedForGood) {
        return !systemUid && !attached
                && (moduleInstalled || (shizukuInstalled && !shizukuDeniedForGood));
    }

    /** Reads whether Shizuku is installed, off the main thread; the answer is kept. Call it at the start. */
    public static void warmUp(Context context) {
        if (sShizukuInstalled != null) return;
        sShizukuInstalled = WindowHostVdClient.isShizukuInstalled(context);
    }

    /**
     * The Shizuku app is installed. On the main thread the PackageManager is not asked: while the
     * answer is not there yet (a start, before warmUp() has run) it is read in the background and
     * the host counts as on its way. A wait is bounded, so a wrong "yes" costs at most its limit.
     */
    private static boolean shizukuInstalled(Context context) {
        Boolean known = sShizukuInstalled;
        if (known != null) return known;
        if (!onMainThread()) {
            warmUp(context);
            return sShizukuInstalled;
        }
        final Context app = context.getApplicationContext();
        if (sShizukuReadRunning.compareAndSet(false, true)) {
            new Thread(() -> {
                try {
                    warmUp(app);
                } finally {
                    sShizukuReadRunning.set(false);
                }
            }, "HostAwait-shizuku").start();
        }
        return true;
    }

    // ---------------------------------------------------------------- waiting, main thread

    /** A wait started with await(); cancel() ends it without a result. */
    public static final class Handle {
        private final String what;
        private final long timeoutMs;
        private final Callback callback;
        private final long beganMs = SystemClock.elapsedRealtime();
        /** Main thread only. */
        private boolean done;
        private boolean registered;
        private final WindowHostVdClient.Listener listener = available -> {
            if (available) finish(true);
        };
        private final Runnable timeout = () -> finish(false);

        private Handle(String what, long timeoutMs, Callback callback) {
            this.what = what;
            this.timeoutMs = timeoutMs;
            this.callback = callback;
        }

        private void register() {
            registered = true;
            WindowHostVdClient.addListener(listener);
            main().postDelayed(timeout, timeoutMs);
            // Attached between the check of the caller and the listener: that one is not announced again.
            if (WindowHostVdClient.current() != null) finish(true);
        }

        private void unregister() {
            if (!registered) return;
            registered = false;
            WindowHostVdClient.removeListener(listener);
            main().removeCallbacks(timeout);
        }

        private void finish(boolean attached) {
            complete(attached, true);
        }

        /** The answer of a case that needed no waiting: nothing to log. */
        private void finishQuietly(boolean attached) {
            complete(attached, false);
        }

        private void complete(boolean attached, boolean log) {
            if (done) return;
            done = true;
            unregister();
            if (log) {
                long waited = SystemClock.elapsedRealtime() - beganMs;
                if (attached) {
                    Log.i(TAG, what + ": VD host attached after " + waited / 1000L + " s");
                } else {
                    Log.i(TAG, what + ": no VD host within " + timeoutMs / 1000L + " s");
                }
            }
            callback.onResult(attached);
        }

        /** Ends the wait: no result is delivered, the listener and the limit are gone. */
        public void cancel() {
            if (!onMainThread()) {
                main().post(this::cancel);
                return;
            }
            done = true;
            unregister();
        }
    }

    /**
     * Calls back when a VD host attaches, or after timeoutMs; main thread only. A host that is
     * already there, or none that could come, is answered at once (posted, so the callback is never
     * inside this call). Otherwise one line is logged now and one at the end.
     *
     * @param what names the waiter in the log, e.g. "PiP ensure"
     */
    public static Handle await(long timeoutMs, String what, Callback cb) {
        Handle handle = new Handle(what, timeoutMs, cb);
        if (!onMainThread()) {
            Log.w(TAG, what + ": await() is for the main thread, answered with no host");
            main().post(() -> handle.finishQuietly(false));
            return handle;
        }
        Context app = LauncherApplication.sApp;
        if (WindowHostVdClient.current() != null) {
            main().post(() -> handle.finishQuietly(true));
        } else if (app == null || !isExpected(app)) {
            main().post(() -> handle.finishQuietly(false));
        } else {
            Log.i(TAG, what + ": waiting up to " + timeoutMs / 1000L + " s for the VD host (Shizuku)");
            handle.register();
        }
        return handle;
    }

    // ---------------------------------------------------------------- waiting, worker thread

    /**
     * Blocks until a VD host attaches, timeoutMs passes, or stillWanted says no; worker threads
     * only (on the main thread it returns false at once). The caller looks at stillWanted every
     * BLOCKING_STEP_MS: that is only so that it can stop waiting, the arrival is the listener's
     * event and releases the wait at once. Unlike await() it does not ask whether a host is
     * expected: its callers know one was there and went away.
     *
     * @return whether a VD host is attached
     */
    public static boolean awaitBlocking(long timeoutMs, BooleanSupplier stillWanted) {
        if (onMainThread()) {
            Log.w(TAG, "awaitBlocking() on the main thread, not waiting");
            return false;
        }
        if (WindowHostVdClient.current() != null) return true;
        final CountDownLatch arrived = new CountDownLatch(1);
        final WindowHostVdClient.Listener listener = available -> {
            if (available) arrived.countDown();
        };
        main().post(() -> {
            WindowHostVdClient.addListener(listener);
            if (WindowHostVdClient.current() != null) arrived.countDown();
        });
        try {
            long deadline = SystemClock.elapsedRealtime() + timeoutMs;
            while (true) {
                long left = deadline - SystemClock.elapsedRealtime();
                if (left <= 0L) return WindowHostVdClient.current() != null;
                if (arrived.await(Math.min(left, BLOCKING_STEP_MS), TimeUnit.MILLISECONDS)) return true;
                if (!stillWanted.getAsBoolean()) return WindowHostVdClient.current() != null;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            main().post(() -> WindowHostVdClient.removeListener(listener));
        }
    }
}
