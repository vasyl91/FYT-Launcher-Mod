package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7_XP_MaintenanceActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7_xp.Golf7_XP_MaintenanceActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 16:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilMarkMax();
                    break;
                case 17:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilProgress();
                    break;
                case 18:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilUnit();
                    break;
                case 70:
                    Golf7_XP_MaintenanceActi.this.mUpdaterCarDays();
                    break;
                case 71:
                    Golf7_XP_MaintenanceActi.this.mUpdaterCarDistance();
                    break;
                case 72:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilDays();
                    break;
                case 73:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilDistancge();
                    break;
                case 82:
                    Golf7_XP_MaintenanceActi.this.mUpdaterCarId();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_miantenance);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{99, 255}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[16].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[17].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[18].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[82].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilMarkMax() {
        int value = DataCanbus.DATA[16];
        if (value > -1 && value < 6) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_maximum_consumption_scale)).setText(Golf7Data.mOilMarkMax[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilProgress() {
        int value = DataCanbus.DATA[17];
        if (value > -1 && value < 101) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_percentage)).setText(String.valueOf(value) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilUnit() {
        int value = DataCanbus.DATA[18];
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_unit)).setText(Golf7Data.mMtOilUnitXp[value]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarId() {
        String value = ConstGolf.mCarId;
        if (value != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_vehicle_identification_number)).setText(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarDays() {
        int value = DataCanbus.DATA[70];
        int flag = value >> 24;
        int data = value & 65535;
        if (flag == 0) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_days)).setText("--");
        } else if (flag == 1) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_days)).setText(String.valueOf(data) + getResources().getString(R.string.day));
        } else if (flag == 2) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_days)).setText(String.valueOf(getResources().getString(R.string.overdue)) + data + getResources().getString(R.string.day));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarDistance() {
        int value = DataCanbus.DATA[71];
        int flag = value >> 24;
        int unit = (value >> 16) & 255;
        int distance = value & 65535;
        if (flag == 0) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText("--");
            return;
        }
        if (flag == 1) {
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText(String.valueOf(distance * 100) + Golf7Data.mMtDistanceUint[unit]);
                return;
            }
            return;
        }
        if (flag == 2 && unit > -1 && unit < 2) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText(String.valueOf(distance) + Golf7Data.mMtDistanceUint[unit]);
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText(String.valueOf(getResources().getString(R.string.overdue)) + (distance * 100) + Golf7Data.mMtDistanceUint[unit]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilDays() {
        int value = DataCanbus.DATA[72];
        int flag = value >> 24;
        int data = value & 65535;
        if (flag == 0) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_days)).setText("--");
        } else if (flag == 1) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_days)).setText(String.valueOf(data) + getResources().getString(R.string.day));
        } else if (flag == 2) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_days)).setText(String.valueOf(getResources().getString(R.string.overdue)) + data + getResources().getString(R.string.day));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilDistancge() {
        int value = DataCanbus.DATA[73];
        int flag = value >> 24;
        int unit = (value >> 16) & 255;
        int distance = value & 65535;
        if (flag == 0) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText("--");
            return;
        }
        if (flag == 1) {
            if (unit > -1 && unit < 2) {
                ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText(String.valueOf(distance * 100) + Golf7Data.mMtDistanceUint[unit]);
                return;
            }
            return;
        }
        if (flag == 2 && unit > -1 && unit < 2) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText(String.valueOf(distance) + Golf7Data.mMtDistanceUint[unit]);
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText(String.valueOf(getResources().getString(R.string.overdue)) + (distance * 100) + Golf7Data.mMtDistanceUint[unit]);
        }
    }
}
