package com.syu.radio.page;

import android.view.View;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JCheckBox;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JSwitchButton;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.ctrl.JSwitchButon2;
import com.syu.radio.data.FinalRadioCtrl;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_Set_Sophia extends MyPage {
    Act_Radio actRadio;
    private int idCheckLast;
    JText mHandSensOnOff;
    JText mRdsOnOff;
    Runnable_SetArea mRunnable_SetArea;
    JSwitchButon2 mSB_RDSOnOff;
    JSwitchButton mSwitchButtonHandSens;
    JText mTxtAmSens;
    JText mTxtFmSens;
    JText mTxtHandSensOnOff;
    JText mTxtRdsOnOff;
    View mViewAmSensMinus;
    View mViewAmSensPlus;
    View mViewFmSensMinus;
    View mViewFmSensPlus;

    public Page_Set_Sophia(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.idCheckLast = -1;
        this.mRunnable_SetArea = new Runnable_SetArea();
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.mSB_RDSOnOff = (JSwitchButon2) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff_2);
        this.mSwitchButtonHandSens = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_HandSensOnOff);
        this.mTxtHandSensOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_HandSensOnOff);
        this.mTxtRdsOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_RdsOnOff);
        this.mRdsOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Rds_OnOff);
        this.mHandSensOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_HandSens_OnOff);
        this.mTxtFmSens = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_FmSensVal);
        this.mViewFmSensMinus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_FmSensMinus);
        this.mViewFmSensPlus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_FmSensPlus);
        this.mTxtAmSens = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_AmSensVal);
        this.mViewAmSensMinus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_AmSensMinus);
        this.mViewAmSensPlus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_AmSensPlus);
        updateFmSens();
        updateAmSens();
        updateAutoSens();
        updateFlagRds();
        updateCurrentArea();
        this.actRadio.hideSetCtrl(getPage());
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() throws Throwable {
        if (App_Radio.bHideSetSystemUI || App_Radio.isTranslucent) {
            this.actRadio.myActivity.hideSystemUi();
        } else {
            this.actRadio.myActivity.showSystemUi();
        }
        App_Radio.mTypeRadio = 3;
        App_Radio.getInstance().saveSet();
        App_Radio.getInstance().mIpcObj.requestAppIdRight();
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.Set_Btn_Default /* 130028 */:
                FmService.mLocFm = false;
                FmStation.setLoc(FmService.mLocFm);
                FmService.mAutoSensitivity = true;
                FmStation.setAutoSenstivity(FmService.mAutoSensitivity);
                updateFmSens();
                updateAmSens();
                updateAutoSens();
                if (App_Radio.isSupportRds()) {
                    FmService.setRdsOnOff(1);
                    updateFlagRds();
                    this.actRadio.updateRdsInfo();
                }
                ToggleCheck(FinalRadioCtrl.Set_CheckBox_AreaEurope);
                this.mRunnable_SetArea.SetId(FinalRadioCtrl.Set_CheckBox_AreaEurope);
                this.mRunnable_SetArea.run();
                break;
            case FinalRadioCtrl.Set_Btn_AmSensMinus /* 130029 */:
                if (FmService.mAmSenstivity > FmUtils.mAmSens_Min) {
                    FmService.mAmSenstivity--;
                    FmStation.setAmSensitivity(FmService.mAmSenstivity);
                    updateAmSens();
                }
                break;
            case FinalRadioCtrl.Set_Btn_AmSensPlus /* 130030 */:
                if (FmService.mAmSenstivity < FmUtils.mAmSens_Max) {
                    FmService.mAmSenstivity++;
                    FmStation.setAmSensitivity(FmService.mAmSenstivity);
                    updateAmSens();
                }
                break;
            case FinalRadioCtrl.Set_Btn_FmSensMinus /* 130031 */:
                if (FmService.mFmSenstivity > FmUtils.mFmSens_Min) {
                    FmService.mFmSenstivity--;
                    FmStation.setFmSensitivity(FmService.mFmSenstivity);
                    updateFmSens();
                }
                break;
            case FinalRadioCtrl.Set_Btn_FmSensPlus /* 130032 */:
                if (FmService.mFmSenstivity < FmUtils.mFmSens_Max) {
                    FmService.mFmSenstivity++;
                    FmStation.setFmSensitivity(FmService.mFmSenstivity);
                    updateFmSens();
                }
                break;
            case FinalRadioCtrl.Set_Btn_HandSensOn /* 130033 */:
            case FinalRadioCtrl.Set_Btn_HandSensOff /* 130034 */:
            case FinalRadioCtrl.Set_Switch_HandSensOnOff /* 130054 */:
                if (v instanceof JSwitchButton) {
                    JSwitchButton switchButton = (JSwitchButton) v;
                    if (switchButton.isChecked()) {
                        FmService.mAutoSensitivity = false;
                    } else {
                        FmService.mAutoSensitivity = true;
                    }
                } else if (id == 130033) {
                    FmService.mAutoSensitivity = false;
                } else {
                    FmService.mAutoSensitivity = true;
                }
                FmStation.setAutoSenstivity(FmService.mAutoSensitivity);
                updateFmSens();
                updateAmSens();
                updateAutoSens();
                break;
            case FinalRadioCtrl.Set_Switch_RdsOnOff /* 130056 */:
                if (v instanceof JSwitchButton) {
                    JSwitchButton switchButton2 = (JSwitchButton) v;
                    if (switchButton2.isChecked()) {
                        FmService.setRdsOnOff(1);
                    } else {
                        FmService.setRdsOnOff(0);
                    }
                }
                updateFlagRds();
                this.actRadio.updateRdsInfo();
                break;
            case FinalRadioCtrl.Set_CheckBox_AreaUSA /* 130063 */:
            case FinalRadioCtrl.Set_CheckBox_AreaLatin /* 130064 */:
            case FinalRadioCtrl.Set_CheckBox_AreaEurope /* 130065 */:
            case FinalRadioCtrl.Set_CheckBox_AreaOirt /* 130066 */:
            case FinalRadioCtrl.Set_CheckBox_AreaJapan /* 130067 */:
                ToggleCheck(id);
                this.mRunnable_SetArea.SetId(id);
                Main.postRunnable_Ui(true, this.mRunnable_SetArea, 500L);
                break;
            case FinalRadioCtrl.Radio_Btn_Back /* 130074 */:
                this.actRadio.goPage(FinalRadioCtrl.Page_Radio);
                break;
        }
    }

    public class Runnable_SetArea implements Runnable {
        int id;

        public Runnable_SetArea() {
        }

        public void SetId(int id) {
            this.id = id;
        }

        @Override // java.lang.Runnable
        public void run() {
            FmService.setCurrentArea(this.id - FinalRadioCtrl.Set_CheckBox_AreaUSA);
            FmStation.cleanAllStations();
            App_Radio.getInstance().getRadioRangeAndFreqDefault();
            App_Radio.getInstance().getData_RadioArm(MyApplication.myApp.getContentResolver());
            Page_Set_Sophia.this.actRadio.jump1stChannel();
            Page_Set_Sophia.this.actRadio.initlist(false, false, true);
        }
    }

    public void ToggleCheck(int id) {
        JCheckBox checkBoxLast;
        JCheckBox checkBox = (JCheckBox) getPage().getChildViewByid(id);
        if (checkBox != null && this.idCheckLast != id) {
            if (this.idCheckLast > 0 && (checkBoxLast = (JCheckBox) getPage().getChildViewByid(this.idCheckLast)) != null) {
                checkBoxLast.setChecked(false);
            }
            checkBox.setChecked(true);
            this.idCheckLast = id;
        }
    }

    public void updateCurrentArea() {
        int iArea = FmService.getCurrentArea();
        int id = FmService.getFocusCheckBoxId(iArea);
        if (id > 0) {
            ToggleCheck(id);
        }
    }

    public void updateFlagRds() {
        int iRdsEnable = FmService.getRdsOnOff();
        if (this.mTxtRdsOnOff != null) {
            if (iRdsEnable == 1) {
                this.mTxtRdsOnOff.setText(getString("radio_set_rds_on"));
            } else {
                this.mTxtRdsOnOff.setText(getString("radio_set_rds_off"));
            }
        }
        if (this.mRdsOnOff != null) {
            if (iRdsEnable == 1) {
                this.mRdsOnOff.setText(getString("set_text_on"));
            } else {
                this.mRdsOnOff.setText(getString("set_text_off"));
            }
        }
        JSwitchButton switchButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff);
        if (switchButton != null) {
            switchButton.setChecked(iRdsEnable == 1);
        }
        if (this.mSB_RDSOnOff != null) {
            this.mSB_RDSOnOff.setSwitch(iRdsEnable == 1);
        }
    }

    public void updateAutoSens() {
        if (this.mSwitchButtonHandSens != null) {
            this.mSwitchButtonHandSens.setChecked(!FmService.mAutoSensitivity);
        }
        if (this.mTxtHandSensOnOff != null) {
            if (FmService.mAutoSensitivity) {
                this.mTxtHandSensOnOff.setText(getString("radio_set_autosens"));
            } else {
                this.mTxtHandSensOnOff.setText(getString("radio_set_handsens"));
            }
        }
        if (this.mHandSensOnOff != null) {
            if (FmService.mAutoSensitivity) {
                this.mHandSensOnOff.setText(getString("radio_set_rds_off"));
            } else {
                this.mHandSensOnOff.setText(getString("radio_set_rds_on"));
            }
        }
        if (this.mViewFmSensMinus != null) {
            this.mViewFmSensMinus.setEnabled(!FmService.mAutoSensitivity);
        }
        if (this.mViewFmSensPlus != null) {
            this.mViewFmSensPlus.setEnabled(!FmService.mAutoSensitivity);
        }
        if (this.mViewAmSensMinus != null) {
            this.mViewAmSensMinus.setEnabled(!FmService.mAutoSensitivity);
        }
        if (this.mViewAmSensPlus != null) {
            this.mViewAmSensPlus.setEnabled(FmService.mAutoSensitivity ? false : true);
        }
    }

    public void updateFmSens() {
        if (this.mTxtFmSens != null) {
            this.mTxtFmSens.setText(new StringBuilder().append(FmUtils.getFmSensitivity(false)).toString());
        }
    }

    public void updateAmSens() {
        if (this.mTxtAmSens != null) {
            this.mTxtAmSens.setText(new StringBuilder().append(FmUtils.getAmSensitivity()).toString());
        }
    }
}
