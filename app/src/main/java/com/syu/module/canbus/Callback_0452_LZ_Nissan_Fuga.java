package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Nissan_Fuga extends CallbackCanbusBase {
    public static final int U_AIR_BLOW_FOOT_RIGHT = 111;
    public static final int U_AIR_BLOW_UP_RIGHT = 110;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D35_D0_B70 = 99;
    public static final int U_CARINF_D35_D10_B6 = 105;
    public static final int U_CARINF_D35_D10_B7 = 104;
    public static final int U_CARINF_D35_D1_B70 = 100;
    public static final int U_CARINF_D35_D2_D3 = 101;
    public static final int U_CARINF_D35_D4_D5 = 102;
    public static final int U_CARINF_D35_D7_D8_D9 = 103;
    public static final int U_CARINF_D36_D0_B70 = 106;
    public static final int U_CARINF_D36_D1_B70 = 107;
    public static final int U_CARINF_D36_D2_B70 = 108;
    public static final int U_CARINF_D36_D3_B70 = 109;
    public static final int U_CNT_MAX = 112;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_Nissan_Fuga(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
        DataCanbus.NOTIFY_EVENTS[110].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
        if (updateCode >= 0 && updateCode < 112) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
