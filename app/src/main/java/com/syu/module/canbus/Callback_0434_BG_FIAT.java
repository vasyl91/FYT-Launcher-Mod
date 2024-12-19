package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0434_BG_FIAT extends CallbackCanbusBase {
    public static final int C_USB_ACTION = 0;
    public static final int U_CAR_BT_STATE = 1;
    public static final int U_CAR_SET = 4;
    public static final int U_CAR_USB_PLAYTIME = 3;
    public static final int U_CAR_USB_STATE = 2;
    public static final int U_CAR_VOICE_STATE = 0;
    public static final int U_CNT_MAX = 10;
    public static final int U_DOOR_BACK = 9;
    public static final int U_DOOR_BEGIN = 4;
    public static final int U_DOOR_END = 10;
    public static final int U_DOOR_ENGINE = 4;
    public static final int U_DOOR_FL = 5;
    public static final int U_DOOR_FR = 6;
    public static final int U_DOOR_RL = 7;
    public static final int U_DOOR_RR = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 10; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 4;
        DoorHelper.sUcDoorFl = 5;
        DoorHelper.sUcDoorFr = 6;
        DoorHelper.sUcDoorRl = 7;
        DoorHelper.sUcDoorRr = 8;
        DoorHelper.sUcDoorBack = 9;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 4; i2 < 10; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 4; i < 10; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 10) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
