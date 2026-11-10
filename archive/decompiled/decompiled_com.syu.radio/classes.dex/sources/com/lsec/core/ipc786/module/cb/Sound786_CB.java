package com.lsec.core.ipc786.module.cb;

import android.os.RemoteException;
import com.syu.ipc.ICallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Sound786_CB extends ICallback.Stub {
    private static Sound786_CB INSTANCE = new Sound786_CB();

    public static Sound786_CB getInstance() {
        return INSTANCE;
    }

    @Override // com.syu.ipc.ICallback
    public void update(int updateCode, int[] intData, float[] fltData, String[] strData) throws RemoteException {
    }
}
