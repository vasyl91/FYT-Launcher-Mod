package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0144_WC1_ZhiNanZhe extends CallbackCanbusBase {
    public static final int U_CAREQ_D0_B70 = 100;
    public static final int U_CAREQ_D1_B70 = 101;
    public static final int U_CAREQ_D2_B70 = 102;
    public static final int U_CAREQ_D3_B70 = 103;
    public static final int U_CAREQ_D4_B70 = 104;
    public static final int U_CAREQ_D5_B70 = 105;
    public static final int U_CNT_MAX = 106;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 106; i++) {
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
        if (updateCode >= 0 && updateCode < 106) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
