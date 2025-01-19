package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_RZC_Guanzhi_All extends CallbackCanbusBase {
    public static final int U_CARSET_BEGIN = 106;
    public static final int U_CARSET_D32_D0_B30 = 109;
    public static final int U_CARSET_D32_D0_B6 = 108;
    public static final int U_CARSET_D32_D0_B7 = 107;
    public static final int U_CARSET_D32_D1_B30 = 111;
    public static final int U_CARSET_D32_D1_B74 = 110;
    public static final int U_CARSET_D32_D2_B1 = 116;
    public static final int U_CARSET_D32_D2_B32 = 115;
    public static final int U_CARSET_D32_D2_B4 = 114;
    public static final int U_CARSET_D32_D2_B5 = 113;
    public static final int U_CARSET_D32_D2_B76 = 112;
    public static final int U_CARSET_D32_D3_B70 = 117;
    public static final int U_CARSET_D32_D4_B70 = 118;
    public static final int U_CARSET_D32_D5_B65 = 120;
    public static final int U_CARSET_D32_D5_B7 = 119;
    public static final int U_CARSET_D40_D10_D11 = 123;
    public static final int U_CARSET_D40_D12_D13 = 124;
    public static final int U_CARSET_D40_D1_D2_D3 = 121;
    public static final int U_CARSET_D40_D25_B70 = 125;
    public static final int U_CARSET_D40_D27_D28 = 126;
    public static final int U_CARSET_D40_D29_D30 = 127;
    public static final int U_CARSET_D40_D9_B70 = 122;
    public static final int U_CNT_MAX = 128;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FR = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RR = 101;
    public static final int U_WARNING_FL = 102;
    public static final int U_WARNING_FR = 103;
    public static final int U_WARNING_RL = 104;
    public static final int U_WARNING_RR = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 128; i++) {
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
        if (updateCode >= 0 && updateCode < 128) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
