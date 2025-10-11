package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.launcher66.settings.Keys;

public final class PendingUpdateStore {
    private static final String PREFS = "LauncherPrefs";
    private static final Object LOCK = new Object();

    private PendingUpdateStore() {}

    /** Save updateOnce if it is greater than currently saved pending value. Thread-safe. */
    public static void saveIfGreater(Context ctx, long updateOnce) {
        if (updateOnce <= 0) return;
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        synchronized (LOCK) {
            long existing = prefs.getLong(Keys.UPDATE_USER_PAGE, -1L);
            Log.d("PendingUpdateStore", "saveIfGreater: existing=" + existing + " incoming=" + updateOnce);
            if (updateOnce > existing) {
                prefs.edit().putLong(Keys.UPDATE_USER_PAGE, updateOnce).apply();
                Log.d("PendingUpdateStore", "saved pending updateOnce=" + updateOnce);
            } else {
                Log.d("PendingUpdateStore", "did not save incoming updateOnce (not greater)");
            }
        }
    }

    /**
     * Atomically read-and-clear the pending updateOnce.
     * Returns -1 if none.
     */
    public static long pollPendingAndClear(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        synchronized (LOCK) {
            long pending = prefs.getLong(Keys.UPDATE_USER_PAGE, -1L);
            Log.d("PendingUpdateStore", "pollPendingAndClear found=" + pending);
            if (pending <= 0) return -1L;
            prefs.edit().remove(Keys.UPDATE_USER_PAGE).apply();
            Log.d("PendingUpdateStore", "cleared pending updateOnce=" + pending);
            return pending;
        }
    }
}