package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.ford.MustangCarCDAct;
import com.syu.carinfo.ford.MustangCarRadioAct;
import com.syu.carinfo.wc.ruijie15.RuijieAirControlAct_Rzc;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0334_RZC_15Ruijie;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

public class Callback_0334_RZC_XP1_Focus2015 extends CallbackCanbusBase {
    public static final int C_CONTRAL = 1;
    public static final int C_REQUEST_AUTO = 0;
    public static final int U_AUTO_REQUEST = 110;
    public static final int U_BT_STATE = 103;
    public static final int U_CARCD_PLAY_STATE = 194;
    public static final int U_CARCD_PLAY_TIME = 191;
    public static final int U_CARCD_RANDOM = 196;
    public static final int U_CARCD_REPEAT = 195;
    public static final int U_CARCD_STATE = 180;
    public static final int U_CARCD_TOTAL_TIME = 192;
    public static final int U_CARCD_TRACK = 189;
    public static final int U_CARCD_TRACK_TOTAL = 190;
    public static final int U_CARCD_WORK_STATE = 193;
    public static final int U_CARINFO_AVG_OIL = 144;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_DRIVEANBLE_MILE = 143;
    public static final int U_CARINFO_END = 112;
    public static final int U_CARINFO_EX_D62_D0_B30 = 160;
    public static final int U_CARINFO_EX_D62_D0_B74 = 159;
    public static final int U_CARINFO_EX_D62_D1_B30 = 162;
    public static final int U_CARINFO_EX_D62_D1_B74 = 161;
    public static final int U_CARINFO_EX_D62_D2_B30 = 164;
    public static final int U_CARINFO_EX_D62_D2_B74 = 163;
    public static final int U_CARINFO_EX_D62_D3_B6 = 197;
    public static final int U_CARINFO_EX_D62_D3_B7 = 165;
    public static final int U_CARINFO_EX_D62_D4_B70 = 166;
    public static final int U_CARINFO_EX_D64_D0_B43 = 169;
    public static final int U_CARINFO_EX_D64_D0_B65 = 168;
    public static final int U_CARINFO_EX_D64_D0_B7 = 167;
    public static final int U_CARINFO_EX_D64_D1_B30 = 171;
    public static final int U_CARINFO_EX_D64_D1_B74 = 170;
    public static final int U_CARINFO_EX_D64_D2_B10 = 174;
    public static final int U_CARINFO_EX_D64_D2_B32 = 173;
    public static final int U_CARINFO_EX_D64_D2_B74 = 172;
    public static final int U_CARINFO_EX_D64_D3_B30 = 176;
    public static final int U_CARINFO_EX_D64_D3_B74 = 175;
    public static final int U_CARINFO_EX_D64_D4_B10 = 179;
    public static final int U_CARINFO_EX_D64_D4_B32 = 178;
    public static final int U_CARINFO_EX_D64_D4_B74 = 177;
    public static final int U_CARINFO_LAST_OIL = 145;
    public static final int U_CARINFO_TC_D24_D5_B0 = 251;
    public static final int U_CARINFO_TC_D24_D5_B1 = 250;
    public static final int U_CARINFO_TC_D24_D5_B2 = 249;
    public static final int U_CARINFO_TC_D24_D5_B3 = 248;
    public static final int U_CARINFO_TC_D24_D5_B4 = 158;
    public static final int U_CARINFO_TC_D24_D6_B5 = 254;
    public static final int U_CARINFO_TC_D24_D6_B6 = 253;
    public static final int U_CARINFO_TC_D24_D6_B7 = 252;
    public static final int U_CARINFO_TOTAL_MILE = 142;
    public static final int U_CARINF_D69_D0_B70 = 243;
    public static final int U_CARINF_D69_D1_D2 = 244;
    public static final int U_CARINF_D69_D3_B70 = 245;
    public static final int U_CARINF_D69_D4_B70 = 246;
    public static final int U_CARINF_TIRE_UNIT = 247;
    public static final int U_CARRADIO_BAND = 181;
    public static final int U_CARRADIO_CHNNEL = 198;
    public static final int U_CARRADIO_FRQ = 182;
    public static final int U_CARRADIO_FRQ1 = 183;
    public static final int U_CARRADIO_FRQ2 = 184;
    public static final int U_CARRADIO_FRQ3 = 185;
    public static final int U_CARRADIO_FRQ4 = 186;
    public static final int U_CARRADIO_FRQ5 = 187;
    public static final int U_CARRADIO_FRQ6 = 188;
    public static final int U_CARSET_AMBIENT_LIGHT = 125;
    public static final int U_CARSET_AMBIENT_LIGHT_EN = 127;
    public static final int U_CARSET_AMBIENT_LIGHT_LEV = 126;
    public static final int U_CARSET_AUTO_LIGHT_SENSOR = 132;
    public static final int U_CARSET_AUTO_UNLOCK = 133;
    public static final int U_CARSET_BEEP_WARN = 131;
    public static final int U_CARSET_BRIGHTNESS = 118;
    public static final int U_CARSET_D28_D0_B70 = 200;
    public static final int U_CARSET_D28_D10_B70 = 208;
    public static final int U_CARSET_D28_D11_B70 = 209;
    public static final int U_CARSET_D28_D12_B70 = 210;
    public static final int U_CARSET_D28_D13_B70 = 211;
    public static final int U_CARSET_D28_D14_B70 = 212;
    public static final int U_CARSET_D28_D1_B70 = 201;
    public static final int U_CARSET_D28_D20_B70 = 213;
    public static final int U_CARSET_D28_D21_B70 = 214;
    public static final int U_CARSET_D28_D22_B70 = 215;
    public static final int U_CARSET_D28_D23_B70 = 216;
    public static final int U_CARSET_D28_D24_B70 = 217;
    public static final int U_CARSET_D28_D25_B70 = 218;
    public static final int U_CARSET_D28_D2_B70 = 202;
    public static final int U_CARSET_D28_D30_B70 = 219;
    public static final int U_CARSET_D28_D3_B70 = 203;
    public static final int U_CARSET_D28_D40_B70 = 220;
    public static final int U_CARSET_D28_D4_B70 = 204;
    public static final int U_CARSET_D28_D50_B70 = 221;
    public static final int U_CARSET_D28_D51_B70 = 222;
    public static final int U_CARSET_D28_D52_B70 = 223;
    public static final int U_CARSET_D28_D53_B70 = 224;
    public static final int U_CARSET_D28_D54_B70 = 225;
    public static final int U_CARSET_D28_D55_B70 = 226;
    public static final int U_CARSET_D28_D56_B70 = 227;
    public static final int U_CARSET_D28_D57_B70 = 228;
    public static final int U_CARSET_D28_D58_B70 = 229;
    public static final int U_CARSET_D28_D59_B70 = 230;
    public static final int U_CARSET_D28_D5A_B70 = 231;
    public static final int U_CARSET_D28_D5B_B70 = 232;
    public static final int U_CARSET_D28_D5C_B70 = 233;
    public static final int U_CARSET_D28_D5_B70 = 205;
    public static final int U_CARSET_D28_D60_B70 = 234;
    public static final int U_CARSET_D28_D61_B70 = 235;
    public static final int U_CARSET_D28_D62_B70 = 236;
    public static final int U_CARSET_D28_D63_B70 = 237;
    public static final int U_CARSET_D28_D64_B70 = 238;
    public static final int U_CARSET_D28_D6_B70 = 206;
    public static final int U_CARSET_D28_D70_B70 = 239;
    public static final int U_CARSET_D28_D71_B70 = 240;
    public static final int U_CARSET_D28_D72_B70 = 241;
    public static final int U_CARSET_D28_D7_B70 = 207;
    public static final int U_CARSET_D28_D80_B70 = 242;
    public static final int U_CARSET_HOME_LIGHT = 141;
    public static final int U_CARSET_INFORMATION = 116;
    public static final int U_CARSET_INTERIORLIGHTING = 122;
    public static final int U_CARSET_LIGHT_INTER_TIME = 138;
    public static final int U_CARSET_NOLINE_CHARG = 136;
    public static final int U_CARSET_RAINSENSOR = 124;
    public static final int U_CARSET_REARVIEW_AUTO = 139;
    public static final int U_CARSET_REARVIEW_SPLIT = 130;
    public static final int U_CARSET_REARVIEW_STAY = 128;
    public static final int U_CARSET_REARVIEW_ZOOM = 129;
    public static final int U_CARSET_REAR_DEFROG_TIME = 140;
    public static final int U_CARSET_REMOTE_WIN = 135;
    public static final int U_CARSET_SPEED_LOCK = 137;
    public static final int U_CARSET_TOWSYSTEM = 115;
    public static final int U_CARSET_TURNLIGHT = 121;
    public static final int U_CARSET_TYREMONITOR = 123;
    public static final int U_CARSET_UNIT = 119;
    public static final int U_CARSET_VOICEMODE = 120;
    public static final int U_CARSET_WARNING = 117;
    public static final int U_CARSET_WELCOME_LIGHT = 134;
    public static final int U_CAR_ENGINE_SPEED = 114;
    public static final int U_CAR_SPEED = 113;
    public static final int U_CAR_TIRE_TEMP_FL = 154;
    public static final int U_CAR_TIRE_TEMP_FR = 155;
    public static final int U_CAR_TIRE_TEMP_RL = 156;
    public static final int U_CAR_TIRE_TEMP_RR = 157;
    public static final int U_CAR_TIRE_VALUE_FL = 146;
    public static final int U_CAR_TIRE_VALUE_FR = 147;
    public static final int U_CAR_TIRE_VALUE_RL = 148;
    public static final int U_CAR_TIRE_VALUE_RR = 149;
    public static final int U_CAR_TIRE_WARN_FL = 150;
    public static final int U_CAR_TIRE_WARN_FR = 151;
    public static final int U_CAR_TIRE_WARN_RL = 152;
    public static final int U_CAR_TIRE_WARN_RR = 153;
    public static final int U_CAR_WARN = 111;
    public static final int U_CNT_MAX = 255;
    public static final int U_CUR_WORK_MODE = 107;
    public static final int U_DISPLAY_MODE = 102;
    public static final int U_LINE_GROUP = 100;
    public static final int U_LIST_INFO = 105;
    public static final int U_METER_STEER_KEY = 199;
    public static final int U_MODE_STATE = 108;
    public static final int U_PARM_WARM = 104;
    public static final int U_PHONE_STATE = 109;
    public static final int U_PHONE_TIME = 106;
    public static final int U_PLAY_TIME = 101;
    public static final int U_SCREEN_ICON = 99;
    public static final int U_SCREEN_ID = 98;
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { 
        @Override
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

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 255; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
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
                //AirHelper.getInstance().buildUi(new Air_0334_RZC_15Ruijie(LauncherApplication.getInstance()));
                for (int i3 = 10; i3 < 97; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
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

    private void showCotrolCD(int updateCode, int[] ints) {
        if (updateCode == 180) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 2 && !MustangCarCDAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ford.MustangCarCDAct");
            } else if (value == 1 && !MustangCarRadioAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ford.MustangCarRadioAct");
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 99 || updateCode == 100 || updateCode == 105 || updateCode == 111 || updateCode == 110) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 10) {
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
        if (updateCode == 180) {
            showCotrolCD(updateCode, ints);
            return;
        }
        if (updateCode == 183) {
            if (strs != null && strs.length > 0) {
                RadioFrq1 = strs[0];
            } else {
                RadioFrq1 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 184) {
            if (strs != null && strs.length > 0) {
                RadioFrq2 = strs[0];
            } else {
                RadioFrq2 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 185) {
            if (strs != null && strs.length > 0) {
                RadioFrq3 = strs[0];
            } else {
                RadioFrq3 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 186) {
            if (strs != null && strs.length > 0) {
                RadioFrq4 = strs[0];
            } else {
                RadioFrq4 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 187) {
            if (strs != null && strs.length > 0) {
                RadioFrq5 = strs[0];
            } else {
                RadioFrq5 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode == 188) {
            if (strs != null && strs.length > 0) {
                RadioFrq6 = strs[0];
            } else {
                RadioFrq6 = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 255) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
