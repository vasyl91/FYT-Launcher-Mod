package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.FinalShare;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0306_WC2_RZC_LiFan820;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0306_RZCexc_Lifan820 extends CallbackCanbusBase {
    public static final int C_CAR_CAMERA_MODE = 3;
    public static final int C_SET_RADAR_ON_OFF = 1;
    public static final int C_SET_WARN_VOL = 0;
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 3;
    public static final int U_AIR_BLOW_AUTO_LEFT = 18;
    public static final int U_AIR_BLOW_BODY_LEFT = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_END = 19;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 17;
    public static final int U_AIR_REAR_DEFROST = 7;
    public static final int U_AIR_SEAT_HEAT_LEFT = 14;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 15;
    public static final int U_AIR_TEMP_LEFT = 9;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_WIND_LEVEL_LEFT = 13;
    public static final int U_CAR_CAMERA_MODE = 2;
    public static final int U_CNT_MAX = 25;
    public static final int U_DOOR_BACK = 24;
    public static final int U_DOOR_BEGIN = 19;
    public static final int U_DOOR_END = 25;
    public static final int U_DOOR_ENGINE = 19;
    public static final int U_DOOR_FL = 20;
    public static final int U_DOOR_FR = 21;
    public static final int U_DOOR_RL = 22;
    public static final int U_DOOR_RR = 23;
    public static final int U_SET_RADAR_ON_OFF = 1;
    public static final int U_SET_WARN_VOL = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 25; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (FinalShare.CUSTOMER_ID != 13) {
            DoorHelper.sUcDoorEngine = 19;
            DoorHelper.sUcDoorFl = 20;
            DoorHelper.sUcDoorFr = 21;
            DoorHelper.sUcDoorRl = 22;
            DoorHelper.sUcDoorRr = 23;
            DoorHelper.sUcDoorBack = 24;
            DoorHelper.getInstance().buildUi();
            for (int i2 = 19; i2 < 25; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
            }
        }
        AirHelper.getInstance().buildUi(new Air_0306_WC2_RZC_LiFan820(LauncherApplication.getInstance()));
        for (int i3 = 3; i3 < 19; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 3; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        if (FinalShare.CUSTOMER_ID != 13) {
            DoorHelper.getInstance().destroyUi();
            for (int i2 = 19; i2 < 25; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 25) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
