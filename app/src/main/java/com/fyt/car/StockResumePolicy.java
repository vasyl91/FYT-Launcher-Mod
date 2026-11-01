package com.fyt.car;

/**
 * Whether a com.syu.media source that stopped when the panes were rebuilt is started again once
 * the launcher puts its channel back. No Android classes in here.
 *
 * <p>com.syu.media pauses on every loss of audio focus and on every channel but its own, and
 * resumes by itself only when it paused for the channel (its own record of that is kept for a
 * channel change, not for the focus the panes' apps take). The channel coming back therefore does
 * not start it again, where com.syu.music, which listens to the channel alone, does.
 */
public final class StockResumePolicy {

    /** The source must have played this recently when the channel left it. */
    public static final long PLAYED_BEFORE_LEAVING_MS = 3000L;
    /** The channel must come back within this of leaving: later it is not a rebuild's doing. */
    public static final long BACK_WITHIN_MS = 10_000L;

    private StockResumePolicy() {
    }

    /**
     * @param lastPlayingAtMs   when the source was last seen playing, 0 if never
     * @param leftAtMs          when the MCU left its channel, 0 if it has not
     * @param nowMs             now
     * @param userPausedAtMs    when the user last paused it with a launcher button, 0 if never
     */
    public static boolean shouldResume(long lastPlayingAtMs, long leftAtMs, long nowMs,
            long userPausedAtMs) {
        if (lastPlayingAtMs <= 0 || leftAtMs <= 0) {
            return false;
        }
        if (leftAtMs - lastPlayingAtMs > PLAYED_BEFORE_LEAVING_MS) {
            return false; // it was already stopped when the channel went
        }
        if (nowMs - leftAtMs >= BACK_WITHIN_MS) {
            return false;
        }
        // A pause pressed in the launcher around or after the leaving is the user's own stop; an
        // older one belongs to an earlier listening (the source played again since).
        return userPausedAtMs <= 0 || userPausedAtMs < leftAtMs - PLAYED_BEFORE_LEAVING_MS
                || userPausedAtMs < lastPlayingAtMs;
    }
}
