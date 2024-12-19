package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.carinfo.wc.gs4.GS4SOSAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0280_RZC_GS8;
import com.syu.ui.air.Air_0280_RZC_XP1_ChuangQiGs4;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0280_RZC_XP1_ChuanQiGS4 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 6;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 1;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 14;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_DEFROST = 4;
    public static final int U_AIR_ION = 73;
    public static final int U_AIR_MAX = 11;
    public static final int U_AIR_MAX_FRONT = 25;
    public static final int U_AIR_NEG_IONS = 64;
    public static final int U_AIR_POWER = 16;
    public static final int U_AIR_REAR_DEFROST = 5;
    public static final int U_AIR_SEAT_HEAT_LEFT = 27;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 28;
    public static final int U_AIR_TEMP_LEFT = 7;
    public static final int U_AIR_TEMP_RIGHT = 15;
    public static final int U_AIR_WARNING = 26;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 13;
    public static final int U_AIR_WIND_MODE = 24;
    public static final int U_CARINFO_BACKLIGHT = 23;
    public static final int U_CARINFO_SOS = 29;
    public static final int U_CARSET_ADD_AIR_SENSOR = 99;
    public static final int U_CARSET_ADD_AIR_WINLEV_AUTO = 100;
    public static final int U_CARSET_ADD_AUTO_LOCK = 91;
    public static final int U_CARSET_ADD_AUTO_UNLOCK = 92;
    public static final int U_CARSET_ADD_BEGIN = 89;
    public static final int U_CARSET_ADD_D52_D27 = 102;
    public static final int U_CARSET_ADD_D52_D28 = 103;
    public static final int U_CARSET_ADD_D52_D29 = 104;
    public static final int U_CARSET_ADD_D52_D2A = 105;
    public static final int U_CARSET_ADD_D52_D2B = 106;
    public static final int U_CARSET_ADD_D52_D2C = 107;
    public static final int U_CARSET_ADD_D52_D2D = 108;
    public static final int U_CARSET_ADD_D52_D2E = 109;
    public static final int U_CARSET_ADD_D52_D2F = 110;
    public static final int U_CARSET_ADD_D52_D30 = 111;
    public static final int U_CARSET_ADD_D52_D31 = 112;
    public static final int U_CARSET_ADD_D52_D32 = 113;
    public static final int U_CARSET_ADD_D52_D33 = 114;
    public static final int U_CARSET_ADD_D52_D34 = 117;
    public static final int U_CARSET_ADD_LEFT_LINE = 97;
    public static final int U_CARSET_ADD_LIGHT_COLOR = 98;
    public static final int U_CARSET_ADD_LOCK_BEEP = 90;
    public static final int U_CARSET_ADD_REARVIEW_AUTO = 94;
    public static final int U_CARSET_ADD_REARVIEW_HAND = 93;
    public static final int U_CARSET_ADD_RIGHT_LINE = 96;
    public static final int U_CARSET_ADD_WELCOME_AUTO = 95;
    public static final int U_CARSET_RIGHT_ENTER_CAMERA = 101;
    public static final int U_CAR_AIR_AUTO_STATE = 68;
    public static final int U_CAR_AIR_CYCLE_STATE = 44;
    public static final int U_CAR_AIR_SOFT_SET = 45;
    public static final int U_CAR_CHARGING_REPEAT = 76;
    public static final int U_CAR_CHARGING_REPEAT_1 = 77;
    public static final int U_CAR_CHARGING_REPEAT_2 = 78;
    public static final int U_CAR_CHARGING_REPEAT_3 = 79;
    public static final int U_CAR_CHARGING_REPEAT_4 = 80;
    public static final int U_CAR_CHARGING_REPEAT_5 = 81;
    public static final int U_CAR_CHARGING_REPEAT_6 = 82;
    public static final int U_CAR_CHARGING_REPEAT_7 = 83;
    public static final int U_CAR_CHARGING_TIMETOSTART = 84;
    public static final int U_CAR_CHARGING_TIME_END = 75;
    public static final int U_CAR_CHARGING_TIME_START = 74;
    public static final int U_CAR_DRIVE_AUTO_UNLOCK = 55;
    public static final int U_CAR_DRIVE_METER_ALARM_VOLUME = 49;
    public static final int U_CAR_DRIVE_OVER_SPEED = 48;
    public static final int U_CAR_DRIVE_RAINBRUSH_MAINTAIN = 57;
    public static final int U_CAR_DRIVE_REAR_RAINBRUSH_AUTO_BRUSH = 58;
    public static final int U_CAR_DRIVE_REMOTE_LEFT_TOP_WINDOW = 56;
    public static final int U_CAR_DRIVE_REMOTE_POWERON_TIME = 50;
    public static final int U_CAR_DRIVE_REMOTE_START_TIME = 51;
    public static final int U_CAR_DRIVE_REMOTE_UNLOCK = 53;
    public static final int U_CAR_DRIVE_SPEED_LOCKUP = 54;
    public static final int U_CAR_DRIVE_TURN_MODE = 52;
    public static final int U_CAR_ELECTRICITY_FLOW = 85;
    public static final int U_CAR_ENERGY_CYCLE_LEV = 87;
    public static final int U_CAR_ENERGY_D54_D9_B52 = 116;
    public static final int U_CAR_ENERGY_D54_D9_B6 = 115;
    public static final int U_CAR_ENERGY_FLOW = 86;
    public static final int U_CAR_ENERGY_IPEDAL = 88;
    public static final int U_CAR_LANG = 43;
    public static final int U_CAR_LEFT_LINE = 71;
    public static final int U_CAR_LIGHT_AUTOLIGHT_SENSE = 63;
    public static final int U_CAR_LIGHT_DAYLIGHT = 62;
    public static final int U_CAR_LIGHT_FROGLIGHT_TURN = 61;
    public static final int U_CAR_LIGHT_HOME_WITH_ME = 60;
    public static final int U_CAR_LIGHT_WELCOME = 72;
    public static final int U_CAR_REAR_MIRROR_FOLD = 67;
    public static final int U_CAR_RIGHT_LINE = 71;
    public static final int U_CAR_RMIRROR_AUTO = 70;
    public static final int U_CAR_RMIRROR_MANUAL = 69;
    public static final int U_CAR_SEAT_AUTOHEAT_LEFT = 46;
    public static final int U_CAR_SEAT_AUTOHEAT_RIGHT = 47;
    public static final int U_CAR_SMART_KEY = 66;
    public static final int U_CAR_TRACK_INFO = 0;
    public static final int U_CAR_WELLCOME = 65;
    public static final int U_CNT_MAX = 118;
    public static final int U_CUR_SPEED = 41;
    public static final int U_DOOR_BACK = 22;
    public static final int U_DOOR_BEGIN = 17;
    public static final int U_DOOR_END = 23;
    public static final int U_DOOR_ENGINE = 17;
    public static final int U_DOOR_FL = 18;
    public static final int U_DOOR_FR = 19;
    public static final int U_DOOR_RL = 20;
    public static final int U_DOOR_RR = 21;
    public static final int U_ENGINE_SPEED = 42;
    public static final int U_GS8AIR_3ZONE = 31;
    public static final int U_GS8AIR_BEGIN = 30;
    public static final int U_GS8AIR_END = 38;
    public static final int U_GS8AIR_REAR = 32;
    public static final int U_GS8AIR_REARBLOW_FOOT = 33;
    public static final int U_GS8AIR_REARBLOW_HEAD = 34;
    public static final int U_GS8AIR_REAR_AUTO = 35;
    public static final int U_GS8AIR_REAR_TEMP = 37;
    public static final int U_GS8AIR_REAR_WIND_LEVEL = 36;
    public static final int U_SMART_LOCK = 39;
    public static final int U_SMART_UNLOCK = 40;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 118; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 17;
        DoorHelper.sUcDoorFl = 18;
        DoorHelper.sUcDoorFr = 19;
        DoorHelper.sUcDoorRl = 20;
        DoorHelper.sUcDoorRr = 21;
        DoorHelper.sUcDoorBack = 22;
        if (DataCanbus.carId == 4 || DataCanbus.carId == 7 || DataCanbus.carId == 20 || DataCanbus.carId == 8) {
            AirHelper.getInstance().buildUi(new Air_0280_RZC_GS8(LauncherApplication.getInstance()));
            for (int i3 = 30; i3 < 38; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            AirHelper.getInstance().buildUi(new Air_0280_RZC_XP1_ChuangQiGs4(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 17; i4 < 23; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i5 = 1; i5 < 17; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void showSoS(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int value = ints[0];
        if ((value == 1 || value == 2) && !GS4SOSAct.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.gs4.GS4SOSAct");
        } else if (GS4SOSAct.mIsFront && value == 0 && GS4SOSAct.mIsFront && GS4SOSAct.mInstance != null) {
            GS4SOSAct.mInstance.finish();
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 17; i < 23; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 1; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        if (DataCanbus.carId == 4) {
            for (int i3 = 30; i3 < 38; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 118) {
            switch (updateCode) {
                case 29:
                    showSoS(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
