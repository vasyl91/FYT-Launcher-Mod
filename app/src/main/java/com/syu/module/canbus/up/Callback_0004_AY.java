package com.syu.module.canbus.up;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0004_AY extends CallbackCanUpBase {
    public static final int C_UP_FILE_PATH = 0;
    public static final int UPGRADE_TIP_IAP_DATA_END = 4;
    public static final int UPGRADE_TIP_IAP_END = 5;
    public static final int UPGRADE_TIP_IAP_ERROR = 6;
    public static final int UPGRADE_TIP_IAP_PROGRESS = 3;
    public static final int UPGRADE_TIP_IAP_START = 2;
    public static final int UPGRADE_TIP_READ_FILE_ERROR = 0;
    public static final int UPGRADE_TIP_REQUEST_UPGRADE = 1;
    public static final int U_UPGRADE_TIP = 0;
    public int mBlockCnt;
    public int mBlockIndex;

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 0:
                if (ints != null && ints.length >= 1) {
                    DataCanUp.DATA[updateCode] = ints[0];
                    if (ints[0] == 3) {
                        this.mBlockIndex = ints[1];
                        this.mBlockCnt = ints[2];
                    }
                    DataCanUp.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
        }
    }

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanUpProxy.getInstance();
        for (int i = 0; i < 1; i++) {
            DataCanUp.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }
}
