package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_RZC_VinFast5_Plus_23 extends CallbackCanbusBase {
    public static final int U_CARSET_D26_D0_B30 = 99;
    public static final int U_CARSET_D26_D0_B74 = 98;
    public static final int U_CARSET_D26_D1_B30 = 101;
    public static final int U_CARSET_D26_D1_B7 = 100;
    public static final int U_CARSET_D26_D2_B40 = 105;
    public static final int U_CARSET_D26_D2_B5 = 104;
    public static final int U_CARSET_D26_D2_B6 = 103;
    public static final int U_CARSET_D26_D2_B7 = 102;
    public static final int U_CARSET_D26_D3_B2 = 111;
    public static final int U_CARSET_D26_D3_B3 = 110;
    public static final int U_CARSET_D26_D3_B4 = 109;
    public static final int U_CARSET_D26_D3_B5 = 108;
    public static final int U_CARSET_D26_D3_B6 = 107;
    public static final int U_CARSET_D26_D3_B7 = 106;
    public static final int U_CARSET_D26_D4_B20 = 122;
    public static final int U_CARSET_D26_D4_B3 = 121;
    public static final int U_CARSET_D26_D4_B5 = 114;
    public static final int U_CARSET_D26_D4_B6 = 113;
    public static final int U_CARSET_D26_D4_B7 = 112;
    public static final int U_CARSET_D26_D5_70 = 115;
    public static final int U_CARSET_D26_D6_70 = 116;
    public static final int U_CARSET_D40_D0_D1 = 117;
    public static final int U_CARSET_D40_D2_B70 = 118;
    public static final int U_CARSET_D40_D3_B0 = 119;
    public static final int U_CARSET_D40_D4_D5 = 120;
    public static final int U_CAR_ANDROID_UI_VOL = 124;
    public static final int U_CAR_TYPE = 126;
    public static final int U_CAR_UI_VOL = 123;
    public static final int U_CAR_VOICE_ANDROID = 125;
    public static final int U_CNT_MAX = 127;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0453_Rzc_VinFast_Plus_23(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
