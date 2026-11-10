package com.lsec.core.util;

import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class IpcUtil {
    public static boolean intsOk(int[] ints, int min) {
        return ints != null && ints.length >= min;
    }

    public static boolean strsOk(Object[] strs, int min) {
        return strs != null && strs.length >= min;
    }

    public static boolean fltsOk(float[] flts, int min) {
        return flts != null && flts.length >= min;
    }

    public static int freqStr2Int(String str) {
        return (int) (Float.valueOf(str).floatValue() * 100.0f);
    }

    public static String int2freqStr(int freq) {
        return freq < 20000 ? String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100)) : String.format(Locale.US, "%d", Integer.valueOf(freq / 100));
    }
}
