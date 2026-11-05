package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class SyncImageLoadingListener extends SimpleImageLoadingListener {
    private Bitmap loadedImage;

    @Override // com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.assist.ImageLoadingListener
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        this.loadedImage = loadedImage;
    }

    public Bitmap getLoadedBitmap() {
        return this.loadedImage;
    }
}
