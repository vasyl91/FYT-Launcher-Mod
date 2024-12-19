package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0058_XBS_XP1_haiMaM8;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0058_XBS_XP1_HaiMaM8 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 6;
    public static final int U_AIR_AMB = 8;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 1;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 3;
    public static final int U_AIR_END = 16;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_POWER = 15;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_TEMP_LEFT = 9;
    public static final int U_AIR_TEMP_RIGHT = 5;
    public static final int U_AIR_WIND_LEVEL = 7;
    public static final int U_CNT_MAX = 23;
    public static final int U_DOOR_BACK = 22;
    public static final int U_DOOR_BEGIN = 17;
    public static final int U_DOOR_END = 23;
    public static final int U_DOOR_ENGINE = 17;
    public static final int U_DOOR_FL = 18;
    public static final int U_DOOR_FR = 19;
    public static final int U_DOOR_RL = 20;
    public static final int U_DOOR_RR = 21;
    public static final int U_LIGHTCOMINGHOME = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 23; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 17;
        DoorHelper.sUcDoorFl = 18;
        DoorHelper.sUcDoorFr = 19;
        DoorHelper.sUcDoorRl = 20;
        DoorHelper.sUcDoorRr = 21;
        DoorHelper.sUcDoorBack = 22;
        AirHelper.getInstance().buildUi(new Air_0058_XBS_XP1_haiMaM8(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 17; i2 < 23; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 1; i3 < 16; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 17; i < 23; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 1; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 23) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
