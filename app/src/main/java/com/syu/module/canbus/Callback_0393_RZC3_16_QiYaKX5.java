package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0393_RZC3_16_QiYaKX5 extends CallbackCanbusBase {
    public static final int C_CMD_SETTING = 1;
    public static final int U_BLIND_SPOTS = 104;
    public static final int U_CARINFO_EQ_BAL = 102;
    public static final int U_CARINFO_EQ_BASS = 98;
    public static final int U_CARINFO_EQ_FAD = 101;
    public static final int U_CARINFO_EQ_MID = 99;
    public static final int U_CARINFO_EQ_TREB = 100;
    public static final int U_CARINFO_EQ_VOL = 112;
    public static final int U_CARINFO_LAGUAGE = 111;
    public static final int U_CLIMATE = 103;
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
        //AirHelper.getInstance().buildUi(new Air_0393_RZC_16_QiYaKX5(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[103].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
            if (updateCode == 103) {
                if (ints[0] == 0) {
                    AirHelper.getInstance().hideWindow();
                } else {
                    AirHelper.getInstance().showAndRefresh();
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
