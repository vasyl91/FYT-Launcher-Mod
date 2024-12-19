package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_DJ_Guanzhi_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_DJ_Guanzhi_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_WIN_LEFT = 13;
    public static final int U_AIR_CYCLE = 8;
    public static final int U_AIR_DUAL = 17;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 9;
    public static final int U_AIR_MAX_FRONT = 16;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CARSET_D52_D01_B70 = 26;
    public static final int U_CARSET_D52_D02_B70 = 27;
    public static final int U_CARSET_D52_D03_B70 = 28;
    public static final int U_CARSET_D52_D04_B70 = 29;
    public static final int U_CARSET_D52_D05_B70 = 30;
    public static final int U_CARSET_D52_D06_B70 = 31;
    public static final int U_CARSET_D52_D07_B70 = 32;
    public static final int U_CARSET_D52_D08_B70 = 33;
    public static final int U_CARSET_D52_D09_B70 = 34;
    public static final int U_CARSET_D52_D0A_B70 = 35;
    public static final int U_CARSET_D52_D0B_B70 = 36;
    public static final int U_CNT_MAX = 37;
    public static final int U_PRESSURE_FL = 22;
    public static final int U_PRESSURE_FR = 23;
    public static final int U_PRESSURE_RL = 24;
    public static final int U_PRESSURE_RR = 25;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 37; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_DJ_Guanzhi_All(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 21; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 37) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
