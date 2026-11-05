package com.fyt.car;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.settings.FytCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The favorites of the FM stations of com.syu.media (the 7870), read only. The app keeps them in its
 * private database radio_database.db, table city_station(_id, title, freq, city, cover_path, url, online,
 * favorite); its provider content://com.syu.radio/city_station is exported without a permission and
 * can be queried (insert, update and delete answer null / -1: the provider is read-only, and the app
 * would not notice a change from outside anyway). So the widget shows the state the app has, and a
 * press on the heart changes nothing.
 *
 * <p>The query is an ordinary ContentResolver query: nothing needs root or Shizuku, the system version does
 * the same. The selection comes with its argument (the provider's code asserts selectionArgs when there
 * is a selection, a {@code content query --where} without them throws). The city is not known (the app
 * keeps it in its private preferences), so a row of the frequency in any city counts, see
 * {@link RadioStationState}. A failure (another firmware, the app not there) is logged once, the state is
 * unknown and the heart stays grey; it is asked again after a minute.
 *
 * <p>Everything is read on a thread of its own; the results are kept in memory by frequency.
 */
final class SyuMediaRadioFavorites {

    private static final String TAG = "SyuMediaFavorites";
    private static final Uri CITY_STATION = Uri.parse("content://com.syu.radio/city_station");
    private static final long RETRY_AFTER_FAILURE_MS = 60_000L;

    private final Context app;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final Map<Integer, RadioStationState> states = new ConcurrentHashMap<>();
    private final ExecutorService worker = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "SyuMediaFavorites");
        t.setPriority(Thread.MIN_PRIORITY);
        t.setDaemon(true);
        return t;
    });
    private volatile long failedAtMs;
    private volatile boolean failureLogged;

    SyuMediaRadioFavorites(Context app) {
        this.app = app;
    }

    /** The state the app has for the frequency; null while it is not known. */
    Boolean favoriteOf(int freq) {
        RadioStationState s = states.get(freq);
        return s == null ? null : s.favorite;
    }

    /** The cover_path of the station in the app's list, null if none. */
    String coverPathOf(int freq) {
        RadioStationState s = states.get(freq);
        return s == null ? null : s.coverPath;
    }

    /**
     * Reads the station again; {@code onChanged} runs on the main thread when its favorite state or
     * cover changed. Main thread.
     */
    void refresh(int freq, Runnable onChanged) {
        if (freq <= 0) {
            return;
        }
        long failed = failedAtMs;
        if (failed != 0 && SystemClock.elapsedRealtime() - failed < RETRY_AFTER_FAILURE_MS) {
            return;
        }
        worker.execute(() -> FytCompat.run("syumedia.fmfavorites", () -> read(freq, onChanged)));
    }

    /** Worker thread. */
    private void read(int freq, Runnable onChanged) {
        RadioStationState now;
        try (Cursor c = app.getContentResolver().query(CITY_STATION,
                new String[]{"favorite", "cover_path", "title"}, "freq=?",
                new String[]{String.valueOf(freq)}, null)) {
            if (c == null) {
                throw new IllegalStateException("city_station gave no cursor");
            }
            List<RadioStationState.Row> rows = new ArrayList<>();
            while (c.moveToNext()) {
                rows.add(new RadioStationState.Row(c.getInt(0), c.getString(1), c.getString(2)));
            }
            now = RadioStationState.of(rows);
            failedAtMs = 0L;
        } catch (RuntimeException e) {
            failedAtMs = SystemClock.elapsedRealtime();
            if (!failureLogged) {
                failureLogged = true;
                Log.w(TAG, "FM favorites of com.syu.media are not readable, the heart stays grey: " + e);
            }
            now = RadioStationState.UNKNOWN;
        }
        RadioStationState before = states.put(freq, now);
        if (before == null || !Objects.equals(before.favorite, now.favorite)
                || !Objects.equals(before.coverPath, now.coverPath)) {
            if (before == null || !Objects.equals(before.favorite, now.favorite)) {
                Log.d(TAG, "FM " + freq + " favorite=" + now.favorite);
            }
            if (onChanged != null) {
                main.post(onChanged);
            }
        }
    }
}
