package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class BmwTimeSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwTimeSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 15:
                    BmwTimeSetAct.this.updaterHour();
                    break;
                case 16:
                    BmwTimeSetAct.this.updaterMinute();
                    break;
                case 17:
                    BmwTimeSetAct.this.updaterDay();
                    break;
                case 18:
                    BmwTimeSetAct.this.updaterMonth();
                    break;
                case 19:
                    BmwTimeSetAct.this.updaterYear();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_haozheng_bmw_time);
        init();
        setUI();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    private void setUI() {
        ((Button) findViewById(R.id.btn_minus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_minus5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_plus5)).setOnClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterHour() {
        int hourValue = DataCanbus.DATA[15];
        if (hourValue < 0) {
            hourValue = 0;
        } else if (hourValue > 23) {
            hourValue = 23;
        }
        ((TextView) findViewById(R.id.tv_text1)).setText(new StringBuilder().append(hourValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMinute() {
        int minuteValue = DataCanbus.DATA[16];
        if (minuteValue < 0) {
            minuteValue = 0;
        } else if (minuteValue > 59) {
            minuteValue = 59;
        }
        ((TextView) findViewById(R.id.tv_text2)).setText(new StringBuilder().append(minuteValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDay() {
        int dayValue = DataCanbus.DATA[17];
        if (dayValue < 1) {
            dayValue = 1;
        } else if (dayValue > 31) {
            dayValue = 31;
        }
        ((TextView) findViewById(R.id.tv_text3)).setText(new StringBuilder().append(dayValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMonth() {
        int monthValue = DataCanbus.DATA[18];
        if (monthValue < 1) {
            monthValue = 1;
        } else if (monthValue > 12) {
            monthValue = 12;
        }
        ((TextView) findViewById(R.id.tv_text4)).setText(new StringBuilder().append(monthValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterYear() {
        int yearValue = DataCanbus.DATA[19];
        if (yearValue < 0) {
            yearValue = 0;
        } else if (yearValue > 99) {
            yearValue = 99;
        }
        if (yearValue >= 0 && yearValue < 10) {
            ((TextView) findViewById(R.id.tv_text5)).setText("200" + yearValue);
        } else {
            ((TextView) findViewById(R.id.tv_text5)).setText("20" + yearValue);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int hourValue = DataCanbus.DATA[15];
        int minuteValue = DataCanbus.DATA[16];
        int dayValue = DataCanbus.DATA[17];
        int monthValue = DataCanbus.DATA[18];
        int yearValue = DataCanbus.DATA[19];
        switch (v.getId()) {
            case R.id.btn_minus1 /* 2131427456 */:
                int value1 = hourValue - 1;
                if (value1 >= 0) {
                    BmwFunc.CAR_TIME_SET(value1, minuteValue, dayValue, monthValue, yearValue);
                }
                break;
            case R.id.btn_plus1 /* 2131427458 */:
                int value2 = hourValue + 1;
                if (value2 <= 23) {
                    BmwFunc.CAR_TIME_SET(value2, minuteValue, dayValue, monthValue, yearValue);
                }
                break;
            case R.id.btn_minus2 /* 2131427459 */:
                int value3 = minuteValue - 1;
                if (value3 > 0) {
                    BmwFunc.CAR_TIME_SET(hourValue, value3, dayValue, monthValue, yearValue);
                }
                break;
            case R.id.btn_plus2 /* 2131427461 */:
                int value4 = minuteValue + 1;
                if (value4 < 59) {
                    BmwFunc.CAR_TIME_SET(hourValue, value4, dayValue, monthValue, yearValue);
                }
                break;
            case R.id.btn_minus3 /* 2131427462 */:
                int value5 = dayValue - 1;
                if (value5 >= 0) {
                    BmwFunc.CAR_TIME_SET(hourValue, minuteValue, value5, monthValue, yearValue);
                }
                break;
            case R.id.btn_plus3 /* 2131427464 */:
                int value6 = dayValue + 1;
                if (value6 <= 31) {
                    BmwFunc.CAR_TIME_SET(hourValue, minuteValue, value6, monthValue, yearValue);
                }
                break;
            case R.id.btn_minus4 /* 2131427465 */:
                int value7 = monthValue - 1;
                if (value7 > 0) {
                    BmwFunc.CAR_TIME_SET(hourValue, minuteValue, dayValue, value7, yearValue);
                }
                break;
            case R.id.btn_plus4 /* 2131427467 */:
                int value8 = monthValue + 1;
                if (value8 <= 12) {
                    BmwFunc.CAR_TIME_SET(hourValue, minuteValue, dayValue, value8, yearValue);
                }
                break;
            case R.id.btn_minus5 /* 2131427468 */:
                int value9 = yearValue - 1;
                if (value9 > 0) {
                    BmwFunc.CAR_TIME_SET(hourValue, minuteValue, dayValue, monthValue, value9);
                }
                break;
            case R.id.btn_plus5 /* 2131427470 */:
                int value10 = yearValue + 1;
                if (value10 < 99) {
                    BmwFunc.CAR_TIME_SET(hourValue, minuteValue, dayValue, monthValue, value10);
                }
                break;
        }
    }
}
