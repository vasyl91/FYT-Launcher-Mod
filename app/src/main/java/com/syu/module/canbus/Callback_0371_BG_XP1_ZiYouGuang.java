package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0371_BG_XP1_ZiYouGuang;
import com.syu.ui.door.DoorHelper;
import com.syu.util.Print;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0371_BG_XP1_ZiYouGuang extends CallbackCanbusBase {
    public static final int C_AIR_CONTROL_CMD = 0;
    public static final int C_CAR_INFO_CD_CMD = 4;
    public static final int C_CAR_INFO_DAQIE_CMD = 1;
    public static final int C_CAR_INFO_ZIYOUGUANG_CMD = 2;
    public static final int C_CAR_INFO_ZIYOUGUANG_H_CMD = 3;
    public static final int C_CYT_AIR_CMD = 5;
    public static String Songname = null;
    public static final int U_AIR_AC = 43;
    public static final int U_AIR_AUTO = 39;
    public static final int U_AIR_BEGIN = 38;
    public static final int U_AIR_BLOW_AUTO_LEFT = 55;
    public static final int U_AIR_BLOW_BODY_LEFT = 45;
    public static final int U_AIR_BLOW_FOOT_LEFT = 46;
    public static final int U_AIR_BLOW_UP_LEFT = 47;
    public static final int U_AIR_CYCLE = 40;
    public static final int U_AIR_END = 58;
    public static final int U_AIR_FRONT_DEFROST = 41;
    public static final int U_AIR_MAXAC = 48;
    public static final int U_AIR_POWER = 53;
    public static final int U_AIR_REAR_DEFROST = 42;
    public static final int U_AIR_SEAT_BLOW_LEFT = 95;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 96;
    public static final int U_AIR_SEAT_HEAT_LEFT = 50;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 51;
    public static final int U_AIR_STEER_HOT = 97;
    public static final int U_AIR_SYNC = 56;
    public static final int U_AIR_TEMP_LEFT = 44;
    public static final int U_AIR_TEMP_RIGHT = 52;
    public static final int U_AIR_TEMP_UNIT = 54;
    public static final int U_AIR_WIND_LEVEL_LEFT = 49;
    public static final int U_AIR_WIND_MODE_LEFT = 57;
    public static final int U_AUTO_LOCK = 5;
    public static final int U_AUTO_PARK_BRAKE = 2;
    public static final int U_BLINDWARRING = 27;
    public static final int U_BRAKE_MODE = 19;
    public static final int U_CARCDENDI = 38;
    public static final int U_CARCDSTATE = 31;
    public static final int U_CARSET_07D00 = 69;
    public static final int U_CARSET_07D01 = 68;
    public static final int U_CARSET_07D02 = 67;
    public static final int U_CARSET_07D04 = 66;
    public static final int U_CARSET_07D06 = 65;
    public static final int U_CARSET_07D16 = 71;
    public static final int U_CARSET_07D17 = 70;
    public static final int U_CARSET_07D21 = 76;
    public static final int U_CARSET_07D22 = 75;
    public static final int U_CARSET_07D23 = 74;
    public static final int U_CARSET_07D24 = 73;
    public static final int U_CARSET_07D26 = 72;
    public static final int U_CARSET_07D30 = 83;
    public static final int U_CARSET_07D31 = 82;
    public static final int U_CARSET_07D32 = 80;
    public static final int U_CARSET_07D33 = 81;
    public static final int U_CARSET_07D34 = 79;
    public static final int U_CARSET_07D36 = 78;
    public static final int U_CARSET_07D37 = 77;
    public static final int U_CARSET_07D45 = 85;
    public static final int U_CARSET_07D47 = 84;
    public static final int U_CARSET_07D53 = 90;
    public static final int U_CARSET_07D54 = 89;
    public static final int U_CARSET_07D55 = 88;
    public static final int U_CARSET_07D56 = 87;
    public static final int U_CARSET_07D57 = 86;
    public static final int U_CARSET_07D65 = 93;
    public static final int U_CARSET_07D66 = 92;
    public static final int U_CARSET_07D67 = 91;
    public static final int U_CARSET_COMPASS = 94;
    public static final int U_CAR_PLAY_PROGRESS = 33;
    public static final int U_CAR_PLAY_STATE = 34;
    public static final int U_CAR_STRS_STATE_ONE = 37;
    public static final int U_CAR_TRACK_INFO = 35;
    public static final int U_CNT_MAX = 98;
    public static final int U_COMFORTSYSTENS = 14;
    public static final int U_COMPASSOFFSET = 16;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 3;
    public static final int U_DISPLAY_ENABLE_0 = 36;
    public static final int U_DOOR_BACK = 63;
    public static final int U_DOOR_BEGIN = 58;
    public static final int U_DOOR_END = 64;
    public static final int U_DOOR_ENGINE = 58;
    public static final int U_DOOR_FL = 59;
    public static final int U_DOOR_FR = 60;
    public static final int U_DOOR_RL = 61;
    public static final int U_DOOR_RR = 62;
    public static final int U_DORRWARRING = 30;
    public static final int U_FORMATSET = 17;
    public static final int U_FORWARDCOLLISIONWARN = 24;
    public static final int U_FORWARD_COLLISION = 20;
    public static final int U_FRONTPARKSENSEVOL = 12;
    public static final int U_GETOFF_AUTOLOCK = 6;
    public static final int U_HEADLIGHTS_OFF_DELAY = 8;
    public static final int U_HEADLIGHTS_ON_DELAY = 9;
    public static final int U_HILL_START_ASSIST = 1;
    public static final int U_KEYLESS_ENTRY = 7;
    public static final int U_LANEWAR = 25;
    public static final int U_LANGUAGESET = 18;
    public static final int U_LOCK_LIGHTS = 4;
    public static final int U_PARKSENSE = 11;
    public static final int U_PARKSENSE_BRAKEASSIST = 0;
    public static final int U_POWER_OFF_DELAY = 10;
    public static final int U_PRESSKEYUNLOCK = 15;
    public static final int U_RAINAUTOLIGHT = 28;
    public static final int U_REARPARKSENSEVOL = 13;
    public static final int U_SETTING_BEGIN = 0;
    public static final int U_SYNC_LINE_GROUP_STR = 32;
    public static final int U_VIDEO_MOVE = 21;
    public static final int U_VIDEO_STATIC = 22;
    public static final int U_VIEW_AUTOLIGHT = 29;
    public static final int U_VIEW_LANEDEV = 26;
    public static final int U_VIEW_RAINAUTO = 23;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 98; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 58;
        DoorHelper.sUcDoorFl = 59;
        DoorHelper.sUcDoorFr = 60;
        DoorHelper.sUcDoorRl = 61;
        DoorHelper.sUcDoorRr = 62;
        DoorHelper.sUcDoorBack = 63;
        AirHelper.getInstance().buildUi(new Air_0371_BG_XP1_ZiYouGuang(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 38; i2 < 58; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 58; i3 < 64; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 38; i < 58; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i2 = 58; i2 < 64; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 32:
                if (ints != null && ints.length >= 2) {
                    infoType = ints[0];
                    infoIndex = ints[1];
                }
                if (strs != null && strs.length > 0) {
                    Songname = strs[0];
                } else {
                    Songname = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            case 37:
                Print.log("LG", "371 updateCode=" + updateCode + " ints[0]=" + strs[0]);
                if (strs != null && strs.length > 0) {
                    current_playtime = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 98) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
