package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_Guanzhi2019;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_BNR_GuanZhi extends CallbackCanbusBase {
    public static final int U_AIR_AC = 34;
    public static final int U_AIR_AUTO = 36;
    public static final int U_AIR_BEGIN = 33;
    public static final int U_AIR_BLOW_BODY_LEFT = 40;
    public static final int U_AIR_BLOW_FOOT_LEFT = 41;
    public static final int U_AIR_BLOW_UP_LEFT = 39;
    public static final int U_AIR_CYCLE = 35;
    public static final int U_AIR_DUAL = 37;
    public static final int U_AIR_END = 47;
    public static final int U_AIR_REAR_DEFROST = 38;
    public static final int U_AIR_SEAT_HOT_LEFT = 45;
    public static final int U_AIR_SEAT_HOT_RIGHT = 46;
    public static final int U_AIR_TEMP_LEFT = 43;
    public static final int U_AIR_TEMP_RIGHT = 44;
    public static final int U_AIR_WIND_LEVEL_LEFT = 42;
    public static final int U_CAR_INFO_AUTOVIEW_CLOSE = 10;
    public static final int U_CAR_INFO_BEGIN = 9;
    public static final int U_CAR_INFO_D41_D1_B70 = 29;
    public static final int U_CAR_INFO_D41_D2_D3 = 30;
    public static final int U_CAR_INFO_D41_D4_D5 = 31;
    public static final int U_CAR_INFO_D41_D6_D7_D8 = 32;
    public static final int U_CAR_INFO_HOME_LIGHT = 12;
    public static final int U_CAR_INFO_METER_LIGHT = 13;
    public static final int U_CAR_INFO_OILUNIT = 17;
    public static final int U_CAR_INFO_TEMPUNIT = 16;
    public static final int U_CAR_INFO_TIMEFORMAT = 15;
    public static final int U_CAR_INFO_TIRERESET = 18;
    public static final int U_CAR_INFO_TRUNK_CTRL = 19;
    public static final int U_CAR_INFO_TRUNK_START = 20;
    public static final int U_CAR_INFO_UNIT = 14;
    public static final int U_CAR_INFO_WELCOME_LIGHT = 11;
    public static final int U_CNT_MAX = 48;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_PRESSURE_FL = 21;
    public static final int U_PRESSURE_FL_WARN = 25;
    public static final int U_PRESSURE_FR = 22;
    public static final int U_PRESSURE_FR_WARN = 26;
    public static final int U_PRESSURE_RL = 23;
    public static final int U_PRESSURE_RL_WARN = 27;
    public static final int U_PRESSURE_RR = 24;
    public static final int U_PRESSURE_RR_WARN = 28;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 48; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_OD_Guanzhi2019(LauncherApplication.getInstance()));
        for (int i3 = 33; i3 < 47; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 33; i2 < 47; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 48) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
