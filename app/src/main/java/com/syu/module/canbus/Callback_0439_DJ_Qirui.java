package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_DJ_Qirui;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_DJ_Qirui extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_WIN_LEFT = 16;
    public static final int U_AIR_CYCLE = 15;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_LEV = 20;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CARINFO_BEGIN = 22;
    public static final int U_CARINFO_D40_D0 = 23;
    public static final int U_CARINFO_D40_D1 = 24;
    public static final int U_CARINFO_D40_D2 = 25;
    public static final int U_CARINFO_D40_D3 = 26;
    public static final int U_CARINFO_D40_D4 = 27;
    public static final int U_CARINFO_D40_D5 = 28;
    public static final int U_CARINFO_D40_D6 = 29;
    public static final int U_CARINFO_D40_D7 = 30;
    public static final int U_CNT_MAX = 31;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_POWER_ON = 9;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 31; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_DJ_Qirui(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 31) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
