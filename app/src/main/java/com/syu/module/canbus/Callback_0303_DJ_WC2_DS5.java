package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0303_DJ_WC2_DS5 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 30;
    public static final int U_AIR_BEGIN = 45;
    public static final int U_AIR_END = 46;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 26;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 27;
    public static final int U_AUTOLOCK_BY_SPEED = 25;
    public static final int U_AUTO_AC_ENABLED = 9;
    public static final int U_AVERAGE_SPEED = 6;
    public static final int U_BATTERY_VOLTAGE = 43;
    public static final int U_CLOSE_BIGLAMP_TIME = 15;
    public static final int U_CLOSE_INSIDELAMP_TIME = 14;
    public static final int U_CNT_MAX = 52;
    public static final int U_CUR_OIL_EXPEND = 1;
    public static final int U_CUR_TRIP_OIL_EXPEND = 5;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 13;
    public static final int U_DOOR_BACK = 51;
    public static final int U_DOOR_BEGIN = 46;
    public static final int U_DOOR_END = 52;
    public static final int U_DOOR_ENGINE = 46;
    public static final int U_DOOR_FL = 47;
    public static final int U_DOOR_FR = 48;
    public static final int U_DOOR_RL = 49;
    public static final int U_DOOR_RR = 50;
    public static final int U_DRIVING_MILEAGE = 2;
    public static final int U_DRIVING_TIME = 4;
    public static final int U_ENGINE_SPEED = 44;
    public static final int U_EXIST_TPMS = 21;
    public static final int U_FEEDBACK_LAMP_ENABLED = 8;
    public static final int U_LAST_OIL = 42;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 29;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 34;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 12;
    public static final int U_OPTIMAL_OIL_EXPEND = 3;
    public static final int U_PARK_BESIDE_ROAD = 37;
    public static final int U_PRESSURE_BACKUP = 20;
    public static final int U_PRESSURE_FL = 16;
    public static final int U_PRESSURE_FR = 17;
    public static final int U_PRESSURE_RL = 18;
    public static final int U_PRESSURE_RR = 19;
    public static final int U_RADAR_VOL = 36;
    public static final int U_REMOTE_2PRESS_UNLOCK = 28;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 11;
    public static final int U_SHOW_RADAR = 35;
    public static final int U_SHOW_TIRE_BACKUP = 22;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 33;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 7;
    public static final int U_TIRE_SHOW_STATE = 23;
    public static final int U_TPMS_STATE = 24;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 31;
    public static final int U_UNLOCK_BY_SMART_DOOR = 32;
    public static final int U_VALID_VENTILATION_ENABLED = 10;
    public static final int U_WARNNING_CLEANNING_FLUID = 40;
    public static final int U_WARNNING_HANDLE_BRAKE = 41;
    public static final int U_WARNNING_LIFE_BELT = 39;
    public static final int U_WARNNING_LOW_OIL = 38;
    final int C_CAR_COMPUTER_SET = 0;
    final int C_TIME_FORMAT_SET = 2;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 52; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 46;
        DoorHelper.sUcDoorFl = 47;
        DoorHelper.sUcDoorFr = 48;
        DoorHelper.sUcDoorRl = 49;
        DoorHelper.sUcDoorRr = 50;
        DoorHelper.sUcDoorBack = 51;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 46; i2 < 52; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 46; i < 52; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 52) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
