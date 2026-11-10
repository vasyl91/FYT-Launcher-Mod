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
public class Steer extends IModuleCallback.Stub implements IConnStateListener {
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Steer INSTANCE = new Steer();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[20];
    public static int[] mCurrentAdcs = new int[50];
    public static int[] mCurrentVal = new int[10];

    public static Steer getInstance() {
        return INSTANCE;
    }

    private Steer() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(10));
            IModuleCallback callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
                return;
            }
            for (int i = 0; i < 20; i++) {
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
            if (this.updateCode >= 0 && this.updateCode < 20) {
                if (this.updateCode == 1) {
                    if (IpcUtil.intsOk(this.ints, 2) && this.ints[0] < Steer.mCurrentAdcs.length) {
                        Steer.mCurrentAdcs[this.ints[0]] = this.ints[1];
                    }
                } else if (this.updateCode == 3) {
                    if (IpcUtil.intsOk(this.ints, 2) && this.ints[0] < Steer.mCurrentVal.length) {
                        Steer.mCurrentVal[this.ints[0]] = this.ints[1];
                    }
                } else if (IpcUtil.intsOk(this.ints, 1)) {
                    Steer.DATA[this.updateCode] = this.ints[0];
                }
                Steer.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
