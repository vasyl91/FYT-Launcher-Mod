package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0362_RZC3_16_QiYaK5 extends CallbackCanbusBase {
    public static String CarFrameNum = "";
    public static final int U_BLIND_SPOTS = 103;
    public static final int U_CARINFO_CARMOD_ON = 105;
    public static final int U_CARINFO_D52_D10_B70 = 106;
    public static final int U_CARINFO_D52_D11_B70 = 107;
    public static final int U_CARINFO_D52_D12_B70 = 108;
    public static final int U_CARINFO_D52_D13_B70 = 109;
    public static final int U_CARINFO_D52_D14_B70 = 110;
    public static final int U_CARINFO_D60_D00_B70 = 104;
    public static final int U_CARINFO_EQ_BAL = 102;
    public static final int U_CARINFO_EQ_BASS = 98;
    public static final int U_CARINFO_EQ_FAD = 101;
    public static final int U_CARINFO_EQ_MID = 99;
    public static final int U_CARINFO_EQ_TREB = 100;
    public static final int U_CARINFO_EQ_VOL = 112;
    public static final int U_CARINFO_LAGUAGE = 111;
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
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0362_RZC_16_QiYaK5(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 113) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
