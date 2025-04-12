package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_RZC_Landrover_Discovery_19 extends CallbackCanbusBase {
    public static final int U_CARINF_D52_D0_D1 = 98;
    public static final int U_CARINF_D52_D2_B70 = 99;
    public static final int U_CARINF_D52_D3_D4 = 100;
    public static final int U_CARINF_D52_D5_B70 = 101;
    public static final int U_CARINF_D52_D6_D7 = 102;
    public static final int U_CARINF_D52_D8_B70 = 103;
    public static final int U_CARINF_D53_D0_B70 = 104;
    public static final int U_CARINF_D53_D1_B70 = 105;
    public static final int U_CARINF_D53_D2_B70 = 106;
    public static final int U_CARINF_D53_D3_B70 = 107;
    public static final int U_CARINF_D53_D4_B70 = 108;
    public static final int U_CARINF_D53_D5_B70 = 109;
    public static final int U_CARINF_D53_D6_B70 = 110;
    public static final int U_CARINF_D54_D0_D1 = 111;
    public static final int U_CARINF_D54_D10_D11 = 116;
    public static final int U_CARINF_D54_D12_D13 = 117;
    public static final int U_CARINF_D54_D14_B70 = 118;
    public static final int U_CARINF_D54_D2_D3 = 112;
    public static final int U_CARINF_D54_D4_D5 = 113;
    public static final int U_CARINF_D54_D6_D7 = 114;
    public static final int U_CARINF_D54_D8_D9 = 115;
    public static final int U_CARINF_D56_T0_D10_B70 = 133;
    public static final int U_CARINF_D56_T0_D11_B70 = 134;
    public static final int U_CARINF_D56_T0_D12_B70 = 135;
    public static final int U_CARINF_D56_T0_D13_B70 = 136;
    public static final int U_CARINF_D56_T0_D14_B70 = 137;
    public static final int U_CARINF_D56_T0_D15_B70 = 138;
    public static final int U_CARINF_D56_T0_D16_B70 = 139;
    public static final int U_CARINF_D56_T0_D17_B70 = 140;
    public static final int U_CARINF_D56_T0_D18_B70 = 141;
    public static final int U_CARINF_D56_T0_D1_D2_D3 = 128;
    public static final int U_CARINF_D56_T0_D4_D5 = 129;
    public static final int U_CARINF_D56_T0_D6_D7 = 130;
    public static final int U_CARINF_D56_T0_D8_B70 = 131;
    public static final int U_CARINF_D56_T0_D9_B70 = 132;
    public static final int U_CARINF_D56_T1_D10_B70 = 147;
    public static final int U_CARINF_D56_T1_D11_B70 = 148;
    public static final int U_CARINF_D56_T1_D12_B70 = 149;
    public static final int U_CARINF_D56_T1_D13_B70 = 150;
    public static final int U_CARINF_D56_T1_D14_B70 = 151;
    public static final int U_CARINF_D56_T1_D15_B70 = 152;
    public static final int U_CARINF_D56_T1_D16_B70 = 153;
    public static final int U_CARINF_D56_T1_D17_B70 = 154;
    public static final int U_CARINF_D56_T1_D18_B70 = 155;
    public static final int U_CARINF_D56_T1_D1_D2_D3 = 142;
    public static final int U_CARINF_D56_T1_D4_D5 = 143;
    public static final int U_CARINF_D56_T1_D6_D7 = 144;
    public static final int U_CARINF_D56_T1_D8_B70 = 145;
    public static final int U_CARINF_D56_T1_D9_B70 = 146;
    public static final int U_CARINF_D56_T2_D10_B70 = 161;
    public static final int U_CARINF_D56_T2_D11_B70 = 162;
    public static final int U_CARINF_D56_T2_D12_B70 = 163;
    public static final int U_CARINF_D56_T2_D13_B70 = 164;
    public static final int U_CARINF_D56_T2_D14_B70 = 165;
    public static final int U_CARINF_D56_T2_D15_B70 = 166;
    public static final int U_CARINF_D56_T2_D16_B70 = 167;
    public static final int U_CARINF_D56_T2_D17_B70 = 168;
    public static final int U_CARINF_D56_T2_D18_B70 = 169;
    public static final int U_CARINF_D56_T2_D1_D2_D3 = 156;
    public static final int U_CARINF_D56_T2_D4_D5 = 157;
    public static final int U_CARINF_D56_T2_D6_D7 = 158;
    public static final int U_CARINF_D56_T2_D8_B70 = 159;
    public static final int U_CARINF_D56_T2_D9_B70 = 160;
    public static final int U_CARINF_D56_T3_D10_B70 = 175;
    public static final int U_CARINF_D56_T3_D11_B70 = 176;
    public static final int U_CARINF_D56_T3_D12_B70 = 177;
    public static final int U_CARINF_D56_T3_D13_B70 = 178;
    public static final int U_CARINF_D56_T3_D14_B70 = 179;
    public static final int U_CARINF_D56_T3_D15_B70 = 180;
    public static final int U_CARINF_D56_T3_D16_B70 = 181;
    public static final int U_CARINF_D56_T3_D17_B70 = 182;
    public static final int U_CARINF_D56_T3_D18_B70 = 183;
    public static final int U_CARINF_D56_T3_D1_D2_D3 = 170;
    public static final int U_CARINF_D56_T3_D4_D5 = 171;
    public static final int U_CARINF_D56_T3_D6_D7 = 172;
    public static final int U_CARINF_D56_T3_D8_B70 = 173;
    public static final int U_CARINF_D56_T3_D9_B70 = 174;
    public static final int U_CARINF_D56_T4_D10_B70 = 189;
    public static final int U_CARINF_D56_T4_D11_B70 = 190;
    public static final int U_CARINF_D56_T4_D12_B70 = 191;
    public static final int U_CARINF_D56_T4_D13_B70 = 192;
    public static final int U_CARINF_D56_T4_D14_B70 = 193;
    public static final int U_CARINF_D56_T4_D15_B70 = 194;
    public static final int U_CARINF_D56_T4_D16_B70 = 195;
    public static final int U_CARINF_D56_T4_D17_B70 = 196;
    public static final int U_CARINF_D56_T4_D18_B70 = 197;
    public static final int U_CARINF_D56_T4_D1_D2_D3 = 184;
    public static final int U_CARINF_D56_T4_D4_D5 = 185;
    public static final int U_CARINF_D56_T4_D6_D7 = 186;
    public static final int U_CARINF_D56_T4_D8_B70 = 187;
    public static final int U_CARINF_D56_T4_D9_B70 = 188;
    public static final int U_CARINF_D56_T5_D10_B70 = 203;
    public static final int U_CARINF_D56_T5_D11_B70 = 204;
    public static final int U_CARINF_D56_T5_D12_B70 = 205;
    public static final int U_CARINF_D56_T5_D13_B70 = 206;
    public static final int U_CARINF_D56_T5_D14_B70 = 207;
    public static final int U_CARINF_D56_T5_D15_B70 = 208;
    public static final int U_CARINF_D56_T5_D16_B70 = 209;
    public static final int U_CARINF_D56_T5_D17_B70 = 210;
    public static final int U_CARINF_D56_T5_D18_B70 = 211;
    public static final int U_CARINF_D56_T5_D1_D2_D3 = 198;
    public static final int U_CARINF_D56_T5_D4_D5 = 199;
    public static final int U_CARINF_D56_T5_D6_D7 = 200;
    public static final int U_CARINF_D56_T5_D8_B70 = 201;
    public static final int U_CARINF_D56_T5_D9_B70 = 202;
    public static final int U_CARINF_D56_T6_D10_B70 = 217;
    public static final int U_CARINF_D56_T6_D11_B70 = 218;
    public static final int U_CARINF_D56_T6_D12_B70 = 219;
    public static final int U_CARINF_D56_T6_D13_B70 = 220;
    public static final int U_CARINF_D56_T6_D14_B70 = 221;
    public static final int U_CARINF_D56_T6_D15_B70 = 222;
    public static final int U_CARINF_D56_T6_D16_B70 = 223;
    public static final int U_CARINF_D56_T6_D17_B70 = 224;
    public static final int U_CARINF_D56_T6_D18_B70 = 225;
    public static final int U_CARINF_D56_T6_D1_D2_D3 = 212;
    public static final int U_CARINF_D56_T6_D4_D5 = 213;
    public static final int U_CARINF_D56_T6_D6_D7 = 214;
    public static final int U_CARINF_D56_T6_D8_B70 = 215;
    public static final int U_CARINF_D56_T6_D9_B70 = 216;
    public static final int U_CARINF_D57_D0_B30 = 123;
    public static final int U_CARINF_D57_D0_B4 = 122;
    public static final int U_CARINF_D57_D0_B5 = 121;
    public static final int U_CARINF_D57_D0_B6 = 120;
    public static final int U_CARINF_D57_D0_B7 = 119;
    public static final int U_CARINF_D57_D1_B0 = 124;
    public static final int U_CARINF_D60_D0_B70 = 125;
    public static final int U_CARINF_D60_D1_B70 = 126;
    public static final int U_CARINF_D60_D2_B70 = 127;
    public static final int U_CNT_MAX = 226;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 226; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0453_RZC_LandRover_Discovery_19(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 226) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
