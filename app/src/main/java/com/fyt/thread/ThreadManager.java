package com.fyt.thread;

public class ThreadManager {
    private static ThreadPoolProxy mDownloadPool;
    private static ThreadPoolProxy mLongPool;
    private static Object mLongLock = new Object();
    private static Object mDownloadLock = new Object();

    public static ThreadPoolProxy getLongPool() {
        if (mLongPool == null) {
            synchronized (mLongLock) {
                if (mLongPool == null) {
                    mLongPool = new ThreadPoolProxy(5, 5, 0L);
                }
            }
        }
        return mLongPool;
    }

    public static ThreadPoolProxy getDownloadPool() {
        if (mDownloadPool == null) {
            synchronized (mDownloadLock) {
                if (mDownloadPool == null) {
                    mDownloadPool = new ThreadPoolProxy(3, 3, 0L);
                }
            }
        }
        return mDownloadPool;
    }
}
