package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OD_Huachen_SWM;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Huachen_SWM extends CallbackCanbusBase {
    public static final int U_CARSET_D04_D0_B4 = 100;
    public static final int U_CARSET_D04_D0_B5 = 99;
    public static final int U_CARSET_D04_D0_B6 = 98;
    public static final int U_CARSET_D04_D10_B0 = 112;
    public static final int U_CARSET_D04_D10_B1 = 111;
    public static final int U_CARSET_D04_D10_B2 = 110;
    public static final int U_CARSET_D04_D10_B4 = 109;
    public static final int U_CARSET_D04_D10_B5 = 108;
    public static final int U_CARSET_D04_D11_B70 = 113;
    public static final int U_CARSET_D04_D12_B70 = 114;
    public static final int U_CARSET_D04_D13_B70 = 115;
    public static final int U_CARSET_D04_D2_B70 = 101;
    public static final int U_CARSET_D04_D3_D4 = 102;
    public static final int U_CARSET_D04_D5_D6_D7 = 103;
    public static final int U_CARSET_D04_D8_B70 = 104;
    public static final int U_CARSET_D04_D9_B30 = 107;
    public static final int U_CARSET_D04_D9_B6 = 106;
    public static final int U_CARSET_D04_D9_B7 = 105;
    public static final int U_CARSET_D40_D0_D1 = 116;
    public static final int U_CARSET_D40_D10_B70 = 123;
    public static final int U_CARSET_D40_D2_D3 = 117;
    public static final int U_CARSET_D40_D4_D5 = 118;
    public static final int U_CARSET_D40_D6_B70 = 119;
    public static final int U_CARSET_D40_D7_B70 = 120;
    public static final int U_CARSET_D40_D8_B70 = 121;
    public static final int U_CARSET_D40_D9_B70 = 122;
    public static final int U_CNT_MAX = 124;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Huachen_SWM(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 124) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
