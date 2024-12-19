package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0293_WC3_15RuiJie;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0293_WC3_RUIJIE15 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 16;
    public static final int U_AIR_AMB = 29;
    public static final int U_AIR_AQS = 28;
    public static final int U_AIR_AUTO = 12;
    public static final int U_AIR_BEGIN = 11;
    public static final int U_AIR_BLOW_AUTO_LEFT = 26;
    public static final int U_AIR_BLOW_BODY_LEFT = 18;
    public static final int U_AIR_BLOW_FOOT_LEFT = 19;
    public static final int U_AIR_BLOW_WIN_LEFT = 27;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_ECO = 25;
    public static final int U_AIR_END = 34;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_MAX = 20;
    public static final int U_AIR_MAXHEAT = 33;
    public static final int U_AIR_POWER = 24;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_SEAT_HEAT_LEFT = 30;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 31;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_RIGHT = 23;
    public static final int U_AIR_TEMP_UNIT = 32;
    public static final int U_AIR_WIND_LEVEL_LEFT = 21;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 22;
    public static final int U_AUDIO_CHANNEL_VALUE = 43;
    public static final int U_CARINFO_BEGIN = 0;
    public static final int U_CARINFO_END = 11;
    public static final int U_CAR_BT_STATE = 5;
    public static final int U_CAR_CURRENT_SPEED = 1;
    public static final int U_CAR_WARN = 10;
    public static final int U_CNT_MAX = 44;
    public static final int U_CUR_SPEED = 41;
    public static final int U_DISPLAY_MODE = 4;
    public static final int U_DOOR_BACK = 39;
    public static final int U_DOOR_BEGIN = 34;
    public static final int U_DOOR_END = 40;
    public static final int U_DOOR_ENGINE = 34;
    public static final int U_DOOR_FL = 35;
    public static final int U_DOOR_FR = 36;
    public static final int U_DOOR_RL = 37;
    public static final int U_DOOR_RR = 38;
    public static final int U_DRIVING_TIME = 2;
    public static final int U_ENGINE_SPEED = 42;
    public static final int U_LINE_GROUP = 9;
    public static final int U_OPTIMAL_OIL_EXPEND = 3;
    public static final int U_PLAY_TIME = 6;
    public static final int U_SCREEN_ICON = 8;
    public static final int U_SCREEN_ID = 7;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 44; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 34;
        DoorHelper.sUcDoorFl = 35;
        DoorHelper.sUcDoorFr = 36;
        DoorHelper.sUcDoorRl = 37;
        DoorHelper.sUcDoorRr = 38;
        DoorHelper.sUcDoorBack = 39;
        AirHelper.getInstance().buildUi(new Air_0293_WC3_15RuiJie(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 34; i2 < 40; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 11; i3 < 34; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 34; i < 40; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 11; i2 < 34; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 43) {
            DataCanbus.DATA[updateCode] = ints[0];
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
        } else {
            if (updateCode == 10) {
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode >= 0 && updateCode < 44) {
                if (strs == null) {
                    HandlerCanbus.update(updateCode, ints);
                } else {
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                }
            }
        }
    }
}
