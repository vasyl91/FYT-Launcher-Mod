package com.syu.util;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
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
