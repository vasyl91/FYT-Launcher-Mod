package com.syu.radio;

import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemProperties;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.android.fmradio.FmChannel;
import com.android.fmradio.FmNative;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApp;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.app.MyUi;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.util.Markup;
import com.lsec.core.util.MySharePreference2;
import com.lsec.core.util.data.FinalChip;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.pekall.fmradio.FMRadioNativeInterface;
import com.pekall.fmradio.FMRadioService;
import com.pekall.fmradio.FmRadio_Sofia;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.broadcast.Receiver;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.data.FinalRadioType;
import com.syu.radio.db.Radio_FreqBk;
import com.syu.radio.db.Radio_Info;
import com.syu.radio.fmbd.FmLogoBean;
import com.syu.radio.fmbd.FmbdlistBean;
import com.syu.radio.netchannel.NetChannel;
import com.syu.radio.runnable.RunnableUpdate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class App_Radio extends MyApp {
    public static File FmLogoPath = null;
    public static File FmbdPath = null;
    public static final int MODULE_RADIO_ARM = 4;
    public static final int MODULE_RADIO_BY_MCU = 1;
    public static final int MODULE_RADIO_DAB = 2;
    public static final int MODULE_RADIO_INNER = 3;
    public static final int MODULE_RADIO_NULL = 0;
    public static final int RadioType_6025 = 2;
    public static final int RadioType_Local = 1;
    public static final int RadioType_Sophia = 3;
    public static final String StrThreadCheckNet = "check net";
    public static final int Type_Album = 2;
    public static final int Type_Broadcast = 3;
    public static final int Type_SmartRadio = 1;
    public static App_Radio instance;
    public Method fytGetState;
    public Method fytSetState;
    public Radio_FreqBk mRadioFreqBkManager;
    public Radio_Info mRadioInfoManager;
    public Method startForegroundService;
    public static List<FmbdlistBean> FmbdBeans = new ArrayList();
    public static List<FmLogoBean> FmLogoBeans = new ArrayList();
    public static boolean FmLogoToList = false;
    public static boolean bFmbdDlgShow = false;
    public static boolean bUI_Colour_DayNight = false;
    public static int mNightDay = 0;
    public static boolean bFocus = false;
    public static ArrayList<Interface_Radio> mInterfaceRadio = new ArrayList<>();
    public static String mCity = FinalChip.BSP_PLATFORM_Null;
    public static String mStrAlbum = FinalChip.BSP_PLATFORM_Null;
    public static int ro_af = 255;
    public static int DEVICE_OUT_FM_HEADSET = 0;
    public static int mFacturer_Id = 0;
    public static String mStrCustomer = FinalChip.BSP_PLATFORM_Null;
    public static int iPageCur = -1;
    public static int iRadioType_Arm = 0;
    public static boolean bRadioType_RDS = true;
    public static boolean bMinusOrPlus_UnNormal = false;
    public static boolean bScan_UnNormal = false;
    public static boolean bChannelAddP = false;
    public static boolean bChannelFreqAddHeadTail = false;
    public static boolean bChannelFreqAddTail = false;
    public static boolean bChannelFreqAddHead = false;
    public static boolean bLocChinese = false;
    public static boolean bStChinese = false;
    public static boolean bHideStLoc = false;
    public static boolean bRuRadioName = false;
    public static boolean bFmOnline = false;
    public static boolean bFmLogoByPng = false;
    public static int iFmOnlineType = 0;
    public static boolean bIsRadioArmExt = false;
    public static boolean bNeedSetBtnBk = false;
    public static boolean bChangeChannelText = false;
    public static boolean bChangeBand = false;
    public static boolean bHideSetSystemUI = false;
    public static boolean bSwitchBandFromFm2Am = true;
    public static boolean bSwitchBandWhenScroll = false;
    public static boolean bOnlyFM = false;
    public static boolean bSetFocus = false;
    public static boolean bSetTransparent = false;
    public static boolean bCustomerId = false;
    public static boolean bUI_Colour_Enable = false;
    public static boolean bUI_NightColour = false;
    public static boolean bFreq_List_Type = false;
    public static int mBkWidth = 0;
    public static float RulerScale = 1.0f;
    public static int mFreqWidth = 0;
    public static int mTypeRadio_No = 0;
    public static int mLongClick_Time = 0;
    public static int mGpsFreq_Top = 0;
    public static int mGpsFreq_Size = 0;
    public static int mSens_Step = 10;
    public static int mTypeRadio = 1;
    public static int mSupportVal = 0;
    public static boolean bHasSupportProp = false;
    public static String mStrFreqCur = FinalChip.BSP_PLATFORM_Null;
    public static boolean isTranslucent = false;
    public static boolean isKeyRoll_NotFocus = false;
    public static long lSeekMillis1 = 0;
    public static long lSeekMillis2 = 0;
    public static long lSeekTaMillis1 = 0;
    public static long lSeekTaMillis2 = 0;
    public static long lSeekPtyMillis1 = 0;
    public static long lSeekPtyMillis2 = 0;
    public static int ret33 = -1;
    public static FmService mService = null;
    public static FmRadio_Sofia mFmRadio_Sofia = null;
    public static int[] mDatas = new int[7];
    public static int mColoerType = 0;
    public static Comparator<FmChannel> comparatorFmStrength = new Comparator<FmChannel>() { // from class: com.syu.radio.App_Radio.2
        @Override // java.util.Comparator
        public int compare(FmChannel lData, FmChannel rData) {
            if (App_Radio.bFreq_List_Type) {
                return 1;
            }
            return rData.strength - lData.strength;
        }
    };
    public boolean bEnableHalfScreen = false;
    public int[] UIUtil_XY = new int[2];
    public Radio_IpcObj mIpcObj = new Radio_IpcObj();
    private Receiver mReceiver = new Receiver();
    public String mClockId = FinalChip.BSP_PLATFORM_Null;
    public int mPlayPos = 0;
    public List<SparseArray<String>> mListRadio = new ArrayList();
    public List<SparseArray<String>> mListRadio_FM = new ArrayList();
    public List<SparseArray<String>> mListRadio_AM = new ArrayList();
    public List<FmChannel> mListFmChannels = new ArrayList();
    public List<FmChannel> mListAmChannels = new ArrayList();
    public HashMap<String, String> mHashMapUrlFix = new HashMap<>();
    public boolean mIsServiceBinded = false;
    public ServiceConnection mServiceConnection = null;
    public Intent mIntentFmService = null;
    public RunnableBindService mRunnableBindService = null;
    RunnableRefreshStationUI mRunnableRefreshStationUI = new RunnableRefreshStationUI(this, null);
    private Runnable mRunnableDisLoading = new Runnable() { // from class: com.syu.radio.App_Radio.1
        @Override // java.lang.Runnable
        public void run() {
            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                interfaceRadio.disLoading();
            }
        }
    };
    public Runnable mRunnableUpdateList = new Runnable() { // from class: com.syu.radio.App_Radio.3
        @Override // java.lang.Runnable
        public void run() {
            App_Radio.this.mListRadio.clear();
            int size = App_Radio.this.mListRadio_FM.size();
            for (int i = size; i < 18; i++) {
                SparseArray<String> map = new SparseArray<>();
                String strFreq = String.format(Locale.US, "%.02f", Float.valueOf(FmUtils.trans2Freq(FmUtils.mFreqDefault[i])));
                map.put(FinalRadioCtrl.RadioItem6025_Freq, strFreq);
                App_Radio.this.mListRadio_FM.add(map);
            }
            int size2 = App_Radio.this.mListRadio_AM.size();
            for (int i2 = size2; i2 < 12; i2++) {
                SparseArray<String> map2 = new SparseArray<>();
                String strFreq2 = String.format(Locale.US, "%d", Integer.valueOf(FmUtils.mFreqDefault[i2 + 18]));
                map2.put(FinalRadioCtrl.RadioItem6025_Freq, strFreq2);
                App_Radio.this.mListRadio_AM.add(map2);
            }
            App_Radio.this.mListRadio.addAll(App_Radio.this.mListRadio_FM);
            App_Radio.this.mListRadio.addAll(App_Radio.this.mListRadio_AM);
        }
    };
    public Runnable mRunnable_SeekPty = new Runnable() { // from class: com.syu.radio.App_Radio.4
        @Override // java.lang.Runnable
        public void run() {
            switch (Main.mConf_PlatForm) {
                case 5:
                    if (App_Radio.mFmRadio_Sofia != null) {
                        for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                            interfaceRadio.stopScan();
                        }
                        for (Interface_Radio interfaceRadio2 : App_Radio.mInterfaceRadio) {
                            interfaceRadio2.showLoading();
                        }
                        App_Radio.mFmRadio_Sofia.seekStationAsync_PTY(FmUtils.mCurStation);
                    }
                    break;
                default:
                    if (App_Radio.mService != null) {
                        for (Interface_Radio interfaceRadio3 : App_Radio.mInterfaceRadio) {
                            interfaceRadio3.stopScan();
                        }
                        for (Interface_Radio interfaceRadio4 : App_Radio.mInterfaceRadio) {
                            interfaceRadio4.showLoading();
                        }
                        float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                        App_Radio.mService.seekStationAsync_PTY(freq);
                    }
                    break;
            }
        }
    };
    public Runnable mRunnable_SeekTa = new Runnable() { // from class: com.syu.radio.App_Radio.5
        @Override // java.lang.Runnable
        public void run() {
            switch (Main.mConf_PlatForm) {
                case 5:
                    if (App_Radio.mFmRadio_Sofia != null) {
                        for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                            interfaceRadio.stopScan();
                        }
                        int[] state = FmService.getRdsConf();
                        if (state != null && state[0] == 1) {
                            for (Interface_Radio interfaceRadio2 : App_Radio.mInterfaceRadio) {
                                interfaceRadio2.showLoading();
                            }
                            App_Radio.mFmRadio_Sofia.seekStationAsync_TA(FmUtils.mCurStation);
                            break;
                        }
                    }
                    break;
                default:
                    if (App_Radio.mService != null) {
                        for (Interface_Radio interfaceRadio3 : App_Radio.mInterfaceRadio) {
                            interfaceRadio3.stopScan();
                        }
                        int[] state2 = FmService.getRdsConf();
                        if (state2 != null && state2[0] == 1) {
                            for (Interface_Radio interfaceRadio4 : App_Radio.mInterfaceRadio) {
                                interfaceRadio4.showLoading();
                            }
                            float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                            App_Radio.mService.seekStationAsync_TA(freq);
                            break;
                        }
                    }
                    break;
            }
        }
    };

    public static App_Radio getInstance() {
        if (instance == null) {
            instance = new App_Radio();
        }
        return instance;
    }

    public App_Radio() {
        this.uiApp = new MyUi(MyApplication.myApp, null, FinalRadioType.class, null);
        this.sPage = FinalRadioCtrl.Page_Radio;
        this.mySharePreference2 = new MySharePreference2();
        this.mySharePreference2.init(MyApplication.myApp, "radio_data");
    }

    public void onCreate(MyApplication myApplication) throws Throwable {
        String[] strs;
        this.myApplication = myApplication;
        Log.d("gdy7", " 00 App_Radio onCreate  bFmLogoByPng = " + bFmLogoByPng);
        readConf();
        if (bFmOnline) {
            read_list();
        }
        if (bFmLogoByPng) {
            read_logolist();
        }
        getMethod();
        this.mRadioInfoManager = new Radio_Info(MyApplication.myApp);
        this.mRadioFreqBkManager = new Radio_FreqBk(MyApplication.myApp);
        if (bUI_Colour_Enable) {
            mColoerType = SystemProperties.getInt("persist.fyt.selectcolor", 2);
            switch (mColoerType) {
                case 0:
                    MyUi.mStrHeadDrawable = "pink_";
                    break;
                case 1:
                    MyUi.mStrHeadDrawable = "red_";
                    break;
                default:
                    MyUi.mStrHeadDrawable = FinalChip.BSP_PLATFORM_Null;
                    break;
            }
        }
        Bundle inparam1 = new Bundle();
        Bundle outparam1 = new Bundle();
        ret33 = test_fmsyu_jni(33, inparam1, outparam1);
        InitBroadCast();
        this.mIpcObj.initIpc();
        NetChannel netChannel = NetChannel.getInstance(MyApplication.myApp);
        MyApplication.startThread(MyApplication.mStrZipTag, StrThreadCheckNet, netChannel.mRunnable_CheckNet, true, 1);
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(MyApplication.myApp).memoryCacheExtraOptions(480, 800).threadPoolSize(3).threadPriority(3).denyCacheImageMultipleSizesInMemory().memoryCache(new UsingFreqLimitedMemoryCache(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END)).memoryCacheSize(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END).discCacheSize(52428800).discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).discCacheFileCount(100).discCache(new UnlimitedDiscCache(new File(Environment.getExternalStorageDirectory() + "/myApp/imgCache"))).imageDownloader(new BaseImageDownloader(MyApplication.myApp, BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT, 30000)).build();
        ImageLoader.getInstance().init(configuration);
        FmUtils.mBand = FmStation.getCurrentBand();
        if ((FmUtils.mBand < 1 || FmUtils.mBand > 3) && (FmUtils.mBand < 4 || FmUtils.mBand > 5)) {
            FmUtils.mBand = 1;
            FmStation.saveCurrentBand();
        }
        switch (iRadioType_Arm) {
            case 1:
            case 2:
            case 3:
                if (iRadioType_Arm == 3) {
                    if (bIsRadioArmExt) {
                        FmUtils.mFmSens_Default = 20;
                        FmUtils.mAmSens_Default = 20;
                    } else {
                        FmUtils.mFmSens_Default = 18;
                        FmUtils.mAmSens_Default = 18;
                    }
                } else {
                    FmUtils.mFmSens_Default = 22;
                    FmUtils.mAmSens_Default = 47;
                    FmUtils.mFmSens_Min = 20;
                    FmUtils.mFmSens_Max = 50;
                    FmUtils.mAmSens_Min = 45;
                    FmUtils.mAmSens_Max = 75;
                }
                mSupportVal = SystemProperties.getInt("persist.fyt.fm.surport", -1);
                if (mSupportVal != -1) {
                    bHasSupportProp = true;
                } else {
                    mSupportVal = 0;
                }
                String strSens = SystemProperties.get("persist.fyt.fm.default");
                if (!TextUtils.isEmpty(strSens) && (strs = strSens.split(" ")) != null && strs.length >= 6) {
                    FmUtils.mFmSens_Default = Integer.parseInt(strs[0]);
                    FmUtils.mFmSens_Min = Integer.parseInt(strs[1]);
                    FmUtils.mFmSens_Max = Integer.parseInt(strs[2]);
                    FmUtils.mAmSens_Default = Integer.parseInt(strs[3]);
                    FmUtils.mAmSens_Min = Integer.parseInt(strs[4]);
                    FmUtils.mAmSens_Max = Integer.parseInt(strs[5]);
                }
                break;
        }
        Log.d("gdy11", " 11 App_Radio onCreate  iRadioType_Arm = " + iRadioType_Arm);
        switch (iRadioType_Arm) {
            case 1:
                if (FmUtils.mBand >= 4) {
                    FmUtils.mBand = 1;
                    FmStation.saveCurrentBand();
                }
                if (FmService.getCurrentArea() != 2) {
                    FmService.setCurrentArea(2);
                }
                break;
            case 3:
                if (!isSupportAm() && FmUtils.mBand >= 4) {
                    FmUtils.mBand = 1;
                    FmStation.saveCurrentBand();
                }
                if (!isSupportArea() && FmService.getCurrentArea() != 2) {
                    FmService.setCurrentArea(2);
                }
                break;
        }
        FmUtils.mCurStation = FmStation.getCurrentStation();
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                if (this.mServiceConnection == null) {
                    this.mServiceConnection = new ServiceConnection() { // from class: com.syu.radio.App_Radio.6
                        @Override // android.content.ServiceConnection
                        public void onServiceConnected(ComponentName className, IBinder service) {
                            App_Radio.mService = ((FmService.ServiceBinder) service).getService();
                            if (App_Radio.mService != null) {
                                if (!App_Radio.mService.isServiceInited()) {
                                    App_Radio.mService.initService(FmUtils.mCurStation);
                                }
                                Log.d("gdy11", " 66 App_Radio onCreate  iRadioType_Arm = " + App_Radio.iRadioType_Arm);
                                App_Radio.this.handleRightAppId();
                            }
                        }

                        @Override // android.content.ServiceConnection
                        public void onServiceDisconnected(ComponentName arg0) {
                        }
                    };
                }
                this.mRunnableBindService = new RunnableBindService();
                Main.postRunnable_Ui(false, this.mRunnableBindService);
                break;
        }
        if (SystemProperties.getInt("ro.fyt.fmsens", 0) != 0) {
            FmUtils.mFmSens_Default = SystemProperties.getInt("ro.fyt.fmsens", 0);
        }
        if (SystemProperties.getInt("ro.fyt.amsens", 0) != 0) {
            FmUtils.mAmSens_Default = SystemProperties.getInt("ro.fyt.amsens", 0);
        }
        int ro_rds = SystemProperties.getInt("ro.fyt.rdsonoff", 255);
        int rds_p = SystemProperties.getInt("sys.fyt.rdsonoff", 255);
        Log.d("gdy", " 00 ** postRunnable_Ui   App init  ro_rds = " + ro_rds + " rds_p = " + rds_p);
        if ((ro_rds == 0 || ro_rds == 1) && ro_rds != rds_p) {
            FmService.setRdsOnOff(ro_rds);
            SystemProperties.set("sys.fyt.rdsonoff", new StringBuilder().append(ro_rds).toString());
        }
        ro_af = SystemProperties.getInt("ro.fyt.afonoff", 255);
        if (ro_af != 255) {
            Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.App_Radio.7
                @Override // java.lang.Runnable
                public void run() {
                    int af_p = SystemProperties.getInt("sys.fyt.afonoff", 255);
                    if (af_p == 255) {
                        FmService.setRdsAfOnOff(App_Radio.ro_af);
                    } else {
                        FmService.setRdsAfOnOff(af_p);
                    }
                }
            }, 3000L);
        }
        Log.d("gdy10", " 00 ** postRunnable_Ui   App init  mStrCustomer = " + mStrCustomer);
        if (mStrCustomer.equals("YL_3")) {
            bUI_NightColour = true;
        }
        if (mStrCustomer.equals("TZY_NEW") && MyApplication.mStrFolderAsset != null) {
            Log.d("gdy10", " 01 ** postRunnable_Ui   App init  mStrFolderAsset = " + MyApplication.mStrFolderAsset);
            if (MyApplication.mStrFolderAsset.equals("UI7")) {
                bUI_NightColour = true;
            }
        }
        Log.d("gdy11", " 22 App_Radio onCreate  ");
    }

    public void handleRightAppId() {
        Log.d("gdy11", " 00 handleRightAppId U_APP_ID = " + Main.DATA[0] + " iRadioType_Arm = " + iRadioType_Arm);
        if (Main.DATA[0] == 1) {
            getData_RadioArm(MyApplication.myApp.getContentResolver());
            switch (iRadioType_Arm) {
                case 1:
                case 2:
                    Log.d("gdy11", " 11 handleRightAppId mService == null ? ");
                    if (mService != null) {
                        float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                        Log.d("gdy11", " 22 handleRightAppId mService != null freq= " + freq);
                        mService.powerUp_Async(freq);
                        for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                            interfaceRadio.checkTuneFromSpeech();
                        }
                    }
                    break;
                case 3:
                    RadioSophia_PowerOn();
                    break;
            }
        }
    }

    public class RunnableBindService implements Runnable {
        public boolean bRun = true;

        public RunnableBindService() {
        }

        public void stopRun() {
            this.bRun = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent;
            if (this.bRun) {
                if (!App_Radio.this.mIsServiceBinded) {
                    if (App_Radio.this.mIntentFmService == null && (intent = new Intent(MyApplication.myApp, (Class<?>) FmService.class)) != null) {
                        try {
                            if (MyApplication.myApp.startService(intent) != null) {
                                App_Radio.this.mIntentFmService = intent;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (App_Radio.this.mIntentFmService != null) {
                        App_Radio.this.mIsServiceBinded = MyApplication.myApp.bindService(new Intent(MyApplication.myApp, (Class<?>) FmService.class), App_Radio.this.mServiceConnection, 1);
                    }
                }
                if (!App_Radio.this.mIsServiceBinded) {
                    Main.postRunnable_Ui(true, this, 1000L);
                }
            }
        }
    }

    public void saveSet() throws Throwable {
        this.mySharePreference2.saveIntValue("TypeRadio", mTypeRadio);
    }

    public void readSet() {
        mTypeRadio = this.mySharePreference2.getIntValue("TypeRadio", mTypeRadio);
        FmService.mPtyConf = this.mySharePreference2.getIntValue("PtyConf", FmService.mPtyConf);
    }

    public void InitBroadCast() {
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(Receiver.REMOVE_BROADCAST);
        iFilter.addAction(Receiver.Gallery_SetPic);
        iFilter.setPriority(Integer.MAX_VALUE);
        MyApplication.myApp.registerReceiver(this.mReceiver, iFilter);
    }

    @Override // com.lsec.core.frame.app.MyApp
    public void requestAppIdRight() {
        this.mIpcObj.requestAppIdRight();
    }

    public void doAfterSucc(boolean bAdd, Act_Radio actRadio) {
        if (actRadio != null) {
            actRadio.initlist(true, bAdd, true);
        }
    }

    public class RunnableDoAfterSucc implements Runnable {
        private Act_Radio actRadio;
        private boolean bAdd;

        public RunnableDoAfterSucc(boolean bAdd, Act_Radio actRadio) {
            this.bAdd = bAdd;
            this.actRadio = actRadio;
        }

        @Override // java.lang.Runnable
        public void run() {
            App_Radio.this.doAfterSucc(this.bAdd, this.actRadio);
        }
    }

    public void add(SparseArray<String> map, Act_Radio actRadio) {
        this.mRadioInfoManager.add(map);
        if (actRadio != null) {
            Main.postRunnable_Ui(false, new RunnableDoAfterSucc(true, actRadio));
        }
    }

    public void update(SparseArray<String> map, Act_Radio actRadio) {
        this.mRadioInfoManager.update(map);
        if (actRadio != null) {
            Main.postRunnable_Ui(false, new RunnableDoAfterSucc(false, actRadio));
        }
    }

    public class RunnableAdd implements Runnable {
        private Act_Radio actRadio;
        private SparseArray<String> map;

        public RunnableAdd(SparseArray<String> map, Act_Radio actRadio) {
            this.map = map;
            this.actRadio = actRadio;
        }

        @Override // java.lang.Runnable
        public void run() {
            App_Radio.this.add(this.map, this.actRadio);
        }
    }

    public int[] InsertOrUpdate(SparseArray<String> map, Act_Radio actRadio) {
        int[] flags = null;
        if (this.mRadioInfoManager != null) {
            flags = new int[]{this.mRadioInfoManager.queryFreq(map), this.mRadioInfoManager.queryName(map)};
            if (flags[1] == 0 && flags[0] == 0) {
                MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new RunnableAdd(map, actRadio), false, 1);
            } else if (flags[1] == 0 && flags[0] != 0) {
                map.put(FinalRadioCtrl.Item_Index, Integer.toString(flags[0]));
                MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new RunnableUpdate(map, actRadio), false, 1);
            }
        }
        return flags;
    }

    public void getRadioRangeAndFreqDefault() {
        Log.d("scan", " 11 getRadioRangeAndFreqDefault iRadioType_Arm = " + iRadioType_Arm + "LOWEST_STATION_FM = " + FmUtils.LOWEST_STATION_FM);
        switch (iRadioType_Arm) {
            case 2:
            case 3:
                Bundle inparam = new Bundle();
                inparam.putInt("setradioarea", FmService.getCurrentArea() + 1);
                Bundle outparam = new Bundle();
                int ret = test_fmsyu_jni(20, inparam, outparam);
                if (ret == 0) {
                    int[] range = outparam.getIntArray("radiorangs");
                    int[] freqdefault = outparam.getIntArray("defaultband");
                    if (range != null && range.length >= 9) {
                        FmUtils.HIGHEST_STATION_FM = range[0];
                        FmUtils.LOWEST_STATION_FM = range[1];
                        Log.d("scan", " 22 getRadioRangeAndFreqDefault LOWEST_STATION_FM = " + FmUtils.LOWEST_STATION_FM);
                        FmUtils.STEP_FM = range[2];
                        FmUtils.HIGHEST_STATION_AM = range[3];
                        FmUtils.LOWEST_STATION_AM = range[4];
                        FmUtils.STEP_AM = range[5];
                        FmUtils.HIGHEST_STATION_OIRT = range[6];
                        FmUtils.LOWEST_STATION_OIRT = range[7];
                        FmUtils.STEP_OIRT = range[8];
                    }
                    if (freqdefault != null && freqdefault.length >= 30) {
                        for (int i = 0; i < 30; i++) {
                            FmUtils.mFreqDefault[i] = freqdefault[i];
                        }
                        break;
                    }
                }
                break;
        }
    }

    public boolean isRadioArmExternalSt_6025() {
        if (FmUtils.mBand <= 3) {
            Bundle inparam = new Bundle();
            Bundle outparam = new Bundle();
            outparam.putInt("monostero", 0);
            int ret = test_fmsyu_jni(9, inparam, outparam);
            if (ret == 0 && 1 == outparam.getInt("monostero", 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRadioArmExternalStOpen_6025() {
        if (FmUtils.mBand <= 3) {
            Bundle inparam = new Bundle();
            Bundle outparam = new Bundle();
            outparam.putInt("isforcemono", 0);
            int ret = test_fmsyu_jni(19, inparam, outparam);
            if (ret == 0 && 1 == outparam.getInt("isforcemono", 0)) {
                return true;
            }
        }
        return false;
    }

    public void setRadioArmExternalForceMono_6025(boolean bForceMono) {
        Bundle inparam = new Bundle();
        inparam.putInt("forcemono", bForceMono ? 1 : 0);
        Bundle outparam = new Bundle();
        outparam.putInt("forcemono", 0);
        test_fmsyu_jni(10, inparam, outparam);
    }

    public void readConf() throws Throwable {
        String str;
        try {
            String strXml = this.uiApp.getRaw("conf_platform");
            if (!TextUtils.isEmpty(strXml)) {
                Markup xml = new Markup();
                xml.ReadXML(strXml);
                if (xml.IntoItem()) {
                    do {
                        String strTemp = xml.GetAttr(Radio_Info.NAME);
                        if (strTemp != null) {
                            if (strTemp.equals("EnableFocusChange")) {
                                String str2 = xml.GetAttr("value");
                                if (str2 != null && str2.equals("1")) {
                                    this.bEnableFocusChange = true;
                                }
                            } else if (strTemp.equals("EnableHalfScreen")) {
                                String str3 = xml.GetAttr("value");
                                if (str3 != null && str3.equals("1")) {
                                    this.bEnableHalfScreen = true;
                                }
                            } else if (strTemp.equals("NeedSetBtnBk")) {
                                String str4 = xml.GetAttr("value");
                                if (str4 != null && str4.equals("1")) {
                                    bNeedSetBtnBk = true;
                                }
                            } else if (strTemp.equals("SwitchBandFromFm2Am")) {
                                String str5 = xml.GetAttr("value");
                                if (str5 != null && str5.equals("0")) {
                                    bSwitchBandFromFm2Am = false;
                                }
                            } else if (strTemp.equals("SwitchBandWhenScroll")) {
                                String str6 = xml.GetAttr("value");
                                if (str6 != null && str6.equals("1")) {
                                    bSwitchBandWhenScroll = true;
                                }
                            } else if (strTemp.equals("Translucent")) {
                                String str7 = xml.GetAttr("value");
                                if (str7 != null && str7.equals("1")) {
                                    isTranslucent = true;
                                }
                            } else if (strTemp.equals("KeyRoll_NotFocus")) {
                                String str8 = xml.GetAttr("value");
                                if (str8 != null && str8.equals("1")) {
                                    isKeyRoll_NotFocus = true;
                                }
                            } else if (strTemp.equals("ChangeChannelText")) {
                                String str9 = xml.GetAttr("value");
                                if (str9 != null && str9.equals("1")) {
                                    bChangeChannelText = true;
                                }
                            } else if (strTemp.equals("ChangeBand")) {
                                String str10 = xml.GetAttr("value");
                                if (str10 != null && str10.equals("1")) {
                                    bChangeBand = true;
                                }
                            } else if (strTemp.equals("HideSetSystemUI")) {
                                String str11 = xml.GetAttr("value");
                                if (str11 != null && str11.equals("1")) {
                                    bHideSetSystemUI = true;
                                }
                            } else if (strTemp.equals("MinusOrPlus_UnNormal")) {
                                String str12 = xml.GetAttr("value");
                                if (str12 != null && str12.equals("1")) {
                                    bMinusOrPlus_UnNormal = true;
                                }
                            } else if (strTemp.equals("Scan_UnNormal")) {
                                String str13 = xml.GetAttr("value");
                                if (str13 != null && str13.equals("1")) {
                                    bScan_UnNormal = true;
                                }
                            } else if (strTemp.equals("UI_Colour_Enable")) {
                                String str14 = xml.GetAttr("value");
                                if (str14 != null && str14.equals("1")) {
                                    bUI_Colour_Enable = true;
                                }
                            } else if (strTemp.equals("UI_Colour_DayNight")) {
                                String str15 = xml.GetAttr("value");
                                if (str15 != null && str15.equals("1")) {
                                    bUI_Colour_DayNight = true;
                                }
                            } else if (strTemp.equals("Freq_List_Type")) {
                                String str16 = xml.GetAttr("value");
                                if (str16 != null && str16.equals("1")) {
                                    bFreq_List_Type = true;
                                }
                            } else if (strTemp.equals("ChannelAddP")) {
                                String str17 = xml.GetAttr("value");
                                if (str17 != null && str17.equals("1")) {
                                    bChannelAddP = true;
                                }
                            } else if (strTemp.equals("ChannelFreqAddHeadTail")) {
                                String str18 = xml.GetAttr("value");
                                if (str18 != null && str18.equals("1")) {
                                    bChannelFreqAddHeadTail = true;
                                }
                            } else if (strTemp.equals("TypeRadio_No")) {
                                String str19 = xml.GetAttr("value");
                                if (str19 != null) {
                                    mTypeRadio_No = Integer.parseInt(str19);
                                }
                            } else if (strTemp.equals("facturer_id")) {
                                String str20 = xml.GetAttr("value");
                                if (str20 != null) {
                                    mFacturer_Id = Integer.parseInt(str20);
                                }
                            } else if (strTemp.equals("customer")) {
                                String str21 = xml.GetAttr("value");
                                if (str21 != null) {
                                    mStrCustomer = str21;
                                }
                            } else if (strTemp.equals("mBkWidth")) {
                                String str22 = xml.GetAttr("value");
                                if (str22 != null) {
                                    mBkWidth = Integer.parseInt(str22);
                                }
                            } else if (strTemp.equals("mFreqWidth")) {
                                String str23 = xml.GetAttr("value");
                                if (str23 != null) {
                                    mFreqWidth = Integer.parseInt(str23);
                                }
                            } else if (strTemp.equals("LongClick_Time")) {
                                String str24 = xml.GetAttr("value");
                                if (str24 != null) {
                                    mLongClick_Time = Integer.parseInt(str24);
                                }
                            } else if (strTemp.equals("GpsFreq_Top")) {
                                String str25 = xml.GetAttr("value");
                                if (str25 != null) {
                                    mGpsFreq_Top = Integer.parseInt(str25);
                                }
                            } else if (strTemp.equals("GpsFreq_Size")) {
                                String str26 = xml.GetAttr("value");
                                if (str26 != null) {
                                    mGpsFreq_Size = Integer.parseInt(str26);
                                }
                            } else if (strTemp.equals("Sens_Step")) {
                                String str27 = xml.GetAttr("value");
                                if (str27 != null) {
                                    mSens_Step = Integer.parseInt(str27);
                                }
                            } else if (strTemp.equals("ChannelFreqAddHead")) {
                                String str28 = xml.GetAttr("value");
                                if (str28 != null && str28.equals("1")) {
                                    bChannelFreqAddHead = true;
                                }
                            } else if (strTemp.equals("ChannelFreqAddTail")) {
                                String str29 = xml.GetAttr("value");
                                if (str29 != null && str29.equals("1")) {
                                    bChannelFreqAddTail = true;
                                }
                            } else if (strTemp.equals("RuRadioName")) {
                                String str30 = xml.GetAttr("value");
                                if (str30 != null && str30.equals("1")) {
                                    bRuRadioName = true;
                                }
                            } else if (strTemp.equals("FmOnline")) {
                                String str31 = xml.GetAttr("value");
                                if (str31 != null) {
                                    if (str31.equals("1")) {
                                        bFmOnline = true;
                                    } else if (str31.equals("2")) {
                                        bFmOnline = true;
                                        iFmOnlineType = 1;
                                    }
                                }
                            } else if (strTemp.equals("FmLogoByPng")) {
                                String str32 = xml.GetAttr("value");
                                if (str32 != null && str32.equals("1")) {
                                    bFmLogoByPng = true;
                                }
                            } else if (strTemp.equals("LocChinese")) {
                                String str33 = xml.GetAttr("value");
                                if (str33 != null && str33.equals("1")) {
                                    bLocChinese = true;
                                }
                            } else if (strTemp.equals("StChinese")) {
                                String str34 = xml.GetAttr("value");
                                if (str34 != null && str34.equals("1")) {
                                    bStChinese = true;
                                }
                            } else if (strTemp.equals("HideStLoc")) {
                                String str35 = xml.GetAttr("value");
                                if (str35 != null && str35.equals("1")) {
                                    bHideStLoc = true;
                                }
                            } else if (strTemp.equals("OnlyFM")) {
                                String str36 = xml.GetAttr("value");
                                if (str36 != null && str36.equals("1")) {
                                    bOnlyFM = true;
                                }
                            } else if (strTemp.equals("SetFocus")) {
                                String str37 = xml.GetAttr("value");
                                if (str37 != null && str37.equals("1")) {
                                    bSetFocus = true;
                                }
                            } else if (strTemp.equals("SetTransparent")) {
                                String str38 = xml.GetAttr("value");
                                if (str38 != null && str38.equals("1")) {
                                    bSetTransparent = true;
                                }
                            } else if (strTemp.equals("CustomerId") && (str = xml.GetAttr("value")) != null && str.equals("1")) {
                                bCustomerId = true;
                            }
                        }
                    } while (xml.NextItem());
                    xml.ExitItem();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkRadioType();
        Log.d("scan", " 00 readConf LOWEST_STATION_FM = " + FmUtils.LOWEST_STATION_FM);
        getRadioRangeAndFreqDefault();
    }

    public void checkRadioType() {
        int iRadioType = SystemProperties.getInt("sys.fyt.radio_type", 1);
        Log.d("rds", " checkRadioType iRadioType = " + iRadioType + " mConf_PlatForm = " + Main.mConf_PlatForm);
        if (iRadioType == 3) {
            switch (Main.mConf_PlatForm) {
                case 5:
                    iRadioType_Arm = 3;
                    break;
                case 6:
                case 8:
                    iRadioType_Arm = 1;
                    break;
            }
        } else if (iRadioType == 4) {
            bIsRadioArmExt = true;
            switch (Main.mConf_PlatForm) {
                case 5:
                    iRadioType_Arm = 3;
                    break;
                case 6:
                case 8:
                    iRadioType_Arm = 2;
                    break;
            }
        }
        if (iRadioType_Arm == 3 && mFmRadio_Sofia == null) {
            mFmRadio_Sofia = new FmRadio_Sofia();
            mFmRadio_Sofia.bindToService();
        }
    }

    public void getMethod() {
        Method[] methodActivityManager = ActivityManager.class.getDeclaredMethods();
        for (Method method : methodActivityManager) {
            if (method.getName().equals("fytgetState")) {
                this.fytGetState = method;
            } else if (method.getName().equals("fytsetState")) {
                this.fytSetState = method;
            }
        }
        Method[] methodContextWrapper = ContextWrapper.class.getDeclaredMethods();
        for (Method method2 : methodContextWrapper) {
            if (method2.getName().equals("startForegroundService")) {
                this.startForegroundService = method2;
            }
        }
        try {
            Class<?> class_AudioManager = Class.forName("android.media.AudioManager");
            if (class_AudioManager != null) {
                Field[] fields = class_AudioManager.getDeclaredFields();
                for (Field f : fields) {
                    if (f.getName().equals("DEVICE_OUT_FM_HEADSET")) {
                        f.setAccessible(true);
                        DEVICE_OUT_FM_HEADSET = f.getInt(class_AudioManager);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean isHalfScreenAble() {
        ActivityManager am;
        int iScreenMode = 0;
        if (this.fytGetState != null && (am = (ActivityManager) MyApplication.myApp.getSystemService("activity")) != null) {
            try {
                iScreenMode = ((Integer) this.fytGetState.invoke(am, new Object[0])).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (iScreenMode & 32) != 0;
    }

    public int getFullScreenMode() {
        ActivityManager am;
        int iScreenMode = -1;
        if (this.fytGetState != null && (am = (ActivityManager) MyApplication.myApp.getSystemService("activity")) != null) {
            try {
                iScreenMode = ((Integer) this.fytGetState.invoke(am, new Object[0])).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return iScreenMode & 15;
    }

    public void setFullScreenMode(int iScreenMode) {
        ActivityManager am;
        if (this.fytSetState != null && (am = (ActivityManager) MyApplication.myApp.getSystemService("activity")) != null) {
            boolean bNeedSet = true;
            if (iScreenMode == 16) {
                try {
                    int iCurScreenMode = ((Integer) this.fytGetState.invoke(am, new Object[0])).intValue();
                    if ((iCurScreenMode & 16) != 0) {
                        bNeedSet = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (bNeedSet) {
                try {
                    this.fytSetState.invoke(am, Integer.valueOf(iScreenMode));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void refreshUI() {
        for (Interface_Radio interfaceRadio : mInterfaceRadio) {
            interfaceRadio.refreshStationUI();
        }
    }

    public void refreshUI_InUiThread(int station) {
        this.mRunnableRefreshStationUI.setCurStation(station);
        Main.postRunnable_Ui(true, this.mRunnableRefreshStationUI);
    }

    private class RunnableRefreshStationUI implements Runnable {
        int station;

        private RunnableRefreshStationUI() {
        }

        /* synthetic */ RunnableRefreshStationUI(App_Radio app_Radio, RunnableRefreshStationUI runnableRefreshStationUI) {
            this();
        }

        public void setCurStation(int station) {
            this.station = station;
        }

        @Override // java.lang.Runnable
        public void run() {
            FmStation.saveCurrentStation(this.station);
            App_Radio.this.refreshUI();
        }
    }

    public void disLoading() {
        Main.postRunnable_Ui(true, this.mRunnableDisLoading);
    }

    public void getStableList(List<FmChannel> listDst, List<FmChannel> listSrc, int len, int station) {
        if (listDst != null && listSrc != null) {
            Collections.sort(listSrc, comparatorFmStrength);
            listDst.clear();
            int iCnt = 0;
            Iterator<FmChannel> it = listSrc.iterator();
            while (it.hasNext()) {
                listDst.add(it.next());
                iCnt++;
                if (iCnt >= len) {
                    break;
                }
            }
            while (iCnt < len) {
                FmChannel fmChannel = new FmChannel();
                fmChannel.station = station;
                fmChannel.strength = 0;
                listDst.add(fmChannel);
                iCnt++;
            }
        }
    }

    public void updateStations(List<FmChannel> listChannelsFM, List<FmChannel> listChannelsAM) {
        FmStation.cleanAllStations();
        int index = 0;
        if (listChannelsFM != null) {
            for (FmChannel fmChannel : listChannelsFM) {
                FmStation.insertStationToDb(index, fmChannel);
                index++;
            }
        }
        int index2 = 18;
        if (listChannelsAM != null) {
            for (FmChannel fmChannel2 : listChannelsAM) {
                FmStation.insertStationToDb(index2, fmChannel2);
                index2++;
            }
        }
    }

    public void getData_RadioArm(ContentResolver contentResolver) {
        boolean bValidStation;
        Log.d("gdy11", " 00 getData_RadioArm iRadioType_Arm = " + iRadioType_Arm);
        if (iRadioType_Arm > 0 && contentResolver != null) {
            try {
                this.mListFmChannels.clear();
                this.mListAmChannels.clear();
                Cursor cursor = contentResolver.query(FmStation.Station.CONTENT_URI, FmStation.COLUMNS, null, null, FmStation.Station.INDEX);
                Log.d("gdy11", " 11 getData_RadioArm iRadioType_Arm = " + iRadioType_Arm);
                if (cursor != null) {
                    Log.d("gdy11", " 22 getData_RadioArm iRadioType_Arm = " + iRadioType_Arm);
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        FmChannel fmChannel = new FmChannel();
                        fmChannel.station = cursor.getInt(cursor.getColumnIndex(FmStation.Station.FREQUENCY));
                        fmChannel.strength = cursor.getInt(cursor.getColumnIndex(FmStation.Station.STRENGTH));
                        int index = cursor.getInt(cursor.getColumnIndex(FmStation.Station.INDEX));
                        if (index < 18) {
                            if (fmChannel.station < 1081) {
                                fmChannel.station *= 10;
                            }
                            if (index < 6) {
                                bValidStation = FmUtils.isValidStation(fmChannel.station, 1);
                            } else {
                                bValidStation = FmUtils.isValidStation(fmChannel.station, 2);
                            }
                            if (bValidStation && this.mListFmChannels.size() < 18) {
                                this.mListFmChannels.add(fmChannel);
                            }
                        } else {
                            boolean bValidStation2 = FmUtils.isValidStation(fmChannel.station, 4);
                            if (bValidStation2 && this.mListAmChannels.size() < 12) {
                                this.mListAmChannels.add(fmChannel);
                            }
                        }
                        cursor.moveToNext();
                    }
                }
                boolean bNeedUpdateStation = false;
                int size = this.mListFmChannels.size();
                if (size < 18) {
                    for (int i = size; i < 18; i++) {
                        FmChannel fmChannel2 = new FmChannel();
                        fmChannel2.station = FmUtils.mFreqDefault[i];
                        fmChannel2.strength = 0;
                        this.mListFmChannels.add(fmChannel2);
                    }
                    bNeedUpdateStation = true;
                }
                int size2 = this.mListAmChannels.size();
                if (size2 < 12) {
                    for (int i2 = size2; i2 < 12; i2++) {
                        FmChannel fmChannel3 = new FmChannel();
                        fmChannel3.station = FmUtils.mFreqDefault[i2 + 18];
                        fmChannel3.strength = 0;
                        this.mListAmChannels.add(fmChannel3);
                    }
                    bNeedUpdateStation = true;
                }
                Log.d("gdy11", " 33 getData_RadioArm iRadioType_Arm = " + iRadioType_Arm);
                getListRadioFm(this.mListFmChannels);
                getListRadioAm(this.mListAmChannels);
                if (bNeedUpdateStation) {
                    updateStations(this.mListFmChannels, this.mListAmChannels);
                    for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                        interfaceRadio.jump1stChannel();
                    }
                }
                for (Interface_Radio interfaceRadio2 : mInterfaceRadio) {
                    interfaceRadio2.updateListRadio();
                }
            } catch (Exception e) {
            }
        }
    }

    public void getListRadioFm(List<FmChannel> listFmChannels) {
        if (listFmChannels != null) {
            this.mListRadio_FM.clear();
            for (FmChannel fmChannel : listFmChannels) {
                SparseArray<String> map = new SparseArray<>();
                String strFreq = String.format(Locale.US, "%.02f", Float.valueOf(FmUtils.trans2Freq(fmChannel.station)));
                map.put(FinalRadioCtrl.RadioItem6025_Freq, strFreq);
                this.mListRadio_FM.add(map);
            }
            Main.postRunnable_Ui(true, this.mRunnableUpdateList);
        }
    }

    public void getListRadioAm(List<FmChannel> listAmChannels) {
        if (listAmChannels != null) {
            this.mListRadio_AM.clear();
            for (FmChannel fmChannel : listAmChannels) {
                SparseArray<String> map = new SparseArray<>();
                String strFreq = String.format(Locale.US, "%d", Integer.valueOf(fmChannel.station));
                map.put(FinalRadioCtrl.RadioItem6025_Freq, strFreq);
                this.mListRadio_AM.add(map);
            }
            Main.postRunnable_Ui(true, this.mRunnableUpdateList);
        }
    }

    public void simulateKey(final int keyCode) {
        MyApplication.startThread(MyApplication.mStrZipTag, "ThreadSimulateKey", new Runnable() { // from class: com.syu.radio.App_Radio.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(keyCode);
                } catch (Exception e) {
                }
            }
        }, false, 5);
    }

    public void updateCurFreqName(JText txt, String strFreq) {
        RunnableQueryFreq runnableQueryFreq = new RunnableQueryFreq(txt, strFreq);
        MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", runnableQueryFreq, false, 1);
    }

    public class RunnableQueryFreq implements Runnable {
        String strFreq;
        JText txt;

        public RunnableQueryFreq(JText txt, String strFreq) {
            this.txt = txt;
            this.strFreq = strFreq;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.txt != null) {
                String name = App_Radio.this.mRadioInfoManager.queryFreq(this.strFreq);
                Main.postRunnable_Ui(false, App_Radio.this.new RunnableSetCurFreqName(this.txt, name));
            }
        }
    }

    public class RunnableSetCurFreqName implements Runnable {
        String name;
        JText txt;

        public RunnableSetCurFreqName(JText txt, String name) {
            this.txt = txt;
            this.name = name;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.txt != null) {
                this.txt.setText(this.name);
                Bundle data = new Bundle();
                data.putString("radio_name", this.name);
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.setAction("com.syu.widget.RadioService");
                intent.setPackage("com.android.launcher3");
                MyApplication.myApp.startServiceSafely(intent);
            }
        }
    }

    public static boolean isSupportRds() {
        bRadioType_RDS = (mSupportVal & 4) != 0;
        return (mSupportVal & 4) != 0;
    }

    public static boolean isSupportArea() {
        return (mSupportVal & 8) != 0;
    }

    public static boolean isSupportRds6025() {
        int iSupportRds = SystemProperties.getInt("persist.fyt.withrdsfn", 0);
        if (iSupportRds == 1) {
            return isSupportRds();
        }
        bRadioType_RDS = false;
        return false;
    }

    public static boolean isSupportAm() {
        if (iRadioType_Arm != 0) {
            return (bOnlyFM || iRadioType_Arm == 1 || (mSupportVal & 16) == 0) ? false : true;
        }
        int iSupportAm = SystemProperties.getInt("sys.fyt.radio_support_am", 1);
        return iSupportAm != 0;
    }

    public static boolean isSupportDispSearchFreq() {
        if (bHasSupportProp) {
            return (mSupportVal & 32) != 0;
        }
        return bIsRadioArmExt;
    }

    public static boolean isFreqMinusOrPlus(boolean bLongClick) {
        if (bMinusOrPlus_UnNormal) {
            if (bLongClick) {
                return true;
            }
            return false;
        }
        if (!bLongClick) {
            return true;
        }
        return false;
    }

    public static boolean isScan(boolean bLongClick) {
        if (bScan_UnNormal) {
            if (bLongClick) {
                return true;
            }
            return false;
        }
        if (!bLongClick) {
            return true;
        }
        return false;
    }

    public void setFreq(int station, boolean bStopScan) {
        Log.d("gdy11", " 11 App_Radio setFreq  station = " + station + " iRadioType_Arm = " + iRadioType_Arm);
        if (bStopScan && iRadioType_Arm != 0) {
            Iterator<Interface_Radio> it = mInterfaceRadio.iterator();
            while (it.hasNext()) {
                it.next().stopScan();
            }
        }
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                FmNative.getInstance().test_stopScan();
                if (mService != null && mService.mPowerStatus == 0) {
                    FmStation.saveCurrentStation(station);
                    for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                        interfaceRadio.refreshStationUI();
                        interfaceRadio.disLoading();
                    }
                    float freq = FmUtils.trans2Freq(station);
                    mService.tuneStationAsync(freq);
                    break;
                }
                break;
            case 3:
                if (mFmRadio_Sofia != null && mFmRadio_Sofia.mService != null) {
                    try {
                        FmStation.saveCurrentStation(station);
                        for (Interface_Radio interfaceRadio2 : mInterfaceRadio) {
                            interfaceRadio2.refreshStationUI();
                            interfaceRadio2.disLoading();
                        }
                        mFmRadio_Sofia.mStateSeekAll = 0;
                        mFmRadio_Sofia.mService.setFMFreq(station * 10);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                    break;
                }
                break;
            default:
                this.mIpcObj.setFreq(station);
                break;
        }
    }

    public void RadioSophia_PowerOn() {
        if (mFmRadio_Sofia != null) {
            mFmRadio_Sofia.powerOnFMRadio();
        }
        for (Interface_Radio interfaceRadio : mInterfaceRadio) {
            interfaceRadio.checkTuneFromSpeech();
        }
    }

    public void RadioSophia_PowerOff() {
        if (mFmRadio_Sofia != null) {
            mFmRadio_Sofia.powerOffFMRadio();
        }
    }

    public void Radio6025_PowerOff() {
        Radio6025_Mute();
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                if (mService != null) {
                    mService.exitFm();
                }
                break;
        }
    }

    public void Radio6025_PowerOffQuickly() {
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                if (mService != null) {
                    mService.powerDown(false);
                }
                break;
        }
    }

    public void Radio6025_Mute() {
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                if (mService != null) {
                    mService.setVolume(0);
                }
                break;
        }
    }

    public void Radio6025_UnMute() {
        if (this.mIpcObj.isRightAppId()) {
            switch (iRadioType_Arm) {
                case 1:
                case 2:
                    if (mService != null && !mService.isScanning()) {
                        mService.setVolume(15);
                        break;
                    }
                    break;
            }
        }
    }

    public void seekFMRadioStation_Sofia(int direction) {
        if (mFmRadio_Sofia != null && mFmRadio_Sofia.mService != null) {
            try {
                mFmRadio_Sofia.mStateSeekAll = 0;
                if (FmUtils.mBand <= 3) {
                    mFmRadio_Sofia.setFMRadioThreshold(FmUtils.getFmSensitivity(FmService.mLocFm));
                } else {
                    mFmRadio_Sofia.setFMRadioThreshold(FmUtils.getAmSensitivity());
                }
                mFmRadio_Sofia.mService.seekFM(direction);
            } catch (Exception e) {
            }
        }
    }

    public void seekDown() {
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                    interfaceRadio.showLoading();
                }
                if (mService != null) {
                    float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                    mService.seekStationAsync(freq, false);
                }
                break;
            case 3:
                for (Interface_Radio interfaceRadio2 : mInterfaceRadio) {
                    interfaceRadio2.showLoading();
                }
                seekFMRadioStation_Sofia(0);
                break;
            default:
                this.mIpcObj.SeekDown();
                break;
        }
    }

    public void seekUp() {
        switch (iRadioType_Arm) {
            case 1:
            case 2:
                for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                    interfaceRadio.showLoading();
                }
                if (mService != null) {
                    float freq = FmUtils.trans2Freq(FmUtils.mCurStation);
                    mService.seekStationAsync(freq, true);
                }
                break;
            case 3:
                for (Interface_Radio interfaceRadio2 : mInterfaceRadio) {
                    interfaceRadio2.showLoading();
                }
                seekFMRadioStation_Sofia(1);
                break;
            default:
                this.mIpcObj.SeekUp();
                break;
        }
    }

    public void sendRadioInfo2Mcu() {
        String strHighLightFreq;
        if (iRadioType_Arm != 0 && Main.DATA[0] == 1 && FmUtils.isValidStation(FmUtils.mDispStation)) {
            int[] datas = new int[7];
            datas[0] = 1;
            for (int i = 1; i < 7; i++) {
                datas[i] = 0;
            }
            if (FmUtils.mSearch) {
                datas[1] = datas[1] | 1;
            }
            if (FmUtils.mScan) {
                datas[1] = datas[1] | 2;
            }
            if (FmUtils.mBand <= 3) {
                switch (iRadioType_Arm) {
                    case 2:
                        if (FmStation.getCurrentForceMono() == 0) {
                            datas[1] = datas[1] | 4;
                            if (getInstance().isRadioArmExternalSt_6025()) {
                                datas[1] = datas[1] | 8;
                            }
                        }
                        break;
                    case 3:
                        if (FmStation.getCurrentForceMono() == 0) {
                            datas[1] = datas[1] | 4;
                            if (FMRadioService.getFMAudioMode()) {
                                datas[1] = datas[1] | 8;
                            }
                        }
                        break;
                }
            }
            if (!FmService.mLocFm) {
                datas[1] = datas[1] | 16;
            }
            datas[2] = FmUtils.mBand - 1;
            int index = FmUtils.mIndexRadio[FmUtils.mBand - 1];
            int start = (FmUtils.mBand - 1) * 6;
            if (this.mListRadio.size() > start + index) {
                SparseArray<String> map = getInstance().mListRadio.get(start + index);
                String strFreq = map.get(FinalRadioCtrl.RadioItem6025_Freq);
                if (FmUtils.mBand <= 3) {
                    strHighLightFreq = String.format(Locale.US, "%.02f", Float.valueOf(FmUtils.trans2Freq(FmUtils.mDispStation)));
                } else {
                    strHighLightFreq = String.format(Locale.US, "%d", Integer.valueOf((int) FmUtils.trans2Freq(FmUtils.mDispStation)));
                }
                if (strHighLightFreq.equals(strFreq)) {
                    datas[3] = index + 1;
                }
            }
            int station = FmUtils.mDispStation;
            if (FmUtils.mBand <= 3) {
                station *= 10;
            }
            datas[4] = (station >> 16) & 255;
            datas[5] = (station >> 8) & 255;
            datas[6] = station & 255;
            boolean bNeedSend = false;
            for (int i2 = 0; i2 < 7; i2++) {
                if (mDatas[i2] != datas[i2]) {
                    bNeedSend = true;
                    mDatas[i2] = datas[i2];
                }
            }
            if (bNeedSend) {
                RadioM.PROXY.cmd(26, datas, (float[]) null, (String[]) null);
            }
        }
    }

    public static int test_fmsyu_jni(int type, Object inparam, Object outparam) {
        switch (Main.mConf_PlatForm) {
            case 5:
                return FMRadioNativeInterface.getInstance().test_fmsyu_jni(type, inparam, outparam);
            default:
                return FmNative.getInstance().test_fmsyu_jni(type, inparam, outparam);
        }
    }

    public static boolean includePage(int idPage) {
        return idPage >= 130001 && idPage < 140001;
    }

    public boolean isAppTop() {
        if (MyApplication.myApp.isAppTop()) {
            return includePage(MyApplication.sPage_Current);
        }
        return false;
    }

    public void Send_FmbdDlgIntent(String str_data) {
        Log.d("fmbd5", " 11 Send_FmbdDlgIntent com.syu.manager.FmbdService str_data = " + str_data);
        Intent serviceIntent = new Intent("com.syu.manager.FmbdService");
        serviceIntent.setPackage("com.syu.onlineradio");
        serviceIntent.putExtra("from", "radio");
        serviceIntent.putExtra("data", str_data);
        serviceIntent.putExtra("type", iFmOnlineType);
        getInstance().myApplication.startServiceSafely(serviceIntent);
    }

    public static void read_list() {
        Log.d("fmbdd", " 00 read_list ");
        String str_Fmbd = readFile();
        if (str_Fmbd != FinalChip.BSP_PLATFORM_Null) {
            FmbdBeans.clear();
            List<String> arraylistFmbd = Arrays.asList(str_Fmbd.split("\\|"));
            for (String StrFm : arraylistFmbd) {
                List<String> listFmbd = Arrays.asList(StrFm.split("\\,"));
                FmbdlistBean fmbdBean = new FmbdlistBean();
                fmbdBean.setId(listFmbd.get(0));
                fmbdBean.setCity(listFmbd.get(1));
                fmbdBean.setLogo(listFmbd.get(2));
                fmbdBean.setName(listFmbd.get(3));
                fmbdBean.setRate(listFmbd.get(4));
                FmbdBeans.add(fmbdBean);
            }
            for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                interfaceRadio.setBtnBk();
            }
        }
    }

    public static void read_logolist() {
        String str_FmLogo = getFileName();
        Log.d("gdy7", "  002 read_logolist str_FmLogo = " + str_FmLogo);
        if (str_FmLogo != FinalChip.BSP_PLATFORM_Null) {
            FmLogoBeans.clear();
            List<String> arraylistFmLogo = Arrays.asList(str_FmLogo.split("\\|"));
            for (String StrFm : arraylistFmLogo) {
                List<String> listFmLogo = Arrays.asList(StrFm.split("\\,"));
                FmLogoBean fmLogo_Bean = new FmLogoBean();
                fmLogo_Bean.setName(listFmLogo.get(0));
                fmLogo_Bean.setFreq(listFmLogo.get(1));
                fmLogo_Bean.setLogo(listFmLogo.get(2));
                FmLogoBeans.add(fmLogo_Bean);
            }
            if (FmLogoBeans != null) {
                Log.d("gdy7", "  003 read_logolist FmLogoBeans.size() = " + FmLogoBeans.size());
            }
            for (Interface_Radio interfaceRadio : mInterfaceRadio) {
                interfaceRadio.setBtnBk();
            }
        }
    }

    public static String getFmLogoLogo(String freq) {
        if (FmLogoBeans.size() > 0) {
            for (FmLogoBean fb : FmLogoBeans) {
                if (fb.getFreq().equals(freq)) {
                    return fb.getLogo();
                }
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public static String getFmLogoName(String freq) {
        if (FmLogoBeans.size() > 0) {
            for (FmLogoBean fb : FmLogoBeans) {
                if (fb.getFreq().equals(freq)) {
                    return fb.getName();
                }
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public static String getFmbdLogo(String freq) {
        if (FmbdBeans.size() > 0) {
            for (FmbdlistBean fb : FmbdBeans) {
                if (fb.getRate().equals(freq)) {
                    return fb.getLogo();
                }
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public static String getFmbdName(String freq) {
        if (FmbdBeans.size() > 0) {
            for (FmbdlistBean fb : FmbdBeans) {
                if (fb.getRate().equals(freq)) {
                    return fb.getName();
                }
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public static String getFmbdCity(String freq) {
        if (FmbdBeans.size() > 0) {
            for (FmbdlistBean fb : FmbdBeans) {
                if (fb.getRate().equals(freq)) {
                    return fb.getCity();
                }
            }
        }
        return "CITY";
    }

    public static String getFmbdId(String freq) {
        if (FmbdBeans.size() > 0) {
            for (FmbdlistBean fb : FmbdBeans) {
                if (fb.getRate().equals(freq)) {
                    return fb.getId();
                }
            }
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public static String getFileName() {
        Log.d("gdy7", "  00 getFileName readLogoFile  ");
        String fileName = FinalChip.BSP_PLATFORM_Null;
        try {
            FmLogoPath = new File(Environment.getExternalStorageDirectory() + "/radio_logo");
            File[] f = FmLogoPath.listFiles();
            for (int i = 0; i < f.length; i++) {
                if (f[i].isFile() && f[i].exists()) {
                    String name = f[i].getName().replace(".png", FinalChip.BSP_PLATFORM_Null);
                    String name1 = String.valueOf(name.replace("_", ",")) + "," + name;
                    fileName = String.valueOf(fileName) + name1 + "|";
                    Log.d("gdy7", "  01 readLogoFile name1 = " + name1);
                }
            }
            Log.d("gdy7", "  02 readLogoFile fileName = " + fileName);
        } catch (Exception e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        }
        return fileName;
    }

    public static String readLogoFile() {
        String fileContent = FinalChip.BSP_PLATFORM_Null;
        try {
            File FmLogoPath1 = new File(Environment.getExternalStorageDirectory() + "/radiologo");
            File f = new File(FmLogoPath1, "radioinfo.txt");
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "utf-8");
                BufferedReader reader = new BufferedReader(read);
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    fileContent = String.valueOf(fileContent) + line + "|";
                }
                read.close();
            }
        } catch (Exception e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        }
        return fileContent;
    }

    public static String readFile() {
        String fileContent = FinalChip.BSP_PLATFORM_Null;
        try {
            FmbdPath = new File(Environment.getExternalStorageDirectory() + "/fmbd");
            File f = new File(FmbdPath, "fmbd.txt");
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "utf-8");
                BufferedReader reader = new BufferedReader(read);
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    fileContent = String.valueOf(fileContent) + line;
                }
                read.close();
            }
        } catch (Exception e) {
            System.out.println("读取文件内容操作出错");
            e.printStackTrace();
        }
        return fileContent;
    }

    public void setDayOrNight(int value) {
        Log.d("gdy10", " **  App_Radio setDayOrNight value = " + value);
        for (Interface_Radio interfaceRadio : mInterfaceRadio) {
            interfaceRadio.setDayOrNight(value);
        }
    }
}
