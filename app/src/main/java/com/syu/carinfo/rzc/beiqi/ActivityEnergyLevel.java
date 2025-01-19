package com.syu.carinfo.rzc.beiqi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class ActivityEnergyLevel extends Activity {
    IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 105:
                case 130:
                case 131:
                    ActivityEnergyLevel.this.updateCarState();
                    break;
                case 106:
                    ActivityEnergyLevel.this.updateEnergyLevel(DataCanbus.DATA[updateCode]);
                    break;
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
        DataCanbus.PROXY.cmd(6, new int[]{57}, null, null);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        if (DataCanbus.DATA[1000] == 786659 || DataCanbus.DATA[1000] == 1376483) {
            DataCanbus.NOTIFY_EVENTS[130].addNotify(this.mNotifyCanbus, 1);
            DataCanbus.NOTIFY_EVENTS[131].addNotify(this.mNotifyCanbus, 1);
            ((TextView) findViewById(R.id.tv_text1)).setVisibility(0);
            return;
        }
        ((TextView) findViewById(R.id.tv_text1)).setVisibility(8);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        if (DataCanbus.DATA[1000] == 786659 || DataCanbus.DATA[1000] == 1376483) {
            DataCanbus.NOTIFY_EVENTS[130].removeNotify(this.mNotifyCanbus);
            DataCanbus.NOTIFY_EVENTS[131].removeNotify(this.mNotifyCanbus);
        }
    }

    
    public void updateCarState() {
        int state = DataCanbus.DATA[105];
        int t1 = DataCanbus.DATA[130];
        int t2 = DataCanbus.DATA[131];
        if (((TextView) findViewById(R.id.tv_227_car_state)) != null) {
            switch (state) {
                case 1:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_1);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_2);
                    break;
                case 3:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_3);
                    break;
                case 4:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("快充模式");
                    break;
                case 5:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("慢充模式");
                    break;
                case 6:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("慢充模式1");
                    break;
                case 7:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText("放电模式");
                    break;
                default:
                    ((TextView) findViewById(R.id.tv_227_car_state)).setText(R.string.str_227_ec180_car_state_0);
                    break;
            }
        }
        switch (state) {
            case 2:
                ((TextView) findViewById(R.id.tv_text1)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("驱动能量等级 " + t1);
                break;
            case 3:
                ((TextView) findViewById(R.id.tv_text1)).setVisibility(0);
                ((TextView) findViewById(R.id.tv_text1)).setText("回收能量等级 " + t2);
                break;
            default:
                ((TextView) findViewById(R.id.tv_text1)).setVisibility(8);
                break;
        }
    }

    
    public void updateEnergyLevel(int value) {
        int resId;
        if (((ImageView) findViewById(R.id.iv_energy_level)) != null) {
            if (DataCanbus.DATA[1000] == 196835) {
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
            } else if (value == 0) {
                resId = R.drawable.ic_227_battery_level_0;
            } else if (value == 1) {
                resId = R.drawable.ic_227_battery_level_1;
            } else if (value == 2) {
                resId = R.drawable.ic_227_battery_level_2;
            } else if (value == 3) {
                resId = R.drawable.ic_227_battery_level_3;
            } else if (value == 4) {
                resId = R.drawable.ic_227_battery_level_4;
            } else if (value == 5) {
                resId = R.drawable.ic_227_battery_level_5;
            } else if (value == 6) {
                resId = R.drawable.ic_227_battery_level_6;
            } else if (value == 7) {
                resId = R.drawable.ic_227_battery_level_7;
            } else if (value == 8) {
                resId = R.drawable.ic_227_battery_level_8;
            } else if (value == 9) {
                resId = R.drawable.ic_227_battery_level_9;
            } else {
                resId = R.drawable.ic_227_battery_level_10;
            }
            ((ImageView) findViewById(R.id.iv_energy_level)).setBackgroundResource(resId);
        }
    }
}
