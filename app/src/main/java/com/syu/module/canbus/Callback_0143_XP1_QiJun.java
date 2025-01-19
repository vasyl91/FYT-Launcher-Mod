package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_RZC_QiJun;

public class Callback_0143_XP1_QiJun extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 102;
    public static final int U_PARK_BTN = 100;
    public static final int U_PARK_CAMERA = 101;
    public static final int U_PARK_PAGE = 99;
    public static final int U_PARK_TXTMSG = 98;

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
        if (1114255 == DataCanbus.DATA[1000]) {
            ParkingHelper.getInstance().buildUi(new Parking_RZC_QiJun(LauncherApplication.getInstance()));
            DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
            for (int i3 = 98; i3 <= 101; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(ParkingHelper.getInstance(), 0);
            }
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
        if (updateCode >= 0 && updateCode < 102) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
