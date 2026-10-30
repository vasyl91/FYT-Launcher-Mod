package com.syu.carinfo.jili;

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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODJiliXingyuanCarSettingsAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.jili.ODJiliXingyuanCarSettingsAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 260:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 261:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text1)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
                case 262:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 263:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_comfort);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_driving_sport);
                            break;
                    }
                    break;
                case 264:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_eco);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_comfort);
                            break;
                        case 2:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                            break;
                    }
                    break;
                case 265:
                    ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 266:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 267:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 268:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("30s");
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("60s");
                            break;
                        case 2:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text5)).setText("90s");
                            break;
                        case 3:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                            break;
                    }
                    break;
                case 269:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 270:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("常开");
                            break;
                        case 2:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("30分");
                            break;
                        case 3:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("1小时");
                            break;
                        case 4:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text6)).setText("2小时");
                            break;
                    }
                    break;
                case 271:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 272:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 273:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 274:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 275:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 276:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 277:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 278:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 279:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.driver_system_standard);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text7)).setText(R.string.str_395_dynamic_state);
                            break;
                    }
                    break;
                case 280:
                    ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                    break;
                case 281:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text9)).setText("驾驶联动");
                            break;
                        case 2:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text9)).setText("呼吸渐变");
                            break;
                        case 3:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text9)).setText("双色交替");
                            break;
                        case 4:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text9)).setText("纯色模式");
                            break;
                    }
                    break;
                case 282:
                    ODJiliXingyuanCarSettingsAct.this.setCheck((CheckedTextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.ctv_checkedtext14), value == 1);
                    break;
                case 283:
                    ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                    break;
                case 284:
                    ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                    break;
                case 285:
                    switch (value) {
                        case 0:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODJiliXingyuanCarSettingsAct.this.findViewById(R.id.tv_text12)).setText(R.string.klc_air_high);
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_jili_xingyuan_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[261] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(7, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[261] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(7, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[263] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[263] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[264] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(0, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[264] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(0, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[265] - 1;
                if (value7 < 1) {
                    value7 = 10;
                }
                setCarInfo(39, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[265] + 1;
                if (value8 > 10) {
                    value8 = 1;
                }
                setCarInfo(39, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[268] - 1;
                if (value9 < 0) {
                    value9 = 3;
                }
                setCarInfo(11, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[268] + 1;
                if (value10 > 3) {
                    value10 = 0;
                }
                setCarInfo(11, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[270] - 1;
                if (value11 < 0) {
                    value11 = 4;
                }
                setCarInfo(9, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[270] + 1;
                if (value12 > 4) {
                    value12 = 0;
                }
                setCarInfo(9, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[279] - 1;
                if (value13 < 0) {
                    value13 = 1;
                }
                setCarInfo(12, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[279] + 1;
                if (value14 > 1) {
                    value14 = 0;
                }
                setCarInfo(12, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[280] - 1;
                if (value15 < 0) {
                    value15 = 5;
                }
                setCarInfo(16, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[280] + 1;
                if (value16 > 5) {
                    value16 = 0;
                }
                setCarInfo(16, value16);
                break;
            case R.id.btn_minus9 /* 2131427480 */:
                int value17 = DataCanbus.DATA[281] - 1;
                if (value17 < 0) {
                    value17 = 4;
                }
                setCarInfo(32, value17);
                break;
            case R.id.btn_plus9 /* 2131427482 */:
                int value18 = DataCanbus.DATA[281] + 1;
                if (value18 > 4) {
                    value18 = 0;
                }
                setCarInfo(32, value18);
                break;
            case R.id.btn_minus10 /* 2131427483 */:
                int value19 = DataCanbus.DATA[283] - 1;
                if (value19 < 1) {
                    value19 = 10;
                }
                setCarInfo(30, value19);
                break;
            case R.id.btn_plus10 /* 2131427485 */:
                int value20 = DataCanbus.DATA[283] + 1;
                if (value20 > 10) {
                    value20 = 1;
                }
                setCarInfo(30, value20);
                break;
            case R.id.btn_minus11 /* 2131427486 */:
                int value21 = DataCanbus.DATA[284] - 1;
                if (value21 < 1) {
                    value21 = 72;
                }
                setCarInfo(31, value21);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value22 = DataCanbus.DATA[284] + 1;
                if (value22 > 72) {
                    value22 = 1;
                }
                setCarInfo(31, value22);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value23 = DataCanbus.DATA[285] - 1;
                if (value23 < 0) {
                    value23 = 2;
                }
                setCarInfo(29, value23);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value24 = DataCanbus.DATA[285] + 1;
                if (value24 > 2) {
                    value24 = 0;
                }
                setCarInfo(29, value24);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(10, DataCanbus.DATA[260] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(14, DataCanbus.DATA[267] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(19, DataCanbus.DATA[269] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(5, DataCanbus.DATA[262] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(13, DataCanbus.DATA[266] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(6, DataCanbus.DATA[271] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(37, DataCanbus.DATA[272] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(35, DataCanbus.DATA[273] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(15, DataCanbus.DATA[274] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(8, DataCanbus.DATA[275] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(3, DataCanbus.DATA[276] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(1, DataCanbus.DATA[277] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(2, DataCanbus.DATA[278] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(34, DataCanbus.DATA[282] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                try {
                    Intent intent = new Intent();
                    intent.setClass(this, ODJiliRadarCarEVInfAct.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                try {
                    Intent intent2 = new Intent();
                    intent2.setClass(this, ODJiliXingyuanCarEVInfAct.class);
                    startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
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
        DataCanbus.NOTIFY_EVENTS[260].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[261].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[262].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[263].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[264].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[265].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[266].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[267].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[268].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[269].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[270].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[271].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[272].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[273].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[274].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[275].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[276].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[277].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[278].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[279].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[280].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[281].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[282].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[283].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[284].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[285].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[260].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[261].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[262].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[263].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[264].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[265].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[266].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[267].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[268].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[269].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[270].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[271].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[272].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[273].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[274].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[275].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[276].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[277].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[278].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[279].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[280].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[281].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[282].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[283].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[284].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[285].removeNotify(this.mNotifyCanbus);
    }
}
