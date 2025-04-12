package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0257_DJ_ChuanQiGA6 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 117;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 114;
    public static final int U_AVERAGE_SPEED = 102;
    public static final int U_CARINFO_END = 119;
    public static final int U_CLOSE_BIGLAMP_TIME = 110;
    public static final int U_CLOSE_INSIDELAMP_TIME = 109;
    public static final int U_CNT_MAX = 119;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_TRIP_OIL_EXPEND = 103;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 108;
    public static final int U_DISPLAY_ENABLE_0 = 101;
    public static final int U_DISPLAY_ENABLE_1 = 111;
    public static final int U_DISPLAY_ENABLE_2 = 112;
    public static final int U_DISPLAY_ENABLE_3 = 113;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 105;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 116;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 107;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_REMOTE_2PRESS_UNLOCK = 115;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 106;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 104;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 118;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0257_DJ_ChuangQiGa6(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 119) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
