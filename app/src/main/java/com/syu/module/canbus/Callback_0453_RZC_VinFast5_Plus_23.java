package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_Rzc_VinFast_Plus_23;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_RZC_VinFast5_Plus_23 extends CallbackCanbusBase {
    public static final int U_CARSET_D26_D0_B30 = 87;
    public static final int U_CARSET_D26_D0_B74 = 86;
    public static final int U_CARSET_D26_D1_B30 = 89;
    public static final int U_CARSET_D26_D1_B7 = 88;
    public static final int U_CARSET_D26_D2_B40 = 93;
    public static final int U_CARSET_D26_D2_B5 = 92;
    public static final int U_CARSET_D26_D2_B6 = 91;
    public static final int U_CARSET_D26_D2_B7 = 90;
    public static final int U_CARSET_D26_D3_B2 = 99;
    public static final int U_CARSET_D26_D3_B3 = 98;
    public static final int U_CARSET_D26_D3_B4 = 97;
    public static final int U_CARSET_D26_D3_B5 = 96;
    public static final int U_CARSET_D26_D3_B6 = 95;
    public static final int U_CARSET_D26_D3_B7 = 94;
    public static final int U_CARSET_D26_D4_B5 = 102;
    public static final int U_CARSET_D26_D4_B6 = 101;
    public static final int U_CARSET_D26_D4_B7 = 100;
    public static final int U_CARSET_D26_D5_70 = 103;
    public static final int U_CARSET_D26_D6_70 = 104;
    public static final int U_CARSET_D40_D0_D1 = 105;
    public static final int U_CARSET_D40_D2_B70 = 106;
    public static final int U_CNT_MAX = 107;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_Rzc_VinFast_Plus_23(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
