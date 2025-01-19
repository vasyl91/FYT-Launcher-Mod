package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0427_XFY_K3 extends CallbackCanbusBase {
    public static final int U_CARINDO_END = 123;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CNT_MAX = 126;
    public static final int U_CUR_SPEED = 124;
    public static final int U_D0B00 = 117;
    public static final int U_D0B02 = 116;
    public static final int U_D0B04 = 99;
    public static final int U_D1B00 = 101;
    public static final int U_D1B02 = 100;
    public static final int U_D2B00 = 106;
    public static final int U_D2B02 = 105;
    public static final int U_D2B04 = 104;
    public static final int U_D2B06 = 103;
    public static final int U_D2B07 = 102;
    public static final int U_D3B04 = 110;
    public static final int U_D3B05 = 109;
    public static final int U_D3B06 = 108;
    public static final int U_D3B07 = 107;
    public static final int U_D4B06 = 112;
    public static final int U_D4B07 = 111;
    public static final int U_D5B02 = 122;
    public static final int U_D5B03 = 121;
    public static final int U_D5B04 = 120;
    public static final int U_D5B05 = 119;
    public static final int U_D5B06 = 118;
    public static final int U_DTS_SURROUND = 115;
    public static final int U_ENGINE_SPEED = 125;
    public static final int U_LOUD = 113;
    public static final int U_SPEED_VOL = 114;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
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
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
