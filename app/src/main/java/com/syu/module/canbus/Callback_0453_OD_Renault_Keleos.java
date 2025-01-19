package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0453_OD_Renault_Keleos extends CallbackCanbusBase {
    public static final int U_CARINF_DC0_ALL_STR = 98;
    public static final int U_CNT_MAX = 99;
    public static String XMName;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 99; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 99) {
            switch (updateCode) {
                case 98:
                    if (strs != null && strs.length > 0) {
                        XMName = strs[0];
                    } else {
                        XMName = "";
                    }
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
