package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0014_WC2_Focus;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0014_WC2_Focus extends CallbackCanbusBase {
    public static final int U_AUDIO_CHANNEL_VALUE = 127;
    public static final int U_BT_STATE = 103;
    public static final int U_CAREQ_BAL = 112;
    public static final int U_CAREQ_BASS = 114;
    public static final int U_CAREQ_BEGIN = 111;
    public static final int U_CAREQ_END = 119;
    public static final int U_CAREQ_FAD = 113;
    public static final int U_CAREQ_MID = 115;
    public static final int U_CAREQ_SURROUND = 118;
    public static final int U_CAREQ_TREB = 116;
    public static final int U_CAREQ_VOL = 111;
    public static final int U_CAREQ_VOL_LINK_SPEED = 117;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_END = 110;
    public static final int U_CARSET_BEGIN = 120;
    public static final int U_CARSET_MEASURE_UNIT = 124;
    public static final int U_CARSET_MESSAGE_PROMPT = 125;
    public static final int U_CARSET_MILIEU_LIGHT_ON = 123;
    public static final int U_CARSET_TRACTION_CTRL = 121;
    public static final int U_CARSET_TURNLIGHT_ON = 122;
    public static final int U_CARSET_WARN_PROMPT = 126;
    public static final int U_CNT_MAX = 128;
    public static final int U_CUR_SPEED = 104;
    public static final int U_DISPLAY_MODE = 102;
    public static final int U_ENGINE_SPEED = 105;
    public static final int U_LINE_GROUP = 100;
    public static final int U_PLAY_TIME = 101;
    public static final int U_SCREEN_ICON = 99;
    public static final int U_SCREEN_ID = 98;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 128; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0014_WC2_Focus(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 128) {
            if (updateCode == 127) {
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
