package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0101_WC2_Nissan_All;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_QiJun;

public class Callback_0101_WC1_QiJun extends CallbackCanbusBase {
    public static final int C_PARKING_KEYDOWN = 1;
    public static final int U_CAREQ_A6_D0_B70 = 102;
    public static final int U_CAREQ_A6_D1_B70 = 103;
    public static final int U_CAREQ_A6_D2_B70 = 104;
    public static final int U_CAREQ_A6_D3_B70 = 105;
    public static final int U_CAREQ_A6_D4_B70 = 106;
    public static final int U_CAREQ_A6_D5_B70 = 107;
    public static final int U_CAREQ_A6_D6_B20 = 110;
    public static final int U_CAREQ_A6_D6_B3 = 109;
    public static final int U_CAREQ_A6_D6_B4 = 108;
    public static final int U_CAREQ_A6_D7_B70 = 111;
    public static final int U_CARSET_D61_D2_B2 = 112;
    public static final int U_CNT_MAX = 113;
    public static final int U_PARK_BTN = 100;
    public static final int U_PARK_CAMERA = 101;
    public static final int U_PARK_PAGE = 99;
    public static final int U_PARK_TXTMSG = 98;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 113; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0101_WC2_Nissan_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 458853) {
            ParkingHelper.getInstance().buildUi(new Parking_QiJun(LauncherApplication.getInstance()));
            DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
            for (int i4 = 98; i4 <= 101; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(ParkingHelper.getInstance(), 0);
            }
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DataMain.NOTIFY_EVENTS[12].removeNotify(ParkingHelper.getInstance());
        ParkingHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 113) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
