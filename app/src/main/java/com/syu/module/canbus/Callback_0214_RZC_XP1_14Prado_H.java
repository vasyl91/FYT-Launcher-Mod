package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0020_XP1_Camry2013;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0214_RZC_XP1_14Prado_H extends CallbackCanbusBase {
    public static final int U_AIR_AC = 61;
    public static final int U_AIR_AUTO = 80;
    public static final int U_AIR_BEGIN = 59;
    public static final int U_AIR_BIG_WIND_LIGHT = 63;
    public static final int U_AIR_BLOW_BODY_LEFT = 68;
    public static final int U_AIR_BLOW_FOOT_LEFT = 69;
    public static final int U_AIR_BLOW_MODE = 167;
    public static final int U_AIR_BLOW_MODE_LEFT = 84;
    public static final int U_AIR_BLOW_UP_LEFT = 67;
    public static final int U_AIR_CLEAN = 163;
    public static final int U_AIR_CLEAN_FLOWER = 164;
    public static final int U_AIR_CLEAN_ICE = 165;
    public static final int U_AIR_CLIMATE = 168;
    public static final int U_AIR_CYCLE = 62;
    public static final int U_AIR_DUAL = 65;
    public static final int U_AIR_END = 73;
    public static final int U_AIR_FRONT_DEFROG = 81;
    public static final int U_AIR_FRONT_DEFROST = 169;
    public static final int U_AIR_LITTLE_WIND_LIGHT = 64;
    public static final int U_AIR_MAX = 66;
    public static final int U_AIR_NEWADD_BLOW_BODY_LEFT = 154;
    public static final int U_AIR_NEWADD_BLOW_BODY_RIGHT = 157;
    public static final int U_AIR_NEWADD_BLOW_FOOT_LEFT = 155;
    public static final int U_AIR_NEWADD_BLOW_FOOT_RIGHT = 158;
    public static final int U_AIR_NEWADD_BLOW_WIN_LEFT = 153;
    public static final int U_AIR_NEWADD_BLOW_WIN_RIGHT = 156;
    public static final int U_AIR_POWER = 60;
    public static final int U_AIR_REAR_DEFROG = 82;
    public static final int U_AIR_SWING = 166;
    public static final int U_AIR_TEMP_LEFT = 71;
    public static final int U_AIR_TEMP_RIGHT = 72;
    public static final int U_AIR_TEMP_UNIT = 83;
    public static final int U_AIR_WIND_LEVEL_LEFT = 70;
    public static final int U_CARINF_EQ_ASL = 188;
    public static final int U_CARINF_EQ_BAL = 184;
    public static final int U_CARINF_EQ_BASS = 185;
    public static final int U_CARINF_EQ_FAD = 183;
    public static final int U_CARINF_EQ_MID = 187;
    public static final int U_CARINF_EQ_SUROUND = 190;
    public static final int U_CARINF_EQ_TREB = 186;
    public static final int U_CARINF_EQ_VOL = 189;
    public static final int U_CARINF_EV_CUR = 161;
    public static final int U_CARINF_EV_MIL = 162;
    public static final int U_CARINF_EV_UNIT = 160;
    public static final int U_CARSET_D50_B10 = 151;
    public static final int U_CARSET_D50_B32 = 150;
    public static final int U_CARSET_OIL_UNIT = 159;
    public static final int U_CAR_AIR_AUTOWIN = 149;
    public static final int U_CAR_EC_LEV = 147;
    public static final int U_CAR_LANGUAGE_SET = 148;
    public static final int U_CMR_NEW_ADD = 140;
    public static final int U_CNT_MAX = 191;
    public static final int U_DOOR_BACK = 78;
    public static final int U_DOOR_BEGIN = 73;
    public static final int U_DOOR_END = 79;
    public static final int U_DOOR_ENGINE = 73;
    public static final int U_DOOR_FL = 74;
    public static final int U_DOOR_FR = 75;
    public static final int U_DOOR_RL = 76;
    public static final int U_DOOR_RR = 77;
    public static final int U_MOTOR_COLOR_TYPE = 146;
    public static final int U_RADARR_FRONT_DISTANCE = 145;
    public static final int U_RADARR_ONOFF = 143;
    public static final int U_RADARR_VOL_LEV = 144;
    public static final int U_RADAR_REAR_DISTANCE = 142;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 191; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 73;
        DoorHelper.sUcDoorFl = 74;
        DoorHelper.sUcDoorFr = 75;
        DoorHelper.sUcDoorRl = 76;
        DoorHelper.sUcDoorRr = 77;
        DoorHelper.sUcDoorBack = 78;
        AirHelper.getInstance().buildUi(new Air_0020_XP1_Camry2013(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 73; i2 < 79; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 59; i3 < 73; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 73; i < 79; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 59; i2 < 73; i2++) {
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
                    if (updateCode >= 0 && updateCode < 191) {
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
