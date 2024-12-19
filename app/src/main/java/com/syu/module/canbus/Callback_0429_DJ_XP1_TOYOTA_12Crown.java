package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.dj.huangguan.ActivityCarCD;
import com.syu.carinfo.dj.huangguan.ActivityCarRadio;
import com.syu.carinfo.dj.huangguan.dj_429_crown_AirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0429_DJ_XP1_TOYOTA_12Crown_Low;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0429_DJ_XP1_TOYOTA_12Crown extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 6;
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int C_CMD_BUTTON = 0;
    public static final int C_CMD_KEY = 2;
    public static final int C_CMD_REQUEST = 1;
    public static final int MODE_AUTO_AIR = 0;
    public static final int MODE_MANUAL_AIR = 1;
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BACK_AC = 30;
    public static final int U_AIR_BACK_AUTO = 29;
    public static final int U_AIR_BACK_BLOW_BODY = 82;
    public static final int U_AIR_BACK_BLOW_FOOT = 83;
    public static final int U_AIR_BACK_BLOW_UP = 81;
    public static final int U_AIR_BACK_TEMP = 33;
    public static final int U_AIR_BACK_TEMP_HI = 32;
    public static final int U_AIR_BACK_TEMP_LO = 31;
    public static final int U_AIR_BACK_WIN_LEV = 80;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 19;
    public static final int U_AIR_BLOW_FOOT_LEFT = 20;
    public static final int U_AIR_BLOW_MODE = 21;
    public static final int U_AIR_BLOW_UP_LEFT = 18;
    public static final int U_AIR_CLEAN = 66;
    public static final int U_AIR_CLEAN_FLOWER = 67;
    public static final int U_AIR_CLEAN_ICE = 68;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 35;
    public static final int U_AIR_FRONT_DEFROST = 25;
    public static final int U_AIR_MANUAL_AUTO = 28;
    public static final int U_AIR_MAXFRONT_DEFROST = 16;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_CTRL = 27;
    public static final int U_AIR_REAR_DEFROST = 26;
    public static final int U_AIR_REAR_LOCK = 17;
    public static final int U_AIR_SHOW = 34;
    public static final int U_AIR_SWING = 69;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 22;
    public static final int U_AVERAGE_SPEED = 84;
    public static final int U_CAREQ_ACOUSTIC = 77;
    public static final int U_CAREQ_BAL = 71;
    public static final int U_CAREQ_BASS = 72;
    public static final int U_CAREQ_FAD = 70;
    public static final int U_CAREQ_MID = 74;
    public static final int U_CAREQ_POSITION = 77;
    public static final int U_CAREQ_TRE = 73;
    public static final int U_CAREQ_VOL = 75;
    public static final int U_CAREQ_VOL_SPEED = 76;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 58;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 63;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 62;
    public static final int U_CARINFO_DVD_ID = 57;
    public static final int U_CARINFO_DVD_PLAYTIME = 64;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 61;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 60;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 59;
    public static final int U_CARINFO_END = 65;
    public static final int U_CARINFO_RADIO_BAND = 51;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 53;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 55;
    public static final int U_CARINFO_RADIO_FREQ = 52;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 54;
    public static final int U_CARINFO_SOURCE = 50;
    public static final int U_CARSET_D26_D0_B10 = 96;
    public static final int U_CARSET_D26_D0_B32 = 95;
    public static final int U_CARSET_D26_D0_B64 = 94;
    public static final int U_CARSET_D26_D0_B7 = 93;
    public static final int U_CARSET_D26_D1_B20 = 101;
    public static final int U_CARSET_D26_D1_B4 = 100;
    public static final int U_CARSET_D26_D1_B5 = 99;
    public static final int U_CARSET_D26_D1_B6 = 98;
    public static final int U_CARSET_D26_D1_B7 = 97;
    public static final int U_CARSET_D26_D2_B20 = 107;
    public static final int U_CARSET_D26_D2_B3 = 106;
    public static final int U_CARSET_D26_D2_B4 = 105;
    public static final int U_CARSET_D26_D2_B5 = 104;
    public static final int U_CARSET_D26_D2_B6 = 103;
    public static final int U_CARSET_D26_D2_B7 = 102;
    public static final int U_CARSET_D26_D3_B10 = 111;
    public static final int U_CARSET_D26_D3_B32 = 110;
    public static final int U_CARSET_D26_D3_B6 = 109;
    public static final int U_CARSET_D26_D3_B7 = 108;
    public static final int U_CARSET_D50_D0_B10 = 114;
    public static final int U_CARSET_D50_D0_B32 = 113;
    public static final int U_CARSET_D50_D0_B54 = 112;
    public static final int U_CARSET_D50_D1_B70 = 115;
    public static final int U_CARSET_D52_D0_B7 = 116;
    public static final int U_CARSET_D52_D1_B7 = 117;
    public static final int U_CARSET_D52_D2_B20 = 118;
    public static final int U_CARSET_D5A_D0_D1 = 119;
    public static final int U_CARSET_D5A_D10_B1 = 128;
    public static final int U_CARSET_D5A_D10_B2 = 127;
    public static final int U_CARSET_D5A_D10_B3 = 126;
    public static final int U_CARSET_D5A_D10_B54 = 125;
    public static final int U_CARSET_D5A_D10_B76 = 124;
    public static final int U_CARSET_D5A_D2_D3 = 120;
    public static final int U_CARSET_D5A_D4_D5 = 121;
    public static final int U_CARSET_D5A_D6_D7 = 122;
    public static final int U_CARSET_D5A_D8_D9 = 123;
    public static final int U_CARSET_OIL_UNIT = 91;
    public static final int U_CAR_JUMP_DISC = 79;
    public static final int U_CAR_JUMP_RADIO = 78;
    public static final int U_CNT_MAX = 129;
    public static final int U_CUR_OIL_EXPEND = 87;
    public static final int U_CUR_SPEED = 7;
    public static final int U_CUR_TRIP_OIL_EXPEND = 88;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_DRIVING_MILEAGE = 86;
    public static final int U_DRIVING_TIME = 85;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 92;
    public static final int U_TRIP_OIL_EXPEND = 89;
    public static final int U_WARNNING_LIFE_BELT = 90;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0429_DJ_XP1_TOYOTA_12Crown_Low(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 29; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            if (updateCode == 55) {
                CHANNEL_FREQ_PRESET = ints;
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode == 78) {
                int value = ints[0];
                if (value == 1 && !ActivityCarRadio.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.ActivityCarRadio");
                    return;
                }
                return;
            }
            if (updateCode == 79) {
                int value2 = ints[0];
                if (value2 == 1 && !ActivityCarCD.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.ActivityCarCD");
                    return;
                }
                return;
            }
            if (updateCode == 34) {
                int value3 = ints[0];
                if (value3 == 1 && !dj_429_crown_AirControlAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.dj_429_crown_AirControlAct");
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
