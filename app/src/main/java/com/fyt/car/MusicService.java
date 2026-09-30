package com.fyt.car;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.android.launcher66.settings.Helpers;

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
    private static final AtomicReference<Intent> sPendingInternal = new AtomicReference<>();

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

    // data broadcasted to NotificationListener.kt for the music widget
    public void sendInternalData() {
        Intent intent = new Intent(TITLES_INTERNAL);
        Bundle bundle = new Bundle();
        bundle.putBoolean(PLAY_STATE, state);
        bundle.putString(PLAY_PATH, music_path);
        bundle.putString(PLAY_SOURCE, SOURCE);
        bundle.putLong(PLAY_CURMINUTES, CURMINUTES);
        intent.putExtras(bundle);
        post(sPendingInternal, intent);
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
                app.sendBroadcast(latest);
            } catch (RuntimeException e) {
                Log.w(TAG, "sendBroadcast(" + latest.getAction() + ") failed", e);
            }
        });
    }
}
