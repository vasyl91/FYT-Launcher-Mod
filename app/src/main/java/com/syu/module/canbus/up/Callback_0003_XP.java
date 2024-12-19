package com.syu.module.canbus.up;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0003_XP extends CallbackCanUpBase {
    public static final int C_UP_FILE_PATH = 0;
    public static final int UPDATA_ERROR_CRC = 7;
    public static final int UPDATA_ERROR_LARGE = 6;
    public static final int UPDATA_ERROR_UNMATE = 5;
    public static final int UPDATA_FAILED = 4;
    public static final int UPDATA_FILE_ERROR = 8;
    public static final int UPDATA_ING = 2;
    public static final int UPDATA_START = 1;
    public static final int UPDATA_SUCCESS = 3;
    public static final int U_TIP_PROGRESS_CURR = 0;
    public static final int U_TIP_PROGRESS_TOTAL = 1;
    public static final int U_TIP_RESULT = 2;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 120) {
            HandleCanUp.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.up.CallbackCanUpBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanUpProxy.getInstance();
        for (int i = 0; i < 120; i++) {
            DataCanUp.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.up.CallbackCanUpBase
    public void out() {
    }
}
