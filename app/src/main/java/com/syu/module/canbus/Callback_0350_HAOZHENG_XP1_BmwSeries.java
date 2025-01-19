package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0350_HAOZHENG_XP1_BmwSeries extends CallbackCanbusBase {
    public static final int U_AUTO_AC_ENABLED = 15;
    public static final int U_CARINFO_BEGIN = 7;
    public static final int U_CARINFO_END = 23;
    public static final int U_CLOSE_BIGLAMP_TIME = 21;
    public static final int U_CLOSE_INSIDELAMP_TIME = 20;
    public static final int U_CNT_MAX = 23;
    public static final int U_CUR_OIL_EXPEND = 8;
    public static final int U_CUR_TRIP_OIL_EXPEND = 12;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 19;
    public static final int U_DRIVING_MILEAGE = 9;
    public static final int U_DRIVING_TIME = 11;
    public static final int U_FEEDBACK_LAMP_ENABLED = 14;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 18;
    public static final int U_OPTIMAL_OIL_EXPEND = 10;
    public static final int U_PRESSURE_FL = 22;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 17;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 13;
    public static final int U_VALID_VENTILATION_ENABLED = 16;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 23; i++) {
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
        if (updateCode >= 0 && updateCode < 23) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
