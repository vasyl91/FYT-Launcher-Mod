package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0425_LZ_Spirior;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0425_LuZhen_Spirior extends CallbackCanbusBase {
    public static final int U_AIR_AC = 22;
    public static final int U_AIR_AUTO = 23;
    public static final int U_AIR_BEGIN = 20;
    public static final int U_AIR_BLOW_BODY_LEFT = 29;
    public static final int U_AIR_BLOW_FOOT_LEFT = 30;
    public static final int U_AIR_BLOW_UP_LEFT = 31;
    public static final int U_AIR_CYCLE = 26;
    public static final int U_AIR_END = 34;
    public static final int U_AIR_FRONT_DEFROST = 24;
    public static final int U_AIR_POWER = 21;
    public static final int U_AIR_REAR_DEFROST = 25;
    public static final int U_AIR_TEMP_LEFT = 28;
    public static final int U_AIR_TEMP_RIGHT = 27;
    public static final int U_AIR_TEMP_UNIT = 33;
    public static final int U_AIR_WIND_LEVEL_LEFT = 32;
    public static final int U_BRAKE_LIGHT = 14;
    public static final int U_CNT_MAX = 34;
    public static final int U_CUR_SPEED = 7;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_FRONT_FOG_LIGHTS = 12;
    public static final int U_HIGH_BEAM = 10;
    public static final int U_LOW_BEAM_LIGHTS = 11;
    public static final int U_REAR_FOG_LAMPS = 13;
    public static final int U_TOTAL_MILEAGE = 9;
    public static final int U_TURN_LEFT_LIGHT = 15;
    public static final int U_TURN_RIGHT_LIGHT = 16;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 34; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0425_LZ_Spirior(LauncherApplication.getInstance()));
        for (int i3 = 20; i3 < 34; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 20; i2 < 34; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 34) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
