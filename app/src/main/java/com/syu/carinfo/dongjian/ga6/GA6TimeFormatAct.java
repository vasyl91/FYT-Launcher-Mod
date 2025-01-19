package com.syu.carinfo.dongjian.ga6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class GA6TimeFormatAct extends BaseActivity implements View.OnClickListener {
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 116:
                    GA6TimeFormatAct.this.updatertimeFormat();
                    break;
                case 117:
                    GA6TimeFormatAct.this.updaterHour();
                    break;
                case 118:
                    GA6TimeFormatAct.this.updaterMinute();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_257_dongjian_ga6_time_format);
        init();
        setUI();
    }

    @Override
    public void init() {
    }

    private void setUI() {
        ((CheckedTextView) findViewById(R.id.dongjian_ga6_time_format_check)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_ga6_time_hour_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_ga6_time_hour_next)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_ga6_time_minutes_pre)).setOnClickListener(this);
        ((Button) findViewById(R.id.dongjian_ga6_time_minutes_next)).setOnClickListener(this);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
    }

    
    public void updatertimeFormat() {
        int timeFormatValue = DataCanbus.DATA[116];
        if (timeFormatValue == 1) {
            ((CheckedTextView) findViewById(R.id.dongjian_ga6_time_format_check)).setChecked(true);
            ((TextView) findViewById(R.id.dongjian_ga6_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_1);
        } else if (timeFormatValue == 0) {
            ((CheckedTextView) findViewById(R.id.dongjian_ga6_time_format_check)).setChecked(false);
            ((TextView) findViewById(R.id.dongjian_ga6_time_format_tv)).setText(R.string.str_bogoo_bmw_time_format_0);
        }
    }

    
    public void updaterHour() {
        int hourtimevalue = DataCanbus.DATA[117];
        ((TextView) findViewById(R.id.dongjian_ga6_time_hour_tv)).setText(new StringBuilder().append(hourtimevalue).toString());
    }

    
    public void updaterMinute() {
        int minutetimevalue = DataCanbus.DATA[118];
        ((TextView) findViewById(R.id.dongjian_ga6_time_minutes_tv)).setText(new StringBuilder().append(minutetimevalue).toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dongjian_ga6_time_format_check /* 2131428946 */:
                GA6Func.C_CAR_CARINFO_CMD(16, 1, DataCanbus.DATA[116] == 0 ? 1 : 0);
                break;
            case R.id.dongjian_ga6_time_hour_pre /* 2131428949 */:
                int val1 = DataCanbus.DATA[117] - 1;
                if (val1 >= 0) {
                    GA6Func.C_CAR_CARINFO_CMD(17, val1, DataCanbus.DATA[118]);
                    break;
                }
            case R.id.dongjian_ga6_time_hour_next /* 2131428951 */:
                int val2 = DataCanbus.DATA[117] + 1;
                if (val2 <= 23) {
                    GA6Func.C_CAR_CARINFO_CMD(17, val2, DataCanbus.DATA[118]);
                    break;
                }
            case R.id.dongjian_ga6_time_minutes_pre /* 2131428952 */:
                int val3 = DataCanbus.DATA[118] - 1;
                if (val3 >= 0) {
                    GA6Func.C_CAR_CARINFO_CMD(17, DataCanbus.DATA[117], val3);
                    break;
                }
            case R.id.dongjian_ga6_time_minutes_next /* 2131428954 */:
                int val4 = DataCanbus.DATA[118] + 1;
                if (val4 <= 59) {
                    GA6Func.C_CAR_CARINFO_CMD(17, DataCanbus.DATA[117], val4);
                    break;
                }
        }
    }
}
