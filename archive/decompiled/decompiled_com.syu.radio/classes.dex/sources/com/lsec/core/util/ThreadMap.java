package com.lsec.core.util;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ThreadMap {
    public static HashMap<String, HandlerThread> mHashMapThread = new HashMap<>();
    public static HashMap<String, Handler> mHashMapHandler = new HashMap<>();

    public static void startThread(String strThread, Runnable runnable, boolean bRemoveOther, int priority) {
        HandlerThread handlerThread;
        if (runnable != null) {
            HandlerThread handlerThread2 = mHashMapThread.get(strThread);
            if (handlerThread2 == null) {
                if (priority < 0) {
                    handlerThread = new HandlerThread(strThread, priority);
                } else {
                    handlerThread = new HandlerThread(strThread);
                }
                handlerThread.start();
                if (priority >= 0) {
                    handlerThread.setPriority(priority);
                }
                mHashMapThread.put(strThread, handlerThread);
                mHashMapHandler.put(strThread, new Handler(handlerThread.getLooper()));
            }
            Handler handler = mHashMapHandler.get(strThread);
            if (handler != null) {
                if (bRemoveOther) {
                    handler.removeCallbacks(runnable);
                }
                handler.post(runnable);
            }
        }
    }

    public static void startThread(String strThread, Runnable runnable, boolean bRemoveOther, int priority, long delayMillis) {
        HandlerThread handlerThread;
        if (runnable != null) {
            HandlerThread handlerThread2 = mHashMapThread.get(strThread);
            if (handlerThread2 == null) {
                if (priority == -20) {
                    handlerThread = new HandlerThread(strThread, priority);
                } else {
                    handlerThread = new HandlerThread(strThread);
                }
                handlerThread.start();
                if (priority != -20) {
                    handlerThread.setPriority(priority);
                }
                mHashMapThread.put(strThread, handlerThread);
                mHashMapHandler.put(strThread, new Handler(handlerThread.getLooper()));
            }
            Handler handler = mHashMapHandler.get(strThread);
            if (handler != null) {
                if (bRemoveOther) {
                    handler.removeCallbacks(runnable);
                }
                handler.postDelayed(runnable, delayMillis);
            }
        }
    }

    public static void removeThreadRunnable(String strThread, Runnable runnable) {
        Handler handler;
        if (runnable != null && (handler = mHashMapHandler.get(strThread)) != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
