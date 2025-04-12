package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_RDW_Benz_All extends CallbackCanbusBase {
    public static final int U_CARINF_D41_T2_D1_D3 = 122;
    public static final int U_CARSET_D05_D0_B70 = 98;
    public static final int U_CARSET_D0D_D0_B10 = 100;
    public static final int U_CARSET_D0D_D0_B32 = 99;
    public static final int U_CARSET_D0D_D1_B10 = 103;
    public static final int U_CARSET_D0D_D1_B2 = 102;
    public static final int U_CARSET_D0D_D1_B3 = 101;
    public static final int U_CARSET_D0F_D0_B30 = 104;
    public static final int U_CARSET_D0F_D1_B30 = 106;
    public static final int U_CARSET_D0F_D1_B74 = 105;
    public static final int U_CARSET_D0F_D2_B30 = 108;
    public static final int U_CARSET_D0F_D2_B74 = 107;
    public static final int U_CARSET_D0F_D3_B30 = 109;
    public static final int U_CARSET_D0F_D4_B30 = 111;
    public static final int U_CARSET_D0F_D4_B74 = 110;
    public static final int U_CARSET_D0F_D5_B30 = 113;
    public static final int U_CARSET_D0F_D5_B74 = 112;
    public static final int U_CARSET_D0F_D6_B30 = 115;
    public static final int U_CARSET_D0F_D6_B74 = 114;
    public static final int U_CARSET_D0F_D7_B30 = 117;
    public static final int U_CARSET_D0F_D7_B74 = 116;
    public static final int U_CARSET_D0F_D8_B30 = 119;
    public static final int U_CARSET_D0F_D8_B74 = 118;
    public static final int U_CARSET_D0F_D9_B30 = 121;
    public static final int U_CARSET_D0F_D9_B74 = 120;
    public static final int U_CNT_MAX = 99;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 99; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0453_TD_LandRover_All(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        //AirHelper.getInstance().buildUi(new Air_0454_RDW_Benz_All(LauncherApplication.getInstance()));
        for (int i4 = 10; i4 < 97; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 99) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
