package com.syu.jni;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TouchNative {
    public static TouchNative INSTANCE = null;
    public static final int STATUS_CALIBRATED = 1;
    public static final int STATUS_KEY_STUDYED = 2;
    public static final int STATUS_UNKNOW = 0;
    public static final int TOCH_STUDY_MODE = 194;
    public static final int TOUCH_CAL_MODE = 193;

    public native int native_calibrate_touch(int[] iArr, int[] iArr2);

    public native int native_get_control(int i);

    public native int native_get_coordinate(int[] iArr, int[] iArr2);

    public native int native_get_key(int i, int i2, int[] iArr);

    public native int native_get_points(int[] iArr, int[] iArr2);

    public native int native_get_resolutions(int[] iArr, int[] iArr2);

    public native int native_get_tconfig(int[] iArr);

    public native int native_save_config();

    public native int native_set_control(int i, int i2);

    public native int native_set_key(int i, int i2, int[] iArr);

    public native int native_set_tconfig(int[] iArr);

    public native void native_touch_close(int i);

    public native int native_touch_open();

    private TouchNative() {
        System.loadLibrary("sqltouch");
    }

    public static TouchNative getInstance() {
        try {
            if (INSTANCE == null) {
                INSTANCE = new TouchNative();
            }
        } catch (Throwable th) {
            INSTANCE = null;
        }
        return INSTANCE;
    }
}
