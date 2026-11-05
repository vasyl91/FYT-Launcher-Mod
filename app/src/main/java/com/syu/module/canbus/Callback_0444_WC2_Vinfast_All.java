package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0444_WC2_Vinfast_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D13_D2_D3 = 99;
    public static final int U_CARINF_D32_D10_B70 = 101;
    public static final int U_CARINF_D32_D11_B70 = 102;
    public static final int U_CARINF_D32_D9_B70 = 100;
    public static final int U_CARSET_D61_D0_B0 = 106;
    public static final int U_CARSET_D61_D0_B1 = 105;
    public static final int U_CARSET_D61_D0_B32 = 104;
    public static final int U_CARSET_D61_D0_B64 = 103;
    public static final int U_CARSET_D61_D1_B70 = 107;
    public static final int U_CARSET_D61_D2_B30 = 108;
    public static final int U_CARSET_D61_D3_B10 = 112;
    public static final int U_CARSET_D61_D3_B2 = 111;
    public static final int U_CARSET_D61_D3_B3 = 110;
    public static final int U_CARSET_D61_D3_B64 = 109;
    public static final int U_CARSET_D61_D4_B0 = 116;
    public static final int U_CARSET_D61_D4_B31 = 115;
    public static final int U_CARSET_D61_D4_B4 = 114;
    public static final int U_CARSET_D61_D4_B5 = 113;
    public static final int U_CARSET_D61_D5_B3 = 118;
    public static final int U_CARSET_D61_D5_B74 = 117;
    public static final int U_CARSET_D61_D6_B0 = 126;
    public static final int U_CARSET_D61_D6_B1 = 125;
    public static final int U_CARSET_D61_D6_B2 = 124;
    public static final int U_CARSET_D61_D6_B3 = 123;
    public static final int U_CARSET_D61_D6_B4 = 122;
    public static final int U_CARSET_D61_D6_B5 = 121;
    public static final int U_CARSET_D61_D6_B6 = 120;
    public static final int U_CARSET_D61_D6_B7 = 119;
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
