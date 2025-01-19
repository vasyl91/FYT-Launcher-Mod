package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OD_Weima_E5;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_OD_Chuangwei_ET5 extends CallbackCanbusBase {
    public static final int U_CARSET_D27_D0_B70 = 98;
    public static final int U_CARSET_D27_D10_B70 = 123;
    public static final int U_CARSET_D27_D11_B70 = 124;
    public static final int U_CARSET_D27_D12_B70 = 125;
    public static final int U_CARSET_D27_D1_B70 = 114;
    public static final int U_CARSET_D27_D2_B70 = 115;
    public static final int U_CARSET_D27_D3_B70 = 116;
    public static final int U_CARSET_D27_D4_B70 = 117;
    public static final int U_CARSET_D27_D5_B70 = 118;
    public static final int U_CARSET_D27_D6_B70 = 119;
    public static final int U_CARSET_D27_D7_B70 = 120;
    public static final int U_CARSET_D27_D8_B70 = 121;
    public static final int U_CARSET_D27_D9_B70 = 122;
    public static final int U_CNT_MAX = 126;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Weima_E5(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
