package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.psa_all.PsaAllAlarmRecordActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0252_WC2_PSAALL;
import com.syu.ui.air.Air_0252_WC2_PSAALL_4008;
import com.syu.ui.air.Air_0252_WC2_PSAALL_407;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0252_WC2_PSAALL extends CallbackCanbusBase {
    public static final int U_174008_AMBIENT_MODE = 178;
    public static final int U_174008_AMBIENT_MODE_ENABLE = 169;
    public static final int U_174008_DRIVE_MODE = 179;
    public static final int U_174008_DRIVE_MODE_ENABLE = 170;
    public static final int U_174008_END = 182;
    public static final int U_174008_FATIGUE_DETECTION = 175;
    public static final int U_174008_FATIGUE_DETECTION_ENABLE = 166;
    public static final int U_174008_INCENSE_CONCENTRATION = 173;
    public static final int U_174008_INCENSE_TYPE = 181;
    public static final int U_174008_INCENSE_TYPE_ENABLE = 172;
    public static final int U_174008_ION_PURIFIER = 180;
    public static final int U_174008_ION_PURIFIER_ENABLE = 171;
    public static final int U_174008_LANE_MAINTAIN = 174;
    public static final int U_174008_LANE_MAINTAIN_ENABLE = 165;
    public static final int U_174008_PANNEL_BRIGHT = 185;
    public static final int U_174008_PANNEL_BRIGHT_ENABLE = 184;
    public static final int U_174008_PANNEL_LEFT = 186;
    public static final int U_174008_PANNEL_RIGHT = 187;
    public static final int U_174008_SPEED_LIMIT = 176;
    public static final int U_174008_SPEED_LIMIT_ENABLE = 167;
    public static final int U_174008_START = 164;
    public static final int U_174008_THEME_COLOR_SET = 177;
    public static final int U_174008_THEME_COLOR_SET_ENABLE = 168;
    public static final int U_2TIMES_KEY_UNLOCK = 98;
    public static final int U_508_SOUND_0 = 188;
    public static final int U_508_SOUND_1 = 189;
    public static final int U_508_SOUND_2 = 190;
    public static final int U_508_SOUND_3 = 191;
    public static final int U_508_SOUND_4 = 192;
    public static final int U_508_SOUND_5 = 193;
    public static final int U_508_SOUND_6 = 194;
    public static final int U_508_SOUND_7 = 195;
    public static final int U_AIR_BY_AUTO_KEY = 140;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 113;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 114;
    public static final int U_AUTOLOCK_BY_SPEED = 112;
    public static final int U_AUTO_AC_ENABLED = 110;
    public static final int U_AVERAGE_SPEED = 90;
    public static final int U_BACK_CAR_VOL = 183;
    public static final int U_BATTERY_VOLTAGE = 148;
    public static final int U_CARINFO_END = 164;
    public static final int U_CARINFO_TRMP_SET_V = 230;
    public static final int U_CARINF_BEGIN = 86;
    public static final int U_CARSET_D79_D2_B0 = 197;
    public static final int U_CARSET_D79_D2_B1 = 196;
    public static final int U_CARSET_D79_D3_B0 = 234;
    public static final int U_CARSET_D79_D3_B1 = 233;
    public static final int U_CARSET_D79_D3_B2 = 232;
    public static final int U_CARSET_D79_D3_B3 = 231;
    public static final int U_CARSET_D79_D3_B4 = 200;
    public static final int U_CARSET_D79_D3_B5 = 199;
    public static final int U_CARSET_D79_D3_B76 = 198;
    public static final int U_CARSET_D79_D4_B20 = 236;
    public static final int U_CARSET_D79_D4_B53 = 235;
    public static final int U_CARSET_D79_D5_B0 = 241;
    public static final int U_CARSET_D79_D5_B1 = 240;
    public static final int U_CARSET_D79_D5_B32 = 239;
    public static final int U_CARSET_D79_D5_B54 = 238;
    public static final int U_CARSET_D79_D5_B76 = 237;
    public static final int U_CARSET_D79_D6_B0 = 243;
    public static final int U_CARSET_D79_D6_B21 = 242;
    public static final int U_CARSET_D93_D0_B5 = 203;
    public static final int U_CARSET_D93_D0_B6 = 202;
    public static final int U_CARSET_D93_D0_B7 = 201;
    public static final int U_CARSET_D93_D1_B70 = 204;
    public static final int U_CARSET_D93_D2_B70 = 205;
    public static final int U_CARSET_D97_D0_B30 = 206;
    public static final int U_CARSET_D97_D1_B0 = 212;
    public static final int U_CARSET_D97_D1_B1 = 211;
    public static final int U_CARSET_D97_D1_B2 = 210;
    public static final int U_CARSET_D97_D1_B3 = 209;
    public static final int U_CARSET_D97_D1_B4 = 208;
    public static final int U_CARSET_D97_D1_B5 = 207;
    public static final int U_CARSET_D97_D2_B0 = 218;
    public static final int U_CARSET_D97_D2_B1 = 217;
    public static final int U_CARSET_D97_D2_B2 = 216;
    public static final int U_CARSET_D97_D2_B3 = 215;
    public static final int U_CARSET_D97_D2_B4 = 214;
    public static final int U_CARSET_D97_D2_B5 = 213;
    public static final int U_CARSET_D97_D3_D4 = 219;
    public static final int U_CARSET_D97_D5_B70 = 220;
    public static final int U_CARSET_D97_D6_B70 = 221;
    public static final int U_CARSET_D97_D7_B2 = 227;
    public static final int U_CARSET_D97_D7_B3 = 226;
    public static final int U_CARSET_D97_D7_B4 = 225;
    public static final int U_CARSET_D97_D7_B5 = 224;
    public static final int U_CARSET_D97_D7_B6 = 223;
    public static final int U_CARSET_D97_D7_B7 = 222;
    public static final int U_CARSET_D97_D8_B70 = 228;
    public static final int U_CARSET_D97_D9_D10 = 229;
    public static final int U_CAR_BT_STATE = 118;
    public static final int U_CAR_CAMERA_MODE = 92;
    public static final int U_CAR_MID_ENABLE = 103;
    public static final int U_CAR_PE_ENABLE = 156;
    public static final int U_CAR_PLAY_PROGRESS = 155;
    public static final int U_CAR_PLAY_STATE = 104;
    public static final int U_CAR_RIGHTCAMERA_STATE = 163;
    public static final int U_CLOSE_BIGLAMP_TIME = 125;
    public static final int U_CLOSE_INSIDELAMP_TIME = 123;
    public static final int U_CNT_MAX = 244;
    public static final int U_CURRENT_SPEED = 111;
    public static final int U_CUR_OIL_EXPEND = 86;
    public static final int U_CUR_TRIP_OIL_EXPEND = 91;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 116;
    public static final int U_DRIVER_ACC = 102;
    public static final int U_DRIVER_DISPLAY_DISTANCE_WARNNING = 153;
    public static final int U_DRIVING_MILEAGE = 87;
    public static final int U_DRIVING_TIME = 89;
    public static final int U_ENGINE_SPEED = 149;
    public static final int U_EXIST_TPMS = 131;
    public static final int U_FEEDBACK_LAMP_ENABLED = 94;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 141;
    public static final int U_JUMP_ALAMINFO = 162;
    public static final int U_JUMP_CARINFO = 161;
    public static final int U_LAST_OIL = 147;
    public static final int U_LIGHT_COMING_HOME = 158;
    public static final int U_LIGHT_LEAVING_HOME = 157;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 97;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 119;
    public static final int U_MIRROR_WIPERS_AUTO_WIPING_IN_RAIN = 101;
    public static final int U_MIRROR_WIPERS_FOLDIN_WHEN_PARKED = 108;
    public static final int U_MIRROR_WIPERS_LOW_WHILE_REVESING = 109;
    public static final int U_MIRROR_WIPERS_REAR_WIN_WIPING_IN_RESERVE = 100;
    public static final int U_MIRROR_WIPERS_SYN_ADJUST = 154;
    public static final int U_MUTIL_AVERAGE_CONSUMPTION = 134;
    public static final int U_MUTIL_AVERAGE_SPEED = 139;
    public static final int U_MUTIL_CONVENIENCE_CONSUMER = 135;
    public static final int U_MUTIL_CURRENT_CONSUMPTION = 133;
    public static final int U_MUTIL_DISTANCE_TRAVELLED = 138;
    public static final int U_MUTIL_ECO_TIPS = 136;
    public static final int U_MUTIL_TRAVELLING_TIME = 137;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 115;
    public static final int U_OPEN_CLOSE_AUTO_LOCK = 107;
    public static final int U_OPEN_CLOSE_CONVENIENCE = 105;
    public static final int U_OPEN_CLOSE_DOOR_UNLOCK = 106;
    public static final int U_OPTIMAL_OIL_EXPEND = 88;
    public static final int U_PARK_BESIDE_ROAD = 150;
    public static final int U_PARK_IN_CARPORT = 151;
    public static final int U_PRESSURE_BACKUP = 130;
    public static final int U_PRESSURE_FL = 126;
    public static final int U_PRESSURE_FR = 127;
    public static final int U_PRESSURE_RL = 128;
    public static final int U_PRESSURE_RR = 129;
    public static final int U_RADAR_MUTE = 152;
    public static final int U_RADAR_VOL = 160;
    public static final int U_REMOTE_2PRESS_UNLOCK = 120;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 124;
    public static final int U_SHOW_RADAR = 159;
    public static final int U_SHOW_TIRE_BACKUP = 132;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 122;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 93;
    public static final int U_TIRE_SHOW_STATE = 96;
    public static final int U_TPMS_STATE = 95;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 99;
    public static final int U_UNLOCK_BY_SMART_DOOR = 121;
    public static final int U_VALID_VENTILATION_ENABLED = 117;
    public static final int U_WARNNING_CLEANNING_FLUID = 145;
    public static final int U_WARNNING_HANDLE_BRAKE = 146;
    public static final int U_WARNNING_LIFE_BELT = 144;
    public static final int U_WARNNING_LOW_BATTERY = 143;
    public static final int U_WARNNING_LOW_OIL = 142;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 244; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 721148) {
            AirHelper.getInstance().buildUi(new Air_0252_WC2_PSAALL_4008(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 1245436) {
            AirHelper.getInstance().buildUi(new Air_0252_WC2_PSAALL_407(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0252_WC2_PSAALL(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 244) {
            if (updateCode == 161) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[161];
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
            if (updateCode == 162) {
                HandlerCanbus.update(updateCode, ints);
                int value2 = DataCanbus.DATA[162];
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
