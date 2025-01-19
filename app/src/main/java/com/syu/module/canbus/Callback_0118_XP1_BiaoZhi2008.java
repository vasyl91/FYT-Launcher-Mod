package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

public class Callback_0118_XP1_BiaoZhi2008 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 166;
    public static int mSum = -1;
    public static int mCurrPage = -1;
    public static String mCarId = null;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 166; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 166) {
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
            if (updateCode == 165) {
                if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(mCarId, strs[0])) {
                    mCarId = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
