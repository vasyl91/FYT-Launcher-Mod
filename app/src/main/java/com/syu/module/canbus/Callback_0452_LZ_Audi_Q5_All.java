package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Audi_Q5_All extends CallbackCanbusBase {
    public static String CarVinID = "";
    public static final int U_CARAIR_REFRESH = 153;
    public static final int U_CARINFO_D0E_D0_D1 = 127;
    public static final int U_CARINFO_D0E_D2_D3 = 128;
    public static final int U_CARINFO_D0E_D4_D5 = 129;
    public static final int U_CARINFO_D0E_D6_D7 = 130;
    public static final int U_CARINFO_D7D_D1_B70 = 98;
    public static final int U_CARINFO_D7E_D10_B70 = 132;
    public static final int U_CARINFO_D7E_D3_D4_D5 = 99;
    public static final int U_CARINFO_D7E_D8_D9 = 100;
    public static final int U_CARINFO_STR_VIN_ID = 131;
    public static final int U_CARSET_D0D_D0_B0 = 106;
    public static final int U_CARSET_D0D_D0_B1 = 105;
    public static final int U_CARSET_D0D_D0_B2 = 104;
    public static final int U_CARSET_D0D_D0_B3 = 103;
    public static final int U_CARSET_D0D_D0_B64 = 102;
    public static final int U_CARSET_D0D_D0_B7 = 101;
    public static final int U_CARSET_D0D_D10_B75 = 152;
    public static final int U_CARSET_D0D_D1_B0 = 114;
    public static final int U_CARSET_D0D_D1_B1 = 113;
    public static final int U_CARSET_D0D_D1_B2 = 112;
    public static final int U_CARSET_D0D_D1_B3 = 111;
    public static final int U_CARSET_D0D_D1_B4 = 110;
    public static final int U_CARSET_D0D_D1_B5 = 109;
    public static final int U_CARSET_D0D_D1_B6 = 108;
    public static final int U_CARSET_D0D_D1_B7 = 107;
    public static final int U_CARSET_D0D_D2_B70 = 115;
    public static final int U_CARSET_D0D_D3_B30 = 117;
    public static final int U_CARSET_D0D_D3_B74 = 116;
    public static final int U_CARSET_D0D_D4_B30 = 119;
    public static final int U_CARSET_D0D_D4_B74 = 118;
    public static final int U_CARSET_D0D_D5_B10 = 125;
    public static final int U_CARSET_D0D_D5_B32 = 124;
    public static final int U_CARSET_D0D_D5_B4 = 123;
    public static final int U_CARSET_D0D_D5_B5 = 122;
    public static final int U_CARSET_D0D_D5_B6 = 121;
    public static final int U_CARSET_D0D_D5_B7 = 120;
    public static final int U_CARSET_D0D_D6_B70 = 126;
    public static final int U_CARSET_D0D_D7_B0 = 139;
    public static final int U_CARSET_D0D_D7_B1 = 138;
    public static final int U_CARSET_D0D_D7_B2 = 137;
    public static final int U_CARSET_D0D_D7_B3 = 136;
    public static final int U_CARSET_D0D_D7_B4 = 135;
    public static final int U_CARSET_D0D_D7_B5 = 134;
    public static final int U_CARSET_D0D_D7_B76 = 133;
    public static final int U_CARSET_D0D_D8_B40 = 143;
    public static final int U_CARSET_D0D_D8_B5 = 142;
    public static final int U_CARSET_D0D_D8_B6 = 141;
    public static final int U_CARSET_D0D_D8_B7 = 140;
    public static final int U_CARSET_D0D_D9_B0 = 151;
    public static final int U_CARSET_D0D_D9_B1 = 150;
    public static final int U_CARSET_D0D_D9_B2 = 149;
    public static final int U_CARSET_D0D_D9_B3 = 148;
    public static final int U_CARSET_D0D_D9_B4 = 147;
    public static final int U_CARSET_D0D_D9_B5 = 146;
    public static final int U_CARSET_D0D_D9_B6 = 145;
    public static final int U_CARSET_D0D_D9_B7 = 144;
    public static final int U_CARSET_D10_D0_B2 = 159;
    public static final int U_CARSET_D10_D0_B3 = 158;
    public static final int U_CARSET_D10_D0_B4 = 157;
    public static final int U_CARSET_D10_D0_B5 = 156;
    public static final int U_CARSET_D10_D0_B6 = 155;
    public static final int U_CARSET_D10_D0_B7 = 154;
    public static final int U_CARSET_D10_D1_B20 = 163;
    public static final int U_CARSET_D10_D1_B53 = 162;
    public static final int U_CARSET_D10_D1_B6 = 161;
    public static final int U_CARSET_D10_D1_B7 = 160;
    public static final int U_CARSET_D10_D2_B54 = 166;
    public static final int U_CARSET_D10_D2_B6 = 165;
    public static final int U_CARSET_D10_D2_B7 = 164;
    public static final int U_CNT_MAX = 167;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 167; i++) {
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
        if (LauncherApplication.getConfiguration() == 1) {
            //AirHelper.getInstance().buildUi(new Air_0452_LZ_Audi_A6(LauncherApplication.getInstance()));
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
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 167) {
            switch (updateCode) {
                case 131:
                    if (strs != null && strs.length > 0) {
                        CarVinID = strs[0];
                    } else {
                        CarVinID = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
