package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0104_WC1_BenTengB70_Old;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0104_WC1_BenTengB70_Old extends CallbackCanbusBase {
    public static final int U_AIR_AC = 6;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 1;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_BODY_RIGHT = 11;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 12;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_BLOW_UP_RIGHT = 13;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 19;
    public static final int U_AIR_END = 23;
    public static final int U_AIR_FRONT_DEFROST = 4;
    public static final int U_AIR_MAX = 14;
    public static final int U_AIR_POWER = 21;
    public static final int U_AIR_REAR_DEFROST = 5;
    public static final int U_AIR_SEAT_HEAT_LEFT = 17;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 18;
    public static final int U_AIR_SHOW = 22;
    public static final int U_AIR_TEMP_LEFT = 7;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 15;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 16;
    public static final int U_CNT_MAX = 29;
    public static final int U_CURRENT_SPEED = 0;
    public static final int U_DOOR_BACK = 28;
    public static final int U_DOOR_BEGIN = 23;
    public static final int U_DOOR_END = 29;
    public static final int U_DOOR_ENGINE = 23;
    public static final int U_DOOR_FL = 24;
    public static final int U_DOOR_FR = 25;
    public static final int U_DOOR_RL = 26;
    public static final int U_DOOR_RR = 27;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 29; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 23;
        DoorHelper.sUcDoorFl = 24;
        DoorHelper.sUcDoorFr = 25;
        DoorHelper.sUcDoorRl = 26;
        DoorHelper.sUcDoorRr = 27;
        DoorHelper.sUcDoorBack = 28;
        AirHelper.getInstance().buildUi(new Air_0104_WC1_BenTengB70_Old(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 23; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 1; i3 < 23; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 23; i < 29; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 1; i2 < 23; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 29) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
