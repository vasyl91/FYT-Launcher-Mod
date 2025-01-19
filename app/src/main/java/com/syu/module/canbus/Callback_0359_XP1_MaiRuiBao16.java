package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0359_XP1_16mairuibao;
//import com.syu.ui.air.Air_0359_XP1_16mairuibao_low;
import com.syu.ui.door.DoorHelper;

public class Callback_0359_XP1_MaiRuiBao16 extends CallbackCanbusBase {
    public static final int U_CAR_COMPASS_ANGEL = 191;
    public static final int U_CAR_WIN_LF = 188;
    public static final int U_CAR_WIN_LR = 190;
    public static final int U_CAR_WIN_RF = 187;
    public static final int U_CAR_WIN_RR = 189;
    public static final int U_CNT_MAX = 192;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 192; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 131431 || DataCanbus.DATA[1000] == 65895) {
            //AirHelper.getInstance().buildUi(new Air_0359_XP1_16mairuibao(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0359_XP1_16mairuibao_low(LauncherApplication.getInstance()));
        }
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
        switch (updateCode) {
            case 115:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 192) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
