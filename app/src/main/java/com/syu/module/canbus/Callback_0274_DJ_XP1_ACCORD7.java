package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0274_DJ_XP1_ACCORD7;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0274_DJ_XP1_ACCORD7 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 19;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE = 20;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 25;
    public static final int U_AIR_END = 28;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 24;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 22;
    public static final int U_AIR_TEMP_RIGHT = 23;
    public static final int U_AIR_WIND_AUTO_LEFT = 26;
    public static final int U_AIR_WIND_LEVEL_LEFT = 21;
    public static final int U_CARINFO_AIR_MIX_CONTROL_MOTOR_LEFT = 54;
    public static final int U_CARINFO_AIR_MIX_CONTROL_MOTOR_RIGHT = 55;
    public static final int U_CARINFO_AIR_MIX_OPEN_DEGREE_LEFT = 58;
    public static final int U_CARINFO_AIR_MIX_OPEN_DEGREE_RIGHT = 59;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_BLOWER_MOTOR = 57;
    public static final int U_CARINFO_END = 64;
    public static final int U_CARINFO_ENGINER_COOLANT = 63;
    public static final int U_CARINFO_EVAPORATOR_TEMP = 61;
    public static final int U_CARINFO_EVAPORATOR_TEMP_SENSOR = 53;
    public static final int U_CARINFO_INTER_TEMP = 62;
    public static final int U_CARINFO_INTER_TEMP_SENSOR = 50;
    public static final int U_CARINFO_MODE_CONTROL_MOTOR = 56;
    public static final int U_CARINFO_OUTER_TEMP_SENSOR = 51;
    public static final int U_CARINFO_SUNLIGHT_LEVEL = 60;
    public static final int U_CARINFO_SUNLIGHT_LEVEL_SENSOR = 52;
    public static final int U_CNT_MAX = 64;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 64; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0274_DJ_XP1_ACCORD7(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 28; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 28; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 64) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
