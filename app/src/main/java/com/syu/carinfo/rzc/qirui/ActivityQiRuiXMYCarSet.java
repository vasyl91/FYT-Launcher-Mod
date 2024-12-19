package com.syu.carinfo.rzc.qirui;

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
public class ActivityQiRuiXMYCarSet extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.qirui.ActivityQiRuiXMYCarSet.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 131:
                    if (((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text3)) != null) {
                        if (value == 1) {
                            ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_sport);
                            break;
                        } else {
                            ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text3)).setText(R.string.str_driving_eco);
                            break;
                        }
                    }
                    break;
                case 132:
                    ActivityQiRuiXMYCarSet.this.setCheck((CheckedTextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 133:
                    ActivityQiRuiXMYCarSet.this.setCheck((CheckedTextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.ctv_checkedtext2), value == 1);
                    break;
                case 134:
                    ActivityQiRuiXMYCarSet.this.setCheck((CheckedTextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.ctv_checkedtext3), value == 1);
                    break;
                case 135:
                    ActivityQiRuiXMYCarSet.this.setCheck((CheckedTextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.ctv_checkedtext4), value == 1);
                    break;
                case 136:
                    ActivityQiRuiXMYCarSet.this.setCheck((CheckedTextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.ctv_checkedtext5), value == 1);
                    break;
                case 137:
                    ActivityQiRuiXMYCarSet.this.setCheck((CheckedTextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.ctv_checkedtext6), value == 1);
                    break;
                case 138:
                    if (((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
                case 139:
                    if (((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)) != null) {
                        switch (value) {
                            case 0:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText(R.string.off);
                                break;
                            case 1:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("1小时");
                                break;
                            case 2:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("1.5小时");
                                break;
                            case 3:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("2小时");
                                break;
                            case 4:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("2.5小时");
                                break;
                            case 5:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("3小时");
                                break;
                            case 6:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("3.5小时");
                                break;
                            case 7:
                                ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text5)).setText("4小时");
                                break;
                        }
                    }
                    break;
                case 140:
                    if (((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value / 10.0f) + "km");
                        break;
                    }
                case 141:
                    if (((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text2)).setText(String.valueOf(value / 5.0f) + "kwh/100km");
                        break;
                    }
                case 153:
                    if (((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) ActivityQiRuiXMYCarSet.this.findViewById(R.id.tv_text6)).setText(new StringBuilder().append(value).toString());
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0404_rzc_xmy_settings);
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value = DataCanbus.DATA[132];
                if (value == 1) {
                    value = 0;
                } else if (value == 0) {
                    value = 1;
                }
                setCarInfo(8, value);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value2 = DataCanbus.DATA[138] - 1;
                if (value2 < 1) {
                    value2 = 7;
                }
                setCarInfo(3, value2);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value3 = DataCanbus.DATA[138] + 1;
                if (value3 > 7) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value4 = DataCanbus.DATA[139] - 1;
                if (value4 < 0) {
                    value4 = 7;
                }
                setCarInfo(4, value4);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value5 = DataCanbus.DATA[139] + 1;
                if (value5 > 7) {
                    value5 = 0;
                }
                setCarInfo(4, value5);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value6 = DataCanbus.DATA[153] - 1;
                if (value6 < 1) {
                    value6 = 4;
                }
                setCarInfo(9, value6);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value7 = DataCanbus.DATA[153] + 1;
                if (value7 > 4) {
                    value7 = 1;
                }
                setCarInfo(9, value7);
                break;
            case R.id.ctv_checkedtext2 /* 2131427531 */:
                int value8 = DataCanbus.DATA[133];
                if (value8 == 1) {
                    value8 = 0;
                } else if (value8 == 0) {
                    value8 = 1;
                }
                setCarInfo(7, value8);
                break;
            case R.id.ctv_checkedtext3 /* 2131427532 */:
                int value9 = DataCanbus.DATA[134];
                if (value9 == 1) {
                    value9 = 0;
                } else if (value9 == 0) {
                    value9 = 1;
                }
                setCarInfo(6, value9);
                break;
            case R.id.ctv_checkedtext4 /* 2131427533 */:
                int value10 = DataCanbus.DATA[135];
                if (value10 == 1) {
                    value10 = 0;
                } else if (value10 == 0) {
                    value10 = 1;
                }
                setCarInfo(5, value10);
                break;
            case R.id.ctv_checkedtext5 /* 2131427537 */:
                int value11 = DataCanbus.DATA[136];
                if (value11 == 1) {
                    value11 = 0;
                } else if (value11 == 0) {
                    value11 = 1;
                }
                setCarInfo(2, value11);
                break;
            case R.id.ctv_checkedtext6 /* 2131427538 */:
                int value12 = DataCanbus.DATA[137];
                if (value12 == 1) {
                    value12 = 0;
                } else if (value12 == 0) {
                    value12 = 1;
                }
                setCarInfo(1, value12);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(2, new int[]{value0, value1}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
    }
}
