package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Ford_Mustang;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Ford_Mustang extends CallbackCanbusBase {
    public static String RadioFrq1 = "";
    public static String RadioFrq2 = "";
    public static String RadioFrq3 = "";
    public static String RadioFrq4 = "";
    public static String RadioFrq5 = "";
    public static String RadioFrq6 = "";
    public static final int U_AUTO_REQUEST = 98;
    public static final int U_BT_STATE = 91;
    public static final int U_CARCD_PLAY_STATE = 118;
    public static final int U_CARCD_PLAY_TIME_M = 124;
    public static final int U_CARCD_PLAY_TIME_S = 125;
    public static final int U_CARCD_RANDOM = 120;
    public static final int U_CARCD_REPEAT = 119;
    public static final int U_CARCD_SCAN = 121;
    public static final int U_CARCD_STATE = 126;
    public static final int U_CARCD_TRACK = 122;
    public static final int U_CARCD_TRACK_TOTAL = 123;
    public static final int U_CARCD_WORK_STATE = 117;
    public static final int U_CAREQ_BAL = 132;
    public static final int U_CAREQ_BASS = 128;
    public static final int U_CAREQ_D2B_D0_B30 = 147;
    public static final int U_CAREQ_D2B_D0_B74 = 146;
    public static final int U_CAREQ_D2B_D1_B30 = 149;
    public static final int U_CAREQ_D2B_D1_B74 = 148;
    public static final int U_CAREQ_D2B_D2_B30 = 151;
    public static final int U_CAREQ_D2B_D2_B74 = 150;
    public static final int U_CAREQ_D2B_D3_B10 = 155;
    public static final int U_CAREQ_D2B_D3_B32 = 154;
    public static final int U_CAREQ_D2B_D3_B54 = 153;
    public static final int U_CAREQ_D2B_D3_B76 = 152;
    public static final int U_CAREQ_D2C_D0_B70 = 156;
    public static final int U_CAREQ_D2C_D1_B70 = 157;
    public static final int U_CAREQ_D63_D04_B20 = 139;
    public static final int U_CAREQ_D63_D04_B3 = 138;
    public static final int U_CAREQ_D63_D04_B4 = 137;
    public static final int U_CAREQ_D63_D04_B5 = 136;
    public static final int U_CAREQ_D63_D04_B6 = 135;
    public static final int U_CAREQ_D63_D04_B7 = 134;
    public static final int U_CAREQ_D63_D05_B7 = 145;
    public static final int U_CAREQ_FAD = 131;
    public static final int U_CAREQ_MID = 129;
    public static final int U_CAREQ_SPEED_VOL = 133;
    public static final int U_CAREQ_TREB = 130;
    public static final int U_CAREQ_VOL = 127;
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_END = 100;
    public static final int U_CARRADIO_BAND = 107;
    public static final int U_CARRADIO_CHNNEL = 116;
    public static final int U_CARRADIO_FRQ = 109;
    public static final int U_CARRADIO_FRQ1 = 110;
    public static final int U_CARRADIO_FRQ2 = 111;
    public static final int U_CARRADIO_FRQ3 = 112;
    public static final int U_CARRADIO_FRQ4 = 113;
    public static final int U_CARRADIO_FRQ5 = 114;
    public static final int U_CARRADIO_FRQ6 = 115;
    public static final int U_CARRADIO_STATE = 108;
    public static final int U_CARSET_AMBIENT_COLOR = 142;
    public static final int U_CARSET_AMBIENT_LEV = 141;
    public static final int U_CARSET_D24_D2_B7 = 101;
    public static final int U_CARSET_D24_D3_B7 = 140;
    public static final int U_CARSET_D24_D5_B4 = 143;
    public static final int U_CARSET_D24_D5_B5 = 102;
    public static final int U_CARSET_D24_D5_B6 = 103;
    public static final int U_CARSET_D24_D5_B7 = 144;
    public static final int U_CARSET_D25_D0_B2 = 104;
    public static final int U_CARSET_D25_D0_B3 = 105;
    public static final int U_CARSET_D27_D0_B70 = 106;
    public static final int U_CAR_WARN = 99;
    public static final int U_CNT_MAX = 158;
    public static final int U_CUR_WORK_MODE = 95;
    public static final int U_DISPLAY_MODE = 90;
    public static final int U_LINE_GROUP = 88;
    public static final int U_LIST_INFO = 93;
    public static final int U_MODE_STATE = 96;
    public static final int U_PARM_WARM = 92;
    public static final int U_PHONE_STATE = 97;
    public static final int U_PHONE_TIME = 94;
    public static final int U_PLAY_TIME = 89;
    public static final int U_SCREEN_ICON = 87;
    public static final int U_SCREEN_ID = 86;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 158; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Ford_Mustang(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            if (updateCode == 1 || updateCode == 2 || updateCode == 7 || updateCode == 13 || updateCode == 12) {
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode == 110) {
                if (strs != null && strs.length > 0) {
                    RadioFrq1 = strs[0];
                } else {
                    RadioFrq1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 111) {
                if (strs != null && strs.length > 0) {
                    RadioFrq2 = strs[0];
                } else {
                    RadioFrq2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 112) {
                if (strs != null && strs.length > 0) {
                    RadioFrq3 = strs[0];
                } else {
                    RadioFrq3 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 113) {
                if (strs != null && strs.length > 0) {
                    RadioFrq4 = strs[0];
                } else {
                    RadioFrq4 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 114) {
                if (strs != null && strs.length > 0) {
                    RadioFrq5 = strs[0];
                } else {
                    RadioFrq5 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 115) {
                if (strs != null && strs.length > 0) {
                    RadioFrq6 = strs[0];
                } else {
                    RadioFrq6 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
