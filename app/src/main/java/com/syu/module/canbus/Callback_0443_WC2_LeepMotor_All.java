package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_LeepMotor_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D13_D0_D1 = 99;
    public static final int U_CARINF_D13_D11_D13 = 101;
    public static final int U_CARINF_D13_D14_B70 = 102;
    public static final int U_CARINF_D13_D15_B70 = 103;
    public static final int U_CARINF_D13_D16_B70 = 104;
    public static final int U_CARINF_D13_D8_D10 = 100;
    public static final int U_CARINF_D14_D0_D1 = 105;
    public static final int U_CARINF_D14_D2_D3 = 106;
    public static final int U_CARINF_D14_D8_D10 = 107;
    public static final int U_CARINF_D15_D0_D1 = 108;
    public static final int U_CARINF_D15_D14_B70 = 111;
    public static final int U_CARINF_D15_D15_B70 = 112;
    public static final int U_CARINF_D15_D16_B70 = 113;
    public static final int U_CARINF_D15_D2_D3 = 109;
    public static final int U_CARINF_D15_D8_D10 = 110;
    public static final int U_CARINF_D3F_D0_D1 = 114;
    public static final int U_CARINF_D3F_D11_B70 = 116;
    public static final int U_CARINF_D3F_D2_D3 = 115;
    public static final int U_CARINF_D48_D2_D3 = 117;
    public static final int U_CARINF_D48_D4_D5 = 118;
    public static final int U_CARINF_D48_D6_D7 = 119;
    public static final int U_CARINF_D48_D8_D9 = 120;
    public static final int U_CARSET_D61_D0_B30 = 121;
    public static final int U_CARSET_D61_D0_B74 = 122;
    public static final int U_CARSET_D61_D1_B30 = 123;
    public static final int U_CARSET_D61_D1_B4 = 124;
    public static final int U_CARSET_D61_D1_B5 = 125;
    public static final int U_CARSET_D61_D2_B10 = 126;
    public static final int U_CARSET_D61_D3_B30 = 127;
    public static final int U_CARSET_D61_D3_B4 = 128;
    public static final int U_CARSET_D61_D3_B5 = 129;
    public static final int U_CARSET_D61_D4_B20 = 130;
    public static final int U_CARSET_D61_D4_B53 = 131;
    public static final int U_CARSET_D61_D4_B6 = 132;
    public static final int U_CARSET_D61_D4_B7 = 133;
    public static final int U_CARSET_D61_D5_B0 = 134;
    public static final int U_CARSET_D61_D6_B60 = 135;
    public static final int U_CARSET_D61_D6_B7 = 136;
    public static final int U_CARSET_D61_D7_B0 = 137;
    public static final int U_CARSET_D61_D7_B1 = 138;
    public static final int U_CNT_MAX = 139;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 139; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_LeepMotor_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 139) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
