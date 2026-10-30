package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0455_OD_25HongGuangMini;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0454_OD_Wulin_HongguangEV extends CallbackCanbusBase {
    public static final int U_CARSER_D40_D0_B10 = 100;
    public static final int U_CARSER_D40_D0_B32 = 99;
    public static final int U_CARSER_D40_D0_B4 = 98;
    public static final int U_CARSER_D40_D10_B70 = 118;
    public static final int U_CARSER_D40_D1_B70 = 101;
    public static final int U_CARSER_D40_D2_B70 = 102;
    public static final int U_CARSER_D40_D3_B10 = 106;
    public static final int U_CARSER_D40_D3_B2 = 105;
    public static final int U_CARSER_D40_D3_B3 = 104;
    public static final int U_CARSER_D40_D3_B4 = 103;
    public static final int U_CARSER_D40_D4_B20 = 111;
    public static final int U_CARSER_D40_D4_B3 = 110;
    public static final int U_CARSER_D40_D4_B54 = 109;
    public static final int U_CARSER_D40_D4_B6 = 108;
    public static final int U_CARSER_D40_D4_B7 = 107;
    public static final int U_CARSER_D40_D5_B0 = 113;
    public static final int U_CARSER_D40_D5_B1 = 112;
    public static final int U_CARSER_D40_D5_B74 = 119;
    public static final int U_CARSER_D40_D6_B70 = 114;
    public static final int U_CARSER_D40_D7_B70 = 115;
    public static final int U_CARSER_D40_D8_B70 = 116;
    public static final int U_CARSER_D40_D9_B70 = 117;
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
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 5571015 || DataCanbus.DATA[1000] == 5636551) {
            AirHelper.getInstance().buildUi(new Air_0455_OD_25HongGuangMini(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
