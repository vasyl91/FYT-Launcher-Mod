package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0386_Bagoo_XP1_NewBmwSeries extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 17;
    public static final int U_CARINFO_RADAR_ONOFF = 20;
    public static final int U_CARINFO_SEAT_HOT_LEFT = 18;
    public static final int U_CARINFO_SEAT_HOT_RIGHT = 19;
    public static final int U_CNT_MAX = 21;
    public static final int U_SETTING_03D23 = 8;
    public static final int U_SETTING_03D45 = 9;
    public static final int U_SETTING_03D67 = 10;
    public static final int U_SETTING_04D0 = 11;
    public static final int U_SETTING_04D1 = 12;
    public static final int U_SETTING_04D2 = 13;
    public static final int U_SETTING_04D3 = 14;
    public static final int U_SETTING_04D4 = 15;
    public static final int U_SETTING_BEGIN = 7;
    public static final int U_SETTING_END = 16;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 21; i++) {
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
        if (updateCode >= 0 && updateCode < 21) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
