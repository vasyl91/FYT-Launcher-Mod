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
public class RZCNissanAmpCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 147:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 148:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 149:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 150:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 151:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 152:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 153:
                    RZCNissanAmpCarSet.this.setCheck((CheckedTextView) RZCNissanAmpCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 154:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 155:
                    RZCNissanAmpCarSet.this.setCheck((CheckedTextView) RZCNissanAmpCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 181:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text8)).setText(R.string.jeep_parksense_1);
                                break;
                        }
                    }
                    break;
                case 182:
                    if (((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_2);
                                break;
                            case 2:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_0);
                                break;
                            case 3:
                                ((TextView) RZCNissanAmpCarSet.this.findViewById(R.id.tv_text9)).setText(R.string.jeep_parksense_1);
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
        //setContentView(R.layout.layout_0190_rzc_nissan_amp_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarInfo(33, 49);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(33, 33);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(34, 49);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(34, 33);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarInfo(35, 49);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(35, 33);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarInfo(36, 49);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarInfo(36, 33);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarInfo(37, 49);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarInfo(37, 33);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(38, 49);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(38, 33);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(40, 49);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(40, 33);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                int value = DataCanbus.DATA[181] - 1;
                if (value < 0) {
                    value = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value}, null, null);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                int value2 = DataCanbus.DATA[181] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{35, value2}, null, null);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value3 = DataCanbus.DATA[182] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value3}, null, null);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value4 = DataCanbus.DATA[182] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                DataCanbus.PROXY.cmd(3, new int[]{34, value4}, null, null);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[153];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(39, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value6 = DataCanbus.DATA[155];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(41, value6);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(3, new int[]{147}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[181].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[182].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[181].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[182].removeNotify(this.mNotifyCanbus);
    }
}
