package com.syu.carinfo.rzc.xima;

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
public class LZ_Nissan22TuleAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.LZ_Nissan22TuleAmpCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 134:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 135:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 136:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 137:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 138:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 139:
                    LZ_Nissan22TuleAmpCarSet.this.setCheck((CheckedTextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 141:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
                case 142:
                    if (((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) LZ_Nissan22TuleAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_lz_nissan_teana_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.layout_view9).setVisibility(8);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
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
                setCarInfo(0, 0);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                setCarInfo(0, 1);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                setCarInfo(1, 0);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                setCarInfo(1, 1);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                setCarInfo(3, 0);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                setCarInfo(3, 1);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                setCarInfo(5, 0);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                setCarInfo(5, 1);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                setCarInfo(4, 0);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                setCarInfo(4, 1);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                setCarInfo(6, 0);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                setCarInfo(6, 1);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                setCarInfo(8, 0);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                setCarInfo(8, 1);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(7, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{59, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
    }
}
