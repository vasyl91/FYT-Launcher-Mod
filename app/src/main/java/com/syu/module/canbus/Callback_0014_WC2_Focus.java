package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0014_WC2_Focus;
import com.syu.ui.door.DoorHelper;

public class Callback_0014_WC2_Focus extends CallbackCanbusBase {
    public static final int U_AUDIO_CHANNEL_VALUE = 114;
    public static final int U_BT_STATE = 103;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_END = 104;
    public static final int U_CARSET_BEGIN = 107;
    public static final int U_CARSET_MEASURE_UNIT = 111;
    public static final int U_CARSET_MESSAGE_PROMPT = 112;
    public static final int U_CARSET_MILIEU_LIGHT_ON = 110;
    public static final int U_CARSET_TRACTION_CTRL = 108;
    public static final int U_CARSET_TURNLIGHT_ON = 109;
    public static final int U_CARSET_WARN_PROMPT = 113;
    public static final int U_CNT_MAX = 115;
    public static final int U_CUR_SPEED = 105;
    public static final int U_DISPLAY_MODE = 102;
    public static final int U_ENGINE_SPEED = 106;
    public static final int U_LINE_GROUP = 100;
    public static final int U_PLAY_TIME = 101;
    public static final int U_SCREEN_ICON = 99;
    public static final int U_SCREEN_ID = 98;

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
        //AirHelper.getInstance().buildUi(new Air_0014_WC2_Focus(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 115) {
            if (updateCode == 114) {
                DataCanbus.DATA[updateCode] = ints[0];
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            } else if (strs == null) {
                HandlerCanbus.update(updateCode, ints);
            } else {
                HandlerCanbus.update(updateCode, ints, flts, strs);
            }
        }
    }
}
