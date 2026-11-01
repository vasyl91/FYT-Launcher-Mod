package com.syu.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HandlerUI extends Handler {
    private static final HandlerUI INSTANCE = new HandlerUI();

    public static HandlerUI getInstance() {
        return INSTANCE;
    }

    private HandlerUI() {
        super(Looper.getMainLooper());
    }
}
