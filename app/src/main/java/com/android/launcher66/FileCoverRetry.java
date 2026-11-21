package com.android.launcher66;

/**
 * Whether the cover of a track's file is read once more, free of android.* so that it has a test.
 *
 * <p>The rule (2026-11-21, the 7870 tester's "default picture until the cover or the track changes"): a file whose
 * picture was read is read once per track, and a file without a picture keeps the default. But a read that could
 * not open the file (it was not there yet, or not readable yet, as right after a start or a change of the medium) is
 * no answer: it is not kept as "no picture", and the file is read once more at the widget's next update. After that
 * the result stands, so a file that cannot be opened is not read every second.
 */
public final class FileCoverRetry {

    /** The reads of one track's file at most: the first and one more. */
    public static final int MAX_TRIES = 2;

    private FileCoverRetry() {
    }

    /** After {@code tries} reads of the same file, the last of which {@code opened} it or not. */
    public static boolean readAgain(boolean opened, int tries) {
        return !opened && tries < MAX_TRIES;
    }
}
