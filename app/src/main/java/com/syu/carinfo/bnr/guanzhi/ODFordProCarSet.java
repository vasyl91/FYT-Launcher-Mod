package com.syu.carinfo.bnr.guanzhi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ODFordProCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 107:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("0S");
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 2:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            case 3:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text1)).setText("120S");
                                break;
                        }
                    }
                    break;
                case 108:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)).setText("5min");
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)).setText("10min");
                                break;
                            case 2:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text2)).setText("15min");
                                break;
                        }
                    }
                    break;
                case 109:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 110:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 111:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 112:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text3)).setText("5min");
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text3)).setText("10min");
                                break;
                        }
                    }
                    break;
                case 117:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 118:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 119:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 120:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 121:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 131:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 132:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 133:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 134:
                    ODFordProCarSet.this.setCheck((CheckedTextView) ODFordProCarSet.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
                case 135:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text4)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text4)).setText("15s");
                                break;
                            case 2:
                                ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text4)).setText("30s");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODFordProCarSet.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value) + "%");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_ford_pro_settings);
        init();
    }

    @Override
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[107] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[107] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[108] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[108] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[135] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(17, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[135] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(17, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[136];
                if (value9 > 0) {
                    value9 -= 5;
                }
                if (value9 < 0) {
                    value9 = 0;
                }
                setCarInfo(18, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[136];
                if (value10 < 100) {
                    value10 += 5;
                }
                if (value10 > 100) {
                    value10 = 100;
                }
                setCarInfo(18, value10);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(1, DataCanbus.DATA[106] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(4, DataCanbus.DATA[109] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                setCarInfo(5, DataCanbus.DATA[110] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                setCarInfo(6, DataCanbus.DATA[111] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                setCarInfo(8, DataCanbus.DATA[117] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                setCarInfo(9, DataCanbus.DATA[118] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                setCarInfo(10, DataCanbus.DATA[119] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                setCarInfo(11, DataCanbus.DATA[120] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                setCarInfo(12, DataCanbus.DATA[121] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                setCarInfo(13, DataCanbus.DATA[131] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                setCarInfo(14, DataCanbus.DATA[132] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                setCarInfo(15, DataCanbus.DATA[133] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                setCarInfo(16, DataCanbus.DATA[134] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(1, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(0, new int[]{65}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
    }
}
