package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0014_WC2_Focus;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0014_WC2_Focus extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 5;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 7;
    public static final int U_AIR_BLOW_FOOT = 8;
    public static final int U_AIR_BLOW_WIN = 6;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_END = 12;
    public static final int U_AIR_MAX = 3;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_SHOW = 0;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL = 9;
    public static final int U_AUDIO_CHANNEL_VALUE = 46;
    public static final int U_BT_STATE = 23;
    public static final int U_CARINFO_BEGIN = 18;
    public static final int U_CARINFO_END = 24;
    public static final int U_CARSET_BEGIN = 27;
    public static final int U_CARSET_END = 33;
    public static final int U_CARSET_MEASURE_UNIT = 31;
    public static final int U_CARSET_MESSAGE_PROMPT = 32;
    public static final int U_CARSET_MILIEU_LIGHT_ON = 30;
    public static final int U_CARSET_TRACTION_CTRL = 28;
    public static final int U_CARSET_TURNLIGHT_ON = 29;
    public static final int U_CARSET_WARN_PROMPT = 33;
    public static final int U_CNT_MAX = 47;
    public static final int U_CUR_SPEED = 25;
    public static final int U_DISPLAY_MODE = 22;
    public static final int U_DOOR_BACK = 17;
    public static final int U_DOOR_BEGIN = 12;
    public static final int U_DOOR_END = 18;
    public static final int U_DOOR_ENGINE = 12;
    public static final int U_DOOR_FL = 13;
    public static final int U_DOOR_FR = 14;
    public static final int U_DOOR_RL = 15;
    public static final int U_DOOR_RR = 16;
    public static final int U_ENGINE_SPEED = 26;
    public static final int U_LINE_GROUP = 20;
    public static final int U_PLAY_TIME = 21;
    public static final int U_SCREEN_ICON = 19;
    public static final int U_SCREEN_ID = 18;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 47; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 12;
        DoorHelper.sUcDoorFl = 13;
        DoorHelper.sUcDoorFr = 14;
        DoorHelper.sUcDoorRl = 15;
        DoorHelper.sUcDoorRr = 16;
        DoorHelper.sUcDoorBack = 17;
        AirHelper.getInstance().buildUi(new Air_0014_WC2_Focus(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 12; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 12; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 12; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 12; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 47) {
            if (updateCode == 46) {
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
