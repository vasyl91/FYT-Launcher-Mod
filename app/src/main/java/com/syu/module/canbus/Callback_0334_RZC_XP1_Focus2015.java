package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.ford.MustangCarCDAct;
import com.syu.carinfo.ford.MustangCarRadioAct;
import com.syu.carinfo.wc.ruijie15.RuijieAirControlAct_Rzc;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0334_RZC_15Ruijie;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0334_RZC_XP1_Focus2015 extends CallbackCanbusBase {
    public static final int C_CONTRAL = 1;
    public static final int C_REQUEST_AUTO = 0;
    public static final int U_AIR_AUTOAIR_MODE = 53;
    public static final int U_AIR_FRONT_DEFROG = 56;
    public static final int U_AIR_REAR_CTRL = 52;
    public static final int U_AIR_REAR_DEFROG = 48;
    public static final int U_AIR_REAR_POWER = 51;
    public static final int U_AIR_REAR_TEMP = 49;
    public static final int U_AIR_REAR_WIND_LEVEL = 50;
    public static final int U_AIR_SEATBLOW_LEFT = 181;
    public static final int U_AIR_SEATBLOW_RIGHT = 182;
    public static final int U_AIR_SEATHEAT_LEFT = 54;
    public static final int U_AIR_SEATHEAT_RIGHT = 55;
    public static final int U_AIR_STEER_HOT = 112;
    public static final int U_CARCD_PLAY_STATE = 127;
    public static final int U_CARCD_PLAY_TIME = 124;
    public static final int U_CARCD_RANDOM = 129;
    public static final int U_CARCD_REPEAT = 128;
    public static final int U_CARCD_STATE = 113;
    public static final int U_CARCD_TOTAL_TIME = 125;
    public static final int U_CARCD_TRACK = 122;
    public static final int U_CARCD_TRACK_TOTAL = 123;
    public static final int U_CARCD_WORK_STATE = 126;
    public static final int U_CARINFO_AVG_OIL = 76;
    public static final int U_CARINFO_DRIVEANBLE_MILE = 75;
    public static final int U_CARINFO_EX_D62_D0_B30 = 92;
    public static final int U_CARINFO_EX_D62_D0_B74 = 91;
    public static final int U_CARINFO_EX_D62_D1_B30 = 94;
    public static final int U_CARINFO_EX_D62_D1_B74 = 93;
    public static final int U_CARINFO_EX_D62_D2_B30 = 96;
    public static final int U_CARINFO_EX_D62_D2_B74 = 95;
    public static final int U_CARINFO_EX_D62_D3_B6 = 130;
    public static final int U_CARINFO_EX_D62_D3_B7 = 97;
    public static final int U_CARINFO_EX_D62_D4_B70 = 98;
    public static final int U_CARINFO_EX_D64_D0_B43 = 101;
    public static final int U_CARINFO_EX_D64_D0_B65 = 100;
    public static final int U_CARINFO_EX_D64_D0_B7 = 99;
    public static final int U_CARINFO_EX_D64_D1_B30 = 103;
    public static final int U_CARINFO_EX_D64_D1_B74 = 102;
    public static final int U_CARINFO_EX_D64_D2_B10 = 106;
    public static final int U_CARINFO_EX_D64_D2_B32 = 105;
    public static final int U_CARINFO_EX_D64_D2_B74 = 104;
    public static final int U_CARINFO_EX_D64_D3_B30 = 108;
    public static final int U_CARINFO_EX_D64_D3_B74 = 107;
    public static final int U_CARINFO_EX_D64_D4_B10 = 111;
    public static final int U_CARINFO_EX_D64_D4_B32 = 110;
    public static final int U_CARINFO_EX_D64_D4_B74 = 109;
    public static final int U_CARINFO_LAST_OIL = 77;
    public static final int U_CARINFO_TC_D24_D5_B0 = 186;
    public static final int U_CARINFO_TC_D24_D5_B1 = 185;
    public static final int U_CARINFO_TC_D24_D5_B2 = 184;
    public static final int U_CARINFO_TC_D24_D5_B3 = 183;
    public static final int U_CARINFO_TC_D24_D5_B4 = 90;
    public static final int U_CARINFO_TC_D24_D6_B5 = 189;
    public static final int U_CARINFO_TC_D24_D6_B6 = 188;
    public static final int U_CARINFO_TC_D24_D6_B7 = 187;
    public static final int U_CARINFO_TOTAL_MILE = 74;
    public static final int U_CARINF_D69_D0_B70 = 176;
    public static final int U_CARINF_D69_D1_D2 = 177;
    public static final int U_CARINF_D69_D3_B70 = 178;
    public static final int U_CARINF_D69_D4_B70 = 179;
    public static final int U_CARINF_TIRE_UNIT = 180;
    public static final int U_CARRADIO_BAND = 114;
    public static final int U_CARRADIO_CHNNEL = 131;
    public static final int U_CARRADIO_FRQ = 115;
    public static final int U_CARRADIO_FRQ1 = 116;
    public static final int U_CARRADIO_FRQ2 = 117;
    public static final int U_CARRADIO_FRQ3 = 118;
    public static final int U_CARRADIO_FRQ4 = 119;
    public static final int U_CARRADIO_FRQ5 = 120;
    public static final int U_CARRADIO_FRQ6 = 121;
    public static final int U_CARSET_AMBIENT_LIGHT = 57;
    public static final int U_CARSET_AMBIENT_LIGHT_EN = 59;
    public static final int U_CARSET_AMBIENT_LIGHT_LEV = 58;
    public static final int U_CARSET_AUTO_LIGHT_SENSOR = 64;
    public static final int U_CARSET_AUTO_UNLOCK = 65;
    public static final int U_CARSET_BEEP_WARN = 63;
    public static final int U_CARSET_D28_D0_B70 = 133;
    public static final int U_CARSET_D28_D10_B70 = 141;
    public static final int U_CARSET_D28_D11_B70 = 142;
    public static final int U_CARSET_D28_D12_B70 = 143;
    public static final int U_CARSET_D28_D13_B70 = 144;
    public static final int U_CARSET_D28_D14_B70 = 145;
    public static final int U_CARSET_D28_D1_B70 = 134;
    public static final int U_CARSET_D28_D20_B70 = 146;
    public static final int U_CARSET_D28_D21_B70 = 147;
    public static final int U_CARSET_D28_D22_B70 = 148;
    public static final int U_CARSET_D28_D23_B70 = 149;
    public static final int U_CARSET_D28_D24_B70 = 150;
    public static final int U_CARSET_D28_D25_B70 = 151;
    public static final int U_CARSET_D28_D2_B70 = 135;
    public static final int U_CARSET_D28_D30_B70 = 152;
    public static final int U_CARSET_D28_D3_B70 = 136;
    public static final int U_CARSET_D28_D40_B70 = 153;
    public static final int U_CARSET_D28_D4_B70 = 137;
    public static final int U_CARSET_D28_D50_B70 = 154;
    public static final int U_CARSET_D28_D51_B70 = 155;
    public static final int U_CARSET_D28_D52_B70 = 156;
    public static final int U_CARSET_D28_D53_B70 = 157;
    public static final int U_CARSET_D28_D54_B70 = 158;
    public static final int U_CARSET_D28_D55_B70 = 159;
    public static final int U_CARSET_D28_D56_B70 = 160;
    public static final int U_CARSET_D28_D57_B70 = 161;
    public static final int U_CARSET_D28_D58_B70 = 162;
    public static final int U_CARSET_D28_D59_B70 = 163;
    public static final int U_CARSET_D28_D5A_B70 = 164;
    public static final int U_CARSET_D28_D5B_B70 = 165;
    public static final int U_CARSET_D28_D5C_B70 = 166;
    public static final int U_CARSET_D28_D5_B70 = 138;
    public static final int U_CARSET_D28_D60_B70 = 167;
    public static final int U_CARSET_D28_D61_B70 = 168;
    public static final int U_CARSET_D28_D62_B70 = 169;
    public static final int U_CARSET_D28_D63_B70 = 170;
    public static final int U_CARSET_D28_D64_B70 = 171;
    public static final int U_CARSET_D28_D6_B70 = 139;
    public static final int U_CARSET_D28_D70_B70 = 172;
    public static final int U_CARSET_D28_D71_B70 = 173;
    public static final int U_CARSET_D28_D72_B70 = 174;
    public static final int U_CARSET_D28_D7_B70 = 140;
    public static final int U_CARSET_D28_D80_B70 = 175;
    public static final int U_CARSET_HOME_LIGHT = 73;
    public static final int U_CARSET_LIGHT_INTER_TIME = 70;
    public static final int U_CARSET_NOLINE_CHARG = 68;
    public static final int U_CARSET_REARVIEW_AUTO = 71;
    public static final int U_CARSET_REARVIEW_SPLIT = 62;
    public static final int U_CARSET_REARVIEW_STAY = 60;
    public static final int U_CARSET_REARVIEW_ZOOM = 61;
    public static final int U_CARSET_REAR_DEFROG_TIME = 72;
    public static final int U_CARSET_REMOTE_WIN = 67;
    public static final int U_CARSET_SPEED_LOCK = 69;
    public static final int U_CARSET_WELCOME_LIGHT = 66;
    public static final int U_CAR_ENGINE_SPEED = 37;
    public static final int U_CAR_TIRE_TEMP_FL = 86;
    public static final int U_CAR_TIRE_TEMP_FR = 87;
    public static final int U_CAR_TIRE_TEMP_RL = 88;
    public static final int U_CAR_TIRE_TEMP_RR = 89;
    public static final int U_CAR_TIRE_VALUE_FL = 78;
    public static final int U_CAR_TIRE_VALUE_FR = 79;
    public static final int U_CAR_TIRE_VALUE_RL = 80;
    public static final int U_CAR_TIRE_VALUE_RR = 81;
    public static final int U_CAR_TIRE_WARN_FL = 82;
    public static final int U_CAR_TIRE_WARN_FR = 83;
    public static final int U_CAR_TIRE_WARN_RL = 84;
    public static final int U_CAR_TIRE_WARN_RR = 85;
    public static final int U_CNT_MAX = 190;
    public static final int U_METER_STEER_KEY = 132;
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { // from class: com.syu.module.canbus.Callback_0334_RZC_XP1_Focus2015.1
        @Override // java.lang.Runnable
        public void run() {
            if (RuijieAirControlAct_Rzc.mIsFront && Callback_0334_RZC_XP1_Focus2015.jump && RuijieAirControlAct_Rzc.mInstance != null) {
                RuijieAirControlAct_Rzc.mInstance.finish();
                Callback_0334_RZC_XP1_Focus2015.jump = false;
            }
        }
    };
    public static String RadioFrq1 = "";
    public static String RadioFrq2 = "";
    public static String RadioFrq3 = "";
    public static String RadioFrq4 = "";
    public static String RadioFrq5 = "";
    public static String RadioFrq6 = "";
    static int power = 0;
    public static boolean jump = false;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 190; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 29;
        DoorHelper.sUcDoorFr = 30;
        DoorHelper.sUcDoorRl = 31;
        DoorHelper.sUcDoorRr = 32;
        DoorHelper.sUcDoorBack = 33;
        DoorHelper.sUcDoorEngine = 34;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 29; i2 < 35; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB /* 1376590 */:
            case FinalCanbus.CAR_RZC_Ford_18Everest_FLB_H /* 1442126 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low1 /* 1507662 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_SUV_Low2 /* 1573198 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_Low /* 1638734 */:
            case FinalCanbus.CAR_RZC_Ford_Everest_PickUP_H /* 1704270 */:
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0334_RZC_15Ruijie(LauncherApplication.getInstance()));
                DataCanbus.NOTIFY_EVENTS[48].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[49].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[50].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[51].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[52].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[53].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[54].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[55].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[112].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                for (int i3 = 14; i3 < 29; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 29; i < 35; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 14; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showCotrolCD(int updateCode, int[] ints) {
        if (updateCode == 113) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 2 && !MustangCarCDAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ford.MustangCarCDAct");
            } else if (value == 1 && !MustangCarRadioAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ford.MustangCarRadioAct");
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1 || updateCode == 2 || updateCode == 7 || updateCode == 13 || updateCode == 12) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 15) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            if (459086 == DataCanbus.DATA[1000] || 1179982 == DataCanbus.DATA[1000] || 1245518 == DataCanbus.DATA[1000]) {
                if (power != ints[0]) {
                    power = ints[0];
                    if (!RuijieAirControlAct_Rzc.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.ruijie15.RuijieAirControlAct_Rzc");
                        jump = true;
                    }
                }
                if (jump) {
                    HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
                    HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 5000L);
                    return;
                }
                return;
            }
            return;
        }
        if (updateCode == 113) {
            showCotrolCD(updateCode, ints);
            return;
        }
        if (updateCode == 116) {
            if (strs != null && strs.length > 0) {
                RadioFrq1 = strs[0];
            } else {
                RadioFrq1 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 117) {
            if (strs != null && strs.length > 0) {
                RadioFrq2 = strs[0];
            } else {
                RadioFrq2 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 118) {
            if (strs != null && strs.length > 0) {
                RadioFrq3 = strs[0];
            } else {
                RadioFrq3 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 119) {
            if (strs != null && strs.length > 0) {
                RadioFrq4 = strs[0];
            } else {
                RadioFrq4 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 120) {
            if (strs != null && strs.length > 0) {
                RadioFrq5 = strs[0];
            } else {
                RadioFrq5 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 121) {
            if (strs != null && strs.length > 0) {
                RadioFrq6 = strs[0];
            } else {
                RadioFrq6 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 190) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
