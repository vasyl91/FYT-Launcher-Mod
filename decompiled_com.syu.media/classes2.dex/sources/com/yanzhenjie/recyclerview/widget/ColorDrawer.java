package com.yanzhenjie.recyclerview.widget;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
class ColorDrawer extends Drawer {
    public ColorDrawer(int i, int i2, int i3) {
        super(new ColorDrawable(opaqueColor(i)), i2, i3);
    }

    public static int opaqueColor(int i) {
        return Color.alpha(i) == 0 ? i : Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
    }
}
