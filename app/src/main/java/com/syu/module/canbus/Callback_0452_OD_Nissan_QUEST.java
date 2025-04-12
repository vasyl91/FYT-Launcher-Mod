package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Nissan_QUEST extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D27_D0_B2 = 99;
    public static final int U_CARINFO_D27_D5_D6 = 100;
    public static final int U_CARINFO_D29_D0_B10 = 101;
    public static final int U_CARINFO_D29_D3_D4 = 102;
    public static final int U_CARINFO_D71_D0 = 103;
    public static final int U_CARINFO_D71_D1 = 104;
    public static final int U_CARINFO_D71_D2 = 105;
    public static final int U_CARINFO_D72_D0 = 106;
    public static final int U_CARINFO_D72_D1 = 107;
    public static final int U_CNT_MAX = 108;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Nissan_QUEST(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
