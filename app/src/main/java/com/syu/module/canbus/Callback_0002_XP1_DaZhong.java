package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0002_XP1_DaZhong extends CallbackCanbusBase {
    public static final int U_AIR_TEMP_OUT = 121;
    public static final int U_BATTERY_VOLTAGE = 105;
    public static final int U_CAR_TIRE_BEGIN = 113;
    public static final int U_CAR_TIRE_CHECK = 118;
    public static final int U_CAR_TIRE_END = 120;
    public static final int U_CAR_TIRE_STATE = 119;
    public static final int U_CAR_TIRE_VALUE_FL = 114;
    public static final int U_CAR_TIRE_VALUE_FR = 115;
    public static final int U_CAR_TIRE_VALUE_RL = 116;
    public static final int U_CAR_TIRE_VALUE_RR = 117;
    public static final int U_CLEAN_FLUIT_WARN = 102;
    public static final int U_CNT_MAX = 122;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_SPEED = 109;
    public static final int U_DRIVE_MILE = 106;
    public static final int U_ENGINE_SPEED = 110;
    public static final int U_HANDLE_BRAKE_WARN = 103;
    public static final int U_LIFE_BELT_WARN = 101;
    public static final int U_LOW_BATTERY_WARN = 100;
    public static final int U_LOW_OIL_WARN = 99;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 112;
    public static final int U_OUT_TEMP = 111;
    public static final int U_PARK = 107;
    public static final int U_RADAR_MUTE = 108;
    public static final int U_RESIDUAL_OIL = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0002_XP1_DaZhong(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 5; i++) {
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
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
