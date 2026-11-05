package com.pekall.fmradio;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import com.android.fmradio.FmChannel;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.module.main.Main;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
@SuppressLint({"HandlerLeak"})
public class FmRadio_Sofia {
    public static final int FM_CLOSED = 6;
    private static final String FM_FREQUENCY = "frequency";
    public static final int FM_INIT_SETCHANNEL_ID = 5;
    public static final int FM_OPEN_FAILED = 2;
    public static final int FM_OPEN_SUCCEED = 1;
    public static final int FM_SEEK_SUCCEED = 4;
    public static final int FM_SETFREQ_SUCCEED = 3;
    public static final int LONG_PRESS_SEEK_TIMEOUT = 2000;
    public static final int LONG_PRESS_TUNE_TIMEOUT = 100;
    public static final int SEEK_FINISHED_PTY = 8;
    public static final int SEEK_FINISHED_TA = 9;
    public static final int SEEK_NEXT = 7;
    public int mStateSeekAll = 0;
    public int mStartFreq = 0;
    public boolean mPowerOn = false;
    public boolean mIsServiceBinded = false;
    public IFMRadioService mService = null;
    public List<FmChannel> mListChannels = new ArrayList();
    public List<FmChannel> mListChannels1 = new ArrayList();
    public List<FmChannel> mListChannels2 = new ArrayList();
    private ServiceConnection mServConnection = new ServiceConnection() { // from class: com.pekall.fmradio.FmRadio_Sofia.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder service) {
            FmRadio_Sofia.this.mIsServiceBinded = true;
            FmRadio_Sofia.this.mService = IFMRadioService.Stub.asInterface(service);
            if (FmRadio_Sofia.this.mService != null) {
                App_Radio.getInstance().handleRightAppId();
                try {
                    FmRadio_Sofia.this.mService.registerCallback(FmRadio_Sofia.this.mCallback);
                } catch (RemoteException e) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            if (FmRadio_Sofia.this.mService == null) {
                return;
            }
            try {
                FmRadio_Sofia.this.mService.unregisterCallback(FmRadio_Sofia.this.mCallback);
            } catch (RemoteException e) {
            }
            FmRadio_Sofia.this.mService = null;
        }
    };
    public Runnable mRunnableSearch2ndArea = new Runnable() { // from class: com.pekall.fmradio.FmRadio_Sofia.2
        @Override // java.lang.Runnable
        public void run() {
            boolean bIsOirtFM = FmService.isAreaOirtFM(FmUtils.mBand);
            if (bIsOirtFM) {
                FmRadio_Sofia.this.search(false);
            }
        }
    };
    private IRemoteServiceCallback mCallback = new IRemoteServiceCallback.Stub() { // from class: com.pekall.fmradio.FmRadio_Sofia.3
        @Override // com.pekall.fmradio.IRemoteServiceCallback
        public void openFMRadioCallBack(boolean result) {
            if (result) {
                FmRadio_Sofia.this.mHandler.sendEmptyMessage(1);
            } else {
                FmRadio_Sofia.this.mHandler.sendEmptyMessage(2);
            }
        }

        @Override // com.pekall.fmradio.IRemoteServiceCallback
        public void openFMRadioTxCallBack(boolean result) {
        }

        @Override // com.pekall.fmradio.IRemoteServiceCallback
        public void setFrequencyCallback(boolean result, int freq) {
            FmRadio_Sofia.this.mHandler.sendEmptyMessage(3);
        }

        @Override // com.pekall.fmradio.IRemoteServiceCallback
        public void seekStationCallback(boolean result, int freq) {
            Main.postRunnable_Ui(false, FmRadio_Sofia.this.new RunnableSeekCallBack(result, freq));
        }
    };
    final Handler mHandler = new Handler() { // from class: com.pekall.fmradio.FmRadio_Sofia.4
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!App_Radio.getInstance().mIpcObj.isRightAppId()) {
                removeCallbacksAndMessages(null);
            }
            switch (msg.what) {
                case 1:
                    if (FmStation.getCurrentForceMono() == 1) {
                        FMRadioService.setFMAudioMode(1);
                    } else {
                        FMRadioService.setFMAudioMode(0);
                    }
                    FmRadio_Sofia.this.mHandler.sendEmptyMessage(5);
                    break;
                case 3:
                    for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                        interfaceRadio.updateCurrentFreq(FmUtils.mCurStation, true);
                    }
                    break;
                case 4:
                    if (FmRadio_Sofia.this.mStateSeekAll > 0) {
                        Message seekNextMsg = FmRadio_Sofia.this.mHandler.obtainMessage(7);
                        long playoutTime = SystemClock.uptimeMillis() + 1500;
                        FmRadio_Sofia.this.mHandler.sendMessageAtTime(seekNextMsg, playoutTime);
                    }
                    break;
                case 5:
                    App_Radio.getInstance().setFreq(FmUtils.mCurStation, true);
                    break;
                case 7:
                    if (FmRadio_Sofia.this.mStateSeekAll > 0) {
                        FmRadio_Sofia.this.seekFMRadioStation(1);
                    }
                    break;
                case 8:
                    App_Radio.lSeekPtyMillis2 = SystemClock.uptimeMillis();
                    Bundle bundle = msg.getData();
                    FmRadio_Sofia.this.setMute(0);
                    int[] seekStation = FmRadio_Sofia.this.seekStation_PTY(FmUtils.mBand, bundle.getInt("frequency"));
                    if (App_Radio.lSeekPtyMillis2 >= App_Radio.lSeekPtyMillis1) {
                        if (seekStation != null && seekStation.length > 0) {
                            if (FmUtils.isValidStation(seekStation[0])) {
                                App_Radio.getInstance().setFreq(seekStation[0], true);
                            } else {
                                App_Radio.getInstance().setFreq(FmUtils.mCurStation, true);
                            }
                        }
                        FmRadio_Sofia.this.setMute(1);
                        App_Radio.getInstance().disLoading();
                    }
                    break;
                case 9:
                    App_Radio.lSeekTaMillis2 = SystemClock.uptimeMillis();
                    Bundle bundle2 = msg.getData();
                    FmRadio_Sofia.this.setMute(0);
                    int[] seekStation2 = FmRadio_Sofia.this.seekStation_TA(FmUtils.mBand, bundle2.getInt("frequency"));
                    if (App_Radio.lSeekTaMillis2 >= App_Radio.lSeekTaMillis1) {
                        if (seekStation2 != null && seekStation2.length > 0) {
                            if (FmUtils.isValidStation(seekStation2[0])) {
                                App_Radio.getInstance().setFreq(seekStation2[0], true);
                            } else {
                                App_Radio.getInstance().setFreq(FmUtils.mCurStation, true);
                            }
                        } else {
                            Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekTa, 20000L);
                        }
                        FmRadio_Sofia.this.setMute(1);
                        App_Radio.getInstance().disLoading();
                    }
                    break;
            }
        }
    };

    public class RunnableSeekCallBack implements Runnable {
        int freq;
        boolean result;

        public RunnableSeekCallBack(boolean result, int freq) {
            this.result = result;
            this.freq = freq;
        }

        @Override // java.lang.Runnable
        public void run() {
            int curStation = this.freq / 10;
            if (this.result) {
                if (FmRadio_Sofia.this.mStateSeekAll == 1) {
                    FmRadio_Sofia.this.mStateSeekAll = 2;
                }
                if (FmUtils.isValidStation(curStation)) {
                    if (FmRadio_Sofia.this.mStateSeekAll > 0) {
                        FmChannel fmChannel = new FmChannel();
                        fmChannel.station = curStation;
                        fmChannel.strength = 0;
                        FmRadio_Sofia.this.mListChannels.add(fmChannel);
                    }
                    App_Radio.getInstance().refreshUI_InUiThread(curStation);
                } else if (FmRadio_Sofia.this.mStateSeekAll > 0) {
                    FmRadio_Sofia.this.mStateSeekAll = 3;
                }
                switch (FmRadio_Sofia.this.mStateSeekAll) {
                    case 1:
                    case 2:
                        FmRadio_Sofia.this.mHandler.sendEmptyMessage(4);
                        break;
                }
            } else if (FmRadio_Sofia.this.mStateSeekAll > 0) {
                FmRadio_Sofia.this.mStateSeekAll = 3;
            }
            if (FmRadio_Sofia.this.mStateSeekAll == 3) {
                boolean bIsOirtFM = FmService.isAreaOirtFM(FmUtils.mBand);
                if (bIsOirtFM && FmRadio_Sofia.this.mStartFreq == FmUtils.LOWEST_STATION_OIRT) {
                    App_Radio.getInstance().getStableList(FmRadio_Sofia.this.mListChannels1, FmRadio_Sofia.this.mListChannels, 6, FmUtils.LOWEST_STATION_OIRT);
                    Main.postRunnable_Ui(true, FmRadio_Sofia.this.mRunnableSearch2ndArea);
                } else {
                    if (bIsOirtFM && FmRadio_Sofia.this.mStartFreq == FmUtils.LOWEST_STATION_FM) {
                        App_Radio.getInstance().getStableList(FmRadio_Sofia.this.mListChannels2, FmRadio_Sofia.this.mListChannels, 12, FmUtils.LOWEST_STATION_FM);
                        FmRadio_Sofia.this.mListChannels.clear();
                        FmRadio_Sofia.this.mListChannels.addAll(FmRadio_Sofia.this.mListChannels1);
                        FmRadio_Sofia.this.mListChannels.addAll(FmRadio_Sofia.this.mListChannels2);
                    } else {
                        if (FmUtils.mBand <= 3) {
                            App_Radio.getInstance().getStableList(FmRadio_Sofia.this.mListChannels2, FmRadio_Sofia.this.mListChannels, 18, FmUtils.LOWEST_STATION_FM);
                        } else {
                            App_Radio.getInstance().getStableList(FmRadio_Sofia.this.mListChannels2, FmRadio_Sofia.this.mListChannels, 12, FmUtils.LOWEST_STATION_AM);
                        }
                        FmRadio_Sofia.this.mListChannels.clear();
                        FmRadio_Sofia.this.mListChannels.addAll(FmRadio_Sofia.this.mListChannels2);
                    }
                    if (FmUtils.mBand <= 3) {
                        App_Radio.getInstance().getListRadioFm(FmRadio_Sofia.this.mListChannels);
                        App_Radio.getInstance().mListFmChannels.clear();
                        App_Radio.getInstance().mListFmChannels.addAll(FmRadio_Sofia.this.mListChannels);
                    } else {
                        App_Radio.getInstance().getListRadioAm(FmRadio_Sofia.this.mListChannels);
                        App_Radio.getInstance().mListAmChannels.clear();
                        App_Radio.getInstance().mListAmChannels.addAll(FmRadio_Sofia.this.mListChannels);
                    }
                    App_Radio.getInstance().updateStations(App_Radio.getInstance().mListFmChannels, App_Radio.getInstance().mListAmChannels);
                    for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                        interfaceRadio.resetIndexFMAM();
                        interfaceRadio.jump1stChannel();
                        interfaceRadio.updateListRadio();
                    }
                }
                FmRadio_Sofia.this.mStateSeekAll = 0;
            }
            if (FmRadio_Sofia.this.mStateSeekAll == 0) {
                FmStation.saveCurrentStation(FmUtils.mCurStation);
                App_Radio.getInstance().disLoading();
            }
        }
    }

    private void disableRds() {
        if (this.mService != null) {
            try {
                if (this.mService.getFMServiceStatus() == 2) {
                    this.mService.disableRds();
                }
            } catch (RemoteException e) {
            }
        }
    }

    public void powerOnFMRadio() {
        if (this.mService != null && !this.mPowerOn) {
            try {
                this.mService.openFMRadio();
                this.mPowerOn = true;
            } catch (RemoteException e) {
            }
        }
    }

    public void powerOffFMRadio() {
        if (this.mService != null) {
            try {
                disableRds();
                this.mService.closeFMRadio();
                Intent iHeadset = new Intent(FmAudioDefaultImpl.FM_ROUTE_HEADSET);
                MyApplication.myApp.sendBroadcast(iHeadset);
                this.mPowerOn = false;
            } catch (RemoteException e) {
            }
        }
    }

    public void seekFMRadioStation(int direction) {
        if (this.mService != null) {
            try {
                if (this.mStateSeekAll > 0) {
                    this.mService.seekFM(direction | 128);
                } else {
                    this.mService.seekFM(direction);
                }
            } catch (RemoteException e) {
            }
        }
    }

    public void unbindFMRadioService() {
        if (this.mIsServiceBinded) {
            MyApplication.myApp.unbindService(this.mServConnection);
            this.mIsServiceBinded = false;
        }
    }

    public boolean bindToService() {
        Intent intent = new Intent(MyApplication.myApp, (Class<?>) FMRadioService.class);
        return MyApplication.myApp.bindService(intent, this.mServConnection, 1);
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

    public void search(boolean bCheckOirtFm) {
        this.mListChannels.clear();
        this.mStateSeekAll = 1;
        disableRds();
        if (FmUtils.mBand <= 3) {
            setFMRadioThreshold(FmUtils.getFmSensitivity(FmService.mLocFm));
            int freq = FmUtils.LOWEST_STATION_FM;
            boolean bIsOirtFM = FmService.isAreaOirtFM(FmUtils.mBand);
            if (bIsOirtFM) {
                if (bCheckOirtFm) {
                    Main.postRunnable_Ui(false, new RunnableSetParaBand(1));
                    freq = FmUtils.LOWEST_STATION_OIRT;
                } else {
                    Main.postRunnable_Ui(false, new RunnableSetParaBand(2));
                }
            }
            setFMRadioFreq(freq * 10);
            FmUtils.mCurStation = freq;
        } else {
            setFMRadioThreshold(FmUtils.getAmSensitivity());
            setFMRadioFreq(FmUtils.LOWEST_STATION_AM * 10);
            FmUtils.mCurStation = FmUtils.LOWEST_STATION_AM;
        }
        this.mStartFreq = FmUtils.mCurStation;
        seekFMRadioStation(1);
    }

    private void setFMRadioFreq(int freq) {
        if (this.mService != null) {
            try {
                this.mService.setFMFreq(freq);
            } catch (RemoteException e) {
            }
        }
    }

    public void setFMRadioThreshold(int value) {
        if (this.mService != null) {
            try {
                this.mService.setFMRssiThreshold(value);
            } catch (RemoteException e) {
            }
        }
    }

    public void seekStationAsync_PTY(int freq) {
        App_Radio.lSeekPtyMillis1 = SystemClock.uptimeMillis();
        Bundle bundle = new Bundle(2);
        bundle.putInt("frequency", freq);
        Message msg = this.mHandler.obtainMessage(8);
        msg.setData(bundle);
        this.mHandler.removeMessages(8);
        this.mHandler.sendMessage(msg);
    }

    public void seekStationAsync_TA(int freq) {
        App_Radio.lSeekTaMillis1 = SystemClock.uptimeMillis();
        Bundle bundle = new Bundle(2);
        bundle.putInt("frequency", freq);
        Message msg = this.mHandler.obtainMessage(9);
        msg.setData(bundle);
        this.mHandler.removeMessages(9);
        this.mHandler.sendMessage(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] seekStation_PTY(int iBand, int freq) {
        int sens;
        if (!this.mPowerOn) {
            return new int[]{-1, -1};
        }
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("startfreq", freq);
        if (iBand >= 4) {
            sens = FmUtils.getAmSensitivity();
        } else {
            sens = FmUtils.getFmSensitivity(FmService.mLocFm);
        }
        inparam.putInt("sensitivity", sens);
        if (iBand > 3) {
            inparam.putInt("isuseam", 1);
        }
        int ret = App_Radio.test_fmsyu_jni(29, inparam, outparam);
        if (ret != 0) {
            return null;
        }
        int[] iRet = outparam.getIntArray("freqrssi");
        return iRet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] seekStation_TA(int iBand, int freq) {
        int sens;
        if (!this.mPowerOn) {
            return new int[]{-1, -1};
        }
        Bundle inparam = new Bundle();
        Bundle outparam = new Bundle();
        inparam.putInt("startfreq", freq);
        if (iBand >= 4) {
            sens = FmUtils.getAmSensitivity();
        } else {
            sens = FmUtils.getFmSensitivity(FmService.mLocFm);
        }
        inparam.putInt("sensitivity", sens);
        if (iBand > 3) {
            inparam.putInt("isuseam", 1);
        }
        int ret = App_Radio.test_fmsyu_jni(28, inparam, outparam);
        if (ret != 0) {
            return null;
        }
        int[] iRet = outparam.getIntArray("freqrssi");
        return iRet;
    }

    public void setMute(int mode) {
        try {
            if (this.mService != null) {
                this.mService.setMute(mode);
            }
        } catch (Exception e) {
        }
    }
}
