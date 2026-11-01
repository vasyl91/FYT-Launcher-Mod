package com.syu.carinfo.oudi;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class RZC_0314_DongfengEv3_CarInfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.oudi.RZC_0314_DongfengEv3_CarInfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 103:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempMotor();
                    break;
                case 104:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempMotorCtrl();
                    break;
                case 105:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageLow();
                    break;
                case 106:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageHigh();
                    break;
                case 107:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageLowNum();
                    break;
                case 108:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateVoltageHighNum();
                    break;
                case 109:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempLow();
                    break;
                case 110:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempHigh();
                    break;
                case 111:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempLowNum();
                    break;
                case 112:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateTempHighNum();
                    break;
                case 113:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateRemainBattery();
                    break;
                case 114:
                    RZC_0314_DongfengEv3_CarInfoAct.this.updateBatteryState();
                    break;
                case 115:
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
        DataCanbus.NOTIFY_EVENTS[103].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[105].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[106].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[107].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[108].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[109].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[103].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[105].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[106].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[107].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[108].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[109].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBMSState() {
        int value = DataCanbus.DATA[115];
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
        int value = DataCanbus.DATA[114];
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
        int value = DataCanbus.DATA[113];
        ((TextView) findViewById(R.id.rzc_yizhiev3_battery_remain)).setText(String.valueOf(value) + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempHighNum() {
        int value = DataCanbus.DATA[112];
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_high_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempLowNum() {
        int value = DataCanbus.DATA[111];
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_low_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempHigh() {
        int value = DataCanbus.DATA[110];
        if (value > 50) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_temp_high)).setText(String.valueOf(value - 50) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_high)).setText("-" + (50 - value) + "℃");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempLow() {
        int value = DataCanbus.DATA[109];
        if (value > 50) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_temp_low)).setText(String.valueOf(value - 50) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_temp_low)).setText("-" + (50 - value) + "℃");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageHighNum() {
        int value = DataCanbus.DATA[107];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_high_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageLowNum() {
        int value = DataCanbus.DATA[107];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_low_num)).setText(new StringBuilder(String.valueOf(value)).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageHigh() {
        int value = DataCanbus.DATA[106];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_low)).setText(String.valueOf(value / 1000) + "." + ((value % 1000) / 100) + ((value % 100) / 10) + (value % 10) + "V");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVoltageLow() {
        int value = DataCanbus.DATA[105];
        ((TextView) findViewById(R.id.rzc_yizhiev3_voltage_high)).setText(String.valueOf(value / 1000) + "." + ((value % 1000) / 100) + ((value % 100) / 10) + (value % 10) + "V");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempMotorCtrl() {
        int value = DataCanbus.DATA[104];
        if (value > 40) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_motor_ctrl_temp)).setText(String.valueOf(value - 40) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_motor_ctrl_temp)).setText("-" + (40 - value) + "℃");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTempMotor() {
        int value = DataCanbus.DATA[103];
        if (value > 40) {
            ((TextView) findViewById(R.id.rzc_yizhiev3_motor_temp)).setText(String.valueOf(value - 40) + "℃");
            return;
        }
        ((TextView) findViewById(R.id.rzc_yizhiev3_motor_temp)).setText("-" + (40 - value) + "℃");
    }
}
