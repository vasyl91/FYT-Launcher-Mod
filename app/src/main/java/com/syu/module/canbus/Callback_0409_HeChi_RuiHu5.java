package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0409_HeChi_RuiHu5;
import com.syu.ui.air.Air_0409_XP_RuiHu5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0409_HeChi_RuiHu5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 13;
    public static final int U_AIR_AUTO = 15;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY = 22;
    public static final int U_AIR_BLOW_FOOT = 21;
    public static final int U_AIR_BLOW_UP = 23;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 14;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FROST_DEFROST = 16;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEFT = 18;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_DRIVING_LIGHT = 52;
    public static final int U_CARINFO_HEAD_LIGHT = 51;
    public static final int U_CARINFO_LAMPLET = 50;
    public static final int U_CARINFO_LAMPLET_VALUE = 53;
    public static final int U_CNT_MAX = 54;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 54) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 54; i++) {
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
        if (DataCanbus.DATA[1000] == 65945) {
            AirHelper.getInstance().buildUi(new Air_0409_XP_RuiHu5(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0409_HeChi_RuiHu5(LauncherApplication.getInstance()));
        }
        for (int i3 = 10; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }
}
