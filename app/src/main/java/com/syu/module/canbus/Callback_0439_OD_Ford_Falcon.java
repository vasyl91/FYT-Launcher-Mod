package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_Ford_Falcon;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OD_Ford_Falcon extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 21;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_MODE = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL = 18;
    public static final int U_CARINFO_AVG_FUEL = 40;
    public static final int U_CARINFO_AVG_SPEED = 42;
    public static final int U_CARINFO_INST_FUEL = 41;
    public static final int U_CARINFO_RANGE = 43;
    public static final int U_CARINFO_TRIPTIME_HOUR = 38;
    public static final int U_CARINFO_TRIPTIME_MUNITE = 39;
    public static final int U_CARSET_BEGIN = 23;
    public static final int U_CARSET_LIGHT2_B30 = 37;
    public static final int U_CARSET_LIGHT2_B74 = 36;
    public static final int U_CARSET_LIGHT_B20 = 35;
    public static final int U_CARSET_LIGHT_B3 = 34;
    public static final int U_CARSET_LIGHT_B4 = 33;
    public static final int U_CARSET_LIGHT_B5 = 32;
    public static final int U_CARSET_LIGHT_B6 = 31;
    public static final int U_CARSET_LIGHT_B7 = 30;
    public static final int U_CARSET_LOCK_UNLOCK_B2 = 29;
    public static final int U_CARSET_LOCK_UNLOCK_B3 = 28;
    public static final int U_CARSET_LOCK_UNLOCK_B4 = 27;
    public static final int U_CARSET_LOCK_UNLOCK_B5 = 26;
    public static final int U_CARSET_LOCK_UNLOCK_B6 = 25;
    public static final int U_CARSET_LOCK_UNLOCK_B7 = 24;
    public static final int U_CNT_MAX = 44;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 44; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0439_OD_Ford_Falcon(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 7; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 44) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
