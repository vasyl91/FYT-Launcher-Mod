package com.lsec.core.frame.camera2;

import android.media.ImageReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface MyCamera2Interface {
    void onImageAvailable(ImageReader imageReader);

    void onImageAvailableExtra(ImageReader imageReader);

    void onOpened();
}
