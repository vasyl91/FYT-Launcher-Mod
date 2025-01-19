package com.syu.util;

import android.os.SystemClock;

public class TimeLock {
    private long cur;
    private long last;

    public boolean unlock(int ms) {
        this.cur = SystemClock.uptimeMillis();
        return this.cur - this.last >= ((long) ms);
    }

    public void reset() {
        this.last = SystemClock.uptimeMillis();
    }

    public void zero() {
        this.last = 0L;
    }
}
