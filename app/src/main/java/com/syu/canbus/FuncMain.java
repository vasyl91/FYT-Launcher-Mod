package com.syu.canbus;

import android.widget.TextView;
import android.widget.Toast;

import com.android.launcher66.LauncherApplication;
import com.syu.module.main.DataMain;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class FuncMain {
    static Toast toast = null;
    static TextView view = null;

    public static void setChannel(int channel) {
        DataMain.PROXY.cmd(0, channel);
    }

    public static void tips(String str) {
        toast = new Toast(LauncherApplication.getInstance());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        view = new TextView(LauncherApplication.getInstance());
        view.setText(str);
        view.setWidth(400);
        view.setHeight(200);
        view.setGravity(17);
        view.setBackgroundResource(R.drawable.d_popwindow);
        view.setTextSize(24.0f);
        toast.setView(view);
        toast.show();
    }
}