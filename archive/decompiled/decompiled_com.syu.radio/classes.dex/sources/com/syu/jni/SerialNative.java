package com.syu.jni;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SerialNative {
    public static native void native_close(int i);

    public static native int native_open(String str);

    public static native int native_open_mbx();

    public static native byte[] native_read(int i, int i2, int i3);

    public static native int native_setup(int i, int i2, int i3, int i4, int i5);

    public static native void native_write(int i, byte[] bArr, int i2);

    static {
        try {
            System.loadLibrary("sqlserial");
        } catch (Throwable th) {
        }
    }
}
