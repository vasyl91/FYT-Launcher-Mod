package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0271_DJ_BenTeng14B70;
import com.syu.ui.door.DoorHelper;

public class Callback_0271_DJ_BENGTENG14B70 extends CallbackCanbusBase {
    public static final int U_CAT_BT_CONNECT_STATE = 99;
    public static final int U_CAT_BT_NUMBER = 100;
    public static final int U_CAT_BT_STATE = 98;
    public static final int U_CNT_MAX = 102;
    public static final int U_SHOW_AIR_KEY = 101;
    public static String btNumber;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 102; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0271_DJ_BenTeng14B70(LauncherApplication.getInstance()));
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
            case 100:
                if (strs != null && strs.length > 0) {
                    btNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 101:
                if (ints[0] == 1 && !Air_Activity_All_NewAdd_HP.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                    break;
                } else if (ints[0] == 1 && Air_Activity_All_NewAdd_HP.mIsFront && Air_Activity_All_NewAdd_HP.mInstance != null) {
                    Air_Activity_All_NewAdd_HP.mInstance.finish();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 102) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
