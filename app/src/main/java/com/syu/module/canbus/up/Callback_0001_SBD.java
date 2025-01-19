package com.syu.module.canbus.up;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0001_SBD extends CallbackCanUpBase {
    public static final int C_UP_FILE_PATH = 0;
    public static final int UPDATA_ERROR_LARGE = 6;
    public static final int UPDATA_ERROR_UNMATE = 5;
    public static final int UPDATA_FAILED = 4;
    public static final int UPDATA_ING = 2;
    public static final int UPDATA_START = 1;
    public static final int UPDATA_SUCCESS = 3;
    public static final int U_TIP_PROGRESS_CURR = 0;
    public static final int U_TIP_PROGRESS_TOTAL = 1;
    public static final int U_TIP_RESULT = 2;

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 3) {
            HandleCanUp.update(updateCode, ints);
        }
    }

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanUpProxy.getInstance();
        for (int i = 0; i < 3; i++) {
            DataCanUp.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }
}
