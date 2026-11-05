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
public class Sound extends IModuleCallback.Stub implements IConnStateListener {
    public static int mFieldX;
    public static int mFieldY;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Sound INSTANCE = new Sound();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[250];
    public static int[] mBarVals = new int[36];
    public static int[] SB = new int[48];
    public static int[] mSpectrum = new int[7];

    public static Sound getInstance() {
        return INSTANCE;
    }

    private Sound() {
    }

    public static int getSpectrumValue() {
        if (DATA[2] <= 0 || DATA[3] != 0) {
            return 0;
        }
        return mSpectrum[2] * mSpectrum[2];
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void sb(int updateCode, int[] ints, float[] flts, String[] strs) {
        int index;
        if (IpcUtil.intsOk(ints, 2) && (index = ints[0]) >= 0 && index < 48 && SB[index] != ints[1]) {
            SB[index] = ints[1];
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
            PROXY.setRemoteModule(toolkit.getRemoteModule(4));
            IModuleCallback callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
                return;
            }
            for (int i = 0; i < 250; i++) {
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
            if (this.updateCode >= 0 && this.updateCode < 250) {
                switch (this.updateCode) {
                    case 0:
                        if (IpcUtil.intsOk(this.ints, 7)) {
                            Sound.mSpectrum = this.ints;
                        }
                        break;
                    case 1:
                    case 4:
                    case 5:
                    case 6:
                    case 11:
                    default:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            Sound.DATA[this.updateCode] = this.ints[0];
                        }
                        Sound.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 2:
                    case 3:
                    case 7:
                    case 10:
                        Sound.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 8:
                        if (IpcUtil.intsOk(this.ints, 2)) {
                            if (Sound.mFieldX != this.ints[0] || Sound.mFieldY != this.ints[1]) {
                                Sound.mFieldX = this.ints[0];
                                Sound.mFieldY = this.ints[1];
                                Sound.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                            }
                        }
                        break;
                    case 9:
                        if (IpcUtil.intsOk(this.ints, 2)) {
                            if (this.ints[0] < Sound.mBarVals.length) {
                                Sound.mBarVals[this.ints[0]] = this.ints[1];
                            }
                            Sound.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        }
                        break;
                    case 12:
                        if (IpcUtil.intsOk(this.ints, 2)) {
                            Sound.sb(this.updateCode, this.ints, this.flts, this.strs);
                        }
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
