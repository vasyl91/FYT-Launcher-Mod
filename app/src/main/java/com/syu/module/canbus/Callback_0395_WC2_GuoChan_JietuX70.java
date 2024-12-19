package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0395_WC2_JietuX70;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0395_WC2_GuoChan_JietuX70 extends CallbackCanbusBase {
    public static final int U_CARINFO_AUTO_FOLD_REARVIEW = 99;
    public static final int U_CARINFO_AUTO_LOCK = 89;
    public static final int U_CARINFO_AUTO_UNLOCK = 98;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 90;
    public static final int U_CARINFO_BLIND_SIDE = 101;
    public static final int U_CARINFO_CHANGE_ROAD_LIGHTONOFF = 105;
    public static final int U_CARINFO_D87_D6_B1 = 110;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 96;
    public static final int U_CARINFO_DAYLIGHT = 91;
    public static final int U_CARINFO_EPS_MODE = 106;
    public static final int U_CARINFO_FORTIFICATION_PROMPT = 103;
    public static final int U_CARINFO_HAND_ENABLE = 108;
    public static final int U_CARINFO_HAND_SKYWIN = 109;
    public static final int U_CARINFO_HOME_LIGHT = 104;
    public static final int U_CARINFO_REMOTE_BACK = 97;
    public static final int U_CARINFO_ROAD_AWAY = 102;
    public static final int U_CARINFO_SPEED_ALARM = 95;
    public static final int U_CARINFO_STEERING_ANIM = 93;
    public static final int U_CARINFO_STEERING_AVM = 92;
    public static final int U_CARINFO_STEERING_POWER = 100;
    public static final int U_CARINFO_VEHICLE_GUIDES = 94;
    public static final int U_CARINFO_WARN_EXIST = 86;
    public static final int U_CARINFO_WARN_SWITCH = 87;
    public static final int U_CARINFO_WARN_TYPE = 88;
    public static final int U_CARINFO_WELCOME_ONOFF = 107;
    public static final int U_CNT_MAX = 111;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0395_WC2_JietuX70(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
