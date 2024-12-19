package com.syu.carinfo.wc2.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WC2FordLincoinAmpInfoAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc2.ford.WC2FordLincoinAmpInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 50:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text1)) != null && val <= 30 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 51:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text2)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 52:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text3)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 53:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text4)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 54:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text5)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 55:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text6)) != null && val <= 14 && val >= 0) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 56:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 57:
                    if (((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text8)) != null) {
                        if (val == 1) {
                            ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_Parking_with_trailer_ON);
                            break;
                        } else {
                            ((TextView) WC2FordLincoinAmpInfoAct.this.findViewById(R.id.tv_text8)).setText(R.string.klc_Parking_with_trailer_Off);
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
        setContentView(R.layout.layout_0452_xc_tianlai_gj_amp_info);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
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
        int data = 0;
        int value = 0;
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                value = DataCanbus.DATA[50] - 1;
                data = 1;
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                value = DataCanbus.DATA[50] + 1;
                data = 1;
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                value = DataCanbus.DATA[51] - 1;
                data = 2;
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                value = DataCanbus.DATA[51] + 1;
                data = 2;
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                value = DataCanbus.DATA[52] - 1;
                data = 3;
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                value = DataCanbus.DATA[52] + 1;
                data = 3;
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                value = DataCanbus.DATA[53] - 1;
                data = 4;
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                value = DataCanbus.DATA[53] + 1;
                data = 4;
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                value = DataCanbus.DATA[54] - 1;
                data = 5;
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                value = DataCanbus.DATA[54] + 1;
                data = 5;
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                value = DataCanbus.DATA[55] - 1;
                data = 6;
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                value = DataCanbus.DATA[55] + 1;
                data = 6;
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                value = DataCanbus.DATA[56] - 1;
                data = 7;
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                value = DataCanbus.DATA[56] + 1;
                data = 7;
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                value = DataCanbus.DATA[57] - 1;
                data = 8;
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                value = DataCanbus.DATA[57] + 1;
                data = 8;
                break;
        }
        cmd(data, value);
    }

    private void cmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(3, new int[]{data0, data1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
    }
}
