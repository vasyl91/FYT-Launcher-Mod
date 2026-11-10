package com.syu.carinfo.zhtd.bmw;

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
public class LZNewAllNissanTuleSetFunc extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.zhtd.bmw.LZNewAllNissanTuleSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value) + "km");
                    break;
                case 152:
                    ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text13)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 153:
                    ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text15)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 158:
                    ((CheckedTextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.ctv_checkedtext3)).setChecked(value == 1);
                    break;
                case 168:
                    ((CheckedTextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.ctv_checkedtext5)).setChecked(value == 1);
                    break;
                case 170:
                    ((CheckedTextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.ctv_checkedtext7)).setChecked(value == 1);
                    break;
                case 173:
                    ((CheckedTextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.ctv_checkedtext4)).setChecked(value == 1);
                    break;
                case 189:
                    ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km");
                    break;
                case 190:
                    switch (value) {
                        case 0:
                            ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text2)).setText("BT");
                            break;
                        case 1:
                            ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text2)).setText("USB");
                            break;
                        case 2:
                            ((TextView) LZNewAllNissanTuleSetFunc.this.findViewById(R.id.tv_text2)).setText("AUX");
                            break;
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lz_nissan_tule_screen_setfunc);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext5), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        int value3;
        int value4;
        switch (v.getId()) {
            case R.id.btn_minus2 /* 2131427459 */:
                int value5 = DataCanbus.DATA[190] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(240, value5);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value6 = DataCanbus.DATA[190] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(240, value6);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value7 = DataCanbus.DATA[152];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(253, value7);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value8 = DataCanbus.DATA[152];
                if (value8 < 36) {
                    value8++;
                }
                setCarInfo(253, value8);
                break;
            case R.id.btn_minus14 /* 2131427495 */:
                int value9 = DataCanbus.DATA[153];
                if (value9 > 0) {
                    value9--;
                }
                setCarInfo(252, value9);
                break;
            case R.id.btn_plus14 /* 2131427497 */:
                int value10 = DataCanbus.DATA[153];
                if (value10 < 36) {
                    value10++;
                }
                setCarInfo(252, value10);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                if (DataCanbus.DATA[173] == 0) {
                    value3 = 1;
                } else {
                    value3 = 0;
                }
                setCarInfo(241, value3);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                if (DataCanbus.DATA[168] == 0) {
                    value2 = 1;
                } else {
                    value2 = 0;
                }
                setCarInfo(244, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                if (DataCanbus.DATA[158] == 0) {
                    value4 = 1;
                } else {
                    value4 = 0;
                }
                setCarInfo(247, value4);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                if (DataCanbus.DATA[170] == 0) {
                    value = 1;
                } else {
                    value = 0;
                }
                setCarInfo(242, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[190].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[189].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[190].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[189].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.notifyCanbus);
    }
}
