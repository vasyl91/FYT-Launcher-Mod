package com.pekall.fmradio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.syu.radio.App_Radio;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FMRadioNativeInterface {
    public static final int FMRADIO_SEEK_BACKWARD = 0;
    public static final int FMRADIO_SEEK_FORWARD = 1;
    public static FMRadioNativeInterface INSTANCE;
    private Handler mEventHandler;
    private int mNativeContext;
    public OnCmdDoneListener mOnCmdDoneListener;

    private native void fmradio_native_finalize();

    public native void fmradio_native_setup(Object obj);

    public native boolean nativeCloseFMRadio();

    public native boolean nativeDisableRds();

    public native boolean nativeEnableRds();

    public native boolean nativeGetFMAudioMode();

    public native boolean nativeGetFMBand();

    public native boolean nativeGetFMFreq();

    public native boolean nativeGetFMRssiLevel();

    public native boolean nativeGetFMVolume();

    public native boolean nativeIsMuteFM();

    public native boolean nativeOpenFMRadio();

    public native boolean nativeOpenFMRadioTx();

    public native boolean nativePowerOffChip();

    public native boolean nativePowerOnChip();

    public native boolean nativeSeekFM(int i, int i2);

    public native boolean nativeSetAntenna(int i);

    public native boolean nativeSetEmphasisFilter(int i);

    public native boolean nativeSetFMAudioMode(int i);

    public native boolean nativeSetFMBand(int i);

    public native boolean nativeSetFMChannel(int i);

    public native boolean nativeSetFMFreq(int i);

    public native boolean nativeSetFMMute(int i);

    public native boolean nativeSetFMRssiThreshold(int i);

    public native boolean nativeSetFMVolume(int i);

    public native boolean nativeSetRdsCallback(int i);

    public native boolean nativeStopSeekFM();

    public native int nativefmsyu_jni(int i, Object obj, Object obj2);

    static {
        System.loadLibrary("fm_jni");
        INSTANCE = null;
    }

    public static FMRadioNativeInterface getInstance() {
        try {
            if (INSTANCE == null) {
                INSTANCE = new FMRadioNativeInterface();
            }
        } catch (Throwable th) {
            INSTANCE = null;
        }
        return INSTANCE;
    }

    public FMRadioNativeInterface() {
        Looper looper = Looper.myLooper();
        if (looper != null) {
            this.mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looper2 = Looper.getMainLooper();
            if (looper2 != null) {
                this.mEventHandler = new EventHandler(this, looper2);
            } else {
                this.mEventHandler = null;
            }
        }
        fmradio_native_setup(new WeakReference(this));
    }

    public boolean powerOnChip() {
        return nativePowerOnChip();
    }

    public boolean powerOffChip() {
        return nativePowerOffChip();
    }

    public boolean openFMRadio() {
        return nativeOpenFMRadio();
    }

    public boolean closeFMRadio() {
        return nativeCloseFMRadio();
    }

    public boolean openFMRadioTx() {
        return nativeOpenFMRadioTx();
    }

    public boolean isMuteFM() {
        return nativeIsMuteFM();
    }

    public boolean setFMMute(int mode) {
        return nativeSetFMMute(mode);
    }

    public boolean getFMFreq() {
        return nativeGetFMFreq();
    }

    public boolean setFMFreq(int freq) {
        return nativeSetFMFreq(freq);
    }

    public boolean setRdsCallback(int start) {
        return nativeSetRdsCallback(start);
    }

    public boolean seekFM(int startFreq, int direction) {
        return nativeSeekFM(startFreq, direction);
    }

    public boolean stopSeekFM() {
        return nativeStopSeekFM();
    }

    public boolean getFMVolume() {
        return nativeGetFMVolume();
    }

    public boolean setFMVolume(int volume) {
        return nativeSetFMVolume(volume);
    }

    public boolean getFMAudioMode() {
        return nativeGetFMAudioMode();
    }

    public boolean setFMAudioMode(int mode) {
        return nativeSetFMAudioMode(mode);
    }

    public boolean getFMRssiLevel() {
        return nativeGetFMRssiLevel();
    }

    public boolean setFMRssiThreshold(int threshold) {
        return nativeSetFMRssiThreshold(threshold);
    }

    public boolean enableRds() {
        return nativeEnableRds();
    }

    public boolean disableRds() {
        return nativeDisableRds();
    }

    public boolean setAntenna(int type) {
        return nativeSetAntenna(type);
    }

    public void destroy() {
        fmradio_native_finalize();
    }

    public int fmsyu_jni(int type, Object inparam, Object outparam) {
        return nativefmsyu_jni(type, inparam, outparam);
    }

    private static void postEventFromNative(Object fmradio_ref, int cmdid, int cmdresult, int fmstatus, int fmvalue) {
        FMRadioNativeInterface fmsystem = (FMRadioNativeInterface) ((WeakReference) fmradio_ref).get();
        if (fmsystem != null && fmsystem.mEventHandler != null) {
            Message msg = fmsystem.mEventHandler.obtainMessage(cmdresult, cmdid, fmstatus, Integer.valueOf(fmvalue));
            fmsystem.mEventHandler.sendMessage(msg);
        }
    }

    private static void postRdsStringFromNative(Object fmradio_ref, byte[] rds, int type) {
        FMRadioNativeInterface fmsystem = (FMRadioNativeInterface) ((WeakReference) fmradio_ref).get();
        if (fmsystem != null && fmsystem.mEventHandler != null && rds != null) {
            Message msg = fmsystem.mEventHandler.obtainMessage(2, 20, type, rds);
            fmsystem.mEventHandler.sendMessage(msg);
        }
    }

    private static void postRdsRawDataFromNative(Object fmradio_ref, byte[] raw, int len) {
        FMRadioNativeInterface fmsystem = (FMRadioNativeInterface) ((WeakReference) fmradio_ref).get();
        if (raw != null && fmsystem != null && fmsystem.mEventHandler != null) {
            Message msg = fmsystem.mEventHandler.obtainMessage(3, 22, len, raw);
            fmsystem.mEventHandler.sendMessage(msg);
        }
    }

    private static class EventHandler extends Handler {
        private static final int FM_EVENT_CMD_DONE = 0;
        private static final int FM_EVENT_CMD_RDS_RAW_DATA = 3;
        private static final int FM_EVENT_CMD_RDS_STRING = 2;
        private FMRadioNativeInterface mFMRadioSystem;

        public EventHandler(FMRadioNativeInterface fm, Looper looper) {
            super(looper);
            this.mFMRadioSystem = fm;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (App_Radio.getInstance().mIpcObj.isRightAppId()) {
                if (this.mFMRadioSystem.mNativeContext != 0 && this.mFMRadioSystem.mOnCmdDoneListener != null) {
                    switch (msg.what) {
                        case 0:
                        case 2:
                        case 3:
                            this.mFMRadioSystem.mOnCmdDoneListener.onCmdDone(msg.arg1, msg.arg2, msg.obj);
                            break;
                    }
                }
                return;
            }
            removeCallbacksAndMessages(null);
        }
    }

    public void setResultHandler(Handler handler) {
        this.mEventHandler = handler;
    }

    public int test_fmsyu_jni(int type, Object inparam, Object outparam) {
        return fmsyu_jni(type, inparam, outparam);
    }
}
