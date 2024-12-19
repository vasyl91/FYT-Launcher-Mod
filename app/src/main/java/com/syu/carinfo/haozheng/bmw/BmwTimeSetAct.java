package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class BmwTimeSetAct extends BaseActivity implements View.OnClickListener {
    int dayValue;
    int hourValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.haozheng.bmw.BmwTimeSetAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 8:
                    BmwTimeSetAct.this.updaterHour();
                    break;
                case 9:
                    BmwTimeSetAct.this.updaterMinute();
                    break;
                case 10:
                    BmwTimeSetAct.this.updaterDay();
                    break;
                case 11:
                    BmwTimeSetAct.this.updaterMonth();
                    break;
                case 12:
                    BmwTimeSetAct.this.updaterYear();
                    break;
            }
        }
    };
    int minuteValue;
    int monthValue;
    int yearValue;

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
        ((Button) findViewById(R.id.bogoo_bmw_time_hour_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_hour_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_minutes_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_minutes_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_day_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_day_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_month_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_month_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_year_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.bogoo_bmw_time_year_next)).setOnClickListener(this);
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
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterHour() {
        this.hourValue = DataCanbus.DATA[8];
        if (this.hourValue < 0) {
            this.hourValue = 0;
        } else if (this.hourValue > 23) {
            this.hourValue = 23;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_hour_tv)).setText(new StringBuilder().append(this.hourValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMinute() {
        this.minuteValue = DataCanbus.DATA[9];
        if (this.minuteValue < 0) {
            this.minuteValue = 0;
        } else if (this.minuteValue > 59) {
            this.minuteValue = 59;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_minutes_tv)).setText(new StringBuilder().append(this.minuteValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDay() {
        this.dayValue = DataCanbus.DATA[10];
        if (this.dayValue < 1) {
            this.dayValue = 1;
        } else if (this.dayValue > 31) {
            this.dayValue = 31;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_day_tv)).setText(new StringBuilder().append(this.dayValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterMonth() {
        this.monthValue = DataCanbus.DATA[11];
        if (this.monthValue < 1) {
            this.monthValue = 1;
        } else if (this.monthValue > 12) {
            this.monthValue = 12;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_month_tv)).setText(new StringBuilder().append(this.monthValue).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterYear() {
        this.yearValue = DataCanbus.DATA[12];
        if (this.yearValue < 0) {
            this.yearValue = 0;
        } else if (this.yearValue > 99) {
            this.yearValue = 99;
        }
        if (this.yearValue >= 0 && this.yearValue < 10) {
            ((TextView) findViewById(R.id.bogoo_bmw_time_year_tv)).setText("200" + this.yearValue);
        } else {
            ((TextView) findViewById(R.id.bogoo_bmw_time_year_tv)).setText("20" + this.yearValue);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bogoo_bmw_time_hour_pre /* 2131431704 */:
                int value1 = this.hourValue - 1;
                if (value1 >= 0) {
                    BmwFunc.CAR_TIME_SET(value1, this.minuteValue, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_hour_next /* 2131431706 */:
                int value2 = this.hourValue + 1;
                if (value2 <= 23) {
                    BmwFunc.CAR_TIME_SET(value2, this.minuteValue, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_minutes_pre /* 2131431707 */:
                int value3 = this.minuteValue - 1;
                if (value3 > 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, value3, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_minutes_next /* 2131431709 */:
                int value4 = this.minuteValue + 1;
                if (value4 < 59) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, value4, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_day_pre /* 2131431710 */:
                int value5 = this.dayValue - 1;
                if (value5 >= 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, value5, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_day_next /* 2131431712 */:
                int value6 = this.dayValue + 1;
                if (value6 <= 31) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, value6, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_month_pre /* 2131431713 */:
                int value7 = this.monthValue - 1;
                if (value7 > 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, value7, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_month_next /* 2131431715 */:
                int value8 = this.monthValue + 1;
                if (value8 <= 12) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, value8, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_year_pre /* 2131431716 */:
                int value9 = this.yearValue - 1;
                if (value9 > 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, this.monthValue, value9);
                    break;
                }
            case R.id.bogoo_bmw_time_year_next /* 2131431718 */:
                int value10 = this.yearValue + 1;
                if (value10 < 99) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, this.monthValue, value10);
                    break;
                }
        }
    }
}
