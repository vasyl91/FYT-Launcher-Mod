package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Golf7OilMileagePage5ActiOD extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    Golf7OilMileagePage5ActiOD.this.mUpdaterAverageOil();
                    break;
                case 103:
                    Golf7OilMileagePage5ActiOD.this.mUpdaterDrivingMileage();
                    break;
                case 104:
                    Golf7OilMileagePage5ActiOD.this.mUpdaterRunningMileage();
                    break;
                case 105:
                    Golf7OilMileagePage5ActiOD.this.mUpdaterDrivingTime();
                    break;
                case 106:
                    Golf7OilMileagePage5ActiOD.this.mUpdaterAverageSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_oil_page5_od);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAverageOil() {
        int value = DataCanbus.DATA[102];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText("--.--");
                    return;
                }
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && mValue != 6553 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText(String.valueOf(mValue) + Golf7Data.mOilUnitXp1[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText("--.--" + Golf7Data.mOilUnitXp1[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterRunningMileage() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_running_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_running_mileage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km");
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 536870911;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_running_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingTime() {
        int value = DataCanbus.DATA[105];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)).setText(String.valueOf(value / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value % 60) + " " + getResources().getString(R.string.time_minute));
            } else {
                int value2 = value & 16777215;
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)).setText(String.valueOf(value2 / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value2 % 60) + " " + getResources().getString(R.string.time_minute));
            }
        }
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)).setText(String.valueOf(value) + "km/h");
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)).setText(String.valueOf(mValue) + Golf7Data.mSpeedUnitXp[unit]);
            }
        }
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
