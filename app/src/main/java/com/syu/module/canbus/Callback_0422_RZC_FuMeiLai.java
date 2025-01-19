package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0422_RZC_FuMeiLai;
//import com.syu.ui.air.Air_0422_RZC_HaiMaS5YOUNG;
import com.syu.ui.door.DoorHelper;

public class Callback_0422_RZC_FuMeiLai extends CallbackCanbusBase {
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_D40_D2_B70 = 102;
    public static final int U_CARSET_D41_D0_B10 = 104;
    public static final int U_CARSET_D41_D0_B3 = 103;
    public static final int U_CARSET_D41_D1_B70 = 105;
    public static final int U_CARSET_LIGHT_HOME = 99;
    public static final int U_CARSET_LIGHT_HOME_TIME = 100;
    public static final int U_CARSET_ROAD_AWAY = 101;
    public static final int U_CNT_MAX = 106;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 106; i++) {
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
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carId == 2 || carId == 4 || carId == 5) {
            //AirHelper.getInstance().buildUi(new Air_0422_RZC_HaiMaS5YOUNG(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0422_RZC_FuMeiLai(LauncherApplication.getInstance()));
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
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 106) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
