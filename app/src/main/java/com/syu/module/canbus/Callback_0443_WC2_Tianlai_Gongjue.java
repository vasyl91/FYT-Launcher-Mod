package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Tianlai_Gongjue extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 100;
    public static final int U_CAREQ_BASS = 103;
    public static final int U_CAREQ_BEGIN = 98;
    public static final int U_CAREQ_BOSE = 104;
    public static final int U_CAREQ_END = 107;
    public static final int U_CAREQ_FAD = 101;
    public static final int U_CAREQ_SPEEDVOL = 105;
    public static final int U_CAREQ_SURROUND = 106;
    public static final int U_CAREQ_TRB = 102;
    public static final int U_CAREQ_VOL = 99;
    public static final int U_CARSET_AUTOKEY_UNLOCK = 113;
    public static final int U_CARSET_BEGIN = 108;
    public static final int U_CARSET_END = 114;
    public static final int U_CARSET_LIGHT_OFFTIME = 111;
    public static final int U_CARSET_LIGHT_SENSOR = 110;
    public static final int U_CARSET_RAINVIPER_SPEED = 112;
    public static final int U_CARSET_UNLOCK_LIGHTON = 109;
    public static final int U_CNT_MAX = 114;

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
        if (updateCode >= 0 && updateCode < 114) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
