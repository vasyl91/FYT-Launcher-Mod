package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LZ_BMW_E46 extends CallbackCanbusBase {
    public static final int U_CARINFO_D35_D0_D6 = 34;
    public static final int U_CARINFO_D35_D10_B6 = 41;
    public static final int U_CARINFO_D35_D10_B7 = 40;
    public static final int U_CARINFO_D35_D11_B70 = 57;
    public static final int U_CARINFO_D35_D12_B70 = 58;
    public static final int U_CARINFO_D35_D13_D14 = 59;
    public static final int U_CARINFO_D35_D1_B70 = 35;
    public static final int U_CARINFO_D35_D2_D3 = 36;
    public static final int U_CARINFO_D35_D4_D5 = 37;
    public static final int U_CARINFO_D35_D6_B70 = 38;
    public static final int U_CARINFO_D35_D7_D8_D9 = 39;
    public static final int U_CARINFO_D37_D0_D1 = 8;
    public static final int U_CARINFO_D37_D2_D3 = 9;
    public static final int U_CARINFO_D37_D4_D5 = 10;
    public static final int U_CARINFO_D37_D6_B0 = 11;
    public static final int U_CARINFO_D37_D6_B21 = 12;
    public static final int U_CARINFO_D38_D0_D1 = 13;
    public static final int U_CARINFO_D38_D10_B70 = 54;
    public static final int U_CARINFO_D38_D11_B70 = 55;
    public static final int U_CARINFO_D38_D12_B70 = 56;
    public static final int U_CARINFO_D38_D2_B0 = 14;
    public static final int U_CARINFO_D38_D2_B1 = 15;
    public static final int U_CARINFO_D38_D2_B32 = 16;
    public static final int U_CARINFO_D38_D2_B4 = 17;
    public static final int U_CARINFO_D38_D2_B5 = 18;
    public static final int U_CARINFO_D38_D2_B6 = 19;
    public static final int U_CARINFO_D38_D2_B7 = 20;
    public static final int U_CARINFO_D38_D3_D4 = 21;
    public static final int U_CARINFO_D38_D5_B70 = 22;
    public static final int U_CARINFO_D38_D6_B70 = 23;
    public static final int U_CARINFO_D38_D7_B70 = 24;
    public static final int U_CARINFO_D38_D8_B1 = 47;
    public static final int U_CARINFO_D38_D8_B2 = 48;
    public static final int U_CARINFO_D38_D8_B3 = 49;
    public static final int U_CARINFO_D38_D8_B4 = 50;
    public static final int U_CARINFO_D38_D8_B5 = 51;
    public static final int U_CARINFO_D38_D8_B6 = 52;
    public static final int U_CARINFO_D38_D8_B70 = 25;
    public static final int U_CARINFO_D38_D9_B70 = 53;
    public static final int U_CARINFO_D39_D0_B30 = 27;
    public static final int U_CARINFO_D39_D0_B74 = 26;
    public static final int U_CARINFO_D39_D1_B70 = 28;
    public static final int U_CARINFO_D39_D2_B70 = 29;
    public static final int U_CARINFO_D39_D3_B70 = 30;
    public static final int U_CARINFO_D3B_D0_B0 = 44;
    public static final int U_CARINFO_D3B_D0_B1 = 43;
    public static final int U_CARINFO_D3B_D0_B74 = 42;
    public static final int U_CARINFO_D3B_D1_B70 = 45;
    public static final int U_CARINFO_D3B_D2_B70 = 46;
    public static final int U_CARINFO_LINE1 = 31;
    public static final int U_CARINFO_LINE2 = 32;
    public static final int U_CARINFO_LINE3 = 33;
    public static final int U_CAR_WARN = 7;
    public static final int U_CNT_MAX = 60;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 60; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 60) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
