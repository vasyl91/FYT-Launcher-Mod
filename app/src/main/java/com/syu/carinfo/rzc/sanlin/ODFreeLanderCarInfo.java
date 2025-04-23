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

public class ODFreeLanderCarInfo extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    if (value == 65535) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text1)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + " L/100KM");
                        break;
                    }
                case 100:
                    if (value == 0) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text2)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 101:
                    if (value == 65535) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text3)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10.0f) + " L/100KM");
                        break;
                    }
                case 102:
                    if (value == 0) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text4)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 103:
                    if (value == 65535) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text5)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10.0f) + " L/100KM");
                        break;
                    }
                case 104:
                    if (value == 0) {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text6)).setText("----");
                        break;
                    } else {
                        ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 105:
                    ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                    break;
                case 106:
                    ODFreeLanderCarInfo.this.setCheck((CheckedTextView) ODFreeLanderCarInfo.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 107:
                    switch (value) {
                        case 0:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.off);
                            break;
                        case 1:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_low);
                            break;
                        case 2:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_middle);
                            break;
                        case 3:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text8)).setText(R.string.klc_air_high);
                            break;
                    }
                case 108:
                    switch (value) {
                        case 0:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_low);
                            break;
                        case 1:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_middle);
                            break;
                        case 2:
                            ((TextView) ODFreeLanderCarInfo.this.findViewById(R.id.tv_text9)).setText(R.string.klc_air_high);
                            break;
                    }
                case 109:
                    ODFreeLanderCarInfo.this.setCheck((CheckedTextView) ODFreeLanderCarInfo.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_freelander_carinfo);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{65}, null, null);
        DataCanbus.PROXY.cmd(1, new int[]{66}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                DataCanbus.PROXY.cmd(0, new int[]{52}, null, null);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                DataCanbus.PROXY.cmd(0, new int[]{51}, null, null);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value = DataCanbus.DATA[107] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value2 = DataCanbus.DATA[107] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value3 = DataCanbus.DATA[108] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value4 = DataCanbus.DATA[108] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value5 = DataCanbus.DATA[106];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(1, value5);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value6 = DataCanbus.DATA[109];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(4, value6);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(2, new int[]{value1, value2}, null, null);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
    }
}
