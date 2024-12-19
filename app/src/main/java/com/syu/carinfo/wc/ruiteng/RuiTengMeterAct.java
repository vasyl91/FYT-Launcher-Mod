package com.syu.carinfo.wc.ruiteng;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RuiTengMeterAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.wc.ruiteng.RuiTengMeterAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            switch (updateCode) {
                case 50:
                    RuiTengMeterAct.this.mUpdaterValue50();
                    break;
                case 51:
                    RuiTengMeterAct.this.mUpdaterValue51();
                    break;
                case 52:
                    RuiTengMeterAct.this.mUpdaterValue52();
                    break;
                case 53:
                    RuiTengMeterAct.this.mUpdaterValue53();
                    break;
                case 54:
                    RuiTengMeterAct.this.mUpdaterValue54();
                    break;
                case 70:
                    RuiTengMeterAct.this.mUpdaterValue55();
                    break;
                case 71:
                    RuiTengMeterAct.this.mUpdaterValue56();
                    break;
                case 72:
                    RuiTengMeterAct.this.mUpdaterValue57();
                    break;
                case 73:
                    RuiTengMeterAct.this.mUpdaterValue58();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wc_ruiteng_meter_info);
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[70].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[71].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[72].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[73].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[70].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[71].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[72].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[73].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue50() {
        int value = DataCanbus.DATA[50];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText("--");
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue51() {
        int value = DataCanbus.DATA[51];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)) != null) {
            if (value == 65535) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText("--");
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(new StringBuilder().append(value).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue52() {
        int value = DataCanbus.DATA[52];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)) != null) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(String.valueOf(value / 10.0f) + "V");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue53() {
        int value = DataCanbus.DATA[53];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)) != null) {
            if (value == 255) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText("-");
            } else if (value >= 0 && value <= 100) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(String.valueOf(value) + "%");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue54() {
        int value = DataCanbus.DATA[54];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_remaining_oil)) != null && value >= 0 && value <= 100) {
            ((TextView) findViewById(R.id.wc_ruiteng_func_btn_remaining_oil)).setText(String.valueOf(value) + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue55() {
        int value = DataCanbus.DATA[70];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(new StringBuilder().append(DataCanbus.DATA[50]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_motor_speed)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue56() {
        int value = DataCanbus.DATA[71];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(new StringBuilder().append(DataCanbus.DATA[51]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_shunshi_speed)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue57() {
        int value = DataCanbus.DATA[72];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(new StringBuilder().append(DataCanbus.DATA[52]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_battery_voltage)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterValue58() {
        int value = DataCanbus.DATA[73];
        if (((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)) != null) {
            if (value == 1) {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(new StringBuilder().append(DataCanbus.DATA[53]).toString());
            } else {
                ((TextView) findViewById(R.id.wc_ruiteng_func_btn_integrity_door_position)).setText(getResources().getString(R.string.wc_ruiteng_string_no_support));
            }
        }
    }
}
