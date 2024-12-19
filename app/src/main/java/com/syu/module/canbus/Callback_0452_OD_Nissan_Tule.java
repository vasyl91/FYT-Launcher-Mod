package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Nissan_Tule;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Nissan_Tule extends CallbackCanbusBase {
    public static final int U_CARINFO_D68_D0_D1 = 98;
    public static final int U_CARINFO_D71_D0_D1 = 95;
    public static final int U_CARINFO_D71_D2_D3 = 96;
    public static final int U_CARINFO_D71_D4_D5_D6 = 97;
    public static final int U_CAR_TIRE_BEGIN = 85;
    public static final int U_CAR_TIRE_END = 94;
    public static final int U_CAR_TIRE_VALUE_FL = 86;
    public static final int U_CAR_TIRE_VALUE_FR = 87;
    public static final int U_CAR_TIRE_VALUE_RL = 88;
    public static final int U_CAR_TIRE_VALUE_RR = 89;
    public static final int U_CAR_TIRE_WARN_FL = 90;
    public static final int U_CAR_TIRE_WARN_FR = 91;
    public static final int U_CAR_TIRE_WARN_RL = 92;
    public static final int U_CAR_TIRE_WARN_RR = 93;
    public static final int U_CNT_MAX = 99;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 99; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Nissan_Tule(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 85; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 99) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
