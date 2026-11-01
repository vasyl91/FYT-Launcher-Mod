package com.fyt.car;

import com.android.launcher66.SysCalls;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
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
    // The 7870's players (com.syu.media)
    // ---------------------------------------------------------------------------------------------

    /*
     * com.syu.media, the 7870's stock player, never starts this service: it reports its track to
     * com.syu.ms only. Its two playback services (local / USB music, internet radio) are exported
     * without a permission and speak AIDL com.syu.media.IPlayer, so SyuMediaClient binds to them
     * and this class fills the same fields as onStartCommand() does for com.syu.music, whichever
     * of them is the source shown (StockSources). On a unit without com.syu.media the bind fails
     * and nothing else happens.
     *
     * Its favorites live in its own library, the "favorite" column of content://com.syu.media/song
     * (internet radio: /radio), a provider exported without a permission. com.syu.media writes it
     * there itself (MediaProviderUtils.update: "favorite" by "_id=? AND path=?"), and its player
     * screen reads it back on every track change. The flag inside MediaSource is not used: it is
     * the in-memory copy, only refreshed while that screen is open.
     */
    public static final String MEDIA_PKG = "com.syu.media";

    /** Starts following com.syu.media, once per process. Any thread. */
    public static void startSyuMedia(Context context) {
        SyuMediaClient.start(context.getApplicationContext());
    }

    /** The com.syu.media update the fields above were last filled from; main thread. */
    private static volatile SyuMediaClient.State sSyuMediaShown;

    /**
     * Whether the track in the fields above is com.syu.media's (a 7870), not com.syu.music's: the
     * last com.syu.media update is still what they show.
     */
    public static boolean isSyuMediaSource() {
        SyuMediaClient.State s = sSyuMediaShown;
        return s != null && !s.path.isEmpty() && s.path.equals(music_path);
    }

    /** com.syu.media's favorite flag of the track shown; null while unknown or not its track. */
    public static Boolean getSyuMediaFavorite() {
        return isSyuMediaSource() ? sSyuMediaShown.favorite : null;
    }

    /**
     * Writes com.syu.media's favorite flag of the track shown, into the library its player keeps
     * it in. Main thread: the flag reads as changed at once, and is read back from the library
     * once written (put back if refused).
     *
     * @return false when there is no com.syu.media track to write it for
     */
    public static boolean setSyuMediaFavorite(boolean favorite) {
        SyuMediaClient.State s = sSyuMediaShown;
        SyuMediaClient client = s != null ? SyuMediaClient.of(s.kind) : null;
        if (client == null || !isSyuMediaSource() || s.favorite == null) {
            return false;
        }
        sSyuMediaShown = s.withFavorite(favorite);
        client.writeFavorite(s, favorite);
        return true;
    }

    /** For controlSyuMedia(). */
    public static final int SYU_MEDIA_PLAY_PAUSE = 0;
    public static final int SYU_MEDIA_NEXT = 1;
    public static final int SYU_MEDIA_PREVIOUS = 2;

    /**
     * Play/pause, next or previous for the com.syu.media player shown (music or internet radio),
     * over its IPlayer binder: it has no intents, and its media session handles no keys for
     * music. Any thread; the call goes out on the client's.
     *
     * @return false when its service is not bound (not running)
     */
    public static boolean controlSyuMedia(int command) {
        SyuMediaClient client = SyuMediaClient.of(shownPlayerKind());
        return client != null && client.control(command);
    }

    /** Asks com.syu.media again, at most once a second; for a flag changed in its own screen. */
    public static void requestSyuMediaRefresh() {
        SyuMediaClient client = SyuMediaClient.of(shownPlayerKind());
        if (client != null) {
            client.requestRefresh();
        }
    }

    /** The player a button is meant for: the one shown, the music player when none is. */
    private static StockKindArbiter.Kind shownPlayerKind() {
        StockKindArbiter.Kind kind = StockSources.shownKind();
        return kind.isMediaPlayer() ? kind : StockKindArbiter.Kind.MEDIA_MUSIC;
    }

    /**
     * What a com.syu.media player reported, read on its client's thread. Main thread. The state
     * of a player that is not the source shown stays with its client: the fields above belong to
     * what the widget shows.
     */
    static void onSyuMediaState(Context app, SyuMediaClient.State s) {
        if (!StockSources.acceptSyuMedia(s.kind, s.playing, s.sampledAtMs)) {
            return;
        }
        applySyuMedia(app, s);
    }

    /**
     * Same as onStartCommand() with sendData()/sendInternalData(), for an update that does not
     * come as an intent to a service instance. Main thread, as there.
     */
    private static void applySyuMedia(Context app, SyuMediaClient.State s) {
        SyuMediaClient.State before = sSyuMediaShown;
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

        // The widget gets the track as it is, not a path to read the tags of: a stream has none,
        // and a file may not be readable here (the standard version without storage access)
        StockTrack track = new StockTrack(s.kind, s.path, s.title, s.artist, s.album, s.duration,
                s.progress, s.playing, StockTitles.isLocalFile(s.path), null, s.favorite);
        if (s.playing) {
            // Held back, like com.syu.music's in onStartCommand(), for the moment after a
            // session's player took over (NotificationListener.setStatus(2)); the next second's
            // read follows
            if (hasTitle && new Helpers().isFytMusicAllowed()) {
                NotificationListener.onStockSourceUpdate(track);
            }
        } else {
            // The play/pause icon and the time do not move by themselves once it stopped
            NotificationListener.onStockSourcePaused(track);
        }

        // A flag changed in com.syu.media's own screen, or read only now: the hearts do not redraw
        // by themselves while it is paused.
        if (before == null || before.kind != s.kind || !before.path.equals(s.path)
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
}
