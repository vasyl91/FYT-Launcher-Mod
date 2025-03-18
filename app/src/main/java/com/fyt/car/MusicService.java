package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import android.util.Log;

import com.android.launcher66.Launcher;
import com.android.launcher66.settings.Helpers;

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
    private boolean intentSent = false;

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
        if (MUSICSERVICE.equals(action)) {
            Bundle bundle = intent.getExtras();
            TOTALMINUTES = bundle.getLong(PLAY_TOTALMINUTES);
            CURMINUTES = bundle.getLong(PLAY_CURMINUTES);
            music_name = bundle.getString(TITLE);
            author_name = bundle.getString(PLAY_ARTIST);
            music_path = bundle.getString(PLAY_PATH);
            state = Boolean.valueOf(bundle.getBoolean(PLAY_STATE));
            if (bundle.getString(PLAY_ALBUM) != null) {
                album = bundle.getString(PLAY_ALBUM);
            } else {
                album = "";
            }

            if (!music_name.contains("Unknown")) {
                sendData();
            }

            Helpers helpers = new Helpers();
            if (state && !music_name.contains("Unknown") && helpers.isFytMusicAllowed()) {
                sendInternalData();
            }
            
        }
        return super.onStartCommand(intent, flags, startId);
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
        sendBroadcastAsUser(intent, UserHandle.ALL);
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
        sendBroadcastAsUser(intent, UserHandle.ALL);
    }
}
