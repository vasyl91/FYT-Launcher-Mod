package com.syu.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
