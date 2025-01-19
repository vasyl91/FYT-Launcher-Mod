package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.carvol.CarVolHelper;
import com.syu.ui.carvol.CarVolView;
import com.syu.ui.door.DoorHelper;

public class Callback_0414_XFY_XP1_TianLai extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 109;
    public static final int U_CUR_SPEED = 107;
    public static final int U_ENGINE_SPEED = 108;
    public static final int U_INFO_CAR_BOSE_POINT = 106;
    public static final int U_INFO_CAR_DRIVER_FIELD = 104;
    public static final int U_INFO_CAR_FIELD_F_B = 101;
    public static final int U_INFO_CAR_FIELD_L_R = 102;
    public static final int U_INFO_CAR_ROUND_VOL = 105;
    public static final int U_INFO_CAR_SOUND_H = 99;
    public static final int U_INFO_CAR_SOUND_L = 100;
    public static final int U_INFO_CAR_SPEED_LINK = 103;
    public static final int U_INFO_CAR_VOL = 98;

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 109) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 109; i++) {
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
        CarVolHelper.mCarVol_ID = 98;
        CarVolHelper.getInstance().buildUi(new CarVolView(LauncherApplication.getInstance()));
        DataCanbus.NOTIFY_EVENTS[98].addNotify(CarVolHelper.SHOW_AND_REFRESH, 0);
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        CarVolHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(CarVolHelper.SHOW_AND_REFRESH);
    }
}
