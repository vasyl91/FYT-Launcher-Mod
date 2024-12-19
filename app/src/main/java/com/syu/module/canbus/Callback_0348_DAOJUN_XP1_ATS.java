package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0348_XP1_GM_H;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0348_DAOJUN_XP1_ATS extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 14;
    public static final int U_ACTIVATE_AUTOMATICLLY = 8;
    public static final int U_AIR = 2;
    public static final int U_AIR_AC = 93;
    public static final int U_AIR_AC_MAX = 94;
    public static final int U_AIR_AQS_ON = 108;
    public static final int U_AIR_AUTO = 88;
    public static final int U_AIR_BEGIN = 87;
    public static final int U_AIR_BLOW_AUTO_LEFT = 110;
    public static final int U_AIR_BLOW_BODY_LEFT = 100;
    public static final int U_AIR_BLOW_BODY_RIGHT = 104;
    public static final int U_AIR_BLOW_FOOT_LEFT = 101;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 105;
    public static final int U_AIR_BLOW_UP_LEFT = 99;
    public static final int U_AIR_BLOW_UP_RIGHT = 103;
    public static final int U_AIR_BLOW_WIND_LEFT = 111;
    public static final int U_AIR_BLOW_WIND_MODE = 112;
    public static final int U_AIR_CYCLE = 89;
    public static final int U_AIR_DUAL = 87;
    public static final int U_AIR_ECO_ON = 109;
    public static final int U_AIR_END = 114;
    public static final int U_AIR_FRONT_DEFROST = 91;
    public static final int U_AIR_POWER_ON = 107;
    public static final int U_AIR_REAR_DEFROST = 92;
    public static final int U_AIR_SEAT_HEAT_LEFT = 95;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 96;
    public static final int U_AIR_SHOW = 90;
    public static final int U_AIR_TEMP_LEFT = 97;
    public static final int U_AIR_TEMP_RIGHT = 98;
    public static final int U_AIR_WIND_LEVEL_LEFT = 102;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 106;
    public static final int U_ANJIXING_PHONE_STATE = 18;
    public static final int U_ANJIXING_STATE = 19;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 12;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 13;
    public static final int U_AUTOLOCK_BY_SPEED = 11;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 24;
    public static final int U_CNT_MAX = 122;
    public static final int U_CURRENT_SPEED = 35;
    public static final int U_CUR_OIL_EXPEND = 15;
    public static final int U_CUR_TRIP_OIL_EXPEND = 21;
    public static final int U_DISPLAY_ENABLE_0 = 38;
    public static final int U_DOOR_BACK = 119;
    public static final int U_DOOR_BEGIN = 114;
    public static final int U_DOOR_END = 120;
    public static final int U_DOOR_ENGINE = 114;
    public static final int U_DOOR_FL = 115;
    public static final int U_DOOR_FR = 116;
    public static final int U_DOOR_RL = 117;
    public static final int U_DOOR_RR = 118;
    public static final int U_DRIVER_ACC = 5;
    public static final int U_DRIVER_ALERT_SYSTEM = 7;
    public static final int U_DRIVER_LAST_DISTANCE_SELECTED = 6;
    public static final int U_DRIVING_MILEAGE = 16;
    public static final int U_DRIVING_TIME = 20;
    public static final int U_FRONT_VOL = 4;
    public static final int U_LIGHT_COMING_HOME = 28;
    public static final int U_LIGHT_LEAVING_HOME = 23;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 10;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 22;
    public static final int U_MIRROR_WIPERS_AUTO_WIPING_IN_RAIN = 36;
    public static final int U_MIRROR_WIPERS_SYN_ADJUST = 37;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 1;
    public static final int U_OPTIMAL_OIL_EXPEND = 17;
    public static final int U_RADAR_VOL = 29;
    public static final int U_REMOTE_2PRESS_UNLOCK = 9;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 0;
    public static final int U_SHOW_RADAR = 26;
    public static final int U_TEMP_UNIT = 113;
    public static final int U_TPMS = 3;
    public static final int U_UNIT_TEMPERATURE = 30;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 25;
    public static final int U_WARNNING_CLEANNING_FLUID = 33;
    public static final int U_WARNNING_HANDLE_BRAKE = 34;
    public static final int U_WARNNING_LIFE_BELT = 32;
    public static final int U_WARNNING_LOW_BATTERY = 31;
    public static final int U_WARNNING_LOW_OIL = 27;
    public static final int U_WIND = 121;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 114;
        DoorHelper.sUcDoorFl = 115;
        DoorHelper.sUcDoorFr = 116;
        DoorHelper.sUcDoorRl = 117;
        DoorHelper.sUcDoorRr = 118;
        DoorHelper.sUcDoorBack = 119;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 114; i2 < 120; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 87; i3 < 114; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0348_XP1_GM_H(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 114; i < 120; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 87; i2 < 114; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 18:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 122) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
