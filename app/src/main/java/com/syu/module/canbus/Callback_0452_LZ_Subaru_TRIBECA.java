package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Subaru_TRIBECA extends CallbackCanbusBase {
    public static final int U_CARINFO_CD_NUM = 130;
    public static final int U_CARINFO_CD_RANDOM = 132;
    public static final int U_CARINFO_CD_REAPEAT = 131;
    public static final int U_CARINFO_CD_TIME_M = 134;
    public static final int U_CARINFO_CD_TIME_S = 135;
    public static final int U_CARINFO_CD_TRACK = 133;
    public static final int U_CARINFO_RADIO_BAND = 119;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 127;
    public static final int U_CARINFO_RADIO_FREQ = 120;
    public static final int U_CARINFO_RADIO_FREQ1 = 121;
    public static final int U_CARINFO_RADIO_FREQ2 = 122;
    public static final int U_CARINFO_RADIO_FREQ3 = 123;
    public static final int U_CARINFO_RADIO_FREQ4 = 124;
    public static final int U_CARINFO_RADIO_FREQ5 = 125;
    public static final int U_CARINFO_RADIO_FREQ6 = 126;
    public static final int U_CARINFO_RADIO_SCAN = 129;
    public static final int U_CARINFO_RADIO_ST = 128;
    public static final int U_CARINF_D31_D0_B70 = 98;
    public static final int U_CARINF_D31_D1_B70 = 99;
    public static final int U_CARINF_D31_D2_B70 = 100;
    public static final int U_CARINF_D31_D3_B70 = 101;
    public static final int U_CARINF_D31_D4_B70 = 102;
    public static final int U_CARINF_D31_D5_B70 = 103;
    public static final int U_CARINF_D31_D6_B70 = 136;
    public static final int U_CARINF_D35_D0_D1 = 104;
    public static final int U_CARINF_D35_D10_D11 = 109;
    public static final int U_CARINF_D35_D13_B70 = 110;
    public static final int U_CARINF_D35_D2_D3 = 105;
    public static final int U_CARINF_D35_D4_D5 = 106;
    public static final int U_CARINF_D35_D6_D7 = 107;
    public static final int U_CARINF_D35_D8_D9 = 108;
    public static final int U_CARINF_D38_D0_B10 = 115;
    public static final int U_CARINF_D38_D0_B2 = 114;
    public static final int U_CARINF_D38_D0_B3 = 113;
    public static final int U_CARINF_D38_D0_B64 = 112;
    public static final int U_CARINF_D38_D0_B7 = 111;
    public static final int U_CARINF_D38_D1_B6 = 117;
    public static final int U_CARINF_D38_D1_B7 = 116;
    public static final int U_CARINF_LEFT_TEMP_ADD = 139;
    public static final int U_CARINF_RIGHT_TEMP_ADD = 140;
    public static final int U_CARINF_UNIT_MILE = 137;
    public static final int U_CARINF_UNIT_OIL = 138;
    public static final int U_CAR_SOURCE_ID = 118;
    public static final int U_CNT_MAX = 141;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 141; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_Subaru(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
        if (updateCode >= 0 && updateCode < 141) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
