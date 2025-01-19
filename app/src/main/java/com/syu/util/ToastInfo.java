package com.syu.util;

import android.content.Context;

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
