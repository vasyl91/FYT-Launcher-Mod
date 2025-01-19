package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0070_RZC_XP1_17CHANGANCS75;
import com.syu.ui.door.DoorHelper;

public class Callback_0070_RZC_XP1_CHANGANCS75 extends CallbackCanbusBase {
    public static final int U_AIRSET_AIRAUTO_DRY = 124;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 122;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 123;
    public static final int U_AIR_AUTO_CLEAR = 132;
    public static final int U_BACK_RAINASSIST = 117;
    public static final int U_BOXVOL_BAOJING = 130;
    public static final int U_BOXVOL_TISHI = 129;
    public static final int U_BOXVOL_YINGBING = 128;
    public static final int U_CNT_MAX = 138;
    public static final int U_CUR_OIL_EXPEND = 99;
    public static final int U_CUR_TRIP_OIL_EXPEND = 101;
    public static final int U_DIANLABA_VOLSET = 136;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 120;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 119;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 121;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 118;
    public static final int U_DRIVING_MILEAGE = 100;
    public static final int U_LIGHT_FORNTDELAY = 125;
    public static final int U_LIGHT_ONEKEYTURN = 126;
    public static final int U_OPTIMAL_OIL_EXPEND = 98;
    public static final int U_PART_AUTO_UNLOCK = 131;
    public static final int U_RESORE_CARSET = 116;
    public static final int U_SET_FOLD_REARMIRROR = 102;
    public static final int U_TIRE_ALARM_FL = 112;
    public static final int U_TIRE_ALARM_FR = 113;
    public static final int U_TIRE_ALARM_RL = 114;
    public static final int U_TIRE_ALARM_RR = 115;
    public static final int U_TIRE_PRESSURE_FL = 104;
    public static final int U_TIRE_PRESSURE_FR = 105;
    public static final int U_TIRE_PRESSURE_RL = 106;
    public static final int U_TIRE_PRESSURE_RR = 107;
    public static final int U_TIRE_RESET = 127;
    public static final int U_TIRE_TEMP_FL = 108;
    public static final int U_TIRE_TEMP_FR = 109;
    public static final int U_TIRE_TEMP_RL = 110;
    public static final int U_TIRE_TEMP_RR = 111;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 103;
    public static final int U_UNLOCK_REC_SET = 137;
    public static final int U_WINDOW_DELAY_TIME = 133;
    public static final int U_WINDOW_LIGHT = 134;
    public static final int U_WINDOW_YAOKONG = 135;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 138; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0070_RZC_XP1_17CHANGANCS75(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 138) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
