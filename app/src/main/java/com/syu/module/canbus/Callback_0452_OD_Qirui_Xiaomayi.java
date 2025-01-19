package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Qirui_Xiaomayi extends CallbackCanbusBase {
    public static final int U_CARSET_D41_D0_B0 = 109;
    public static final int U_CARSET_D41_D0_B1 = 108;
    public static final int U_CARSET_D41_D0_B2 = 107;
    public static final int U_CARSET_D41_D0_B3 = 102;
    public static final int U_CARSET_D41_D0_B4 = 101;
    public static final int U_CARSET_D41_D0_B5 = 100;
    public static final int U_CARSET_D41_D0_B6 = 99;
    public static final int U_CARSET_D41_D0_B7 = 98;
    public static final int U_CARSET_D41_D1_B70 = 103;
    public static final int U_CARSET_D41_D2_B70 = 104;
    public static final int U_CARSET_D44_D0_D1 = 105;
    public static final int U_CARSET_D44_D2_B70 = 106;
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
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
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
