package com.syu.carinfo.golf7;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7Electric_information_Acti extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7Electric_information_Acti.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            Log.d("canbus", String.format("updateCode:%d,unit_Distance[%d]", Integer.valueOf(updateCode), Integer.valueOf(DataCanbus.DATA[177] & 255)));
            switch (updateCode) {
                case 293:
                    Golf7Electric_information_Acti.this.mUpdaterDrivingPotential();
                    break;
                case 294:
                    Golf7Electric_information_Acti.this.mUpdaterEnergyFlow();
                    break;
                case 295:
                    Golf7Electric_information_Acti.this.mUpdaterDrivingMileage();
                    break;
                case 296:
                    Golf7Electric_information_Acti.this.mUpdaterElectricMileage();
                    break;
                case 297:
                    Golf7Electric_information_Acti.this.mUpdaterElectricOilRate();
                    break;
                case 303:
                    Golf7Electric_information_Acti.this.mUpdaterBatteryLevel();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_golf7_electric_information);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(98, new int[]{3}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[293].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[294].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[295].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[296].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[297].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[303].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[293].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[294].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[295].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[296].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[297].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[303].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingPotential() {
        int value = DataCanbus.DATA[293];
        int unit_wc = DataCanbus.DATA[177] & 255;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEnergyFlow() {
        int value = DataCanbus.DATA[294];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[295];
        int unit_wc = DataCanbus.DATA[177] & 255;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectricMileage() {
        int value = DataCanbus.DATA[296];
        int unit_wc = DataCanbus.DATA[177] & 255;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterElectricOilRate() {
        int value = DataCanbus.DATA[297];
        ((TextView) findViewById(R.id.golf7_tv_electric_oil_rate)).setText(String.valueOf(value) + " %");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryLevel() {
        int value = DataCanbus.DATA[303];
        ((TextView) findViewById(R.id.golf7_tv_electric_battery_level)).setText(String.valueOf(value) + " %");
    }
}
