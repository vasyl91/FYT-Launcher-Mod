package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODRuichiEC75CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 98:
                    ODRuichiEC75CarSet.this.setCheck((CheckedTextView) ODRuichiEC75CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 99:
                    if (((TextView) ODRuichiEC75CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODRuichiEC75CarSet.this.findViewById(R.id.tv_text1)).setText("直接下电");
                                break;
                            case 1:
                                ((TextView) ODRuichiEC75CarSet.this.findViewById(R.id.tv_text1)).setText("延时30分钟");
                                break;
                            case 2:
                                ((TextView) ODRuichiEC75CarSet.this.findViewById(R.id.tv_text1)).setText("延时60分钟");
                                break;
                            case 3:
                                ((TextView) ODRuichiEC75CarSet.this.findViewById(R.id.tv_text1)).setText("延时90分钟");
                                break;
                            case 4:
                                ((TextView) ODRuichiEC75CarSet.this.findViewById(R.id.tv_text1)).setText("延时620分钟");
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0455_od_ruichi_ec75_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[99] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[99] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value3 = DataCanbus.DATA[98];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(1, value3);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64}, null, null);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
