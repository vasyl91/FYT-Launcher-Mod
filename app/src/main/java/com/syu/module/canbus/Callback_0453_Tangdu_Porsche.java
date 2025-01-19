package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_Tangdu_Porsche extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D40_D0_B30 = 99;
    public static final int U_CARINFO_D40_D0_B4 = 100;
    public static final int U_CARINFO_D40_D0_B5 = 101;
    public static final int U_CARINFO_D40_D0_B6 = 102;
    public static final int U_CARINFO_D40_D0_B7 = 103;
    public static final int U_CARINFO_D40_D1_B0 = 104;
    public static final int U_CARINFO_D40_D1_B12 = 105;
    public static final int U_CARINFO_D40_D1_B34 = 106;
    public static final int U_CARINFO_D40_D1_B5 = 107;
    public static final int U_CARINFO_D40_D1_B6 = 108;
    public static final int U_CARINFO_D40_D2_B04 = 109;
    public static final int U_CARINFO_D40_D2_B5 = 110;
    public static final int U_CARINFO_D40_D3_B70 = 111;
    public static final int U_CARINFO_D41_D11_D13 = 116;
    public static final int U_CARINFO_D41_D4_D5 = 112;
    public static final int U_CARINFO_D41_D6_D7 = 113;
    public static final int U_CARINFO_D41_D8_B70 = 114;
    public static final int U_CARINFO_D41_D9_D10 = 115;
    public static final int U_CARSET_EQ_BAL = 118;
    public static final int U_CARSET_EQ_BASS = 119;
    public static final int U_CARSET_EQ_D4_B0 = 123;
    public static final int U_CARSET_EQ_D4_B1 = 124;
    public static final int U_CARSET_EQ_D4_B2 = 125;
    public static final int U_CARSET_EQ_D4_B3 = 126;
    public static final int U_CARSET_EQ_FAD = 117;
    public static final int U_CARSET_EQ_MID = 120;
    public static final int U_CARSET_EQ_TREB = 121;
    public static final int U_CARSET_EQ_VOL = 122;
    public static final int U_CNT_MAX = 127;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
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
        if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
