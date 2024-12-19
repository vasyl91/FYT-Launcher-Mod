package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_ChangAn_CS95;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OD_ChangAn_CS95 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_MODE_LEFT = 11;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_DUAL = 1;
    public static final int U_AIR_END = 14;
    public static final int U_AIR_FRONT_DEFROST = 5;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_TEMP_LEFT = 12;
    public static final int U_AIR_TEMP_RIGHT = 13;
    public static final int U_AIR_WIND_LEVEL_LEFT = 7;
    public static final int U_AUTO_LOCK_DRIVING = 25;
    public static final int U_AUTO_UNLOCK_LIGHTOFF = 26;
    public static final int U_CNT_MAX = 33;
    public static final int U_DOOR_BACK = 19;
    public static final int U_DOOR_BEGIN = 14;
    public static final int U_DOOR_END = 20;
    public static final int U_DOOR_ENGINE = 14;
    public static final int U_DOOR_FL = 15;
    public static final int U_DOOR_FR = 16;
    public static final int U_DOOR_RL = 17;
    public static final int U_DOOR_RR = 18;
    public static final int U_DRIVING_MILEAGE = 22;
    public static final int U_FRONT_LIGHT_DELAY = 27;
    public static final int U_ONKEY_TURN_OFF = 28;
    public static final int U_REMOTE_UNLOCK_MODE = 24;
    public static final int U_REVERSE_AUTO_WIPER = 29;
    public static final int U_SET_FOLD_REARMIRROR = 21;
    public static final int U_SMART_AIR_PURIFY = 32;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 23;
    public static final int U_UNLOCK_AUTO_VENTILATION = 30;
    public static final int U_UNLOCK_AUTO_WINDOW = 31;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 33; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 14;
        DoorHelper.sUcDoorFl = 15;
        DoorHelper.sUcDoorFr = 16;
        DoorHelper.sUcDoorRl = 17;
        DoorHelper.sUcDoorRr = 18;
        DoorHelper.sUcDoorBack = 19;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 14; i2 < 20; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_OD_ChangAn_CS95(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 14; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 14; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 14; i2 < 20; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 33) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
