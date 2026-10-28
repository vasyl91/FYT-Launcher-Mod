package com.syu.carinfo.wc2.ford;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC2FordLincoinCarSeatSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 166:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 167:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 168:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 169:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text4)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 170:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text5)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 171:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 172:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text7)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 173:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 174:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text9)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text9)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text9)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 175:
                    if (((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text10)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordLincoinCarSeatSet.this.findViewById(R.id.tv_text10)).setText(R.string.wc_372_high);
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
        //setContentView(R.layout.layout_0443_wc_ford_seat_settings);
        init();
    }

    @Override
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
        setSelfClick((Button) findViewById(R.id.btn_minus9), this);
        setSelfClick((Button) findViewById(R.id.btn_plus9), this);
        setSelfClick((Button) findViewById(R.id.btn_minus10), this);
        setSelfClick((Button) findViewById(R.id.btn_plus10), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarInfo(8, 240);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(8, 241);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(9, 240);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(9, 241);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarInfo(10, 240);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(10, 241);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value = DataCanbus.DATA[169] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(11, value);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value2 = DataCanbus.DATA[169] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(11, value2);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value3 = DataCanbus.DATA[170] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value4 = DataCanbus.DATA[170] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                setCarInfo(14, 240);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                setCarInfo(14, 241);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                setCarInfo(15, 240);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                setCarInfo(15, 241);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(16, 240);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(16, 241);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                int value5 = DataCanbus.DATA[174] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                int value6 = DataCanbus.DATA[174] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                int value7 = DataCanbus.DATA[175] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(18, value7);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                int value8 = DataCanbus.DATA[175] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(18, value8);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(5, new int[]{value0, value1, 255, 255}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[166].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[173].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[174].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[175].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[166].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[173].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[174].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[175].removeNotify(this.mNotifyCanbus);
    }
}
