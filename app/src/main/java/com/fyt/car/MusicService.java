package com.fyt.car;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.android.launcher66.NotificationListener;
import com.syu.widget.Widget;

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
            sendData();
        }
        return super.onStartCommand(intent, flags, startId);
    }

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
}
