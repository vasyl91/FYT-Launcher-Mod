package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.carvol.CarVolHelper;
import com.syu.ui.carvol.CarVolView;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0414_XFY_XP1_TianLai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 13;
    public static final int U_AIR_AUTO = 15;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_FOOT = 21;
    public static final int U_AIR_BLOW_MODE = 24;
    public static final int U_AIR_BLOW_UP = 22;
    public static final int U_AIR_BLOW_WIN = 23;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 14;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_FROST_DEFROST = 16;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEFT = 18;
    public static final int U_CNT_MAX = 35;
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
    public static final int U_INFO_CAR_BOSE_POINT = 34;
    public static final int U_INFO_CAR_DRIVER_FIELD = 32;
    public static final int U_INFO_CAR_FIELD_F_B = 29;
    public static final int U_INFO_CAR_FIELD_L_R = 30;
    public static final int U_INFO_CAR_ROUND_VOL = 33;
    public static final int U_INFO_CAR_SOUND_H = 27;
    public static final int U_INFO_CAR_SOUND_L = 28;
    public static final int U_INFO_CAR_SPEED_LINK = 31;
    public static final int U_INFO_CAR_VOL = 26;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 35) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 35; i++) {
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
        CarVolHelper.mCarVol_ID = 26;
        CarVolHelper.getInstance().buildUi(new CarVolView(LauncherApplication.getInstance()));
        DataCanbus.NOTIFY_EVENTS[26].addNotify(CarVolHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        CarVolHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[26].removeNotify(CarVolHelper.SHOW_AND_REFRESH);
    }
}
