package com.syu.carinfo.rzc.jianghuai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class RzcJianghuaiCarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.jianghuai.RzcJianghuaiCarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 34:
                    switch (value) {
                        case 0:
                            ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("S");
                            break;
                        case 1:
                            ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("E");
                            break;
                        case 2:
                            ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("L");
                            break;
                    }
                case 35:
                case 37:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_voltage_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 36:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_current_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "A");
                    break;
                case 38:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_mileage_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 39:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_rem_mileage_value)).setText(String.valueOf(value) + "km");
                    break;
                case 40:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_charging_value)).setText(String.valueOf(value) + "%");
                    break;
                case 41:
                    switch (value) {
                        case 0:
                            ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_battery_value)).setText(R.string.str_298_17crv_notdisplay);
                            break;
                        case 1:
                            ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_battery_value)).setText(R.string.str_227_ec180_car_state_2);
                            break;
                        case 2:
                            ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_battery_value)).setText(R.string.str_227_ec180_car_state_3);
                            break;
                    }
                case 42:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_avg_energycons_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/kwh");
                    break;
                case 43:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_cur_energycons_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/kwh");
                    break;
                case 44:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_energy_air_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kw");
                    break;
                case 45:
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_energy_recycle_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "kw");
                    break;
                case 46:
                    int value2 = (value * 30) / 4;
                    ((TextView) RzcJianghuaiCarinfoAct.this.findViewById(R.id.rzc_jianghuai_energy_motor_value)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "kw");
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_rzc_jianghuai_carinfo);
        init();
    }

    @Override // com.syu.canbus.BaseActivity
    public void init() {
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[34].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[35].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[36].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[37].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[38].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[39].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[40].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[41].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[42].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[43].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[44].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[45].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[46].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[35].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[36].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[38].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[39].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[40].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[41].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[43].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[44].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[45].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[46].removeNotify(this.mNotifyCanbus);
    }
}
