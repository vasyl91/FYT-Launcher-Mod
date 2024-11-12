package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class VideoService extends Service {
    public static final String LAUNCHERVIDEO = "com.fyt.launcher.video";
    public static final String MUSIC_PKG = "com.syu.music";
    public static final String NEXTSERVICE = "com.syu.music.next";
    public static final String PLAYSERVICE = "com.syu.music.playpause";
    public static final String PLAY_ALBUM = "play_album";
    public static final String PLAY_ALBUMPIC = "play_alubm_pic";
    public static final String PLAY_ARTIST = "play_artist";
    public static final String PLAY_CURMINUTES = "play_cur";
    public static final String PLAY_STATE = "play_state";
    public static final String PLAY_TOTALMINUTES = "play_total";
    public static final String PRESERVICE = "com.syu.music.prev";
    public static final String REMOVE_MUSIC = "com.fyt.systemui.remove";
    public static final String TITLE = "title";
    public static byte[] album_cover;
    public static String music_name = "";
    public static String author_name = "";
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
        if (LAUNCHERVIDEO.equals(action)) {
            Bundle bundle = intent.getExtras();
            state = Boolean.valueOf(bundle.getBoolean("play_state"));
            LauncherNotify.NOTIFIER_VIDEO.set(null, new long[]{CURMINUTES, TOTALMINUTES}, null, new String[]{state.toString(), author_name, music_name}, null, "fyt");
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
