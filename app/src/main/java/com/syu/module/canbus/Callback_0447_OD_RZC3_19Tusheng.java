package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0447_OD_RZC_19Tusheng;
import com.syu.ui.door.DoorHelper;

public class Callback_0447_OD_RZC3_19Tusheng extends CallbackCanbusBase {
    public static final int U_CARINFO_D41_D0_B30 = 221;
    public static final int U_CARINFO_D41_D0_B4 = 220;
    public static final int U_CARINFO_D52_D10_B70 = 173;
    public static final int U_CARINFO_D52_D11_B70 = 174;
    public static final int U_CARINFO_D52_D12_B70 = 175;
    public static final int U_CARINFO_D52_D13_B70 = 192;
    public static final int U_CARINFO_D52_D14_B70 = 183;
    public static final int U_CARINFO_D52_D20_B70 = 155;
    public static final int U_CARINFO_D52_D21_B70 = 156;
    public static final int U_CARINFO_D52_D22_B70 = 157;
    public static final int U_CARINFO_D52_D23_B70 = 158;
    public static final int U_CARINFO_D52_D24_B70 = 197;
    public static final int U_CARINFO_D52_D25_B70 = 198;
    public static final int U_CARINFO_D52_D26_B70 = 199;
    public static final int U_CARINFO_D52_D27_B70 = 200;
    public static final int U_CARINFO_D52_D28_B70 = 201;
    public static final int U_CARINFO_D52_D29_B70 = 202;
    public static final int U_CARINFO_D52_D2A_B70 = 203;
    public static final int U_CARINFO_D52_D2B_B70 = 204;
    public static final int U_CARINFO_D52_D2C_B70 = 205;
    public static final int U_CARINFO_D52_D2D_B70 = 206;
    public static final int U_CARINFO_D52_D2E_B70 = 207;
    public static final int U_CARINFO_D52_D30_B70 = 159;
    public static final int U_CARINFO_D52_D31_B70 = 160;
    public static final int U_CARINFO_D52_D32_B70 = 161;
    public static final int U_CARINFO_D52_D33_B70 = 162;
    public static final int U_CARINFO_D52_D34_B70 = 163;
    public static final int U_CARINFO_D52_D35_B70 = 164;
    public static final int U_CARINFO_D52_D36_B70 = 165;
    public static final int U_CARINFO_D52_D37_D1_D2 = 166;
    public static final int U_CARINFO_D52_D38_D1_D2 = 167;
    public static final int U_CARINFO_D52_D39_B70 = 208;
    public static final int U_CARINFO_D52_D3A_B70 = 209;
    public static final int U_CARINFO_D52_D40_B70 = 168;
    public static final int U_CARINFO_D52_D41_B70 = 210;
    public static final int U_CARINFO_D52_D42_B70 = 211;
    public static final int U_CARINFO_D52_D43_B70 = 212;
    public static final int U_CARINFO_D52_D44_B70 = 213;
    public static final int U_CARINFO_D52_D45_B70 = 214;
    public static final int U_CARINFO_D52_D50_B70 = 169;
    public static final int U_CARINFO_D52_D60_B70 = 170;
    public static final int U_CARINFO_D52_D61_B70 = 171;
    public static final int U_CARINFO_D52_D62_B70 = 172;
    public static final int U_CARINFO_D52_D63_B70 = 215;
    public static final int U_CARINFO_D52_D70_B70 = 176;
    public static final int U_CARINFO_D52_D71_B70 = 177;
    public static final int U_CARINFO_D52_D72_B70 = 178;
    public static final int U_CARINFO_D52_D73_B70 = 179;
    public static final int U_CARINFO_D52_D74_B70 = 216;
    public static final int U_CARINFO_D52_D75_B70 = 217;
    public static final int U_CARINFO_D52_D7_B70 = 114;
    public static final int U_CARINFO_D52_D80_B70 = 180;
    public static final int U_CARINFO_D52_D81_B70 = 181;
    public static final int U_CARINFO_D52_D82_B70 = 182;
    public static final int U_CARINFO_D52_D83_B70 = 183;
    public static final int U_CARINFO_D52_D84_B70 = 218;
    public static final int U_CARINFO_D52_D8_B70 = 115;
    public static final int U_CARINFO_D52_D90_B70 = 184;
    public static final int U_CARINFO_D52_D91_B70 = 185;
    public static final int U_CARINFO_D52_D92_B70 = 186;
    public static final int U_CARINFO_D52_D93_B70 = 219;
    public static final int U_CARINFO_D52_D9_B70 = 116;
    public static final int U_CARINFO_D52_DA0_B70 = 187;
    public static final int U_CARINFO_D52_DA1_B70 = 188;
    public static final int U_CARINFO_D52_DA2_B70 = 189;
    public static final int U_CARINFO_D52_DA3_B70 = 190;
    public static final int U_CARINFO_D52_DA4_B70 = 191;
    public static final int U_CARINFO_D52_DA_B70 = 117;
    public static final int U_CARINFO_D52_DB_B70 = 118;
    public static final int U_CARINFO_D52_DC_B70 = 119;
    public static final int U_CARINFO_D52_DD_B70 = 120;
    public static final int U_CARINFO_D52_DE_B70 = 121;
    public static final int U_CARINFO_D52_DF_B70 = 122;
    public static final int U_CARINFO_D53_D0_B70 = 123;
    public static final int U_CARINFO_D53_D10_B10 = 138;
    public static final int U_CARINFO_D53_D10_B32 = 137;
    public static final int U_CARINFO_D53_D10_B4 = 136;
    public static final int U_CARINFO_D53_D10_B5 = 135;
    public static final int U_CARINFO_D53_D10_B6 = 134;
    public static final int U_CARINFO_D53_D10_B7 = 133;
    public static final int U_CARINFO_D53_D11_B70 = 139;
    public static final int U_CARINFO_D53_D1_B70 = 124;
    public static final int U_CARINFO_D53_D2_B70 = 125;
    public static final int U_CARINFO_D53_D3_B70 = 126;
    public static final int U_CARINFO_D53_D4_B70 = 127;
    public static final int U_CARINFO_D53_D5_B70 = 128;
    public static final int U_CARINFO_D53_D6_B70 = 129;
    public static final int U_CARINFO_D53_D7_B70 = 130;
    public static final int U_CARINFO_D53_D8_B70 = 131;
    public static final int U_CARINFO_D53_D9_B70 = 132;
    public static final int U_CARINFO_D54_D0_B70 = 140;
    public static final int U_CARINFO_D54_D10_D11 = 146;
    public static final int U_CARINFO_D54_D1_D2 = 141;
    public static final int U_CARINFO_D54_D3_D4 = 142;
    public static final int U_CARINFO_D54_D5_B70 = 143;
    public static final int U_CARINFO_D54_D6_B70 = 144;
    public static final int U_CARINFO_D54_D7_D8_D9 = 145;
    public static final int U_CARINFO_D55_D0_D1 = 147;
    public static final int U_CARINFO_D55_D11_B30 = 154;
    public static final int U_CARINFO_D55_D11_B74 = 153;
    public static final int U_CARINFO_D55_D2_D3 = 148;
    public static final int U_CARINFO_D55_D4_D5 = 149;
    public static final int U_CARINFO_D55_D6_B70 = 150;
    public static final int U_CARINFO_D55_D7_D8 = 151;
    public static final int U_CARINFO_D55_D9_D10 = 152;
    public static final int U_CARINFO_D60_D00_B70 = 195;
    public static final int U_CARINFO_EQ_BAL = 102;
    public static final int U_CARINFO_EQ_BASS = 98;
    public static final int U_CARINFO_EQ_FAD = 101;
    public static final int U_CARINFO_EQ_MID = 99;
    public static final int U_CARINFO_EQ_TREB = 100;
    public static final int U_CARINFO_EQ_VOL = 196;
    public static final int U_CARINFO_LAGUAGE = 194;
    public static final int U_CARSET_AUTO_TEMP_CTRL = 109;
    public static final int U_CARSET_BEGIN = 103;
    public static final int U_CARSET_BLIND_POINT = 108;
    public static final int U_CARSET_GUIJI = 104;
    public static final int U_CARSET_RADAR = 105;
    public static final int U_CARSET_SEAT_HOTBLOW = 113;
    public static final int U_CARSET_STEER_HOT = 112;
    public static final int U_CARSET_THIRD_SEAT_LEFT = 110;
    public static final int U_CARSET_THIRD_SEAT_RIGHT = 111;
    public static final int U_CARSET_VIEW_FRONT = 106;
    public static final int U_CARSET_VIEW_REAR = 107;
    public static final int U_CNT_MAX = 222;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 222; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_447_OD_RZC_19Tusheng /* 65983 */:
            case FinalCanbus.CAR_447_OD_RZC_19Tusheng_H /* 131519 */:
            case FinalCanbus.CAR_447_OD_RZC_19Tusheng_Top /* 197055 */:
                //AirHelper.getInstance().buildUi(new Air_0447_OD_RZC_19Tusheng(LauncherApplication.getInstance()));
                break;
            default:
                //AirHelper.getInstance().buildUi(new Air_0447_RZC_XianDai_All(LauncherApplication.getInstance()));
                break;
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 222) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
