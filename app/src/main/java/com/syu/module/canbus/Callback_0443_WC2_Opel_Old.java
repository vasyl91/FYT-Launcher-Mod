package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Opel_Old extends CallbackCanbusBase {
    public static String ListStr1 = "";
    public static String ListStr2 = "";
    public static String ListStr3 = "";
    public static final int U_CARINF_D19_D0_D1 = 101;
    public static final int U_CARINF_D19_D2_D3 = 102;
    public static final int U_CARINF_D19_D4_D5 = 103;
    public static final int U_CARINF_D19_D6_D7 = 104;
    public static final int U_CARINF_D19_D8_B70 = 105;
    public static final int U_CARINF_D19_D9_D10 = 106;
    public static final int U_CARINF_D9A_ALL = 98;
    public static final int U_CARINF_D9B_ALL = 99;
    public static final int U_CARINF_D9C_ALL = 100;
    public static final int U_CNT_MAX = 107;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_Opel_Old(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 107) {
            if (updateCode == 98) {
                if (strs != null && strs.length > 0) {
                    ListStr1 = strs[0];
                } else {
                    ListStr1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 99) {
                if (strs != null && strs.length > 0) {
                    ListStr2 = strs[0];
                } else {
                    ListStr2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            if (updateCode == 100) {
                if (strs != null && strs.length > 0) {
                    ListStr3 = strs[0];
                } else {
                    ListStr3 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
