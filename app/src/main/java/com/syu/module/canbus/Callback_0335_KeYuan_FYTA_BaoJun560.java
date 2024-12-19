package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0335_KeYuan_FYTA_BaoJun560 extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_END = 1;
    public static final int U_CNT_MAX = 7;
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
        for (int i = 0; i < 7; i++) {
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
        if (updateCode >= 0 && updateCode < 7) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
