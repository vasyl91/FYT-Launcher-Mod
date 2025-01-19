package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_RZC_Siwei;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_SiWei extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D41_DATA0_B02 = 102;
    public static final int U_CARINFO_D41_DATA0_B03 = 101;
    public static final int U_CARINFO_D41_DATA0_B04 = 100;
    public static final int U_CARINFO_D41_DATA0_B10 = 103;
    public static final int U_CARINFO_D41_DATA0_B75 = 99;
    public static final int U_CARINFO_D41_DATA1_B00 = 109;
    public static final int U_CARINFO_D41_DATA1_B01 = 108;
    public static final int U_CARINFO_D41_DATA1_B02 = 107;
    public static final int U_CARINFO_D41_DATA1_B07 = 104;
    public static final int U_CARINFO_D41_DATA1_B43 = 106;
    public static final int U_CARINFO_D41_DATA1_B65 = 105;
    public static final int U_CARINFO_D41_DATA2_B00 = 116;
    public static final int U_CARINFO_D41_DATA2_B01 = 115;
    public static final int U_CARINFO_D41_DATA2_B03 = 114;
    public static final int U_CARINFO_D41_DATA2_B04 = 113;
    public static final int U_CARINFO_D41_DATA2_B05 = 112;
    public static final int U_CARINFO_D41_DATA2_B06 = 111;
    public static final int U_CARINFO_D41_DATA2_B07 = 110;
    public static final int U_CNT_MAX = 117;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_Siwei(LauncherApplication.getInstance()));
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
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
