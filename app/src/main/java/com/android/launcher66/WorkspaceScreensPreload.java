package com.android.launcher66;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.SystemClock;
import android.util.Log;

/**
 * The workspace's screen ids, read at the start off the main thread (see LauncherApplication)
 * for the first Workspace. Its own class, not Workspace's: loading and verifying Workspace took
 * the start-up thread longer than the main thread took to get there (capture 18-10-2026 03:41:47).
 *
 * Any change to the screen table drops the read (see LauncherProvider); a Workspace that finds
 * none queries the ids itself.
 */
final class WorkspaceScreensPreload {

    private static final String TAG = "Launcher.Workspace";
    /** What the main thread waits for a read under way, rather than running a second query. */
    private static final long IN_FLIGHT_WAIT_MS = 300L;

    private static final Object LOCK = new Object();
    private static long[] sIds;
    private static int sGeneration;
    private static boolean sInFlight;

    private WorkspaceScreensPreload() {
    }

    static void preload(Context context) {
        int generation;
        synchronized (LOCK) {
            generation = sGeneration;
            sInFlight = true;
        }
        long[] ids = null;
        try {
            ids = query(context.getContentResolver());
        } finally {
            synchronized (LOCK) {
                if (generation == sGeneration) {
                    sIds = ids;
                }
                sInFlight = false;
                LOCK.notifyAll();
            }
        }
    }

    static void changed() {
        synchronized (LOCK) {
            sGeneration++;
            sIds = null;
        }
    }

    /** The ids read ahead, once; null if there are none (then the caller queries them). */
    static long[] take() {
        synchronized (LOCK) {
            long deadline = SystemClock.uptimeMillis() + IN_FLIGHT_WAIT_MS;
            long left;
            while (sInFlight && (left = deadline - SystemClock.uptimeMillis()) > 0) {
                try {
                    LOCK.wait(left);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            long[] ids = sIds;
            if (ids == null) {
                Log.d(TAG, "screens not read ahead (" + (sInFlight ? "still reading" : "none") + ")");
            }
            // Also refuses a read still under way
            sGeneration++;
            sIds = null;
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
