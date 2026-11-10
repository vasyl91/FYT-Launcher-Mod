package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public class GlobalLock {
    private static final Mutex GLOBAL_MUTEX = new Mutex();

    public static void acquire() throws InterruptedException {
        GLOBAL_MUTEX.acquire();
    }

    public static void tryToAcquire() {
        GLOBAL_MUTEX.tryToAcquire();
    }

    public static void release() {
        GLOBAL_MUTEX.release();
    }
}
