package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0217_RZC4_PSA13_408 extends CallbackCanbusBase {
    public static final int U_AVERAGE_OIL_COST = 8;
    public static final int U_AVERAGE_OIL_COST_2 = 14;
    public static final int U_AVERAGE_SPEED = 9;
    public static final int U_AVERAGE_SPEED_2 = 16;
    public static final int U_CARINFO_CUR_PAGE = 18;
    public static final int U_CAR_BEGIN = 7;
    public static final int U_CAR_END = 19;
    public static final int U_CNT_MAX = 20;
    public static final int U_CUR_OIL_EXPEND = 10;
    public static final int U_DRIVING_MILEAGE = 11;
    public static final int U_JUMP_CARINFO = 17;
    public static final int U_OPTIMAL_OIL_EXPEND = 12;
    public static final int U_TOTAL_MILES = 13;
    public static final int U_TOTAL_MILES_2 = 15;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 20; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
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
        if (updateCode >= 0 && updateCode < 20) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
