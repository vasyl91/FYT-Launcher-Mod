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
public class ODHuachenSWMChargeCarInfo extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 108:
                    ODHuachenSWMChargeCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 109:
                    ODHuachenSWMChargeCarInfo.this.setCheck((CheckedTextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 110:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text1)).setText("纯电优先");
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text1)).setText("油电混合");
                                break;
                        }
                    }
                    break;
                case 111:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text2)).setText("智能保电");
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text2)).setText("强制保电");
                                break;
                        }
                    }
                    break;
                case 112:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text3)).setText("标准");
                                break;
                            case 1:
                                ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text3)).setText("较强");
                                break;
                        }
                    }
                    break;
                case 113:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text4)).setText(String.valueOf(val) + "%");
                        break;
                    }
                case 114:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text5)).setText(new StringBuilder(String.valueOf(val)).toString());
                        break;
                    }
                case 115:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text6)).setText(new StringBuilder(String.valueOf(val)).toString());
                        break;
                    }
                case 116:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text7)).setText(String.valueOf(val) + " km");
                        break;
                    }
                case 117:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text8)).setText(String.valueOf(val) + " km");
                        break;
                    }
                case 118:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text9)).setText(String.valueOf(val) + " km");
                        break;
                    }
                case 119:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text10)).setText(String.valueOf(val / 10) + "." + (val % 10) + "L");
                        break;
                    }
                case 120:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text11)).setText(String.valueOf(val / 10) + "." + (val % 10) + "kw/h");
                        break;
                    }
                case 121:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text12)).setText(String.valueOf(val) + "%");
                        break;
                    }
                case 122:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text13)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text13)).setText(String.valueOf(val / 10) + "." + (val % 10) + "kw");
                        break;
                    }
                case 123:
                    if (((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text14)) != null) {
                        ((TextView) ODHuachenSWMChargeCarInfo.this.findViewById(R.id.tv_text14)).setText(String.valueOf(val / 10) + "." + (val % 10) + "kwh");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_swm_charge_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[110] - 1;
                if (value < 0) {
                    value = 1;
                }
                setCarInfo(13, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[110] + 1;
                if (value2 > 1) {
                    value2 = 0;
                }
                setCarInfo(13, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[111] - 1;
                if (value3 < 0) {
                    value3 = 1;
                }
                setCarInfo(14, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[111] + 1;
                if (value4 > 1) {
                    value4 = 0;
                }
                setCarInfo(14, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[112] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(15, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[112] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(15, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[113];
                if (value7 > 0) {
                    value7--;
                }
                setCarInfo(16, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[113];
                if (value8 < 70) {
                    value8++;
                }
                setCarInfo(16, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[114] - 1;
                if (value9 < 0) {
                    value9 = 23;
                }
                setCarInfo(19, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[114] + 1;
                if (value10 > 23) {
                    value10 = 0;
                }
                setCarInfo(19, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[115] - 1;
                if (value11 < 0) {
                    value11 = 59;
                }
                setCarInfo(20, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[115] + 1;
                if (value12 > 59) {
                    value12 = 0;
                }
                setCarInfo(20, value12);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                setCarInfo(17, DataCanbus.DATA[108] != 1 ? 1 : 0);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                setCarInfo(18, DataCanbus.DATA[109] != 1 ? 1 : 0);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{4}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
    }
}
