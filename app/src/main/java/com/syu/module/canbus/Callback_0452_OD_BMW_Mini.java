package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_BMW_Mini extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D03_D2_D3 = 99;
    public static final int U_CARINFO_D03_D4_D5 = 100;
    public static final int U_CARINFO_D03_D6_D7 = 101;
    public static final int U_CARINFO_D04_D0_B70 = 102;
    public static final int U_CARINFO_D04_D1_B70 = 103;
    public static final int U_CARINFO_D04_D2_B70 = 104;
    public static final int U_CARINFO_D04_D3_B70 = 105;
    public static final int U_CARINFO_D04_D4_B70 = 106;
    public static final int U_CARINFO_D04_D5_B70 = 115;
    public static final int U_CARINFO_D40_D0_B70 = 107;
    public static final int U_CARINFO_D40_D1_B70 = 108;
    public static final int U_CARINFO_D40_D2_B70 = 109;
    public static final int U_CARINFO_D40_D3_B70 = 110;
    public static final int U_CARINFO_D40_D4_B70 = 111;
    public static final int U_CARINFO_D40_D5_B70 = 112;
    public static final int U_CARINFO_D40_D6_B70 = 113;
    public static final int U_CARINFO_D40_D7_B70 = 114;
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_BMW_Mini(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
