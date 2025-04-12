package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.hc.volvo.IndexAct_Hc_volvo;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_HC_Volvo extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 99;
    public static final int U_JUMP_CARINFO = 98;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 99; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_HC_Volvo(LauncherApplication.getInstance()));
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

    private void convCarVideo(int updateCode, int[] ints) {
        if (updateCode == 98) {
            int value = ints[0];
            if (value == 1 && !IndexAct_Hc_volvo.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hc.volvo.IndexAct_Hc_volvo");
            } else if (IndexAct_Hc_volvo.mIsFront && IndexAct_Hc_volvo.mInstance != null) {
                IndexAct_Hc_volvo.mInstance.finish();
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 99) {
            switch (updateCode) {
                case 98:
                    convCarVideo(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
