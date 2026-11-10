package com.lsec.core.ipc.module.sys;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Locate extends IModuleCallback.Stub implements IConnStateListener {
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Locate INSTANCE = new Locate();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[10];
    public static String mCity = FinalChip.BSP_PLATFORM_Null;

    public static Locate getInstance() {
        return INSTANCE;
    }

    private Locate() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        IModuleCallback callback = getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
            return;
        }
        for (int i = 0; i < 10; i++) {
            PROXY.register(callback, i, 1);
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
                if (IpcUtil.intsOk(this.ints, 1)) {
                    Locate.DATA[this.updateCode] = this.ints[0];
                }
                if (this.updateCode == 0 && IpcUtil.strsOk(this.strs, 1)) {
                    Locate.mCity = this.strs[0];
                }
                Locate.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
