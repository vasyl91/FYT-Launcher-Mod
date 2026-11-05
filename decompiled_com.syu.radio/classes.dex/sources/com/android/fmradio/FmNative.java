package com.android.fmradio;

import com.lsec.core.ipc.module.main.Main;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FmNative {
    public static final int FMJNI_CMD_10_SETMONOSTERO = 10;
    public static final int FMJNI_CMD_11_GETRSSI = 11;
    public static final int FMJNI_CMD_12_PRESEARCH = 12;
    public static final int FMJNI_CMD_13_RESTORESEARCH = 13;
    public static final int FMJNI_CMD_14_DENSENSEDETECT = 14;
    public static final int FMJNI_CMD_15_ANASWITCH = 15;
    public static final int FMJNI_CMD_16_SMTUNE = 16;
    public static final int FMJNI_CMD_17_GETFMTTYPE = 17;
    public static final int FMJNI_CMD_18_CURRENTFREQ = 18;
    public static final int FMJNI_CMD_19_GET_STMN_STATUS = 19;
    public static final int FMJNI_CMD_1_AUTOSCAN = 1;
    public static final int FMJNI_CMD_20_SETGET_AREA = 20;
    public static final int FMJNI_CMD_21_RDSONOFF = 21;
    public static final int FMJNI_CMD_22_GETRDSONOFF = 22;
    public static final int FMJNI_CMD_23_RDSTACONFIG = 23;
    public static final int FMJNI_CMD_24_RDSAFCONFIG = 24;
    public static final int FMJNI_CMD_25_RDSPTYCONFIG = 25;
    public static final int FMJNI_CMD_26_GETRDSCONFIG = 26;
    public static final int FMJNI_CMD_27_GETRDSSTATE = 27;
    public static final int FMJNI_CMD_28_RDSTASEEK = 28;
    public static final int FMJNI_CMD_29_RDSPTYSEEK = 29;
    public static final int FMJNI_CMD_2_OPENDEV = 2;
    public static final int FMJNI_CMD_30_RDSGETPS = 30;
    public static final int FMJNI_CMD_31_RDSGETTEXT = 31;
    public static final int FMJNI_CMD_32_RDSGETFREQPS = 32;
    public static final int FMJNI_CMD_33_OIRTFREQCHECK = 33;
    public static final int FMJNI_CMD_3_CLOSEDEV = 3;
    public static final int FMJNI_CMD_4_POWERUP = 4;
    public static final int FMJNI_CMD_5_POWERDOWN = 5;
    public static final int FMJNI_CMD_6_SEEK = 6;
    public static final int FMJNI_CMD_7_TUNE = 7;
    public static final int FMJNI_CMD_8_SETMUTE = 8;
    public static final int FMJNI_CMD_9_GETMONOSTERO = 9;
    public static FmNative INSTANCE = null;
    public Runnable mRunnableInitPara = new Runnable() { // from class: com.android.fmradio.FmNative.1
        @Override // java.lang.Runnable
        public void run() {
            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                interfaceRadio.initPara();
            }
        }
    };

    private native short[] autoScan(int i);

    private native boolean closeDev();

    private native int fmsyu_jni(int i, Object obj, Object obj2);

    private native int getmonostero(int i);

    private native boolean openDev();

    private native boolean powerDown(int i);

    private native boolean powerUp(float f);

    private native float[] seek(float f, boolean z);

    private native int setMute(boolean z);

    private native int setconfig(String str);

    private native int setmonostero(int i);

    private native int sqlautoScan(int i, short[] sArr, short[] sArr2);

    private native boolean stopScan();

    private native int switchAntenna(int i);

    private native boolean tune(float f);

    native short activeAf();

    native byte[] getLrText();

    native byte[] getPs();

    native int isRdsSupport();

    native short readRds();

    native int setRds(boolean z);

    private FmNative() {
        System.loadLibrary("fmjni");
    }

    public static FmNative getInstance() {
        try {
            if (INSTANCE == null) {
                INSTANCE = new FmNative();
            }
        } catch (Throwable th) {
            INSTANCE = null;
        }
        return INSTANCE;
    }

    public boolean test_powerUp(float frequency) {
        if (openDev() && powerUp(frequency)) {
            Main.postRunnable_Ui(true, this.mRunnableInitPara);
            return true;
        }
        closeDev();
        return false;
    }

    public boolean test_powerDown(int type) {
        return powerDown(type) && closeDev();
    }

    public boolean test_tune(float frequency) {
        return tune(frequency);
    }

    public boolean test_stopScan() {
        FmUtils.mStopScan = true;
        return stopScan();
    }

    public int test_setMute(boolean mute) {
        return setMute(mute);
    }

    public int test_fmsyu_jni(int type, Object inparam, Object outparam) {
        return fmsyu_jni(type, inparam, outparam);
    }
}
