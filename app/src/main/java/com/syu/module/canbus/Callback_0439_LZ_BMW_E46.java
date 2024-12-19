package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LZ_BMW_E46 extends CallbackCanbusBase {
    public static final int U_CARINFO_D35_D0_D6 = 35;
    public static final int U_CARINFO_D35_D10_B6 = 42;
    public static final int U_CARINFO_D35_D10_B7 = 41;
    public static final int U_CARINFO_D35_D1_B70 = 36;
    public static final int U_CARINFO_D35_D2_D3 = 37;
    public static final int U_CARINFO_D35_D4_D5 = 38;
    public static final int U_CARINFO_D35_D6_B70 = 39;
    public static final int U_CARINFO_D35_D7_D8_D9 = 40;
    public static final int U_CARINFO_D37_D0_D1 = 9;
    public static final int U_CARINFO_D37_D2_D3 = 10;
    public static final int U_CARINFO_D37_D4_D5 = 11;
    public static final int U_CARINFO_D37_D6_B0 = 12;
    public static final int U_CARINFO_D37_D6_B21 = 13;
    public static final int U_CARINFO_D38_D0_D1 = 14;
    public static final int U_CARINFO_D38_D2_B0 = 15;
    public static final int U_CARINFO_D38_D2_B1 = 16;
    public static final int U_CARINFO_D38_D2_B32 = 17;
    public static final int U_CARINFO_D38_D2_B4 = 18;
    public static final int U_CARINFO_D38_D2_B5 = 19;
    public static final int U_CARINFO_D38_D2_B6 = 20;
    public static final int U_CARINFO_D38_D2_B7 = 21;
    public static final int U_CARINFO_D38_D3_D4 = 22;
    public static final int U_CARINFO_D38_D5_B70 = 23;
    public static final int U_CARINFO_D38_D6_B70 = 24;
    public static final int U_CARINFO_D38_D7_B70 = 25;
    public static final int U_CARINFO_D38_D8_B70 = 26;
    public static final int U_CARINFO_D39_D0_B30 = 28;
    public static final int U_CARINFO_D39_D0_B74 = 27;
    public static final int U_CARINFO_D39_D1_B70 = 29;
    public static final int U_CARINFO_D39_D2_B70 = 30;
    public static final int U_CARINFO_D39_D3_B70 = 31;
    public static final int U_CARINFO_D3B_D0_B0 = 45;
    public static final int U_CARINFO_D3B_D0_B1 = 44;
    public static final int U_CARINFO_D3B_D0_B74 = 43;
    public static final int U_CARINFO_D3B_D1_B70 = 46;
    public static final int U_CARINFO_D3B_D2_B70 = 47;
    public static final int U_CARINFO_LINE1 = 32;
    public static final int U_CARINFO_LINE2 = 33;
    public static final int U_CARINFO_LINE3 = 34;
    public static final int U_CAR_WARN = 1;
    public static final int U_CNT_MAX = 48;
    public static final int U_DOOR_BACK = 7;
    public static final int U_DOOR_BEGIN = 2;
    public static final int U_DOOR_END = 8;
    public static final int U_DOOR_ENGINE = 2;
    public static final int U_DOOR_FL = 3;
    public static final int U_DOOR_FR = 4;
    public static final int U_DOOR_RL = 5;
    public static final int U_DOOR_RR = 6;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 48; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 2;
        DoorHelper.sUcDoorFl = 3;
        DoorHelper.sUcDoorFr = 4;
        DoorHelper.sUcDoorRl = 5;
        DoorHelper.sUcDoorRr = 6;
        DoorHelper.sUcDoorBack = 7;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 2; i2 < 8; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 2; i < 8; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 48) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
