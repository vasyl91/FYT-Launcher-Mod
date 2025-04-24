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

@SuppressWarnings({"deprecation", "unchecked"})
public class RZCNissanJUKECarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 156:
                    RZCNissanJUKECarSet.this.setCheck((CheckedTextView) RZCNissanJUKECarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 157:
                    RZCNissanJUKECarSet.this.setCheck((CheckedTextView) RZCNissanJUKECarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 158:
                    RZCNissanJUKECarSet.this.setCheck((CheckedTextView) RZCNissanJUKECarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 181:
                    if (((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text3)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNissanJUKECarSet.this.findViewById(R.id.tv_text4)).setText(R.string.jeep_parksense_1);
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
        //setContentView(R.layout.layout_0190_rzc_nissan_juke_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus3 /* 2131427461 */:
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value}, null, null);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value2 = DataCanbus.DATA[181] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value2}, null, null);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value3 = DataCanbus.DATA[182] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value3}, null, null);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value4 = DataCanbus.DATA[182] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value4}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(82, 1);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(83, 1);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(81, 1);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{149}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[157].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[158].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[157].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[158].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }
}
