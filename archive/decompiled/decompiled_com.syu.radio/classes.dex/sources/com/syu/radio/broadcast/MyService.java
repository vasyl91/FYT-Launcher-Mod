package com.syu.radio.broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.util.SparseArray;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.syu.radio.App_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.netchannel.NetChannel;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class MyService extends Service {
    public static final Binder BINDER = new Binder();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("gdy11", " *** Server onBind");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d("gdy11", " *** Server onBind");
        return BINDER;
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("gdy11", " *** Server onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) throws Throwable {
        if (intent != null) {
            String action = intent.getAction();
            Log.d("gdy1", " 00 radio MyService action = " + action);
            if ("com.syu.radio.prevservice".equals(action)) {
                App_Radio.getInstance().mIpcObj.Prev_Channel();
            } else if ("com.syu.radio.nextservice".equals(action)) {
                App_Radio.getInstance().mIpcObj.Next_Channel();
            } else if ("com.syu.radio.relogo".equals(action)) {
                if (App_Radio.bFmOnline) {
                    App_Radio.getInstance();
                    App_Radio.read_list();
                }
            } else if ("com.syu.radio.msgservice".equals(action) && intent.hasExtra("data")) {
                Log.d("gdy11", " 01 radio MyService U_APP_ID = " + Main.DATA[0]);
                if (App_Radio.getInstance().myApplication == null) {
                    App_Radio.getInstance().onCreate(MyApplication.myApp);
                }
                if (Main.DATA[0] != 1) {
                    Log.d("gdy11", " 02 radio MyService U_APP_ID = " + Main.DATA[0]);
                    Main.requestAppId(1);
                    Log.d("gdy11", " 03 radio MyService U_APP_ID = " + Main.DATA[0]);
                }
                NetChannel netChannel = NetChannel.getInstance(MyApplication.myApp);
                MyApplication.startThread(MyApplication.mStrZipTag, App_Radio.StrThreadCheckNet, netChannel.mRunnable_CheckNet, true, 1);
                String str_data = intent.getStringExtra("data");
                if (str_data.equals("prev")) {
                    radio_Channel(false);
                } else if (str_data.equals("next")) {
                    Log.d("gdy11", " 111 radio MyService Next_Channel() mBand = " + FmUtils.mBand + " mIndexRadio = " + FmUtils.mIndexRadio[FmUtils.mBand - 1]);
                    radio_Channel(true);
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void radio_Channel(boolean isNext) {
        Log.d("gdy11", " 000 radio radio_Channel mListRadio.size = " + App_Radio.getInstance().mListRadio.size() + " mBand = " + FmUtils.mBand);
        if (App_Radio.getInstance().mListRadio.size() == 30) {
            if (isNext) {
                int[] iArr = FmUtils.mIndexRadio;
                int i = FmUtils.mBand - 1;
                iArr[i] = iArr[i] + 1;
            } else {
                int[] iArr2 = FmUtils.mIndexRadio;
                int i2 = FmUtils.mBand - 1;
                iArr2[i2] = iArr2[i2] - 1;
            }
            if (FmUtils.mIndexRadio[FmUtils.mBand - 1] < 0) {
                FmUtils.mIndexRadio[FmUtils.mBand - 1] = 0;
            }
            Log.d("gdy11", " 111 radio radio_Channel mIndexRadio = " + FmUtils.mIndexRadio[FmUtils.mBand - 1]);
            int indexStart = (FmUtils.mBand - 1) * 6;
            List<SparseArray<String>> listRadio = App_Radio.getInstance().mListRadio;
            if (listRadio != null && listRadio.size() > FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart) {
                SparseArray<String> map = listRadio.get(FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart);
                float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
                App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
                Log.d("gdy11", " 222 radio radio_Channel freq = " + freq);
                FmUtils.mDispStation = FmUtils.trans2KB(freq);
                RadioM.PROXY.cmd(26, 0, FmUtils.trans2KB(freq));
                App_Radio.getInstance().sendRadioInfo2Mcu();
            }
        }
    }
}
