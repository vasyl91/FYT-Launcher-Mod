package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0453_LZ_Maserati300C;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_Maserati_300C extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 160;
    public static final int U_CARINFO_EQ_BASS = 156;
    public static final int U_CARINFO_EQ_CARVOL = 161;
    public static final int U_CARINFO_EQ_FAD = 159;
    public static final int U_CARINFO_EQ_MID = 157;
    public static final int U_CARINFO_EQ_SPEEDVOL = 163;
    public static final int U_CARINFO_EQ_SUROUND = 162;
    public static final int U_CARINFO_EQ_TREB = 158;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D38_D0_B10 = 104;
    public static final int U_CARINF_D38_D0_B2 = 103;
    public static final int U_CARINF_D38_D0_B3 = 102;
    public static final int U_CARINF_D38_D0_B4 = 101;
    public static final int U_CARINF_D38_D0_B65 = 100;
    public static final int U_CARINF_D38_D0_B7 = 99;
    public static final int U_CARINF_D38_D1_B0 = 111;
    public static final int U_CARINF_D38_D1_B1 = 110;
    public static final int U_CARINF_D38_D1_B2 = 109;
    public static final int U_CARINF_D38_D1_B3 = 108;
    public static final int U_CARINF_D38_D1_B4 = 107;
    public static final int U_CARINF_D38_D1_B5 = 106;
    public static final int U_CARINF_D38_D1_B76 = 105;
    public static final int U_CARINF_D38_D2_B0 = 119;
    public static final int U_CARINF_D38_D2_B1 = 118;
    public static final int U_CARINF_D38_D2_B2 = 117;
    public static final int U_CARINF_D38_D2_B3 = 116;
    public static final int U_CARINF_D38_D2_B4 = 115;
    public static final int U_CARINF_D38_D2_B5 = 114;
    public static final int U_CARINF_D38_D2_B6 = 113;
    public static final int U_CARINF_D38_D2_B7 = 112;
    public static final int U_CARINF_D38_D3_B0 = 125;
    public static final int U_CARINF_D38_D3_B1 = 124;
    public static final int U_CARINF_D38_D3_B2 = 123;
    public static final int U_CARINF_D38_D3_B3 = 122;
    public static final int U_CARINF_D38_D3_B54 = 121;
    public static final int U_CARINF_D38_D3_B76 = 120;
    public static final int U_CARINF_D38_D4_B70 = 126;
    public static final int U_CARINF_D38_D5_B0 = 134;
    public static final int U_CARINF_D38_D5_B1 = 133;
    public static final int U_CARINF_D38_D5_B2 = 132;
    public static final int U_CARINF_D38_D5_B3 = 131;
    public static final int U_CARINF_D38_D5_B4 = 130;
    public static final int U_CARINF_D38_D5_B5 = 129;
    public static final int U_CARINF_D38_D5_B6 = 128;
    public static final int U_CARINF_D38_D5_B7 = 127;
    public static final int U_CARINF_D38_D6_B10 = 138;
    public static final int U_CARINF_D38_D6_B32 = 137;
    public static final int U_CARINF_D38_D6_B54 = 136;
    public static final int U_CARINF_D38_D6_B76 = 135;
    public static final int U_CARINF_D38_D7_B0 = 144;
    public static final int U_CARINF_D38_D7_B1 = 143;
    public static final int U_CARINF_D38_D7_B2 = 142;
    public static final int U_CARINF_D38_D7_B3 = 141;
    public static final int U_CARINF_D38_D7_B54 = 140;
    public static final int U_CARINF_D38_D7_B76 = 139;
    public static final int U_CARINF_D38_D8_B10 = 151;
    public static final int U_CARINF_D38_D8_B2 = 150;
    public static final int U_CARINF_D38_D8_B3 = 149;
    public static final int U_CARINF_D38_D8_B4 = 148;
    public static final int U_CARINF_D38_D8_B5 = 147;
    public static final int U_CARINF_D38_D8_B6 = 146;
    public static final int U_CARINF_D38_D8_B7 = 145;
    public static final int U_CARINF_D38_D9_B21 = 155;
    public static final int U_CARINF_D38_D9_B3 = 154;
    public static final int U_CARINF_D38_D9_B54 = 153;
    public static final int U_CARINF_D38_D9_B76 = 152;
    public static final int U_CNT_MAX = 164;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 164; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0453_LZ_Maserati300C(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 164) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
