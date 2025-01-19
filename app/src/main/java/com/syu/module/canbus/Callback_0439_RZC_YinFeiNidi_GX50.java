package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_YinFeiNidi_GX50 extends CallbackCanbusBase {
    public static final int U_CARINFO_D27_D0_B0 = 105;
    public static final int U_CARINFO_D27_D0_B1 = 104;
    public static final int U_CARINFO_D27_D1_D4 = 106;
    public static final int U_CARINFO_D27_D5_D6 = 107;
    public static final int U_CARINFO_D29_D0_B10 = 109;
    public static final int U_CARINFO_D29_D0_B32 = 108;
    public static final int U_CARINFO_D29_D1_D2 = 110;
    public static final int U_CARINFO_D29_D3_D4 = 111;
    public static final int U_CARINFO_D40_D1_B70 = 112;
    public static final int U_CARINFO_D40_D2_B70 = 113;
    public static final int U_CARINFO_D40_D3_B70 = 114;
    public static final int U_CARINFO_D40_D4_B70 = 115;
    public static final int U_CARINFO_D40_D5_B70 = 116;
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_D73_D0_B70 = 117;
    public static final int U_CARSET_D73_D1_B70 = 118;
    public static final int U_CARSET_D73_D2_B70 = 119;
    public static final int U_CARSET_D73_D3_B0 = 122;
    public static final int U_CARSET_D73_D3_B1 = 121;
    public static final int U_CARSET_D73_D3_B2 = 120;
    public static final int U_CARSET_D74_D0_B10 = 136;
    public static final int U_CARSET_D74_D0_B32 = 135;
    public static final int U_CARSET_D74_D0_B54 = 134;
    public static final int U_CARSET_D74_D1_B76 = 137;
    public static final int U_CARSET_D74_D2_B54 = 138;
    public static final int U_CARSET_D74_D3_B10 = 139;
    public static final int U_CARSET_D74_D4_B70 = 140;
    public static final int U_CARSET_D93_D0_B70 = 123;
    public static final int U_CARSET_D93_D10_B70 = 133;
    public static final int U_CARSET_D93_D1_B70 = 124;
    public static final int U_CARSET_D93_D2_B70 = 125;
    public static final int U_CARSET_D93_D3_B70 = 126;
    public static final int U_CARSET_D93_D4_B70 = 127;
    public static final int U_CARSET_D93_D5_B70 = 128;
    public static final int U_CARSET_D93_D6_B70 = 129;
    public static final int U_CARSET_D93_D7_B70 = 130;
    public static final int U_CARSET_D93_D8_B70 = 131;
    public static final int U_CARSET_D93_D9_B70 = 132;
    public static final int U_CARSET_KEY_UNLOCK = 103;
    public static final int U_CARSET_LIGHTAUTO_SENSOR = 100;
    public static final int U_CARSET_LIGHTAUTO_TIME = 101;
    public static final int U_CARSET_LIGHTAUTO_UNLOCK = 99;
    public static final int U_CARSET_SELECT_UNLOCK = 102;
    public static final int U_CNT_MAX = 141;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 141; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0454_RZC_Infeinidi_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 141) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
