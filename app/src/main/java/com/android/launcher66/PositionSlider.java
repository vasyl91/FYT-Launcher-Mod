package com.android.launcher66;

/**
 * The position slider of the home music widget on the 7870, free of android.* so that it has a test.
 *
 * <p>The rule (2026-11-21, the 7870 tester asked for a slider of the track's position on the big widget, for the
 * files and for BT): on the 7870 ({@link #shown}) the widget's thin progress bar is a slider that shows the
 * position of what plays or pauses, 0 to {@link #MAX} of the track's length. It moves the track only where the player
 * can be told to ({@link #seekable}): com.syu.media's own files, through its IPlayer.seekTo (transaction 12). BT has
 * no command for it in com.syu.ms, an internet station has no position to go to, so there the slider only shows. A
 * position at or past the length makes com.syu.media go to the next track, so the position asked for is kept a second
 * short of the end ({@link #position}). The other units keep the thin bar.
 */
public final class PositionSlider {

    /** The slider's scale, the same as the progress bar's. */
    public static final int MAX = 1000;
    /** A position asked for stays this far before the end of the track. */
    public static final long END_GUARD_MS = 1_000L;

    private PositionSlider() {
    }

    /** Whether the widget has the slider: the 7870. */
    public static boolean shown(boolean syuMediaUnit) {
        return syuMediaUnit;
    }

    /** Whether the user can move the track with it: com.syu.media's own files, with a known length. */
    public static boolean seekable(boolean syuMediaUnit, boolean syuMediaFile, long totalMs) {
        return syuMediaUnit && syuMediaFile && totalMs > 0;
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
