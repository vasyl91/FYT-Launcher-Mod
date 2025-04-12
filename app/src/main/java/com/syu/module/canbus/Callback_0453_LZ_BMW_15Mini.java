package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_BMW_15Mini extends CallbackCanbusBase {
    public static final int U_CARINF_D12_D1_B6 = 99;
    public static final int U_CARINF_D12_D1_B7 = 98;
    public static final int U_CARINF_D12_D2_B70 = 100;
    public static final int U_CARINF_D19_D0_B30 = 165;
    public static final int U_CARINF_D19_D0_B6 = 164;
    public static final int U_CARINF_D19_D0_B7 = 163;
    public static final int U_CARINF_D19_D1_B0 = 173;
    public static final int U_CARINF_D19_D1_B1 = 172;
    public static final int U_CARINF_D19_D1_B2 = 171;
    public static final int U_CARINF_D19_D1_B3 = 170;
    public static final int U_CARINF_D19_D1_B4 = 169;
    public static final int U_CARINF_D19_D1_B5 = 168;
    public static final int U_CARINF_D19_D1_B6 = 167;
    public static final int U_CARINF_D19_D1_B7 = 166;
    public static final int U_CARINF_D19_D2_B0 = 174;
    public static final int U_CARINF_D19_D3_B70 = 175;
    public static final int U_CARINF_D19_D4_B70 = 176;
    public static final int U_CARINF_D19_D5_B70 = 177;
    public static final int U_CARINF_D40_D0_D1_D2 = 101;
    public static final int U_CARINF_D40_D3_D4 = 102;
    public static final int U_CARINF_D46_D0_B3 = 107;
    public static final int U_CARINF_D46_D0_B4 = 106;
    public static final int U_CARINF_D46_D0_B5 = 105;
    public static final int U_CARINF_D46_D0_B6 = 104;
    public static final int U_CARINF_D46_D0_B7 = 103;
    public static final int U_CARINF_D46_D1_B54 = 109;
    public static final int U_CARINF_D46_D1_B7 = 108;
    public static final int U_CARINF_D46_D2_B0 = 178;
    public static final int U_CARINF_D46_D2_B1 = 112;
    public static final int U_CARINF_D46_D2_B32 = 111;
    public static final int U_CARINF_D46_D2_B74 = 110;
    public static final int U_CARINF_D46_D3_B4 = 116;
    public static final int U_CARINF_D46_D3_B5 = 115;
    public static final int U_CARINF_D46_D3_B6 = 114;
    public static final int U_CARINF_D46_D3_B7 = 113;
    public static final int U_CARINF_D46_D4_B70 = 117;
    public static final int U_CARINF_D46_D5_B10 = 179;
    public static final int U_CARINF_D46_D5_B2 = 123;
    public static final int U_CARINF_D46_D5_B3 = 122;
    public static final int U_CARINF_D46_D5_B4 = 121;
    public static final int U_CARINF_D46_D5_B5 = 120;
    public static final int U_CARINF_D46_D5_B6 = 119;
    public static final int U_CARINF_D46_D5_B7 = 118;
    public static final int U_CARINF_D46_D6_B7 = 124;
    public static final int U_CARINF_D46_WARN_SPEED = 125;
    public static final int U_CARINF_D48_D0_D1 = 126;
    public static final int U_CARINF_D48_D2_D3 = 127;
    public static final int U_CARINF_D48_D4_D5 = 128;
    public static final int U_CARINF_D49_D0_B0 = 130;
    public static final int U_CARINF_D49_D0_B64 = 130;
    public static final int U_CARINF_D49_D0_B7 = 129;
    public static final int U_CARINF_D49_D11_D12 = 142;
    public static final int U_CARINF_D49_D13_B70 = 143;
    public static final int U_CARINF_D49_D14_D15 = 144;
    public static final int U_CARINF_D49_D16_D17 = 145;
    public static final int U_CARINF_D49_D18_D19 = 146;
    public static final int U_CARINF_D49_D1_B10 = 134;
    public static final int U_CARINF_D49_D1_B32 = 133;
    public static final int U_CARINF_D49_D1_B54 = 132;
    public static final int U_CARINF_D49_D1_B76 = 131;
    public static final int U_CARINF_D49_D20_D21 = 147;
    public static final int U_CARINF_D49_D2_B32 = 137;
    public static final int U_CARINF_D49_D2_B54 = 136;
    public static final int U_CARINF_D49_D2_B76 = 135;
    public static final int U_CARINF_D49_D4_B70 = 138;
    public static final int U_CARINF_D49_D5_D6 = 139;
    public static final int U_CARINF_D49_D7_D8 = 140;
    public static final int U_CARINF_D49_D9_D10 = 141;
    public static final int U_CARINF_D4A_D0_B0 = 150;
    public static final int U_CARINF_D4A_D0_B64 = 149;
    public static final int U_CARINF_D4A_D0_B7 = 148;
    public static final int U_CARINF_D4A_D1_B70 = 151;
    public static final int U_CARINF_D4B_D0_B70 = 152;
    public static final int U_CARINF_D4B_D1_B70 = 153;
    public static final int U_CARINF_D4B_D2_B70 = 154;
    public static final int U_CARINF_D4B_D3_B70 = 155;
    public static final int U_CARINF_D4B_D4_B54 = 158;
    public static final int U_CARINF_D4B_D4_B6 = 157;
    public static final int U_CARINF_D4B_D4_B7 = 156;
    public static final int U_CARINF_D4B_D5_B70 = 159;
    public static final int U_CARINF_D4B_D6_B70 = 160;
    public static final int U_CARINF_D4B_D7_B7 = 161;
    public static final int U_CARINF_D4B_DISTANCE = 162;
    public static final int U_CARINF_D50_T1_D1_B70 = 180;
    public static final int U_CARINF_D50_T1_D2_B70 = 181;
    public static final int U_CARINF_D50_T1_D3_B70 = 182;
    public static final int U_CARINF_D50_T1_D4_B70 = 183;
    public static final int U_CARINF_D50_T1_D5_B70 = 184;
    public static final int U_CARINF_D50_T1_D6_B70 = 185;
    public static final int U_CARINF_D50_T2_D1_B70 = 186;
    public static final int U_CARINF_D50_T2_D2_B70 = 187;
    public static final int U_CARINF_D50_T3_D1_B70 = 188;
    public static final int U_CARINF_D50_T3_D2_B70 = 189;
    public static final int U_CARINF_D50_T4_D1_B5 = 192;
    public static final int U_CARINF_D50_T4_D1_B6 = 191;
    public static final int U_CARINF_D50_T4_D1_B7 = 190;
    public static final int U_CARINF_D50_T4_D2_B70 = 193;
    public static final int U_CARINF_D50_T4_D3_B70 = 194;
    public static final int U_CARINF_D50_T4_D4_B70 = 195;
    public static final int U_CARINF_D50_T4_D5_B70 = 196;
    public static final int U_CNT_MAX = 197;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 197; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0453_LZ_BMW_15Mini(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 197) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
