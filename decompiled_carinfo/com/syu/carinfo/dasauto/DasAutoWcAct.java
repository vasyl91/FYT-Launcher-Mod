package com.syu.carinfo.dasauto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.widget.DoorContentView;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.CallbackCanbusBase;
import com.syu.module.canbus.Callback_0001_WC1_DaZhong;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;
import com.syu.ui.door.DoorHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class DasAutoWcAct extends BaseActivity {
    public Callback_0001_WC1_DaZhong mCallback = null;
    private IUiNotify notifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    DasAutoWcAct.this.updaterDoor();
                    DasAutoWcAct.this.updaterDoorBack();
                    break;
                case 98:
                    DasAutoWcAct.this.updaterTrip();
                    break;
                case 99:
                    DasAutoWcAct.this.updaterLastOilWarning();
                    break;
                case 100:
                    DasAutoWcAct.this.updaterBatteryVolWarning();
                    break;
                case 101:
                    DasAutoWcAct.this.updaterSafetyBelt();
                    break;
                case 102:
                    DasAutoWcAct.this.updaterCleanLiquid();
                    break;
                case 103:
                    DasAutoWcAct.this.updaterLastOil();
                    break;
                case 104:
                    DasAutoWcAct.this.updaterBatteryVol();
                    break;
                case 105:
                    DasAutoWcAct.this.updaterDrivingMileage();
                    break;
                case 110:
                    DasAutoWcAct.this.updaterWater();
                    break;
                case 111:
                    DasAutoWcAct.this.updaterEngine();
                    break;
                case 112:
                    DasAutoWcAct.this.updaterCurrentVelocity();
                    break;
                case 113:
                    DasAutoWcAct.this.updaterEngineSpeed();
                    break;
                case 118:
                    DasAutoWcAct.this.updaterOutTemp();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_dasauto_wc);
        init();
    }

    @Override
    public void init() {
        findViewById(R.id.dasauto_btn_setting_wc).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                DasAutoWcAct.this.startActivity(new Intent(LauncherApplication.getInstance(), (Class<?>) DasAutoSettingAct.class));
            }
        });
    }

    @Override
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

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.notifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.notifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.notifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.notifyCanbus);
    }

    
    public void updaterEngineSpeed() {
        int value = DataCanbus.DATA[113];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed_wc)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed_wc)).setText("--.-- RPM");
        }
    }

    
    public void updaterCurrentVelocity() {
        int value = DataCanbus.DATA[112];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText(String.valueOf(value) + " Km/h");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText("--.-- Km/h");
        }
    }

    
    public void updaterDrivingMileage() {
        int value = DataCanbus.DATA[105];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed_wc)).setText(String.valueOf(value / 10.0f) + " Mil");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_mileage_wc)).setText("--.-- Mil");
        }
    }

    
    public void updaterSafetyBelt() {
        int value = DataCanbus.DATA[101];
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

    
    public void updaterCleanLiquid() {
        int value = DataCanbus.DATA[102];
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

    
    public void updaterBatteryVol() {
        int value = DataCanbus.DATA[104];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setText("--.-- V");
        }
    }

    
    public void updaterTrip() {
        int value = DataCanbus.DATA[98];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_trip_wc)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf((value >> 8) & 255), Integer.valueOf(value & 255))) + "L/100KM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_trip_wc)).setText("--.--L/100KM");
        }
    }

    
    public void updaterBatteryVolWarning() {
        int value = DataCanbus.DATA[100];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage_wc_icon)).setVisibility(8);
        }
    }

    
    public void updaterEngine() {
        int value = DataCanbus.DATA[111];
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

    
    public void updaterOutTemp() {
        int value = DataCanbus.DATA[118];
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)) != null) {
            int mValue = (value * 5) - 400;
            if (mValue > 500) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)).setText("--.-- °C");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature_wc)).setText(String.valueOf(mValue * 0.1f) + " °C");
            }
        }
    }

    
    public void updaterLastOil() {
        int value = DataCanbus.DATA[103];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setText(String.valueOf(value) + " L");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setText("--.-- L");
        }
    }

    
    public void updaterWater() {
        int value = DataCanbus.DATA[110];
        if (value == 255) {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText("--.--");
        } else if (value == 0) {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText(R.string.normal);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_water_wc)).setText(String.valueOf(value) + " °C");
        }
    }

    
    public void updaterLastOilWarning() {
        int value = DataCanbus.DATA[99];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_tv_last_oil_wc_icon)).setVisibility(8);
        }
    }

    
    public void updaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_wc)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_wc)).invalidate();
        }
    }

    
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
