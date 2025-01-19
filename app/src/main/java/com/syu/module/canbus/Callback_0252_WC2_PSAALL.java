package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.psa_all.PsaAllAlarmRecordActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0252_WC2_PSAALL;
import com.syu.ui.door.DoorHelper;

public class Callback_0252_WC2_PSAALL extends CallbackCanbusBase {
    public static final int U_174008_AMBIENT_MODE = 190;
    public static final int U_174008_AMBIENT_MODE_ENABLE = 181;
    public static final int U_174008_DRIVE_MODE = 191;
    public static final int U_174008_DRIVE_MODE_ENABLE = 182;
    public static final int U_174008_END = 194;
    public static final int U_174008_FATIGUE_DETECTION = 187;
    public static final int U_174008_FATIGUE_DETECTION_ENABLE = 178;
    public static final int U_174008_INCENSE_CONCENTRATION = 185;
    public static final int U_174008_INCENSE_TYPE = 193;
    public static final int U_174008_INCENSE_TYPE_ENABLE = 184;
    public static final int U_174008_ION_PURIFIER = 192;
    public static final int U_174008_ION_PURIFIER_ENABLE = 183;
    public static final int U_174008_LANE_MAINTAIN = 186;
    public static final int U_174008_LANE_MAINTAIN_ENABLE = 177;
    public static final int U_174008_PANNEL_BRIGHT = 197;
    public static final int U_174008_PANNEL_BRIGHT_ENABLE = 196;
    public static final int U_174008_PANNEL_LEFT = 198;
    public static final int U_174008_PANNEL_RIGHT = 199;
    public static final int U_174008_SPEED_LIMIT = 188;
    public static final int U_174008_SPEED_LIMIT_ENABLE = 179;
    public static final int U_174008_START = 176;
    public static final int U_174008_THEME_COLOR_SET = 189;
    public static final int U_174008_THEME_COLOR_SET_ENABLE = 180;
    public static final int U_2TIMES_KEY_UNLOCK = 110;
    public static final int U_508_SOUND_0 = 200;
    public static final int U_508_SOUND_1 = 201;
    public static final int U_508_SOUND_2 = 202;
    public static final int U_508_SOUND_3 = 203;
    public static final int U_508_SOUND_4 = 204;
    public static final int U_508_SOUND_5 = 205;
    public static final int U_508_SOUND_6 = 206;
    public static final int U_508_SOUND_7 = 207;
    public static final int U_AIR_BY_AUTO_KEY = 152;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 125;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 126;
    public static final int U_AUTOLOCK_BY_SPEED = 124;
    public static final int U_AUTO_AC_ENABLED = 122;
    public static final int U_AVERAGE_SPEED = 102;
    public static final int U_BACK_CAR_VOL = 195;
    public static final int U_BATTERY_VOLTAGE = 160;
    public static final int U_CARINFO_END = 176;
    public static final int U_CARINFO_TRMP_SET_V = 242;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARSET_D79_D2_B0 = 209;
    public static final int U_CARSET_D79_D2_B1 = 208;
    public static final int U_CARSET_D79_D3_B0 = 246;
    public static final int U_CARSET_D79_D3_B1 = 245;
    public static final int U_CARSET_D79_D3_B2 = 244;
    public static final int U_CARSET_D79_D3_B3 = 243;
    public static final int U_CARSET_D79_D3_B4 = 212;
    public static final int U_CARSET_D79_D3_B5 = 211;
    public static final int U_CARSET_D79_D3_B76 = 210;
    public static final int U_CARSET_D79_D4_B20 = 248;
    public static final int U_CARSET_D79_D4_B53 = 247;
    public static final int U_CARSET_D79_D5_B0 = 253;
    public static final int U_CARSET_D79_D5_B1 = 252;
    public static final int U_CARSET_D79_D5_B32 = 251;
    public static final int U_CARSET_D79_D5_B54 = 250;
    public static final int U_CARSET_D79_D5_B76 = 249;
    public static final int U_CARSET_D79_D6_B0 = 255;
    public static final int U_CARSET_D79_D6_B21 = 254;
    public static final int U_CARSET_D93_D0_B5 = 215;
    public static final int U_CARSET_D93_D0_B6 = 214;
    public static final int U_CARSET_D93_D0_B7 = 213;
    public static final int U_CARSET_D93_D1_B70 = 216;
    public static final int U_CARSET_D93_D2_B70 = 217;
    public static final int U_CARSET_D97_D0_B30 = 218;
    public static final int U_CARSET_D97_D1_B0 = 224;
    public static final int U_CARSET_D97_D1_B1 = 223;
    public static final int U_CARSET_D97_D1_B2 = 222;
    public static final int U_CARSET_D97_D1_B3 = 221;
    public static final int U_CARSET_D97_D1_B4 = 220;
    public static final int U_CARSET_D97_D1_B5 = 219;
    public static final int U_CARSET_D97_D2_B0 = 230;
    public static final int U_CARSET_D97_D2_B1 = 229;
    public static final int U_CARSET_D97_D2_B2 = 228;
    public static final int U_CARSET_D97_D2_B3 = 227;
    public static final int U_CARSET_D97_D2_B4 = 226;
    public static final int U_CARSET_D97_D2_B5 = 225;
    public static final int U_CARSET_D97_D3_D4 = 231;
    public static final int U_CARSET_D97_D5_B70 = 232;
    public static final int U_CARSET_D97_D6_B70 = 233;
    public static final int U_CARSET_D97_D7_B2 = 239;
    public static final int U_CARSET_D97_D7_B3 = 238;
    public static final int U_CARSET_D97_D7_B4 = 237;
    public static final int U_CARSET_D97_D7_B5 = 236;
    public static final int U_CARSET_D97_D7_B6 = 235;
    public static final int U_CARSET_D97_D7_B7 = 234;
    public static final int U_CARSET_D97_D8_B70 = 240;
    public static final int U_CARSET_D97_D9_D10 = 241;
    public static final int U_CAR_BT_STATE = 130;
    public static final int U_CAR_CAMERA_MODE = 104;
    public static final int U_CAR_MID_ENABLE = 115;
    public static final int U_CAR_PE_ENABLE = 168;
    public static final int U_CAR_PLAY_PROGRESS = 167;
    public static final int U_CAR_PLAY_STATE = 116;
    public static final int U_CAR_RIGHTCAMERA_STATE = 175;
    public static final int U_CLOSE_BIGLAMP_TIME = 137;
    public static final int U_CLOSE_INSIDELAMP_TIME = 135;
    public static final int U_CNT_MAX = 256;
    public static final int U_CURRENT_SPEED = 123;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_TRIP_OIL_EXPEND = 103;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 128;
    public static final int U_DRIVER_ACC = 114;
    public static final int U_DRIVER_DISPLAY_DISTANCE_WARNNING = 165;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 101;
    public static final int U_ENGINE_SPEED = 161;
    public static final int U_EXIST_TPMS = 143;
    public static final int U_FEEDBACK_LAMP_ENABLED = 106;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 153;
    public static final int U_JUMP_ALAMINFO = 174;
    public static final int U_JUMP_CARINFO = 173;
    public static final int U_LAST_OIL = 159;
    public static final int U_LIGHT_COMING_HOME = 170;
    public static final int U_LIGHT_LEAVING_HOME = 169;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 109;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 131;
    public static final int U_MIRROR_WIPERS_AUTO_WIPING_IN_RAIN = 113;
    public static final int U_MIRROR_WIPERS_FOLDIN_WHEN_PARKED = 120;
    public static final int U_MIRROR_WIPERS_LOW_WHILE_REVESING = 121;
    public static final int U_MIRROR_WIPERS_REAR_WIN_WIPING_IN_RESERVE = 112;
    public static final int U_MIRROR_WIPERS_SYN_ADJUST = 166;
    public static final int U_MUTIL_AVERAGE_CONSUMPTION = 146;
    public static final int U_MUTIL_AVERAGE_SPEED = 151;
    public static final int U_MUTIL_CONVENIENCE_CONSUMER = 147;
    public static final int U_MUTIL_CURRENT_CONSUMPTION = 145;
    public static final int U_MUTIL_DISTANCE_TRAVELLED = 150;
    public static final int U_MUTIL_ECO_TIPS = 148;
    public static final int U_MUTIL_TRAVELLING_TIME = 149;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 127;
    public static final int U_OPEN_CLOSE_AUTO_LOCK = 119;
    public static final int U_OPEN_CLOSE_CONVENIENCE = 117;
    public static final int U_OPEN_CLOSE_DOOR_UNLOCK = 118;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_PARK_BESIDE_ROAD = 162;
    public static final int U_PARK_IN_CARPORT = 163;
    public static final int U_PRESSURE_BACKUP = 142;
    public static final int U_PRESSURE_FL = 138;
    public static final int U_PRESSURE_FR = 139;
    public static final int U_PRESSURE_RL = 140;
    public static final int U_PRESSURE_RR = 141;
    public static final int U_RADAR_MUTE = 164;
    public static final int U_RADAR_VOL = 172;
    public static final int U_REMOTE_2PRESS_UNLOCK = 132;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 136;
    public static final int U_SHOW_RADAR = 171;
    public static final int U_SHOW_TIRE_BACKUP = 144;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 134;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 105;
    public static final int U_TIRE_SHOW_STATE = 108;
    public static final int U_TPMS_STATE = 107;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 111;
    public static final int U_UNLOCK_BY_SMART_DOOR = 133;
    public static final int U_VALID_VENTILATION_ENABLED = 129;
    public static final int U_WARNNING_CLEANNING_FLUID = 157;
    public static final int U_WARNNING_HANDLE_BRAKE = 158;
    public static final int U_WARNNING_LIFE_BELT = 156;
    public static final int U_WARNNING_LOW_BATTERY = 155;
    public static final int U_WARNNING_LOW_OIL = 154;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 256; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0252_WC2_PSAALL(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 256) {
            if (updateCode == 173) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[173];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.psa_all.PSAOilMileIndexActi");
                    return;
                } else {
                    if (PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 174) {
                HandlerCanbus.update(updateCode, ints);
                int value2 = DataCanbus.DATA[174];
                if (value2 == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.psa_all.PsaAllAlarmRecordActi");
                    return;
                } else {
                    if (PsaAllAlarmRecordActi.mIsFront && PsaAllAlarmRecordActi.mInstance != null) {
                        PsaAllAlarmRecordActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
