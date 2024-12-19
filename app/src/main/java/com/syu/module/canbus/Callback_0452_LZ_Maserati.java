package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Maserati;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Maserati extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 86;
    public static final int U_CARINF_D35_D0_B70 = 87;
    public static final int U_CARINF_D35_D1_B70 = 88;
    public static final int U_CARINF_D35_D2_D3 = 89;
    public static final int U_CARINF_D35_D4_D5 = 90;
    public static final int U_CARINF_D35_D7_D8_D9_D10 = 91;
    public static final int U_CARINF_D37_D0_B70 = 92;
    public static final int U_CARINF_D37_D10_D11 = 100;
    public static final int U_CARINF_D37_D12_D13 = 101;
    public static final int U_CARINF_D37_D1_B70 = 93;
    public static final int U_CARINF_D37_D2_B70 = 94;
    public static final int U_CARINF_D37_D3_D4 = 95;
    public static final int U_CARINF_D37_D5_D6 = 96;
    public static final int U_CARINF_D37_D7_B70 = 97;
    public static final int U_CARINF_D37_D8_B70 = 98;
    public static final int U_CARINF_D37_D9_B70 = 99;
    public static final int U_CARINF_D38_D0_B70 = 102;
    public static final int U_CARINF_D38_D1_B30 = 106;
    public static final int U_CARINF_D38_D1_B54 = 105;
    public static final int U_CARINF_D38_D1_B6 = 104;
    public static final int U_CARINF_D38_D1_B7 = 103;
    public static final int U_CARINF_D38_D2_B1 = 113;
    public static final int U_CARINF_D38_D2_B2 = 112;
    public static final int U_CARINF_D38_D2_B3 = 111;
    public static final int U_CARINF_D38_D2_B4 = 110;
    public static final int U_CARINF_D38_D2_B5 = 109;
    public static final int U_CARINF_D38_D2_B6 = 108;
    public static final int U_CARINF_D38_D2_B7 = 107;
    public static final int U_CARINF_D38_D3_B30 = 114;
    public static final int U_CARINF_D38_D4_B70 = 115;
    public static final int U_CARINF_D39_D0_D1 = 116;
    public static final int U_CARINF_D39_D2_B70 = 117;
    public static final int U_CNT_MAX = 118;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 118; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Maserati(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
