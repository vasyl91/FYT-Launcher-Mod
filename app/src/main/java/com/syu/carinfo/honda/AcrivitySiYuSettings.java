package com.syu.carinfo.honda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class AcrivitySiYuSettings extends BaseActivity implements View.OnClickListener {
    int iOilSrvLifePN;
    int iOilSrvLifeUnit;
    int iiOilSrvLife;
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.honda.AcrivitySiYuSettings.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 50:
                    AcrivitySiYuSettings.this.mUpdaterValue2();
                    break;
                case 58:
                    AcrivitySiYuSettings.this.updateTripA();
                    break;
                case 59:
                    AcrivitySiYuSettings.this.updateTripB();
                    break;
                case 60:
                    AcrivitySiYuSettings.this.updateOutTemp();
                    break;
                case 61:
                    AcrivitySiYuSettings.this.updateAutoLightSens();
                    break;
                case 62:
                    AcrivitySiYuSettings.this.updateHeadLessAutoOff();
                    break;
                case 63:
                    AcrivitySiYuSettings.this.updateInteriorLightDimmingTime();
                    break;
                case 64:
                    AcrivitySiYuSettings.this.updateKeyLockAnswer();
                    break;
                case 65:
                    AcrivitySiYuSettings.this.updateKeyAndRemoteUnlockMode();
                    break;
                case 66:
                    AcrivitySiYuSettings.this.updateSecurityRelockTime();
                    break;
                case 67:
                    AcrivitySiYuSettings.this.updateAutoDoorUnLock();
                    break;
                case 68:
                    AcrivitySiYuSettings.this.updateAutoDoorLock();
                    break;
                case 69:
                    AcrivitySiYuSettings.this.updateKeylessAccessBeep();
                    break;
                case 70:
                    AcrivitySiYuSettings.this.updateRemoteStartSys();
                    break;
                case 71:
                    AcrivitySiYuSettings.this.updateDoorUnlockMode();
                    break;
                case 72:
                    AcrivitySiYuSettings.this.updateKeylessAccessLightFlash();
                    break;
                case 73:
                    AcrivitySiYuSettings.this.updateAutoInterIllumination();
                    break;
                case 74:
                    AcrivitySiYuSettings.this.updateAdjustAlarmVolume();
                    break;
                case 75:
                    AcrivitySiYuSettings.this.updateFuelEfficBacklight();
                    break;
                case 76:
                    AcrivitySiYuSettings.this.updateNewMsgNoti();
                    break;
                case 77:
                    AcrivitySiYuSettings.this.updateSpeedDistanceUnit();
                    break;
                case 78:
                    AcrivitySiYuSettings.this.updateTachometer();
                    break;
                case 79:
                    AcrivitySiYuSettings.this.updateWalkAwayAutoLock();
                    break;
                case 80:
                    AcrivitySiYuSettings.this.updateAutoHeadlightWiper();
                    break;
                case 81:
                    AcrivitySiYuSettings.this.updateVolumeAlarmSys();
                    break;
                case 82:
                    AcrivitySiYuSettings.this.updateEnergySaveAutoEnghine();
                    break;
                case 83:
                    AcrivitySiYuSettings.this.updateAccDiscoveryVehicle();
                    break;
                case 84:
                    AcrivitySiYuSettings.this.updatePauseLKADTone();
                    break;
                case 85:
                    AcrivitySiYuSettings.this.updateSetFrontHazardDistance();
                    break;
                case 86:
                    AcrivitySiYuSettings.this.updateMinorLane();
                    break;
                case 87:
                    AcrivitySiYuSettings.this.updateTachometerSet();
                    break;
                case 108:
                    AcrivitySiYuSettings.this.updateKeylessAccessBeepVol();
                    break;
                case 109:
                    AcrivitySiYuSettings.this.updateBackCarBeepTone();
                    break;
                case 110:
                    AcrivitySiYuSettings.this.updateEleDoorRemoteOpenCondition();
                    break;
                case 111:
                    AcrivitySiYuSettings.this.updateEleDoorOpenAutoOrManule();
                    break;
                case 112:
                    AcrivitySiYuSettings.this.updateDrivingPositionRemory();
                    break;
                case 113:
                    AcrivitySiYuSettings.this.updateInOutSeatSport();
                    break;
                case 114:
                    AcrivitySiYuSettings.this.uAttentionMonitor(val);
                    break;
                case 135:
                    AcrivitySiYuSettings.this.uOilSrvLifeUnit(val);
                    break;
                case 136:
                    AcrivitySiYuSettings.this.uOilSrvLifePN(val);
                    break;
                case 137:
                    AcrivitySiYuSettings.this.uOilSrvLife(val);
                    break;
                case 149:
                    AcrivitySiYuSettings.this.uPilao(val);
                    break;
                case 150:
                    AcrivitySiYuSettings.this.uAWD(val);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_298_siyu_settings);
        init();
        setListener();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.honda.AcrivitySiYuSettings.2
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[50] & 255;
                DataCanbus.PROXY.cmd(104, value == 0 ? 1 : 0);
            }
        });
    }

    private void setListener() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext6), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext13), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext14), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext28), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext29), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext30), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus8), this);
        setSelfClick((Button) findViewById(R.id.btn_plus8), this);
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
        setSelfClick(findViewById(R.id.layout_view1), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.btn_minus13 /* 2131427468 */:
                int value4 = DataCanbus.DATA[86];
                int value5 = (value4 - 1) % 3;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(34, value5);
                break;
            case R.id.btn_plus13 /* 2131427470 */:
                int value6 = DataCanbus.DATA[86];
                setCarInfo(34, (value6 + 1) % 3);
                break;
            case R.id.btn_minus14 /* 2131427471 */:
                int value7 = DataCanbus.DATA[114];
                int value8 = value7 - 1;
                if (value8 < 0) {
                    value8 = 2;
                }
                if (DataCanbus.sCanbusId == 983338) {
                    setCarInfo(41, value8);
                    break;
                } else {
                    setCarInfo(36, value8);
                    break;
                }
            case R.id.btn_plus14 /* 2131427473 */:
                int value9 = DataCanbus.DATA[114];
                int value10 = (value9 + 1) % 3;
                if (DataCanbus.sCanbusId == 983338) {
                    setCarInfo(41, value10);
                    break;
                } else {
                    setCarInfo(36, value10);
                    break;
                }
            case R.id.layout_view1 /* 2131427479 */:
                try {
                    Intent ii = new Intent();
                    ii.setClass(this, ActiAMP_Bnr.class);
                    startActivity(ii);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.btn_minus1 /* 2131427480 */:
                int value11 = DataCanbus.DATA[58];
                int value12 = (value11 - 1) % 3;
                if (value12 < 0) {
                    value12 = 2;
                }
                setCarInfo(2, value12);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value13 = DataCanbus.DATA[58];
                setCarInfo(2, (value13 + 1) % 3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value14 = DataCanbus.DATA[59];
                int value15 = (value14 - 1) % 3;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(3, value15);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value16 = DataCanbus.DATA[59];
                setCarInfo(3, (value16 + 1) % 3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value17 = DataCanbus.DATA[60];
                int value18 = (value17 - 1) % 11;
                if (value18 < 0) {
                    value18 = 10;
                }
                setCarInfo(0, value18);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value19 = DataCanbus.DATA[60];
                setCarInfo(0, (value19 + 1) % 11);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value20 = DataCanbus.DATA[61];
                int value21 = (value20 - 1) % 5;
                if (value21 < 0) {
                    value21 = 4;
                }
                setCarInfo(6, value21);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value22 = DataCanbus.DATA[61];
                setCarInfo(6, (value22 + 1) % 5);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value23 = DataCanbus.DATA[62];
                int value24 = (value23 - 1) % 4;
                if (value24 < 0) {
                    value24 = 3;
                }
                setCarInfo(5, value24);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value25 = DataCanbus.DATA[62];
                setCarInfo(5, (value25 + 1) % 4);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value26 = DataCanbus.DATA[63];
                int value27 = (value26 - 1) % 3;
                if (value27 < 0) {
                    value27 = 2;
                }
                setCarInfo(4, value27);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value28 = DataCanbus.DATA[63];
                setCarInfo(4, (value28 + 1) % 3);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value29 = DataCanbus.DATA[66];
                int value30 = (value29 - 1) % 3;
                if (value30 < 0) {
                    value30 = 2;
                }
                setCarInfo(11, value30);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value31 = DataCanbus.DATA[66];
                setCarInfo(11, (value31 + 1) % 3);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                int value32 = DataCanbus.DATA[67];
                int value33 = (value32 - 1) % 4;
                if (value33 < 0) {
                    value33 = 3;
                }
                setCarInfo(8, value33);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                int value34 = DataCanbus.DATA[67];
                setCarInfo(8, (value34 + 1) % 4);
                break;
            case R.id.btn_minus9 /* 2131427513 */:
                int value35 = DataCanbus.DATA[68];
                int value36 = (value35 - 1) % 3;
                if (value36 < 0) {
                    value36 = 2;
                }
                setCarInfo(7, value36);
                break;
            case R.id.btn_plus9 /* 2131427515 */:
                int value37 = DataCanbus.DATA[68];
                setCarInfo(7, (value37 + 1) % 3);
                break;
            case R.id.btn_minus10 /* 2131427517 */:
                int value38 = DataCanbus.DATA[73];
                int value39 = (value38 - 1) % 5;
                if (value39 < 0) {
                    value39 = 4;
                }
                setCarInfo(27, value39);
                break;
            case R.id.btn_plus10 /* 2131427519 */:
                int value40 = DataCanbus.DATA[73];
                setCarInfo(27, (value40 + 1) % 5);
                break;
            case R.id.btn_minus11 /* 2131427521 */:
                int value41 = DataCanbus.DATA[74];
                int value42 = (value41 - 1) % 3;
                if (value42 < 0) {
                    value42 = 2;
                }
                setCarInfo(18, value42);
                break;
            case R.id.btn_plus11 /* 2131427523 */:
                int value43 = DataCanbus.DATA[74];
                setCarInfo(18, (value43 + 1) % 3);
                break;
            case R.id.btn_minus12 /* 2131427525 */:
                int value44 = DataCanbus.DATA[85];
                int value45 = (value44 - 1) % 3;
                if (value45 < 0) {
                    value45 = 2;
                }
                setCarInfo(31, value45);
                break;
            case R.id.btn_plus12 /* 2131427527 */:
                int value46 = DataCanbus.DATA[85];
                setCarInfo(31, (value46 + 1) % 3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value47 = DataCanbus.DATA[64];
                setCarInfo(10, value47 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value48 = DataCanbus.DATA[65];
                setCarInfo(9, value48 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                setCarInfo(12, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value49 = DataCanbus.DATA[69];
                setCarInfo(13, value49 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value50 = DataCanbus.DATA[70];
                setCarInfo(24, value50 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value51 = DataCanbus.DATA[71];
                setCarInfo(25, value51 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value52 = DataCanbus.DATA[72];
                setCarInfo(26, value52 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value53 = DataCanbus.DATA[75];
                setCarInfo(19, value53 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427542 */:
                int value54 = DataCanbus.DATA[76];
                setCarInfo(20, value54 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427543 */:
                int value55 = DataCanbus.DATA[77];
                setCarInfo(21, value55 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427544 */:
                int value56 = DataCanbus.DATA[78];
                setCarInfo(22, value56 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427545 */:
                int value57 = DataCanbus.DATA[79];
                setCarInfo(23, value57 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427546 */:
                int value58 = DataCanbus.DATA[80];
                setCarInfo(28, value58 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427547 */:
                int value59 = DataCanbus.DATA[81];
                setCarInfo(30, value59 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427548 */:
                int value60 = DataCanbus.DATA[82];
                setCarInfo(29, value60 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427647 */:
                int value61 = DataCanbus.DATA[83];
                setCarInfo(32, value61 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427649 */:
                int value62 = DataCanbus.DATA[84];
                setCarInfo(33, value62 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427651 */:
                int value63 = DataCanbus.DATA[87];
                setCarInfo(35, value63 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427653 */:
                if (isBNRSiYuOrGuanDao()) {
                    value3 = DataCanbus.DATA[109] == 0 ? 1 : 0;
                } else {
                    value3 = 0;
                }
                setCarInfo(36, value3);
                break;
            case R.id.ctv_checkedtext21 /* 2131427655 */:
                int value64 = DataCanbus.DATA[110] == 0 ? 1 : 0;
                setCarInfo(37, value64);
                break;
            case R.id.ctv_checkedtext22 /* 2131427657 */:
                int value65 = DataCanbus.DATA[111] == 0 ? 1 : 0;
                setCarInfo(38, value65);
                break;
            case R.id.ctv_checkedtext23 /* 2131427660 */:
                if (isBNRSiYuOrGuanDao()) {
                    value2 = DataCanbus.DATA[112] == 0 ? 1 : 0;
                } else {
                    value2 = 0;
                }
                setCarInfo(39, value2);
                break;
            case R.id.ctv_checkedtext24 /* 2131427832 */:
                if (isBNRSiYuOrGuanDao()) {
                    value = DataCanbus.DATA[113] == 0 ? 1 : 0;
                } else {
                    value = 0;
                }
                setCarInfo(40, value);
                break;
            case R.id.ctv_checkedtext25 /* 2131427834 */:
                setCarInfo(42, DataCanbus.DATA[149] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427836 */:
                setCarInfo(43, DataCanbus.DATA[150] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext29 /* 2131427877 */:
                setCarInfo(15, 0);
                break;
            case R.id.ctv_checkedtext30 /* 2131427886 */:
                setCarInfo(17, 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427892 */:
                setCarInfo(14, 0);
                break;
        }
    }

    private boolean isBNRSiYuOrGuanDao() {
        int canbusId = DataCanbus.DATA[1000];
        switch (canbusId) {
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_L /* 393514 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_Vsceen_H /* 459050 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_NoAmp /* 524586 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Amp_View /* 590122 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_L /* 1048874 */:
            case FinalCanbus.CAR_RZC_HONDA_16Civic_Vsceen_H /* 1114410 */:
            case FinalCanbus.CAR_RZC_HONDA_Crown /* 2031914 */:
            case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
            case FinalCanbus.CAR_BNR_HONDA_16Civic_NoAir /* 2621738 */:
                return true;
            default:
                return false;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(105, value1, value2);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setViewState(findViewById(R.id.layout_view43), 0);
        if (DataCanbus.DATA[1000] == 196906 || DataCanbus.DATA[1000] == 262442) {
            setViewState(findViewById(R.id.layout_view28), 8);
            setViewState(findViewById(R.id.layout_view29), 8);
            setViewState(findViewById(R.id.layout_view30), 8);
            setViewState(findViewById(R.id.layout_view31), 8);
            setViewState((TextView) findViewById(R.id.tv_text20), 0);
        } else {
            setViewState((TextView) findViewById(R.id.tv_text20), 8);
            setViewState(findViewById(R.id.layout_view28), 0);
            setViewState(findViewById(R.id.layout_view29), 0);
            setViewState(findViewById(R.id.layout_view30), 0);
            setViewState(findViewById(R.id.layout_view31), 0);
        }
        if (isGuanDao()) {
            setViewState(findViewById(R.id.layout_view34), 0);
            setViewState(findViewById(R.id.layout_view35), 0);
            setViewState(findViewById(R.id.layout_view36), 0);
            setViewState(findViewById(R.id.layout_view37), 0);
            setViewState(findViewById(R.id.layout_view38), 0);
            setViewState(findViewById(R.id.layout_view43), 8);
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_BNR_HONDA_Avancier_Amp_View /* 590122 */:
                case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
                case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
                case FinalCanbus.CAR_RZC_XP1_22ZRV_H /* 3277098 */:
                    setViewState(findViewById(R.id.layout_view1), 0);
                    break;
                default:
                    setViewState(findViewById(R.id.layout_view1), 8);
                    break;
            }
        } else {
            setViewState(findViewById(R.id.layout_view34), 8);
            setViewState(findViewById(R.id.layout_view35), 8);
            setViewState(findViewById(R.id.layout_view36), 8);
            setViewState(findViewById(R.id.layout_view37), 8);
            setViewState(findViewById(R.id.layout_view38), 8);
            setViewState(findViewById(R.id.layout_view1), 8);
        }
        if (DataCanbus.DATA[1000] == 786730 || DataCanbus.DATA[1000] == 852266 || DataCanbus.DATA[1000] == 1835306 || DataCanbus.DATA[1000] == 1900842 || DataCanbus.DATA[1000] == 2425130 || DataCanbus.DATA[1000] == 2490666 || DataCanbus.DATA[1000] == 2687274 || DataCanbus.DATA[1000] == 2752810) {
            setViewState(findViewById(R.id.layout_view35), 0);
            setViewState(findViewById(R.id.layout_view36), 0);
            setViewState(findViewById(R.id.layout_view11), 0);
            setViewState(findViewById(R.id.layout_view12), 0);
            setViewState(findViewById(R.id.layout_view16), 0);
            setViewState(findViewById(R.id.layout_view22), 0);
            setViewState((TextView) findViewById(R.id.tv_text20), 0);
        } else {
            setViewState(findViewById(R.id.layout_view11), 8);
            setViewState(findViewById(R.id.layout_view12), 8);
            setViewState(findViewById(R.id.layout_view16), 8);
            setViewState(findViewById(R.id.layout_view22), 8);
        }
        if (DataCanbus.sCanbusId == 983338) {
            setViewVisible(findViewById(R.id.layout_view9), true);
            setViewVisible(findViewById(R.id.layout_view11), true);
            setViewVisible(findViewById(R.id.layout_view12), true);
            setViewVisible(findViewById(R.id.layout_view16), true);
            setViewVisible(findViewById(R.id.layout_view39), true);
            setViewVisible(findViewById(R.id.layout_view40), true);
            setViewVisible(findViewById(R.id.layout_view28), false);
            setViewVisible(findViewById(R.id.layout_view29), false);
            setViewVisible(findViewById(R.id.layout_view34), false);
            setViewVisible(findViewById(R.id.layout_view35), true);
            setViewVisible(findViewById(R.id.layout_view36), true);
            setViewVisible(findViewById(R.id.layout_view37), false);
            setViewVisible(findViewById(R.id.layout_view38), false);
            setViewVisible(findViewById(R.id.layout_view43), false);
        } else {
            setViewVisible(findViewById(R.id.layout_view39), false);
            setViewVisible(findViewById(R.id.layout_view40), false);
        }
        addNotify();
    }

    private void setViewState(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    private boolean isGuanDao() {
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_BNR_HONDA_Avancier_NoAmp /* 524586 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Amp_View /* 590122 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_NoAmp /* 655658 */:
            case FinalCanbus.CAR_BNR_HONDA_Avancier_Vsceen_Amp_View /* 721194 */:
            case FinalCanbus.CAR_RZC_HONDA_Crown /* 2031914 */:
            case FinalCanbus.CAR_RZC_HONDA_Crown_H /* 2097450 */:
            case FinalCanbus.CAR_RZC_XP1_22ZRV_H /* 3277098 */:
                return true;
            default:
                return false;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[74].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[75].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[76].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[77].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[79].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[81].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[83].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[84].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[85].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[74].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[75].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[76].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[77].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[78].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[79].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[81].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[83].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[84].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[85].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripA() {
        int value = DataCanbus.DATA[58];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_298_ignite_off);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_298_manually);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text1)).setText(R.string.str_298_refuel);
                    break;
            }
        }
    }

    protected void uAWD(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext26), val != 0);
    }

    protected void uPilao(int val) {
        setCheck((CheckedTextView) findViewById(R.id.ctv_checkedtext25), val != 0);
    }

    protected void uOilSrvLife(int val) {
        this.iiOilSrvLife = val;
        if (((TextView) findViewById(R.id.tv_text20)) != null) {
            String sUnit = this.iOilSrvLifeUnit == 0 ? "Km" : "Mile";
            String sOilPn = this.iOilSrvLifePN == 0 ? "" : "-";
            ((TextView) findViewById(R.id.tv_text20)).setText(String.valueOf(sOilPn) + val + sUnit);
        }
    }

    protected void uAttentionMonitor(int val) {
        switch (val) {
            case 1:
                ((TextView) findViewById(R.id.tv_text18)).setText(R.string.str_298_visual_warning_);
                break;
            case 2:
                ((TextView) findViewById(R.id.tv_text18)).setText(R.string.str_298_tactile_and_visual_warnings);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text18)).setText(R.string.off);
                break;
        }
    }

    protected void uOilSrvLifePN(int val) {
        this.iOilSrvLifePN = val;
        uOilSrvLife(this.iiOilSrvLife);
    }

    protected void uOilSrvLifeUnit(int val) {
        this.iOilSrvLifeUnit = val;
        uOilSrvLife(this.iiOilSrvLife);
    }

    protected void updateInOutSeatSport() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext24)) != null) {
            int value = DataCanbus.DATA[113];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
        }
    }

    protected void updateDrivingPositionRemory() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            int value = DataCanbus.DATA[112];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
        }
    }

    protected void updateEleDoorOpenAutoOrManule() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            int value = DataCanbus.DATA[111];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
        }
    }

    protected void updateEleDoorRemoteOpenCondition() {
        if (((TextView) findViewById(R.id.tv_text19)) != null) {
            int value = DataCanbus.DATA[110];
            ((TextView) findViewById(R.id.tv_text19)).setText(value == 0 ? R.string.str_guandao_remote_open1 : R.string.str_guandao_remote_open2);
        }
    }

    protected void updateBackCarBeepTone() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            int value = DataCanbus.DATA[109];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTripB() {
        int value = DataCanbus.DATA[59];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_ignite_off);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_manually);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text2)).setText(R.string.str_298_refuel);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOutTemp() {
        int value = DataCanbus.DATA[60];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoLightSens() {
        int value = DataCanbus.DATA[61];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text4)).setText("min");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text4)).setText("low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text4)).setText("middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text4)).setText("high");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text4)).setText("max");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[50] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext27)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setChecked(value == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeadLessAutoOff() {
        int value = DataCanbus.DATA[62];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text5)).setText("0s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text5)).setText("15s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text5)).setText("30s");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text5)).setText("60s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInteriorLightDimmingTime() {
        int value = DataCanbus.DATA[63];
        if (((TextView) findViewById(R.id.tv_text6)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text6)).setText("15s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text6)).setText("30s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text6)).setText("60s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyLockAnswer() {
        int value = DataCanbus.DATA[64];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeyAndRemoteUnlockMode() {
        int value = DataCanbus.DATA[65];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSecurityRelockTime() {
        int value = DataCanbus.DATA[66];
        if (((TextView) findViewById(R.id.tv_text7)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text7)).setText("30s");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text7)).setText("60s");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text7)).setText("90s");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoDoorUnLock() {
        int value = DataCanbus.DATA[67];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_298_all_when_driver_door_open);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_298_all_door_when_shifted_to_park);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.str_298_all_when_ignition_switched_off);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoDoorLock() {
        int value = DataCanbus.DATA[68];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_298_vehicle_speed);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.str_298_shift_from_p);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.off);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeylessAccessBeep() {
        int value = DataCanbus.DATA[69];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeylessAccessBeepVol() {
        int value = DataCanbus.DATA[108];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(value == 0 ? R.string.wc_372_low : R.string.wc_372_high);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemoteStartSys() {
        int value = DataCanbus.DATA[70];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDoorUnlockMode() {
        int value = DataCanbus.DATA[71];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateKeylessAccessLightFlash() {
        int value = DataCanbus.DATA[72];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoInterIllumination() {
        int value = DataCanbus.DATA[73];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text12)).setText("min");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text12)).setText("low");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text12)).setText("middle");
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text12)).setText("high");
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text12)).setText("max");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdjustAlarmVolume() {
        int value = DataCanbus.DATA[74];
        if (((TextView) findViewById(R.id.tv_text13)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text13)).setText("hight");
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text13)).setText("middle");
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text13)).setText("low");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFuelEfficBacklight() {
        int value = DataCanbus.DATA[75];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewMsgNoti() {
        int value = DataCanbus.DATA[76];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedDistanceUnit() {
        int value = DataCanbus.DATA[77];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text14)).setText("km/h  km");
        } else {
            ((TextView) findViewById(R.id.tv_text14)).setText("mph  miles");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTachometer() {
        int value = DataCanbus.DATA[78];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWalkAwayAutoLock() {
        int value = DataCanbus.DATA[79];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoHeadlightWiper() {
        int value = DataCanbus.DATA[80];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVolumeAlarmSys() {
        int value = DataCanbus.DATA[81];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text15)).setText("low");
        } else {
            ((TextView) findViewById(R.id.tv_text15)).setText("high");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEnergySaveAutoEnghine() {
        int value = DataCanbus.DATA[82];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAccDiscoveryVehicle() {
        int value = DataCanbus.DATA[83];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePauseLKADTone() {
        int value = DataCanbus.DATA[84];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
    }

    protected void updateSetFrontHazardDistance() {
        int value = DataCanbus.DATA[85];
        if (((TextView) findViewById(R.id.tv_text16)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text16)).setText(R.string.jeep_lanesensewarn_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text16)).setText(R.string.jeep_forwardcollisionwarn_0);
                    break;
            }
        }
    }

    protected void updateMinorLane() {
        int value = DataCanbus.DATA[86];
        if (((TextView) findViewById(R.id.tv_text17)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.jeep_lanesensewarn_1);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_298_wide);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text17)).setText(R.string.str_298_only_warn);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTachometerSet() {
        int value = DataCanbus.DATA[87];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
    }
}
