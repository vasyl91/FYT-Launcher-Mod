package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class SimpleBitmapDisplayer implements BitmapDisplayer {
    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public Bitmap display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
        return bitmap;
    }
}
