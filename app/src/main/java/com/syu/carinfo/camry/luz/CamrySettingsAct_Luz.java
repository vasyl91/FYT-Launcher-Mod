package com.syu.carinfo.camry.luz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.carinfo.zhtd.bmw.LZToyotaLexRX450LightAct;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamrySettingsAct_Luz extends BaseActivity implements View.OnClickListener {
    public static CamrySettingsAct_Luz mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 101:
                    CamrySettingsAct_Luz.this.mUpdaterDayTimeRuningLights();
                    break;
                case 102:
                    CamrySettingsAct_Luz.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 103:
                    CamrySettingsAct_Luz.this.mUpdaterInteriorLightOffTime();
                    break;
                case 104:
                    CamrySettingsAct_Luz.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 105:
                    CamrySettingsAct_Luz.this.mUpdaterAutolockBySpeed();
                    break;
                case 106:
                    CamrySettingsAct_Luz.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 107:
                    CamrySettingsAct_Luz.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 108:
                    CamrySettingsAct_Luz.this.mUpdaterRemote2PressUnlock();
                    break;
                case 109:
                    CamrySettingsAct_Luz.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 110:
                    CamrySettingsAct_Luz.this.m2TimesKeyUnLock();
                    break;
                case 111:
                    CamrySettingsAct_Luz.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 112:
                    CamrySettingsAct_Luz.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 113:
                    CamrySettingsAct_Luz.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 114:
                    CamrySettingsAct_Luz.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 115:
                    CamrySettingsAct_Luz.this.mUpdaterElectric();
                    break;
                case 116:
                    CamrySettingsAct_Luz.this.mUpdaterAirByAutoKey();
                    break;
                case 117:
                    CamrySettingsAct_Luz.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 118:
                    CamrySettingsAct_Luz.this.mUpdaterLoucs();
                    break;
                case 120:
                    CamrySettingsAct_Luz.this.updateAutoRelockTime();
                    break;
                case 121:
                    CamrySettingsAct_Luz.this.mUpdaterGasSensor();
                    break;
                case 122:
                    CamrySettingsAct_Luz.this.mUpdaterSeatMoveMent();
                    break;
                case 125:
                    if (((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_1);
                                break;
                            default:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_forwardcollisionwarn_0);
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((CheckedTextView) CamrySettingsAct_Luz.this.findViewById(R.id.ctv_checkedtext1)) != null) {
                        ((CheckedTextView) CamrySettingsAct_Luz.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value != 0);
                        break;
                    }
                case 127:
                    if (((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 159:
                    if (((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText("15s");
                                break;
                            case 3:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            default:
                                ((TextView) CamrySettingsAct_Luz.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_luz_toyota_camry_settings);
        mInit = this;
        init();
    }

    @Override
    public void init() {
        if (DataCanbus.DATA[1000] == 12648900) {
            findViewById(R.id.layout_view30).setVisibility(0);
        } else {
            findViewById(R.id.layout_view30).setVisibility(8);
        }
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
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
    }

    @Override
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value3 = DataCanbus.DATA[127];
                if (value3 > 1) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value3 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int value4 = DataCanbus.DATA[127];
                if (value4 < 5) {
                    DataCanbus.PROXY.cmd(40, new int[]{21, value4 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus3 /* 2131427461 */:
                if (DataCanbus.DATA[125] == 1) {
                    value2 = 0;
                } else {
                    value2 = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value2}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                if (DataCanbus.DATA[125] == 1) {
                    value = 0;
                } else {
                    value = 1;
                }
                DataCanbus.PROXY.cmd(40, new int[]{23, value}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value5 = DataCanbus.DATA[109];
                if (value5 > 0) {
                    DataCanbus.PROXY.cmd(6, new int[]{value5 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus4 /* 2131427466 */:
                int value6 = DataCanbus.DATA[109];
                if (value6 < 6) {
                    DataCanbus.PROXY.cmd(6, new int[]{value6 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus5 /* 2131427467 */:
                int value7 = DataCanbus.DATA[102];
                if (value7 > 0) {
                    DataCanbus.PROXY.cmd(0, new int[]{value7 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus5 /* 2131427469 */:
                int value8 = DataCanbus.DATA[102];
                if (value8 < 4) {
                    DataCanbus.PROXY.cmd(0, new int[]{value8 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus6 /* 2131427470 */:
                int value9 = DataCanbus.DATA[103];
                if (value9 > 0) {
                    DataCanbus.PROXY.cmd(11, new int[]{value9 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus6 /* 2131427472 */:
                int value10 = DataCanbus.DATA[103];
                if (value10 < 3) {
                    DataCanbus.PROXY.cmd(11, new int[]{value10 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus7 /* 2131427473 */:
                int value11 = DataCanbus.DATA[104];
                if (value11 > 0) {
                    DataCanbus.PROXY.cmd(7, new int[]{value11 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus7 /* 2131427475 */:
                int value12 = DataCanbus.DATA[104];
                if (value12 < 3) {
                    DataCanbus.PROXY.cmd(7, new int[]{value12 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus8 /* 2131427476 */:
                int value13 = DataCanbus.DATA[115];
                if (value13 > 0) {
                    DataCanbus.PROXY.cmd(19, new int[]{value13 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus8 /* 2131427478 */:
                int value14 = DataCanbus.DATA[115];
                if (value14 < 4) {
                    DataCanbus.PROXY.cmd(19, new int[]{value14 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus9 /* 2131427479 */:
                int value15 = DataCanbus.DATA[118];
                if (value15 > 0) {
                    DataCanbus.PROXY.cmd(21, new int[]{value15 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus9 /* 2131427481 */:
                int value16 = DataCanbus.DATA[118];
                if (value16 < 2) {
                    DataCanbus.PROXY.cmd(21, new int[]{value16 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus10 /* 2131427482 */:
                int value17 = DataCanbus.DATA[120];
                if (value17 > 0) {
                    DataCanbus.PROXY.cmd(23, new int[]{value17 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus10 /* 2131427484 */:
                int value18 = DataCanbus.DATA[120];
                if (value18 < 3) {
                    DataCanbus.PROXY.cmd(23, new int[]{value18 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus11 /* 2131427485 */:
                int value19 = DataCanbus.DATA[122];
                if (value19 > 0) {
                    DataCanbus.PROXY.cmd(28, new int[]{value19 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus11 /* 2131427487 */:
                int value20 = DataCanbus.DATA[122];
                if (value20 < 2) {
                    DataCanbus.PROXY.cmd(28, new int[]{value20 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus12 /* 2131427488 */:
                int value21 = DataCanbus.DATA[121];
                if (value21 > 0) {
                    DataCanbus.PROXY.cmd(27, new int[]{value21 - 1}, null, null);
                    break;
                }
            case R.id.btn_plus12 /* 2131427490 */:
                int value22 = DataCanbus.DATA[121];
                if (value22 < 6) {
                    DataCanbus.PROXY.cmd(27, new int[]{value22 + 1}, null, null);
                    break;
                }
            case R.id.btn_minus13 /* 2131427491 */:
                int value23 = DataCanbus.DATA[159] - 1;
                if (value23 < 0) {
                    value23 = 3;
                }
                DataCanbus.PROXY.cmd(40, new int[]{43, value23}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value24 = DataCanbus.DATA[159] + 1;
                if (value24 > 3) {
                    value24 = 0;
                }
                DataCanbus.PROXY.cmd(40, new int[]{43, value24}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                if (DataCanbus.DATA[126] == 0) {
                    DataCanbus.PROXY.cmd(40, new int[]{22, 1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(40, new int[]{22}, null, null);
                    break;
                }
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                if (DataCanbus.DATA[105] == 0) {
                    DataCanbus.PROXY.cmd(1, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(1, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                if (DataCanbus.DATA[106] == 0) {
                    DataCanbus.PROXY.cmd(2, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(2, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                if (DataCanbus.DATA[107] == 0) {
                    DataCanbus.PROXY.cmd(3, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(3, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                if (DataCanbus.DATA[108] == 0) {
                    DataCanbus.PROXY.cmd(4, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(4, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                if (DataCanbus.DATA[110] == 0) {
                    DataCanbus.PROXY.cmd(12, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(12, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                if (DataCanbus.DATA[111] == 0) {
                    DataCanbus.PROXY.cmd(13, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(13, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                if (DataCanbus.DATA[112] == 0) {
                    DataCanbus.PROXY.cmd(14, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(14, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                if (DataCanbus.DATA[113] == 0) {
                    DataCanbus.PROXY.cmd(15, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(15, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                if (DataCanbus.DATA[114] == 0) {
                    DataCanbus.PROXY.cmd(16, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(16, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                if (DataCanbus.DATA[116] == 0) {
                    DataCanbus.PROXY.cmd(17, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(17, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                if (DataCanbus.DATA[117] == 0) {
                    DataCanbus.PROXY.cmd(18, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(18, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                if (DataCanbus.DATA[101] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1}, null, null);
                    break;
                } else {
                    DataCanbus.PROXY.cmd(5, new int[1], null, null);
                    break;
                }
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, LZToyotaLexRX450LightAct.class);
                    startActivity(intent);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
        }
    }

    @Override
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{38}, null, null);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            int value = DataCanbus.DATA[120];
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_light_Lasuo_headlight_delay_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_light_Lasuo_headlight_delay_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_light_Lasuo_headlight_delay_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text10)).setText(R.string.klc_onstar_call_alarm_off);
                    break;
            }
        }
    }

    
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.tv_text9)) != null) {
            switch (value) {
                case 0:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model0_string);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model1_string);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model2_string);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text9)).setText(R.string.xp_loucs_model0_string);
                    break;
            }
        }
    }

    private void mUpdaterLoucsenable() {
    }

    
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[105];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[106];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[107];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[108];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[109];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[110];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[111];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[112];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[113];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[114];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[116];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[117];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[101];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
        }
    }

    
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text6)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    
    public void mUpdaterGasSensor() {
        int value = DataCanbus.DATA[121];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            ((TextView) findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value + 1).toString());
        }
    }

    
    public void mUpdaterSeatMoveMent() {
        int value = DataCanbus.DATA[122];
        if (((TextView) findViewById(R.id.tv_text11)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.str_sbd_x80_shengchang_0);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.distance_very_close);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text11)).setText(R.string.jeep_comfortsystems_0);
                    break;
            }
        }
    }

    
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.tv_text7)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.tv_text7)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[115];
        if (((TextView) findViewById(R.id.tv_text8)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_4);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_text8)).setText(R.string.xp_camry_electric_level_0);
                    break;
            }
        }
    }
}
