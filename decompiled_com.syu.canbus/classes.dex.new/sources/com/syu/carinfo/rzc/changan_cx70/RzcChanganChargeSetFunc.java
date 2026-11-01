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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RzcChanganChargeSetFunc extends BaseActivity implements View.OnClickListener {
    IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.changan_cx70.RzcChanganChargeSetFunc.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 195:
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
                    }
                    break;
                case 196:
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
                    }
                    break;
                case 197:
                    RzcChanganChargeSetFunc.this.setCheck((CheckedTextView) RzcChanganChargeSetFunc.this.findViewById(R.id.ctv_checkedtext1), value == 1);
                    break;
                case 198:
                    switch (value) {
                        case 1:
                            ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.mateng_air_con_profile_2);
                            break;
                        default:
                            ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text5)).setText(R.string.mateng_air_con_profile_0);
                            break;
                    }
                    break;
                case 199:
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text6)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text6)).setText(String.valueOf(value) + "%");
                    }
                    break;
                case 200:
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text7)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text7)).setText(String.valueOf(value) + "A");
                    }
                    break;
                case 201:
                    if (((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text8)) != null) {
                        ((TextView) RzcChanganChargeSetFunc.this.findViewById(R.id.tv_text8)).setText(String.valueOf(value / 8) + "km");
                    }
                    break;
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
            case R.id.btn_minus1 /* 2131427456 */:
                int value3 = DataCanbus.DATA[195];
                int value1 = DataCanbus.DATA[196];
                int hour = (value3 >> 7) & 31;
                int minute = (value3 >> 1) & 63;
                int hour1 = (value1 >> 7) & 31;
                int minute1 = (value1 >> 1) & 63;
                int hour2 = hour - 1;
                if (hour2 < 0) {
                    hour2 = 23;
                }
                setCarInfo1(1, hour2, minute, hour1, minute1);
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value4 = DataCanbus.DATA[195];
                int value5 = DataCanbus.DATA[196];
                int hour3 = (value4 >> 7) & 31;
                int minute2 = (value4 >> 1) & 63;
                int hour4 = (value5 >> 7) & 31;
                int minute3 = (value5 >> 1) & 63;
                int hour5 = hour3 + 1;
                if (hour5 > 23) {
                    hour5 = 0;
                }
                setCarInfo1(1, hour5, minute2, hour4, minute3);
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value6 = DataCanbus.DATA[195];
                int value7 = DataCanbus.DATA[196];
                int hour6 = (value6 >> 7) & 31;
                int minute4 = (value6 >> 1) & 63;
                int hour7 = (value7 >> 7) & 31;
                int minute5 = (value7 >> 1) & 63;
                int minute6 = minute4 - 1;
                if (minute6 < 0) {
                    minute6 = 59;
                }
                setCarInfo1(1, hour6, minute6, hour7, minute5);
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value8 = DataCanbus.DATA[195];
                int value9 = DataCanbus.DATA[196];
                int hour8 = (value8 >> 7) & 31;
                int minute7 = (value8 >> 1) & 63;
                int hour9 = (value9 >> 7) & 31;
                int minute8 = (value9 >> 1) & 63;
                int minute9 = minute7 + 1;
                if (minute9 > 59) {
                    minute9 = 0;
                }
                setCarInfo1(1, hour8, minute9, hour9, minute8);
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value10 = DataCanbus.DATA[195];
                int value11 = DataCanbus.DATA[196];
                int hour10 = (value10 >> 7) & 31;
                int minute10 = (value10 >> 1) & 63;
                int hour11 = (value11 >> 7) & 31;
                int minute11 = (value11 >> 1) & 63;
                int hour12 = hour11 - 1;
                if (hour12 < 0) {
                    hour12 = 23;
                }
                setCarInfo1(1, hour10, minute10, hour12, minute11);
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value12 = DataCanbus.DATA[195];
                int value13 = DataCanbus.DATA[196];
                int hour13 = (value12 >> 7) & 31;
                int minute12 = (value12 >> 1) & 63;
                int hour14 = (value13 >> 7) & 31;
                int minute13 = (value13 >> 1) & 63;
                int hour15 = hour14 + 1;
                if (hour15 > 23) {
                    hour15 = 0;
                }
                setCarInfo1(1, hour13, minute12, hour15, minute13);
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value14 = DataCanbus.DATA[195];
                int value15 = DataCanbus.DATA[196];
                int hour16 = (value14 >> 7) & 31;
                int minute14 = (value14 >> 1) & 63;
                int hour17 = (value15 >> 7) & 31;
                int minute15 = ((value15 >> 1) & 63) - 1;
                if (minute15 < 0) {
                    minute15 = 59;
                }
                setCarInfo1(1, hour16, minute14, hour17, minute15);
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value16 = DataCanbus.DATA[195];
                int value17 = DataCanbus.DATA[196];
                int hour18 = (value16 >> 7) & 31;
                int minute16 = (value16 >> 1) & 63;
                int hour19 = (value17 >> 7) & 31;
                int minute17 = ((value17 >> 1) & 63) + 1;
                if (minute17 > 59) {
                    minute17 = 0;
                }
                setCarInfo1(1, hour18, minute16, hour19, minute17);
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value18 = DataCanbus.DATA[198] - 1;
                if (value18 < 0) {
                    value18 = 1;
                }
                setCarInfo(2, value18);
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value19 = DataCanbus.DATA[198] + 1;
                if (value19 > 1) {
                    value19 = 0;
                }
                setCarInfo(2, value19);
                break;
            case R.id.btn_minus6 /* 2131427471 */:
                int value20 = DataCanbus.DATA[199] - 1;
                if (value20 < 60) {
                    value20 = 60;
                }
                setCarInfo(4, value20);
                break;
            case R.id.btn_plus6 /* 2131427473 */:
                int value21 = DataCanbus.DATA[199] + 1;
                if (value21 < 100) {
                    value21 = 100;
                }
                setCarInfo(4, value21);
                break;
            case R.id.btn_minus7 /* 2131427474 */:
                int value22 = DataCanbus.DATA[200];
                if (value22 == 8) {
                    value2 = 32;
                } else if (value22 == 10) {
                    value2 = 8;
                } else if (value22 == 16) {
                    value2 = 10;
                } else if (value22 == 32) {
                    value2 = 16;
                } else {
                    value2 = 8;
                }
                setCarInfo(5, value2);
                break;
            case R.id.btn_plus7 /* 2131427476 */:
                int value23 = DataCanbus.DATA[200];
                if (value23 == 8) {
                    value = 10;
                } else if (value23 == 10) {
                    value = 16;
                } else if (value23 != 16 && value23 == 32) {
                    value = 8;
                } else {
                    value = 32;
                }
                setCarInfo(5, value);
                break;
            case R.id.ctv_checkedtext1 /* 2131427554 */:
                int value24 = DataCanbus.DATA[198];
                if (value24 == 1) {
                    value24 = 8;
                } else if (value24 == 8) {
                    value24 = 1;
                }
                setCarInfo(3, value24);
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
        DataCanbus.PROXY.cmd(5, new int[]{83, 0}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[198].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[199].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[200].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[201].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[198].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[199].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[200].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[201].removeNotify(this.mNotifyCanbus);
    }
}
