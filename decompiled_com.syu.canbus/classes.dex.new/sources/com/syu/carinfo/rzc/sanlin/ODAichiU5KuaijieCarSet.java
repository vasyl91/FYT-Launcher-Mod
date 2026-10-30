package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class ODAichiU5KuaijieCarSet extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0455_od_aichi_u5_kuaijie_settings);
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
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext18), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                setCarInfo(80, 1);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                setCarInfo(81, 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                setCarInfo(82, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                setCarInfo(80, 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                setCarInfo(81, 1);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                setCarInfo(82, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                setCarInfo(83, 1);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                setCarInfo(83, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                setCarInfo(84, 1);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                setCarInfo(84, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                setCarInfo(85, 1);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                setCarInfo(85, 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                setCarInfo(86, 1);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                setCarInfo(87, 1);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                setCarInfo(87, 0);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                setCarInfo(88, 1);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                setCarInfo(88, 0);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                setCarInfo(96, 1);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                setCarInfo(96, 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                setCarInfo(89, 1);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                setCarInfo(90, 1);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }
}
