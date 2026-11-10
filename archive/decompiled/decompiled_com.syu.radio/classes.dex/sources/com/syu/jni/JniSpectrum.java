package com.syu.jni;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JniSpectrum {
    public static native int open(String str);

    public static native int read(int i);

    static {
        try {
            System.loadLibrary("jni_spectrum");
        } catch (Throwable th) {
        }
    }
}
