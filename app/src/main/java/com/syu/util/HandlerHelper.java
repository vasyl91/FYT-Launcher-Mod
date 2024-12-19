package com.syu.util;

import android.os.Handler;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public final class HandlerHelper implements Runnable {
    private static final int MAX_POOL_SIZE = 50;
    private static HandlerHelper sPool;
    private Runnable callback;
    private long delayMillis;
    private HandlerHelper next;
    private Handler target;
    private static final Object sPoolSync = new Object();
    private static int sPoolSize = 0;

    public static void removeCallbacks(Handler target, Runnable callback) {
        if (target != null) {
            HandlerHelper helper = obtain();
            helper.target = target;
            helper.callback = callback;
            helper.delayMillis = -1L;
            target.post(helper);
        }
    }

    public static void postDelayed(Handler target, Runnable callback, long delayMillis) {
        if (target != null) {
            HandlerHelper helper = obtain();
            helper.target = target;
            helper.callback = callback;
            if (delayMillis < 0) {
                delayMillis = 0;
            }
            helper.delayMillis = delayMillis;
            target.post(helper);
        }
    }

    private static HandlerHelper obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                HandlerHelper helper = sPool;
                sPool = helper.next;
                helper.next = null;
                sPoolSize--;
                return helper;
            }
            return new HandlerHelper();
        }
    }

    private void recycle() {
        this.target = null;
        this.callback = null;
        synchronized (sPoolSync) {
            if (sPoolSize < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }

    private HandlerHelper() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.delayMillis < 0) {
            this.target.removeCallbacks(this.callback);
        } else {
            this.target.postDelayed(this.callback, this.delayMillis);
        }
        recycle();
    }
}
