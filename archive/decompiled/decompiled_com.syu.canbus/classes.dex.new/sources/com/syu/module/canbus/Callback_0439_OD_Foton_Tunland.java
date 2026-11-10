package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_Foton_Tunland;
import com.syu.ui.air.Air_0455_Oudi_Foton_Kawenlefu;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0439_OD_Foton_Tunland extends CallbackCanbusBase {
    public static final int U_CARSET_BEGIN = 97;
    public static final int U_CARSET_D40_D0_B70 = 98;
    public static final int U_CARSET_D40_D1_B70 = 99;
    public static final int U_CARSET_D40_D2_B70 = 100;
    public static final int U_CARSET_D40_D3_B70 = 101;
    public static final int U_CARSET_D40_D4_B2 = 108;
    public static final int U_CARSET_D40_D4_B3 = 107;
    public static final int U_CARSET_D40_D4_B4 = 106;
    public static final int U_CARSET_D40_D4_B65 = 105;
    public static final int U_CARSET_D40_D4_B7 = 104;
    public static final int U_CARSET_D40_D5_B30 = 110;
    public static final int U_CARSET_D40_D5_B74 = 109;
    public static final int U_CARSET_D41_D0_B70 = 102;
    public static final int U_CARSET_D41_D1_B70 = 103;
    public static final int U_CNT_MAX = 111;

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_OD_Futon_Kawenlefu /* 7471559 */:
                AirHelper.getInstance().buildUi(new Air_0455_Oudi_Foton_Kawenlefu(TheApp.getInstance()));
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0439_OD_Foton_Tunland(TheApp.getInstance()));
                break;
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
