package com.syu.util;

import android.content.Context;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ToastInfo {
    public static MyToast toast;

    public static void showToast(Context context, String str) {
        if (toast != null) {
            toast.cancel();
        }
        toast = new MyToast(context, str, 100, -16711936, 25);
        toast.show();
    }
}
