package com.syu.module.canbus;

import android.os.RemoteException;
import android.os.SystemProperties;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0070_RZC_XP1_17CHANGANCS75;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0070_RZC_XP1_CHANGANCS75 extends CallbackCanbusBase {
    public static final int U_AIRSET_AIRAUTO_DRY = 45;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 43;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 44;
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 15;
    public static final int U_AIR_AUTO = 5;
    public static final int U_AIR_AUTO_CLEAR = 53;
    public static final int U_AIR_BEGIN = 4;
    public static final int U_AIR_BLOW_BODY_LEFT = 11;
    public static final int U_AIR_BLOW_FOOT_LEFT = 12;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_CYCLE = 6;
    public static final int U_AIR_END = 16;
    public static final int U_AIR_FRONT_DEFROST = 7;
    public static final int U_AIR_REAR_DEFROST = 8;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_WIND_LEVEL_LEFT = 14;
    public static final int U_BACK_RAINASSIST = 38;
    public static final int U_BOXVOL_BAOJING = 51;
    public static final int U_BOXVOL_TISHI = 50;
    public static final int U_BOXVOL_YINGBING = 49;
    public static final int U_CNT_MAX = 59;
    public static final int U_CUR_OIL_EXPEND = 1;
    public static final int U_CUR_TRIP_OIL_EXPEND = 3;
    public static final int U_DIANLABA_VOLSET = 57;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 41;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 40;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 42;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 39;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;
    public static final int U_DRIVING_MILEAGE = 2;
    public static final int U_LIGHT_FORNTDELAY = 46;
    public static final int U_LIGHT_ONEKEYTURN = 47;
    public static final int U_OPTIMAL_OIL_EXPEND = 0;
    public static final int U_PART_AUTO_UNLOCK = 52;
    public static final int U_RESORE_CARSET = 37;
    public static final int U_SET_FOLD_REARMIRROR = 23;
    public static final int U_TIRE_ALARM_FL = 33;
    public static final int U_TIRE_ALARM_FR = 34;
    public static final int U_TIRE_ALARM_RL = 35;
    public static final int U_TIRE_ALARM_RR = 36;
    public static final int U_TIRE_PRESSURE_FL = 25;
    public static final int U_TIRE_PRESSURE_FR = 26;
    public static final int U_TIRE_PRESSURE_RL = 27;
    public static final int U_TIRE_PRESSURE_RR = 28;
    public static final int U_TIRE_RESET = 48;
    public static final int U_TIRE_TEMP_FL = 29;
    public static final int U_TIRE_TEMP_FR = 30;
    public static final int U_TIRE_TEMP_RL = 31;
    public static final int U_TIRE_TEMP_RR = 32;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 24;
    public static final int U_UNLOCK_REC_SET = 58;
    public static final int U_WINDOW_DELAY_TIME = 54;
    public static final int U_WINDOW_LIGHT = 55;
    public static final int U_WINDOW_YAOKONG = 56;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 59; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 16;
        DoorHelper.sUcDoorFl = 17;
        DoorHelper.sUcDoorFr = 18;
        DoorHelper.sUcDoorRl = 19;
        DoorHelper.sUcDoorRr = 20;
        DoorHelper.sUcDoorBack = 21;
        SystemProperties.getInt("ro.build.fytmanufacturer", -1);
        if (DataCanbus.DATA[1000] == 65606 || DataCanbus.DATA[1000] == 327750 || DataCanbus.DATA[1000] == 1704006 || DataCanbus.DATA[1000] == 786502 || DataCanbus.DATA[1000] == 720966) {
            AirHelper.getInstance().buildUi(new Air_0070_RZC_XP1_17CHANGANCS75(LauncherApplication.getInstance()));
        }
        if (DataCanbus.DATA[1000] == 458822 || DataCanbus.DATA[1000] == 589894 || DataCanbus.DATA[1000] == 524358 || DataCanbus.DATA[1000] == 655430 || DataCanbus.DATA[1000] == 1179718 || DataCanbus.DATA[1000] == 917574 || DataCanbus.DATA[1000] == 1245254 || DataCanbus.DATA[1000] == 1310790 || DataCanbus.DATA[1000] == 1376326 || DataCanbus.DATA[1000] == 1441862) {
            AirHelper.getInstance().buildUi(new Air_0070_RZC_XP1_17CHANGANCS75(LauncherApplication.getInstance()));
        } else if (DataCanbus.carId != 2) {
            AirHelper.getInstance().buildUi(new Air_0070_RZC_XP1_17CHANGANCS75(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 16; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 4; i3 < 16; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 16; i < 22; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 4; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 59) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
