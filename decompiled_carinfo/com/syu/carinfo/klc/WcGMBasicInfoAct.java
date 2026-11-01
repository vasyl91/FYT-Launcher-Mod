package com.syu.carinfo.klc;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.TextView;

import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WcGMBasicInfoAct extends Activity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 106:
                    WcGMBasicInfoAct.this.mUpdaterTrip();
                    break;
                case 110:
                    WcGMBasicInfoAct.this.mUpdaterCurrentSpeech();
                    break;
                case 169:
                    WcGMBasicInfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 194:
                    WcGMBasicInfoAct.this.mUpdaterTrunk();
                    break;
                case 195:
                    WcGMBasicInfoAct.this.mUpdaterBatteryVol();
                    break;
                case 196:
                    WcGMBasicInfoAct.this.mUpdaterDrivingMileage();
                    break;
                case 197:
                    WcGMBasicInfoAct.this.updaterOutTemp();
                    break;
                case 202:
                    if (value > 0) {
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + " KM");
                        break;
                    } else {
                        ((TextView) WcGMBasicInfoAct.this.findViewById(R.id.tv_text1)).setText("--.-- KM");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0036_wc_gm_basic_info);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addUpdater();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeUpdater();
    }

    protected void finalize() throws Throwable {
        removeUpdater();
    }

    private void addUpdater() {
        DataCanbus.NOTIFY_EVENTS[195].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[196].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[194].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[197].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[202].addNotify(this.mNotifyCanbus, 1);
    }

    private void removeUpdater() {
        DataCanbus.NOTIFY_EVENTS[195].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[196].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[194].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[197].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[202].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[169];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_engine_speed_wc)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_engine_speed_wc)).setText("--.-- RPM");
        }
    }

    
    public void mUpdaterCurrentSpeech() {
        int value = DataCanbus.DATA[110];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_current_speed)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_current_speed)).setText("--.-- Km/h");
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[196];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_mileage_wc)).setText(String.valueOf(value) + " KM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_mileage_wc)).setText("--.-- KM");
        }
    }

    
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[195];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_battery_voltage_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " V");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_battery_voltage_wc)).setText("--.-- V");
        }
    }

    
    public void mUpdaterTrip() {
        int value = DataCanbus.DATA[106];
        if (value > 0) {
            ((TextView) findViewById(R.id.xp_yl_tv_trip_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.xp_yl_tv_trip_wc)).setText("--.--L/100KM");
        }
    }

    
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[197];
        if (value >= 0 && value <= 80) {
            int value2 = 400 - (value * 5);
            ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText("-" + (value2 / 10) + "." + (value2 % 10) + "℃");
        } else {
            int value3 = (value * 5) - 400;
            ((TextView) findViewById(R.id.xp_yl_tv_outside_temperature_wc)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + "℃");
        }
    }

    
    public void mUpdaterTrunk() {
        int value = DataCanbus.DATA[194];
        ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(String.valueOf(value) + " ");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
