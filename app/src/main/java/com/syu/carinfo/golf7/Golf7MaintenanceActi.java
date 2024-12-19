package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7MaintenanceActi extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7MaintenanceActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 16:
                    Golf7MaintenanceActi.this.mUpdaterOilMarkMax();
                    break;
                case 17:
                    Golf7MaintenanceActi.this.mUpdaterOilProgress();
                    break;
                case 18:
                    Golf7MaintenanceActi.this.mUpdaterOilUnit();
                    break;
                case 70:
                    Golf7MaintenanceActi.this.mUpdaterCarDays();
                    break;
                case 71:
                    Golf7MaintenanceActi.this.mUpdaterCarDistance();
                    break;
                case 72:
                    Golf7MaintenanceActi.this.mUpdaterOilDays();
                    break;
                case 73:
                    Golf7MaintenanceActi.this.mUpdaterOilDistancge();
                    break;
                case 82:
                    Golf7MaintenanceActi.this.mUpdaterCarId();
                    break;
                case 388:
                    if (value > -1 && value < 9) {
                        ((TextView) Golf7MaintenanceActi.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "/8");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setContentView(R.layout.layout_golf7_miantenance_od);
        } else {
            setContentView(R.layout.layout_golf7_miantenance);
        }
        if (DataCanbus.DATA[1000] == 2621600) {
            findViewById(R.id.layout_view1).setVisibility(0);
        } else {
            findViewById(R.id.layout_view1).setVisibility(8);
        }
        if (findViewById(R.id.turui_reset) != null) {
            findViewById(R.id.turui_reset).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7MaintenanceActi.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DataCanbus.PROXY.cmd(103, new int[]{141, 1}, null, null);
                }
            });
        }
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
        DataCanbus.NOTIFY_EVENTS[16].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[17].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[18].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[82].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[388].addNotify(this.mNotifyCanbus, 1);
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
        DataCanbus.NOTIFY_EVENTS[388].removeNotify(this.mNotifyCanbus);
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
            if (ConstGolf.isWcGolf()) {
                ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_unit)).setText(Golf7Data.mMtOilUnit[value]);
            } else {
                ((TextView) findViewById(R.id.golf7_tv_maintenance_consumption_unit)).setText(Golf7Data.mMtOilUnitXp[value]);
            }
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

    @Override // com.syu.canbus.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            finish();
            try {
                Intent intent = new Intent();
                if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                    intent.setClass(this, Golf7FunctionalActiOD.class);
                } else {
                    intent.setClass(this, Golf7IndexAct.class);
                }
                startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }
}
