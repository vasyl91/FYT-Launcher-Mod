package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AIR_0265_BNR_T600;
import com.syu.ui.air.AIR_0265_LUZ_T600;
import com.syu.ui.air.AIR_0265_RZC_Jili_Boyue;
import com.syu.ui.air.AIR_0265_RZC_ShangQiT60;
import com.syu.ui.air.AIR_0265_RZC_ZhongTaiDaMaiX5;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0265_RZC_ZhongTaiT600 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 32;
    public static final int U_AIR_ACMAX = 47;
    public static final int U_AIR_AUTO = 44;
    public static final int U_AIR_BEGIN = 31;
    public static final int U_AIR_BLOW_AUTO = 92;
    public static final int U_AIR_BLOW_BODY_LEFT = 34;
    public static final int U_AIR_BLOW_FACE = 66;
    public static final int U_AIR_BLOW_FOOT_LEFT = 35;
    public static final int U_AIR_BLOW_MODE_LEFT = 46;
    public static final int U_AIR_BLOW_UP_LEFT = 36;
    public static final int U_AIR_CYCLE = 33;
    public static final int U_AIR_DUAL = 45;
    public static final int U_AIR_END = 49;
    public static final int U_AIR_FRONT_DEFROST = 40;
    public static final int U_AIR_ION = 48;
    public static final int U_AIR_POWER = 31;
    public static final int U_AIR_REAR_DEFROST = 41;
    public static final int U_AIR_SEATHEAT_LEFT = 68;
    public static final int U_AIR_SEATHEAT_RIGHT = 69;
    public static final int U_AIR_SHOW = 65;
    public static final int U_AIR_TEMP_LEFT = 42;
    public static final int U_AIR_TEMP_RIGHT = 39;
    public static final int U_AIR_TEMP_UNIT = 67;
    public static final int U_AIR_TEMP_UNIT_LEFT = 38;
    public static final int U_AIR_TEMP_UNIT_RIGHT = 43;
    public static final int U_AIR_TYPE = 85;
    public static final int U_AIR_WIND_LEVEL_AUTO = 93;
    public static final int U_AIR_WIND_LEVEL_LEFT = 37;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 2;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 3;
    public static final int U_AUTOLOCK_BY_SPEED = 1;
    public static final int U_BACKLIGHT = 50;
    public static final int U_BATTERY_VOLTAGE = 16;
    public static final int U_BELT_LEFT = 70;
    public static final int U_BELT_RIGHT = 71;
    public static final int U_CARSET_D51_D1_B3 = 108;
    public static final int U_CARSET_D51_D3_B54 = 107;
    public static final int U_CARSET_D51_D3_B6 = 106;
    public static final int U_CARSET_D51_D3_B7 = 105;
    public static final int U_CAR_ACTIVE_YAW = 88;
    public static final int U_CAR_ALARM_DISTANCE = 89;
    public static final int U_CAR_ASSIST_TURN_BY_MOVING = 62;
    public static final int U_CAR_AUTO_BRAK = 90;
    public static final int U_CAR_BIGLIGHT_HEIGHT = 86;
    public static final int U_CAR_CAMERA_MODE = 21;
    public static final int U_CAR_COLLISION_WARNING = 91;
    public static final int U_CAR_DYNAMIC_RAILLINE = 58;
    public static final int U_CAR_ELEC_ASSISTMODE = 56;
    public static final int U_CAR_FISHEYE_CALIC = 59;
    public static final int U_CAR_INTELLIGENT_LIGHT = 87;
    public static final int U_CAR_LANG = 51;
    public static final int U_CAR_LOCK_CAR_AUTO_CLOSE_WINDOW = 52;
    public static final int U_CAR_LOCK_CAR_AUTO_TURNOFF_POSITONLIGHT = 53;
    public static final int U_CAR_LOCK_TURNOFF_UNLOCKCAR = 54;
    public static final int U_CAR_RADARWARINING_SOUND = 64;
    public static final int U_CAR_REMOTELOCK_RECALL = 55;
    public static final int U_CAR_RMODE_5S_DELAY = 60;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 22;
    public static final int U_CAR_SETALL = 63;
    public static final int U_CAR_SINGLEROAD_BACKCAR_VIDEO = 61;
    public static final int U_CAR_STATIC_RAILLINE = 57;
    public static final int U_CNT_MAX = 109;
    public static final int U_COME_HOME_WITH_ME = 94;
    public static final int U_DOOR_BACK = 29;
    public static final int U_DOOR_BEGIN = 24;
    public static final int U_DOOR_END = 30;
    public static final int U_DOOR_ENGINE = 24;
    public static final int U_DOOR_FL = 25;
    public static final int U_DOOR_FR = 26;
    public static final int U_DOOR_RL = 27;
    public static final int U_DOOR_RR = 28;
    public static final int U_DRIVING_AUTO_LOCK = 97;
    public static final int U_ENGINE_SPEED = 17;
    public static final int U_KEEP_LIGHTON_TIME = 96;
    public static final int U_KEY_UNLOCK = 101;
    public static final int U_LAST_OIL = 14;
    public static final int U_LOCK_FEEDBACK = 99;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 5;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_MISC_END = 23;
    public static final int U_NOKEY_UNLOCK = 100;
    public static final int U_PARK_BESIDE_ROAD = 18;
    public static final int U_PARK_IN_CARPORT = 19;
    public static final int U_PM25_IN = 82;
    public static final int U_PM25_OUT = 83;
    public static final int U_PM25_VALUE = 81;
    public static final int U_PRESSURE_FL = 6;
    public static final int U_PRESSURE_FR = 7;
    public static final int U_PRESSURE_RL = 8;
    public static final int U_PRESSURE_RR = 9;
    public static final int U_RADAR_MUTE = 20;
    public static final int U_REARVIEW_AUTO = 102;
    public static final int U_REMOTE_2PRESS_UNLOCK = 4;
    public static final int U_SEEK_CAR_FEEDBACK = 95;
    public static final int U_SPEED_WARN = 103;
    public static final int U_SPEED_WARN_VALUE = 104;
    public static final int U_TIRE_FRONT_LEFT = 80;
    public static final int U_TIRE_FRONT_RIGHT = 79;
    public static final int U_TIRE_REAR_LEFT = 77;
    public static final int U_TIRE_REAR_RIGHT = 78;
    public static final int U_TIRE_SYS = 72;
    public static final int U_TIRE_WARN_FRONT_LEFT = 75;
    public static final int U_TIRE_WARN_FRONT_RIGHT = 76;
    public static final int U_TIRE_WARN_REAR_LEFT = 73;
    public static final int U_TIRE_WARN_REAR_RIGHT = 74;
    public static final int U_TURNOFF_AUTO_UNLOCK = 98;
    public static final int U_WARNNING_CLEANNING_FLUID = 13;
    public static final int U_WARNNING_HANDLE_BRAKE = 15;
    public static final int U_WARNNING_LIFE_BELT = 12;
    public static final int U_WARNNING_LOW_BATTERY = 11;
    public static final int U_WARNNING_LOW_OIL = 10;
    public static final int U_WARN_ZHONGTAI = 84;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 109; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 24;
        DoorHelper.sUcDoorFl = 25;
        DoorHelper.sUcDoorFr = 26;
        DoorHelper.sUcDoorRl = 27;
        DoorHelper.sUcDoorRr = 28;
        DoorHelper.sUcDoorBack = 29;
        if (DataCanbus.DATA[1000] == 65801) {
            AirHelper.getInstance().buildUi(new AIR_0265_RZC_ZhongTaiDaMaiX5(LauncherApplication.getInstance()));
            for (int i2 = 31; i2 < 49; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 196873 || DataCanbus.DATA[1000] == 459017) {
            AirHelper.getInstance().buildUi(new AIR_0265_RZC_Jili_Boyue(LauncherApplication.getInstance()));
            for (int i3 = 31; i3 < 49; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 327945) {
            AirHelper.getInstance().buildUi(new AIR_0265_LUZ_T600(LauncherApplication.getInstance()));
            for (int i4 = 31; i4 < 49; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i5 = 65; i5 <= 69; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 393481) {
            AirHelper.getInstance().buildUi(new AIR_0265_BNR_T600(LauncherApplication.getInstance()));
            for (int i6 = 31; i6 < 49; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i7 = 65; i7 <= 69; i7++) {
                DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 590089 || DataCanbus.DATA[1000] == 655625 || DataCanbus.DATA[1000] == 721161 || DataCanbus.DATA[1000] == 852233 || DataCanbus.DATA[1000] == 917769 || DataCanbus.DATA[1000] == 983305 || DataCanbus.DATA[1000] == 1048841 || DataCanbus.DATA[1000] == 1179913 || DataCanbus.DATA[1000] == 1245449) {
            AirHelper.getInstance().buildUi(new AIR_0265_RZC_ShangQiT60(LauncherApplication.getInstance()));
            for (int i8 = 31; i8 < 49; i8++) {
                DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            AirHelper.getInstance().buildUi(new AIR_0265_RZC_ZhongTaiDaMaiX5(LauncherApplication.getInstance()));
            for (int i9 = 31; i9 < 49; i9++) {
                DataCanbus.NOTIFY_EVENTS[i9].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i10 = 24; i10 < 30; i10++) {
            DataCanbus.NOTIFY_EVENTS[i10].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 24; i < 30; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
        for (int i2 = 31; i2 < 49; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 65; i3 <= 69; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 109) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
