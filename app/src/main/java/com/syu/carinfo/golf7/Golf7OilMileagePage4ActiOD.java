package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7OilMileagePage4ActiOD extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7OilMileagePage4ActiOD.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    Golf7OilMileagePage4ActiOD.this.mUpdaterAverageOil();
                    break;
                case 1:
                    Golf7OilMileagePage4ActiOD.this.mUpdaterDrivingMileage();
                    break;
                case 2:
                    Golf7OilMileagePage4ActiOD.this.mUpdaterRunningMileage();
                    break;
                case 3:
                    Golf7OilMileagePage4ActiOD.this.mUpdaterDrivingTime();
                    break;
                case 4:
                    Golf7OilMileagePage4ActiOD.this.mUpdaterAverageSpeed();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_oil_page4_od);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageOil() {
        int value = DataCanbus.DATA[0];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "L/100km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText("--.--");
                    return;
                }
            }
            int unit = ((-536870912) & value) >> 29;
            int mValue = value & 65535;
            if (mValue != 65535 && mValue != 6553 && unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText(String.valueOf(mValue) + Golf7Data.mOilUnitXp1[unit]);
            } else if (unit > -1 && unit < 4) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_oil)).setText("--.--" + Golf7Data.mOilUnitXp1[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[1];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                if (value != 65535) {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "km");
                    return;
                } else {
                    ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)).setText("--");
                    return;
                }
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRunningMileage() {
        int value = DataCanbus.DATA[2];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + "km");
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 536870911;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_running_mileage)).setText(String.valueOf(mValue) + Golf7Data.mDistanceUnitXp[unit]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingTime() {
        int value = DataCanbus.DATA[3];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time)).setText(String.valueOf(value / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value % 60) + " " + getResources().getString(R.string.time_minute));
            } else {
                int value2 = value & 16777215;
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_driving_time)).setText(String.valueOf(value2 / 60) + " " + getResources().getString(R.string.time_hour) + " " + (value2 % 60) + " " + getResources().getString(R.string.time_minute));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAverageSpeed() {
        int value = DataCanbus.DATA[4];
        if (((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity)) != null) {
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity)).setText(String.valueOf(value) + "km/h");
                return;
            }
            int unit = (536870912 & value) >> 29;
            int mValue = value & 65535;
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_oil_since_start_average_velocity)).setText(String.valueOf(mValue) + Golf7Data.mSpeedUnitXp[unit]);
            }
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            return true;
        }
        return true;
    }
}
