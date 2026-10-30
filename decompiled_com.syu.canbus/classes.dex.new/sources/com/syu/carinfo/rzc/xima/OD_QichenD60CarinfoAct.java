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

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class OD_QichenD60CarinfoAct extends BaseActivity {
    int tempunit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.xima.OD_QichenD60CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    OD_QichenD60CarinfoAct.this.mUpdaterDoor();
                    OD_QichenD60CarinfoAct.this.mUpdaterDoorBack();
                    break;
                case 98:
                    OD_QichenD60CarinfoAct.this.mUpdaterSafetyBelt();
                    break;
                case 100:
                    OD_QichenD60CarinfoAct.this.mUpdaterBreakwarn();
                    break;
                case 101:
                    OD_QichenD60CarinfoAct.this.mUpdaterEngineSpeed();
                    break;
                case 102:
                    OD_QichenD60CarinfoAct.this.mUpdaterCurrentVelocity();
                    break;
                case 103:
                    OD_QichenD60CarinfoAct.this.mUpdaterBatteryVol();
                    break;
                case 104:
                    OD_QichenD60CarinfoAct.this.mUpdaterOutTemp();
                    break;
                case 105:
                    OD_QichenD60CarinfoAct.this.mUpdaterDrivingMileage();
                    break;
                case 106:
                    OD_QichenD60CarinfoAct.this.mUpdaterLastOil();
                    break;
                case 111:
                    OD_QichenD60CarinfoAct.this.mUpdaterCleanLiquid();
                    break;
                case 112:
                    if (value == 1) {
                        ((TextView) OD_QichenD60CarinfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_unlocked);
                    } else {
                        ((TextView) OD_QichenD60CarinfoAct.this.findViewById(R.id.tv_text2)).setText(R.string.str_locked);
                    }
                    break;
                case 113:
                    ((TextView) OD_QichenD60CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(value) + "%");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0080_czh_nissan_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
        ((Button) findViewById(R.id.dasauto_btn_setting)).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.rzc.xima.OD_QichenD60CarinfoAct.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(OD_QichenD60CarinfoAct.this, OD_QichenD60TireAct.class);
                    OD_QichenD60CarinfoAct.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
        DoorHelper.disableDoorWindowLocal(true);
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
        DoorHelper.disableDoorWindowLocal(false);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        this.tempunit = SystemProperties.getInt("persist.fyt.temperature", 0);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[1].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[2].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[3].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[4].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[1].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[2].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[3].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[4].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngineSpeed() {
        int value = DataCanbus.DATA[101];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_engine_speed)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurrentVelocity() {
        int value = DataCanbus.DATA[102];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText(String.valueOf(value * 0.01f) + " km/h");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_current_speed)).setText("--.-- km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDrivingMileage() {
        int value = DataCanbus.DATA[105];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_mileage)).setText("--.-- km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterSafetyBelt() {
        int value = DataCanbus.DATA[98];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCleanLiquid() {
        int value = DataCanbus.DATA[111];
        switch (value) {
            case 0:
                ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText("P");
                break;
            case 1:
                ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText("R");
                break;
            case 2:
                ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText("N");
                break;
            case 3:
                ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText("D");
                break;
            case 4:
                ((TextView) findViewById(R.id.dasauto_tv_cleaning_liquid)).setText("S");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBreakwarn() {
        int value = DataCanbus.DATA[100];
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

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterBatteryVol() {
        int value = DataCanbus.DATA[103];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " V");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_battery_voltage)).setText("--.-- V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOutTemp() {
        int value = DataCanbus.DATA[104];
        if (((TextView) findViewById(R.id.dasauto_tv_outside_temperature)) != null) {
            if (value == 0) {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText("OFF");
                return;
            }
            if (this.tempunit == 1) {
                if ((value & 32768) != 0) {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf(((((65536 - value) * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                } else {
                    ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(String.format("%d", Integer.valueOf((((value * 9) / 5) + 320) / 10))) + " ℉");
                    return;
                }
            }
            if ((value & 32768) != 0) {
                int value2 = 65536 - value;
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText("-" + (value2 / 10) + "." + (value2 % 10) + " ℃");
            } else {
                ((TextView) findViewById(R.id.dasauto_tv_outside_temperature)).setText(String.valueOf(value / 10) + "." + (value % 10) + " ℃");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterLastOil() {
        int value = DataCanbus.DATA[106];
        if (value > 0) {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.dasauto_tv_last_oil)).setText("--.-- km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDoor() {
        if (((DoorContentView) findViewById(R.id.dasauto_door_xp)) != null) {
            ((DoorContentView) findViewById(R.id.dasauto_door_xp)).invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
