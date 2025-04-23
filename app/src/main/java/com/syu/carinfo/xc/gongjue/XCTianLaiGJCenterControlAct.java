package com.syu.carinfo.xc.gongjue;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class XCTianLaiGJCenterControlAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    XCTianLaiGJCenterControlAct.this.setCheck((CheckedTextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 99:
                    ((TextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder(String.valueOf(val)).toString());
                    break;
                case 100:
                    XCTianLaiGJCenterControlAct.this.setCheck((CheckedTextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 101:
                    XCTianLaiGJCenterControlAct.this.setCheck((CheckedTextView) XCTianLaiGJCenterControlAct.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 102:
                    XCTianLaiGJCenterControlAct.this.updateHeadLightOffDelay(val);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_xc_tianlai_gj_center_control);
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
                int value = DataCanbus.DATA[99] - 1;
                if (value >= 0) {
                    cmd(3, value);
                    break;
                }
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 <= 7) {
                    cmd(3, value2);
                    break;
                }
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[102] - 1;
                if (value3 >= 0) {
                    cmd(4, value3);
                    break;
                }
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[102];
                if (value4 <= 7) {
                    cmd(4, value4);
                    break;
                }
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[98] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                cmd(2, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value6 = DataCanbus.DATA[100] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                cmd(5, value6);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value7 = DataCanbus.DATA[101] + 1;
                if (value7 > 1) {
                    value7 = 0;
                }
                cmd(7, value7);
                break;
        }
    }

    private void cmd(int data0, int data1) {
        DataCanbus.PROXY.cmd(0, new int[]{data0, data1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void updateHeadLightOffDelay(int value) {
        int second = 0;
        switch (value) {
            case 1:
                second = 30;
                break;
            case 2:
                second = 45;
                break;
            case 3:
                second = 60;
                break;
            case 4:
                second = 90;
                break;
            case 5:
                second = 120;
                break;
            case 6:
                second = 150;
                break;
            case 7:
                second = 180;
                break;
        }
        ((TextView) findViewById(R.id.tv_text2)).setText(String.valueOf(second) + "s");
    }
}
