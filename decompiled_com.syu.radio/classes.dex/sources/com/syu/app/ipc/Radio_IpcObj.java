package com.syu.app.ipc;

import android.util.Log;
import android.util.SparseArray;
import com.android.fmradio.FmService;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.frame.ctrl.JButton;
import com.lsec.core.frame.ctrl.JText;
import com.lsec.core.frame.ctrl.JView;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.App_Radio;
import com.syu.radio.ctrl.JFreqBand;
import com.syu.radio.ctrl.JFreqLineRuler;
import com.syu.radio.ctrl.JFreqRoundRuler;
import com.syu.radio.ctrl.JRulerView;
import com.syu.radio.page.Page_Radio;
import com.syu.radio.page.Page_Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Radio_IpcObj {
    public static SparseArray<String> updateMap;
    Radio_Ipc_New mIpc_New = new Radio_Ipc_New();
    public static String mTextHZ = "MHZ";
    public static int mFreq_for_db = -1;
    public static int mIndex_for_db = -1;
    public static boolean mIsAdd_for_db = true;

    public void handleExtraFreqInfo(JFreqRoundRuler freqRoundRuler) {
        freqRoundRuler.setup(RadioM.sFreqMin, RadioM.sFreqMax, RadioM.sFreqStepLen, RadioM.sFreqStepCnt);
    }

    public void handleExtraFreqInfo(JFreqLineRuler freqLineRuler) {
        freqLineRuler.setup(RadioM.sFreqMin, RadioM.sFreqMax, RadioM.sFreqStepLen, RadioM.sFreqStepCnt);
    }

    public void handleExtraFreqInfo(JRulerView rulerView) {
        rulerView.setup(RadioM.DATA[1], RadioM.sFreqMin, RadioM.sFreqMax, RadioM.sFreqStepLen);
    }

    public String getPsText() {
        return RadioM.sPsText;
    }

    public String getRdsText() {
        return RadioM.sRdsText;
    }

    public void updateNotify_Radio() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.updateNotify_Radio();
        }
    }

    public void updateNotify_Set() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.updateNotify_Set();
        }
    }

    public void initIpc() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.initIpc();
        }
    }

    public int updateChannelText(JText txtChannel, JFreqBand bandChannel) {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        int iIndexBtn = this.mIpc_New.mNotify.updateChannelText(txtChannel, bandChannel);
        return iIndexBtn;
    }

    public void updatePtyText(JText txtPty) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.mNotify.updatePtyText(txtPty);
        }
    }

    public int getTAOn_Visibility() {
        if (MyApplication.mIsOldService) {
            return 8;
        }
        int visibility = this.mIpc_New.mNotify.getTAOn_Visibility();
        return visibility;
    }

    public int getAFOn_Visibility() {
        if (MyApplication.mIsOldService) {
            return 8;
        }
        int visibility = this.mIpc_New.mNotify.getAFOn_Visibility();
        return visibility;
    }

    public int getArea() {
        switch (App_Radio.iRadioType_Arm) {
            case 1:
            case 2:
            case 3:
                int iArea = FmService.getCurrentArea();
                return iArea;
            default:
                if (MyApplication.mIsOldService) {
                    return 0;
                }
                int iArea2 = this.mIpc_New.getArea();
                return iArea2;
        }
    }

    public int getRdsEnable() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        int iRdsEnable = this.mIpc_New.getRdsEnable();
        return iRdsEnable;
    }

    public int getAutoSensity() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        int iAutoSensity = this.mIpc_New.getAutoSensity();
        return iAutoSensity;
    }

    public int getFocusCheckBoxId() {
        if (MyApplication.mIsOldService) {
            return -1;
        }
        int id = this.mIpc_New.mNotify.getFocusCheckBoxId();
        return id;
    }

    public void setArea(int iArea) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.setArea(iArea);
        }
    }

    public void defaultSet() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.defaultSet();
        }
    }

    public void amSens_plus() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.amSens_plus();
        }
    }

    public void amSens_minus() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.amSens_minus();
        }
    }

    public void fmSens_plus() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.fmSens_plus();
        }
    }

    public void fmSens_minus() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.fmSens_minus();
        }
    }

    public void switchRdsOnOff(boolean bCheck) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.switchRdsOnOff(bCheck);
        }
    }

    public void switchHandSensOnOff(boolean bCheck) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.switchHandSensOnOff(bCheck);
        }
    }

    public void getSTSCAN_Visibility(int[] visibility) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.mNotify.getSTSCAN_Visibility(visibility);
        }
    }

    public int getLoc_Visibility() {
        if (MyApplication.mIsOldService) {
            return 8;
        }
        int visibility = this.mIpc_New.mNotify.getLoc_Visibility();
        return visibility;
    }

    public int getTA_Visibility() {
        if (MyApplication.mIsOldService) {
            return 8;
        }
        int visibility = this.mIpc_New.mNotify.getTA_Visibility();
        return visibility;
    }

    public int getTP_Visibility() {
        if (MyApplication.mIsOldService) {
            return 8;
        }
        int visibility = this.mIpc_New.mNotify.getTP_Visibility();
        return visibility;
    }

    public boolean getRdsDisplay() {
        if (MyApplication.mIsOldService) {
            return false;
        }
        boolean bRdsDisplay = this.mIpc_New.mNotify.getRdsDisplay();
        return bRdsDisplay;
    }

    public boolean isPtyValid() {
        if (MyApplication.mIsOldService) {
            return false;
        }
        boolean bValid = this.mIpc_New.isPtyValid();
        return bValid;
    }

    public String getPtyStr() {
        return !MyApplication.mIsOldService ? this.mIpc_New.getPtyStr() : FinalChip.BSP_PLATFORM_Null;
    }

    public int getBand() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        int iBand = this.mIpc_New.getBand();
        return iBand;
    }

    public int getBandAmBegin() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        int iBandAmBegin = this.mIpc_New.getBandAmBegin();
        return iBandAmBegin;
    }

    public int getChannelAmBegin() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        int iChannelAmBegin = this.mIpc_New.getChannelAmBegin();
        return iChannelAmBegin;
    }

    public int[] getFreqAm() {
        if (MyApplication.mIsOldService) {
            return null;
        }
        return this.mIpc_New.getFreqAm();
    }

    public int[] getFreqFm() {
        if (MyApplication.mIsOldService) {
            return null;
        }
        return this.mIpc_New.getFreqFm();
    }

    public int getBandFmBegin() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        return this.mIpc_New.getBandFmBegin();
    }

    public int getChannelFmBegin() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        return this.mIpc_New.getChannelFmBegin();
    }

    public int getRightAppId() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        return this.mIpc_New.getRightAppId();
    }

    public void requestAppIdRight() {
        if (App_Radio.bFocus) {
            Log.d("gdy1", " 33 radio MyService requestAppIdRight = " + Main.DATA[0]);
            if (!MyApplication.mIsOldService) {
                this.mIpc_New.requestAppIdRight();
            }
        }
    }

    public boolean isRightAppId() {
        Log.d("gdy1", " 01 radio  isRightAppId U_APP_ID = " + Main.DATA[0]);
        if (MyApplication.mIsOldService) {
            return false;
        }
        return this.mIpc_New.isRightAppId();
    }

    public void requestAppIdNull() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.requestAppIdNull();
        }
    }

    public void SeekUp() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.SeekUp();
        }
    }

    public void SeekDown() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.SeekDown();
        }
    }

    public void saveChannel(int band, int index) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.saveChannel(band, index);
        }
    }

    public void SelectChannel(int band, int id) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.SelectChannel(band, id);
        }
    }

    public void Prev_Channel() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.Prev_Channel();
        }
    }

    public void Next_Channel() {
        Log.d("gdy11", " 22 radio Radio_IpcObj Next_Channel  mIsOldService = " + MyApplication.mIsOldService);
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.Next_Channel();
        }
    }

    public void setFreq(int iFreq) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.setFreq(iFreq);
        }
    }

    public void freqPlus() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.freqPlus();
        }
    }

    public void freqMinus() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.freqMinus();
        }
    }

    public boolean updateHiLightBtn(JButton btn, JView view, int freq, int indexSelect) {
        if (MyApplication.mIsOldService) {
            return false;
        }
        return this.mIpc_New.mNotify.updateHiLightBtn(btn, view, freq, indexSelect);
    }

    public void Search() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.Search();
        }
    }

    public void switchAfEnable() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.switchAfEnable();
        }
    }

    public void switchTaEnable() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.switchTaEnable();
        }
    }

    public void switchPtyEnable() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.switchPtyEnable();
        }
    }

    public void scan() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.scan();
        }
    }

    public void save() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.save();
        }
    }

    public void Band() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.Band();
        }
    }

    public void FmBand(int value) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.FmBand(value);
        }
    }

    public void AmBand(int value) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.AmBand(value);
        }
    }

    public void SFmBand() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.SFmBand();
        }
    }

    public void SAmBand() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.SAmBand();
        }
    }

    public void Loc() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.Loc();
        }
    }

    public void ST() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.ST();
        }
    }

    public void SetStandBy() {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.SetStandBy();
        }
    }

    public int getCurrentFreq() {
        if (MyApplication.mIsOldService) {
            return 0;
        }
        return this.mIpc_New.getCurrentFreq();
    }

    public void onNotify(Page_Radio radioPage_Radio, int updateCode, int[] ints, float[] flts, String[] strs) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.mNotify.onNotify(radioPage_Radio, updateCode, ints, flts, strs);
        }
    }

    public void onNotify(Page_Set radioPage_Set, int updateCode, int[] ints, float[] flts, String[] strs) {
        if (!MyApplication.mIsOldService) {
            this.mIpc_New.mNotify.onNotify(radioPage_Set, updateCode, ints, flts, strs);
        }
    }
}
