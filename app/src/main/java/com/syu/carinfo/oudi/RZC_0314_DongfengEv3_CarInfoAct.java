package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RZC_0314_DongfengEv3_CarInfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 91:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempMotor();
                    break;
                case 92:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempMotorCtrl();
                    break;
                case 93:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageLow();
                    break;
                case 94:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageHigh();
                    break;
                case 95:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageLowNum();
                    break;
                case 96:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageHighNum();
                    break;
                case 97:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempLow();
                    break;
                case 98:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempHigh();
                    break;
                case 99:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempLowNum();
                    break;
                case 100:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempHighNum();
                    break;
                case 101:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateRemainBattery();
                    break;
                case 102:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateBatteryState();
                    break;
                case 103:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateBMSState();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0314_dongfengev3_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[92].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[93].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[94].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[95].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[96].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[97].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[98].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[102].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[92].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[93].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[94].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[95].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[96].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[97].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[98].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[102].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBMSState() {
        int value = DataCanbus.DATA[103];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.rzc_yizhiev3_bms_charge_state)).setText(R.string.str_313_parking_charge);
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_yizhiev3_bms_charge_state)).setText(R.string.str_313_driving_charge);
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_yizhiev3_bms_charge_state)).setText(R.string.str_313_not_charged);
                break;
            case 4:
                ((TextView) findViewById(R.id.rzc_yizhiev3_bms_charge_state)).setText(R.string.str_313_finished_charging);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBatteryState() {
        int value = DataCanbus.DATA[102];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.rzc_yizhiev3_charge_state)).setText(R.string.discharging);
                break;
            case 2:
                ((TextView) findViewById(R.id.rzc_yizhiev3_charge_state)).setText(R.string.charging);
                break;
            case 3:
                ((TextView) findViewById(R.id.rzc_yizhiev3_charge_state)).setText(R.string.str_slow_charging);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRemainBattery() {
        int value = DataCanbus.DATA[101];
        ((TextView) findViewById(R.id.rzc_yizhiev3_battery_remain)).setText(String.valueOf(value) + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempHighNum() {
        int value = DataCanbus.DATA[100];
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_high_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempLowNum() {
        int value = DataCanbus.DATA[99];
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_low_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempHigh() {
        int value = DataCanbus.DATA[98];
        if (value > 50) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_temp_high)).setText(String.valueOf(value - 50) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_high)).setText("-" + (50 - value) + "℃");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempLow() {
        int value = DataCanbus.DATA[97];
        if (value > 50) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_temp_low)).setText(String.valueOf(value - 50) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_low)).setText("-" + (50 - value) + "℃");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageHighNum() {
        int value = DataCanbus.DATA[95];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_high_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageLowNum() {
        int value = DataCanbus.DATA[95];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_low_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageHigh() {
        int value = DataCanbus.DATA[94];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_low)).setText(String.valueOf(value / 1000) + "." + ((value % 1000) / 100) + ((value % 100) / 10) + (value % 10) + "V");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageLow() {
        int value = DataCanbus.DATA[93];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_high)).setText(String.valueOf(value / 1000) + "." + ((value % 1000) / 100) + ((value % 100) / 10) + (value % 10) + "V");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempMotorCtrl() {
        int value = DataCanbus.DATA[92];
        if (value > 40) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_motor_ctrl_temp)).setText(String.valueOf(value - 40) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_motor_ctrl_temp)).setText("-" + (40 - value) + "℃");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempMotor() {
        int value = DataCanbus.DATA[91];
        if (value > 40) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_motor_temp)).setText(String.valueOf(value - 40) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_motor_temp)).setText("-" + (40 - value) + "℃");
    }
}
