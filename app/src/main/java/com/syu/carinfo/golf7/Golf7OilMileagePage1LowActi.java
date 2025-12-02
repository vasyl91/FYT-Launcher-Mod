package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.camry2012.xp.CamryData;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7OilMileagePage1LowActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 97:
                    Golf7OilMileagePage1LowActi.this.mUpdaterAverageOil();
                    break;
                case 98:
                    Golf7OilMileagePage1LowActi.this.mUpdaterDrivingMileage();
                    break;
                case 99:
                    Golf7OilMileagePage1LowActi.this.mUpdaterRunningMileage();
                    break;
                case 100:
                    Golf7OilMileagePage1LowActi.this.mUpdaterDrivingTime();
                    break;
                case 101:
                    Golf7OilMileagePage1LowActi.this.mUpdaterAverageSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_oil_page1_low);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DataCanbus.PROXY.cmd(98, new int[]{2}, null, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    protected void finalize() throws Throwable {
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterAverageOil() {
        int value = DataCanbus.DATA[97];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + CamryData.OIL_EXPEND_UNIT_L_PER_100KM);
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)).setText("--.--");
                    return;
                }
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && mValue != 6553 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)).setText(String.valueOf(mValue) + Golf7Data.mOilUnitXp1[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil_low)).setText("--.--" + Golf7Data.mOilUnitXp1[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[98];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)) != null) {
            if (ConstGolf.isWcGolf() || DataCanbus.DATA[1000] == 45) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage_low)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterRunningMileage() {
        int value = DataCanbus.DATA[99];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage_low)) != null) {
            if (ConstGolf.isWcGolf() || DataCanbus.DATA[1000] == 45) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage_low)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km");
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 536870911;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage_low)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingTime() {
        int value = DataCanbus.DATA[100];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time_low)) != null) {
            if (ConstGolf.isWcGolf() || DataCanbus.DATA[1000] == 45) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time_low)).setText(String.valueOf(value / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value % 60) + " " + getResources().getString(R.string.time_minute));
            } else {
                int value2 = value & 16777215;
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time_low)).setText(String.valueOf(value2 / 60) + getResources().getString(R.string.time_hour) + (value2 % 60) + getResources().getString(R.string.time_minute));
            }
        }
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[101];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity_low)) != null) {
            if (ConstGolf.isWcGolf() || DataCanbus.DATA[1000] == 45) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity_low)).setText(String.valueOf(value) + "km/h");
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity_low)).setText(String.valueOf(mValue) + Golf7Data.mSpeedUnitXp[unit]);
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
