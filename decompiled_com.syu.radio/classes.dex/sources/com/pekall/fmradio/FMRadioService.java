package com.pekall.fmradio;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.android.fmradio.FmUtils;
import com.android.fmradio.Runnable_RdsHandle;
import com.lsec.core.ipc.module.main.Main;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FMRadioService extends Service {
    static final String CMD_NAME = "command";
    static final String CMD_SEEK = "command.seek";
    static final String CMD_STOP_FM = "command.stop.FM";
    private static final int FM_AIRPLANE_MODE_CHANGED = 7;
    static final String FM_APPWIDGET_UPDATE = "com.pekall.fmradio.appwidgetupdate";
    private static final int FM_CB_OPEN_RX = 0;
    private static final int FM_CB_OPEN_TX = 1;
    private static final int FM_CB_SEEK_CHN = 2;
    private static final int FM_CB_SET_FREQ = 3;
    public static final String FM_CLOSED = "com.pekall.fmradio.closed";
    private static final int FM_DISABLE_RDS = 21;
    private static final int FM_ENABLE_RDS = 20;
    static final String FM_LAUNCHING = "com.pekall.fmradio.launching";
    static final String FM_OPEN_FAILED = "com.pekall.fmradio.openfailed";
    private static final int FM_OPEN_FIRMWARE = 3;
    private static final int FM_OPEN_TX = 15;
    private static final int FM_POWER_OFF_CHIP = 2;
    private static final int FM_POWER_ON_AUDIO = 12;
    private static final int FM_POWER_ON_CHIP = 1;
    public static final String FM_RDS_STRING = "com.pekall.fmradio.rds.string";
    private static final int FM_SEEK_CHANNEL = 5;
    public static final int FM_SERVICE_EXITING = 3;
    public static final int FM_SERVICE_INIT = 0;
    public static final int FM_SERVICE_NONE = -1;
    public static final int FM_SERVICE_ON = 2;
    public static final int FM_SERVICE_OPENED = 1;
    public static final int FM_SERVICE_TX_INIT = 4;
    public static final int FM_SERVICE_TX_ON = 5;
    private static final int FM_SET_ANTENNA = 23;
    private static final int FM_SET_FREQ = 13;
    private static final int FM_SET_OUTPUT_MODE = 24;
    private static final int FM_SET_RSSI_THRESHOLD = 6;
    static final String SERVICE_CMD = "com.pekall.fmradio.servicecommand";
    private static FmAudioDeviceInterface mAudioInterface = null;
    private PowerManager.WakeLock mWakeLock;
    private int mFMServiceState = -1;
    RunnableUpdateSearchFreq mRunnableUpdateSearchFreq = null;

    @SuppressLint({"HandlerLeak"})
    private final Handler mHandler = new Handler() { // from class: com.pekall.fmradio.FMRadioService.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (App_Radio.getInstance().mIpcObj.isRightAppId()) {
                switch (msg.what) {
                    case 1:
                        if (4 != FMRadioService.this.mFMServiceState && 5 != FMRadioService.this.mFMServiceState && 3 != FMRadioService.this.mFMServiceState) {
                            FMRadioService.this.mFMServiceState = 0;
                            FMRadioNativeInterface.getInstance().powerOnChip();
                        } else {
                            FMRadioService.this.mHandler.sendEmptyMessageDelayed(1, 300L);
                        }
                        break;
                    case 2:
                        FMRadioNativeInterface.getInstance().powerOffChip();
                        break;
                    case 3:
                        FMRadioNativeInterface.getInstance().openFMRadio();
                        break;
                    case 5:
                        FMRadioNativeInterface.getInstance().seekFM(FmUtils.mCurStation * 10, ((Integer) msg.obj).intValue());
                        break;
                    case 6:
                        FMRadioNativeInterface.getInstance().setFMRssiThreshold(((Integer) msg.obj).intValue());
                        break;
                    case 7:
                        App_Radio.getInstance().RadioSophia_PowerOff();
                        break;
                    case 12:
                        FMRadioService.mAudioInterface.powerOnAudio();
                        FMRadioService.mAudioInterface.setMute(false);
                        break;
                    case 13:
                        FMRadioNativeInterface.getInstance().setFMFreq(FmUtils.mCurStation * 10);
                        break;
                    case 15:
                        if (FMRadioService.this.mFMServiceState == -1) {
                            FMRadioService.this.mFMServiceState = 4;
                            FMRadioNativeInterface.getInstance().openFMRadioTx();
                        } else {
                            FMRadioService.this.mHandler.sendEmptyMessageDelayed(15, 200L);
                        }
                        break;
                    case 20:
                        FMRadioNativeInterface.getInstance().enableRds();
                        break;
                    case 21:
                        FMRadioNativeInterface.getInstance().disableRds();
                        break;
                    case 23:
                        if (FMRadioService.this.mFMServiceState == 2) {
                            FMRadioNativeInterface.getInstance().setAntenna(0);
                        }
                        break;
                }
            }
            removeCallbacksAndMessages(null);
        }
    };
    private final OnCmdDoneListener mOnCmdDoneListener = new OnCmdDoneListener() { // from class: com.pekall.fmradio.FMRadioService.2
        @Override // com.pekall.fmradio.OnCmdDoneListener
        public void onCmdDone(int what, int status, Object value) {
            switch (what) {
                case 0:
                    if (status == 0) {
                        FMRadioService.this.mFMServiceState = 1;
                        FMRadioNativeInterface.getInstance().openFMRadio();
                    } else {
                        FMRadioService.this.mFMServiceState = -1;
                        FMRadioService.this.callback2Client(0, false, null);
                    }
                    break;
                case 1:
                    FMRadioService.this.mFMServiceState = -1;
                    break;
                case 2:
                    if (status == 0) {
                        FMRadioService.this.mFMServiceState = 2;
                        FMRadioService.this.mHandler.sendEmptyMessage(13);
                        FMRadioService.this.mHandler.sendEmptyMessageDelayed(12, 100L);
                        FMRadioService.this.mHandler.sendEmptyMessageDelayed(20, 200L);
                    } else {
                        FMRadioService.this.mFMServiceState = 1;
                        FMRadioService.this.mHandler.sendEmptyMessage(2);
                    }
                    FMRadioService.this.callback2Client(0, status == 0, null);
                    break;
                case 3:
                    FMRadioService.this.mFMServiceState = -1;
                    FMRadioService.this.sendBroadcast(new Intent(FMRadioService.FM_CLOSED));
                    break;
                case 11:
                    if (FMRadioService.this.mFMServiceState == 5 || FMRadioService.this.mFMServiceState == 2) {
                        FMRadioService.this.callback2Client(3, status == 0, Integer.valueOf(FmUtils.mCurStation * 10));
                    }
                    break;
                case 12:
                    if (App_Radio.bIsRadioArmExt && status == 2) {
                        int freq = Integer.parseInt(value.toString());
                        if (FMRadioService.this.mRunnableUpdateSearchFreq != null) {
                            FMRadioService.this.mRunnableUpdateSearchFreq.stopRun();
                            Main.removeRunnable_Ui(FMRadioService.this.mRunnableUpdateSearchFreq);
                            FMRadioService.this.mRunnableUpdateSearchFreq = null;
                        }
                        FMRadioService.this.mRunnableUpdateSearchFreq = FMRadioService.this.new RunnableUpdateSearchFreq(freq / 10);
                        Main.postRunnable_Ui(false, FMRadioService.this.mRunnableUpdateSearchFreq);
                    } else {
                        FMRadioService.this.callback2Client(2, status == 0, Integer.valueOf(Integer.parseInt(value.toString())));
                    }
                    break;
                case 19:
                    if (FMRadioService.this.mFMServiceState == 4) {
                        boolean rst = status == 0;
                        if (rst) {
                            FMRadioService.this.mFMServiceState = 5;
                        } else {
                            FMRadioService.this.mFMServiceState = -1;
                        }
                        FMRadioService.this.callback2Client(1, rst, null);
                    }
                    break;
                case 20:
                    Intent intent = new Intent(FMRadioService.FM_RDS_STRING);
                    intent.putExtra("rds", (byte[]) value);
                    intent.putExtra("type", status);
                    FMRadioService.this.sendBroadcast(intent);
                    break;
                case 21:
                    Message msg = Message.obtain(FMRadioService.this.mHandler, 24, Integer.valueOf(status));
                    FMRadioService.this.mHandler.sendMessage(msg);
                    break;
                case 23:
                    Main.postRunnable_Ui(false, new Runnable_RdsHandle(status, Integer.parseInt(value.toString()), 0, 0));
                    break;
            }
        }
    };
    private final IFMRadioService.Stub mBinder = new IFMRadioService.Stub() { // from class: com.pekall.fmradio.FMRadioService.3
        @Override // com.pekall.fmradio.IFMRadioService
        public int getFMServiceStatus() {
            return FMRadioService.this.mFMServiceState;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean openFMRadio() {
            FMRadioService.this.mHandler.sendEmptyMessage(1);
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean closeFMRadio() {
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public void killFMRadio() {
            FMRadioService.mAudioInterface.setMute(true);
            FMRadioService.mAudioInterface.enableTouchSound();
            FMRadioService.mAudioInterface.powerOffAudio();
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public void disTouchSound() {
            FMRadioService.mAudioInterface.disableTouchSound();
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public void enTouchSound() {
            FMRadioService.mAudioInterface.enableTouchSound();
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean openFMRadioTx() {
            FMRadioService.this.mHandler.sendEmptyMessage(15);
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public int getFMFreq() {
            return FmUtils.mCurStation * 10;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean setRdsCallback(int start) {
            return FMRadioNativeInterface.getInstance().setRdsCallback(start);
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean setFMFreq(int freq) {
            if (FMRadioService.this.mFMServiceState == 2 || FMRadioService.this.mFMServiceState == 5) {
                return FMRadioNativeInterface.getInstance().setFMFreq(freq);
            }
            return false;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean seekFM(int direction) {
            if (FMRadioService.this.mFMServiceState == 2) {
                Message msg = Message.obtain(FMRadioService.this.mHandler, 5, Integer.valueOf(direction));
                FMRadioService.this.mHandler.sendMessage(msg);
                return true;
            }
            return false;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean stopSeekFM() {
            if (FMRadioService.this.mFMServiceState != 2) {
                return false;
            }
            return FMRadioNativeInterface.getInstance().stopSeekFM();
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public int getFMVolume() {
            if (FMRadioService.this.mFMServiceState != 2) {
                return -1;
            }
            FMRadioNativeInterface.getInstance().getFMVolume();
            return 0;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean setFMVolume(int volume) {
            if (FMRadioService.this.mFMServiceState != 2) {
                return false;
            }
            return FMRadioNativeInterface.getInstance().setFMVolume(volume);
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean isMuteFM() {
            if (FMRadioService.this.mFMServiceState == 2) {
                return FMRadioService.mAudioInterface.getMute();
            }
            return false;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean setMute(int mode) {
            if (FMRadioService.this.mFMServiceState != 2) {
                return false;
            }
            FMRadioService.mAudioInterface.setMute(mode == 0);
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public int getFMAudioRouting() {
            if (FMRadioService.this.mFMServiceState == 2) {
                return FMRadioService.mAudioInterface.getAudioPath();
            }
            return -1;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean setFMAudioRouting(int mode) {
            if (FMRadioService.this.mFMServiceState != 2) {
                return false;
            }
            FMRadioService.mAudioInterface.setAudioOnSpeaker(mode == 1);
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public int getFMRssiLevel() {
            if (FMRadioService.this.mFMServiceState != 2) {
                return -1;
            }
            FMRadioNativeInterface.getInstance().getFMRssiLevel();
            return 0;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean setFMRssiThreshold(int value) {
            if (FMRadioService.this.mFMServiceState == 2) {
                Message msg = Message.obtain(FMRadioService.this.mHandler, 6, Integer.valueOf(value));
                FMRadioService.this.mHandler.sendMessage(msg);
                return true;
            }
            return false;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean enableRds() {
            FMRadioService.this.mHandler.sendEmptyMessage(20);
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public boolean disableRds() {
            FMRadioService.this.mHandler.sendEmptyMessage(21);
            return true;
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public void registerCallback(IRemoteServiceCallback cb) {
            if (cb != null) {
                FMRadioService.this.mCallbacks.register(cb);
            }
        }

        @Override // com.pekall.fmradio.IFMRadioService
        public void unregisterCallback(IRemoteServiceCallback cb) {
            if (cb != null) {
                FMRadioService.this.mCallbacks.unregister(cb);
            }
        }
    };
    final RemoteCallbackList<IRemoteServiceCallback> mCallbacks = new RemoteCallbackList<>();

    public boolean setHardwareVolume(int volume) {
        if (this.mFMServiceState != 2) {
            return false;
        }
        mAudioInterface.setFMStreamVol(volume);
        return true;
    }

    public class RunnableUpdateSearchFreq implements Runnable {
        boolean bRun = true;
        int freq;

        public void stopRun() {
            this.bRun = false;
        }

        public RunnableUpdateSearchFreq(int freq) {
            this.freq = freq;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRun) {
                for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                    interfaceRadio.updateSearchFreq(this.freq);
                }
            }
        }
    }

    void stopFMRadioOnAudioFocusLossTransient() {
        FMRadioNativeInterface.getInstance().disableRds();
        mAudioInterface.setMute(true);
        if (!App_Radio.bIsRadioArmExt) {
            mAudioInterface.mAudioMgr.setParameters("route-fm=disabled");
        }
    }

    void startFMRadioOnAudioFocusGain() {
        FMRadioNativeInterface.getInstance().enableRds();
        mAudioInterface.powerOnAudioOnFocusLoss();
        mAudioInterface.setMute(false);
    }

    public OnCmdDoneListener getCommandDoneListener() {
        return this.mOnCmdDoneListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callback2Client(int callbackId, boolean result, Object data) {
        int number = this.mCallbacks.beginBroadcast();
        for (int i = 0; i < number; i++) {
            switch (callbackId) {
                case 0:
                    try {
                        ((IRemoteServiceCallback) this.mCallbacks.getBroadcastItem(i)).openFMRadioCallBack(result);
                    } catch (RemoteException e) {
                    }
                    break;
                case 1:
                    ((IRemoteServiceCallback) this.mCallbacks.getBroadcastItem(i)).openFMRadioTxCallBack(result);
                    break;
                case 2:
                    ((IRemoteServiceCallback) this.mCallbacks.getBroadcastItem(i)).seekStationCallback(result, ((Integer) data).intValue());
                    break;
                case 3:
                    ((IRemoteServiceCallback) this.mCallbacks.getBroadcastItem(i)).setFrequencyCallback(result, ((Integer) data).intValue());
                    break;
            }
        }
        this.mCallbacks.finishBroadcast();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mFMServiceState = -1;
        FMRadioNativeInterface.getInstance().mOnCmdDoneListener = getCommandDoneListener();
        FMRadioNativeInterface.getInstance().fmradio_native_setup(new WeakReference(FMRadioNativeInterface.getInstance()));
        mAudioInterface = new FmAudioDeviceInterface(this, this);
        PowerManager pm = (PowerManager) getSystemService("power");
        this.mWakeLock = pm.newWakeLock(1, getClass().getName());
        this.mWakeLock.setReferenceCounted(false);
        mAudioInterface.disableTouchSound();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mFMServiceState = -1;
        this.mHandler.removeCallbacksAndMessages(null);
        FMRadioNativeInterface.getInstance().destroy();
        super.onDestroy();
    }

    public int getState() {
        return this.mFMServiceState;
    }

    public void setState(int state) {
        if (state < -1 || state > 5) {
            throw new IllegalArgumentException();
        }
        this.mFMServiceState = state;
    }

    public static void onAudioFocusChange(int focusChange) {
        if (mAudioInterface != null) {
            mAudioInterface.onAudioFocusChange(focusChange);
        }
    }

    public static boolean setFMAudioMode(int mode) {
        return FMRadioNativeInterface.getInstance().setFMAudioMode(mode);
    }

    public static boolean getFMAudioMode() {
        return FMRadioNativeInterface.getInstance().getFMAudioMode();
    }
}
