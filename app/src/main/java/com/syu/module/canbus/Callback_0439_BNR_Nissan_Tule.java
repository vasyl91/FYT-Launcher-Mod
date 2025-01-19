package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_BNR_Nissan_Tule;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_BNR_Nissan_Tule extends CallbackCanbusBase {
    public static final int U_CARINF_AVGFUEL = 110;
    public static final int U_CARINF_BEGIN = 108;
    public static final int U_CARINF_END = 113;
    public static final int U_CARINF_MILEAGE = 109;
    public static final int U_CARINF_TRAVELABLE = 111;
    public static final int U_CAR_TIRE_BEGIN = 98;
    public static final int U_CAR_TIRE_END = 107;
    public static final int U_CAR_TIRE_VALUE_FL = 99;
    public static final int U_CAR_TIRE_VALUE_FR = 100;
    public static final int U_CAR_TIRE_VALUE_RL = 101;
    public static final int U_CAR_TIRE_VALUE_RR = 102;
    public static final int U_CAR_TIRE_WARN_FL = 103;
    public static final int U_CAR_TIRE_WARN_FR = 104;
    public static final int U_CAR_TIRE_WARN_RL = 105;
    public static final int U_CAR_TIRE_WARN_RR = 106;
    public static final int U_CNT_MAX = 114;
    public static final int U_CUR_MOTOR_SPEED = 112;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_BNR_Nissan_Tule(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
