package com.android.launcher66.settings;

/**
 * When and how the launcher tries to bring the fYT Rating bridge up. Pure, so that the steps and the
 * pauses between them have a test; FytRatingBridgeStarter does the calls.
 *
 * <p>One sequence runs at a time, whatever starts it: a ping of the status, and when it is not answered a
 * wake (through the launcher's activity when it is resumed and the boot is over, else the ping alone, which a
 * broadcast launch also delivers) and a second ping 1.5 s later. If that is not answered either, the next
 * attempt comes 5 s, 15 s and 60 s later, then every 5 minutes, as long as the launcher is resumed.
 */
public final class BridgeStartPolicy {

    /** The pauses before the 2nd, 3rd and 4th attempt (ms). */
    public static final long[] RETRY_DELAYS_MS = {5_000L, 15_000L, 60_000L};
    /** Then one attempt this often (ms). */
    public static final long REPEAT_MS = 300_000L;
    /** The second ping after a wake (ms). */
    public static final long PING_AFTER_WAKE_MS = 1_500L;
    /** The broadcast launch is tried again after a failure no more often than this (ms). */
    public static final long BROADCAST_RETRY_MIN_MS = 60_000L;
    /**
     * Waking through an activity pauses the launcher and, right after the boot, did not get an answer within
     * its time (the pane apps are cold-starting): not before this uptime (ms). The ping has no such gate.
     */
    public static final long ACTIVITY_WAKE_UPTIME_MS = 90_000L;

    private boolean running;
    private int unanswered;
    private long lastBroadcastRetryMs = Long.MIN_VALUE;

    /** A trigger arrived: false when a sequence is already running, which it must not duplicate. */
    public synchronized boolean begin() {
        if (running) {
            return false;
        }
        running = true;
        unanswered = 0;
        return true;
    }

    /** The bridge answered: the sequence is over, and the counts start afresh. */
    public synchronized void answered() {
        running = false;
        unanswered = 0;
    }

    /** The launcher was paused: the sequence stops, a later trigger starts a new one. */
    public synchronized void stopped() {
        running = false;
    }

    /** @return the pause (ms) before the next attempt after one that got no answer */
    public synchronized long unansweredDelayMs() {
        unanswered++;
        return unanswered <= RETRY_DELAYS_MS.length ? RETRY_DELAYS_MS[unanswered - 1] : REPEAT_MS;
    }

    /** Whether the broadcast launch may be tried again now (and, if so, it is counted as tried). */
    public synchronized boolean mayRetryBroadcastLaunch(long nowMs) {
        if (lastBroadcastRetryMs != Long.MIN_VALUE && nowMs - lastBroadcastRetryMs < BROADCAST_RETRY_MIN_MS) {
            return false;
        }
        lastBroadcastRetryMs = nowMs;
        return true;
    }

    /** Whether the bridge may be woken through an activity of the launcher now. */
    public static boolean mayWakeByActivity(long uptimeMs, boolean launcherResumed) {
        return launcherResumed && uptimeMs >= ACTIVITY_WAKE_UPTIME_MS;
    }
}
