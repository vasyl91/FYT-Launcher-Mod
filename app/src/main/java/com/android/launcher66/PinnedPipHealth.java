package com.android.launcher66;

/**
 * Notices a unit on which the pinned PiP does not work: the app that is started as the pinned PiP comes to
 * the front full screen instead.
 *
 * <p>Some FYT units cannot show an app pinned on the main screen (the README warns of it: Google Maps then
 * pops up at every return to the home page). Which units those are is not known, and no capture of one
 * exists. So this only watches and says what it saw, in the log, and changes nothing: a start counts as
 * failed when, a few seconds after it, the task in front on the main screen is the pinned app itself, in a
 * mode that covers the home screen, the launcher is no longer in front, and the user touched nothing since
 * the start (an app the user opens full screen is not a failure). {@link #FAILURES_TO_TELL} such starts in a
 * row are told once; one start that lands as it should begins the count again.
 *
 * <p>A notice to the user, or not starting the app again, is deliberately not done from a rule that was never
 * seen to be right on a device: on a unit where the pinned PiP works it would be a false alarm. The log line
 * is what a later round needs to decide that. Pure Java, so that it has a test.
 */
public final class PinnedPipHealth {

    /** How long after a pinned start the look is taken. */
    public static final long CHECK_AFTER_MS = 3000L;
    /** So many failed starts in a row are told. */
    static final int FAILURES_TO_TELL = 3;

    private int failuresInARow;

    /**
     * Whether a pinned start failed.
     *
     * @param frontIsPinnedApp  the task in front on the main screen that covers the home screen is the pinned app's
     * @param launcherInFront   the launcher is resumed
     * @param touchedSinceStart the user touched the screen or pressed a button since the start
     */
    public static boolean failed(boolean frontIsPinnedApp, boolean launcherInFront, boolean touchedSinceStart) {
        return frontIsPinnedApp && !launcherInFront && !touchedSinceStart;
    }

    /**
     * Notes how a start ended.
     *
     * @return true when this failure is the one to tell: the {@link #FAILURES_TO_TELL}th in a row
     */
    public synchronized boolean note(boolean failed) {
        if (!failed) {
            failuresInARow = 0;
            return false;
        }
        failuresInARow++;
        return failuresInARow == FAILURES_TO_TELL;
    }

    public synchronized int failuresInARow() {
        return failuresInARow;
    }
}
