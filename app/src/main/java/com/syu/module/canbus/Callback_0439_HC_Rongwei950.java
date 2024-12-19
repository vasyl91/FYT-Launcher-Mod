package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Rongwei950;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_Rongwei950 extends CallbackCanbusBase {
    public static final int C_CARSET_CONTROL = 1;
    public static final int U_CARSET_AIR_AUTOBLOW_MODE = 87;
    public static final int U_CARSET_AIR_DUAL_TEMP = 89;
    public static final int U_CARSET_AIR_FRONT = 91;
    public static final int U_CARSET_AIR_REAR = 90;
    public static final int U_CARSET_AIR_SENSOR_LEVEL = 88;
    public static final int U_CARSET_AUTOLOCK_OPENDOOR = 94;
    public static final int U_CARSET_AUTOLOCK_START = 95;
    public static final int U_CARSET_AUTOUNLOCK_STOP = 96;
    public static final int U_CARSET_BACK_REARWIPER = 101;
    public static final int U_CARSET_BEGIN = 86;
    public static final int U_CARSET_CONTRL_SIGN = 104;
    public static final int U_CARSET_FOUND_LIGHT = 92;
    public static final int U_CARSET_LOCK_DELAY = 97;
    public static final int U_CARSET_LOCK_DELAY_LIGHT = 93;
    public static final int U_CARSET_REMOTE_LOCK_AGAIN = 102;
    public static final int U_CARSET_REMOTE_LOCK_LIGHT = 99;
    public static final int U_CARSET_REMOTE_START = 103;
    public static final int U_CARSET_REMOTE_UNLOCK = 100;
    public static final int U_CARSET_REMOTE_UNLOCK_LIGHT = 98;
    public static final int U_CNT_MAX = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 105; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0439_HC_Rongwei950(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 105) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
