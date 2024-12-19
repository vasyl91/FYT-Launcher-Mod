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

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ODBeiqiBJ80CarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.sanlin.ODBeiqiBJ80CarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 87:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText("15S");
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText("30S");
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text1)).setText("45S");
                                break;
                        }
                    }
                    break;
                case 88:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text2)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_only_light);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text2)).setText(R.string.klc_remote_Remote_control_latch_light_Speaker);
                                break;
                        }
                    }
                    break;
                case 89:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_low);
                                break;
                            case 2:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_middle);
                                break;
                            case 3:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text3)).setText(R.string.klc_air_high);
                                break;
                        }
                    }
                    break;
                case 90:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(val).toString());
                        break;
                    }
                case 91:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext1), val == 1);
                    break;
                case 92:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext2), val == 1);
                    break;
                case 93:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext3), val == 1);
                    break;
                case 94:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext4), val == 1);
                    break;
                case 95:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext5), val == 1);
                    break;
                case 96:
                    ODBeiqiBJ80CarSet.this.setCheck((CheckedTextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.ctv_checkedtext6), val == 1);
                    break;
                case 97:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_metric);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text5)).setText(R.string.str_unit_us_imperial);
                                break;
                        }
                    }
                    break;
                case 98:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text6)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text6)).setText("℃");
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text6)).setText("℉");
                                break;
                        }
                    }
                    break;
                case 99:
                    if (((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text7)) != null) {
                        switch (val) {
                            case 0:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_bogoo_bmw_time_format_1);
                                break;
                            case 1:
                                ((TextView) ODBeiqiBJ80CarSet.this.findViewById(R.id.tv_text7)).setText(R.string.str_bogoo_bmw_time_format_0);
                                break;
                        }
                    }
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_od_beiqi_bj80_settings);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[91];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(6, value);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value2 = DataCanbus.DATA[87] - 1;
                if (value2 < 0) {
                    value2 = 3;
                }
                setCarInfo(2, value2);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value3 = DataCanbus.DATA[87] + 1;
                if (value3 > 3) {
                    value3 = 0;
                }
                setCarInfo(2, value3);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value4 = DataCanbus.DATA[88] - 1;
                if (value4 < 0) {
                    value4 = 1;
                }
                setCarInfo(3, value4);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value5 = DataCanbus.DATA[88] + 1;
                if (value5 > 1) {
                    value5 = 0;
                }
                setCarInfo(3, value5);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value6 = DataCanbus.DATA[89] - 1;
                if (value6 < 0) {
                    value6 = 3;
                }
                setCarInfo(4, value6);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value7 = DataCanbus.DATA[89] + 1;
                if (value7 > 3) {
                    value7 = 0;
                }
                setCarInfo(4, value7);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value8 = DataCanbus.DATA[90] - 1;
                if (value8 < 1) {
                    value8 = 7;
                }
                setCarInfo(5, value8);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value9 = DataCanbus.DATA[90] + 1;
                if (value9 > 7) {
                    value9 = 1;
                }
                setCarInfo(5, value9);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value10 = DataCanbus.DATA[97] - 1;
                if (value10 < 0) {
                    value10 = 1;
                }
                setCarInfo(12, value10);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value11 = DataCanbus.DATA[97] + 1;
                if (value11 > 1) {
                    value11 = 0;
                }
                setCarInfo(12, value11);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value12 = DataCanbus.DATA[98] - 1;
                if (value12 < 0) {
                    value12 = 1;
                }
                setCarInfo(13, value12);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value13 = DataCanbus.DATA[98] + 1;
                if (value13 > 1) {
                    value13 = 0;
                }
                setCarInfo(13, value13);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value14 = DataCanbus.DATA[99] - 1;
                if (value14 < 0) {
                    value14 = 1;
                }
                setCarInfo(14, value14);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value15 = DataCanbus.DATA[99] + 1;
                if (value15 > 1) {
                    value15 = 0;
                }
                setCarInfo(14, value15);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value16 = DataCanbus.DATA[92];
                if (value16 == 1) {
                    value16 = 0;
                } else if (value16 == 0) {
                    value16 = 1;
                }
                setCarInfo(7, value16);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value17 = DataCanbus.DATA[93];
                if (value17 == 1) {
                    value17 = 0;
                } else if (value17 == 0) {
                    value17 = 1;
                }
                setCarInfo(8, value17);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value18 = DataCanbus.DATA[94];
                if (value18 == 1) {
                    value18 = 0;
                } else if (value18 == 0) {
                    value18 = 1;
                }
                setCarInfo(9, value18);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value19 = DataCanbus.DATA[95];
                if (value19 == 1) {
                    value19 = 0;
                } else if (value19 == 0) {
                    value19 = 1;
                }
                setCarInfo(10, value19);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value20 = DataCanbus.DATA[96];
                if (value20 == 1) {
                    value20 = 0;
                } else if (value20 == 0) {
                    value20 = 1;
                }
                setCarInfo(11, value20);
                break;
        }
    }

    public void setCarInfo(int value1, int value2) {
        DataCanbus.PROXY.cmd(0, new int[]{value1, value2}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(1, new int[]{64}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        setCarInfo(0, 1);
        DataCanbus.NOTIFY_EVENTS[87].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[88].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[89].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[90].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[87].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[88].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[89].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[90].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
    }
}
