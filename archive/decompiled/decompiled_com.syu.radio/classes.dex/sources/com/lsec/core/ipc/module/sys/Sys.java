package com.lsec.core.ipc.module.sys;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Sys extends IModuleCallback.Stub implements IConnStateListener {
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Sys INSTANCE = new Sys();
    public static int simCardState = 0;
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[10];

    public static Sys getInstance() {
        return INSTANCE;
    }

    private Sys() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(0));
            IModuleCallback callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
                return;
            }
            for (int i = 0; i < 10; i++) {
                PROXY.register(callback, i, 1);
            }
        } catch (Exception e) {
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
            if (this.updateCode >= 0 && this.updateCode < 10) {
                if (IpcUtil.intsOk(this.ints, 1) && Sys.DATA[this.updateCode] != this.ints[0]) {
                    Sys.DATA[this.updateCode] = this.ints[0];
                }
                Sys.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
