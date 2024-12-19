package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_ChangAn_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_ChangAn_All extends CallbackCanbusBase {
    public static final int C_CARSET = 1;
    public static final int C_TURN_RIGHT_ENTER_CAMERA = 0;
    public static final int U_AIRSET_AIRAUTO_DRY = 41;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 39;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 40;
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_ACMAX = 1;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_AUTO_CLEAR = 49;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_BLUET_WIN_DOWN = 55;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_END = 12;
    public static final int U_AIR_FRONT_DEFROST = 5;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_TEMP_LEFT = 11;
    public static final int U_AIR_WIND_LEVEL_LEFT = 7;
    public static final int U_BACK_RAINASSIST = 34;
    public static final int U_BOXVOL_BAOJING = 47;
    public static final int U_BOXVOL_TISHI = 46;
    public static final int U_BOXVOL_YINGBING = 45;
    public static final int U_CNT_MAX = 61;
    public static final int U_CUR_OIL_EXPEND = 59;
    public static final int U_DIANLABA_VOLSET = 53;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 37;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 36;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 38;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 35;
    public static final int U_DOOR_BACK = 17;
    public static final int U_DOOR_BEGIN = 12;
    public static final int U_DOOR_END = 18;
    public static final int U_DOOR_ENGINE = 12;
    public static final int U_DOOR_FL = 13;
    public static final int U_DOOR_FR = 14;
    public static final int U_DOOR_RL = 15;
    public static final int U_DOOR_RR = 16;
    public static final int U_DRIVING_MILEAGE = 60;
    public static final int U_LIGHT_ATMOSPHERE_LIGHT = 57;
    public static final int U_LIGHT_DAY_LIGHT = 56;
    public static final int U_LIGHT_FORNTDELAY = 42;
    public static final int U_LIGHT_ONEKEYTURN = 43;
    public static final int U_OPTIMAL_OIL_EXPEND = 58;
    public static final int U_PART_AUTO_UNLOCK = 48;
    public static final int U_RESORE_CARSET = 33;
    public static final int U_SET_FOLD_REARMIRROR = 19;
    public static final int U_TIRE_ALARM_FL = 29;
    public static final int U_TIRE_ALARM_FR = 30;
    public static final int U_TIRE_ALARM_RL = 31;
    public static final int U_TIRE_ALARM_RR = 32;
    public static final int U_TIRE_PRESSURE_FL = 21;
    public static final int U_TIRE_PRESSURE_FR = 22;
    public static final int U_TIRE_PRESSURE_RL = 23;
    public static final int U_TIRE_PRESSURE_RR = 24;
    public static final int U_TIRE_RESET = 44;
    public static final int U_TIRE_TEMP_FL = 25;
    public static final int U_TIRE_TEMP_FR = 26;
    public static final int U_TIRE_TEMP_RL = 27;
    public static final int U_TIRE_TEMP_RR = 28;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 20;
    public static final int U_UNLOCK_REC_SET = 54;
    public static final int U_WINDOW_DELAY_TIME = 50;
    public static final int U_WINDOW_LIGHT = 51;
    public static final int U_WINDOW_YAOKONG = 52;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 61; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 12;
        DoorHelper.sUcDoorFl = 13;
        DoorHelper.sUcDoorFr = 14;
        DoorHelper.sUcDoorRl = 15;
        DoorHelper.sUcDoorRr = 16;
        DoorHelper.sUcDoorBack = 17;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 12; i3 < 18; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_ChangAn_All(LauncherApplication.getInstance()));
        for (int i4 = 0; i4 < 12; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(AirHelper.SHOW_AND_REFRESH);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 12; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 12; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 61) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
