package com.syu.carinfo.rzc.sanlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WC2FordMDOCarSeatSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 113:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 114:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 115:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text5)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 116:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 117:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 118:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text6)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 120:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text7)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text7)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 121:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text10)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 122:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text9)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 123:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text8)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 124:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text13)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text13)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text13)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text13)).setText(R.string.wc_372_high);
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text14)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text14)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text14)).setText(R.string.wc_372_low);
                                break;
                            case 2:
                                ((TextView) WC2FordMDOCarSeatSet.this.findViewById(R.id.tv_text14)).setText(R.string.wc_372_high);
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
        //setContentView(R.layout.layout_0021_wc_ford_seat_settings);
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
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus13), this);
        setSelfClick((Button) findViewById(R.id.btn_plus13), this);
        setSelfClick((Button) findViewById(R.id.btn_minus14), this);
        setSelfClick((Button) findViewById(R.id.btn_plus14), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                setCarInfo(10, 240);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                setCarInfo(10, 241);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                setCarInfo(9, 240);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                setCarInfo(9, 241);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                setCarInfo(8, 240);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                setCarInfo(8, 241);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                setCarInfo(24, 240);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                setCarInfo(24, 241);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                setCarInfo(25, 240);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                setCarInfo(25, 241);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value = DataCanbus.DATA[119] - 1;
                if (value < 0) {
                    value = 2;
                }
                setCarInfo(11, value);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value2 = DataCanbus.DATA[119] + 1;
                if (value2 > 2) {
                    value2 = 0;
                }
                setCarInfo(11, value2);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value3 = DataCanbus.DATA[120] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(12, value3);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value4 = DataCanbus.DATA[120] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(12, value4);
                break;
            case R.id.btn_minus8 /* 2131427476 */:
                setCarInfo(16, 240);
                break;
            case R.id.btn_plus8 /* 2131427478 */:
                setCarInfo(16, 241);
                break;
            case R.id.btn_minus9 /* 2131427479 */:
                setCarInfo(15, 240);
                break;
            case R.id.btn_plus9 /* 2131427481 */:
                setCarInfo(15, 241);
                break;
            case R.id.btn_minus10 /* 2131427482 */:
                setCarInfo(14, 240);
                break;
            case R.id.btn_plus10 /* 2131427484 */:
                setCarInfo(14, 241);
                break;
            case R.id.btn_minus11 /* 2131427485 */:
                setCarInfo(26, 240);
                break;
            case R.id.btn_plus11 /* 2131427487 */:
                setCarInfo(26, 241);
                break;
            case R.id.btn_minus12 /* 2131427488 */:
                setCarInfo(27, 240);
                break;
            case R.id.btn_plus12 /* 2131427490 */:
                setCarInfo(27, 241);
                break;
            case R.id.btn_minus13 /* 2131427491 */:
                int value5 = DataCanbus.DATA[124] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(17, value5);
                break;
            case R.id.btn_plus13 /* 2131427493 */:
                int value6 = DataCanbus.DATA[124] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(17, value6);
                break;
            case R.id.btn_minus14 /* 2131427494 */:
                int value7 = DataCanbus.DATA[125] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(18, value7);
                break;
            case R.id.btn_plus14 /* 2131427496 */:
                int value8 = DataCanbus.DATA[125] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(18, value8);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(17, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }
}
