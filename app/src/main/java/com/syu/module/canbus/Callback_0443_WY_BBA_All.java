package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WY_BBA_All extends CallbackCanbusBase {
    public static final int U_CARINF_D12_D2_B70 = 116;
    public static final int U_CARINF_D12_D5_B70 = 109;
    public static final int U_CARINF_D12_D6_B54 = 111;
    public static final int U_CARINF_D12_D6_B76 = 110;
    public static final int U_CARINF_D47_D0_B70 = 112;
    public static final int U_CARSET_AUX_CH_CHANGE = 117;
    public static final int U_CARSET_BACKCAR_TYPE = 113;
    public static final int U_CARSET_CARUI_ONOFF = 115;
    public static final int U_CARSET_D1_D0_B6 = 118;
    public static final int U_CARSET_D1_D0_B7 = 119;
    public static final int U_CARSET_SPLIT_ONOFF = 114;
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
    public static final int U_CNT_MAX = 120;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
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
        if (DataCanbus.DATA[1000] == 2818492) {
            //AirHelper.getInstance().buildUi(new Air_0444_wy_audi_q4(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0443_WY_BBA_All(LauncherApplication.getInstance()));
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
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
