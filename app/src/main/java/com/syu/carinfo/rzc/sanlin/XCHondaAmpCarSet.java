package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class XCHondaAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.XCHondaAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 87:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 88:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 89:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 90:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 92:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 93:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 94:
                    if (((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) XCHondaAmpCarSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_xc_honda_amp_settings);
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
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427480 */:
                setCarInfo(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                setCarInfo(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                setCarInfo(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                setCarInfo(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                setCarInfo(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                setCarInfo(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                setCarInfo(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                setCarInfo(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                setCarInfo(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                setCarInfo(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                setCarInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                setCarInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                setCarInfo(48, 49);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                setCarInfo(48, 33);
                break;
            case R.id.btn_minus8 /* 2131427509 */:
                setCarInfo(49, 49);
                break;
            case R.id.btn_plus8 /* 2131427511 */:
                setCarInfo(49, 33);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{115}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
    }
}
