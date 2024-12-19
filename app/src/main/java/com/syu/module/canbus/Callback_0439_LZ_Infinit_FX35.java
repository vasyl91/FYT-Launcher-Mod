package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Luz_Infinit_Fx35;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LZ_Infinit_FX35 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_MODE = 21;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 18;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_TEMP_UNIT = 20;
    public static final int U_AIR_WIND_LEVEL = 19;
    public static final int U_CARINFO_BEGIN = 23;
    public static final int U_CARINFO_CUR_SPEED = 25;
    public static final int U_CARINFO_ENGINE_SPEED = 27;
    public static final int U_CARINFO_MILE_DRIVENABLE = 26;
    public static final int U_CARINFO_MILE_UNIT = 29;
    public static final int U_CARINFO_TEMP_UNIT = 28;
    public static final int U_CARINFO_WATER_TEMP = 24;
    public static final int U_CARSET_BEIGIN = 35;
    public static final int U_CARSET_DATA38_VALUE0 = 36;
    public static final int U_CARSET_DATA38_VALUE1 = 37;
    public static final int U_CARSET_DATA38_VALUE10 = 46;
    public static final int U_CARSET_DATA38_VALUE2 = 38;
    public static final int U_CARSET_DATA38_VALUE3 = 39;
    public static final int U_CARSET_DATA38_VALUE4 = 40;
    public static final int U_CARSET_DATA38_VALUE5 = 41;
    public static final int U_CARSET_DATA38_VALUE6 = 42;
    public static final int U_CARSET_DATA38_VALUE7 = 43;
    public static final int U_CARSET_DATA38_VALUE8 = 44;
    public static final int U_CARSET_DATA38_VALUE9 = 45;
    public static final int U_CAR_TIRE_BEGIN = 30;
    public static final int U_CAR_TIRE_VALUE1 = 31;
    public static final int U_CAR_TIRE_VALUE2 = 32;
    public static final int U_CAR_TIRE_VALUE3 = 33;
    public static final int U_CAR_TIRE_VALUE4 = 34;
    public static final int U_CNT_MAX = 47;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 47; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_Luz_Infinit_Fx35(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 47) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
