package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0293_WC3_15RuiJie;
import com.syu.ui.door.DoorHelper;

public class Callback_0293_WC3_RUIJIE15 extends CallbackCanbusBase {
    public static final int U_AUDIO_CHANNEL_VALUE = 111;
    public static final int U_CARINFO_END = 108;
    public static final int U_CAR_BT_STATE = 102;
    public static final int U_CAR_CURRENT_SPEED = 98;
    public static final int U_CAR_WARN = 107;
    public static final int U_CNT_MAX = 112;
    public static final int U_CUR_SPEED = 109;
    public static final int U_DISPLAY_MODE = 101;
    public static final int U_DRIVING_TIME = 99;
    public static final int U_ENGINE_SPEED = 110;
    public static final int U_LINE_GROUP = 106;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_PLAY_TIME = 103;
    public static final int U_SCREEN_ICON = 105;
    public static final int U_SCREEN_ID = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0293_WC3_15RuiJie(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
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
        if (updateCode == 111) {
            DataCanbus.DATA[updateCode] = ints[0];
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        } else {
            if (updateCode == 107) {
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode >= 0 && updateCode < 112) {
                if (strs == null) {
                    HandlerCanbus.update(updateCode, ints);
                } else {
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                }
            }
        }
    }
}
