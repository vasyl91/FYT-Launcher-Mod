package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_OD_Opel_adan extends CallbackCanbusBase {
    public static final int U_CARCD_TEXT = 110;
    public static final int U_CNT_MAX = 111;
    public static final int U_TIRE_ALARM_FL = 106;
    public static final int U_TIRE_ALARM_FR = 107;
    public static final int U_TIRE_ALARM_RL = 108;
    public static final int U_TIRE_ALARM_RR = 109;
    public static final int U_TIRE_PRESSURE_FL = 98;
    public static final int U_TIRE_PRESSURE_FR = 99;
    public static final int U_TIRE_PRESSURE_RL = 100;
    public static final int U_TIRE_PRESSURE_RR = 101;
    public static final int U_TIRE_TEMP_FL = 102;
    public static final int U_TIRE_TEMP_FR = 103;
    public static final int U_TIRE_TEMP_RL = 104;
    public static final int U_TIRE_TEMP_RR = 105;
    public static String cdText;

    @Override
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
        //AirHelper.getInstance().buildUi(new Air_0439_OD_Opel_Adan(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 110:
                if (strs != null && strs.length > 0) {
                    cdText = strs[0];
                } else {
                    cdText = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            default:
                if (updateCode >= 0 && updateCode < 111) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
