package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_Opel_Adan;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OD_Opel_adan extends CallbackCanbusBase {
    public static final int U_AIR_AC = 7;
    public static final int U_AIR_AUTO = 9;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 12;
    public static final int U_AIR_BLOW_WIN_LEFT = 11;
    public static final int U_AIR_CYCLE = 8;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_WIND_LEVEL_LEFT = 14;
    public static final int U_CARCD_TEXT = 30;
    public static final int U_CNT_MAX = 31;
    public static final int U_TIRE_ALARM_FL = 26;
    public static final int U_TIRE_ALARM_FR = 27;
    public static final int U_TIRE_ALARM_RL = 28;
    public static final int U_TIRE_ALARM_RR = 29;
    public static final int U_TIRE_PRESSURE_FL = 18;
    public static final int U_TIRE_PRESSURE_FR = 19;
    public static final int U_TIRE_PRESSURE_RL = 20;
    public static final int U_TIRE_PRESSURE_RR = 21;
    public static final int U_TIRE_TEMP_FL = 22;
    public static final int U_TIRE_TEMP_FR = 23;
    public static final int U_TIRE_TEMP_RL = 24;
    public static final int U_TIRE_TEMP_RR = 25;
    public static String cdText;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 31; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_OD_Opel_Adan(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 17; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 30:
                if (strs != null && strs.length > 0) {
                    cdText = strs[0];
                } else {
                    cdText = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            default:
                if (updateCode >= 0 && updateCode < 31) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
