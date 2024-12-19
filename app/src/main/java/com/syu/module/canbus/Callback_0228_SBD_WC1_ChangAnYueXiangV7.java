package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0228_SBD_ChangAnYueXiangV7;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0228_SBD_WC1_ChangAnYueXiangV7 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 2;
    public static final int U_AIR_BLOW_BODY_RIGHT = 5;
    public static final int U_AIR_BLOW_FOOT_LEFT = 3;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 6;
    public static final int U_AIR_BLOW_UP_LEFT = 4;
    public static final int U_AIR_BLOW_UP_RIGHT = 7;
    public static final int U_AIR_END = 11;
    public static final int U_AIR_POWER = 10;
    public static final int U_AIR_WIND_LEVEL_LEFT = 8;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 9;
    public static final int U_CNT_MAX = 17;
    public static final int U_DOOR_BACK = 16;
    public static final int U_DOOR_BEGIN = 11;
    public static final int U_DOOR_END = 17;
    public static final int U_DOOR_ENGINE = 11;
    public static final int U_DOOR_FL = 12;
    public static final int U_DOOR_FR = 13;
    public static final int U_DOOR_RL = 14;
    public static final int U_DOOR_RR = 15;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 17; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 11;
        DoorHelper.sUcDoorFl = 12;
        DoorHelper.sUcDoorFr = 13;
        DoorHelper.sUcDoorRl = 14;
        DoorHelper.sUcDoorRr = 15;
        DoorHelper.sUcDoorBack = 16;
        AirHelper.getInstance().buildUi(new Air_0228_SBD_ChangAnYueXiangV7(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 11; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 11; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 11; i < 17; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 11; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 17) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
