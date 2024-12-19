package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC_nissan_ruiqi;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Nissan_Ruiqi6 extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_FUEL = 87;
    public static final int U_CARINFO_AVG_SPEED = 89;
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_CURRENT = 91;
    public static final int U_CARINFO_SOC = 92;
    public static final int U_CARINFO_TOTAL_MILEAGE = 88;
    public static final int U_CARINFO_VOLTAGE = 90;
    public static final int U_CARINF_END = 93;
    public static final int U_CARSET_AUTOLOCK_DRIVING = 104;
    public static final int U_CARSET_AUTOUNLOCK_STOP = 105;
    public static final int U_CARSET_BEGIN = 103;
    public static final int U_CARSET_D61_D0_B4 = 107;
    public static final int U_CARSET_HOME_LIGHT = 106;
    public static final int U_CAR_TIRE_BEGIN = 93;
    public static final int U_CAR_TIRE_END = 102;
    public static final int U_CAR_TIRE_TEMP_FL = 98;
    public static final int U_CAR_TIRE_TEMP_FR = 99;
    public static final int U_CAR_TIRE_TEMP_RL = 100;
    public static final int U_CAR_TIRE_TEMP_RR = 101;
    public static final int U_CAR_TIRE_VALUE_FL = 94;
    public static final int U_CAR_TIRE_VALUE_FR = 95;
    public static final int U_CAR_TIRE_VALUE_RL = 96;
    public static final int U_CAR_TIRE_VALUE_RR = 97;
    public static final int U_CNT_MAX = 108;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC_nissan_ruiqi(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
