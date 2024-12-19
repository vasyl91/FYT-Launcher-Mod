package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Captiva;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_CAOTIVA_GM extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AC_AUTO = 23;
    public static final int U_AIR_AQS = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 18;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_DUAL = 13;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_SEAT_HOT_LEFT = 21;
    public static final int U_AIR_SEAT_HOT_RIGHT = 22;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_AUTO = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_CARINFO_D33_D1_D2 = 26;
    public static final int U_CARINFO_D33_D3_D4 = 27;
    public static final int U_CARINFO_D33_D5_B54 = 28;
    public static final int U_CARINFO_D33_D5_B7 = 29;
    public static final int U_CARINFO_D33_D6_B70 = 30;
    public static final int U_CNT_MAX = 43;
    public static final int U_TIRE_ALARM_FL = 39;
    public static final int U_TIRE_ALARM_FR = 40;
    public static final int U_TIRE_ALARM_RL = 41;
    public static final int U_TIRE_ALARM_RR = 42;
    public static final int U_TIRE_PRESSURE_FL = 31;
    public static final int U_TIRE_PRESSURE_FR = 32;
    public static final int U_TIRE_PRESSURE_RL = 33;
    public static final int U_TIRE_PRESSURE_RR = 34;
    public static final int U_TIRE_TEMP_FL = 35;
    public static final int U_TIRE_TEMP_FR = 36;
    public static final int U_TIRE_TEMP_RL = 37;
    public static final int U_TIRE_TEMP_RR = 38;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 43; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Captiva(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 25; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 43) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
