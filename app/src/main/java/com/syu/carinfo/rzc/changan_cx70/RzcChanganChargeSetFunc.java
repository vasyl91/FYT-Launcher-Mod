package com.syu.carinfo.rzc.changan_cx70;

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
public class RzcChanganChargeSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganChargeSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    int year = (value >> 24) & 127;
                    int month = (value >> 20) & 15;
                    int monthDay = (value >> 12) & 31;
                    int hour = (value >> 7) & 31;
                    int minute = (value >> 1) & 63;
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text9)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text9)).setText("20" + (year / 10) + (year % 10) + "-" + (month / 10) + (month % 10) + "-" + (monthDay / 10) + (monthDay % 10));
                    }
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text1)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text1)).setText(new StringBuilder().append(hour).toString());
                    }
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text2)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text2)).setText(new StringBuilder().append(minute).toString());
                        break;
                    }
                case 119:
                    int year2 = (value >> 24) & 127;
                    int month2 = (value >> 20) & 15;
                    int monthDay2 = (value >> 12) & 31;
                    int hour2 = (value >> 7) & 31;
                    int minute2 = (value >> 1) & 63;
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text10)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text10)).setText("20" + (year2 / 10) + (year2 % 10) + "-" + (month2 / 10) + (month2 % 10) + "-" + (monthDay2 / 10) + (monthDay2 % 10));
                    }
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text3)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text3)).setText(new StringBuilder().append(hour2).toString());
                    }
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text4)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text4)).setText(new StringBuilder().append(minute2).toString());
                        break;
                    }
                case 120:
                    RzcChanganChargeSetFunc.this.setCheck((CheckedTextView) RzcChanganChargeSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 121:
                    switch (value) {
                        case 1:
                            ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        default:
                            ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.mateng_air_con_profile_0);
                            break;
                    }
                case 122:
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                        break;
                    }
                case 123:
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "A");
                        break;
                    }
                case 124:
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 8) + "km");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0453_rzc_changan_cs15_charge);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
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
        setSelfClick((Button) findViewById(R.id.btn_minus5), this);
        setSelfClick((Button) findViewById(R.id.btn_plus5), this);
        setSelfClick((Button) findViewById(R.id.btn_minus6), this);
        setSelfClick((Button) findViewById(R.id.btn_plus6), this);
        setSelfClick((Button) findViewById(R.id.btn_minus7), this);
        setSelfClick((Button) findViewById(R.id.btn_plus7), this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int value;
        int value2;
        switch (v.getId()) {
            case R.id.ctv_checkedtext1 /* 2131427478 */:
                int value3 = DataCanbus.DATA[121];
                if (value3 == 1) {
                    value3 = 8;
                } else if (value3 == 8) {
                    value3 = 1;
                }
                setCarInfo(3, value3);
                break;
            case R.id.btn_minus1 /* 2131427480 */:
                int value4 = DataCanbus.DATA[118];
                int value1 = DataCanbus.DATA[119];
                int hour = (value4 >> 7) & 31;
                int minute = (value4 >> 1) & 63;
                int hour1 = (value1 >> 7) & 31;
                int minute1 = (value1 >> 1) & 63;
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                setCarInfo1(1, hour2, minute, hour1, minute1);
                break;
            case R.id.btn_plus1 /* 2131427482 */:
                int value5 = DataCanbus.DATA[118];
                int value12 = DataCanbus.DATA[119];
                int hour3 = (value5 >> 7) & 31;
                int minute2 = (value5 >> 1) & 63;
                int hour12 = (value12 >> 7) & 31;
                int minute12 = (value12 >> 1) & 63;
                int hour4 = hour3 + 1;
                if (hour4 > 23) {
                    hour4 = 0;
                }
                setCarInfo1(1, hour4, minute2, hour12, minute12);
                break;
            case R.id.btn_minus2 /* 2131427484 */:
                int value6 = DataCanbus.DATA[118];
                int value13 = DataCanbus.DATA[119];
                int hour5 = (value6 >> 7) & 31;
                int minute3 = (value6 >> 1) & 63;
                int hour13 = (value13 >> 7) & 31;
                int minute13 = (value13 >> 1) & 63;
                int minute4 = minute3 - 1;
                if (minute4 < 0) {
                    minute4 = 59;
                }
                setCarInfo1(1, hour5, minute4, hour13, minute13);
                break;
            case R.id.btn_plus2 /* 2131427486 */:
                int value7 = DataCanbus.DATA[118];
                int value14 = DataCanbus.DATA[119];
                int hour6 = (value7 >> 7) & 31;
                int minute5 = (value7 >> 1) & 63;
                int hour14 = (value14 >> 7) & 31;
                int minute14 = (value14 >> 1) & 63;
                int minute6 = minute5 + 1;
                if (minute6 > 59) {
                    minute6 = 0;
                }
                setCarInfo1(1, hour6, minute6, hour14, minute14);
                break;
            case R.id.btn_minus3 /* 2131427488 */:
                int value8 = DataCanbus.DATA[118];
                int value15 = DataCanbus.DATA[119];
                int hour7 = (value8 >> 7) & 31;
                int minute7 = (value8 >> 1) & 63;
                int hour15 = (value15 >> 7) & 31;
                int minute15 = (value15 >> 1) & 63;
                int hour16 = hour15 - 1;
                if (hour16 < 0) {
                    hour16 = 23;
                }
                setCarInfo1(1, hour7, minute7, hour16, minute15);
                break;
            case R.id.btn_plus3 /* 2131427490 */:
                int value9 = DataCanbus.DATA[118];
                int value16 = DataCanbus.DATA[119];
                int hour8 = (value9 >> 7) & 31;
                int minute8 = (value9 >> 1) & 63;
                int hour17 = (value16 >> 7) & 31;
                int minute16 = (value16 >> 1) & 63;
                int hour18 = hour17 + 1;
                if (hour18 > 23) {
                    hour18 = 0;
                }
                setCarInfo1(1, hour8, minute8, hour18, minute16);
                break;
            case R.id.btn_minus4 /* 2131427492 */:
                int value10 = DataCanbus.DATA[118];
                int value17 = DataCanbus.DATA[119];
                int hour9 = (value10 >> 7) & 31;
                int minute9 = (value10 >> 1) & 63;
                int hour19 = (value17 >> 7) & 31;
                int minute17 = ((value17 >> 1) & 63) - 1;
                if (minute17 < 0) {
                    minute17 = 59;
                }
                setCarInfo1(1, hour9, minute9, hour19, minute17);
                break;
            case R.id.btn_plus4 /* 2131427494 */:
                int value11 = DataCanbus.DATA[118];
                int value18 = DataCanbus.DATA[119];
                int hour10 = (value11 >> 7) & 31;
                int minute10 = (value11 >> 1) & 63;
                int hour110 = (value18 >> 7) & 31;
                int minute18 = ((value18 >> 1) & 63) + 1;
                if (minute18 > 59) {
                    minute18 = 0;
                }
                setCarInfo1(1, hour10, minute10, hour110, minute18);
                break;
            case R.id.btn_minus5 /* 2131427496 */:
                int value19 = DataCanbus.DATA[121] - 1;
                if (value19 < 0) {
                    value19 = 1;
                }
                setCarInfo(2, value19);
                break;
            case R.id.btn_plus5 /* 2131427498 */:
                int value20 = DataCanbus.DATA[121] + 1;
                if (value20 > 1) {
                    value20 = 0;
                }
                setCarInfo(2, value20);
                break;
            case R.id.btn_minus6 /* 2131427501 */:
                int value21 = DataCanbus.DATA[122] - 1;
                if (value21 < 60) {
                    value21 = 60;
                }
                setCarInfo(4, value21);
                break;
            case R.id.btn_plus6 /* 2131427503 */:
                int value22 = DataCanbus.DATA[122] + 1;
                if (value22 < 100) {
                    value22 = 100;
                }
                setCarInfo(4, value22);
                break;
            case R.id.btn_minus7 /* 2131427505 */:
                int value23 = DataCanbus.DATA[123];
                if (value23 == 8) {
                    value2 = 32;
                } else if (value23 == 10) {
                    value2 = 8;
                } else if (value23 == 16) {
                    value2 = 10;
                } else if (value23 == 32) {
                    value2 = 16;
                } else {
                    value2 = 8;
                }
                setCarInfo(5, value2);
                break;
            case R.id.btn_plus7 /* 2131427507 */:
                int value24 = DataCanbus.DATA[123];
                if (value24 == 8) {
                    value = 10;
                } else if (value24 == 10) {
                    value = 16;
                } else if (value24 == 16) {
                    value = 32;
                } else if (value24 == 32) {
                    value = 8;
                } else {
                    value = 32;
                }
                setCarInfo(5, value);
                break;
        }
    }

    public void setCarInfo(int value0, int value1) {
        DataCanbus.PROXY.cmd(4, new int[]{value0, value1}, null, null);
    }

    public void setCarInfo1(int value0, int value1, int value2, int value3, int value4) {
        DataCanbus.PROXY.cmd(3, new int[]{value0, value1, value2, value3, value4}, null, null);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(5, new int[]{83}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
    }
}
