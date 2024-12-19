package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0383_JYKJ_XP1_ZhongTaiDaMaiX5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0383_JYKJ_XP_ZhongTaiDaMaiX5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 6;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_END = 13;
    public static final int U_AIR_FRONT_DEFROST = 2;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 3;
    public static final int U_AIR_SHOW = 12;
    public static final int U_AIR_TEMP_LEFT = 5;
    public static final int U_AIR_TEMP_RIGHT = 10;
    public static final int U_AIR_WIND_LEVEL_LEFT = 9;
    public static final int U_CNT_MAX = 19;
    public static final int U_DOOR_BACK = 18;
    public static final int U_DOOR_BEGIN = 13;
    public static final int U_DOOR_END = 19;
    public static final int U_DOOR_ENGINE = 13;
    public static final int U_DOOR_FL = 14;
    public static final int U_DOOR_FR = 15;
    public static final int U_DOOR_RL = 16;
    public static final int U_DOOR_RR = 17;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 19; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 13;
        DoorHelper.sUcDoorFl = 14;
        DoorHelper.sUcDoorFr = 15;
        DoorHelper.sUcDoorRl = 16;
        DoorHelper.sUcDoorRr = 17;
        DoorHelper.sUcDoorBack = 18;
        AirHelper.getInstance().buildUi(new Air_0383_JYKJ_XP1_ZhongTaiDaMaiX5(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 13; i2 < 19; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 13; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 13; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 13; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 19) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
