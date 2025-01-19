package com.syu.carinfo.oudi.hantengx5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Oudi_0453_JMC_EV3_CarSettingAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 119:
                    Oudi_0453_JMC_EV3_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 120:
                    Oudi_0453_JMC_EV3_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 121:
                    if (((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 122:
                    Oudi_0453_JMC_EV3_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 124:
                    if (((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("0s");
                                break;
                            case 1:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("30s");
                                break;
                            case 2:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("60s");
                                break;
                            case 3:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("90s");
                                break;
                        }
                    }
                    break;
                case 125:
                    if (((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(R.string.rzc_c4l_close);
                                break;
                            case 1:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text4)).setText(R.string.rzc_c4l_open);
                                break;
                            case 2:
                                ((TextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.tv_text4)).setText("随小灯关闭");
                                break;
                        }
                    }
                    break;
                case 126:
                    Oudi_0453_JMC_EV3_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0453_JMC_EV3_CarSettingAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0453_od_jmc_ev3_settings);
        init();
    }

    @Override
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext1), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext2), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext3), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext4), this);
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
                int value = DataCanbus.DATA[118] - 1;
                if (value < 0) {
                    value = 3;
                }
                setCarInfo(1, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[118] + 1;
                if (value2 > 3) {
                    value2 = 0;
                }
                setCarInfo(1, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[121] - 1;
                if (value3 < 0) {
                    value3 = 3;
                }
                setCarInfo(4, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[121] + 1;
                if (value4 > 3) {
                    value4 = 0;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[124] - 1;
                if (value5 < 0) {
                    value5 = 3;
                }
                setCarInfo(7, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[124] + 1;
                if (value6 > 3) {
                    value6 = 0;
                }
                setCarInfo(7, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[125] - 1;
                if (value7 < 0) {
                    value7 = 2;
                }
                setCarInfo(8, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[125] + 1;
                if (value8 > 2) {
                    value8 = 0;
                }
                setCarInfo(8, value8);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value9 = DataCanbus.DATA[119];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(2, value9);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value10 = DataCanbus.DATA[120];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(3, value10);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value11 = DataCanbus.DATA[122];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(5, value11);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value12 = DataCanbus.DATA[126];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(9, value12);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
    }
}
