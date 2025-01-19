package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_LZ_TATA_ALL;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_TATA_ALL extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D38_D0_B10 = 99;
    public static final int U_CARINF_D38_D0_B32 = 100;
    public static final int U_CARINF_D38_D0_B4 = 101;
    public static final int U_CARINF_D38_D1_B0 = 102;
    public static final int U_CARINF_D38_D1_B1 = 103;
    public static final int U_CARINF_D38_D1_B32 = 104;
    public static final int U_CARINF_D38_D1_B54 = 105;
    public static final int U_CARINF_D38_D1_B6 = 106;
    public static final int U_CARINF_D38_D1_B7 = 107;
    public static final int U_CARINF_D38_D2_B30 = 108;
    public static final int U_CARINF_D38_D2_B74 = 109;
    public static final int U_CARINF_D38_D3_B70 = 110;
    public static final int U_CNT_MAX = 111;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_TATA_ALL(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
