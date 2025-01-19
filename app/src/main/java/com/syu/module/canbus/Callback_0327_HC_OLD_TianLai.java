package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0327_HC_TianLai;
import com.syu.ui.door.DoorHelper;

public class Callback_0327_HC_OLD_TianLai extends CallbackCanbusBase {
    public static final int U_CARINFO_OIL = 121;
    public static final int U_CARSET_BEGIN = 107;
    public static final int U_CARSET_DX30_D0_B02 = 110;
    public static final int U_CARSET_DX30_D0_B04 = 109;
    public static final int U_CARSET_DX30_D0_B65 = 108;
    public static final int U_CARSET_DX30_D1_B30 = 112;
    public static final int U_CARSET_DX30_D1_B76 = 111;
    public static final int U_CARSET_DX30_D2_B01 = 118;
    public static final int U_CARSET_DX30_D2_B05 = 115;
    public static final int U_CARSET_DX30_D2_B06 = 114;
    public static final int U_CARSET_DX30_D2_B07 = 113;
    public static final int U_CARSET_DX30_D2_B21 = 117;
    public static final int U_CARSET_DX30_D2_B43 = 116;
    public static final int U_CD_BEGIN = 98;
    public static final int U_CD_CURRENT_DISC_TRACK = 101;
    public static final int U_CD_CURRENT_TIME = 102;
    public static final int U_CD_DISC_ID = 100;
    public static final int U_CD_DISC_RANDOM_STATE = 105;
    public static final int U_CD_DISC_REPEATE_STATE = 104;
    public static final int U_CD_DISC_STATE = 99;
    public static final int U_CD_DISC_WORK_STATE = 103;
    public static final int U_CD_END = 106;
    public static final int U_CNT_MAX = 122;
    public static final int U_CUR_SPEED = 119;
    public static final int U_ENGINE_SPEED = 120;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0327_HC_TianLai(LauncherApplication.getInstance()));
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
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
