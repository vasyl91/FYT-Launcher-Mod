package com.syu.util;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.syu.canbus.TheApp;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ToolkitRes {
    public static Drawable loadDrawable(String fileName) {
        try {
            return new BitmapDrawable(BitmapFactory.decodeStream(TheApp.getAssetManager().open(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return new ColorDrawable(0);
        }
    }
}
