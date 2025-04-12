package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_Nissan_Teana_08 extends CallbackCanbusBase {
    public static String Str_Line1 = null;
    public static String Str_Line2 = null;
    public static final int U_CARCD_DISC1 = 156;
    public static final int U_CARCD_DISC2 = 155;
    public static final int U_CARCD_DISC3 = 154;
    public static final int U_CARCD_DISC4 = 153;
    public static final int U_CARCD_DISC5 = 152;
    public static final int U_CARCD_DISC6 = 151;
    public static final int U_CARCD_END = 163;
    public static final int U_CARCD_NUM = 158;
    public static final int U_CARCD_PLAYSTATE = 157;
    public static final int U_CARCD_REPEAT = 159;
    public static final int U_CARCD_TIME_M = 161;
    public static final int U_CARCD_TIME_S = 162;
    public static final int U_CARCD_TRACK = 160;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D35_D10_B6 = 106;
    public static final int U_CARINF_D35_D10_B7 = 105;
    public static final int U_CARINF_D35_D2_D3 = 103;
    public static final int U_CARINF_D35_D7_D8_D9 = 104;
    public static final int U_CARINF_D37_D0_D1 = 99;
    public static final int U_CARINF_D37_D2_D3 = 100;
    public static final int U_CARINF_D37_D4_D5_D6 = 101;
    public static final int U_CARINF_D37_D7_D8 = 102;
    public static final int U_CARINF_D3B_D0_B70 = 111;
    public static final int U_CARINF_D3B_D1_B70 = 112;
    public static final int U_CARINF_D3B_D2_B70 = 113;
    public static final int U_CARINF_D3B_D3_B70 = 114;
    public static final int U_CARINF_D3B_D4_B70 = 115;
    public static final int U_CARINF_D3B_D5_B30 = 118;
    public static final int U_CARINF_D3B_D5_B4 = 117;
    public static final int U_CARINF_D3B_D5_B5 = 116;
    public static final int U_CARINF_D3B_D6_B70 = 119;
    public static final int U_CARINF_D3C_D1_ALL_STR = 120;
    public static final int U_CARINF_D3C_D2_ALL_STR = 121;
    public static final int U_CARINF_D3C_D3_D1_B0 = 122;
    public static final int U_CARINF_D3C_D3_D1_B1 = 123;
    public static final int U_CARINF_D3C_D3_D1_B2 = 124;
    public static final int U_CARINF_D3C_D3_D1_B3 = 125;
    public static final int U_CARINF_D3C_D3_D1_B4 = 126;
    public static final int U_CARINF_D3C_D3_D1_B5 = 127;
    public static final int U_CARINF_D3C_D3_D1_B6 = 128;
    public static final int U_CARINF_D3C_D3_D1_B7 = 129;
    public static final int U_CARINF_D3C_D3_D2_B0 = 130;
    public static final int U_CARINF_D3C_D3_D2_B1 = 131;
    public static final int U_CARINF_D3C_D3_D2_B2 = 132;
    public static final int U_CARINF_D3C_D3_D2_B3 = 133;
    public static final int U_CARINF_D3C_D3_D2_B4 = 134;
    public static final int U_CARINF_D3C_D3_D2_B5 = 135;
    public static final int U_CARINF_D3C_D3_D2_B6 = 136;
    public static final int U_CARINF_D3C_D3_D2_B7 = 137;
    public static final int U_CARINF_D3C_D3_D3_B0 = 138;
    public static final int U_CARINF_D3C_D3_D3_B1 = 139;
    public static final int U_CARRADIO_BAND = 141;
    public static final int U_CARRADIO_BEGIN = 140;
    public static final int U_CARRADIO_CHANNELE = 142;
    public static final int U_CARRADIO_END = 150;
    public static final int U_CARRADIO_FRQ = 143;
    public static final int U_CARRADIO_FRQ1 = 144;
    public static final int U_CARRADIO_FRQ2 = 145;
    public static final int U_CARRADIO_FRQ3 = 146;
    public static final int U_CARRADIO_FRQ4 = 147;
    public static final int U_CARRADIO_FRQ5 = 148;
    public static final int U_CARRADIO_FRQ6 = 149;
    public static final int U_CAR_AIR_TYPR = 164;
    public static final int U_CNT_MAX = 165;
    public static final int U_PRESSURE_FL = 107;
    public static final int U_PRESSURE_FR = 108;
    public static final int U_PRESSURE_RL = 109;
    public static final int U_PRESSURE_RR = 110;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 165; i++) {
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
        //AirHelper.getInstance().buildUi(new AIR_0453_LZ_Nissan_Teana_08(LauncherApplication.getInstance()));
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
        switch (updateCode) {
            case 120:
                if (strs != null && strs.length > 0) {
                    Str_Line1 = strs[0];
                } else {
                    Str_Line1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 121:
                if (strs != null && strs.length > 0) {
                    Str_Line2 = strs[0];
                } else {
                    Str_Line2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 165) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
