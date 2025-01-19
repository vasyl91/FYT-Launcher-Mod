package com.syu.util;

import android.os.Handler;
import android.os.Looper;

public class HandlerUI extends Handler {
    private static final HandlerUI INSTANCE = new HandlerUI();

    public static HandlerUI getInstance() {
        return INSTANCE;
    }

    private HandlerUI() {
        super(Looper.getMainLooper());
    }
}
