package com.android.launcher66;

/**
 * What the play/pause button shows after a tap, and whether a tap is taken.
 *
 * <p>The rule: a tap is taken when no earlier tap is still waiting for its answer. A taken tap shows the
 * opposite symbol at once, on every play/pause button (the home screen's widget and the bar's), and the
 * command goes to the player at once. Until the player reports the state the tap asked for, or
 * {@link #HOLD_MS} are over, every redraw shows the tap's symbol - the redraws that follow a tap, the
 * stock firmware's "pause.button" broadcasts, a wake. Then the player's own state is shown again.
 *
 * <p>Before this, the pause of a session player was sent 350 ms after the tap, the symbol changed with it,
 * and a redraw at 500 ms read the session while it still played and put the old symbol back until the
 * player answered: the owner saw pause, play, pause for one tap (7862, 2026-11-15 17:34:51). A second tap
 * in that time toggled the player once more. Pure Java, so that it has a test.
 */
final class PlayPauseRequest {

    /** How long a tap's symbol waits for the player's answer. */
    static final long HOLD_MS = 2000L;

    /** Until when the tap waits, 0 for no tap waiting. */
    private long until;
    /** The state the player was in at the tap. */
    private boolean from;

    /**
     * A tap.
     *
     * @param now        the time, in ms of the uptime clock
     * @param playingNow the state the player reports now
     * @return whether the tap is taken; false while an earlier one waits for its answer
     */
    boolean tap(long now, boolean playingNow) {
        if (waiting(now, playingNow)) {
            return false;
        }
        from = playingNow;
        until = now + HOLD_MS;
        return true;
    }

    /** Whether the button shows the symbol of playing. */
    boolean showsPlaying(long now, boolean playingNow) {
        return waiting(now, playingNow) ? !from : playingNow;
    }

    /** Whether a tap still waits: not answered by the player and not over. Ends the wait when it is. */
    boolean waiting(long now, boolean playingNow) {
        if (until == 0) {
            return false;
        }
        if (now >= until || playingNow != from) {
            until = 0;
            return false;
        }
        return true;
    }
}
