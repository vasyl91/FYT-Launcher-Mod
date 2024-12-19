package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0412_XP1_YearGmcSeries extends CallbackCanbusBase {
    public static final int U_CARSET_D38_D0_B10 = 8;
    public static final int U_CARSET_D38_D0_B2 = 9;
    public static final int U_CARSET_D38_D0_B3 = 10;
    public static final int U_CARSET_D38_D0_B4 = 11;
    public static final int U_CARSET_D38_D0_B5 = 12;
    public static final int U_CARSET_D38_D0_B6 = 13;
    public static final int U_CARSET_D38_D0_B7 = 14;
    public static final int U_CARSET_D38_D1_B0 = 15;
    public static final int U_CARSET_D38_D1_B1 = 16;
    public static final int U_CARSET_D38_D1_B2 = 17;
    public static final int U_CARSET_D38_D1_B3 = 18;
    public static final int U_CARSET_D38_D1_B4 = 19;
    public static final int U_CARSET_D38_D1_B75 = 20;
    public static final int U_CARSET_D38_D2_B0 = 21;
    public static final int U_CARSET_D38_D2_B1 = 22;
    public static final int U_CARSET_D38_D2_B2 = 23;
    public static final int U_CARSET_D38_D2_B3 = 24;
    public static final int U_CARSET_D38_D2_B4 = 25;
    public static final int U_CARSET_D38_D3_B70 = 26;
    public static final int U_CAR_SPEED = 7;
    public static final int U_CNT_MAX = 27;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 27; i++) {
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
        if (updateCode >= 0 && updateCode < 27) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
