package com.syu.radio.page;

import android.R;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.frame.ctrl.JViewPager;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
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
import com.syu.radio.data.FinalRadioCtrl;
import com.syu.radio.db.Radio_Info;
import com.syu.radio.runnable.RunnableSetBk;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Radio extends MyPage implements Interface_RadioPage {
    JButton AM1;
    JButton AM2;
    JButton FM1;
    JButton FM2;
    JButton FM3;
    public Act_Radio actRadio;
    boolean bChange;
    View mAMBLayout;
    JButton mBtnAM;
    JButton mBtnFM;
    int mClickCnt;
    View mFMBLayout;
    View mFm2AmGroup;
    ImageView mImgViewRadioBk;
    private int mIndexSelect;
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
    Runnable_SelectChannel mRunnable_SelectChannel;
    JText mTxtCurrentFreqName;
    JText mTxtScanning;
    JText mTxtUnit1;
    JText mTxtUnit2;
    JText mTxtUnit3;
    JText mTxtUnit4;
    JText mTxtUnit5;
    JText mTxtUnit6;
    JView mViewAfOn;
    JView mViewFreqLine1;
    JView mViewFreqLine2;
    JView mViewFreqLine3;
    JView mViewFreqLine4;
    JView mViewFreqLine5;
    JView mViewFreqLine6;
    View mViewHalfScreen;
    JView mViewLoc;
    JViewPager mViewPager;
    JViewPager mViewPagerFMAM;
    JView mViewST;
    JView mViewScan;
    JView mViewTa;
    JView mViewTaOn;
    JView mViewTp;
    Toast toast;

    public Page_Radio(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.mIndexSelect = 0;
        this.bChange = false;
        this.mClickCnt = 0;
        this.toast = null;
        this.mRunnable_SelectChannel = new Runnable_SelectChannel();
        this.mRunnableHideRuler = new Runnable() { // from class: com.syu.radio.page.Page_Radio.1
            @Override // java.lang.Runnable
            public void run() {
                Page_Radio.this.hideRuler();
            }
        };
        this.mOnTouchListenerRuler = new View.OnTouchListener() { // from class: com.syu.radio.page.Page_Radio.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case 0:
                    case 2:
                        Page_Radio.this.showRuler(false);
                        return false;
                    case 1:
                    case 3:
                        Main.postRunnable_Ui(true, Page_Radio.this.mRunnableHideRuler, 6000L);
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.actRadio = actRadio;
        actRadio.mInterfacePageRadio = this;
    }

    public void updateSelectChannelLight(int freq) {
        updateSelectChannelLight(getPage(), freq);
        updateSelectChannelLight(this.mPageAm1, freq);
        updateSelectChannelLight(this.mPageAm2, freq);
        updateSelectChannelLight(this.mPageFm1, freq);
        updateSelectChannelLight(this.mPageFm2, freq);
        updateSelectChannelLight(this.mPageFm3, freq);
    }

    public void updateSelectChannelLight(JPage page, int freq) {
        int indexFix;
        if (page != null && (indexFix = getFixIndex(page)) >= 0) {
            JButton btn = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq1 + indexFix);
            JView view = (JView) page.getChildViewByid(FinalRadioCtrl.Radio_Ico_Line1 + indexFix);
            if (btn != null) {
                boolean bHiLight = App_Radio.getInstance().mIpcObj.updateHiLightBtn(btn, view, freq, this.mIndexSelect);
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
                                    break;
                                } catch (Exception e) {
                                    break;
                                }
                            }
                        }
                        if (bZoom) {
                            if (bHiLight) {
                                this.actRadio.Zoom(btn, fRatio);
                            } else {
                                this.actRadio.reStoreScale(btn);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean isAreaOirtFM() {
        int iArea = App_Radio.getInstance().mIpcObj.getArea();
        int iBand = App_Radio.getInstance().mIpcObj.getBand();
        int iBandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        return iArea == 3 && iBand >= iBandFmBegin && iBand < iBandFmBegin + 3;
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
        if (isAreaOirtFM()) {
            if (freq > RadioM.sFreqMax) {
                RadioM.sFreqMin = 8750;
                RadioM.sFreqMax = 10800;
                RadioM.sFreqStepLen = 10;
                RadioM.sFreqStepCnt = 205;
                handleExtraFreqInfo();
            } else if (freq < RadioM.sFreqMin) {
                RadioM.sFreqMin = 6500;
                RadioM.sFreqMax = 7400;
                RadioM.sFreqStepLen = 3;
                RadioM.sFreqStepCnt = 300;
                handleExtraFreqInfo();
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
        JFreqView freqView = (JFreqView) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqView);
        if (freqView != null) {
            freqView.setCurrenFreq(strFreq);
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
        updateSelectChannelLight(freq);
        if (Main.DATA[113] == 1) {
            if (freq > 5000) {
                showToast(String.valueOf(strFreq) + " MHz");
            } else {
                showToast(String.valueOf(strFreq) + " KHz");
            }
        }
    }

    private void showToast(String info) {
        if (this.toast == null) {
            this.toast = Toast.makeText(MyApplication.myApp, info, 1);
            LinearLayout layout = (LinearLayout) this.toast.getView();
            layout.setBackground(getPage().getDrawableFromPath("gps_freq", getPage().mDrawables, getPage().mDrawables));
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

    public void updateCurFreqName() {
        String strFreq;
        int freq = RadioM.DATA[1];
        int band = RadioM.DATA[0];
        if (band >= 65536 && band <= 65538 && (freq < 5000 || freq > 10800)) {
            freq = 8750;
        }
        if (freq > 5000) {
            Radio_IpcObj.mFreq_for_db = freq;
            strFreq = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
        } else {
            Radio_IpcObj.mFreq_for_db = freq * 100;
            strFreq = new StringBuilder().append(freq).toString();
        }
        App_Radio.getInstance().updateCurFreqName(this.mTxtCurrentFreqName, strFreq);
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.actRadio.initlist(false, false, false);
        this.mPageAm1 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_AM1);
        this.mPageAm2 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_AM2);
        this.mPageFm1 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM1);
        this.mPageFm2 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM2);
        this.mPageFm3 = getPage().ui.loadPage(true, FinalRadioCtrl.Page_FM3);
        this.mTxtUnit1 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit1);
        this.mTxtUnit2 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit2);
        this.mTxtUnit3 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit3);
        this.mTxtUnit4 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit4);
        this.mTxtUnit5 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit5);
        this.mTxtUnit6 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit6);
        this.mTxtCurrentFreqName = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_CurFreqName);
        this.mTxtScanning = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Scanning);
        if (this.mTxtScanning != null) {
            this.mTxtScanning.setVisibility(8);
        }
        this.mViewHalfScreen = getPage().getChildViewByid(FinalRadioCtrl.Radio_Btn_HalfScreen);
        this.mViewLoc = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Loc);
        this.mViewScan = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Scan);
        this.mViewST = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_St);
        this.mViewTa = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Ta);
        this.mViewTp = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Tp);
        this.mViewTaOn = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_TaOn);
        this.mViewAfOn = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_AfOn);
        this.mViewPager = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPage);
        this.mViewPagerFMAM = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPageFMAM);
        this.mRulerView = (JRulerView) getPage().getChildViewByid(FinalRadioCtrl.Radio_RulerView);
        this.mViewFreqLine1 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Line1);
        this.mViewFreqLine2 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Line2);
        this.mViewFreqLine3 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Line3);
        this.mViewFreqLine4 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Line4);
        this.mViewFreqLine5 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Line5);
        this.mViewFreqLine6 = (JView) getPage().getChildViewByid(FinalRadioCtrl.Radio_Ico_Line6);
        this.mFMBLayout = getPage().getChildViewByid(FinalRadioCtrl.FMBand_Index);
        this.mAMBLayout = getPage().getChildViewByid(FinalRadioCtrl.AMBand_Index);
        this.AM1 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.AM_1);
        this.AM2 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.AM_2);
        this.FM1 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_1);
        this.FM2 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_2);
        this.FM3 = (JButton) getPage().getChildViewByid(FinalRadioCtrl.FM_3);
        this.mPageMenu = (JPage) getPage().getChildViewByid(FinalRadioCtrl.Page_Menu);
        this.mImgViewRadioBk = (ImageView) getPage().getChildViewByid(FinalRadioCtrl.Radio_BK);
        this.mRulerLayout = getPage().getChildViewByid(FinalRadioCtrl.Radio_Ruler_Group);
        this.mFm2AmGroup = getPage().getChildViewByid(FinalRadioCtrl.Radio_FM_AM_Group);
        this.mLineRuler = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
        this.mBtnFM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_FMBand);
        this.mBtnAM = (JButton) getPage().findViewById(FinalRadioCtrl.Radio_Btn_AMBand);
        if (this.mFm2AmGroup != null) {
            this.mFm2AmGroup.setVisibility(8);
        }
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
        if (this.mViewFreqLine1 != null) {
            this.mViewFreqLine1.setVisibility(4);
        }
        if (this.mViewFreqLine2 != null) {
            this.mViewFreqLine2.setVisibility(4);
        }
        if (this.mViewFreqLine3 != null) {
            this.mViewFreqLine3.setVisibility(4);
        }
        if (this.mViewFreqLine4 != null) {
            this.mViewFreqLine4.setVisibility(4);
        }
        if (this.mViewFreqLine5 != null) {
            this.mViewFreqLine5.setVisibility(4);
        }
        if (this.mViewFreqLine6 != null) {
            this.mViewFreqLine6.setVisibility(4);
        }
        if (this.mRulerView != null) {
            this.mRulerView.setOnValueChangeListener(new JRulerView.OnValueChangeListener() { // from class: com.syu.radio.page.Page_Radio.3
                @Override // com.syu.radio.ctrl.JRulerView.OnValueChangeListener
                public void onValueChange(float value) {
                    App_Radio.getInstance().setFreq((int) value, true);
                }
            });
        }
        updateMenuFocus();
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
        App_Radio.mTypeRadio = 1;
        App_Radio.getInstance().saveSet();
        App_Radio.getInstance().mIpcObj.requestAppIdRight();
        App_Radio.getInstance().mIpcObj.updateNotify_Radio();
        if (this.actRadio.mFreqTuneFromSpeech != -1) {
            App_Radio.getInstance().setFreq(this.actRadio.mFreqTuneFromSpeech, true);
            this.actRadio.mFreqTuneFromSpeech = -1;
        }
        updateHalfScreenVisble();
    }

    public void Func_FreqAdujst(boolean bFreqP, boolean bLongClick) {
        if (App_Radio.isFreqMinusOrPlus(bLongClick)) {
            if (bFreqP) {
                App_Radio.getInstance().mIpcObj.freqPlus();
                return;
            } else {
                App_Radio.getInstance().mIpcObj.freqMinus();
                return;
            }
        }
        if (bFreqP) {
            App_Radio.getInstance().mIpcObj.SeekUp();
        } else {
            App_Radio.getInstance().mIpcObj.SeekDown();
        }
    }

    public void Func_Scan(boolean bLongClick) {
        if (App_Radio.isScan(bLongClick)) {
            App_Radio.getInstance().mIpcObj.scan();
        } else {
            App_Radio.getInstance().mIpcObj.Search();
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public boolean ResponseClick_Menu(int id) {
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
                    this.bChange = this.bChange ? false : true;
                    if (App_Radio.bOnlyFM) {
                        App_Radio.getInstance().mIpcObj.SFmBand();
                    } else {
                        this.actRadio.changeBand(this.bChange);
                    }
                }
                break;
            case FinalRadioCtrl.Radio_Btn_Loc /* 130110 */:
                App_Radio.getInstance().mIpcObj.Loc();
                break;
            case FinalRadioCtrl.Radio_Btn_ST /* 130111 */:
                App_Radio.getInstance().mIpcObj.ST();
                break;
            case FinalRadioCtrl.Radio_Btn_Scan /* 130112 */:
                Func_Scan(false);
                break;
            case FinalRadioCtrl.Radio_Btn_Save /* 130113 */:
                App_Radio.getInstance().mIpcObj.save();
                break;
            case FinalRadioCtrl.Radio_Btn_Pty /* 130114 */:
                App_Radio.getInstance().mIpcObj.switchPtyEnable();
                break;
            case FinalRadioCtrl.Radio_Btn_Ta /* 130115 */:
                App_Radio.getInstance().mIpcObj.switchTaEnable();
                break;
            case FinalRadioCtrl.Radio_Btn_Af /* 130134 */:
                App_Radio.getInstance().mIpcObj.switchAfEnable();
                break;
            case FinalRadioCtrl.Radio_Btn_Hand /* 130137 */:
                showRuler(true);
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void ResponseClick(int id) {
        int indexFix;
        int item;
        int item2;
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
                    int bandFix = this.actRadio.getFixBand(this.mViewPagerFMAM, true);
                    int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
                    if (bandFix >= bandAmBegin && bandFix < bandAmBegin + 2) {
                        indexFix = ((id + 18) - FinalRadioCtrl.Radio_Btn_Freq1) + ((bandFix + 0) * 6);
                    } else {
                        indexFix = (id - FinalRadioCtrl.Radio_Btn_Freq1) + ((bandFix - 65536) * 6);
                    }
                    if (App_Radio.bNeedSetBtnBk && this.mIndexSelect == indexFix) {
                        this.mClickCnt++;
                        App_Radio.mStrFreqCur = new StringBuilder().append(RadioM.DATA[1]).toString();
                        if (this.mClickCnt == 3) {
                            this.actRadio.jumpPhoto();
                        }
                    } else {
                        this.mClickCnt = 0;
                        this.mRunnable_SelectChannel.SetId(this.actRadio.getFixBand(this.mViewPagerFMAM, true), id);
                        updateChannelLight(indexFix);
                        Main.postRunnable_Ui(true, this.mRunnable_SelectChannel, 500L);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_SeekUp /* 130102 */:
                    App_Radio.getInstance().mIpcObj.SeekUp();
                    break;
                case FinalRadioCtrl.Radio_Btn_SeekDown /* 130103 */:
                    App_Radio.getInstance().mIpcObj.SeekDown();
                    break;
                case FinalRadioCtrl.Radio_Btn_FMBand /* 130106 */:
                    App_Radio.getInstance().mIpcObj.SFmBand();
                    if (this.mFm2AmGroup != null) {
                        this.mFm2AmGroup.setVisibility(8);
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_AMBand /* 130107 */:
                    App_Radio.getInstance().mIpcObj.SAmBand();
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
                case FinalRadioCtrl.Radio_Btn_MenuPrev /* 130221 */:
                    JViewPager viewPager = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPage);
                    if (viewPager != null && (item2 = viewPager.getCurrentItem()) != 0) {
                        viewPager.setCurrentItem(item2 - 1, true);
                        break;
                    }
                    break;
                case FinalRadioCtrl.Radio_Btn_MenuNext /* 130222 */:
                    JViewPager viewPager2 = (JViewPager) getPage().getChildViewByid(FinalRadioCtrl.Radio_ViewPage);
                    if (viewPager2 != null && (item = viewPager2.getCurrentItem()) != viewPager2.getSize() + 1) {
                        viewPager2.setCurrentItem(item + 1, true);
                        break;
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
    public void ResponseClick(View v) {
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

    public class Runnable_SelectChannel implements Runnable {
        int band;
        int id;

        public Runnable_SelectChannel() {
        }

        public void SetId(int band, int id) {
            this.band = band;
            this.id = id;
        }

        @Override // java.lang.Runnable
        public void run() {
            App_Radio.getInstance().mIpcObj.SelectChannel(this.band, this.id);
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
                    App_Radio.getInstance().mIpcObj.saveChannel(this.actRadio.getFixBand(this.mViewPagerFMAM, true), id - FinalRadioCtrl.Radio_Btn_Freq1);
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

    public void updateChannelName(int iChannel) {
        updateChannelName(getPage(), iChannel);
        updateChannelName(this.mPageAm1, iChannel);
        updateChannelName(this.mPageAm2, iChannel);
        updateChannelName(this.mPageFm1, iChannel);
        updateChannelName(this.mPageFm2, iChannel);
        updateChannelName(this.mPageFm3, iChannel);
    }

    public void updateChannelName(JPage page, int iChannel) {
        JText textFreq;
        if (page != null && (textFreq = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Freq1 + iChannel)) != null && !TextUtils.isEmpty(textFreq.getText().toString())) {
            String name = null;
            String strFreq = null;
            int band = App_Radio.getInstance().mIpcObj.getBand();
            int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
            int bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
            switch (page.getId()) {
                case FinalRadioCtrl.Page_FM1 /* 130004 */:
                    band = bandFmBegin;
                    break;
                case FinalRadioCtrl.Page_FM2 /* 130005 */:
                    band = bandFmBegin + 1;
                    break;
                case FinalRadioCtrl.Page_FM3 /* 130006 */:
                    band = bandFmBegin + 2;
                    break;
                case FinalRadioCtrl.Page_AM1 /* 130007 */:
                    band = bandAmBegin;
                    break;
                case FinalRadioCtrl.Page_AM2 /* 130008 */:
                    band = bandAmBegin + 1;
                    break;
            }
            if (band >= bandAmBegin && band < bandAmBegin + 2) {
                int index = ((band - bandAmBegin) * 6) + iChannel;
                strFreq = String.format(Locale.US, "%d", Integer.valueOf(App_Radio.getInstance().mIpcObj.getFreqAm()[index]));
                if (!TextUtils.isEmpty(RadioM.FREQ_AM_TEXT[index])) {
                    name = RadioM.FREQ_AM_TEXT[index];
                }
            } else if (band >= bandFmBegin && band < bandFmBegin + 3) {
                int index2 = ((band - bandFmBegin) * 6) + iChannel;
                int freq = App_Radio.getInstance().mIpcObj.getFreqFm()[index2];
                strFreq = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
                if (!TextUtils.isEmpty(RadioM.FREQ_FM_TEXT[index2])) {
                    name = RadioM.FREQ_FM_TEXT[index2];
                }
            }
            String nameCur = name;
            if (Radio_Info.mListInfo != null) {
                for (SparseArray<String> map : Radio_Info.mListInfo) {
                    if (map.get(FinalRadioCtrl.Item_Txt_Freq).equals(strFreq)) {
                        nameCur = map.get(FinalRadioCtrl.Item_Txt_Name);
                    }
                }
            }
            JText textName = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Name1 + iChannel);
            JText textMinFreq = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_MinFreq1 + iChannel);
            if (nameCur != null && !nameCur.equals(FinalChip.BSP_PLATFORM_Null)) {
                if (textName != null) {
                    textName.setText(nameCur);
                }
                if (textMinFreq != null) {
                    textMinFreq.setText(textFreq.getText().toString());
                    if (textFreq.getVisibility() != 4) {
                        textFreq.setVisibility(4);
                        textMinFreq.setVisibility(0);
                        textName.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (textName != null) {
                textName.setText(" ");
            }
            if (textMinFreq != null) {
                if (textFreq.getVisibility() != 0) {
                    textFreq.setVisibility(0);
                }
                if (textMinFreq.getVisibility() == 0) {
                    textMinFreq.setVisibility(4);
                    textName.setVisibility(4);
                }
            }
        }
    }

    public void updateChannelFreq(int channel, int freq) {
        int band = App_Radio.getInstance().mIpcObj.getBand();
        int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
        int bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        int channelAmBegin = App_Radio.getInstance().mIpcObj.getChannelAmBegin();
        int channelFmBegin = App_Radio.getInstance().mIpcObj.getChannelFmBegin();
        int bandFix = -band;
        if (channel >= channelAmBegin && channel < channelAmBegin + 6) {
            bandFix = bandAmBegin;
        } else if (channel >= channelAmBegin + 6 && channel < channelAmBegin + 12) {
            bandFix = bandAmBegin + 1;
        } else if (channel >= channelFmBegin && channel < channelFmBegin + 6) {
            bandFix = bandFmBegin;
        } else if (channel >= channelFmBegin + 6 && channel < channelFmBegin + 12) {
            bandFix = bandFmBegin + 1;
        } else if (channel >= channelFmBegin + 12 && channel < channelFmBegin + 18) {
            bandFix = bandFmBegin + 2;
        }
        if (band == bandFix) {
            updateChannelFreq(getPage(), channel, freq);
        }
        if (channel >= channelAmBegin && channel < channelAmBegin + 6) {
            updateChannelFreq(this.mPageAm1, channel, freq);
            return;
        }
        if (channel >= channelAmBegin + 6 && channel < channelAmBegin + 12) {
            updateChannelFreq(this.mPageAm2, channel, freq);
            return;
        }
        if (channel >= channelFmBegin && channel < channelFmBegin + 6) {
            updateChannelFreq(this.mPageFm1, channel, freq);
            return;
        }
        if (channel >= channelFmBegin + 6 && channel < channelFmBegin + 12) {
            updateChannelFreq(this.mPageFm2, channel, freq);
        } else if (channel >= channelFmBegin + 12 && channel < channelFmBegin + 18) {
            updateChannelFreq(this.mPageFm3, channel, freq);
        }
    }

    public void updateChannelFreq(JPage page, int channel, int freq) {
        if (page != null) {
            int channelAmBegin = App_Radio.getInstance().mIpcObj.getChannelAmBegin();
            int channelFmBegin = App_Radio.getInstance().mIpcObj.getChannelFmBegin();
            if (channel >= channelAmBegin && channel < channelAmBegin + 12) {
                channel -= channelAmBegin;
            } else if (channel >= channelFmBegin && channel < channelFmBegin + 18) {
                channel -= channelFmBegin;
            }
            int iIndexChannel = channel % 6;
            JText text = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_Freq1 + iIndexChannel);
            JText txtNum = (JText) page.getChildViewByid(FinalRadioCtrl.Radio_Txt_No1 + iIndexChannel);
            if (txtNum != null) {
                if (App_Radio.mTypeRadio_No == 1) {
                    txtNum.setText((channel + 1) + ".");
                } else if (App_Radio.mTypeRadio_No == 2) {
                    txtNum.setText((channel + 1) + "/");
                } else {
                    txtNum.setText(new StringBuilder().append(channel + 1).toString());
                }
            }
            String strFreq = new StringBuilder().append(freq).toString();
            ImageView imgView = (ImageView) page.getChildViewByid(FinalRadioCtrl.Radio_BK1 + iIndexChannel);
            MyApplication.startThread(MyApplication.mStrZipTag, "db-operation-freqbk", new RunnableSetBk(strFreq, imgView), false, 1);
            if (text != null) {
                String str = null;
                String strHead = FinalChip.BSP_PLATFORM_Null;
                String strTail = FinalChip.BSP_PLATFORM_Null;
                if (freq > 5000) {
                    str = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
                    strHead = "FM ";
                    strTail = " MHz";
                } else if (freq > 500 && freq < 5000) {
                    str = String.format(Locale.US, "%d", Integer.valueOf(freq));
                    strHead = "AM ";
                    strTail = " KHz";
                }
                if (str != null) {
                    boolean bSetTextOk = false;
                    if (App_Radio.bChannelFreqAddHeadTail) {
                        bSetTextOk = true;
                        text.setText(String.valueOf(strHead) + str + strTail);
                    } else if (App_Radio.bChannelFreqAddTail) {
                        bSetTextOk = true;
                        text.setText(String.valueOf(str) + strTail);
                    } else if (App_Radio.bChannelFreqAddHead) {
                        bSetTextOk = true;
                        text.setText(String.valueOf(strHead) + str);
                    }
                    if (!bSetTextOk) {
                        text.setText(str);
                    }
                    updateChannelName(page, iIndexChannel);
                }
            }
            if (channel == this.mIndexSelect || channel + 18 == this.mIndexSelect) {
                updateSelectChannelLight(page, freq);
            }
        }
    }

    public void band(boolean bResetViewPagerItem) {
        int band = App_Radio.getInstance().mIpcObj.getBand();
        int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
        int channelAmBegin = App_Radio.getInstance().mIpcObj.getChannelAmBegin();
        int bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        int channelFmBegin = App_Radio.getInstance().mIpcObj.getChannelFmBegin();
        if (band >= bandAmBegin && band < bandAmBegin + 2) {
            int start = (band - bandAmBegin) * 6;
            int end = start + 6;
            for (int i = start; i < end; i++) {
                updateChannelFreq(channelAmBegin + i, App_Radio.getInstance().mIpcObj.getFreqAm()[i]);
            }
            if (Radio_IpcObj.mTextHZ != "KHz") {
                Radio_IpcObj.mTextHZ = "KHz";
                this.actRadio.initlist(false, false, true);
            }
            JText txtUnit = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit);
            if (txtUnit != null) {
                txtUnit.setText("KHz");
            }
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
            if (App_Radio.bHideStLoc) {
                if (this.mViewLoc != null) {
                    this.mViewLoc.setVisibility(8);
                }
                if (this.mViewST != null) {
                    this.mViewST.setVisibility(8);
                }
            }
        } else if (band >= bandFmBegin && band < bandFmBegin + 3) {
            int start2 = (band - bandFmBegin) * 6;
            int end2 = start2 + 6;
            for (int i2 = start2; i2 < end2; i2++) {
                updateChannelFreq(channelFmBegin + i2, App_Radio.getInstance().mIpcObj.getFreqFm()[i2]);
            }
            if (Radio_IpcObj.mTextHZ != "MHz") {
                Radio_IpcObj.mTextHZ = "MHz";
                this.actRadio.initlist(false, false, true);
            }
            JText txtUnit2 = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Unit);
            if (txtUnit2 != null) {
                txtUnit2.setText("MHz");
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
            if (App_Radio.bHideStLoc) {
                if (this.mViewLoc != null) {
                    this.mViewLoc.setVisibility(0);
                }
                if (this.mViewST != null) {
                    this.mViewST.setVisibility(0);
                }
            }
        }
        for (int i3 = 0; i3 < 6; i3++) {
            updateChannelFreq(this.mPageAm1, channelAmBegin + i3, App_Radio.getInstance().mIpcObj.getFreqAm()[i3]);
        }
        for (int i4 = 6; i4 < 12; i4++) {
            updateChannelFreq(this.mPageAm2, channelAmBegin + i4, App_Radio.getInstance().mIpcObj.getFreqAm()[i4]);
        }
        for (int i5 = 0; i5 < 6; i5++) {
            updateChannelFreq(this.mPageFm1, channelFmBegin + i5, App_Radio.getInstance().mIpcObj.getFreqFm()[i5]);
        }
        for (int i6 = 6; i6 < 12; i6++) {
            updateChannelFreq(this.mPageFm2, channelFmBegin + i6, App_Radio.getInstance().mIpcObj.getFreqFm()[i6]);
        }
        for (int i7 = 12; i7 < 18; i7++) {
            updateChannelFreq(this.mPageFm3, channelFmBegin + i7, App_Radio.getInstance().mIpcObj.getFreqFm()[i7]);
        }
        updateBandFocus(bResetViewPagerItem);
        channel();
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateBandFocus(boolean bResetViewPagerItem) {
        int bandFix = App_Radio.getInstance().mIpcObj.getBand();
        int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
        int bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        if (!bResetViewPagerItem) {
            bandFix = this.actRadio.getFixBand(this.mViewPagerFMAM, true);
        } else if (this.mViewPagerFMAM != null) {
            this.mViewPagerFMAM.setCurrentItem(this.actRadio.getFixItem(this.mViewPagerFMAM, bandFix, true));
        }
        if (this.AM1 != null) {
            this.AM1.setFocus(bandFix == bandAmBegin);
        }
        if (this.AM2 != null) {
            this.AM2.setFocus(bandFix == bandAmBegin + 1);
        }
        if (this.FM1 != null) {
            this.FM1.setFocus(bandFix == bandFmBegin);
        }
        if (this.FM2 != null) {
            this.FM2.setFocus(bandFix == bandFmBegin + 1);
        }
        if (this.FM3 != null) {
            this.FM3.setFocus(bandFix == bandFmBegin + 2);
        }
        if (bandFix >= bandFmBegin && bandFix <= bandFmBegin + 2) {
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
        if (bandFix >= bandAmBegin && bandFix <= bandAmBegin + 1) {
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

    public void rdsEnable() {
        boolean bRdsDisplay = App_Radio.getInstance().mIpcObj.getRdsDisplay();
        JText txtPty = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Pty);
        JText txtPs = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ps);
        JText txtTa = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ta);
        JText txtTp = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Tp);
        JButton btnPty = null;
        JButton btnTA = null;
        JButton btnAF = null;
        JPage page = getPage().ui.getPage(FinalRadioCtrl.Page_Menu);
        if (page == null) {
            page = getPage().ui.getPage(FinalRadioCtrl.Page_Menu2);
        }
        if (page == null) {
            page = getPage();
        }
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

    public void showTP() {
        int visibility = App_Radio.getInstance().mIpcObj.getTP_Visibility();
        JText txtTp = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Tp);
        if (txtTp != null) {
            if (visibility == 8) {
                txtTp.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                txtTp.setText("TP");
            }
            txtTp.setVisibility(visibility);
            return;
        }
        if (this.mViewTp != null) {
            this.mViewTp.setFocus(visibility != 8);
        }
    }

    public void showTA() {
        JButton btnTA;
        int visibility = App_Radio.getInstance().mIpcObj.getTA_Visibility();
        JText txtTa = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ta);
        if (txtTa != null) {
            if (visibility == 8) {
                txtTa.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                txtTa.setText("TA");
            }
            txtTa.setVisibility(visibility);
        } else if (this.mViewTa != null) {
            this.mViewTa.setFocus(visibility != 8);
        }
        if (this.mPageMenu != null && (btnTA = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Ta)) != null && App_Radio.bSetFocus) {
            btnTA.setFocus(visibility != 8);
        }
    }

    public void showLOC() {
        JButton btnLoc;
        int visibility = App_Radio.getInstance().mIpcObj.getLoc_Visibility();
        JText txtLoc = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Loc);
        if (txtLoc != null) {
            txtLoc.setText(this.actRadio.getStrLoc(visibility != 8));
            txtLoc.setVisibility(visibility);
        } else if (this.mViewLoc != null) {
            this.mViewLoc.setFocus(visibility != 8);
        }
        if (this.mPageMenu != null && (btnLoc = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Loc)) != null && App_Radio.bSetFocus) {
            btnLoc.setFocus(visibility != 8);
        }
    }

    public void showSTSCAN() {
        JButton btnST;
        int[] visibility = new int[2];
        for (int i = 0; i < 2; i++) {
            visibility[i] = 8;
        }
        App_Radio.getInstance().mIpcObj.getSTSCAN_Visibility(visibility);
        JText txtScan = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Scan);
        if (txtScan != null) {
            if (visibility[0] == 8) {
                txtScan.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                txtScan.setText("SCAN");
            }
            txtScan.setVisibility(visibility[0]);
        } else if (this.mViewScan != null) {
            this.mViewScan.setFocus(visibility[0] != 8);
        }
        JText txtSt = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_St);
        if (txtSt != null) {
            txtSt.setText(this.actRadio.getStrST(visibility[1] != 8));
            txtSt.setVisibility(visibility[1]);
        } else if (this.mViewST != null) {
            this.mViewST.setFocus(visibility[1] != 8);
        }
        if (this.mPageMenu != null && (btnST = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_ST)) != null && App_Radio.bSetFocus) {
            btnST.setFocus(visibility[1] != 8);
        }
    }

    public void showAFON() {
        JButton btnAF;
        int visibility = App_Radio.getInstance().mIpcObj.getAFOn_Visibility();
        JText txtAfOn = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_AfOn);
        if (txtAfOn != null) {
            if (visibility == 8) {
                txtAfOn.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                txtAfOn.setText("AF ON");
            }
            txtAfOn.setVisibility(visibility);
        } else if (this.mViewAfOn != null) {
            this.mViewAfOn.setFocus(visibility != 8);
        }
        if (this.mPageMenu != null && (btnAF = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Af)) != null && App_Radio.bSetFocus) {
            btnAF.setFocus(visibility != 8);
        }
    }

    public void showTAON() {
        JButton btnTA;
        int visibility = App_Radio.getInstance().mIpcObj.getTAOn_Visibility();
        JText txtTaOn = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_TaOn);
        if (txtTaOn != null) {
            if (visibility == 8) {
                txtTaOn.setText(FinalChip.BSP_PLATFORM_Null);
            } else {
                txtTaOn.setText("TA ON");
            }
            txtTaOn.setVisibility(visibility);
        } else if (this.mViewTaOn != null) {
            this.mViewTaOn.setFocus(visibility != 8);
        }
        if (this.mPageMenu != null && (btnTA = (JButton) this.mPageMenu.getChildViewByid(FinalRadioCtrl.Radio_Btn_Ta)) != null && App_Radio.bSetFocus) {
            btnTA.setFocus(visibility != 8);
        }
    }

    public void showPTY() {
        JText txtPty = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Pty);
        if (txtPty != null) {
            App_Radio.getInstance().mIpcObj.updatePtyText(txtPty);
        }
    }

    public void showPS() {
        JText txtPs = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Ps);
        if (txtPs != null) {
            String strPsText = App_Radio.getInstance().mIpcObj.getPsText();
            if (!TextUtils.isEmpty(strPsText)) {
                txtPs.setText("PS:" + strPsText);
            } else {
                txtPs.setText(FinalChip.BSP_PLATFORM_Null);
            }
        }
    }

    public void showRds() {
        JText txtRds = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Rds);
        if (txtRds != null) {
            String strRdsText = App_Radio.getInstance().mIpcObj.getRdsText();
            if (!TextUtils.isEmpty(strRdsText)) {
                txtRds.setText(strRdsText);
            } else {
                txtRds.setText(FinalChip.BSP_PLATFORM_Null);
            }
        }
    }

    public void updateChannelLight(int indexSelect) {
        updateChannelLight(getPage(), indexSelect);
        updateChannelLight(this.mPageAm1, indexSelect);
        updateChannelLight(this.mPageAm2, indexSelect);
        updateChannelLight(this.mPageFm1, indexSelect);
        updateChannelLight(this.mPageFm2, indexSelect);
        updateChannelLight(this.mPageFm3, indexSelect);
    }

    public int getFixIndex(JPage page) {
        if (page == null) {
            return -1;
        }
        switch (page.getId()) {
            case FinalRadioCtrl.Page_FM1 /* 130004 */:
                if (this.mIndexSelect < 0 || this.mIndexSelect >= 6) {
                    return -1;
                }
                int index = this.mIndexSelect % 6;
                return index;
            case FinalRadioCtrl.Page_FM2 /* 130005 */:
                if (this.mIndexSelect < 6 || this.mIndexSelect >= 12) {
                    return -1;
                }
                int index2 = this.mIndexSelect % 6;
                return index2;
            case FinalRadioCtrl.Page_FM3 /* 130006 */:
                if (this.mIndexSelect < 12 || this.mIndexSelect >= 18) {
                    return -1;
                }
                int index3 = this.mIndexSelect % 6;
                return index3;
            case FinalRadioCtrl.Page_AM1 /* 130007 */:
                if (this.mIndexSelect < 18 || this.mIndexSelect >= 24) {
                    return -1;
                }
                int index4 = this.mIndexSelect % 6;
                return index4;
            case FinalRadioCtrl.Page_AM2 /* 130008 */:
                if (this.mIndexSelect < 24 || this.mIndexSelect >= 30) {
                    return -1;
                }
                int index5 = this.mIndexSelect % 6;
                return index5;
            default:
                int index6 = this.mIndexSelect % 6;
                return index6;
        }
    }

    private void updateChannelLight(JPage page, int indexSelect) {
        if (page != null) {
            this.mIndexSelect = indexSelect;
            int indexFix = getFixIndex(page);
            int i = 0;
            while (i < 6) {
                JButton btn = (JButton) page.getChildViewByid(FinalRadioCtrl.Radio_Btn_Freq1 + i);
                JView view = (JView) page.getChildViewByid(FinalRadioCtrl.Radio_Ico_Line1 + i);
                if (btn != null) {
                    boolean bHighLight = i == indexFix;
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
                                        break;
                                    } catch (Exception e) {
                                        break;
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
                i++;
            }
        }
    }

    public void channel() {
        JText txtChannel = (JText) getPage().getChildViewByid(FinalRadioCtrl.Radio_Txt_Channel);
        JFreqBand bandChannel = (JFreqBand) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqBand);
        int iIndexBtn = App_Radio.getInstance().mIpcObj.updateChannelText(txtChannel, bandChannel);
        if (-1 < iIndexBtn && iIndexBtn < 30) {
            updateChannelLight(iIndexBtn);
        }
    }

    public void updateDispInfo() {
        rdsEnable();
        showTP();
        showTA();
        showAFON();
        showTAON();
        showPTY();
        showLOC();
        showPS();
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
        int indexWillBe;
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
        }
        if (isViewPagerFmAm(viewPager)) {
            updateBandFocus(false);
            if (App_Radio.bSwitchBandWhenScroll) {
                int band = this.actRadio.getFixBand(this.mViewPagerFMAM, true);
                int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
                int bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
                if (band >= bandAmBegin && band < bandAmBegin + 2) {
                    indexWillBe = (band + 3) - bandAmBegin;
                } else {
                    indexWillBe = band - bandFmBegin;
                }
                switch (indexWillBe) {
                    case 0:
                        App_Radio.getInstance().mIpcObj.FmBand(0);
                        break;
                    case 1:
                        App_Radio.getInstance().mIpcObj.FmBand(1);
                        break;
                    case 2:
                        App_Radio.getInstance().mIpcObj.FmBand(2);
                        break;
                    case 3:
                        App_Radio.getInstance().mIpcObj.AmBand(0);
                        break;
                    case 4:
                        App_Radio.getInstance().mIpcObj.AmBand(1);
                        break;
                }
            }
        }
    }

    public void handleExtraFreqInfo() {
        JFreqRoundRuler freqRoundRuler = (JFreqRoundRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqRoundRuler);
        if (freqRoundRuler != null) {
            App_Radio.getInstance().mIpcObj.handleExtraFreqInfo(freqRoundRuler);
        }
        JFreqLineRuler freqLineRuler = (JFreqLineRuler) getPage().getChildViewByid(FinalRadioCtrl.Radio_FreqLineRuler);
        if (freqLineRuler != null) {
            App_Radio.getInstance().mIpcObj.handleExtraFreqInfo(freqLineRuler);
        }
        JRulerView rulerView = (JRulerView) getPage().getChildViewByid(FinalRadioCtrl.Radio_RulerView);
        if (rulerView != null) {
            App_Radio.getInstance().mIpcObj.handleExtraFreqInfo(rulerView);
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
    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        App_Radio.getInstance().mIpcObj.onNotify(this, updateCode, ints, flts, strs);
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateListRadio() {
        updateCurFreqName();
        for (int i = 0; i < 6; i++) {
            updateChannelName(i);
        }
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void switchBand(boolean bNext, boolean bSwitchBandFromFm2Am, boolean bResetViewPagerItem) {
        int indexWillBe;
        int band = App_Radio.getInstance().mIpcObj.getBand();
        int bandAmBegin = App_Radio.getInstance().mIpcObj.getBandAmBegin();
        int bandFmBegin = App_Radio.getInstance().mIpcObj.getBandFmBegin();
        if (band >= bandAmBegin && band < bandAmBegin + 2) {
            int indexWillBe2 = (band + 3) - bandAmBegin;
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
            int indexWillBe3 = band - bandFmBegin;
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
        switch (indexWillBe) {
            case 0:
                App_Radio.getInstance().mIpcObj.FmBand(0);
                break;
            case 1:
                App_Radio.getInstance().mIpcObj.FmBand(1);
                break;
            case 2:
                App_Radio.getInstance().mIpcObj.FmBand(2);
                break;
            case 3:
                App_Radio.getInstance().mIpcObj.AmBand(0);
                break;
            case 4:
                App_Radio.getInstance().mIpcObj.AmBand(1);
                break;
        }
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

    @Override // com.syu.radio.Interface_RadioPage
    public void refreshStationUI() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void checkTuneFromSpeech() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void disLoading() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void showLoading() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void jump1stChannel() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void jump1stChannel_AtSoon() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void Func_Search() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void setPara(int iBand) {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void initPara() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void showHideScan() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateChannelTxt() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void hideScan() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void updateStFocus() {
    }

    @Override // com.syu.radio.Interface_RadioPage
    public void setBtnBk() {
        band(false);
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
}
