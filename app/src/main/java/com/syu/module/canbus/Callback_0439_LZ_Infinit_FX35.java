package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LZ_Infinit_FX35 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CUR_SPEED = 100;
    public static final int U_CARINFO_ENGINE_SPEED = 102;
    public static final int U_CARINFO_MILE_DRIVENABLE = 101;
    public static final int U_CARINFO_MILE_UNIT = 104;
    public static final int U_CARINFO_TEMP_UNIT = 103;
    public static final int U_CARINFO_WATER_TEMP = 99;
    public static final int U_CARSET_BEIGIN = 110;
    public static final int U_CARSET_DATA38_VALUE0 = 111;
    public static final int U_CARSET_DATA38_VALUE1 = 112;
    public static final int U_CARSET_DATA38_VALUE10 = 121;
    public static final int U_CARSET_DATA38_VALUE2 = 113;
    public static final int U_CARSET_DATA38_VALUE3 = 114;
    public static final int U_CARSET_DATA38_VALUE4 = 115;
    public static final int U_CARSET_DATA38_VALUE5 = 116;
    public static final int U_CARSET_DATA38_VALUE6 = 117;
    public static final int U_CARSET_DATA38_VALUE7 = 118;
    public static final int U_CARSET_DATA38_VALUE8 = 119;
    public static final int U_CARSET_DATA38_VALUE9 = 120;
    public static final int U_CAR_TIRE_BEGIN = 105;
    public static final int U_CAR_TIRE_VALUE1 = 106;
    public static final int U_CAR_TIRE_VALUE2 = 107;
    public static final int U_CAR_TIRE_VALUE3 = 108;
    public static final int U_CAR_TIRE_VALUE4 = 109;
    public static final int U_CNT_MAX = 122;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_Luz_Infinit_Fx35(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
