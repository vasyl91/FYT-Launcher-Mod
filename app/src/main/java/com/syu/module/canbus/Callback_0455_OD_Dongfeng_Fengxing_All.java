package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0455_OD_Dongfeng_Fengxing_All extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 97;
    public static final int U_CARSET_D40_D0_B2 = 102;
    public static final int U_CARSET_D40_D0_B3 = 101;
    public static final int U_CARSET_D40_D0_B4 = 100;
    public static final int U_CARSET_D40_D0_B5 = 99;
    public static final int U_CARSET_D40_D0_B76 = 98;
    public static final int U_CARSET_D40_D1_B70 = 103;
    public static final int U_CARSET_D40_D2_B70 = 104;
    public static final int U_CARSET_D40_D3_B2 = 108;
    public static final int U_CARSET_D40_D3_B43 = 107;
    public static final int U_CARSET_D40_D3_B65 = 106;
    public static final int U_CARSET_D40_D3_B7 = 105;
    public static final int U_CARSET_D40_D4_B70 = 109;
    public static final int U_CNT_MAX = 110;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
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
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
