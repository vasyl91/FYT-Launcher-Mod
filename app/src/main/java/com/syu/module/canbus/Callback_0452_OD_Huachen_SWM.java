package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Huachen_SWM;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Huachen_SWM extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 12;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CARSET_D04_D0_B4 = 24;
    public static final int U_CARSET_D04_D0_B5 = 23;
    public static final int U_CARSET_D04_D0_B6 = 22;
    public static final int U_CARSET_D04_D2_B70 = 25;
    public static final int U_CARSET_D04_D3_D4 = 26;
    public static final int U_CARSET_D04_D5_D6_D7 = 27;
    public static final int U_CARSET_D04_D8_B70 = 28;
    public static final int U_CARSET_D04_D9_B30 = 31;
    public static final int U_CARSET_D04_D9_B6 = 30;
    public static final int U_CARSET_D04_D9_B7 = 29;
    public static final int U_CNT_MAX = 32;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 32; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Huachen_SWM(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 32) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
