package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_TATA_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_TATA_All extends CallbackCanbusBase {
    public static final int U_CARINF_D13_D2_D3 = 97;
    public static final int U_CARINF_D14_D0_B70 = 98;
    public static final int U_CARINF_D14_D10_B70 = 108;
    public static final int U_CARINF_D14_D11_B70 = 109;
    public static final int U_CARINF_D14_D12_B70 = 110;
    public static final int U_CARINF_D14_D13_B70 = 111;
    public static final int U_CARINF_D14_D14_B70 = 112;
    public static final int U_CARINF_D14_D15_B70 = 113;
    public static final int U_CARINF_D14_D16_B70 = 114;
    public static final int U_CARINF_D14_D17_B70 = 115;
    public static final int U_CARINF_D14_D18_B70 = 116;
    public static final int U_CARINF_D14_D19_B70 = 117;
    public static final int U_CARINF_D14_D1_B70 = 99;
    public static final int U_CARINF_D14_D2_B70 = 100;
    public static final int U_CARINF_D14_D3_B70 = 101;
    public static final int U_CARINF_D14_D4_B70 = 102;
    public static final int U_CARINF_D14_D5_B70 = 103;
    public static final int U_CARINF_D14_D6_B70 = 104;
    public static final int U_CARINF_D14_D7_B70 = 105;
    public static final int U_CARINF_D14_D8_B70 = 106;
    public static final int U_CARINF_D14_D9_B70 = 107;
    public static final int U_CARSET_D61_D0_B10 = 88;
    public static final int U_CARSET_D61_D0_B32 = 87;
    public static final int U_CARSET_D61_D0_B74 = 86;
    public static final int U_CARSET_D61_D1_B3 = 118;
    public static final int U_CARSET_D61_D1_B54 = 91;
    public static final int U_CARSET_D61_D1_B6 = 90;
    public static final int U_CARSET_D61_D1_B7 = 89;
    public static final int U_CARSET_D61_D2_B31 = 95;
    public static final int U_CARSET_D61_D2_B4 = 94;
    public static final int U_CARSET_D61_D2_B5 = 93;
    public static final int U_CARSET_D61_D2_B76 = 92;
    public static final int U_CARSET_D61_D3_B75 = 96;
    public static final int U_CARSET_D61_D6_B75 = 119;
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
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 5439931) {
            AirHelper.getInstance().buildUi(new Air_0443_WC2_TATA_All(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 85; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
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
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
