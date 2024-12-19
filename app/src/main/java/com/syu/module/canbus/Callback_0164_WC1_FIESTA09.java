package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0164_WC_Fiesta;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0164_WC1_FIESTA09 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 20;
    public static final int U_AIR_AUTO = 19;
    public static final int U_AIR_BEGIN = 15;
    public static final int U_AIR_BLOW_BODY_LEFT = 22;
    public static final int U_AIR_BLOW_FOOT_LEFT = 23;
    public static final int U_AIR_BLOW_UP_LEFT = 21;
    public static final int U_AIR_CYCLE = 18;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_POWER = 16;
    public static final int U_AIR_TEMP_LEFT = 25;
    public static final int U_AIR_WIND_LEVEL_LEFT = 24;
    public static final int U_BATTERY_VOLTAGE = 6;
    public static final int U_CNT_MAX = 26;
    public static final int U_DOOR_BACK = 13;
    public static final int U_DOOR_BEGIN = 8;
    public static final int U_DOOR_END = 14;
    public static final int U_DOOR_ENGINE = 8;
    public static final int U_DOOR_FL = 9;
    public static final int U_DOOR_FR = 10;
    public static final int U_DOOR_RL = 11;
    public static final int U_DOOR_RR = 12;
    public static final int U_LAST_OIL = 5;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_SETTING_END = 7;
    public static final int U_WARNNING_CLEANNING_FLUID = 3;
    public static final int U_WARNNING_HANDLE_BRAKE = 4;
    public static final int U_WARNNING_LIFE_BELT = 2;
    public static final int U_WARNNING_LOW_BATTERY = 1;
    public static final int U_WARNNING_LOW_OIL = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 26; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 8;
        DoorHelper.sUcDoorFl = 9;
        DoorHelper.sUcDoorFr = 10;
        DoorHelper.sUcDoorRl = 11;
        DoorHelper.sUcDoorRr = 12;
        DoorHelper.sUcDoorBack = 13;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 8; i2 < 14; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 15; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0164_WC_Fiesta(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 8; i < 14; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 15; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 26) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
