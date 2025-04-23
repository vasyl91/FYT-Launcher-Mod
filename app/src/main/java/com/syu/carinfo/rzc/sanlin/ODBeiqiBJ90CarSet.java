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

public class ODBeiqiBJ90CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 122:
                    ODBeiqiBJ90CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 123:
                    if (((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText("45S");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText("60S");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 124:
                    if (((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("45S");
                                break;
                            case 4:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText("60S");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.off);
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("运动");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text3)).setText("舒适");
                                break;
                        }
                    }
                    break;
                case 126:
                    if (((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        switch (val) {
                            case 1:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)).setText("运动");
                                break;
                            default:
                                ((TextView) ODBeiqiBJ90CarSet.this.findViewById(R.id.tv_text4)).setText("舒适");
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
        //setContentView(R.layout.layout_0453_od_beiqi_bj90_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus1), this);
        setSelfClick((Button) findViewById(R.id.btn_plus1), this);
        setSelfClick((Button) findViewById(R.id.btn_minus2), this);
        setSelfClick((Button) findViewById(R.id.btn_plus2), this);
        setSelfClick((Button) findViewById(R.id.btn_minus3), this);
        setSelfClick((Button) findViewById(R.id.btn_plus3), this);
        setSelfClick((Button) findViewById(R.id.btn_minus4), this);
        setSelfClick((Button) findViewById(R.id.btn_plus4), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[123] - 1;
                if (value < 0) {
                    value = 4;
                }
                setCarInfo(2, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[123] + 1;
                if (value2 > 4) {
                    value2 = 0;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[124] - 1;
                if (value3 < 0) {
                    value3 = 4;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[124] + 1;
                if (value4 > 4) {
                    value4 = 0;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[125] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[125] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[126] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(5, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[126] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(5, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[122];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(1, value9);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(4, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{66}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        setCarInfo(0, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }
}
