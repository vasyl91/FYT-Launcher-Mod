package com.syu.carinfo.rzc.ruifengs3;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class JhRuiFengEV7ChargeSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.ruifengs3.JhRuiFengEV7ChargeSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 52:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 53:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 54:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 55:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 56:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 58:
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
                case 59:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value) + " km");
                        break;
                    }
                case 60:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text3)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 61:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text4)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 62:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text5)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 63:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value / 10) + "." + (value % 10) + " km/kWh");
                        break;
                    }
                case 64:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text7)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 65:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text8)).setText(new StringBuilder(String.valueOf(value)).toString());
                        break;
                    }
                case 66:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text9)).setText(String.valueOf(value / 10) + "." + (value % 10));
                        break;
                    }
                case 67:
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
                case 68:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text11)).setText(String.valueOf(value / 10) + "." + (value % 10) + " A");
                        break;
                    }
                case 69:
                    if (((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.tv_text12)).setText(String.valueOf(value / 10) + "." + (value % 10) + " V");
                        break;
                    }
                case 70:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 71:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 72:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 73:
                    JhRuiFengEV7ChargeSetFunc.this.setCheck((CheckedTextView) JhRuiFengEV7ChargeSetFunc.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0452_od_jianghuai_ev7_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[52];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(18, value);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value2 = DataCanbus.DATA[53];
                if (value2 == 1) {
                    value2 = 0;
                } else if (value2 == 0) {
                    value2 = 1;
                }
                setCarInfo(19, value2);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value3 = DataCanbus.DATA[54];
                if (value3 == 1) {
                    value3 = 0;
                } else if (value3 == 0) {
                    value3 = 1;
                }
                setCarInfo(20, value3);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value4 = DataCanbus.DATA[55];
                if (value4 == 1) {
                    value4 = 0;
                } else if (value4 == 0) {
                    value4 = 1;
                }
                setCarInfo(21, value4);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value5 = DataCanbus.DATA[56];
                if (value5 == 1) {
                    value5 = 0;
                } else if (value5 == 0) {
                    value5 = 1;
                }
                setCarInfo(22, value5);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value6 = DataCanbus.DATA[70];
                if (value6 == 1) {
                    value6 = 0;
                } else if (value6 == 0) {
                    value6 = 1;
                }
                setCarInfo(23, value6);
                break;
            case R.id.ctv_checkedtext7 /* 2131427539 */:
                int value7 = DataCanbus.DATA[71];
                if (value7 == 1) {
                    value7 = 0;
                } else if (value7 == 0) {
                    value7 = 1;
                }
                setCarInfo(24, value7);
                break;
            case R.id.ctv_checkedtext8 /* 2131427540 */:
                int value8 = DataCanbus.DATA[72];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(25, value8);
                break;
            case R.id.ctv_checkedtext9 /* 2131427541 */:
                int value9 = DataCanbus.DATA[73];
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[60].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[61].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[62].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[63].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[64].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[69].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[60].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[61].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[62].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[63].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[69].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
    }
}
