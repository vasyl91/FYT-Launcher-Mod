package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0375_SBD_BenTengX80;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0375_SBD_WC1_ReservedCdBenTengX80 extends CallbackCanbusBase {
    public static String Str1 = null;
    public static String Str2 = null;
    public static String Str3 = null;
    public static String Str4 = null;
    public static String Str5 = null;
    public static String Str6 = null;
    public static final int U_2TIMES_KEY_UNLOCK = 51;
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 10;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 0;
    public static final int U_AIR_END = 12;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 7;
    public static final int U_AIR_WIND_LEVEL_LEFT = 11;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 38;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 44;
    public static final int U_AUTOLOCK_BY_SPEED = 42;
    public static final int U_AUTO_AC_ENABLED = 34;
    public static final int U_BATTERY_VOLTAGE = 66;
    public static final int U_CARINFO_START = 25;
    public static final int U_CAR_CURR_SOURCE = 70;
    public static final int U_CAR_MID_ENABLE = 71;
    public static final int U_CAR_PLAY_PROGRESS = 72;
    public static final int U_CAR_PLAY_STATE = 73;
    public static final int U_CAR_STRS_STATE_FIVE = 49;
    public static final int U_CAR_STRS_STATE_FOUR = 48;
    public static final int U_CAR_STRS_STATE_ONE = 43;
    public static final int U_CAR_STRS_STATE_THERE = 47;
    public static final int U_CAR_STRS_STATE_TWO = 46;
    public static final int U_CLOSE_BIGLAMP_TIME = 41;
    public static final int U_CLOSE_INSIDELAMP_TIME = 40;
    public static final int U_CNT_MAX = 75;
    public static final int U_CUR_OIL_EXPEND = 28;
    public static final int U_CUR_TRIP_OIL_EXPEND = 31;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 39;
    public static final int U_DISPLAY_ENABLE_0 = 27;
    public static final int U_DISPLAY_ENABLE_11 = 67;
    public static final int U_DISPLAY_ENABLE_16 = 74;
    public static final int U_DISPLAY_ENABLE_19 = 26;
    public static final int U_DRIVING_TIME = 30;
    public static final int U_FEEDBACK_LAMP_ENABLED = 33;
    public static final int U_LAST_OIL = 65;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 50;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 55;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 37;
    public static final int U_OPTIMAL_OIL_EXPEND = 29;
    public static final int U_PARK_BESIDE_ROAD = 68;
    public static final int U_PARK_IN_CARPORT = 69;
    public static final int U_PRESSURE_FL = 59;
    public static final int U_PRESSURE_FR = 60;
    public static final int U_RADAR_VOL = 57;
    public static final int U_REMOTE_2PRESS_UNLOCK = 45;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 36;
    public static final int U_SHOW_RADAR = 56;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 54;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 32;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 52;
    public static final int U_UNLOCK_BY_SMART_DOOR = 53;
    public static final int U_VALID_VENTILATION_ENABLED = 35;
    public static final int U_WARNNING_CLEANNING_FLUID = 63;
    public static final int U_WARNNING_HANDLE_BRAKE = 64;
    public static final int U_WARNNING_LIFE_BELT = 62;
    public static final int U_WARNNING_LOW_BATTERY = 61;
    public static final int U_WARNNING_LOW_OIL = 58;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 75; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carId != 3) {
            AirHelper.getInstance().buildUi(new Air_0375_SBD_BenTengX80(LauncherApplication.getInstance()));
            for (int i2 = 0; i2 < 12; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 12; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 43:
                if (strs != null && strs.length > 0) {
                    Str1 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 44:
            case 45:
            default:
                if (updateCode >= 0 && updateCode < 75) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
            case 46:
                if (strs != null && strs.length > 0) {
                    Str2 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 47:
                if (strs != null && strs.length > 0) {
                    Str3 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 48:
                if (strs != null && strs.length > 0) {
                    Str4 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 49:
                if (strs != null && strs.length > 0) {
                    Str5 = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
        }
    }
}
