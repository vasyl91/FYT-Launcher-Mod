package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_BMW_15Mini extends CallbackCanbusBase {
    public static final int U_CARINF_D12_D1_B6 = 8;
    public static final int U_CARINF_D12_D1_B7 = 7;
    public static final int U_CARINF_D12_D2_B70 = 9;
    public static final int U_CARINF_D40_D0_D1_D2 = 10;
    public static final int U_CARINF_D40_D3_D4 = 11;
    public static final int U_CARINF_D46_D0_B3 = 16;
    public static final int U_CARINF_D46_D0_B4 = 15;
    public static final int U_CARINF_D46_D0_B5 = 14;
    public static final int U_CARINF_D46_D0_B6 = 13;
    public static final int U_CARINF_D46_D0_B7 = 12;
    public static final int U_CARINF_D46_D1_B54 = 18;
    public static final int U_CARINF_D46_D1_B7 = 17;
    public static final int U_CARINF_D46_D2_B1 = 21;
    public static final int U_CARINF_D46_D2_B32 = 20;
    public static final int U_CARINF_D46_D2_B74 = 19;
    public static final int U_CARINF_D46_D3_B4 = 25;
    public static final int U_CARINF_D46_D3_B5 = 24;
    public static final int U_CARINF_D46_D3_B6 = 23;
    public static final int U_CARINF_D46_D3_B7 = 22;
    public static final int U_CARINF_D46_D4_B70 = 26;
    public static final int U_CARINF_D46_D5_B2 = 32;
    public static final int U_CARINF_D46_D5_B3 = 31;
    public static final int U_CARINF_D46_D5_B4 = 30;
    public static final int U_CARINF_D46_D5_B5 = 29;
    public static final int U_CARINF_D46_D5_B6 = 28;
    public static final int U_CARINF_D46_D5_B7 = 27;
    public static final int U_CARINF_D46_D6_B7 = 33;
    public static final int U_CARINF_D46_WARN_SPEED = 34;
    public static final int U_CARINF_D48_D0_D1 = 35;
    public static final int U_CARINF_D48_D2_D3 = 36;
    public static final int U_CARINF_D48_D4_D5 = 37;
    public static final int U_CARINF_D49_D0_B0 = 39;
    public static final int U_CARINF_D49_D0_B64 = 39;
    public static final int U_CARINF_D49_D0_B7 = 38;
    public static final int U_CARINF_D49_D11_D12 = 51;
    public static final int U_CARINF_D49_D13_B70 = 52;
    public static final int U_CARINF_D49_D14_D15 = 53;
    public static final int U_CARINF_D49_D16_D17 = 54;
    public static final int U_CARINF_D49_D18_D19 = 55;
    public static final int U_CARINF_D49_D1_B10 = 43;
    public static final int U_CARINF_D49_D1_B32 = 42;
    public static final int U_CARINF_D49_D1_B54 = 41;
    public static final int U_CARINF_D49_D1_B76 = 40;
    public static final int U_CARINF_D49_D20_D21 = 56;
    public static final int U_CARINF_D49_D2_B32 = 46;
    public static final int U_CARINF_D49_D2_B54 = 45;
    public static final int U_CARINF_D49_D2_B76 = 44;
    public static final int U_CARINF_D49_D4_B70 = 47;
    public static final int U_CARINF_D49_D5_D6 = 48;
    public static final int U_CARINF_D49_D7_D8 = 49;
    public static final int U_CARINF_D49_D9_D10 = 50;
    public static final int U_CARINF_D4A_D0_B0 = 59;
    public static final int U_CARINF_D4A_D0_B64 = 58;
    public static final int U_CARINF_D4A_D0_B7 = 57;
    public static final int U_CARINF_D4A_D1_B70 = 60;
    public static final int U_CARINF_D4B_D0_B70 = 61;
    public static final int U_CARINF_D4B_D1_B70 = 62;
    public static final int U_CARINF_D4B_D2_B70 = 63;
    public static final int U_CARINF_D4B_D3_B70 = 64;
    public static final int U_CARINF_D4B_D4_B54 = 67;
    public static final int U_CARINF_D4B_D4_B6 = 66;
    public static final int U_CARINF_D4B_D4_B7 = 65;
    public static final int U_CARINF_D4B_D5_B70 = 68;
    public static final int U_CARINF_D4B_D6_B70 = 69;
    public static final int U_CARINF_D4B_D7_B7 = 70;
    public static final int U_CARINF_D4B_DISTANCE = 71;
    public static final int U_CNT_MAX = 72;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 72; i++) {
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
        if (updateCode >= 0 && updateCode < 72) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
