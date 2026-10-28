package com.syu.carinfo.honda;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Acrivity_RZC_DashBord_Settings extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0298_rzc_dashboard_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                DataCanbus.PROXY.cmd(105, new int[]{240}, null, null);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                DataCanbus.PROXY.cmd(105, new int[]{240, 1}, null, null);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                DataCanbus.PROXY.cmd(105, new int[]{241}, null, null);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                DataCanbus.PROXY.cmd(105, new int[]{241, 1}, null, null);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                DataCanbus.PROXY.cmd(105, new int[]{242}, null, null);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                DataCanbus.PROXY.cmd(105, new int[]{242, 1}, null, null);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                DataCanbus.PROXY.cmd(105, new int[]{243}, null, null);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                DataCanbus.PROXY.cmd(105, new int[]{243, 1}, null, null);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                DataCanbus.PROXY.cmd(105, new int[]{244}, null, null);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                DataCanbus.PROXY.cmd(105, new int[]{244, 1}, null, null);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                DataCanbus.PROXY.cmd(105, new int[]{245}, null, null);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                DataCanbus.PROXY.cmd(105, new int[]{245, 1}, null, null);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                DataCanbus.PROXY.cmd(105, new int[]{247}, null, null);
                break;
            case R.id.ctv_checkedtext14 /* 2131427556 */:
                DataCanbus.PROXY.cmd(105, new int[]{247, 1}, null, null);
                break;
            case R.id.ctv_checkedtext15 /* 2131427557 */:
                DataCanbus.PROXY.cmd(105, new int[]{248}, null, null);
                break;
            case R.id.ctv_checkedtext16 /* 2131427558 */:
                DataCanbus.PROXY.cmd(105, new int[]{248, 1}, null, null);
                break;
            case R.id.ctv_checkedtext17 /* 2131427559 */:
                DataCanbus.PROXY.cmd(105, new int[]{246}, null, null);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
