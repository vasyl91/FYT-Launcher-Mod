package com.lsec.core.frame.camera;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.data.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Runnable_setPreviewSurfHolder implements Runnable {
    public boolean bRunning = true;
    SurfaceHolder holder;

    Runnable_setPreviewSurfHolder(SurfaceHolder holder) {
        this.holder = holder;
    }

    public void stopRun() {
        this.bRunning = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!MyCamera.getInstance().bShutDown) {
            MyCamera.getInstance().open(MyCameraUtil.getCameraId());
            if (MyCamera.getInstance().mCamera == null) {
                if (this.bRunning) {
                    Main.postRunnable_Ui(true, this, 1000L);
                    return;
                }
                return;
            }
            boolean bNeedSetDisplayOrientation = MyCameraUtil.iDegree != 0;
            if (!bNeedSetDisplayOrientation) {
                String plat = SystemProperties.get("sys.fyt.platform", FinalChip.BSP_PLATFORM_Null);
                if (TextUtils.isEmpty(plat)) {
                    plat = SystemProperties.get("ro.fyt.platform", FinalChip.BSP_PLATFORM_Null);
                }
                if ("6315".equals(plat) || "6316".equals(plat)) {
                    bNeedSetDisplayOrientation = true;
                }
            }
            if (bNeedSetDisplayOrientation) {
                MyCamera.getInstance().mCamera.setDisplayOrientation(MyCameraUtil.iDegree);
            }
            try {
                MyCamera.getInstance().mCamera.setPreviewDisplay(this.holder);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean bStartPreview = false;
            boolean bInitCamera = MyCamera.getInstance().initCamera(MyCameraUtil.getCameraId());
            if (bInitCamera) {
                bStartPreview = MyCamera.getInstance().startPreView();
            }
            if (!bInitCamera || !bStartPreview) {
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.lsec.core.frame.camera.Runnable_setPreviewSurfHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!MyCamera.getInstance().bShutDown) {
                            MyCamera.getInstance().setPreview(Runnable_setPreviewSurfHolder.this.holder, MyCameraUtil.idVideo, MyCameraUtil.iDegree);
                        }
                    }
                }, 1000L);
            }
        }
    }
}
