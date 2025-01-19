package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0061_RZC_XP1_GM;
import com.syu.ui.door.DoorHelper;

public class Callback_0061_RZC_XP1_GM extends CallbackCanbusBase {
    public static final int U_AIR_PARTITION_TEMP = 100;
    public static final int U_AIR_QUALITY_SENSOR = 99;
    public static final int U_AIR_START_MODE_SET = 104;
    public static final int U_ANJIXING_PHONE_STATE = 118;
    public static final int U_ANJIXING_STATE = 119;
    public static final int U_AUTO_COLLISION = 127;
    public static final int U_AUTO_FRONT_GOFOG_ON = 102;
    public static final int U_AUTO_REAR_GOFOG_ON = 101;
    public static final int U_AUTO_WIND_MODE = 98;
    public static final int U_AUTO_WIPERS = 124;
    public static final int U_BLIND_SIDE = 125;
    public static final int U_CAREQ_D28_D0_B70 = 314;
    public static final int U_CAREQ_D28_D1_B70 = 315;
    public static final int U_CAREQ_D28_D2_B70 = 316;
    public static final int U_CAREQ_D28_D3_B70 = 317;
    public static final int U_CAREQ_D28_D4_B70 = 318;
    public static final int U_CAREQ_D28_D5_B70 = 319;
    public static final int U_CAREQ_D28_D6_B70 = 320;
    public static final int U_CARINFO_D50_T1_D10_D11 = 222;
    public static final int U_CARINFO_D50_T1_D12_B70 = 223;
    public static final int U_CARINFO_D50_T1_D13_D14 = 224;
    public static final int U_CARINFO_D50_T1_D15_D16 = 225;
    public static final int U_CARINFO_D50_T1_D1_D2 = 217;
    public static final int U_CARINFO_D50_T1_D3_D4 = 218;
    public static final int U_CARINFO_D50_T1_D5_D6 = 219;
    public static final int U_CARINFO_D50_T1_D7_B70 = 220;
    public static final int U_CARINFO_D50_T1_D8_D9 = 221;
    public static final int U_CARINFO_D50_T2_D1_B70 = 226;
    public static final int U_CARINFO_D50_T2_D2_B70 = 227;
    public static final int U_CARINFO_D50_T2_D3_B70 = 228;
    public static final int U_CARINFO_D50_T2_D4_B70 = 229;
    public static final int U_CARINFO_D51_T1_D1_B30 = 231;
    public static final int U_CARINFO_D51_T1_D1_B76 = 230;
    public static final int U_CARINFO_D51_T1_D2_B6 = 233;
    public static final int U_CARINFO_D51_T1_D2_B7 = 232;
    public static final int U_CARINFO_D51_T1_D3_D4 = 234;
    public static final int U_CARINFO_D51_T1_D5_B70 = 235;
    public static final int U_CARINFO_D51_T1_D6_B70 = 236;
    public static final int U_CARINFO_D51_T1_D7_B70 = 237;
    public static final int U_CARINFO_D51_T1_D8_B70 = 238;
    public static final int U_CARINFO_D51_T2_D1_B4 = 241;
    public static final int U_CARINFO_D51_T2_D1_B65 = 240;
    public static final int U_CARINFO_D51_T2_D1_B7 = 239;
    public static final int U_CARINFO_D51_T2_D2_D3 = 242;
    public static final int U_CARINFO_D51_T2_D4_D5 = 243;
    public static final int U_CARINFO_D51_T31_D10_B70 = 257;
    public static final int U_CARINFO_D51_T31_D11_B70 = 258;
    public static final int U_CARINFO_D51_T31_D12_B70 = 259;
    public static final int U_CARINFO_D51_T31_D13_B70 = 260;
    public static final int U_CARINFO_D51_T31_D14_B70 = 261;
    public static final int U_CARINFO_D51_T31_D2_B4 = 246;
    public static final int U_CARINFO_D51_T31_D2_B65 = 245;
    public static final int U_CARINFO_D51_T31_D2_B7 = 244;
    public static final int U_CARINFO_D51_T31_D3_B10 = 250;
    public static final int U_CARINFO_D51_T31_D3_B32 = 249;
    public static final int U_CARINFO_D51_T31_D3_B54 = 248;
    public static final int U_CARINFO_D51_T31_D3_B7 = 247;
    public static final int U_CARINFO_D51_T31_D4_B70 = 251;
    public static final int U_CARINFO_D51_T31_D5_B70 = 252;
    public static final int U_CARINFO_D51_T31_D6_B70 = 253;
    public static final int U_CARINFO_D51_T31_D7_B70 = 254;
    public static final int U_CARINFO_D51_T31_D8_B70 = 255;
    public static final int U_CARINFO_D51_T31_D9_B70 = 256;
    public static final int U_CARINFO_D51_T32_D2_D3 = 262;
    public static final int U_CARINFO_D51_T33_D2_D3 = 263;
    public static final int U_CARINFO_D51_T34_D2_D3 = 264;
    public static final int U_CARINFO_D51_T35_D2_D3 = 265;
    public static final int U_CARINFO_D51_T36_D2_D3 = 266;
    public static final int U_CARINFO_D51_T37_D2_D3 = 267;
    public static final int U_CARINFO_D51_T38_D2_D3 = 268;
    public static final int U_CARINFO_D51_T41_D10_B70 = 282;
    public static final int U_CARINFO_D51_T41_D11_B70 = 283;
    public static final int U_CARINFO_D51_T41_D12_B70 = 284;
    public static final int U_CARINFO_D51_T41_D13_B70 = 285;
    public static final int U_CARINFO_D51_T41_D14_B70 = 286;
    public static final int U_CARINFO_D51_T41_D2_B4 = 271;
    public static final int U_CARINFO_D51_T41_D2_B65 = 270;
    public static final int U_CARINFO_D51_T41_D2_B7 = 269;
    public static final int U_CARINFO_D51_T41_D3_B10 = 275;
    public static final int U_CARINFO_D51_T41_D3_B32 = 274;
    public static final int U_CARINFO_D51_T41_D3_B54 = 273;
    public static final int U_CARINFO_D51_T41_D3_B7 = 272;
    public static final int U_CARINFO_D51_T41_D4_B70 = 276;
    public static final int U_CARINFO_D51_T41_D5_B70 = 277;
    public static final int U_CARINFO_D51_T41_D6_B70 = 278;
    public static final int U_CARINFO_D51_T41_D7_B70 = 279;
    public static final int U_CARINFO_D51_T41_D8_B70 = 280;
    public static final int U_CARINFO_D51_T41_D9_B70 = 281;
    public static final int U_CARINFO_D51_T42_D2_D3 = 287;
    public static final int U_CARINFO_D51_T43_D2_D3 = 288;
    public static final int U_CARINFO_D51_T44_D2_D3 = 289;
    public static final int U_CARINFO_D51_T45_D2_D3 = 290;
    public static final int U_CARINFO_D51_T46_D2_D3 = 291;
    public static final int U_CARINFO_D51_T47_D2_D3 = 292;
    public static final int U_CARINFO_D51_T48_D2_D3 = 293;
    public static final int U_CARINFO_D51_T51_D10_B70 = 302;
    public static final int U_CARINFO_D51_T51_D11_B70 = 303;
    public static final int U_CARINFO_D51_T51_D12_B70 = 304;
    public static final int U_CARINFO_D51_T51_D13_B70 = 305;
    public static final int U_CARINFO_D51_T51_D14_B70 = 306;
    public static final int U_CARINFO_D51_T51_D2_B4 = 295;
    public static final int U_CARINFO_D51_T51_D2_B76 = 294;
    public static final int U_CARINFO_D51_T51_D4_B70 = 296;
    public static final int U_CARINFO_D51_T51_D5_B70 = 297;
    public static final int U_CARINFO_D51_T51_D6_B70 = 298;
    public static final int U_CARINFO_D51_T51_D7_B70 = 299;
    public static final int U_CARINFO_D51_T51_D8_B70 = 300;
    public static final int U_CARINFO_D51_T51_D9_B70 = 301;
    public static final int U_CARINFO_D51_T52_D2_D3 = 307;
    public static final int U_CARINFO_D51_T53_D2_D3 = 308;
    public static final int U_CARINFO_D51_T54_D2_D3 = 309;
    public static final int U_CARINFO_D51_T55_D2_D3 = 310;
    public static final int U_CARINFO_D51_T56_D2_D3 = 311;
    public static final int U_CARINFO_D51_T57_D2_D3 = 312;
    public static final int U_CARINFO_D51_T58_D2_D3 = 313;
    public static final int U_CARINFO_RESERVE = 117;
    public static final int U_CARINF_D05_D1_B4 = 163;
    public static final int U_CARINF_D05_D1_B5 = 162;
    public static final int U_CARINF_D06_D1_B0 = 164;
    public static final int U_CARINF_D0A_D1_B10 = 147;
    public static final int U_CARINF_D0A_D1_B2 = 146;
    public static final int U_CARINF_D0A_D1_B3 = 145;
    public static final int U_CARINF_D0A_D1_B4 = 144;
    public static final int U_CARINF_D0A_D2_B0 = 154;
    public static final int U_CARINF_D0A_D2_B1 = 153;
    public static final int U_CARINF_D0A_D2_B32 = 152;
    public static final int U_CARINF_D0A_D2_B4 = 151;
    public static final int U_CARINF_D0A_D2_B5 = 150;
    public static final int U_CARINF_D0A_D2_B6 = 149;
    public static final int U_CARINF_D0A_D2_B7 = 148;
    public static final int U_CARINF_D0A_D3_B10 = 161;
    public static final int U_CARINF_D0A_D3_B2 = 160;
    public static final int U_CARINF_D0A_D3_B3 = 159;
    public static final int U_CARINF_D0A_D3_B4 = 158;
    public static final int U_CARINF_D0A_D3_B5 = 157;
    public static final int U_CARINF_D0A_D3_B6 = 156;
    public static final int U_CARINF_D0A_D3_B7 = 155;
    public static final int U_CARINF_D0A_D4_B0 = 171;
    public static final int U_CARINF_D0A_D4_B1 = 170;
    public static final int U_CARINF_D0A_D4_B2 = 169;
    public static final int U_CARINF_D0A_D4_B3 = 168;
    public static final int U_CARINF_D0A_D4_B4 = 167;
    public static final int U_CARINF_D0A_D4_B65 = 166;
    public static final int U_CARINF_D0A_D4_B7 = 165;
    public static final int U_CARINF_D47_D0_B7 = 132;
    public static final int U_CARINF_D47_D1_B2 = 138;
    public static final int U_CARINF_D47_D1_B3 = 137;
    public static final int U_CARINF_D47_D1_B4 = 136;
    public static final int U_CARINF_D47_D1_B5 = 135;
    public static final int U_CARINF_D47_D1_B6 = 134;
    public static final int U_CARINF_D47_D1_B7 = 133;
    public static final int U_CARINF_D47_D2_B4 = 142;
    public static final int U_CARINF_D47_D2_B5 = 141;
    public static final int U_CARINF_D47_D2_B6 = 140;
    public static final int U_CARINF_D47_D2_B7 = 139;
    public static final int U_CARINF_D47_D3_B70 = 143;
    public static final int U_CARINF_D4A_D001_D1_B70 = 173;
    public static final int U_CARINF_D4A_D001_D2_B70 = 174;
    public static final int U_CARINF_D4A_D001_D3_B70 = 175;
    public static final int U_CARINF_D4A_D001_D4_B70 = 176;
    public static final int U_CARINF_D4A_D001_D5_B70 = 177;
    public static final int U_CARINF_D4A_D002_D1_D2 = 178;
    public static final int U_CARINF_D4A_D002_D3_D4 = 179;
    public static final int U_CARINF_D4A_D002_D5_D6 = 197;
    public static final int U_CARINF_D4A_D003_D10_D11_D12 = 189;
    public static final int U_CARINF_D4A_D003_D13_B70 = 190;
    public static final int U_CARINF_D4A_D003_D14_D15 = 191;
    public static final int U_CARINF_D4A_D003_D16_D17 = 192;
    public static final int U_CARINF_D4A_D003_D1_B32 = 184;
    public static final int U_CARINF_D4A_D003_D1_B4 = 183;
    public static final int U_CARINF_D4A_D003_D1_B5 = 182;
    public static final int U_CARINF_D4A_D003_D1_B6 = 181;
    public static final int U_CARINF_D4A_D003_D1_B7 = 180;
    public static final int U_CARINF_D4A_D003_D2_D3_D4 = 185;
    public static final int U_CARINF_D4A_D003_D5_B70 = 186;
    public static final int U_CARINF_D4A_D003_D6_D7 = 187;
    public static final int U_CARINF_D4A_D003_D8_D9 = 188;
    public static final int U_CARINF_D4A_D004_D1_B70 = 200;
    public static final int U_CARINF_D4A_D004_D2_B70 = 201;
    public static final int U_CARINF_D4A_D004_D3_B70 = 202;
    public static final int U_CARINF_D4A_D004_D4_D5 = 203;
    public static final int U_CARINF_D4A_D004_D6_D7 = 204;
    public static final int U_CARINF_D4A_D004_D8_B70 = 205;
    public static final int U_CARINF_D4A_D004_D9_B70 = 206;
    public static final int U_CARINF_D4B_CD_TXT = 196;
    public static final int U_CARINF_D4B_D00_B3 = 195;
    public static final int U_CARINF_D4B_D00_B64 = 194;
    public static final int U_CARINF_D4B_D00_B7 = 193;
    public static final int U_CARSET_D44_D0_B20 = 213;
    public static final int U_CARSET_D44_D0_B43 = 212;
    public static final int U_CARSET_D44_D0_B5 = 211;
    public static final int U_CARSET_D44_D0_B6 = 210;
    public static final int U_CARSET_D44_D0_B7 = 209;
    public static final int U_CARSET_D44_D1_B3 = 216;
    public static final int U_CARSET_D44_D1_B4 = 215;
    public static final int U_CARSET_D44_D1_B75 = 214;
    public static final int U_CARTIME_SET = 172;
    public static final int U_CAR_BUTTON_DOWN = 199;
    public static final int U_CAR_BUTTON_UP = 198;
    public static final int U_CAR_LANGUAGE = 131;
    public static final int U_CAR_STATUS = 128;
    public static final int U_CNT_MAX = 321;
    public static final int U_DELAY_TO_LOCK_SET = 110;
    public static final int U_DRIVER_PERSONAL_SET = 122;
    public static final int U_FORGET_KEY = 121;
    public static final int U_LEARVER_CAR_LOCK = 126;
    public static final int U_LOOKING_FOR_LIGHT = 105;
    public static final int U_LUOSUO_DELAY_SET = 106;
    public static final int U_NEAR_CAR_UNLOCK = 120;
    public static final int U_PARKING_AUTO_UNLOCK = 109;
    public static final int U_PREVENT_AUTO_LUOSUO = 107;
    public static final int U_RADAR_SWITCH = 130;
    public static final int U_REAR_WIPERS_AUTO_START = 114;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 123;
    public static final int U_REMOTE_AGAIN_LOCK_DOOR = 115;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK = 112;
    public static final int U_REMOTE_LOCK_SET = 113;
    public static final int U_REMOTE_START_CAR = 116;
    public static final int U_REMOTE_START_HEAT_SEAT = 103;
    public static final int U_REMOTE_UNLOCK_LIGHT_FEEDBACK = 111;
    public static final int U_START_AUTO_LUOSUO = 108;
    public static final int U_WARN_VOLUME = 129;
    public static final int U_WIFI_NAME = 207;
    public static final int U_WIFI_PSWORD = 208;
    public static String WifiName;
    public static String WifiPsword;
    public static String cdText;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 321; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0061_RZC_XP1_GM(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 118:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 196:
                if (strs != null && strs.length > 0) {
                    cdText = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 207:
                if (strs != null && strs.length > 0) {
                    WifiName = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 208:
                if (strs != null && strs.length > 0) {
                    WifiPsword = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 321) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
