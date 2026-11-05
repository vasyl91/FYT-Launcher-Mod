package com.android.fmradio;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDevicePort;
import android.media.AudioManager;
import android.media.AudioMixPort;
import android.media.AudioPatch;
import android.media.AudioPort;
import android.media.AudioPortConfig;
import android.media.AudioSystem;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FmService extends Service {
    public static final int DURING_POWER_UP = 1;
    private static final String FM_FREQUENCY = "frequency";
    private static final String FM_SEEK_NEXT = "fmradio.seek.next";
    private static final String FM_SEEK_PREVIOUS = "fmradio.seek.previous";
    private static final String OPTION = "option";
    public static final int POWER_DOWN = 2;
    public static final int POWER_UP = 0;
    private static final String SOUND_POWER_DOWN_MSG = "com.android.music.musicservicecommand";
    private FmRadioServiceHandler mFmServiceHandler;
    public static boolean mAutoSensitivity = true;
    public static boolean mLocFm = false;
    public static int mFmSenstivity = 22;
    public static int mAmSenstivity = 22;
    public static int mPtyConf = -1;
    public static int mTaOnVisibility = 0;
    public static int mAfOnVisibility = 0;
    static RunnableRefreshSearchFreq mRunnableRefreshSearchFreq = new RunnableRefreshSearchFreq();
    private boolean mIsNativeScanning = false;
    private boolean mIsScanning = false;
    private boolean mIsNativeSeeking = false;
    public int mPowerStatus = 2;
    private boolean mIsServiceInited = false;
    private Context mContext = null;
    public AudioManager mAudioManager = null;
    private final IBinder mBinder = new ServiceBinder();
    private FmServiceBroadcastReceiver mBroadcastReceiver = null;
    private Object mAudioPatch = null;
    private Object mRenderLock = new Object();
    AudioDevicePort mAudioSource = null;
    AudioDevicePort mAudioSink = null;
    public Runnable mRunnableStartCheckSt = new Runnable() { // from class: com.android.fmradio.FmService.1
        @Override // java.lang.Runnable
        public void run() {
            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                interfaceRadio.startCheckSt();
            }
        }
    };
    RunnableHandleScanFinish mRunnableHandleScanFinish = null;

    public interface OnExitListener {
        void onExit();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public class ServiceBinder extends Binder {
        public ServiceBinder() {
        }

        public FmService getService() {
            return FmService.this;
        }
    }

    private class FmServiceBroadcastReceiver extends BroadcastReceiver {
        private FmServiceBroadcastReceiver() {
        }

        /* synthetic */ FmServiceBroadcastReceiver(FmService fmService, FmServiceBroadcastReceiver fmServiceBroadcastReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.media.VOLUME_CHANGED_ACTION".equals(action) && !FmService.this.isScanning() && Main.mConf_PlatForm != 8 && intent.hasExtra("android.media.EXTRA_VOLUME_STREAM_TYPE") && intent.hasExtra("android.media.EXTRA_VOLUME_STREAM_VALUE")) {
                int streamType = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
                if (streamType == 10) {
                    int index = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
                    if (index != -1) {
                        FmService.this.setVolume(15);
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public boolean isBluetoothHeadsetInUse() {
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        int a2dpState = btAdapter.getProfileConnectionState(1);
        return 2 == a2dpState || 1 == a2dpState;
    }

    private synchronized void startRender() {
        switch (Main.mConf_PlatForm) {
            case 8:
                if (App_Radio.iRadioType_Arm != 2) {
                }
            default:
                AudioSystem.setDeviceConnectionState(App_Radio.DEVICE_OUT_FM_HEADSET, 1, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
                synchronized (this.mRenderLock) {
                    this.mRenderLock.notify();
                    break;
                }
                break;
        }
    }

    private synchronized void stopRender() {
        switch (Main.mConf_PlatForm) {
            case 8:
                if (App_Radio.iRadioType_Arm != 2) {
                }
            default:
                AudioSystem.setDeviceConnectionState(App_Radio.DEVICE_OUT_FM_HEADSET, 0, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
                break;
        }
    }

    private synchronized void exitRenderThread() {
        stopRender();
    }

    public boolean powerUp(float frequency) {
        Log.d("gdy11", " 00 powerUp frequency = " + frequency);
        if (Main.DATA[0] != 1) {
            return false;
        }
        if (this.mContext != null) {
            setForceUse(true);
            if (this.mPowerStatus == 0) {
                return true;
            }
            this.mPowerStatus = 1;
            boolean pwrUp = FmNative.getInstance().test_powerUp(frequency);
            if (!pwrUp) {
                this.mPowerStatus = 2;
                return false;
            }
            setForceUse(true);
            this.mPowerStatus = 0;
        }
        if (this.mPowerStatus == 0) {
            Main.postRunnable_Ui(true, this.mRunnableStartCheckSt);
        }
        return this.mPowerStatus == 0;
    }

    public boolean powerDown(boolean bCheckAppId) {
        if (bCheckAppId && Main.DATA[0] == 1) {
            return false;
        }
        setForceUse(false);
        if (this.mContext != null) {
            if (this.mPowerStatus == 2) {
                return true;
            }
            setVolume(0);
            enableFmAudio(false);
            if (!FmNative.getInstance().test_powerDown(0)) {
                return false;
            }
            this.mPowerStatus = 2;
        }
        return true;
    }

    private void setForceUse(boolean isSpeaker) {
        if (this.mContext != null) {
            if (isSpeaker) {
                if (AudioSystem.getForceUse(6) != 1) {
                    AudioSystem.setForceUse(6, 1);
                }
            } else if (AudioSystem.getForceUse(6) != 0) {
                AudioSystem.setForceUse(6, 0);
            }
        }
    }

    public void powerUp_Async(float frequency) {
        Log.d("gdy11", " 11 powerUp_Async mService != null  ");
        Bundle bundle = new Bundle(1);
        bundle.putFloat("frequency", frequency);
        Message msg = this.mFmServiceHandler.obtainMessage(9);
        msg.setData(bundle);
        this.mFmServiceHandler.removeMessages(9);
        this.mFmServiceHandler.removeMessages(10);
        this.mFmServiceHandler.sendMessage(msg);
    }

    public void tuneStationAsync(float freq) {
        Log.d("gdy11", " 11 FmService tuneStationAsync freq = " + freq);
        Bundle bundle = new Bundle(1);
        bundle.putFloat("frequency", freq);
        Message msg = this.mFmServiceHandler.obtainMessage(15);
        msg.setData(bundle);
        this.mFmServiceHandler.removeMessages(15);
        this.mFmServiceHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tuneStation(float freq) {
        App_Radio.getInstance().refreshUI_InUiThread(FmUtils.trans2KB(freq));
        if (this.mPowerStatus == 0) {
            boolean bRet = FmNative.getInstance().test_tune(freq);
            setVolume(15);
            return bRet;
        }
        boolean tune = false;
        if (powerUp(freq)) {
            enableFmAudio(true);
            setForceUse(true);
            setVolume(15);
            tune = true;
        }
        boolean bRet2 = tune;
        return bRet2;
    }

    public void seekStationAsync(float freq, boolean isUp) {
        App_Radio.lSeekMillis1 = SystemClock.uptimeMillis();
        Bundle bundle = new Bundle(2);
        bundle.putFloat("frequency", freq);
        bundle.putBoolean(OPTION, isUp);
        Message msg = this.mFmServiceHandler.obtainMessage(16);
        msg.setData(bundle);
        this.mFmServiceHandler.removeMessages(16);
        this.mFmServiceHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] seekStation(int iBand, float frequency, boolean isUp) {
        int sens;
        if (this.mPowerStatus != 0) {
            return new float[]{-1.0f, -1.0f};
        }
        this.mIsNativeSeeking = true;
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putFloat("startfreq", frequency);
        inparam.putInt("isup", isUp ? 1 : 0);
        if (iBand >= 4) {
            sens = FmUtils.getAmSensitivity();
        } else {
            sens = FmUtils.getFmSensitivity(mLocFm);
        }
        inparam.putInt("sensitivity", sens);
        if (iBand > 3) {
            inparam.putInt("isuseam", 1);
        }
        App_Radio.test_fmsyu_jni(6, inparam, outparam);
        float[] floatArray = outparam.getFloatArray("freqrssi");
        this.mIsNativeSeeking = false;
        return floatArray;
    }

    public void seekStationAsync_TA(float freq) {
        App_Radio.lSeekTaMillis1 = SystemClock.uptimeMillis();
        Bundle bundle = new Bundle(2);
        bundle.putFloat("frequency", freq);
        Message msg = this.mFmServiceHandler.obtainMessage(27);
        msg.setData(bundle);
        this.mFmServiceHandler.removeMessages(27);
        this.mFmServiceHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] seekStation_TA(int iBand, float frequency) {
        int sens;
        if (this.mPowerStatus != 0) {
            return new float[]{-1.0f, -1.0f};
        }
        this.mIsNativeSeeking = true;
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putFloat("startfreq", frequency);
        if (iBand >= 4) {
            sens = FmUtils.getAmSensitivity();
        } else {
            sens = FmUtils.getFmSensitivity(mLocFm);
        }
        inparam.putInt("sensitivity", sens);
        if (iBand > 3) {
            inparam.putInt("isuseam", 1);
        }
        int ret = App_Radio.test_fmsyu_jni(28, inparam, outparam);
        float[] fRet = null;
        if (ret == 0) {
            fRet = outparam.getFloatArray("freqrssi");
        }
        this.mIsNativeSeeking = false;
        return fRet;
    }

    public void seekStationAsync_PTY(float freq) {
        App_Radio.lSeekPtyMillis1 = SystemClock.uptimeMillis();
        Bundle bundle = new Bundle(2);
        bundle.putFloat("frequency", freq);
        Message msg = this.mFmServiceHandler.obtainMessage(28);
        msg.setData(bundle);
        this.mFmServiceHandler.removeMessages(28);
        this.mFmServiceHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] seekStation_PTY(int iBand, float frequency) {
        int sens;
        if (this.mPowerStatus != 0) {
            return new float[]{-1.0f, -1.0f};
        }
        this.mIsNativeSeeking = true;
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putFloat("startfreq", frequency);
        if (iBand >= 4) {
            sens = FmUtils.getAmSensitivity();
        } else {
            sens = FmUtils.getFmSensitivity(mLocFm);
        }
        inparam.putInt("sensitivity", sens);
        if (iBand > 3) {
            inparam.putInt("isuseam", 1);
        }
        int ret = App_Radio.test_fmsyu_jni(29, inparam, outparam);
        float[] fRet = null;
        if (ret == 0) {
            fRet = outparam.getFloatArray("freqrssi");
        }
        this.mIsNativeSeeking = false;
        return fRet;
    }

    public static int setRdsOnOff(int onoff) {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("rdsonoff", onoff);
        int ret = App_Radio.test_fmsyu_jni(21, inparam, outparam);
        return ret;
    }

    public static int getRdsOnOff() {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        int ret = App_Radio.test_fmsyu_jni(22, inparam, outparam);
        if (ret == 0) {
            return outparam.getInt("rdsonoff");
        }
        String strRdsState = SystemProperties.get("persist.fyt.fm.rdsstate");
        if ("on".equals(strRdsState)) {
            return 1;
        }
        return -1;
    }

    public static int setRdsTaOnOff(int onoff) {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("configdata", onoff);
        int ret = App_Radio.test_fmsyu_jni(23, inparam, outparam);
        return ret;
    }

    public static int setRdsAfOnOff(int onoff) {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("configdata", onoff);
        int ret = App_Radio.test_fmsyu_jni(24, inparam, outparam);
        return ret;
    }

    public static int setRdsPtyType(int type) {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("configdata", type);
        int ret = App_Radio.test_fmsyu_jni(25, inparam, outparam);
        return ret;
    }

    public static int[] getRdsConf() {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("type", 0);
        int ret = App_Radio.test_fmsyu_jni(26, inparam, outparam);
        if (ret == 0) {
            return new int[]{outparam.getInt("TAconfig"), outparam.getInt("AFconfig"), outparam.getInt("PTYconfig")};
        }
        return null;
    }

    public static int[] getRdsState() {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("type", 0);
        int ret = App_Radio.test_fmsyu_jni(27, inparam, outparam);
        if (ret == 0) {
            return new int[]{outparam.getInt("TPstate"), outparam.getInt("TAstate"), outparam.getInt("PTYstate")};
        }
        return null;
    }

    public static String getPs() {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        int ret = App_Radio.test_fmsyu_jni(30, inparam, outparam);
        if (ret == 0) {
            try {
                if (outparam.getByteArray("PSname")[0] == 0 && outparam.getByteArray("PSname")[1] == 0 && outparam.getByteArray("PSname")[2] == 0) {
                    return FinalChip.BSP_PLATFORM_Null;
                }
                return new String(outparam.getByteArray("PSname"), "ascii");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public static String getRds() {
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        int ret = App_Radio.test_fmsyu_jni(31, inparam, outparam);
        if (ret == 0) {
            int textsize = outparam.getInt("TextSize");
            if (textsize == 0) {
                return FinalChip.BSP_PLATFORM_Null;
            }
            try {
                return new String(outparam.getByteArray("Text"), "ascii");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    private static int callback(int a, int b) {
        if (App_Radio.iRadioType_Arm == 2) {
            mRunnableRefreshSearchFreq.freq = a;
            Main.postRunnable_Ui(false, mRunnableRefreshSearchFreq);
        }
        return 0;
    }

    private static int Rdscallback(int ID, int data0, int data1, int data2) {
        Main.postRunnable_Ui(false, new Runnable_RdsHandle(ID, data0, data1, data2));
        return 0;
    }

    public static class RunnableRefreshSearchFreq implements Runnable {
        public int freq;

        @Override // java.lang.Runnable
        public void run() {
            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                interfaceRadio.updateSearchFreq(this.freq);
            }
        }
    }

    public FmChannel[] autoScan(int iBand, int start_freq) {
        int sens;
        int size;
        Log.d("scan", " ** 0  autoScan  start_freq = " + start_freq + " iBand = " + iBand);
        FmChannel[] fmChannels = null;
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("param0", start_freq);
        if (iBand >= 4) {
            sens = FmUtils.getAmSensitivity();
        } else {
            sens = FmUtils.getFmSensitivity(mLocFm);
        }
        inparam.putInt("sensitivity", sens);
        if (iBand > 3) {
            inparam.putInt("isuseam", 1);
        }
        Log.d("scan", " ** 1  autoScan  start_freq = " + start_freq + " sens = " + sens);
        int ret = App_Radio.test_fmsyu_jni(1, inparam, outparam);
        if (ret != -1 && outparam != null) {
            short[] stationsInShort = outparam.getShortArray("param0");
            short[] strengthInShort = outparam.getShortArray("param1");
            if (stationsInShort != null && (size = stationsInShort.length) > 0) {
                fmChannels = new FmChannel[size];
                for (int i = 0; i < size; i++) {
                    fmChannels[i] = new FmChannel();
                    fmChannels[i].station = stationsInShort[i];
                    fmChannels[i].strength = strengthInShort[i];
                    if (iBand <= 3 && (App_Radio.ret33 != 0 || fmChannels[i].station < 6400)) {
                        fmChannels[i].station *= 10;
                    }
                }
            }
        }
        return fmChannels;
    }

    public boolean isScanning() {
        return this.mIsScanning;
    }

    public boolean isSeeking() {
        return this.mIsNativeSeeking;
    }

    public void initService(int iCurrentStation) {
        this.mIsServiceInited = true;
    }

    public boolean isServiceInited() {
        return this.mIsServiceInited;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = getApplicationContext();
        this.mAudioManager = (AudioManager) getSystemService("audio");
        registerFmBroadcastReceiver();
        HandlerThread handlerThread = new HandlerThread("FmRadioServiceThread");
        handlerThread.start();
        this.mFmServiceHandler = new FmRadioServiceHandler(handlerThread.getLooper());
        setForceUse(true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mAudioManager.setParameters("AudioFmPreStop=1");
        setVolume(0);
        unregisterFmBroadcastReceiver();
        exitFm();
        exitRenderThread();
        releaseAudioPatch();
        super.onDestroy();
    }

    private synchronized int createAudioPatch() {
        if (this.mAudioPatch == null) {
            this.mAudioPatch = new Object();
        }
        return -1;
    }

    private synchronized void releaseAudioPatch() {
        if (this.mAudioPatch != null) {
            this.mAudioPatch = null;
        }
        this.mAudioSource = null;
        this.mAudioSink = null;
    }

    private void registerFmBroadcastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(SOUND_POWER_DOWN_MSG);
        filter.addAction("android.intent.action.ACTION_SHUTDOWN");
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.HEADSET_PLUG");
        filter.addAction("android.media.VOLUME_CHANGED_ACTION");
        this.mBroadcastReceiver = new FmServiceBroadcastReceiver(this, null);
        registerReceiver(this.mBroadcastReceiver, filter);
    }

    private void unregisterFmBroadcastReceiver() {
        if (this.mBroadcastReceiver != null) {
            unregisterReceiver(this.mBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public void exitFm() {
        this.mFmServiceHandler.removeMessages(13);
        this.mFmServiceHandler.removeMessages(16);
        if (this.mIsNativeScanning || this.mIsNativeSeeking) {
            FmNative.getInstance().test_stopScan();
        }
        this.mFmServiceHandler.removeCallbacksAndMessages(null);
        this.mFmServiceHandler.removeMessages(11);
        this.mFmServiceHandler.sendEmptyMessage(11);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (intent != null) {
            String action = intent.getAction();
            float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
            if (FM_SEEK_PREVIOUS.equals(action)) {
                seekStationAsync(freq, false);
                return 2;
            }
            if (FM_SEEK_NEXT.equals(action)) {
                seekStationAsync(freq, true);
                return 2;
            }
            return 2;
        }
        return 2;
    }

    private void enableFmAudio(boolean enable) {
        if (enable) {
            if (this.mPowerStatus == 0) {
                ArrayList<AudioPatch> patches = new ArrayList<>();
                AudioManager.listAudioPatches(patches);
                if (this.mAudioPatch == null) {
                    if (isPatchMixerToEarphone(patches)) {
                        stopRender();
                        int status = createAudioPatch();
                        if (status != 0) {
                            startRender();
                            return;
                        }
                        return;
                    }
                    startRender();
                    return;
                }
                return;
            }
            return;
        }
        releaseAudioPatch();
        stopRender();
    }

    private boolean isPatchMixerToEarphone(ArrayList<AudioPatch> patches) {
        int deviceCount = 0;
        int deviceEarphoneCount = 0;
        for (AudioPatch patch : patches) {
            AudioPortConfig[] sources = patch.sources();
            AudioPortConfig[] sinks = patch.sinks();
            AudioPortConfig sourceConfig = sources[0];
            AudioPortConfig sinkConfig = sinks[0];
            AudioPort sourcePort = sourceConfig.port();
            AudioDevicePort audioDevicePortPort = sinkConfig.port();
            if ((sourcePort instanceof AudioMixPort) && (audioDevicePortPort instanceof AudioDevicePort)) {
                deviceCount++;
                int type = audioDevicePortPort.type();
                if (type == 4 || type == 8) {
                    deviceEarphoneCount++;
                }
            }
        }
        return deviceEarphoneCount == 1 && deviceCount == deviceEarphoneCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<FmChannel> startScan(int iBand, int start_freq) {
        FmChannel[] fmChannels2;
        FmUtils.mStopScan = false;
        Log.d("scan", " *0* 00 startScan  start_freq = " + start_freq + " iBand = " + iBand);
        List<FmChannel> listChannels = new ArrayList<>();
        List<FmChannel> listChannels1 = new ArrayList<>();
        List<FmChannel> listChannels2 = new ArrayList<>();
        setVolume(0);
        this.mIsNativeScanning = true;
        boolean bIsOirtFM = isAreaOirtFM(iBand);
        if (bIsOirtFM) {
            Main.postRunnable_Ui(false, new RunnableSetParaBand(1));
            Log.d("scan", " ** 01 startScan  FmUtils.LOWEST_STATION_OIRT = " + FmUtils.LOWEST_STATION_OIRT);
            FmChannel[] fmChannels1 = autoScan(iBand, FmUtils.LOWEST_STATION_OIRT / 10);
            if (FmUtils.mStopScan) {
                return null;
            }
            List<FmChannel> listChannelsTmp = new ArrayList<>();
            if (fmChannels1 != null) {
                for (FmChannel fmChannel : fmChannels1) {
                    listChannelsTmp.add(fmChannel);
                }
            }
            App_Radio.getInstance().getStableList(listChannels1, listChannelsTmp, 6, FmUtils.LOWEST_STATION_OIRT);
            Main.postRunnable_Ui(false, new RunnableSetParaBand(2));
        }
        if (iBand <= 3) {
            Log.d("scan", " ** 02 startScan  start_freq = " + start_freq);
            fmChannels2 = autoScan(2, start_freq);
        } else {
            fmChannels2 = autoScan(iBand, start_freq);
        }
        if (FmUtils.mStopScan) {
            return null;
        }
        List<FmChannel> listChannelsTmp2 = new ArrayList<>();
        if (fmChannels2 != null) {
            for (FmChannel fmChannel2 : fmChannels2) {
                listChannelsTmp2.add(fmChannel2);
            }
        }
        if (bIsOirtFM) {
            App_Radio.getInstance().getStableList(listChannels2, listChannelsTmp2, 12, FmUtils.LOWEST_STATION_FM);
            listChannels.clear();
            listChannels.addAll(listChannels1);
            listChannels.addAll(listChannels2);
        } else {
            if (iBand <= 3) {
                App_Radio.getInstance().getStableList(listChannels2, listChannelsTmp2, 18, FmUtils.LOWEST_STATION_FM);
            } else {
                App_Radio.getInstance().getStableList(listChannels2, listChannelsTmp2, 12, FmUtils.LOWEST_STATION_AM);
            }
            listChannels.clear();
            listChannels.addAll(listChannels2);
        }
        this.mIsNativeScanning = false;
        return listChannels;
    }

    public class RunnableSetParaBand implements Runnable {
        public int iBand;

        RunnableSetParaBand(int iBand) {
            this.iBand = iBand;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                interfaceRadio.setPara(this.iBand);
            }
        }
    }

    public class RunnableHandleScanFinish implements Runnable {
        boolean bRun = true;
        int iBand;
        List<FmChannel> listChannels;

        public RunnableHandleScanFinish(int iBand, List<FmChannel> listChannels) {
            this.iBand = iBand;
            this.listChannels = listChannels;
        }

        public void stopRun() {
            this.bRun = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRun && this.listChannels != null) {
                if (this.iBand <= 3) {
                    App_Radio.getInstance().getListRadioFm(this.listChannels);
                    App_Radio.getInstance().mListFmChannels.clear();
                    App_Radio.getInstance().mListFmChannels.addAll(this.listChannels);
                } else {
                    App_Radio.getInstance().getListRadioAm(this.listChannels);
                    App_Radio.getInstance().mListAmChannels.clear();
                    App_Radio.getInstance().mListAmChannels.addAll(this.listChannels);
                }
                App_Radio.getInstance().updateStations(App_Radio.getInstance().mListFmChannels, App_Radio.getInstance().mListAmChannels);
                for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                    interfaceRadio.resetIndexFMAM();
                    interfaceRadio.jump1stChannel();
                    interfaceRadio.updateListRadio();
                }
                App_Radio.getInstance().disLoading();
            }
        }
    }

    class FmRadioServiceHandler extends Handler {
        public FmRadioServiceHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 9:
                    Bundle bundle = msg.getData();
                    if (FmStation.getCurrentForceMono() == 1) {
                        App_Radio.getInstance().setRadioArmExternalForceMono_6025(true);
                    } else {
                        App_Radio.getInstance().setRadioArmExternalForceMono_6025(false);
                    }
                    float freq = bundle.getFloat("frequency");
                    FmService.this.tuneStationAsync(freq);
                    App_Radio.getInstance().Radio6025_UnMute();
                    break;
                case 11:
                    FmService.this.powerDown(true);
                    break;
                case 13:
                    List<FmChannel> listChannels = null;
                    FmService.this.mIsScanning = true;
                    int station = FmUtils.getDefaultStation();
                    float freq2 = FmUtils.trans2Freq(station);
                    if (FmService.this.powerUp(freq2)) {
                        int start_freq = msg.arg1;
                        listChannels = FmService.this.startScan(FmUtils.mBand, start_freq);
                    }
                    FmService.this.setVolume(15);
                    FmService.this.mIsScanning = false;
                    if (!FmUtils.mStopScan) {
                        if (FmService.this.mRunnableHandleScanFinish != null) {
                            Main.removeRunnable_Ui(FmService.this.mRunnableHandleScanFinish);
                            FmService.this.mRunnableHandleScanFinish.stopRun();
                            FmService.this.mRunnableHandleScanFinish = null;
                        }
                        FmService.this.mRunnableHandleScanFinish = FmService.this.new RunnableHandleScanFinish(FmUtils.mBand, listChannels);
                        Main.postRunnable_Ui(false, FmService.this.mRunnableHandleScanFinish);
                    } else {
                        App_Radio.getInstance().disLoading();
                    }
                    break;
                case 15:
                    Bundle bundle2 = msg.getData();
                    float tuneStation = bundle2.getFloat("frequency");
                    FmService.this.tuneStation(tuneStation);
                    break;
                case 16:
                    App_Radio.lSeekMillis2 = SystemClock.uptimeMillis();
                    Bundle bundle3 = msg.getData();
                    FmService.this.setVolume(0);
                    float[] seekStation = FmService.this.seekStation(FmUtils.mBand, bundle3.getFloat("frequency"), bundle3.getBoolean(FmService.OPTION));
                    if (App_Radio.lSeekMillis2 >= App_Radio.lSeekMillis1) {
                        if (seekStation != null && seekStation.length > 0) {
                            int station2 = FmUtils.trans2KB(seekStation[0]);
                            int stationBak = FmUtils.mCurStation;
                            if (!FmUtils.isValidStation(station2)) {
                                seekStation[0] = FmUtils.trans2Freq(stationBak);
                            }
                            FmService.this.tuneStationAsync(seekStation[0]);
                        } else {
                            FmService.this.setVolume(15);
                        }
                        App_Radio.getInstance().disLoading();
                    }
                    break;
                case 27:
                    App_Radio.lSeekTaMillis2 = SystemClock.uptimeMillis();
                    Bundle bundle4 = msg.getData();
                    FmService.this.setVolume(0);
                    float[] seekStation2 = FmService.this.seekStation_TA(FmUtils.mBand, bundle4.getFloat("frequency"));
                    if (App_Radio.lSeekTaMillis2 >= App_Radio.lSeekTaMillis1) {
                        if (seekStation2 != null && seekStation2.length > 0) {
                            int station3 = FmUtils.trans2KB(seekStation2[0]);
                            int stationBak2 = FmUtils.mCurStation;
                            if (!FmUtils.isValidStation(station3)) {
                                seekStation2[0] = FmUtils.trans2Freq(stationBak2);
                            }
                            FmService.this.tuneStationAsync(seekStation2[0]);
                        } else {
                            Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekTa, 20000L);
                            FmService.this.setVolume(15);
                        }
                        App_Radio.getInstance().disLoading();
                    }
                    break;
                case 28:
                    App_Radio.lSeekPtyMillis2 = SystemClock.uptimeMillis();
                    Bundle bundle5 = msg.getData();
                    FmService.this.setVolume(0);
                    float[] seekStation3 = FmService.this.seekStation_PTY(FmUtils.mBand, bundle5.getFloat("frequency"));
                    if (App_Radio.lSeekPtyMillis2 >= App_Radio.lSeekPtyMillis1) {
                        if (seekStation3 != null && seekStation3.length > 0) {
                            int station4 = FmUtils.trans2KB(seekStation3[0]);
                            int stationBak3 = FmUtils.mCurStation;
                            if (!FmUtils.isValidStation(station4)) {
                                seekStation3[0] = FmUtils.trans2Freq(stationBak3);
                            }
                            FmService.this.tuneStationAsync(seekStation3[0]);
                        } else {
                            FmService.this.setVolume(15);
                        }
                        App_Radio.getInstance().disLoading();
                    }
                    break;
            }
        }
    }

    public void startScan() {
        Message msg;
        Log.d("scan", " 00 startScan FmUtils.LOWEST_STATION_FM = " + FmUtils.LOWEST_STATION_FM);
        if (FmUtils.mBand <= 3) {
            msg = this.mFmServiceHandler.obtainMessage(13, FmUtils.LOWEST_STATION_FM / 10, FmUtils.LOWEST_STATION_FM / 10);
        } else {
            msg = this.mFmServiceHandler.obtainMessage(13, FmUtils.LOWEST_STATION_AM, FmUtils.LOWEST_STATION_AM);
        }
        this.mFmServiceHandler.removeMessages(13);
        this.mFmServiceHandler.sendMessage(msg);
    }

    public boolean setVolume(int volume) {
        Log.d("voo", " **00  setVolume volume = " + volume + " getStreamVolume = " + this.mAudioManager.getStreamVolume(10));
        boolean value = false;
        if (Main.mConf_PlatForm != 8) {
            if (this.mAudioManager == null) {
                return false;
            }
            if (this.mPowerStatus == 0) {
                if (volume == 0) {
                    FmNative.getInstance().test_setMute(true);
                } else {
                    FmNative.getInstance().test_setMute(false);
                }
                Log.d("voo", " **11  setVolume volume = " + volume);
                this.mAudioManager.setParameter("FM_Volume", new StringBuilder().append(volume).toString());
                value = true;
            }
        }
        return value;
    }

    public static int getCurrentArea() {
        int iArea_def = SystemProperties.getInt("ro.fyt.area", 2);
        if (App_Radio.iRadioType_Arm == 1) {
            return 2;
        }
        int iArea = App_Radio.getInstance().mySharePreference2.getIntValue("currentArea6025", iArea_def);
        return iArea;
    }

    public static boolean isAreaOirt() {
        return getCurrentArea() == 3;
    }

    public static boolean isAreaOirtFM(int iBand) {
        return isAreaOirt() && iBand <= 3;
    }

    public static boolean isAreaOirtFMBand1(int iBand) {
        return isAreaOirt() && iBand == 1;
    }

    public static void setCurrentArea(int iArea) {
        App_Radio.getInstance().mySharePreference2.saveIntValue("currentArea6025", iArea);
    }

    public static int getFocusCheckBoxId(int iArea) {
        switch (iArea) {
            case 0:
                return FinalRadioCtrl.Set_CheckBox_AreaUSA;
            case 1:
                return FinalRadioCtrl.Set_CheckBox_AreaLatin;
            case 2:
                return FinalRadioCtrl.Set_CheckBox_AreaEurope;
            case 3:
                return FinalRadioCtrl.Set_CheckBox_AreaOirt;
            case 4:
                return FinalRadioCtrl.Set_CheckBox_AreaJapan;
            default:
                return -1;
        }
    }
}
