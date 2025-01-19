package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_RZC_Perodua_All extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 98;
    public static final int U_CARSET_OIL_UNIT = 104;
    public static final int U_CAR_DRIVER_POSTION = 106;
    public static final int U_CNT_MAX = 107;
    public static final int U_CUR_OIL_EXPEND = 101;
    public static final int U_CUR_TRIP_OIL_EXPEND = 102;
    public static final int U_DRIVING_MILEAGE = 100;
    public static final int U_DRIVING_TIME = 99;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 105;
    public static final int U_TRIP_OIL_EXPEND = 103;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
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
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
