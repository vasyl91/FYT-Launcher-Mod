package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0276_DJ_BYD_F6;
import com.syu.ui.door.DoorHelper;

public class Callback_0276_DJ_XP1_BIYADI_F6 extends CallbackCanbusBase {
    public static final int U_CARINDO_END = 124;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CNT_MAX = 124;
    public static final int U_D0B00 = 118;
    public static final int U_D0B02 = 117;
    public static final int U_D0B04 = 100;
    public static final int U_D1B00 = 102;
    public static final int U_D1B02 = 101;
    public static final int U_D2B00 = 107;
    public static final int U_D2B02 = 106;
    public static final int U_D2B04 = 105;
    public static final int U_D2B06 = 104;
    public static final int U_D2B07 = 103;
    public static final int U_D3B04 = 111;
    public static final int U_D3B05 = 110;
    public static final int U_D3B06 = 109;
    public static final int U_D3B07 = 108;
    public static final int U_D4B06 = 113;
    public static final int U_D4B07 = 112;
    public static final int U_D5B02 = 123;
    public static final int U_D5B03 = 122;
    public static final int U_D5B04 = 121;
    public static final int U_D5B05 = 120;
    public static final int U_D5B06 = 119;
    public static final int U_DTS_SURROUND = 116;
    public static final int U_LOUD = 114;
    public static final int U_SPEED_VOL = 115;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0276_DJ_BYD_F6(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
        if (updateCode >= 0 && updateCode < 124) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
