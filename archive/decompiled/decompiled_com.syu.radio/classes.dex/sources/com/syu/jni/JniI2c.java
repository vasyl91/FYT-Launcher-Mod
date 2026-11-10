package com.syu.jni;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JniI2c {
    public static native int open(String str);

    public static native int readRk(int i, int i2, int i3);

    public static native int write(int i, int i2, int i3, int i4);

    public static native int writeRk(int i, int i2, int i3, int i4);

    static {
        try {
            System.loadLibrary("jni_i2c");
        } catch (Throwable th) {
        }
    }
}
