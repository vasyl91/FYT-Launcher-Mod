package com.android.launcher66;

/**
 * The workspace's screen ids kept in memory for every Workspace of the process (WorkspaceScreensPreload),
 * so that a launcher created again (after the settings, say) builds its pages without a query on the main
 * thread. StrictMode caught that query, about 144 ms, on the 7862 (log of 2026-11-20 09:32:05): the ids were
 * read once at the start and dropped by the first Workspace.
 *
 * <p>The rule: <b>the ids in memory are the screen table as last written.</b> They are dropped before every
 * write of the table and read again, off the main thread, once the write is committed; a read begun before a
 * later write is refused, since it may hold the table before that write. Taking them hands out a copy and
 * leaves them for the next Workspace. Every write of the table goes through LauncherProvider, which tells
 * this so (LauncherProvider.screensMayChange() and screensWritten()); a write around it would leave stale ids
 * here.
 *
 * <p>Plain Java, guarded by the caller's lock.
 */
final class ScreenIdsMemory {

    private long[] mIds;
    private int mGeneration;
    private int mReadsUnderWay;

    /** Before a write of the table: what is in memory, and what a read under way will give, is out of date. */
    void writing() {
        mGeneration++;
        mIds = null;
    }

    /** A read of the table is given out (and counted as under way from now); its ticket goes to readEnds(). */
    int readStarts() {
        mReadsUnderWay++;
        return mGeneration;
    }

    /**
     * A read has ended. Its ids are kept unless the table was written since it was given out.
     *
     * @param ids the ids read, in rank order; null if the read failed
     * @return whether the ids were kept
     */
    boolean readEnds(int ticket, long[] ids) {
        if (mReadsUnderWay > 0) {
            mReadsUnderWay--;
        }
        if (ticket != mGeneration || ids == null) {
            return false;
        }
        mIds = ids.clone();
        return true;
    }

    /** Whether a read is under way, which a Workspace about to be created may wait for. */
    boolean reading() {
        return mReadsUnderWay > 0;
    }

    /** A copy of the ids in memory, which stay; null if there are none (the caller then queries them). */
    long[] take() {
        return mIds == null ? null : mIds.clone();
    }
}
