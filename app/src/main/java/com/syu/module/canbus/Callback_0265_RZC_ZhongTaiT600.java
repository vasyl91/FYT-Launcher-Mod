package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
//import com.syu.ui.air.Air_0265_BNR_T600;
//import com.syu.ui.air.Air_0265_LUZ_T600;
//import com.syu.ui.air.Air_0265_RZC_Jili_Boyue;
//import com.syu.ui.air.Air_0265_RZC_ShangQiT60;
//import com.syu.ui.air.Air_0265_RZC_ZhongTaiDaMaiX5;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0265_RZC_ZhongTaiT600 extends CallbackCanbusBase {
    public static final int U_AIR_TYPE = 151;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 99;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 100;
    public static final int U_AUTOLOCK_BY_SPEED = 98;
    public static final int U_BACKLIGHT = 121;
    public static final int U_BATTERY_VOLTAGE = 113;
    public static final int U_BELT_LEFT = 136;
    public static final int U_BELT_RIGHT = 137;
    public static final int U_CARSET_D51_D1_B3 = 172;
    public static final int U_CARSET_D51_D3_B54 = 171;
    public static final int U_CARSET_D51_D3_B6 = 170;
    public static final int U_CARSET_D51_D3_B7 = 169;
    public static final int U_CAR_ACTIVE_YAW = 154;
    public static final int U_CAR_ALARM_DISTANCE = 155;
    public static final int U_CAR_ASSIST_TURN_BY_MOVING = 133;
    public static final int U_CAR_AUTO_BRAK = 156;
    public static final int U_CAR_BIGLIGHT_HEIGHT = 152;
    public static final int U_CAR_CAMERA_MODE = 118;
    public static final int U_CAR_COLLISION_WARNING = 157;
    public static final int U_CAR_DYNAMIC_RAILLINE = 129;
    public static final int U_CAR_ELEC_ASSISTMODE = 127;
    public static final int U_CAR_FISHEYE_CALIC = 130;
    public static final int U_CAR_INTELLIGENT_LIGHT = 153;
    public static final int U_CAR_LANG = 122;
    public static final int U_CAR_LOCK_CAR_AUTO_CLOSE_WINDOW = 123;
    public static final int U_CAR_LOCK_CAR_AUTO_TURNOFF_POSITONLIGHT = 124;
    public static final int U_CAR_LOCK_TURNOFF_UNLOCKCAR = 125;
    public static final int U_CAR_RADARWARINING_SOUND = 135;
    public static final int U_CAR_REMOTELOCK_RECALL = 126;
    public static final int U_CAR_RMODE_5S_DELAY = 131;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 119;
    public static final int U_CAR_SETALL = 134;
    public static final int U_CAR_SINGLEROAD_BACKCAR_VIDEO = 132;
    public static final int U_CAR_STATIC_RAILLINE = 128;
    public static final int U_CNT_MAX = 173;
    public static final int U_COME_HOME_WITH_ME = 158;
    public static final int U_DRIVING_AUTO_LOCK = 161;
    public static final int U_ENGINE_SPEED = 114;
    public static final int U_KEEP_LIGHTON_TIME = 160;
    public static final int U_KEY_UNLOCK = 165;
    public static final int U_LAST_OIL = 111;
    public static final int U_LOCK_FEEDBACK = 163;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 102;
    public static final int U_MISC_BEGIN = 97;
    public static final int U_MISC_END = 120;
    public static final int U_NOKEY_UNLOCK = 164;
    public static final int U_PARK_BESIDE_ROAD = 115;
    public static final int U_PARK_IN_CARPORT = 116;
    public static final int U_PM25_IN = 148;
    public static final int U_PM25_OUT = 149;
    public static final int U_PM25_VALUE = 147;
    public static final int U_PRESSURE_FL = 103;
    public static final int U_PRESSURE_FR = 104;
    public static final int U_PRESSURE_RL = 105;
    public static final int U_PRESSURE_RR = 106;
    public static final int U_RADAR_MUTE = 117;
    public static final int U_REARVIEW_AUTO = 166;
    public static final int U_REMOTE_2PRESS_UNLOCK = 101;
    public static final int U_SEEK_CAR_FEEDBACK = 159;
    public static final int U_SPEED_WARN = 167;
    public static final int U_SPEED_WARN_VALUE = 168;
    public static final int U_TIRE_FRONT_LEFT = 146;
    public static final int U_TIRE_FRONT_RIGHT = 145;
    public static final int U_TIRE_REAR_LEFT = 143;
    public static final int U_TIRE_REAR_RIGHT = 144;
    public static final int U_TIRE_SYS = 138;
    public static final int U_TIRE_WARN_FRONT_LEFT = 141;
    public static final int U_TIRE_WARN_FRONT_RIGHT = 142;
    public static final int U_TIRE_WARN_REAR_LEFT = 139;
    public static final int U_TIRE_WARN_REAR_RIGHT = 140;
    public static final int U_TURNOFF_AUTO_UNLOCK = 162;
    public static final int U_WARNNING_CLEANNING_FLUID = 110;
    public static final int U_WARNNING_HANDLE_BRAKE = 112;
    public static final int U_WARNNING_LIFE_BELT = 109;
    public static final int U_WARNNING_LOW_BATTERY = 108;
    public static final int U_WARNNING_LOW_OIL = 107;
    public static final int U_WARN_ZHONGTAI = 150;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 173; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 65801) {
            //AirHelper.getInstance().buildUi(new AIR_0265_RZC_ZhongTaiDaMaiX5(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 196873 || DataCanbus.DATA[1000] == 459017) {
            //AirHelper.getInstance().buildUi(new AIR_0265_RZC_Jili_Boyue(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 327945) {
            //AirHelper.getInstance().buildUi(new AIR_0265_LUZ_T600(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 393481) {
            //AirHelper.getInstance().buildUi(new AIR_0265_BNR_T600(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 590089 || DataCanbus.DATA[1000] == 655625 || DataCanbus.DATA[1000] == 721161 || DataCanbus.DATA[1000] == 852233 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 1310985 || DataCanbus.DATA[1000] == 983305 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            //AirHelper.getInstance().buildUi(new AIR_0265_RZC_ShangQiT60(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new AIR_0265_RZC_ZhongTaiDaMaiX5(LauncherApplication.getInstance()));
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 173) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
