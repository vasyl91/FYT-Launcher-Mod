package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class Mutex {
    private Thread owner = null;
    private int lock_count = 0;

    public synchronized void acquire() throws InterruptedException {
        while (!tryToAcquire()) {
            wait();
        }
    }

    public synchronized boolean tryToAcquire() {
        Thread thread = this.owner;
        if (thread == null) {
            this.owner = Thread.currentThread();
            this.lock_count = 1;
            return true;
        }
        if (thread != Thread.currentThread()) {
            return false;
        }
        this.lock_count++;
        return true;
    }

    public synchronized void release() {
        if (this.owner != Thread.currentThread()) {
            throw new IllegalStateException("Thread calling release() doesn't own mutex");
        }
        int i = this.lock_count - 1;
        this.lock_count = i;
        if (i <= 0) {
            this.owner = null;
            notify();
        }
    }
}
