package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0385_HC_Accord8;

public class Callback_0385_HC_XP1_PartComHonda extends CallbackCanbusBase {
    public static String CdTextInfo = null;
    public static int CdTextType = 0;
    public static String CdUsbList = null;
    public static int CdUsbListType = 0;
    public static String MenuList = null;
    public static int MenuListType = 0;
    public static String TelTextInfo = null;
    public static int TelTextType = 0;
    public static final int U_CARCD_BEGIN = 98;
    public static final int U_CARCD_CDDISPLAY_STATE = 104;
    public static final int U_CARCD_CDTEXT_INFO = 107;
    public static final int U_CARCD_CDTEXT_TYPE = 106;
    public static final int U_CARCD_CDUSB_LIST1 = 109;
    public static final int U_CARCD_CDUSB_LIST2 = 110;
    public static final int U_CARCD_CDUSB_LIST3 = 111;
    public static final int U_CARCD_CDUSB_LIST_TYPE = 108;
    public static final int U_CARCD_DISC_INFO = 99;
    public static final int U_CARCD_END = 132;
    public static final int U_CARCD_FOLD_INFO = 105;
    public static final int U_CARCD_PLAY_MINUTE = 130;
    public static final int U_CARCD_PLAY_MODE = 102;
    public static final int U_CARCD_PLAY_SECOND = 131;
    public static final int U_CARCD_PLAY_TIME = 101;
    public static final int U_CARCD_TRACK_INFO = 100;
    public static final int U_CARCD_WORK_STATE = 103;
    public static final int U_CARRADIO_BEGIN = 133;
    public static final int U_CARRADIO_END = 139;
    public static final int U_CAR_DISC1_INFO = 112;
    public static final int U_CAR_DISC2_INFO = 113;
    public static final int U_CAR_DISC3_INFO = 114;
    public static final int U_CAR_DISC4_INFO = 115;
    public static final int U_CAR_DISC5_INFO = 116;
    public static final int U_CAR_DISC6_INFO = 117;
    public static final int U_CAR_MENULIST1_INFO = 119;
    public static final int U_CAR_MENULIST2_INFO = 120;
    public static final int U_CAR_MENULIST3_INFO = 121;
    public static final int U_CAR_MENULIST_TYPE = 118;
    public static final int U_CAR_TIME_FUNC = 122;
    public static final int U_CAR_TIME_HOUR = 123;
    public static final int U_CAR_TIME_MINUTE = 124;
    public static final int U_CNT_MAX = 139;
    public static final int U_CUR_BAND = 134;
    public static final int U_CUR_CHANNEL = 135;
    public static final int U_CUR_FREQ = 133;
    public static final int U_ICON_DISPLAY = 129;
    public static final int U_PRESET_CHANNEL = 137;
    public static final int U_RECEIVE_STATE = 138;
    public static final int U_SOURCE_STATE = 125;
    public static final int U_STATE_ST = 136;
    public static final int U_TEL_ENABLE = 127;
    public static final int U_TEL_PHONE = 126;
    public static final int U_VOL_VALUE = 128;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
        for (int i = 0; i < 139; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0385_HC_Accord8(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 107:
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
            case 109:
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
            case 119:
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
            case 126:
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
                if (updateCode >= 0 && updateCode < 139) {
                    Log.i("canbus", "updateCode" + updateCode);
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
