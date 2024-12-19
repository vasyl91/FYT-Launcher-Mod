package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0379_BNR_GM;
import com.syu.ui.air.Air_0379_HC_GL6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0379_BNR_XP1_GM extends CallbackCanbusBase {
    public static final int CAR_AIR_CONTROL_2 = 10;
    public static final int CYCLE_AUTO = 2;
    public static final int CYCLE_INNER_MANUAL = 1;
    public static final int CYCLE_OUTER = 0;
    public static final int TEMP_HIGH = -3;
    public static final int TEMP_LOW = -2;
    public static final int TEMP_NONE = -1;
    public static final int U_ACC_PROMPT = 138;
    public static final int U_AIR_AC = 93;
    public static final int U_AIR_AC_AUTO = 152;
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
    public static final int U_AIR_CYCLE = 89;
    public static final int U_AIR_DUAL = 87;
    public static final int U_AIR_ECO_ON = 109;
    public static final int U_AIR_END = 113;
    public static final int U_AIR_FRONT_DEFROST = 91;
    public static final int U_AIR_POWER_ON = 107;
    public static final int U_AIR_REAR_BLOW_AUTO = 129;
    public static final int U_AIR_REAR_BLOW_BODY = 130;
    public static final int U_AIR_REAR_BLOW_FOOT = 131;
    public static final int U_AIR_REAR_BLOW_MODE = 132;
    public static final int U_AIR_REAR_DEFROST = 92;
    public static final int U_AIR_REAR_TEMP = 128;
    public static final int U_AIR_REAR_WINDLEVEL = 133;
    public static final int U_AIR_REAR_WINDLEVEL_AUTO = 134;
    public static final int U_AIR_SEAT_HEAT_LEFT = 95;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 96;
    public static final int U_AIR_SHOW = 90;
    public static final int U_AIR_TEMP_LEFT = 97;
    public static final int U_AIR_TEMP_RIGHT = 98;
    public static final int U_AIR_WIND_LEVEL = 112;
    public static final int U_AIR_WIND_LEVEL_SEAT_LEFT = 102;
    public static final int U_AIR_WIND_LEVEL_SEAT_RIGHT = 106;
    public static final int U_AUTO_ANTICRASH_PREPARE = 124;
    public static final int U_CAR_STATE_PROMPT = 127;
    public static final int U_CNT_MAX = 153;
    public static final int U_CRASH_REMINDER_TYPE = 140;
    public static final int U_DETECT_WALKER = 141;
    public static final int U_DOOR_BACK = 119;
    public static final int U_DOOR_BEGIN = 114;
    public static final int U_DOOR_END = 120;
    public static final int U_DOOR_ENGINE = 114;
    public static final int U_DOOR_FL = 115;
    public static final int U_DOOR_FR = 116;
    public static final int U_DOOR_RL = 117;
    public static final int U_DOOR_RR = 118;
    public static final int U_GETOFF_OPTIONS = 143;
    public static final int U_LANE_CHANGE_WARN = 142;
    public static final int U_RADAR_SWITCH = 150;
    public static final int U_RAMP_START_ASSIST = 125;
    public static final int U_REAR_CAR_PASSING_WARN = 144;
    public static final int U_REAR_SEAT_REMINDER = 139;
    public static final int U_REMOTE_AIR_POWER = 135;
    public static final int U_REMOTE_DOORWINDOW = 126;
    public static final int U_REMOTE_REAR_AIR_POWER = 136;
    public static final int U_REMOTE_REAR_DEFROG_POWER_MODE = 137;
    public static final int U_REMOTE_START_COLD_SEAT = 123;
    public static final int U_REMOTE_START_HEAT_SEAT_WeiLang = 122;
    public static final int U_SPARE_TIRE_EXIST = 147;
    public static final int U_SPARE_TIRE_PRESS = 149;
    public static final int U_TIRE_EXIST = 146;
    public static final int U_TIRE_UNIT = 148;
    public static final int U_WIFI_PASSWORD = 145;
    public static final int U_WIND = 121;
    public static final int U_WIND_LEVEL_LEFT_AUTO = 151;
    final int SYS_START_VER = 0;
    final int CAR_AIR_CONTROL = 1;
    final int CAR_COMM_CONTROL = 3;
    final int CAR_RADAR_CTL = 4;
    final int CAR_ON_START_CTL = 5;
    final int CAR_ON_START_CALL = 6;
    final int CAR_WARNN_VOL = 7;
    final int REQUEST_CAR_INFO = 8;
    final int CAR_NAVI_STATE = 9;
    final int C_CAR_LANGUAGE_SETUP = 96;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 153; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 114;
        DoorHelper.sUcDoorFl = 115;
        DoorHelper.sUcDoorFr = 116;
        DoorHelper.sUcDoorRl = 117;
        DoorHelper.sUcDoorRr = 118;
        DoorHelper.sUcDoorBack = 119;
        if (DataCanbus.DATA[1000] == 2294139) {
            AirHelper.getInstance().buildUi(new Air_0379_HC_GL6(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0379_BNR_GM(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 114; i2 < 120; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 87; i3 < 113; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[151].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        for (int i4 = 128; i4 < 135; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 114; i < 120; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 87; i2 < 113; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 128; i3 < 135; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(AirHelper.SHOW_AND_REFRESH);
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
                if (updateCode >= 0 && updateCode < 153) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
