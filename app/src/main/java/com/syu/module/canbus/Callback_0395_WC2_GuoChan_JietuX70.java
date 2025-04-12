package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0395_WC2_GuoChan_JietuX70 extends CallbackCanbusBase {
    public static final int U_CARINFO_AUTO_FOLD_REARVIEW = 111;
    public static final int U_CARINFO_AUTO_LOCK = 101;
    public static final int U_CARINFO_AUTO_UNLOCK = 110;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 102;
    public static final int U_CARINFO_BLIND_SIDE = 113;
    public static final int U_CARINFO_CHANGE_ROAD_LIGHTONOFF = 117;
    public static final int U_CARINFO_D87_D6_B1 = 122;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 108;
    public static final int U_CARINFO_DAYLIGHT = 103;
    public static final int U_CARINFO_EPS_MODE = 118;
    public static final int U_CARINFO_FORTIFICATION_PROMPT = 115;
    public static final int U_CARINFO_HAND_ENABLE = 120;
    public static final int U_CARINFO_HAND_SKYWIN = 121;
    public static final int U_CARINFO_HOME_LIGHT = 116;
    public static final int U_CARINFO_REMOTE_BACK = 109;
    public static final int U_CARINFO_ROAD_AWAY = 114;
    public static final int U_CARINFO_SPEED_ALARM = 107;
    public static final int U_CARINFO_STEERING_ANIM = 105;
    public static final int U_CARINFO_STEERING_AVM = 104;
    public static final int U_CARINFO_STEERING_POWER = 112;
    public static final int U_CARINFO_VEHICLE_GUIDES = 106;
    public static final int U_CARINFO_WARN_EXIST = 98;
    public static final int U_CARINFO_WARN_SWITCH = 99;
    public static final int U_CARINFO_WARN_TYPE = 100;
    public static final int U_CARINFO_WELCOME_ONOFF = 119;
    public static final int U_CNT_MAX = 123;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0395_WC2_JietuX70(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 123) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
