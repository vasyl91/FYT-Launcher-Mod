package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0373_RZC_XP1_ZiYouGuang extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AUTO_LOCK = 103;
    public static final int U_AUTO_PARK_BRAKE = 100;
    public static final int U_BLINDWARRING = 126;
    public static final int U_BRAKE_MODE = 118;
    public static final int U_CARCDENDI = 139;
    public static final int U_CARCDSTATE = 132;
    public static final int U_CARINFO_AUTO_ADJUST_SUSPENSION = 146;
    public static final int U_CARINFO_AUTO_LOCK_DRIVING = 142;
    public static final int U_CARINFO_BEEP_BY_LOCKED = 143;
    public static final int U_CARINFO_BEEP_WHEN_CAR_LOCKED = 158;
    public static final int U_CARINFO_BEGIN = 141;
    public static final int U_CARINFO_BUSY_POINT_ALARM = 141;
    public static final int U_CARINFO_DISPLAY_SUSOENSION_INFO = 147;
    public static final int U_CARINFO_ELECTRIC_TAILGATE_ALARM = 144;
    public static final int U_CARINFO_ELECTRONIC_PACK_BRAKE = 154;
    public static final int U_CARINFO_END = 162;
    public static final int U_CARINFO_HEADLEAP_SENSI = 159;
    public static final int U_CARINFO_INTER_ATMOSPHERE_LIGHT = 160;
    public static final int U_CARINFO_SEAT_FACILITATES_ACCESS = 145;
    public static final int U_CARINFO_TILT_REARVIEW_MIRROR_WHEN_REVERSING = 161;
    public static final int U_CARINFO_TIRE_JACKS = 148;
    public static final int U_CARINFO_TRANSPORT_MODE = 149;
    public static final int U_CARINFO_TURNING_LIGHT = 156;
    public static final int U_CARINFO_UNIT_OIL = 151;
    public static final int U_CARINFO_UNIT_TEMP = 153;
    public static final int U_CARINFO_UNIT_TPMS = 152;
    public static final int U_CARINFO_UNLOCK_TURN_LIGHT = 157;
    public static final int U_CARINFO_WELCOME_LIGHT = 155;
    public static final int U_CARINFO_WHEEL_ALIGNMENT_MODE = 150;
    public static final int U_CARSET_D07_D10_B3 = 206;
    public static final int U_CARSET_D07_D10_B7 = 205;
    public static final int U_CARSET_D07_D11_B7 = 207;
    public static final int U_CARSET_D07_D2_B4 = 198;
    public static final int U_CARSET_D07_D2_B5 = 199;
    public static final int U_CARSET_D07_D4_B21 = 202;
    public static final int U_CARSET_D07_D6_B10 = 204;
    public static final int U_CARSET_D07_D6_B4 = 203;
    public static final int U_CARSET_D07_D6_B6 = 200;
    public static final int U_CARSET_D60_D4_B70 = 201;
    public static final int U_CARSET_D60_D5_B70 = 220;
    public static final int U_CARSET_D61_D0_B0 = 214;
    public static final int U_CARSET_D61_D0_B1 = 213;
    public static final int U_CARSET_D61_D0_B2 = 212;
    public static final int U_CARSET_D61_D0_B3 = 211;
    public static final int U_CARSET_D61_D0_B5 = 210;
    public static final int U_CARSET_D61_D0_B6 = 209;
    public static final int U_CARSET_D61_D0_B7 = 208;
    public static final int U_CARSET_D61_D1_B0 = 219;
    public static final int U_CARSET_D61_D1_B2 = 218;
    public static final int U_CARSET_D61_D1_B3 = 217;
    public static final int U_CARSET_D61_D1_B4 = 216;
    public static final int U_CARSET_D61_D1_B5 = 215;
    public static final int U_CARSET_D7D_TF0_D2_B70 = 221;
    public static final int U_CARSET_D7D_TF0_D3_B70 = 222;
    public static final int U_CARSET_D7D_TF0_D4_B70 = 223;
    public static final int U_CARSET_D7D_TF0_D5_B70 = 224;
    public static final int U_CARSET_D7D_TF0_D6_B70 = 225;
    public static final int U_CARSET_EQ_BAL = 190;
    public static final int U_CARSET_EQ_BASS = 192;
    public static final int U_CARSET_EQ_FAD = 191;
    public static final int U_CARSET_EQ_MID = 193;
    public static final int U_CARSET_EQ_ONOFF = 197;
    public static final int U_CARSET_EQ_SPEEDVOL = 195;
    public static final int U_CARSET_EQ_SURROUND = 196;
    public static final int U_CARSET_EQ_TREB = 194;
    public static final int U_CARSET_EQ_VOL = 189;
    public static final int U_CAR_PLAY_PROGRESS = 134;
    public static final int U_CAR_PLAY_STATE = 135;
    public static final int U_CAR_STRS_STATE_ONE = 138;
    public static final int U_CAR_TRACK_INFO = 136;
    public static final int U_CNT_MAX = 226;
    public static final int U_COMFORTSYSTENS = 112;
    public static final int U_COMPASSOFF = 114;
    public static final int U_COMPASSOFFSET = 115;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 101;
    public static final int U_DISPLAY_ENABLE_0 = 137;
    public static final int U_DORRWARRING = 129;
    public static final int U_FENGMINGQI = 140;
    public static final int U_FORMATSET = 116;
    public static final int U_FORWARDCOLLISIONWARN = 123;
    public static final int U_FORWARD_COLLISION = 119;
    public static final int U_FRONTPARKSENSEVOL = 110;
    public static final int U_GETOFF_AUTOLOCK = 104;
    public static final int U_HEADLIGHTS_OFF_DELAY = 106;
    public static final int U_HEADLIGHTS_ON_DELAY = 107;
    public static final int U_HILL_START_ASSIST = 99;
    public static final int U_KEYLESS_ENTRY = 105;
    public static final int U_LANEWAR = 124;
    public static final int U_LANGUAGESET = 117;
    public static final int U_LOCK_LIGHTS = 102;
    public static final int U_PARKSENSE = 109;
    public static final int U_PARKSENSE_BRAKEASSIST = 98;
    public static final int U_POWER_OFF_DELAY = 108;
    public static final int U_PRESSKEYUNLOCK = 113;
    public static final int U_RAINAUTOLIGHT = 127;
    public static final int U_REARPARKSENSEVOL = 111;
    public static final int U_REARVIEWMIRROR = 131;
    public static final int U_SEATAUTOHEAT = 130;
    public static final int U_SETTING_BEGIN = 98;
    public static final int U_SET_ANTI_COLLISON = 170;
    public static final int U_SET_AUTO_FOLD_REARVIEW = 186;
    public static final int U_SET_AUTO_PARK_BRAKE = 168;
    public static final int U_SET_AUTO_START_STOP = 176;
    public static final int U_SET_CURRENT_MODE = 179;
    public static final int U_SET_CURRENT_MODESTATE = 181;
    public static final int U_SET_ECO_MODE = 175;
    public static final int U_SET_ELC_BACKDOOR = 188;
    public static final int U_SET_KEY_REMOTE_WINDOW = 187;
    public static final int U_SET_LANE_DEPARTURE = 171;
    public static final int U_SET_LAUNCH_CONTROL = 178;
    public static final int U_SET_NON_SLIP = 173;
    public static final int U_SET_PARKVIEW_PARKIMAGE_DELAY = 165;
    public static final int U_SET_RADAR_ONOFF = 177;
    public static final int U_SET_REMOTESTART_SOUND = 167;
    public static final int U_SET_SERVER_MODE = 169;
    public static final int U_SET_SETTING_MODE = 180;
    public static final int U_SET_SHIFT_PADDLE = 184;
    public static final int U_SET_SPOT_MODE = 174;
    public static final int U_SET_STEER_MAIN = 172;
    public static final int U_SET_STEER_POWER = 183;
    public static final int U_SET_TIRE_SYS = 185;
    public static final int U_SET_TURNLIGHT_MOVE = 182;
    public static final int U_SET_TURN_ASSIST_LIGHT = 166;
    public static final int U_SET_UNIT_MILES = 163;
    public static final int U_SET_UNIT_OIL = 164;
    public static final int U_SYNC_LINE_GROUP_STR = 133;
    public static final int U_VIDEO_MOVE = 120;
    public static final int U_VIDEO_STATIC = 121;
    public static final int U_VIEW_AUTOLIGHT = 128;
    public static final int U_VIEW_LANEDEV = 125;
    public static final int U_VIEW_RAINAUTO = 122;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 226; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 373 || DataCanbus.DATA[1000] == 65909 || DataCanbus.DATA[1000] == 1114485 || DataCanbus.DATA[1000] == 2359669 || DataCanbus.DATA[1000] == 1311093 || DataCanbus.DATA[1000] == 1376629 || DataCanbus.DATA[1000] == 1835381 || DataCanbus.DATA[1000] == 1245557 || DataCanbus.DATA[1000] == 196981 || DataCanbus.DATA[1000] == 459125) {
            //AirHelper.getInstance().buildUi(new Air_0373_RZC_XP1_ZiYouGuang(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        } else {
            //AirHelper.getInstance().buildUi(new Air_0373_RZC_Jeep_ZhiNanZhe(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 0; i4 < 6; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(AirHelper.SHOW_AND_REFRESH);
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 133:
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
            case 138:
                if (strs != null && strs.length > 0) {
                    current_playtime = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 226) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
