package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0132_WC2_HavaH2;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0132_WC2_HavalH2 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 11;
    public static final int U_AIR_END = 14;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 13;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 12;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CARINFO_BATTERY_VOLGATE = 51;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_COOLANT_TEMP = 52;
    public static final int U_CARINFO_END = 54;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 53;
    public static final int U_CNT_MAX = 54;
    public static final int U_DOOR_BACK = 19;
    public static final int U_DOOR_BEGIN = 14;
    public static final int U_DOOR_END = 20;
    public static final int U_DOOR_ENGINE = 14;
    public static final int U_DOOR_FL = 15;
    public static final int U_DOOR_FR = 16;
    public static final int U_DOOR_RL = 17;
    public static final int U_DOOR_RR = 18;
    int carId;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 54; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 14;
        DoorHelper.sUcDoorFl = 15;
        DoorHelper.sUcDoorFr = 16;
        DoorHelper.sUcDoorRl = 17;
        DoorHelper.sUcDoorRr = 18;
        DoorHelper.sUcDoorBack = 19;
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0132_WC2_HavaH2(LauncherApplication.getInstance()));
        for (int i2 = 14; i2 < 20; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 14; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 14; i < 20; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 14; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 54) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
