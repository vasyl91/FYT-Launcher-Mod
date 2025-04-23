package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.crv.XpCrvActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0024_XP1_SIYU2012 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 108;
    public static final int U_COMPASS_ANGLE = 107;
    public static final int U_COMPASS_AREA = 106;
    public static final int U_COMPASS_CALIBRATION = 105;
    public static final int U_PLAYER_FOLDER = 103;
    public static final int U_PLAYER_PROGRESS = 104;
    public static final int U_PLAYER_TIME = 100;
    public static final int U_PLAYER_TOTAL_TRACK = 102;
    public static final int U_PLAYER_TRACK = 101;
    public static final int U_USB_STATES = 98;
    public static final int U_USB_TYPE = 99;

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
        if (updateCode >= 0 && updateCode < 108) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode == 98) {
            int value = DataCanbus.DATA[98];
            if (value == 3 && !XpCrvActi.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.crv.XpCrvActi");
            } else if (value == 2 && XpCrvActi.mIsFront && XpCrvActi.mInstance != null) {
                XpCrvActi.mInstance.finish();
            }
        }
    }
}
