package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_XC_Ruijie;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_HC_Ford_Ruijie extends CallbackCanbusBase {
    public static final int CMD_CAREQ_CTRL = 2;
    public static final int CMD_CARSET_CTRL = 1;
    public static final int U_CAREQ_BAL = 104;
    public static final int U_CAREQ_BASS = 106;
    public static final int U_CAREQ_BEGIN = 102;
    public static final int U_CAREQ_END = 110;
    public static final int U_CAREQ_FAD = 105;
    public static final int U_CAREQ_MID = 107;
    public static final int U_CAREQ_TREBLE = 108;
    public static final int U_CAREQ_VOL = 103;
    public static final int U_CAREQ_VOL_SPEED = 109;
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_D28_D0_B30 = 112;
    public static final int U_CARSET_D28_D0_B74 = 111;
    public static final int U_CARSET_END = 101;
    public static final int U_CARSET_LAG = 100;
    public static final int U_CARSET_TEMP_UNIT = 99;
    public static final int U_CNT_MAX = 113;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 113; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_XC_Ruijie(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 113) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
