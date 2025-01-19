package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0282_WC2_17MingJueRuiTeng;
//import com.syu.ui.air.Air_0282_WC2_MingJueRuiTeng;
import com.syu.ui.door.DoorHelper;

public class Callback_0282_WC2_MingJueRuiTeng extends CallbackCanbusBase {
    public static final int U_17MINGJUE_END = 181;
    public static final int U_17MINGJUE_START = 171;
    public static final int U_2TIMES_KEY_UNLOCK = 139;
    public static final int U_AIR_AUTOMODE_BLOW_VALUE = 175;
    public static final int U_AIR_AUTOMODE_BLOW_VALUE_VIEW = 178;
    public static final int U_AIR_DUAL_TEMP_VALUE = 176;
    public static final int U_AIR_DUAL_TEMP_VALUE_VIEW = 179;
    public static final int U_AIR_REARFROST_FOG_VLAUE = 177;
    public static final int U_AIR_REARFROST_FOG_VLAUE_VIEW = 180;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 135;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 136;
    public static final int U_AUTOLOCK_BY_SPEED = 134;
    public static final int U_AUTO_AC_ENABLED = 104;
    public static final int U_BATTERY_VOLTAGE = 112;
    public static final int U_CAR_BT_STATE = 152;
    public static final int U_CAR_CAMERA_MODE = 151;
    public static final int U_CAR_CURR_SOURCE = 158;
    public static final int U_CAR_PLAY_PROGRESS = 148;
    public static final int U_CAR_PLAY_STATE = 149;
    public static final int U_CAR_RIGHTCAMERA_STATE = 157;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 101;
    public static final int U_CLOSE_BIGLAMP_TIME = 117;
    public static final int U_CLOSE_INSIDELAMP_TIME = 116;
    public static final int U_CNT_MAX = 187;
    public static final int U_CUR_OIL_EXPEND = 153;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 115;
    public static final int U_DRIVER_ACC = 161;
    public static final int U_DRIVING_MILEAGE = 154;
    public static final int U_DRIVING_TIME = 156;
    public static final int U_ENGINE_SPEED = 119;
    public static final int U_ESC_SYSTEM = 124;
    public static final int U_EXIST_TPMS = 130;
    public static final int U_FEEDBACK_LAMP_ENABLED = 103;
    public static final int U_LAST_OIL = 111;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 138;
    public static final int U_MIRROR_WIPERS_AUTO_WIPING_IN_RAIN = 160;
    public static final int U_MIRROR_WIPERS_FOLDIN_WHEN_PARKED = 165;
    public static final int U_MIRROR_WIPERS_LOW_WHILE_REVESING = 166;
    public static final int U_MIRROR_WIPERS_REAR_WIN_WIPING_IN_RESERVE = 159;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 170;
    public static final int U_MUTIL_SPEED_WARNNING = 123;
    public static final int U_OIL_MARK_MAX = 144;
    public static final int U_OIL_PROGRESS = 145;
    public static final int U_OIL_UNIT = 146;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 114;
    public static final int U_OPEN_CLOSE_AUTO_LOCK = 164;
    public static final int U_OPEN_CLOSE_CONVENIENCE = 162;
    public static final int U_OPEN_CLOSE_DOOR_UNLOCK = 163;
    public static final int U_OPTIMAL_OIL_EXPEND = 155;
    public static final int U_PARK_BESIDE_ROAD = 120;
    public static final int U_PARK_IN_CARPORT = 147;
    public static final int U_PRESSURE_BACKUP = 129;
    public static final int U_PRESSURE_FL = 118;
    public static final int U_PRESSURE_FR = 121;
    public static final int U_PRESSURE_RL = 122;
    public static final int U_PRESSURE_RR = 128;
    public static final int U_RADAR_MUTE = 150;
    public static final int U_RADAR_VOL = 100;
    public static final int U_REMOTE_2PRESS_UNLOCK = 137;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 113;
    public static final int U_SET_BEEP_ONOFF = 185;
    public static final int U_SET_COME_HOME_WITH_ME = 169;
    public static final int U_SET_COME_HOME_WITH_ME_VIEW = 174;
    public static final int U_SET_LIGHT_HOME_TIME = 182;
    public static final int U_SET_SEARCH_CAR_INDICATION = 168;
    public static final int U_SET_SEARCH_CAR_INDICATION_VIEW = 173;
    public static final int U_SET_START_AUTO_LOCK = 184;
    public static final int U_SET_STEERING_FEEL = 167;
    public static final int U_SET_STOP_AUTO_UNLOCK = 183;
    public static final int U_SHOW_RADAR = 99;
    public static final int U_SHOW_TIRE_BACKUP = 131;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 142;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 102;
    public static final int U_TIRE_SHOW_STATE = 132;
    public static final int U_TPMS_STATE = 133;
    public static final int U_UNIT_CONSUMPTION = 127;
    public static final int U_UNIT_PRESSURE = 143;
    public static final int U_UNIT_TEMPERATURE = 125;
    public static final int U_UNIT_VOLUME = 126;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 140;
    public static final int U_UNLOCK_BY_SMART_DOOR = 141;
    public static final int U_VALID_VENTILATION_ENABLED = 106;
    public static final int U_VALUE_TEMP_INTER = 186;
    public static final int U_WARNNING_CLEANNING_FLUID = 109;
    public static final int U_WARNNING_HANDLE_BRAKE = 110;
    public static final int U_WARNNING_LIFE_BELT = 108;
    public static final int U_WARNNING_LOW_BATTERY = 107;
    public static final int U_WARNNING_LOW_OIL = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 187; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.sCanbusId == 131354) {
            //AirHelper.getInstance().buildUi(new Air_0282_WC2_17MingJueRuiTeng(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0282_WC2_MingJueRuiTeng(LauncherApplication.getInstance()));
        }
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
        if (updateCode >= 0 && updateCode < 187) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
