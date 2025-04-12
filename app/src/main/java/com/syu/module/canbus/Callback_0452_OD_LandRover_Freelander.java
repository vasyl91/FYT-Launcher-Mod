package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_LandRover_Freelander extends CallbackCanbusBase {
    public static final int U_AIR_WIND_LEVEL_REAR = 105;
    public static final int U_CARINFO_D41_D0_D1 = 99;
    public static final int U_CARINFO_D41_D2_B70 = 100;
    public static final int U_CARINFO_D41_D3_D4 = 101;
    public static final int U_CARINFO_D41_D5_B70 = 102;
    public static final int U_CARINFO_D41_D6_D7 = 103;
    public static final int U_CARINFO_D41_D8_B70 = 104;
    public static final int U_CARINFO_D42_D0_B70 = 106;
    public static final int U_CARINFO_D42_D1_B70 = 107;
    public static final int U_CARINFO_D42_D2_B70 = 108;
    public static final int U_CARINFO_D42_D3_B70 = 109;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CNT_MAX = 110;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Landrover(LauncherApplication.getInstance()));
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
