package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.rzc.biaozhi408.Const_RZC4_PSA_ALL_DATA;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0339_RZC4_PSA14_4008;
//import com.syu.ui.air.Air_0339_RZC4_PSA_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0339_RZC4_PSA_ALL extends CallbackCanbusBase {
    public static int mSum = -1;
    public static int mCurrPage = -1;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 237; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 65875) {
            //AirHelper.getInstance().buildUi(new Air_0339_RZC4_PSA14_4008(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[54].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        } else {
            //AirHelper.getInstance().buildUi(new Air_0339_RZC4_PSA_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 237) {
            if (updateCode == 115) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[115];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 225) {
                if (strs != null && strs.length > 0) {
                    Const_RZC4_PSA_ALL_DATA.RadioText = strs[0];
                } else {
                    Const_RZC4_PSA_ALL_DATA.RadioText = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
