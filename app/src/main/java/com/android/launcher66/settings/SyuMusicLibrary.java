package com.android.launcher66.settings;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.android.launcher66.MediaFavoriteController;
import com.syu.util.WindowHostVdClient;

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
 * Reaching that database (it is owned by com.syu.music, uid system, mode 660, and this launcher is
 * not that uid): this runs only on a rooted unit, with the user's root, on the user's own apps.
 * The file must be touched through a real SQLite connection - replacing it as a whole file would
 * corrupt com.syu.music's open connection, and there is no sqlite3 binary on the unit to run SQL
 * as root - so root widens the file's other-permission for the moment of the open, the launcher
 * opens the real file with its own SQLite engine (multi-process safe with the player's connection,
 * so each sees the other's committed change), and the permission is taken away again the instant
 * the connection closes. com.syu.music, the owner, keeps its own access the whole time.
 *
 * Without root the launcher cannot reach it and {@link #isAvailable} is false, so the caller keeps
 * its opt-in cache instead.
 *
 * Reads are cached per path so the widget's per-draw lookups stay on the main thread while the
 * database work (and the su calls) run on {@link #IO}; writes are optimistic and read back.
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

    private static volatile int sAccess = ACCESS_UNKNOWN;

    private static final ExecutorService IO = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "SyuMusicLib");
        t.setDaemon(true);
        return t;
    });
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    /** Favorite state per track path, for the main thread; absent until a read lands. */
    private static final ConcurrentHashMap<String, Boolean> FAV_BY_PATH = new ConcurrentHashMap<>();
    private static volatile String sLoadingPath;

    private SyuMusicLibrary() {
    }

    /**
     * Whether com.syu.music's real favorites are reachable, so the launcher manages them there
     * instead of in its cache: com.syu.music installed and a root (su) host present on the unit.
     */
    public static boolean isAvailable(Context context) {
        return accessMode(context) == ACCESS_ROOT;
    }

    /**
     * The favorite state of {@code path}: FAVORITED, NOT_FAVORITED, or UNKNOWN until the first
     * background read for it lands (then the widget is redrawn). A track the database has no row
     * for reads as NOT_FAVORITED, so the button is usable and the first press likes it.
     */
    public static int getState(Context context, String path) {
        if (TextUtils.isEmpty(path) || accessMode(context) != ACCESS_ROOT) {
            return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
        }
        Boolean fav = FAV_BY_PATH.get(path);
        if (fav != null) {
            return fav ? MediaFavoriteController.FAVORITE_STATE_FAVORITED
                    : MediaFavoriteController.FAVORITE_STATE_NOT_FAVORITED;
        }
        requestLoad(context.getApplicationContext(), path);
        return MediaFavoriteController.FAVORITE_STATE_UNKNOWN;
    }

    /**
     * Writes the favorite state of {@code path} into com.syu.music's library (insert or delete the
     * row, as it does itself). Optimistic: the cached state flips at once for the redraw, then the
     * row is written and read back on {@link #IO}.
     *
     * @return false when the library is not reachable
     */
    public static boolean setFavorite(Context context, String path, String name,
            String artist, String album, boolean favorite) {
        if (TextUtils.isEmpty(path) || accessMode(context) != ACCESS_ROOT) {
            return false;
        }
        FAV_BY_PATH.put(path, favorite);
        Context app = context.getApplicationContext();
        IO.execute(() -> {
            writeFavorite(path, name, artist, album, favorite);
            Boolean actual = readFavorite(path);
            if (actual != null) {
                FAV_BY_PATH.put(path, actual);
            }
            redraw(app);
        });
        return true;
    }

    // =====================================================================================
    // Access mode
    // =====================================================================================

    private static int accessMode(Context context) {
        int a = sAccess;
        if (a != ACCESS_UNKNOWN) {
            return a;
        }
        if (context == null || !isInstalled(context)) {
            return ACCESS_NONE; // not cached: com.syu.music may be installed later
        }
        // WindowHostVdClient.hasRoot() is the launcher's own su/root check (binary or module); it
        // does not invoke su, so no superuser prompt here - that comes on the first real DB touch.
        a = WindowHostVdClient.hasRoot() ? ACCESS_ROOT : ACCESS_NONE;
        sAccess = a;
        return a;
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

    private static void requestLoad(Context app, String path) {
        if (path.equals(sLoadingPath)) {
            return;
        }
        sLoadingPath = path;
        IO.execute(() -> {
            Boolean fav = readFavorite(path);
            if (path.equals(sLoadingPath)) {
                sLoadingPath = null;
            }
            if (fav != null) {
                FAV_BY_PATH.put(path, fav);
                redraw(app);
            }
        });
    }

    /** True/false from the row's presence, or null when the database could not be opened. */
    private static Boolean readFavorite(String path) {
        SQLiteDatabase db = open();
        if (db == null) {
            return null;
        }
        try (Cursor c = db.rawQuery("SELECT 1 FROM " + TABLE + " WHERE Path=? LIMIT 1",
                new String[]{path})) {
            return c != null && c.moveToFirst();
        } catch (RuntimeException e) {
            Log.w(TAG, "favorite read failed", e);
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
            Log.d(TAG, "favorite=" + favorite + " written for " + path);
        } catch (RuntimeException e) {
            Log.w(TAG, "favorite write failed", e);
        } finally {
            close(db);
        }
    }

    /** Opens the real database behind a momentary root grant; null if the grant or open failed. */
    private static SQLiteDatabase open() {
        if (!su(GRANT)) {
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
        if (db == null) {
            su(REVOKE);
        }
        return db;
    }

    private static void close(SQLiteDatabase db) {
        try {
            db.close();
        } catch (RuntimeException ignored) {
        }
        su(REVOKE);
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
