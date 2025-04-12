package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Nissan_Tule extends CallbackCanbusBase {
    public static final int U_CARINFO_D68_D0_D1 = 110;
    public static final int U_CARINFO_D71_D0_D1 = 107;
    public static final int U_CARINFO_D71_D2_D3 = 108;
    public static final int U_CARINFO_D71_D4_D5_D6 = 109;
    public static final int U_CAR_TIRE_BEGIN = 97;
    public static final int U_CAR_TIRE_END = 106;
    public static final int U_CAR_TIRE_VALUE_FL = 98;
    public static final int U_CAR_TIRE_VALUE_FR = 99;
    public static final int U_CAR_TIRE_VALUE_RL = 100;
    public static final int U_CAR_TIRE_VALUE_RR = 101;
    public static final int U_CAR_TIRE_WARN_FL = 102;
    public static final int U_CAR_TIRE_WARN_FR = 103;
    public static final int U_CAR_TIRE_WARN_RL = 104;
    public static final int U_CAR_TIRE_WARN_RR = 105;
    public static final int U_CNT_MAX = 111;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Nissan_Tule(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
