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

public class Oudi_0454_Hongqi_EQM5_CarSettingAct extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 134:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 135:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text2)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("舒适");
                                break;
                            case 1:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("中度");
                                break;
                            case 2:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text2)).setText("高效");
                                break;
                        }
                    }
                    break;
                case 136:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text3)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("标准");
                                break;
                            case 1:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text3)).setText("节能");
                                break;
                        }
                    }
                    break;
                case 137:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 138:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 139:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 140:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 141:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text4)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text4)).setText("报警+制动");
                                break;
                            case 1:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text4)).setText("报警");
                                break;
                        }
                    }
                    break;
                case 142:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text5)).setText("低");
                                break;
                            case 1:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text5)).setText("中");
                                break;
                            case 2:
                                ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text5)).setText("高");
                                break;
                        }
                    }
                    break;
                case 143:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 144:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "km/h");
                        break;
                    }
                case 145:
                    if (((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 146:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 147:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 148:
                    Oudi_0454_Hongqi_EQM5_CarSettingAct.this.setCheck((CheckedTextView) Oudi_0454_Hongqi_EQM5_CarSettingAct.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0454_od_hongqi_eqm5_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427455 */:
                int value = DataCanbus.DATA[134] - 1;
                if (value < 1) {
                    value = 1;
                }
                setCarInfo(146, value);
                break;
            case R.id.btn_plus1 /* 2131427457 */:
                int value2 = DataCanbus.DATA[134] + 1;
                if (value2 > 80) {
                    value2 = 80;
                }
                setCarInfo(146, value2);
                break;
            case R.id.btn_minus2 /* 2131427458 */:
                int value3 = DataCanbus.DATA[135] - 1;
                if (value3 < 0) {
                    value3 = 2;
                }
                setCarInfo(147, value3);
                break;
            case R.id.btn_plus2 /* 2131427460 */:
                int value4 = DataCanbus.DATA[135] + 1;
                if (value4 > 2) {
                    value4 = 0;
                }
                setCarInfo(147, value4);
                break;
            case R.id.btn_minus3 /* 2131427461 */:
                int value5 = DataCanbus.DATA[136] - 1;
                if (value5 < 0) {
                    value5 = 1;
                }
                setCarInfo(148, value5);
                break;
            case R.id.btn_plus3 /* 2131427463 */:
                int value6 = DataCanbus.DATA[136] + 1;
                if (value6 > 1) {
                    value6 = 0;
                }
                setCarInfo(148, value6);
                break;
            case R.id.btn_minus4 /* 2131427464 */:
                int value7 = DataCanbus.DATA[141] - 1;
                if (value7 < 0) {
                    value7 = 1;
                }
                setCarInfo(153, value7);
                break;
            case R.id.btn_plus4 /* 2131427466 */:
                int value8 = DataCanbus.DATA[141] + 1;
                if (value8 > 1) {
                    value8 = 0;
                }
                setCarInfo(153, value8);
                break;
            case R.id.btn_minus5 /* 2131427467 */:
                int value9 = DataCanbus.DATA[142] - 1;
                if (value9 < 0) {
                    value9 = 2;
                }
                setCarInfo(154, value9);
                break;
            case R.id.btn_plus5 /* 2131427469 */:
                int value10 = DataCanbus.DATA[142] + 1;
                if (value10 > 2) {
                    value10 = 0;
                }
                setCarInfo(154, value10);
                break;
            case R.id.btn_minus6 /* 2131427470 */:
                int value11 = DataCanbus.DATA[144] - 5;
                if (value11 < 30) {
                    value11 = 30;
                }
                setCarInfo(156, value11);
                break;
            case R.id.btn_plus6 /* 2131427472 */:
                int value12 = DataCanbus.DATA[144] + 5;
                if (value12 > 220) {
                    value12 = 220;
                }
                setCarInfo(156, value12);
                break;
            case R.id.btn_minus7 /* 2131427473 */:
                int value13 = DataCanbus.DATA[145] - 1;
                if (value13 < 1) {
                    value13 = 1;
                }
                setCarInfo(157, value13);
                break;
            case R.id.btn_plus7 /* 2131427475 */:
                int value14 = DataCanbus.DATA[145] + 1;
                if (value14 > 5) {
                    value14 = 5;
                }
                setCarInfo(157, value14);
                break;
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value15 = DataCanbus.DATA[137];
                if (value15 == 1) {
                    value15 = 0;
                } else if (value15 == 0) {
                    value15 = 1;
                }
                setCarInfo(149, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value16 = DataCanbus.DATA[138];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(150, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value17 = DataCanbus.DATA[139];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(151, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value18 = DataCanbus.DATA[140];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(152, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value19 = DataCanbus.DATA[143];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(155, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value20 = DataCanbus.DATA[146];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(158, value20);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value21 = DataCanbus.DATA[147];
                if (value21 == 1) {
                    value21 = 0;
                } else if (value21 == 0) {
                    value21 = 1;
                }
                setCarInfo(159, value21);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value22 = DataCanbus.DATA[148];
                if (value22 == 1) {
                    value22 = 0;
                } else if (value22 == 0) {
                    value22 = 1;
                }
                setCarInfo(160, value22);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1}, null, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(2, new int[]{66}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
    }
}
