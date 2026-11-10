package com.syu.carinfo.wc.leinuo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Megane4UserSetActi extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.leinuo.Megane4UserSetActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 125:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext7), value == 1);
                    break;
                case 126:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext8), value == 1);
                    break;
                case 127:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext9), value == 1);
                    break;
                case 128:
                    if (((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text11)) != null) {
                        ((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text11)).setText(new StringBuilder().append(value + 1).toString());
                    }
                    break;
                case 129:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext10), value == 1);
                    break;
                case 130:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext11), value == 1);
                    break;
                case 131:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext12), value == 1);
                    break;
                case 132:
                    if (((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text12)) != null) {
                        ((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text12)).setText(new StringBuilder().append(value * 5).toString());
                    }
                    break;
                case 142:
                    if (((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text17)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_low);
                                break;
                            case 1:
                                ((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_middle);
                                break;
                            case 2:
                                ((TextView) Megane4UserSetActi.this.findViewById(R.id.tv_text17)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 143:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext19), value == 1);
                    break;
                case 144:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext20), value == 1);
                    break;
                case 145:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext21), value == 1);
                    break;
                case 146:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext22), value == 1);
                    break;
                case 147:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext23), value == 1);
                    break;
                case 148:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext24), value == 1);
                    break;
                case 149:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext25), value == 1);
                    break;
                case 150:
                    Megane4UserSetActi.this.setCheck((CheckedTextView) Megane4UserSetActi.this.findViewById(R.id.ctv_checkedtext26), value == 1);
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0352_wc_magane_user_settings);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext7), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext8), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext9), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext10), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext11), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext12), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext19), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext20), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext21), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext22), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext23), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext24), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext25), this);
        setSelfClick((CheckedTextView) findViewById(R.id.ctv_checkedtext26), this);
        setSelfClick((Button) findViewById(R.id.btn_minus11), this);
        setSelfClick((Button) findViewById(R.id.btn_plus11), this);
        setSelfClick((Button) findViewById(R.id.btn_minus12), this);
        setSelfClick((Button) findViewById(R.id.btn_plus12), this);
        setSelfClick((Button) findViewById(R.id.btn_minus17), this);
        setSelfClick((Button) findViewById(R.id.btn_plus17), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_minus11 /* 2131427486 */:
                int value = DataCanbus.DATA[128];
                if (value > 0) {
                    value--;
                }
                setCarInfo(20, value, 0, 0);
                break;
            case R.id.btn_plus11 /* 2131427488 */:
                int value2 = DataCanbus.DATA[128];
                if (value2 < 2) {
                    value2++;
                }
                setCarInfo(20, value2, 0, 0);
                break;
            case R.id.btn_minus12 /* 2131427489 */:
                int value3 = DataCanbus.DATA[132];
                if (value3 > 0) {
                    value3--;
                }
                setCarInfo(24, value3, 0, 0);
                break;
            case R.id.btn_plus12 /* 2131427491 */:
                int value4 = DataCanbus.DATA[132];
                if (value4 < 20) {
                    value4++;
                }
                setCarInfo(24, value4, 0, 0);
                break;
            case R.id.btn_minus17 /* 2131427504 */:
                int value5 = DataCanbus.DATA[142] - 1;
                if (value5 < 0) {
                    value5 = 2;
                }
                setCarInfo(36, value5, 0, 0);
                break;
            case R.id.btn_plus17 /* 2131427506 */:
                int value6 = DataCanbus.DATA[142] + 1;
                if (value6 > 2) {
                    value6 = 0;
                }
                setCarInfo(36, value6, 0, 0);
                break;
            case R.id.ctv_checkedtext7 /* 2131427582 */:
                int value7 = DataCanbus.DATA[125];
                if (value7 == 0) {
                    value7 = 1;
                } else if (value7 == 1) {
                    value7 = 0;
                }
                setCarInfo(17, value7, 0, 0);
                break;
            case R.id.ctv_checkedtext8 /* 2131427633 */:
                int value8 = DataCanbus.DATA[126];
                if (value8 == 0) {
                    value8 = 1;
                } else if (value8 == 1) {
                    value8 = 0;
                }
                setCarInfo(18, value8, 0, 0);
                break;
            case R.id.ctv_checkedtext9 /* 2131427634 */:
                int value9 = DataCanbus.DATA[127];
                if (value9 == 0) {
                    value9 = 1;
                } else if (value9 == 1) {
                    value9 = 0;
                }
                setCarInfo(19, value9, 0, 0);
                break;
            case R.id.ctv_checkedtext10 /* 2131427635 */:
                int value10 = DataCanbus.DATA[129];
                if (value10 == 0) {
                    value10 = 1;
                } else if (value10 == 1) {
                    value10 = 0;
                }
                setCarInfo(21, value10, 0, 0);
                break;
            case R.id.ctv_checkedtext11 /* 2131427636 */:
                int value11 = DataCanbus.DATA[130];
                if (value11 == 0) {
                    value11 = 1;
                } else if (value11 == 1) {
                    value11 = 0;
                }
                setCarInfo(22, value11, 0, 0);
                break;
            case R.id.ctv_checkedtext12 /* 2131427637 */:
                int value12 = DataCanbus.DATA[131];
                if (value12 == 0) {
                    value12 = 1;
                } else if (value12 == 1) {
                    value12 = 0;
                }
                setCarInfo(23, value12, 0, 0);
                break;
            case R.id.ctv_checkedtext19 /* 2131427766 */:
                int value13 = DataCanbus.DATA[143];
                if (value13 == 0) {
                    value13 = 1;
                } else if (value13 == 1) {
                    value13 = 0;
                }
                setCarInfo(37, value13, 0, 0);
                break;
            case R.id.ctv_checkedtext20 /* 2131427768 */:
                int value14 = DataCanbus.DATA[144];
                if (value14 == 0) {
                    value14 = 1;
                } else if (value14 == 1) {
                    value14 = 0;
                }
                setCarInfo(38, value14, 0, 0);
                break;
            case R.id.ctv_checkedtext21 /* 2131427770 */:
                int value15 = DataCanbus.DATA[145];
                if (value15 == 0) {
                    value15 = 1;
                } else if (value15 == 1) {
                    value15 = 0;
                }
                setCarInfo(39, value15, 0, 0);
                break;
            case R.id.ctv_checkedtext22 /* 2131427772 */:
                int value16 = DataCanbus.DATA[146];
                if (value16 == 0) {
                    value16 = 1;
                } else if (value16 == 1) {
                    value16 = 0;
                }
                setCarInfo(40, value16, 0, 0);
                break;
            case R.id.ctv_checkedtext23 /* 2131427775 */:
                int value17 = DataCanbus.DATA[147];
                if (value17 == 0) {
                    value17 = 1;
                } else if (value17 == 1) {
                    value17 = 0;
                }
                setCarInfo(41, value17, 0, 0);
                break;
            case R.id.ctv_checkedtext24 /* 2131427780 */:
                int value18 = DataCanbus.DATA[148];
                if (value18 == 0) {
                    value18 = 1;
                } else if (value18 == 1) {
                    value18 = 0;
                }
                setCarInfo(42, value18, 0, 0);
                break;
            case R.id.ctv_checkedtext25 /* 2131427782 */:
                int value19 = DataCanbus.DATA[149];
                if (value19 == 0) {
                    value19 = 1;
                } else if (value19 == 1) {
                    value19 = 0;
                }
                setCarInfo(43, value19, 0, 0);
                break;
            case R.id.ctv_checkedtext26 /* 2131427824 */:
                int value20 = DataCanbus.DATA[150];
                if (value20 == 0) {
                    value20 = 1;
                } else if (value20 == 1) {
                    value20 = 0;
                }
                setCarInfo(44, value20, 0, 0);
                break;
        }
    }

    public void setCarInfo(int value0, int value1, int value2, int value3) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1, value2, value3}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[128].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[129].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[132].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[128].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[129].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
    }
}
