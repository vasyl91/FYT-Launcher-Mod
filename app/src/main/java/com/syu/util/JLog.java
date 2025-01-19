package com.syu.util;

import android.os.SystemClock;
import android.util.Log;

public class JLog {
    static JLog instance;
    static long startime;
    static String Tag = "JLog";
    static boolean Debug = true;

    public static JLog getInstance() {
        if (instance == null) {
            instance = new JLog();
        }
        return instance;
    }

    public JLog() {
        startime = SystemClock.uptimeMillis();
    }

    public void e(String msg) {
        if (Debug) {
            Log.e(Tag, "=====> " + msg);
        }
    }

    public void w(String msg) {
        if (Debug) {
            Log.w(Tag, "=====> " + msg);
        }
    }

    public void d(String msg) {
        if (Debug) {
            Log.d(Tag, "=====> " + msg);
        }
    }

    public void i(String msg) {
        if (Debug) {
            Log.i(Tag, "=====> " + msg);
        }
    }

    public void e(String msg, Throwable tr) {
        if (Debug) {
            Log.e(Tag, "=====> " + msg, tr);
        }
    }

    public static void setTag(String tag) {
        Tag = tag;
    }

    public static void setDebug(boolean debug) {
        Debug = debug;
    }
}
