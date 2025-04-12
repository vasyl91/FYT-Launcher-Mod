package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OUDI_Dongnan_all;

public class Callback_0452_Oudi_Dongnan_All extends CallbackCanbusBase {
    public static final int U_CARINF_AIRCLEAR_LEV = 100;
    public static final int U_CARINF_AIR_WARN_LEV = 101;
    public static final int U_CARINF_BEGIN = 97;
    public static final int U_CARINF_PM25_VALUE = 98;
    public static final int U_CARINF_PM25_WARN_LEV = 99;
    public static final int U_CNT_MAX = 102;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 102; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0452_OUDI_Dongnan_all(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 102) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
