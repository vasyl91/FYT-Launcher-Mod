package com.syu.carinfo.haozheng.bmw;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BmwTimeSetAct extends BaseActivity implements View.OnClickListener {
    int dayValue;
    int hourValue;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
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
    int minuteValue;
    int monthValue;
    int yearValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_haozheng_bmw_time);
        init();
        setUI();
    }

    @Override
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
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[19].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterHour() {
        this.hourValue = DataCanbus.DATA[15];
        if (this.hourValue < 0) {
            this.hourValue = 0;
        } else if (this.hourValue > 23) {
            this.hourValue = 23;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_hour_tv)).setText(new StringBuilder().append(this.hourValue).toString());
    }

    
    public void updaterMinute() {
        this.minuteValue = DataCanbus.DATA[16];
        if (this.minuteValue < 0) {
            this.minuteValue = 0;
        } else if (this.minuteValue > 59) {
            this.minuteValue = 59;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_minutes_tv)).setText(new StringBuilder().append(this.minuteValue).toString());
    }

    
    public void updaterDay() {
        this.dayValue = DataCanbus.DATA[17];
        if (this.dayValue < 1) {
            this.dayValue = 1;
        } else if (this.dayValue > 31) {
            this.dayValue = 31;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_day_tv)).setText(new StringBuilder().append(this.dayValue).toString());
    }

    
    public void updaterMonth() {
        this.monthValue = DataCanbus.DATA[18];
        if (this.monthValue < 1) {
            this.monthValue = 1;
        } else if (this.monthValue > 12) {
            this.monthValue = 12;
        }
        ((TextView) findViewById(R.id.bogoo_bmw_time_month_tv)).setText(new StringBuilder().append(this.monthValue).toString());
    }

    
    public void updaterYear() {
        this.yearValue = DataCanbus.DATA[19];
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bogoo_bmw_time_hour_pre /* 2131431681 */:
                int value1 = this.hourValue - 1;
                if (value1 >= 0) {
                    BmwFunc.CAR_TIME_SET(value1, this.minuteValue, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_hour_next /* 2131431683 */:
                int value2 = this.hourValue + 1;
                if (value2 <= 23) {
                    BmwFunc.CAR_TIME_SET(value2, this.minuteValue, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_minutes_pre /* 2131431684 */:
                int value3 = this.minuteValue - 1;
                if (value3 > 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, value3, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_minutes_next /* 2131431686 */:
                int value4 = this.minuteValue + 1;
                if (value4 < 59) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, value4, this.dayValue, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_day_pre /* 2131431687 */:
                int value5 = this.dayValue - 1;
                if (value5 >= 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, value5, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_day_next /* 2131431689 */:
                int value6 = this.dayValue + 1;
                if (value6 <= 31) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, value6, this.monthValue, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_month_pre /* 2131431690 */:
                int value7 = this.monthValue - 1;
                if (value7 > 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, value7, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_month_next /* 2131431692 */:
                int value8 = this.monthValue + 1;
                if (value8 <= 12) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, value8, this.yearValue);
                    break;
                }
            case R.id.bogoo_bmw_time_year_pre /* 2131431693 */:
                int value9 = this.yearValue - 1;
                if (value9 > 0) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, this.monthValue, value9);
                    break;
                }
            case R.id.bogoo_bmw_time_year_next /* 2131431695 */:
                int value10 = this.yearValue + 1;
                if (value10 < 99) {
                    BmwFunc.CAR_TIME_SET(this.hourValue, this.minuteValue, this.dayValue, this.monthValue, value10);
                    break;
                }
        }
    }
}
