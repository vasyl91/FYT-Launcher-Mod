package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0415_WC_Haval_Coupe extends CallbackCanbusBase {
    public static final int U_CAR_INFO_BEGIN = 10;
    public static final int U_CNT_MAX = 20;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_INFO_LIGHT_FOLLOW = 14;
    public static final int U_INFO_LIGHT_HEAD = 13;
    public static final int U_INFO_LIGHT_SAVE = 15;
    public static final int U_INFO_LIGHT_SENSE = 16;
    public static final int U_INFO_LIGHT_TRAIL = 17;
    public static final int U_INFO_SOUND = 11;
    public static final int U_INFO_VOL_WITH_SPEED = 12;
    public static final int U_REARVIEW_AUTO_SHOW = 19;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 18;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 20; i++) {
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
        if (updateCode >= 0 && updateCode < 20) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
