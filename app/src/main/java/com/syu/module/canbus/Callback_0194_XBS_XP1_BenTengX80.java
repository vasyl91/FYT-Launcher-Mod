package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0194_XBS_XP1_BYDTang;
import com.syu.ui.carvol.CarVolHelper;
import com.syu.ui.carvol.CarVolView;
import com.syu.ui.door.DoorHelper;

public class Callback_0194_XBS_XP1_BenTengX80 extends CallbackCanbusBase {
    public static final int U_CAR_DTS = 100;
    public static final int U_CAR_SOC = 101;
    public static final int U_CAR_VOL = 99;
    public static final int U_CAR_VOL_SHOW = 98;
    public static final int U_CNT_MAX = 102;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 102; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0194_XBS_XP1_BYDTang(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        CarVolHelper.mCarVol_ID = 99;
        CarVolHelper.getInstance().buildUi(new CarVolView(LauncherApplication.getInstance()));
        DataCanbus.NOTIFY_EVENTS[99].addNotify(CarVolHelper.SHOW_AND_REFRESH, 0);
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
        CarVolHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(CarVolHelper.SHOW_AND_REFRESH);
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 102) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
