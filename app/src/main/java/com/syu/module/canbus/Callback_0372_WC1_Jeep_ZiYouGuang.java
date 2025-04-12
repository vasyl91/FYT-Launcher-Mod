package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0372_WC1_Jeep_ZiYouGuang extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AIR_UNIT_OIL = 161;
    public static final int U_AMPSET_DA6_D0_B70 = 190;
    public static final int U_AMPSET_DA6_D1_B70 = 191;
    public static final int U_AMPSET_DA6_D2_B70 = 192;
    public static final int U_AMPSET_DA6_D3_B70 = 193;
    public static final int U_AMPSET_DA6_D4_B70 = 194;
    public static final int U_AMPSET_DA6_D5_B70 = 195;
    public static final int U_CARCDENDI = 154;
    public static final int U_CARCDSTATE = 143;
    public static final int U_CAR_PLAY_PROGRESS = 145;
    public static final int U_CAR_PLAY_STATE = 146;
    public static final int U_CAR_TRACK_INFO = 147;
    public static final int U_CNT_MAX = 217;
    public static final int U_CUR_SPEED = 155;
    public static final int U_DISPLAY_ENABLE_0 = 148;
    public static final int U_DISPLAY_ENABLE_1 = 149;
    public static final int U_DISPLAY_ENABLE_2 = 150;
    public static final int U_DISPLAY_ENABLE_3 = 151;
    public static final int U_DISPLAY_ENABLE_4 = 152;
    public static final int U_DISPLAY_ENABLE_5 = 153;
    public static final int U_ENGINE_SPEED = 156;
    public static final int U_PRESSURE_FL = 213;
    public static final int U_PRESSURE_FR = 214;
    public static final int U_PRESSURE_RL = 215;
    public static final int U_PRESSURE_RR = 216;
    public static final int U_SETTING_43D30 = 102;
    public static final int U_SETTING_43D31 = 101;
    public static final int U_SETTING_43D32 = 100;
    public static final int U_SETTING_43D34 = 99;
    public static final int U_SETTING_43D36 = 98;
    public static final int U_SETTING_43D40 = 108;
    public static final int U_SETTING_43D42 = 107;
    public static final int U_SETTING_43D43 = 106;
    public static final int U_SETTING_43D44 = 162;
    public static final int U_SETTING_43D45 = 105;
    public static final int U_SETTING_43D46 = 104;
    public static final int U_SETTING_43D47 = 103;
    public static final int U_SETTING_43D50 = 113;
    public static final int U_SETTING_43D52 = 112;
    public static final int U_SETTING_43D54 = 111;
    public static final int U_SETTING_43D55 = 110;
    public static final int U_SETTING_43D56 = 109;
    public static final int U_SETTING_60D00 = 125;
    public static final int U_SETTING_60D01 = 124;
    public static final int U_SETTING_60D02 = 123;
    public static final int U_SETTING_60D03 = 122;
    public static final int U_SETTING_60D04 = 121;
    public static final int U_SETTING_60D10 = 130;
    public static final int U_SETTING_60D11 = 129;
    public static final int U_SETTING_60D12 = 128;
    public static final int U_SETTING_60D13 = 127;
    public static final int U_SETTING_60D14 = 126;
    public static final int U_SETTING_60D15 = 157;
    public static final int U_SETTING_60D17 = 163;
    public static final int U_SETTING_62D14 = 158;
    public static final int U_SETTING_62D20 = 116;
    public static final int U_SETTING_62D22 = 115;
    public static final int U_SETTING_62D24 = 114;
    public static final int U_SETTING_62D26 = 159;
    public static final int U_SETTING_62D30 = 120;
    public static final int U_SETTING_62D31 = 119;
    public static final int U_SETTING_62D32 = 160;
    public static final int U_SETTING_62D33 = 118;
    public static final int U_SETTING_62D34 = 117;
    public static final int U_SETTING_62D35 = 139;
    public static final int U_SETTING_62D37 = 140;
    public static final int U_SETTING_9CD0 = 134;
    public static final int U_SETTING_A6D60 = 133;
    public static final int U_SETTING_A6D61 = 132;
    public static final int U_SETTING_BEGIN = 97;
    public static final int U_SETTING_BODY = 138;
    public static final int U_SETTING_BODYFOOT = 135;
    public static final int U_SETTING_C1D00 = 141;
    public static final int U_SETTING_C1D04 = 164;
    public static final int U_SETTING_C1D3 = 131;
    public static final int U_SETTING_D32_D10_D11 = 175;
    public static final int U_SETTING_D32_D12_B70 = 176;
    public static final int U_SETTING_D32_D13_B70 = 177;
    public static final int U_SETTING_D32_D6_B70 = 172;
    public static final int U_SETTING_D32_D8_B70 = 173;
    public static final int U_SETTING_D32_D9_B70 = 174;
    public static final int U_SETTING_D34_D0_D1 = 180;
    public static final int U_SETTING_D34_D11_B70 = 182;
    public static final int U_SETTING_D34_D12_B70 = 183;
    public static final int U_SETTING_D34_D13_B70 = 184;
    public static final int U_SETTING_D34_D14_B70 = 185;
    public static final int U_SETTING_D34_D19_B70 = 186;
    public static final int U_SETTING_D34_D20_B70 = 187;
    public static final int U_SETTING_D34_D21_B70 = 188;
    public static final int U_SETTING_D34_D22_B70 = 189;
    public static final int U_SETTING_D34_D2_D3 = 181;
    public static final int U_SETTING_D45_D3_B10 = 168;
    public static final int U_SETTING_D45_D3_B32 = 167;
    public static final int U_SETTING_D45_D3_B54 = 166;
    public static final int U_SETTING_D45_D3_B76 = 165;
    public static final int U_SETTING_D45_D4_B5 = 171;
    public static final int U_SETTING_D45_D4_B6 = 170;
    public static final int U_SETTING_D45_D4_B7 = 169;
    public static final int U_SETTING_D62_D1_B5 = 179;
    public static final int U_SETTING_D62_D1_B76 = 178;
    public static final int U_SETTING_D64_D10_B7 = 196;
    public static final int U_SETTING_D64_D11_B7 = 197;
    public static final int U_SETTING_D64_D12_B6 = 199;
    public static final int U_SETTING_D64_D12_B7 = 198;
    public static final int U_SETTING_D64_D13_B1 = 206;
    public static final int U_SETTING_D64_D13_B2 = 205;
    public static final int U_SETTING_D64_D13_B3 = 204;
    public static final int U_SETTING_D64_D13_B4 = 203;
    public static final int U_SETTING_D64_D13_B5 = 202;
    public static final int U_SETTING_D64_D13_B6 = 201;
    public static final int U_SETTING_D64_D13_B7 = 200;
    public static final int U_SETTING_D64_D14_B54 = 208;
    public static final int U_SETTING_D64_D14_B76 = 207;
    public static final int U_SETTING_D64_D15_B5 = 211;
    public static final int U_SETTING_D64_D15_B6 = 210;
    public static final int U_SETTING_D64_D15_B7 = 209;
    public static final int U_SETTING_END = 142;
    public static final int U_SETTING_FOOT = 137;
    public static final int U_SETTING_WINDFOOT = 136;
    public static final int U_SYNC_LINE_GROUP_STR = 144;
    public static final int U_TIRE_WARN = 212;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 217; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        if (carId == 4 || carId == 5) {
            //AirHelper.getInstance().buildUi(new Air_0372_WC1_Jeep_ZhiNanZhe(LauncherApplication.getInstance()));
        } else if (carId != 3) {
            //AirHelper.getInstance().buildUi(new Air_0372_WC1_Jeep_ZiYouGuang(LauncherApplication.getInstance()));
        }
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 144:
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
                if (updateCode >= 0 && updateCode < 217) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
