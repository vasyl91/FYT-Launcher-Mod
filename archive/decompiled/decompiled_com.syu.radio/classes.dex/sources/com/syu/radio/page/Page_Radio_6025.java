package com.syu.radio.page;

import android.R;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.fmradio.CollChannel;
import com.android.fmradio.FmNative;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JScrollViewHorizontal;
import com.lsec.core.frame.ctrl.JSwitchButton;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.frame.ctrl.JViewPager;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.data.FinalChip;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_RadioPage;
import com.syu.radio.ctrl.JFreqBand;
import com.syu.radio.ctrl.JFreqLineRuler;
import com.syu.radio.ctrl.JFreqRoundRuler;
import com.syu.radio.ctrl.JFreqView;
import com.syu.radio.ctrl.JRulerView;
import com.syu.radio.ctrl.JSwitchButon2;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.runnable.RunnableSetBk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Radio_6025 extends MyPage implements Interface_RadioPage {
    static JButton BtnDeleteAll;
    static JScrollViewHorizontal Freq_CollectList;
    public static Drawable btn_col;
    public static Drawable btn_col_p;
    public static Drawable drawable_col_n;
    public static Drawable drawable_col_p;
    static JButton mBtnCol;
    static JButton mBtnCol_Lc;
    static JButton mRadio_Btn_Scan_Lc;
    static JViewPager mViewPagerFMAM;
    static JPage pageRadio;
    JButton AM1;
    JButton AM2;
    JButton FM1;
    JButton FM2;
    JButton FM3;
    String Gps_freq;
    Act_Radio actRadio;
    boolean bFreqBtnType;
    public boolean bTop;
    public int i;
    public int i_band;
    public boolean isNight;
    boolean isToastShow;
    View mAMBLayout;
    JButton mBtnAM;
    JButton mBtnBandAM;
    JButton mBtnBandFM;
    JButton mBtnColList;
    JButton mBtnFM;
    JButton mBtnFreqList;
    JButton mBtnFreqM;
    JButton mBtnFreqP;
    int mClickCnt;
    View mFMBLayout;
    View mFm2AmGroup;
    JFreqBand mFreqBand;
    JFreqLineRuler mFreqLineRuler;
    JFreqRoundRuler mFreqRoundRuler;
    JFreqView mFreqView;
    JFreqView mFreqView_night;
    private Handler mHandler1;
    ImageView mImgViewRadioBk;
    JFreqLineRuler mLineRuler;
    public View.OnTouchListener mOnTouchListenerCol;
    public View.OnTouchListener mOnTouchListenerRuler;
    View mPTY_VIEW;
    JPage mPageAm1;
    JPage mPageAm2;
    JPage mPageFm1;
    JPage mPageFm2;
    JPage mPageFm3;
    JPage mPageMenu;
    View mRulerLayout;
    JRulerView mRulerView;
    public Runnable mRunnableHideRuler;
    public Runnable mRunnableJump1stChannel;
    public Runnable mRunnableLongClickFreqM;
    public Runnable mRunnableLongClickFreqP;
    public Runnable mRunnableRulerNight;
    public Runnable mRunnableUpdateAllChannel;
    public Runnable mRunnableUpdateListRadio;
    int mTaState;
    JText mTextAfOn;
    JText mTextLoc;
    JText mTextST;
    JText mTextScan;
    JText mTextTa;
    JText mTextTaOn;
    JText mTextTp;
    JText mTxtChannel;
    JText mTxtClock;
    JText mTxtCurrentCity;
    JText mTxtCurrentFreq;
    JText mTxtCurrentFreqName;
    JText mTxtCurrentFreqNameAll;
    JText mTxtFreqShow;
    JText mTxtScanning;
    JText mTxtUnit;
    JText mTxtUnit1;
    JText mTxtUnit2;
    JText mTxtUnit3;
    JText mTxtUnit4;
    JText mTxtUnit5;
    JText mTxtUnit6;
    View mVIEW_FMSet;
    JView mViewAfOn;
    JView mViewFMAM;
    View mViewHalfScreen;
    JView mViewLoc;
    JViewPager mViewPager;
    ImageView mViewRadioCircleLogo;
    ImageView mViewRadioLogo;
    ImageView mViewRadioLogo1;
    ImageView mViewRadioLogo2;
    ImageView mViewRadioLogo3;
    ImageView mViewRadioLogo4;
    ImageView mViewRadioLogo5;
    ImageView mViewRadioLogo6;
    JView mViewST;
    JView mViewScan;
    JView mViewTa;
    JView mViewTaOn;
    JView mViewTp;
    View mView_Radio_FreqLineRuler_bk;
    private int[] nightBtn;
    private int[] nightText;
    private int[] nightView;
    public String strFreq_run;
    JSwitchButton switchAFOnOffButton;
    JSwitchButton switchLocOnOffButton;
    JSwitchButton switchRdsOnOffButton;
    JSwitchButon2 switchRdsOnOffButton2;
    JSwitchButton switchStOnOffButton;
    JSwitchButton switchTAOnOffButton;
    Toast toast;
    private TextView tv_freq;
    private TextView tv_name;
    private TextView tv_title;
    static List<CollChannel> Collect_FmList = new ArrayList();
    static List<CollChannel> Collect_AmList = new ArrayList();
    public static String Desplay_Freq = null;
    public static int MsgBox_Sel = 255;
    public static int[] colBtn = {FinalRadioCtrl.Radio_Btn_Col0, FinalRadioCtrl.Radio_Btn_Col1, FinalRadioCtrl.Radio_Btn_Col2, FinalRadioCtrl.Radio_Btn_Col3, FinalRadioCtrl.Radio_Btn_Col4, FinalRadioCtrl.Radio_Btn_Col5, FinalRadioCtrl.Radio_Btn_Col6, FinalRadioCtrl.Radio_Btn_Col7, FinalRadioCtrl.Radio_Btn_Col8, FinalRadioCtrl.Radio_Btn_Col9, FinalRadioCtrl.Radio_Btn_Col10, FinalRadioCtrl.Radio_Btn_Col11, FinalRadioCtrl.Radio_Btn_Col12, FinalRadioCtrl.Radio_Btn_Col13, FinalRadioCtrl.Radio_Btn_Col14, FinalRadioCtrl.Radio_Btn_Col15, FinalRadioCtrl.Radio_Btn_Col16, FinalRadioCtrl.Radio_Btn_Col17, FinalRadioCtrl.Radio_Btn_Col18, FinalRadioCtrl.Radio_Btn_Col19};
    public static int[] colTxt = {FinalRadioCtrl.Radio_Txt_Col0, FinalRadioCtrl.Radio_Txt_Col1, FinalRadioCtrl.Radio_Txt_Col2, FinalRadioCtrl.Radio_Txt_Col3, FinalRadioCtrl.Radio_Txt_Col4, FinalRadioCtrl.Radio_Txt_Col5, FinalRadioCtrl.Radio_Txt_Col6, FinalRadioCtrl.Radio_Txt_Col7, FinalRadioCtrl.Radio_Txt_Col8, FinalRadioCtrl.Radio_Txt_Col9, FinalRadioCtrl.Radio_Txt_Col10, FinalRadioCtrl.Radio_Txt_Col11, FinalRadioCtrl.Radio_Txt_Col12, FinalRadioCtrl.Radio_Txt_Col13, FinalRadioCtrl.Radio_Txt_Col14, FinalRadioCtrl.Radio_Txt_Col15, FinalRadioCtrl.Radio_Txt_Col16, FinalRadioCtrl.Radio_Txt_Col17, FinalRadioCtrl.Radio_Txt_Col18, FinalRadioCtrl.Radio_Txt_Col19};
    public static boolean bDelay_run = true;

    public Page_Radio_6025(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.nightBtn = new int[]{FinalRadioCtrl.Radio_Btn_FreqM, FinalRadioCtrl.Radio_Btn_FreqP, FinalRadioCtrl.Radio_Btn_Band, FinalRadioCtrl.Radio_Menu_Home, FinalRadioCtrl.Radio_Btn_Save, FinalRadioCtrl.Radio_Btn_Scan, FinalRadioCtrl.Radio_Btn_Loc, FinalRadioCtrl.Radio_Btn_ST, FinalRadioCtrl.Radio_Btn_Pty, FinalRadioCtrl.Radio_Btn_FMBand, FinalRadioCtrl.Radio_Btn_AMBand, FinalRadioCtrl.Radio_Btn_Ta, FinalRadioCtrl.Radio_Btn_Af, FinalRadioCtrl.Radio_Btn_Set, FinalRadioCtrl.Radio_Btn_Yun, FinalRadioCtrl.Radio_Btn_Edit, FinalRadioCtrl.Radio_Btn_Freq1, FinalRadioCtrl.Radio_Btn_Freq2, FinalRadioCtrl.Radio_Btn_Freq3, FinalRadioCtrl.Radio_Btn_Freq4, FinalRadioCtrl.Radio_Btn_Freq5, FinalRadioCtrl.Radio_Btn_Freq6};
        this.nightText = new int[]{FinalRadioCtrl.Radio_Txt_Channel, FinalRadioCtrl.Radio_Txt_CurFreqName, FinalRadioCtrl.Radio_Txt_Unit, FinalRadioCtrl.Radio_Txt_Scanning, FinalRadioCtrl.Radio_Txt_CurFreqName_All, FinalRadioCtrl.Radio_Txt_1, FinalRadioCtrl.Radio_Txt_2, FinalRadioCtrl.Radio_Txt_3, FinalRadioCtrl.Radio_Txt_4, FinalRadioCtrl.Radio_Txt_5, FinalRadioCtrl.Radio_Txt_6, FinalRadioCtrl.Radio_Txt_7};
        this.nightView = new int[]{FinalRadioCtrl.Radio_FreqLineRuler_bk, FinalRadioCtrl.Radio_FreqLineRuler_half_bk, FinalRadioCtrl.Radio_View_half_bk, FinalRadioCtrl.Menu_Rds_bk, FinalRadioCtrl.Radio_Ico_TaOn, FinalRadioCtrl.Radio_Ico_AfOn, FinalRadioCtrl.Radio_View_1, FinalRadioCtrl.Radio_View_2};
        this.bTop = false;
        this.mClickCnt = 0;
        this.mTaState = -255;
        this.toast = null;
        this.bFreqBtnType = true;
        this.i = 0;
        this.i_band = 0;
        this.strFreq_run = null;
        this.mHandler1 = new Handler() { // from class: com.syu.radio.page.Page_Radio_6025.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Page_Radio_6025.this.mTxtClock.setText(Page_Radio_6025.this.getTime());
                        break;
                }
            }
        };
        this.mRunnableUpdateAllChannel = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.2
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_6025.this.updateAllChannel(false);
            }
        };
        this.Gps_freq = null;
        this.isToastShow = true;
        this.mRunnableRulerNight = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.3
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_6025.this.mTxtCurrentFreqName.setVisibility(0);
                if (Page_Radio_6025.this.mView_Radio_FreqLineRuler_bk != null) {
                    Page_Radio_6025.this.mView_Radio_FreqLineRuler_bk.setVisibility(8);
                }
                View view = Page_Radio_6025.this.getPage().getChildViewByid(FinalRadioCtrl.view_radioTxt);
                if (view != null) {
                    view.setVisibility(0);
                }
                Page_Radio_6025.this.mLineRuler.setVisibility(8);
            }
        };
        this.isNight = false;
        this.mRunnableUpdateListRadio = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.4
            @Override // java.lang.Runnable
            public void run() {
                String strFreq;
                Page_Radio_6025.this.updateAllChannel(true);
                int freq = FmUtils.mCurStation;
                if (freq > 5000) {
                    Radio_IpcObj.mFreq_for_db = freq;
                    strFreq = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
                } else {
                    Radio_IpcObj.mFreq_for_db = freq * 100;
                    strFreq = new StringBuilder().append(freq).toString();
                }
                App_Radio.getInstance().updateCurFreqName(Page_Radio_6025.this.mTxtCurrentFreqName, strFreq);
                Page_Radio_6025.this.Show_FreqNameAll();
                Page_Radio_6025.this.strFreq_run = strFreq;
            }
        };
        this.mRunnableJump1stChannel = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.5
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_6025.this.jump1stChannel_AtSoon();
            }
        };
        this.mRunnableHideRuler = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.6
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_6025.this.hideRuler();
            }
        };
        this.mOnTouchListenerCol = new View.OnTouchListener() { // from class: com.syu.radio.page.Page_Radio_6025.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                        Log.d("gdd", " 11 mOnTouchListenerCol ACTION_DOWN :" + view.getId());
                        switch (view.getId()) {
                            case FinalRadioCtrl.Radio_Btn_Col0 /* 130267 */:
                            case FinalRadioCtrl.Radio_Btn_Col1 /* 130268 */:
                            case FinalRadioCtrl.Radio_Btn_Col2 /* 130269 */:
                            case FinalRadioCtrl.Radio_Btn_Col3 /* 130270 */:
                            case FinalRadioCtrl.Radio_Btn_Col4 /* 130271 */:
                            case FinalRadioCtrl.Radio_Btn_Col5 /* 130272 */:
                            case FinalRadioCtrl.Radio_Btn_Col6 /* 130273 */:
                            case FinalRadioCtrl.Radio_Btn_Col7 /* 130274 */:
                            case FinalRadioCtrl.Radio_Btn_Col8 /* 130275 */:
                            case FinalRadioCtrl.Radio_Btn_Col9 /* 130276 */:
                            case FinalRadioCtrl.Radio_Btn_Col10 /* 130277 */:
                            case FinalRadioCtrl.Radio_Btn_Col11 /* 130278 */:
                            case FinalRadioCtrl.Radio_Btn_Col12 /* 130279 */:
                            case FinalRadioCtrl.Radio_Btn_Col13 /* 130280 */:
                            case FinalRadioCtrl.Radio_Btn_Col14 /* 130281 */:
                            case FinalRadioCtrl.Radio_Btn_Col15 /* 130282 */:
                            case FinalRadioCtrl.Radio_Btn_Col16 /* 130283 */:
                            case FinalRadioCtrl.Radio_Btn_Col17 /* 130284 */:
                            case FinalRadioCtrl.Radio_Btn_Col18 /* 130285 */:
                            case FinalRadioCtrl.Radio_Btn_Col19 /* 130286 */:
                                int i_col = view.getId() - FinalRadioCtrl.Radio_Btn_Col0;
                                Log.d("col", " 00 col setFreq  coll_freq = " + Page_Radio_6025.getColList().get(i_col).coll_freq);
                                App_Radio.getInstance().setFreq(FmUtils.trans2KB(Float.parseFloat(Page_Radio_6025.getColList().get(i_col).coll_freq)), true);
                                Log.d("gdd", " 22 mOnTouchListenerCol down i_col = " + i_col);
                                break;
                        }
                        break;
                }
                return false;
            }
        };
        this.mOnTouchListenerRuler = new View.OnTouchListener() { // from class: com.syu.radio.page.Page_Radio_6025.8
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                    case 2:
                        Page_Radio_6025.this.showRuler(false);
                        return false;
                    case 1:
                    case 3:
                        Main.postRunnable_Ui(true, Page_Radio_6025.this.mRunnableHideRuler, 6000L);
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.mRunnableLongClickFreqM = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.9
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_6025.this.bFreqBtnType = !Page_Radio_6025.this.bFreqBtnType;
                FmStation.setLongClick(Page_Radio_6025.this.bFreqBtnType);
                Main.PROXY.cmd(80);
            }
        };
        this.mRunnableLongClickFreqP = new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.10
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_6025.this.bFreqBtnType = !Page_Radio_6025.this.bFreqBtnType;
                FmStation.setLongClick(Page_Radio_6025.this.bFreqBtnType);
                Main.PROXY.cmd(80);
            }
        };
        this.actRadio = actRadio;
        actRadio.mInterfacePageRadio = this;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.actRadio.initlist(false, false, false);
        this.bFreqBtnType = FmStation.getLongClick();
        pageRadio = getPage();
        this.mPageAm1 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_AM1);
        this.mPageAm2 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_AM2);
        this.mPageFm1 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM1);
        this.mPageFm2 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM2);
        this.mPageFm3 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM3);
        this.mTxtCurrentFreqName = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_CurFreqName);
        this.mTxtCurrentFreqNameAll = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_CurFreqName_All);
        this.mTxtCurrentCity = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_City);
        this.mTxtCurrentFreq = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_CurFreq);
        this.mViewHalfScreen = getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_HalfScreen);
        this.mViewPager = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPage);
        mViewPagerFMAM = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPageFMAM);
        this.mTextLoc = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Loc);
        this.mTextScan = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Scan);
        this.mTextST = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_St);
        this.mTextAfOn = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_AfOn);
        this.mTextTaOn = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_TaOn);
        this.mTextTp = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Tp);
        this.mTextTa = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ta);
        this.mViewLoc = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Loc);
        this.mViewScan = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Scan);
        this.mViewST = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_St);
        this.mViewTa = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Ta);
        this.mViewTp = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Tp);
        this.mViewTaOn = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_TaOn);
        this.mViewAfOn = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_AfOn);
        this.mViewFMAM = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_FMAM);
        this.mTxtChannel = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Channel);
        this.mTxtUnit = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit);
        this.mTxtUnit1 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit1);
        this.mTxtUnit2 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit2);
        this.mTxtUnit3 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit3);
        this.mTxtUnit4 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit4);
        this.mTxtUnit5 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit5);
        this.mTxtUnit6 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit6);
        this.mTxtScanning = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Scanning);
        this.mFreqBand = (JFreqBand) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqBand);
        this.mFreqView = (JFreqView) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqView);
        this.mFreqView_night = (JFreqView) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqView_night);
        this.mTxtFreqShow = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_FreqShow);
        this.mRulerView = (JRulerView) getPage().getChildViewByid(FinalRadioCtrl.Radio_RulerView);
        drawable_col_n = getPage().getDrawableFromPath("radio_menu_col_n", getPage().mDrawables, getPage().mDrawables);
        drawable_col_p = getPage().getDrawableFromPath("radio_menu_col_p", getPage().mDrawables, getPage().mDrawables);
        btn_col = getPage().getDrawableFromPath("radio_ch", getPage().mDrawables, getPage().mDrawables);
        btn_col_p = getPage().getDrawableFromPath("radio_ch_p", getPage().mDrawables, getPage().mDrawables);
        this.switchLocOnOffButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_LocOnOff);
        this.switchAFOnOffButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_AFOnOff);
        this.switchTAOnOffButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_TAOnOff);
        this.switchRdsOnOffButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff);
        this.switchStOnOffButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_StOnOff);
        this.switchRdsOnOffButton2 = (JSwitchButon2) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff_2);
        this.mVIEW_FMSet = getPage().getChildViewByid(FinalRadioCtrl.View_Switch_FmSet);
        this.mView_Radio_FreqLineRuler_bk = getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler_bk);
        this.mFMBLayout = getPage().getChildViewByid(FinalRadioCtrl.FMBand_Index);
        this.mAMBLayout = getPage().getChildViewByid(FinalRadioCtrl.AMBand_Index);
        this.AM1 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.AM_1);
        this.AM2 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.AM_2);
        this.FM1 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_1);
        this.FM2 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_2);
        this.FM3 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_3);
        Freq_CollectList = (JScrollViewHorizontal) getPage().getChildViewByid(FinalRadioCtrl.Freq_CollectList);
        if (Freq_CollectList != null) {
            for (int i = 0; i < 20; i++) {
                View view_col = getPage().getChildViewByid(colBtn[i]);
                if (view_col != null) {
                    view_col.setOnTouchListener(this.mOnTouchListenerCol);
                }
            }
        }
        if (mViewPagerFMAM != null) {
            mViewPagerFMAM.setVisibility(0);
        }
        if (Freq_CollectList != null) {
            Freq_CollectList.setVisibility(8);
        }
        ReadColList();
        this.mTxtClock = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Clock);
        if (this.mTxtClock != null) {
            new TimeThread().start();
        }
        this.mFm2AmGroup = getPage().getChildViewByid(FinalRadioCtrl.Radio_FM_AM_Group);
        if (this.mFm2AmGroup != null) {
            this.mFm2AmGroup.setVisibility(8);
        }
        this.mBtnFM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_FMBand);
        this.mBtnAM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_AMBand);
        this.mBtnBandFM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_Band_FM);
        this.mBtnBandAM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_Band_AM);
        this.mPTY_VIEW = getPage().getChildViewByid(FinalRadioCtrl.Radio_PTY_VIEW);
        if (this.mPTY_VIEW != null) {
            this.mPTY_VIEW.setVisibility(8);
        }
        this.mBtnFreqList = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_FreqList);
        this.mBtnColList = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_ColList);
        if (this.mBtnFreqList != null) {
            this.mBtnFreqList.setBackground(getPage().getDrawableFromPath("radio_menu_freqlist_p", null, null));
        }
        if (this.mBtnColList != null) {
            this.mBtnColList.setBackground(getPage().getDrawableFromPath("radio_menu_collist_n", null, null));
        }
        BtnDeleteAll = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_Del);
        if (BtnDeleteAll != null) {
            BtnDeleteAll.setEnabled(false);
        }
        mBtnCol = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_Col);
        this.mPageMenu = (JPage) getPage().getChildViewByid(FinalRadioCtrl.Page_Menu);
        this.mImgViewRadioBk = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_BK);
        this.mViewRadioLogo = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo);
        this.mViewRadioCircleLogo = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_CircleLogo);
        this.mViewRadioLogo1 = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo1);
        this.mViewRadioLogo2 = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo2);
        this.mViewRadioLogo3 = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo3);
        this.mViewRadioLogo4 = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo4);
        this.mViewRadioLogo5 = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo5);
        this.mViewRadioLogo6 = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Logo6);
        this.mRulerLayout = getPage().getChildViewByid(FinalRadioCtrl.Radio_Ruler_Group);
        if (App_Radio.mLongClick_Time > 0) {
            this.mBtnFreqM = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_FreqM);
            if (this.mBtnFreqM != null) {
                this.mBtnFreqM.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.radio.page.Page_Radio_6025.11
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View arg0, MotionEvent event) {
                        switch (event.getAction()) {
                            case 0:
                                Main.postRunnable_Ui(true, Page_Radio_6025.this.mRunnableLongClickFreqM, App_Radio.mLongClick_Time * 1000);
                                break;
                            case 1:
                            case 2:
                            case 3:
                                Main.removeRunnable_Ui(Page_Radio_6025.this.mRunnableLongClickFreqM);
                                break;
                        }
                        return false;
                    }
                });
            }
            this.mBtnFreqP = (JButton) getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_FreqP);
            if (this.mBtnFreqP != null) {
                this.mBtnFreqP.setOnTouchListener(new View.OnTouchListener() { // from class: com.syu.radio.page.Page_Radio_6025.12
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View arg0, MotionEvent event) {
                        switch (event.getAction()) {
                            case 0:
                                Main.postRunnable_Ui(true, Page_Radio_6025.this.mRunnableLongClickFreqP, App_Radio.mLongClick_Time * 1000);
                                break;
                            case 1:
                            case 2:
                            case 3:
                                Main.removeRunnable_Ui(Page_Radio_6025.this.mRunnableLongClickFreqP);
                                break;
                        }
                        return false;
                    }
                });
            }
        }
        this.mLineRuler = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
        if (this.mLineRuler != null) {
            this.mLineRuler.setOnTouchListener(this.mOnTouchListenerRuler);
        }
        if (this.mRulerLayout != null) {
            this.mRulerLayout.setVisibility(8);
        }
        if (this.mFMBLayout != null) {
            this.mFMBLayout.setVisibility(4);
        }
        if (this.mAMBLayout != null) {
            this.mAMBLayout.setVisibility(4);
        }
        if (this.mRulerView != null) {
            this.mRulerView.setOnValueChangeListener(new JRulerView.OnValueChangeListener() { // from class: com.syu.radio.page.Page_Radio_6025.13
                @Override // com.syu.radio.ctrl.JRulerView.OnValueChangeListener
                public void onValueChange(float value) {
                    if (!Page_Radio_6025.this.mRulerView.isAdjusting()) {
                        App_Radio.getInstance().setFreq((int) value, true);
                    }
                }
            });
        }
        this.mFreqLineRuler = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
        this.mFreqRoundRuler = (JFreqRoundRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqRoundRuler);
        disLoading();
        initPara();
        updateBandFocus(true);
        if (!App_Radio.isSupportAm()) {
            this.actRadio.setUiLoader(mViewPagerFMAM, false);
        }
        updateRdsInfo();
    }

    public void bCol_Freq(String freq, List<CollChannel> list) {
        int id_Col = getColIdByFreq(freq, list);
        Log.d("col", " 00 bCol_Freq  freq = " + freq + " list = " + list.size());
        if (id_Col == 255) {
            if (list.size() >= 20) {
                MsgBox_Sel = 1;
                Dialog popDlg = this.actRadio.ui.getPopDlg(FinalRadioCtrl.Page_MsgBox, "popwindow_delete_btn_anim_style", true);
                if (popDlg != null) {
                    JPage page = this.actRadio.ui.getPage(FinalRadioCtrl.Page_MsgBox);
                    if (page != null) {
                        page.resume();
                    }
                    popDlg.show();
                    return;
                }
                return;
            }
            AddCollFreq(freq, list);
        } else {
            list.remove(id_Col);
        }
        SaveColList(list);
        refreshCol();
    }

    static int getColSize() {
        return FmUtils.mBand <= 3 ? Collect_FmList.size() : Collect_AmList.size();
    }

    static List<CollChannel> getColList() {
        return (FmUtils.mBand < 4 || FmUtils.mBand > 5) ? Collect_FmList : Collect_AmList;
    }

    String Float_Str(float f_num) {
        NumberFormat formatter = new DecimalFormat("0.00");
        return formatter.format(f_num);
    }

    public static void refreshColName() {
        if (Freq_CollectList != null) {
            for (int i = 0; i < getColList().size(); i++) {
                if (getColList().get(i) != null) {
                    getColList().get(i).coll_name = App_Radio.getInstance().mRadioInfoManager.queryFreq(getColList().get(i).coll_freq);
                }
            }
            refreshCol();
        }
    }

    public static void refreshCol() {
        if (Freq_CollectList != null) {
            if (mBtnCol != null) {
                if (getColIdByFreq(Desplay_Freq, getColList()) != 255) {
                    mBtnCol.setBackground(drawable_col_p);
                } else {
                    mBtnCol.setBackground(drawable_col_n);
                }
            }
            for (int i = 0; i < 20; i++) {
                View viewCol = pageRadio.getChildViewByid(colBtn[i]);
                if (viewCol != null) {
                    boolean isGone = false;
                    if (getColList() == null || i >= getColList().size()) {
                        isGone = true;
                    }
                    if (isGone) {
                        viewCol.setVisibility(8);
                    } else {
                        viewCol.setVisibility(0);
                        if (getColList().get(i).coll_freq.equals(Desplay_Freq)) {
                            viewCol.setBackground(btn_col_p);
                        } else {
                            viewCol.setBackground(btn_col);
                        }
                        JText tv_Col = (JText) pageRadio.getChildViewByid(colTxt[i]);
                        if (tv_Col != null) {
                            if (getColList().get(i).coll_name != FinalChip.BSP_PLATFORM_Null) {
                                tv_Col.setTextSize(30.0f);
                                tv_Col.setText(getColList().get(i).coll_name);
                            } else {
                                tv_Col.setTextSize(40.0f);
                                tv_Col.setText(getColList().get(i).coll_freq);
                            }
                        }
                    }
                }
            }
        }
    }

    static int getColIdByFreq(String Desplay_Freq2, List<CollChannel> FreqList) {
        if (Freq_CollectList == null) {
            return 255;
        }
        Log.d("gdy2", " *** 00 getColFreq Desplay_Freq = " + Desplay_Freq2);
        if (FreqList == null || Desplay_Freq2 == null) {
            return 255;
        }
        for (int i = 0; i < FreqList.size(); i++) {
            if (FreqList.get(i) != null && FreqList.get(i).coll_freq != null) {
                Log.d("gdy2", " *** 01 getColFreq Desplay_Freq = " + Desplay_Freq2 + " item_freq = " + FreqList.get(i).coll_freq);
                if (FreqList.get(i).coll_freq.equals(Desplay_Freq2)) {
                    return i;
                }
            }
        }
        return 255;
    }

    public static void ReadColList() {
        if (Freq_CollectList != null) {
            String FM_List = App_Radio.getInstance().mySharePreference2.getStringValue("FM_Col");
            Log.d("gdy9", "  ***  read  FM_List = " + FM_List);
            if (FM_List != null && FM_List.length() > 5) {
                Collect_FmList.clear();
                int a = 0;
                for (int i = 0; i < FM_List.length(); i++) {
                    if (FM_List.charAt(i) == '*') {
                        Log.d("gdy9", "  ***  read list  i = " + i + "  a = " + a + "  Str = " + FM_List.substring(a, i));
                        AddCollFreq(FM_List.substring(a, i), Collect_FmList);
                        a = i + 1;
                    }
                }
            }
            String AM_List = App_Radio.getInstance().mySharePreference2.getStringValue("AM_Col");
            Log.d("gdy9", "  ***  read  AM_List = " + AM_List);
            if (AM_List != null && AM_List.length() > 5) {
                Collect_AmList.clear();
                int a2 = 0;
                for (int i2 = 0; i2 < AM_List.length(); i2++) {
                    if (AM_List.charAt(i2) == '*') {
                        Log.d("gdy9", "  ***  read list  i = " + i2 + "  a = " + a2 + "  Str = " + AM_List.substring(a2, i2));
                        AddCollFreq(AM_List.substring(a2, i2), Collect_AmList);
                        a2 = i2 + 1;
                    }
                }
            }
        }
    }

    public static void SaveColList(List<CollChannel> StrList) {
        if (Freq_CollectList != null) {
            getColList();
            String str_key = "FM_Col";
            if (FmUtils.mBand >= 4 && FmUtils.mBand <= 5) {
                str_key = "AM_Col";
            }
            String Str_List = FinalChip.BSP_PLATFORM_Null;
            for (int i = 0; i < StrList.size(); i++) {
                Str_List = String.valueOf(Str_List) + StrList.get(i).coll_freq + "*";
            }
            Log.d("gdy9", " *** save mBand = " + FmUtils.mBand + "  --str_key = " + str_key + " --list = " + Str_List);
            App_Radio.getInstance().mySharePreference2.saveStringValue(str_key, Str_List);
        }
    }

    public static void AddCollFreq(String freq, List<CollChannel> list) {
        if (Freq_CollectList != null) {
            if (list != null) {
                Log.d("col", " 00 AddCollFreq  freq = " + freq + " list = " + list.size());
            }
            CollChannel channel = new CollChannel();
            channel.coll_freq = freq;
            channel.coll_name = App_Radio.getInstance().mRadioInfoManager.queryFreq(freq);
            list.add(channel);
            Log.d("col", " 01 AddCollFreq  freq = " + freq + " list = " + list.size());
        }
    }

    public class TimeThread extends Thread {
        public TimeThread() {
        }

        /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Message msg = new Message();
                    msg.what = 1;
                    Page_Radio_6025.this.mHandler1.sendMessage(msg);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getTime() {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        int mHour = c.get(11);
        if (!DateFormat.is24HourFormat(MyApplication.myApp) && mHour > 12) {
            mHour -= 12;
        }
        int mMinute = c.get(12);
        return String.valueOf(mHour / 10) + (mHour % 10) + ":" + (mMinute / 10) + (mMinute % 10);
    }

    public void rdsEnable() {
        boolean bRdsDisplay = App_Radio.isSupportRds6025() && FmService.getRdsOnOff() == 1;
        JText txtPty = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Pty);
        JText txtPs = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ps);
        JText txtTa = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ta);
        JText txtTp = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Tp);
        View view = getPage().getChildViewByid(FinalRadioCtrl.Menu_Rds);
        if (view != null) {
            view.setVisibility(bRdsDisplay ? 0 : 8);
        } else {
            JButton btnPty = null;
            JButton btnTA = null;
            JButton btnAF = null;
            JPage page = getPage();
            if (page != null) {
                btnPty = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Pty);
                btnTA = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Ta);
                btnAF = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Af);
            }
            if (txtPty != null && App_Radio.getInstance().mIpcObj.isPtyValid()) {
                txtPty.setText(bRdsDisplay ? App_Radio.getInstance().mIpcObj.getPtyStr() : FinalChip.BSP_PLATFORM_Null);
            }
            if (txtPs != null) {
                txtPs.setVisibility(bRdsDisplay ? 0 : 4);
            }
            if (txtTa != null) {
                txtTa.setVisibility(bRdsDisplay ? 0 : 4);
            }
            if (txtTp != null) {
                txtTp.setVisibility(bRdsDisplay ? 0 : 4);
            }
            if (btnPty != null) {
                if (bRdsDisplay) {
                    btnPty.setTextColor(-1);
                } else {
                    btnPty.setTextColor(-7829368);
                }
                btnPty.setEnabled(bRdsDisplay);
            }
            if (btnAF != null) {
                if (bRdsDisplay) {
                    btnAF.setTextColor(-1);
                } else {
                    btnAF.setTextColor(-7829368);
                }
                btnAF.setEnabled(bRdsDisplay);
            }
            if (btnTA != null) {
                if (bRdsDisplay) {
                    btnTA.setTextColor(-1);
                } else {
                    btnTA.setTextColor(-7829368);
                }
                btnTA.setEnabled(bRdsDisplay);
            }
        }
        for (Page_Menu pageMenu : this.actRadio.mListPageMenus) {
            pageMenu.rdsEnable();
        }
    }

    public void updateRdsInfo() {
        int iRdsEnable = FmService.getRdsOnOff();
        if (FmUtils.mBand > 3) {
            iRdsEnable = -1;
        }
        if (App_Radio.isSupportRds6025() && this.switchRdsOnOffButton != null) {
            this.switchRdsOnOffButton.setChecked(iRdsEnable == 1);
        }
        rdsEnable();
        showTp(iRdsEnable);
        showTa(iRdsEnable);
        showPty(iRdsEnable);
        showTaOn(iRdsEnable);
        showAfOn(iRdsEnable);
        showPS(iRdsEnable);
        showRds(iRdsEnable);
    }

    public void showTp(int iRdsEnable) {
        if (iRdsEnable == 1) {
            int[] state = FmService.getRdsState();
            if (state != null) {
                if (this.mTextTp != null) {
                    if (state[0] == 1) {
                        this.mTextTp.setText("TP");
                        return;
                    } else {
                        this.mTextTp.setText(FinalChip.BSP_PLATFORM_Null);
                        return;
                    }
                }
                if (this.mViewTp != null) {
                    this.mViewTp.setFocus(state[0] == 1);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mTextTp != null) {
            this.mTextTp.setText(FinalChip.BSP_PLATFORM_Null);
        } else if (this.mViewTp != null) {
            this.mViewTp.setFocus(false);
        }
    }

    public void showTa(int iRdsEnable) {
        JButton btnTA = null;
        if (this.mPageMenu != null) {
            btnTA = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Ta);
        }
        if (iRdsEnable == 1) {
            int[] state = FmService.getRdsState();
            if (state != null && this.mTaState != state[1]) {
                if (this.mTextTa != null) {
                    if (state[1] == 1) {
                        this.mTextTa.setText("TA");
                    } else {
                        this.mTextTa.setText(FinalChip.BSP_PLATFORM_Null);
                    }
                } else if (this.mViewTa != null) {
                    this.mViewTa.setFocus(state[1] == 1);
                }
                if (btnTA != null && App_Radio.bSetFocus) {
                    btnTA.setFocus(state[1] == 1);
                }
                if (this.switchTAOnOffButton != null) {
                    this.switchTAOnOffButton.setChecked(state[1] == 1);
                }
                if (this.mTaState == 1 && state[1] != 1) {
                    if (FmService.mTaOnVisibility == 1) {
                        Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekTa, 20000L);
                    }
                } else if (state[1] == 1) {
                    Main.removeRunnable_Ui(App_Radio.getInstance().mRunnable_SeekTa);
                }
                this.mTaState = state[1];
                return;
            }
            return;
        }
        if (this.mTextTa != null) {
            this.mTextTa.setText(FinalChip.BSP_PLATFORM_Null);
        } else if (this.mViewTa != null) {
            this.mViewTa.setFocus(false);
        }
        if (btnTA != null && App_Radio.bSetFocus) {
            btnTA.setFocus(false);
        }
        if (this.switchTAOnOffButton != null) {
            this.switchTAOnOffButton.setChecked(false);
        }
    }

    public void showPty(int rdsEnable) {
        JText txtPty = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Pty);
        if (txtPty != null) {
            int visibility = 8;
            int flagPty = FmService.mPtyConf;
            int band = FmUtils.mBand;
            if (flagPty < 0 || flagPty > 40) {
                flagPty = 0;
            }
            if (rdsEnable == 1 && band >= 1 && band <= 3) {
                visibility = 0;
                txtPty.setText(RadioM.PTY_Display[flagPty]);
            }
            txtPty.setVisibility(visibility);
        }
    }

    public void showTaOn(int rdsEnable) {
        JButton btnTA = null;
        if (this.mPageMenu != null) {
            btnTA = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Ta);
        }
        if (rdsEnable == 1) {
            if (this.mTextTaOn != null) {
                if (FmService.mTaOnVisibility == 1) {
                    this.mTextTaOn.setText("TA ON");
                } else {
                    this.mTextTaOn.setText(FinalChip.BSP_PLATFORM_Null);
                }
            } else if (this.mViewTaOn != null) {
                this.mViewTaOn.setFocus(FmService.mTaOnVisibility == 1);
            }
            if (btnTA != null && App_Radio.bSetFocus) {
                btnTA.setFocus(FmService.mTaOnVisibility == 1);
            }
            if (this.switchTAOnOffButton != null) {
                this.switchTAOnOffButton.setChecked(FmService.mTaOnVisibility == 1);
                return;
            }
            return;
        }
        if (this.mTextTaOn != null) {
            this.mTextTaOn.setText(FinalChip.BSP_PLATFORM_Null);
        } else if (this.mViewTaOn != null) {
            this.mViewTaOn.setFocus(false);
        }
        if (btnTA != null && App_Radio.bSetFocus) {
            btnTA.setFocus(false);
        }
        if (this.switchTAOnOffButton != null) {
            this.switchTAOnOffButton.setChecked(false);
        }
    }

    public void showAfOn(int rdsEnable) {
        JButton btnAF = null;
        if (this.mPageMenu != null) {
            btnAF = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Af);
        }
        if (rdsEnable == 1) {
            if (this.mTextAfOn != null) {
                if (FmService.mAfOnVisibility == 1) {
                    this.mTextAfOn.setText("AF ON");
                } else {
                    this.mTextAfOn.setText(FinalChip.BSP_PLATFORM_Null);
                }
            } else if (this.mViewAfOn != null) {
                this.mViewAfOn.setFocus(FmService.mAfOnVisibility == 1);
            }
            if (btnAF != null && App_Radio.bSetFocus) {
                btnAF.setFocus(FmService.mAfOnVisibility == 1);
            }
            if (this.switchAFOnOffButton != null) {
                this.switchAFOnOffButton.setChecked(FmService.mAfOnVisibility == 1);
                return;
            }
            return;
        }
        if (this.mTextAfOn != null) {
            this.mTextAfOn.setText(FinalChip.BSP_PLATFORM_Null);
        } else if (this.mViewAfOn != null) {
            this.mViewAfOn.setFocus(false);
        }
        if (btnAF != null && App_Radio.bSetFocus) {
            btnAF.setFocus(false);
        }
        if (this.switchAFOnOffButton != null) {
            this.switchAFOnOffButton.setChecked(false);
        }
    }

    public void showPS(int rdsEnable) {
        JText txtPs = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ps);
        if (txtPs != null) {
            String strPsText = FinalChip.BSP_PLATFORM_Null;
            if (rdsEnable == 1 && FmUtils.mBand <= 3) {
                String strTmp = FmService.getPs();
                if (!TextUtils.isEmpty(strTmp)) {
                    strPsText = "PS:" + strTmp;
                }
            }
            txtPs.setText(strPsText);
            if (strPsText != FinalChip.BSP_PLATFORM_Null) {
                updateAllChannel(true);
                getColList();
            }
        }
    }

    public void showRds(int rdsEnable) {
        JText txtRds = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Rds);
        if (txtRds != null) {
            String strRdsText = FinalChip.BSP_PLATFORM_Null;
            if (rdsEnable == 1) {
                String strTmp = FmService.getRds();
                if (!TextUtils.isEmpty(strTmp)) {
                    strRdsText = strTmp;
                }
            }
            txtRds.setText(strRdsText);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void setPara(int iBand) {
        int iFreqCur;
        int iFreqMin;
        int iFreqMax;
        int iFreqStep;
        if (iBand <= 3) {
            boolean bIsOirtFMBand1 = FmService.isAreaOirtFMBand1(iBand);
            if (bIsOirtFMBand1) {
                iFreqCur = FmUtils.LOWEST_STATION_OIRT;
                iFreqMin = FmUtils.LOWEST_STATION_OIRT;
                iFreqMax = FmUtils.HIGHEST_STATION_OIRT;
                iFreqStep = FmUtils.STEP_OIRT;
            } else {
                iFreqCur = FmUtils.LOWEST_STATION_FM;
                iFreqMin = FmUtils.LOWEST_STATION_FM;
                iFreqMax = FmUtils.HIGHEST_STATION_FM;
                iFreqStep = FmUtils.STEP_FM;
            }
        } else {
            iFreqCur = FmUtils.LOWEST_STATION_AM;
            iFreqMin = FmUtils.LOWEST_STATION_AM;
            iFreqMax = FmUtils.HIGHEST_STATION_AM;
            iFreqStep = FmUtils.STEP_AM;
        }
        Log.d("freqq", " 44 Radio6025 setPara iBand = " + iBand);
        handleExtraFreqInfo(iFreqCur, iFreqMin, iFreqMax, iFreqStep);
    }

    public void handleExtraFreqInfo(int iFreqCur, int iFreqMin, int iFreqMax, int iFreqStep) {
        RadioM.sFreqMin = iFreqMin;
        RadioM.sFreqMax = iFreqMax;
        if (this.mRulerView != null) {
            this.mRulerView.setup(iFreqCur, iFreqMin, iFreqMax, iFreqStep);
        }
        Log.d("freqq", " 55 Radio6025 handleExtraFreqInfo iFreqMin = " + iFreqMin + " iFreqMax = " + iFreqMax);
        if (this.mFreqLineRuler != null) {
            this.mFreqLineRuler.setup(iFreqMin, iFreqMax, iFreqStep, (iFreqMax - iFreqMin) / iFreqStep);
        }
        if (this.mFreqRoundRuler != null) {
            this.mFreqRoundRuler.setup(iFreqMin, iFreqMax, iFreqStep, (iFreqMax - iFreqMin) / iFreqStep);
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() throws Throwable {
        this.bTop = true;
        this.mClickCnt = 0;
        if (App_Radio.isTranslucent) {
            this.actRadio.myActivity.hideSystemUi();
        } else {
            this.actRadio.myActivity.showSystemUi();
        }
        if (this.toast != null) {
            this.toast.cancel();
            Main.DATA[113] = 0;
        }
        setPara(FmUtils.mBand);
        App_Radio.mTypeRadio = 2;
        App_Radio.getInstance().saveSet();
        Log.d("gdy10", "  33   resume  App_Radio.bFocus = " + App_Radio.bFocus);
        if (!App_Radio.getInstance().mIpcObj.isRightAppId()) {
            App_Radio.getInstance().mIpcObj.requestAppIdRight();
        }
        if (this.actRadio.bNeedTuneCurrentStation) {
            this.actRadio.bNeedTuneCurrentStation = false;
            App_Radio.getInstance().setFreq(FmUtils.mCurStation, true);
        }
        if (App_Radio.mStrCustomer.equals("TZY_NEW") && App_Radio.bUI_NightColour) {
            setDayOrNight(App_Radio.mNightDay);
        }
        this.actRadio.startCheckSt();
        updateLoc();
        updateChannelTxt();
        updateHalfScreenVisble();
        checkTuneFromSpeech();
        refreshStationUI();
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void pause() {
        this.bTop = false;
        this.actRadio.stopCheckSt();
    }

    public void updataAF() {
        int[] state = FmService.getRdsConf();
        if (state != null && this.switchAFOnOffButton != null) {
            this.switchAFOnOffButton.setChecked(state[1] == 1);
        }
    }

    public void updataTA() {
        int[] state = FmService.getRdsConf();
        if (state != null && this.switchTAOnOffButton != null) {
            this.switchTAOnOffButton.setChecked(state[0] == 1);
        }
    }

    public void updateLoc() {
        if (FmUtils.mBand <= 3) {
            boolean bLoc = FmService.mLocFm;
            if (this.switchLocOnOffButton != null) {
                this.switchLocOnOffButton.setChecked(FmService.mLocFm);
            }
            if (this.mViewLoc != null) {
                this.mViewLoc.setVisibility(0);
                this.mViewLoc.setFocus(bLoc);
            }
            if (this.mTextLoc != null) {
                this.mTextLoc.setVisibility(0);
                this.mTextLoc.setText(this.actRadio.getStrLoc(bLoc));
            }
            Log.d("st", " loc  FmService.mLocFm = " + FmService.mLocFm);
            Intent intents = new Intent("com.syu.radio.data");
            intents.putExtra("loc", FmService.mLocFm);
            MyApplication.myApp.sendBroadcast(intents);
            return;
        }
        if (this.mViewLoc != null) {
            this.mViewLoc.setVisibility(8);
        }
        if (this.mTextLoc != null) {
            this.mTextLoc.setVisibility(8);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateStFocus() {
        boolean bStFocus = false;
        if (FmUtils.mBand <= 3) {
            bStFocus = App_Radio.getInstance().isRadioArmExternalSt_6025();
        }
        if (FmStation.getCurrentForceMono() == 1) {
            bStFocus = false;
        }
        Log.d("st", " loc  FmService.mLocFm = " + FmService.mLocFm);
        Intent intents = new Intent("com.syu.radio.data");
        intents.putExtra("st", bStFocus);
        MyApplication.myApp.sendBroadcast(intents);
        if (this.switchStOnOffButton != null) {
            this.switchStOnOffButton.setChecked(FmStation.getCurrentForceMono() == 0 && FmUtils.mBand <= 3);
        }
        JText txtSt = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_St);
        if (txtSt != null) {
            txtSt.setText(this.actRadio.getStrST(bStFocus));
            if (FmStation.getCurrentForceMono() == 0 && FmUtils.mBand <= 3) {
                txtSt.setVisibility(0);
            } else {
                txtSt.setVisibility(8);
            }
        } else if (this.mViewST != null) {
            this.mViewST.setFocus(bStFocus);
        }
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateChannelTxt() {
        String strBand;
        if (this.mTxtUnit != null) {
            if (FmUtils.mBand <= 3) {
                if (this.mViewFMAM != null) {
                    this.mViewFMAM.setFocus(false);
                }
                if (this.mTxtUnit != null) {
                    this.mTxtUnit.setText("MHz");
                }
                if (this.mTxtUnit1 != null) {
                    this.mTxtUnit1.setText("MHz");
                }
                if (this.mTxtUnit2 != null) {
                    this.mTxtUnit2.setText("MHz");
                }
                if (this.mTxtUnit3 != null) {
                    this.mTxtUnit3.setText("MHz");
                }
                if (this.mTxtUnit4 != null) {
                    this.mTxtUnit4.setText("MHz");
                }
                if (this.mTxtUnit5 != null) {
                    this.mTxtUnit5.setText("MHz");
                }
                if (this.mTxtUnit6 != null) {
                    this.mTxtUnit6.setText("MHz");
                }
            } else {
                if (this.mViewFMAM != null) {
                    this.mViewFMAM.setFocus(true);
                }
                if (this.mTxtUnit != null) {
                    this.mTxtUnit.setText("kHz");
                }
                if (this.mTxtUnit1 != null) {
                    this.mTxtUnit1.setText("kHz");
                }
                if (this.mTxtUnit2 != null) {
                    this.mTxtUnit2.setText("kHz");
                }
                if (this.mTxtUnit3 != null) {
                    this.mTxtUnit3.setText("kHz");
                }
                if (this.mTxtUnit4 != null) {
                    this.mTxtUnit4.setText("kHz");
                }
                if (this.mTxtUnit5 != null) {
                    this.mTxtUnit5.setText("kHz");
                }
                if (this.mTxtUnit6 != null) {
                    this.mTxtUnit6.setText("kHz");
                }
            }
        }
        if (App_Radio.bChangeChannelText) {
            if (FmUtils.mBand <= 3) {
                strBand = "FM";
            } else {
                strBand = "AM";
            }
        } else if (FmUtils.mBand <= 3) {
            strBand = String.format(Locale.US, "FM %d-%d", Integer.valueOf(FmUtils.mBand), Integer.valueOf(FmUtils.mIndexRadio[FmUtils.mBand - 1] + 1));
        } else {
            strBand = String.format(Locale.US, "AM %d-%d", Integer.valueOf((FmUtils.mBand - 4) + 1), Integer.valueOf(FmUtils.mIndexRadio[FmUtils.mBand - 1] + 1));
        }
        if (this.mTxtChannel != null) {
            this.mTxtChannel.setText(strBand);
        }
        if (this.mFreqBand != null) {
            this.mFreqBand.setCurrenBand(strBand);
        }
        if (this.bTop && mViewPagerFMAM != null) {
            int item = FmUtils.mBand;
            Log.d("freq", " ** 00 mViewPagerFMAM.setCurrentItem item= " + item);
            mViewPagerFMAM.setCurrentItem(item);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void checkTuneFromSpeech() {
        int iStationSpeech = this.actRadio.mFreqTuneFromSpeech;
        if (FmUtils.isValidStation(iStationSpeech)) {
            if (iStationSpeech == FmUtils.mCurStation) {
                this.actRadio.mFreqTuneFromSpeech = -1;
            } else {
                App_Radio.getInstance().setFreq(this.actRadio.mFreqTuneFromSpeech, true);
            }
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateCurrentFreq(int freq, boolean bCheckAdjust) {
        String strFreq;
        JPage page;
        JText text;
        Log.d("gdy11", " 11 radio Page 6025 updateCurrentFreq freq = " + freq);
        if (bCheckAdjust) {
            JFreqRoundRuler freqRoundRuler = (JFreqRoundRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqRoundRuler);
            if (freqRoundRuler == null || !freqRoundRuler.isAdjusting()) {
                JFreqLineRuler freqLineRuler = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
                if (freqLineRuler == null || !freqLineRuler.isAdjusting()) {
                    JRulerView rulerView = (JRulerView) getPage().getChildViewByid(FinalRadioCtrl.Radio_RulerView);
                    if (rulerView != null && rulerView.isAdjusting()) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        if (FmUtils.mBand > 3 || freq >= 6500) {
            if (FmUtils.mBand <= 3 || freq < 6500) {
                FmUtils.mDispStation = freq;
                RadioM.PROXY.cmd(26, 0, freq);
                App_Radio.getInstance().sendRadioInfo2Mcu();
                if (FmService.isAreaOirtFM(FmUtils.mBand)) {
                    if (freq > RadioM.sFreqMax) {
                        handleExtraFreqInfo(freq, 8750, 10800, 10);
                    } else if (freq < RadioM.sFreqMin) {
                        handleExtraFreqInfo(freq, 6500, 7400, 3);
                    }
                }
                if (freq > 5000) {
                    Radio_IpcObj.mFreq_for_db = freq;
                    strFreq = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
                } else {
                    Radio_IpcObj.mFreq_for_db = freq * 100;
                    strFreq = new StringBuilder().append(freq).toString();
                }
                App_Radio.getInstance().updateCurFreqName(this.mTxtCurrentFreqName, strFreq);
                this.strFreq_run = strFreq;
                Show_FreqNameAll();
                if (this.mTxtCurrentFreq != null) {
                    if (freq > 5000) {
                        this.mTxtCurrentFreq.setText("FM " + strFreq);
                    } else {
                        this.mTxtCurrentFreq.setText("AM " + strFreq);
                    }
                }
                if (this.mFreqView != null) {
                    this.mFreqView.setCurrenFreq(strFreq);
                }
                if (this.mFreqView_night != null) {
                    this.mFreqView_night.setCurrenFreq(strFreq);
                }
                if (App_Radio.mStrCustomer.equals("YL_3") && this.mLineRuler != null) {
                    this.mLineRuler.setVisibility(0);
                    if (this.mView_Radio_FreqLineRuler_bk != null) {
                        this.mView_Radio_FreqLineRuler_bk.setVisibility(0);
                    }
                    View view = getPage().getChildViewByid(FinalRadioCtrl.view_radioTxt);
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    if (this.mTxtCurrentFreqName != null) {
                        this.mTxtCurrentFreqName.setVisibility(8);
                    }
                    Main.removeRunnable_Ui(this.mRunnableRulerNight);
                    Main.postRunnable_Ui(true, this.mRunnableRulerNight, 3000L);
                }
                if (mBtnCol != null) {
                    Desplay_Freq = strFreq;
                    if (getColIdByFreq(Desplay_Freq, getColList()) != 255) {
                        mBtnCol.setBackground(drawable_col_p);
                    } else {
                        mBtnCol.setBackground(drawable_col_n);
                    }
                    if (Freq_CollectList != null && Freq_CollectList.getVisibility() == 0 && !App_Radio.mService.isScanning() && !App_Radio.mService.isSeeking()) {
                        refreshCol();
                    }
                    Log.d("list2", " *0* updateText freq = " + strFreq + "   i = " + this.i);
                }
                if (this.mTxtFreqShow != null) {
                    this.mTxtFreqShow.setText(strFreq);
                }
                JText title = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Title);
                if (title != null) {
                    if (freq > 5000) {
                        title.setText("FM    " + strFreq + "    MHz");
                    } else {
                        title.setText("AM    " + strFreq + "    kHz");
                    }
                }
                JFreqRoundRuler freqRoundRuler2 = (JFreqRoundRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqRoundRuler);
                if (freqRoundRuler2 != null) {
                    freqRoundRuler2.updateFreq(freq);
                }
                Log.d("gdy3", " ** 00 radio 6025 Ruler freq = " + freq);
                JFreqLineRuler freqLineRuler2 = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
                if (freqLineRuler2 != null) {
                    freqLineRuler2.updateFreq(freq);
                }
                JRulerView rulerView2 = (JRulerView) getPage().getChildViewByid(FinalRadioCtrl.Radio_RulerView);
                if (rulerView2 != null) {
                    rulerView2.setup(freq, -1, -1, -1);
                }
                JText text2 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Freq);
                if (text2 != null) {
                    text2.setText(strFreq);
                }
                Dialog popDlg = getPage().ui.mDlgs.get(FinalRadioCtrl.Page_EditInfo);
                if (popDlg != null && popDlg.isShowing() && (page = getPage().ui.getPage(FinalRadioCtrl.Page_EditInfo)) != null && (text = (JText) page.getChildViewByid(FinalRadioCtrl.EditInfo_Txt_Freq)) != null) {
                    text.setText(strFreq);
                }
                Main.removeRunnable_Ui(this.mRunnableUpdateAllChannel);
                Main.postRunnable_Ui(true, this.mRunnableUpdateAllChannel, 300L);
                if (Main.DATA[113] == 1 && getPage().getDrawableFromPath("gps_freq", getPage().mDrawables, getPage().mDrawables) != null) {
                    if (freq > 5000) {
                        this.Gps_freq = "FM " + strFreq + "MHz";
                    } else {
                        this.Gps_freq = "AM " + strFreq + "kHz";
                    }
                    showToast(this.Gps_freq);
                }
            }
        }
    }

    private void showToast(String info) {
        if (this.isToastShow) {
            this.isToastShow = false;
            Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.14
                @Override // java.lang.Runnable
                public void run() {
                    Page_Radio_6025.this.isToastShow = true;
                    if (Page_Radio_6025.this.toast != null) {
                        Page_Radio_6025.this.toast.cancel();
                    }
                }
            }, 3000L);
        }
        Drawable drawable = getPage().getDrawableFromPath("gps_freq", getPage().mDrawables, getPage().mDrawables);
        if (drawable != null) {
            if (this.toast == null) {
                this.toast = Toast.makeText(MyApplication.myApp, info, 1);
                LinearLayout layout = (LinearLayout) this.toast.getView();
                layout.setBackground(drawable);
                TextView v = (TextView) this.toast.getView().findViewById(R.id.message);
                v.setTextColor(-1);
                v.setTextSize(App_Radio.mGpsFreq_Size);
                v.setPadding(0, App_Radio.mGpsFreq_Top, 0, 0);
                this.toast.setGravity(80, 0, 150);
            } else {
                this.toast.setText(info);
            }
            if (this.toast != null) {
                this.toast.show();
            }
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void refreshStationUI() {
        updateCurrentFreq(FmUtils.mCurStation, true);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void hideScan() {
        if (this.mViewScan != null) {
            this.mViewScan.setFocus(false);
        }
        if (this.mTextScan != null) {
            this.mTextScan.setText(FinalChip.BSP_PLATFORM_Null);
        }
    }

    public void Func_FreqAdujst(boolean bFreqP, boolean bLongClick) {
        if (App_Radio.isFreqMinusOrPlus(bLongClick)) {
            if (bFreqP) {
                int station = FmUtils.computeIncreaseStation();
                App_Radio.getInstance().setFreq(station, true);
                return;
            } else {
                int station2 = FmUtils.computeDecreaseStation();
                App_Radio.getInstance().setFreq(station2, true);
                return;
            }
        }
        if (bFreqP) {
            FmNative.getInstance().test_stopScan();
            if (App_Radio.mService.isSeeking()) {
                this.actRadio.stopScan();
                return;
            } else {
                App_Radio.getInstance().seekUp();
                return;
            }
        }
        FmNative.getInstance().test_stopScan();
        if (App_Radio.mService.isSeeking()) {
            this.actRadio.stopScan();
        } else {
            App_Radio.getInstance().seekDown();
        }
    }

    public void Func_Scan(boolean bLongClick) {
        if (App_Radio.isScan(bLongClick)) {
            this.actRadio.startScan();
        } else {
            Func_Search();
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void Func_Search() {
        FmNative.getInstance().test_stopScan();
        this.actRadio.stopScan();
        this.actRadio.showLoading();
        if (App_Radio.mService != null && !App_Radio.mService.isScanning() && !App_Radio.mService.isSeeking()) {
            App_Radio.mService.startScan();
        }
    }

    public void Send_MsgServerIntent(String str_data) {
        Log.d("gdy1", " 33 Send com.syu.radio.msgservice str_data = " + str_data);
        Intent serviceIntent = new Intent("com.syu.radio.msgservice");
        serviceIntent.setPackage(FmStation.AUTHORITY);
        serviceIntent.putExtra("data", str_data);
        MyApplication.myApp.startService(serviceIntent);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public boolean ResponseClick_Menu(int id) throws Throwable {
        int iCurConf_list = 255;
        switch (id) {
            case FinalRadioCtrl.Set_Switch_RdsOnOff /* 130056 */:
                if (this.switchRdsOnOffButton != null) {
                    if (this.switchRdsOnOffButton.isChecked()) {
                        FmService.setRdsOnOff(1);
                    } else {
                        FmService.setRdsOnOff(0);
                    }
                }
                updateRdsInfo();
                this.actRadio.updateRdsInfo();
                break;
            case FinalRadioCtrl.Set_Switch_LocOnOff /* 130058 */:
            case FinalRadioCtrl.Radio_Btn_Loc /* 130110 */:
                if (FmUtils.mBand <= 3) {
                    this.actRadio.stopScan();
                    FmService.mLocFm = !FmService.mLocFm;
                    FmStation.setLoc(FmService.mLocFm);
                    updateLoc();
                    App_Radio.getInstance().sendRadioInfo2Mcu();
                }
                break;
            case FinalRadioCtrl.Set_Switch_AFOnOff /* 130059 */:
            case FinalRadioCtrl.Radio_Btn_Af /* 130134 */:
                int[] state = FmService.getRdsConf();
                if (state != null) {
                    this.actRadio.stopScan();
                    if (state[1] == 1) {
                        FmService.setRdsAfOnOff(0);
                    } else {
                        FmService.setRdsAfOnOff(1);
                    }
                }
                updataAF();
                break;
            case FinalRadioCtrl.Set_Switch_TAOnOff /* 130060 */:
            case FinalRadioCtrl.Radio_Btn_Ta /* 130115 */:
                int[] state2 = FmService.getRdsConf();
                if (state2 != null) {
                    this.actRadio.stopScan();
                    if (state2[0] == 1) {
                        if (FmService.setRdsTaOnOff(0) == 0) {
                            Main.removeRunnable_Ui(App_Radio.getInstance().mRunnable_SeekTa);
                        }
                    } else if (FmService.setRdsTaOnOff(1) == 0) {
                        Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekTa, 3000L);
                    }
                }
                updataTA();
                break;
            case FinalRadioCtrl.Set_Switch_StOnOff /* 130061 */:
            case FinalRadioCtrl.Radio_Btn_ST /* 130111 */:
                if (App_Radio.iRadioType_Arm == 2) {
                    this.actRadio.stopScan();
                    if (FmStation.getCurrentForceMono() == 0) {
                        FmStation.setCurrentForceMono(1);
                    } else {
                        FmStation.setCurrentForceMono(0);
                    }
                    if (FmStation.getCurrentForceMono() == 1) {
                        App_Radio.getInstance().setRadioArmExternalForceMono_6025(true);
                    } else {
                        App_Radio.getInstance().setRadioArmExternalForceMono_6025(false);
                    }
                    if (FmStation.getCurrentForceMono() == 1) {
                        this.actRadio.stopCheckSt();
                    } else {
                        this.actRadio.startCheckSt();
                    }
                    updateStFocus();
                }
                break;
            case FinalRadioCtrl.Radio_Btn_FreqM /* 130099 */:
                if (App_Radio.mLongClick_Time == 0) {
                    Func_FreqAdujst(false, false);
                } else {
                    Func_FreqAdujst(false, this.bFreqBtnType);
                }
                break;
            case FinalRadioCtrl.Radio_Btn_FreqP /* 130100 */:
                if (App_Radio.mLongClick_Time == 0) {
                    Func_FreqAdujst(true, false);
                } else {
                    Func_FreqAdujst(true, this.bFreqBtnType);
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Eq /* 130104 */:
                Log.d("eqq", " Page radio 6025 Radio_Btn_Eq **** 000 ");
                if (!FuncUtils.isFastDoubleClick()) {
                    Log.d("eqq", " Page radio 6025  Radio_Btn_Eq **** 111 ");
                    Intent intent = new Intent();
                    intent.setAction("com.syu.eq");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setFlags(268435456);
                    this.actRadio.myActivity.startActivity(intent);
                    Log.d("eqq", " Page radio 6025  Radio_Btn_Eq **** 222 ");
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Band /* 130105 */:
            case FinalRadioCtrl.Radio_Btn_Band_FM /* 130108 */:
            case FinalRadioCtrl.Radio_Btn_Band_AM /* 130109 */:
                if (App_Radio.isSupportAm() && this.mFm2AmGroup != null) {
                    if (this.mFm2AmGroup.getVisibility() == 8) {
                        this.mFm2AmGroup.setVisibility(0);
                    } else {
                        this.mFm2AmGroup.setVisibility(8);
                    }
                } else {
                    switchBand(true, true, true);
                }
                break;
            case FinalRadioCtrl.Radio_Btn_FMBand /* 130106 */:
                FmNative.getInstance().test_stopScan();
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.15
                    @Override // java.lang.Runnable
                    public void run() {
                        int iBandFm = 1;
                        if (FmUtils.mBand < 3) {
                            iBandFm = FmUtils.mBand + 1;
                        }
                        Page_Radio_6025.this.switchBand(iBandFm, true);
                        if (Page_Radio_6025.this.mFm2AmGroup != null) {
                            Page_Radio_6025.this.mFm2AmGroup.setVisibility(8);
                        }
                    }
                }, 200L);
                break;
            case FinalRadioCtrl.Radio_Btn_AMBand /* 130107 */:
                FmNative.getInstance().test_stopScan();
                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.16
                    @Override // java.lang.Runnable
                    public void run() {
                        int iBandAm = 4;
                        if (FmUtils.mBand == 4) {
                            iBandAm = 5;
                        }
                        Page_Radio_6025.this.switchBand(iBandAm, true);
                        if (Page_Radio_6025.this.mFm2AmGroup != null) {
                            Page_Radio_6025.this.mFm2AmGroup.setVisibility(8);
                        }
                    }
                }, 200L);
                break;
            case FinalRadioCtrl.Radio_Btn_Scan /* 130112 */:
                Func_Scan(false);
                break;
            case FinalRadioCtrl.Radio_Btn_Save /* 130113 */:
                this.actRadio.stopScan();
                saveCurrentChannel(FmUtils.mBand, FmUtils.mIndexRadio[FmUtils.mBand - 1]);
                break;
            case FinalRadioCtrl.Radio_Btn_Pty /* 130114 */:
                this.actRadio.stopScan();
                int iCurConf = FmService.mPtyConf + 1;
                if (iCurConf < 0 || iCurConf > 31) {
                    iCurConf = 0;
                }
                if (FmService.setRdsPtyType(iCurConf) == 0) {
                    FmService.mPtyConf = iCurConf;
                    App_Radio.getInstance().mySharePreference2.saveIntValue("PtyConf", FmService.mPtyConf);
                    showPty(FmService.getRdsOnOff());
                    if (FmService.mPtyConf != 0) {
                        Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekPty, 3000L);
                    }
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Hand /* 130137 */:
                showRuler(true);
                break;
            case FinalRadioCtrl.btn_music /* 130164 */:
                Intent intent1 = new Intent("android.intent.action.MAIN");
                intent1.addFlags(270532608);
                intent1.setComponent(new ComponentName("com.syu.music", "com.syu.app.Activity_All"));
                try {
                    this.actRadio.myActivity.startActivity(intent1);
                } catch (Exception e) {
                    Toast.makeText(MyApplication.myApp, "App not installed", 0).show();
                }
                break;
            case FinalRadioCtrl.btn_bt /* 130165 */:
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addFlags(270532608);
                intent2.setComponent(new ComponentName("com.syu.bt", "com.syu.bt.act.ActBtAvStart"));
                try {
                    this.actRadio.myActivity.startActivity(intent2);
                } catch (Exception e2) {
                    Toast.makeText(MyApplication.myApp, "App not installed", 0).show();
                }
                break;
            case FinalRadioCtrl.btn_rl /* 130166 */:
                Intent intent3 = new Intent("android.intent.action.MAIN");
                intent3.addFlags(270532608);
                intent3.setComponent(new ComponentName("com.syu.onlineradio", "com.syu.onlineradio.MainActivity"));
                try {
                    this.actRadio.myActivity.startActivity(intent3);
                } catch (Exception e3) {
                    Toast.makeText(MyApplication.myApp, "App not installed", 0).show();
                }
                break;
            case FinalRadioCtrl.radio_spsotify /* 130167 */:
                String pkg = SystemProperties.get("persist.launcher.music.pkg", FinalChip.BSP_PLATFORM_Null);
                if (!TextUtils.isEmpty(pkg)) {
                    PackageInfo packageinfo = null;
                    try {
                        packageinfo = MyApplication.myApp.getPackageManager().getPackageInfo(pkg, 0);
                    } catch (PackageManager.NameNotFoundException e4) {
                        e4.printStackTrace();
                    }
                    if (packageinfo == null) {
                        return false;
                    }
                    Intent resolveIntent = new Intent("android.intent.action.MAIN", (Uri) null);
                    resolveIntent.addCategory("android.intent.category.LAUNCHER");
                    resolveIntent.setPackage(packageinfo.packageName);
                    List<ResolveInfo> resolveinfoList = MyApplication.myApp.getPackageManager().queryIntentActivities(resolveIntent, 0);
                    ResolveInfo resolveinfo = resolveinfoList.iterator().next();
                    if (resolveinfo != null) {
                        String packageName = resolveinfo.activityInfo.packageName;
                        String className = resolveinfo.activityInfo.name;
                        Intent intentSpoitfy = new Intent("android.intent.action.MAIN");
                        intentSpoitfy.addCategory("android.intent.category.LAUNCHER");
                        ComponentName cn = new ComponentName(packageName, className);
                        intentSpoitfy.setComponent(cn);
                        this.actRadio.myActivity.startActivity(intentSpoitfy);
                    }
                } else {
                    Intent spotify = new Intent("tzy_music.MusicService.SelectSpotifyYandex");
                    spotify.setPackage("com.syu.tzy_music");
                    MyApplication.myApp.startService(spotify);
                }
                break;
            case FinalRadioCtrl.Radio_Btn_PtyList /* 130233 */:
                if (this.mPTY_VIEW != null) {
                    if (this.mPTY_VIEW.getVisibility() == 8) {
                        this.mPTY_VIEW.setVisibility(0);
                    } else {
                        this.mPTY_VIEW.setVisibility(8);
                    }
                }
                break;
            case FinalRadioCtrl.Radio_PTY_Back /* 130235 */:
                if (this.mPTY_VIEW != null) {
                    this.mPTY_VIEW.setVisibility(8);
                }
                break;
            case FinalRadioCtrl.Radio_PTY_0 /* 130236 */:
            case FinalRadioCtrl.Radio_PTY_1 /* 130237 */:
            case FinalRadioCtrl.Radio_PTY_2 /* 130238 */:
            case FinalRadioCtrl.Radio_PTY_3 /* 130239 */:
            case FinalRadioCtrl.Radio_PTY_4 /* 130240 */:
            case FinalRadioCtrl.Radio_PTY_5 /* 130241 */:
            case FinalRadioCtrl.Radio_PTY_6 /* 130242 */:
            case FinalRadioCtrl.Radio_PTY_7 /* 130243 */:
            case FinalRadioCtrl.Radio_PTY_8 /* 130244 */:
            case FinalRadioCtrl.Radio_PTY_9 /* 130245 */:
            case FinalRadioCtrl.Radio_PTY_10 /* 130246 */:
            case FinalRadioCtrl.Radio_PTY_11 /* 130247 */:
            case FinalRadioCtrl.Radio_PTY_12 /* 130248 */:
            case FinalRadioCtrl.Radio_PTY_13 /* 130249 */:
            case FinalRadioCtrl.Radio_PTY_14 /* 130250 */:
            case FinalRadioCtrl.Radio_PTY_15 /* 130251 */:
            case FinalRadioCtrl.Radio_PTY_16 /* 130252 */:
            case FinalRadioCtrl.Radio_PTY_17 /* 130253 */:
            case FinalRadioCtrl.Radio_PTY_18 /* 130254 */:
            case FinalRadioCtrl.Radio_PTY_19 /* 130255 */:
            case FinalRadioCtrl.Radio_PTY_20 /* 130256 */:
            case FinalRadioCtrl.Radio_PTY_21 /* 130257 */:
            case FinalRadioCtrl.Radio_PTY_22 /* 130258 */:
            case FinalRadioCtrl.Radio_PTY_23 /* 130259 */:
            case FinalRadioCtrl.Radio_PTY_24 /* 130260 */:
            case FinalRadioCtrl.Radio_PTY_25 /* 130261 */:
            case FinalRadioCtrl.Radio_PTY_26 /* 130262 */:
                this.actRadio.stopScan();
                iCurConf_list = (id - FinalRadioCtrl.Radio_PTY_0) + 2;
                if (this.mPTY_VIEW != null) {
                    this.mPTY_VIEW.setVisibility(8);
                }
                break;
            case FinalRadioCtrl.Radio_PTY_27 /* 130263 */:
                this.actRadio.stopScan();
                iCurConf_list = 1;
                if (this.mPTY_VIEW != null) {
                    this.mPTY_VIEW.setVisibility(8);
                }
                break;
            case FinalRadioCtrl.Radio_PTY_28 /* 130264 */:
                this.actRadio.stopScan();
                iCurConf_list = 29;
                if (this.mPTY_VIEW != null) {
                    this.mPTY_VIEW.setVisibility(8);
                }
                break;
            case FinalRadioCtrl.Radio_PTY_29 /* 130265 */:
                this.actRadio.stopScan();
                iCurConf_list = 30;
                if (this.mPTY_VIEW != null) {
                    this.mPTY_VIEW.setVisibility(8);
                }
                break;
            case FinalRadioCtrl.Radio_PTY_30 /* 130266 */:
                this.actRadio.stopScan();
                iCurConf_list = 31;
                if (this.mPTY_VIEW != null) {
                    this.mPTY_VIEW.setVisibility(8);
                }
                break;
            default:
                return false;
        }
        if (iCurConf_list != 255 && FmService.setRdsPtyType(iCurConf_list) == 0) {
            FmService.mPtyConf = iCurConf_list;
            App_Radio.getInstance().mySharePreference2.saveIntValue("PtyConf", FmService.mPtyConf);
            showPty(FmService.getRdsOnOff());
            if (FmService.mPtyConf != 0) {
                Main.removeRunnable_Ui(App_Radio.getInstance().mRunnable_SeekPty);
            }
            Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekPty, 300L);
        }
        return true;
    }

    public void selectChannel(int index) {
        if (index >= 0 && index < 6) {
            boolean bSameBand = true;
            int bandFix = this.actRadio.getFixBand(mViewPagerFMAM, false);
            if (bandFix != FmUtils.mBand) {
                bSameBand = false;
                FmUtils.mBand = bandFix;
                FmStation.saveCurrentBand();
            }
            if (bSameBand && App_Radio.bNeedSetBtnBk && FmUtils.mIndexRadio[bandFix - 1] == index) {
                this.mClickCnt++;
                App_Radio.mStrFreqCur = new StringBuilder().append(FmUtils.mCurStation).toString();
                if (this.mClickCnt == 3) {
                    this.actRadio.jumpPhoto();
                    return;
                }
                return;
            }
            this.mClickCnt = 0;
            FmNative.getInstance().test_stopScan();
            int start = (bandFix - 1) * 6;
            if (App_Radio.getInstance().mListRadio.size() > start + index) {
                FmUtils.mIndexRadio[bandFix - 1] = index;
                FmStation.setCurrentIndexRadio(bandFix, FmUtils.mIndexRadio[bandFix - 1]);
                updateChannelTxt();
                SparseArray<String> map = App_Radio.getInstance().mListRadio.get(start + index);
                float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
                App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
                updateListRadio();
            }
        }
    }

    public void saveChannel(int index) {
        if (index >= 0 && index < 6) {
            int bandFix = this.actRadio.getFixBand(mViewPagerFMAM, false);
            FmUtils.mBand = bandFix;
            FmStation.saveCurrentBand();
            FmUtils.mIndexRadio[bandFix - 1] = index;
            saveCurrentChannel(bandFix, FmUtils.mIndexRadio[bandFix - 1]);
            FmStation.setCurrentIndexRadio(bandFix, FmUtils.mIndexRadio[bandFix - 1]);
            updateChannelTxt();
            updateListRadio();
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void ResponseClick(int id) throws Throwable {
        boolean bRet = ResponseClick_Menu(id);
        if (!bRet) {
            switch (id) {
                case FinalRadioCtrl.Radio_Btn_StandBy /* 130075 */:
                    App_Radio.getInstance().mIpcObj.SetStandBy();
                    break;
                case FinalRadioCtrl.Radio_Btn_FullScreen /* 130076 */:
                    App_Radio.getInstance().setFullScreenMode(1);
                    break;
                case FinalRadioCtrl.Radio_Btn_HalfScreen /* 130077 */:
                    if (App_Radio.getInstance().isHalfScreenAble()) {
                        App_Radio.getInstance().setFullScreenMode(0);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Freq1 /* 130078 */:
                case FinalRadioCtrl.Radio_Btn_Freq2 /* 130079 */:
                case FinalRadioCtrl.Radio_Btn_Freq3 /* 130080 */:
                case FinalRadioCtrl.Radio_Btn_Freq4 /* 130081 */:
                case FinalRadioCtrl.Radio_Btn_Freq5 /* 130082 */:
                case FinalRadioCtrl.Radio_Btn_Freq6 /* 130083 */:
                    selectChannel(id - FinalRadioCtrl.Radio_Btn_Freq1);
                    break;
                case FinalRadioCtrl.Radio_Btn_SeekUp /* 130102 */:
                    App_Radio.getInstance().mIpcObj.SeekUp();
                    break;
                case FinalRadioCtrl.Radio_Btn_SeekDown /* 130103 */:
                    App_Radio.getInstance().mIpcObj.SeekDown();
                    break;
                case FinalRadioCtrl.Radio_Btn_FMBand /* 130106 */:
                    this.i_band = 1;
                    if (FmUtils.mBand < 3) {
                        this.i_band = FmUtils.mBand + 1;
                    }
                    App_Radio.getInstance().mIpcObj.SFmBand();
                    switchBand(this.i_band, true);
                    if (this.mFm2AmGroup != null) {
                        this.mFm2AmGroup.setVisibility(8);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_AMBand /* 130107 */:
                    this.i_band = 4;
                    if (FmUtils.mBand == 4) {
                        this.i_band = 5;
                    }
                    App_Radio.getInstance().mIpcObj.SAmBand();
                    switchBand(this.i_band, true);
                    if (this.mFm2AmGroup != null) {
                        this.mFm2AmGroup.setVisibility(8);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Edit /* 130116 */:
                    Log.d("edit", " 00  Radio_Btn_Edit ");
                    Dialog popDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_Info, "pop_add_contacts_anim", true);
                    Log.d("edit", " 01  Radio_Btn_Edit ");
                    if (popDlg != null) {
                        Log.d("edit", " 02  Radio_Btn_Edit ");
                        JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_Info);
                        Log.d("edit", " 03  Radio_Btn_Edit ");
                        if (page != null) {
                            page.resume();
                        }
                        Log.d("edit", " 04  Radio_Btn_Edit ");
                        popDlg.show();
                    }
                    if (App_Radio.mFacturer_Id == 112) {
                        Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.17
                            @Override // java.lang.Runnable
                            public void run() {
                                Dialog popDlg_Edit = Page_Radio_6025.this.getPage().ui.getPopDlg(FinalRadioCtrl.Page_EditInfo, "popwindow_delete_btn_anim_style", true);
                                if (popDlg_Edit != null) {
                                    JPage page2 = Page_Radio_6025.this.actRadio.ui.getPage(FinalRadioCtrl.Page_EditInfo);
                                    Radio_IpcObj.mIsAdd_for_db = true;
                                    if (page2 != null) {
                                        page2.resume();
                                    }
                                    popDlg_Edit.show();
                                }
                            }
                        }, 200L);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Del /* 130119 */:
                    MsgBox_Sel = 255;
                    Dialog popDlg2 = this.actRadio.ui.getPopDlg(FinalRadioCtrl.Page_MsgBox, "popwindow_delete_btn_anim_style", true);
                    if (popDlg2 != null) {
                        JPage page2 = this.actRadio.ui.getPage(FinalRadioCtrl.Page_MsgBox);
                        if (page2 != null) {
                            page2.resume();
                        }
                        popDlg2.show();
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Col /* 130120 */:
                    bCol_Freq(Desplay_Freq, getColList());
                    break;
                case FinalRadioCtrl.Radio_Btn_FreqList /* 130123 */:
                    if (mViewPagerFMAM != null) {
                        mViewPagerFMAM.setVisibility(0);
                    }
                    if (Freq_CollectList != null) {
                        Freq_CollectList.setVisibility(8);
                    }
                    if (BtnDeleteAll != null) {
                        BtnDeleteAll.setEnabled(false);
                    }
                    if (this.mBtnFreqList != null) {
                        this.mBtnFreqList.setBackground(getPage().getDrawableFromPath("radio_menu_freqlist_p", null, null));
                    }
                    if (this.mBtnColList != null) {
                        this.mBtnColList.setBackground(getPage().getDrawableFromPath("radio_menu_collist_n", null, null));
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_ColList /* 130127 */:
                    if (mViewPagerFMAM != null) {
                        mViewPagerFMAM.setVisibility(8);
                    }
                    if (Freq_CollectList != null) {
                        Freq_CollectList.setVisibility(0);
                        refreshCol();
                    }
                    if (BtnDeleteAll != null) {
                        BtnDeleteAll.setEnabled(true);
                    }
                    if (this.mBtnFreqList != null) {
                        this.mBtnFreqList.setBackground(getPage().getDrawableFromPath("radio_menu_freqlist", null, null));
                    }
                    if (this.mBtnColList != null) {
                        this.mBtnColList.setBackground(getPage().getDrawableFromPath("radio_menu_collist_p", null, null));
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Set /* 130135 */:
                    Log.d("gdy4", " *** Radio_Btn_Set mStrCustomer = " + App_Radio.mStrCustomer);
                    if (App_Radio.mStrCustomer.equals("YL_3")) {
                        Dialog popSetDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_SettingInfo, "pop_add_contacts_anim", true);
                        if (popSetDlg != null) {
                            popSetDlg.show();
                        }
                    } else {
                        this.actRadio.goPage(FinalRadioCtrl.Page_Set);
                    }
                    break;
                case FinalRadioCtrl.Radio_Menu_Home /* 130231 */:
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.HOME");
                    this.actRadio.myActivity.startActivity(intent);
                    break;
                case FinalRadioCtrl.Radio_Menu_Back /* 130232 */:
                    this.actRadio.myActivity.dispatchKeyEvent(new KeyEvent(0, 4));
                    this.actRadio.myActivity.finish();
                    break;
            }
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) throws Throwable {
        Log.d("gdd", "  11   windowFocusChanged  App_Radio.bFocus = " + App_Radio.bFocus);
        if (!App_Radio.getInstance().mIpcObj.isRightAppId()) {
            App_Radio.getInstance().mIpcObj.requestAppIdRight();
        }
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.Radio_FreqRoundRuler /* 130223 */:
                JFreqRoundRuler freqRoundRuler = (JFreqRoundRuler) v;
                if (freqRoundRuler != null) {
                    App_Radio.getInstance().setFreq(freqRoundRuler.mFreqShouldBe, true);
                }
                break;
            case FinalRadioCtrl.Radio_FreqLineRuler /* 130224 */:
                JFreqLineRuler freqLineRuler = (JFreqLineRuler) v;
                if (freqLineRuler != null) {
                    App_Radio.getInstance().setFreq(freqLineRuler.mFreqShouldBe, true);
                }
                break;
            default:
                ResponseClick(id);
                break;
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public boolean ResponseLongClick_Menu(int id) {
        switch (id) {
            case FinalRadioCtrl.Radio_Btn_FreqM /* 130099 */:
                if (App_Radio.mLongClick_Time == 0) {
                    Func_FreqAdujst(false, true);
                }
                break;
            case FinalRadioCtrl.Radio_Btn_FreqP /* 130100 */:
                if (App_Radio.mLongClick_Time == 0) {
                    Func_FreqAdujst(true, true);
                }
                break;
            case FinalRadioCtrl.Radio_Btn_SetFreq /* 130101 */:
                Dialog popDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_SetFreqInfo, "pop_add_contacts_anim", true);
                if (popDlg != null) {
                    JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_SetFreqInfo);
                    if (page != null) {
                        page.resume();
                    }
                    popDlg.show();
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Scan /* 130112 */:
                Func_Scan(true);
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void ResponseLongClick(int id) {
        boolean bRet = ResponseLongClick_Menu(id);
        if (!bRet) {
            switch (id) {
                case FinalRadioCtrl.Radio_Btn_Freq1 /* 130078 */:
                case FinalRadioCtrl.Radio_Btn_Freq2 /* 130079 */:
                case FinalRadioCtrl.Radio_Btn_Freq3 /* 130080 */:
                case FinalRadioCtrl.Radio_Btn_Freq4 /* 130081 */:
                case FinalRadioCtrl.Radio_Btn_Freq5 /* 130082 */:
                case FinalRadioCtrl.Radio_Btn_Freq6 /* 130083 */:
                    saveChannel(id - FinalRadioCtrl.Radio_Btn_Freq1);
                    if (App_Radio.mLongClick_Time > 0) {
                        Main.PROXY.cmd(80);
                    }
                    break;
            }
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public boolean ResponseLongClick(View v) {
        int id = v.getId();
        ResponseLongClick(id);
        return false;
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateListRadio() {
        Main.postRunnable_Ui(true, this.mRunnableUpdateListRadio);
    }

    public void setPageDayOrNight(JPage page, int value) {
        JText txtFreq1 = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Freq1 + this.i);
        JText txtName1 = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Name1 + this.i);
        JText txtMiniFreq1 = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_MinFreq1 + this.i);
        if (App_Radio.mStrCustomer.equals("YL_3")) {
            if (txtFreq1 != null) {
                int[] iArr = new int[2];
                iArr[0] = value > 0 ? -1 : -16777216;
                iArr[1] = value > 0 ? -1 : -16777216;
                txtFreq1.setColor(iArr);
            }
            if (txtName1 != null) {
                int[] iArr2 = new int[2];
                iArr2[0] = value > 0 ? -1 : Color.parseColor("#74777e");
                iArr2[1] = value > 0 ? -1 : Color.parseColor("#74777e");
                txtName1.setColor(iArr2);
            }
            if (txtMiniFreq1 != null) {
                int[] iArr3 = new int[2];
                iArr3[0] = value > 0 ? -1 : -16777216;
                iArr3[1] = value > 0 ? -1 : -16777216;
                txtMiniFreq1.setColor(iArr3);
            }
            if (txtFreq1 != null) {
                txtFreq1.setTextColor(App_Radio.mNightDay > 0 ? -1 : -16777216);
            }
            if (txtName1 != null) {
                txtName1.setTextColor(App_Radio.mNightDay > 0 ? -1 : Color.parseColor("#74777e"));
            }
            if (txtMiniFreq1 != null) {
                txtMiniFreq1.setTextColor(App_Radio.mNightDay <= 0 ? -16777216 : -1);
            }
            JButton Radio_Btn_Freq1 = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq1 + this.i);
            Radio_Btn_Freq1.setStrDrawable(value > 0 ? "night_radio_freq" : "radio_freq", true);
            return;
        }
        if (txtFreq1 != null) {
            if (App_Radio.mNightDay > 0) {
                txtFreq1.setColor(Color.parseColor("#8c939a"), -1);
                if (txtFreq1.focus) {
                    txtFreq1.setTextColor(-1);
                }
            } else {
                txtFreq1.setColor(Color.parseColor("#8c939a"), ViewCompat.MEASURED_STATE_MASK);
                if (txtFreq1.focus) {
                    txtFreq1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                }
            }
        }
        if (txtName1 != null) {
            if (App_Radio.mNightDay > 0) {
                txtName1.setColor(Color.parseColor("#8c939a"), -1);
                if (txtName1.focus) {
                    txtName1.setTextColor(-1);
                    return;
                }
                return;
            }
            txtName1.setColor(Color.parseColor("#8c939a"), ViewCompat.MEASURED_STATE_MASK);
            if (txtName1.focus) {
                txtName1.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
    }

    public void show_FreqNight() {
        if (App_Radio.mStrCustomer.equals("YL_3") && this.mFreqView_night != null) {
            this.mFreqView.setVisibility(this.isNight ? 8 : 0);
            this.mFreqView_night.setVisibility(this.isNight ? 0 : 8);
        }
    }

    public void setDayOrNight(int value) {
        Log.d("gdy10", " 0000 Page radio 6025 setDayOrNight value = " + value + " bUI_NightColour = " + App_Radio.bUI_NightColour);
        if (App_Radio.bUI_NightColour) {
            this.isNight = value > 0;
            App_Radio.mNightDay = value;
            String str = value > 0 ? "night_" : FinalChip.BSP_PLATFORM_Null;
            getPage().setBackground(getPage().getDrawableFromPath(String.valueOf(str) + "bk_radio", getPage().mDrawables, getPage().mDrawables));
            for (Page_Menu pageMenu : this.actRadio.mListPageMenus) {
                pageMenu.setDayOrNight(value);
            }
            IPageNotify pageNotify = this.actRadio.getSettingInfo();
            if (pageNotify instanceof Page_SettingInfo) {
                ((Page_SettingInfo) pageNotify).setDayOrNight(value);
            }
            IPageNotify pageNotify1 = this.actRadio.getPageInfo();
            if (pageNotify1 instanceof Page_Info) {
                ((Page_Info) pageNotify1).setDayOrNight(value);
            }
            show_FreqNight();
            Log.d("gdy10", " 00 setPageDayOrNight ");
            this.i = 0;
            while (this.i < 6) {
                setPageDayOrNight(this.mPageAm1, value);
                setPageDayOrNight(this.mPageAm2, value);
                setPageDayOrNight(this.mPageFm1, value);
                setPageDayOrNight(this.mPageFm2, value);
                setPageDayOrNight(this.mPageFm3, value);
                this.i++;
            }
            Log.d("gdy10", " 01 setPageDayOrNight ");
            for (int i = 0; i < this.nightBtn.length; i++) {
                JButton button = (JButton) getPage().getChildViewByid(this.nightBtn[i]);
                if (button != null) {
                    String drawableName = button.getStrDrawable();
                    Log.d("gdy10", " 0001 Page radio 6025 for drawableName = " + drawableName + " str = " + str);
                    if (drawableName != null) {
                        if (TextUtils.isEmpty(str)) {
                            if (drawableName.startsWith("night_")) {
                                button.setStrDrawable(drawableName.replace("night_", FinalChip.BSP_PLATFORM_Null), true);
                            }
                        } else if (!drawableName.startsWith("night_")) {
                            button.setStrDrawable("night_" + drawableName, true);
                        }
                    }
                }
            }
            for (int k = 0; k < this.nightText.length; k++) {
                JText text = (JText) getPage().getChildViewByid(this.nightText[k]);
                if (text != null) {
                    text.setTextColor(value > 0 ? -1 : ViewCompat.MEASURED_STATE_MASK);
                }
            }
            for (int j = 0; j < this.nightView.length; j++) {
                JView view = (JView) getPage().getChildViewByid(this.nightView[j]);
                if (view != null) {
                    String drawableName2 = view.getStrDrawable();
                    if (TextUtils.isEmpty(str)) {
                        if (drawableName2.startsWith("night_")) {
                            view.setStrDrawable(drawableName2.replace("night_", FinalChip.BSP_PLATFORM_Null), true);
                        }
                    } else if (!drawableName2.startsWith("night_")) {
                        view.setStrDrawable("night_" + drawableName2, true);
                    }
                }
            }
            Log.d("gdy10", " 03 setPageDayOrNight ");
            if (this.mTxtFreqShow != null) {
                this.mTxtFreqShow.setTextColor(value > 0 ? -1 : Color.parseColor("#3c3c47"));
            }
        }
    }

    private ColorStateList createColorStateList(int pressed, int normal) {
        int[][] states = {new int[]{R.attr.state_pressed}, new int[0]};
        int[] colors = {pressed, normal};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    private ColorStateList createColorStateList(int pressed, int normal, int focused) {
        int[][] states = {new int[]{R.attr.state_pressed}, new int[0], new int[]{R.attr.state_focused}};
        int[] colors = {pressed, normal, focused};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    private ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = {pressed, focused, normal, focused, unable, normal};
        int[][] states = {new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    public void updateAllChannel(boolean bUpdateFreqAndName) {
        updateAllChannel(getPage(), bUpdateFreqAndName);
        updateAllChannel(this.mPageAm1, bUpdateFreqAndName);
        updateAllChannel(this.mPageAm2, bUpdateFreqAndName);
        updateAllChannel(this.mPageFm1, bUpdateFreqAndName);
        updateAllChannel(this.mPageFm2, bUpdateFreqAndName);
        updateAllChannel(this.mPageFm3, bUpdateFreqAndName);
        App_Radio.getInstance().sendRadioInfo2Mcu();
        Log.d("gdy2", "  updateAllChannel to refreshColName ");
        refreshColName();
    }

    private Bitmap outputCircleLittle(Bitmap bitmap, int data) {
        if (bitmap == null) {
            return null;
        }
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        localCanvas.drawRoundRect(rectF, data, data, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(bitmap, rect, rect, paint);
        return localBitmap;
    }

    /* JADX WARN: Code duplicated, block: B:137:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:50:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x0175  */
    public void updateAllChannel(JPage page, boolean bUpdateFreqAndName) {
        String strHead;
        String strTail;
        int num;
        String strHighLightFreq;
        if (page != null) {
            int band = FmUtils.mBand;
            switch (page.getId()) {
                case FinalRadioCtrl.Page_FM1 /* 130004 */:
                    band = 1;
                    break;
                case FinalRadioCtrl.Page_FM2 /* 130005 */:
                    band = 2;
                    break;
                case FinalRadioCtrl.Page_FM3 /* 130006 */:
                    band = 3;
                    break;
                case FinalRadioCtrl.Page_AM1 /* 130007 */:
                    band = 4;
                    break;
                case FinalRadioCtrl.Page_AM2 /* 130008 */:
                    band = 5;
                    break;
            }
            int start = (band - 1) * 6;
            if (App_Radio.getInstance().mListRadio.size() >= start + 6) {
                int i = 0;
                while (i < 6) {
                    JButton btn = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq1 + i);
                    JView view = (JView) page.getChildViewByid(FinalRadioCtrl.Radio_Ico_Line1 + i);
                    JText txtNum = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_No1 + i);
                    boolean bHighLight = FmUtils.mIndexRadio[band + (-1)] == i;
                    SparseArray<String> map = App_Radio.getInstance().mListRadio.get(start + i);
                    String strFreq = map.get(FinalRadioCtrl.RadioItem6025_Freq);
                    ImageView imgView = (ImageView) page.getChildViewByid(FinalRadioCtrl.Radio_BK1 + i);
                    if (imgView != null) {
                        Log.d("gdy5", " 00 RunnableSetBk strFreq = " + strFreq);
                        MyApplication.startThread(MyApplication.mStrZipTag, "db-operation-freqbk", new RunnableSetBk(strFreq, imgView), false, 1);
                    }
                    if (bHighLight) {
                        if (band <= 3) {
                            strHighLightFreq = String.format(Locale.US, "%.02f", Float.valueOf(FmUtils.trans2Freq(FmUtils.mCurStation)));
                        } else {
                            strHighLightFreq = String.format(Locale.US, "%d", Integer.valueOf((int) FmUtils.trans2Freq(FmUtils.mCurStation)));
                        }
                        if (!strHighLightFreq.equals(strFreq)) {
                            bHighLight = false;
                        }
                    }
                    if (txtNum != null) {
                        if (band <= 3) {
                            num = ((band - 1) * 6) + i + 1;
                        } else {
                            num = ((band - 4) * 6) + i + 1;
                        }
                        if (App_Radio.mTypeRadio_No == 1) {
                            txtNum.setText(num + ".");
                        } else if (App_Radio.mTypeRadio_No == 2) {
                            txtNum.setText(num + "/");
                        } else {
                            txtNum.setText(new StringBuilder().append(num).toString());
                        }
                    }
                    if (btn != null) {
                        if (btn.bPartnerDependent) {
                            btn.setPartnerFocus(bHighLight);
                        } else {
                            btn.setFocus(bHighLight);
                            if (view != null) {
                                if (bHighLight) {
                                    view.setVisibility(0);
                                } else {
                                    view.setVisibility(4);
                                }
                            }
                        }
                        Object obj = btn.getTag();
                        if (obj instanceof MyUiItem) {
                            boolean bZoom = false;
                            float fRatio = 1.18f;
                            MyUiItem item = (MyUiItem) obj;
                            String[] strs = item.getParaStr();
                            if (strs != null && strs.length > 0) {
                                for (String str : strs) {
                                    if (str.contains("zoom=")) {
                                        bZoom = true;
                                        try {
                                            fRatio = Float.parseFloat(str.substring("zoom=".length()));
                                        } catch (Exception e) {
                                        }
                                        if (bZoom) {
                                            if (bHighLight) {
                                                this.actRadio.Zoom(btn, fRatio);
                                            } else {
                                                this.actRadio.reStoreScale(btn);
                                            }
                                        }
                                    }
                                }
                                if (bZoom) {
                                    if (bHighLight) {
                                        this.actRadio.Zoom(btn, fRatio);
                                    } else {
                                        this.actRadio.reStoreScale(btn);
                                    }
                                }
                            }
                        }
                    }
                    ImageView imgLogo = (ImageView) page.getChildViewByid(FinalRadioCtrl.Radio_Logo1 + i);
                    if (imgLogo != null) {
                        if (App_Radio.bFmOnline) {
                            File File_FmbdLogo = new File(App_Radio.FmbdPath, String.valueOf(App_Radio.getFmbdId(strFreq)) + ".bmp");
                            if (File_FmbdLogo.exists()) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inSampleSize = 1;
                                options.inJustDecodeBounds = false;
                                Uri uri = Uri.fromFile(File_FmbdLogo);
                                try {
                                    Bitmap bitmap = BitmapFactory.decodeStream(MyApplication.myApp.getContentResolver().openInputStream(uri), null, options);
                                    if (bitmap != null) {
                                        imgLogo.setImageBitmap(outputCircleLittle(bitmap, 14));
                                    } else {
                                        imgLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                                    }
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                            } else {
                                imgLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                            }
                        } else if (App_Radio.bFmLogoByPng) {
                            File File_FmLogo = new File(App_Radio.FmLogoPath, String.valueOf(App_Radio.getFmLogoLogo(strFreq)) + ".png");
                            if (File_FmLogo.exists()) {
                                BitmapFactory.Options options2 = new BitmapFactory.Options();
                                options2.inSampleSize = 1;
                                options2.inJustDecodeBounds = false;
                                Uri uri2 = Uri.fromFile(File_FmLogo);
                                try {
                                    Bitmap bitmap2 = BitmapFactory.decodeStream(MyApplication.myApp.getContentResolver().openInputStream(uri2), null, options2);
                                    if (bitmap2 != null) {
                                        imgLogo.setImageBitmap(outputCircleLittle(bitmap2, 14));
                                    } else {
                                        imgLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                                    }
                                } catch (FileNotFoundException e3) {
                                    e3.printStackTrace();
                                }
                            } else {
                                String strDrawable = App_Radio.getInstance().mRadioInfoManager.queryLogo(strFreq);
                                Drawable drawable = getPage().getDrawableFromPath(strDrawable, getPage().mDrawables, getPage().mDrawables);
                                if (drawable != null) {
                                    BitmapDrawable bd = (BitmapDrawable) drawable;
                                    Bitmap bitmap3 = bd.getBitmap();
                                    if (bitmap3 != null) {
                                        imgLogo.setImageBitmap(outputCircle(bitmap3));
                                    }
                                } else {
                                    imgLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                                }
                            }
                        } else {
                            String strDrawable2 = App_Radio.getInstance().mRadioInfoManager.queryLogo(strFreq);
                            Drawable drawable2 = getPage().getDrawableFromPath(strDrawable2, getPage().mDrawables, getPage().mDrawables);
                            if (drawable2 != null) {
                                BitmapDrawable bd2 = (BitmapDrawable) drawable2;
                                Bitmap bitmap4 = bd2.getBitmap();
                                if (bitmap4 != null) {
                                    imgLogo.setImageBitmap(outputCircle(bitmap4));
                                }
                            } else {
                                imgLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                            }
                        }
                    }
                    if (bUpdateFreqAndName) {
                        Log.d("gdy3", " 11 bUpdateFreqAndName setColor ");
                        JText txtFreq = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Freq1 + i);
                        JText txtMinFreq = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_MinFreq1 + i);
                        JText txtName = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Name1 + i);
                        if (App_Radio.bUI_NightColour && !App_Radio.mStrCustomer.equals("YL_3")) {
                            if (txtFreq != null) {
                                if (App_Radio.mNightDay > 0) {
                                    txtFreq.setColor(Color.parseColor("#8c939a"), -1);
                                } else {
                                    txtFreq.setColor(Color.parseColor("#8c939a"), ViewCompat.MEASURED_STATE_MASK);
                                }
                            }
                            if (txtName != null) {
                                if (App_Radio.mNightDay > 0) {
                                    txtName.setColor(Color.parseColor("#8c939a"), -1);
                                } else {
                                    txtName.setColor(Color.parseColor("#8c939a"), ViewCompat.MEASURED_STATE_MASK);
                                }
                            }
                        }
                        if (txtFreq != null) {
                            if (band <= 3) {
                                strHead = "FM ";
                                strTail = " MHz";
                            } else {
                                strHead = "AM ";
                                strTail = " kHz";
                            }
                            if (App_Radio.bChannelFreqAddHeadTail) {
                                txtFreq.setText(String.valueOf(strHead) + strFreq + strTail);
                            } else if (App_Radio.bChannelFreqAddTail) {
                                txtFreq.setText(String.valueOf(strFreq) + strTail);
                            } else if (App_Radio.bChannelFreqAddHead) {
                                txtFreq.setText(String.valueOf(strHead) + strFreq);
                            } else {
                                txtFreq.setText(strFreq);
                            }
                        }
                        String strName = App_Radio.getInstance().mRadioInfoManager.queryFreq(strFreq);
                        if (band <= 3) {
                            Bundle inparam = new Bundle();
                            int iFreq = (int) (100.0f * Float.parseFloat(strFreq));
                            inparam.putInt("freq", iFreq);
                            Bundle outparam = new Bundle();
                            int ret = App_Radio.test_fmsyu_jni(32, inparam, outparam);
                            if (ret == 0 && FmService.getRdsOnOff() == 1) {
                                try {
                                    String str_PsName = new String(outparam.getByteArray("FreqPSname"), "ascii");
                                    if (str_PsName != null && !str_PsName.equals(FinalChip.BSP_PLATFORM_Null) && (str_PsName.length() != 9 || str_PsName.charAt(3) != 0 || str_PsName.charAt(5) != 0 || str_PsName.charAt(7) != 0)) {
                                        strName = str_PsName;
                                    }
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        if (App_Radio.bFmOnline) {
                            strName = App_Radio.getFmbdName(strFreq);
                        }
                        if (strName != null && !strName.equals(FinalChip.BSP_PLATFORM_Null)) {
                            if (txtName != null) {
                                txtName.setText(strName);
                                if (txtFreq.getVisibility() != 4) {
                                    txtFreq.setVisibility(4);
                                    if (txtMinFreq != null) {
                                        txtMinFreq.setVisibility(0);
                                    }
                                    txtName.setVisibility(0);
                                }
                            }
                            if (txtMinFreq != null) {
                                txtMinFreq.setText(txtFreq.getText().toString());
                                if (txtFreq.getVisibility() != 4) {
                                    txtFreq.setVisibility(4);
                                    txtMinFreq.setVisibility(0);
                                    txtName.setVisibility(0);
                                }
                            }
                        } else {
                            if (txtName != null) {
                                txtName.setText(FinalChip.BSP_PLATFORM_Null);
                                if (txtFreq.getVisibility() != 0) {
                                    txtFreq.setVisibility(0);
                                    if (txtMinFreq != null) {
                                        txtMinFreq.setVisibility(4);
                                    }
                                    txtName.setVisibility(4);
                                }
                            }
                            if (txtMinFreq != null && txtFreq.getVisibility() != 0) {
                                txtFreq.setVisibility(0);
                                txtMinFreq.setVisibility(4);
                                txtName.setVisibility(4);
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    public void Show_FreqNameAll() {
        if (this.mTxtCurrentFreqNameAll != null) {
            Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.18
                @Override // java.lang.Runnable
                public void run() {
                    String strName = App_Radio.getInstance().mRadioInfoManager.queryFreq(Page_Radio_6025.this.strFreq_run);
                    if (App_Radio.bFmOnline) {
                        strName = App_Radio.getFmbdName(Page_Radio_6025.this.strFreq_run);
                    }
                    if (strName == FinalChip.BSP_PLATFORM_Null) {
                        if (Page_Radio_6025.this.getString("radio_freq_name_default").equals("radio_freq_name_default")) {
                            Page_Radio_6025.this.mTxtCurrentFreqNameAll.setText(FinalChip.BSP_PLATFORM_Null);
                        } else {
                            Page_Radio_6025.this.mTxtCurrentFreqNameAll.setText(Page_Radio_6025.this.getString("radio_freq_name_default"));
                        }
                    } else {
                        Page_Radio_6025.this.mTxtCurrentFreqNameAll.setText(strName);
                    }
                    if (Page_Radio_6025.this.mTxtCurrentCity != null) {
                        Page_Radio_6025.this.mTxtCurrentCity.setText(App_Radio.getFmbdCity(Page_Radio_6025.this.strFreq_run));
                    }
                }
            }, 50L);
        }
        Log.d("gdyy", " 00 Show_FreqNameAll ");
        if (this.mViewRadioLogo != null) {
            try {
                if (App_Radio.bFmOnline) {
                    File File_FmbdLogo = new File(App_Radio.FmbdPath, String.valueOf(App_Radio.getFmbdId(this.strFreq_run)) + ".bmp");
                    if (File_FmbdLogo.exists()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 1;
                        options.inJustDecodeBounds = false;
                        Uri uri = Uri.fromFile(File_FmbdLogo);
                        try {
                            Bitmap bitmap = BitmapFactory.decodeStream(MyApplication.myApp.getContentResolver().openInputStream(uri), null, options);
                            if (bitmap != null) {
                                this.mViewRadioLogo.setImageBitmap(outputCircleLittle(bitmap, 14));
                            } else {
                                this.mViewRadioLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.mViewRadioLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                    }
                } else {
                    Log.d("gdyy", " 01 Show_FreqNameAll ");
                    String strDrawable = App_Radio.getInstance().mRadioInfoManager.queryLogo(this.strFreq_run);
                    Drawable drawable = getPage().getDrawableFromPath(strDrawable, getPage().mDrawables, getPage().mDrawables);
                    Log.d("gdyy", " 01 strDrawable ");
                    Log.d("gdyy", " 02 Show_FreqNameAll ");
                    if (drawable != null) {
                        BitmapDrawable bd = (BitmapDrawable) drawable;
                        Bitmap bitmap2 = bd.getBitmap();
                        if (bitmap2 != null) {
                            this.mViewRadioLogo.setImageBitmap(outputCircle(bitmap2));
                        }
                    } else {
                        this.mViewRadioLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo", getPage().mDrawables, getPage().mDrawables));
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (this.mViewRadioCircleLogo != null) {
            try {
                if (App_Radio.bFmLogoByPng) {
                    Bitmap bitmap3 = null;
                    String LogoName = App_Radio.getFmLogoLogo(this.strFreq_run);
                    File File_FmLogo = new File(App_Radio.FmLogoPath, String.valueOf(LogoName) + ".png");
                    Log.d("gdy7", " mViewRadioCircleLogo strFreq_run = " + this.strFreq_run + " LogoName = " + LogoName);
                    if (File_FmLogo.exists()) {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = 1;
                        options2.inJustDecodeBounds = false;
                        Uri uri2 = Uri.fromFile(File_FmLogo);
                        bitmap3 = BitmapFactory.decodeStream(MyApplication.myApp.getContentResolver().openInputStream(uri2), null, options2);
                    }
                    if (bitmap3 != null) {
                        this.mViewRadioCircleLogo.setImageBitmap(outputCircle(bitmap3));
                        return;
                    }
                    String strDrawable2 = App_Radio.getInstance().mRadioInfoManager.queryLogo(this.strFreq_run);
                    Drawable drawable2 = getPage().getDrawableFromPath(strDrawable2, getPage().mDrawables, getPage().mDrawables);
                    if (drawable2 != null) {
                        BitmapDrawable bd2 = (BitmapDrawable) drawable2;
                        Bitmap bitmap4 = bd2.getBitmap();
                        if (bitmap4 != null) {
                            this.mViewRadioCircleLogo.setImageBitmap(outputCircle(bitmap4));
                            return;
                        }
                        return;
                    }
                    this.mViewRadioCircleLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo1", getPage().mDrawables, getPage().mDrawables));
                    return;
                }
                String strDrawable3 = App_Radio.getInstance().mRadioInfoManager.queryLogo(this.strFreq_run);
                Drawable drawable3 = getPage().getDrawableFromPath(strDrawable3, getPage().mDrawables, getPage().mDrawables);
                if (drawable3 != null) {
                    BitmapDrawable bd3 = (BitmapDrawable) drawable3;
                    Bitmap bitmap5 = bd3.getBitmap();
                    if (bitmap5 != null) {
                        this.mViewRadioCircleLogo.setImageBitmap(outputCircle(bitmap5));
                        return;
                    }
                    return;
                }
                this.mViewRadioCircleLogo.setImageDrawable(getPage().getDrawableFromPath("radio_logo1", getPage().mDrawables, getPage().mDrawables));
            } catch (Exception e3) {
            }
        }
    }

    public static void saveBmpToPng(Bitmap bmp, File f) {
        try {
            FileOutputStream out = new FileOutputStream(f);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
        }
    }

    private Bitmap outputCircle(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        Log.d("circle", "  30, 30 bitmap.getWidth() = " + bitmap.getWidth());
        int r = bitmap.getWidth() / 2;
        localCanvas.drawRoundRect(rectF, r, r, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(bitmap, rect, rect, paint);
        return localBitmap;
    }

    public void saveCurrentChannel(int band, int pos) {
        String strFreqCurrent;
        FmNative.getInstance().test_stopScan();
        this.actRadio.stopScan();
        int index = ((band - 1) * 6) + pos;
        List<SparseArray<String>> listRadio = App_Radio.getInstance().mListRadio;
        if (listRadio.size() > index) {
            SparseArray<String> map = listRadio.get(index);
            int station = FmUtils.mCurStation;
            float freq = FmUtils.trans2Freq(station);
            if (band <= 3) {
                strFreqCurrent = String.format(Locale.US, "%.02f", Float.valueOf(freq));
            } else {
                strFreqCurrent = String.format(Locale.US, "%d", Integer.valueOf((int) freq));
            }
            String strFreqOld = map.get(FinalRadioCtrl.RadioItem6025_Freq);
            if (!strFreqCurrent.equals(strFreqOld)) {
                map.put(FinalRadioCtrl.RadioItem6025_Freq, strFreqCurrent);
                updateListRadio();
            }
            FmStation.updateStationToDb(index, FmUtils.mCurStation);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void jump1stChannel_AtSoon() {
        int index;
        SparseArray<String> map;
        List<SparseArray<String>> listRadio = App_Radio.getInstance().mListRadio;
        if (FmUtils.mBand <= 3) {
            FmUtils.mBand = 1;
        } else {
            FmUtils.mBand = 4;
        }
        FmStation.saveCurrentBand();
        setPara(FmUtils.mBand);
        FmUtils.mIndexRadio[FmUtils.mBand - 1] = 0;
        FmStation.setCurrentIndexRadio(FmUtils.mBand, 0);
        updateListRadio();
        updateChannelTxt();
        if (listRadio != null && listRadio.size() > (index = (FmUtils.mBand - 1) * 6) && (map = listRadio.get(index)) != null) {
            float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
            App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
        }
    }

    public void playCurChannel() {
        int index = ((FmUtils.mBand - 1) * 6) + FmUtils.mIndexRadio[FmUtils.mBand - 1];
        if (App_Radio.getInstance().mListRadio.size() > index) {
            SparseArray<String> map = App_Radio.getInstance().mListRadio.get(index);
            float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
            App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void jump1stChannel() {
        Main.postRunnable_Ui(true, this.mRunnableJump1stChannel, 300L);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void showLoading() {
        FmUtils.mSearch = true;
        if (!App_Radio.bIsRadioArmExt) {
            if (this.mTxtScanning != null) {
                this.mTxtScanning.setVisibility(0);
            }
            if (this.mFreqView != null) {
                this.mFreqView.setVisibility(8);
            }
            if (this.mFreqView_night != null) {
                this.mFreqView_night.setVisibility(8);
            }
            if (this.mTxtFreqShow != null) {
                this.mTxtFreqShow.setVisibility(8);
            }
        }
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void disLoading() {
        FmUtils.mSearch = false;
        if (this.mTxtScanning != null) {
            this.mTxtScanning.setVisibility(8);
        }
        if (this.mFreqView != null) {
            this.mFreqView.setVisibility(0);
        }
        show_FreqNight();
        if (this.mTxtFreqShow != null) {
            this.mTxtFreqShow.setVisibility(0);
        }
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    public void updateMenuFocus() {
        if (this.mViewPager != null) {
            int item = this.mViewPager.getCurrentItem();
            JView viewFocus1 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Menu1Focus);
            JView viewFocus2 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Menu2Focus);
            switch (item) {
                case 1:
                    if (viewFocus1 != null) {
                        viewFocus1.setFocus(true);
                    }
                    if (viewFocus2 != null) {
                        viewFocus2.setFocus(false);
                    }
                    break;
                case 2:
                    if (viewFocus1 != null) {
                        viewFocus1.setFocus(false);
                    }
                    if (viewFocus2 != null) {
                        viewFocus2.setFocus(true);
                    }
                    break;
            }
        }
    }

    public void setRadioBk(String strDrawable) {
        if (this.mImgViewRadioBk != null) {
            this.mImgViewRadioBk.setBackground(getPage().getDrawableFromPath(strDrawable, null, null));
        }
    }

    public boolean isViewPagerFmAm(ViewPager viewPager) {
        return viewPager != null && viewPager == mViewPagerFMAM;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void viewPagePrev(ViewPager viewPager) {
        switch (App_Radio.mColoerType) {
            case 0:
                setRadioBk("pink_radio_bk_right");
                break;
            case 1:
                setRadioBk("red_radio_bk_right");
                break;
            default:
                setRadioBk("radio_bk_right");
                break;
        }
        hideRuler();
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void viewPageNext(ViewPager viewPager) {
        switch (App_Radio.mColoerType) {
            case 0:
                setRadioBk("pink_radio_bk_left");
                break;
            case 1:
                setRadioBk("red_radio_bk_left");
                break;
            default:
                setRadioBk("radio_bk_left");
                break;
        }
        hideRuler();
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void viewPageScrolled(ViewPager viewPager) {
        Log.d("freqq", " 00 Radio6025 viewPageScrolled  mBand = " + FmUtils.mBand);
        switch (App_Radio.mColoerType) {
            case 0:
                setRadioBk("pink_radio_bk");
                break;
            case 1:
                setRadioBk("red_radio_bk");
                break;
            default:
                setRadioBk("radio_bk");
                break;
        }
        if (viewPager == this.mViewPager) {
            updateMenuFocus();
            return;
        }
        if (isViewPagerFmAm(viewPager)) {
            Log.d("freqq", " 01 Radio6025 viewPageScrolled  bSwitchBandWhenScroll = " + App_Radio.bSwitchBandWhenScroll);
            if (App_Radio.bSwitchBandWhenScroll) {
                int band = this.actRadio.getFixBand(mViewPagerFMAM, false);
                Log.d("freqq", " 02 Radio6025 viewPageScrolled  mBand = " + FmUtils.mBand + " band = " + band);
                switchBand(band, true);
                return;
            }
            updateBandFocus(false);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void initPara() {
        App_Radio.getInstance().checkRadioType();
        setPara(FmUtils.mBand);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateHalfScreenVisble() {
        if (App_Radio.getInstance().bEnableHalfScreen && this.mViewHalfScreen != null) {
            if (App_Radio.getInstance().isHalfScreenAble()) {
                this.mViewHalfScreen.setVisibility(0);
                this.actRadio.startCheckHalfScreenVisible();
            } else {
                this.mViewHalfScreen.setVisibility(8);
                this.actRadio.stopCheckHalfScreenVisible();
            }
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void showHideScan() {
        if (this.mViewScan != null) {
            if (this.mViewScan.focus) {
                this.mViewScan.setFocus(false);
            } else {
                this.mViewScan.setFocus(true);
            }
        }
        if (this.mTextScan != null) {
            if ("SCAN".equals(this.mTextScan.getText())) {
                this.mTextScan.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                this.mTextScan.setText("SCAN");
            }
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) throws Throwable {
        switch (updateCode) {
            case 28:
                if (IpcUtil.intsOk(ints, 1)) {
                    switch (ints[0]) {
                        case 0:
                            if (FmUtils.mIndexRadio[FmUtils.mBand - 1] < 5) {
                                int[] iArr = FmUtils.mIndexRadio;
                                int i = FmUtils.mBand - 1;
                                iArr[i] = iArr[i] + 1;
                            } else {
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
                                FmUtils.mIndexRadio[FmUtils.mBand - 1] = 0;
                                updateListRadio();
                            }
                            FmStation.setCurrentIndexRadio(FmUtils.mBand, FmUtils.mIndexRadio[FmUtils.mBand - 1]);
                            updateChannelTxt();
                            int indexStart = (FmUtils.mBand - 1) * 6;
                            List<SparseArray<String>> listRadio = App_Radio.getInstance().mListRadio;
                            if (listRadio != null && listRadio.size() > FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart) {
                                SparseArray<String> map = listRadio.get(FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart);
                                float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
                                App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
                                break;
                            }
                            break;
                        case 1:
                            if (FmUtils.mIndexRadio[FmUtils.mBand - 1] > 0) {
                                int[] iArr2 = FmUtils.mIndexRadio;
                                int i2 = FmUtils.mBand - 1;
                                iArr2[i2] = iArr2[i2] - 1;
                            } else {
                                if (FmUtils.mBand <= 3) {
                                    if (FmUtils.mBand > 1) {
                                        FmUtils.mBand--;
                                    } else {
                                        FmUtils.mBand = 3;
                                    }
                                } else if (FmUtils.mBand <= 5) {
                                    if (FmUtils.mBand > 4) {
                                        FmUtils.mBand--;
                                    } else {
                                        FmUtils.mBand = 5;
                                    }
                                }
                                FmStation.saveCurrentBand();
                                FmUtils.mIndexRadio[FmUtils.mBand - 1] = 5;
                                updateListRadio();
                            }
                            FmStation.setCurrentIndexRadio(FmUtils.mBand, FmUtils.mIndexRadio[FmUtils.mBand - 1]);
                            updateChannelTxt();
                            int indexStart2 = (FmUtils.mBand - 1) * 6;
                            List<SparseArray<String>> listRadio2 = App_Radio.getInstance().mListRadio;
                            if (listRadio2 != null && listRadio2.size() > FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart2) {
                                SparseArray<String> map2 = listRadio2.get(FmUtils.mIndexRadio[FmUtils.mBand - 1] + indexStart2);
                                float freq2 = Float.parseFloat(map2.get(FinalRadioCtrl.RadioItem6025_Freq));
                                App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq2), true);
                                break;
                            }
                            break;
                        case 3:
                            if (bDelay_run) {
                                bDelay_run = false;
                                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.19
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Page_Radio_6025.bDelay_run = true;
                                    }
                                }, 100L);
                                ResponseClick(FinalRadioCtrl.Radio_Btn_FreqP);
                            }
                            break;
                        case 4:
                            if (bDelay_run) {
                                bDelay_run = false;
                                Main.postRunnable_Ui(false, new Runnable() { // from class: com.syu.radio.page.Page_Radio_6025.20
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Page_Radio_6025.bDelay_run = true;
                                    }
                                }, 100L);
                                ResponseClick(FinalRadioCtrl.Radio_Btn_FreqM);
                            }
                            break;
                        case 5:
                            FmNative.getInstance().test_stopScan();
                            if (App_Radio.mService.isSeeking()) {
                                this.actRadio.stopScan();
                            } else {
                                App_Radio.getInstance().seekUp();
                            }
                            break;
                        case 6:
                            FmNative.getInstance().test_stopScan();
                            if (App_Radio.mService.isSeeking()) {
                                this.actRadio.stopScan();
                            } else {
                                App_Radio.getInstance().seekDown();
                            }
                            break;
                        case 7:
                            if (IpcUtil.intsOk(ints, 2)) {
                                selectChannel(ints[1] - 1);
                            }
                            break;
                        case 8:
                            if (IpcUtil.intsOk(ints, 2)) {
                                saveChannel(ints[1] - 1);
                            }
                            break;
                        case 9:
                            ResponseClick(FinalRadioCtrl.Radio_Btn_Scan);
                            break;
                        case 10:
                            ResponseClick(FinalRadioCtrl.Radio_Btn_Save);
                            break;
                        case 11:
                            if (App_Radio.bFocus) {
                                ResponseClick(FinalRadioCtrl.Radio_Btn_Band);
                            }
                            break;
                        case 13:
                            if (IpcUtil.intsOk(ints, 2)) {
                                App_Radio.getInstance().setFreq(ints[1], true);
                            }
                            break;
                        case 16:
                            int iRdsEnable = FmService.getRdsOnOff();
                            if (iRdsEnable == 0) {
                                FmService.setRdsOnOff(1);
                            } else {
                                FmService.setRdsOnOff(0);
                            }
                            IPageNotify pageNotify = this.actRadio.getPageSet();
                            if (pageNotify instanceof Page_Set_6025) {
                                ((Page_Set_6025) pageNotify).updateFlagRds();
                            }
                            IPageNotify pageNotify1 = this.actRadio.getSettingInfo();
                            if (pageNotify1 instanceof Page_SettingInfo) {
                                ((Page_SettingInfo) pageNotify1).updateFlagRds();
                            }
                            this.actRadio.updateRdsInfo();
                            break;
                        case 17:
                            ResponseClick_Menu(FinalRadioCtrl.Radio_Btn_ST);
                            break;
                        case 18:
                            ResponseClick_Menu(FinalRadioCtrl.Radio_Btn_Loc);
                            break;
                        case 22:
                            ResponseLongClick(FinalRadioCtrl.Radio_Btn_Scan);
                            break;
                        case 27:
                            switchBand(1, true);
                            break;
                        case 28:
                            switchBand(2, true);
                            break;
                        case 29:
                            switchBand(3, true);
                            break;
                        case 30:
                            if (App_Radio.isSupportAm()) {
                                switchBand(4, true);
                            }
                            break;
                        case 31:
                            if (App_Radio.isSupportAm()) {
                                switchBand(5, true);
                            }
                            break;
                    }
                }
                break;
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void switchBand(boolean bNext, boolean bSwitchBandFromFm2Am, boolean bResetViewPagerItem) {
        int indexWillBe;
        if (App_Radio.iRadioType_Arm == 1) {
            bSwitchBandFromFm2Am = false;
        }
        this.actRadio.stopScan();
        saveCurrentChannel(FmUtils.mBand, FmUtils.mIndexRadio[FmUtils.mBand - 1]);
        if (FmUtils.mBand >= 4) {
            int indexWillBe2 = (FmUtils.mBand + 3) - 4;
            if (bNext) {
                indexWillBe = indexWillBe2 + 1;
            } else {
                indexWillBe = indexWillBe2 - 1;
            }
            if (!bSwitchBandFromFm2Am) {
                if (indexWillBe < 3) {
                    indexWillBe = 4;
                } else if (indexWillBe > 4) {
                    indexWillBe = 3;
                }
            } else if (indexWillBe > 4) {
                indexWillBe = 0;
            }
        } else {
            int indexWillBe3 = FmUtils.mBand - 1;
            if (bNext) {
                indexWillBe = indexWillBe3 + 1;
            } else {
                indexWillBe = indexWillBe3 - 1;
            }
            if (!bSwitchBandFromFm2Am) {
                if (indexWillBe < 0) {
                    indexWillBe = 2;
                } else if (indexWillBe > 2) {
                    indexWillBe = 0;
                }
            } else if (indexWillBe < 0) {
                indexWillBe = 4;
            }
        }
        if (!App_Radio.isSupportAm()) {
            if (indexWillBe > 2) {
                indexWillBe = 0;
            } else if (indexWillBe < 0) {
                indexWillBe = 2;
            }
        }
        switch (indexWillBe) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                switchBand(indexWillBe + 1, bResetViewPagerItem);
                break;
        }
    }

    public void switchBand(int iBand, boolean bResetViewPagerItem) {
        Log.d("freqq", " 11 Radio6025 switchBand iBand = " + iBand + " mBand = " + FmUtils.mBand);
        if (FmUtils.mBand != iBand) {
            boolean bFmBak = FmUtils.mBand <= 3;
            boolean bIsOirtFMBand1Bak = FmService.isAreaOirtFMBand1(FmUtils.mBand);
            FmUtils.mBand = iBand;
            FmStation.saveCurrentBand();
            boolean bFmCur = FmUtils.mBand <= 3;
            boolean bIsOirtFMBand1Cur = FmService.isAreaOirtFMBand1(FmUtils.mBand);
            if (bFmCur != bFmBak || bIsOirtFMBand1Cur != bIsOirtFMBand1Bak) {
                setPara(FmUtils.mBand);
                if (bFmCur) {
                    if (Radio_IpcObj.mTextHZ != "MHz") {
                        Radio_IpcObj.mTextHZ = "MHz";
                        this.actRadio.initlist(false, false, true);
                    }
                } else if (Radio_IpcObj.mTextHZ != "kHz") {
                    Radio_IpcObj.mTextHZ = "kHz";
                    this.actRadio.initlist(false, false, true);
                }
            }
            Log.d("freqq", " 22 Radio6025 switchBand iBand = " + iBand + " mBand = " + FmUtils.mBand);
            updateChannelTxt();
            updateListRadio();
            playCurChannel();
            updateBandFocus(bResetViewPagerItem);
            updateLoc();
            updataTA();
            updataAF();
            updateRdsInfo();
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateBandFocus(boolean bResetViewPagerItem) {
        int bandFix = FmUtils.mBand;
        if (!bResetViewPagerItem) {
            bandFix = this.actRadio.getFixBand(mViewPagerFMAM, false);
        } else {
            Log.d("freq", " ** 11 mViewPagerFMAM.setCurrentItem item= " + this.actRadio.getFixItem(mViewPagerFMAM, bandFix, false));
            if (mViewPagerFMAM != null) {
                mViewPagerFMAM.setCurrentItem(this.actRadio.getFixItem(mViewPagerFMAM, bandFix, false));
            }
        }
        if (this.AM1 != null) {
            this.AM1.setFocus(bandFix == 4);
        }
        if (this.AM2 != null) {
            this.AM2.setFocus(bandFix == 5);
        }
        if (this.FM1 != null) {
            this.FM1.setFocus(bandFix == 1);
        }
        if (this.FM2 != null) {
            this.FM2.setFocus(bandFix == 2);
        }
        if (this.FM3 != null) {
            this.FM3.setFocus(bandFix == 3);
        }
        if (FmUtils.mBand >= 1 && FmUtils.mBand <= 3) {
            if (App_Radio.bSetFocus) {
                if (this.mBtnAM != null) {
                    this.mBtnAM.setFocus(false);
                }
                if (this.mBtnFM != null) {
                    this.mBtnFM.setFocus(true);
                }
            }
            if (this.mAMBLayout != null) {
                this.mAMBLayout.setVisibility(8);
            }
            if (this.mFMBLayout != null) {
                this.mFMBLayout.setVisibility(0);
            }
            if (this.mBtnBandAM != null) {
                this.mBtnBandAM.setVisibility(8);
            }
            if (this.mBtnBandFM != null) {
                this.mBtnBandFM.setVisibility(0);
            }
            if (this.mVIEW_FMSet != null) {
                this.mVIEW_FMSet.setVisibility(0);
            }
            if (!App_Radio.bSwitchBandFromFm2Am) {
                this.actRadio.setUiLoader(mViewPagerFMAM, false);
                return;
            }
            return;
        }
        if (FmUtils.mBand >= 4 && FmUtils.mBand <= 5) {
            if (App_Radio.bSetFocus) {
                if (this.mBtnAM != null) {
                    this.mBtnAM.setFocus(true);
                }
                if (this.mBtnFM != null) {
                    this.mBtnFM.setFocus(false);
                }
            }
            if (this.mAMBLayout != null) {
                this.mAMBLayout.setVisibility(0);
            }
            if (this.mFMBLayout != null) {
                this.mFMBLayout.setVisibility(8);
            }
            if (!App_Radio.bSwitchBandFromFm2Am) {
                this.actRadio.setUiLoader(mViewPagerFMAM, true);
            }
            if (this.mBtnBandAM != null) {
                this.mBtnBandAM.setVisibility(0);
            }
            if (this.mBtnBandFM != null) {
                this.mBtnBandFM.setVisibility(8);
            }
            if (this.mVIEW_FMSet != null) {
                this.mVIEW_FMSet.setVisibility(8);
            }
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void setBtnBk() {
        updateAllChannel(false);
    }

    public void hideRuler() {
        Main.removeRunnable_Ui(this.mRunnableHideRuler);
        if (this.mPageMenu != null && this.mRulerLayout != null && this.mRulerLayout.getVisibility() == 0) {
            this.mRulerLayout.setVisibility(8);
            this.mPageMenu.setVisibility(0);
        }
    }

    public void showRuler(boolean bHideDelay) {
        if (this.mPageMenu != null && this.mRulerLayout != null && this.mRulerLayout.getVisibility() == 8) {
            this.mPageMenu.setVisibility(8);
            this.mRulerLayout.setVisibility(0);
        }
        if (bHideDelay) {
            Main.postRunnable_Ui(true, this.mRunnableHideRuler, 3000L);
        }
    }

    public boolean scrollToPrev() {
        View v = this.actRadio.getFocus(getPage());
        if (v == null) {
            return false;
        }
        View vFocus = null;
        if (v.getId() != 130078) {
            return false;
        }
        if (mViewPagerFMAM != null && mViewPagerFMAM.mContents != null) {
            int item = mViewPagerFMAM.getCurrentItem();
            int len = mViewPagerFMAM.mContents.length;
            switch (len) {
                case 2:
                    switch (item) {
                        case 1:
                            item = 2;
                            vFocus = this.mPageAm2.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 2:
                            item = 1;
                            vFocus = this.mPageAm1.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                    }
                    mViewPagerFMAM.setCurrentItem(item);
                    updateBandFocus(false);
                    break;
                case 3:
                case 5:
                    switch (item) {
                        case 1:
                            item = 3;
                            vFocus = this.mPageFm3.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 2:
                            item = 1;
                            vFocus = this.mPageFm1.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 3:
                            item = 2;
                            vFocus = this.mPageFm2.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 4:
                            item = 5;
                            vFocus = this.mPageAm2.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 5:
                            item = 4;
                            vFocus = this.mPageAm1.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                    }
                    mViewPagerFMAM.setCurrentItem(item);
                    updateBandFocus(false);
                    break;
            }
        }
        if (vFocus == null) {
            return false;
        }
        vFocus.requestFocusFromTouch();
        return true;
    }

    public boolean scrollToNext() {
        View v = this.actRadio.getFocus(getPage());
        if (v == null) {
            return false;
        }
        View vFocus = null;
        if (v.getId() != 130083) {
            return false;
        }
        if (mViewPagerFMAM != null && mViewPagerFMAM.mContents != null) {
            int item = mViewPagerFMAM.getCurrentItem();
            int len = mViewPagerFMAM.mContents.length;
            switch (len) {
                case 2:
                    switch (item) {
                        case 1:
                            item = 2;
                            vFocus = this.mPageAm2.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 2:
                            item = 1;
                            vFocus = this.mPageAm1.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                    }
                    mViewPagerFMAM.setCurrentItem(item);
                    updateBandFocus(false);
                    break;
                case 3:
                case 5:
                    switch (item) {
                        case 1:
                            item = 2;
                            vFocus = this.mPageFm3.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 2:
                            item = 3;
                            vFocus = this.mPageFm1.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 3:
                            item = 1;
                            vFocus = this.mPageFm2.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 4:
                            item = 5;
                            vFocus = this.mPageAm2.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                        case 5:
                            item = 4;
                            vFocus = this.mPageAm1.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq6);
                            break;
                    }
                    mViewPagerFMAM.setCurrentItem(item);
                    updateBandFocus(false);
                    break;
            }
        }
        if (vFocus == null) {
            return false;
        }
        vFocus.requestFocusFromTouch();
        return true;
    }
}
