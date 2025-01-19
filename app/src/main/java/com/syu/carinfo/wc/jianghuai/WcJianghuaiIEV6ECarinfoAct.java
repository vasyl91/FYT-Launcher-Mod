package com.syu.carinfo.wc.jianghuai;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class WcJianghuaiIEV6ECarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 113:
                    switch (value) {
                        case 1:
                            ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("L");
                            break;
                        case 2:
                            ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("E");
                            break;
                        case 3:
                            ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_drivemode_value)).setText("S");
                            break;
                    }
                case 115:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_current_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "A");
                    break;
                case 116:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_voltage_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 117:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_mileage_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 118:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_rem_mileage_value)).setText(String.valueOf(value) + "km");
                    break;
                case 119:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_charging_value)).setText(String.valueOf(value) + "%");
                    break;
                case 120:
                    switch (value) {
                        case 0:
                            ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_battery_value)).setText(R.string.str_298_17crv_notdisplay);
                            break;
                        case 1:
                            ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_battery_value)).setText(R.string.str_227_ec180_car_state_2);
                            break;
                        case 2:
                            ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_battery_value)).setText(R.string.str_227_ec180_car_state_3);
                            break;
                    }
                case 121:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_avg_energycons_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/kmh");
                    break;
                case 122:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_cur_energycons_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km/kmh");
                    break;
                case 123:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_energy_air_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 124:
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_energy_recycle_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "km");
                    break;
                case 125:
                    int value2 = (value * 30) / 4;
                    ((TextView) WcJianghuaiIEV6ECarinfoAct.this.findViewById(R.id.rzc_jianghuai_energy_motor_value)).setText(String.valueOf(value2 / 10) + "." + (value2 % 10) + "km");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_rzc_jianghuai_carinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        addNotify();
    }

    @Override
    protected void onPause() {
        super.onPause();
        removeNotify();
    }

    @Override
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
    }
}
