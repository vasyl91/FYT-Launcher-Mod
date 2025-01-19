package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RuiTengMeterAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 123:
                    RuiTengMeterAct.this.mUpdaterValue50();
                    break;
                case 124:
                    RuiTengMeterAct.this.mUpdaterValue51();
                    break;
                case 125:
                    RuiTengMeterAct.this.mUpdaterValue52();
                    break;
                case 126:
                    RuiTengMeterAct.this.mUpdaterValue53();
                    break;
                case 127:
                    RuiTengMeterAct.this.mUpdaterValue54();
                    break;
                case 143:
                    RuiTengMeterAct.this.mUpdaterValue55();
                    break;
                case 144:
                    RuiTengMeterAct.this.mUpdaterValue56();
                    break;
                case 145:
                    RuiTengMeterAct.this.mUpdaterValue57();
                    break;
                case 146:
                    RuiTengMeterAct.this.mUpdaterValue58();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_ruiteng_meter_info);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[127].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[127].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue50() {
        int value = DataCanbus.DATA[123];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText("--");
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void mUpdaterValue51() {
        int value = DataCanbus.DATA[124];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText("--");
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    
    public void mUpdaterValue52() {
        int value = DataCanbus.DATA[125];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(String.valueOf(value / 10.0f) + "V");
        }
    }

    
    public void mUpdaterValue53() {
        int value = DataCanbus.DATA[126];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText("-");
            } else if (value >= 0 && value <= 100) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(String.valueOf(value) + "%");
            }
        }
    }

    
    public void mUpdaterValue54() {
        int value = DataCanbus.DATA[127];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_remaining_oil)) != null && value >= 0 && value <= 100) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_remaining_oil)).setText(String.valueOf(value) + "%");
        }
    }

    
    public void mUpdaterValue55() {
        int value = DataCanbus.DATA[143];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(new StringBuilder().append(DataCanbus.DATA[123]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    
    public void mUpdaterValue56() {
        int value = DataCanbus.DATA[144];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(new StringBuilder().append(DataCanbus.DATA[124]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    
    public void mUpdaterValue57() {
        int value = DataCanbus.DATA[145];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(new StringBuilder().append(DataCanbus.DATA[125]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    
    public void mUpdaterValue58() {
        int value = DataCanbus.DATA[146];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(new StringBuilder().append(DataCanbus.DATA[126]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }
}
