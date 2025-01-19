package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7Electric_information_Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", String.format("updateCode:%d,unit_Distance[%d]", Integer.valueOf(updateCode), Integer.valueOf(DataCanbus.DATA[231] & 255)));
            switch (updateCode) {
                case 311:
                    Golf7Electric_information_Acti.this.mUpdaterDrivingPotential();
                    break;
                case 312:
                    Golf7Electric_information_Acti.this.mUpdaterEnergyFlow();
                    break;
                case 313:
                    Golf7Electric_information_Acti.this.mUpdaterDrivingMileage();
                    break;
                case 314:
                    Golf7Electric_information_Acti.this.mUpdaterElectricMileage();
                    break;
                case 315:
                    Golf7Electric_information_Acti.this.mUpdaterElectricOilRate();
                    break;
                case 321:
                    Golf7Electric_information_Acti.this.mUpdaterBatteryLevel();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_electric_information);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{3}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[311].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[312].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[313].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[314].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[315].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[321].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[311].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[312].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[313].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[314].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[315].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[321].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterDrivingPotential() {
        int value = DataCanbus.DATA[311];
        int unit_wc = DataCanbus.DATA[231] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_driving_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_driving_mileage)).setText(String.valueOf(String.format("%d ", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_driving_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_driving_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterEnergyFlow() {
        int value = DataCanbus.DATA[312];
        if (value != 1) {
            if (value != 2) {
                ((TextView) findViewById(R.id.golf7_tv_energy_flow)).setText(" ");
                return;
            } else {
                ((TextView) findViewById(R.id.golf7_tv_energy_flow)).setText(R.string.discharging);
                return;
            }
        }
        ((TextView) findViewById(R.id.golf7_tv_energy_flow)).setText(R.string.charging);
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[313];
        int unit_wc = DataCanbus.DATA[231] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_mileage)).setText(String.valueOf(String.format("%d ", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterElectricMileage() {
        int value = DataCanbus.DATA[314];
        int unit_wc = DataCanbus.DATA[231] & 255;
        if (((TextView) findViewById(R.id.golf7_tv_electric_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_electric_mileage)).setText(String.valueOf(String.format("%d ", Integer.valueOf(value))) + Golf7Data.mDistanceUnitWc[unit_wc]);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_electric_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_electric_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterElectricOilRate() {
        int value = DataCanbus.DATA[315];
        ((TextView) findViewById(R.id.golf7_tv_electric_oil_rate)).setText(String.valueOf(value) + " %");
    }

    
    public void mUpdaterBatteryLevel() {
        int value = DataCanbus.DATA[321];
        ((TextView) findViewById(R.id.golf7_tv_electric_battery_level)).setText(String.valueOf(value) + " %");
    }
}
