package com.syu.carinfo.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.air.AirHelper;

public class BMWX1CarSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 29:
                    BMWX1CarSetActi.this.updateText1();
                    break;
                case 30:
                    BMWX1CarSetActi.this.updateText2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0230_wc_bmw_x1_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(6);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(7);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(3);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(4);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(5);
                break;
        }
    }

    public void setCarInfo(int value) {
        DataCanbus.PROXY.cmd(6, new int[]{value}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AirHelper.disableAirWindowLocal(true);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AirHelper.disableAirWindowLocal(false);
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[29].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateText2() {
        int value = DataCanbus.DATA[30];
        if (((TextView) findViewById(R.id.tv_text2)) != null) {
            ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }

    
    public void updateText1() {
        int value = DataCanbus.DATA[29];
        if (((TextView) findViewById(R.id.tv_text1)) != null) {
            ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(value)).toString());
        }
    }
}
