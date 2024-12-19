package com.syu.util;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public final class TimeLocker implements Runnable {
    public static final Handler HANDLER;
    private boolean mLock;

    static {
        HandlerThread thread = new HandlerThread("TimerLockerThread");
        thread.start();
        HANDLER = new Handler(thread.getLooper());
    }

    public void setLocked(boolean lock) {
        this.mLock = lock;
    }

    public boolean isLocked() {
        return this.mLock;
    }

    public synchronized void lock(int ms) {
        HANDLER.removeCallbacks(this);
        this.mLock = true;
        HANDLER.postDelayed(this, ms);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        this.mLock = false;
    }
}
