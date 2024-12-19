package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AIR_0453_LZ_Nissan_Teana_08;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_Nissan_Teana_08 extends CallbackCanbusBase {
    public static String Str_Line1 = null;
    public static String Str_Line2 = null;
    public static final int U_CARCD_DISC1 = 144;
    public static final int U_CARCD_DISC2 = 143;
    public static final int U_CARCD_DISC3 = 142;
    public static final int U_CARCD_DISC4 = 141;
    public static final int U_CARCD_DISC5 = 140;
    public static final int U_CARCD_DISC6 = 139;
    public static final int U_CARCD_END = 151;
    public static final int U_CARCD_NUM = 146;
    public static final int U_CARCD_PLAYSTATE = 145;
    public static final int U_CARCD_REPEAT = 147;
    public static final int U_CARCD_TIME_M = 149;
    public static final int U_CARCD_TIME_S = 150;
    public static final int U_CARCD_TRACK = 148;
    public static final int U_CARINF_BEGIN = 86;
    public static final int U_CARINF_D35_D10_B6 = 94;
    public static final int U_CARINF_D35_D10_B7 = 93;
    public static final int U_CARINF_D35_D2_D3 = 91;
    public static final int U_CARINF_D35_D7_D8_D9 = 92;
    public static final int U_CARINF_D37_D0_D1 = 87;
    public static final int U_CARINF_D37_D2_D3 = 88;
    public static final int U_CARINF_D37_D4_D5_D6 = 89;
    public static final int U_CARINF_D37_D7_D8 = 90;
    public static final int U_CARINF_D3B_D0_B70 = 99;
    public static final int U_CARINF_D3B_D1_B70 = 100;
    public static final int U_CARINF_D3B_D2_B70 = 101;
    public static final int U_CARINF_D3B_D3_B70 = 102;
    public static final int U_CARINF_D3B_D4_B70 = 103;
    public static final int U_CARINF_D3B_D5_B30 = 106;
    public static final int U_CARINF_D3B_D5_B4 = 105;
    public static final int U_CARINF_D3B_D5_B5 = 104;
    public static final int U_CARINF_D3B_D6_B70 = 107;
    public static final int U_CARINF_D3C_D1_ALL_STR = 108;
    public static final int U_CARINF_D3C_D2_ALL_STR = 109;
    public static final int U_CARINF_D3C_D3_D1_B0 = 110;
    public static final int U_CARINF_D3C_D3_D1_B1 = 111;
    public static final int U_CARINF_D3C_D3_D1_B2 = 112;
    public static final int U_CARINF_D3C_D3_D1_B3 = 113;
    public static final int U_CARINF_D3C_D3_D1_B4 = 114;
    public static final int U_CARINF_D3C_D3_D1_B5 = 115;
    public static final int U_CARINF_D3C_D3_D1_B6 = 116;
    public static final int U_CARINF_D3C_D3_D1_B7 = 117;
    public static final int U_CARINF_D3C_D3_D2_B0 = 118;
    public static final int U_CARINF_D3C_D3_D2_B1 = 119;
    public static final int U_CARINF_D3C_D3_D2_B2 = 120;
    public static final int U_CARINF_D3C_D3_D2_B3 = 121;
    public static final int U_CARINF_D3C_D3_D2_B4 = 122;
    public static final int U_CARINF_D3C_D3_D2_B5 = 123;
    public static final int U_CARINF_D3C_D3_D2_B6 = 124;
    public static final int U_CARINF_D3C_D3_D2_B7 = 125;
    public static final int U_CARINF_D3C_D3_D3_B0 = 126;
    public static final int U_CARINF_D3C_D3_D3_B1 = 127;
    public static final int U_CARRADIO_BAND = 129;
    public static final int U_CARRADIO_BEGIN = 128;
    public static final int U_CARRADIO_CHANNELE = 130;
    public static final int U_CARRADIO_END = 138;
    public static final int U_CARRADIO_FRQ = 131;
    public static final int U_CARRADIO_FRQ1 = 132;
    public static final int U_CARRADIO_FRQ2 = 133;
    public static final int U_CARRADIO_FRQ3 = 134;
    public static final int U_CARRADIO_FRQ4 = 135;
    public static final int U_CARRADIO_FRQ5 = 136;
    public static final int U_CARRADIO_FRQ6 = 137;
    public static final int U_CAR_AIR_TYPR = 152;
    public static final int U_CNT_MAX = 153;
    public static final int U_PRESSURE_FL = 95;
    public static final int U_PRESSURE_FR = 96;
    public static final int U_PRESSURE_RL = 97;
    public static final int U_PRESSURE_RR = 98;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 153; i++) {
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
        AirHelper.getInstance().buildUi(new AIR_0453_LZ_Nissan_Teana_08(LauncherApplication.getInstance()));
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
        switch (updateCode) {
            case 108:
                if (strs != null && strs.length > 0) {
                    Str_Line1 = strs[0];
                } else {
                    Str_Line1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 109:
                if (strs != null && strs.length > 0) {
                    Str_Line2 = strs[0];
                } else {
                    Str_Line2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 153) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
