package com.lsec.core.frame.camera3;

import android.media.ImageReader;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface MyCamera3Interface {
    void onImageDoubleCameraAvailable(ImageReader imageReader);

    void onImageDoubleCameraAvailableExtra(ImageReader imageReader);

    void onOpenedDoubleCamera();
}
