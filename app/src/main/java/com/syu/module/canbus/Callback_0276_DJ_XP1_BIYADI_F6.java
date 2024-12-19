package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0276_DJ_BYD_F6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0276_DJ_XP1_BIYADI_F6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AUTO = 24;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 28;
    public static final int U_AIR_BLOW_MODE = 16;
    public static final int U_AIR_BLOW_MODE_RIGHT = 29;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_BLOW_UP_RIGHT = 27;
    public static final int U_AIR_BLOW_WIN_LEFT = 13;
    public static final int U_AIR_CYCLE = 18;
    public static final int U_AIR_END = 30;
    public static final int U_AIR_HEAT_LEFT = 22;
    public static final int U_AIR_HEAT_RIGHT = 23;
    public static final int U_AIR_MAXAC = 26;
    public static final int U_AIR_MAXFRONT_DEFROST = 19;
    public static final int U_AIR_REAR_DEFROST = 20;
    public static final int U_AIR_SYNC = 25;
    public static final int U_AIR_TEMP_LEFT = 11;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND = 12;
    public static final int U_CARINDO_END = 57;
    public static final int U_CARINFO_BEGIN = 31;
    public static final int U_CNT_MAX = 57;
    public static final int U_CUR_SPEED = 7;
    public static final int U_D0B00 = 51;
    public static final int U_D0B02 = 50;
    public static final int U_D0B04 = 33;
    public static final int U_D1B00 = 35;
    public static final int U_D1B02 = 34;
    public static final int U_D2B00 = 40;
    public static final int U_D2B02 = 39;
    public static final int U_D2B04 = 38;
    public static final int U_D2B06 = 37;
    public static final int U_D2B07 = 36;
    public static final int U_D3B04 = 44;
    public static final int U_D3B05 = 43;
    public static final int U_D3B06 = 42;
    public static final int U_D3B07 = 41;
    public static final int U_D4B06 = 46;
    public static final int U_D4B07 = 45;
    public static final int U_D5B02 = 56;
    public static final int U_D5B03 = 55;
    public static final int U_D5B04 = 54;
    public static final int U_D5B05 = 53;
    public static final int U_D5B06 = 52;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_DTS_SURROUND = 49;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_LOUD = 47;
    public static final int U_SPEED_VOL = 48;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 57; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0276_DJ_BYD_F6(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 30; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 30; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 57) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
