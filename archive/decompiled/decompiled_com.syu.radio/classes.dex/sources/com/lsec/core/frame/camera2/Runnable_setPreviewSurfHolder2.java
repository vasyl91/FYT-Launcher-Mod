package com.lsec.core.frame.camera2;

import android.view.SurfaceHolder;
import com.lsec.core.frame.camera.MyCameraUtil;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Runnable_setPreviewSurfHolder2 implements Runnable {
    public boolean bRunning = true;
    SurfaceHolder holder;

    Runnable_setPreviewSurfHolder2(SurfaceHolder holder) {
        this.holder = holder;
    }

    public void stopRun() {
        this.bRunning = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!MyCamera2.getInstance().bShutDown) {
            MyCamera2.getInstance().start(new StringBuilder().append(MyCameraUtil.getCameraId()).toString(), this.holder);
        }
    }
}
