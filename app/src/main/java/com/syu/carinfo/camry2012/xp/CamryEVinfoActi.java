package com.syu.carinfo.camry2012.xp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class CamryEVinfoActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    CamryEVinfoActi.this.mUpdaterAveSpeed();
                    break;
                case 101:
                    CamryEVinfoActi.this.mUpdaterOutTemp();
                    break;
                case 145:
                    CamryEVinfoActi.this.mUpdaterRearLock();
                    break;
                case 146:
                    CamryEVinfoActi.this.mUpdaterFRLock();
                    break;
                case 147:
                    CamryEVinfoActi.this.mUpdaterFLLock();
                    break;
                case 148:
                    CamryEVinfoActi.this.mUpdaterDomer();
                    break;
                case 149:
                    CamryEVinfoActi.this.mUpdaterTripTotal();
                    break;
                case 150:
                    CamryEVinfoActi.this.mUpdaterTripLast();
                    break;
                case 153:
                    CamryEVinfoActi.this.mUpdaterCurSpeed();
                    break;
                case 154:
                    CamryEVinfoActi.this.mUpdaterEngine();
                    break;
                case 170:
                case 171:
                    CamryEVinfoActi.this.mUpdaterTripB();
                    break;
                case 172:
                    CamryEVinfoActi.this.mUpdaterTripA();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_camry_base_info_ev);
        findViewById(R.id.camry_light).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(CamryEVinfoActi.this, CamryLightActi.class);
                    CamryEVinfoActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(20, new int[]{43}, null, null);
        DataCanbus.PROXY.cmd(20, new int[]{33}, null, null);
        addNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[149].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[153].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[154].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[145].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[146].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[147].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[148].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[171].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[172].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[153].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[154].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[145].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[146].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[147].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[148].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[171].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[172].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterTripTotal() {
        int value = DataCanbus.DATA[149];
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_total)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_total)).setText("--.-- km");
        }
    }

    
    public void mUpdaterTripLast() {
        int value = DataCanbus.DATA[150];
        if (value > 0 && value < 10000) {
            ((TextView) findViewById(R.id.camry_meter_mile)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_mile)).setText("--.-- km");
        }
    }

    
    public void mUpdaterTripA() {
        int value = DataCanbus.DATA[172];
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_a)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_a)).setText("--.-- km");
        }
    }

    
    public void mUpdaterTripB() {
        int value = DataCanbus.DATA[171];
        int unit = DataCanbus.DATA[170];
        if (unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KWh/km");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- KWh/km");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " KWh/100km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- KWh/100km");
        }
    }

    
    public void mUpdaterCurSpeed() {
        int value = DataCanbus.DATA[153];
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " km/h");
        } else {
            ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText("--.-- km/h");
        }
    }

    
    public void mUpdaterAveSpeed() {
        int value = DataCanbus.DATA[97];
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/h");
        } else {
            ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText("--.-- km/h");
        }
    }

    
    public void mUpdaterEngine() {
        int value = DataCanbus.DATA[154];
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_engine_speed)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.camry_meter_engine_speed)).setText("--.-- RPM");
        }
    }

    
    public void mUpdaterOutTemp() {
        int value = DataCanbus.DATA[101];
        ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value / 60) + "时 " + (value % 60) + "分");
    }

    
    public void mUpdaterRearLock() {
        int i = R.drawable.ic_camry_lock_lock;
        int value = DataCanbus.DATA[145];
        ((TextView) findViewById(R.id.camry_lock_rear_left)).setBackgroundResource(value == 0 ? 2130839814 : 2130839815);
        TextView textView = (TextView) findViewById(R.id.camry_lock_rear_right);
        if (value != 0) {
            i = 2130839815;
        }
        textView.setBackgroundResource(i);
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
