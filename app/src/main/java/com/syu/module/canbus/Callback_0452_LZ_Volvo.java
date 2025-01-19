package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_LZ_Volvo;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Volvo extends CallbackCanbusBase {
    public static final int U_AIR_CTRL_MODE = 154;
    public static final int U_AIR_CTRL_TEMP_LEFT_ADD = 155;
    public static final int U_AIR_CTRL_TEMP_LEFT_SUB = 156;
    public static final int U_AIR_CTRL_TEMP_RIGHT_ADD = 157;
    public static final int U_AIR_CTRL_TEMP_RIGHT_SUB = 158;
    public static final int U_CARINFO_D38_D0_B70 = 98;
    public static final int U_CARINFO_D38_D10_B70 = 108;
    public static final int U_CARINFO_D38_D11_B70 = 109;
    public static final int U_CARINFO_D38_D12_B70 = 110;
    public static final int U_CARINFO_D38_D13_B70 = 111;
    public static final int U_CARINFO_D38_D14_B70 = 112;
    public static final int U_CARINFO_D38_D15_B70 = 113;
    public static final int U_CARINFO_D38_D16_B70 = 114;
    public static final int U_CARINFO_D38_D17_B70 = 115;
    public static final int U_CARINFO_D38_D18_B70 = 116;
    public static final int U_CARINFO_D38_D19_B70 = 117;
    public static final int U_CARINFO_D38_D1_B70 = 99;
    public static final int U_CARINFO_D38_D20_B70 = 118;
    public static final int U_CARINFO_D38_D21_B0 = 124;
    public static final int U_CARINFO_D38_D21_B21 = 123;
    public static final int U_CARINFO_D38_D21_B3 = 122;
    public static final int U_CARINFO_D38_D21_B4 = 121;
    public static final int U_CARINFO_D38_D21_B5 = 120;
    public static final int U_CARINFO_D38_D21_B76 = 119;
    public static final int U_CARINFO_D38_D22_B0 = 131;
    public static final int U_CARINFO_D38_D22_B1 = 130;
    public static final int U_CARINFO_D38_D22_B2 = 129;
    public static final int U_CARINFO_D38_D22_B3 = 128;
    public static final int U_CARINFO_D38_D22_B4 = 127;
    public static final int U_CARINFO_D38_D22_B65 = 126;
    public static final int U_CARINFO_D38_D22_B7 = 125;
    public static final int U_CARINFO_D38_D23_B1 = 137;
    public static final int U_CARINFO_D38_D23_B2 = 136;
    public static final int U_CARINFO_D38_D23_B3 = 135;
    public static final int U_CARINFO_D38_D23_B4 = 134;
    public static final int U_CARINFO_D38_D23_B5 = 133;
    public static final int U_CARINFO_D38_D23_B76 = 132;
    public static final int U_CARINFO_D38_D24_B0 = 148;
    public static final int U_CARINFO_D38_D24_B1 = 147;
    public static final int U_CARINFO_D38_D24_B2 = 146;
    public static final int U_CARINFO_D38_D24_B3 = 145;
    public static final int U_CARINFO_D38_D24_B4 = 144;
    public static final int U_CARINFO_D38_D24_B5 = 143;
    public static final int U_CARINFO_D38_D24_B6 = 142;
    public static final int U_CARINFO_D38_D24_B7 = 141;
    public static final int U_CARINFO_D38_D25_B7 = 149;
    public static final int U_CARINFO_D38_D2_B70 = 100;
    public static final int U_CARINFO_D38_D3_B70 = 101;
    public static final int U_CARINFO_D38_D4_B70 = 102;
    public static final int U_CARINFO_D38_D5_B70 = 103;
    public static final int U_CARINFO_D38_D6_B70 = 104;
    public static final int U_CARINFO_D38_D7_B70 = 105;
    public static final int U_CARINFO_D38_D8_B70 = 106;
    public static final int U_CARINFO_D38_D9_B70 = 107;
    public static final int U_CARINFO_D39_D0_B70 = 151;
    public static final int U_CARINFO_D39_D1_B70 = 152;
    public static final int U_CARINFO_D39_D2_B70 = 153;
    public static final int U_CARINFO_D7D_D1_B30 = 138;
    public static final int U_CARINFO_D7E_D3_D4_D5 = 139;
    public static final int U_CARINFO_D7E_D8_D9 = 140;
    public static final int U_CNT_MAX = 159;
    public static final int U_STEER_CONTROLER_TYPE = 150;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 159; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_Volvo(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 159) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
