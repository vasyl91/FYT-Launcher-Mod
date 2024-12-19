package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.klc.RzcKlcAirCtrlAct;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0061_RZC_XP1_GM;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0061_RZC_XP1_GM extends CallbackCanbusBase {
    public static final int REQUEST_CAR_INFO = 8;
    public static final int U_AIR_AC = 34;
    public static final int U_AIR_AQS_ON = 44;
    public static final int U_AIR_AUTO = 58;
    public static final int U_AIR_BEGIN = 32;
    public static final int U_AIR_BLOW_AUTO_LEFT = 45;
    public static final int U_AIR_BLOW_AUTO_REAR = 68;
    public static final int U_AIR_BLOW_BODY_LEFT = 40;
    public static final int U_AIR_BLOW_BODY_REAR = 66;
    public static final int U_AIR_BLOW_FOOT_LEFT = 41;
    public static final int U_AIR_BLOW_FOOT_REAR = 67;
    public static final int U_AIR_BLOW_UP_LEFT = 39;
    public static final int U_AIR_BLOW_WIND_LEFT = 46;
    public static final int U_AIR_CLIMITE_SHOW = 63;
    public static final int U_AIR_CYCLE = 32;
    public static final int U_AIR_END = 47;
    public static final int U_AIR_LOCK_REAR = 69;
    public static final int U_AIR_PARTITION_TEMP = 2;
    public static final int U_AIR_POWER_ON = 43;
    public static final int U_AIR_QUALITY_SENSOR = 1;
    public static final int U_AIR_REAR_DEFROST = 33;
    public static final int U_AIR_SEAT_HEAT_LEFT = 35;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 36;
    public static final int U_AIR_START_MODE_SET = 6;
    public static final int U_AIR_SYNC_REAR = 70;
    public static final int U_AIR_TEMP_LEFT = 37;
    public static final int U_AIR_TEMP_REAR = 64;
    public static final int U_AIR_TEMP_RIGHT = 38;
    public static final int U_AIR_WIND_LEVEL_LEFT = 42;
    public static final int U_AIR_WIND_LEVEL_SEAT_LEFT = 59;
    public static final int U_AIR_WIND_LEVEL_SEAT_RIGHT = 60;
    public static final int U_AIR_WINLEV_REAR = 65;
    public static final int U_AIR_ZONE = 57;
    public static final int U_ANJIXING_PHONE_STATE = 20;
    public static final int U_ANJIXING_STATE = 21;
    public static final int U_AUTO_COLLISION = 29;
    public static final int U_AUTO_FRONT_GOFOG_ON = 4;
    public static final int U_AUTO_REAR_GOFOG_ON = 3;
    public static final int U_AUTO_WIND_MODE = 0;
    public static final int U_AUTO_WIPERS = 26;
    public static final int U_BLIND_SIDE = 27;
    public static final int U_CARINFO_RESERVE = 19;
    public static final int U_CARINF_D05_D1_B4 = 102;
    public static final int U_CARINF_D05_D1_B5 = 101;
    public static final int U_CARINF_D06_D1_B0 = 103;
    public static final int U_CARINF_D0A_D1_B10 = 86;
    public static final int U_CARINF_D0A_D1_B2 = 85;
    public static final int U_CARINF_D0A_D1_B3 = 84;
    public static final int U_CARINF_D0A_D1_B4 = 83;
    public static final int U_CARINF_D0A_D2_B0 = 93;
    public static final int U_CARINF_D0A_D2_B1 = 92;
    public static final int U_CARINF_D0A_D2_B32 = 91;
    public static final int U_CARINF_D0A_D2_B4 = 90;
    public static final int U_CARINF_D0A_D2_B5 = 89;
    public static final int U_CARINF_D0A_D2_B6 = 88;
    public static final int U_CARINF_D0A_D2_B7 = 87;
    public static final int U_CARINF_D0A_D3_B10 = 100;
    public static final int U_CARINF_D0A_D3_B2 = 99;
    public static final int U_CARINF_D0A_D3_B3 = 98;
    public static final int U_CARINF_D0A_D3_B4 = 97;
    public static final int U_CARINF_D0A_D3_B5 = 96;
    public static final int U_CARINF_D0A_D3_B6 = 95;
    public static final int U_CARINF_D0A_D3_B7 = 94;
    public static final int U_CARINF_D0A_D4_B0 = 110;
    public static final int U_CARINF_D0A_D4_B1 = 109;
    public static final int U_CARINF_D0A_D4_B2 = 108;
    public static final int U_CARINF_D0A_D4_B3 = 107;
    public static final int U_CARINF_D0A_D4_B4 = 106;
    public static final int U_CARINF_D0A_D4_B65 = 105;
    public static final int U_CARINF_D0A_D4_B7 = 104;
    public static final int U_CARINF_D47_D0_B7 = 71;
    public static final int U_CARINF_D47_D1_B2 = 77;
    public static final int U_CARINF_D47_D1_B3 = 76;
    public static final int U_CARINF_D47_D1_B4 = 75;
    public static final int U_CARINF_D47_D1_B5 = 74;
    public static final int U_CARINF_D47_D1_B6 = 73;
    public static final int U_CARINF_D47_D1_B7 = 72;
    public static final int U_CARINF_D47_D2_B4 = 81;
    public static final int U_CARINF_D47_D2_B5 = 80;
    public static final int U_CARINF_D47_D2_B6 = 79;
    public static final int U_CARINF_D47_D2_B7 = 78;
    public static final int U_CARINF_D47_D3_B70 = 82;
    public static final int U_CARINF_D4A_D001_D1_B70 = 112;
    public static final int U_CARINF_D4A_D001_D2_B70 = 113;
    public static final int U_CARINF_D4A_D001_D3_B70 = 114;
    public static final int U_CARINF_D4A_D001_D4_B70 = 115;
    public static final int U_CARINF_D4A_D001_D5_B70 = 116;
    public static final int U_CARINF_D4A_D002_D1_D2 = 117;
    public static final int U_CARINF_D4A_D002_D3_D4 = 118;
    public static final int U_CARINF_D4A_D002_D5_D6 = 136;
    public static final int U_CARINF_D4A_D003_D10_D11_D12 = 128;
    public static final int U_CARINF_D4A_D003_D13_B70 = 129;
    public static final int U_CARINF_D4A_D003_D14_D15 = 130;
    public static final int U_CARINF_D4A_D003_D16_D17 = 131;
    public static final int U_CARINF_D4A_D003_D1_B32 = 123;
    public static final int U_CARINF_D4A_D003_D1_B4 = 122;
    public static final int U_CARINF_D4A_D003_D1_B5 = 121;
    public static final int U_CARINF_D4A_D003_D1_B6 = 120;
    public static final int U_CARINF_D4A_D003_D1_B7 = 119;
    public static final int U_CARINF_D4A_D003_D2_D3_D4 = 124;
    public static final int U_CARINF_D4A_D003_D5_B70 = 125;
    public static final int U_CARINF_D4A_D003_D6_D7 = 126;
    public static final int U_CARINF_D4A_D003_D8_D9 = 127;
    public static final int U_CARINF_D4A_D004_D1_B70 = 139;
    public static final int U_CARINF_D4A_D004_D2_B70 = 140;
    public static final int U_CARINF_D4A_D004_D3_B70 = 141;
    public static final int U_CARINF_D4A_D004_D4_D5 = 142;
    public static final int U_CARINF_D4A_D004_D6_D7 = 143;
    public static final int U_CARINF_D4A_D004_D8_B70 = 144;
    public static final int U_CARINF_D4A_D004_D9_B70 = 145;
    public static final int U_CARINF_D4B_CD_TXT = 135;
    public static final int U_CARINF_D4B_D00_B3 = 134;
    public static final int U_CARINF_D4B_D00_B64 = 133;
    public static final int U_CARINF_D4B_D00_B7 = 132;
    public static final int U_CARTIME_SET = 111;
    public static final int U_CAR_BUTTON_DOWN = 138;
    public static final int U_CAR_BUTTON_UP = 137;
    public static final int U_CAR_LANGUAGE = 62;
    public static final int U_CAR_STATUS = 30;
    public static final int U_CNT_MAX = 146;
    public static final int U_DELAY_TO_LOCK_SET = 12;
    public static final int U_DOOR_BACK = 53;
    public static final int U_DOOR_BEGIN = 48;
    public static final int U_DOOR_END = 54;
    public static final int U_DOOR_ENGINE = 48;
    public static final int U_DOOR_FL = 49;
    public static final int U_DOOR_FR = 50;
    public static final int U_DOOR_RL = 51;
    public static final int U_DOOR_RR = 52;
    public static final int U_DRIVER_PERSONAL_SET = 24;
    public static final int U_FORGET_KEY = 23;
    public static final int U_LEARVER_CAR_LOCK = 28;
    public static final int U_LOOKING_FOR_LIGHT = 7;
    public static final int U_LUOSUO_DELAY_SET = 8;
    public static final int U_NEAR_CAR_UNLOCK = 22;
    public static final int U_PARKING_AUTO_UNLOCK = 11;
    public static final int U_PREVENT_AUTO_LUOSUO = 9;
    public static final int U_REAR_WIPERS_AUTO_START = 16;
    public static final int U_RELOCK_REMOTE_OPEN_DOOR = 25;
    public static final int U_REMOTE_AGAIN_LOCK_DOOR = 17;
    public static final int U_REMOTE_LOCK_LIGHT_OR_SPEAKER_FEEDBACK = 14;
    public static final int U_REMOTE_LOCK_SET = 15;
    public static final int U_REMOTE_START_CAR = 18;
    public static final int U_REMOTE_START_HEAT_SEAT = 5;
    public static final int U_REMOTE_UNLOCK_LIGHT_FEEDBACK = 13;
    public static final int U_START_AUTO_LUOSUO = 10;
    public static final int U_WARN_VOLUME = 31;
    public static final int U_WIFI_NAME = 55;
    public static final int U_WIFI_PSWORD = 56;
    public static final int U_WIND_MODE = 61;
    public static String WifiName;
    public static String WifiPsword;
    public static String cdText;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 146; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 48;
        DoorHelper.sUcDoorFl = 49;
        DoorHelper.sUcDoorFr = 50;
        DoorHelper.sUcDoorRl = 51;
        DoorHelper.sUcDoorRr = 52;
        DoorHelper.sUcDoorBack = 53;
        AirHelper.getInstance().buildUi(new Air_0061_RZC_XP1_GM(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 48; i2 < 54; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 32; i3 < 47; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[63].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 48; i < 54; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 32; i2 < 47; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int value = ints[0];
        if (value == 1) {
            if (!RzcKlcAirCtrlAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.klc.RzcKlcAirCtrlAct");
            }
        } else if (value == 0 && RzcKlcAirCtrlAct.mIsFront && RzcKlcAirCtrlAct.mInstance != null) {
            RzcKlcAirCtrlAct.mInstance.finish();
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 20:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 55:
                if (strs != null && strs.length > 0) {
                    WifiName = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 56:
                if (strs != null && strs.length > 0) {
                    WifiPsword = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 63:
                showCotrolAir(updateCode, ints);
                break;
            case 135:
                if (strs != null && strs.length > 0) {
                    cdText = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 146) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
