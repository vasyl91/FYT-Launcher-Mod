package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_LZ_GMC_Chevrolet_Screen extends CallbackCanbusBase {
    public static final int U_CARINF_D35_D10_B70 = 106;
    public static final int U_CARINF_D35_D11_B6 = 108;
    public static final int U_CARINF_D35_D11_B7 = 107;
    public static final int U_CARINF_D35_D2_D3 = 104;
    public static final int U_CARINF_D35_D7_D9 = 105;
    public static final int U_CARSET_SCREE_TYPE = 109;
    public static final int U_CAR_ANDROID_UI_VOL = 99;
    public static final int U_CAR_AUDI_TYPE = 110;
    public static final int U_CAR_LVDS_MODE = 101;
    public static final int U_CAR_SCREEN_H = 103;
    public static final int U_CAR_SCREEN_W = 102;
    public static final int U_CAR_UI_VOL = 98;
    public static final int U_CAR_VOICE_ANDROID = 100;
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
        //AirHelper.getInstance().buildUi(new Air_0454_LZ_GMC_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
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
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
