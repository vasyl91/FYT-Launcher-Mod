package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.biaozhi408.BZ408AirControlActi;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0122_WC2_408_14 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 167;
    public static final int U_SHOW_AIR_KEY = 166;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 167; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0122_WC2_408_14(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 167) {
            if (updateCode == 115) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[115];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 166) {
                if (ints[0] == 1 && !BZ408AirControlActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408AirControlActi");
                    return;
                } else {
                    if (ints[0] == 1 && BZ408AirControlActi.mIsFront && BZ408AirControlActi.mInstance != null) {
                        BZ408AirControlActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
