package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_OD_Bent_NAT;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0453_OD_Bent_NAT_Energy extends CallbackCanbusBase {
    public static final int U_CARINF_D41_D0_D1 = 107;
    public static final int U_CARINF_D41_D2_D3 = 108;
    public static final int U_CARINF_D41_D4_D6 = 109;
    public static final int U_CARINF_D41_D7_D8 = 110;
    public static final int U_CARINF_D41_D9_B70 = 111;
    public static final int U_CARINF_D42_D0_D1 = 112;
    public static final int U_CARINF_D42_D2_D3 = 113;
    public static final int U_CARINF_D42_D4_B70 = 114;
    public static final int U_CARINF_D42_D5_B70 = 115;
    public static final int U_CARINF_D42_D6_B70 = 116;
    public static final int U_CARINF_D43_D0_D1 = 117;
    public static final int U_CARINF_D43_D2_D3 = 118;
    public static final int U_CARINF_D43_D4_B70 = 119;
    public static final int U_CARINF_D43_D7_B70 = 120;
    public static final int U_CARINF_D43_D8_B70 = 121;
    public static final int U_CARSET_D40_D0_B70 = 98;
    public static final int U_CARSET_D40_D1_B70 = 99;
    public static final int U_CARSET_D40_D2_B70 = 100;
    public static final int U_CARSET_D40_D3_B70 = 101;
    public static final int U_CARSET_D40_D4_B70 = 102;
    public static final int U_CARSET_D40_D5_B70 = 103;
    public static final int U_CARSET_D40_D6_B70 = 104;
    public static final int U_CARSET_D40_D7_B70 = 105;
    public static final int U_CARSET_D40_D8_B70 = 106;
    public static final int U_CNT_MAX = 122;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_OD_Bent_NAT(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
