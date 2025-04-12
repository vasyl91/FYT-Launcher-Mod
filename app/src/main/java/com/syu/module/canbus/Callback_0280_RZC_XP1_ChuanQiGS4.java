package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.wc.gs4.GS4SOSAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0280_RZC_XP1_ChuanQiGS4 extends CallbackCanbusBase {
    public static final int U_AIR_NEG_IONS = 127;
    public static final int U_AIR_WARNING = 100;
    public static final int U_CARINFO_BACKLIGHT = 99;
    public static final int U_CARINFO_SOS = 101;
    public static final int U_CARSET_ADD_AIR_SENSOR = 161;
    public static final int U_CARSET_ADD_AIR_WINLEV_AUTO = 162;
    public static final int U_CARSET_ADD_AUTO_LOCK = 153;
    public static final int U_CARSET_ADD_AUTO_UNLOCK = 154;
    public static final int U_CARSET_ADD_BEGIN = 151;
    public static final int U_CARSET_ADD_D52_D27 = 164;
    public static final int U_CARSET_ADD_D52_D28 = 165;
    public static final int U_CARSET_ADD_D52_D29 = 166;
    public static final int U_CARSET_ADD_D52_D2A = 167;
    public static final int U_CARSET_ADD_D52_D2B = 168;
    public static final int U_CARSET_ADD_D52_D2C = 169;
    public static final int U_CARSET_ADD_D52_D2D = 170;
    public static final int U_CARSET_ADD_D52_D2E = 171;
    public static final int U_CARSET_ADD_D52_D2F = 172;
    public static final int U_CARSET_ADD_D52_D30 = 173;
    public static final int U_CARSET_ADD_D52_D31 = 174;
    public static final int U_CARSET_ADD_D52_D32 = 175;
    public static final int U_CARSET_ADD_D52_D33 = 176;
    public static final int U_CARSET_ADD_D52_D34 = 179;
    public static final int U_CARSET_ADD_D52_D35 = 180;
    public static final int U_CARSET_ADD_D52_D36 = 181;
    public static final int U_CARSET_ADD_D52_D37 = 182;
    public static final int U_CARSET_ADD_D52_D38 = 183;
    public static final int U_CARSET_ADD_D52_D39 = 184;
    public static final int U_CARSET_ADD_D52_D3A = 185;
    public static final int U_CARSET_ADD_D52_D3B = 186;
    public static final int U_CARSET_ADD_D52_D3C = 187;
    public static final int U_CARSET_ADD_D55_D01 = 188;
    public static final int U_CARSET_ADD_D55_D02 = 189;
    public static final int U_CARSET_ADD_D55_D03 = 190;
    public static final int U_CARSET_ADD_D55_D04 = 191;
    public static final int U_CARSET_ADD_D55_D05 = 192;
    public static final int U_CARSET_ADD_D55_D06 = 193;
    public static final int U_CARSET_ADD_D55_D07 = 194;
    public static final int U_CARSET_ADD_D55_D08 = 195;
    public static final int U_CARSET_ADD_D58_D01 = 196;
    public static final int U_CARSET_ADD_D58_D02 = 197;
    public static final int U_CARSET_ADD_D58_D03 = 198;
    public static final int U_CARSET_ADD_D58_D04 = 199;
    public static final int U_CARSET_ADD_D58_D05 = 200;
    public static final int U_CARSET_ADD_D58_D06 = 201;
    public static final int U_CARSET_ADD_D58_D07 = 202;
    public static final int U_CARSET_ADD_D58_D08 = 203;
    public static final int U_CARSET_ADD_LEFT_LINE = 159;
    public static final int U_CARSET_ADD_LIGHT_COLOR = 160;
    public static final int U_CARSET_ADD_LOCK_BEEP = 152;
    public static final int U_CARSET_ADD_REARVIEW_AUTO = 156;
    public static final int U_CARSET_ADD_REARVIEW_HAND = 155;
    public static final int U_CARSET_ADD_RIGHT_LINE = 158;
    public static final int U_CARSET_ADD_WELCOME_AUTO = 157;
    public static final int U_CARSET_RIGHT_ENTER_CAMERA = 163;
    public static final int U_CAR_AIR_AUTO_STATE = 131;
    public static final int U_CAR_AIR_CYCLE_STATE = 107;
    public static final int U_CAR_AIR_SOFT_SET = 108;
    public static final int U_CAR_CHARGING_REPEAT = 138;
    public static final int U_CAR_CHARGING_REPEAT_1 = 139;
    public static final int U_CAR_CHARGING_REPEAT_2 = 140;
    public static final int U_CAR_CHARGING_REPEAT_3 = 141;
    public static final int U_CAR_CHARGING_REPEAT_4 = 142;
    public static final int U_CAR_CHARGING_REPEAT_5 = 143;
    public static final int U_CAR_CHARGING_REPEAT_6 = 144;
    public static final int U_CAR_CHARGING_REPEAT_7 = 145;
    public static final int U_CAR_CHARGING_TIMETOSTART = 146;
    public static final int U_CAR_CHARGING_TIME_END = 137;
    public static final int U_CAR_CHARGING_TIME_START = 136;
    public static final int U_CAR_DRIVE_AUTO_UNLOCK = 118;
    public static final int U_CAR_DRIVE_METER_ALARM_VOLUME = 112;
    public static final int U_CAR_DRIVE_OVER_SPEED = 111;
    public static final int U_CAR_DRIVE_RAINBRUSH_MAINTAIN = 120;
    public static final int U_CAR_DRIVE_REAR_RAINBRUSH_AUTO_BRUSH = 121;
    public static final int U_CAR_DRIVE_REMOTE_LEFT_TOP_WINDOW = 119;
    public static final int U_CAR_DRIVE_REMOTE_POWERON_TIME = 113;
    public static final int U_CAR_DRIVE_REMOTE_START_TIME = 114;
    public static final int U_CAR_DRIVE_REMOTE_UNLOCK = 116;
    public static final int U_CAR_DRIVE_SPEED_LOCKUP = 117;
    public static final int U_CAR_DRIVE_TURN_MODE = 115;
    public static final int U_CAR_ELECTRICITY_FLOW = 147;
    public static final int U_CAR_ENERGY_CYCLE_LEV = 149;
    public static final int U_CAR_ENERGY_D54_D9_B52 = 178;
    public static final int U_CAR_ENERGY_D54_D9_B6 = 177;
    public static final int U_CAR_ENERGY_FLOW = 148;
    public static final int U_CAR_ENERGY_IPEDAL = 150;
    public static final int U_CAR_ENERGY_OD_D53_D10_B70 = 208;
    public static final int U_CAR_ENERGY_OD_D53_D9_B10 = 207;
    public static final int U_CAR_ENERGY_OD_D53_D9_B4 = 206;
    public static final int U_CAR_ENERGY_OD_D53_D9_B5 = 205;
    public static final int U_CAR_ENERGY_OD_D53_D9_B6 = 204;
    public static final int U_CAR_LANG = 106;
    public static final int U_CAR_LEFT_LINE = 134;
    public static final int U_CAR_LIGHT_AUTOLIGHT_SENSE = 126;
    public static final int U_CAR_LIGHT_DAYLIGHT = 125;
    public static final int U_CAR_LIGHT_FROGLIGHT_TURN = 124;
    public static final int U_CAR_LIGHT_HOME_WITH_ME = 123;
    public static final int U_CAR_LIGHT_WELCOME = 135;
    public static final int U_CAR_REAR_MIRROR_FOLD = 130;
    public static final int U_CAR_RIGHT_LINE = 134;
    public static final int U_CAR_RMIRROR_AUTO = 133;
    public static final int U_CAR_RMIRROR_MANUAL = 132;
    public static final int U_CAR_SEAT_AUTOHEAT_LEFT = 109;
    public static final int U_CAR_SEAT_AUTOHEAT_RIGHT = 110;
    public static final int U_CAR_SMART_KEY = 129;
    public static final int U_CAR_TRACK_INFO = 98;
    public static final int U_CAR_WELLCOME = 128;
    public static final int U_CNT_MAX = 209;
    public static final int U_CUR_SPEED = 104;
    public static final int U_ENGINE_SPEED = 105;
    public static final int U_SMART_LOCK = 102;
    public static final int U_SMART_UNLOCK = 103;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 209; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 262424 || DataCanbus.DATA[1000] == 459032 || DataCanbus.DATA[1000] == 524568 || DataCanbus.DATA[1000] == 1311000 || DataCanbus.DATA[1000] == 1245464 || DataCanbus.DATA[1000] == 1835288) {
            //AirHelper.getInstance().buildUi(new Air_0280_RZC_GS8(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            //AirHelper.getInstance().buildUi(new Air_0280_RZC_XP1_ChuangQiGs4(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i4 = 10; i4 < 97; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void showSoS(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int value = ints[0];
        if ((value == 1 || value == 2) && !GS4SOSAct.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.gs4.GS4SOSAct");
        } else if (GS4SOSAct.mIsFront && value == 0 && GS4SOSAct.mIsFront && GS4SOSAct.mInstance != null) {
            GS4SOSAct.mInstance.finish();
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
        if (updateCode >= 0 && updateCode < 209) {
            switch (updateCode) {
                case 101:
                    showSoS(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
