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

@SuppressWarnings({"deprecation", "unchecked"})
public class Oudi_0452_Hongqi_CarSettingAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 119:
                    if (((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 120:
                    if (((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("开启四门");
                                break;
                            case 1:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("开启司机门");
                                break;
                        }
                    }
                    break;
                case 121:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 122:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 123:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 124:
                    if (((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("驾驶门");
                                break;
                            case 1:
                                ((TextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("所有车门");
                                break;
                        }
                    }
                    break;
                case 125:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 126:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 127:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 128:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 129:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 130:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 131:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 132:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 133:
                    Oudi_0452_Hongqi_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0452_Hongqi_CarSettingAct.this.findViewById(R.id.ctv_checkedtext13), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_hongqi_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[119] - 10;
                if (value < 30) {
                    value = 220;
                }
                setCarInfo(147, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[119] + 10;
                if (value2 > 220) {
                    value2 = 30;
                }
                setCarInfo(147, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[120];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(148, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[120];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(148, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[124];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(152, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[124];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(152, value6);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value7 = DataCanbus.DATA[118];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(146, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value8 = DataCanbus.DATA[121];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(149, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value9 = DataCanbus.DATA[122];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(150, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value10 = DataCanbus.DATA[123];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(151, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value11 = DataCanbus.DATA[125];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(153, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value12 = DataCanbus.DATA[126];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(154, value12);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value13 = DataCanbus.DATA[127];
                if (value13 == 1) {
                    value13 = 0;
                } else if (value13 == 0) {
                    value13 = 1;
                }
                setCarInfo(155, value13);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value14 = DataCanbus.DATA[128];
                if (value14 == 1) {
                    value14 = 0;
                } else if (value14 == 0) {
                    value14 = 1;
                }
                setCarInfo(156, value14);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value15 = DataCanbus.DATA[129];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(157, value15);
                break;
            case R.id.ctv_checkedtext10 /* 2131427552 */:
                int value16 = DataCanbus.DATA[130];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(158, value16);
                break;
            case R.id.ctv_checkedtext11 /* 2131427553 */:
                int value17 = DataCanbus.DATA[131];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(159, value17);
                break;
            case R.id.ctv_checkedtext12 /* 2131427554 */:
                int value18 = DataCanbus.DATA[132];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(160, value18);
                break;
            case R.id.ctv_checkedtext13 /* 2131427555 */:
                int value19 = DataCanbus.DATA[133];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(161, value19);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(1, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{65}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
    }
}
