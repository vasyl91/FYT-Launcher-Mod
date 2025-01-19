package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0273_RZC_17MingJueRuiTeng;
//import com.syu.ui.air.Air_0273_RZC_MingJueRuiTeng;
import com.syu.ui.door.DoorHelper;

public class Callback_0273_RZC_XP1_MingJueRuiTeng extends CallbackCanbusBase {
    public static final int U_AIR_D21_D0_B0 = 190;
    public static final int U_AIR_SET_DUAL = 124;
    public static final int U_AIR_SET_REAR = 122;
    public static final int U_AIR_SET_WIND_AUTO = 123;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int[] U_CARINFO_OIL_LIST = new int[50];
    public static final int U_CARINFO_PM25 = 143;
    public static final int U_CARINFO_RX5_DISPLAY_1 = 117;
    public static final int U_CARINFO_RX5_DISPLAY_2 = 118;
    public static final int U_CARINFO_RX5_DISPLAY_3 = 119;
    public static final int U_CARINFO_RX5_DISPLAY_4 = 120;
    public static final int U_CARINFO_RX5_DISPLAY_5 = 121;
    public static final int U_CARSET_D39_D4_D5 = 198;
    public static final int U_CARSET_D39_D5_D4 = 195;
    public static final int U_CARSET_D39_D6_D15 = 173;
    public static final int U_CARSET_D39_D6_D16 = 174;
    public static final int U_CARSET_D39_D8_D2 = 197;
    public static final int U_CARSET_D39_D9_D6 = 175;
    public static final int U_CARSET_D39_D9_D7 = 196;
    public static final int U_CARSET_D41_D0_B0 = 149;
    public static final int U_CARSET_D41_D0_B1 = 129;
    public static final int U_CARSET_D41_D10_B2 = 159;
    public static final int U_CARSET_D41_D10_B43 = 158;
    public static final int U_CARSET_D41_D10_B65 = 157;
    public static final int U_CARSET_D41_D10_B7 = 156;
    public static final int U_CARSET_D41_D2_B4 = 146;
    public static final int U_CARSET_D41_D2_B5 = 130;
    public static final int U_CARSET_D41_D4_B5 = 148;
    public static final int U_CARSET_D41_D4_B6 = 147;
    public static final int U_CARSET_D41_D6_B0 = 150;
    public static final int U_CARSET_D41_D6_B1 = 135;
    public static final int U_CARSET_D41_D6_B32 = 134;
    public static final int U_CARSET_D41_D6_B4 = 133;
    public static final int U_CARSET_D41_D6_B65 = 132;
    public static final int U_CARSET_D41_D6_B7 = 131;
    public static final int U_CARSET_D41_D7_B0 = 154;
    public static final int U_CARSET_D41_D7_B1 = 153;
    public static final int U_CARSET_D41_D7_B2 = 152;
    public static final int U_CARSET_D41_D7_B3 = 151;
    public static final int U_CARSET_D41_D7_B54 = 138;
    public static final int U_CARSET_D41_D7_B6 = 137;
    public static final int U_CARSET_D41_D7_B7 = 136;
    public static final int U_CARSET_D41_D8_B21 = 155;
    public static final int U_CARSET_D41_D8_B43 = 141;
    public static final int U_CARSET_D41_D8_B65 = 140;
    public static final int U_CARSET_D41_D8_B7 = 139;
    public static final int U_CARSET_D41_D9 = 142;
    public static final int U_CARSET_D50_D0_B04 = 144;
    public static final int U_CARSET_D50_D0_B32 = 145;
    public static final int U_CARSET_D53_D0 = 176;
    public static final int U_CARSET_D53_D1 = 177;
    public static final int U_CARSET_D53_D2 = 191;
    public static final int U_CARSET_D53_D3 = 192;
    public static final int U_CARSET_D53_D4 = 193;
    public static final int U_CARSET_D53_D5 = 194;
    public static final int U_CARSET_D54_D0_B07 = 178;
    public static final int U_CARSET_D60_D0_B07 = 179;
    public static final int U_CARSET_D60_D1_D2 = 180;
    public static final int U_CARSET_D60_D3_D4 = 181;
    public static final int U_CARSET_D60_D5_D6 = 182;
    public static final int U_CARSET_D60_D7_D8 = 183;
    public static final int U_CARSET_D60_D9_D10 = 184;
    public static final int U_CARSET_D61_D0_D1 = 185;
    public static final int U_CARSET_D62_D0_D1 = 186;
    public static final int U_CARSET_D62_D2_D3 = 187;
    public static final int U_CARSET_D63_D0_D49 = 188;
    public static final int U_CARSET_D64_D0_D49 = 189;
    public static final int U_CARSET_D70_D0_B70 = 200;
    public static final int U_CAR_METER_LIGHT_LEV = 127;
    public static final int U_CAR_SETTING_END = 113;
    public static final int U_CAR_STABLE_CTRL = 125;
    public static final int U_CAR_STRS_STATE_ONE = 111;
    public static final int U_CAR_WARN = 112;
    public static final int U_CAR_WARN_FOOTMAN_BEEP = 126;
    public static final int U_CNT_MAX = 201;
    public static final int U_DISPLAY_ENABLE_0 = 99;
    public static final int U_DISPLAY_ENABLE_1 = 100;
    public static final int U_DISPLAY_ENABLE_10 = 109;
    public static final int U_DISPLAY_ENABLE_11 = 110;
    public static final int U_DISPLAY_ENABLE_2 = 101;
    public static final int U_DISPLAY_ENABLE_3 = 102;
    public static final int U_DISPLAY_ENABLE_4 = 103;
    public static final int U_DISPLAY_ENABLE_5 = 104;
    public static final int U_DISPLAY_ENABLE_6 = 105;
    public static final int U_DISPLAY_ENABLE_7 = 106;
    public static final int U_DISPLAY_ENABLE_8 = 107;
    public static final int U_DISPLAY_ENABLE_9 = 108;
    public static final int U_JUMP_CARSET = 128;
    public static final int U_SETTING_BEGIN = 98;
    public static final int U_SET_COME_HOME_WITH_ME = 116;
    public static final int U_SET_SEARCH_CAR_INDICATION = 115;
    public static final int U_SET_STEERING_FEEL = 114;
    public static final int U_STEER_BUTTON_C = 199;
    public static final int U_TIRE_ALARM_FL = 168;
    public static final int U_TIRE_ALARM_FR = 169;
    public static final int U_TIRE_ALARM_RL = 170;
    public static final int U_TIRE_ALARM_RR = 171;
    public static final int U_TIRE_PRESSURE_FL = 160;
    public static final int U_TIRE_PRESSURE_FR = 161;
    public static final int U_TIRE_PRESSURE_RL = 162;
    public static final int U_TIRE_PRESSURE_RR = 163;
    public static final int U_TIRE_TEMP_FL = 164;
    public static final int U_TIRE_TEMP_FR = 165;
    public static final int U_TIRE_TEMP_RL = 166;
    public static final int U_TIRE_TEMP_RR = 167;
    public static final int U_TIRE_UNIT = 172;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 201; i++) {
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
                //AirHelper.getInstance().buildUi(new Air_0273_RZC_17MingJueRuiTeng(LauncherApplication.getInstance()));
                break;
            default:
                //AirHelper.getInstance().buildUi(new Air_0273_RZC_MingJueRuiTeng(LauncherApplication.getInstance()));
                break;
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[14].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 112) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 188) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
        } else if (updateCode == 189) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_OIL_LIST[ints[0]] = ints[1];
        } else if (updateCode >= 0 && updateCode < 201) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
