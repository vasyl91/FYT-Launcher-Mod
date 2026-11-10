package com.syu.utils;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class LogUtils {
    public static final HashMap a = new HashMap();
    public static boolean b = false;
    public static int c = 2;

    public static Boolean a(int i, String str) {
        if (!b || c > i) {
            return Boolean.FALSE;
        }
        Boolean bool = (Boolean) a.get(str);
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public static void d(String str, String str2) {
        if (a(3, str).booleanValue()) {
            e("Usb", str2);
            LogPreview.show(str2);
        }
    }

    public static void disEnableTag(String... strArr) {
        for (String str : strArr) {
            HashMap map = a;
            if (map.containsKey(str)) {
                map.remove(str);
            }
        }
    }

    public static void e(String str, String str2) {
        if (a(6, str).booleanValue()) {
            Log.e(str, str2);
            LogPreview.show(str2);
        }
    }

    public static void enableAll(boolean z) {
    }

    public static void enableTag(String... strArr) {
        for (String str : strArr) {
            HashMap map = a;
            Boolean bool = (Boolean) map.get(str);
            if (bool == null || !bool.booleanValue()) {
                map.put(str, Boolean.TRUE);
            }
        }
    }

    public static void i(String str, String str2) {
        if (a(4, str).booleanValue()) {
            Log.i(str, str2);
            LogPreview.show(str2);
        }
    }

    public static void setEnable(boolean z) {
        b = z;
    }

    public static void setLogLevel(int i) {
        c = i;
    }

    public static void setLogRecordSwitch(Context context, String str) {
        if (new File(str).exists()) {
            LogRecorder.getInstance(context).start();
        }
    }

    public static void setShowSwitch(Context context, String str) {
        LogPreview.getInstance(context, str);
    }

    public static void v(String str, String str2) {
        if (a(2, str).booleanValue()) {
            Log.v(str, str2);
            LogPreview.show(str2);
        }
    }
}
