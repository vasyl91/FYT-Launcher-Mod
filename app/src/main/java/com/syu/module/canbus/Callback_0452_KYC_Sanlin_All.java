package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_KYC_Sanlin_All extends CallbackCanbusBase {
    public static final int U_CARINF_D40_D3_B70 = 113;
    public static final int U_CARINF_D41_D0_B70 = 114;
    public static final int U_CARINF_D41_D10_B70 = 124;
    public static final int U_CARINF_D41_D11_B70 = 125;
    public static final int U_CARINF_D41_D12_B70 = 126;
    public static final int U_CARINF_D41_D13_B70 = 127;
    public static final int U_CARINF_D41_D1_B70 = 115;
    public static final int U_CARINF_D41_D2_B70 = 116;
    public static final int U_CARINF_D41_D3_B70 = 117;
    public static final int U_CARINF_D41_D4_B70 = 118;
    public static final int U_CARINF_D41_D5_B70 = 119;
    public static final int U_CARINF_D41_D6_B70 = 120;
    public static final int U_CARINF_D41_D7_B70 = 121;
    public static final int U_CARINF_D41_D8_B70 = 122;
    public static final int U_CARINF_D41_D9_B70 = 123;
    public static final int U_CARSET_LEFT_OR_RIGHT = 128;
    public static final int U_CNT_MAX = 129;
    public static final int U_PRESSURE_BACK = 102;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FR = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RR = 101;
    public static final int U_TEMP_BACK = 107;
    public static final int U_TEMP_FL = 103;
    public static final int U_TEMP_FR = 104;
    public static final int U_TEMP_RL = 105;
    public static final int U_TEMP_RR = 106;
    public static final int U_WARNING_BACK = 112;
    public static final int U_WARNING_FL = 108;
    public static final int U_WARNING_FR = 109;
    public static final int U_WARNING_RL = 110;
    public static final int U_WARNING_RR = 111;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
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
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
