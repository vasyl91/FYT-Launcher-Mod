package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0385_HC_Accord8;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0385_HC_XP1_PartComHonda extends CallbackCanbusBase {
    public static String CdTextInfo = null;
    public static int CdTextType = 0;
    public static String CdUsbList = null;
    public static int CdUsbListType = 0;
    public static String MenuList = null;
    public static int MenuListType = 0;
    public static String TelTextInfo = null;
    public static int TelTextType = 0;
    public static final int U_AIR_AC = 1;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 7;
    public static final int U_AIR_BLOW_FOOT = 8;
    public static final int U_AIR_BLOW_WIN = 6;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 4;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 5;
    public static final int U_AIR_SHOW = 14;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_TEMP_UNIT = 13;
    public static final int U_AIR_WIND_LEFT = 9;
    public static final int U_CARCD_BEGIN = 20;
    public static final int U_CARCD_CDDISPLAY_STATE = 26;
    public static final int U_CARCD_CDTEXT_INFO = 29;
    public static final int U_CARCD_CDTEXT_TYPE = 28;
    public static final int U_CARCD_CDUSB_LIST1 = 31;
    public static final int U_CARCD_CDUSB_LIST2 = 32;
    public static final int U_CARCD_CDUSB_LIST3 = 33;
    public static final int U_CARCD_CDUSB_LIST_TYPE = 30;
    public static final int U_CARCD_DISC_INFO = 21;
    public static final int U_CARCD_END = 54;
    public static final int U_CARCD_FOLD_INFO = 27;
    public static final int U_CARCD_PLAY_MINUTE = 52;
    public static final int U_CARCD_PLAY_MODE = 24;
    public static final int U_CARCD_PLAY_SECOND = 53;
    public static final int U_CARCD_PLAY_TIME = 23;
    public static final int U_CARCD_TRACK_INFO = 22;
    public static final int U_CARCD_WORK_STATE = 25;
    public static final int U_CARRADIO_BEGIN = 60;
    public static final int U_CARRADIO_END = 73;
    public static final int U_CAR_DISC1_INFO = 34;
    public static final int U_CAR_DISC2_INFO = 35;
    public static final int U_CAR_DISC3_INFO = 36;
    public static final int U_CAR_DISC4_INFO = 37;
    public static final int U_CAR_DISC5_INFO = 38;
    public static final int U_CAR_DISC6_INFO = 39;
    public static final int U_CAR_MENULIST1_INFO = 41;
    public static final int U_CAR_MENULIST2_INFO = 42;
    public static final int U_CAR_MENULIST3_INFO = 43;
    public static final int U_CAR_MENULIST_TYPE = 40;
    public static final int U_CAR_TIME_FUNC = 44;
    public static final int U_CAR_TIME_HOUR = 45;
    public static final int U_CAR_TIME_MINUTE = 46;
    public static final int U_CHANNEL_CNT = 65;
    public static final int U_CHANNEL_FREQ = 63;
    public static final int U_CNT_MAX = 73;
    public static final int U_CUR_BAND = 61;
    public static final int U_CUR_CHANNEL = 62;
    public static final int U_CUR_FREQ = 60;
    public static final int U_ICON_DISPLAY = 51;
    public static final int U_LIST_CNT = 67;
    public static final int U_LIST_FREQ = 66;
    public static final int U_PRESET_CHANNEL = 71;
    public static final int U_RECEIVE_STATE = 72;
    public static final int U_SOURCE_STATE = 47;
    public static final int U_STATE_REFRESH = 69;
    public static final int U_STATE_SCAN = 68;
    public static final int U_STATE_ST = 70;
    public static final int U_TEL_ENABLE = 49;
    public static final int U_TEL_PHONE = 48;
    public static final int U_VOL_VALUE = 50;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
        for (int i = 0; i < 73; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0385_HC_Accord8(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 15; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 29:
                if (ints != null && ints.length >= 1) {
                    CdTextType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    CdTextInfo = strs[0];
                } else {
                    CdTextInfo = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 31:
                if (ints != null && ints.length >= 1) {
                    CdUsbListType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    CdUsbList = strs[0];
                } else {
                    CdUsbList = "";
                }
                Log.i("canbus", "Callback_CdUsbListType=" + CdUsbListType + "CdUsbList=" + CdUsbList);
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 41:
                if (ints != null && ints.length >= 1) {
                    MenuListType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    MenuList = strs[0];
                } else {
                    MenuList = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 48:
                if (ints != null && ints.length >= 1) {
                    TelTextType = ints[0];
                }
                if (strs != null && strs.length > 0) {
                    TelTextInfo = strs[0];
                } else {
                    TelTextInfo = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            default:
                if (updateCode >= 0 && updateCode < 73) {
                    Log.i("canbus", "updateCode" + updateCode);
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
