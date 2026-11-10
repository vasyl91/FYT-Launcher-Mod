package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.data.FinalTpms;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Tpms extends IModuleCallback.Stub implements IConnStateListener {
    public static boolean isFirstConn;
    public static boolean isMTUSerialObdEnable;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static final Tpms INSTANCE = new Tpms();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static final ModuleProxy PROXY = new ModuleProxy();
    public static final int[] DATA = new int[FinalTpms.U_CNT_MAX];

    public static Tpms getInstance() {
        return INSTANCE;
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(8));
            IModuleCallback callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
            } else {
                PROXY.register(callback, 1, 1);
                PROXY.register(callback, 2, 1);
                PROXY.register(callback, 3, 1);
                PROXY.register(callback, 4, 1);
                PROXY.register(callback, 5, 1);
                PROXY.register(callback, 6, 1);
                PROXY.register(callback, 7, 1);
                PROXY.register(callback, 8, 1);
                PROXY.register(callback, 9, 1);
            }
            isFirstConn = true;
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
            if (this.updateCode >= 0 && this.updateCode < 20) {
                if (IpcUtil.intsOk(this.ints, 1)) {
                    Tpms.DATA[this.updateCode] = this.ints[0];
                }
                Tpms.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
