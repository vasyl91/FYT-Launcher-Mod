package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0144_WC1_ZhiNanZhe extends CallbackCanbusBase {
    public static final int U_CAREQ_D0_B70 = 9;
    public static final int U_CAREQ_D1_B70 = 10;
    public static final int U_CAREQ_D2_B70 = 11;
    public static final int U_CAREQ_D3_B70 = 12;
    public static final int U_CAREQ_D4_B70 = 13;
    public static final int U_CAREQ_D5_B70 = 14;
    public static final int U_CNT_MAX = 15;
    public static final int U_CUR_SPEED = 0;
    public static final int U_DOOR_BACK = 7;
    public static final int U_DOOR_BEGIN = 2;
    public static final int U_DOOR_END = 8;
    public static final int U_DOOR_ENGINE = 2;
    public static final int U_DOOR_FL = 3;
    public static final int U_DOOR_FR = 4;
    public static final int U_DOOR_RL = 5;
    public static final int U_DOOR_RR = 6;
    public static final int U_ENGINE_SPEED = 1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 15; i++) {
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
        if (updateCode >= 0 && updateCode < 15) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
