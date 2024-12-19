package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_BenzAll;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OD_BenzAll extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_AUTO = 13;
    public static final int U_AIR_BEGIN = 9;
    public static final int U_AIR_BLOW_BODY_LEFT = 19;
    public static final int U_AIR_BLOW_FOOT_LEFT = 20;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_MAX = 17;
    public static final int U_AIR_POWER = 10;
    public static final int U_AIR_REAR = 16;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_REST = 25;
    public static final int U_AIR_SHOW = 21;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 22;
    public static final int U_CNT_MAX = 26;
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 26; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_OD_BenzAll(LauncherApplication.getInstance()));
        for (int i3 = 9; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 9; i < 26; i++) {
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
        if (updateCode >= 0 && updateCode < 26) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
