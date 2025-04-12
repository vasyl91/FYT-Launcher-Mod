package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_DJ_Rongwe_iI5 extends CallbackCanbusBase {
    public static final int U_CARINFO_B00_DATA0 = 104;
    public static final int U_CARINFO_B00_DATA1 = 105;
    public static final int U_CARINFO_B01_DATA0 = 103;
    public static final int U_CARINFO_B02_DATA0 = 102;
    public static final int U_CARINFO_B03_DATA0 = 101;
    public static final int U_CARINFO_B04_DATA0 = 100;
    public static final int U_CARINFO_B75_DATA0 = 99;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_GUIJI_MODE = 107;
    public static final int U_CARINFO_RIGHT_ALLVIEW = 106;
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
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        //AirHelper.getInstance().buildUi(new Air_0439_DJ_Rongwei_I5(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
