package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_PA_Nissan_All extends CallbackCanbusBase {
    public static final int U_CARSET_ALTITUDE = 143;
    public static final int U_CARSET_ANGLE = 146;
    public static final int U_CARSET_CALIBRATE = 149;
    public static final int U_CARSET_D4D_D0_D1 = 147;
    public static final int U_CARSET_D4D_D2_D3 = 148;
    public static final int U_CARSET_D5D_D0_B0 = 110;
    public static final int U_CARSET_D5D_D0_B1 = 140;
    public static final int U_CARSET_D5E_D0_B1 = 126;
    public static final int U_CARSET_D5E_D0_B2 = 125;
    public static final int U_CARSET_D5E_D0_B3 = 124;
    public static final int U_CARSET_D5E_D0_B4 = 123;
    public static final int U_CARSET_D5E_D0_B5 = 122;
    public static final int U_CARSET_D5E_D0_B6 = 121;
    public static final int U_CARSET_D5E_D0_B7 = 120;
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
    public static final int U_CARSET_D93_D0_B70 = 111;
    public static final int U_CARSET_D93_D1_B70 = 112;
    public static final int U_CARSET_D93_D2_B70 = 113;
    public static final int U_CARSET_D93_D3_B70 = 114;
    public static final int U_CARSET_D93_D4_B70 = 115;
    public static final int U_CARSET_D93_D5_B70 = 116;
    public static final int U_CARSET_D93_D6_B70 = 117;
    public static final int U_CARSET_D93_D7_B70 = 118;
    public static final int U_CARSET_D93_D8_B70 = 119;
    public static final int U_CARSET_D95_D0_B5 = 129;
    public static final int U_CARSET_D95_D0_B6 = 128;
    public static final int U_CARSET_D95_D0_B7 = 127;
    public static final int U_CARSET_D95_D1_B30 = 133;
    public static final int U_CARSET_D95_D1_B4 = 132;
    public static final int U_CARSET_D95_D1_B65 = 131;
    public static final int U_CARSET_D95_D1_B7 = 130;
    public static final int U_CARSET_D95_D2_B0 = 150;
    public static final int U_CARSET_D95_D2_B1 = 142;
    public static final int U_CARSET_D95_D2_B2 = 141;
    public static final int U_CARSET_D95_D2_B3 = 137;
    public static final int U_CARSET_D95_D2_B4 = 136;
    public static final int U_CARSET_D95_D2_B6 = 135;
    public static final int U_CARSET_D95_D2_B7 = 134;
    public static final int U_CARSET_D95_D3_B30 = 139;
    public static final int U_CARSET_D95_D3_B74 = 138;
    public static final int U_CARSET_LATITUDE = 145;
    public static final int U_CARSET_LONGITUDE = 144;
    public static final int U_CNT_MAX = 151;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 151; i++) {
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
        if (updateCode >= 0 && updateCode < 151) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
