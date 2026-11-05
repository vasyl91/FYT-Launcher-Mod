package com.fyt.car;

/**
 * When the cover of the song a phone plays over Bluetooth is taken, free of android.* so that it can be
 * tested on the JVM. The Bluetooth app (blink) writes the cover of the playing song to one file,
 * /data/blink/Id3_CoverArt.JPEG, and com.syu.ms reports its path as code 51 of module 2; the file is
 * written a little after the song changes, so a file older than the change is the previous song's.
 */
public final class StockBtCover {

    /** The file may be this much older than the change of the song and still be this song's. */
    public static final long TOLERANCE_MS = 2_000L;
    /** After a change of the title: the first read, as BluetoothObserver does. */
    public static final long FIRST_READ_MS = 1_500L;
    /** If the file has not changed yet: the reads that follow, counted from the change of the title. */
    public static final long[] RETRY_MS = {3_000L, 6_000L};

    private StockBtCover() {
    }

    /** Whether a file last modified at {@code lastModifiedMs} is the cover of the song that changed at {@code songChangedAtMs}. */
    public static boolean isFresh(long lastModifiedMs, long songChangedAtMs) {
        return lastModifiedMs > 0 && lastModifiedMs >= songChangedAtMs - TOLERANCE_MS;
    }

    /** All the delays after a change of the title at which the file is read, in order. */
    public static long[] readDelaysAfterTitleChange() {
        long[] all = new long[1 + RETRY_MS.length];
        all[0] = FIRST_READ_MS;
        System.arraycopy(RETRY_MS, 0, all, 1, RETRY_MS.length);
        return all;
    }
}
