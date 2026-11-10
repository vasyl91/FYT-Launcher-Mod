package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_Oudi_Changan_Lumin;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Callback_0454_OD_Changan_Lumin extends CallbackCanbusBase {
    public static final int U_CARSER_D66_D0_B4 = 99;
    public static final int U_CARSER_D66_D0_B75 = 98;
    public static final int U_CARSER_D66_D1_B0 = 101;
    public static final int U_CARSER_D66_D1_B1 = 100;
    public static final int U_CARSER_D66_D1_B2 = 104;
    public static final int U_CARSER_D66_D1_B3 = 106;
    public static final int U_CARSER_D66_D1_B4 = 105;
    public static final int U_CARSER_D66_D2_B0 = 103;
    public static final int U_CARSER_D66_D2_B1 = 102;
    public static final int U_CARSER_D66_D3_B70 = 107;
    public static final int U_CARSER_XTA_D66_D0_B20 = 108;
    public static final int U_CARSER_XTA_D66_D1_B0 = 115;
    public static final int U_CARSER_XTA_D66_D1_B1 = 114;
    public static final int U_CARSER_XTA_D66_D1_B2 = 113;
    public static final int U_CARSER_XTA_D66_D1_B43 = 112;
    public static final int U_CARSER_XTA_D66_D1_B5 = 111;
    public static final int U_CARSER_XTA_D66_D1_B6 = 110;
    public static final int U_CARSER_XTA_D66_D1_B7 = 109;
    public static final int U_CARSER_XTA_D66_D2_B10 = 117;
    public static final int U_CARSER_XTA_D66_D2_B32 = 116;
    public static final int U_CARSER_XTA_D66_D3_B70 = 118;
    public static final int U_CARSER_XTA_D66_D4_D5 = 119;
    public static final int U_CNT_MAX = 120;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0454_Oudi_Changan_Lumin(TheApp.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
