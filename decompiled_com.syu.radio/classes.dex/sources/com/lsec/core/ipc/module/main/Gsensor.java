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
public class Gsensor extends IModuleCallback.Stub implements IConnStateListener {
    public static final int U_GSENSOR_ON = 3;
    public static final int U_LOCK_RECORD = 1;
    public static final int U_SLEEP_30S_COLLIDE_RECORD = 8;
    public static final int U_SLEEP_STOP_RECORD = 2;
    public static final int U_STANDBY_COLLIDE_SCREENON = 7;
    public static final int U_STANDBY_RECORD_TIME = 6;
    public static final int U_STANDBY_SENSITIVITY = 5;
    public static final int U_WORK_SENSITIVITY = 4;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Gsensor INSTANCE = new Gsensor();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static final ModuleProxy PROXY = new ModuleProxy();
    public static final int[] DATA = new int[20];

    public static Gsensor getInstance() {
        return INSTANCE;
    }

    private Gsensor() {
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(17));
            Gsensor callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
                return;
            }
            for (int i = 0; i < 20; i++) {
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
            if (this.updateCode >= 0 && this.updateCode < 20) {
                switch (this.updateCode) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 12:
                    case 13:
                    case 14:
                        Gsensor.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                }
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
