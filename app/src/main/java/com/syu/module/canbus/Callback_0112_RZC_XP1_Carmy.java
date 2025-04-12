package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.camry2012.xp.ToyotaLexusActivityCarCD;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0112_RZC_XP1_Carmy extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 6;
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int U_CARAIR_AUTO_AC = 156;
    public static final int U_CARAIR_BLOW_EFFECTIVE = 157;
    public static final int U_CARCD_DISC1 = 208;
    public static final int U_CARCD_DISC2 = 209;
    public static final int U_CARCD_DISC3 = 210;
    public static final int U_CARCD_DISC4 = 211;
    public static final int U_CARCD_DISC5 = 212;
    public static final int U_CARCD_DISC6 = 213;
    public static final int U_CARCD_DISC_TYPE1 = 214;
    public static final int U_CARCD_DISC_TYPE2 = 215;
    public static final int U_CARCD_DISC_TYPE3 = 216;
    public static final int U_CARCD_DISC_TYPE4 = 217;
    public static final int U_CARCD_DISC_TYPE5 = 218;
    public static final int U_CARCD_DISC_TYPE6 = 219;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 174;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 179;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 178;
    public static final int U_CARINFO_DVD_ID = 173;
    public static final int U_CARINFO_DVD_PLAYTIME = 180;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 177;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 176;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 175;
    public static final int U_CARINFO_RADIO_BAND = 191;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 193;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 195;
    public static final int U_CARINFO_RADIO_FREQ = 192;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 194;
    public static final int U_CARINFO_SOURCE = 181;
    public static final int U_CARINFO_USB_CURRENT_TRACK = 203;
    public static final int U_CARINFO_USB_PLAYTIME = 204;
    public static final int U_CARINFO_USB_PLAY_MODE_RAND = 202;
    public static final int U_CARINFO_USB_PLAY_MODE_RPT = 201;
    public static final int U_CARINFO_USB_STATE = 200;
    public static final int U_CARINF_D26_D3_B10 = 206;
    public static final int U_CARINF_D26_D3_B4 = 273;
    public static final int U_CARINF_D26_D3_B5 = 272;
    public static final int U_CARINF_D52_D0_B64 = 207;
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
    public static final int U_CARINF_EV_CUR = 171;
    public static final int U_CARINF_EV_MIL = 172;
    public static final int U_CARINF_EV_UNIT = 170;
    public static final int U_CARSET_BACKCAR_DELAY = 220;
    public static final int U_CARSET_CJ_SET_VAL = 254;
    public static final int U_CARSET_D41_T80_D1_B70 = 255;
    public static final int U_CARSET_D41_T80_D2_B70 = 256;
    public static final int U_CARSET_D41_T80_D3_B70 = 257;
    public static final int U_CARSET_D41_T80_D4_B70 = 258;
    public static final int U_CARSET_D41_T80_D5_B70 = 259;
    public static final int U_CARSET_D41_T80_D6_B70 = 260;
    public static final int U_CARSET_D50_B10 = 168;
    public static final int U_CARSET_D50_B32 = 167;
    public static final int U_CARSET_D50_D2_B70 = 245;
    public static final int U_CARSET_D50_D3_B70 = 246;
    public static final int U_CARSET_D50_D4_B70 = 271;
    public static final int U_CARSET_D52_D4_B10 = 249;
    public static final int U_CARSET_D52_D4_B32 = 248;
    public static final int U_CARSET_D52_D4_B4 = 247;
    public static final int U_CARSET_D52_D5_B42 = 251;
    public static final int U_CARSET_D52_D5_B75 = 250;
    public static final int U_CARSET_D52_D6_B54 = 253;
    public static final int U_CARSET_D52_D6_B76 = 252;
    public static final int U_CARSET_D66_D2_B6 = 262;
    public static final int U_CARSET_D66_D2_B7 = 261;
    public static final int U_CARSET_DF2_D04 = 222;
    public static final int U_CARSET_DF2_D05 = 223;
    public static final int U_CARSET_DF2_D07_D0_B70 = 224;
    public static final int U_CARSET_DF2_D07_D1_B70 = 225;
    public static final int U_CARSET_DF2_D07_D2_B70 = 226;
    public static final int U_CARSET_DF2_D07_D3_B70 = 227;
    public static final int U_CARSET_DF2_D07_D4_B70 = 228;
    public static final int U_CARSET_DF2_D08_D0_B70 = 229;
    public static final int U_CARSET_DF2_D17_D0_B70 = 232;
    public static final int U_CARSET_DF2_D18_D0_B70 = 233;
    public static final int U_CARSET_DF2_D19_D0_B70 = 234;
    public static final int U_CARSET_DF2_D1A_D0_B70 = 235;
    public static final int U_CARSET_DF2_D1B_D0_B70 = 236;
    public static final int U_CARSET_DF2_D1B_D1_B70 = 237;
    public static final int U_CARSET_DF2_D1D_D0_B70 = 247;
    public static final int U_CARSET_DF2_D1E_D0_B70 = 240;
    public static final int U_CARSET_DF2_D1F_D0_B70 = 241;
    public static final int U_CARSET_DF2_D20_D0_B70 = 242;
    public static final int U_CARSET_DF2_D21_D0_B70 = 243;
    public static final int U_CARSET_DF2_D22_D0_B70 = 244;
    public static final int U_CARSET_DF2_D23_D0_B70 = 263;
    public static final int U_CARSET_DF2_D24_D0_B70 = 264;
    public static final int U_CARSET_DF2_D25_D0_B70 = 265;
    public static final int U_CARSET_DF2_D26_D0_B70 = 266;
    public static final int U_CARSET_DF2_D27_D0_B70 = 267;
    public static final int U_CARSET_DF2_D28_D0_B70 = 268;
    public static final int U_CARSET_DF2_D29_D0_B70 = 269;
    public static final int U_CARSET_DF2_D2A_D0_B70 = 270;
    public static final int U_CARSET_DOORLOCK = 221;
    public static final int U_CARSET_OIL_UNIT = 169;
    public static final int U_CAR_360_ONOFF = 239;
    public static final int U_CAR_AIR_AUTOWIN = 166;
    public static final int U_CAR_EC_LEV = 164;
    public static final int U_CAR_LANGUAGE_SET = 165;
    public static final int U_CMR_NEW_ADD = 158;
    public static final int U_CNT_MAX = 274;
    public static final int U_DOOR_DRIVE_SIDE = 230;
    public static final int U_GPS_TIME_AUTO = 205;
    public static final int U_MOTOR_COLOR_TYPE = 163;
    public static final int U_RADARR_FRONT_DISTANCE = 162;
    public static final int U_RADARR_ONOFF = 160;
    public static final int U_RADARR_VOL_LEV = 161;
    public static final int U_RADAR_REAR_DISTANCE = 159;
    public static final int U_STEER_BUTTON_SET = 231;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 274; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 3211376 || DataCanbus.DATA[1000] == 3276912 || DataCanbus.DATA[1000] == 3342448 || DataCanbus.DATA[1000] == 3801200 || DataCanbus.DATA[1000] == 4915312 || DataCanbus.DATA[1000] == 7274608 || DataCanbus.DATA[1000] == 3670128) {
            //AirHelper.getInstance().buildUi(new Air_0112_zx_6606_toyota(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 3735664) {
            //AirHelper.getInstance().buildUi(new Air_0112_zx_6606_yazhoulong(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0112_XP1_Camry(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[166].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showCotrolCD(int updateCode, int[] ints) {
        if (updateCode == 181) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 2 && !ToyotaLexusActivityCarCD.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.camry2012.xp.ToyotaLexusActivityCarCD");
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 105:
                    TripOilExpand(updateCode, ints);
                    break;
                case 134:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                case 181:
                    break;
                case 195:
                    CHANNEL_FREQ_PRESET = ints;
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 274) {
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
