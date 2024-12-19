package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0013_WC2_XinJunWei2013;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0013_WC2_XinJunWei2013 extends CallbackCanbusBase {
    public static final int U_AIR_AC_MAX = 3;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 5;
    public static final int U_AIR_SEAT_BLOW_LEFT = 9;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 10;
    public static final int U_AIR_SEAT_HEAT_LEFT = 7;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 8;
    public static final int U_AIR_SYNC = 2;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL = 12;
    public static final int U_AIR_WIND_MODE = 11;
    public static final int U_CNT_MAX = 21;
    public static final int U_DOOR_BACK = 20;
    public static final int U_DOOR_BEGIN = 15;
    public static final int U_DOOR_END = 21;
    public static final int U_DOOR_ENGINE = 15;
    public static final int U_DOOR_FL = 16;
    public static final int U_DOOR_FR = 17;
    public static final int U_DOOR_RL = 18;
    public static final int U_DOOR_RR = 19;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 21; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 15;
        DoorHelper.sUcDoorFl = 16;
        DoorHelper.sUcDoorFr = 17;
        DoorHelper.sUcDoorRl = 18;
        DoorHelper.sUcDoorRr = 19;
        DoorHelper.sUcDoorBack = 20;
        AirHelper.getInstance().buildUi(new Air_0013_WC2_XinJunWei2013(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 15; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 15; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 15; i < 21; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 21) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
