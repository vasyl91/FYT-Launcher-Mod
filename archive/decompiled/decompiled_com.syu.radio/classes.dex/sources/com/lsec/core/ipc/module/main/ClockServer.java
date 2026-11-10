package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ClockServer extends IModuleCallback.Stub implements IConnStateListener {
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static ClockServer INSTANCE = new ClockServer();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[2];

    private ClockServer() {
    }

    public static ClockServer getInstance() {
        return INSTANCE;
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            if (DATA[updateCode] != ints[0]) {
                DATA[updateCode] = ints[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                return;
            }
            return;
        }
        mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(0));
            ClockServer callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
                return;
            }
            for (int i = 1; i < 2; i++) {
                PROXY.register(callback, i, 1);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onDisconnected() {
        PROXY.setRemoteModule(null);
    }

    private class Runnable_Update implements Runnable {
        public float[] flts;
        public int[] ints;
        public String[] strs;
        public int updateCode;

        public Runnable_Update(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.updateCode = updateCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.updateCode >= 0 && this.updateCode < 2) {
                ClockServer.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
