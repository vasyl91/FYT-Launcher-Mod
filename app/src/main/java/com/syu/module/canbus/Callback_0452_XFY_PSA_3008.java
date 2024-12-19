package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_XFY_PSA_3008 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 14;
    public static final int U_AIR_ACMAX = 17;
    public static final int U_AIR_AUTO = 13;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 11;
    public static final int U_AIR_BLOW_FOOT_LEFT = 12;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_CYCLE = 16;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_MAX = 19;
    public static final int U_AIR_REAR_DEFROST = 18;
    public static final int U_AIR_TEMP_LEFT = 7;
    public static final int U_AIR_TEMP_RIGHT = 8;
    public static final int U_AIR_WIND_LEVEL = 9;
    public static final int U_AIR_WIND_MODE = 20;
    public static final int U_CARINF_BEGIN = 33;
    public static final int U_CARINF_D50_D0_D1 = 34;
    public static final int U_CARINF_D50_D2_D3 = 35;
    public static final int U_CARINF_D50_D4_D5 = 36;
    public static final int U_CARINF_D51_D0_D1 = 37;
    public static final int U_CARINF_D51_D2_D3 = 38;
    public static final int U_CARINF_D51_D4_D5 = 39;
    public static final int U_CARINF_D52_D0_D1 = 40;
    public static final int U_CARINF_D52_D2_D3 = 41;
    public static final int U_CARINF_D52_D4_D5 = 42;
    public static final int U_CARINF_JUMP = 43;
    public static final int U_CARSET_BEGIN = 21;
    public static final int U_CARSET_D26_D0_B0 = 22;
    public static final int U_CARSET_D26_D0_B1 = 23;
    public static final int U_CARSET_D26_D0_B2 = 24;
    public static final int U_CARSET_D26_D0_B3 = 25;
    public static final int U_CARSET_D26_D0_B64 = 26;
    public static final int U_CARSET_D26_D0_B7 = 27;
    public static final int U_CARSET_D26_D1_B2 = 28;
    public static final int U_CARSET_D26_D1_B3 = 29;
    public static final int U_CARSET_D26_D1_B4 = 30;
    public static final int U_CARSET_D26_D1_B5 = 31;
    public static final int U_CARSET_D26_D1_B76 = 32;
    public static final int U_CNT_MAX = 44;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 44; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 44) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
