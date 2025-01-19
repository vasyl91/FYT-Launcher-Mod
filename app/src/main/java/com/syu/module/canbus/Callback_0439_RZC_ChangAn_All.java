package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_RZC_ChangAn_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_ChangAn_All extends CallbackCanbusBase {
    public static final int C_CARSET = 1;
    public static final int C_TURN_RIGHT_ENTER_CAMERA = 0;
    public static final int U_AIRSET_AIRAUTO_DRY = 120;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 118;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 119;
    public static final int U_AIR_AUTO_CLEAR = 128;
    public static final int U_AIR_BLUET_WIN_DOWN = 134;
    public static final int U_BACK_RAINASSIST = 113;
    public static final int U_BOXVOL_BAOJING = 126;
    public static final int U_BOXVOL_TISHI = 125;
    public static final int U_BOXVOL_YINGBING = 124;
    public static final int U_CNT_MAX = 140;
    public static final int U_CUR_OIL_EXPEND = 138;
    public static final int U_DIANLABA_VOLSET = 132;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 116;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 115;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 117;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 114;
    public static final int U_DRIVING_MILEAGE = 139;
    public static final int U_LIGHT_ATMOSPHERE_LIGHT = 136;
    public static final int U_LIGHT_DAY_LIGHT = 135;
    public static final int U_LIGHT_FORNTDELAY = 121;
    public static final int U_LIGHT_ONEKEYTURN = 122;
    public static final int U_OPTIMAL_OIL_EXPEND = 137;
    public static final int U_PART_AUTO_UNLOCK = 127;
    public static final int U_RESORE_CARSET = 112;
    public static final int U_SET_FOLD_REARMIRROR = 98;
    public static final int U_TIRE_ALARM_FL = 108;
    public static final int U_TIRE_ALARM_FR = 109;
    public static final int U_TIRE_ALARM_RL = 110;
    public static final int U_TIRE_ALARM_RR = 111;
    public static final int U_TIRE_PRESSURE_FL = 100;
    public static final int U_TIRE_PRESSURE_FR = 101;
    public static final int U_TIRE_PRESSURE_RL = 102;
    public static final int U_TIRE_PRESSURE_RR = 103;
    public static final int U_TIRE_RESET = 123;
    public static final int U_TIRE_TEMP_FL = 104;
    public static final int U_TIRE_TEMP_FR = 105;
    public static final int U_TIRE_TEMP_RL = 106;
    public static final int U_TIRE_TEMP_RR = 107;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 99;
    public static final int U_UNLOCK_REC_SET = 133;
    public static final int U_WINDOW_DELAY_TIME = 129;
    public static final int U_WINDOW_LIGHT = 130;
    public static final int U_WINDOW_YAOKONG = 131;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 140; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_ChangAn_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 140) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
