package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0192_WC2_15_BinZhi;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0192_WC2_15_BinZhi extends CallbackCanbusBase {
    public static final int U_AIR_AC = 30;
    public static final int U_AIR_AUTO = 26;
    public static final int U_AIR_BEGIN = 25;
    public static final int U_AIR_BLOW_BODY_LEFT = 32;
    public static final int U_AIR_BLOW_FOOT_LEFT = 33;
    public static final int U_AIR_BLOW_UP_LEFT = 34;
    public static final int U_AIR_CYCLE = 27;
    public static final int U_AIR_DUAL = 36;
    public static final int U_AIR_END = 40;
    public static final int U_AIR_FRONT_DEFROST = 28;
    public static final int U_AIR_POWER = 38;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_SYNC = 39;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_RIGHT = 37;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_CNT_MAX = 46;
    public static final int U_DOOR_BACK = 45;
    public static final int U_DOOR_BEGIN = 40;
    public static final int U_DOOR_END = 46;
    public static final int U_DOOR_ENGINE = 40;
    public static final int U_DOOR_FL = 41;
    public static final int U_DOOR_FR = 42;
    public static final int U_DOOR_RL = 43;
    public static final int U_DOOR_RR = 44;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 46; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 40;
        DoorHelper.sUcDoorFl = 41;
        DoorHelper.sUcDoorFr = 42;
        DoorHelper.sUcDoorRl = 43;
        DoorHelper.sUcDoorRr = 44;
        DoorHelper.sUcDoorBack = 45;
        AirHelper.getInstance().buildUi(new Air_0192_WC2_15_BinZhi(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 40; i2 < 46; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 25; i3 < 40; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 40; i < 46; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 25; i2 < 40; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 46) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
