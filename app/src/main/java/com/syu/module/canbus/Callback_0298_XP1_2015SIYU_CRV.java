package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0298_BNR_2016GuanDao;
import com.syu.ui.air.Air_0298_XP1_2015SIYU_CRV;
import com.syu.ui.air.Air_0298_XP1_2016SIYU;
import com.syu.ui.air.Air_0298_zx_6606_honda;
import com.syu.ui.benzair.Air_BenzHelper;
import com.syu.ui.benzair.Air_RZC_23Yage;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0298_XP1_2015SIYU_CRV extends CallbackCanbusBase {
    public static final int U_AIR_AC = 24;
    public static final int U_AIR_AUTO = 20;
    public static final int U_AIR_BACK_AUTO = 57;
    public static final int U_AIR_BACK_BODY = 54;
    public static final int U_AIR_BACK_FOOT = 55;
    public static final int U_AIR_BACK_TEMP = 52;
    public static final int U_AIR_BACK_UP = 53;
    public static final int U_AIR_BACK_WIND = 56;
    public static final int U_AIR_BEGIN = 19;
    public static final int U_AIR_BLOW_BODY_LEFT = 26;
    public static final int U_AIR_BLOW_BODY_RIGHT = 92;
    public static final int U_AIR_BLOW_FOOT_LEFT = 27;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 93;
    public static final int U_AIR_BLOW_UP_LEFT = 28;
    public static final int U_AIR_BLOW_UP_RIGHT = 91;
    public static final int U_AIR_CLIMATE = 35;
    public static final int U_AIR_CYCLE = 21;
    public static final int U_AIR_DUAL = 30;
    public static final int U_AIR_END = 36;
    public static final int U_AIR_FRONT_DEFROST = 22;
    public static final int U_AIR_POWER = 32;
    public static final int U_AIR_REAR_DEFROST = 23;
    public static final int U_AIR_REAR_LOCK = 34;
    public static final int U_AIR_SEAT_COLD_LEFT = 94;
    public static final int U_AIR_SEAT_COLD_RIGHT = 96;
    public static final int U_AIR_SEAT_HEAT_LEFT = 95;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 97;
    public static final int U_AIR_SYNC = 51;
    public static final int U_AIR_TEMP_LEFT = 25;
    public static final int U_AIR_TEMP_RIGHT = 31;
    public static final int U_AIR_TEMP_UNIT = 33;
    public static final int U_AIR_WIND_LEVEL_LEFT = 29;
    public static final int U_CAMERAMODE_DRIVING = 167;
    public static final int U_CAMERA_AUTO_OPEN_TUNK = 166;
    public static final int U_CAMERA_BACK_PARKMODE = 171;
    public static final int U_CAMERA_CROSSROADS_MONITOR = 172;
    public static final int U_CAMERA_LOWSPEED_START = 169;
    public static final int U_CAMERA_PRE_PARKMODE = 170;
    public static final int U_CAMERA_START_REARVIEW = 168;
    public static final int U_CARINFO_ACC_DISCOVERY_VEHICLE_IN_FRONT_TONE = 83;
    public static final int U_CARINFO_ADJUST_ALARM_VOLUME = 74;
    public static final int U_CARINFO_AUTO_DOOR_LOCK = 68;
    public static final int U_CARINFO_AUTO_DOOR_UNLOCK = 67;
    public static final int U_CARINFO_AUTO_HEADLIGHT_WIPER = 80;
    public static final int U_CARINFO_AUTO_INTER_ILLUMINATION = 73;
    public static final int U_CARINFO_AUTO_LIGHT_SENSITIVITY = 61;
    public static final int U_CARINFO_AWD_INFO = 150;
    public static final int U_CARINFO_BACK_CAR_BEEP_TONE = 109;
    public static final int U_CARINFO_BEGIN = 51;
    public static final int U_CARINFO_DOOR_UNLOCK_MODE = 71;
    public static final int U_CARINFO_DRIVER_WATCH_MONITOR = 148;
    public static final int U_CARINFO_DRIVING_POSITION_REMORY = 112;
    public static final int U_CARINFO_DYNAMIC_LINE = 156;
    public static final int U_CARINFO_ELE_DOOR_OPEN_AUTO_OR_MANULE = 111;
    public static final int U_CARINFO_ELE_DOOR_REMOTE_OPEN_CONDITION = 110;
    public static final int U_CARINFO_END = 88;
    public static final int U_CARINFO_ENERGY_SAVE_AUTO_ENGHINE = 82;
    public static final int U_CARINFO_FUEL_EFFIC_BACKLIGHT = 75;
    public static final int U_CARINFO_HEADLIGHT_AUTO_OFF_TIME = 62;
    public static final int U_CARINFO_INOUT_SEAT_SPORT = 113;
    public static final int U_CARINFO_INTERIOR_LIGHT_DIMMING_TIME = 63;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEP = 69;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEPVOL = 108;
    public static final int U_CARINFO_KEYLESS_ACCESS_LIGHT_FLASH = 72;
    public static final int U_CARINFO_KEY_AND_REMOTE_UNLOCK_MODE = 65;
    public static final int U_CARINFO_KEY_LOCK_ANSWER = 64;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE = 137;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE_PN_UNIT = 136;
    public static final int U_CARINFO_MAINTANCE_OIL_SERVICE_LIFE_UNIT = 135;
    public static final int U_CARINFO_MEMORY_SEAT = 153;
    public static final int U_CARINFO_MINOR_LANE_DEPARTURE_SYS_SETTINGS = 86;
    public static final int U_CARINFO_MULTI_FUNCTION = 161;
    public static final int U_CARINFO_NEW_MSG_NOTIF = 76;
    public static final int U_CARINFO_OUT_TEMP_SHOW = 60;
    public static final int U_CARINFO_PANORAMIC_IMAGE = 160;
    public static final int U_CARINFO_PARK_SPACE = 158;
    public static final int U_CARINFO_PAUSE_LKAS_TONE = 84;
    public static final int U_CARINFO_PILAO_DRIVER = 149;
    public static final int U_CARINFO_REMAIN_EC = 174;
    public static final int U_CARINFO_REMINDER_SYSTEM = 159;
    public static final int U_CARINFO_REMOTE_START_SYS = 70;
    public static final int U_CARINFO_RISE_WARNING = 152;
    public static final int U_CARINFO_SEAT_BELT = 154;
    public static final int U_CARINFO_SECURITY_RELOCK_TIME = 66;
    public static final int U_CARINFO_SET_FRONT_HAZARD_DISTANCE = 85;
    public static final int U_CARINFO_SHOW_CAMERA = 157;
    public static final int U_CARINFO_SPEED_DISTANCE_UNIT = 77;
    public static final int U_CARINFO_STATIC_LINE = 155;
    public static final int U_CARINFO_TACHOMETER = 78;
    public static final int U_CARINFO_TACHOMETER_SET = 87;
    public static final int U_CARINFO_TRAFFIC_SIGN = 151;
    public static final int U_CARINFO_TRIP_A = 58;
    public static final int U_CARINFO_TRIP_B = 59;
    public static final int U_CARINFO_VOLUME_ALARM_SYS = 81;
    public static final int U_CARINFO_WALK_AWAY_AUTO_LOCK = 79;
    public static final int U_CARINF_DAY_HOUR = 181;
    public static final int U_CARINF_DAY_MDAY = 184;
    public static final int U_CARINF_DAY_MIN = 182;
    public static final int U_CARINF_DAY_MONTH = 183;
    public static final int U_CARINF_DAY_WEEKDAY = 185;
    public static final int U_CARINF_GEAR = 187;
    public static final int U_CARINF_TEMPOUT = 186;
    public static final int U_CARRADIO_END = 212;
    public static final int U_CARRADIO_GUIJ = 180;
    public static final int U_CARSET_BACKCAR_DELAY = 188;
    public static final int U_CARSET_D32_D10_B2 = 192;
    public static final int U_CARSET_D32_D10_B3 = 191;
    public static final int U_CARSET_D32_D10_B4 = 179;
    public static final int U_CARSET_D32_D10_B5 = 178;
    public static final int U_CARSET_D32_D10_B6 = 177;
    public static final int U_CARSET_D32_D10_B7 = 176;
    public static final int U_CARSET_D32_D11_B1 = 197;
    public static final int U_CARSET_D32_D11_B2 = 196;
    public static final int U_CARSET_D32_D11_B3 = 195;
    public static final int U_CARSET_D32_D11_B4 = 194;
    public static final int U_CARSET_D32_D11_B75 = 193;
    public static final int U_CARSET_D32_D8_B4 = 190;
    public static final int U_CARSET_D32_D8_B5 = 175;
    public static final int U_CARSET_D32_D8_B6 = 173;
    public static final int U_CARSET_D33_D05_D11_D13 = 217;
    public static final int U_CARSET_D33_D05_D14_D15 = 218;
    public static final int U_CARSET_D33_D05_D16_D18 = 219;
    public static final int U_CARSET_D33_D05_D19_D20 = 220;
    public static final int U_CARSET_D33_D05_D1_D3 = 213;
    public static final int U_CARSET_D33_D05_D21_B10 = 225;
    public static final int U_CARSET_D33_D05_D21_B32 = 224;
    public static final int U_CARSET_D33_D05_D21_B54 = 223;
    public static final int U_CARSET_D33_D05_D21_B6 = 222;
    public static final int U_CARSET_D33_D05_D21_B7 = 221;
    public static final int U_CARSET_D33_D05_D22 = 226;
    public static final int U_CARSET_D33_D05_D4_D5 = 214;
    public static final int U_CARSET_D33_D05_D6_D8 = 215;
    public static final int U_CARSET_D33_D05_D9_D10 = 216;
    public static final int U_CARSET_D35_D0_B30 = 233;
    public static final int U_CARSET_D35_D1_B70 = 234;
    public static final int U_CARSET_D35_D2_B70 = 235;
    public static final int U_CARSET_D35_D3_B1 = 242;
    public static final int U_CARSET_D35_D3_B2 = 241;
    public static final int U_CARSET_D35_D3_B3 = 240;
    public static final int U_CARSET_D35_D3_B4 = 239;
    public static final int U_CARSET_D35_D3_B5 = 238;
    public static final int U_CARSET_D35_D3_B6 = 237;
    public static final int U_CARSET_D35_D3_B7 = 236;
    public static final int U_CARSET_D35_D4_B70 = 243;
    public static final int U_CARSET_D36_D0_B0 = 251;
    public static final int U_CARSET_D36_D0_B1 = 250;
    public static final int U_CARSET_D36_D0_B2 = 249;
    public static final int U_CARSET_D36_D0_B3 = 248;
    public static final int U_CARSET_D36_D0_B4 = 247;
    public static final int U_CARSET_D36_D0_B5 = 246;
    public static final int U_CARSET_D36_D0_B6 = 245;
    public static final int U_CARSET_D36_D0_B7 = 244;
    public static final int U_CARSET_D36_D1_B4 = 255;
    public static final int U_CARSET_D36_D1_B5 = 254;
    public static final int U_CARSET_D36_D1_B6 = 253;
    public static final int U_CARSET_D36_D1_B7 = 252;
    public static final int U_CARSET_D36_D2_B70 = 256;
    public static final int U_CARSET_D36_D3_B7 = 257;
    public static final int U_CARSET_DF2_D07_D0_B70 = 227;
    public static final int U_CARSET_DF2_D07_D1_B70 = 228;
    public static final int U_CARSET_DF2_D07_D2_B70 = 229;
    public static final int U_CARSET_DF2_D07_D3_B70 = 230;
    public static final int U_CARSET_DF2_D07_D4_B70 = 231;
    public static final int U_CARSET_DF2_D08_D0_B70 = 232;
    public static final int U_CARSET_DOORLOCK = 189;
    public static final int U_CNT_MAX = 258;
    public static final int U_CUR_SPEED = 89;
    public static final int U_DOOR_BACK = 41;
    public static final int U_DOOR_BEGIN = 36;
    public static final int U_DOOR_END = 42;
    public static final int U_DOOR_ENGINE = 36;
    public static final int U_DOOR_FL = 37;
    public static final int U_DOOR_FR = 38;
    public static final int U_DOOR_RL = 39;
    public static final int U_DOOR_RR = 40;
    public static final int U_DRIVER_ATTENTION_MONITOR = 114;
    public static final int U_ENGINE_SPEED = 90;
    public static final int U_GUANDAO_AMP_0 = 139;
    public static final int U_GUANDAO_AMP_1 = 140;
    public static final int U_GUANDAO_AMP_2 = 141;
    public static final int U_GUANDAO_AMP_3 = 142;
    public static final int U_GUANDAO_AMP_4 = 143;
    public static final int U_GUANDAO_AMP_5 = 144;
    public static final int U_GUANDAO_AMP_6 = 145;
    public static final int U_GUANDAO_AMP_7 = 146;
    public static final int U_GUANDAO_AMP_8 = 147;
    public static final int U_INFO_BEGIN = 115;
    public static final int U_INFO_CAR_BT_BATTERY = 129;
    public static final int U_INFO_CAR_BT_SINGAL = 128;
    public static final int U_INFO_CAR_BT_STATE = 127;
    public static final int U_INFO_CAR_CD_STATE = 124;
    public static final int U_INFO_CAR_RADIO_AUTOSELECT = 121;
    public static final int U_INFO_CAR_RADIO_SCAN = 123;
    public static final int U_INFO_CAR_RADIO_ST = 122;
    public static final int U_INFO_CAR_SOUND_CHANNEL = 134;
    public static final int U_INFO_CAR_TIME_AMPM = 131;
    public static final int U_INFO_CAR_TIME_FORMAT = 130;
    public static final int U_INFO_CAR_TIME_HOUR = 132;
    public static final int U_INFO_CAR_TIME_MINTUS = 133;
    public static final int U_INFO_CAR_USB_PLAYSTATE = 126;
    public static final int U_INFO_CAR_USB_PLUGINSTATE = 125;
    public static final int U_INFO_CAR_VOL = 120;
    public static final int U_INFO_CAR_VOL_SHOW = 119;
    public static final int U_INFO_CONTENT = 118;
    public static final int U_INFO_END = 138;
    public static final int U_INFO_HILIGHT = 117;
    public static final int U_INFO_TITLE = 116;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 50;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 258; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 36;
        DoorHelper.sUcDoorFl = 37;
        DoorHelper.sUcDoorFr = 38;
        DoorHelper.sUcDoorRl = 39;
        DoorHelper.sUcDoorRr = 40;
        DoorHelper.sUcDoorBack = 41;
        if (DataCanbus.DATA[1000] == 196906 || DataCanbus.DATA[1000] == 262442 || DataCanbus.DATA[1000] == 2818346 || DataCanbus.DATA[1000] == 2883882 || DataCanbus.DATA[1000] == 786730 || DataCanbus.DATA[1000] == 852266 || DataCanbus.DATA[1000] == 917802 || DataCanbus.DATA[1000] == 1835306 || DataCanbus.DATA[1000] == 1900842 || DataCanbus.DATA[1000] == 2425130 || DataCanbus.DATA[1000] == 2490666 || DataCanbus.DATA[1000] == 2687274 || DataCanbus.DATA[1000] == 3211562 || DataCanbus.DATA[1000] == 3277098 || DataCanbus.DATA[1000] == 2752810 || DataCanbus.DATA[1000] == 1179946 || DataCanbus.DATA[1000] == 2359594 || DataCanbus.DATA[1000] == 2949418 || DataCanbus.DATA[1000] == 1507626 || DataCanbus.DATA[1000] == 1769770 || DataCanbus.DATA[1000] == 2556202 || DataCanbus.DATA[1000] == 1573162 || DataCanbus.DATA[1000] == 2162986 || DataCanbus.DATA[1000] == 1245482 || DataCanbus.DATA[1000] == 2228522 || DataCanbus.DATA[1000] == 1311018 || DataCanbus.DATA[1000] == 1376554 || DataCanbus.DATA[1000] == 3146026 || DataCanbus.DATA[1000] == 3342634 || DataCanbus.DATA[1000] == 1442090) {
            AirHelper.getInstance().buildUi(new Air_0298_XP1_2016SIYU(LauncherApplication.getInstance()));
            for (int i3 = 51; i3 <= 57; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 524586 || DataCanbus.DATA[1000] == 590122 || DataCanbus.DATA[1000] == 2031914 || DataCanbus.DATA[1000] == 2097450 || DataCanbus.DATA[1000] == 983338) {
            AirHelper.getInstance().buildUi(new Air_0298_BNR_2016GuanDao(LauncherApplication.getInstance()));
            for (int i4 = 51; i4 <= 57; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i5 = 91; i5 <= 97; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 3014954 || DataCanbus.DATA[1000] == 3080490 || DataCanbus.DATA[1000] == 3932458 || DataCanbus.DATA[1000] == 4194602 || DataCanbus.DATA[1000] == 3997994) {
            AirHelper.getInstance().buildUi(new Air_0298_zx_6606_honda(LauncherApplication.getInstance()));
            for (int i6 = 51; i6 <= 57; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            AirHelper.getInstance().buildUi(new Air_0298_XP1_2015SIYU_CRV(LauncherApplication.getInstance()));
        }
        if (DataCanbus.DATA[1000] == 4260138) {
            Air_BenzHelper.getInstance().buildUi(new Air_RZC_23Yage(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[256].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i7 = 36; i7 < 42; i7++) {
            DataCanbus.NOTIFY_EVENTS[i7].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i8 = 19; i8 < 35; i8++) {
            DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 2818346 || DataCanbus.DATA[1000] == 2883882) {
            DataCanbus.NOTIFY_EVENTS[29].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 36; i < 42; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 51; i2 <= 57; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 19; i3 < 35; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 118) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 35) {
            int value = ints[0];
            if (value == 1) {
                if (!ActivityAirControl.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityAirControl");
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
        if (updateCode >= 0 && updateCode < 258) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    public static void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(105, value1, value2);
    }
}
