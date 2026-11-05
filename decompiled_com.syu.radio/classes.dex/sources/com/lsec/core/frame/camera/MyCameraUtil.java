package com.lsec.core.frame.camera;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.InterfaceGetCameraId;
import com.lsec.core.util.data.AutoKeyEvent;
import com.lsec.core.util.data.FinalChip;
import com.lsec.core.util.share.ShareHandler;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyCameraUtil {
    public static int idVideo;
    public static int idVideo2;
    public static String strCvbs = FinalChip.BSP_PLATFORM_Null;
    public static boolean bAddImageReader = true;
    public static int iDegree = 0;
    public static int[] mSizeDiy_Preview = null;
    public static int[] mSizeDiy = null;
    public static int[] mSizeDiy2 = null;
    public static int mWidth_FourCamera360 = 1280;
    public static int mHeight_FourCamera360 = 2880;
    public static InterfaceGetCameraId mInterfaceGetCameraId = null;
    public static InterfaceGetCameraId mInterfaceGetDoubleCameraId = null;

    public static int getCameraId() {
        return mInterfaceGetCameraId != null ? mInterfaceGetCameraId.getCameraId() : getCameraId_Default();
    }

    public static int getDoubleCameraId() {
        return mInterfaceGetDoubleCameraId != null ? mInterfaceGetDoubleCameraId.getCameraId() : getCameraId_Default();
    }

    public static int getCameraId_Default() {
        int iRealPlatForm = SystemProperties.getInt("ro.fyt.realplatform", 0);
        switch (iRealPlatForm) {
            case 816:
            case 818:
            case 3003:
                return 1;
            default:
                if (MyApplication.mIdChip == 8) {
                    return 0;
                }
                if (idVideo == 9 || idVideo == 1) {
                    return 2;
                }
                if (Main.mConf_PlatForm == 8) {
                    return 1;
                }
                if (idVideo == 1) {
                    return Main.getBackCameraId(MyApplication.mIdPlatForm);
                }
                return 0;
        }
    }

    public static boolean isVideoQualityExists(int cameraId, int quality, List<Camera.Size> supported) {
        if (supported != null && CamcorderProfile.hasProfile(cameraId, quality)) {
            CamcorderProfile camcorderProfile = CamcorderProfile.get(cameraId, quality);
            for (int i = 0; i < supported.size(); i++) {
                if (camcorderProfile.videoFrameWidth == supported.get(i).width && camcorderProfile.videoFrameHeight == supported.get(i).height) {
                    return true;
                }
            }
        }
        return false;
    }

    public static CamcorderProfile getCamcorderProfileByQuality(int cameraId, int quality, Camera.Parameters parameters, List<Camera.Size> supportedPreviewSizes) {
        CamcorderProfile camcorderProfile = null;
        if (quality >= 1080 && isVideoQualityExists(cameraId, 6, supportedPreviewSizes)) {
            camcorderProfile = CamcorderProfile.get(cameraId, 6);
        }
        if (camcorderProfile == null && quality >= 720 && isVideoQualityExists(cameraId, 5, supportedPreviewSizes)) {
            camcorderProfile = CamcorderProfile.get(cameraId, 5);
        }
        if (camcorderProfile == null && isVideoQualityExists(cameraId, 4, supportedPreviewSizes)) {
            return CamcorderProfile.get(cameraId, 4);
        }
        return camcorderProfile;
    }

    public static boolean isDvd9853() {
        if (idVideo != 3) {
            return false;
        }
        switch (Main.mConf_PlatForm) {
            case 8:
                int external = SystemProperties.getInt("sys.syu.dvd_external", 0);
                return external != 1;
            default:
                return false;
        }
    }

    public static int getFixWidth() {
        switch (Main.mConf_PlatForm) {
            case 8:
                String plat = SystemProperties.get("sys.fyt.platform", FinalChip.BSP_PLATFORM_Null);
                if (TextUtils.isEmpty(plat)) {
                    plat = SystemProperties.get("ro.fyt.platform", FinalChip.BSP_PLATFORM_Null);
                }
                if (FinalChip.BSP_PLATFORM_6025.equals(plat) || "6315".equals(plat) || "6316".equals(plat)) {
                    return 960;
                }
                return 990;
            default:
                return 960;
        }
    }

    public static int[] getSystemPropSize() {
        if (mSizeDiy != null && mSizeDiy.length == 2) {
            return mSizeDiy;
        }
        int[] size = {720, 480};
        if (idVideo == 9 || idVideo == 16 || idVideo == 15) {
            size[0] = mWidth_FourCamera360;
            size[1] = mHeight_FourCamera360;
            return size;
        }
        if (isDvd9853()) {
            size[0] = 720;
            size[1] = 480;
            return size;
        }
        if (Main.getBackCameraType() == 1) {
            boolean isTP2825 = ShareHandler.isTp2825();
            boolean isTp2850 = ShareHandler.isTp2850();
            if (isTP2825 || isTp2850) {
                switch (Main.DATA[70]) {
                    case 0:
                        size[0] = getFixWidth();
                        size[1] = 480;
                        return size;
                    case 1:
                        size[0] = getFixWidth();
                        size[1] = 576;
                        return size;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        size[0] = 1280;
                        size[1] = 720;
                        return size;
                    case 6:
                    case 7:
                        size[0] = 1920;
                        size[1] = 1080;
                        return size;
                    case 8:
                    case 9:
                        size[0] = 1280;
                        size[1] = 720;
                        return size;
                    case 10:
                        size[0] = 720;
                        size[1] = 240;
                        return size;
                    case 11:
                        size[0] = 720;
                        size[1] = 288;
                        return size;
                    default:
                        return size;
                }
            }
            switch (Main.DATA[70]) {
                case 0:
                    size[0] = 720;
                    if (ShareHandler.is6322()) {
                        size[1] = 240;
                        return size;
                    }
                    size[1] = 480;
                    return size;
                case 1:
                    size[0] = 720;
                    if (ShareHandler.is6322()) {
                        size[1] = 288;
                        return size;
                    }
                    size[1] = 576;
                    return size;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    return size;
                case 8:
                case 9:
                    size[0] = 1280;
                    size[1] = 720;
                    return size;
                case 10:
                    size[0] = 720;
                    size[1] = 240;
                    return size;
                case 11:
                    size[0] = 720;
                    size[1] = 288;
                    return size;
            }
        }
        return size;
    }

    public static int[] getSystemPropSize2() {
        if (mSizeDiy2 != null && mSizeDiy2.length == 2) {
            return mSizeDiy2;
        }
        int[] size = {720, 480};
        if (idVideo == 9 || idVideo == 16 || idVideo == 15) {
            size[0] = mWidth_FourCamera360;
            size[1] = mHeight_FourCamera360;
            return size;
        }
        return size;
    }

    public static int[] getPreviewSize(int cameraId, Camera.Parameters parameters) {
        CamcorderProfile camcorderProfileTmp;
        CamcorderProfile camcorderProfileTmp2;
        if (mSizeDiy_Preview != null && mSizeDiy_Preview.length == 2) {
            return mSizeDiy_Preview;
        }
        if (mSizeDiy != null && mSizeDiy.length == 2) {
            return mSizeDiy;
        }
        int[] size = new int[2];
        if (idVideo == 9) {
            size[0] = mWidth_FourCamera360;
            size[1] = mHeight_FourCamera360;
            return size;
        }
        if (isDvd9853()) {
            size[0] = 720;
            size[1] = 480;
            return size;
        }
        if (parameters == null) {
            return size;
        }
        CamcorderProfile profile = CamcorderProfile.get(1);
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        boolean bProfileOk = false;
        if (Main.mConf_PlatForm == 5 && (Main.DATA[12] != 1 || Main.getBackCameraType() == 1)) {
            try {
                if (Main.DATA[70] == 0) {
                    camcorderProfileTmp2 = CamcorderProfile.get(cameraId, MyCamera.QUALITY_CVBSN);
                } else if (Main.DATA[70] == 1) {
                    camcorderProfileTmp2 = CamcorderProfile.get(cameraId, MyCamera.QUALITY_CVBSP);
                } else {
                    camcorderProfileTmp2 = getCamcorderProfileByQuality(cameraId, 1080, parameters, supportedPreviewSizes);
                }
            } catch (Exception e) {
                camcorderProfileTmp2 = CamcorderProfile.get(cameraId, 4);
            }
            if (camcorderProfileTmp2 != null) {
                bProfileOk = true;
                profile = camcorderProfileTmp2;
            }
        }
        if (!bProfileOk && (camcorderProfileTmp = getCamcorderProfileByQuality(cameraId, 1080, parameters, supportedPreviewSizes)) != null) {
            profile = camcorderProfileTmp;
        }
        if (profile != null) {
            size[0] = profile.videoFrameWidth;
            size[1] = profile.videoFrameHeight;
        }
        int wNTSC = 704;
        int hNTSC = 468;
        int wPAL = 704;
        int hPAL = AutoKeyEvent.KEYCODE_SEEKUP;
        int wPreviewMax = 0;
        int hPreviewMax = 0;
        for (Camera.Size s : supportedPreviewSizes) {
            if (s.height > hPreviewMax) {
                wPreviewMax = s.width;
                hPreviewMax = s.height;
            } else if (s.height == hPreviewMax && s.width > wPreviewMax) {
                wPreviewMax = s.width;
                hPreviewMax = s.height;
            }
            if (s.width < 740 && s.width > 700) {
                if (s.height < 500 && s.height > 460) {
                    wNTSC = s.width;
                    hNTSC = s.height;
                } else if (s.height < 600 && s.height > 560) {
                    wPAL = s.width;
                    hPAL = s.height;
                }
            }
        }
        boolean bMatchWH = false;
        Camera.Size preferSize = parameters.getPreferredPreviewSizeForVideo();
        if (preferSize != null && preferSize.width > 0 && preferSize.height > 0) {
            for (Camera.Size s2 : supportedPreviewSizes) {
                if (preferSize.height == s2.height) {
                    bMatchWH = true;
                    size[0] = s2.width;
                    size[1] = s2.height;
                    break;
                }
            }
        }
        if (!bMatchWH) {
            size[0] = wPreviewMax;
            size[1] = hPreviewMax;
        }
        boolean isTP2825 = ShareHandler.isTp2825();
        boolean isTp2850 = ShareHandler.isTp2850();
        if (Main.getBackCameraType() == 1) {
            if (isTP2825 || isTp2850) {
                switch (Main.DATA[70]) {
                    case 0:
                        size[0] = 960;
                        size[1] = 480;
                        break;
                    case 1:
                        size[0] = 960;
                        size[1] = 576;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        size[0] = 1280;
                        size[1] = 720;
                        switch (Main.mConf_PlatForm) {
                            case 6:
                            case 7:
                            case 8:
                                break;
                            default:
                                size[0] = size[0] - 16;
                                break;
                        }
                        break;
                    case 6:
                    case 7:
                        size[0] = 1920;
                        size[1] = 1080;
                        break;
                    case 8:
                    case 9:
                        size[0] = 1280;
                        size[1] = 720;
                        break;
                    case 10:
                        size[0] = 720;
                        size[1] = 240;
                        break;
                    case 11:
                        size[0] = 720;
                        size[1] = 288;
                        break;
                }
            } else {
                switch (Main.mConf_PlatForm) {
                    case 6:
                    case 8:
                        switch (Main.DATA[70]) {
                            case 0:
                                if (ShareHandler.is6322()) {
                                    size[0] = 720;
                                    size[1] = 240;
                                } else {
                                    size[0] = 720;
                                    size[1] = 480;
                                }
                                break;
                            case 1:
                                if (ShareHandler.is6322()) {
                                    size[0] = 720;
                                    size[1] = 288;
                                } else {
                                    size[0] = 720;
                                    size[1] = 576;
                                }
                                break;
                            case 8:
                            case 9:
                                size[0] = 1280;
                                size[1] = 720;
                                break;
                            case 10:
                                size[0] = 720;
                                size[1] = 240;
                                break;
                            case 11:
                                size[0] = 720;
                                size[1] = 288;
                                break;
                        }
                        break;
                    case 7:
                    default:
                        if (Main.DATA[70] == 0) {
                            size[0] = wNTSC;
                            size[1] = hNTSC;
                        } else {
                            size[0] = wPAL;
                            size[1] = hPAL;
                        }
                        break;
                }
            }
        }
        if (size[0] <= wPreviewMax && size[1] <= hPreviewMax) {
            return size;
        }
        size[0] = wPreviewMax;
        size[1] = hPreviewMax;
        return size;
    }
}
