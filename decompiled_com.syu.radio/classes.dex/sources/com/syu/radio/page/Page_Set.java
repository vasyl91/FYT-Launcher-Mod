package com.syu.radio.page;

import android.view.View;
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
public class Page_Set extends MyPage {
    Act_Radio actRadio;
    private int idCheckLast;
    JText mHandSensOnOff;
    JText mRdsOnOff;
    Runnable_SetArea mRunnable_SetArea;
    JSwitchButon2 mSB_HandSensOnOff;
    JSwitchButon2 mSB_RDSOnOff;
    JText mTxtHandSensOnOff;
    JText mTxtRdsOnOff;

    public Page_Set(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.idCheckLast = -1;
        this.mRunnable_SetArea = new Runnable_SetArea();
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.mTxtHandSensOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_HandSensOnOff);
        this.mHandSensOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_HandSens_OnOff);
        this.mSB_HandSensOnOff = (JSwitchButon2) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_HandSensOnOff_2);
        this.mSB_RDSOnOff = (JSwitchButon2) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff_2);
        this.mTxtRdsOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_RdsOnOff);
        this.mRdsOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Rds_OnOff);
        if (this.mSB_HandSensOnOff != null) {
            this.mSB_HandSensOnOff.setOnSwitchStateLisenter(new JSwitchButon2.OnSwitchStateLisenter() { // from class: com.syu.radio.page.Page_Set.1
                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOn() {
                    App_Radio.getInstance().mIpcObj.switchHandSensOnOff(true);
                }

                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOff() {
                    App_Radio.getInstance().mIpcObj.switchHandSensOnOff(false);
                }
            });
        }
        if (this.mSB_RDSOnOff != null) {
            this.mSB_RDSOnOff.setOnSwitchStateLisenter(new JSwitchButon2.OnSwitchStateLisenter() { // from class: com.syu.radio.page.Page_Set.2
                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOn() {
                    App_Radio.getInstance().mIpcObj.switchRdsOnOff(true);
                }

                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOff() {
                    App_Radio.getInstance().mIpcObj.switchRdsOnOff(false);
                }
            });
        }
        this.actRadio.hideSetCtrl(getPage());
        updateFlagRds();
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() throws Throwable {
        if (App_Radio.bHideSetSystemUI || App_Radio.isTranslucent) {
            this.actRadio.myActivity.hideSystemUi();
        } else {
            this.actRadio.myActivity.showSystemUi();
        }
        App_Radio.mTypeRadio = 1;
        App_Radio.getInstance().saveSet();
        App_Radio.getInstance().mIpcObj.requestAppIdRight();
        App_Radio.getInstance().mIpcObj.updateNotify_Set();
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        switch (id) {
            case FinalRadioCtrl.Set_Btn_Default /* 130028 */:
                App_Radio.getInstance().mIpcObj.defaultSet();
                break;
            case FinalRadioCtrl.Set_Btn_AmSensMinus /* 130029 */:
                App_Radio.getInstance().mIpcObj.amSens_minus();
                break;
            case FinalRadioCtrl.Set_Btn_AmSensPlus /* 130030 */:
                App_Radio.getInstance().mIpcObj.amSens_plus();
                break;
            case FinalRadioCtrl.Set_Btn_FmSensMinus /* 130031 */:
                App_Radio.getInstance().mIpcObj.fmSens_minus();
                break;
            case FinalRadioCtrl.Set_Btn_FmSensPlus /* 130032 */:
                App_Radio.getInstance().mIpcObj.fmSens_plus();
                break;
            case FinalRadioCtrl.Set_Btn_HandSensOn /* 130033 */:
                App_Radio.getInstance().mIpcObj.switchHandSensOnOff(true);
                break;
            case FinalRadioCtrl.Set_Btn_HandSensOff /* 130034 */:
                App_Radio.getInstance().mIpcObj.switchHandSensOnOff(false);
                break;
            case FinalRadioCtrl.Set_Btn_RdsOn /* 130035 */:
                App_Radio.getInstance().mIpcObj.switchRdsOnOff(true);
                break;
            case FinalRadioCtrl.Set_Btn_RdsOff /* 130036 */:
                App_Radio.getInstance().mIpcObj.switchRdsOnOff(false);
                break;
            case FinalRadioCtrl.Set_Switch_HandSensOnOff /* 130054 */:
                JSwitchButton switchButton = (JSwitchButton) v;
                App_Radio.getInstance().mIpcObj.switchHandSensOnOff(switchButton.isChecked());
                break;
            case FinalRadioCtrl.Set_Switch_RdsOnOff /* 130056 */:
                JSwitchButton switchButton2 = (JSwitchButton) v;
                App_Radio.getInstance().mIpcObj.switchRdsOnOff(switchButton2.isChecked());
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
            App_Radio.getInstance().mIpcObj.setArea(this.id - FinalRadioCtrl.Set_CheckBox_AreaUSA);
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
        int id = App_Radio.getInstance().mIpcObj.getFocusCheckBoxId();
        if (id > 0) {
            ToggleCheck(id);
        }
    }

    public void updateSensAuto() {
        boolean bUnAuto = true;
        if (App_Radio.getInstance().mIpcObj.getAutoSensity() != 0) {
            bUnAuto = false;
        }
        View view = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_AmSensMinus);
        if (view != null) {
            view.setEnabled(bUnAuto);
        }
        View view2 = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_AmSensPlus);
        if (view2 != null) {
            view2.setEnabled(bUnAuto);
        }
        View view3 = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_FmSensMinus);
        if (view3 != null) {
            view3.setEnabled(bUnAuto);
        }
        View view4 = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_FmSensPlus);
        if (view4 != null) {
            view4.setEnabled(bUnAuto);
        }
        JSwitchButton switchButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_HandSensOnOff);
        if (switchButton != null) {
            switchButton.setChecked(bUnAuto);
        }
        if (this.mSB_HandSensOnOff != null) {
            this.mSB_HandSensOnOff.setSwitch(bUnAuto);
        }
        if (this.mTxtHandSensOnOff != null) {
            if (bUnAuto) {
                this.mTxtHandSensOnOff.setText(getString("radio_set_handsens"));
            } else {
                this.mTxtHandSensOnOff.setText(getString("radio_set_autosens"));
            }
        }
        if (this.mHandSensOnOff != null) {
            if (bUnAuto) {
                this.mHandSensOnOff.setText(getString("set_text_on"));
            } else {
                this.mHandSensOnOff.setText(getString("set_text_off"));
            }
        }
    }

    public void updateFlagRds() {
        int iRdsEnable = App_Radio.getInstance().mIpcObj.getRdsEnable();
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
            switchButton.setChecked(iRdsEnable != 0);
        }
        if (this.mSB_RDSOnOff != null) {
            this.mSB_RDSOnOff.setSwitch(iRdsEnable != 0);
        }
    }

    public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        App_Radio.getInstance().mIpcObj.onNotify(this, updateCode, ints, flts, strs);
    }
}
