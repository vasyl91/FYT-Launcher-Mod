package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0416_WC_RongWei_Rx5;
import com.syu.ui.door.DoorHelper;

public class Callback_0416_WC2_RongWeiRX5 extends CallbackCanbusBase {
    public static final int U_CARINFO_BATTERY_VOLTAGE = 98;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D14_D1_D50 = 168;
    public static final int U_CARINFO_D15_D1_D50 = 169;
    public static final int U_CARINFO_D34_D10_D11 = 164;
    public static final int U_CARINFO_D34_D12_D13 = 165;
    public static final int U_CARINFO_D34_D15_D16 = 166;
    public static final int U_CARINFO_D34_D20_D21 = 167;
    public static final int U_CARINFO_D34_D4_D5_D6 = 162;
    public static final int U_CARINFO_D34_D7_D8 = 163;
    public static final int U_CARINFO_D35_D2_B10 = 100;
    public static final int U_CARINFO_D35_D2_B76 = 99;
    public static final int U_CARINFO_D35_D3_B1 = 101;
    public static final int U_CARINFO_D35_D4_B3 = 102;
    public static final int U_CARINFO_D3F_D1_D2 = 170;
    public static final int U_CARINFO_D3F_D3_B70 = 171;
    public static final int U_CARINFO_D3F_D6_D7 = 172;
    public static final int U_CARINFO_D3F_D8_D9 = 173;
    public static final int U_CARINFO_D66_D0_B0 = 109;
    public static final int U_CARINFO_D66_D0_B1 = 108;
    public static final int U_CARINFO_D66_D0_B2 = 107;
    public static final int U_CARINFO_D66_D0_B3 = 106;
    public static final int U_CARINFO_D66_D0_B4 = 105;
    public static final int U_CARINFO_D66_D0_B5 = 104;
    public static final int U_CARINFO_D66_D0_B7 = 103;
    public static final int U_CARINFO_D66_D10_B0 = 157;
    public static final int U_CARINFO_D66_D10_B1 = 156;
    public static final int U_CARINFO_D66_D10_B2 = 155;
    public static final int U_CARINFO_D66_D10_B3 = 154;
    public static final int U_CARINFO_D66_D10_B4 = 153;
    public static final int U_CARINFO_D66_D10_B5 = 152;
    public static final int U_CARINFO_D66_D10_B6 = 151;
    public static final int U_CARINFO_D66_D10_B7 = 150;
    public static final int U_CARINFO_D66_D11_B70 = 158;
    public static final int U_CARINFO_D66_D12_B70 = 159;
    public static final int U_CARINFO_D66_D13_B70 = 160;
    public static final int U_CARINFO_D66_D14_B70 = 161;
    public static final int U_CARINFO_D66_D2_B1 = 116;
    public static final int U_CARINFO_D66_D2_B2 = 115;
    public static final int U_CARINFO_D66_D2_B3 = 114;
    public static final int U_CARINFO_D66_D2_B4 = 113;
    public static final int U_CARINFO_D66_D2_B5 = 112;
    public static final int U_CARINFO_D66_D2_B6 = 111;
    public static final int U_CARINFO_D66_D2_B7 = 110;
    public static final int U_CARINFO_D66_D3_B10 = 120;
    public static final int U_CARINFO_D66_D3_B32 = 119;
    public static final int U_CARINFO_D66_D3_B4 = 118;
    public static final int U_CARINFO_D66_D3_B5 = 117;
    public static final int U_CARINFO_D66_D4_B0 = 128;
    public static final int U_CARINFO_D66_D4_B1 = 127;
    public static final int U_CARINFO_D66_D4_B2 = 126;
    public static final int U_CARINFO_D66_D4_B3 = 125;
    public static final int U_CARINFO_D66_D4_B4 = 124;
    public static final int U_CARINFO_D66_D4_B5 = 123;
    public static final int U_CARINFO_D66_D4_B6 = 122;
    public static final int U_CARINFO_D66_D4_B7 = 121;
    public static final int U_CARINFO_D66_D5_B30 = 130;
    public static final int U_CARINFO_D66_D5_B74 = 129;
    public static final int U_CARINFO_D66_D6_B10 = 134;
    public static final int U_CARINFO_D66_D6_B32 = 133;
    public static final int U_CARINFO_D66_D6_B4 = 132;
    public static final int U_CARINFO_D66_D6_B5 = 131;
    public static final int U_CARINFO_D66_D7_B10 = 138;
    public static final int U_CARINFO_D66_D7_B32 = 137;
    public static final int U_CARINFO_D66_D7_B54 = 136;
    public static final int U_CARINFO_D66_D7_B76 = 135;
    public static final int U_CARINFO_D66_D8_B10 = 144;
    public static final int U_CARINFO_D66_D8_B2 = 143;
    public static final int U_CARINFO_D66_D8_B3 = 142;
    public static final int U_CARINFO_D66_D8_B54 = 141;
    public static final int U_CARINFO_D66_D8_B6 = 140;
    public static final int U_CARINFO_D66_D8_B7 = 139;
    public static final int U_CARINFO_D66_D9_B10 = 149;
    public static final int U_CARINFO_D66_D9_B32 = 148;
    public static final int U_CARINFO_D66_D9_B54 = 147;
    public static final int U_CARINFO_D66_D9_B6 = 146;
    public static final int U_CARINFO_D66_D9_B7 = 145;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int[] U_CARINFO_OIL_LIST = new int[50];
    public static final int U_CNT_MAX = 174;

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 169) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
        } else if (updateCode == 168) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_OIL_LIST[ints[0]] = ints[1];
        } else if (updateCode >= 0 && updateCode < 174) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 174; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0416_WC_RongWei_Rx5(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
}
