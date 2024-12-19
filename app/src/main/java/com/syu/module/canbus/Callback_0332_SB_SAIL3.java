package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0332_SB_SaiO3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0332_SB_SAIL3 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 44;
    public static final int U_AIR_ACMAX = 56;
    public static final int U_AIR_AUTO = 40;
    public static final int U_AIR_BEGIN = 39;
    public static final int U_AIR_BLOW_AUTO_LEFT = 55;
    public static final int U_AIR_BLOW_BODY_LEFT = 50;
    public static final int U_AIR_BLOW_FOOT_LEFT = 51;
    public static final int U_AIR_BLOW_UP_LEFT = 49;
    public static final int U_AIR_CYCLE = 41;
    public static final int U_AIR_ECO_ON = 54;
    public static final int U_AIR_END = 69;
    public static final int U_AIR_FRONT_DEFROST = 42;
    public static final int U_AIR_MAX_FRONT = 57;
    public static final int U_AIR_PARTITION_TEMP = 2;
    public static final int U_AIR_POWER_ON = 53;
    public static final int U_AIR_QUALITY_SENSOR = 1;
    public static final int U_AIR_REAR_BLOW_AUTO_LEFT = 65;
    public static final int U_AIR_REAR_BLOW_BODY_LEFT = 68;
    public static final int U_AIR_REAR_BLOW_FOOT_LEFT = 67;
    public static final int U_AIR_REAR_BLOW_UP_LEFT = 66;
    public static final int U_AIR_REAR_DEFROST = 43;
    public static final int U_AIR_REAR_TEMP = 63;
    public static final int U_AIR_REAR_WIND_LEVEL = 64;
    public static final int U_AIR_SEATBLOW_LEFT = 60;
    public static final int U_AIR_SEATBLOW_RIGHT = 61;
    public static final int U_AIR_SEAT_HEAT_LEFT = 45;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 46;
    public static final int U_AIR_START_MODE_SET = 6;
    public static final int U_AIR_STEER_HEAT = 62;
    public static final int U_AIR_SYNC = 58;
    public static final int U_AIR_TEMP_LEFT = 47;
    public static final int U_AIR_TEMP_RIGHT = 48;
    public static final int U_AIR_WIND_AUTO = 59;
    public static final int U_AIR_WIND_LEVEL_LEFT = 52;
    public static final int U_ANJIXING_PHONE_STATE = 33;
    public static final int U_ANJIXING_STATE = 34;
    public static final int U_AUTO_ACC_PROMPT = 79;
    public static final int U_AUTO_ANTI_CRASH = 80;
    public static final int U_AUTO_FRONT_GOFOG_ON = 4;
    public static final int U_AUTO_MIRROR_FOLDING = 26;
    public static final int U_AUTO_MODE_ZIDINGYI = 32;
    public static final int U_AUTO_REAR_GOFOG_ON = 3;
    public static final int U_AUTO_WIND_MODE = 0;
    public static final int U_AUTO_WIPERS = 27;
    public static final int U_AVERAGE_OIL_CONSUMPTION = 85;
    public static final int U_BLIND_SIDE = 37;
    public static final int U_CARINFO_CARTYPE = 90;
    public static final int U_CAR_CHANGE_LOAD_WARN = 21;
    public static final int U_CNT_MAX = 100;
    public static final int U_DELAY_TO_LOCK_SET = 12;
    public static final int U_DOOR_BACK = 75;
    public static final int U_DOOR_BEGIN = 70;
    public static final int U_DOOR_END = 76;
    public static final int U_DOOR_ENGINE = 70;
    public static final int U_DOOR_FL = 71;
    public static final int U_DOOR_FR = 72;
    public static final int U_DOOR_RL = 73;
    public static final int U_DOOR_RR = 74;
    public static final int U_EASY_EXIT_DRIVER_SEAT = 24;
    public static final int U_FORGET_KEY = 36;
    public static final int U_FUEL_MILEAGE = 87;
    public static final int U_INSTANT_OIL_CONSUMPTION = 86;
    public static final int U_LEARVER_CAR_LOCK = 28;
    public static final int U_LOOKING_FOR_LIGHT = 7;
    public static final int U_LUOSUO_DELAY_SET = 8;
    public static final int U_NEAR_CAR_UNLOCK = 35;
    public static final int U_PARKING_AUTO_UNLOCK = 11;
    public static final int U_PRESSURE_FL = 81;
    public static final int U_PRESSURE_FR = 82;
    public static final int U_PRESSURE_RL = 83;
    public static final int U_PRESSURE_RR = 84;
    public static final int U_PREVENT_AUTO_LUOSUO = 9;
    public static final int U_REAR_CAR_THROUGH_WARN = 22;
    public static final int U_REAR_WIPERS_AUTO_START = 16;
    public static final int U_REAR_ZOOM_AIR = 5;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 17;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK = 14;
    public static final int U_REMOTE_LOCK_SET = 15;
    public static final int U_REMOTE_START_CAR = 18;
    public static final int U_REMOTE_START_SEAT_AUTO_HOT = 20;
    public static final int U_REMOTE_START_SEAT_AUTO_TONFEGN = 19;
    public static final int U_REMOTE_UNLOCK_LIGHT_FEEDBACK = 13;
    public static final int U_REVERSE_TILT_MIRROR = 25;
    public static final int U_SET_AUTO_LOCK = 78;
    public static final int U_SET_REMOTE_AIR_POWER = 77;
    public static final int U_SPORT_MODE_4QUDONG = 31;
    public static final int U_SPORT_MODE_STEER = 29;
    public static final int U_SPORT_MODE_XUANGUA = 30;
    public static final int U_START_AUTO_LUOSUO = 10;
    public static final int U_TOTAL_MILEAGE = 88;
    public static final int U_USER_THE_REMEMENBER_LOCATION = 23;
    public static final int U_VOLTAGE = 89;
    public static final int U_ZHONGKONG_ENABLE = 38;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 100; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 70;
        DoorHelper.sUcDoorFl = 71;
        DoorHelper.sUcDoorFr = 72;
        DoorHelper.sUcDoorRl = 73;
        DoorHelper.sUcDoorRr = 74;
        DoorHelper.sUcDoorBack = 75;
        AirHelper.getInstance().buildUi(new Air_0332_SB_SaiO3(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 70; i2 < 76; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 39; i3 < 69; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 70; i < 76; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 39; i2 < 69; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 33:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 100) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
