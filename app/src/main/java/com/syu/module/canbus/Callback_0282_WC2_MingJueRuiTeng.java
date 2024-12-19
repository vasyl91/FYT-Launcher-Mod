package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0282_WC2_17MingJueRuiTeng;
import com.syu.ui.air.Air_0282_WC2_MingJueRuiTeng;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0282_WC2_MingJueRuiTeng extends CallbackCanbusBase {
    public static final int U_17MINGJUE_END = 109;
    public static final int U_17MINGJUE_START = 98;
    public static final int U_2TIMES_KEY_UNLOCK = 66;
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_AUTOMODE_BLOW_VALUE = 103;
    public static final int U_AIR_AUTOMODE_BLOW_VALUE_VIEW = 106;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 19;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 99;
    public static final int U_AIR_DUAL_TEMP_VALUE = 104;
    public static final int U_AIR_DUAL_TEMP_VALUE_VIEW = 107;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_MAX = 20;
    public static final int U_AIR_POWER = 23;
    public static final int U_AIR_REARFROST_FOG_VLAUE = 105;
    public static final int U_AIR_REARFROST_FOG_VLAUE_VIEW = 108;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 22;
    public static final int U_AIR_TEMP_RIGHT_REAL = 100;
    public static final int U_AIR_WIND_LEVEL_LEFT = 21;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 62;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 63;
    public static final int U_AUTOLOCK_BY_SPEED = 61;
    public static final int U_AUTO_AC_ENABLED = 31;
    public static final int U_BATTERY_VOLTAGE = 39;
    public static final int U_CAR_BT_STATE = 79;
    public static final int U_CAR_CAMERA_MODE = 78;
    public static final int U_CAR_CURR_SOURCE = 85;
    public static final int U_CAR_PLAY_PROGRESS = 75;
    public static final int U_CAR_PLAY_STATE = 76;
    public static final int U_CAR_RIGHTCAMERA_STATE = 84;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 28;
    public static final int U_CLOSE_BIGLAMP_TIME = 44;
    public static final int U_CLOSE_INSIDELAMP_TIME = 43;
    public static final int U_CNT_MAX = 114;
    public static final int U_CUR_OIL_EXPEND = 80;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 42;
    public static final int U_DRIVER_ACC = 88;
    public static final int U_DRIVING_MILEAGE = 81;
    public static final int U_DRIVING_TIME = 83;
    public static final int U_ENGINE_SPEED = 46;
    public static final int U_ESC_SYSTEM = 51;
    public static final int U_EXIST_TPMS = 57;
    public static final int U_FEEDBACK_LAMP_ENABLED = 30;
    public static final int U_LAST_OIL = 38;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 65;
    public static final int U_MIRROR_WIPERS_AUTO_WIPING_IN_RAIN = 87;
    public static final int U_MIRROR_WIPERS_FOLDIN_WHEN_PARKED = 92;
    public static final int U_MIRROR_WIPERS_LOW_WHILE_REVESING = 93;
    public static final int U_MIRROR_WIPERS_REAR_WIN_WIPING_IN_RESERVE = 86;
    public static final int U_MISC_BEGIN = 25;
    public static final int U_MISC_END = 97;
    public static final int U_MUTIL_SPEED_WARNNING = 50;
    public static final int U_OIL_MARK_MAX = 71;
    public static final int U_OIL_PROGRESS = 72;
    public static final int U_OIL_UNIT = 73;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 41;
    public static final int U_OPEN_CLOSE_AUTO_LOCK = 91;
    public static final int U_OPEN_CLOSE_CONVENIENCE = 89;
    public static final int U_OPEN_CLOSE_DOOR_UNLOCK = 90;
    public static final int U_OPTIMAL_OIL_EXPEND = 82;
    public static final int U_PARK_BESIDE_ROAD = 47;
    public static final int U_PARK_IN_CARPORT = 74;
    public static final int U_PRESSURE_BACKUP = 56;
    public static final int U_PRESSURE_FL = 45;
    public static final int U_PRESSURE_FR = 48;
    public static final int U_PRESSURE_RL = 49;
    public static final int U_PRESSURE_RR = 55;
    public static final int U_RADAR_MUTE = 77;
    public static final int U_RADAR_VOL = 27;
    public static final int U_REMOTE_2PRESS_UNLOCK = 64;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 40;
    public static final int U_SET_BEEP_ONOFF = 113;
    public static final int U_SET_COME_HOME_WITH_ME = 96;
    public static final int U_SET_COME_HOME_WITH_ME_VIEW = 102;
    public static final int U_SET_LIGHT_HOME_TIME = 110;
    public static final int U_SET_SEARCH_CAR_INDICATION = 95;
    public static final int U_SET_SEARCH_CAR_INDICATION_VIEW = 101;
    public static final int U_SET_START_AUTO_LOCK = 112;
    public static final int U_SET_STEERING_FEEL = 94;
    public static final int U_SET_STOP_AUTO_UNLOCK = 111;
    public static final int U_SHOW_RADAR = 26;
    public static final int U_SHOW_TIRE_BACKUP = 58;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 69;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 29;
    public static final int U_TIRE_SHOW_STATE = 59;
    public static final int U_TPMS_STATE = 60;
    public static final int U_UNIT_CONSUMPTION = 54;
    public static final int U_UNIT_PRESSURE = 70;
    public static final int U_UNIT_TEMPERATURE = 52;
    public static final int U_UNIT_VOLUME = 53;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 67;
    public static final int U_UNLOCK_BY_SMART_DOOR = 68;
    public static final int U_VALID_VENTILATION_ENABLED = 33;
    public static final int U_WARNNING_CLEANNING_FLUID = 36;
    public static final int U_WARNNING_HANDLE_BRAKE = 37;
    public static final int U_WARNNING_LIFE_BELT = 35;
    public static final int U_WARNNING_LOW_BATTERY = 34;
    public static final int U_WARNNING_LOW_OIL = 32;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.sCanbusId == 131354) {
            DataCanbus.NOTIFY_EVENTS[99].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[100].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            AirHelper.getInstance().buildUi(new Air_0282_WC2_17MingJueRuiTeng(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0282_WC2_MingJueRuiTeng(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i4 = 23; i4 < 24; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
