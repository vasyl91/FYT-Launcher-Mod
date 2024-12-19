package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Nissan_Xiaoke;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_Nissan_Xiaoke extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 24;
    public static final int U_AIR_AUTO = 12;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 13;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_FRONT_DEFROST = 23;
    public static final int U_AIR_FRONT_MAX = 14;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_TEMP_UNIT = 22;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CAR_TIRE_BEGIN = 25;
    public static final int U_CAR_TIRE_END = 32;
    public static final int U_CAR_TIRE_SYS_VALUE = 31;
    public static final int U_CAR_TIRE_VALUE_FL = 26;
    public static final int U_CAR_TIRE_VALUE_FR = 27;
    public static final int U_CAR_TIRE_VALUE_RL = 28;
    public static final int U_CAR_TIRE_VALUE_RR = 29;
    public static final int U_CAR_TIRE_WARN_VALUE = 30;
    public static final int U_CNT_MAX = 32;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 32; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_HC_Nissan_Xiaoke(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 25; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 32) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
