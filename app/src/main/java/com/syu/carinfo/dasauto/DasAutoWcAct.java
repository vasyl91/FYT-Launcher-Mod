package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.widget.DoorContentView;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0001_WC1_DaZhong;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DasAutoWcAct extends BaseActivity {
    public Callback_0001_WC1_DaZhong mCallback = null;
    private IUiNotify notifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dasauto.DasAutoWcAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                    DasAutoWcAct.this.updaterTrip();
                    break;
                case 1:
                    DasAutoWcAct.this.updaterLastOilWarning();
                    break;
                case 2:
                    DasAutoWcAct.this.updaterBatteryVolWarning();
                    break;
                case 3:
                    DasAutoWcAct.this.updaterSafetyBelt();
                    break;
                case 4:
                    DasAutoWcAct.this.updaterCleanLiquid();
                    break;
                case 5:
                    DasAutoWcAct.this.updaterLastOil();
                    break;
                case 6:
                    DasAutoWcAct.this.updaterBatteryVol();
                    break;
                case 7:
                    DasAutoWcAct.this.updaterDrivingMileage();
                    break;
                case 12:
                    DasAutoWcAct.this.updaterWater();
                    break;
                case 13:
                    DasAutoWcAct.this.updaterEngine();
                    break;
                case 14:
                    DasAutoWcAct.this.updaterCurrentVelocity();
                    break;
                case 15:
                    DasAutoWcAct.this.updaterEngineSpeed();
                    break;
                case 20:
                    DasAutoWcAct.this.updaterOutTemp();
                    break;
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                    DasAutoWcAct.this.updaterDoor();
                    DasAutoWcAct.this.updaterDoorBack();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dasauto_wc);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        findViewById(R.id.dasauto_btn_setting_wc).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.dasauto.DasAutoWcAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DasAutoWcAct.this.startActivity(new Intent(LauncherApplication.getInstance(), (Class<?>) DasAutoSettingAct.class));
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        CallbackCanbusBase callback = ModuleCallbackCanbusProxy.getInstance().getCallbackCanbus();
        if (!(callback instanceof Callback_0001_WC1_DaZhong)) {
            finish();
        } else {
            this.mCallback = (Callback_0001_WC1_DaZhong) callback;
            addNotify();
        }
        if (LauncherApplication.getScreenWidth() != 800) {
            DoorHelper.disableDoorWindowLocal(true);
        }
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[47].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[6].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[7].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[8].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[9].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[10].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[11].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[12].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[13].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[14].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[15].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(this.notifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[47].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[6].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[7].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[8].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[9].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[10].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[11].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[12].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[13].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[14].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[15].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(this.notifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEngineSpeed() {
        int value = DataCanbus.DATA[15];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed_wc)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed_wc)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCurrentVelocity() {
        int value = DataCanbus.DATA[14];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText("--.-- Km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDrivingMileage() {
        int value = DataCanbus.DATA[7];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText(String.valueOf(value / 10.0f) + " Mil");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_mileage_wc)).setText("--.-- Mil");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterSafetyBelt() {
        int value = DataCanbus.DATA[3];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterCleanLiquid() {
        int value = DataCanbus.DATA[4];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterBatteryVol() {
        int value = DataCanbus.DATA[6];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterTrip() {
        int value = DataCanbus.DATA[0];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_trip_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_trip_wc)).setText("--.--L/100KM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterBatteryVolWarning() {
        int value = DataCanbus.DATA[2];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterEngine() {
        int value = DataCanbus.DATA[13];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[20];
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)) != null) {
            int mValue = (value * 5) - 400;
            if (mValue > 500) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)).setText("--.-- °C");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)).setText(String.valueOf(mValue * 0.1f) + " °C");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLastOil() {
        int value = DataCanbus.DATA[5];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setText(String.valueOf(value) + " L");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setText("--.-- L");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterWater() {
        int value = DataCanbus.DATA[12];
        if (value == 255) {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText("--.--");
        } else if (value == 0) {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText(R.string.normal);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText(String.valueOf(value) + " °C");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterLastOilWarning() {
        int value = DataCanbus.DATA[1];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc_icon)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_wc)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_wc)).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updaterDoorBack() {
        int value = DataCanbus.DATA[47];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_trunk_wc_icon)).setVisibility(8);
        }
    }
}
