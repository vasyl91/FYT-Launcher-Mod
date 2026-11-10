package com.syu.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class HandlerUI extends Handler {
    private static final HandlerUI INSTANCE = new HandlerUI();

    public static HandlerUI getInstance() {
        return INSTANCE;
    }

    private HandlerUI() {
        super(Looper.getMainLooper());
    }
}
