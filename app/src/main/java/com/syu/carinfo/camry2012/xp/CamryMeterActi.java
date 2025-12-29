package com.syu.carinfo.camry2012.xp;

import android.content.Intent;
import android.os.Bundle;
import android.SystemProperties;
import android.view.View;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryMeterActi extends BaseActivity {
    int carid = 0;
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 97:
                    CamryMeterActi.this.mUpdaterAveSpeed();
                    break;
                case 102:
                    CamryMeterActi.this.unit = (value >> 24) & 255;
                    break;
                case 145:
                    CamryMeterActi.this.mUpdaterRearLock();
                    break;
                case 146:
                    CamryMeterActi.this.mUpdaterFRLock();
                    break;
                case 147:
                    CamryMeterActi.this.mUpdaterFLLock();
                    break;
                case 148:
                    CamryMeterActi.this.mUpdaterDomer();
                    break;
                case 149:
                    CamryMeterActi.this.mUpdaterTripTotal();
                    break;
                case 150:
                    CamryMeterActi.this.mUpdaterTripLast();
                    break;
                case 151:
                    CamryMeterActi.this.mUpdaterTripA();
                    break;
                case 152:
                    CamryMeterActi.this.mUpdaterTripB();
                    break;
                case 153:
                    CamryMeterActi.this.mUpdaterCurSpeed();
                    break;
                case 154:
                    CamryMeterActi.this.mUpdaterEngine();
                    break;
                case 155:
                    CamryMeterActi.this.mUpdaterOutTemp();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_base_info);
        findViewById(R.id.camry_light).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(CamryMeterActi.this, CamryLightActi.class);
                    CamryMeterActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.carid = (DataCanbus.DATA[1000] >> 16) & 65535;
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(20, new int[]{65}, null, null);
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[152].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[155].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[152].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[155].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterTripTotal() {
        int value = DataCanbus.DATA[149];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_total)).setText(String.valueOf(value) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_total)).setText("--.-- miles");
                return;
            }
        }
        int mileUnit = SystemProperties.getInt("persist.fyt.reverselicheng", 0);
        if (mileUnit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_total)).setText(String.valueOf((value * 10) / 16) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_total)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_total)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_total)).setText("--.-- km");
        }
    }

    
    public void mUpdaterTripLast() {
        int value = DataCanbus.DATA[150];
        if (this.unit == 1) {
            if (value > 0 && value < 10000) {
                ((TextView) findViewById(R.id.camry_meter_mile)).setText(String.valueOf(value) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_mile)).setText("--.-- miles");
                return;
            }
        }
        int mileUnit = SystemProperties.getInt("persist.fyt.reverselicheng", 0);
        if (mileUnit == 1) {
            if (value > 0 && value < 10000) {
                ((TextView) findViewById(R.id.camry_meter_mile)).setText(String.valueOf((value * 10) / 16) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_mile)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0 && value < 10000) {
            ((TextView) findViewById(R.id.camry_meter_mile)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_mile)).setText("--.-- km");
        }
    }

    
    public void mUpdaterTripA() {
        int value = DataCanbus.DATA[151];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_a)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_a)).setText("--.-- miles");
                return;
            }
        }
        int mileUnit = SystemProperties.getInt("persist.fyt.reverselicheng", 0);
        if (mileUnit == 1) {
            if (value > 0) {
                int value2 = (value * 10) / 16;
                ((TextView) findViewById(R.id.camry_meter_a)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_a)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_a)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_a)).setText("--.-- km");
        }
    }

    
    public void mUpdaterTripB() {
        int value = DataCanbus.DATA[152];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- miles");
                return;
            }
        }
        int mileUnit = SystemProperties.getInt("persist.fyt.reverselicheng", 0);
        if (mileUnit == 1) {
            if (value > 0) {
                int value2 = (value * 10) / 16;
                ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- km");
        }
    }

    
    public void mUpdaterCurSpeed() {
        int value = DataCanbus.DATA[153];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " mph");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText("--.-- mph");
                return;
            }
        }
        int mileUnit = SystemProperties.getInt("persist.fyt.reverselicheng", 0);
        if (mileUnit == 1) {
            if (value > 0) {
                int value2 = (value * 10) / 16;
                ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 100), Integer.valueOf(value2 % 100))) + " mph");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText("--.-- mph");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " km/h");
        } else {
            ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText("--.-- km/h");
        }
    }

    
    public void mUpdaterAveSpeed() {
        int value = DataCanbus.DATA[97];
        if (this.unit == 1) {
            if (value > 0) {
                if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
                    ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " mph");
                    return;
                } else {
                    ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mph");
                    return;
                }
            }
            ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText("--.-- mph");
            return;
        }
        int mileUnit = SystemProperties.getInt("persist.fyt.reverselicheng", 0);
        if (mileUnit == 1) {
            if (value > 0) {
                int value2 = (value * 10) / 16;
                if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
                    ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 100), Integer.valueOf(value2 % 100))) + " mph");
                    return;
                } else {
                    ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + " mph");
                    return;
                }
            }
            ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText("--.-- mph");
            return;
        }
        if (value > 0) {
            if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
                ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " km/h");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/h");
                return;
            }
        }
        ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText("--.-- km/h");
    }

    
    public void mUpdaterEngine() {
        int value = DataCanbus.DATA[154];
        if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
            value /= 4;
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_engine_speed)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.camry_meter_engine_speed)).setText("--.-- RPM");
        }
    }

    
    public void mUpdaterOutTemp() {
        int value = DataCanbus.DATA[155];
        if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
            int TempUnit = SystemProperties.getInt("persist.fyt.temperature", 0);
            if (TempUnit == 1) {
                if (value == 0) {
                    ((TextView) findViewById(R.id.camry_meter_out_temp)).setText("--.-- ℉");
                    return;
                }
                if (value < 80) {
                    int value2 = 400 - (value * 9);
                    ((TextView) findViewById(R.id.camry_meter_out_temp)).setText("-" + (value2 / 10) + "." + (value2 % 10) + " ℉");
                    return;
                } else {
                    if (value >= 80) {
                        int value3 = (value * 9) - 400;
                        ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " ℉");
                        return;
                    }
                    return;
                }
            }
            if (value == 0) {
                ((TextView) findViewById(R.id.camry_meter_out_temp)).setText("--.-- °C");
                return;
            }
            if (value < 80) {
                int value4 = 400 - (value * 5);
                ((TextView) findViewById(R.id.camry_meter_out_temp)).setText("-" + (value4 / 10) + "." + (value4 % 10) + " °C");
                return;
            } else {
                if (value >= 80) {
                    int value5 = (value * 5) - 400;
                    ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value5 / 10) + "." + (value5 % 10) + " °C");
                    return;
                }
                return;
            }
        }
        if (value > -1 && value < 100) {
            ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value) + " °C");
        } else if (value > 100) {
            ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value - 256) + " °C");
        }
    }

    
    public void mUpdaterRearLock() {
        int i = R.drawable.ic_camry_lock_lock;
        int value = DataCanbus.DATA[145];
        if (((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77) || (DataCanbus.DATA[1000] & 65535) == 112) {
            ((TextView) findViewById(R.id.camry_lock_rear_left)).setBackgroundResource((value & 2) == 0 ? 2130839814 : 2130839815);
            TextView textView = (TextView) findViewById(R.id.camry_lock_rear_right);
            if ((value & 1) != 0) {
                i = 2130839815;
            }
            textView.setBackgroundResource(i);
            return;
        }
        ((TextView) findViewById(R.id.camry_lock_rear_left)).setBackgroundResource(value == 0 ? 2130839814 : 2130839815);
        TextView textView2 = (TextView) findViewById(R.id.camry_lock_rear_right);
        if (value != 0) {
            i = 2130839815;
        }
        textView2.setBackgroundResource(i);
    }

    
    public void mUpdaterFRLock() {
        int value = DataCanbus.DATA[146];
        ((TextView) findViewById(R.id.camry_lock_front_right)).setBackgroundResource(value == 0 ? R.drawable.ic_camry_lock_lock : R.drawable.ic_camry_lock_unlock);
    }

    
    public void mUpdaterFLLock() {
        int value = DataCanbus.DATA[147];
        ((TextView) findViewById(R.id.camry_lock_front_left)).setBackgroundResource(value == 0 ? R.drawable.ic_camry_lock_lock : R.drawable.ic_camry_lock_unlock);
    }

    
    public void mUpdaterDomer() {
        int value = DataCanbus.DATA[148];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText(R.string.camry_dormer_open);
                break;
            case 2:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText(R.string.camry_dormer_close);
                break;
            case 3:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText(R.string.camry_dormer_half_open);
                break;
            default:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText("--");
                break;
        }
    }
}
