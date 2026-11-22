package com.android.launcher66;

/**
 * The position slider of the home music widget, free of android.* so that it has a test.
 *
 * <p>The rule (2026-11-21 for the 7870, the tester's request; 2026-11-22 for every unit and every player, the
 * owner's): the large music widget shows the position of what plays or pauses as a slider, 0 to {@link #MAX} of the
 * track's length, in one of three states ({@link #mode}):
 * <ul>
 *   <li>{@link Mode#SEEK}: the player can be told to go to a position (com.syu.media's own files on the 7870, through
 *       its IPlayer.seekTo; a session whose player offers ACTION_SEEK_TO): a knob, and a move goes to that position;</li>
 *   <li>{@link Mode#SHOW}: the position is known but the player cannot be moved from here (BT, an internet station,
 *       com.syu.music without a session that seeks, a session without ACTION_SEEK_TO): the progress as the thin bar
 *       showed it, without a knob;</li>
 *   <li>{@link Mode#GREY}: nothing to show (no length: a live stream, a radio station, a player that says nothing):
 *       the bar stays empty: all of it in the colour of the part of a track not played yet (the owner, 2026-11-22).</li>
 * </ul>
 * A position at or past the length makes com.syu.media go to the next track, so the position asked for is kept a
 * second short of the end ({@link #position}), for every player alike.
 */
public final class PositionSlider {

    /** What the slider is for the track shown. */
    public enum Mode { SEEK, SHOW, GREY }

    /** The slider's scale, the same as the progress bar's. */
    public static final int MAX = 1000;
    /** A position asked for stays this far before the end of the track. */
    public static final long END_GUARD_MS = 1_000L;

    private PositionSlider() {
    }

    /** The state of the slider for a track of {@code totalMs} (0 or less: unknown), a live stream or not. */
    public static Mode mode(long totalMs, boolean live, boolean canSeek) {
        if (totalMs <= 0 || live) {
            return Mode.GREY;
        }
        return canSeek ? Mode.SEEK : Mode.SHOW;
    }

    /** com.syu.media's own file on the 7870 (not BT, not a station, not a session's app). */
    public static boolean syuMediaFileSeekable(boolean syuMediaUnit, boolean syuMediaFile) {
        return syuMediaUnit && syuMediaFile;
    }

    /** The slider's value for a position: 0 .. MAX of the length; 0 without a length. */
    public static int value(long positionMs, long totalMs) {
        if (totalMs <= 0 || positionMs <= 0) {
            return 0;
        }
        return (int) Math.min(MAX, positionMs * MAX / totalMs);
    }

    /** The position in ms a value stands for, kept {@link #END_GUARD_MS} short of the end (never below 0). */
    public static long position(int value, long totalMs) {
        if (totalMs <= 0) {
            return 0;
        }
        int clamped = Math.max(0, Math.min(MAX, value));
        long ms = totalMs * clamped / MAX;
        return Math.max(0, Math.min(ms, totalMs - END_GUARD_MS));
    }
}
