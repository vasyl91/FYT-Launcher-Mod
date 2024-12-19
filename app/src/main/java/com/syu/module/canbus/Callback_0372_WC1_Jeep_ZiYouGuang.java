package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0372_WC1_Jeep_ZhiNanZhe;
import com.syu.ui.air.Air_0372_WC1_Jeep_ZiYouGuang;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0372_WC1_Jeep_ZiYouGuang extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AIR_AC = 62;
    public static final int U_AIR_AUTO = 58;
    public static final int U_AIR_BACKMIRROR = 77;
    public static final int U_AIR_BEGIN = 57;
    public static final int U_AIR_BLOW_AUTO_LEFT = 75;
    public static final int U_AIR_BLOW_BODY_LEFT = 64;
    public static final int U_AIR_BLOW_FOOT_LEFT = 65;
    public static final int U_AIR_BLOW_MODE = 87;
    public static final int U_AIR_BLOW_UP_LEFT = 66;
    public static final int U_AIR_CYCLE = 59;
    public static final int U_AIR_END = 78;
    public static final int U_AIR_FRONT_DEFROST = 60;
    public static final int U_AIR_MAXAC = 67;
    public static final int U_AIR_POWER = 72;
    public static final int U_AIR_REAR_AUTO = 112;
    public static final int U_AIR_REAR_BLOW_BODY = 113;
    public static final int U_AIR_REAR_BLOW_FOOT = 114;
    public static final int U_AIR_REAR_CTRL = 111;
    public static final int U_AIR_REAR_DEFROST = 61;
    public static final int U_AIR_REAR_POWER = 110;
    public static final int U_AIR_REAR_TEMP = 116;
    public static final int U_AIR_REAR_WIN_LEV = 115;
    public static final int U_AIR_SEAT_BLOW_LEFT = 119;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 120;
    public static final int U_AIR_SEAT_HEAT_LEFT = 69;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 70;
    public static final int U_AIR_STEER_HOT = 131;
    public static final int U_AIR_SYNC = 76;
    public static final int U_AIR_TEMP_LEFT = 63;
    public static final int U_AIR_TEMP_RIGHT = 71;
    public static final int U_AIR_TEMP_UNIT = 73;
    public static final int U_AIR_UNIT = 74;
    public static final int U_AIR_UNIT_OIL = 93;
    public static final int U_AIR_UNIT_TEMP = 92;
    public static final int U_AIR_WIND_LEVEL_LEFT = 68;
    public static final int U_AMPSET_DA6_D0_B70 = 132;
    public static final int U_AMPSET_DA6_D1_B70 = 133;
    public static final int U_AMPSET_DA6_D2_B70 = 134;
    public static final int U_AMPSET_DA6_D3_B70 = 135;
    public static final int U_AMPSET_DA6_D4_B70 = 136;
    public static final int U_AMPSET_DA6_D5_B70 = 137;
    public static final int U_CARCDENDI = 57;
    public static final int U_CARCDSTATE = 46;
    public static final int U_CAR_PLAY_PROGRESS = 48;
    public static final int U_CAR_PLAY_STATE = 49;
    public static final int U_CAR_TRACK_INFO = 50;
    public static final int U_CNT_MAX = 154;
    public static final int U_CUR_SPEED = 85;
    public static final int U_DISPLAY_ENABLE_0 = 51;
    public static final int U_DISPLAY_ENABLE_1 = 52;
    public static final int U_DISPLAY_ENABLE_2 = 53;
    public static final int U_DISPLAY_ENABLE_3 = 54;
    public static final int U_DISPLAY_ENABLE_4 = 55;
    public static final int U_DISPLAY_ENABLE_5 = 56;
    public static final int U_DOOR_BACK = 83;
    public static final int U_DOOR_BEGIN = 78;
    public static final int U_DOOR_END = 84;
    public static final int U_DOOR_ENGINE = 78;
    public static final int U_DOOR_FL = 79;
    public static final int U_DOOR_FR = 80;
    public static final int U_DOOR_RL = 81;
    public static final int U_DOOR_RR = 82;
    public static final int U_ENGINE_SPEED = 86;
    public static final int U_SETTING_43D30 = 5;
    public static final int U_SETTING_43D31 = 4;
    public static final int U_SETTING_43D32 = 3;
    public static final int U_SETTING_43D34 = 2;
    public static final int U_SETTING_43D36 = 1;
    public static final int U_SETTING_43D40 = 11;
    public static final int U_SETTING_43D42 = 10;
    public static final int U_SETTING_43D43 = 9;
    public static final int U_SETTING_43D44 = 94;
    public static final int U_SETTING_43D45 = 8;
    public static final int U_SETTING_43D46 = 7;
    public static final int U_SETTING_43D47 = 6;
    public static final int U_SETTING_43D50 = 16;
    public static final int U_SETTING_43D52 = 15;
    public static final int U_SETTING_43D54 = 14;
    public static final int U_SETTING_43D55 = 13;
    public static final int U_SETTING_43D56 = 12;
    public static final int U_SETTING_60D00 = 28;
    public static final int U_SETTING_60D01 = 27;
    public static final int U_SETTING_60D02 = 26;
    public static final int U_SETTING_60D03 = 25;
    public static final int U_SETTING_60D04 = 24;
    public static final int U_SETTING_60D10 = 33;
    public static final int U_SETTING_60D11 = 32;
    public static final int U_SETTING_60D12 = 31;
    public static final int U_SETTING_60D13 = 30;
    public static final int U_SETTING_60D14 = 29;
    public static final int U_SETTING_60D15 = 88;
    public static final int U_SETTING_60D17 = 95;
    public static final int U_SETTING_62D14 = 89;
    public static final int U_SETTING_62D20 = 19;
    public static final int U_SETTING_62D22 = 18;
    public static final int U_SETTING_62D24 = 17;
    public static final int U_SETTING_62D26 = 90;
    public static final int U_SETTING_62D30 = 23;
    public static final int U_SETTING_62D31 = 22;
    public static final int U_SETTING_62D32 = 91;
    public static final int U_SETTING_62D33 = 21;
    public static final int U_SETTING_62D34 = 20;
    public static final int U_SETTING_62D35 = 42;
    public static final int U_SETTING_62D37 = 43;
    public static final int U_SETTING_9CD0 = 37;
    public static final int U_SETTING_A6D60 = 36;
    public static final int U_SETTING_A6D61 = 35;
    public static final int U_SETTING_BEGIN = 0;
    public static final int U_SETTING_BODY = 41;
    public static final int U_SETTING_BODYFOOT = 38;
    public static final int U_SETTING_C1D00 = 44;
    public static final int U_SETTING_C1D04 = 96;
    public static final int U_SETTING_C1D3 = 34;
    public static final int U_SETTING_D32_D10_D11 = 107;
    public static final int U_SETTING_D32_D12_B70 = 108;
    public static final int U_SETTING_D32_D13_B70 = 109;
    public static final int U_SETTING_D32_D6_B70 = 104;
    public static final int U_SETTING_D32_D8_B70 = 105;
    public static final int U_SETTING_D32_D9_B70 = 106;
    public static final int U_SETTING_D34_D0_D1 = 121;
    public static final int U_SETTING_D34_D11_B70 = 123;
    public static final int U_SETTING_D34_D12_B70 = 124;
    public static final int U_SETTING_D34_D13_B70 = 125;
    public static final int U_SETTING_D34_D14_B70 = 126;
    public static final int U_SETTING_D34_D19_B70 = 127;
    public static final int U_SETTING_D34_D20_B70 = 128;
    public static final int U_SETTING_D34_D21_B70 = 129;
    public static final int U_SETTING_D34_D22_B70 = 130;
    public static final int U_SETTING_D34_D2_D3 = 122;
    public static final int U_SETTING_D45_D3_B10 = 100;
    public static final int U_SETTING_D45_D3_B32 = 99;
    public static final int U_SETTING_D45_D3_B54 = 98;
    public static final int U_SETTING_D45_D3_B76 = 97;
    public static final int U_SETTING_D45_D4_B5 = 103;
    public static final int U_SETTING_D45_D4_B6 = 102;
    public static final int U_SETTING_D45_D4_B7 = 101;
    public static final int U_SETTING_D62_D1_B5 = 118;
    public static final int U_SETTING_D62_D1_B76 = 117;
    public static final int U_SETTING_D64_D10_B7 = 138;
    public static final int U_SETTING_D64_D11_B7 = 139;
    public static final int U_SETTING_D64_D12_B6 = 141;
    public static final int U_SETTING_D64_D12_B7 = 140;
    public static final int U_SETTING_D64_D13_B1 = 148;
    public static final int U_SETTING_D64_D13_B2 = 147;
    public static final int U_SETTING_D64_D13_B3 = 146;
    public static final int U_SETTING_D64_D13_B4 = 145;
    public static final int U_SETTING_D64_D13_B5 = 144;
    public static final int U_SETTING_D64_D13_B6 = 143;
    public static final int U_SETTING_D64_D13_B7 = 142;
    public static final int U_SETTING_D64_D14_B54 = 150;
    public static final int U_SETTING_D64_D14_B76 = 149;
    public static final int U_SETTING_D64_D15_B5 = 153;
    public static final int U_SETTING_D64_D15_B6 = 152;
    public static final int U_SETTING_D64_D15_B7 = 151;
    public static final int U_SETTING_END = 45;
    public static final int U_SETTING_FOOT = 40;
    public static final int U_SETTING_WINDFOOT = 39;
    public static final int U_SYNC_LINE_GROUP_STR = 47;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 154; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 78;
        DoorHelper.sUcDoorFl = 79;
        DoorHelper.sUcDoorFr = 80;
        DoorHelper.sUcDoorRl = 81;
        DoorHelper.sUcDoorRr = 82;
        DoorHelper.sUcDoorBack = 83;
        DoorHelper.getInstance().buildUi();
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carId == 4 || carId == 5) {
            AirHelper.getInstance().buildUi(new Air_0372_WC1_Jeep_ZhiNanZhe(LauncherApplication.getInstance()));
            for (int i2 = 57; i2 < 78; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
            DataCanbus.NOTIFY_EVENTS[92].addNotify(AirHelper.SHOW_AND_REFRESH);
        } else if (carId != 3) {
            AirHelper.getInstance().buildUi(new Air_0372_WC1_Jeep_ZiYouGuang(LauncherApplication.getInstance()));
            for (int i3 = 57; i3 < 78; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
            DataCanbus.NOTIFY_EVENTS[92].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i4 = 78; i4 < 84; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 57; i < 78; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(AirHelper.SHOW_AND_REFRESH);
        for (int i2 = 78; i2 < 84; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 47:
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
            default:
                if (updateCode >= 0 && updateCode < 154) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
