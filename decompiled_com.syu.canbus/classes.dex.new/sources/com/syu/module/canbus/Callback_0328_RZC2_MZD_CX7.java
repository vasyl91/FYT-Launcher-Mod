package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0328_RZC2_MZD_CX7 extends CallbackCanbusBase {
    public static final int U_CAREQ_D31_D0_B70 = 15;
    public static final int U_CAREQ_D31_D1_B70 = 16;
    public static final int U_CAREQ_D31_D2_B70 = 17;
    public static final int U_CAREQ_D31_D3_B70 = 18;
    public static final int U_CAREQ_D31_D4_B70 = 19;
    public static final int U_CAREQ_D31_D5_B0 = 20;
    public static final int U_CNT_MAX = 21;
    public static final int U_CUR_OIL_EXPEND = 11;
    public static final int U_DRIVING_MILEAGE = 12;
    public static final int U_LAST_OIL = 14;
    public static final int U_OPTIMAL_OIL_EXPEND = 13;
    public static final int U_PRESSURE_FL = 7;
    public static final int U_PRESSURE_FR = 8;
    public static final int U_PRESSURE_RL = 9;
    public static final int U_PRESSURE_RR = 10;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 21; i++) {
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
        if (updateCode >= 0 && updateCode < 21) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
