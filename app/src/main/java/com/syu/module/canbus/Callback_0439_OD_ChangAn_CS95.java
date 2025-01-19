package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_OD_ChangAn_CS95;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_OD_ChangAn_CS95 extends CallbackCanbusBase {
    public static final int U_AUTO_LOCK_DRIVING = 102;
    public static final int U_AUTO_UNLOCK_LIGHTOFF = 103;
    public static final int U_CARSET_D3A_D3_B6 = 110;
    public static final int U_CARSET_D66_D1_B1 = 111;
    public static final int U_CARSET_D66_D2_B1 = 116;
    public static final int U_CARSET_D66_D2_B2 = 115;
    public static final int U_CARSET_D66_D2_B3 = 114;
    public static final int U_CARSET_D66_D2_B4 = 113;
    public static final int U_CARSET_D66_D2_B5 = 112;
    public static final int U_CARSET_D66_D3_B3 = 126;
    public static final int U_CARSET_D66_D4_B30 = 119;
    public static final int U_CARSET_D66_D4_B54 = 118;
    public static final int U_CARSET_D66_D4_B6 = 117;
    public static final int U_CARSET_D66_D5_B30 = 120;
    public static final int U_CARSET_D66_D6_B7 = 121;
    public static final int U_CARSET_D66_D7_B0 = 125;
    public static final int U_CARSET_D66_D7_B1 = 124;
    public static final int U_CARSET_D66_D7_B2 = 123;
    public static final int U_CARSET_D66_D7_B3 = 122;
    public static final int U_CNT_MAX = 127;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_FRONT_LIGHT_DELAY = 104;
    public static final int U_ONKEY_TURN_OFF = 105;
    public static final int U_REMOTE_UNLOCK_MODE = 101;
    public static final int U_REVERSE_AUTO_WIPER = 106;
    public static final int U_SET_FOLD_REARMIRROR = 98;
    public static final int U_SMART_AIR_PURIFY = 109;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 100;
    public static final int U_UNLOCK_AUTO_VENTILATION = 107;
    public static final int U_UNLOCK_AUTO_WINDOW = 108;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_OD_ChangAn_CS95(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
