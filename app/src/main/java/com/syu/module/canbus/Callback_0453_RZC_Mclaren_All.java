package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_RZC_Mclaren_All extends CallbackCanbusBase {
    public static final int U_CAREQ_D62_D00_B70 = 127;
    public static final int U_CAREQ_D62_D01_B70 = 128;
    public static final int U_CAREQ_D62_D02_B70 = 129;
    public static final int U_CAREQ_D62_D03_B70 = 130;
    public static final int U_CAREQ_D62_D04_B70 = 131;
    public static final int U_CAREQ_D62_D05_B30 = 133;
    public static final int U_CAREQ_D62_D05_B74 = 132;
    public static final int U_CAREQ_D62_D06_B70 = 134;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D40_D0A_B70 = 107;
    public static final int U_CARINFO_D40_D0B_B70 = 108;
    public static final int U_CARINFO_D40_D0C_B70 = 109;
    public static final int U_CARINFO_D40_D0E_B70 = 110;
    public static final int U_CARINFO_D40_D0F_B70 = 111;
    public static final int U_CARINFO_D40_D10_B70 = 112;
    public static final int U_CARINFO_D40_D1_B70 = 99;
    public static final int U_CARINFO_D40_D20_B70 = 113;
    public static final int U_CARINFO_D40_D21_B70 = 114;
    public static final int U_CARINFO_D40_D22_B70 = 115;
    public static final int U_CARINFO_D40_D23_B70 = 116;
    public static final int U_CARINFO_D40_D24_B70 = 117;
    public static final int U_CARINFO_D40_D25_B70 = 118;
    public static final int U_CARINFO_D40_D26_B70 = 119;
    public static final int U_CARINFO_D40_D26_D2_B30 = 136;
    public static final int U_CARINFO_D40_D26_D2_B74 = 135;
    public static final int U_CARINFO_D40_D27_B70 = 120;
    public static final int U_CARINFO_D40_D28_B70 = 121;
    public static final int U_CARINFO_D40_D2_B70 = 100;
    public static final int U_CARINFO_D40_D30_B70 = 122;
    public static final int U_CARINFO_D40_D31_B70 = 123;
    public static final int U_CARINFO_D40_D32_B70 = 124;
    public static final int U_CARINFO_D40_D33_B70 = 125;
    public static final int U_CARINFO_D40_D34_B70 = 126;
    public static final int U_CARINFO_D40_D3_B70 = 101;
    public static final int U_CARINFO_D40_D4_B70 = 102;
    public static final int U_CARINFO_D40_D6_B70 = 103;
    public static final int U_CARINFO_D40_D7_B70 = 104;
    public static final int U_CARINFO_D40_D8_B70 = 105;
    public static final int U_CARINFO_D40_D9_B70 = 106;
    public static final int U_CNT_MAX = 137;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 137; i++) {
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
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
