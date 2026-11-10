package com.syu.radio;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemProperties;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.android.fmradio.FmNative;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.InterfaceUi;
import com.lsec.core.frame.app.MyAct;
import com.lsec.core.frame.app.MyActivity;
import com.lsec.core.frame.app.MyApp;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.app.MyUi;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JSwitchButton;
import com.lsec.core.frame.ctrl.JViewPager;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.sys.Locate;
import com.lsec.core.util.data.FinalChip;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.pekall.fmradio.FmRadio_Sofia;
import com.syu.radio.ctrl.JFreqBand;
import com.syu.radio.ctrl.JFreqLineRuler;
import com.syu.radio.ctrl.JFreqRoundRuler;
import com.syu.radio.ctrl.JFreqView;
import com.syu.radio.ctrl.JHorizontalListView;
import com.syu.radio.ctrl.JRulerView;
import com.syu.radio.ctrl.JSwitchButon2;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.data.FinalRadioType;
import com.syu.radio.db.Radio_Info;
import com.syu.radio.fmbd.FmLogoBean;
import com.syu.radio.netchannel.NetChannel;
import com.syu.radio.page.Page_CityInfo;
import com.syu.radio.page.Page_DelInfo;
import com.syu.radio.page.Page_EditInfo;
import com.syu.radio.page.Page_Info;
import com.syu.radio.page.Page_InfoItem;
import com.syu.radio.page.Page_Main;
import com.syu.radio.page.Page_Menu;
import com.syu.radio.page.Page_MsgBox;
import com.syu.radio.page.Page_Radio;
import com.syu.radio.page.Page_RadioFmAm;
import com.syu.radio.page.Page_Radio_6025;
import com.syu.radio.page.Page_Radio_Sophia;
import com.syu.radio.page.Page_Set;
import com.syu.radio.page.Page_SetFreq;
import com.syu.radio.page.Page_Set_6025;
import com.syu.radio.page.Page_Set_Sophia;
import com.syu.radio.page.Page_SettingInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Act_Radio extends MyAct implements Interface_Radio, InterfaceUi {
    public static final int BROADCAST_RADIO_SMART = -1;
    public static final int ErrType_GetList = 1;
    public static final int ErrType_Play = 2;
    public static final int PAGE_SIZE_ALBUM = 20;
    public static final int PAGE_SIZE_PLAYLIST = 10;
    public static DisplayImageOptions options;
    public static DisplayImageOptions optionsRadioBk;
    public int mErrType = 1;
    public int mPlayPosWill = -1;
    public int mFreqTuneFromSpeech = -1;
    public int bJumpSetOnly = 0;
    public boolean bHasZoomed = false;
    public boolean bNeedTuneCurrentStation = true;
    public Drawable mDrawableBg = null;
    public Interface_RadioPage mInterfacePageRadio = null;
    public int mIndexRadioScanStart = 0;
    RunnableScanChannel_App mRunnableScanChannel_App = null;
    RunnableShowScan_App mRunnableShowScan_App = null;
    public ArrayList<Page_Menu> mListPageMenus = new ArrayList<>();
    public int station = 0;
    public Runnable_updateHalfScreenVisible mRunnable_updateHalfScreenVisible = null;
    Toast mToast = null;
    TextView mView = null;
    public Runnable mRunnable_initlist = new Runnable() { // from class: com.syu.radio.Act_Radio.1
        @Override // java.lang.Runnable
        public void run() {
            Page_Info page_info = Act_Radio.this.getPageInfo();
            if (page_info != null) {
                page_info.resetList(Radio_Info.mListInfo);
            }
            if (Act_Radio.this.mInterfacePageRadio != null) {
                Act_Radio.this.mInterfacePageRadio.updateListRadio();
            }
        }
    };
    RunnableCheckSt mRunnableCheckSt = null;

    public Page_Info getPageInfo() {
        return (Page_Info) this.myActivity.getPageNotify(this.ui, FinalRadioCtrl.Page_Info);
    }

    public Page_SettingInfo getSettingInfo() {
        return (Page_SettingInfo) this.myActivity.getPageNotify(this.ui, FinalRadioCtrl.Page_SettingInfo);
    }

    public Page_Set getPageSet() {
        IPageNotify pageNotify = this.myActivity.getPageNotify(this.ui, FinalRadioCtrl.Page_Set);
        if (pageNotify instanceof Page_Set) {
            return (Page_Set) pageNotify;
        }
        return null;
    }

    public Page_Set_6025 getPageSet6025() {
        IPageNotify pageNotify = this.myActivity.getPageNotify(this.ui, FinalRadioCtrl.Page_Set);
        if (pageNotify instanceof Page_Set_6025) {
            return (Page_Set_6025) pageNotify;
        }
        return null;
    }

    public IPageNotify getPageRadio() {
        return this.myActivity.getPageNotify(this.ui, FinalRadioCtrl.Page_Radio);
    }

    @Override // com.syu.radio.Interface_Radio
    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.onNotify(updateCode, ints, flts, strs);
        }
        Page_Set page_Set = getPageSet();
        if (page_Set != null) {
            page_Set.onNotify(updateCode, ints, flts, strs);
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void refreshStationUI() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.refreshStationUI();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void checkTuneFromSpeech() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.checkTuneFromSpeech();
        }
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void onCreate(MyActivity act) throws Throwable {
        if (App_Radio.getInstance().myApplication == null) {
            App_Radio.getInstance().onCreate(MyApplication.myApp);
        }
        if (App_Radio.bSetTransparent) {
            Log.d("fmbd5", " ** 01 onCreate ActRadio  Set Transparent");
            Window window = act.getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(ExploreByTouchHelper.INVALID_ID);
            window.setStatusBarColor(0);
        }
        this.myActivity = act;
        this.ui = new MyUi(act, this, FinalRadioType.class, FinalRadioCtrl.class);
        this.mDrawableBg = this.ui.getDrawableFromPath("toast_bg", null, null);
        App_Radio.mInterfaceRadio.add(this);
        if (App_Radio.mBkWidth != 0) {
            int BkWidth = this.ui.getDrawableFromPath("radio_bk", null, null).getIntrinsicWidth();
            App_Radio.RulerScale = App_Radio.mBkWidth / BkWidth;
            Log.d("theme", " 00 Act radio  *** 00 InitMapPage  RulerWidth = " + BkWidth + " App_Radio.mBkWidth = " + App_Radio.mBkWidth + " RulerScale = " + App_Radio.RulerScale);
        }
        options = new DisplayImageOptions.Builder().showImageOnLoading(this.ui.getDrawableFromPath("ic_stub", null, null)).showImageForEmptyUri(this.ui.getDrawableFromPath("ic_empty", null, null)).showImageOnFail(this.ui.getDrawableFromPath("ic_error", null, null)).cacheInMemory(true).cacheOnDisc(true).considerExifParams(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).resetViewBeforeLoading(true).build();
        optionsRadioBk = new DisplayImageOptions.Builder().cacheInMemory(true).considerExifParams(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build();
        initlist(false, false, true);
        if (App_Radio.iRadioType_Arm > 0) {
            FmUtils.mIndexRadio[0] = FmStation.getCurrentIndexRadio(1);
            FmUtils.mIndexRadio[1] = FmStation.getCurrentIndexRadio(2);
            FmUtils.mIndexRadio[2] = FmStation.getCurrentIndexRadio(3);
            FmUtils.mIndexRadio[3] = FmStation.getCurrentIndexRadio(4);
            FmUtils.mIndexRadio[4] = FmStation.getCurrentIndexRadio(5);
            FmService.mLocFm = FmStation.getLoc();
            FmService.mFmSenstivity = FmStation.getFmSensitivity();
            if (FmService.mFmSenstivity < FmUtils.mFmSens_Min || FmService.mFmSenstivity > FmUtils.mFmSens_Max) {
                FmService.mFmSenstivity = FmUtils.mFmSens_Default;
            }
            FmService.mAmSenstivity = FmStation.getAmSensitivity();
            if (FmService.mAmSenstivity < FmUtils.mAmSens_Min || FmService.mAmSenstivity > FmUtils.mAmSens_Max) {
                FmService.mAmSenstivity = FmUtils.mAmSens_Default;
            }
            FmService.mAutoSensitivity = FmStation.getAutoSenstivity();
        }
        NetChannel netChannel = NetChannel.getInstance(MyApplication.myApp);
        MyApplication.startThread(MyApplication.mStrZipTag, App_Radio.StrThreadCheckNet, netChannel.mRunnable_CheckNet, true, 1);
        if (App_Radio.mStrCustomer.equalsIgnoreCase("YL_3")) {
            checkCustomerId();
        }
    }

    public static void checkCustomerId() {
        if (App_Radio.bCustomerId && App_Radio.mStrCustomer.equalsIgnoreCase("YL_3")) {
            String customId = SystemProperties.get("ro.build.fytmanufacturer");
            Log.d("gdy4", " customId = " + customId);
            if (!customId.equals("116") && !customId.equals("127") && !customId.equals("132")) {
                throw new NullPointerException("null--*" + customId + "*");
            }
        }
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void onDestroy() {
        if (App_Radio.bFmbdDlgShow) {
            App_Radio.bFmbdDlgShow = false;
            App_Radio.getInstance().Send_FmbdDlgIntent("hide");
        }
        App_Radio.mInterfaceRadio.remove(this);
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void onNewIntent(Intent intent, MyActivity act) throws Throwable {
        handleIntent(intent, act, false);
    }

    private void handleIntent(Intent intent, MyActivity act, boolean bIsOnCreate) throws Throwable {
        boolean bNeedHandle = false;
        if (intent != null) {
            String strAction = intent.getAction();
            if (!TextUtils.isEmpty(strAction)) {
                Log.d("ama", " *** 0 *** handleIntent strAction = " + strAction);
                if (strAction.startsWith(FmStation.AUTHORITY)) {
                    bNeedHandle = true;
                }
                if (strAction.startsWith("android.intent.action.VIEW")) {
                    bNeedHandle = true;
                }
                if (bNeedHandle) {
                    if (this.myActivity == null) {
                        onCreate(act);
                    }
                    Uri uri = intent.getData();
                    if (uri != null) {
                        String strFreq = uri.getQueryParameter("freq");
                        Log.d("ama", " ** 1 ** handleIntent * strFreq = " + strFreq + " isAM = " + App_Radio.isSupportAm() + " *bIsOnCreate = " + bIsOnCreate);
                        try {
                            if (!TextUtils.isEmpty(strFreq)) {
                                this.station = Integer.valueOf(strFreq).intValue();
                                this.mFreqTuneFromSpeech = this.station;
                                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.Act_Radio.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Log.d("ama", " ** 1 ** handleIntent * freq = " + Act_Radio.this.station + " FmUtils.mBand = " + FmUtils.mBand + " *band = " + FmStation.getCurrentBand());
                                        boolean ReBand = false;
                                        if (Act_Radio.this.station > 3000 && FmUtils.mBand >= 4) {
                                            ReBand = true;
                                            FmUtils.mBand = 5;
                                            App_Radio.getInstance().mIpcObj.FmBand(0);
                                            Act_Radio.this.setPara(FmUtils.mBand);
                                        } else if (Act_Radio.this.station < 3000 && FmUtils.mBand < 4) {
                                            ReBand = true;
                                            FmUtils.mBand = 3;
                                            App_Radio.getInstance().mIpcObj.SAmBand();
                                            Act_Radio.this.setPara(FmUtils.mBand);
                                        }
                                        Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.Act_Radio.2.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                App_Radio.getInstance().setFreq(Act_Radio.this.station, true);
                                            }
                                        }, ReBand ? 800 : 100);
                                    }
                                }, bIsOnCreate ? FmRadio_Sofia.LONG_PRESS_SEEK_TIMEOUT : 300);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    if (strAction.equals("com.syu.radio.set")) {
                        this.bJumpSetOnly = 1;
                        goPage(FinalRadioCtrl.Page_Set);
                    }
                }
            }
        }
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void onResume() {
        String city;
        Log.d("gdy10", " ActRaido onResume bUI_Colour_DayNight = " + App_Radio.bUI_Colour_DayNight + " mNightDay = " + App_Radio.mNightDay);
        if (App_Radio.bUI_Colour_DayNight) {
            this.myActivity.getWindow().getDecorView().setBackground(this.ui.getDrawableFromPath(App_Radio.mNightDay > 0 ? "night_bk_radio" : "bk_radio", null, null));
        }
        if (App_Radio.bUI_NightColour) {
            setDayOrNight(App_Radio.mNightDay);
        }
        Intent i = new Intent("android.fyt.action.HIDE");
        i.setPackage("com.fyt.screenbutton");
        MyApplication.myApp.startServiceSafely(i);
        String str = App_Radio.mCity;
        String strLocale = Locale.getDefault().toString();
        if (strLocale.equals("zh_CN") || App_Radio.bRuRadioName) {
            city = Locate.mCity;
        } else {
            city = FinalChip.BSP_PLATFORM_Null;
        }
        Log.d("logg", " 00 Act_Radio  onResume Locate.mCity = " + Locate.mCity + " city = " + city + " App_Radio.mCity = " + App_Radio.mCity);
        if (city != null && !city.equals(App_Radio.mCity)) {
            App_Radio.mCity = city;
            initlist(false, false, true);
        }
        if (App_Radio.getInstance().bEnableHalfScreen && App_Radio.getInstance().getFullScreenMode() == 0) {
            goPage(FinalRadioCtrl.Page_Radio);
        }
        if (this.bJumpSetOnly == 2) {
            this.bJumpSetOnly = 0;
            goPage(FinalRadioCtrl.Page_Radio);
        } else if (this.bJumpSetOnly == 1) {
            this.bJumpSetOnly = 2;
        }
        if (App_Radio.bFmOnline) {
            Log.d("fmbdd", " 11 onResume  FmbdBeans.size = " + App_Radio.FmbdBeans.size());
            if (App_Radio.FmbdBeans.size() <= 0) {
                App_Radio.getInstance();
                App_Radio.read_list();
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.Act_Radio.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (App_Radio.FmbdBeans.size() <= 0) {
                            App_Radio.getInstance().Send_FmbdDlgIntent("down");
                        }
                    }
                }, 2000L);
            }
        }
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void onPause() {
        if (App_Radio.bFmbdDlgShow) {
            App_Radio.bFmbdDlgShow = false;
            App_Radio.getInstance().Send_FmbdDlgIntent("hide");
        }
        Intent i = new Intent("android.fyt.action.SHOW");
        i.setPackage("com.fyt.screenbutton");
        MyApplication.myApp.startServiceSafely(i);
    }

    public void startCheckHalfScreenVisible() {
        if (this.mRunnable_updateHalfScreenVisible == null) {
            this.mRunnable_updateHalfScreenVisible = new Runnable_updateHalfScreenVisible();
            Main.postRunnable_Ui(true, this.mRunnable_updateHalfScreenVisible);
        }
    }

    public void stopCheckHalfScreenVisible() {
        if (this.mRunnable_updateHalfScreenVisible != null) {
            Main.removeRunnable_Ui(this.mRunnable_updateHalfScreenVisible);
            this.mRunnable_updateHalfScreenVisible.stopRun();
            this.mRunnable_updateHalfScreenVisible = null;
        }
    }

    public class Runnable_updateHalfScreenVisible implements Runnable {
        public boolean bRun = true;

        public Runnable_updateHalfScreenVisible() {
        }

        public void stopRun() {
            this.bRun = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRun) {
                if (App_Radio.getInstance().bEnableHalfScreen && Act_Radio.this.mInterfacePageRadio != null) {
                    Act_Radio.this.mInterfacePageRadio.updateHalfScreenVisble();
                }
                Main.postRunnable_Ui(true, this, 1000L);
            }
        }
    }

    @Override // com.lsec.core.frame.app.InterfaceUi
    public void InitMapPage(MyUi ui) {
        ui.mMapPage.put(130001, "main");
        ui.mMapPage.put(FinalRadioCtrl.Page_Radio, "radio");
        ui.mMapPage.put(FinalRadioCtrl.Page_RadioItem_6025, "radio_item6025");
        ui.mMapPage.put(FinalRadioCtrl.Page_FM1, "radio_band_fm1");
        ui.mMapPage.put(FinalRadioCtrl.Page_FM2, "radio_band_fm2");
        ui.mMapPage.put(FinalRadioCtrl.Page_FM3, "radio_band_fm3");
        ui.mMapPage.put(FinalRadioCtrl.Page_AM1, "radio_band_am1");
        ui.mMapPage.put(FinalRadioCtrl.Page_AM2, "radio_band_am2");
        ui.mMapPage.put(FinalRadioCtrl.Page_Set, "radio_set");
        ui.mMapPage.put(FinalRadioCtrl.Page_Menu, "radio_menu");
        ui.mMapPage.put(FinalRadioCtrl.Page_Menu1, "radio_menu1");
        ui.mMapPage.put(FinalRadioCtrl.Page_Menu2, "radio_menu2");
        ui.mMapPage.put(FinalRadioCtrl.Page_Info, "radio_info");
        ui.mMapPage.put(FinalRadioCtrl.Page_InfoItem, "radio_infoitem");
        ui.mMapPage.put(FinalRadioCtrl.Page_CityInfo, "radio_cityinfo");
        ui.mMapPage.put(FinalRadioCtrl.Page_DelInfo, "radio_delinfo");
        ui.mMapPage.put(FinalRadioCtrl.Page_MsgBox, "common_msgbox");
        ui.mMapPage.put(FinalRadioCtrl.Page_EditInfo, "radio_editinfo");
        ui.mMapPage.put(FinalRadioCtrl.Page_SettingInfo, "radio_settinginfo");
        ui.mMapPage.put(FinalRadioCtrl.Page_SetFreqInfo, "radio_setfreqinfo");
    }

    @Override // com.lsec.core.frame.app.InterfaceUi
    public void InitPage(JPage page) {
        int id = page.getId();
        switch (id) {
            case 130001:
                page.setNotify(new Page_Main(page, this));
                break;
            case FinalRadioCtrl.Page_Radio /* 130002 */:
                switch (App_Radio.iRadioType_Arm) {
                    case 1:
                    case 2:
                        page.setNotify(new Page_Radio_6025(page, this));
                        break;
                    case 3:
                        page.setNotify(new Page_Radio_Sophia(page, this));
                        break;
                    default:
                        page.setNotify(new Page_Radio(page, this));
                        break;
                }
                break;
            case FinalRadioCtrl.Page_FM1 /* 130004 */:
            case FinalRadioCtrl.Page_FM2 /* 130005 */:
            case FinalRadioCtrl.Page_FM3 /* 130006 */:
            case FinalRadioCtrl.Page_AM1 /* 130007 */:
            case FinalRadioCtrl.Page_AM2 /* 130008 */:
                page.setNotify(new Page_RadioFmAm(page, this));
                break;
            case FinalRadioCtrl.Page_Menu /* 130009 */:
            case FinalRadioCtrl.Page_Menu1 /* 130010 */:
            case FinalRadioCtrl.Page_Menu2 /* 130011 */:
                page.setNotify(new Page_Menu(page, this));
                break;
            case FinalRadioCtrl.Page_Info /* 130012 */:
                page.setNotify(new Page_Info(page, this));
                break;
            case FinalRadioCtrl.Page_InfoItem /* 130013 */:
                page.setNotify(new Page_InfoItem(page, this));
                break;
            case FinalRadioCtrl.Page_DelInfo /* 130014 */:
                page.setNotify(new Page_DelInfo(page, this));
                break;
            case FinalRadioCtrl.Page_EditInfo /* 130015 */:
                page.setNotify(new Page_EditInfo(page, this));
                break;
            case FinalRadioCtrl.Page_CityInfo /* 130016 */:
                page.setNotify(new Page_CityInfo(page, this));
                break;
            case FinalRadioCtrl.Page_SettingInfo /* 130017 */:
                page.setNotify(new Page_SettingInfo(page, this));
                break;
            case FinalRadioCtrl.Page_SetFreqInfo /* 130019 */:
                page.setNotify(new Page_SetFreq(page, this));
                break;
            case FinalRadioCtrl.Page_Set /* 130023 */:
                switch (App_Radio.iRadioType_Arm) {
                    case 1:
                    case 2:
                        page.setNotify(new Page_Set_6025(page, this));
                        break;
                    case 3:
                        page.setNotify(new Page_Set_Sophia(page, this));
                        break;
                    default:
                        page.setNotify(new Page_Set(page, this));
                        break;
                }
                break;
            case FinalRadioCtrl.Page_MsgBox /* 130133 */:
                page.setNotify(new Page_MsgBox(page, this));
                break;
        }
    }

    @Override // com.lsec.core.frame.app.InterfaceUi
    public View createUiItemOtherWay(JPage page, MyUiItem item) {
        int type = item.getType();
        switch (type) {
            case 1000:
                JFreqView view = new JFreqView(page);
                if (item.getStrDrawableExtra() == null) {
                    return view;
                }
                view.setIconName(item.getStrDrawableExtra());
                return view;
            case 1001:
                JFreqBand view2 = new JFreqBand(page);
                if (item.getStrDrawableExtra() == null) {
                    return view2;
                }
                view2.setIconName(item.getStrDrawableExtra());
                return view2;
            case 1002:
                JFreqRoundRuler ruler = new JFreqRoundRuler(this, page);
                ruler.setIconName(item.getStrDrawableExtra()[0]);
                ruler.calcPara(item);
                ruler.setTextSize(item.getHeight());
                if (item.getColor() == null) {
                    return ruler;
                }
                ruler.setTextColor(item.getColor()[0]);
                return ruler;
            case 1003:
                JFreqLineRuler ruler2 = new JFreqLineRuler(this, page);
                ruler2.setIconName(item.getStrDrawableExtra());
                ruler2.calcPara(item);
                ruler2.setTextSize(item.getHeight());
                if (item.getColor() != null) {
                    ruler2.setTextColor(item.getColor()[0]);
                }
                return ruler2;
            case 1004:
                JRulerView ruler3 = new JRulerView(this, page);
                if (item.getColor() != null) {
                    int[] para = item.getPara();
                    if (para.length > 5) {
                        ruler3.init(item.getColor()[0], para[0], para[1], para[2], para[3], para[4], para[5]);
                    }
                }
                return ruler3;
            case 1005:
                JHorizontalListView view3 = new JHorizontalListView(this.ui.mContext);
                return view3;
            case 1006:
                JSwitchButon2 view4 = new JSwitchButon2(page, item);
                return view4;
            default:
                return null;
        }
    }

    @Override // com.lsec.core.frame.app.InterfaceUi
    public void setProperty(View child) {
    }

    public void tips(String str) {
        if (this.mToast != null) {
            this.mToast.cancel();
            this.mToast = null;
        }
        this.mToast = new Toast(this.myActivity);
        this.mToast.setGravity(17, 0, 0);
        this.mToast.setDuration(0);
        this.mView = new TextView(this.myActivity);
        this.mView.setText(str);
        this.mView.setGravity(17);
        this.mView.setBackground(this.mDrawableBg);
        this.mView.setTextSize(24.0f);
        this.mToast.setView(this.mView);
        this.mToast.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.lsec.core.frame.app.MyAct
    public boolean onKeyDown(int keyCode, KeyEvent event) throws Throwable {
        if (keyCode == 4) {
            boolean bMoveTask2Back = false;
            if (this.myActivity.mPageCurrent != null) {
                int idPage = this.myActivity.mPageCurrent.getId();
                switch (idPage) {
                    case FinalRadioCtrl.Page_Radio /* 130002 */:
                        bMoveTask2Back = true;
                        break;
                    case FinalRadioCtrl.Page_Set /* 130023 */:
                        Log.d("gdy10", " 0000 KEYCODE_BACK bJumpSetOnly = " + this.bJumpSetOnly);
                        if (this.bJumpSetOnly == 0) {
                            goPage(FinalRadioCtrl.Page_Radio);
                            return true;
                        }
                        bMoveTask2Back = true;
                        break;
                        break;
                }
            }
            if (bMoveTask2Back) {
                this.myActivity.moveTaskToBack(true);
            }
            App_Radio.getInstance().saveSet();
            App_Radio.getInstance().mIpcObj.requestAppIdNull();
        }
        return false;
    }

    @Override // com.lsec.core.frame.app.MyAct
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 92) {
            App_Radio.getInstance().mIpcObj.Prev_Channel();
        }
        if (keyCode == 93) {
            App_Radio.getInstance().mIpcObj.Next_Channel();
            return false;
        }
        return false;
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void onTouchEvent(MotionEvent event) {
        Log.d("gdd", " 22 onTouchEvent  App_Radio.bFocus = " + App_Radio.bFocus + "  event.getAction() = " + event.getAction());
        switch (event.getAction()) {
            case 0:
                if (!App_Radio.getInstance().mIpcObj.isRightAppId()) {
                    App_Radio.getInstance().mIpcObj.requestAppIdRight();
                }
                break;
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void initlist(boolean bTip, boolean bAdd, boolean bReGetData) {
        Log.d("gdy6", " *** initlist mListInfo getArea = " + App_Radio.getInstance().mIpcObj.getArea());
        MyApplication.startThread(MyApplication.mStrZipTag, "db-operation", new RunnableInitList(bTip, bAdd, bReGetData), false, 1);
    }

    public class RunnableInitList implements Runnable {
        private boolean bAdd;
        private boolean bReGetData;
        private boolean bTip;

        public RunnableInitList(boolean bTip, boolean bAdd, boolean bReGetData) {
            this.bTip = bTip;
            this.bAdd = bAdd;
            this.bReGetData = bReGetData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("gdy6", "ActRadio RunnableInitList run  bReGetData = " + this.bReGetData + " App_Radio.mCity = " + App_Radio.mCity + " getArea = " + App_Radio.getInstance().mIpcObj.getArea());
            if (this.bReGetData) {
                Radio_Info.mListInfo = App_Radio.getInstance().mRadioInfoManager.query(Integer.valueOf(App_Radio.getInstance().mIpcObj.getArea()));
                App_Radio.FmLogoToList = false;
            }
            Main.postRunnable_Ui(true, Act_Radio.this.mRunnable_initlist);
            if (Radio_Info.mListInfo != null) {
                Log.d("gdy6", " 001 ActRadio RunnableInitList mListInfo.size " + Radio_Info.mListInfo.size() + " FmLogoToList = " + App_Radio.FmLogoToList);
            }
            if (this.bTip) {
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.Act_Radio.RunnableInitList.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RunnableInitList.this.bAdd) {
                            Act_Radio.this.tips(App_Radio.getInstance().uiApp.getString("radio_info_addsuccess"));
                        } else {
                            Act_Radio.this.tips(App_Radio.getInstance().uiApp.getString("radio_info_editsuccess"));
                        }
                    }
                });
            }
            if (App_Radio.bFmLogoByPng) {
                if (Radio_Info.mListInfo == null) {
                    Radio_Info.mListInfo = new ArrayList();
                    App_Radio.FmLogoToList = false;
                }
                if (App_Radio.FmLogoBeans != null && App_Radio.FmLogoBeans.size() > 0 && !App_Radio.FmLogoToList) {
                    for (FmLogoBean fb : App_Radio.FmLogoBeans) {
                        if (fb.getLogo() != null) {
                            SparseArray<String> map = new SparseArray<>();
                            map.put(FinalRadioCtrl.Item_Index, FinalChip.BSP_PLATFORM_Null);
                            map.put(FinalRadioCtrl.Item_Txt_Freq, fb.getFreq());
                            map.put(FinalRadioCtrl.Item_Area, FinalChip.BSP_PLATFORM_Null);
                            map.put(FinalRadioCtrl.Item_Txt_Name, fb.getName());
                            map.put(FinalRadioCtrl.Item_Txt_Unit, "MHz");
                            map.put(FinalRadioCtrl.Item_Net, Integer.toString(0));
                            map.put(FinalRadioCtrl.Item_City, FinalChip.BSP_PLATFORM_Null);
                            if (App_Radio.bRuRadioName) {
                                map.put(FinalRadioCtrl.Item_Logo, fb.getLogo());
                            }
                            if (Radio_Info.mListInfo != null) {
                                Radio_Info.mListInfo.add(map);
                            }
                        }
                    }
                    App_Radio.FmLogoToList = true;
                }
            }
        }
    }

    public void requestAppIdRight() {
        App_Radio.getInstance().mIpcObj.requestAppIdRight();
    }

    private void showToast(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(MyApplication.myApp, msg, 0).show();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void updateListRadio() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.updateListRadio();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void disLoading() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.disLoading();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showLoading() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.showLoading();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void jump1stChannel() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.jump1stChannel();
        }
    }

    public void jump1stChannel_AtSoon() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.jump1stChannel_AtSoon();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void resetIndexFMAM() {
        FmUtils.mIndexRadio[0] = 0;
        FmUtils.mIndexRadio[1] = 0;
        FmUtils.mIndexRadio[2] = 0;
        FmUtils.mIndexRadio[3] = 0;
        FmUtils.mIndexRadio[4] = 0;
        FmStation.setCurrentIndexRadio(1, 0);
        FmStation.setCurrentIndexRadio(2, 0);
        FmStation.setCurrentIndexRadio(3, 0);
        FmStation.setCurrentIndexRadio(4, 0);
        FmStation.setCurrentIndexRadio(5, 0);
    }

    public View getFocus(JPage page) {
        View v = null;
        if (this.myActivity.bTop && page != null) {
            v = page.getFocusedChild();
            while (v instanceof ViewGroup) {
                v = ((ViewGroup) v).getFocusedChild();
            }
        }
        return v;
    }

    @Override // com.syu.radio.Interface_Radio
    public void scrollToPrev() {
        if (this.myActivity.bTop) {
            boolean bScroll = true;
            if (this.myActivity.mPageCurrent != null) {
                IPageNotify pageNotify = this.myActivity.mPageCurrent.getNotify();
                if (pageNotify instanceof Page_Radio_6025) {
                    bScroll = !((Page_Radio_6025) pageNotify).scrollToPrev();
                } else if (pageNotify instanceof Page_Radio_Sophia) {
                    bScroll = !((Page_Radio_Sophia) pageNotify).scrollToPrev();
                } else if (pageNotify instanceof Page_Radio) {
                    bScroll = !((Page_Radio) pageNotify).scrollToPrev();
                }
            }
            if (bScroll) {
                onKeyHandle(this.myActivity.mPageCurrent, 1);
            }
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void scrollToNext() {
        if (this.myActivity.bTop) {
            boolean bScroll = true;
            if (this.myActivity.mPageCurrent != null) {
                IPageNotify pageNotify = this.myActivity.mPageCurrent.getNotify();
                if (pageNotify instanceof Page_Radio_6025) {
                    bScroll = !((Page_Radio_6025) pageNotify).scrollToNext();
                } else if (pageNotify instanceof Page_Radio_Sophia) {
                    bScroll = !((Page_Radio_Sophia) pageNotify).scrollToNext();
                } else if (pageNotify instanceof Page_Radio) {
                    bScroll = !((Page_Radio) pageNotify).scrollToNext();
                }
            }
            if (bScroll) {
                onKeyHandle(this.myActivity.mPageCurrent, 2);
            }
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void scrollOk() {
        if (this.myActivity.bTop) {
            View v = getFocus(this.myActivity.mPageCurrent);
            if (v instanceof JSwitchButton) {
                ((JSwitchButton) v).setChecked(!((JSwitchButton) v).isChecked());
                IPageNotify pageNotify = this.myActivity.mPageCurrent.getNotify();
                if (pageNotify != null) {
                    pageNotify.ResponseClick(v);
                    return;
                }
                return;
            }
            App_Radio.getInstance().simulateKey(66);
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void onKeyLeft() {
        onKeyHandle(this.myActivity.mPageCurrent, 17);
    }

    @Override // com.syu.radio.Interface_Radio
    public void onKeyUp() {
        onKeyHandle(this.myActivity.mPageCurrent, 33);
    }

    @Override // com.syu.radio.Interface_Radio
    public void onKeyRight() {
        onKeyHandle(this.myActivity.mPageCurrent, 66);
    }

    @Override // com.syu.radio.Interface_Radio
    public void onKeyDown() {
        onKeyHandle(this.myActivity.mPageCurrent, 130);
    }

    public void onKeyHandle(JPage page, int direction) {
        if (this.myActivity.bTop && page != null) {
            View v = page.getFocusedChild();
            while (v instanceof ViewGroup) {
                v = ((ViewGroup) v).getFocusedChild();
            }
            View vFocus = null;
            if (v != null) {
                vFocus = v.focusSearch(direction);
            }
            if (vFocus == null) {
                Object obj = page.getTag();
                if (obj instanceof MyUiItem) {
                    MyUiItem uiItemTmp = (MyUiItem) obj;
                    String[] strs = uiItemTmp.getParaStr();
                    if (strs != null && strs.length > 0 && this.ui.mCtrlId.containsKey(strs[0])) {
                        int idCtrl = this.ui.mCtrlId.get(strs[0]).intValue();
                        vFocus = page.findViewById(idCtrl);
                    }
                }
            }
            if (vFocus != null) {
                vFocus.requestFocusFromTouch();
            }
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void updateSearchFreq(int freq) {
        FmUtils.mCurStation = freq;
        boolean bUpdateCurrentFreq = true;
        switch (Main.mConf_PlatForm) {
            case 6:
            case 8:
                bUpdateCurrentFreq = FmUtils.mSearch;
                break;
        }
        if (bUpdateCurrentFreq && this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.updateCurrentFreq(freq, false);
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void setPara(int iBand) {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.setPara(iBand);
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void initPara() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.initPara();
        }
        refreshStationUI();
    }

    public class RunnableShowScan_App implements Runnable {
        public boolean bRun = true;

        public RunnableShowScan_App() {
        }

        public void stopRun() {
            this.bRun = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRun) {
                if (Act_Radio.this.mInterfacePageRadio != null) {
                    Act_Radio.this.mInterfacePageRadio.showHideScan();
                }
                if (this.bRun) {
                    Main.postRunnable_Ui(true, this, 1000L);
                }
            }
        }
    }

    public class RunnableScanChannel_App implements Runnable {
        public boolean bRun = true;

        public RunnableScanChannel_App() {
        }

        public void stopRun() {
            this.bRun = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRun) {
                int indexStart = (FmUtils.mBand - 1) * 6;
                List<SparseArray<String>> listRadio = App_Radio.getInstance().mListRadio;
                if (listRadio != null) {
                    if (listRadio.size() > FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart + 1) {
                        int[] iArr = FmUtils.mIndexRadio;
                        int i = FmUtils.mBand - 1;
                        iArr[i] = iArr[i] + 1;
                    } else {
                        FmUtils.mIndexRadio[FmUtils.mBand - 1] = 0;
                    }
                    if (FmUtils.mIndexRadio[FmUtils.mBand - 1] % 6 == 0) {
                        FmUtils.mIndexRadio[FmUtils.mBand - 1] = 0;
                        boolean bIsOirtFMBand1Bak = FmService.isAreaOirtFMBand1(FmUtils.mBand);
                        if (FmUtils.mBand <= 3) {
                            if (FmUtils.mBand < 3) {
                                FmUtils.mBand++;
                            } else {
                                FmUtils.mBand = 1;
                            }
                        } else if (FmUtils.mBand <= 5) {
                            if (FmUtils.mBand < 5) {
                                FmUtils.mBand++;
                            } else {
                                FmUtils.mBand = 4;
                            }
                        }
                        FmStation.saveCurrentBand();
                        boolean bIsOirtFMBand1Cur = FmService.isAreaOirtFMBand1(FmUtils.mBand);
                        if (bIsOirtFMBand1Cur != bIsOirtFMBand1Bak) {
                            Act_Radio.this.setPara(FmUtils.mBand);
                        }
                        FmUtils.mIndexRadio[FmUtils.mBand - 1] = 0;
                        Act_Radio.this.updateListRadio();
                    }
                    FmStation.setCurrentIndexRadio(FmUtils.mBand, FmUtils.mIndexRadio[FmUtils.mBand - 1]);
                    if (Act_Radio.this.mInterfacePageRadio != null) {
                        Act_Radio.this.mInterfacePageRadio.updateChannelTxt();
                    }
                    int indexStart2 = (FmUtils.mBand - 1) * 6;
                    if (listRadio.size() > FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart2) {
                        SparseArray<String> map = listRadio.get(FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart2);
                        float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
                        App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), false);
                    }
                    if (this.bRun && FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart2 != Act_Radio.this.mIndexRadioScanStart) {
                        Main.postRunnable_Ui(true, this, 5000L);
                    } else {
                        Act_Radio.this.stopScan();
                    }
                }
            }
        }
    }

    public void Func_Search() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.Func_Search();
        }
    }

    public void startScan() {
        switch (App_Radio.iRadioType_Arm) {
            case 1:
            case 2:
                FmNative.getInstance().test_stopScan();
                break;
        }
        Log.d("gdy6", " startScan  FmUtils.mScan = " + FmUtils.mScan);
        if (FmUtils.mScan) {
            stopScan();
            return;
        }
        jump1stChannel_AtSoon();
        this.mIndexRadioScanStart = ((FmUtils.mBand - 1) * 6) + FmUtils.mIndexRadio[FmUtils.mBand - 1];
        this.mRunnableScanChannel_App = new RunnableScanChannel_App();
        Main.postRunnable_Ui(true, this.mRunnableScanChannel_App, 5000L);
        this.mRunnableShowScan_App = new RunnableShowScan_App();
        Main.postRunnable_Ui(true, this.mRunnableShowScan_App);
        FmUtils.mScan = true;
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    @Override // com.syu.radio.Interface_Radio
    public void stopScan() {
        FmUtils.mScan = false;
        if (this.mRunnableScanChannel_App != null) {
            Main.removeRunnable_Ui(this.mRunnableScanChannel_App);
            this.mRunnableScanChannel_App.stopRun();
            this.mRunnableScanChannel_App = null;
        }
        if (this.mRunnableShowScan_App != null) {
            Main.removeRunnable_Ui(this.mRunnableShowScan_App);
            this.mRunnableShowScan_App.stopRun();
            this.mRunnableShowScan_App = null;
        }
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.hideScan();
        }
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    public class RunnableCheckSt implements Runnable {
        private boolean bRun = true;

        public RunnableCheckSt() {
        }

        public void stopRun() {
            this.bRun = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.bRun) {
                if (Act_Radio.this.mInterfacePageRadio != null) {
                    Act_Radio.this.mInterfacePageRadio.updateStFocus();
                }
                Main.postRunnable_Ui(true, this, 1000L);
            }
        }
    }

    public void stopCheckSt() {
        if (this.mRunnableCheckSt != null) {
            this.mRunnableCheckSt.stopRun();
            Main.removeRunnable_Ui(this.mRunnableCheckSt);
            this.mRunnableCheckSt = null;
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void startCheckSt() {
        if (this.myActivity.bTop) {
            switch (App_Radio.iRadioType_Arm) {
                case 2:
                case 3:
                    if (FmStation.getCurrentForceMono() == 0) {
                        if (this.mRunnableCheckSt == null) {
                            this.mRunnableCheckSt = new RunnableCheckSt();
                        }
                        Main.postRunnable_Ui(true, this.mRunnableCheckSt);
                    }
                    break;
            }
        }
    }

    public void hideSetCtrl(JPage page) {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        Log.d("rds", " hideSetCtrl iRadioType_Arm = " + App_Radio.iRadioType_Arm);
        switch (App_Radio.iRadioType_Arm) {
            case 0:
                if (!App_Radio.isSupportAm() && (view7 = page.getChildViewByid(FinalRadioCtrl.Set_Group_AmSens)) != null) {
                    view7.setVisibility(8);
                    break;
                }
                break;
            case 1:
                if (!App_Radio.isSupportRds6025() && (view6 = page.getChildViewByid(FinalRadioCtrl.Set_Group_Rds)) != null) {
                    view6.setVisibility(8);
                }
                View view8 = page.getChildViewByid(FinalRadioCtrl.Set_Group_AmSens);
                if (view8 != null) {
                    view8.setVisibility(8);
                }
                View view9 = page.getChildViewByid(FinalRadioCtrl.Set_Group_Area);
                if (view9 != null) {
                    view9.setVisibility(8);
                }
                break;
            case 2:
                if (!App_Radio.isSupportRds6025() && (view5 = page.getChildViewByid(FinalRadioCtrl.Set_Group_Rds)) != null) {
                    view5.setVisibility(8);
                }
                if (!App_Radio.isSupportAm() && (view4 = page.getChildViewByid(FinalRadioCtrl.Set_Group_AmSens)) != null) {
                    view4.setVisibility(8);
                    break;
                }
                break;
            case 3:
                if (!App_Radio.isSupportRds() && (view3 = page.getChildViewByid(FinalRadioCtrl.Set_Group_Rds)) != null) {
                    view3.setVisibility(8);
                }
                if (!App_Radio.isSupportAm() && (view2 = page.getChildViewByid(FinalRadioCtrl.Set_Group_AmSens)) != null) {
                    view2.setVisibility(8);
                }
                if (!App_Radio.isSupportArea() && (view = page.getChildViewByid(FinalRadioCtrl.Set_Group_Area)) != null) {
                    view.setVisibility(8);
                    break;
                }
                break;
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void updateCurrentFreq(int freq, boolean bCheckAdjust) {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.updateCurrentFreq(freq, bCheckAdjust);
        }
    }

    public void Zoom(JButton btn, float fRatio) {
        if (btn != null) {
            this.bHasZoomed = true;
            btn.setScaleX(fRatio);
            btn.setScaleY(fRatio);
            btn.bringToFront();
            if (btn.mPartnerViews != null) {
                for (View vPartner : btn.mPartnerViews) {
                    vPartner.setScaleX(fRatio);
                    vPartner.setScaleY(fRatio);
                    vPartner.bringToFront();
                }
            }
        }
    }

    public void reStoreScale(JButton btn) {
        if (this.bHasZoomed && btn != null) {
            btn.setScaleX(1.0f);
            btn.setScaleY(1.0f);
            if (btn.mPartnerViews != null) {
                for (View vPartner : btn.mPartnerViews) {
                    vPartner.setScaleX(1.0f);
                    vPartner.setScaleY(1.0f);
                }
            }
        }
    }

    public void reStoreScaleAll(JPage page) {
        if (this.bHasZoomed && page != null) {
            for (int i = 0; i < 6; i++) {
                JButton btn = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq1 + i);
                reStoreScale(btn);
            }
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void setDayOrNight(int value) {
        Log.d("gdy10", " ActRaido setDayOrNight bUI_NightColour = " + App_Radio.bUI_NightColour + " mNightDay = " + App_Radio.mNightDay + " value = " + value);
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).updateAllChannel(false);
        }
        if (App_Radio.bUI_NightColour) {
            if (pageNotify instanceof Page_Radio_6025) {
                ((Page_Radio_6025) pageNotify).setDayOrNight(value);
            }
            Page_Set_6025 page_set = getPageSet6025();
            if (page_set != null) {
                page_set.setDayOrNight(value);
            }
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void setBtnBk() {
        if (this.mInterfacePageRadio != null) {
            this.mInterfacePageRadio.setBtnBk();
        }
    }

    public String getStrLoc(boolean bLoc) {
        if (App_Radio.bLocChinese) {
            if (bLoc) {
                return "近程";
            }
            return "远程";
        }
        if (bLoc) {
            return "LOC";
        }
        return FinalChip.BSP_PLATFORM_Null;
    }

    public String getStrST(boolean bST) {
        if (App_Radio.bStChinese) {
            if (bST) {
                return "立体声";
            }
            return "单声道";
        }
        if (bST) {
            return "ST";
        }
        return "MONO";
    }

    public void jumpPhoto() {
        try {
            Intent intent = new Intent();
            intent.putExtra("folder", "/mnt/sdcard/RadioPC");
            intent.setAction("com.syu.gallery.jumpbyradio");
            intent.setPackage("com.syu.gallery");
            this.myActivity.startActivity(intent);
        } catch (Exception e) {
        }
    }

    public void changeBand(boolean change) {
        if (App_Radio.bChangeBand) {
            if (change) {
                App_Radio.getInstance().mIpcObj.SFmBand();
                return;
            } else {
                App_Radio.getInstance().mIpcObj.SAmBand();
                return;
            }
        }
        App_Radio.getInstance().mIpcObj.Band();
    }

    public int getFixBand(JViewPager viewPagerFMAM, boolean bMcu) {
        int band;
        int bandAmBegin;
        int bandFmBegin;
        if (bMcu) {
            band = App_Radio.getInstance().mIpcObj.getBand();
            bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
            bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        } else {
            band = FmUtils.mBand;
            bandAmBegin = 4;
            bandFmBegin = 1;
        }
        if (viewPagerFMAM != null) {
            if (viewPagerFMAM.mContents != null) {
                int item = viewPagerFMAM.getCurrentItem();
                int len = viewPagerFMAM.mContents.length;
                switch (len) {
                    case 2:
                        switch (item) {
                            case 1:
                                return bandAmBegin;
                            case 2:
                                return bandAmBegin + 1;
                            default:
                                int bandAmBegin2 = band;
                                return bandAmBegin2;
                        }
                    case 3:
                    case 5:
                        switch (item) {
                            case 1:
                                int bandAmBegin3 = bandFmBegin;
                                return bandAmBegin3;
                            case 2:
                                int bandAmBegin4 = bandFmBegin + 1;
                                return bandAmBegin4;
                            case 3:
                                int bandAmBegin5 = bandFmBegin + 2;
                                return bandAmBegin5;
                            case 4:
                                return bandAmBegin;
                            case 5:
                                return bandAmBegin + 1;
                            default:
                                int bandAmBegin6 = band;
                                return bandAmBegin6;
                        }
                    case 4:
                    default:
                        int bandAmBegin7 = band;
                        return bandAmBegin7;
                }
            }
            int bandAmBegin8 = band;
            return bandAmBegin8;
        }
        int bandAmBegin9 = band;
        return bandAmBegin9;
    }

    public int getFixItem(JViewPager viewPagerFMAM, int band, boolean bMcu) {
        int bandAmBegin;
        int bandFmBegin;
        Log.d("freq", " ** 00 getFixItem  band= " + band + "  bMcu = " + bMcu);
        int item = 1;
        if (bMcu) {
            bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
            bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        } else {
            bandAmBegin = 4;
            bandFmBegin = 1;
        }
        if (viewPagerFMAM != null && viewPagerFMAM.mContents != null) {
            int len = viewPagerFMAM.mContents.length;
            switch (len) {
                case 2:
                    if (band >= bandAmBegin && band < bandAmBegin + 2) {
                        item = (band + 1) - bandAmBegin;
                    }
                    break;
                case 3:
                case 5:
                    if (band >= bandAmBegin && band < bandAmBegin + 2) {
                        item = (band + 4) - bandAmBegin;
                    }
                    if (band >= bandFmBegin && band < bandFmBegin + 3) {
                        item = (band + 1) - bandFmBegin;
                    }
                    break;
            }
        }
        Log.d("freq", " ** 11 getFixItem  band= " + band + "  item = " + item);
        return item;
    }

    public void setUiLoader(JViewPager viewPager, boolean bAM) {
        if (viewPager != null) {
            if (bAM) {
                if (viewPager.mContents != null && viewPager.mContents.length != 2) {
                    viewPager.setUiLoader(FinalRadioCtrl.Page_AM1, FinalRadioCtrl.Page_AM2);
                    if (this.mInterfacePageRadio != null) {
                        this.mInterfacePageRadio.updateBandFocus(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (viewPager.mContents != null && viewPager.mContents.length != 3) {
                viewPager.setUiLoader(FinalRadioCtrl.Page_FM1, FinalRadioCtrl.Page_FM2, FinalRadioCtrl.Page_FM3);
                if (this.mInterfacePageRadio != null) {
                    this.mInterfacePageRadio.updateBandFocus(true);
                }
            }
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showTp() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showTp(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showTp(FmService.getRdsOnOff());
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showTa() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showTa(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showTa(FmService.getRdsOnOff());
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showPty() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showPty(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showPty(FmService.getRdsOnOff());
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showTaOn() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showTaOn(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showTaOn(FmService.getRdsOnOff());
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showAfOn() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showAfOn(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showAfOn(FmService.getRdsOnOff());
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showPs() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showPS(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showPS(FmService.getRdsOnOff());
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public void showRds() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).showRds(FmService.getRdsOnOff());
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).showRds(FmService.getRdsOnOff());
        }
    }

    public void updateRdsInfo() {
        IPageNotify pageNotify = getPageRadio();
        if (pageNotify instanceof Page_Radio_6025) {
            ((Page_Radio_6025) pageNotify).updateRdsInfo();
        } else if (pageNotify instanceof Page_Radio_Sophia) {
            ((Page_Radio_Sophia) pageNotify).updateRdsInfo();
        }
    }

    @Override // com.syu.radio.Interface_Radio
    public boolean isTop() {
        return this.myActivity.bTop && App_Radio.includePage(MyApplication.sPage_Current);
    }

    @Override // com.syu.radio.Interface_Radio
    public void goPage(int idPageTo) {
        this.myActivity.goPage(idPageTo);
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void addChild2Parent(ViewGroup viewParent) {
        JPage pageMain;
        if (viewParent != null && viewParent.findViewById(130001) == null && (pageMain = this.ui.loadPage(true, 130001)) != null) {
            viewParent.addView(pageMain);
        }
    }

    @Override // com.lsec.core.frame.app.MyAct
    public void removeChildFromParent(ViewGroup viewParent) {
        JPage pageMain;
        if (viewParent != null && (pageMain = (JPage) viewParent.findViewById(130001)) != null) {
            pageMain.pause();
            pageMain.removeFromUiPages();
            viewParent.removeView(pageMain);
        }
    }

    @Override // com.lsec.core.frame.app.MyAct
    public MyApp getMyApp() {
        return App_Radio.getInstance();
    }

    @Override // com.lsec.core.frame.app.MyAct
    public boolean includePage(int idPage) {
        return App_Radio.includePage(idPage);
    }

    public void windowFocusChanged(boolean hasFocus) {
        Log.d("gdd", "  11   windowFocusChanged  App_Radio.bFocus = " + App_Radio.bFocus);
        App_Radio.bFocus = hasFocus;
        if (App_Radio.bFocus && !App_Radio.getInstance().mIpcObj.isRightAppId()) {
            App_Radio.getInstance().mIpcObj.requestAppIdRight();
        }
    }
}
