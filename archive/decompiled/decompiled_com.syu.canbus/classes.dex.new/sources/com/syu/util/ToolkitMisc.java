package com.syu.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ToolkitMisc {
    public static boolean strEqual(String a, String b) {
        if (a == null) {
            if (b != null) {
                return false;
            }
        } else if (!a.equals(b)) {
            return false;
        }
        return true;
    }

    public static boolean strsOk(String[] strs, int min) {
        return strs != null && strs.length >= min;
    }
}
