package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0373_RZC_Jeep_ZhiNanZhe;
import com.syu.ui.air.Air_0373_RZC_XP1_ZiYouGuang;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0373_RZC_XP1_ZiYouGuang extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AIR_AC = 46;
    public static final int U_AIR_AUTO = 42;
    public static final int U_AIR_AUTO_REAR = 135;
    public static final int U_AIR_BEGIN = 41;
    public static final int U_AIR_BLOW_AUTO_LEFT = 58;
    public static final int U_AIR_BLOW_BODY_LEFT = 48;
    public static final int U_AIR_BLOW_BODY_REAR = 138;
    public static final int U_AIR_BLOW_FOOT_LEFT = 49;
    public static final int U_AIR_BLOW_FOOT_REAR = 139;
    public static final int U_AIR_BLOW_UP_LEFT = 50;
    public static final int U_AIR_CYCLE = 43;
    public static final int U_AIR_END = 60;
    public static final int U_AIR_FRONT_DEFROST = 44;
    public static final int U_AIR_LOCK_REAR = 137;
    public static final int U_AIR_MAXAC = 51;
    public static final int U_AIR_POWER = 56;
    public static final int U_AIR_POWER_REAR = 134;
    public static final int U_AIR_REAR_DEFROST = 45;
    public static final int U_AIR_SEAT_BLOW_LEFT = 111;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 112;
    public static final int U_AIR_SEAT_HEAT_LEFT = 53;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 54;
    public static final int U_AIR_STEER_HOT = 113;
    public static final int U_AIR_SYNC = 59;
    public static final int U_AIR_SYNC_REAR = 136;
    public static final int U_AIR_TEMP_LEFT = 47;
    public static final int U_AIR_TEMP_REAR = 141;
    public static final int U_AIR_TEMP_RIGHT = 55;
    public static final int U_AIR_TEMP_UNIT = 57;
    public static final int U_AIR_WIND_LEVEL_LEFT = 52;
    public static final int U_AIR_WIND_LEVEL_REAR = 140;
    public static final int U_AUTO_LOCK = 5;
    public static final int U_AUTO_PARK_BRAKE = 2;
    public static final int U_BLINDWARRING = 28;
    public static final int U_BRAKE_MODE = 20;
    public static final int U_CARCDENDI = 41;
    public static final int U_CARCDSTATE = 34;
    public static final int U_CARINFO_AUTO_ADJUST_SUSPENSION = 73;
    public static final int U_CARINFO_AUTO_LOCK_DRIVING = 69;
    public static final int U_CARINFO_BEEP_BY_LOCKED = 70;
    public static final int U_CARINFO_BEEP_WHEN_CAR_LOCKED = 85;
    public static final int U_CARINFO_BEGIN = 68;
    public static final int U_CARINFO_BUSY_POINT_ALARM = 68;
    public static final int U_CARINFO_DISPLAY_SUSOENSION_INFO = 74;
    public static final int U_CARINFO_ELECTRIC_TAILGATE_ALARM = 71;
    public static final int U_CARINFO_ELECTRONIC_PACK_BRAKE = 81;
    public static final int U_CARINFO_END = 89;
    public static final int U_CARINFO_HEADLEAP_SENSI = 86;
    public static final int U_CARINFO_INTER_ATMOSPHERE_LIGHT = 87;
    public static final int U_CARINFO_SEAT_FACILITATES_ACCESS = 72;
    public static final int U_CARINFO_TILT_REARVIEW_MIRROR_WHEN_REVERSING = 88;
    public static final int U_CARINFO_TIRE_JACKS = 75;
    public static final int U_CARINFO_TRANSPORT_MODE = 76;
    public static final int U_CARINFO_TURNING_LIGHT = 83;
    public static final int U_CARINFO_UNIT_OIL = 78;
    public static final int U_CARINFO_UNIT_TEMP = 80;
    public static final int U_CARINFO_UNIT_TPMS = 79;
    public static final int U_CARINFO_UNLOCK_TURN_LIGHT = 84;
    public static final int U_CARINFO_WELCOME_LIGHT = 82;
    public static final int U_CARINFO_WHEEL_ALIGNMENT_MODE = 77;
    public static final int U_CARSET_D07_D10_B3 = 150;
    public static final int U_CARSET_D07_D10_B7 = 149;
    public static final int U_CARSET_D07_D11_B7 = 151;
    public static final int U_CARSET_D07_D2_B4 = 142;
    public static final int U_CARSET_D07_D2_B5 = 143;
    public static final int U_CARSET_D07_D4_B21 = 146;
    public static final int U_CARSET_D07_D6_B10 = 148;
    public static final int U_CARSET_D07_D6_B4 = 147;
    public static final int U_CARSET_D07_D6_B6 = 144;
    public static final int U_CARSET_D60_D4_B70 = 145;
    public static final int U_CARSET_EQ_BAL = 126;
    public static final int U_CARSET_EQ_BASS = 128;
    public static final int U_CARSET_EQ_FAD = 127;
    public static final int U_CARSET_EQ_MID = 129;
    public static final int U_CARSET_EQ_ONOFF = 133;
    public static final int U_CARSET_EQ_SPEEDVOL = 131;
    public static final int U_CARSET_EQ_SURROUND = 132;
    public static final int U_CARSET_EQ_TREB = 130;
    public static final int U_CARSET_EQ_VOL = 125;
    public static final int U_CAR_PLAY_PROGRESS = 36;
    public static final int U_CAR_PLAY_STATE = 37;
    public static final int U_CAR_STRS_STATE_ONE = 40;
    public static final int U_CAR_TRACK_INFO = 38;
    public static final int U_CNT_MAX = 152;
    public static final int U_COMFORTSYSTENS = 14;
    public static final int U_COMPASSOFF = 16;
    public static final int U_COMPASSOFFSET = 17;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 3;
    public static final int U_DISPLAY_ENABLE_0 = 39;
    public static final int U_DOOR_BACK = 65;
    public static final int U_DOOR_BEGIN = 60;
    public static final int U_DOOR_END = 66;
    public static final int U_DOOR_ENGINE = 60;
    public static final int U_DOOR_FL = 61;
    public static final int U_DOOR_FR = 62;
    public static final int U_DOOR_RL = 63;
    public static final int U_DOOR_RR = 64;
    public static final int U_DORRWARRING = 31;
    public static final int U_FENGMINGQI = 67;
    public static final int U_FORMATSET = 18;
    public static final int U_FORWARDCOLLISIONWARN = 25;
    public static final int U_FORWARD_COLLISION = 21;
    public static final int U_FRONTPARKSENSEVOL = 12;
    public static final int U_GETOFF_AUTOLOCK = 6;
    public static final int U_HEADLIGHTS_OFF_DELAY = 8;
    public static final int U_HEADLIGHTS_ON_DELAY = 9;
    public static final int U_HILL_START_ASSIST = 1;
    public static final int U_KEYLESS_ENTRY = 7;
    public static final int U_LANEWAR = 26;
    public static final int U_LANGUAGESET = 19;
    public static final int U_LOCK_LIGHTS = 4;
    public static final int U_PARKSENSE = 11;
    public static final int U_PARKSENSE_BRAKEASSIST = 0;
    public static final int U_POWER_OFF_DELAY = 10;
    public static final int U_PRESSKEYUNLOCK = 15;
    public static final int U_RAINAUTOLIGHT = 29;
    public static final int U_REARPARKSENSEVOL = 13;
    public static final int U_REARVIEWMIRROR = 33;
    public static final int U_SEATAUTOHEAT = 32;
    public static final int U_SETTING_BEGIN = 0;
    public static final int U_SET_ANTI_COLLISON = 103;
    public static final int U_SET_AUTO_FOLD_REARVIEW = 122;
    public static final int U_SET_AUTO_PARK_BRAKE = 101;
    public static final int U_SET_AUTO_START_STOP = 109;
    public static final int U_SET_CURRENT_MODE = 115;
    public static final int U_SET_CURRENT_MODESTATE = 117;
    public static final int U_SET_ECO_MODE = 108;
    public static final int U_SET_ELC_BACKDOOR = 124;
    public static final int U_SET_KEY_REMOTE_WINDOW = 123;
    public static final int U_SET_LANE_DEPARTURE = 104;
    public static final int U_SET_LAUNCH_CONTROL = 114;
    public static final int U_SET_NON_SLIP = 106;
    public static final int U_SET_PARKVIEW_PARKIMAGE_DELAY = 98;
    public static final int U_SET_RADAR_ONOFF = 110;
    public static final int U_SET_REMOTESTART_SOUND = 100;
    public static final int U_SET_SERVER_MODE = 102;
    public static final int U_SET_SETTING_MODE = 116;
    public static final int U_SET_SHIFT_PADDLE = 120;
    public static final int U_SET_SPOT_MODE = 107;
    public static final int U_SET_STEER_MAIN = 105;
    public static final int U_SET_STEER_POWER = 119;
    public static final int U_SET_TIRE_SYS = 121;
    public static final int U_SET_TURNLIGHT_MOVE = 118;
    public static final int U_SET_TURN_ASSIST_LIGHT = 99;
    public static final int U_SET_UNIT_MILES = 96;
    public static final int U_SET_UNIT_OIL = 97;
    public static final int U_SYNC_LINE_GROUP_STR = 35;
    public static final int U_VIDEO_MOVE = 22;
    public static final int U_VIDEO_STATIC = 23;
    public static final int U_VIEW_AUTOLIGHT = 30;
    public static final int U_VIEW_LANEDEV = 27;
    public static final int U_VIEW_RAINAUTO = 24;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 60;
        DoorHelper.sUcDoorFl = 61;
        DoorHelper.sUcDoorFr = 62;
        DoorHelper.sUcDoorRl = 63;
        DoorHelper.sUcDoorRr = 64;
        DoorHelper.sUcDoorBack = 65;
        if (DataCanbus.DATA[1000] == 373 || DataCanbus.DATA[1000] == 65909 || DataCanbus.DATA[1000] == 1114485 || DataCanbus.DATA[1000] == 196981 || DataCanbus.DATA[1000] == 459125) {
            AirHelper.getInstance().buildUi(new Air_0373_RZC_XP1_ZiYouGuang(LauncherApplication.getInstance()));
            for (int i3 = 41; i3 < 60; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        } else {
            AirHelper.getInstance().buildUi(new Air_0373_RZC_Jeep_ZhiNanZhe(LauncherApplication.getInstance()));
            for (int i4 = 41; i4 < 60; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i5 = 60; i5 < 66; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 41; i < 60; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(AirHelper.SHOW_AND_REFRESH);
        for (int i2 = 60; i2 < 66; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 35:
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
            case 40:
                if (strs != null && strs.length > 0) {
                    current_playtime = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 152) {
                    HandlerCanbus.update(updateCode, ints);
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
                break;
        }
    }
}
