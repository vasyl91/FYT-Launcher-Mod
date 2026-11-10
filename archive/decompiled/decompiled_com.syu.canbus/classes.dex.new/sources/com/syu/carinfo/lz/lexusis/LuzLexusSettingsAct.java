package com.syu.carinfo.lz.lexusis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class LuzLexusSettingsAct extends BaseActivity implements View.OnClickListener {
    public static LuzLexusSettingsAct mInit;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.lz.lexusis.LuzLexusSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 159:
                    LuzLexusSettingsAct.this.mUpdaterDayTimeRuningLights();
                    break;
                case 160:
                    LuzLexusSettingsAct.this.mUpdaterHeadLampsOnSensitivity();
                    break;
                case 161:
                    LuzLexusSettingsAct.this.mUpdaterInteriorLightOffTime();
                    break;
                case 162:
                    LuzLexusSettingsAct.this.mUpdaterHeadLampsAutoOffTimer();
                    break;
                case 163:
                    LuzLexusSettingsAct.this.mUpdaterAutolockBySpeed();
                    break;
                case 164:
                    LuzLexusSettingsAct.this.mUpdaterAutolockByShiftFromP();
                    break;
                case 165:
                    LuzLexusSettingsAct.this.mUpdaterAutoUnlockByShiftToP();
                    break;
                case 166:
                    LuzLexusSettingsAct.this.mUpdaterRemote2PressUnlock();
                    break;
                case 167:
                    LuzLexusSettingsAct.this.mUpdaterLockUnlockFeedbackTone();
                    break;
                case 168:
                    LuzLexusSettingsAct.this.m2TimesKeyUnLock();
                    break;
                case 169:
                    LuzLexusSettingsAct.this.mUpdaterUnLockByDriversDoorOpen();
                    break;
                case 170:
                    LuzLexusSettingsAct.this.mUpdaterKeySystemWithElecKey();
                    break;
                case 171:
                    LuzLexusSettingsAct.this.mUpdaterSmartLockAndOneKeyBoot();
                    break;
                case 172:
                    LuzLexusSettingsAct.this.mUpdaterLockUnLockFeedbackByLights();
                    break;
                case 173:
                    LuzLexusSettingsAct.this.mUpdaterElectric();
                    break;
                case 174:
                    LuzLexusSettingsAct.this.mUpdaterAirByAutoKey();
                    break;
                case 175:
                    LuzLexusSettingsAct.this.mUpdaterInOutAirByAutoKey();
                    break;
                case 176:
                    LuzLexusSettingsAct.this.mUpdaterLoucs();
                    break;
                case 177:
                    LuzLexusSettingsAct.this.updateAutoRelockTime();
                    break;
                case 178:
                    LuzLexusSettingsAct.this.mUpdaterGasSensor();
                    break;
                case 179:
                    LuzLexusSettingsAct.this.mUpdaterSeatMoveMent();
                    break;
                case 180:
                    if (((TextView) LuzLexusSettingsAct.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 1:
                                ((TextView) LuzLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText("7.5s");
                                break;
                            case 2:
                                ((TextView) LuzLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText("15s");
                                break;
                            case 3:
                                ((TextView) LuzLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText("30s");
                                break;
                            default:
                                ((TextView) LuzLexusSettingsAct.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_luz_toyota_lexus_settings);
        mInit = this;
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus4 /* 2131427465 */:
                int value = DataCanbus.DATA[167];
                if (value > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{5, value - 1}, null, null);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value2 = DataCanbus.DATA[167];
                if (value2 < 6) {
                    DataCanbus.PROXY.cmd(5, new int[]{5, value2 + 1}, null, null);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value3 = DataCanbus.DATA[160];
                if (value3 > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{6, value3 - 1}, null, null);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value4 = DataCanbus.DATA[160];
                if (value4 < 4) {
                    DataCanbus.PROXY.cmd(5, new int[]{6, value4 + 1}, null, null);
                }
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value5 = DataCanbus.DATA[161];
                if (value5 > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{12, value5 - 1}, null, null);
                }
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value6 = DataCanbus.DATA[161];
                if (value6 < 3) {
                    DataCanbus.PROXY.cmd(5, new int[]{12, value6 + 1}, null, null);
                }
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value7 = DataCanbus.DATA[162];
                if (value7 > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{7, value7 - 1}, null, null);
                }
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value8 = DataCanbus.DATA[162];
                if (value8 < 3) {
                    DataCanbus.PROXY.cmd(5, new int[]{7, value8 + 1}, null, null);
                }
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value9 = DataCanbus.DATA[173];
                if (value9 > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{35, value9 - 1}, null, null);
                }
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value10 = DataCanbus.DATA[173];
                if (value10 < 4) {
                    DataCanbus.PROXY.cmd(5, new int[]{35, value10 + 1}, null, null);
                }
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value11 = DataCanbus.DATA[179];
                if (value11 > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{37, value11 - 1}, null, null);
                }
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value12 = DataCanbus.DATA[179];
                if (value12 < 2) {
                    DataCanbus.PROXY.cmd(5, new int[]{37, value12 + 1}, null, null);
                }
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value13 = DataCanbus.DATA[178];
                if (value13 > 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{38, value13 - 1}, null, null);
                }
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value14 = DataCanbus.DATA[178];
                if (value14 < 6) {
                    DataCanbus.PROXY.cmd(5, new int[]{38, value14 + 1}, null, null);
                }
                break;
            case R.id.btn_minus13 /* 2131427492 */:
                int value15 = DataCanbus.DATA[180] - 1;
                if (value15 < 0) {
                    value15 = 3;
                }
                DataCanbus.PROXY.cmd(5, new int[]{43, value15}, null, null);
                break;
            case R.id.btn_plus13 /* 2131427494 */:
                int value16 = DataCanbus.DATA[180] + 1;
                if (value16 > 3) {
                    value16 = 0;
                }
                DataCanbus.PROXY.cmd(5, new int[]{43, value16}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[165] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{2, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{2, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[166] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{3, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{3, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                if (DataCanbus.DATA[163] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{0, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[2], null, null);
                }
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[164] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{1, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{1, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                if (DataCanbus.DATA[168] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{13, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{13, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (DataCanbus.DATA[169] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{14, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{14, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                if (DataCanbus.DATA[170] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{15, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{15, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                if (DataCanbus.DATA[171] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{16, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                if (DataCanbus.DATA[172] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{17, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{17, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                if (DataCanbus.DATA[174] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{18, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{18, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                if (DataCanbus.DATA[175] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{19, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{19, 0}, null, null);
                }
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                if (DataCanbus.DATA[159] == 0) {
                    DataCanbus.PROXY.cmd(5, new int[]{4, 1}, null, null);
                } else {
                    DataCanbus.PROXY.cmd(5, new int[]{4, 0}, null, null);
                }
                break;
        }
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.PROXY.cmd(43, new int[]{38, 0}, null, null);
        DataCanbus.NOTIFY_EVENTS[163].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[164].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[165].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[159].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[160].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[161].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[162].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[176].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[178].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[180].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[163].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[164].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[165].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[159].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[160].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[161].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[162].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[176].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[177].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[178].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[180].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoRelockTime() {
        if (((TextView) findViewById(R.id.tv_text10)) != null) {
            int value = DataCanbus.DATA[177];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLoucs() {
        int value = DataCanbus.DATA[176];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockBySpeed() {
        int value = DataCanbus.DATA[163];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext2)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext2)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutolockByShiftFromP() {
        int value = DataCanbus.DATA[164];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext3)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext3)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAutoUnlockByShiftToP() {
        int value = DataCanbus.DATA[165];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext4)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext4)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRemote2PressUnlock() {
        int value = DataCanbus.DATA[166];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext5)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext5)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnlockFeedbackTone() {
        int value = DataCanbus.DATA[167];
        if (((TextView) findViewById(R.id.tv_text4)) != null) {
            ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2TimesKeyUnLock() {
        int value = DataCanbus.DATA[168];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext6)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext6)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterUnLockByDriversDoorOpen() {
        int value = DataCanbus.DATA[169];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext7)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext7)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterKeySystemWithElecKey() {
        int value = DataCanbus.DATA[170];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext8)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext8)).setChecked(value != 0);
        }
        if (((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)) != null) {
            ((TextView) findViewById(R.id.camry_tv_lock_set_unlock_intelligent_door)).setText(value != 0 ? R.string.lock_set_unlock_intelligent_door_driver : R.string.lock_set_unlock_intelligent_door_all);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSmartLockAndOneKeyBoot() {
        int value = DataCanbus.DATA[171];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext9)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext9)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLockUnLockFeedbackByLights() {
        int value = DataCanbus.DATA[172];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext10)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext10)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAirByAutoKey() {
        int value = DataCanbus.DATA[174];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext11)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext11)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInOutAirByAutoKey() {
        int value = DataCanbus.DATA[175];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext12)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext12)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDayTimeRuningLights() {
        int value = DataCanbus.DATA[159];
        if (((CheckedTextView) findViewById(R.id.ctv_checkedtext13)) != null) {
            ((CheckedTextView) findViewById(R.id.ctv_checkedtext13)).setChecked(value != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsOnSensitivity() {
        int value = DataCanbus.DATA[160];
        if (((TextView) findViewById(R.id.tv_text5)) != null) {
            ((TextView) findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterInteriorLightOffTime() {
        int value = DataCanbus.DATA[161];
        if (((TextView) findViewById(R.id.tv_text6)) != null && value > -1 && value < 5) {
            ((TextView) findViewById(R.id.tv_text6)).setText(CamryData.mStrInteriorLightOffTime[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterGasSensor() {
        int value = DataCanbus.DATA[178];
        if (((TextView) findViewById(R.id.tv_text12)) != null) {
            ((TextView) findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value + 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSeatMoveMent() {
        int value = DataCanbus.DATA[179];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterHeadLampsAutoOffTimer() {
        int value = DataCanbus.DATA[162];
        if (((TextView) findViewById(R.id.tv_text7)) != null && value > -1 && value < 4) {
            ((TextView) findViewById(R.id.tv_text7)).setText(CamryData.mStrHeadLampsAutoOffTimer[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectric() {
        int value = DataCanbus.DATA[173];
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
