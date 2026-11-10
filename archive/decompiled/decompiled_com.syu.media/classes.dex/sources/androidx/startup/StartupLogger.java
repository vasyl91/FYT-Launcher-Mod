package androidx.startup;

import android.util.Log;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void i(String str) {
        Log.i(TAG, str);
    }

    public static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
