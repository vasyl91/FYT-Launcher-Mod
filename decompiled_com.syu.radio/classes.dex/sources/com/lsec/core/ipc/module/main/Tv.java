package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Tv extends IModuleCallback.Stub implements IConnStateListener {
    public static final int CHANNEL_CNT_MAX = 256;
    public static int sChannelCnt;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Tv INSTANCE = new Tv();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[30];
    public static int[] CHANNEL_FREQ = new int[256];
    public static String[] CHANNEL_FREQ_STR = new String[256];

    public static Tv getInstance() {
        return INSTANCE;
    }

    private Tv() {
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void channelCnt(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && sChannelCnt != ints[0]) {
            if (ints[0] == 0) {
                sChannelCnt = ints[0];
            }
            if (ints[0] > 256) {
                ints[0] = 256;
            }
            while (sChannelCnt < ints[0]) {
                CHANNEL_FREQ[sChannelCnt] = PROXY.getI(0, sChannelCnt, 0);
                float freq = CHANNEL_FREQ[sChannelCnt] / 1000.0f;
                DecimalFormat df = new DecimalFormat("#.00");
                if (freq == 0.0f) {
                    CHANNEL_FREQ_STR[sChannelCnt] = "0.00";
                } else {
                    CHANNEL_FREQ_STR[sChannelCnt] = df.format(freq);
                }
                sChannelCnt++;
            }
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
            PROXY.setRemoteModule(toolkit.getRemoteModule(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        IModuleCallback callback = getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
            return;
        }
        for (int i = 0; i < 30; i++) {
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
            if (this.updateCode >= 0 && this.updateCode < 30) {
                switch (this.updateCode) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        Tv.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 4:
                        Tv.channelCnt(this.updateCode, this.ints, this.flts, this.strs);
                        Tv.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    default:
                        Tv.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
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
