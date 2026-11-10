package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class L {
    private static volatile boolean DISABLED = false;
    private static final String LOG_FORMAT = "%1$s\n%2$s";

    private L() {
    }

    public static void enableLogging() {
        DISABLED = false;
    }

    public static void disableLogging() {
        DISABLED = true;
    }

    public static void d(String message, Object... args) {
        log(3, null, message, args);
    }

    public static void i(String message, Object... args) {
        log(4, null, message, args);
    }

    public static void w(String message, Object... args) {
        log(5, null, message, args);
    }

    public static void e(Throwable ex) {
        log(6, ex, null, new Object[0]);
    }

    public static void e(String message, Object... args) {
        log(6, null, message, args);
    }

    public static void e(Throwable ex, String message, Object... args) {
        log(6, ex, message, args);
    }

    private static void log(int priority, Throwable ex, String message, Object... args) {
        String log;
        if (!DISABLED) {
            if (args.length > 0) {
                message = String.format(message, args);
            }
            if (ex == null) {
                log = message;
            } else {
                String logMessage = message == null ? ex.getMessage() : message;
                String logBody = Log.getStackTraceString(ex);
                log = String.format(LOG_FORMAT, logMessage, logBody);
            }
            Log.println(priority, ImageLoader.TAG, log);
        }
    }
}
