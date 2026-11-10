package com.lsec.core.util.share;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.lsec.core.util.data.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ShareHandler {
    public static final int KEY_EXT_DVR_TYPE = 8;
    public static final int KEY_MODULE_ID_AMP = 5;
    public static final int KEY_MODULE_ID_DVD = 4;
    public static final int KEY_MODULE_ID_OBD = 7;
    public static final int KEY_MODULE_ID_SOUND = 3;
    public static final int KEY_MODULE_ID_TPMS = 6;
    public static final int KEY_TV_TYPE = 0;
    public static final int KEY_USE_AMP_EQ = 2;
    public static final int KEY_USE_CAR_EQ = 1;
    public static final Uri URI = Uri.parse("content://com.syu.ms.provider");

    public static int getInt(ContentResolver resolver, int key, int valueIfNotFound) {
        Cursor cursor;
        int result = valueIfNotFound;
        if (resolver != null && (cursor = resolver.query(URI, null, Integer.toString(key), null, null)) != null) {
            try {
                try {
                    if (cursor.moveToFirst()) {
                        result = cursor.getInt(0);
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
                return result;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return result;
    }

    public static int getCustomerID() {
        return SystemProperties.getInt("ro.build.fytmanufacturer", 2);
    }

    public static boolean isInclude8288A(int idPlatForm) {
        switch (idPlatForm) {
            case 10:
            case 12:
            case 13:
            case 38:
                return true;
            default:
                return false;
        }
    }

    public static boolean is2009(int idPlatForm) {
        return 9 == idPlatForm;
    }

    public static boolean is6322() {
        String plat = SystemProperties.get("sys.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        if (TextUtils.isEmpty(plat)) {
            plat = SystemProperties.get("ro.fyt.platform", FinalChip.BSP_PLATFORM_Null);
        }
        return FinalChip.BSP_PLATFORM_6322.equals(plat);
    }

    public static boolean isMcuReverse() {
        int i = SystemProperties.getInt("sys.fyt.mcu_reverse", 0);
        return 1 == i;
    }

    public static boolean isHiworldObdEnable() {
        return SystemProperties.getBoolean("sys.fyt.hiworld_obd_enable", false);
    }

    public static boolean isTp2825() {
        return SystemProperties.getInt("ro.fyt.m_VideoIC", 0) == 3;
    }

    public static boolean isTp2850() {
        return "TP2850".equals(SystemProperties.get("sys.fyt.video_ic")) || "TP2850".equals(SystemProperties.get("sys.fyt.front_video_ic")) || "TP2850".equals(SystemProperties.get("sys.fyt.back_video_ic"));
    }

    public static boolean isTpPR2000() {
        return SystemProperties.getInt("ro.fyt.m_VideoIC", 0) == 6;
    }

    public static boolean isModifyDefaultLogo() {
        return SystemProperties.getBoolean("sys.fyt.zyc_default_logo_modify", false);
    }

    public static boolean isCanbusT21() {
        return SystemProperties.getInt("ro.fyt.canbus_id", 0) == 61443;
    }

    public static boolean isCanbusM1A() {
        return SystemProperties.getInt("ro.fyt.canbus_id", 0) == 61444;
    }

    public static boolean isCanbusNianXingChe() {
        return SystemProperties.getInt("ro.fyt.canbus_id", 0) == 61445;
    }

    public static boolean isCanbusX5() {
        return SystemProperties.getInt("ro.fyt.canbus_id", 0) == 61446;
    }

    public static boolean isCanbusYunDu() {
        return SystemProperties.getInt("ro.fyt.canbus_id", 0) == 61447;
    }

    public static boolean isThirdVerUI() {
        return SystemProperties.getBoolean("ro.build.fytThirdUI", false);
    }

    public static boolean isShowMark() {
        return SystemProperties.getInt("ro.fyt.showmark", 0) == 1;
    }

    public static boolean isExistInSim() {
        return SystemProperties.getInt("ril.has_sim1", 0) == 1;
    }

    public static boolean isForeginClient() {
        return SystemProperties.getBoolean("ro.client.foreign", false);
    }

    public static boolean isSofiaNeedActive(int idPlatForm, int idCustomer) {
        switch (idPlatForm) {
            case 23:
            case 35:
                switch (idCustomer) {
                    case 62:
                    case 83:
                        return false;
                    default:
                        return true;
                }
            case 28:
            case 29:
            case 36:
            case 37:
                return true;
            default:
                return false;
        }
    }

    public static boolean isCarScreen(int idPlatForm) {
        switch (idPlatForm) {
            case 24:
                return true;
            default:
                return false;
        }
    }

    public static boolean isDebug2825() {
        return SystemProperties.getBoolean("sys.fyt.video.debug", false);
    }

    public static boolean isShowTrackLine() {
        return SystemProperties.getInt("ro.fyt.showtrack", 0) == 1;
    }

    public static boolean is1280Split() {
        return SystemProperties.getInt("ro.fyt.ccbwin", 1) == 0;
    }

    public static boolean isNeedStartFrontView() {
        return SystemProperties.getBoolean("persist.fyt.fy_radartofront", false);
    }

    public static boolean isSerialObdEnable() {
        return SystemProperties.getBoolean("persist.fyt.serial_obd_enable", false);
    }

    public static String getInSimIccid() {
        return SystemProperties.get("ro.sim2.iccid", FinalChip.BSP_PLATFORM_Null);
    }

    public static int getVerAngle() {
        return SystemProperties.getInt("ro.sf.hwrotation", 0);
    }

    public static int getUIID() {
        return SystemProperties.getInt("ro.fyt.uiid", 2);
    }
}
