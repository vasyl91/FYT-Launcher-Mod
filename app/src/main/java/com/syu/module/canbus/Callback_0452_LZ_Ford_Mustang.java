package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_LZ_Ford_Mustang;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Ford_Mustang extends CallbackCanbusBase {
    public static String RadioFrq1 = "";
    public static String RadioFrq2 = "";
    public static String RadioFrq3 = "";
    public static String RadioFrq4 = "";
    public static String RadioFrq5 = "";
    public static String RadioFrq6 = "";
    public static final int U_AUTO_REQUEST = 110;
    public static final int U_BT_STATE = 103;
    public static final int U_CARCD_PLAY_STATE = 130;
    public static final int U_CARCD_PLAY_TIME_M = 136;
    public static final int U_CARCD_PLAY_TIME_S = 137;
    public static final int U_CARCD_RANDOM = 132;
    public static final int U_CARCD_REPEAT = 131;
    public static final int U_CARCD_SCAN = 133;
    public static final int U_CARCD_STATE = 138;
    public static final int U_CARCD_TRACK = 134;
    public static final int U_CARCD_TRACK_TOTAL = 135;
    public static final int U_CARCD_WORK_STATE = 129;
    public static final int U_CAREQ_BAL = 144;
    public static final int U_CAREQ_BASS = 140;
    public static final int U_CAREQ_D2B_D0_B30 = 159;
    public static final int U_CAREQ_D2B_D0_B74 = 158;
    public static final int U_CAREQ_D2B_D1_B30 = 161;
    public static final int U_CAREQ_D2B_D1_B74 = 160;
    public static final int U_CAREQ_D2B_D2_B30 = 163;
    public static final int U_CAREQ_D2B_D2_B74 = 162;
    public static final int U_CAREQ_D2B_D3_B10 = 167;
    public static final int U_CAREQ_D2B_D3_B32 = 166;
    public static final int U_CAREQ_D2B_D3_B54 = 165;
    public static final int U_CAREQ_D2B_D3_B76 = 164;
    public static final int U_CAREQ_D2C_D0_B70 = 168;
    public static final int U_CAREQ_D2C_D1_B70 = 169;
    public static final int U_CAREQ_D63_D04_B20 = 151;
    public static final int U_CAREQ_D63_D04_B3 = 150;
    public static final int U_CAREQ_D63_D04_B4 = 149;
    public static final int U_CAREQ_D63_D04_B5 = 148;
    public static final int U_CAREQ_D63_D04_B6 = 147;
    public static final int U_CAREQ_D63_D04_B7 = 146;
    public static final int U_CAREQ_D63_D05_B7 = 157;
    public static final int U_CAREQ_FAD = 143;
    public static final int U_CAREQ_MID = 141;
    public static final int U_CAREQ_SPEED_VOL = 145;
    public static final int U_CAREQ_TREB = 142;
    public static final int U_CAREQ_VOL = 139;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_END = 112;
    public static final int U_CARINF_BACK_CAR = 173;
    public static final int U_CARINF_D28_D0_B0 = 171;
    public static final int U_CARINF_D28_D0_B21 = 170;
    public static final int U_CARINF_D28_D1_B70 = 172;
    public static final int U_CARINF_D29_TYPE1_D1_B0 = 175;
    public static final int U_CARINF_D29_TYPE1_D1_B1 = 174;
    public static final int U_CARINF_D29_TYPE1_D6_D7 = 176;
    public static final int U_CARINF_D29_TYPE1_D8_D10 = 177;
    public static final int U_CARINF_D29_TYPE2_D1_B70 = 178;
    public static final int U_CARINF_D29_TYPE2_D2_B70 = 179;
    public static final int U_CARINF_D29_TYPE2_D3_B70 = 180;
    public static final int U_CARINF_D29_TYPE2_D4_B70 = 181;
    public static final int U_CARINF_D29_TYPE2_D5_B70 = 182;
    public static final int U_CARINF_D29_TYPE2_D6_B70 = 183;
    public static final int U_CARINF_D29_TYPE2_D7_B70 = 184;
    public static final int U_CARINF_D29_TYPE2_D8_B70 = 185;
    public static final int U_CARINF_D29_TYPE2_D9_B70 = 186;
    public static final int U_CARRADIO_BAND = 119;
    public static final int U_CARRADIO_CHNNEL = 128;
    public static final int U_CARRADIO_FRQ = 121;
    public static final int U_CARRADIO_FRQ1 = 122;
    public static final int U_CARRADIO_FRQ2 = 123;
    public static final int U_CARRADIO_FRQ3 = 124;
    public static final int U_CARRADIO_FRQ4 = 125;
    public static final int U_CARRADIO_FRQ5 = 126;
    public static final int U_CARRADIO_FRQ6 = 127;
    public static final int U_CARRADIO_STATE = 120;
    public static final int U_CARSET_AMBIENT_COLOR = 154;
    public static final int U_CARSET_AMBIENT_LEV = 153;
    public static final int U_CARSET_D24_D2_B7 = 113;
    public static final int U_CARSET_D24_D3_B7 = 152;
    public static final int U_CARSET_D24_D5_B4 = 155;
    public static final int U_CARSET_D24_D5_B5 = 114;
    public static final int U_CARSET_D24_D5_B6 = 115;
    public static final int U_CARSET_D24_D5_B7 = 156;
    public static final int U_CARSET_D25_D0_B2 = 116;
    public static final int U_CARSET_D25_D0_B3 = 117;
    public static final int U_CARSET_D27_D0_B70 = 118;
    public static final int U_CAR_WARN = 111;
    public static final int U_CNT_MAX = 187;
    public static final int U_CUR_WORK_MODE = 107;
    public static final int U_DISPLAY_MODE = 102;
    public static final int U_LINE_GROUP = 100;
    public static final int U_LIST_INFO = 105;
    public static final int U_MODE_STATE = 108;
    public static final int U_PARM_WARM = 104;
    public static final int U_PHONE_STATE = 109;
    public static final int U_PHONE_TIME = 106;
    public static final int U_PLAY_TIME = 101;
    public static final int U_SCREEN_ICON = 99;
    public static final int U_SCREEN_ID = 98;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 187; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_Ford_Mustang(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            if (updateCode == 99 || updateCode == 100 || updateCode == 105 || updateCode == 111 || updateCode == 110) {
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode == 122) {
                if (strs != null && strs.length > 0) {
                    RadioFrq1 = strs[0];
                } else {
                    RadioFrq1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 123) {
                if (strs != null && strs.length > 0) {
                    RadioFrq2 = strs[0];
                } else {
                    RadioFrq2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 124) {
                if (strs != null && strs.length > 0) {
                    RadioFrq3 = strs[0];
                } else {
                    RadioFrq3 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 125) {
                if (strs != null && strs.length > 0) {
                    RadioFrq4 = strs[0];
                } else {
                    RadioFrq4 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 126) {
                if (strs != null && strs.length > 0) {
                    RadioFrq5 = strs[0];
                } else {
                    RadioFrq5 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 127) {
                if (strs != null && strs.length > 0) {
                    RadioFrq6 = strs[0];
                } else {
                    RadioFrq6 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            Log.v("zed", "updateCode == " + updateCode + "-----value == " + DataCanbus.DATA[updateCode]);
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
