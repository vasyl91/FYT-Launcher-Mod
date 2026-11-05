package com.syu.radio.page;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemProperties;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.android.fmradio.FmNative;
import com.android.fmradio.FmService;
import com.android.fmradio.FmStation;
import com.android.fmradio.FmUtils;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JCheckBox;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.ctrl.JSwitchButton;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.frame.page.MyPage;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import com.syu.radio.ctrl.JSwitchButon2;
import com.syu.radio.data.FinalRadioCtrl;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Page_SettingInfo extends MyPage {
    Act_Radio actRadio;
    private int idCheckLast;
    JText mHandSensOnOff;
    Runnable_SetArea mRunnable_SetArea;
    JSwitchButton mSwitchButtonHandSens;
    JText mTxtAmSens;
    JText mTxtFmSens;
    JText mTxtHandSensOnOff;
    JText mTxtRdsOnOff;
    View mViewAmSensMinus;
    View mViewAmSensPlus;
    View mViewFmSensMinus;
    View mViewFmSensPlus;
    private int[] nightBox;
    private int[] nightBtn;
    private int[] nightText;
    private int[] nightView;
    JSwitchButon2 switchHandSens2;
    JSwitchButon2 switchRds2;

    public Page_SettingInfo(JPage page, Act_Radio actRadio) {
        super(page, App_Radio.getInstance().uiApp);
        this.idCheckLast = -1;
        this.nightBtn = new int[]{FinalRadioCtrl.Set_Btn_Default, FinalRadioCtrl.Set_Btn_AmSensMinus, FinalRadioCtrl.Set_Btn_AmSensPlus, FinalRadioCtrl.Set_Btn_FmSensMinus, FinalRadioCtrl.Set_Btn_FmSensPlus};
        this.nightText = new int[]{FinalRadioCtrl.Set_Txt_AmSens, FinalRadioCtrl.Set_Txt_FmSens, FinalRadioCtrl.Set_Txt_HandSensOnOff, FinalRadioCtrl.Set_Txt_RdsOnOff, FinalRadioCtrl.Set_Txt_Area, FinalRadioCtrl.Set_Txt_default, FinalRadioCtrl.Set_Txt_default_1};
        this.nightBox = new int[]{FinalRadioCtrl.Set_CheckBox_AreaUSA, FinalRadioCtrl.Set_CheckBox_AreaLatin, FinalRadioCtrl.Set_CheckBox_AreaEurope, FinalRadioCtrl.Set_CheckBox_AreaOirt, FinalRadioCtrl.Set_CheckBox_AreaJapan};
        this.nightView = new int[]{FinalRadioCtrl.Set_iv_tip1, FinalRadioCtrl.Set_iv_tip2, FinalRadioCtrl.Set_iv_tip3, FinalRadioCtrl.Set_iv_tip4, FinalRadioCtrl.Set_iv_tip5, FinalRadioCtrl.Set_iv_tip6};
        this.mRunnable_SetArea = new Runnable_SetArea();
        this.actRadio = actRadio;
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void init() {
        this.mSwitchButtonHandSens = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_HandSensOnOff);
        this.mTxtHandSensOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_HandSensOnOff);
        this.mHandSensOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_HandSens_OnOff);
        this.mTxtFmSens = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_FmSensVal);
        this.mViewFmSensMinus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_FmSensMinus);
        this.mViewFmSensPlus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_FmSensPlus);
        this.mTxtAmSens = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_AmSensVal);
        this.mViewAmSensMinus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_AmSensMinus);
        this.mViewAmSensPlus = getPage().getChildViewByid(FinalRadioCtrl.Set_Btn_AmSensPlus);
        this.mTxtRdsOnOff = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_RdsOnOff);
        this.switchRds2 = (JSwitchButon2) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff_2);
        if (this.switchRds2 != null) {
            this.switchRds2.setOnSwitchStateLisenter(new JSwitchButon2.OnSwitchStateLisenter() { // from class: com.syu.radio.page.Page_SettingInfo.1
                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOn() {
                    FmService.setRdsOnOff(1);
                    Page_SettingInfo.this.updateFlagRds();
                    Page_SettingInfo.this.actRadio.updateRdsInfo();
                }

                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOff() {
                    FmService.setRdsOnOff(0);
                    Page_SettingInfo.this.updateFlagRds();
                    Page_SettingInfo.this.actRadio.updateRdsInfo();
                }
            });
        }
        this.switchHandSens2 = (JSwitchButon2) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_HandSensOnOff_2);
        if (this.switchHandSens2 != null) {
            this.switchHandSens2.setOnSwitchStateLisenter(new JSwitchButon2.OnSwitchStateLisenter() { // from class: com.syu.radio.page.Page_SettingInfo.2
                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOn() {
                    Log.d("gdy4", " 01 switchHandSens2 on mAutoSensitivity = " + FmService.mAutoSensitivity);
                    FmStation.setAutoSenstivity(false);
                    FmService.mAutoSensitivity = false;
                    Page_SettingInfo.this.updateFmSens();
                    Page_SettingInfo.this.updateAmSens();
                    Page_SettingInfo.this.updateAutoSens();
                }

                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOff() {
                    Log.d("gdy4", " 02 switchHandSens2 off mAutoSensitivity = " + FmService.mAutoSensitivity);
                    FmStation.setAutoSenstivity(true);
                    FmService.mAutoSensitivity = true;
                    Page_SettingInfo.this.updateFmSens();
                    Page_SettingInfo.this.updateAmSens();
                    Page_SettingInfo.this.updateAutoSens();
                }
            });
        }
        if (App_Radio.bUI_NightColour) {
            setDayOrNight(App_Radio.mNightDay);
        }
        updateFmSens();
        updateAmSens();
        updateAutoSens();
        updateCurrentArea();
        updateFlagRds();
        this.actRadio.hideSetCtrl(getPage());
    }

    public void updateCurrentArea() {
        int iArea = FmService.getCurrentArea();
        int id = FmService.getFocusCheckBoxId(iArea);
        if (id > 0) {
            ToggleCheck(id);
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void resume() throws Throwable {
        if (App_Radio.bHideSetSystemUI || App_Radio.isTranslucent) {
            this.actRadio.myActivity.hideSystemUi();
        } else {
            this.actRadio.myActivity.showSystemUi();
        }
        App_Radio.mTypeRadio = 2;
        App_Radio.getInstance().saveSet();
        App_Radio.getInstance().mIpcObj.requestAppIdRight();
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
        if (App_Radio.isSupportRds6025()) {
            JSwitchButton switchButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff);
            if (switchButton != null) {
                switchButton.setChecked(iRdsEnable == 1);
            }
            Log.d("gdy4", " 00 Set_Switch_RdsOnOff_2 setSwitch iRdsEnable = " + iRdsEnable);
            if (this.switchRds2 != null) {
                this.switchRds2.setSwitch(iRdsEnable == 1);
            }
        }
    }

    @Override // com.lsec.core.frame.page.MyPage, com.lsec.core.frame.page.IPageNotify
    public void ResponseClick(View v) {
        int id = v.getId();
        Log.d("gdy4", " 00 Set_Switch_RdsOnOff_2 id = " + id);
        switch (id) {
            case FinalRadioCtrl.Set_Btn_Default /* 130028 */:
                FmService.mLocFm = false;
                FmStation.setLoc(FmService.mLocFm);
                FmService.mAutoSensitivity = true;
                FmStation.setAutoSenstivity(FmService.mAutoSensitivity);
                updateFmSens();
                updateAmSens();
                updateAutoSens();
                if (App_Radio.isSupportRds6025()) {
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
                JSwitchButton switchButton2 = (JSwitchButton) v;
                if (switchButton2.isChecked()) {
                    FmService.setRdsOnOff(1);
                } else {
                    FmService.setRdsOnOff(0);
                }
                updateFlagRds();
                this.actRadio.updateRdsInfo();
                break;
            case FinalRadioCtrl.Set_CheckBox_AreaUSA /* 130063 */:
            case FinalRadioCtrl.Set_CheckBox_AreaLatin /* 130064 */:
            case FinalRadioCtrl.Set_CheckBox_AreaEurope /* 130065 */:
            case FinalRadioCtrl.Set_CheckBox_AreaOirt /* 130066 */:
            case FinalRadioCtrl.Set_CheckBox_AreaJapan /* 130067 */:
                if (App_Radio.mService.isScanning() || App_Radio.mService.isSeeking()) {
                    FmNative.getInstance().test_stopScan();
                }
                ToggleCheck(id);
                this.mRunnable_SetArea.SetId(id);
                Main.postRunnable_Ui(true, this.mRunnable_SetArea, 500L);
                break;
            case FinalRadioCtrl.Radio_Btn_Back /* 130074 */:
                this.actRadio.goPage(FinalRadioCtrl.Page_Radio);
                break;
            case FinalRadioCtrl.btn_music /* 130164 */:
                Intent intent1 = new Intent("android.intent.action.MAIN");
                intent1.addFlags(270532608);
                intent1.setComponent(new ComponentName("com.syu.music", "com.syu.app.Activity_All"));
                try {
                    this.actRadio.myActivity.startActivity(intent1);
                } catch (Exception e) {
                    Toast.makeText(MyApplication.myApp, "App not installed", 0).show();
                    return;
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
                    return;
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
                    return;
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
                    if (packageinfo != null) {
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
                    }
                } else {
                    Intent spotify = new Intent("tzy_music.MusicService.SelectSpotifyYandex");
                    spotify.setPackage("com.syu.tzy_music");
                    MyApplication.myApp.startService(spotify);
                }
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
            Page_SettingInfo.this.actRadio.jump1stChannel();
            Page_SettingInfo.this.actRadio.initlist(false, false, true);
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

    public void updateAutoSens() {
        if (this.switchHandSens2 != null) {
            this.switchHandSens2.setSwitch(!FmService.mAutoSensitivity);
        }
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
                this.mHandSensOnOff.setText(getString("set_text_on"));
            } else {
                this.mHandSensOnOff.setText(getString("set_text_off"));
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

    public void setDayOrNight(int value) {
        Log.d("ui7", " 0011 Page radio set 6025 setDayOrNight value = " + value);
        if (App_Radio.bUI_NightColour) {
            String str = value > 0 ? "night_" : FinalChip.BSP_PLATFORM_Null;
            getPage().setBackground(getPage().getDrawableFromPath(String.valueOf(str) + "bk_radio", getPage().mDrawables, getPage().mDrawables));
            for (int i = 0; i < this.nightBtn.length; i++) {
                JButton button = (JButton) getPage().getChildViewByid(this.nightBtn[i]);
                if (button != null) {
                    String drawableName = button.getStrDrawable();
                    if (TextUtils.isEmpty(str)) {
                        if (drawableName.startsWith("night_")) {
                            button.setStrDrawable(drawableName.replace("night_", FinalChip.BSP_PLATFORM_Null), true);
                        }
                    } else if (!drawableName.startsWith("night_")) {
                        button.setStrDrawable("night_" + drawableName, true);
                    }
                }
            }
            for (int k = 0; k < this.nightText.length; k++) {
                JText text = (JText) getPage().getChildViewByid(this.nightText[k]);
                if (text != null) {
                    text.setTextColor(value > 0 ? -1 : ViewCompat.MEASURED_STATE_MASK);
                }
            }
            JText text_am = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_AmSensVal);
            text_am.setStrDrawable(String.valueOf(str) + "radio_set_txtbk", true);
            JText text_fm = (JText) getPage().getChildViewByid(FinalRadioCtrl.Set_Txt_FmSensVal);
            text_fm.setStrDrawable(String.valueOf(str) + "radio_set_txtbk", true);
            JSwitchButton switchButton = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_RdsOnOff);
            if (switchButton != null) {
                switchButton.setIconName(new String[]{String.valueOf(str) + "radioset_rds_off", String.valueOf(str) + "radioset_rds_on"});
            }
            JSwitchButton switchButton2 = (JSwitchButton) getPage().getChildViewByid(FinalRadioCtrl.Set_Switch_HandSensOnOff);
            if (switchButton2 != null) {
                switchButton2.setIconName(new String[]{String.valueOf(str) + "radioset_rds_off", String.valueOf(str) + "radioset_rds_on"});
            }
            for (int k2 = 0; k2 < this.nightBox.length; k2++) {
                JCheckBox checkBox = (JCheckBox) getPage().getChildViewByid(this.nightBox[k2]);
                if (checkBox != null) {
                    checkBox.setTextColor(value > 0 ? -1 : ViewCompat.MEASURED_STATE_MASK);
                    checkBox.setIconName(new String[]{String.valueOf(str) + "radio_set_check", String.valueOf(str) + "radio_set_check_p"});
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
        }
    }
}
