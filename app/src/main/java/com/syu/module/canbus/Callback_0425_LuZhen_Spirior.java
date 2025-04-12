package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0425_LuZhen_Spirior extends CallbackCanbusBase {
    public static final int U_BRAKE_LIGHT = 105;
    public static final int U_CNT_MAX = 108;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_FRONT_FOG_LIGHTS = 103;
    public static final int U_HIGH_BEAM = 101;
    public static final int U_LOW_BEAM_LIGHTS = 102;
    public static final int U_REAR_FOG_LAMPS = 104;
    public static final int U_TOTAL_MILEAGE = 100;
    public static final int U_TURN_LEFT_LIGHT = 106;
    public static final int U_TURN_RIGHT_LIGHT = 107;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 108; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        //AirHelper.getInstance().buildUi(new Air_0425_LZ_Spirior(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
