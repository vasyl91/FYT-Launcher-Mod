package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0223_WC1_MengDiOu2011;
import com.syu.ui.door.DoorHelper;

public class Callback_0223_WC1_MENGDIOU2011 extends CallbackCanbusBase {
    public static final int U_AIR_BLOW_MODE_LEFT = 99;
    public static final int U_CNT_MAX = 106;
    public static final int U_CYT_AIR_DATA0 = 100;
    public static final int U_CYT_AIR_DATA1 = 101;
    public static final int U_CYT_AIR_DATA2 = 102;
    public static final int U_CYT_AIR_DATA3 = 103;
    public static final int U_CYT_AIR_DATA4 = 104;
    public static final int U_CYT_AIR_DATA5 = 105;
    public static final int U_SHOW_AIR_KEY = 98;

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
        //AirHelper.getInstance().buildUi(new Air_0223_WC1_MengDiOu2011(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
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
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 98:
                break;
            default:
                if (updateCode >= 0 && updateCode < 106) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
