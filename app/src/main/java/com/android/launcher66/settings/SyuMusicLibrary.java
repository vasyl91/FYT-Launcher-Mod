package com.android.launcher66.settings;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.MediaFavoriteController;
import com.syu.util.WindowHostVdClient;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * com.syu.music's own favorites (the stock player on 7862/8581), in its real database rather than
 * the launcher's cache. See the stock-player section of {@link MediaFavoriteController}.
 *
 * com.syu.music publishes no media session and no content provider for its library: its favorites
 * live in the "Table_Favorite" table of its private music.db (SQLite, rollback journal), one row
 * per liked track keyed by the file path - the same path it reports to MusicService as "play_path"
 * and checks with "select Name from Table_Favorite where Path = ?". So a row's presence is the
 * favorite state.
 *
 * Reaching that database (it is owned by com.syu.music, uid system, mode 660):
 *   - with system privileges (the FYT build, uid 1000 like com.syu.music): opened directly;
 *   - on a rooted unit, with the user's root: the file must be touched through a real SQLite
 *     connection - replacing it as a whole file would corrupt com.syu.music's open connection, and
 *     there is no sqlite3 binary on the unit to run SQL as root - so root widens the file's
 *     other-permission for the moment of the open, the launcher opens the real file with its own
 *     SQLite engine (multi-process safe with the player's connection, so each sees the other's
 *     committed change), and the permission is taken away again the instant the connection
 *     closes. com.syu.music, the owner, keeps its own access the whole time;
 *   - not through Shizuku as shell (uid 2000): neither the uid nor SELinux's shell domain may
 *     touch another app's private data, nor chmod it.
 * Which one is found out by opening the database once, off the main thread; until then the
 * library counts as reachable, and where it is not (no root, su refused) {@link #isAvailable}
 * turns false and the caller keeps its opt-in cache instead.
 *
 * The whole Table_Favorite (its paths) is read at once and kept, so the widget's per-draw lookups
 * stay on the main thread and a track change needs no read of its own; it is read again on
 * {@link #IO} at most every {@link #REREAD_MIN_MS} and at once when the launcher comes back to the
 * front ({@link #onLauncherResumed}), where a like changed in com.syu.music's own screen shows up.
 * Writes are optimistic and read back.
 */
public final class SyuMusicLibrary {

    public static final String PACKAGE = "com.syu.music";

    private static final String TAG = "SyuMusicLib";
    private static final String DATA_DIR = "/data/data/" + PACKAGE;
    private static final String DB_DIR = DATA_DIR + "/databases";
    private static final String DB_PATH = DB_DIR + "/music.db";
    private static final String TABLE = "Table_Favorite";

    /** su, applied only while a connection is open, then reversed by {@link #REVOKE}. */
    private static final String GRANT = "chmod o+x " + DATA_DIR + "; chmod o+wx " + DB_DIR
            + "; chmod o+rw " + DB_PATH;
    /** Removes every other-permission again; the file started with none. */
    private static final String REVOKE = "chmod o-rwx " + DB_PATH + " " + DB_DIR + " " + DATA_DIR;

    private static final int ACCESS_UNKNOWN = 0;
    private static final int ACCESS_NONE = 1;
    private static final int ACCESS_ROOT = 2;
    /** System privileges: the launcher is com.syu.music's uid, the file is opened as it is. */
    private static final int ACCESS_DIRECT = 3;

    private static volatile int sAccess = ACCESS_UNKNOWN;
    private static volatile boolean sProbing;

    private static final ExecutorService IO = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "SyuMusicLib");
        t.setDaemon(true);
        return t;
    });
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** Every liked path, as last read; null until the first read lands. */
    private static volatile Set<String> sFavorites;
    /** Presses still being written, by path: they win over a read until written and read back. */
    private static final ConcurrentHashMap<String, Boolean> PENDING = new ConcurrentHashMap<>();
    private static volatile boolean sReading;

    /**
     * The table is read again no more than this often, so a like made inside com.syu.music is
     * picked up (getState is called about once a second while a stock track plays). With root
     * each read is a pair of su calls, so it is not run on every draw.
     */
    private static final long REREAD_MIN_MS = 1500L;
    private static volatile long sLastReadAtMs;

    private SyuMusicLibrary() {
    }

    /**
     * Whether com.syu.music's real favorites are reachable, so the launcher manages them there
     * instead of in its cache: com.syu.music installed and its database opened (or not tried yet).
     */
    public static boolean isAvailable(Context context) {
        int a = accessMode(context);
        return a == ACCESS_ROOT || a == ACCESS_DIRECT || a == ACCESS_UNKNOWN;
    }

    /**
     * The favorite state of {@code path}: FAVORITED, NOT_FAVORITED, or UNKNOWN until the first
     * read of the table lands (then the widget is redrawn). A track the table has no row for reads
     * as NOT_FAVORITED, so the button is usable and the first press likes it.
     */
    public static int getState(Context context, String path) {
        if (TextUtils.isEmpty(path) || !isAvailable(context)) {
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }
        maybeRead(context.getApplicationContext(), false);
        Boolean pending = PENDING.get(path);
        Set<String> favorites = sFavorites;
        if (pending == null && favorites == null) {
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }
        boolean fav = pending != null ? pending : favorites.contains(path);
        return fav ? MediaFavoriteController.FAVORITE_STATE_FAVORITED
                : MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
    }

    /**
     * The launcher is in front again: a like changed in com.syu.music's own screen meanwhile is
     * read now, not up to REREAD_MIN_MS into the next tracks (each showed the old heart for a
     * moment). Main thread.
     */
    public static void onLauncherResumed(Context context) {
        int a = sAccess;
        if (a == ACCESS_ROOT || a == ACCESS_DIRECT) {
            maybeRead(context.getApplicationContext(), true);
        }
    }

    /**
     * Writes the favorite state of {@code path} into com.syu.music's library (insert or delete the
     * row, as it does itself). Optimistic: the state flips at once for the redraw, then the row is
     * written and the table read back on {@link #IO}.
     *
     * @return false when the library is not reachable
     */
    public static boolean setFavorite(Context context, String path, String name,
            String artist, String album, boolean favorite) {
        int a = accessMode(context);
        if (TextUtils.isEmpty(path) || (a != ACCESS_ROOT && a != ACCESS_DIRECT)) {
            return false;
        }
        PENDING.put(path, favorite);
        Context app = context.getApplicationContext();
        IO.execute(() -> {
            try {
                writeFavorite(path, name, artist, album, favorite);
                Set<String> actual = readFavorites();
                if (actual != null) {
                    sFavorites = actual;
                    sLastReadAtMs = SystemClock.elapsedRealtime();
                }
            } finally {
                // Only this press's own value: a later press for the path stays pending
                PENDING.remove(path, favorite);
                redraw(app);
            }
        });
        return true;
    }

    // =====================================================================================
    // Access mode
    // =====================================================================================

    /** The access found; UNKNOWN (and the probe started) until the database has been opened. */
    private static int accessMode(Context context) {
        int a = sAccess;
        if (a != ACCESS_UNKNOWN) {
            return a;
        }
        if (context == null || !isInstalled(context)) {
            return ACCESS_NONE; // not cached: com.syu.music may be installed later
        }
        if (!sProbing) {
            sProbing = true;
            Context app = context.getApplicationContext();
            IO.execute(() -> probe(app));
        }
        return ACCESS_UNKNOWN;
    }

    /**
     * Opens the database the way this launcher can (the first read of the table): directly with
     * system privileges, else through root when there is any (WindowHostVdClient.hasRoot() looks
     * for su files: here, off the main thread). The su prompt, if any, comes now. IO thread.
     */
    private static void probe(Context app) {
        int found = ACCESS_NONE;
        if (LauncherApplication.hasSystemPrivileges()) {
            sAccess = ACCESS_DIRECT;
            if (readAndKeep()) {
                found = ACCESS_DIRECT;
            }
        }
        if (found == ACCESS_NONE && WindowHostVdClient.hasRoot()) {
            sAccess = ACCESS_ROOT;
            if (readAndKeep()) {
                found = ACCESS_ROOT;
            }
        }
        sAccess = found;
        sProbing = false;
        Log.i(TAG, "com.syu.music's favorites: " + (found == ACCESS_DIRECT ? "opened directly"
                : found == ACCESS_ROOT ? "opened through root" : "out of reach, the cache stays"));
        redraw(app);
    }

    private static boolean isInstalled(Context context) {
        try {
            context.getPackageManager().getPackageInfo(PACKAGE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    // =====================================================================================
    // Database
    // =====================================================================================

    /**
     * Reads the table in the background when it is worth it: now when asked to, otherwise at most
     * every {@link #REREAD_MIN_MS}. The widget is redrawn only when a path's state changed.
     */
    private static void maybeRead(Context app, boolean now) {
        int a = sAccess;
        if (a != ACCESS_ROOT && a != ACCESS_DIRECT) {
            return; // the probe reads it first
        }
        if (sReading) {
            return;
        }
        if (!now && sFavorites != null
                && SystemClock.elapsedRealtime() - sLastReadAtMs < REREAD_MIN_MS) {
            return;
        }
        sReading = true;
        sLastReadAtMs = SystemClock.elapsedRealtime();
        IO.execute(() -> {
            Set<String> before = sFavorites;
            try {
                readAndKeep();
            } finally {
                sReading = false;
            }
            if (!java.util.Objects.equals(before, sFavorites)) {
                redraw(app); // first read, or a like changed in com.syu.music
            }
        });
    }

    /** Reads the table into sFavorites; false when the database could not be opened. IO thread. */
    private static boolean readAndKeep() {
        Set<String> favorites = readFavorites();
        if (favorites == null) {
            return false;
        }
        sFavorites = favorites;
        sLastReadAtMs = SystemClock.elapsedRealtime();
        return true;
    }

    /** Every liked path, or null when the database could not be opened. */
    private static Set<String> readFavorites() {
        SQLiteDatabase db = open();
        if (db == null) {
            return null;
        }
        try (Cursor c = db.rawQuery("SELECT Path FROM " + TABLE, null)) {
            Set<String> paths = new HashSet<>();
            while (c != null && c.moveToNext()) {
                String path = c.getString(0);
                if (path != null) {
                    paths.add(path);
                }
            }
            return paths;
        } catch (RuntimeException e) {
            Log.w(TAG, "favorites read failed", e);
            return null;
        } finally {
            close(db);
        }
    }

    private static void writeFavorite(String path, String name, String artist,
            String album, boolean favorite) {
        SQLiteDatabase db = open();
        if (db == null) {
            return;
        }
        try {
            // Delete first either way: it clears a stale row before an insert, and is the whole of
            // an un-favorite. Matches com.syu.music's own "delete ... where Path = ?".
            db.execSQL("DELETE FROM " + TABLE + " WHERE Path=?", new String[]{path});
            if (favorite) {
                // The columns com.syu.music's add2Favorite fills; its own screen reads them back.
                db.execSQL("INSERT INTO " + TABLE + "(Name,Path,Folder,Artist,Album) VALUES(?,?,?,?,?)",
                        new String[]{nonEmpty(name, fileNameOf(path)), path, folderOf(path),
                                nonEmpty(artist, "<unknown>"), nonEmpty(album, "<unknown>")});
            }
            Log.d(TAG, "favorite=" + favorite + " written for " + path
                    + (sAccess == ACCESS_DIRECT ? " (opened directly)" : " (through root)"));
        } catch (RuntimeException e) {
            Log.w(TAG, "favorite write failed", e);
        } finally {
            close(db);
        }
    }

    /**
     * Opens the real database, directly or behind a momentary root grant; null if the grant or
     * open failed.
     */
    private static SQLiteDatabase open() {
        boolean root = sAccess == ACCESS_ROOT;
        if (root && !su(GRANT)) {
            return null;
        }
        SQLiteDatabase db;
        try {
            // OPEN_READWRITE only: no ENABLE_WRITE_AHEAD_LOGGING, so the file keeps its rollback
            // journal - turning on WAL here would litter com.syu.music's dir with -wal/-shm files.
            db = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (RuntimeException e) {
            Log.w(TAG, "openDatabase failed", e);
            db = null;
        }
        if (db == null && root) {
            su(REVOKE);
        }
        return db;
    }

    private static void close(SQLiteDatabase db) {
        try {
            db.close();
        } catch (RuntimeException ignored) {
        }
        if (sAccess == ACCESS_ROOT) {
            su(REVOKE);
        }
    }

    // =====================================================================================
    // Root
    // =====================================================================================

    /** Runs one command as root (su -c). true when su ran it and it exited 0. */
    private static boolean su(String command) {
        Process p = null;
        try {
            p = new ProcessBuilder("su", "-c", command).redirectErrorStream(true).start();
            if (!p.waitFor(5, TimeUnit.SECONDS)) {
                return false;
            }
            return p.exitValue() == 0;
        } catch (Exception e) {
            // No su, or the superuser prompt was denied: the library is simply not reachable.
            Log.w(TAG, "su failed", e);
            return false;
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
    }

    // =====================================================================================
    // Helpers
    // =====================================================================================

    private static void redraw(Context app) {
        MAIN.post(() -> MediaFavoriteController.onStockFavoriteChanged(app));
    }

    private static String nonEmpty(String value, String fallback) {
        return TextUtils.isEmpty(value) ? fallback : value;
    }

    /** The parent directory's own name, as com.syu.music stores in Folder. */
    private static String folderOf(String path) {
        int end = path.lastIndexOf('/');
        if (end <= 0) {
            return "";
        }
        int start = path.lastIndexOf('/', end - 1);
        return path.substring(start + 1, end);
    }

    private static String fileNameOf(String path) {
        int slash = path.lastIndexOf('/');
        return slash >= 0 ? path.substring(slash + 1) : path;
    }
}
