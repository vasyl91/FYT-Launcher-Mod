package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0397_BNR_Camry2013;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LUZ_Toyato_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 61;
    public static final int U_AIR_AQS = 122;
    public static final int U_AIR_AUTO = 64;
    public static final int U_AIR_AUTO_FRONT_DEFROST = 108;
    public static final int U_AIR_BACK_BLOW_AUTO = 115;
    public static final int U_AIR_BACK_BLOW_BODY = 113;
    public static final int U_AIR_BACK_BLOW_FOOT = 114;
    public static final int U_AIR_BACK_BLOW_WIND = 116;
    public static final int U_AIR_BACK_POWER = 111;
    public static final int U_AIR_BACK_TEMP = 110;
    public static final int U_AIR_BACK_TEMP_RIGHT = 118;
    public static final int U_AIR_BEGIN = 59;
    public static final int U_AIR_BIG_WIND_LIGHT = 63;
    public static final int U_AIR_BLOW_BODY_LEFT = 68;
    public static final int U_AIR_BLOW_FOOT_LEFT = 69;
    public static final int U_AIR_BLOW_MODE = 167;
    public static final int U_AIR_BLOW_UP_LEFT = 67;
    public static final int U_AIR_CLEAN = 163;
    public static final int U_AIR_CLEAN_FLOWER = 164;
    public static final int U_AIR_CLEAN_ICE = 165;
    public static final int U_AIR_CLEAR = 168;
    public static final int U_AIR_CYCLE = 62;
    public static final int U_AIR_DUAL = 65;
    public static final int U_AIR_END = 75;
    public static final int U_AIR_MAX = 66;
    public static final int U_AIR_POWER = 60;
    public static final int U_AIR_REAR_CTRL = 117;
    public static final int U_AIR_REAR_DEFROG = 73;
    public static final int U_AIR_REAR_LOCK = 109;
    public static final int U_AIR_SWING = 166;
    public static final int U_AIR_TEMP_LEFT = 71;
    public static final int U_AIR_TEMP_RIGHT = 72;
    public static final int U_AIR_TEMP_UNIT = 74;
    public static final int U_AIR_WIND_LEVEL_LEFT = 70;
    public static final int U_CARAIR_CTRL_TYPE = 199;
    public static final int U_CARAUX_CTRL_TYPE = 198;
    public static final int U_CARINFO_AUTO_RELOCK_TIME = 107;
    public static final int U_CARINFO_NEW_ADD = 102;
    public static final int U_CARINFO_NEW_ADD_END = 121;
    public static final int U_CARINF_EQ_ASL = 188;
    public static final int U_CARINF_EQ_BAL = 184;
    public static final int U_CARINF_EQ_BASS = 185;
    public static final int U_CARINF_EQ_FAD = 183;
    public static final int U_CARINF_EQ_MID = 187;
    public static final int U_CARINF_EQ_POS = 201;
    public static final int U_CARINF_EQ_SUROUND = 190;
    public static final int U_CARINF_EQ_TREB = 186;
    public static final int U_CARINF_EQ_VOL = 189;
    public static final int U_CARINF_SYSEQ_VOL = 191;
    public static final int U_CAR_ANDROID_UI_VOL = 200;
    public static final int U_CAR_BELT_STATE = 192;
    public static final int U_CAR_HANDBRAKE_STATE = 193;
    public static final int U_CAR_LIGHT_FAR = 194;
    public static final int U_CAR_REARSCREEN_LOCK = 203;
    public static final int U_CAR_SCREEN_H = 196;
    public static final int U_CAR_SCREEN_W = 195;
    public static final int U_CAR_SET_TYPE = 202;
    public static final int U_CAR_UI_VOL = 197;
    public static final int U_CMR_NEW_ADD = 140;
    public static final int U_CNT_MAX = 204;
    public static final int U_DOOR_BACK = 80;
    public static final int U_DOOR_BEGIN = 75;
    public static final int U_DOOR_END = 81;
    public static final int U_DOOR_ENGINE = 75;
    public static final int U_DOOR_FL = 76;
    public static final int U_DOOR_FR = 77;
    public static final int U_DOOR_RL = 78;
    public static final int U_DOOR_RR = 79;
    public static final int U_INFO_CAR_AIR_INOUT_SENSOR = 123;
    public static final int U_INFO_CAR_DRIVE_MILEAGE = 126;
    public static final int U_INFO_CAR_SEAT_AUTO = 124;
    public static final int U_INFO_CAR_TOTAL_MILEAGE = 125;
    public static final int U_MOTOR_COLOR_TYPE = 146;
    public static final int U_RADARR_FRONT_DISTANCE = 145;
    public static final int U_RADARR_ONOFF = 143;
    public static final int U_RADARR_VOL_LEV = 144;
    public static final int U_RADAR_REAR_DISTANCE = 142;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 204; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 75;
        DoorHelper.sUcDoorFl = 76;
        DoorHelper.sUcDoorFr = 77;
        DoorHelper.sUcDoorRl = 78;
        DoorHelper.sUcDoorRr = 79;
        DoorHelper.sUcDoorBack = 80;
        AirHelper.getInstance().buildUi(new Air_0397_BNR_Camry2013(LauncherApplication.getInstance()));
        for (int i2 = 59; i2 < 75; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i3 = 108; i3 < 121; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 75; i4 < 81; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 75; i < 81; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 59; i2 < 75; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 8:
                    TripOilExpand(updateCode, ints);
                    break;
                case 37:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 213) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void TripOilExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void LastMinuteOldExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
