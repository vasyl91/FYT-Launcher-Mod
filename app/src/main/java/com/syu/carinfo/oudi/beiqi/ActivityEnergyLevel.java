package com.syu.carinfo.oudi.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.FinalCanbus;

public class ActivityEnergyLevel extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (DataCanbus.DATA[1000]) {
                case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
                case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
                case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                    int value = DataCanbus.DATA[updateCode];
                    switch (updateCode) {
                        case 110:
                            ActivityEnergyLevel.this.updateCarState2();
                            break;
                        case 112:
                            ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                            break;
                        case 113:
                            ActivityEnergyLevel.this.updateCarState2();
                            break;
                        case 115:
                            int hour = value / 60;
                            int min = value % 60;
                            ((TextView) ActivityEnergyLevel.this.findViewById(R.id.tv_text1)).setText(String.valueOf(ActivityEnergyLevel.this.getResources().getString(R.string.str_charging_remaining_time)) + ": " + hour + ActivityEnergyLevel.this.getResources().getString(R.string.time_hour) + min + ActivityEnergyLevel.this.getResources().getString(R.string.time_minute));
                            break;
                    }
                case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                    switch (updateCode) {
                        case 102:
                            ActivityEnergyLevel.this.updateCarState(DataCanbus.DATA[updateCode]);
                            break;
                        case 103:
                            ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                            break;
                    }
                default:
                    switch (updateCode) {
                        case 100:
                            ActivityEnergyLevel.this.updateCarState(DataCanbus.DATA[updateCode]);
                            break;
                        case 101:
                            ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                            break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_227_energy_level);
    }

    @Override
    protected void onResume() {
        super.onResume();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
                break;
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
                DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_454_OD_Beijing_X3_18 /* 4063686 */:
            case FinalCanbus.CAR_454_OD_Beijing_X5_18 /* 4129222 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_D50_19 /* 4260294 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X35_19 /* 4325830 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Shenbao_X55_18 /* 4391366 */:
            case FinalCanbus.CAR_454_OD_Beiqi_Zhixing_18 /* 4456902 */:
                DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
                break;
            case FinalCanbus.CAR_454_OD_Beiqi_EU5_18 /* 4194758 */:
                DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
                break;
            default:
                DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
                DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
                break;
        }
    }

    
    public void updateEnergyLevel(int value) {
        int resId;
        if (((ImageView) findViewById(R.id.iv_energy_level)) != null) {
            if (value < 13) {
                resId = R.drawable.ic_227_battery_level_0;
            } else if (value < 38) {
                resId = R.drawable.ic_227_battery_level_1;
            } else if (value < 63) {
                resId = R.drawable.ic_227_battery_level_2;
            } else if (value < 88) {
                resId = R.drawable.ic_227_battery_level_3;
            } else if (value < 113) {
                resId = R.drawable.ic_227_battery_level_4;
            } else if (value < 138) {
                resId = R.drawable.ic_227_battery_level_5;
            } else if (value < 163) {
                resId = R.drawable.ic_227_battery_level_6;
            } else if (value < 188) {
                resId = R.drawable.ic_227_battery_level_7;
            } else if (value < 213) {
                resId = R.drawable.ic_227_battery_level_8;
            } else if (value < 238) {
                resId = R.drawable.ic_227_battery_level_9;
            } else {
                resId = R.drawable.ic_227_battery_level_10;
            }
            ((ImageView) findViewById(R.id.iv_energy_level)).setBackgroundResource(resId);
        }
    }

    
    public void updateCarState(int value) {
        if (((TextView) findViewById(R.id.tv_227_car_state)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_3);
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_0);
                    break;
            }
        }
    }

    
    public void updateCarState2() {
        int value = DataCanbus.DATA[110];
        int data = DataCanbus.DATA[113];
        if (((TextView) findViewById(R.id.tv_227_car_state)) != null) {
            switch (value) {
                case 1:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(String.valueOf(getResources().getString(R.string.str_227_ec180_car_state_2)) + " Lv" + data);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(String.valueOf(getResources().getString(R.string.str_227_ec180_car_state_3)) + " Lv" + data);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("快充模式");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("慢充模式");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("慢充模式");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("放电模式");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_0);
                    break;
            }
        }
    }
}
