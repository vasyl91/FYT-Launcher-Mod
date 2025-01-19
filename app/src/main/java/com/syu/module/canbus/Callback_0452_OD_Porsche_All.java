package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OD_Porsche_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Porsche_All extends CallbackCanbusBase {
    public static final int U_CARSEt_D40_D00 = 105;
    public static final int U_CARSEt_D40_D01 = 106;
    public static final int U_CARSEt_D40_D02 = 107;
    public static final int U_CARSEt_D40_D03 = 108;
    public static final int U_CARSEt_D40_D04 = 109;
    public static final int U_CARSEt_D40_D05 = 110;
    public static final int U_CARSEt_D40_D06 = 111;
    public static final int U_CARSEt_D40_D07 = 112;
    public static final int U_CARSEt_D40_D08 = 113;
    public static final int U_CARSEt_D40_D09 = 114;
    public static final int U_CARSEt_D40_D0A = 115;
    public static final int U_CARSEt_D40_D0B = 116;
    public static final int U_CARSEt_D40_D0C = 117;
    public static final int U_CARSEt_D40_D0D = 118;
    public static final int U_CARSEt_D40_D0E = 119;
    public static final int U_CNT_MAX = 120;
    public static final int U_NEWADD_D68_D0 = 103;
    public static final int U_NEWADD_D68_D1 = 104;
    public static final int U_TIRE_PRESSURE_FL = 98;
    public static final int U_TIRE_PRESSURE_FR = 99;
    public static final int U_TIRE_PRESSURE_RL = 100;
    public static final int U_TIRE_PRESSURE_RR = 101;
    public static final int U_TIRE_UNIT = 102;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Porsche_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
