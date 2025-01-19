package com.fyt.car;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
import com.syu.log.LogPreview;
import com.syu.util.Utils;

public class SetWallpaperReceiver extends BroadcastReceiver {
    String name;
    String pak;
    private final Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (Launcher.getLauncher() == null) {
                SetWallpaperReceiver.this.handler.postDelayed(this, 1000L);
            } else {
                Launcher.getLauncher().setDefaultWallpaper();
            }
        }
    };

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("LZP", "onReceive-----------> 13");
        if (intent.getAction().equals("android.intent.action.WALLPAPER_CHANGED")) {
            if (LauncherApplication.mAppWallPaper) {
                LauncherApplication.mAppWallPaper = false;
                LauncherApplication.mWallPaperUpdate = true;
                SharedPreferences.Editor editor = Utils.getSp().edit();
                editor.putBoolean("mAppWallPaper", LauncherApplication.mAppWallPaper);
                editor.putBoolean("mWallPaperUpdate", LauncherApplication.mWallPaperUpdate);
                editor.apply();
                return;
            }
            LauncherApplication.mWallPaperUpdate = false;
            SharedPreferences.Editor editor2 = Utils.getSp().edit();
            editor2.putBoolean("mWallPaperUpdate", LauncherApplication.mWallPaperUpdate);
            editor2.commit();
            return;
        }
        this.name = intent.getAction();
        if (intent.getExtras() != null) {
            this.pak = (String) intent.getExtras().get("msg");
        }
        int a = LauncherApplication.sApp.getResources().getInteger(R.integer.apps_launcher_packagename);
        String launcherpackagename = "com.android.launcher" + a;
        if (this.name.equals("android.intent.LAUNCHER.LauncherChoose") && this.pak.equals(launcherpackagename)) {
            LogPreview.show("android.intent.LAUNCHER.LauncherChoose");
            this.handler.postDelayed(this.runnable, 200L);
        }
    }
}
