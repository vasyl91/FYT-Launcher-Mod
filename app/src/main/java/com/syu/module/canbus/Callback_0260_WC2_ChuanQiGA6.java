package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0260_WC2_ChuangQiGa6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0260_WC2_ChuanQiGA6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 30;
    public static final int U_AIR_AUTO = 26;
    public static final int U_AIR_BEGIN = 25;
    public static final int U_AIR_BLOW_AUTO_LEFT = 40;
    public static final int U_AIR_BLOW_BODY_LEFT = 32;
    public static final int U_AIR_BLOW_FOOT_LEFT = 33;
    public static final int U_AIR_BLOW_UP_LEFT = 34;
    public static final int U_AIR_CYCLE = 27;
    public static final int U_AIR_DUAL = 41;
    public static final int U_AIR_END = 44;
    public static final int U_AIR_FRONT_DEFROST = 28;
    public static final int U_AIR_ION = 43;
    public static final int U_AIR_MAX = 42;
    public static final int U_AIR_POWER = 39;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_SEAT_HEAT_LEFT = 36;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 37;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_RIGHT = 38;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_CNT_MAX = 52;
    public static final int U_DOOR_BACK = 49;
    public static final int U_DOOR_BEGIN = 44;
    public static final int U_DOOR_END = 50;
    public static final int U_DOOR_ENGINE = 44;
    public static final int U_DOOR_FL = 45;
    public static final int U_DOOR_FR = 46;
    public static final int U_DOOR_RL = 47;
    public static final int U_DOOR_RR = 48;
    public static final int U_ENGINESPEED = 50;
    public static final int U_ENGINE_BEGIN = 50;
    public static final int U_ENGINE_END = 52;
    public static final int U_INSTANTANEOUSSPEED = 51;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 52; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 44;
        DoorHelper.sUcDoorFl = 45;
        DoorHelper.sUcDoorFr = 46;
        DoorHelper.sUcDoorRl = 47;
        DoorHelper.sUcDoorRr = 48;
        DoorHelper.sUcDoorBack = 49;
        AirHelper.getInstance().buildUi(new Air_0260_WC2_ChuangQiGa6(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 44; i2 < 50; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 25; i3 < 44; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 44; i < 50; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 25; i2 < 44; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 52) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
