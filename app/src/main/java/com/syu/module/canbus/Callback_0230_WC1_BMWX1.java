package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0230_WC1_BMW_X1;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0230_WC1_BMWX1 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 28;
    public static final int U_AIR_ACMAX = 37;
    public static final int U_AIR_AUTO = 25;
    public static final int U_AIR_AUTO2 = 38;
    public static final int U_AIR_BEGIN = 21;
    public static final int U_AIR_BLOW_BODY_LEFT = 33;
    public static final int U_AIR_BLOW_BODY_RIGHT = 39;
    public static final int U_AIR_BLOW_FOOT_LEFT = 34;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 40;
    public static final int U_AIR_BLOW_UP_LEFT = 35;
    public static final int U_AIR_BLOW_UP_RIGHT = 41;
    public static final int U_AIR_CYCLE = 24;
    public static final int U_AIR_DUAL = 26;
    public static final int U_AIR_END = 43;
    public static final int U_AIR_FRONT_DEFROST = 30;
    public static final int U_AIR_POWER = 23;
    public static final int U_AIR_REAR = 27;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_SEAT_HOT_LEFT = 19;
    public static final int U_AIR_SEAT_HOT_RIGHT = 20;
    public static final int U_AIR_SHOW = 22;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_OUT = 11;
    public static final int U_AIR_TEMP_RIGHT = 32;
    public static final int U_AIR_WIND_LEVEL_LEFT = 36;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 42;
    public static final int U_AVERAGE_SPEED = 2;
    public static final int U_BLOWER_ONOFF = 4;
    public static final int U_BLOWER_SHOW = 3;
    public static final int U_CNT_MAX = 44;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_DOOR_BACK = 17;
    public static final int U_DOOR_BEGIN = 12;
    public static final int U_DOOR_END = 18;
    public static final int U_DOOR_ENGINE = 12;
    public static final int U_DOOR_FL = 13;
    public static final int U_DOOR_FR = 14;
    public static final int U_DOOR_RL = 15;
    public static final int U_DOOR_RR = 16;
    public static final int U_DRIVING_MILEAGE = 1;
    public static final int U_TIME1_HOUR = 7;
    public static final int U_TIME1_MINUTES = 8;
    public static final int U_TIME1_SET = 5;
    public static final int U_TIME2_HOUR = 9;
    public static final int U_TIME2_MINUTES = 10;
    public static final int U_TIME2_SET = 6;
    public static int[] mBlower_Time = new int[5];

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 44; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 12;
        DoorHelper.sUcDoorFl = 13;
        DoorHelper.sUcDoorFr = 14;
        DoorHelper.sUcDoorRl = 15;
        DoorHelper.sUcDoorRr = 16;
        DoorHelper.sUcDoorBack = 17;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 12; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0230_WC1_BMW_X1(LauncherApplication.getInstance()));
        for (int i3 = 21; i3 < 43; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 12; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 21; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 7) {
            if (ints != null && ints.length >= 2) {
                mBlower_Time = ints;
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
            }
        } else if (updateCode >= 0 && updateCode < 44) {
            Log.v("zed", " updateCode == " + updateCode + "value = " + ints[0]);
        }
        HandlerCanbus.update(updateCode, ints);
    }
}
