package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Porsche_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Porsche_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_ACMAX = 22;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY = 15;
    public static final int U_AIR_BLOW_FOOT = 16;
    public static final int U_AIR_BLOW_UP = 14;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_DUAL = 11;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 20;
    public static final int U_AIR_MAX = 12;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 21;
    public static final int U_AIR_REAR_LOCK = 13;
    public static final int U_AIR_TEMPUNIT = 23;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_WIND_LEVEL = 17;
    public static final int U_CARSEt_D40_D00 = 32;
    public static final int U_CARSEt_D40_D01 = 33;
    public static final int U_CARSEt_D40_D02 = 34;
    public static final int U_CARSEt_D40_D03 = 35;
    public static final int U_CARSEt_D40_D04 = 36;
    public static final int U_CARSEt_D40_D05 = 37;
    public static final int U_CARSEt_D40_D06 = 38;
    public static final int U_CARSEt_D40_D07 = 39;
    public static final int U_CARSEt_D40_D08 = 40;
    public static final int U_CARSEt_D40_D09 = 41;
    public static final int U_CARSEt_D40_D0A = 42;
    public static final int U_CARSEt_D40_D0B = 43;
    public static final int U_CARSEt_D40_D0C = 44;
    public static final int U_CARSEt_D40_D0D = 45;
    public static final int U_CARSEt_D40_D0E = 46;
    public static final int U_CNT_MAX = 47;
    public static final int U_NEWADD_D68_D0 = 30;
    public static final int U_NEWADD_D68_D1 = 31;
    public static final int U_TIRE_PRESSURE_FL = 25;
    public static final int U_TIRE_PRESSURE_FR = 26;
    public static final int U_TIRE_PRESSURE_RL = 27;
    public static final int U_TIRE_PRESSURE_RR = 28;
    public static final int U_TIRE_UNIT = 29;

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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Porsche_All(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 24; i++) {
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
        if (updateCode >= 0 && updateCode < 47) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
