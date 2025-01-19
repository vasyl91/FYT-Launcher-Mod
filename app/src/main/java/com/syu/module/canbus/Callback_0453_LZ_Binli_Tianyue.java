package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_Binli_Tianyue extends CallbackCanbusBase {
    public static final int U_AIR_D07_D1_B2 = 115;
    public static final int U_AIR_D07_D1_B3 = 114;
    public static final int U_AIR_D07_D1_B4 = 113;
    public static final int U_AIR_D07_D1_B5 = 112;
    public static final int U_AIR_D07_D1_B6 = 111;
    public static final int U_AIR_D07_D1_B7 = 110;
    public static final int U_AIR_SEAT_AUTO_LEFT = 100;
    public static final int U_AIR_SEAT_AUTO_RIGHT = 101;
    public static final int U_AIR_SEAT_COLD_AUTO_LEFT = 98;
    public static final int U_AIR_SEAT_COLD_AUTO_RIGHT = 99;
    public static final int U_AIR_SEAT_COLD_LEFT_BOTTOM = 107;
    public static final int U_AIR_SEAT_COLD_LEFT_WAIST = 106;
    public static final int U_AIR_SEAT_COLD_RIGHT_BOTTOM = 109;
    public static final int U_AIR_SEAT_COLD_RIGHT_WAIST = 108;
    public static final int U_AIR_SEAT_HOT_LEFT_BOTTOM = 103;
    public static final int U_AIR_SEAT_HOT_LEFT_WAIST = 102;
    public static final int U_AIR_SEAT_HOT_RIGHT_BOTTOM = 105;
    public static final int U_AIR_SEAT_HOT_RIGHT_WAIST = 104;
    public static final int U_CNT_MAX = 116;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
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
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
