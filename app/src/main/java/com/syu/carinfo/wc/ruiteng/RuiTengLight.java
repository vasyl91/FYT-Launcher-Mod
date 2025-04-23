package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class RuiTengLight extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 132:
                    RuiTengLight.this.mUpdaterValue17();
                    break;
                case 133:
                    RuiTengLight.this.mUpdaterValue18();
                    break;
                case 134:
                    RuiTengLight.this.mUpdaterValue19();
                    break;
                case 135:
                    RuiTengLight.this.mUpdaterValue20();
                    break;
                case 136:
                    RuiTengLight.this.mUpdaterValue21();
                    break;
                case 137:
                    RuiTengLight.this.mUpdaterValue22();
                    break;
                case 138:
                    RuiTengLight.this.mUpdaterValue23();
                    break;
                case 139:
                    RuiTengLight.this.mUpdaterValue24();
                    break;
                case 140:
                    RuiTengLight.this.mUpdaterValue25();
                    break;
                case 141:
                    RuiTengLight.this.mUpdaterValue26();
                    break;
                case 142:
                    RuiTengLight.this.mUpdaterValue27();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_wc_ruiteng_light);
    }

    @Override
    public void addNotify() {
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
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[132].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[133].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterValue17() {
        int value = DataCanbus.DATA[132];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_near_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_near_light)).setBackgroundResource(R.drawable.wc_ruiteng_near_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_near_light)).setBackgroundResource(R.drawable.wc_ruiteng_near_light_0);
            }
        }
    }

    
    public void mUpdaterValue18() {
        int value = DataCanbus.DATA[133];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_away_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_away_light)).setBackgroundResource(R.drawable.wc_ruiteng_away_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_away_light)).setBackgroundResource(R.drawable.wc_ruiteng_away_light_0);
            }
        }
    }

    
    public void mUpdaterValue19() {
        int value = DataCanbus.DATA[134];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_width_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_width_light)).setBackgroundResource(R.drawable.wc_ruiteng_width_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_width_light)).setBackgroundResource(R.drawable.wc_ruiteng_width_light_0);
            }
        }
    }

    
    public void mUpdaterValue20() {
        int value = DataCanbus.DATA[135];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_front_fog_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_front_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_front_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_front_fog_light_0);
            }
        }
    }

    
    public void mUpdaterValue21() {
        int value = DataCanbus.DATA[136];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_rear_fog_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_rear_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_rear_fog_light)).setBackgroundResource(R.drawable.wc_ruiteng_rear_fog_light_0);
            }
        }
    }

    
    public void mUpdaterValue22() {
        int value = DataCanbus.DATA[137];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_brake_car_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_brake_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_brake_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_brake_car_light_0);
            }
        }
    }

    
    public void mUpdaterValue23() {
        int value = DataCanbus.DATA[138];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_back_car_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_back_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_back_car_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_back_car_light)).setBackgroundResource(R.drawable.wc_ruiteng_back_car_light_0);
            }
        }
    }

    
    public void mUpdaterValue24() {
        int value = DataCanbus.DATA[139];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_day_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_day_light)).setBackgroundResource(R.drawable.wc_ruiteng_day_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_day_light)).setBackgroundResource(R.drawable.wc_ruiteng_day_light_0);
            }
        }
    }

    
    public void mUpdaterValue25() {
        int value = DataCanbus.DATA[140];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_right_turn_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_right_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_right_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_right_turn_light_0);
            }
        }
    }

    
    public void mUpdaterValue26() {
        int value = DataCanbus.DATA[141];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_left_turn_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_left_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_left_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_left_turn_light_0);
            }
        }
    }

    
    public void mUpdaterValue27() {
        int value = DataCanbus.DATA[142];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_both_turn_light)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_both_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_both_turn_light_1);
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_both_turn_light)).setBackgroundResource(R.drawable.wc_ruiteng_both_turn_light_0);
            }
        }
    }
}
