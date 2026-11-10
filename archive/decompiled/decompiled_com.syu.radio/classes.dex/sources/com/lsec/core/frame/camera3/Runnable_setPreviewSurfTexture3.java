package com.lsec.core.frame.camera3;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.lsec.core.frame.camera.MyCameraUtil;
import com.lsec.core.log.LogUtils;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Runnable_setPreviewSurfTexture3 implements Runnable {
    public boolean bRunning = true;
    SurfaceTexture surface;
    TextureView texture;

    Runnable_setPreviewSurfTexture3(SurfaceTexture surface) {
        this.surface = surface;
    }

    Runnable_setPreviewSurfTexture3(TextureView texture) {
        this.texture = texture;
    }

    public void stopRun() {
        this.bRunning = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        LogUtils.e("camera2", "Runnable_setPreviewSurfTexture3  Camera ID: " + MyCameraUtil.getDoubleCameraId());
        if (!MyCamera3.getInstance().bShutDown) {
            if (this.texture != null) {
                MyCamera3.getInstance().start(new StringBuilder().append(MyCameraUtil.getDoubleCameraId()).toString(), this.texture);
            } else {
                MyCamera3.getInstance().start(new StringBuilder().append(MyCameraUtil.getDoubleCameraId()).toString(), this.surface);
            }
        }
    }
}
