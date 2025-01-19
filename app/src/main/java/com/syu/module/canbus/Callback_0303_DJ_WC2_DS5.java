package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0303_DJ_WC2_DS5 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 127;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 123;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 124;
    public static final int U_AUTOLOCK_BY_SPEED = 122;
    public static final int U_AUTO_AC_ENABLED = 106;
    public static final int U_AVERAGE_SPEED = 103;
    public static final int U_BATTERY_VOLTAGE = 140;
    public static final int U_CLOSE_BIGLAMP_TIME = 112;
    public static final int U_CLOSE_INSIDELAMP_TIME = 111;
    public static final int U_CNT_MAX = 142;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_TRIP_OIL_EXPEND = 102;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 110;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 101;
    public static final int U_ENGINE_SPEED = 141;
    public static final int U_EXIST_TPMS = 118;
    public static final int U_FEEDBACK_LAMP_ENABLED = 105;
    public static final int U_LAST_OIL = 139;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 126;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 131;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 109;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_PARK_BESIDE_ROAD = 134;
    public static final int U_PRESSURE_BACKUP = 117;
    public static final int U_PRESSURE_FL = 113;
    public static final int U_PRESSURE_FR = 114;
    public static final int U_PRESSURE_RL = 115;
    public static final int U_PRESSURE_RR = 116;
    public static final int U_RADAR_VOL = 133;
    public static final int U_REMOTE_2PRESS_UNLOCK = 125;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 108;
    public static final int U_SHOW_RADAR = 132;
    public static final int U_SHOW_TIRE_BACKUP = 119;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 130;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 104;
    public static final int U_TIRE_SHOW_STATE = 120;
    public static final int U_TPMS_STATE = 121;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 128;
    public static final int U_UNLOCK_BY_SMART_DOOR = 129;
    public static final int U_VALID_VENTILATION_ENABLED = 107;
    public static final int U_WARNNING_CLEANNING_FLUID = 137;
    public static final int U_WARNNING_HANDLE_BRAKE = 138;
    public static final int U_WARNNING_LIFE_BELT = 136;
    public static final int U_WARNNING_LOW_OIL = 135;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 142; i++) {
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
        if (updateCode >= 0 && updateCode < 142) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
