package com.android.fmradio;

import com.syu.radio.App_Radio;
import com.syu.radio.Interface_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Runnable_RdsHandle implements Runnable {
    public static final int RDS_CMD_NONE = -1;
    public static final int RDS_CMD_NOTIFY_AF_CONFIG = 8;
    public static final int RDS_CMD_NOTIFY_AF_SWITCH = 9;
    public static final int RDS_CMD_NOTIFY_PI_Seeking = 5;
    public static final int RDS_CMD_NOTIFY_PSNAME = 10;
    public static final int RDS_CMD_NOTIFY_PTY_CONFIG = 7;
    public static final int RDS_CMD_NOTIFY_PTY_Seeking = 4;
    public static final int RDS_CMD_NOTIFY_PTY_TYPE = 2;
    public static final int RDS_CMD_NOTIFY_TA_CONFIG = 6;
    public static final int RDS_CMD_NOTIFY_TA_STATE = 1;
    public static final int RDS_CMD_NOTIFY_TA_Seeking = 3;
    public static final int RDS_CMD_NOTIFY_TEXT = 11;
    public static final int RDS_CMD_NOTIFY_TP_STATE = 0;
    int mD0;
    int mD1;
    int mD2;
    int mID;

    public Runnable_RdsHandle(int ID, int data0, int data1, int data2) {
        this.mID = ID;
        this.mD0 = data0;
        this.mD1 = data1;
        this.mD2 = data2;
    }

    @Override // java.lang.Runnable
    public void run() {
        switch (this.mID) {
            case 0:
                for (Interface_Radio interfaceRadio : App_Radio.mInterfaceRadio) {
                    interfaceRadio.showTp();
                }
                break;
            case 1:
                for (Interface_Radio interfaceRadio2 : App_Radio.mInterfaceRadio) {
                    interfaceRadio2.showTa();
                }
                break;
            case 2:
                FmService.mPtyConf = this.mD0;
                for (Interface_Radio interfaceRadio3 : App_Radio.mInterfaceRadio) {
                    interfaceRadio3.showPty();
                }
                break;
            case 6:
                FmService.mTaOnVisibility = this.mD0;
                for (Interface_Radio interfaceRadio4 : App_Radio.mInterfaceRadio) {
                    interfaceRadio4.showTaOn();
                }
                break;
            case 7:
                FmService.mPtyConf = this.mD0;
                for (Interface_Radio interfaceRadio5 : App_Radio.mInterfaceRadio) {
                    interfaceRadio5.showPty();
                }
                break;
            case 8:
                FmService.mAfOnVisibility = this.mD0;
                for (Interface_Radio interfaceRadio6 : App_Radio.mInterfaceRadio) {
                    interfaceRadio6.showAfOn();
                }
                break;
            case 9:
                FmStation.saveCurrentStation(this.mD0);
                for (Interface_Radio interfaceRadio7 : App_Radio.mInterfaceRadio) {
                    interfaceRadio7.refreshStationUI();
                }
                break;
            case 10:
                for (Interface_Radio interfaceRadio8 : App_Radio.mInterfaceRadio) {
                    interfaceRadio8.showPs();
                }
                break;
            case 11:
                for (Interface_Radio interfaceRadio9 : App_Radio.mInterfaceRadio) {
                    interfaceRadio9.showRds();
                }
                break;
        }
    }
}
