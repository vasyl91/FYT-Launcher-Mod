package com.syu.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class HandlerRemove extends Handler {
    private static final HandlerRemove INSTANCE;

    static {
        HandlerThread thread = new HandlerThread("HandlerRemove");
        thread.start();
        INSTANCE = new HandlerRemove(thread.getLooper());
    }

    public static HandlerRemove getInstance() {
        return INSTANCE;
    }

    private HandlerRemove(Looper looper) {
        super(looper);
    }
}
