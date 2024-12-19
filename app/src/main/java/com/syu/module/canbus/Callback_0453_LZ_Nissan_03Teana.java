package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_Nissan_03Teana;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_Nissan_03Teana extends CallbackCanbusBase {
    public static final int U_CARINF_D35_D10_B6 = 94;
    public static final int U_CARINF_D35_D10_B7 = 93;
    public static final int U_CARINF_D35_D1_B70 = 90;
    public static final int U_CARINF_D35_D2_D3 = 91;
    public static final int U_CARINF_D35_D7_D8_D9 = 92;
    public static final int U_CARINF_D37_D0_D1 = 86;
    public static final int U_CARINF_D37_D2_D3 = 87;
    public static final int U_CARINF_D37_D4_D5_D6 = 88;
    public static final int U_CARINF_D37_D7_D8 = 89;
    public static final int U_CARINF_D39_D0_B0 = 104;
    public static final int U_CARINF_D39_D0_B1 = 103;
    public static final int U_CARINF_D39_D0_B2 = 102;
    public static final int U_CARINF_D39_D0_B3 = 101;
    public static final int U_CARINF_D39_D0_B4 = 100;
    public static final int U_CARINF_D39_D0_B5 = 99;
    public static final int U_CARINF_D39_D1_B30 = 106;
    public static final int U_CARINF_D39_D1_B74 = 105;
    public static final int U_CARINF_D39_D2_B30 = 108;
    public static final int U_CARINF_D39_D2_B74 = 107;
    public static final int U_CARINF_D39_D3_B70 = 109;
    public static final int U_CARINF_D39_D4_B70 = 110;
    public static final int U_CARINF_D39_D5_B70 = 111;
    public static final int U_CNT_MAX = 112;
    public static final int U_TIRE_VALUE_FL = 95;
    public static final int U_TIRE_VALUE_FR = 96;
    public static final int U_TIRE_VALUE_RL = 97;
    public static final int U_TIRE_VALUE_RR = 98;

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
        AirHelper.getInstance().buildUi(new Air_0453_LZ_Nissan_03Teana(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 85; i++) {
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
        if (updateCode >= 0 && updateCode < 112) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
