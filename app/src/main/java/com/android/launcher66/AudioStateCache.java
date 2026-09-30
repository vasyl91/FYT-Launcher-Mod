package com.android.launcher66;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * AudioManager.isMusicActive() that can never freeze its caller.
 *
 * The call is answered by the audioserver. At boot this ROM's audioserver hangs and is restarted
 * (TimeCheck on IAudioFlinger, about ten seconds without audio), and a single call made on the
 * main thread then froze the whole launcher for that long. Stall report from the capture of
 * 28-09-2026 20:41: AudioSystem.isStreamActive <- AudioManager.isMusicActive <-
 * NotificationListener$RunTaskRunnable.run.
 *
 * Here the call always runs on one background thread. At most one probe is in flight, however
 * long the audioserver takes, and callers get either a fresh answer or the last known one.
 */
public final class AudioStateCache {

    private static final String TAG = "AudioStateCache";

    private static final ExecutorService PROBE_THREAD = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "AudioStateProbe");
        t.setDaemon(true);
        return t;
    });

    private static volatile boolean sMusicActive;

    /** The probe in flight, or the last one. Guarded by AudioStateCache.class. */
    private static Future<?> sProbe;

    private AudioStateCache() {
    }

    /**
     * The last known answer; a fresh one is asked for in the background and is what the next call
     * returns. Never blocks. Meant for pollers, which are then at most one poll behind.
     */
    public static boolean isMusicActive(Context context) {
        probe(context);
        return sMusicActive;
    }

    /**
     * Waits at most waitMs for a fresh answer. Normally that takes a few milliseconds, so this
     * behaves like the plain call; while the audioserver does not answer, the last known answer is
     * returned after waitMs instead of freezing the caller.
     */
    public static boolean isMusicActive(Context context, long waitMs) {
        Future<?> probe = probe(context);
        if (waitMs > 0L) {
            try {
                probe.get(waitMs, TimeUnit.MILLISECONDS);
            } catch (TimeoutException e) {
                // The audioserver is not answering: keep the last known answer.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                // Cannot happen, the probe catches everything itself.
            }
        }
        return sMusicActive;
    }

    /** The probe in flight, or a new one once the previous has finished. */
    private static synchronized Future<?> probe(Context context) {
        if (sProbe != null && !sProbe.isDone()) {
            return sProbe;
        }
        Context app = context.getApplicationContext();
        final Context ctx = app != null ? app : context;
        sProbe = PROBE_THREAD.submit(() -> {
            try {
                AudioManager am = (AudioManager) ctx.getSystemService(Context.AUDIO_SERVICE);
                if (am != null) {
                    sMusicActive = am.isMusicActive();
                }
            } catch (RuntimeException e) {
                Log.w(TAG, "isMusicActive() failed: " + e);
            }
        });
        return sProbe;
    }
}
