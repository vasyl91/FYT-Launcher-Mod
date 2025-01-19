package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_PA_Ford_F150 extends CallbackCanbusBase {
    public static String Str_Line1 = null;
    public static String Str_Line2 = null;
    public static String Str_Line3 = null;
    public static final int U_CARSET_ALTITUDE = 126;
    public static final int U_CARSET_ANGLE = 129;
    public static final int U_CARSET_CALIBRATE = 115;
    public static final int U_CARSET_D17_D0_B0 = 116;
    public static final int U_CARSET_D17_D1_B70 = 117;
    public static final int U_CARSET_D17_D2_B70 = 118;
    public static final int U_CARSET_D17_D3_B70 = 119;
    public static final int U_CARSET_D17_D4_B70 = 120;
    public static final int U_CARSET_D17_D5_B70 = 121;
    public static final int U_CARSET_D17_D6_B70 = 122;
    public static final int U_CARSET_D17_D7_B70 = 123;
    public static final int U_CARSET_D17_D8_B30 = 125;
    public static final int U_CARSET_D17_D8_B6 = 124;
    public static final int U_CARSET_D18_D0_B70 = 131;
    public static final int U_CARSET_D19_D0_B70 = 132;
    public static final int U_CARSET_D1A_D0_D15 = 133;
    public static final int U_CARSET_D1B_D0_B2 = 139;
    public static final int U_CARSET_D1B_D0_B3 = 138;
    public static final int U_CARSET_D1B_D0_B4 = 137;
    public static final int U_CARSET_D1B_D0_B5 = 136;
    public static final int U_CARSET_D1B_D0_B6 = 135;
    public static final int U_CARSET_D1B_D0_B7 = 134;
    public static final int U_CARSET_D1B_D1_B2 = 145;
    public static final int U_CARSET_D1B_D1_B3 = 144;
    public static final int U_CARSET_D1B_D1_B4 = 143;
    public static final int U_CARSET_D1B_D1_B5 = 142;
    public static final int U_CARSET_D1B_D1_B6 = 141;
    public static final int U_CARSET_D1B_D1_B7 = 140;
    public static final int U_CARSET_D1C_D0_D23 = 146;
    public static final int U_CARSET_D1D_D0_D23 = 147;
    public static final int U_CARSET_D1E_D0_B70 = 148;
    public static final int U_CARSET_D40_D00_D1_B70 = 113;
    public static final int U_CARSET_D40_D01_D1_B70 = 114;
    public static final int U_CARSET_D4D_D0_D1 = 111;
    public static final int U_CARSET_D4D_D2_D3 = 112;
    public static final int U_CARSET_D5D_D0_B0 = 110;
    public static final int U_CARSET_D5D_D0_B1 = 130;
    public static final int U_CARSET_D5F_D0_B0 = 105;
    public static final int U_CARSET_D5F_D0_B1 = 104;
    public static final int U_CARSET_D5F_D0_B2 = 103;
    public static final int U_CARSET_D5F_D0_B3 = 102;
    public static final int U_CARSET_D5F_D0_B4 = 101;
    public static final int U_CARSET_D5F_D0_B5 = 100;
    public static final int U_CARSET_D5F_D0_B6 = 99;
    public static final int U_CARSET_D5F_D0_B7 = 98;
    public static final int U_CARSET_D5F_D1_B70 = 106;
    public static final int U_CARSET_D5F_D2_B70 = 107;
    public static final int U_CARSET_D5F_D3_B70 = 108;
    public static final int U_CARSET_D5F_D4_B70 = 109;
    public static final int U_CARSET_LATITUDE = 128;
    public static final int U_CARSET_LONGITUDE = 127;
    public static final int U_CNT_MAX = 149;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 149; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 133:
                if (strs != null && strs.length > 0) {
                    Str_Line1 = strs[0];
                } else {
                    Str_Line1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 146:
                if (strs != null && strs.length > 0) {
                    Str_Line2 = strs[0];
                } else {
                    Str_Line2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 147:
                if (strs != null && strs.length > 0) {
                    Str_Line3 = strs[0];
                } else {
                    Str_Line3 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 149) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
