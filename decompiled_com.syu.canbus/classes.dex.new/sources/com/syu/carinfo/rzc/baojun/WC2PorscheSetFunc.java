package com.syu.carinfo.rzc.baojun;

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
public class WC2PorscheSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.baojun.WC2PorscheSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    switch (value) {
                        case 0:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                            break;
                        default:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value * 10) + "s");
                            break;
                    }
                    break;
                case 100:
                    ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value * 10) + "%");
                    break;
                case 101:
                    ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value * 10) + "s");
                    break;
                case 102:
                    switch (value) {
                        case 0:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_auto);
                            break;
                        case 1:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text4)).setText(R.string.klc_air_Manual);
                            break;
                    }
                    break;
                case 103:
                    switch (value) {
                        case 0:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_auto);
                            break;
                        case 1:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.klc_air_Manual);
                            break;
                    }
                    break;
                case 104:
                    ((CheckedTextView) WC2PorscheSetFunc.this.findViewById(R.id.ctv_checkedtext1)).setChecked(value == 1);
                    break;
                case 105:
                    switch (value) {
                        case 0:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_1);
                            break;
                        case 1:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text6)).setText(R.string.wc_ruiteng_string_intelligent_unlocke_0);
                            break;
                    }
                    break;
                case 106:
                    switch (value) {
                        case 0:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_after_ignition);
                            break;
                        case 2:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text7)).setText(R.string.str_after_start);
                            break;
                    }
                    break;
                case 107:
                    switch (value) {
                        case 0:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_soft_and_quiet);
                            break;
                        case 1:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.normal);
                            break;
                        case 2:
                            ((TextView) WC2PorscheSetFunc.this.findViewById(R.id.tv_text8)).setText(R.string.str_strong_and_fast);
                            break;
                    }
                    break;
                case 108:
                    ((CheckedTextView) WC2PorscheSetFunc.this.findViewById(R.id.ctv_checkedtext2)).setChecked(value == 1);
                    break;
                case 109:
                    ((CheckedTextView) WC2PorscheSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.layout_0444_wc2_porsche_all);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 1) {
                    value = 12;
                }
                setCarInfo(1, 1, value);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 12) {
                    value2 = 1;
                }
                setCarInfo(1, 1, value2);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = DataCanbus.DATA[100] - 1;
                if (value3 < 0) {
                    value3 = 10;
                }
                setCarInfo(1, 2, value3);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = DataCanbus.DATA[100] + 1;
                if (value4 > 10) {
                    value4 = 0;
                }
                setCarInfo(1, 2, value4);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = DataCanbus.DATA[101] - 1;
                if (value5 < 0) {
                    value5 = 30;
                }
                setCarInfo(1, 3, value5);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = DataCanbus.DATA[101] + 1;
                if (value6 > 30) {
                    value6 = 0;
                }
                setCarInfo(1, 3, value6);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = DataCanbus.DATA[102] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(1, 4, value7);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = DataCanbus.DATA[102] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(1, 4, value8);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = DataCanbus.DATA[103] - 1;
                if (value9 < 0) {
                    value9 = 1;
                }
                setCarInfo(1, 5, value9);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = DataCanbus.DATA[103] + 1;
                if (value10 > 1) {
                    value10 = 0;
                }
                setCarInfo(1, 5, value10);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value11 = DataCanbus.DATA[105] - 1;
                if (value11 < 0) {
                    value11 = 1;
                }
                setCarInfo(2, 1, value11);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value12 = DataCanbus.DATA[105] + 1;
                if (value12 > 1) {
                    value12 = 0;
                }
                setCarInfo(2, 1, value12);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value13 = DataCanbus.DATA[106] - 1;
                if (value13 < 0) {
                    value13 = 2;
                }
                setCarInfo(2, 2, value13);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value14 = DataCanbus.DATA[106] + 1;
                if (value14 > 2) {
                    value14 = 0;
                }
                setCarInfo(2, 2, value14);
                break;
            case R.id.btn_minus8 /* 2131427477 */:
                int value15 = DataCanbus.DATA[107] - 1;
                if (value15 < 0) {
                    value15 = 2;
                }
                setCarInfo(3, 1, value15);
                break;
            case R.id.btn_plus8 /* 2131427479 */:
                int value16 = DataCanbus.DATA[107] + 1;
                if (value16 > 2) {
                    value16 = 0;
                }
                setCarInfo(3, 1, value16);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(1, 6, DataCanbus.DATA[104] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(3, 2, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(3, 3, DataCanbus.DATA[109] != 1 ? 1 : 0);
                break;
        }
    }

    void setCarInfo(int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2, value3}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
