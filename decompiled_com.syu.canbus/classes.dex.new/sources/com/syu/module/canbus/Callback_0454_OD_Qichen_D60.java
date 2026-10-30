package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_OD_QichenD60EV;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0454_OD_Qichen_D60 extends CallbackCanbusBase {
    public static final int U_CARINF_D38_D4_B70 = 107;
    public static final int U_CARINF_D38_D5_B70 = 108;
    public static final int U_CARINF_D38_D6_B70 = 109;
    public static final int U_CARINF_D38_D7_B70 = 110;
    public static final int U_CARINF_D41_D0_B5 = 100;
    public static final int U_CARINF_D41_D0_B6 = 99;
    public static final int U_CARINF_D41_D0_B7 = 98;
    public static final int U_CARINF_D41_D12_D13 = 106;
    public static final int U_CARINF_D41_D14_B70 = 111;
    public static final int U_CARINF_D41_D15_B70 = 112;
    public static final int U_CARINF_D41_D17_B70 = 113;
    public static final int U_CARINF_D41_D1_D2 = 101;
    public static final int U_CARINF_D41_D3_D4 = 102;
    public static final int U_CARINF_D41_D5_D6 = 103;
    public static final int U_CARINF_D41_D7_D8 = 104;
    public static final int U_CARINF_D41_D9_D11 = 105;
    public static final int U_CNT_MAX = 114;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0454_OD_QichenD60EV(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
