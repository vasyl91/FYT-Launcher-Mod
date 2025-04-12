package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_XC_GM_Rongwei_All extends CallbackCanbusBase {
    public static final int U_ANJIXING_PHONE_STATE = 122;
    public static final int U_ANJIXING_STATE = 123;
    public static final int U_CARINFO_D05_D0_B10 = 101;
    public static final int U_CARINFO_D05_D0_B32 = 100;
    public static final int U_CARINFO_D05_D0_B54 = 99;
    public static final int U_CARINFO_D05_D0_B76 = 98;
    public static final int U_CARINFO_D05_D1_B0 = 146;
    public static final int U_CARINFO_D05_D1_B1 = 145;
    public static final int U_CARINFO_D05_D1_B32 = 144;
    public static final int U_CARINFO_D06_D0_B0 = 107;
    public static final int U_CARINFO_D06_D0_B21 = 106;
    public static final int U_CARINFO_D06_D0_B3 = 105;
    public static final int U_CARINFO_D06_D0_B4 = 104;
    public static final int U_CARINFO_D06_D0_B65 = 103;
    public static final int U_CARINFO_D06_D0_B7 = 102;
    public static final int U_CARINFO_D06_D1_B0 = 114;
    public static final int U_CARINFO_D06_D1_B1 = 113;
    public static final int U_CARINFO_D06_D1_B2 = 112;
    public static final int U_CARINFO_D06_D1_B3 = 111;
    public static final int U_CARINFO_D06_D1_B4 = 110;
    public static final int U_CARINFO_D06_D1_B65 = 109;
    public static final int U_CARINFO_D06_D1_B7 = 108;
    public static final int U_CARINFO_D06_D2_B2 = 120;
    public static final int U_CARINFO_D06_D2_B3 = 119;
    public static final int U_CARINFO_D06_D2_B4 = 118;
    public static final int U_CARINFO_D06_D2_B5 = 117;
    public static final int U_CARINFO_D06_D2_B6 = 116;
    public static final int U_CARINFO_D06_D2_B7 = 115;
    public static final int U_CARINFO_D16_D0_B10 = 126;
    public static final int U_CARINFO_D16_D0_B32 = 125;
    public static final int U_CARINFO_D16_D0_B76 = 124;
    public static final int U_CARINFO_D17_D0_B0 = 134;
    public static final int U_CARINFO_D17_D0_B1 = 133;
    public static final int U_CARINFO_D17_D0_B2 = 132;
    public static final int U_CARINFO_D17_D0_B3 = 131;
    public static final int U_CARINFO_D17_D0_B4 = 130;
    public static final int U_CARINFO_D17_D0_B5 = 129;
    public static final int U_CARINFO_D17_D0_B6 = 128;
    public static final int U_CARINFO_D17_D0_B7 = 127;
    public static final int U_CARINFO_D18_D0_D1 = 135;
    public static final int U_CARINFO_D18_D10_D11 = 141;
    public static final int U_CARINFO_D18_D12_D13 = 142;
    public static final int U_CARINFO_D18_D2_B70 = 136;
    public static final int U_CARINFO_D18_D3_D4 = 137;
    public static final int U_CARINFO_D18_D5_D6 = 138;
    public static final int U_CARINFO_D18_D7_B70 = 139;
    public static final int U_CARINFO_D18_D8_D9 = 140;
    public static final int U_CARINFO_D19_D0_B70 = 143;
    public static final int U_CARINFO_RADAR_ONOFF = 121;
    public static final int U_CNT_MAX = 147;
    public static String anjixingNumber;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 147; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_XC_GM_Rongwei_All(LauncherApplication.getInstance()));
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
        switch (updateCode) {
            case 122:
                if (strs != null && strs.length > 0) {
                    anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 147) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
