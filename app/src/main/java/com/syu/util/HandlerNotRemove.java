package com.syu.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

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
