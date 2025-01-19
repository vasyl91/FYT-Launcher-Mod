package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Jili_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D32_D6_B70 = 99;
    public static final int U_CARINF_D32_D7_B70 = 100;
    public static final int U_CARSET_D35_D2_B76 = 149;
    public static final int U_CARSET_D35_D4_B1 = 152;
    public static final int U_CARSET_D35_D4_B2 = 151;
    public static final int U_CARSET_D35_D4_B3 = 150;
    public static final int U_CARSET_D61_D0_B0 = 107;
    public static final int U_CARSET_D61_D0_B1 = 106;
    public static final int U_CARSET_D61_D0_B32 = 105;
    public static final int U_CARSET_D61_D0_B4 = 104;
    public static final int U_CARSET_D61_D0_B5 = 103;
    public static final int U_CARSET_D61_D0_B6 = 102;
    public static final int U_CARSET_D61_D0_B7 = 101;
    public static final int U_CARSET_D61_D1_B0 = 115;
    public static final int U_CARSET_D61_D1_B1 = 114;
    public static final int U_CARSET_D61_D1_B2 = 113;
    public static final int U_CARSET_D61_D1_B3 = 112;
    public static final int U_CARSET_D61_D1_B4 = 111;
    public static final int U_CARSET_D61_D1_B5 = 110;
    public static final int U_CARSET_D61_D1_B6 = 109;
    public static final int U_CARSET_D61_D1_B7 = 108;
    public static final int U_CARSET_D61_D2_B0 = 122;
    public static final int U_CARSET_D61_D2_B1 = 121;
    public static final int U_CARSET_D61_D2_B2 = 120;
    public static final int U_CARSET_D61_D2_B3 = 119;
    public static final int U_CARSET_D61_D2_B54 = 118;
    public static final int U_CARSET_D61_D2_B6 = 117;
    public static final int U_CARSET_D61_D2_B7 = 116;
    public static final int U_CARSET_D61_D3_B10 = 128;
    public static final int U_CARSET_D61_D3_B32 = 127;
    public static final int U_CARSET_D61_D3_B4 = 126;
    public static final int U_CARSET_D61_D3_B5 = 125;
    public static final int U_CARSET_D61_D3_B6 = 124;
    public static final int U_CARSET_D61_D3_B7 = 123;
    public static final int U_CARSET_D61_D4_B0 = 133;
    public static final int U_CARSET_D61_D4_B21 = 132;
    public static final int U_CARSET_D61_D4_B3 = 131;
    public static final int U_CARSET_D61_D4_B4 = 130;
    public static final int U_CARSET_D61_D4_B5 = 129;
    public static final int U_CARSET_D61_D5_B0 = 139;
    public static final int U_CARSET_D61_D5_B1 = 138;
    public static final int U_CARSET_D61_D5_B2 = 137;
    public static final int U_CARSET_D61_D5_B3 = 136;
    public static final int U_CARSET_D61_D5_B65 = 135;
    public static final int U_CARSET_D61_D5_B7 = 134;
    public static final int U_CARSET_D61_D6_B0 = 144;
    public static final int U_CARSET_D61_D6_B1 = 143;
    public static final int U_CARSET_D61_D6_B2 = 142;
    public static final int U_CARSET_D61_D6_B3 = 141;
    public static final int U_CARSET_D61_D6_B74 = 140;
    public static final int U_CARSET_D61_D7_B30 = 148;
    public static final int U_CARSET_D61_D7_B4 = 147;
    public static final int U_CARSET_D61_D7_B65 = 146;
    public static final int U_CARSET_D61_D7_B7 = 145;
    public static final int U_CNT_MAX = 153;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 153; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0443_WC_Jili_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 153) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
