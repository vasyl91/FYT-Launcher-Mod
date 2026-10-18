package com.fyt.car;

import com.android.launcher66.SysCalls;
import android.app.Service;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import com.android.launcher66.MediaFavoriteController;
import com.android.launcher66.NotificationListener;
import com.android.launcher66.settings.Helpers;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class MusicService extends Service {
    public static final String MUSICSERVICE = "com.fyt.launcher.music";
    public static final String MUSIC_PKG = "com.syu.music";
    public static final String NEXTMUSIC = "com.syu.music.next";
    public static final String PLAYPAUSEMUSIC = "com.syu.music.playpause";
    public static final String PLAY_ALBUM = "play_album";
    public static final String PLAY_ARTIST = "play_artist";
    public static final String PLAY_CURMINUTES = "play_cur";
    public static final String PLAY_PATH = "play_path";
    public static final String PLAY_STATE = "play_state";
    public static final String PLAY_TOTALMINUTES = "play_total";
    public static final String PREVMUSIC = "com.syu.music.prev";
    public static final String REMOVE_MUSIC = "com.fyt.systemui.remove";
    public static final String TITLE = "title";
    public static final String TITLES_RECEIVER = "titlesReceiver";
    public static final String TITLES_INTERNAL = "titlesInternal";
    public static final String PLAY_SOURCE = "source";
    public static final String SOURCE = "fyt";
    public static byte[] album_cover;
    public static String music_name = "";
    public static String author_name = "";
    public static String music_path = "";
    public static Boolean state = false;
    public static String album = "";
    public static long TOTALMINUTES = 0;
    public static long CURMINUTES = 0;

    private static final String TAG = "MusicService";

    /*
     * The broadcasts go out from their own thread. sendBroadcast() is a synchronous call into
     * ActivityManager, and com.syu.music sends an update every second: during the boot-time stall
     * (ActivityManager blocked for ~11 s) onStartCommand() held the launcher's main thread for
     * over 7 s (capture 29-09-2026 20:17: MusicService.onStartCommand -> sendBroadcast).
     *
     * Every broadcast carries the full state, so while one is waiting only the latest per action is
     * kept: after a stall each action goes out once, with the current data, instead of a backlog
     * of stale seconds. The intents are still built here, on the caller's thread, from the values
     * of this very update.
     */
    private static final ExecutorService BROADCASTER = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "MusicServiceBroadcast");
        t.setDaemon(true);
        return t;
    });
    private static final AtomicReference<Intent> sPendingExternal = new AtomicReference<>();

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return super.onStartCommand(intent, flags, startId);
        }
        String action = intent.getAction();
        Bundle bundle = intent.getExtras();
        // Without extras there is nothing to read (this used to be a NullPointerException).
        if (MUSICSERVICE.equals(action) && bundle != null) {
            TOTALMINUTES = bundle.getLong(PLAY_TOTALMINUTES);
            CURMINUTES = bundle.getLong(PLAY_CURMINUTES);
            // Missing strings become "", as the album already did: a missing title used to crash
            // the launcher in music_name.contains() below.
            music_name = nonNull(bundle.getString(TITLE));
            author_name = nonNull(bundle.getString(PLAY_ARTIST));
            music_path = nonNull(bundle.getString(PLAY_PATH));
            state = Boolean.valueOf(bundle.getBoolean(PLAY_STATE));
            album = nonNull(bundle.getString(PLAY_ALBUM));

            boolean hasTitle = !music_name.isEmpty() && !music_name.contains("Unknown");
            if (hasTitle) {
                sendData();
            }

            Helpers helpers = new Helpers();
            if (state && hasTitle && helpers.isFytMusicAllowed()) {
                sendInternalData();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private static String nonNull(String s) {
        return s != null ? s : "";
    }

    // data for external apps
    public void sendData() {
        Intent intent = new Intent(TITLES_RECEIVER);
        Bundle bundle = new Bundle();
        bundle.putBoolean(PLAY_STATE, state);
        bundle.putString(TITLE, music_name);
        bundle.putString(PLAY_ARTIST, author_name);
        bundle.putString(PLAY_ALBUM, album);
        bundle.putString(PLAY_PATH, music_path);
        bundle.putString(PLAY_SOURCE, SOURCE);
        bundle.putLong(PLAY_TOTALMINUTES, TOTALMINUTES);
        bundle.putLong(PLAY_CURMINUTES, CURMINUTES);
        intent.putExtras(bundle);
        post(sPendingExternal, intent);
    }

    // data for NotificationListener.kt (the music widget); same process, so no broadcast
    public void sendInternalData() {
        NotificationListener.onFytUpdate(state, music_path, SOURCE, CURMINUTES);
    }

    /**
     * Sends the intent on BROADCASTER. If a send for the same action is still queued, the intent
     * just replaces the one it would have sent, so nothing piles up while ActivityManager stalls.
     */
    private void post(final AtomicReference<Intent> slot, Intent intent) {
        final Context app = getApplicationContext();
        if (slot.getAndSet(intent) != null) {
            return; // the queued send takes this newer intent
        }
        BROADCASTER.execute(() -> {
            Intent latest = slot.getAndSet(null);
            if (latest == null) {
                return;
            }
            try {
                SysCalls.sendBroadcast(app, latest);
            } catch (RuntimeException e) {
                Log.w(TAG, "sendBroadcast(" + latest.getAction() + ") failed", e);
            }
        });
    }

    // ---------------------------------------------------------------------------------------------
    // The 7870's player (com.syu.media)
    // ---------------------------------------------------------------------------------------------

    /*
     * com.syu.media, the 7870's stock player, never starts this service: it reports its track to
     * com.syu.ms only. Its playback service, though, is exported without a permission (an
     * intent-filter, targetSdk 26) and speaks AIDL com.syu.media.IPlayer, so the launcher binds to
     * it and fills the same fields as onStartCommand() does for com.syu.music. On a unit without
     * com.syu.media the bind fails and nothing else happens.
     *
     * The protocol, from the decompiled com.syu.media (no AIDL files: the codes are fixed by it):
     *   IPlayer   8 isPlaying() -> int, 9 getProgress() -> int (ms), 10 getPlayingSong() ->
     *             MediaSource, 15 registerCallback(ICallback), 16 unregisterCallback(ICallback)
     *   ICallback 1 onSongChanged(MediaSource), 2 onPlayStatusChanged(int), 3 onPlayModeChanged(int)
     *   MediaSource: int id, String title, displayName, artist, album, path, folder,
     *             int duration (ms), byte favorite, int length
     *
     * Its favorites live in its own library, the "favorite" column of content://com.syu.media/song,
     * a provider exported without a permission. com.syu.media writes it there itself
     * (MediaProviderUtils.update: "favorite" by "_id=? AND path=?"), and its player screen reads it
     * back on every track change. The flag inside MediaSource is not used: it is the in-memory
     * copy, only refreshed while that screen is open.
     */
    public static final String MEDIA_PKG = "com.syu.media";
    private static final String MEDIA_SERVICE_ACTION = "com.syu.media.music.MusicService";
    private static final Uri MEDIA_SONGS = Uri.parse("content://com.syu.media/song");
    private static final String COLUMN_FAVORITE = "favorite";

    /** Starts following com.syu.media, once per process. Any thread. */
    public static void startSyuMedia(Context context) {
        SyuMediaClient.start(context.getApplicationContext());
    }

    /** The com.syu.media update the fields above were last filled from; main thread. */
    private static volatile SyuMediaState sSyuMediaShown;

    /**
     * Whether the track in the fields above is com.syu.media's (a 7870), not com.syu.music's: the
     * last com.syu.media update is still what they show.
     */
    public static boolean isSyuMediaSource() {
        SyuMediaState s = sSyuMediaShown;
        return s != null && !s.path.isEmpty() && s.path.equals(music_path);
    }

    /** com.syu.media's favorite flag of the track shown; null while unknown or not its track. */
    public static Boolean getSyuMediaFavorite() {
        return isSyuMediaSource() ? sSyuMediaShown.favorite : null;
    }

    /**
     * Writes com.syu.media's favorite flag of the track shown. Main thread: the flag reads as
     * changed at once, and is read back from the library once written (put back if refused).
     *
     * @return false when there is no com.syu.media track to write it for
     */
    public static boolean setSyuMediaFavorite(boolean favorite) {
        SyuMediaClient client = SyuMediaClient.sInstance;
        SyuMediaState s = sSyuMediaShown;
        if (client == null || !isSyuMediaSource() || s.favorite == null) {
            return false;
        }
        sSyuMediaShown = s.withFavorite(favorite);
        client.writeFavorite(s, favorite);
        return true;
    }

    /** Asks com.syu.media again, at most once a second; for a flag changed in its own screen. */
    public static void requestSyuMediaRefresh() {
        SyuMediaClient client = SyuMediaClient.sInstance;
        if (client != null) {
            client.requestRefresh();
        }
    }

    /** What com.syu.media reports, read on the client's thread and applied on the main one. */
    private static final class SyuMediaState {
        final boolean playing;
        final long progress;
        final long duration;
        final int id;
        final String title;
        final String artist;
        final String album;
        final String path;
        /** From its library; null when it could not be read. */
        final Boolean favorite;

        SyuMediaState(boolean playing, long progress, SyuMediaSong song, Boolean favorite) {
            this.playing = playing;
            this.progress = Math.max(progress, 0);
            this.duration = song != null ? Math.max(song.duration, 0) : 0;
            this.id = song != null ? song.id : -1;
            this.title = song != null ? song.title : "";
            this.artist = song != null ? song.artist : "";
            this.album = song != null ? song.album : "";
            this.path = song != null ? song.path : "";
            this.favorite = favorite;
        }

        SyuMediaState withFavorite(Boolean favorite) {
            return new SyuMediaState(playing, progress, songOf(this), favorite);
        }

        /** Same track, play state and favorite; the position is left out, it moves every second. */
        boolean sameAs(SyuMediaState o) {
            return o != null && playing == o.playing && duration == o.duration && id == o.id
                    && title.equals(o.title) && artist.equals(o.artist)
                    && album.equals(o.album) && path.equals(o.path)
                    && Objects.equals(favorite, o.favorite);
        }
    }

    private static SyuMediaSong songOf(SyuMediaState s) {
        SyuMediaSong song = new SyuMediaSong();
        song.id = s.id;
        song.title = s.title;
        song.artist = s.artist;
        song.album = s.album;
        song.path = s.path;
        song.duration = (int) s.duration;
        return song;
    }

    private static final class SyuMediaSong {
        int id;
        String title;
        String artist;
        String album;
        String path;
        int duration;

        /** Reads a MediaSource written with its "non-null" int in front, as IPlayer sends it. */
        static SyuMediaSong read(Parcel p) {
            if (p.readInt() == 0) {
                return null;
            }
            SyuMediaSong s = new SyuMediaSong();
            s.id = p.readInt();
            String title = p.readString();
            String displayName = p.readString();
            // Untagged files: the file name, as com.syu.media shows them.
            s.title = nonNull(title != null && !title.isEmpty() ? title : displayName);
            s.artist = nonNull(p.readString());
            s.album = nonNull(p.readString());
            s.path = nonNull(p.readString());
            p.readString(); // folder
            s.duration = p.readInt();
            // favorite (the library's is used, see above) and length follow
            return s;
        }
    }

    /**
     * Same as onStartCommand() with sendData()/sendInternalData(), for an update that does not
     * come as an intent to a service instance. Main thread, as there.
     */
    private static void applySyuMedia(Context app, SyuMediaState s) {
        SyuMediaState before = sSyuMediaShown;
        sSyuMediaShown = s;
        TOTALMINUTES = s.duration;
        CURMINUTES = s.progress;
        music_name = s.title;
        author_name = s.artist;
        music_path = s.path;
        state = s.playing;
        album = s.album;

        boolean hasTitle = !music_name.isEmpty() && !music_name.contains("Unknown");
        if (hasTitle) {
            Intent intent = new Intent(TITLES_RECEIVER);
            Bundle bundle = new Bundle();
            bundle.putBoolean(PLAY_STATE, state);
            bundle.putString(TITLE, music_name);
            bundle.putString(PLAY_ARTIST, author_name);
            bundle.putString(PLAY_ALBUM, album);
            bundle.putString(PLAY_PATH, music_path);
            bundle.putString(PLAY_SOURCE, SOURCE);
            bundle.putLong(PLAY_TOTALMINUTES, TOTALMINUTES);
            bundle.putLong(PLAY_CURMINUTES, CURMINUTES);
            intent.putExtras(bundle);
            postFrom(app, sPendingExternal, intent);
        }

        Helpers helpers = new Helpers();
        if (state && hasTitle && helpers.isFytMusicAllowed()) {
            NotificationListener.onFytUpdate(state, music_path, SOURCE, CURMINUTES);
        }

        // A flag changed in com.syu.media's own screen, or read only now: the hearts do not redraw
        // by themselves while it is paused.
        if (before == null || !before.path.equals(s.path)
                || !Objects.equals(before.favorite, s.favorite)) {
            MediaFavoriteController.onStockFavoriteChanged(app);
        }
    }

    /** post() without a service instance; shares its slot, so the newest intent still wins. */
    private static void postFrom(final Context app, final AtomicReference<Intent> slot, Intent intent) {
        if (slot.getAndSet(intent) != null) {
            return;
        }
        BROADCASTER.execute(() -> {
            Intent latest = slot.getAndSet(null);
            if (latest == null) {
                return;
            }
            try {
                SysCalls.sendBroadcast(app, latest);
            } catch (RuntimeException e) {
                Log.w(TAG, "sendBroadcast(" + latest.getAction() + ") failed", e);
            }
        });
    }

    /**
     * The binding to com.syu.media's MusicService. Without BIND_AUTO_CREATE: the launcher only
     * listens, it does not bring the player up (created, it resumes the last track by itself). The
     * connection comes as soon as the player's service runs, and again after each restart.
     *
     * Binder calls go out on "SyuMediaClient", never the main thread; the fields are written on the
     * main thread, like onStartCommand() writes them.
     */
    private static final class SyuMediaClient implements ServiceConnection {
        private static final String IPLAYER = "com.syu.media.IPlayer";
        private static final String ICALLBACK = "com.syu.media.ICallback";
        private static final int TX_IS_PLAYING = 8;
        private static final int TX_GET_PROGRESS = 9;
        private static final int TX_GET_PLAYING_SONG = 10;
        private static final int TX_REGISTER_CALLBACK = 15;
        private static final int CB_SONG_CHANGED = 1;
        private static final int CB_PLAY_STATUS_CHANGED = 2;
        private static final int CB_PLAY_MODE_CHANGED = 3;

        /** com.syu.music sent an update every second while playing; this keeps that pace. */
        private static final long TICK_MS = 1000;
        private static final long REBIND_MS = 5000;
        /** requestRefresh() comes with every heart drawn: one lookup per second is enough. */
        private static final long REQUESTED_REFRESH_MIN_MS = 1000;

        private static volatile SyuMediaClient sInstance;

        private volatile long lastRequestedRefreshAtMs;

        private final Context app;
        private final Handler worker;
        private final Handler main = new Handler(Looper.getMainLooper());
        private final Binder callback = new CallbackStub();
        private final Runnable tick = this::refresh;
        // worker thread only
        private IBinder player;
        private SyuMediaState last;

        static synchronized void start(Context app) {
            if (sInstance != null) {
                return;
            }
            sInstance = new SyuMediaClient(app);
            sInstance.worker.post(sInstance::bind);
        }

        private SyuMediaClient(Context app) {
            this.app = app;
            HandlerThread thread = new HandlerThread("SyuMediaClient");
            thread.start();
            worker = new Handler(thread.getLooper());
        }

        private void bind() {
            Intent intent = new Intent(MEDIA_SERVICE_ACTION).setPackage(MEDIA_PKG);
            boolean bound;
            try {
                bound = app.bindService(intent, this, 0);
            } catch (RuntimeException e) {
                Log.w(TAG, "bindService(" + MEDIA_PKG + ") failed", e);
                bound = false;
            }
            if (!bound) {
                // Not a 7870 (no com.syu.media): nothing to follow.
                Log.d(TAG, MEDIA_PKG + " not available");
                try {
                    app.unbindService(this);
                } catch (RuntimeException ignored) {
                }
            }
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            worker.post(() -> {
                player = service;
                Log.d(TAG, MEDIA_PKG + " connected");
                Parcel reply = callPlayer(TX_REGISTER_CALLBACK, callback);
                if (reply != null) {
                    reply.recycle();
                }
                refresh();
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // The player's service stopped or its process died; the binding stays and connects
            // again when it is back. Until then it is not playing.
            worker.post(this::dropPlayer);
        }

        @Override
        public void onBindingDied(ComponentName name) {
            // com.syu.media was updated or reinstalled: this binding is over, a new one is needed.
            worker.post(() -> {
                dropPlayer();
                try {
                    app.unbindService(this);
                } catch (RuntimeException ignored) {
                }
                worker.postDelayed(this::bind, REBIND_MS);
            });
        }

        /** Worker thread. */
        private void dropPlayer() {
            worker.removeCallbacks(tick);
            if (player == null) {
                return;
            }
            player = null;
            Log.d(TAG, MEDIA_PKG + " disconnected");
            if (last != null && last.playing) {
                // Keep the track, only the play state changes.
                publish(new SyuMediaState(false, last.progress, songOf(last), last.favorite));
            }
        }

        /** See MusicService.requestSyuMediaRefresh(). Any thread. */
        void requestRefresh() {
            long now = SystemClock.elapsedRealtime();
            if (now - lastRequestedRefreshAtMs < REQUESTED_REFRESH_MIN_MS) {
                return;
            }
            lastRequestedRefreshAtMs = now;
            worker.post(this::refresh);
        }

        /** See MusicService.setSyuMediaFavorite(). */
        void writeFavorite(SyuMediaState track, boolean favorite) {
            worker.post(() -> {
                ContentValues values = new ContentValues();
                values.put(COLUMN_FAVORITE, favorite);
                int rows = 0;
                try {
                    rows = app.getContentResolver().update(MEDIA_SONGS, values,
                            trackSelection(track), trackSelectionArgs(track));
                } catch (RuntimeException e) {
                    Log.w(TAG, MEDIA_PKG + ": favorite not written", e);
                }
                Log.d(TAG, MEDIA_PKG + ": favorite=" + favorite + " written to " + rows + " row(s)");
                // Read back whatever the library now holds, and publish it even when it is what
                // was last published: the flag shown was changed ahead of the write.
                last = null;
                refresh();
            });
        }

        /** The track's favorite flag in com.syu.media's library; null if it cannot be read. */
        private Boolean readFavorite(SyuMediaSong song) {
            if (song == null || song.path.isEmpty()) {
                return null;
            }
            SyuMediaState track = new SyuMediaState(false, 0, song, null);
            try (Cursor c = app.getContentResolver().query(MEDIA_SONGS,
                    new String[]{COLUMN_FAVORITE}, trackSelection(track),
                    trackSelectionArgs(track), null)) {
                if (c != null && c.moveToFirst()) {
                    return c.getInt(0) != 0;
                }
            } catch (RuntimeException e) {
                Log.w(TAG, MEDIA_PKG + ": favorite not readable: " + e);
            }
            return null; // not in its library (yet)
        }

        /** As com.syu.media's own MediaProviderUtils.update(); by path alone without an id. */
        private static String trackSelection(SyuMediaState track) {
            return track.id >= 0 ? "_id=? AND path=?" : "path=?";
        }

        private static String[] trackSelectionArgs(SyuMediaState track) {
            return track.id >= 0
                    ? new String[]{String.valueOf(track.id), track.path}
                    : new String[]{track.path};
        }

        /** Reads the player's state and publishes it. Worker thread. */
        private void refresh() {
            worker.removeCallbacks(tick);
            if (player == null) {
                return;
            }
            Parcel reply = callPlayer(TX_GET_PLAYING_SONG, null);
            SyuMediaSong song = null;
            if (reply != null) {
                try {
                    song = SyuMediaSong.read(reply);
                } catch (RuntimeException e) {
                    Log.w(TAG, MEDIA_PKG + ": unreadable song", e);
                } finally {
                    reply.recycle();
                }
            }
            boolean playing = readInt(TX_IS_PLAYING, 0) != 0;
            long progress = readInt(TX_GET_PROGRESS, 0);
            if (player == null) {
                return; // died during the calls
            }
            SyuMediaState s = new SyuMediaState(playing, progress, song, readFavorite(song));
            // While playing every second, like com.syu.music; otherwise only what changed.
            if (playing || !s.sameAs(last)) {
                publish(s);
            }
            if (playing) {
                worker.postDelayed(tick, TICK_MS);
            }
        }

        private void publish(SyuMediaState s) {
            last = s;
            main.post(() -> applySyuMedia(app, s));
        }

        private int readInt(int code, int fallback) {
            Parcel reply = callPlayer(code, null);
            if (reply == null) {
                return fallback;
            }
            try {
                return reply.readInt();
            } finally {
                reply.recycle();
            }
        }

        /**
         * One IPlayer call; the reply past its exception header, or null when the call failed (the
         * caller recycles it). Worker thread.
         */
        private Parcel callPlayer(int code, IBinder arg) {
            IBinder p = player;
            if (p == null) {
                return null;
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken(IPLAYER);
                if (arg != null) {
                    data.writeStrongBinder(arg);
                }
                p.transact(code, data, reply, 0);
                reply.readException();
                return reply;
            } catch (RemoteException | RuntimeException e) {
                // DeadObjectException: onServiceDisconnected() follows. A RuntimeException is
                // thrown by the player itself (getPlayingSong() with a song without an id).
                Log.w(TAG, MEDIA_PKG + " call " + code + " failed: " + e);
                reply.recycle();
                return null;
            } finally {
                data.recycle();
            }
        }

        /** ICallback, implemented by hand like IPlayer. Binder threads: hands over to the worker. */
        private final class CallbackStub extends Binder {
            CallbackStub() {
                attachInterface(null, ICALLBACK);
            }

            @Override
            protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                    throws RemoteException {
                if (code == INTERFACE_TRANSACTION) {
                    reply.writeString(ICALLBACK);
                    return true;
                }
                if (code != CB_SONG_CHANGED && code != CB_PLAY_STATUS_CHANGED
                        && code != CB_PLAY_MODE_CHANGED) {
                    return super.onTransact(code, data, reply, flags);
                }
                data.enforceInterface(ICALLBACK);
                if (code != CB_PLAY_MODE_CHANGED) {
                    // The arguments are not needed: refresh() reads song, state and position
                    // together, so they always belong to each other.
                    worker.post(SyuMediaClient.this::refresh);
                }
                if (reply != null) {
                    reply.writeNoException();
                }
                return true;
            }
        }
    }
}
