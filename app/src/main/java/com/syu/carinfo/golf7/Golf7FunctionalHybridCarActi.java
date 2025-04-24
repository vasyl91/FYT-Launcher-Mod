package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7FunctionalHybridCarActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", String.format("IUiNotify->updateCode:%d", Integer.valueOf(updateCode)));
            switch (updateCode) {
                case 299:
                    Golf7FunctionalHybridCarActi.this.mUpdaterHybridVisibleOrGone();
                    break;
                case 300:
                    Golf7FunctionalHybridCarActi.this.mUpdaterHybridChargeCurrentMax();
                    break;
                case 301:
                    Golf7FunctionalHybridCarActi.this.mUpdaterHybridTemperatureInter();
                    break;
                case 302:
                    Golf7FunctionalHybridCarActi.this.mUpdaterHybridAirUseBatterySwitch();
                    break;
                case 303:
                    Golf7FunctionalHybridCarActi.this.mUpdateHybridChargeLowLimit();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_functional_hybridcar);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.glf7_btn_functional_charge_current_max_m)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[300];
                if (value2 == 5) {
                    value = 255;
                } else if (value2 == 10) {
                    value = 5;
                } else if (value2 == 13) {
                    value = 10;
                } else {
                    value = value2 == 255 ? 13 : 5;
                }
                DataCanbus.PROXY.cmd(145, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_charge_current_max_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[300];
                if (value2 == 5) {
                    value = 10;
                } else if (value2 == 10) {
                    value = 13;
                } else if (value2 == 13) {
                    value = 255;
                } else {
                    value = value2 == 255 ? 5 : 5;
                }
                DataCanbus.PROXY.cmd(145, new int[]{1, value}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_temperatuer_inter_m)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[301];
                if (value2 != 254) {
                    if (value2 == 255) {
                        value = 59;
                    } else if (value2 <= 32) {
                        value = 254;
                    } else {
                        value = value2 - 1;
                    }
                    DataCanbus.PROXY.cmd(145, new int[]{2, value}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_temperatuer_inter_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value;
                int value2 = DataCanbus.DATA[301];
                if (value2 != 255) {
                    if (value2 == 254) {
                        value = 32;
                    } else if (value2 >= 59) {
                        value = 255;
                    } else {
                        value = value2 + 1;
                    }
                    DataCanbus.PROXY.cmd(145, new int[]{2, value}, null, null);
                }
            }
        });
        ((CheckedTextView) findViewById(R.id.glf7_btn_air_use_battery_switch)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[302];
                int value2 = value != 0 ? 0 : 1;
                DataCanbus.PROXY.cmd(145, new int[]{3, value2}, null, null);
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_battery_charge_low_limit_m)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[303];
                if (value != 0) {
                    DataCanbus.PROXY.cmd(145, new int[]{4, value - 1}, null, null);
                }
            }
        });
        ((Button) findViewById(R.id.glf7_btn_functional_battery_charge_low_limit_p)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                int value = DataCanbus.DATA[303];
                if (value < 10) {
                    DataCanbus.PROXY.cmd(145, new int[]{4, value + 1}, null, null);
                }
            }
        });
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[299].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[300].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[301].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[302].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[299].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[300].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[301].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[302].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterHybridVisibleOrGone() {
        int value = DataCanbus.DATA[299];
        findViewById(R.id.glf7_view_functional_charge_current_max).setVisibility((value & 128) != 0 ? 0 : 8);
        findViewById(R.id.glf7_view_functional_temperature_inter).setVisibility((value & 64) != 0 ? 0 : 8);
        findViewById(R.id.glf7_view_functional_air_use_battery_switch).setVisibility((value & 32) != 0 ? 0 : 8);
        findViewById(R.id.glf7_view_functional_battery_charge_low_limit).setVisibility((value & 16) == 0 ? 8 : 0);
    }

    
    public void mUpdaterHybridChargeCurrentMax() {
        int value = DataCanbus.DATA[300];
        if (((TextView) findViewById(R.id.glf7_txt_functional_charge_current_max)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.glf7_txt_functional_charge_current_max)).setText(R.string.MAX);
            } else {
                ((TextView) findViewById(R.id.glf7_txt_functional_charge_current_max)).setText(String.valueOf(value) + " A");
            }
        }
    }

    
    public void mUpdaterHybridTemperatureInter() {
        int value = DataCanbus.DATA[301];
        if (((TextView) findViewById(R.id.glf7_txt_functional_temperature_inter)) != null) {
            if (value == 254) {
                ((TextView) findViewById(R.id.glf7_txt_functional_temperature_inter)).setText(R.string.MIN);
            } else if (value == 255) {
                ((TextView) findViewById(R.id.glf7_txt_functional_temperature_inter)).setText(R.string.MAX);
            } else {
                int value2 = value * 5;
                ((TextView) findViewById(R.id.glf7_txt_functional_temperature_inter)).setText(String.format("%d.%d °C", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10)));
            }
        }
    }

    
    public void mUpdaterHybridAirUseBatterySwitch() {
        int value = DataCanbus.DATA[302];
        ((CheckedTextView) findViewById(R.id.glf7_btn_air_use_battery_switch)).setChecked(value != 0);
    }

    
    public void mUpdateHybridChargeLowLimit() {
        int value = DataCanbus.DATA[303];
        ((TextView) findViewById(R.id.glf7_txt_functional_battery_charge_low_limit)).setText(String.valueOf(value * 10) + " %");
    }
}
