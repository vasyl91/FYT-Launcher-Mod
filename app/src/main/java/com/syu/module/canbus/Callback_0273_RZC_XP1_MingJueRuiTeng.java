package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengAirSet;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0273_RZC_17MingJueRuiTeng;
import com.syu.ui.air.Air_0273_RZC_MingJueRuiTeng;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0273_RZC_XP1_MingJueRuiTeng extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 23;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 19;
    public static final int U_AIR_CLIMATE = 122;
    public static final int U_AIR_CLIMIT = 74;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_D21_D0_B0 = 123;
    public static final int U_AIR_DUAL = 49;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 22;
    public static final int U_AIR_REAR_AUTO = 137;
    public static final int U_AIR_REAR_BLOW_AUTO = 135;
    public static final int U_AIR_REAR_BLOW_BODY = 133;
    public static final int U_AIR_REAR_BLOW_FOOT = 134;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_REAR_LOCK = 139;
    public static final int U_AIR_REAR_POWER = 136;
    public static final int U_AIR_REAR_TEMP = 132;
    public static final int U_AIR_REAR_WINLEV = 91;
    public static final int U_AIR_SEAT_HOT_LEFT = 56;
    public static final int U_AIR_SEAT_HOT_RIGHT = 57;
    public static final int U_AIR_SET_DUAL = 52;
    public static final int U_AIR_SET_REAR = 50;
    public static final int U_AIR_SET_WIND_AUTO = 51;
    public static final int U_AIR_SYNC = 138;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int[] U_CARINFO_OIL_LIST = new int[50];
    public static final int U_CARINFO_PM25 = 73;
    public static final int U_CARINFO_RX5_DISPLAY_1 = 44;
    public static final int U_CARINFO_RX5_DISPLAY_2 = 45;
    public static final int U_CARINFO_RX5_DISPLAY_3 = 46;
    public static final int U_CARINFO_RX5_DISPLAY_4 = 47;
    public static final int U_CARINFO_RX5_DISPLAY_5 = 48;
    public static final int U_CARSET_D39_D4_D5 = 131;
    public static final int U_CARSET_D39_D5_D4 = 128;
    public static final int U_CARSET_D39_D6_D15 = 105;
    public static final int U_CARSET_D39_D6_D16 = 106;
    public static final int U_CARSET_D39_D8_D2 = 130;
    public static final int U_CARSET_D39_D9_D6 = 107;
    public static final int U_CARSET_D39_D9_D7 = 129;
    public static final int U_CARSET_D41_D0_B0 = 80;
    public static final int U_CARSET_D41_D0_B1 = 59;
    public static final int U_CARSET_D41_D10_B2 = 90;
    public static final int U_CARSET_D41_D10_B43 = 89;
    public static final int U_CARSET_D41_D10_B65 = 88;
    public static final int U_CARSET_D41_D10_B7 = 87;
    public static final int U_CARSET_D41_D2_B4 = 77;
    public static final int U_CARSET_D41_D2_B5 = 60;
    public static final int U_CARSET_D41_D4_B5 = 79;
    public static final int U_CARSET_D41_D4_B6 = 78;
    public static final int U_CARSET_D41_D6_B0 = 81;
    public static final int U_CARSET_D41_D6_B1 = 65;
    public static final int U_CARSET_D41_D6_B32 = 64;
    public static final int U_CARSET_D41_D6_B4 = 63;
    public static final int U_CARSET_D41_D6_B65 = 62;
    public static final int U_CARSET_D41_D6_B7 = 61;
    public static final int U_CARSET_D41_D7_B0 = 85;
    public static final int U_CARSET_D41_D7_B1 = 84;
    public static final int U_CARSET_D41_D7_B2 = 83;
    public static final int U_CARSET_D41_D7_B3 = 82;
    public static final int U_CARSET_D41_D7_B54 = 68;
    public static final int U_CARSET_D41_D7_B6 = 67;
    public static final int U_CARSET_D41_D7_B7 = 66;
    public static final int U_CARSET_D41_D8_B21 = 86;
    public static final int U_CARSET_D41_D8_B43 = 71;
    public static final int U_CARSET_D41_D8_B65 = 70;
    public static final int U_CARSET_D41_D8_B7 = 69;
    public static final int U_CARSET_D41_D9 = 72;
    public static final int U_CARSET_D50_D0_B04 = 75;
    public static final int U_CARSET_D50_D0_B32 = 76;
    public static final int U_CARSET_D53_D0 = 108;
    public static final int U_CARSET_D53_D1 = 109;
    public static final int U_CARSET_D53_D2 = 124;
    public static final int U_CARSET_D53_D3 = 125;
    public static final int U_CARSET_D53_D4 = 126;
    public static final int U_CARSET_D53_D5 = 127;
    public static final int U_CARSET_D54_D0_B07 = 110;
    public static final int U_CARSET_D60_D0_B07 = 111;
    public static final int U_CARSET_D60_D1_D2 = 112;
    public static final int U_CARSET_D60_D3_D4 = 113;
    public static final int U_CARSET_D60_D5_D6 = 114;
    public static final int U_CARSET_D60_D7_D8 = 115;
    public static final int U_CARSET_D60_D9_D10 = 116;
    public static final int U_CARSET_D61_D0_D1 = 117;
    public static final int U_CARSET_D62_D0_D1 = 118;
    public static final int U_CARSET_D62_D2_D3 = 119;
    public static final int U_CARSET_D63_D0_D49 = 120;
    public static final int U_CARSET_D64_D0_D49 = 121;
    public static final int U_CARSET_D70_D0_B70 = 141;
    public static final int U_CAR_METER_LIGHT_LEV = 55;
    public static final int U_CAR_SETTING_END = 40;
    public static final int U_CAR_STABLE_CTRL = 53;
    public static final int U_CAR_STRS_STATE_ONE = 38;
    public static final int U_CAR_WARN = 39;
    public static final int U_CAR_WARN_FOOTMAN_BEEP = 54;
    public static final int U_CNT_MAX = 142;
    public static final int U_DISPLAY_ENABLE_0 = 26;
    public static final int U_DISPLAY_ENABLE_1 = 27;
    public static final int U_DISPLAY_ENABLE_10 = 36;
    public static final int U_DISPLAY_ENABLE_11 = 37;
    public static final int U_DISPLAY_ENABLE_2 = 28;
    public static final int U_DISPLAY_ENABLE_3 = 29;
    public static final int U_DISPLAY_ENABLE_4 = 30;
    public static final int U_DISPLAY_ENABLE_5 = 31;
    public static final int U_DISPLAY_ENABLE_6 = 32;
    public static final int U_DISPLAY_ENABLE_7 = 33;
    public static final int U_DISPLAY_ENABLE_8 = 34;
    public static final int U_DISPLAY_ENABLE_9 = 35;
    public static final int U_JUMP_CARSET = 58;
    public static final int U_SETTING_BEGIN = 25;
    public static final int U_SET_COME_HOME_WITH_ME = 43;
    public static final int U_SET_SEARCH_CAR_INDICATION = 42;
    public static final int U_SET_STEERING_FEEL = 41;
    public static final int U_STEER_BUTTON_C = 140;
    public static final int U_TIRE_ALARM_FL = 100;
    public static final int U_TIRE_ALARM_FR = 101;
    public static final int U_TIRE_ALARM_RL = 102;
    public static final int U_TIRE_ALARM_RR = 103;
    public static final int U_TIRE_PRESSURE_FL = 92;
    public static final int U_TIRE_PRESSURE_FR = 93;
    public static final int U_TIRE_PRESSURE_RL = 94;
    public static final int U_TIRE_PRESSURE_RR = 95;
    public static final int U_TIRE_TEMP_FL = 96;
    public static final int U_TIRE_TEMP_FR = 97;
    public static final int U_TIRE_TEMP_RL = 98;
    public static final int U_TIRE_TEMP_RR = 99;
    public static final int U_TIRE_UNIT = 104;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 142; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_Mingjue_17RuiTeng /* 196881 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_EI5_L /* 393489 */:
            case FinalCanbus.CAR_RZC_XP1_RongWei_EI5_M /* 459025 */:
            case FinalCanbus.CAR_BNR_Mingjue_17GS /* 655633 */:
            case FinalCanbus.CAR_BNR_Mingjue_17ZS /* 786705 */:
            case FinalCanbus.CAR_RZC_19MingjueHS /* 852241 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5 /* 917777 */:
            case FinalCanbus.CAR_RZC_19RongWei_I6 /* 983313 */:
            case FinalCanbus.CAR_RZC_19MingjueHS_H /* 1048849 */:
            case FinalCanbus.CAR_RZC_19RongWei_I5_H /* 1114385 */:
            case FinalCanbus.CAR_RZC_17_18RongWei_I6 /* 1179921 */:
            case FinalCanbus.CAR_RZC_19MingjueEZS /* 1245457 */:
            case FinalCanbus.CAR_RZC_19RongWei_RX8 /* 1310993 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS /* 1376529 */:
            case FinalCanbus.CAR_RZC_Mingjue_20ZS_H /* 1442065 */:
                AirHelper.getInstance().buildUi(new Air_0273_RZC_17MingJueRuiTeng(LauncherApplication.getInstance()));
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0273_RZC_MingJueRuiTeng(LauncherApplication.getInstance()));
                break;
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[49].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 39) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 122) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            int value = ints[0];
            if (value == 1) {
                if (!ActRuiTengAirSet.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.mingjueruiteng.ActRuiTengAirSet");
                    return;
                } else {
                    if (ActRuiTengAirSet.mIsFront && ActRuiTengAirSet.mInstance != null) {
                        ActRuiTengAirSet.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (updateCode == 120) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
        } else if (updateCode == 121) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_OIL_LIST[ints[0]] = ints[1];
        } else if (updateCode >= 0 && updateCode < 142) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
