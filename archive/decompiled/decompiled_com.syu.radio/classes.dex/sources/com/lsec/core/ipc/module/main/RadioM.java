package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.data.AutoKeyEvent;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class RadioM extends IModuleCallback.Stub implements IConnStateListener {
    public static final int FREQ_AM_CNT = 12;
    public static final int FREQ_FM_CNT = 18;
    public static int sFreqMax;
    public static int sFreqMin;
    public static int sFreqStepCnt;
    public static int sFreqStepLen;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static RadioM INSTANCE = new RadioM();
    public static String sPsText = FinalChip.BSP_PLATFORM_Null;
    public static String sRdsText = FinalChip.BSP_PLATFORM_Null;
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[100];
    public static int[] FREQ_AM = new int[12];
    public static int[] FREQ_FM = new int[18];
    public static String[] FREQ_AM_TEXT = new String[12];
    public static String[] FREQ_FM_TEXT = new String[18];
    public static int mMinFm1 = 6500;
    public static int mMaxFm1 = 7400;
    public static int mStepFm1 = 3;
    public static int mMinFm2 = 8750;
    public static int mMaxFm2 = 10800;
    public static int mStepFm2 = 10;
    public static int[] mMinAm = {AutoKeyEvent.KEYCODE_CAR_INFO, AutoKeyEvent.KEYCODE_DVR, AutoKeyEvent.KEYCODE_GUIDE, AutoKeyEvent.KEYCODE_GUIDE, AutoKeyEvent.KEYCODE_GUIDE};
    public static int[] mMaxAm = {1720, 1620, 1620, 1620, 1629};
    public static int[] mStepAm = {10, 10, 9, 9, 9};
    public static int[] mTotalAm = {119, 110, 122, 122, 123};
    public static int[] mMinFm = {8750, 8750, 8750, mMinFm1, 7600};
    public static int[] mMaxFm = {10790, 10800, 10800, mMaxFm1, 9000};
    public static int[] mStepFm = {20, 5, 5, mStepFm1, 10};
    public static int[] mTotalFm = {102, 410, 410, 300, 140};
    public static final String[] PTY_Display = {" NO PTY ", "  News  ", "Affairs ", "  Info  ", " Sport  ", "Educate ", " Drama  ", "Culture ", "Science ", " Varied ", " Pop M  ", " Rock M ", " Easy M ", "Light M ", "Classics", "Other M ", "Weather ", "Finance ", "Children", " Social ", "Religion", "Phone In", " Travel ", "Leisure ", "  Jazz  ", "Country ", "Nation M", " Oldies ", " Folk M ", "Document", "  Test  ", " Alarm  ", "PTY Seek", "        ", " TA ON  ", " TA OFF ", " TA SEEK", " AF ON  ", " AF OFF ", " AF SEEK", "PTY SEEK"};

    public static RadioM getInstance() {
        return INSTANCE;
    }

    private RadioM() {
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void psText(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            sPsText = strs[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void rdsText(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            sRdsText = strs[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void extraFreqInfo(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 4)) {
            sFreqMin = ints[0];
            sFreqMax = ints[1];
            sFreqStepLen = ints[2];
            sFreqStepCnt = ints[3];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void channelFreq(int updateCode, int[] ints, float[] flts, String[] strs) {
        int indexAm;
        if (IpcUtil.intsOk(ints, 2)) {
            int channel = ints[0];
            int freq = ints[1];
            if (channel >= 65536 && channel <= 131072) {
                int indexFm = channel - 65536;
                if (indexFm < 18 && FREQ_FM[indexFm] != freq) {
                    FREQ_FM[indexFm] = freq;
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (channel >= 0 && channel <= 65536 && (indexAm = channel + 0) < 12 && FREQ_AM[indexAm] != freq) {
                FREQ_AM[indexAm] = freq;
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void channelText(int updateCode, int[] ints, float[] flts, String[] strs) {
        int indexAm;
        if (IpcUtil.intsOk(ints, 1) && IpcUtil.strsOk(strs, 1)) {
            int channel = ints[0];
            String strChannel = strs[0];
            if (strChannel != null) {
                if (channel >= 65536 && channel <= 131072) {
                    int indexFm = channel - 65536;
                    if (indexFm < 18 && !strChannel.equals(FREQ_FM_TEXT[indexFm])) {
                        FREQ_FM_TEXT[indexFm] = strChannel;
                        mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                        return;
                    }
                    return;
                }
                if (channel >= 0 && channel <= 65536 && (indexAm = channel + 0) < 12 && !strChannel.equals(FREQ_AM_TEXT[indexAm])) {
                    FREQ_AM_TEXT[indexAm] = strChannel;
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                }
            }
        }
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
        RadioM callback = getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
            return;
        }
        for (int i = 0; i < 100; i++) {
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
            if (this.updateCode >= 0 && this.updateCode < 100) {
                switch (this.updateCode) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 15:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        RadioM.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 4:
                        RadioM.channelFreq(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 24:
                    case 25:
                    default:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            RadioM.DATA[this.updateCode] = this.ints[0];
                        }
                        RadioM.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 13:
                        RadioM.rdsText(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 14:
                        RadioM.channelText(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 16:
                        RadioM.extraFreqInfo(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 26:
                        RadioM.psText(this.updateCode, this.ints, this.flts, this.strs);
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
