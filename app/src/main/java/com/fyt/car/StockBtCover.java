package com.fyt.car;

/**
 * When the cover of the song a phone plays over Bluetooth is taken, free of android.* so that it can be
 * tested on the JVM. The Bluetooth app (blink) writes the cover of the playing song to one file,
 * /data/blink/Id3_CoverArt.JPEG, and com.syu.ms reports its path as code 51 of module 2; the file is
 * written a little after the song changes, so a file older than the change is the previous song's.
 *
 * <p>When the song changed (the rule, 2026-11-21, after the tester's report that the default picture stayed until
 * the cover or the song changed): only a real change of the song counts ({@link #titleChange}).
 * <ul>
 *   <li>the first title after the launcher started is a song that may have begun long ago: its file is taken
 *       whatever its age ({@link #UNKNOWN});</li>
 *   <li>a title that is cleared for a moment and comes back is the same song: its time and its cover stay;</li>
 *   <li>the time of the change is kept on the clock that does not jump (elapsed time) and turned into the wall
 *       clock of the file's time when the file is read ({@link #changedAtNow}): the 7870 sets its clock after a
 *       start, and a jump back made every file look older than the change.</li>
 * </ul>
 * com.syu.media's BluetoothObserver does not look at the time at all; the check stays so that the previous song's
 * file is not shown for the next one.
 */
public final class StockBtCover {

    /** The time of the song's change is not known (the first title after a start): a file of any age is taken. */
    public static final long UNKNOWN = Long.MIN_VALUE;

    /** What a title reported by com.syu.ms (code 0) is for the cover. */
    public enum TitleChange {
        /** No title: a field cleared for a moment; the song and its cover stay. */
        CLEARED,
        /** The first title since the start. */
        FIRST,
        /** The title of the song shown (back after a moment without one, or reported again). */
        SAME,
        /** Another song. */
        NEW
    }

    /** The file may be this much older than the change of the song and still be this song's. */
    public static final long TOLERANCE_MS = 2_000L;
    /** After a change of the title: the first read, as BluetoothObserver does. */
    public static final long FIRST_READ_MS = 1_500L;
    /** If the file has not changed yet: the reads that follow, counted from the change of the title. */
    public static final long[] RETRY_MS = {3_000L, 6_000L};

    private StockBtCover() {
    }

    /**
     * Whether a file last modified at {@code lastModifiedMs} is the cover of the song that changed at
     * {@code songChangedAtMs} (the wall clock, or {@link #UNKNOWN}).
     */
    public static boolean isFresh(long lastModifiedMs, long songChangedAtMs) {
        if (lastModifiedMs <= 0) {
            return false;
        }
        return songChangedAtMs == UNKNOWN || lastModifiedMs >= songChangedAtMs - TOLERANCE_MS;
    }

    /** What the title {@code newTitle} is after the last song's {@code lastSongTitle} (null: none since the start). */
    public static TitleChange titleChange(String lastSongTitle, String newTitle) {
        String now = newTitle == null ? "" : newTitle.trim();
        if (now.isEmpty()) {
            return TitleChange.CLEARED;
        }
        if (lastSongTitle == null) {
            return TitleChange.FIRST;
        }
        return now.equals(lastSongTitle.trim()) ? TitleChange.SAME : TitleChange.NEW;
    }

    /**
     * The wall-clock time of a song's change as the wall clock counts now, from the elapsed time of the change
     * ({@code changedElapsedMs}, 0 for none known): a jump of the wall clock since then moves it with the clock.
     */
    public static long changedAtNow(long nowWallMs, long nowElapsedMs, long changedElapsedMs) {
        if (changedElapsedMs <= 0) {
            return UNKNOWN;
        }
        return nowWallMs - (nowElapsedMs - changedElapsedMs);
    }

    /** All the delays after a change of the title at which the file is read, in order. */
    public static long[] readDelaysAfterTitleChange() {
        long[] all = new long[1 + RETRY_MS.length];
        all[0] = FIRST_READ_MS;
        System.arraycopy(RETRY_MS, 0, all, 1, RETRY_MS.length);
        return all;
    }
}
