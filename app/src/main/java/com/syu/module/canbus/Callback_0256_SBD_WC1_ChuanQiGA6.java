package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0256_SBD_WC1_ChuangQiGa6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0256_SBD_WC1_ChuanQiGA6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 6;
    public static final int U_AIR_BLOW_BODY_RIGHT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 10;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_BLOW_UP_RIGHT = 11;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_END = 16;
    public static final int U_AIR_FRONT_DEFROST = 2;
    public static final int U_AIR_POWER = 15;
    public static final int U_AIR_REAR_DEFROST = 3;
    public static final int U_AIR_TEMP_LEFT = 5;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 13;
    public static final int U_CNT_MAX = 22;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 22; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 16;
        DoorHelper.sUcDoorFl = 17;
        DoorHelper.sUcDoorFr = 18;
        DoorHelper.sUcDoorRl = 19;
        DoorHelper.sUcDoorRr = 20;
        DoorHelper.sUcDoorBack = 21;
        AirHelper.getInstance().buildUi(new Air_0256_SBD_WC1_ChuangQiGa6(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 16; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 16; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 16; i < 22; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 22) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
