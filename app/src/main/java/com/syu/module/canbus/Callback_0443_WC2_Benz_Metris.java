package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_19Sprinter;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Benz_Metris extends CallbackCanbusBase {
    public static String Title = null;
    public static final int U_CARINF_D9B_STR = 125;
    public static final int U_CARSET_BEGIN = 109;
    public static final int U_CARSET_D61_D0_B30 = 111;
    public static final int U_CARSET_D61_D0_B4 = 110;
    public static final int U_CARSET_D61_D0_B5 = 124;
    public static final int U_CARSET_D61_D1_B30 = 113;
    public static final int U_CARSET_D61_D1_B4 = 112;
    public static final int U_CARSET_D61_D2_B4 = 114;
    public static final int U_CARSET_D61_D3_B0 = 116;
    public static final int U_CARSET_D61_D3_B74 = 115;
    public static final int U_CARSET_D61_D4_B0 = 118;
    public static final int U_CARSET_D61_D4_B4 = 117;
    public static final int U_CARSET_D61_D5_B30 = 120;
    public static final int U_CARSET_D61_D5_B4 = 119;
    public static final int U_CARSET_D61_D6_B0 = 122;
    public static final int U_CARSET_D61_D6_B4 = 121;
    public static final int U_CARSET_D61_D7_B4 = 123;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CNT_MAX = 126;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_19Sprinter(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 126) {
            switch (updateCode) {
                case 125:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = null;
                    }
                    Log.v("zed", "U_CARINF_D9B_STR updateCode" + updateCode + "== Title == " + Title);
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
