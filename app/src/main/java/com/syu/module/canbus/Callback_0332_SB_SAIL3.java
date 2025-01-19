package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0332_SB_SaiO3;
import com.syu.ui.door.DoorHelper;

public class Callback_0332_SB_SAIL3 extends CallbackCanbusBase {
    public static final int U_AIR_PARTITION_TEMP = 99;
    public static final int U_AIR_QUALITY_SENSOR = 98;
    public static final int U_AIR_START_MODE_SET = 103;
    public static final int U_ANJIXING_PHONE_STATE = 130;
    public static final int U_ANJIXING_STATE = 131;
    public static final int U_AUTO_ACC_PROMPT = 138;
    public static final int U_AUTO_ANTI_CRASH = 139;
    public static final int U_AUTO_FRONT_GOFOG_ON = 101;
    public static final int U_AUTO_MIRROR_FOLDING = 123;
    public static final int U_AUTO_MODE_ZIDINGYI = 129;
    public static final int U_AUTO_REAR_GOFOG_ON = 100;
    public static final int U_AUTO_WIND_MODE = 97;
    public static final int U_AUTO_WIPERS = 124;
    public static final int U_AVERAGE_OIL_CONSUMPTION = 144;
    public static final int U_BLIND_SIDE = 134;
    public static final int U_CARINFO_CARTYPE = 149;
    public static final int U_CAR_CHANGE_LOAD_WARN = 118;
    public static final int U_CNT_MAX = 150;
    public static final int U_DELAY_TO_LOCK_SET = 109;
    public static final int U_EASY_EXIT_DRIVER_SEAT = 121;
    public static final int U_FORGET_KEY = 133;
    public static final int U_FUEL_MILEAGE = 146;
    public static final int U_INSTANT_OIL_CONSUMPTION = 145;
    public static final int U_LEARVER_CAR_LOCK = 125;
    public static final int U_LOOKING_FOR_LIGHT = 104;
    public static final int U_LUOSUO_DELAY_SET = 105;
    public static final int U_NEAR_CAR_UNLOCK = 132;
    public static final int U_PARKING_AUTO_UNLOCK = 108;
    public static final int U_PRESSURE_FL = 140;
    public static final int U_PRESSURE_FR = 141;
    public static final int U_PRESSURE_RL = 142;
    public static final int U_PRESSURE_RR = 143;
    public static final int U_PREVENT_AUTO_LUOSUO = 106;
    public static final int U_REAR_CAR_THROUGH_WARN = 119;
    public static final int U_REAR_WIPERS_AUTO_START = 113;
    public static final int U_REAR_ZOOM_AIR = 102;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 114;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK = 111;
    public static final int U_REMOTE_LOCK_SET = 112;
    public static final int U_REMOTE_START_CAR = 115;
    public static final int U_REMOTE_START_SEAT_AUTO_HOT = 117;
    public static final int U_REMOTE_START_SEAT_AUTO_TONFEGN = 116;
    public static final int U_REMOTE_UNLOCK_LIGHT_FEEDBACK = 110;
    public static final int U_REVERSE_TILT_MIRROR = 122;
    public static final int U_SET_AUTO_LOCK = 137;
    public static final int U_SET_REMOTE_AIR_POWER = 136;
    public static final int U_SPORT_MODE_4QUDONG = 128;
    public static final int U_SPORT_MODE_STEER = 126;
    public static final int U_SPORT_MODE_XUANGUA = 127;
    public static final int U_START_AUTO_LUOSUO = 107;
    public static final int U_TOTAL_MILEAGE = 147;
    public static final int U_USER_THE_REMEMENBER_LOCATION = 120;
    public static final int U_VOLTAGE = 148;
    public static final int U_ZHONGKONG_ENABLE = 135;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 150; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0332_SB_SaiO3(LauncherApplication.getInstance()));
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
        switch (updateCode) {
            case 130:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 150) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
