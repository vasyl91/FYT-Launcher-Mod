package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0108_WC2_GeShiTu extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 31;
    public static final int U_DOOR_BACK = 30;
    public static final int U_DOOR_BEGIN = 25;
    public static final int U_DOOR_END = 31;
    public static final int U_DOOR_ENGINE = 25;
    public static final int U_DOOR_FL = 26;
    public static final int U_DOOR_FR = 27;
    public static final int U_DOOR_RL = 28;
    public static final int U_DOOR_RR = 29;
    public static final int U_LIGHT_TRAVEL_MODE = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 31; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 25;
        DoorHelper.sUcDoorFl = 26;
        DoorHelper.sUcDoorFr = 27;
        DoorHelper.sUcDoorRl = 28;
        DoorHelper.sUcDoorRr = 29;
        DoorHelper.sUcDoorBack = 30;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 25; i2 < 31; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 25; i < 31; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 31) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
