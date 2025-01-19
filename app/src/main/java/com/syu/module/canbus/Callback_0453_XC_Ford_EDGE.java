package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0453_XC_Ford_EDGE;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_XC_Ford_EDGE extends CallbackCanbusBase {
    public static final int U_CARSET_D1E_D1_B70 = 98;
    public static final int U_CARSET_D1E_D2_B70 = 99;
    public static final int U_CARSET_D27_D1_B70 = 100;
    public static final int U_CARSET_D27_D2_B70 = 101;
    public static final int U_CARSET_D27_D3_B70 = 102;
    public static final int U_CARSET_D27_D4_B70 = 103;
    public static final int U_CARSET_D27_D5_B70 = 104;
    public static final int U_CARSET_D27_D6_B70 = 105;
    public static final int U_CARSET_D27_D7_B70 = 106;
    public static final int U_CNT_MAX = 107;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0453_XC_Ford_EDGE(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
