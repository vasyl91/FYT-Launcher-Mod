package com.android.launcher66.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;

import androidx.preference.PreferenceManager;

import com.syu.util.WindowHostVdClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Full alpha of the stats window, its background and its text.
 *
 * Since Android 12 the system caps the alpha of a whole not-touchable overlay window (the stats
 * window is one, so the touches go through it) at Settings.Global
 * "maximum_obscuring_opacity_for_touch", 0.8 by default (DisplayPolicy.adjustWindowParamsLw),
 * unless the window is a trusted overlay. A system launcher makes its window one; with root,
 * Shizuku or WRITE_SECURE_SETTINGS the limit is set to 1 for as long as the window is shown, and
 * put back after it. The touches pass in all cases (the flags and the alpha of the window are
 * left as they are).
 */
public final class StatsOverlayAlpha {
    private static final String TAG = "StatsOverlayAlpha";
    static final String LIMIT_KEY = "maximum_obscuring_opacity_for_touch";
    private static final float DEFAULT_LIMIT = 0.8f;

    enum Route { NOT_NEEDED, TRUSTED, WRITE_DIRECT, HOST, SU, UNAVAILABLE }

    enum LimitAction { NOTHING, RAISE, RESTORE, FORGET }

    private StatsOverlayAlpha() {}

    // ---------------------------------------------------------------------------------------
    // Pure decisions
    // ---------------------------------------------------------------------------------------

    static Route route(int sdk, boolean systemUid, boolean internalSystemWindow, boolean writeSecureSettings,
                       boolean privilegedHost, boolean root, float currentLimit) {
        if (sdk < 31 || currentLimit >= 1f) return Route.NOT_NEEDED;
        if (systemUid || internalSystemWindow) return Route.TRUSTED;
        if (writeSecureSettings) return Route.WRITE_DIRECT;
        if (privilegedHost) return Route.HOST;
        if (root) return Route.SU;
        return Route.UNAVAILABLE;
    }

    /** The limit in a Settings value: null, empty or not a number is the default, 0.8. */
    static float parseLimit(String value) {
        if (value == null || value.trim().isEmpty()) return DEFAULT_LIMIT;
        try {
            return Float.parseFloat(value.trim());
        } catch (NumberFormatException e) {
            return DEFAULT_LIMIT;
        }
    }

    /**
     * The window is shown, is not a trusted overlay and the limit is below 1: someone lowered it
     * after we raised it (or never let us), and the window loses its full alpha until we raise it.
     */
    static boolean needsRaise(boolean windowShown, boolean trustedApplied, float currentLimit) {
        return windowShown && !trustedApplied && currentLimit < 1f;
    }

    static LimitAction limitAction(boolean windowShown, boolean raisedByUs, String currentValue) {
        boolean full = parseLimit(currentValue) >= 1f;
        if (windowShown) return full ? LimitAction.NOTHING : LimitAction.RAISE;
        if (!raisedByUs) return LimitAction.NOTHING;
        return full ? LimitAction.RESTORE : LimitAction.FORGET;
    }

    // ---------------------------------------------------------------------------------------
    // The thin layer with a Context
    // ---------------------------------------------------------------------------------------

    /** Created on first use: the pure decisions above run in a JVM test with no Android. */
    private static final class MainHolder {
        static final Handler MAIN = new Handler(Looper.getMainLooper());
    }
    private static final HideDebounce DEBOUNCE = new HideDebounce();
    /** One thread: the host and su block, and the last task is the one that counts. */
    private static final class ExecutorHolder {
        static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "StatsOverlayAlpha");
            t.setDaemon(true);
            return t;
        });
    }

    private static volatile boolean desiredShown;
    /** The window of this addView is a trusted overlay: the limit does not matter to it. */
    private static volatile boolean trustedApplied;
    private static volatile Context sApp;
    private static volatile Runnable sOnRaised;
    private static boolean listenerAdded;
    /** How often the limit is looked at while the window is shown, in case no change is reported. */
    private static final long CHECK_INTERVAL_MS = 60_000L;
    /** Main thread only. */
    private static ContentObserver sLimitObserver;

    private static final class Tasks {
        static final Runnable HIDE_TASK = () -> {
            if (DEBOUNCE.due(SystemClock.uptimeMillis())) {
                desiredShown = false;
                stopWatching();
                submit();
            }
        };

        /** Main thread: looks at the limit and asks again in a minute for as long as the window is shown. */
        static final Runnable CHECK_TASK = new Runnable() {
            @Override
            public void run() {
                if (!desiredShown) return;
                submit();
                MainHolder.MAIN.postDelayed(this, CHECK_INTERVAL_MS);
            }
        };

        static final WindowHostVdClient.Listener HOST_LISTENER = available -> {
            if (available) submit();     // the task decides itself whether to raise or to restore
        };
    }

    /** Main thread, no I/O. Before every addView of the stats window. */
    static void applyBeforeAdd(Context context, WindowManager.LayoutParams params) {
        trustedApplied = false;
        try {
            // Not route(): it also asks hasRoot() and the host, which is of no interest here and
            // used to cost five File.exists() on the main thread before every addView.
            boolean trusted = Build.VERSION.SDK_INT >= 31 && currentLimit(context) < 1f
                    && (Process.myUid() == Process.SYSTEM_UID
                    || granted(context, "android.permission.INTERNAL_SYSTEM_WINDOW"));
            if (trusted) {
                try {
                    WindowManager.LayoutParams.class.getMethod("setTrustedOverlay").invoke(params);
                    trustedApplied = true;
                    Log.i(TAG, "route TRUSTED: trusted overlay, the limit is left alone");
                } catch (Throwable t) {
                    // WRITE_SECURE_SETTINGS (a system app has it) or the host or su do it instead
                    Log.w(TAG, "route TRUSTED: setTrustedOverlay failed: " + t);
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "applyBeforeAdd failed: " + t);
        }
    }

    /** Main thread. The stats window was added: the limit goes to 1, then onRaised (main thread). */
    static void onWindowShown(Context context, Runnable onRaised) {
        sApp = context.getApplicationContext();
        sOnRaised = onRaised;
        MainHolder.MAIN.removeCallbacks(Tasks.HIDE_TASK);
        DEBOUNCE.onShown(SystemClock.uptimeMillis());
        desiredShown = true;
        addHostListener();
        startWatching(context.getApplicationContext());
        submit();
    }

    /** Main thread. The window was removed: the limit goes back 3 s later unless the window is back. */
    static void onWindowHidden(Context context) {
        sApp = context.getApplicationContext();
        DEBOUNCE.onHidden(SystemClock.uptimeMillis());
        MainHolder.MAIN.postDelayed(Tasks.HIDE_TASK, HideDebounce.DELAY_MS);
    }

    /** The service stops or starts: the limit goes back at once if we raised it. */
    static void onWindowHiddenNow(Context context) {
        sApp = context.getApplicationContext();
        MainHolder.MAIN.removeCallbacks(Tasks.HIDE_TASK);
        desiredShown = false;
        stopWatching();
        // Also when the host is not there yet (a start before Shizuku): the listener makes the
        // restore happen once it connects.
        addHostListener();
        submit();
    }

    /**
     * Main thread. While the window is shown the limit is watched, so that a full alpha lost to
     * someone else's write is brought back: by the setting's observer and, in case the system
     * reports nothing, by a look every minute.
     */
    private static void startWatching(Context app) {
        if (sLimitObserver == null) {
            sLimitObserver = new ContentObserver(MainHolder.MAIN) {
                @Override
                public void onChange(boolean selfChange) {
                    Context c = sApp;
                    if (c != null && needsRaise(desiredShown, trustedApplied, currentLimit(c))) {
                        submit();
                    }
                }
            };
            try {
                app.getContentResolver().registerContentObserver(
                        Settings.Global.getUriFor(LIMIT_KEY), false, sLimitObserver);
            } catch (Throwable t) {
                Log.w(TAG, "cannot watch the limit: " + t);
                sLimitObserver = null;
            }
        }
        MainHolder.MAIN.removeCallbacks(Tasks.CHECK_TASK);
        MainHolder.MAIN.postDelayed(Tasks.CHECK_TASK, CHECK_INTERVAL_MS);
    }

    /** Main thread. The window is gone: nothing to keep at full alpha. */
    private static void stopWatching() {
        MainHolder.MAIN.removeCallbacks(Tasks.CHECK_TASK);
        ContentObserver observer = sLimitObserver;
        sLimitObserver = null;
        Context app = sApp;
        if (observer != null && app != null) {
            try {
                app.getContentResolver().unregisterContentObserver(observer);
            } catch (Throwable t) {
                Log.w(TAG, "cannot stop watching the limit: " + t);
            }
        }
    }

    private static void addHostListener() {
        if (listenerAdded) return;
        listenerAdded = true;
        WindowHostVdClient.addListener(Tasks.HOST_LISTENER);
    }

    private static void submit() {
        try {
            ExecutorHolder.EXECUTOR.execute(StatsOverlayAlpha::sync);
        } catch (Throwable t) {
            Log.w(TAG, "task rejected: " + t);
        }
    }

    /** On the executor: brings the limit to what desiredShown says. */
    private static void sync() {
        final Context app = sApp;
        if (app == null) return;
        try {
            boolean shown = desiredShown;
            ContentResolver cr = app.getContentResolver();
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(app);
            boolean raised = prefs.getBoolean(Keys.STATS_OBSCURING_RAISED, false);
            String current = Settings.Global.getString(cr, LIMIT_KEY);
            LimitAction action = limitAction(shown, raised, current);
            if (action == LimitAction.NOTHING) return;
            if (action == LimitAction.FORGET) {
                prefs.edit().remove(Keys.STATS_OBSCURING_RAISED).remove(Keys.STATS_OBSCURING_ORIGINAL).commit();
                Log.i(TAG, "FORGET: the limit is " + current + ", changed by someone else; left alone");
                return;
            }
            // How to write: not as a trusted overlay (that is not a way to write), and whatever
            // the limit is now (the route() for a limit of 1 says NOT_NEEDED)
            Route write = route(Build.VERSION.SDK_INT, false, false,
                    granted(app, "android.permission.WRITE_SECURE_SETTINGS"),
                    WindowHostVdClient.hasPrivilegedHost(), WindowHostVdClient.hasRoot(), 0f);
            if (action == LimitAction.RAISE) {
                if (trustedApplied) {
                    Log.i(TAG, "RAISE: not needed, the window is a trusted overlay");
                    return;
                }
                if (write == Route.NOT_NEEDED || write == Route.UNAVAILABLE) {
                    Log.w(TAG, "RAISE: route " + write + ", the limit stays " + current);
                    return;
                }
                if (raised) {
                    Log.w(TAG, "RAISE again: the limit was " + current + " while the window was shown");
                }
                SharedPreferences.Editor e = prefs.edit();
                if (!raised) {
                    if (current == null) e.remove(Keys.STATS_OBSCURING_ORIGINAL);
                    else e.putString(Keys.STATS_OBSCURING_ORIGINAL, current);
                }
                e.putBoolean(Keys.STATS_OBSCURING_RAISED, true).commit();
                String result = write(app, write, "1");
                float after = currentLimit(app);
                for (int i = 0; i < 10 && after < 1f && desiredShown; i++) {   // WMS observes the setting
                    SystemClock.sleep(100);
                    after = currentLimit(app);
                }
                Log.i(TAG, "RAISE: route " + write + ", " + current + " -> " + after
                        + ", original " + (raised ? "kept" : current) + ", result " + result);
                final Runnable onRaised = sOnRaised;
                if (after >= 1f && onRaised != null && desiredShown) MainHolder.MAIN.post(onRaised);
            } else {   // RESTORE
                if (write == Route.NOT_NEEDED || write == Route.UNAVAILABLE) {
                    Log.i(TAG, "RESTORE: route " + write + ", the limit stays " + current
                            + ", deferred until a host is available");
                    return;
                }
                String original = prefs.getString(Keys.STATS_OBSCURING_ORIGINAL, null);
                String result = write(app, write, original);
                Log.i(TAG, "RESTORE: route " + write + ", " + current + " -> "
                        + (original == null ? "(deleted)" : original) + ", result " + result);
                if (result != null) {
                    prefs.edit().remove(Keys.STATS_OBSCURING_RAISED).remove(Keys.STATS_OBSCURING_ORIGINAL).commit();
                }
            }
        } catch (Throwable t) {
            Log.w(TAG, "task failed", t);
        }
    }

    /** value null: delete the setting. @return a report, null when nothing could write it */
    private static String write(Context app, Route route, String value) {
        if (route == Route.WRITE_DIRECT) {
            try {
                Settings.Global.putString(app.getContentResolver(), LIMIT_KEY, value);
                return "OK (direct)";
            } catch (Throwable t) {
                Log.w(TAG, "direct write failed: " + t);
                return null;
            }
        }
        if (route == Route.HOST) {
            try {
                String r = WindowHostVdClient.setObscuringOpacityLimit(app.getPackageName(), value);
                if (r != null) return r;
            } catch (Throwable t) {
                Log.w(TAG, "host write failed: " + t);
            }
            if (!WindowHostVdClient.hasRoot()) return null;
            route = Route.SU;      // an old daemon does not know the call
        }
        if (route == Route.SU) {
            String cmd = value == null
                    ? "settings delete global " + LIMIT_KEY
                    : "settings put global " + LIMIT_KEY + " " + value;
            return su(cmd) ? "OK (su)" : null;
        }
        return null;
    }

    /** Runs one command as root with a timeout. true when it exited 0. */
    private static boolean su(String command) {
        java.lang.Process p = null;
        try {
            p = new ProcessBuilder("su", "-c", command).redirectErrorStream(true).start();
            p.getOutputStream().close();
            final java.io.InputStream in = p.getInputStream();
            byte[] buf = new byte[512];
            while (in.available() > 0 && in.read(buf) > 0) { /* drained */ }
            if (!p.waitFor(5, TimeUnit.SECONDS)) {
                Log.w(TAG, "su timed out: " + command);
                return false;
            }
            return p.exitValue() == 0;
        } catch (Exception e) {
            Log.w(TAG, "su failed", e);
            return false;
        } finally {
            if (p != null) p.destroy();
        }
    }

    private static boolean granted(Context c, String permission) {
        return c.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    /** InputManager.getMaximumObscuringOpacityForTouch(), 0.8 when it cannot be read. */
    private static float currentLimit(Context c) {
        try {
            Object im = c.getSystemService(Context.INPUT_SERVICE);
            return ((Float) im.getClass().getMethod("getMaximumObscuringOpacityForTouch").invoke(im));
        } catch (Throwable t) {
            return DEFAULT_LIMIT;
        }
    }
}
