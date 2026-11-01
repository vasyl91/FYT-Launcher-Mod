package com.fyt.car;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import com.fyt.car.StockKindArbiter.Kind;

import java.util.Objects;

/**
 * The binding to one of com.syu.media's two playback services: the 7870's stock player, which
 * never starts MusicService, reports its track to com.syu.ms only. Both services are exported
 * without a permission (an intent-filter, targetSdk 26) and speak AIDL com.syu.media.IPlayer,
 * with the same codes; MediaSource carries the track, so no file has to be readable here.
 *
 * <pre>
 *   MEDIA_MUSIC   action com.syu.media.music.MusicService          channel 8, library "song"
 *   MEDIA_ONLINE  action com.syu.media.online.OnlineRadioService   channel 7, library "radio"
 * </pre>
 *
 * The protocol, from the decompiled com.syu.media (no AIDL files: the codes are fixed by it):
 * <pre>
 *   IPlayer   1 play() 5 playLast() 6 playNext() 7 pause() 8 isPlaying() -> int
 *             9 getProgress() -> int (ms) 10 getPlayingSong() -> MediaSource
 *             15 registerCallback(ICallback)
 *   ICallback 1 onSongChanged(MediaSource) 2 onPlayStatusChanged(int) 3 onPlayModeChanged(int)
 *   MediaSource: int id, String title, displayName, artist, album, path, folder,
 *             int duration (ms), byte favorite (an int in the parcel), int length;
 *             RadioSource adds String type, country, local, freqTitle, icon
 * </pre>
 * Without a track getPlayingSong() answers a placeholder (id -1, every text "unknown"), which is
 * no track.
 *
 * Without BIND_AUTO_CREATE: the launcher only listens, it does not bring a player up (created,
 * it resumes the last track by itself). The connection comes as soon as the service runs, and
 * again after each restart. The online service lives only while a page of com.syu.media binds it,
 * so it comes and goes: a service that is destroyed gives onServiceDisconnected and
 * onBindingDied, and the binding is made again.
 *
 * Binder calls go out on "SyuMediaClient", never the main thread; the fields of MusicService are
 * written on the main thread, like onStartCommand() writes them.
 */
final class SyuMediaClient implements ServiceConnection {

    private static final String TAG = "SyuMedia";

    private static final String IPLAYER = "com.syu.media.IPlayer";
    private static final String ICALLBACK = "com.syu.media.ICallback";
    private static final int TX_PLAY = 1;
    private static final int TX_PLAY_LAST = 5;
    private static final int TX_PLAY_NEXT = 6;
    private static final int TX_PAUSE = 7;
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
    /** The library is asked for the flag on a new track, after a write, on a request, and this often. */
    private static final int FAVORITE_EVERY_TICKS = 5;

    private static final String COLUMN_FAVORITE = "favorite";

    static volatile SyuMediaClient music;
    static volatile SyuMediaClient online;

    /** Whether "not available" has been logged: once for both services. */
    private static boolean sMissingLogged;

    private static HandlerThread sThread;

    /** Starts following com.syu.media, once per process. Any thread. */
    static synchronized void start(Context context) {
        if (music != null) {
            return;
        }
        Context app = context.getApplicationContext();
        sThread = new HandlerThread("SyuMediaClient");
        sThread.start();
        music = new SyuMediaClient(app, Kind.MEDIA_MUSIC, "com.syu.media.music.MusicService",
                Uri.parse("content://com.syu.media/song"), sThread.getLooper());
        online = new SyuMediaClient(app, Kind.MEDIA_ONLINE, "com.syu.media.online.OnlineRadioService",
                Uri.parse("content://com.syu.media/radio"), sThread.getLooper());
        music.worker.post(music::bind);
        online.worker.post(online::bind);
    }

    /** The client of a com.syu.media player; null before start() and for any other kind. */
    static SyuMediaClient of(Kind kind) {
        if (kind == Kind.MEDIA_MUSIC) {
            return music;
        }
        if (kind == Kind.MEDIA_ONLINE) {
            return online;
        }
        return null;
    }

    final Kind kind;
    private final Context app;
    private final String action;
    private final Uri library;
    private final Handler worker;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final Binder callback = new CallbackStub();
    private final Runnable tick = this::tickRefresh;

    // worker thread only
    private IBinder player;
    private State last;
    private int ticks;

    /** Whether player is set, for control() on another thread. */
    private volatile boolean connected;
    private volatile long lastRequestedRefreshAtMs;
    /** When a read last said it plays; 0 if it never did. See StockResumePolicy. */
    private volatile long lastPlayingAtMs;

    private SyuMediaClient(Context app, Kind kind, String action, Uri library, Looper looper) {
        this.app = app;
        this.kind = kind;
        this.action = action;
        this.library = library;
        this.worker = new Handler(looper);
    }

    boolean isConnected() {
        return connected;
    }

    long lastPlayingAtMs() {
        return lastPlayingAtMs;
    }

    /** What the client knows, for the diagnostics. */
    String dump() {
        State s = last;
        return kind + ": " + (connected ? "connected" : "not connected") + ", lastPlayingAt="
                + lastPlayingAtMs + (s != null ? ", last=" + s.describe() : ", no track");
    }

    // ---------------------------------------------------------------------------------------------
    // Binding
    // ---------------------------------------------------------------------------------------------

    private void bind() {
        Intent intent = new Intent(action).setPackage(MusicService.MEDIA_PKG);
        boolean bound;
        try {
            bound = app.bindService(intent, this, 0);
        } catch (RuntimeException e) {
            Log.w(TAG, kind + " bindService failed", e);
            bound = false;
        }
        if (!bound) {
            // Not a 7870 (no com.syu.media): nothing to follow.
            synchronized (SyuMediaClient.class) {
                if (!sMissingLogged) {
                    sMissingLogged = true;
                    Log.d(TAG, MusicService.MEDIA_PKG + " not available");
                }
            }
            try {
                app.unbindService(this);
            } catch (RuntimeException ignored) {
            }
            return;
        }
        Log.d(TAG, kind + " bind " + action);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        worker.post(() -> {
            player = service;
            connected = true;
            Log.d(TAG, kind + " connected");
            Parcel reply = callPlayer(TX_REGISTER_CALLBACK, callback);
            if (reply != null) {
                reply.recycle();
            }
            last = null;
            refresh(true);
        });
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        // The service stopped or its process died; the binding stays and connects again when it
        // is back. Until then it is not playing.
        Log.d(TAG, kind + " disconnected");
        worker.post(this::dropPlayer);
    }

    @Override
    public void onBindingDied(ComponentName name) {
        // com.syu.media was updated or reinstalled, or the service was destroyed with its last
        // page: this binding is over, a new one is needed.
        Log.d(TAG, kind + " bindingDied, binding again in " + REBIND_MS + " ms");
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
        connected = false;
        if (last != null && last.playing) {
            // Keep the track, only the play state changes.
            publish(last.withPlaying(false));
        }
    }

    // ---------------------------------------------------------------------------------------------
    // What the player reports
    // ---------------------------------------------------------------------------------------------

    /** See MusicService.requestSyuMediaRefresh(). Any thread. */
    void requestRefresh() {
        long now = SystemClock.elapsedRealtime();
        if (now - lastRequestedRefreshAtMs < REQUESTED_REFRESH_MIN_MS) {
            return;
        }
        lastRequestedRefreshAtMs = now;
        worker.post(() -> refresh(true));
    }

    /**
     * Reads the player again and publishes it whatever it says, for a source that has just
     * become the one shown. Any thread.
     */
    void republish() {
        worker.post(() -> {
            if (player != null) {
                last = null;
                refresh(true);
            } else if (last != null) {
                publish(last);
            }
        });
    }

    private void tickRefresh() {
        ticks++;
        refresh(ticks % FAVORITE_EVERY_TICKS == 0);
    }

    /**
     * Reads the player's state and publishes it. Worker thread.
     *
     * @param forceFavorite read the library's flag even though the track is the same one
     */
    private void refresh(boolean forceFavorite) {
        worker.removeCallbacks(tick);
        if (player == null) {
            return;
        }
        long sampledAt = SystemClock.elapsedRealtime();
        Parcel reply = callPlayer(TX_GET_PLAYING_SONG, null);
        Song song = null;
        if (reply != null) {
            try {
                song = Song.read(reply);
            } catch (RuntimeException e) {
                Log.w(TAG, kind + ": unreadable song", e);
            } finally {
                reply.recycle();
            }
        }
        boolean playing = readInt(TX_IS_PLAYING, 0) != 0;
        long progress = readInt(TX_GET_PROGRESS, 0);
        if (player == null) {
            return; // died during the calls
        }
        if (playing) {
            lastPlayingAtMs = sampledAt;
        }
        if (song == null || song.isPlaceholder()) {
            // No track: the one before stays, only its play state can have changed.
            if (last != null && (playing != last.playing)) {
                publish(last.withPlaying(playing, progress, sampledAt));
            }
        } else {
            boolean sameTrack = last != null && last.isSameTrack(song);
            Boolean favorite = last != null && sameTrack ? last.favorite : null;
            if (!sameTrack || forceFavorite) {
                favorite = readFavorite(song);
            }
            State s = new State(kind, playing, progress, song, favorite, sampledAt);
            // While playing every second, like com.syu.music; otherwise only what changed.
            if (playing || !s.sameAs(last)) {
                publish(s);
            }
        }
        if (playing) {
            worker.postDelayed(tick, TICK_MS);
        }
    }

    private void publish(State s) {
        last = s;
        main.post(() -> MusicService.onSyuMediaState(app, s));
    }

    // ---------------------------------------------------------------------------------------------
    // Control
    // ---------------------------------------------------------------------------------------------

    /** See MusicService.controlSyuMedia(). Any thread. */
    boolean control(int command) {
        if (!connected) {
            return false;
        }
        worker.post(() -> {
            int code;
            String what;
            if (command == MusicService.SYU_MEDIA_NEXT) {
                code = TX_PLAY_NEXT;
                what = "next";
            } else if (command == MusicService.SYU_MEDIA_PREVIOUS) {
                code = TX_PLAY_LAST;
                what = "previous";
            } else {
                // No toggle in IPlayer, and TX_PLAY on a track that plays starts it again: the
                // state decides, read in this very task.
                boolean playing = readInt(TX_IS_PLAYING, 0) != 0;
                code = playing ? TX_PAUSE : TX_PLAY;
                what = playing ? "pause" : "play";
                if (playing) {
                    main.post(() -> StockSources.onUserPaused(kind));
                }
            }
            Log.d(TAG, "control " + kind + " " + what + " -> TX " + code);
            Parcel reply = callPlayer(code, null);
            if (reply != null) {
                reply.recycle();
            }
            // Its callbacks follow too; this one does not wait for them
            refresh(false);
        });
        return true;
    }

    /**
     * Starts the player again if it is stopped, once the launcher has put its channel back
     * (StockResumePolicy). Any thread.
     */
    void resumeIfStopped(int channel) {
        worker.post(() -> {
            if (player == null) {
                Log.d(TAG, "resume " + kind + " skipped: not connected");
                return;
            }
            if (readInt(TX_IS_PLAYING, 0) != 0) {
                Log.d(TAG, "resume " + kind + " not needed: it plays");
                return;
            }
            Log.d(TAG, "resume " + kind + " after channel restore " + channel);
            Parcel reply = callPlayer(TX_PLAY, null);
            if (reply != null) {
                reply.recycle();
            }
            refresh(false);
        });
    }

    /** See MusicService.setSyuMediaFavorite(). */
    void writeFavorite(State track, boolean favorite) {
        worker.post(() -> {
            ContentValues values = new ContentValues();
            values.put(COLUMN_FAVORITE, favorite);
            int rows = 0;
            try {
                rows = app.getContentResolver().update(library, values,
                        trackSelection(track), trackSelectionArgs(track));
            } catch (RuntimeException e) {
                Log.w(TAG, kind + ": favorite not written", e);
            }
            Log.d(TAG, "favorite " + kind + "=" + favorite + " written to " + rows + " row(s)");
            // Read back whatever the library now holds, and publish it even when it is what
            // was last published: the flag shown was changed ahead of the write.
            last = null;
            refresh(true);
        });
    }

    /** The track's favorite flag in com.syu.media's library; null if it cannot be read. */
    private Boolean readFavorite(Song song) {
        if (song == null || song.path.isEmpty()) {
            return null;
        }
        State track = new State(kind, false, 0, song, null, 0);
        try (Cursor c = app.getContentResolver().query(library,
                new String[]{COLUMN_FAVORITE}, trackSelection(track),
                trackSelectionArgs(track), null)) {
            if (c != null && c.moveToFirst()) {
                return c.getInt(0) != 0;
            }
        } catch (RuntimeException e) {
            Log.w(TAG, kind + ": favorite not readable: " + e);
        }
        return null; // not in its library (yet)
    }

    /** As com.syu.media's own MediaProviderUtils.update(); by path alone without an id. */
    private static String trackSelection(State track) {
        return track.id >= 0 ? "_id=? AND path=?" : "path=?";
    }

    private static String[] trackSelectionArgs(State track) {
        return track.id >= 0
                ? new String[]{String.valueOf(track.id), track.path}
                : new String[]{track.path};
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
            Log.w(TAG, kind + " call " + code + " failed: " + e);
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
                worker.post(() -> refresh(false));
            }
            // The player calls this synchronously, inside a lock of its own: answer at once
            if (reply != null) {
                reply.writeNoException();
            }
            return true;
        }
    }

    // ---------------------------------------------------------------------------------------------
    // Values
    // ---------------------------------------------------------------------------------------------

    /** A MediaSource as read from its parcel. */
    static final class Song {
        int id;
        String title = "";
        String artist = "";
        String album = "";
        String path = "";
        int duration;
        /** RadioSource: the kind of station (Pop, News ...), "" for a track. */
        String type = "";

        /** Reads a MediaSource written with its "non-null" int in front, as IPlayer sends it. */
        static Song read(Parcel p) {
            if (p.readInt() == 0) {
                return null;
            }
            Song s = new Song();
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
            // favorite (the library's is used, it is the in-memory copy here) and length
            p.readInt();
            p.readInt();
            if (p.dataAvail() > 0) {
                try {
                    s.type = nonNull(p.readString());
                } catch (RuntimeException e) {
                    // not a RadioSource after all
                }
            }
            return s;
        }

        /** What getPlayingSong() answers without a track: id -1, every text "unknown". */
        boolean isPlaceholder() {
            return id < 0 || "unknown".equals(path);
        }
    }

    /** What a player reports, read on the client's thread and applied on the main one. */
    static final class State {
        final Kind kind;
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
        /** When the player was read (SystemClock.elapsedRealtime()). */
        final long sampledAtMs;

        State(Kind kind, boolean playing, long progress, Song song, Boolean favorite,
                long sampledAtMs) {
            this.kind = kind;
            this.playing = playing;
            this.progress = Math.max(progress, 0);
            this.duration = Math.max(song.duration, 0);
            this.id = song.id;
            this.title = song.title;
            // A station has no artist: its kind of music says what it is
            this.artist = song.artist.isEmpty() || "unknown".equals(song.artist) ? song.type : song.artist;
            this.album = song.album;
            this.path = song.path;
            this.favorite = favorite;
            this.sampledAtMs = sampledAtMs;
        }

        private State(State o, boolean playing, long progress, Boolean favorite, long sampledAtMs) {
            this.kind = o.kind;
            this.playing = playing;
            this.progress = Math.max(progress, 0);
            this.duration = o.duration;
            this.id = o.id;
            this.title = o.title;
            this.artist = o.artist;
            this.album = o.album;
            this.path = o.path;
            this.favorite = favorite;
            this.sampledAtMs = sampledAtMs;
        }

        State withPlaying(boolean playing) {
            return new State(this, playing, progress, favorite, sampledAtMs);
        }

        State withPlaying(boolean playing, long progress, long sampledAtMs) {
            return new State(this, playing, progress, favorite, sampledAtMs);
        }

        State withFavorite(Boolean favorite) {
            return new State(this, playing, progress, favorite, sampledAtMs);
        }

        boolean isSameTrack(Song song) {
            return id == song.id && path.equals(song.path);
        }

        /** Same track, play state and favorite; the position is left out, it moves every second. */
        boolean sameAs(State o) {
            return o != null && playing == o.playing && duration == o.duration && id == o.id
                    && title.equals(o.title) && artist.equals(o.artist)
                    && album.equals(o.album) && path.equals(o.path)
                    && Objects.equals(favorite, o.favorite);
        }

        String describe() {
            return (playing ? "playing" : "paused") + " '" + title + "' " + progress + "/"
                    + duration + "ms favorite=" + favorite + " " + path;
        }
    }

    private static String nonNull(String s) {
        return s != null ? s : "";
    }
}
