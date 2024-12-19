package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Xiandai_all;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Xiandai_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_CLEAR = 39;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_CYCLE_AUTO = 40;
    public static final int U_AIR_DATA0 = 18;
    public static final int U_AIR_DATA1 = 19;
    public static final int U_AIR_DATA2 = 20;
    public static final int U_AIR_DATA3 = 21;
    public static final int U_AIR_DATA4 = 22;
    public static final int U_AIR_DATA5 = 23;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 12;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_SHOW = 16;
    public static final int U_AIR_SYNC = 15;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CARINFO_BEGIN = 31;
    public static final int U_CARINFO_END = 38;
    public static final int U_CARINFO_FRONT_VIEW_INIT = 34;
    public static final int U_CARINFO_RADAR_DISPLAY = 33;
    public static final int U_CARINFO_REAR_VIEW_INIT = 35;
    public static final int U_CARINFO_TRACK_DISPLAY = 32;
    public static final int U_CARSEAT_BACK_STATE = 37;
    public static final int U_CARSEAT_SHOW_ENABLE = 41;
    public static final int U_CARSEAT_STATE = 36;
    public static final int U_CNT_MAX = 42;
    public static final int U_CYTK3_AIR_BEGIN = 18;
    public static final int U_DOOR_BACK = 29;
    public static final int U_DOOR_BEGIN = 24;
    public static final int U_DOOR_END = 30;
    public static final int U_DOOR_ENGINE = 24;
    public static final int U_DOOR_FL = 25;
    public static final int U_DOOR_FR = 26;
    public static final int U_DOOR_RL = 27;
    public static final int U_DOOR_RR = 28;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 42; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 24;
        DoorHelper.sUcDoorFl = 25;
        DoorHelper.sUcDoorFr = 26;
        DoorHelper.sUcDoorRl = 27;
        DoorHelper.sUcDoorRr = 28;
        DoorHelper.sUcDoorBack = 29;
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Xiandai_all(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 24; i2 < 30; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[39].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 24; i < 30; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 42) {
            if (updateCode == 16) {
                if (ints[0] == 0) {
                    AirHelper.getInstance().hideWindow();
                    return;
                } else {
                    AirHelper.getInstance().showAndRefresh();
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
