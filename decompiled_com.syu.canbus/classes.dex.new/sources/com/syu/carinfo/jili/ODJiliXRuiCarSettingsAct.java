package com.syu.carinfo.jili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODJiliXRuiCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliXRuiCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 230:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_background_blue);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_brown);
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.str_403_ambient_3);
                            break;
                    }
                    break;
                case 231:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_economics);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.driver_system_sports);
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.wc_golf_comfort);
                            break;
                    }
                    break;
                case 232:
                    ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    break;
                case 233:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 234:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("30s");
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("60s");
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text4)).setText("90s");
                            break;
                    }
                    break;
                case 235:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 236:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 237:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 238:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.dj_airuize7_prompt_lightsounds);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.dj_airuize7_prompt_light);
                            break;
                    }
                    break;
                case 239:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 240:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 241:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.lingdu_air_con_profile_0);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.lingdu_air_con_profile_1);
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.lingdu_air_con_profile_2);
                            break;
                    }
                    break;
                case 242:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 243:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 244:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 245:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 246:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("10km/h");
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text7)).setText("20km/h");
                            break;
                    }
                    break;
                case 247:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 248:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 249:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 250:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText(R.string.wc_weilang_auto_fangzhuang_warn);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText("弱辅助");
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text8)).setText("强辅助");
                            break;
                    }
                    break;
                case 251:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 252:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext15), value == 1);
                    break;
                case 253:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_low);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_mid);
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_high);
                            break;
                    }
                    break;
                case 254:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.jeep_parksense_0);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_vibrate);
                            break;
                        case 2:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text10)).setText(R.string.str_sound_vibrate);
                            break;
                    }
                    break;
                case 255:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.str_golf_acc);
                            break;
                        case 1:
                            ((TextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.tv_text11)).setText(R.string.str_intelligent);
                            break;
                    }
                    break;
                case 256:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext16), value == 1);
                    break;
                case 257:
                    ODJiliXRuiCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXRuiCarSettingsAct.this.findViewById(R.id.ctv_checkedtext17), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_jili_xingrui_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext15), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext16), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext17), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[230] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(41, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[230] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(41, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[231] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(40, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[231] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(40, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[232];
                if (value5 > 0) {
                    value5--;
                }
                setCarInfo(39, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[232];
                if (value6 < 10) {
                    value6++;
                }
                setCarInfo(39, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[234] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(11, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[234] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(11, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[238] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(17, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[238] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(17, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[241] - 1;
                if (value11 < 0) {
                    value11 = 2;
                }
                setCarInfo(38, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[241] + 1;
                if (value12 > 2) {
                    value12 = 0;
                }
                setCarInfo(38, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[246] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(19, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[246] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(19, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[250] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(21, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[250] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(21, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[253] - 1;
                if (value17 < 0) {
                    value17 = 2;
                }
                setCarInfo(29, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[253] + 1;
                if (value18 > 2) {
                    value18 = 0;
                }
                setCarInfo(29, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[254] - 1;
                if (value19 < 0) {
                    value19 = 2;
                }
                setCarInfo(22, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[254] + 1;
                if (value20 > 2) {
                    value20 = 0;
                }
                setCarInfo(22, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[255] - 1;
                if (value21 < 0) {
                    value21 = 1;
                }
                setCarInfo(26, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[255] + 1;
                if (value22 > 1) {
                    value22 = 0;
                }
                setCarInfo(26, value22);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(12, DataCanbus.DATA[233] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(6, DataCanbus.DATA[237] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(13, DataCanbus.DATA[239] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(15, DataCanbus.DATA[235] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(16, DataCanbus.DATA[236] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(14, DataCanbus.DATA[240] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(36, DataCanbus.DATA[242] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(35, DataCanbus.DATA[243] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(10, DataCanbus.DATA[244] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(7, DataCanbus.DATA[245] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(2, DataCanbus.DATA[247] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(18, DataCanbus.DATA[248] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(20, DataCanbus.DATA[249] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(28, DataCanbus.DATA[251] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(27, DataCanbus.DATA[252] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(23, DataCanbus.DATA[256] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(24, DataCanbus.DATA[257] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{80, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[230].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[231].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[232].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[233].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[234].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[235].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[236].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[237].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[238].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[239].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[240].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[241].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[242].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[243].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[244].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[245].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[246].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[247].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[248].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[249].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[250].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[251].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[252].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[253].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[254].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[255].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[256].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[257].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[230].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[231].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[232].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[233].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[234].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[235].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[236].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[237].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[238].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[239].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[240].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[241].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[242].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[243].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[244].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[245].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[246].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[247].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[248].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[249].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[250].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[251].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[252].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[253].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[254].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[255].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[256].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[257].removeNotify(this.mNotifyCanbus);
    }
}
