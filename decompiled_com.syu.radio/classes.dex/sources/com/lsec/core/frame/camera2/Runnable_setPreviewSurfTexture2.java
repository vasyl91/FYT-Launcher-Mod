package com.lsec.core.frame.camera2;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.lsec.core.frame.camera.MyCameraUtil;
import com.lsec.core.log.LogUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Runnable_setPreviewSurfTexture2 implements Runnable {
    public boolean bRunning = true;
    SurfaceTexture surface;
    TextureView texture;

    Runnable_setPreviewSurfTexture2(SurfaceTexture surface) {
        this.surface = surface;
    }

    Runnable_setPreviewSurfTexture2(TextureView texture) {
        this.texture = texture;
    }

    public void stopRun() {
        this.bRunning = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogUtils.e("camera2", "Runnable_setPreviewSurfTexture2  Camera ID: " + MyCameraUtil.getCameraId());
        if (!MyCamera2.getInstance().bShutDown) {
            if (this.texture != null) {
                MyCamera2.getInstance().start(new StringBuilder().append(MyCameraUtil.getCameraId()).toString(), this.texture);
            } else {
                MyCamera2.getInstance().start(new StringBuilder().append(MyCameraUtil.getCameraId()).toString(), this.surface);
            }
        }
    }
}
