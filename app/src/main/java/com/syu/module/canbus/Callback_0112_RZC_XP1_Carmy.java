package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.camry2012.xp.ToyotaLexusActivityCarCD;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0112_XP1_Camry;
import com.syu.ui.air.Air_0112_zx_6606_toyota;
import com.syu.ui.air.Air_0112_zx_6606_yazhoulong;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0112_RZC_XP1_Carmy extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 6;
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int U_AIR_AC = 61;
    public static final int U_AIR_ACMAX = 214;
    public static final int U_AIR_AQS = 223;
    public static final int U_AIR_AUTO_REAR = 220;
    public static final int U_AIR_BEGIN = 59;
    public static final int U_AIR_BIG_WIND_LIGHT = 63;
    public static final int U_AIR_BLOW_BODY_LEFT = 68;
    public static final int U_AIR_BLOW_BODY_REAR = 218;
    public static final int U_AIR_BLOW_FOOT_LEFT = 69;
    public static final int U_AIR_BLOW_FOOT_REAR = 219;
    public static final int U_AIR_BLOW_MODE = 167;
    public static final int U_AIR_BLOW_MODE_RIGHT = 247;
    public static final int U_AIR_BLOW_UP_LEFT = 67;
    public static final int U_AIR_CLEAN = 163;
    public static final int U_AIR_CLEAN_FLOWER = 164;
    public static final int U_AIR_CLEAN_ICE = 165;
    public static final int U_AIR_CLEAR = 252;
    public static final int U_AIR_CLIMATE = 168;
    public static final int U_AIR_CYCLE = 62;
    public static final int U_AIR_DUAL = 65;
    public static final int U_AIR_ECO = 213;
    public static final int U_AIR_ECO_HEAT_COOL = 180;
    public static final int U_AIR_END = 73;
    public static final int U_AIR_FRONT_DEFROST = 169;
    public static final int U_AIR_FRONT_ONLY = 253;
    public static final int U_AIR_LITTLE_WIND_LIGHT = 64;
    public static final int U_AIR_MANUALL_REAR = 222;
    public static final int U_AIR_MAX = 66;
    public static final int U_AIR_NEWADD_BLOW_BODY_LEFT = 154;
    public static final int U_AIR_NEWADD_BLOW_BODY_RIGHT = 157;
    public static final int U_AIR_NEWADD_BLOW_FOOT_LEFT = 155;
    public static final int U_AIR_NEWADD_BLOW_FOOT_RIGHT = 158;
    public static final int U_AIR_NEWADD_BLOW_WIN_LEFT = 153;
    public static final int U_AIR_NEWADD_BLOW_WIN_RIGHT = 156;
    public static final int U_AIR_POWER = 60;
    public static final int U_AIR_POWER_REAR = 217;
    public static final int U_AIR_REAR_BLOW = 179;
    public static final int U_AIR_REAR_CTRL = 215;
    public static final int U_AIR_REAR_DEFROG = 152;
    public static final int U_AIR_SEAT_BLOW_LEFT = 202;
    public static final int U_AIR_SEAT_BLOW_LEFT_REAR = 250;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 203;
    public static final int U_AIR_SEAT_BLOW_RIGHT_REAR = 251;
    public static final int U_AIR_SEAT_HEAT_LEFT = 200;
    public static final int U_AIR_SEAT_HEAT_LEFT_REAR = 248;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 201;
    public static final int U_AIR_SEAT_HEAT_RIGHT_REAR = 249;
    public static final int U_AIR_SWING = 166;
    public static final int U_AIR_TEMP_LEFT = 71;
    public static final int U_AIR_TEMP_REAR = 216;
    public static final int U_AIR_TEMP_REAR_RIGHT = 246;
    public static final int U_AIR_TEMP_RIGHT = 72;
    public static final int U_AIR_TEMP_UNIT = 181;
    public static final int U_AIR_WIND_LEVEL_LEFT = 70;
    public static final int U_AIR_WIND_LEVEL_REAR = 221;
    public static final int U_CARAIR_AUTO_AC = 80;
    public static final int U_CARAIR_BLOW_EFFECTIVE = 81;
    public static final int U_CARCD_DISC1 = 224;
    public static final int U_CARCD_DISC2 = 225;
    public static final int U_CARCD_DISC3 = 226;
    public static final int U_CARCD_DISC4 = 227;
    public static final int U_CARCD_DISC5 = 228;
    public static final int U_CARCD_DISC6 = 229;
    public static final int U_CARCD_DISC_TYPE1 = 230;
    public static final int U_CARCD_DISC_TYPE2 = 231;
    public static final int U_CARCD_DISC_TYPE3 = 232;
    public static final int U_CARCD_DISC_TYPE4 = 233;
    public static final int U_CARCD_DISC_TYPE5 = 234;
    public static final int U_CARCD_DISC_TYPE6 = 235;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 171;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 176;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 175;
    public static final int U_CARINFO_DVD_ID = 170;
    public static final int U_CARINFO_DVD_PLAYTIME = 177;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 174;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 173;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 172;
    public static final int U_CARINFO_RADIO_BAND = 191;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 193;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 195;
    public static final int U_CARINFO_RADIO_FREQ = 192;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 194;
    public static final int U_CARINFO_SOURCE = 178;
    public static final int U_CARINFO_USB_CURRENT_TRACK = 207;
    public static final int U_CARINFO_USB_PLAYTIME = 208;
    public static final int U_CARINFO_USB_PLAY_MODE_RAND = 206;
    public static final int U_CARINFO_USB_PLAY_MODE_RPT = 205;
    public static final int U_CARINFO_USB_STATE = 204;
    public static final int U_CARINF_D26_D3_B10 = 210;
    public static final int U_CARINF_D52_D0_B64 = 211;
    public static final int U_CARINF_D52_D1_B30 = 197;
    public static final int U_CARINF_D52_D1_B64 = 196;
    public static final int U_CARINF_D52_D2_B74 = 182;
    public static final int U_CARINF_D52_D3_B30 = 199;
    public static final int U_CARINF_D52_D3_B74 = 198;
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
    public static final int U_CARSET_BACKCAR_DELAY = 236;
    public static final int U_CARSET_D50_B10 = 151;
    public static final int U_CARSET_D50_B32 = 150;
    public static final int U_CARSET_DF2_D04 = 238;
    public static final int U_CARSET_DF2_D05 = 239;
    public static final int U_CARSET_DF2_D07_D0_B70 = 240;
    public static final int U_CARSET_DF2_D07_D1_B70 = 241;
    public static final int U_CARSET_DF2_D07_D2_B70 = 242;
    public static final int U_CARSET_DF2_D07_D3_B70 = 243;
    public static final int U_CARSET_DF2_D07_D4_B70 = 244;
    public static final int U_CARSET_DF2_D08_D0_B70 = 245;
    public static final int U_CARSET_DOORLOCK = 237;
    public static final int U_CARSET_OIL_UNIT = 159;
    public static final int U_CAR_AIR_AUTOWIN = 149;
    public static final int U_CAR_EC_LEV = 147;
    public static final int U_CAR_LANGUAGE_SET = 148;
    public static final int U_CMR_NEW_ADD = 140;
    public static final int U_CNT_MAX = 255;
    public static final int U_DOOR_BACK = 78;
    public static final int U_DOOR_BEGIN = 73;
    public static final int U_DOOR_DRIVE_SIDE = 254;
    public static final int U_DOOR_END = 79;
    public static final int U_DOOR_ENGINE = 73;
    public static final int U_DOOR_FL = 74;
    public static final int U_DOOR_FR = 75;
    public static final int U_DOOR_RL = 76;
    public static final int U_DOOR_RR = 77;
    public static final int U_GPS_TIME_AUTO = 209;
    public static final int U_INFO_CAR_SEAT_AUTO = 212;
    public static final int U_MOTOR_COLOR_TYPE = 146;
    public static final int U_RADARR_FRONT_DISTANCE = 145;
    public static final int U_RADARR_ONOFF = 143;
    public static final int U_RADARR_VOL_LEV = 144;
    public static final int U_RADAR_REAR_DISTANCE = 142;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 255; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 73;
        DoorHelper.sUcDoorFl = 74;
        DoorHelper.sUcDoorFr = 75;
        DoorHelper.sUcDoorRl = 76;
        DoorHelper.sUcDoorRr = 77;
        DoorHelper.sUcDoorBack = 78;
        if (DataCanbus.DATA[1000] == 3211376 || DataCanbus.DATA[1000] == 3276912 || DataCanbus.DATA[1000] == 3342448 || DataCanbus.DATA[1000] == 3801200 || DataCanbus.DATA[1000] == 3670128) {
            AirHelper.getInstance().buildUi(new Air_0112_zx_6606_toyota(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 3735664) {
            AirHelper.getInstance().buildUi(new Air_0112_zx_6606_yazhoulong(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0112_XP1_Camry(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 73; i2 < 79; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 59; i3 < 73; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[152].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[203].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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

    private void showCotrolCD(int updateCode, int[] ints) {
        if (updateCode == 178) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 2 && !ToyotaLexusActivityCarCD.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.camry2012.xp.ToyotaLexusActivityCarCD");
            }
        }
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
                case 178:
                    break;
                case 195:
                    CHANNEL_FREQ_PRESET = ints;
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 255) {
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
