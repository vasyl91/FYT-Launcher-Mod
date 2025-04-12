package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0274_DJ_XP1_ACCORD7 extends CallbackCanbusBase {
    public static final int U_CARINFO_AIR_MIX_CONTROL_MOTOR_LEFT = 104;
    public static final int U_CARINFO_AIR_MIX_CONTROL_MOTOR_RIGHT = 105;
    public static final int U_CARINFO_AIR_MIX_OPEN_DEGREE_LEFT = 108;
    public static final int U_CARINFO_AIR_MIX_OPEN_DEGREE_RIGHT = 109;
    public static final int U_CARINFO_BEGIN = 100;
    public static final int U_CARINFO_BLOWER_MOTOR = 107;
    public static final int U_CARINFO_END = 114;
    public static final int U_CARINFO_ENGINER_COOLANT = 113;
    public static final int U_CARINFO_EVAPORATOR_TEMP = 111;
    public static final int U_CARINFO_EVAPORATOR_TEMP_SENSOR = 103;
    public static final int U_CARINFO_INTER_TEMP = 112;
    public static final int U_CARINFO_INTER_TEMP_SENSOR = 100;
    public static final int U_CARINFO_MODE_CONTROL_MOTOR = 106;
    public static final int U_CARINFO_OUTER_TEMP_SENSOR = 101;
    public static final int U_CARINFO_SUNLIGHT_LEVEL = 110;
    public static final int U_CARINFO_SUNLIGHT_LEVEL_SENSOR = 102;
    public static final int U_CNT_MAX = 114;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0274_DJ_XP1_ACCORD7(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
