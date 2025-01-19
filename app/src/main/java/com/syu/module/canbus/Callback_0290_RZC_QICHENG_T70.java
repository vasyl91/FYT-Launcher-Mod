package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0290_RZC_QICHENG_T70 extends CallbackCanbusBase {
    public static final int U_AVM_61_D00 = 110;
    public static final int U_AVM_61_D01 = 109;
    public static final int U_AVM_61_D02 = 108;
    public static final int U_AVM_61_D03 = 107;
    public static final int U_BELT_LEFT = 105;
    public static final int U_BELT_RIGHT = 106;
    public static final int U_CARINFO_MILEAGE = 103;
    public static final int U_CARINO_BEGIN = 101;
    public static final int U_CARINO_END = 104;
    public static final int U_CNT_MAX = 112;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_SPEED = 101;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_ENGINE_SPEED = 102;
    public static final int U_LIGHT_TRAVEL_MODE = 111;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
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
        if (updateCode >= 0 && updateCode < 112) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
