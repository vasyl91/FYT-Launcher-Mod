package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0326_XFY_DX7 extends CallbackCanbusBase {
    public static final int C_ALL_SETTINGS = 0;
    public static final int U_CARINFO_BACKLIGHT_MOTOR = 113;
    public static final int U_CARINFO_BEGIN = 106;
    public static final int U_CARINFO_DOOR_UNLOCK = 108;
    public static final int U_CARINFO_LOCK_SPEED = 111;
    public static final int U_CARINFO_REARVIEW_AUTO = 107;
    public static final int U_CARINFO_RELOCK_AUTO = 112;
    public static final int U_CARINFO_TIME_FORMAT = 114;
    public static final int U_CARINFO_UNLOCK_AUTO = 110;
    public static final int U_CARINFO_UNLOCK_BY_LIGHT = 109;
    public static final int U_CNT_MAX = 115;
    public static final int U_CUR_OIL_EXPEND = 102;
    public static final int U_DRIVING_MILEAGE = 103;
    public static final int U_LAST_OIL = 105;
    public static final int U_OPTIMAL_OIL_EXPEND = 104;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FR = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RR = 101;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
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
        if (updateCode >= 0 && updateCode < 115) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
