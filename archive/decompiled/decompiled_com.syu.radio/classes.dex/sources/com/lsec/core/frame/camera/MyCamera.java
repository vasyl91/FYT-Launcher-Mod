package com.lsec.core.frame.camera;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.log.LogUtils;
import com.lsec.core.util.InterfaceCamera;
import com.lsec.core.util.data.FinalChip;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyCamera {
    public static int QUALITY_CVBSN;
    public static int QUALITY_CVBSP;
    public static MyCamera mCameraInst = null;
    public static InterfaceCamera mInterfaceCamera = null;
    public Camera mCamera;
    public Camera.Parameters mParameters;
    private boolean bIsPreview = false;
    public boolean bShutDown = false;
    Runnable_setPreviewSurfHolder runnable_setPreviewSurfHolder = null;
    Runnable_setPreviewSurfTexture runnable_setPreviewSurfTexture = null;

    protected MyCamera() {
    }

    public static synchronized MyCamera getInstance() {
        if (mCameraInst == null) {
            mCameraInst = new MyCamera();
        }
        return mCameraInst;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:14:0x0027
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public android.hardware.Camera open_actual(int r5) {
        /*
            r4 = this;
            int r3 = com.lsec.core.ipc.module.main.Main.mConf_PlatForm     // Catch: java.lang.Exception -> L27
            switch(r3) {
                case 7: goto L13;
                case 8: goto L13;
                default: goto L5;
            }     // Catch: java.lang.Exception -> L27
        L5:
            int r2 = android.hardware.Camera.getNumberOfCameras()     // Catch: java.lang.Exception -> L27
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo     // Catch: java.lang.Exception -> L27
            r0.<init>()     // Catch: java.lang.Exception -> L27
            r1 = 0
        Lf:
            if (r1 < r2) goto L18
        L11:
            r3 = 0
        L12:
            return r3
        L13:
            android.hardware.Camera r3 = android.hardware.Camera.open(r5)     // Catch: java.lang.Exception -> L27
            goto L12
        L18:
            android.hardware.Camera.getCameraInfo(r1, r0)     // Catch: java.lang.Exception -> L27
            int r3 = r0.facing     // Catch: java.lang.Exception -> L27
            if (r3 != r5) goto L24
            android.hardware.Camera r3 = android.hardware.Camera.open(r5)     // Catch: java.lang.Exception -> L27
            goto L12
        L24:
            int r1 = r1 + 1
            goto Lf
        L27:
            r3 = move-exception
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lsec.core.frame.camera.MyCamera.open_actual(int):android.hardware.Camera");
    }

    public void open(int cameraId) {
        if (this.mCamera == null) {
            setSystemProp();
            LogUtils.e("camera", "0000 MyCamera  open(int cameraId)  Camera ID: " + cameraId + "  mCamera: " + this.mCamera);
            this.mCamera = open_actual(cameraId);
            LogUtils.e("camera", "0001 MyCamera  open(int cameraId)  Camera ID: " + cameraId + "  mCamera: " + this.mCamera);
        }
    }

    public boolean isCameraOpen() {
        return this.mCamera != null;
    }

    public boolean isCameraPreview() {
        return this.bIsPreview;
    }

    public void setPreview(SurfaceHolder holder, int idVideo, int iDegree) {
        Log.d("HJT", "setPreview2:" + idVideo);
        MyCameraUtil.idVideo = idVideo;
        MyCameraUtil.iDegree = iDegree;
        this.bShutDown = false;
        try {
            if (this.runnable_setPreviewSurfHolder != null) {
                this.runnable_setPreviewSurfHolder.stopRun();
            }
            LogUtils.e("camera", "MyCamera  startPreView(holder, int idVideo, int iDegree)  " + holder);
            this.runnable_setPreviewSurfHolder = new Runnable_setPreviewSurfHolder(holder);
            this.runnable_setPreviewSurfHolder.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPreview(SurfaceTexture surface, int idVideo, int iDegree) {
        Log.d("HJT", "setPreview1:" + idVideo);
        MyCameraUtil.idVideo = idVideo;
        MyCameraUtil.iDegree = iDegree;
        this.bShutDown = false;
        try {
            if (this.runnable_setPreviewSurfTexture != null) {
                this.runnable_setPreviewSurfTexture.stopRun();
            }
            this.runnable_setPreviewSurfTexture = new Runnable_setPreviewSurfTexture(surface);
            this.runnable_setPreviewSurfTexture.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean startPreView() {
        if (this.mCamera == null || this.bIsPreview) {
            return true;
        }
        try {
            if (mInterfaceCamera != null) {
                mInterfaceCamera.setCameraCallBack();
            }
            this.mCamera.startPreview();
            this.bIsPreview = true;
            LogUtils.e("camera", "MyCamera  startPreView() bIsPreview " + this.bIsPreview + "  mCamera: " + this.mCamera);
            return true;
        } catch (Exception e) {
            LogUtils.e("camera", "MyCamera  startPreView() Exception  bIsPreview " + this.bIsPreview);
            return false;
        }
    }

    public void shutDown() {
        this.bShutDown = true;
        LogUtils.e("camera", "MyCamera  shutDown() ");
        try {
            if (this.mCamera != null) {
                this.mCamera.setPreviewCallback(null);
                if (this.bIsPreview) {
                    this.mCamera.stopPreview();
                    LogUtils.e("camera", " MyCamera  shutDown()  ====== >> mCamera.stopPreview()");
                    this.bIsPreview = false;
                }
                this.mCamera.release();
                this.mCamera = null;
            }
        } catch (Exception e) {
        }
    }

    public static void setSystemProp() {
        switch (Main.mConf_PlatForm) {
            case 6:
            case 8:
                int[] size = MyCameraUtil.getSystemPropSize();
                String width = String.format(Locale.US, "%d", Integer.valueOf(size[0]));
                String height = String.format(Locale.US, "%d", Integer.valueOf(size[1]));
                setSystemProp(width, height, FinalChip.BSP_PLATFORM_Null);
                break;
        }
    }

    public static void setSystemProp2() {
        switch (Main.mConf_PlatForm) {
            case 6:
            case 8:
                int[] size = MyCameraUtil.getSystemPropSize2();
                String width = String.format(Locale.US, "%d", Integer.valueOf(size[0]));
                String height = String.format(Locale.US, "%d", Integer.valueOf(size[1]));
                setSystemProp(width, height, "sys.fyt.cvbs.");
                break;
        }
    }

    public static void setSystemProp(String width, String height, String str_cvbs) {
        String strCvbs = "sys.fyt.cvbs.";
        String plat = SystemProperties.get("sys.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        if (TextUtils.isEmpty(plat)) {
            plat = SystemProperties.get("ro.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        }
        if ("6315".equals(plat) || "6316".equals(plat)) {
            if (MyCameraUtil.idVideo == 9 || MyCameraUtil.idVideo == 16) {
                strCvbs = "sys.fyt.cvbs_2.";
            } else if (MyCameraUtil.idVideo == 15) {
                strCvbs = "sys.fyt.cvbs.";
            }
        }
        if (!TextUtils.isEmpty(MyCameraUtil.strCvbs)) {
            strCvbs = MyCameraUtil.strCvbs;
        }
        if (!TextUtils.isEmpty(str_cvbs)) {
            strCvbs = str_cvbs;
        }
        Log.d("HJT", "strCvbs:" + strCvbs + "-width:" + width + "-height:" + height);
        switch (Main.mConf_PlatForm) {
            case 6:
            case 8:
                SystemProperties.set(String.valueOf(strCvbs) + "width", width);
                SystemProperties.set(String.valueOf(strCvbs) + "height", height);
                SystemProperties.set(String.valueOf(strCvbs) + "trim_width", width);
                SystemProperties.set(String.valueOf(strCvbs) + "trim_height", height);
                SystemProperties.set(String.valueOf(strCvbs) + "scaler_trim.w", width);
                SystemProperties.set(String.valueOf(strCvbs) + "scaler_trim.h", height);
                SystemProperties.set(String.valueOf(strCvbs) + "scaler_trim.x", "0");
                SystemProperties.set(String.valueOf(strCvbs) + "scaler_trim.y", "0");
                break;
        }
    }

    boolean initCamera(int cameraId) {
        int[] sizePreview;
        boolean z = false;
        try {
            if (this.mCamera == null) {
                return false;
            }
            this.mParameters = this.mCamera.getParameters();
            if (this.mParameters == null || (sizePreview = MyCameraUtil.getPreviewSize(cameraId, this.mParameters)) == null) {
                return false;
            }
            this.mParameters.setPreviewFrameRate(20);
            if (Main.mConf_PlatForm == 7 && MyCameraUtil.idVideo == 1) {
                this.mParameters.set("mirror-preview", Main.DATA[24] == 1 ? "true" : "false");
            }
            this.mParameters.setPreviewSize(sizePreview[0], sizePreview[1]);
            if (mInterfaceCamera != null) {
                mInterfaceCamera.setPreviewFormat();
            }
            this.mCamera.setParameters(this.mParameters);
            z = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }
}
