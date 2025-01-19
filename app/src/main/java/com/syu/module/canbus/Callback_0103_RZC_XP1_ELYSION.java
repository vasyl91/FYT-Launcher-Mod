package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0103_RZC_XP1_ELYSION extends CallbackCanbusBase {
    public static final int U_AVERAGE_OIL = 102;
    public static final int U_AVERAGE_SPEED = 104;
    public static final int U_A_DIS_CONTROL_BIT = 100;
    public static final int U_B_DIS_CONTROL_BIT = 101;
    public static final int U_CAR_SPEED_INFO = 107;
    public static final int U_CNT_MAX = 115;
    public static final int U_DIS_CONTROL_BIT = 99;
    public static final int U_FRONT_FOG_LIGHTS_SWITCH = 111;
    public static final int U_HEADLIGHT_SWITCH = 109;
    public static final int U_HIGH_BEAM_SWITCH = 110;
    public static final int U_INSTRUMENT_LIGHT_BRIGHT = 113;
    public static final int U_OIL_BEGIN = 98;
    public static final int U_OIL_END = 114;
    public static final int U_REAR_FOG_LAMPS_SWITCH = 112;
    public static final int U_SMALL_LIGHTS_SWITCH = 108;
    public static final int U_TRAVEL_DISTANCE = 103;
    public static final int U_TRAVEL_TIME = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 115) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
