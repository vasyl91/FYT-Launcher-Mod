package com.syu.util;

import android.content.Context;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
