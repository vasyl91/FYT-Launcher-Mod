package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0175_XP1_MZD_CX5 extends CallbackCanbusBase {
    public static final int U_AUTO_AC_ENABLED = 105;
    public static final int U_CAR_INFO_END = 109;
    public static final int U_CNT_MAX = 110;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_TRIP_OIL_EXPEND = 102;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 101;
    public static final int U_FEEDBACK_LAMP_ENABLED = 104;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 108;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 107;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 103;
    public static final int U_VALID_VENTILATION_ENABLED = 106;

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
