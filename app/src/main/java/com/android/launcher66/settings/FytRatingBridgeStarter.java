package com.android.launcher66.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Brings the fYT Rating bridge up, from every place where the launcher starts or comes back: the start of
 * the process, each resume, the end of a wake of the screen and the return from the bridge to the settings.
 * The rules (one sequence at a time, the pauses) are in {@link BridgeStartPolicy}.
 *
 * <p>Everything blocking (the pings wait for the bridge's reply) runs on one background thread; only the
 * start of the wake activity is posted to the main thread.
 */
public final class FytRatingBridgeStarter {

    private static final String TAG = "FytRatingBridge";

    private static final BridgeStartPolicy POLICY = new BridgeStartPolicy();
    private static final ScheduledExecutorService EXEC = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread t = new Thread(r, "fyt-rating-bridge-start");
        t.setDaemon(true);
        return t;
    });
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** The launcher activity while it is resumed: the one context that may start the wake activity. */
    private static volatile WeakReference<Activity> sResumedLauncher = new WeakReference<>(null);

    private FytRatingBridgeStarter() {
    }

    /** Launcher.onResume. */
    public static void onLauncherResumed(Activity launcher) {
        sResumedLauncher = new WeakReference<>(launcher);
    }

    /** Launcher.onPause. */
    public static void onLauncherPaused(Activity launcher) {
        Activity current = sResumedLauncher.get();
        if (current == launcher) {
            sResumedLauncher = new WeakReference<>(null);
        }
    }

    /**
     * A reason to look for the bridge. Cheap on the calling thread: a sequence is queued, or nothing when one
     * is running or the bridge is not installed.
     */
    public static void start(Context context, String trigger) {
        if (context == null) {
            return;
        }
        final Context app = context.getApplicationContext();
        EXEC.execute(() -> {
            if (!FytRating.isInstalled(app)) {
                return;
            }
            if (!POLICY.begin()) {
                return;
            }
            attempt(app, trigger);
        });
    }

    /** One attempt, on the background thread. */
    private static void attempt(Context app, String trigger) {
        boolean answered = ping(app);
        String wake = "none";
        if (!answered) {
            if (POLICY.mayRetryBroadcastLaunch(SystemClock.elapsedRealtime())) {
                FytRating.retryBroadcastLaunch();
            }
            final Activity launcher = sResumedLauncher.get();
            if (BridgeStartPolicy.mayWakeByActivity(SystemClock.elapsedRealtime(), launcher != null)) {
                wake = "activity";
                MAIN.post(() -> {
                    if (!FytRating.wake(launcher)) {
                        Log.d(TAG, "The wake activity could not be started");
                    }
                });
            } else {
                wake = "broadcast";   // the second ping is the broadcast that may launch it
            }
            // Whatever was cached described a process that was not answering
            FytRating.resetTransport();
            try {
                Thread.sleep(BridgeStartPolicy.PING_AFTER_WAKE_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                POLICY.stopped();
                return;
            }
            answered = ping(app);
        }
        if (answered) {
            POLICY.answered();
            Log.i(TAG, "bridge start (" + trigger + "): ping -> answered, wake " + wake + ", next in 0 s");
            return;
        }
        if (sResumedLauncher.get() == null) {
            POLICY.stopped();
            Log.i(TAG, "bridge start (" + trigger + "): ping -> no answer, wake " + wake
                    + ", next in 0 s (the launcher is not resumed)");
            return;
        }
        long delay = POLICY.unansweredDelayMs();
        Log.i(TAG, "bridge start (" + trigger + "): ping -> no answer, wake " + wake + ", next in "
                + delay / 1000 + " s");
        EXEC.schedule(() -> {
            if (sResumedLauncher.get() == null) {
                POLICY.stopped();
                return;
            }
            attempt(app, "retry");
        }, delay, TimeUnit.MILLISECONDS);
    }

    /** Blocking. Asks for the status and tells the settings, which draw what the bridge said. */
    private static boolean ping(Context app) {
        FytRating.refreshStatus(app);
        boolean answered = FytRating.isBridgeAnswering();
        FytRating.setNoAnswer(!answered);
        MAIN.post(FytRating::notifyStateChanged);
        return answered;
    }
}
