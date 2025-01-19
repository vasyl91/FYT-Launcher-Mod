package com.fyt.widget;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.fyt.car.LauncherNotify;

public class DvrService extends Service {
    public static final String LAUNCHERDVR = "com.fyt.launcher.dvr";
    public static final String MUSIC_PKG = "com.syu.music";
    public static final String NEXTSERVICE = "com.syu.music.next";
    public static final String PLAYSERVICE = "com.syu.music.playpause";
    public static final String PLAY_ALBUM = "play_album";
    public static final String PLAY_ALBUMPIC = "play_alubm_pic";
    public static final String PLAY_ARTIST = "play_artist";
    public static final String PLAY_CURMINUTES = "play_cur";
    public static final String PLAY_TOTALMINUTES = "play_total";
    public static final String PRESERVICE = "com.syu.music.prev";
    public static final String REC_STATE = "DVR";
    public static final String REMOVE_MUSIC = "com.fyt.systemui.remove";
    public static final String TITLE = "title";
    public static byte[] album_cover;
    public static String music_name = "";
    public static String author_name = "";
    public static int state = 0;
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
        if (LAUNCHERDVR.equals(action)) {
            Bundle bundle = intent.getExtras();
            state = bundle.getInt(REC_STATE);
            Log.i("hy", "state" + state);
            LauncherNotify.NOTIFIER_DVR.set(new int[]{state}, null, null, null, null, "fyt");
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
