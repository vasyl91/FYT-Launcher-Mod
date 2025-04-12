package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0025_XP1_GM_H extends CallbackCanbusBase {
    public static final int U_ADAPTIVE_FORWARD_LIGHT = 125;
    public static final int U_AIR_PARTITION_TEMP = 99;
    public static final int U_AIR_PARTITION_TEMP_ENABLE = 159;
    public static final int U_AIR_QUALITY_SENSOR = 98;
    public static final int U_AIR_QUALITY_SENSOR_ENABLE = 155;
    public static final int U_AIR_START_MODE_SET = 103;
    public static final int U_AIR_START_MODE_SET_ENABLE = 156;
    public static final int U_AIR_TEMP_OUT = 133;
    public static final int U_ANJIXING_PHONE_STATE = 115;
    public static final int U_ANJIXING_STATE = 116;
    public static final int U_AUTO_ANTICRASH_PREPARE = 185;
    public static final int U_AUTO_ANTICRASH_PREPARE_ENABLE = 186;
    public static final int U_AUTO_FRONT_GOFOG_ON = 101;
    public static final int U_AUTO_FRONT_GOFOG_ON_ENABEL = 157;
    public static final int U_AUTO_MEMORY_RECALL = 129;
    public static final int U_AUTO_MEMORY_RECALL_ENABLE = 166;
    public static final int U_AUTO_MIRROR_FOLDING = 126;
    public static final int U_AUTO_MIRROR_FOLDING_ENABLE = 169;
    public static final int U_AUTO_REAR_GOFOG_ON = 100;
    public static final int U_AUTO_REAR_GOFOG_ON_ENABLE = 158;
    public static final int U_AUTO_WIND_MODE = 97;
    public static final int U_AUTO_WIND_MODE_ENABLE = 154;
    public static final int U_AUTO_WIPERS = 121;
    public static final int U_AUTO_WIPERS_ENABLE = 170;
    public static final int U_BATTERY_VOLTAGE = 132;
    public static final int U_BLIND_SIDE = 122;
    public static final int U_BLIND_SIDE_ENABLE = 163;
    public static final int U_CARINFO_RESERVE = 114;
    public static final int U_CARINF_D68_D0_B70 = 187;
    public static final int U_CARINF_D68_D1_D2 = 188;
    public static final int U_CARINF_D68_D3_B70 = 189;
    public static final int U_CARINF_D68_D4_D5 = 190;
    public static final int U_CARINF_D68_D6_D7 = 191;
    public static final int U_CAR_CURRENT_SPEED = 130;
    public static final int U_CNT_MAX = 192;
    public static final int U_DELAY_TO_LOCK_SET = 109;
    public static final int U_DELAY_TO_LOCK_SET_ENABLE = 176;
    public static final int U_DRIVER_PERSONAL_SET = 119;
    public static final int U_DRIVER_PERSONAL_SET_ENABLE = 165;
    public static final int U_EASY_EXIT_DRIVER_SEAT = 128;
    public static final int U_EASY_EXIT_DRIVER_SEAT_ENABLE = 167;
    public static final int U_ENGINE_SPEED = 135;
    public static final int U_FOOT_BRAKE_INFO = 137;
    public static final int U_FORGET_KEY = 118;
    public static final int U_FORGET_KEY_ENABLE = 182;
    public static final int U_FRONT_LEFT_HIGH_WARN_INFO = 142;
    public static final int U_FRONT_LEFT_LOW_WARN_INFO = 143;
    public static final int U_FRONT_LEFT_PRESS = 138;
    public static final int U_FRONT_LEFT_WARN_INFO = 144;
    public static final int U_FRONT_RIGHT_HIGH_WARN_INFO = 145;
    public static final int U_FRONT_RIGHT_LOW_WARN_INFO = 146;
    public static final int U_FRONT_RIGHT_PRESS = 139;
    public static final int U_FRONT_RIGHT_WARN_INFO = 147;
    public static final int U_LEARVER_CAR_LOCK = 123;
    public static final int U_LEARVER_CAR_LOCK_ENABLE = 183;
    public static final int U_LEFT_OR_RIGHT_TRAFFIC = 124;
    public static final int U_LOOKING_FOR_LIGHT = 104;
    public static final int U_LOOKING_FOR_LIGHT_ENABLE = 171;
    public static final int U_LUOSUO_DELAY_SET = 105;
    public static final int U_LUOSUO_DELAY_SET_ENABLE = 172;
    public static final int U_NEAR_CAR_UNLOCK = 117;
    public static final int U_NEAR_CAR_UNLOCK_ENABLE = 181;
    public static final int U_PARKING_AID_ENABLE = 162;
    public static final int U_PARKING_AUTO_UNLOCK = 108;
    public static final int U_PARKING_AUTO_UNLOCK_ENABLE = 174;
    public static final int U_PREVENT_AUTO_LUOSUO = 106;
    public static final int U_PREVENT_AUTO_LUOSUO_ENABLE = 173;
    public static final int U_RADAR_SWITCH = 184;
    public static final int U_REAR_LEFT_HIGH_WARN_INFO = 148;
    public static final int U_REAR_LEFT_LOW_WARN_INFO = 149;
    public static final int U_REAR_LEFT_PRESS = 140;
    public static final int U_REAR_LEFT_WARN_INFO = 150;
    public static final int U_REAR_RIGHT_HIGH_WARN_INFO = 151;
    public static final int U_REAR_RIGHT_LOW_WARN_INFO = 152;
    public static final int U_REAR_RIGHT_PRESS = 141;
    public static final int U_REAR_RIGHT_WARN_INFO = 153;
    public static final int U_REAR_WIPERS_AUTO_START = 113;
    public static final int U_REAR_WIPERS_AUTO_START_ENABLE = 164;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 120;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR_ENABLE = 180;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK = 111;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK_ENABLE = 177;
    public static final int U_REMOTE_LOCK_SET = 112;
    public static final int U_REMOTE_LOCK_SET_ENABLE = 179;
    public static final int U_REMOTE_LUOSUO_FEEDBACK_ENABLE = 178;
    public static final int U_REMOTE_START_HEAT_SEAT = 102;
    public static final int U_REMOTE_START_HEAT_SEAT_ENABLE = 160;
    public static final int U_REMOTE_START_HEAT_WIND_ENABLE = 161;
    public static final int U_REMOTE_UNLOCK_LIGHT_FEEDBACK = 110;
    public static final int U_REVERSE_TILT_MIRROR = 127;
    public static final int U_REVERSE_TILT_MIRROR_ENABLE = 168;
    public static final int U_SHUNSHI_YOUHAO = 136;
    public static final int U_START_AUTO_LUOSUO = 107;
    public static final int U_START_AUTO_LUOSUO_ENABLE = 175;
    public static final int U_TOTAL_TRAVEL_MILES = 134;
    public static final int U_WARN_VOLUME = 131;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 192; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 2359321) {
            //AirHelper.getInstance().buildUi(new Air_0025_DJ_Saiou3(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0025_XP1_GM_H(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
            case 115:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 192) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
