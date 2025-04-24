package com.syu.carinfo.rzc.xima;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.carinfo.widget.DoorContentView;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;
import com.syu.ui.door.DoorHelper;

@SuppressWarnings({"deprecation", "unchecked"})
public class OD_NissanXimaCarinfoAct extends BaseActivity {
    int tempunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    OD_NissanXimaCarinfoAct.this.mUpdaterDoor();
                    OD_NissanXimaCarinfoAct.this.mUpdaterDoorBack();
                    break;
                case 114:
                    OD_NissanXimaCarinfoAct.this.mUpdaterSafetyBelt();
                    break;
                case 115:
                    OD_NissanXimaCarinfoAct.this.mUpdaterCleanLiquid();
                    break;
                case 116:
                    OD_NissanXimaCarinfoAct.this.mUpdaterBreakwarn();
                    break;
                case 117:
                    OD_NissanXimaCarinfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 118:
                    OD_NissanXimaCarinfoAct.this.mUpdaterCurrentVelocity();
                    break;
                case 119:
                    OD_NissanXimaCarinfoAct.this.mUpdaterBatteryVol();
                    break;
                case 120:
                    OD_NissanXimaCarinfoAct.this.mUpdaterOutTemp();
                    break;
                case 121:
                    OD_NissanXimaCarinfoAct.this.mUpdaterDrivingMileage();
                    break;
                case 122:
                    OD_NissanXimaCarinfoAct.this.mUpdaterLastOil();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_dasauto);
        init();
    }

    @Override
    public void init() {
        ((Button) findViewById(R.id.dasauto_btn_setting)).setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(OD_NissanXimaCarinfoAct.this, OD_NissanTireAct.class);
                    OD_NissanXimaCarinfoAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
        DoorHelper.disableDoorWindowLocal(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override
    public void addNotify() {
        this.tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
    }

    
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[117];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText("--.-- RPM");
        }
    }

    
    public void mUpdaterCurrentVelocity() {
        int value = DataCanbus.DATA[118];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText(String.valueOf(value * 0.01f) + " km/h");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText("--.-- km/h");
        }
    }

    
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[121];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText("--.-- km");
        }
    }

    
    public void mUpdaterSafetyBelt() {
        int value = DataCanbus.DATA[114];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_safety_belt_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_safety_belt)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_safety_belt_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterCleanLiquid() {
        int value = DataCanbus.DATA[115];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_cleaning_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_cleaning_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterBreakwarn() {
        int value = DataCanbus.DATA[116];
        if (value == 1) {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(R.string.alarm);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setTextColor(-65536);
            ((TextView) findViewById(R.id.dasauto_hand_brake_xp_icon)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setText(R.string.normal);
            ((TextView) findViewById(R.id.dasauto_tv_hand_brake)).setTextColor(-1);
            ((TextView) findViewById(R.id.dasauto_hand_brake_xp_icon)).setVisibility(8);
        }
    }

    
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[119];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText("--.-- V");
        }
    }

    
    public void mUpdaterOutTemp() {
        int value = DataCanbus.DATA[120];
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText("OFF");
                return;
            }
            if (this.tempunit == 1) {
                if ((value & 32768) != 0) {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf(((((value - 65536) * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                } else {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf((((value * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                }
            }
            if ((value & 32768) != 0) {
                int value2 = value - 65536;
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText("-" + (value2 / 10) + "." + (value2 % 10) + " ℃");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(value / 10) + "." + (value % 10) + " ℃");
            }
        }
    }

    
    public void mUpdaterLastOil() {
        int value = DataCanbus.DATA[122];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText("--.-- km");
        }
    }

    
    public void mUpdaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_xp)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_xp)).invalidate();
        }
    }

    
    public void mUpdaterDoorBack() {
        if (DoorHelper.sUcDoorBack > -1) {
            int value = DataCanbus.DATA[DoorHelper.sUcDoorBack];
            if (value == 1) {
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setText(R.string.alarm);
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setTextColor(-65536);
                ((TextView) findViewById(R.id.dasauto_trunk_xp_icon)).setVisibility(0);
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setText(R.string.normal);
                ((TextView) findViewById(R.id.dasauto_tv_trunk)).setTextColor(-1);
                ((TextView) findViewById(R.id.dasauto_trunk_xp_icon)).setVisibility(8);
            }
        }
    }
}
