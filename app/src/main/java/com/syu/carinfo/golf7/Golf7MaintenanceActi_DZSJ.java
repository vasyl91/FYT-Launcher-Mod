package com.syu.carinfo.golf7;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Golf7MaintenanceActi_DZSJ extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.golf7.Golf7MaintenanceActi_DZSJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 70:
                case 71:
                    Golf7MaintenanceActi_DZSJ.this.mUpdaterCarDistance();
                    break;
                case 72:
                case 73:
                    Golf7MaintenanceActi_DZSJ.this.mUpdaterOilDistancge();
                    break;
                case 82:
                    Golf7MaintenanceActi_DZSJ.this.mUpdaterCarId();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
        setContentView(R.layout.layout_golf7_miantenance_od);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        if (DataCanbus.DATA[1000] == 327720 || DataCanbus.DATA[1000] == 393256 || DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
            setSelfClick((Button) findViewById(R.id.glf7_btn_car_back_od), new View.OnClickListener() { // from class: com.syu.carinfo.golf7.Golf7MaintenanceActi_DZSJ.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent();
                        intent.setClass(Golf7MaintenanceActi_DZSJ.this, Golf7FunctionalActiOD.class);
                        Golf7MaintenanceActi_DZSJ.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
    public void mUpdaterCarId() {
        String value = ConstGolf.mCarId;
        if (value != null) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_vehicle_identification_number)).setText(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCarDistance() {
        int value = DataCanbus.DATA[70];
        int flag_d = value >> 24;
        int data = value & 65535;
        String str_day = "";
        if (flag_d == 0) {
            str_day = "--";
        } else if (flag_d == 1) {
            str_day = String.valueOf(data) + getResources().getString(R.string.day);
        } else if (flag_d == 2) {
            str_day = String.valueOf(getResources().getString(R.string.overdue)) + data + getResources().getString(R.string.day);
        }
        int value2 = DataCanbus.DATA[71];
        int flag_m = value2 >> 24;
        int unit = (value2 >> 16) & 255;
        int distance = value2 & 65535;
        String str_Mileage = "";
        if (flag_m == 0) {
            str_Mileage = "--";
        } else if (flag_m == 1) {
            if (unit > -1 && unit < 2) {
                str_Mileage = String.valueOf(distance * 100) + Golf7Data.mMtDistanceUint[unit];
            }
        } else if (flag_m == 2 && unit > -1 && unit < 2) {
            str_Mileage = String.valueOf(getResources().getString(R.string.overdue)) + (distance * 100) + Golf7Data.mMtDistanceUint[unit];
        }
        if (flag_d == 0 && flag_m == 0) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText("--");
        } else {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_check_mileage)).setText(String.valueOf(str_day) + "s " + getResources().getString(R.string.str_or) + str_Mileage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOilDistancge() {
        int value = DataCanbus.DATA[72];
        int flag_d = value >> 24;
        int data = value & 65535;
        String str_day = "";
        if (flag_d == 0) {
            str_day = "--";
        } else if (flag_d == 1) {
            str_day = String.valueOf(data) + getResources().getString(R.string.day);
        } else if (flag_d == 2) {
            str_day = String.valueOf(getResources().getString(R.string.overdue)) + data + getResources().getString(R.string.day);
        }
        int value2 = DataCanbus.DATA[73];
        int flag_m = value2 >> 24;
        int unit = (value2 >> 16) & 255;
        int distance = value2 & 65535;
        String str_Mileage = "";
        if (flag_m == 0) {
            str_Mileage = "--";
        } else if (flag_m == 1) {
            if (unit > -1 && unit < 2) {
                str_Mileage = String.valueOf(distance * 100) + Golf7Data.mMtDistanceUint[unit];
            }
        } else if (flag_m == 2 && unit > -1 && unit < 2) {
            str_Mileage = String.valueOf(getResources().getString(R.string.overdue)) + (distance * 100) + Golf7Data.mMtDistanceUint[unit];
        }
        if (flag_d == 0 && flag_m == 0) {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText("--");
        } else {
            ((TextView) findViewById(R.id.golf7_tv_maintenance_oil_maintenance_mileage)).setText(String.valueOf(str_day) + "s " + getResources().getString(R.string.str_or) + str_Mileage);
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