package com.syu.carinfo.golf7_xp;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7Data;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class Golf7_XP_MaintenanceActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 113:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilMarkMax();
                    break;
                case 114:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilProgress();
                    break;
                case 115:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilUnit();
                    break;
                case 167:
                    Golf7_XP_MaintenanceActi.this.mUpdaterCarDays();
                    break;
                case 168:
                    Golf7_XP_MaintenanceActi.this.mUpdaterCarDistance();
                    break;
                case 169:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilDays();
                    break;
                case 170:
                    Golf7_XP_MaintenanceActi.this.mUpdaterOilDistancge();
                    break;
                case 179:
                    Golf7_XP_MaintenanceActi.this.mUpdaterCarId();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_golf7_miantenance);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{99, 255}, null, null);
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[167].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[168].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[169].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[170].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[179].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[167].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[168].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[169].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[170].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[179].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterOilMarkMax() {
        int value = DataCanbus.DATA[113];
        if (value > -1 && value < 6) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_maximum_consumption_scale)).setText(Golf7Data.mOilMarkMax[value]);
        }
    }

    
    public void mUpdaterOilProgress() {
        int value = DataCanbus.DATA[114];
        if (value > -1 && value < 101) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_percentage)).setText(String.valueOf(value) + "%");
        }
    }

    
    public void mUpdaterOilUnit() {
        int value = DataCanbus.DATA[115];
        if (value > -1 && value < 2) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_unit)).setText(Golf7Data.mMtOilUnitXp[value]);
        }
    }

    
    public void mUpdaterCarId() {
        String value = ConstGolf.mCarId;
        if (value != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_vehicle_identification_number)).setText(value);
        }
    }

    
    public void mUpdaterCarDays() {
        int value = DataCanbus.DATA[167];
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

    
    public void mUpdaterCarDistance() {
        int value = DataCanbus.DATA[168];
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

    
    public void mUpdaterOilDays() {
        int value = DataCanbus.DATA[169];
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

    
    public void mUpdaterOilDistancge() {
        int value = DataCanbus.DATA[170];
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
