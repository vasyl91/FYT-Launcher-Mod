package com.syu.carinfo.dongjian.wc2.ds5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class DS5CarTimeSetAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 136:
                    DS5CarTimeSetAct.this.updaterYear();
                    break;
                case 137:
                    DS5CarTimeSetAct.this.updaterMonth();
                    break;
                case 138:
                    DS5CarTimeSetAct.this.updaterDay();
                    break;
                case 139:
                    DS5CarTimeSetAct.this.updaterHour();
                    break;
                case 140:
                    DS5CarTimeSetAct.this.updaterMinute();
                    break;
                case 141:
                    DS5CarTimeSetAct.this.updatertimeFromat();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        //setContentView(R.layout.layout_302_dongjian_wc2_ds5_time_format);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    public void setUI() {
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_hour_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_hour_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_minutes_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_minutes_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_day_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_day_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_month_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_month_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_year_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_wc2_ds5_time_year_next)).setOnClickListener(this);
        ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_time_format_check)).setOnClickListener(this);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
    }

    
    public void updaterHour() {
        int hourValue = DataCanbus.DATA[139];
        if (hourValue < 0) {
            hourValue = 0;
        } else if (hourValue > 23) {
            hourValue = 23;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_hour_tv)).setText(new StringBuilder().append(hourValue).toString());
    }

    
    public void updaterMinute() {
        int minuteValue = DataCanbus.DATA[140];
        if (minuteValue < 0) {
            minuteValue = 0;
        } else if (minuteValue > 59) {
            minuteValue = 59;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_minutes_tv)).setText(new StringBuilder().append(minuteValue).toString());
    }

    
    public void updaterDay() {
        int dayValue = DataCanbus.DATA[138];
        if (dayValue < 1) {
            dayValue = 1;
        } else if (dayValue > 31) {
            dayValue = 31;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_day_tv)).setText(new StringBuilder().append(dayValue).toString());
    }

    
    public void updaterMonth() {
        int monthValue = DataCanbus.DATA[137];
        if (monthValue < 1) {
            monthValue = 1;
        } else if (monthValue > 12) {
            monthValue = 12;
        }
        ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_month_tv)).setText(new StringBuilder().append(monthValue).toString());
    }

    
    public void updaterYear() {
        int yearValue = DataCanbus.DATA[136];
        if (yearValue < 0) {
            yearValue = 0;
        } else if (yearValue > 99) {
            yearValue = 99;
        }
        if (yearValue >= 0 && yearValue < 10) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_year_tv)).setText("200" + yearValue);
        } else {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_year_tv)).setText("20" + yearValue);
        }
    }

    
    public void updatertimeFromat() {
        int TimeFormatValue = DataCanbus.DATA[141];
        if (TimeFormatValue == 1) {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_1);
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_time_format_check)).setChecked(true);
        } else {
            ((TextView) findViewById(R.id.dongjian_wc2_ds5_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_0);
            ((CheckedTextView) findViewById(R.id.dongjian_wc2_ds5_time_format_check)).setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_wc2_ds5_time_hour_pre /* 2131429226 */:
                int value1 = DataCanbus.DATA[139] - 1;
                if (value1 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], DataCanbus.DATA[138], value1, DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_hour_next /* 2131429228 */:
                int value2 = DataCanbus.DATA[139] + 1;
                if (value2 < 12) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], DataCanbus.DATA[138], value2, DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_minutes_pre /* 2131429229 */:
                int value3 = DataCanbus.DATA[140] - 1;
                if (value3 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], DataCanbus.DATA[138], DataCanbus.DATA[139], value3, DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_minutes_next /* 2131429231 */:
                int value4 = DataCanbus.DATA[140] + 1;
                if (value4 < 59) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], DataCanbus.DATA[138], DataCanbus.DATA[139], value4, DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_day_pre /* 2131429232 */:
                int value5 = DataCanbus.DATA[138] - 1;
                if (value5 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], value5, DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_day_next /* 2131429234 */:
                int value6 = DataCanbus.DATA[138] + 1;
                if (value6 < 31) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], value6, DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_month_pre /* 2131429235 */:
                int value7 = DataCanbus.DATA[137] - 1;
                if (value7 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], value7, DataCanbus.DATA[138], DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_month_next /* 2131429237 */:
                int value8 = DataCanbus.DATA[137] + 1;
                if (value8 < 12) {
                    DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], value8, DataCanbus.DATA[138], DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_year_pre /* 2131429238 */:
                int value9 = DataCanbus.DATA[136] - 1;
                if (value9 > 0) {
                    DS5Func.C_TIME_FORMAT_SET(value9, DataCanbus.DATA[137], DataCanbus.DATA[138], DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_year_next /* 2131429240 */:
                int value10 = DataCanbus.DATA[136] + 1;
                if (value10 < 99) {
                    DS5Func.C_TIME_FORMAT_SET(value10, DataCanbus.DATA[137], DataCanbus.DATA[138], DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141]);
                    break;
                }
            case R.id.dongjian_wc2_ds5_time_format_check /* 2131429241 */:
                DS5Func.C_TIME_FORMAT_SET(DataCanbus.DATA[136], DataCanbus.DATA[137], DataCanbus.DATA[138], DataCanbus.DATA[139], DataCanbus.DATA[140], DataCanbus.DATA[141] == 0 ? 1 : 0);
                break;
        }
    }
}
