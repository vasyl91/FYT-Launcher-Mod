package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0287_XP_JEEP extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_END = 1;
    public static final int U_CAREQ_D17_D0_B70 = 9;
    public static final int U_CAREQ_D17_D1_B70 = 10;
    public static final int U_CAREQ_D17_D2_B70 = 11;
    public static final int U_CAREQ_D17_D3_B70 = 12;
    public static final int U_CAREQ_D17_D4_B70 = 13;
    public static final int U_CAREQ_D17_D5_B70 = 14;
    public static final int U_CAREQ_D17_D6_B70 = 15;
    public static final int U_CARINF_D40_D40_D3_B1 = 8;
    public static final int U_CNT_MAX = 16;
    public static final int U_DOOR_BACK = 6;
    public static final int U_DOOR_BEGIN = 1;
    public static final int U_DOOR_END = 7;
    public static final int U_DOOR_ENGINE = 1;
    public static final int U_DOOR_FL = 2;
    public static final int U_DOOR_FR = 3;
    public static final int U_DOOR_RL = 4;
    public static final int U_DOOR_RR = 5;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 16; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 1;
        DoorHelper.sUcDoorFl = 2;
        DoorHelper.sUcDoorFr = 3;
        DoorHelper.sUcDoorRl = 4;
        DoorHelper.sUcDoorRr = 5;
        DoorHelper.sUcDoorBack = 6;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 1; i2 < 7; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 1; i < 7; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 16) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
