package com.lsec.core.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TickLock {
    private long cur;
    private long last;

    public boolean unlock(int ms) {
        this.cur = SystemClock.uptimeMillis();
        if (this.cur - this.last < ms) {
            return false;
        }
        this.last = this.cur;
        return true;
    }

    public int pass() {
        this.cur = SystemClock.uptimeMillis();
        return (int) (this.cur - this.last);
    }

    public void reset() {
        this.last = SystemClock.uptimeMillis();
    }

    public void resetOffset(long offset) {
        this.last = SystemClock.uptimeMillis() + offset;
    }

    public void resetToZero() {
        this.last = 0L;
    }
}
