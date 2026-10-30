package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Acrivity_RZC_DashBord_Settings extends BaseActivity implements View.OnClickListener {
    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0298_rzc_dashboard_settings);
        setListener();
    }

    private void setListener() {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                DataCanbus.PROXY.cmd(105, new int[]{240, 0}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427561 */:
                DataCanbus.PROXY.cmd(105, new int[]{241, 1}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427562 */:
                DataCanbus.PROXY.cmd(105, new int[]{242, 0}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427576 */:
                DataCanbus.PROXY.cmd(105, new int[]{240, 1}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427577 */:
                DataCanbus.PROXY.cmd(105, new int[]{241, 0}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427581 */:
                DataCanbus.PROXY.cmd(105, new int[]{242, 1}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                DataCanbus.PROXY.cmd(105, new int[]{243, 0}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                DataCanbus.PROXY.cmd(105, new int[]{243, 1}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                DataCanbus.PROXY.cmd(105, new int[]{244, 0}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                DataCanbus.PROXY.cmd(105, new int[]{244, 1}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                DataCanbus.PROXY.cmd(105, new int[]{245, 0}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                DataCanbus.PROXY.cmd(105, new int[]{245, 1}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427638 */:
                DataCanbus.PROXY.cmd(105, new int[]{247, 0}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427639 */:
                DataCanbus.PROXY.cmd(105, new int[]{247, 1}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427640 */:
                DataCanbus.PROXY.cmd(105, new int[]{248, 0}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427641 */:
                DataCanbus.PROXY.cmd(105, new int[]{248, 1}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427642 */:
                DataCanbus.PROXY.cmd(105, new int[]{246, 0}, null, null);
                break;
            case R.id.ctv_checkedtext18 /* 2131427764 */:
                DataCanbus.PROXY.cmd(105, new int[]{249, 0}, null, null);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                DataCanbus.PROXY.cmd(105, new int[]{249, 1}, null, null);
                break;
        }
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
