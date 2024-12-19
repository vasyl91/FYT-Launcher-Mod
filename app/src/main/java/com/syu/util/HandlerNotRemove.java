package com.syu.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HandlerNotRemove extends Handler {
    private static final HandlerNotRemove INSTANCE;

    static {
        HandlerThread thread = new HandlerThread("HandlerNotRemove");
        thread.start();
        INSTANCE = new HandlerNotRemove(thread.getLooper());
    }

    public static HandlerNotRemove getInstance() {
        return INSTANCE;
    }

    private HandlerNotRemove(Looper looper) {
        super(looper);
    }
}
