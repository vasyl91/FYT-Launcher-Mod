package com.syu.jni;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JniToolkit {
    public static native int openQst();

    public static native int setBrightness(int i);

    static {
        try {
            System.loadLibrary("jni_toolkit");
        } catch (Throwable th) {
        }
    }
}
