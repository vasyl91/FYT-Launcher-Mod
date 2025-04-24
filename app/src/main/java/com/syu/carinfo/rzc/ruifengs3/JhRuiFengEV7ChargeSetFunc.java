package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class JhRuiFengEV7ChargeSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 126:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 127:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 128:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 129:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 130:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 132:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        if (value >= 0 && value <= 4) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("1/12");
                            break;
                        } else if (value >= 5 && value <= 15) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("2/12");
                            break;
                        } else if (value >= 16 && value <= 23) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("3/12");
                            break;
                        } else if (value >= 24 && value <= 31) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("4/12");
                            break;
                        } else if (value >= 32 && value <= 39) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("5/12");
                            break;
                        } else if (value >= 40 && value <= 47) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("6/12");
                            break;
                        } else if (value >= 48 && value <= 55) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("7/12");
                            break;
                        } else if (value >= 56 && value <= 63) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("8/12");
                            break;
                        } else if (value >= 64 && value <= 71) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("9/12");
                            break;
                        } else if (value >= 72 && value <= 79) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("10/12");
                            break;
                        } else if (value >= 80 && value <= 87) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("11/12");
                            break;
                        } else if (value >= 88 && value <= 255) {
                            ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text1)).setText("12/12");
                            break;
                        }
                    }
                    break;
                case 133:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 134:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 135:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 136:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 137:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 138:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 139:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 140:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
                case 141:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text10)).setText("----");
                                break;
                            case 1:
                                ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text10)).setText("普通充电");
                                break;
                            case 2:
                                ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text10)).setText("长寿充电");
                                break;
                            case 3:
                                ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text10)).setText("低温充电");
                                break;
                            case 4:
                                ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text10)).setText("长程充电");
                                break;
                        }
                    }
                    break;
                case 142:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                        break;
                    }
                case 143:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                        break;
                    }
                case 144:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 145:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 146:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 147:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0452_od_jianghuai_ev7_settings);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427525 */:
                int value = DataCanbus.DATA[126];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(18, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427541 */:
                int value2 = DataCanbus.DATA[127];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(19, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427542 */:
                int value3 = DataCanbus.DATA[128];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(20, value3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427544 */:
                int value4 = DataCanbus.DATA[129];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(21, value4);
                break;
            case R.id.ctv_checkedtext5 /* 2131427547 */:
                int value5 = DataCanbus.DATA[130];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(22, value5);
                break;
            case R.id.ctv_checkedtext6 /* 2131427548 */:
                int value6 = DataCanbus.DATA[144];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(23, value6);
                break;
            case R.id.ctv_checkedtext7 /* 2131427549 */:
                int value7 = DataCanbus.DATA[145];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(24, value7);
                break;
            case R.id.ctv_checkedtext8 /* 2131427550 */:
                int value8 = DataCanbus.DATA[146];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(25, value8);
                break;
            case R.id.ctv_checkedtext9 /* 2131427551 */:
                int value9 = DataCanbus.DATA[147];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(26, value9);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(0, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[133].addNotify(this.mNotifyCanbus, 1);
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
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
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
    }
}
