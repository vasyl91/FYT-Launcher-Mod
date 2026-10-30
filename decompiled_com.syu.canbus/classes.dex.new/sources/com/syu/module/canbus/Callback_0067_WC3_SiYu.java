package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0067_WC3_SiYu extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 107;
    public static final int U_COMPASS_STATUS = 106;
    public static final int U_CUR_SPEED = 98;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 107;
    public static final int U_PLAYER_MDI = 103;
    public static final int U_PLAYER_PROGRESS = 104;
    public static final int U_PLAYER_STATES = 105;
    public static final int U_PLAYER_TIME = 100;
    public static final int U_PLAYER_TOTAL_TRACK = 102;
    public static final int U_PLAYER_TRACK = 101;
    public static final int U_USB_TYPE = 99;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
