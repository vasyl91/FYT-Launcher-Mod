package com.syu.radio.page;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.android.fmradio.FmNative;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.frame.ctrl.JViewPager;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.data.FinalChip;
import com.pekall.fmradio.FMRadioService;
import com.syu.app.ipc.Radio_IpcObj;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_RadioPage;
import com.syu.radio.ctrl.JFreqBand;
import com.syu.radio.ctrl.JFreqLineRuler;
import com.syu.radio.ctrl.JFreqRoundRuler;
import com.syu.radio.ctrl.JFreqView;
import com.syu.radio.ctrl.JRulerView;
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.runnable.RunnableSetBk;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Radio_Sophia extends MyPage implements Interface_RadioPage {
    JButton AM1;
    JButton AM2;
    JButton FM1;
    JButton FM2;
    JButton FM3;
    Act_Radio actRadio;
    View mAMBLayout;
    JButton mBtnAM;
    JButton mBtnFM;
    int mClickCnt;
    View mFMBLayout;
    View mFm2AmGroup;
    JFreqBand mFreqBand;
    JFreqLineRuler mFreqLineRuler;
    JFreqRoundRuler mFreqRoundRuler;
    JFreqView mFreqView;
    ImageView mImgViewRadioBk;
    JFreqLineRuler mLineRuler;
    public View.OnTouchListener mOnTouchListenerRuler;
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
    JText mTxtCurrentFreqName;
    JText mTxtScanning;
    JText mTxtUnit;
    JText mTxtUnit1;
    JText mTxtUnit2;
    JText mTxtUnit3;
    JText mTxtUnit4;
    JText mTxtUnit5;
    JText mTxtUnit6;
    JView mViewAfOn;
    View mViewHalfScreen;
    JView mViewLoc;
    JViewPager mViewPager;
    JViewPager mViewPagerFMAM;
    JView mViewST;
    JView mViewScan;
    JView mViewTa;
    JView mViewTaOn;
    JView mViewTp;

    public Page_Radio_Sophia(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.mClickCnt = 0;
        this.mTaState = -255;
        this.mRunnableUpdateListRadio = new Runnable() { // from class: com.syu.radio.page.Page_Radio_Sophia.1
            @Override // java.lang.Runnable
            public void run() {
                String strFreq;
                Page_Radio_Sophia.this.updateAllChannel(true);
                int freq = FmUtils.mCurStation;
                if (freq > 5000) {
                    Radio_IpcObj.mFreq_for_db = freq;
                    strFreq = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
                } else {
                    Radio_IpcObj.mFreq_for_db = freq * 100;
                    strFreq = new StringBuilder().append(freq).toString();
                }
                App_Radio.getInstance().updateCurFreqName(Page_Radio_Sophia.this.mTxtCurrentFreqName, strFreq);
            }
        };
        this.mRunnableJump1stChannel = new Runnable() { // from class: com.syu.radio.page.Page_Radio_Sophia.2
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_Sophia.this.jump1stChannel_AtSoon();
            }
        };
        this.mRunnableHideRuler = new Runnable() { // from class: com.syu.radio.page.Page_Radio_Sophia.3
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio_Sophia.this.hideRuler();
            }
        };
        this.mOnTouchListenerRuler = new View.OnTouchListener() { // from class: com.syu.radio.page.Page_Radio_Sophia.4
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                    case 2:
                        Page_Radio_Sophia.this.showRuler(false);
                        return false;
                    case 1:
                    case 3:
                        Main.postRunnable_Ui(true, Page_Radio_Sophia.this.mRunnableHideRuler, 6000L);
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.actRadio = actRadio;
        actRadio.mInterfacePageRadio = this;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.actRadio.initlist(false, false, false);
        this.mPageAm1 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_AM1);
        this.mPageAm2 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_AM2);
        this.mPageFm1 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM1);
        this.mPageFm2 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM2);
        this.mPageFm3 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM3);
        this.mTxtCurrentFreqName = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_CurFreqName);
        this.mViewHalfScreen = getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_HalfScreen);
        this.mViewPager = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPage);
        this.mViewPagerFMAM = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPageFMAM);
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
        this.mRulerView = (JRulerView) getPage().getChildViewByid(FinalRadioCtrl.Radio_RulerView);
        this.mFMBLayout = getPage().getChildViewByid(FinalRadioCtrl.FMBand_Index);
        this.mAMBLayout = getPage().getChildViewByid(FinalRadioCtrl.AMBand_Index);
        this.AM1 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.AM_1);
        this.AM2 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.AM_2);
        this.FM1 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_1);
        this.FM2 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_2);
        this.FM3 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_3);
        this.mFm2AmGroup = getPage().getChildViewByid(FinalRadioCtrl.Radio_FM_AM_Group);
        if (this.mFm2AmGroup != null) {
            this.mFm2AmGroup.setVisibility(8);
        }
        this.mBtnFM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_FMBand);
        this.mBtnAM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_AMBand);
        this.mPageMenu = (JPage) getPage().getChildViewByid(FinalRadioCtrl.Page_Menu);
        this.mImgViewRadioBk = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_BK);
        this.mRulerLayout = getPage().getChildViewByid(FinalRadioCtrl.Radio_Ruler_Group);
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
            this.mRulerView.setOnValueChangeListener(new JRulerView.OnValueChangeListener() { // from class: com.syu.radio.page.Page_Radio_Sophia.5
                @Override // com.syu.radio.ctrl.JRulerView.OnValueChangeListener
                public void onValueChange(float value) {
                    App_Radio.getInstance().setFreq((int) value, true);
                }
            });
        }
        this.mFreqLineRuler = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
        this.mFreqRoundRuler = (JFreqRoundRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqRoundRuler);
        disLoading();
        initPara();
        updateBandFocus(true);
        if (!App_Radio.isSupportAm()) {
            this.actRadio.setUiLoader(this.mViewPagerFMAM, false);
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() throws Throwable {
        this.mClickCnt = 0;
        if (App_Radio.isTranslucent) {
            this.actRadio.myActivity.hideSystemUi();
        } else {
            this.actRadio.myActivity.showSystemUi();
        }
        setPara(FmUtils.mBand);
        App_Radio.mTypeRadio = 3;
        App_Radio.getInstance().saveSet();
        App_Radio.getInstance().mIpcObj.requestAppIdRight();
        if (this.actRadio.bNeedTuneCurrentStation) {
            this.actRadio.bNeedTuneCurrentStation = false;
            App_Radio.getInstance().setFreq(FmUtils.mCurStation, true);
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
        this.actRadio.stopCheckSt();
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
    public void showLoading() {
        FmUtils.mSearch = true;
        if (!App_Radio.isSupportDispSearchFreq()) {
            if (this.mTxtScanning != null) {
                this.mTxtScanning.setVisibility(0);
            }
            if (this.mFreqView != null) {
                this.mFreqView.setVisibility(8);
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
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    public void handleExtraFreqInfo(int iFreqCur, int iFreqMin, int iFreqMax, int iFreqStep) {
        RadioM.sFreqMin = iFreqMin;
        RadioM.sFreqMax = iFreqMax;
        if (this.mRulerView != null) {
            this.mRulerView.setup(iFreqCur, iFreqMin, iFreqMax, iFreqStep);
        }
        if (this.mFreqLineRuler != null) {
            this.mFreqLineRuler.setup(iFreqMin, iFreqMax, iFreqStep, (iFreqMax - iFreqMin) / iFreqStep);
        }
        if (this.mFreqRoundRuler != null) {
            this.mFreqRoundRuler.setup(iFreqMin, iFreqMax, iFreqStep, (iFreqMax - iFreqMin) / iFreqStep);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateCurrentFreq(int freq, boolean bCheckAdjust) {
        String strFreq;
        JPage page;
        JText text;
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
        if (this.mFreqView != null) {
            this.mFreqView.setCurrenFreq(strFreq);
        }
        JText title = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Title);
        if (title != null) {
            if (freq > 5000) {
                title.setText("FM    " + strFreq + "    MHz");
            } else {
                title.setText("AM    " + strFreq + "    KHz");
            }
        }
        JFreqRoundRuler freqRoundRuler2 = (JFreqRoundRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqRoundRuler);
        if (freqRoundRuler2 != null) {
            freqRoundRuler2.updateFreq(freq);
        }
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
        updateAllChannel(false);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void refreshStationUI() {
        updateCurrentFreq(FmUtils.mCurStation, true);
    }

    public void search() {
        switch (App_Radio.iRadioType_Arm) {
            case 1:
            case 2:
                FmNative.getInstance().test_stopScan();
                break;
        }
        this.actRadio.stopScan();
        if (App_Radio.mFmRadio_Sofia != null) {
            App_Radio.mFmRadio_Sofia.search(true);
        }
    }

    public void saveCurrentChannel(int band, int pos) {
        String strFreqCurrent;
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

    public void playCurChannel() {
        int index = ((FmUtils.mBand - 1) * 6) + FmUtils.mIndexRadio[FmUtils.mBand - 1];
        if (App_Radio.getInstance().mListRadio.size() > index) {
            SparseArray<String> map = App_Radio.getInstance().mListRadio.get(index);
            float freq = Float.parseFloat(map.get(FinalRadioCtrl.RadioItem6025_Freq));
            App_Radio.getInstance().setFreq(FmUtils.trans2KB(freq), true);
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
            App_Radio.getInstance().seekUp();
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
        showLoading();
        search();
    }

    @Override // com.syu.radio.Interface_RadioPage
    public boolean ResponseClick_Menu(int id) throws Throwable {
        switch (id) {
            case FinalRadioCtrl.Radio_Btn_FreqM /* 130099 */:
                Func_FreqAdujst(false, false);
                break;
            case FinalRadioCtrl.Radio_Btn_FreqP /* 130100 */:
                Func_FreqAdujst(true, false);
                break;
            case FinalRadioCtrl.Radio_Btn_Band /* 130105 */:
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
            case FinalRadioCtrl.Radio_Btn_Loc /* 130110 */:
                if (FmUtils.mBand <= 3) {
                    FmService.mLocFm = FmService.mLocFm ? false : true;
                    FmStation.setLoc(FmService.mLocFm);
                    updateLoc();
                    App_Radio.getInstance().sendRadioInfo2Mcu();
                }
                break;
            case FinalRadioCtrl.Radio_Btn_ST /* 130111 */:
                if (FmStation.getCurrentForceMono() == 0) {
                    FmStation.setCurrentForceMono(1);
                } else {
                    FmStation.setCurrentForceMono(0);
                }
                if (FmStation.getCurrentForceMono() == 1) {
                    FMRadioService.setFMAudioMode(1);
                } else {
                    FMRadioService.setFMAudioMode(0);
                }
                if (FmStation.getCurrentForceMono() == 1) {
                    this.actRadio.stopCheckSt();
                    updateStFocus();
                } else {
                    this.actRadio.startCheckSt();
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Scan /* 130112 */:
                Func_Scan(false);
                break;
            case FinalRadioCtrl.Radio_Btn_Save /* 130113 */:
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
            case FinalRadioCtrl.Radio_Btn_Ta /* 130115 */:
                int[] state = FmService.getRdsConf();
                if (state != null) {
                    this.actRadio.stopScan();
                    if (state[0] == 1) {
                        if (FmService.setRdsTaOnOff(0) == 0) {
                            Main.removeRunnable_Ui(App_Radio.getInstance().mRunnable_SeekTa);
                        }
                    } else if (FmService.setRdsTaOnOff(1) == 0) {
                        Main.postRunnable_Ui(true, App_Radio.getInstance().mRunnable_SeekTa, 3000L);
                    }
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Af /* 130134 */:
                int[] state2 = FmService.getRdsConf();
                if (state2 != null) {
                    this.actRadio.stopScan();
                    if (state2[1] == 1) {
                        FmService.setRdsAfOnOff(0);
                    } else {
                        FmService.setRdsAfOnOff(1);
                    }
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Hand /* 130137 */:
                showRuler(true);
                break;
            default:
                return false;
        }
        return true;
    }

    public void selectChannel(int index) {
        if (index >= 0 && index < 6) {
            boolean bSameBand = true;
            int bandFix = this.actRadio.getFixBand(this.mViewPagerFMAM, false);
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
            int bandFix = this.actRadio.getFixBand(this.mViewPagerFMAM, false);
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
                    switchBand(1, true);
                    if (this.mFm2AmGroup != null) {
                        this.mFm2AmGroup.setVisibility(8);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_AMBand /* 130107 */:
                    switchBand(4, true);
                    if (this.mFm2AmGroup != null) {
                        this.mFm2AmGroup.setVisibility(8);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Edit /* 130116 */:
                    Dialog popDlg = getPage().ui.getPopDlg(FinalRadioCtrl.Page_Info, "pop_add_contacts_anim", true);
                    if (popDlg != null) {
                        JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_Info);
                        if (page != null) {
                            page.resume();
                        }
                        popDlg.show();
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_Set /* 130135 */:
                    this.actRadio.goPage(FinalRadioCtrl.Page_Set);
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
                Func_FreqAdujst(false, true);
                break;
            case FinalRadioCtrl.Radio_Btn_FreqP /* 130100 */:
                Func_FreqAdujst(true, true);
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
        handleExtraFreqInfo(iFreqCur, iFreqMin, iFreqMax, iFreqStep);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateChannelTxt() {
        String strBand;
        if (this.mTxtUnit != null) {
            if (FmUtils.mBand <= 3) {
                this.mTxtUnit.setText("MHz");
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
                this.mTxtUnit.setText("KHz");
                if (this.mTxtUnit1 != null) {
                    this.mTxtUnit1.setText("KHz");
                }
                if (this.mTxtUnit2 != null) {
                    this.mTxtUnit2.setText("KHz");
                }
                if (this.mTxtUnit3 != null) {
                    this.mTxtUnit3.setText("KHz");
                }
                if (this.mTxtUnit4 != null) {
                    this.mTxtUnit4.setText("KHz");
                }
                if (this.mTxtUnit5 != null) {
                    this.mTxtUnit5.setText("KHz");
                }
                if (this.mTxtUnit6 != null) {
                    this.mTxtUnit6.setText("KHz");
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
    public void updateListRadio() {
        Main.postRunnable_Ui(true, this.mRunnableUpdateListRadio);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void initPara() {
        App_Radio.getInstance().checkRadioType();
        setPara(FmUtils.mBand);
    }

    public void updateAllChannel(boolean bUpdateFreqAndName) {
        updateAllChannel(getPage(), bUpdateFreqAndName);
        updateAllChannel(this.mPageAm1, bUpdateFreqAndName);
        updateAllChannel(this.mPageAm2, bUpdateFreqAndName);
        updateAllChannel(this.mPageFm1, bUpdateFreqAndName);
        updateAllChannel(this.mPageFm2, bUpdateFreqAndName);
        updateAllChannel(this.mPageFm3, bUpdateFreqAndName);
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0138 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x013a  */
    /* JADX WARN: Code duplicated, block: B:76:0x025c  */
    public void updateAllChannel(JPage page, boolean bUpdateFreqAndName) {
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
                    MyApplication.startThread(MyApplication.mStrZipTag, "db-operation-freqbk", new RunnableSetBk(strFreq, imgView), false, 1);
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
                            int num = ((band - 1) * 6) + i + 1;
                            txtNum.setText(new StringBuilder(String.valueOf(num)).toString());
                        } else {
                            int num2 = ((band - 4) * 6) + i + 1;
                            txtNum.setText(new StringBuilder(String.valueOf(num2)).toString());
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
                    if (bUpdateFreqAndName) {
                        JText txtFreq = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Freq1 + i);
                        JText txtMinFreq = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_MinFreq1 + i);
                        JText txtName = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Name1 + i);
                        if (txtFreq != null) {
                            txtFreq.setText(strFreq);
                        }
                        String strName = App_Radio.getInstance().mRadioInfoManager.queryFreq(strFreq);
                        if (strName != null && !strName.equals(FinalChip.BSP_PLATFORM_Null)) {
                            if (txtName != null) {
                                txtName.setText(strName);
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

    @Override // com.syu.radio.Interface_RadioPage
    public void jump1stChannel() {
        Main.postRunnable_Ui(true, this.mRunnableJump1stChannel, 300L);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void jump1stChannel_AtSoon() {
        int index;
        SparseArray<String> map;
        if (App_Radio.getInstance().mIpcObj.isRightAppId()) {
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
    public void hideScan() {
        if (this.mViewScan != null) {
            this.mViewScan.setFocus(false);
        }
        if (this.mTextScan != null) {
            this.mTextScan.setText(FinalChip.BSP_PLATFORM_Null);
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
                            ResponseClick(FinalRadioCtrl.Radio_Btn_FreqP);
                            break;
                        case 4:
                            ResponseClick(FinalRadioCtrl.Radio_Btn_FreqM);
                            break;
                        case 5:
                            ResponseLongClick(FinalRadioCtrl.Radio_Btn_FreqP);
                            break;
                        case 6:
                            ResponseLongClick(FinalRadioCtrl.Radio_Btn_FreqM);
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
                            ResponseClick(FinalRadioCtrl.Radio_Btn_Band);
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
                            if (pageNotify instanceof Page_Set_Sophia) {
                                ((Page_Set_Sophia) pageNotify).updateFlagRds();
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

    public void updateLoc() {
        if (FmUtils.mBand <= 3) {
            boolean bLoc = FmService.mLocFm;
            if (this.mViewLoc != null) {
                this.mViewLoc.setVisibility(0);
                this.mViewLoc.setFocus(bLoc);
            }
            if (this.mTextLoc != null) {
                this.mTextLoc.setVisibility(0);
                this.mTextLoc.setText(this.actRadio.getStrLoc(bLoc));
                return;
            }
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
            bStFocus = FMRadioService.getFMAudioMode();
        }
        JText txtSt = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_St);
        if (txtSt != null) {
            txtSt.setText(this.actRadio.getStrST(bStFocus));
            txtSt.setVisibility(bStFocus ? 0 : 8);
        } else if (this.mViewST != null) {
            this.mViewST.setFocus(bStFocus);
        }
        App_Radio.getInstance().sendRadioInfo2Mcu();
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void switchBand(boolean bNext, boolean bSwitchBandFromFm2Am, boolean bResetViewPagerItem) {
        int indexWillBe;
        if (!App_Radio.isSupportAm()) {
            bSwitchBandFromFm2Am = false;
        }
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
        if (App_Radio.bOnlyFM) {
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
                } else if (Radio_IpcObj.mTextHZ != "KHz") {
                    Radio_IpcObj.mTextHZ = "KHz";
                    this.actRadio.initlist(false, false, true);
                }
            }
            updateChannelTxt();
            updateListRadio();
            playCurChannel();
            updateBandFocus(bResetViewPagerItem);
            updateLoc();
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateBandFocus(boolean bResetViewPagerItem) {
        int bandFix = FmUtils.mBand;
        if (!bResetViewPagerItem) {
            bandFix = this.actRadio.getFixBand(this.mViewPagerFMAM, false);
        } else if (this.mViewPagerFMAM != null) {
            this.mViewPagerFMAM.setCurrentItem(this.actRadio.getFixItem(this.mViewPagerFMAM, bandFix, false));
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
        if (bandFix >= 1 && bandFix <= 3) {
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
            if (!App_Radio.bSwitchBandFromFm2Am) {
                this.actRadio.setUiLoader(this.mViewPagerFMAM, false);
                return;
            }
            return;
        }
        if (bandFix >= 4 && bandFix <= 5) {
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
                this.actRadio.setUiLoader(this.mViewPagerFMAM, true);
            }
        }
    }

    public void setRadioBk(String strDrawable) {
        if (this.mImgViewRadioBk != null) {
            this.mImgViewRadioBk.setBackground(getPage().getDrawableFromPath(strDrawable, null, null));
        }
    }

    public boolean isViewPagerFmAm(ViewPager viewPager) {
        return viewPager != null && viewPager == this.mViewPagerFMAM;
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
            updateBandFocus(false);
            if (App_Radio.bSwitchBandWhenScroll) {
                int band = this.actRadio.getFixBand(this.mViewPagerFMAM, false);
                switchBand(band, true);
            }
        }
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
        if (this.mViewPagerFMAM != null && this.mViewPagerFMAM.mContents != null) {
            int item = this.mViewPagerFMAM.getCurrentItem();
            int len = this.mViewPagerFMAM.mContents.length;
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
                    this.mViewPagerFMAM.setCurrentItem(item);
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
                    this.mViewPagerFMAM.setCurrentItem(item);
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
        if (this.mViewPagerFMAM != null && this.mViewPagerFMAM.mContents != null) {
            int item = this.mViewPagerFMAM.getCurrentItem();
            int len = this.mViewPagerFMAM.mContents.length;
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
                    this.mViewPagerFMAM.setCurrentItem(item);
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
                    this.mViewPagerFMAM.setCurrentItem(item);
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

    public void rdsEnable() {
        boolean bRdsDisplay = App_Radio.isSupportRds() && FmService.getRdsOnOff() == 1;
        JText txtPty = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Pty);
        JText txtPs = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ps);
        JText txtTa = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ta);
        JText txtTp = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Tp);
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
        for (Page_Menu pageMenu : this.actRadio.mListPageMenus) {
            pageMenu.rdsEnable();
        }
    }

    public void updateRdsInfo() {
        int iRdsEnable = FmService.getRdsOnOff();
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
    }

    public void showPS(int rdsEnable) {
        JText txtPs = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ps);
        if (txtPs != null) {
            String strPsText = FinalChip.BSP_PLATFORM_Null;
            if (rdsEnable == 1) {
                String strTmp = FmService.getPs();
                if (!TextUtils.isEmpty(strTmp)) {
                    strPsText = "PS:" + strTmp;
                }
            }
            txtPs.setText(strPsText);
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
}
