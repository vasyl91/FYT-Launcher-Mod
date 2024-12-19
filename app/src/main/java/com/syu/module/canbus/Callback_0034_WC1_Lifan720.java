package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0034_WC1_LiFan720;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0034_WC1_Lifan720 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 3;
    public static final int U_AIR_BLOW_FOOT = 4;
    public static final int U_AIR_BLOW_UP = 2;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_END = 9;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_WIND_LEVEL = 6;
    public static final int U_CNT_MAX = 15;
    public static final int U_DOOR_BACK = 14;
    public static final int U_DOOR_BEGIN = 9;
    public static final int U_DOOR_END = 15;
    public static final int U_DOOR_ENGINE = 9;
    public static final int U_DOOR_FL = 10;
    public static final int U_DOOR_FR = 11;
    public static final int U_DOOR_RL = 12;
    public static final int U_DOOR_RR = 13;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 15; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 9;
        DoorHelper.sUcDoorFl = 10;
        DoorHelper.sUcDoorFr = 11;
        DoorHelper.sUcDoorRl = 12;
        DoorHelper.sUcDoorRr = 13;
        DoorHelper.sUcDoorBack = 14;
        AirHelper.getInstance().buildUi(new Air_0034_WC1_LiFan720(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 9; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 9; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 9; i < 15; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 9; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 15) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
