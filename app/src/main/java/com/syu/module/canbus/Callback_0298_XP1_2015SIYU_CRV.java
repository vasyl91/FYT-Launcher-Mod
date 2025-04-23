package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.benzair.Air_BenzHelper;
import com.syu.ui.benzair.Air_RZC_23Yage;
import com.syu.ui.door.DoorHelper;

public class Callback_0298_XP1_2015SIYU_CRV extends CallbackCanbusBase {
    public static String Caridstr = null;
    public static final int U_CAMERAMODE_DRIVING = 211;
    public static final int U_CAMERA_APANORAMA_EXIT = 206;
    public static final int U_CAMERA_AUTO_OPEN_TUNK = 210;
    public static final int U_CAMERA_BACK_PARKMODE = 215;
    public static final int U_CAMERA_CROSSROADS_MONITOR = 216;
    public static final int U_CAMERA_FRONTORLR_VIEW = 207;
    public static final int U_CAMERA_LOWSPEED_START = 213;
    public static final int U_CAMERA_PARKING_ASSISTANCE = 209;
    public static final int U_CAMERA_PRE_PARKMODE = 214;
    public static final int U_CAMERA_REAR_VIEW = 208;
    public static final int U_CAMERA_START_REARVIEW = 212;
    public static final int U_CARINFO_ACC_DISCOVERY_VEHICLE_IN_FRONT_TONE = 144;
    public static final int U_CARINFO_ADJUST_ALARM_VOLUME = 135;
    public static final int U_CARINFO_AUTO_DOOR_LOCK = 129;
    public static final int U_CARINFO_AUTO_DOOR_UNLOCK = 128;
    public static final int U_CARINFO_AUTO_HEADLIGHT_WIPER = 141;
    public static final int U_CARINFO_AUTO_INTER_ILLUMINATION = 134;
    public static final int U_CARINFO_AUTO_LIGHT_SENSITIVITY = 122;
    public static final int U_CARINFO_AWD_INFO = 194;
    public static final int U_CARINFO_BACK_CAR_BEEP_TONE = 153;
    public static final int U_CARINFO_BEGIN = 118;
    public static final int U_CARINFO_DOOR_UNLOCK_MODE = 132;
    public static final int U_CARINFO_DRIVER_WATCH_MONITOR = 192;
    public static final int U_CARINFO_DRIVING_POSITION_REMORY = 156;
    public static final int U_CARINFO_DYNAMIC_LINE = 200;
    public static final int U_CARINFO_ELE_DOOR_OPEN_AUTO_OR_MANULE = 155;
    public static final int U_CARINFO_ELE_DOOR_REMOTE_OPEN_CONDITION = 154;
    public static final int U_CARINFO_ENERGY_SAVE_AUTO_ENGHINE = 143;
    public static final int U_CARINFO_FUEL_EFFIC_BACKLIGHT = 136;
    public static final int U_CARINFO_HEADLIGHT_AUTO_OFF_TIME = 123;
    public static final int U_CARINFO_INOUT_SEAT_SPORT = 157;
    public static final int U_CARINFO_INTERIOR_LIGHT_DIMMING_TIME = 124;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEP = 130;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEPVOL = 152;
    public static final int U_CARINFO_KEYLESS_ACCESS_LIGHT_FLASH = 133;
    public static final int U_CARINFO_KEY_AND_REMOTE_UNLOCK_MODE = 126;
    public static final int U_CARINFO_KEY_LOCK_ANSWER = 125;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE = 181;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE_PN_UNIT = 180;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE_UNIT = 179;
    public static final int U_CARINFO_MEMORY_SEAT = 197;
    public static final int U_CARINFO_MINOR_LANE_DEPARTURE_SYS_SETTINGS = 147;
    public static final int U_CARINFO_MULTI_FUNCTION = 205;
    public static final int U_CARINFO_NEW_MSG_NOTIF = 137;
    public static final int U_CARINFO_OUT_TEMP_SHOW = 121;
    public static final int U_CARINFO_PANORAMIC_IMAGE = 204;
    public static final int U_CARINFO_PARK_SPACE = 202;
    public static final int U_CARINFO_PAUSE_LKAS_TONE = 145;
    public static final int U_CARINFO_PILAO_DRIVER = 193;
    public static final int U_CARINFO_REMAIN_EC = 218;
    public static final int U_CARINFO_REMINDER_SYSTEM = 203;
    public static final int U_CARINFO_REMOTE_START_SYS = 131;
    public static final int U_CARINFO_RISE_WARNING = 196;
    public static final int U_CARINFO_SEAT_BELT = 198;
    public static final int U_CARINFO_SECURITY_RELOCK_TIME = 127;
    public static final int U_CARINFO_SET_FRONT_HAZARD_DISTANCE = 146;
    public static final int U_CARINFO_SHOW_CAMERA = 201;
    public static final int U_CARINFO_SPEED_DISTANCE_UNIT = 138;
    public static final int U_CARINFO_STATIC_LINE = 199;
    public static final int U_CARINFO_TACHOMETER = 139;
    public static final int U_CARINFO_TACHOMETER_SET = 148;
    public static final int U_CARINFO_TRAFFIC_SIGN = 195;
    public static final int U_CARINFO_TRIP_A = 119;
    public static final int U_CARINFO_TRIP_B = 120;
    public static final int U_CARINFO_VOLUME_ALARM_SYS = 142;
    public static final int U_CARINFO_WALK_AWAY_AUTO_LOCK = 140;
    public static final int U_CARINF_D22_D0_B70 = 312;
    public static final int U_CARINF_D22_D1_B70 = 313;
    public static final int U_CARINF_D22_D2_B70 = 314;
    public static final int U_CARINF_D22_D3_B70 = 315;
    public static final int U_CARINF_D25_D0_B1 = 310;
    public static final int U_CARINF_D25_D0_B76 = 311;
    public static final int U_CARINF_D33_T05_D11_D12 = 337;
    public static final int U_CARINF_D33_T05_D1_D4 = 328;
    public static final int U_CARINF_D33_T05_D5_B70 = 329;
    public static final int U_CARINF_D33_T05_D6_B70 = 330;
    public static final int U_CARINF_D33_T05_D7_B70 = 331;
    public static final int U_CARINF_D33_T05_D8_B4 = 335;
    public static final int U_CARINF_D33_T05_D8_B5 = 334;
    public static final int U_CARINF_D33_T05_D8_B6 = 333;
    public static final int U_CARINF_D33_T05_D8_B7 = 332;
    public static final int U_CARINF_D33_T05_D9_D10 = 336;
    public static final int U_CARINF_D33_T06_D1_D17 = 338;
    public static final int U_CARINF_DAY_HOUR = 225;
    public static final int U_CARINF_DAY_MDAY = 228;
    public static final int U_CARINF_DAY_MIN = 226;
    public static final int U_CARINF_DAY_MONTH = 227;
    public static final int U_CARINF_DAY_WEEKDAY = 229;
    public static final int U_CARINF_GEAR = 231;
    public static final int U_CARINF_TEMPOUT = 230;
    public static final int U_CARINF_UBACK_STATE = 316;
    public static final int U_CARINF_UBACK_STATE_ACT = 318;
    public static final int U_CARINF_UCAMERA_MODE = 317;
    public static final int U_CARRADIO_BEGIN = 237;
    public static final int U_CARRADIO_END = 249;
    public static final int U_CARRADIO_GUIJ = 224;
    public static final int U_CARSET_BACKCAR_DELAY = 232;
    public static final int U_CARSET_D32_D10_B2 = 236;
    public static final int U_CARSET_D32_D10_B3 = 235;
    public static final int U_CARSET_D32_D10_B4 = 223;
    public static final int U_CARSET_D32_D10_B5 = 222;
    public static final int U_CARSET_D32_D10_B6 = 221;
    public static final int U_CARSET_D32_D10_B7 = 220;
    public static final int U_CARSET_D32_D11_B0 = 305;
    public static final int U_CARSET_D32_D11_B1 = 304;
    public static final int U_CARSET_D32_D11_B2 = 303;
    public static final int U_CARSET_D32_D11_B3 = 302;
    public static final int U_CARSET_D32_D11_B4 = 301;
    public static final int U_CARSET_D32_D11_B75 = 300;
    public static final int U_CARSET_D32_D8_B4 = 234;
    public static final int U_CARSET_D32_D8_B5 = 219;
    public static final int U_CARSET_D32_D8_B6 = 217;
    public static final int U_CARSET_D33_D05_D11_D13 = 254;
    public static final int U_CARSET_D33_D05_D14_D15 = 255;
    public static final int U_CARSET_D33_D05_D16_D18 = 256;
    public static final int U_CARSET_D33_D05_D19_D20 = 257;
    public static final int U_CARSET_D33_D05_D1_D3 = 250;
    public static final int U_CARSET_D33_D05_D21_B10 = 262;
    public static final int U_CARSET_D33_D05_D21_B32 = 261;
    public static final int U_CARSET_D33_D05_D21_B54 = 260;
    public static final int U_CARSET_D33_D05_D21_B6 = 259;
    public static final int U_CARSET_D33_D05_D21_B7 = 258;
    public static final int U_CARSET_D33_D05_D22 = 263;
    public static final int U_CARSET_D33_D05_D4_D5 = 251;
    public static final int U_CARSET_D33_D05_D6_D8 = 252;
    public static final int U_CARSET_D33_D05_D9_D10 = 253;
    public static final int U_CARSET_D35_D0_B30 = 270;
    public static final int U_CARSET_D35_D1_B70 = 271;
    public static final int U_CARSET_D35_D2_B70 = 272;
    public static final int U_CARSET_D35_D3_B1 = 279;
    public static final int U_CARSET_D35_D3_B2 = 278;
    public static final int U_CARSET_D35_D3_B3 = 277;
    public static final int U_CARSET_D35_D3_B4 = 276;
    public static final int U_CARSET_D35_D3_B5 = 275;
    public static final int U_CARSET_D35_D3_B6 = 274;
    public static final int U_CARSET_D35_D3_B7 = 273;
    public static final int U_CARSET_D35_D4_B70 = 280;
    public static final int U_CARSET_D36_D0_B0 = 288;
    public static final int U_CARSET_D36_D0_B1 = 287;
    public static final int U_CARSET_D36_D0_B2 = 286;
    public static final int U_CARSET_D36_D0_B3 = 285;
    public static final int U_CARSET_D36_D0_B4 = 284;
    public static final int U_CARSET_D36_D0_B5 = 283;
    public static final int U_CARSET_D36_D0_B6 = 282;
    public static final int U_CARSET_D36_D0_B7 = 281;
    public static final int U_CARSET_D36_D1_B4 = 292;
    public static final int U_CARSET_D36_D1_B5 = 291;
    public static final int U_CARSET_D36_D1_B6 = 290;
    public static final int U_CARSET_D36_D1_B7 = 289;
    public static final int U_CARSET_D36_D2_B70 = 293;
    public static final int U_CARSET_D36_D3_B7 = 294;
    public static final int U_CARSET_D41_T80_D1_B70 = 319;
    public static final int U_CARSET_D41_T80_D2_B70 = 320;
    public static final int U_CARSET_D41_T80_D3_B70 = 321;
    public static final int U_CARSET_D41_T80_D4_B70 = 322;
    public static final int U_CARSET_D41_T80_D5_B70 = 323;
    public static final int U_CARSET_D41_T80_D6_B70 = 324;
    public static final int U_CARSET_D52_D0_B70 = 308;
    public static final int U_CARSET_D52_D1_B70 = 309;
    public static final int U_CARSET_DF2_D07_D0_B70 = 264;
    public static final int U_CARSET_DF2_D07_D1_B70 = 265;
    public static final int U_CARSET_DF2_D07_D2_B70 = 266;
    public static final int U_CARSET_DF2_D07_D3_B70 = 267;
    public static final int U_CARSET_DF2_D07_D4_B70 = 268;
    public static final int U_CARSET_DF2_D08_D0_B70 = 269;
    public static final int U_CARSET_DF2_D17_D0_B70 = 296;
    public static final int U_CARSET_DF2_D18_D0_B70 = 297;
    public static final int U_CARSET_DF2_D19_D0_B70 = 298;
    public static final int U_CARSET_DF2_D1A_D0_B70 = 299;
    public static final int U_CARSET_DF2_D1B_D0_B70 = 306;
    public static final int U_CARSET_DF2_D1B_D1_B70 = 307;
    public static final int U_CARSET_DOORLOCK = 233;
    public static final int U_CAR_DRIVENABLE_MILEAGE = 326;
    public static final int U_CAR_HANDBRAKE = 327;
    public static final int U_CNT_MAX = 339;
    public static final int U_CUR_SPEED = 149;
    public static final int U_DRIVER_ATTENTION_MONITOR = 158;
    public static final int U_ENGINE_SPEED = 151;
    public static final int U_GUANDAO_AMP_0 = 183;
    public static final int U_GUANDAO_AMP_1 = 184;
    public static final int U_GUANDAO_AMP_2 = 185;
    public static final int U_GUANDAO_AMP_3 = 186;
    public static final int U_GUANDAO_AMP_4 = 187;
    public static final int U_GUANDAO_AMP_5 = 188;
    public static final int U_GUANDAO_AMP_6 = 189;
    public static final int U_GUANDAO_AMP_7 = 190;
    public static final int U_GUANDAO_AMP_8 = 191;
    public static final int U_INFO_BEGIN = 159;
    public static final int U_INFO_CAR_BT_BATTERY = 173;
    public static final int U_INFO_CAR_BT_SINGAL = 172;
    public static final int U_INFO_CAR_BT_STATE = 171;
    public static final int U_INFO_CAR_CD_STATE = 168;
    public static final int U_INFO_CAR_RADIO_AUTOSELECT = 165;
    public static final int U_INFO_CAR_RADIO_SCAN = 167;
    public static final int U_INFO_CAR_RADIO_ST = 166;
    public static final int U_INFO_CAR_SOUND_CHANNEL = 178;
    public static final int U_INFO_CAR_TIME_AMPM = 175;
    public static final int U_INFO_CAR_TIME_FORMAT = 174;
    public static final int U_INFO_CAR_TIME_HOUR = 176;
    public static final int U_INFO_CAR_TIME_MINTUS = 177;
    public static final int U_INFO_CAR_USB_PLAYSTATE = 170;
    public static final int U_INFO_CAR_USB_PLUGINSTATE = 169;
    public static final int U_INFO_CAR_VOL = 164;
    public static final int U_INFO_CAR_VOL_SHOW = 163;
    public static final int U_INFO_CONTENT = 162;
    public static final int U_INFO_END = 182;
    public static final int U_INFO_HILIGHT = 161;
    public static final int U_INFO_TITLE = 160;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 117;
    public static final int U_STEER_BUTTON_SET = 295;
    public static final int U_TURN_RIGHT_CAMERA_ONOFF = 325;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 150;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 339; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 196906 || DataCanbus.DATA[1000] == 262442 || DataCanbus.DATA[1000] == 2818346 || DataCanbus.DATA[1000] == 2883882 || DataCanbus.DATA[1000] == 5439786 || DataCanbus.DATA[1000] == 786730 || DataCanbus.DATA[1000] == 852266 || DataCanbus.DATA[1000] == 917802 || DataCanbus.DATA[1000] == 4981034 || DataCanbus.DATA[1000] == 5046570 || DataCanbus.DATA[1000] == 5112106 || DataCanbus.DATA[1000] == 5177642 || DataCanbus.DATA[1000] == 5243178 || DataCanbus.DATA[1000] == 5308714 || DataCanbus.DATA[1000] == 1835306 || DataCanbus.DATA[1000] == 1900842 || DataCanbus.DATA[1000] == 2425130 || DataCanbus.DATA[1000] == 2490666 || DataCanbus.DATA[1000] == 3211562 || DataCanbus.DATA[1000] == 3277098 || DataCanbus.DATA[1000] == 2752810 || DataCanbus.DATA[1000] == 1179946 || DataCanbus.DATA[1000] == 2359594 || DataCanbus.DATA[1000] == 2949418 || DataCanbus.DATA[1000] == 1507626 || DataCanbus.DATA[1000] == 1769770 || DataCanbus.DATA[1000] == 2556202 || DataCanbus.DATA[1000] == 1573162 || DataCanbus.DATA[1000] == 2162986 || DataCanbus.DATA[1000] == 1245482 || DataCanbus.DATA[1000] == 2228522 || DataCanbus.DATA[1000] == 4915498 || DataCanbus.DATA[1000] == 1311018 || DataCanbus.DATA[1000] == 1376554 || DataCanbus.DATA[1000] == 3146026 || DataCanbus.DATA[1000] == 3342634 || DataCanbus.DATA[1000] == 1442090) {
            //AirHelper.getInstance().buildUi(new Air_0298_XP1_2016SIYU(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 524586 || DataCanbus.DATA[1000] == 590122 || DataCanbus.DATA[1000] == 2031914 || DataCanbus.DATA[1000] == 2097450 || DataCanbus.DATA[1000] == 983338) {
            //AirHelper.getInstance().buildUi(new Air_0298_BNR_2016GuanDao(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 3014954 || DataCanbus.DATA[1000] == 3080490 || DataCanbus.DATA[1000] == 3932458 || DataCanbus.DATA[1000] == 4194602 || DataCanbus.DATA[1000] == 4784426 || DataCanbus.DATA[1000] == 4849962 || DataCanbus.DATA[1000] == 3997994) {
            //AirHelper.getInstance().buildUi(new Air_0298_zx_6606_honda(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0298_XP1_2015SIYU_CRV(LauncherApplication.getInstance()));
        }
        if (DataCanbus.DATA[1000] == 4260138 || DataCanbus.DATA[1000] == 5636394 || DataCanbus.DATA[1000] == 5701930 || DataCanbus.DATA[1000] == 5767466 || DataCanbus.DATA[1000] == 5833002) {
            Air_BenzHelper.getInstance().buildUi(new Air_RZC_23Yage(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[293].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
        }
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
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 162) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 64) {
            int value = ints[0];
            if (value == 1) {
                if (!ActivityAirControl.mIsFront) {
                    //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityAirControl");
                    return;
                } else {
                    if (ActivityAirControl.mIsFront && ActivityAirControl.mInstance != null) {
                        ActivityAirControl.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (updateCode == 338) {
            if (strs != null && strs.length > 0) {
                Caridstr = strs[0];
            } else {
                Caridstr = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 339) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    public static void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(105, value1, value2);
    }
}
