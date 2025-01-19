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

public class AcrivitySiYuSettings extends BaseActivity implements View.OnClickListener {
    int iOilSrvLifePN;
    int iOilSrvLifeUnit;
    int iiOilSrvLife;
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 119:
                    AcrivitySiYuSettings.this.updateTripA();
                    break;
                case 120:
                    AcrivitySiYuSettings.this.updateTripB();
                    break;
                case 121:
                    AcrivitySiYuSettings.this.updateOutTemp();
                    break;
                case 122:
                    AcrivitySiYuSettings.this.updateAutoLightSens();
                    break;
                case 123:
                    AcrivitySiYuSettings.this.updateHeadLessAutoOff();
                    break;
                case 124:
                    AcrivitySiYuSettings.this.updateInteriorLightDimmingTime();
                    break;
                case 125:
                    AcrivitySiYuSettings.this.updateKeyLockAnswer();
                    break;
                case 126:
                    AcrivitySiYuSettings.this.updateKeyAndRemoteUnlockMode();
                    break;
                case 127:
                    AcrivitySiYuSettings.this.updateSecurityRelockTime();
                    break;
                case 128:
                    AcrivitySiYuSettings.this.updateAutoDoorUnLock();
                    break;
                case 129:
                    AcrivitySiYuSettings.this.updateAutoDoorLock();
                    break;
                case 130:
                    AcrivitySiYuSettings.this.updateKeylessAccessBeep();
                    break;
                case 131:
                    AcrivitySiYuSettings.this.updateRemoteStartSys();
                    break;
                case 132:
                    AcrivitySiYuSettings.this.updateDoorUnlockMode();
                    break;
                case 133:
                    AcrivitySiYuSettings.this.updateKeylessAccessLightFlash();
                    break;
                case 134:
                    AcrivitySiYuSettings.this.updateAutoInterIllumination();
                    break;
                case 135:
                    AcrivitySiYuSettings.this.updateAdjustAlarmVolume();
                    break;
                case 136:
                    AcrivitySiYuSettings.this.updateFuelEfficBacklight();
                    break;
                case 137:
                    AcrivitySiYuSettings.this.updateNewMsgNoti();
                    break;
                case 138:
                    AcrivitySiYuSettings.this.updateSpeedDistanceUnit();
                    break;
                case 139:
                    AcrivitySiYuSettings.this.updateTachometer();
                    break;
                case 140:
                    AcrivitySiYuSettings.this.updateWalkAwayAutoLock();
                    break;
                case 141:
                    AcrivitySiYuSettings.this.updateAutoHeadlightWiper();
                    break;
                case 142:
                    AcrivitySiYuSettings.this.updateVolumeAlarmSys();
                    break;
                case 143:
                    AcrivitySiYuSettings.this.updateEnergySaveAutoEnghine();
                    break;
                case 144:
                    AcrivitySiYuSettings.this.updateAccDiscoveryVehicle();
                    break;
                case 145:
                    AcrivitySiYuSettings.this.updatePauseLKADTone();
                    break;
                case 146:
                    AcrivitySiYuSettings.this.updateSetFrontHazardDistance();
                    break;
                case 147:
                    AcrivitySiYuSettings.this.updateMinorLane();
                    break;
                case 148:
                    AcrivitySiYuSettings.this.updateTachometerSet();
                    break;
                case 150:
                    AcrivitySiYuSettings.this.mUpdaterValue2();
                    break;
                case 152:
                    AcrivitySiYuSettings.this.updateKeylessAccessBeepVol();
                    break;
                case 153:
                    AcrivitySiYuSettings.this.updateBackCarBeepTone();
                    break;
                case 154:
                    AcrivitySiYuSettings.this.updateEleDoorRemoteOpenCondition();
                    break;
                case 155:
                    AcrivitySiYuSettings.this.updateEleDoorOpenAutoOrManule();
                    break;
                case 156:
                    AcrivitySiYuSettings.this.updateDrivingPositionRemory();
                    break;
                case 157:
                    AcrivitySiYuSettings.this.updateInOutSeatSport();
                    break;
                case 158:
                    AcrivitySiYuSettings.this.uAttentionMonitor(val);
                    break;
                case 179:
                    AcrivitySiYuSettings.this.uOilSrvLifeUnit(val);
                    break;
                case 180:
                    AcrivitySiYuSettings.this.uOilSrvLifePN(val);
                    break;
                case 181:
                    AcrivitySiYuSettings.this.uOilSrvLife(val);
                    break;
                case 193:
                    AcrivitySiYuSettings.this.uPilao(val);
                    break;
                case 194:
                    AcrivitySiYuSettings.this.uAWD(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_298_siyu_settings);
        init();
        setListener();
    }

    @Override
    public void init() {
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                int value = DataCanbus.DATA[150] & 255;
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

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value4 = DataCanbus.DATA[119];
                int value5 = (value4 - 1) % 3;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(2, value5);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value6 = DataCanbus.DATA[119];
                setCarInfo(2, (value6 + 1) % 3);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value7 = DataCanbus.DATA[120];
                int value8 = (value7 - 1) % 3;
                if (value8 < 0) {
                    value8 = 2;
                }
                setCarInfo(3, value8);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value9 = DataCanbus.DATA[120];
                setCarInfo(3, (value9 + 1) % 3);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value10 = DataCanbus.DATA[121];
                int value11 = (value10 - 1) % 11;
                if (value11 < 0) {
                    value11 = 10;
                }
                setCarInfo(0, value11);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value12 = DataCanbus.DATA[121];
                setCarInfo(0, (value12 + 1) % 11);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value13 = DataCanbus.DATA[122];
                int value14 = (value13 - 1) % 5;
                if (value14 < 0) {
                    value14 = 4;
                }
                setCarInfo(6, value14);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value15 = DataCanbus.DATA[122];
                setCarInfo(6, (value15 + 1) % 5);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value16 = DataCanbus.DATA[123];
                int value17 = (value16 - 1) % 4;
                if (value17 < 0) {
                    value17 = 3;
                }
                setCarInfo(5, value17);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value18 = DataCanbus.DATA[123];
                setCarInfo(5, (value18 + 1) % 4);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value19 = DataCanbus.DATA[124];
                int value20 = (value19 - 1) % 3;
                if (value20 < 0) {
                    value20 = 2;
                }
                setCarInfo(4, value20);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value21 = DataCanbus.DATA[124];
                setCarInfo(4, (value21 + 1) % 3);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value22 = DataCanbus.DATA[127];
                int value23 = (value22 - 1) % 3;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(11, value23);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value24 = DataCanbus.DATA[127];
                setCarInfo(11, (value24 + 1) % 3);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value25 = DataCanbus.DATA[128];
                int value26 = (value25 - 1) % 4;
                if (value26 < 0) {
                    value26 = 3;
                }
                setCarInfo(8, value26);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value27 = DataCanbus.DATA[128];
                setCarInfo(8, (value27 + 1) % 4);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value28 = DataCanbus.DATA[129];
                int value29 = (value28 - 1) % 3;
                if (value29 < 0) {
                    value29 = 2;
                }
                setCarInfo(7, value29);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value30 = DataCanbus.DATA[129];
                setCarInfo(7, (value30 + 1) % 3);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value31 = DataCanbus.DATA[134];
                int value32 = (value31 - 1) % 5;
                if (value32 < 0) {
                    value32 = 4;
                }
                setCarInfo(27, value32);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value33 = DataCanbus.DATA[134];
                setCarInfo(27, (value33 + 1) % 5);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                int value34 = DataCanbus.DATA[135];
                int value35 = (value34 - 1) % 3;
                if (value35 < 0) {
                    value35 = 2;
                }
                setCarInfo(18, value35);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                int value36 = DataCanbus.DATA[135];
                setCarInfo(18, (value36 + 1) % 3);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                int value37 = DataCanbus.DATA[146];
                int value38 = (value37 - 1) % 3;
                if (value38 < 0) {
                    value38 = 2;
                }
                setCarInfo(31, value38);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                int value39 = DataCanbus.DATA[146];
                setCarInfo(31, (value39 + 1) % 3);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value40 = DataCanbus.DATA[147];
                int value41 = (value40 - 1) % 3;
                if (value41 < 0) {
                    value41 = 2;
                }
                setCarInfo(34, value41);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value42 = DataCanbus.DATA[147];
                setCarInfo(34, (value42 + 1) % 3);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value43 = DataCanbus.DATA[158];
                int value44 = value43 - 1;
                if (value44 < 0) {
                    value44 = 2;
                }
                if (DataCanbus.sCanbusId == 983338) {
                    setCarInfo(41, value44);
                    break;
                } else {
                    setCarInfo(36, value44);
                    break;
                }
            case R.id.btn_plus14 /* 2131427496 */:
                int value45 = DataCanbus.DATA[158];
                int value46 = (value45 + 1) % 3;
                if (DataCanbus.sCanbusId == 983338) {
                    setCarInfo(41, value46);
                    break;
                } else {
                    setCarInfo(36, value46);
                    break;
                }
            case R.id.layout_view1 /* 2131427526 */:
                try {
                    Intent ii = new Intent();
                    ii.setClass(this, ActiAMP_Bnr.class);
                    startActivity(ii);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value47 = DataCanbus.DATA[125];
                setCarInfo(10, value47 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value48 = DataCanbus.DATA[126];
                setCarInfo(9, value48 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(12, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value49 = DataCanbus.DATA[130];
                setCarInfo(13, value49 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value50 = DataCanbus.DATA[131];
                setCarInfo(24, value50 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value51 = DataCanbus.DATA[132];
                setCarInfo(25, value51 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value52 = DataCanbus.DATA[133];
                setCarInfo(26, value52 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value53 = DataCanbus.DATA[136];
                setCarInfo(19, value53 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value54 = DataCanbus.DATA[137];
                setCarInfo(20, value54 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value55 = DataCanbus.DATA[138];
                setCarInfo(21, value55 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value56 = DataCanbus.DATA[139];
                setCarInfo(22, value56 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value57 = DataCanbus.DATA[140];
                setCarInfo(23, value57 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                int value58 = DataCanbus.DATA[141];
                setCarInfo(28, value58 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                int value59 = DataCanbus.DATA[142];
                setCarInfo(30, value59 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                int value60 = DataCanbus.DATA[143];
                setCarInfo(29, value60 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                int value61 = DataCanbus.DATA[144];
                setCarInfo(32, value61 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext18 /* 2131427661 */:
                int value62 = DataCanbus.DATA[145];
                setCarInfo(33, value62 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427663 */:
                int value63 = DataCanbus.DATA[148];
                setCarInfo(35, value63 != 0 ? 0 : 1);
                break;
            case R.id.ctv_checkedtext20 /* 2131427665 */:
                if (isBNRSiYuOrGuanDao()) {
                    value3 = DataCanbus.DATA[153] == 0 ? 1 : 0;
                } else {
                    value3 = 0;
                }
                setCarInfo(36, value3);
                break;
            case R.id.ctv_checkedtext21 /* 2131427667 */:
                int value64 = DataCanbus.DATA[154] == 0 ? 1 : 0;
                setCarInfo(37, value64);
                break;
            case R.id.ctv_checkedtext22 /* 2131427669 */:
                int value65 = DataCanbus.DATA[155] == 0 ? 1 : 0;
                setCarInfo(38, value65);
                break;
            case R.id.ctv_checkedtext23 /* 2131427672 */:
                if (isBNRSiYuOrGuanDao()) {
                    value2 = DataCanbus.DATA[156] == 0 ? 1 : 0;
                } else {
                    value2 = 0;
                }
                setCarInfo(39, value2);
                break;
            case R.id.ctv_checkedtext24 /* 2131427848 */:
                if (isBNRSiYuOrGuanDao()) {
                    value = DataCanbus.DATA[157] == 0 ? 1 : 0;
                } else {
                    value = 0;
                }
                setCarInfo(40, value);
                break;
            case R.id.ctv_checkedtext25 /* 2131427850 */:
                setCarInfo(42, DataCanbus.DATA[193] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427852 */:
                setCarInfo(43, DataCanbus.DATA[194] == 0 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext29 /* 2131427893 */:
                setCarInfo(15, 0);
                break;
            case R.id.ctv_checkedtext30 /* 2131427902 */:
                setCarInfo(17, 0);
                break;
            case R.id.ctv_checkedtext28 /* 2131427904 */:
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
            case FinalCanbus.CAR_BNR_HONDA_16Civic_NoAir /* 2621738 */:
                return true;
            default:
                return false;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(105, value1, value2);
    }

    @Override
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
        setViewState(findViewById(R.id.layout_view11), 8);
        setViewState(findViewById(R.id.layout_view12), 8);
        setViewState(findViewById(R.id.layout_view16), 8);
        setViewState(findViewById(R.id.layout_view22), 8);
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
                return true;
            default:
                return false;
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[193].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[193].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateTripA() {
        int value = DataCanbus.DATA[119];
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
            int value = DataCanbus.DATA[157];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext24)).setChecked(value != 0);
        }
    }

    protected void updateDrivingPositionRemory() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext23)) != null) {
            int value = DataCanbus.DATA[156];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext23)).setChecked(value != 0);
        }
    }

    protected void updateEleDoorOpenAutoOrManule() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext22)) != null) {
            int value = DataCanbus.DATA[155];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext22)).setChecked(value != 0);
        }
    }

    protected void updateEleDoorRemoteOpenCondition() {
        if (((TextView) findViewById(R.id.tv_text19)) != null) {
            int value = DataCanbus.DATA[154];
            ((TextView) findViewById(R.id.tv_text19)).setText(value == 0 ? R.string.str_guandao_remote_open1 : R.string.str_guandao_remote_open2);
        }
    }

    protected void updateBackCarBeepTone() {
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext20)) != null) {
            int value = DataCanbus.DATA[153];
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext20)).setChecked(value != 0);
        }
    }

    
    public void updateTripB() {
        int value = DataCanbus.DATA[120];
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

    
    public void updateOutTemp() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.tv_text3)) != null) {
            ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value - 5).toString());
        }
    }

    
    public void updateAutoLightSens() {
        int value = DataCanbus.DATA[122];
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

    
    public void mUpdaterValue2() {
        int value = DataCanbus.DATA[150] & 255;
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext27)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext27)).setChecked(value == 1);
        }
    }

    
    public void updateHeadLessAutoOff() {
        int value = DataCanbus.DATA[123];
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

    
    public void updateInteriorLightDimmingTime() {
        int value = DataCanbus.DATA[124];
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

    
    public void updateKeyLockAnswer() {
        int value = DataCanbus.DATA[125];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
    }

    
    public void updateKeyAndRemoteUnlockMode() {
        int value = DataCanbus.DATA[126];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
    }

    
    public void updateSecurityRelockTime() {
        int value = DataCanbus.DATA[127];
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

    
    public void updateAutoDoorUnLock() {
        int value = DataCanbus.DATA[128];
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

    
    public void updateAutoDoorLock() {
        int value = DataCanbus.DATA[129];
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

    
    public void updateKeylessAccessBeep() {
        int value = DataCanbus.DATA[130];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
    }

    
    public void updateKeylessAccessBeepVol() {
        int value = DataCanbus.DATA[152];
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            ((TextView) findViewById(R.id.tv_text10)).setText(value == 0 ? R.string.wc_372_low : R.string.wc_372_high);
        }
    }

    
    public void updateRemoteStartSys() {
        int value = DataCanbus.DATA[131];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
    }

    
    public void updateDoorUnlockMode() {
        int value = DataCanbus.DATA[132];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_0);
        } else {
            ((TextView) findViewById(R.id.tv_text11)).setText(R.string.wc_ruiteng_string_unlock_mode_1);
        }
    }

    
    public void updateKeylessAccessLightFlash() {
        int value = DataCanbus.DATA[133];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
    }

    
    public void updateAutoInterIllumination() {
        int value = DataCanbus.DATA[134];
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

    
    public void updateAdjustAlarmVolume() {
        int value = DataCanbus.DATA[135];
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

    
    public void updateFuelEfficBacklight() {
        int value = DataCanbus.DATA[136];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
    }

    
    public void updateNewMsgNoti() {
        int value = DataCanbus.DATA[137];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
    }

    
    public void updateSpeedDistanceUnit() {
        int value = DataCanbus.DATA[138];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text14)).setText("km/h  km");
        } else {
            ((TextView) findViewById(R.id.tv_text14)).setText("mph  miles");
        }
    }

    
    public void updateTachometer() {
        int value = DataCanbus.DATA[139];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
    }

    
    public void updateWalkAwayAutoLock() {
        int value = DataCanbus.DATA[140];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
    }

    
    public void updateAutoHeadlightWiper() {
        int value = DataCanbus.DATA[141];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext14)).setChecked(value != 0);
    }

    
    public void updateVolumeAlarmSys() {
        int value = DataCanbus.DATA[142];
        if (value == 0) {
            ((TextView) findViewById(R.id.tv_text15)).setText("low");
        } else {
            ((TextView) findViewById(R.id.tv_text15)).setText("high");
        }
    }

    
    public void updateEnergySaveAutoEnghine() {
        int value = DataCanbus.DATA[143];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext16)).setChecked(value != 0);
    }

    
    public void updateAccDiscoveryVehicle() {
        int value = DataCanbus.DATA[144];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext17)).setChecked(value != 0);
    }

    
    public void updatePauseLKADTone() {
        int value = DataCanbus.DATA[145];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext18)).setChecked(value != 0);
    }

    protected void updateSetFrontHazardDistance() {
        int value = DataCanbus.DATA[146];
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
        int value = DataCanbus.DATA[147];
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

    
    public void updateTachometerSet() {
        int value = DataCanbus.DATA[148];
        ((CheckedTextView) findViewById(R.id.ctv_checkedtext19)).setChecked(value != 0);
    }
}
