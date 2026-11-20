package com.android.launcher66;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.SystemClock;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The workspace's screen ids, read off the main thread and kept in memory for every Workspace of the process
 * (ScreenIdsMemory holds the rule). They are read at the start (see LauncherApplication) for the first
 * Workspace; its own class, not Workspace's: loading and verifying Workspace took the start-up thread longer
 * than the main thread took to get there (capture 18-10-2026 03:41:47).
 *
 * <p>They stay after a Workspace has taken them, so a launcher created again in the same process (after the
 * settings, say) finds them too: it queried them on the main thread before (StrictMode, about 144 ms on the
 * 7862, log of 2026-11-20). Every write of the screen table drops them before it (changed()) and has them read
 * again on this class's own thread once it is committed (written(), both from LauncherProvider). A Workspace
 * that finds none queries the ids itself.
 */
final class WorkspaceScreensPreload {

    private static final String TAG = "Launcher.Workspace";
    /** What the main thread waits for a read under way, rather than running a second query. */
    private static final long IN_FLIGHT_WAIT_MS = 300L;

    private static final Object LOCK = new Object();
    /** Guarded by LOCK. */
    private static final ScreenIdsMemory MEMORY = new ScreenIdsMemory();
    /**
     * The reads after a write: off the main thread, and off the writer's thread (the model's worker), which
     * goes on with its own work meanwhile.
     */
    private static final ExecutorService READER = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "ScreensReader");
        t.setDaemon(true);
        return t;
    });

    private WorkspaceScreensPreload() {
    }

    /** At the start, on a thread of its own (LauncherApplication). */
    static void preload(Context context) {
        int ticket;
        synchronized (LOCK) {
            ticket = MEMORY.readStarts();
        }
        read(context, ticket);
    }

    /** Before a write of the screen table (LauncherProvider): the ids in memory are out of date. */
    static void changed() {
        synchronized (LOCK) {
            MEMORY.writing();
        }
    }

    /**
     * After a write of the screen table is committed (LauncherProvider): the ids are read again off the main
     * thread. The read counts as under way from now, so a Workspace created meanwhile waits for it.
     */
    static void written(Context context) {
        final Context app = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        final int ticket;
        synchronized (LOCK) {
            ticket = MEMORY.readStarts();
        }
        try {
            READER.execute(() -> read(app, ticket));
        } catch (RuntimeException e) {
            Log.w(TAG, "screens not read again: " + e);
            ended(ticket, null);
        }
    }

    private static void read(Context context, int ticket) {
        long[] ids = null;
        try {
            ids = query(context.getContentResolver());
        } catch (RuntimeException e) {
            Log.w(TAG, "screens not read: " + e);
        } finally {
            ended(ticket, ids);
        }
    }

    private static void ended(int ticket, long[] ids) {
        synchronized (LOCK) {
            MEMORY.readEnds(ticket, ids);
            LOCK.notifyAll();
        }
    }

    /**
     * A copy of the ids in memory, which stay for the next Workspace; null if there are none (then the caller
     * queries them). A read under way is waited for, a little.
     */
    static long[] take() {
        synchronized (LOCK) {
            long deadline = SystemClock.uptimeMillis() + IN_FLIGHT_WAIT_MS;
            long left;
            while (MEMORY.reading() && (left = deadline - SystemClock.uptimeMillis()) > 0) {
                try {
                    LOCK.wait(left);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            long[] ids = MEMORY.take();
            if (ids == null) {
                Log.d(TAG, "screens not read ahead (" + (MEMORY.reading() ? "still reading" : "none") + ")");
            }
            return ids;
        }
    }

    /** The persisted screens' ids in rank order; null if the query failed. */
    static long[] query(ContentResolver resolver) {
        try (Cursor c = resolver.query(
                LauncherSettings.WorkspaceScreens.CONTENT_URI,
                new String[] { "_id" },
                null, null,
                LauncherSettings.WorkspaceScreens.SCREEN_RANK + " ASC")) {
            if (c == null) {
                return null;
            }
            long[] ids = new long[c.getCount()];
            for (int i = 0; i < ids.length && c.moveToNext(); i++) {
                ids[i] = c.getLong(0);
            }
            return ids;
        }
    }
}
