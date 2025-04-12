package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0230_WC1_BMWX1 extends CallbackCanbusBase {
    public static final int U_AIR_TEMP_OUT = 109;
    public static final int U_AVERAGE_SPEED = 100;
    public static final int U_BLOWER_ONOFF = 102;
    public static final int U_BLOWER_SHOW = 101;
    public static final int U_CNT_MAX = 110;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_TIME1_HOUR = 105;
    public static final int U_TIME1_MINUTES = 106;
    public static final int U_TIME1_SET = 103;
    public static final int U_TIME2_HOUR = 107;
    public static final int U_TIME2_MINUTES = 108;
    public static final int U_TIME2_SET = 104;
    public static int[] mBlower_Time = new int[5];

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0230_WC1_BMW_X1(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 105) {
            if (ints != null && ints.length >= 2) {
                mBlower_Time = ints;
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
                return;
            }
            return;
        }
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
