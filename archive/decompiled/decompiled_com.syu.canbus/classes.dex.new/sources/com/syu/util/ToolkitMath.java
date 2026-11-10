package com.syu.util;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ToolkitMath {
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        return value > max ? max : value;
    }
}
