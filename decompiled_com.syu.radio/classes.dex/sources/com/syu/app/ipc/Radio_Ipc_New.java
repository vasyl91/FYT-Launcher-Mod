package com.syu.app.ipc;

import android.util.Log;
import com.lsec.core.frame.app.MyApplication;
import com.lsec.core.ipc.Conn;
import com.lsec.core.ipc.ConnSys;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc.module.main.RadioM;
import com.lsec.core.ipc.module.sys.Locate;
import com.lsec.core.util.IUiNotify;
import com.lsec.core.util.IpcUtil;
import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;
import com.syu.radio.data.FinalRadioCtrl;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Radio_Ipc_New {
    static final int[] NOTIFYCODE_Radio = {0, 3, 1, 16, 15, 9, 6, 5, 7, 8, 26, 13, 14, 20, 21, 22, 23};
    static final int[] NOTIFYCODE_Set = {2, 17, 18, 19, 15};
    public Conn mConn = null;
    public ConnSys mConnSys = null;
    public Radio_Ipc_NewNotifyPage mNotify = new Radio_Ipc_NewNotifyPage();
    private IUiNotify notify_Main = new IUiNotify() { // from class: com.syu.app.ipc.Radio_Ipc_New.1
        boolean bAppIdThirdPlayerBak = false;
        boolean bAppIdRadioBak = false;
        boolean bAccOnBak = false;

        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) throws Throwable {
            switch (updateCode) {
                case 0:
                    boolean bAppIdRadio = Radio_Ipc_New.isAppIdRadio();
                    if (this.bAppIdRadioBak != bAppIdRadio) {
                        if (!bAppIdRadio) {
                            App_Radio.mDatas[0] = -1;
                            switch (App_Radio.iRadioType_Arm) {
                                case 1:
                                case 2:
                                    App_Radio.getInstance().Radio6025_PowerOff();
                                    break;
                                case 3:
                                    App_Radio.getInstance().RadioSophia_PowerOff();
                                    break;
                            }
                        } else if (App_Radio.iRadioType_Arm > 0) {
                            App_Radio.getInstance().handleRightAppId();
                        }
                        this.bAppIdRadioBak = bAppIdRadio;
                    }
                    break;
                case 4:
                    if (IpcUtil.intsOk(ints, 1)) {
                        Log.d("gdy10", " **  onNotify U_LAMPLET ints[0] = " + ints[0]);
                        App_Radio.mNightDay = ints[0];
                        App_Radio.getInstance().setDayOrNight(ints[0]);
                    }
                    break;
                case 50:
                    if (IpcUtil.intsOk(ints, 1)) {
                        boolean bAccOn = ints[0] != 0;
                        if (this.bAccOnBak != bAccOn) {
                            if (ints[0] == 0) {
                                App_Radio.getInstance().saveSet();
                            }
                            this.bAccOnBak = bAccOn;
                            if (!bAccOn) {
                                switch (App_Radio.iRadioType_Arm) {
                                    case 1:
                                    case 2:
                                        App_Radio.getInstance().Radio6025_PowerOff();
                                        break;
                                    case 3:
                                        App_Radio.getInstance().RadioSophia_PowerOff();
                                        break;
                                }
                            } else {
                                if (App_Radio.iRadioType_Arm > 0) {
                                    App_Radio.getInstance().handleRightAppId();
                                }
                                break;
                            }
                        }
                    }
                    break;
                case 60:
                    if (IpcUtil.intsOk(ints, 1) && App_Radio.getInstance().isAppTop()) {
                        switch (ints[0]) {
                            case 0:
                                if (App_Radio.isKeyRoll_NotFocus) {
                                    Radio_Ipc_New.this.Band();
                                } else {
                                    for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                                        if (interfaceRadio.isTop()) {
                                            interfaceRadio.scrollOk();
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                for (Interface_Radio interfaceRadio2 : App_Radio.mInterfaceRadio) {
                                    if (interfaceRadio2.isTop()) {
                                        interfaceRadio2.onKeyUp();
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                for (Interface_Radio interfaceRadio3 : App_Radio.mInterfaceRadio) {
                                    if (interfaceRadio3.isTop()) {
                                        interfaceRadio3.onKeyDown();
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                for (Interface_Radio interfaceRadio4 : App_Radio.mInterfaceRadio) {
                                    if (interfaceRadio4.isTop()) {
                                        interfaceRadio4.onKeyLeft();
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                for (Interface_Radio interfaceRadio5 : App_Radio.mInterfaceRadio) {
                                    if (interfaceRadio5.isTop()) {
                                        interfaceRadio5.onKeyRight();
                                        break;
                                    }
                                }
                                break;
                            case 5:
                                if (App_Radio.isKeyRoll_NotFocus) {
                                    Radio_Ipc_New.this.Prev_Channel();
                                } else {
                                    for (Interface_Radio interfaceRadio6 : App_Radio.mInterfaceRadio) {
                                        if (interfaceRadio6.isTop()) {
                                            interfaceRadio6.scrollToPrev();
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 6:
                                if (App_Radio.isKeyRoll_NotFocus) {
                                    Radio_Ipc_New.this.Next_Channel();
                                } else {
                                    for (Interface_Radio interfaceRadio7 : App_Radio.mInterfaceRadio) {
                                        if (interfaceRadio7.isTop()) {
                                            interfaceRadio7.scrollToNext();
                                            break;
                                        }
                                    }
                                }
                                break;
                        }
                    }
                    break;
                case 61:
                    if (IpcUtil.intsOk(ints, 1) && ints[0] != -1) {
                        App_Radio.getInstance().saveSet();
                        break;
                    }
                    break;
            }
        }
    };
    private IUiNotify notify_Radio = new IUiNotify() { // from class: com.syu.app.ipc.Radio_Ipc_New.2
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            if (Radio_Ipc_New.this.getRightAppId() == 1) {
                for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                    interfaceRadio.onNotify(updateCode, ints, flts, strs);
                }
            }
        }
    };
    private IUiNotify notify_Sys = new IUiNotify() { // from class: com.syu.app.ipc.Radio_Ipc_New.3
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) throws Throwable {
            switch (updateCode) {
                case 0:
                    if (IpcUtil.strsOk(strs, 1) && MyApplication.myApp.getPackageName().equals(strs[0])) {
                        App_Radio.getInstance().saveSet();
                        App_Radio.getInstance().mIpcObj.requestAppIdNull();
                        switch (App_Radio.iRadioType_Arm) {
                            case 1:
                            case 2:
                                App_Radio.getInstance().Radio6025_PowerOff();
                                App_Radio.getInstance().Radio6025_PowerOffQuickly();
                                break;
                            case 3:
                                App_Radio.getInstance().RadioSophia_PowerOff();
                                break;
                        }
                    }
                    break;
            }
        }
    };
    private IUiNotify notify_Location = new IUiNotify() { // from class: com.syu.app.ipc.Radio_Ipc_New.4
        @Override // com.lsec.core.util.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Log.d("logg", " 11 Radio_Ipc_New   Locate.mCity = " + Locate.mCity + " App_Radio.mCity = " + App_Radio.mCity);
                    if (Locate.mCity != null && !Locate.mCity.equals(App_Radio.mCity)) {
                        String strLocale = Locale.getDefault().toString();
                        Log.d("logg", " 22 Radio_Ipc_New   strLocale = " + strLocale + " App_Radio.mCity = " + App_Radio.mCity);
                        if (strLocale.indexOf("zh_CN") >= 0 || App_Radio.bRuRadioName) {
                            if (Locate.mCity.indexOf("市") < 0 && Locate.mCity.indexOf("盟") < 0 && Locate.mCity.indexOf("旗") < 0) {
                                Locate.mCity = String.valueOf(Locate.mCity) + "市";
                            }
                            App_Radio.mCity = Locate.mCity;
                            Log.d("logg", " 33 Radio_Ipc_New    App_Radio.mCity = " + App_Radio.mCity);
                            for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                                interfaceRadio.initlist(false, false, true);
                            }
                        }
                        break;
                    }
                    break;
            }
        }
    };

    public void initIpc() {
        MyApplication.mListUiNotify_Main.add(this.notify_Main);
        MyApplication.mListUiNotify_Radio.add(this.notify_Radio);
        MyApplication.mListUiNotify_Location.add(this.notify_Location);
        MyApplication.mListUiNotify_Sys.add(this.notify_Sys);
    }

    public boolean isRightAppId() {
        Log.d("gdy1", " 02 radio  isRightAppId mConf_PlatForm = " + Main.mConf_PlatForm);
        if (Main.mConf_PlatForm == 1) {
            return true;
        }
        Log.d("gdy1", " 03 radio  isRightAppId getRightAppId() = " + getRightAppId());
        return Main.DATA[0] == getRightAppId();
    }

    public boolean isPtyValid() {
        return RadioM.DATA[5] >= 0 && RadioM.DATA[5] < RadioM.PTY_Display.length;
    }

    public void requestAppIdRight() {
        Log.d("gdy1", " 33 radio MyService requestAppIdRight getRightAppId" + getRightAppId());
        Main.requestAppIdByOnTop(getRightAppId());
    }

    public void requestAppIdNull() {
        if (isRightAppId()) {
            Main.requestAppId(0);
        }
    }

    public static boolean isAppIdThirdPlayer() {
        if (Main.mConf_PlatForm == 1) {
            return true;
        }
        if (Main.sAppIdRequest == 10 && App_Radio.getInstance().isAppTop()) {
            return true;
        }
        return Main.sAppIdRequest == Main.DATA[0] && Main.DATA[0] == 10;
    }

    public static boolean isAppIdRadio() {
        return Main.mConf_PlatForm == 1 || Main.DATA[0] == 1;
    }

    public int getBandAmBegin() {
        return 0;
    }

    public int getChannelAmBegin() {
        return 0;
    }

    public int getBandFmBegin() {
        return 65536;
    }

    public int getChannelFmBegin() {
        return 65536;
    }

    public int getRightAppId() {
        return 1;
    }

    public int getArea() {
        return RadioM.DATA[2];
    }

    public int getRdsEnable() {
        return RadioM.DATA[15];
    }

    public int getAutoSensity() {
        return RadioM.DATA[19];
    }

    public String getPtyStr() {
        return RadioM.PTY_Display[RadioM.DATA[5]];
    }

    public int getBand() {
        return RadioM.DATA[0];
    }

    public int getCurrentFreq() {
        return RadioM.DATA[1];
    }

    public int[] getFreqAm() {
        return RadioM.FREQ_AM;
    }

    public int[] getFreqFm() {
        return RadioM.FREQ_FM;
    }

    public void setArea(int iArea) {
        RadioM.PROXY.cmd(12, iArea);
    }

    public void amSens_plus() {
        RadioM.PROXY.cmd(14, 0, -1);
    }

    public void amSens_minus() {
        RadioM.PROXY.cmd(14, 0, -2);
    }

    public void fmSens_plus() {
        RadioM.PROXY.cmd(14, 1, -1);
    }

    public void fmSens_minus() {
        RadioM.PROXY.cmd(14, 1, -2);
    }

    public void setFreq(int iFreq) {
        Log.d("gdy11", " 11 Ipc new setFreq  iFreq = " + iFreq);
        RadioM.PROXY.cmd(13, 3, iFreq);
    }

    public void freqPlus() {
        RadioM.PROXY.cmd(3);
    }

    public void freqMinus() {
        RadioM.PROXY.cmd(4);
    }

    public void Search() {
        RadioM.PROXY.cmd(22, 2);
    }

    public void switchAfEnable() {
        RadioM.PROXY.cmd(20, 2);
    }

    public void switchTaEnable() {
        RadioM.PROXY.cmd(19, 2);
    }

    public void switchPtyEnable() {
        RadioM.PROXY.cmd(21, 2);
    }

    public void scan() {
        RadioM.PROXY.cmd(9);
    }

    public void save() {
        RadioM.PROXY.cmd(10);
    }

    public void Band() {
        RadioM.PROXY.cmd(11, -1);
    }

    public void FmBand(int value) {
        RadioM.PROXY.cmd(11, 65536 + value);
    }

    public void AmBand(int value) {
        RadioM.PROXY.cmd(11, value);
    }

    public void SFmBand() {
        RadioM.PROXY.cmd(11, -3);
    }

    public void SAmBand() {
        RadioM.PROXY.cmd(11, -2);
    }

    public void Loc() {
        RadioM.PROXY.cmd(18, 2);
    }

    public void ST() {
        RadioM.PROXY.cmd(17, 2);
    }

    public void SeekUp() {
        RadioM.PROXY.cmd(5);
    }

    public void SeekDown() {
        RadioM.PROXY.cmd(6);
    }

    public void defaultSet() {
        RadioM.PROXY.cmd(15, 1);
        RadioM.PROXY.cmd(16, 0);
        RadioM.PROXY.cmd(12, 2);
    }

    public void SetStandBy() {
        Main.PROXY.cmd(18, 1);
    }

    public void switchRdsOnOff(boolean bCheck) {
        if (bCheck) {
            RadioM.PROXY.cmd(16, 1);
        } else {
            RadioM.PROXY.cmd(16, 0);
        }
    }

    public void switchHandSensOnOff(boolean bCheck) {
        if (bCheck) {
            RadioM.PROXY.cmd(15, 0);
        } else {
            RadioM.PROXY.cmd(15, 1);
        }
    }

    public void saveChannel(int band, int index) {
        if (band >= 0 && band < 2) {
            int indexFix = index + ((band + 0) * 6);
            RadioM.PROXY.cmd(8, indexFix + 0);
        } else if (band >= 65536 && band < 65539) {
            int indexFix2 = index + ((band - 65536) * 6);
            RadioM.PROXY.cmd(8, 65536 + indexFix2);
        }
    }

    public void SelectChannel(int band, int id) {
        if (band >= 0 && band < 2) {
            int indexFix = (id - FinalRadioCtrl.Radio_Btn_Freq1) + ((band + 0) * 6);
            RadioM.PROXY.cmd(7, indexFix + 0);
        } else if (band >= 65536 && band < 65539) {
            int indexFix2 = (id - FinalRadioCtrl.Radio_Btn_Freq1) + ((band - 65536) * 6);
            RadioM.PROXY.cmd(7, 65536 + indexFix2);
        }
    }

    public void Prev_Channel() {
        RadioM.PROXY.cmd(1);
    }

    public void Next_Channel() {
        Log.d("gdy11", " 33 radio Radio_Ipc_New Next_Channel   ");
        RadioM.PROXY.cmd(0);
    }

    public void updateNotify_Radio() {
        for (int updateCode : NOTIFYCODE_Radio) {
            this.notify_Radio.onNotify(updateCode, null, null, null);
        }
    }

    public void updateNotify_Set() {
        for (int updateCode : NOTIFYCODE_Set) {
            this.notify_Radio.onNotify(updateCode, null, null, null);
        }
    }
}
