package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_OilMileagePage2Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 102:
                    Golf7_XP_OilMileagePage2Acti.this.mUpdaterAverageOil();
                    break;
                case 103:
                    Golf7_XP_OilMileagePage2Acti.this.mUpdaterDrivingMileage();
                    break;
                case 104:
                    Golf7_XP_OilMileagePage2Acti.this.mUpdaterRunningMileage();
                    break;
                case 105:
                    Golf7_XP_OilMileagePage2Acti.this.mUpdaterDrivingTime();
                    break;
                case 106:
                    Golf7_XP_OilMileagePage2Acti.this.mUpdaterAverageSpeed();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_oil_page2);
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
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && mValue != 6553 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText(String.valueOf(mValue / 10) + "." + (mValue % 10) + Golf7Data.mOilUnitXp1[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_oil)).setText("--.--" + Golf7Data.mOilUnitXp1[unit]);
            }
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[103];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_mileage)) != null) {
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
            int value2 = value & 16777215;
            ((TextView) findViewById(R.id.golf7_tv_oil_long_term_driving_time)).setText(String.valueOf(value2 / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value2 % 60) + " " + getResources().getString(R.string.time_minute));
        }
    }

    
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[106];
        if (((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)) != null) {
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_long_term_term_velocity)).setText(String.valueOf(mValue) + Golf7Data.mSpeedUnitXp[unit]);
            }
        }
    }
}
