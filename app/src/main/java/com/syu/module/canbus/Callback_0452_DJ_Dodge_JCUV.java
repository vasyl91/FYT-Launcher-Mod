package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_DJ_Dodge_JCUV;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_DJ_Dodge_JCUV extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 113;
    public static final int U_CAREQ_BASS = 115;
    public static final int U_CAREQ_FAD = 114;
    public static final int U_CAREQ_MID = 116;
    public static final int U_CAREQ_SPEED_VOL = 118;
    public static final int U_CAREQ_TREB = 117;
    public static final int U_CAREQ_VOL = 111;
    public static final int U_CAREQ_VOL_PERCENTATE = 112;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D36_D0_B0 = 103;
    public static final int U_CARINFO_D36_D0_B1 = 102;
    public static final int U_CARINFO_D36_D0_B32 = 101;
    public static final int U_CARINFO_D36_D0_B54 = 100;
    public static final int U_CARINFO_D36_D0_B76 = 99;
    public static final int U_CARINFO_D36_D1_B21 = 109;
    public static final int U_CARINFO_D36_D1_B3 = 108;
    public static final int U_CARINFO_D36_D1_B4 = 107;
    public static final int U_CARINFO_D36_D1_B5 = 106;
    public static final int U_CARINFO_D36_D1_B6 = 105;
    public static final int U_CARINFO_D36_D1_B7 = 104;
    public static final int U_CARINFO_LANGUAGE = 120;
    public static final int U_CARINFO_UNIT = 119;
    public static final int U_CARSET_END = 110;
    public static final int U_CNT_MAX = 121;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 121; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_DJ_Dodge_JCUV(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 121) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
