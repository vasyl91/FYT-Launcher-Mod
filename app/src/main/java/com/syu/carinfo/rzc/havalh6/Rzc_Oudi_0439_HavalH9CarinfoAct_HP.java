package com.syu.carinfo.rzc.havalh6;

import android.os.Bundle;
import android.os.SystemProperties;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Rzc_Oudi_0439_HavalH9CarinfoAct_HP extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    if (value >= 64) {
                        int temp = ((value * 30) / 4) - 480;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_condensate_value)).setText((temp / 10.0f) + "℃");
                        break;
                    } else {
                        int temp2 = 480 - ((value * 30) / 4);
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_condensate_value)).setText("-" + (temp2 / 10.0f) + "℃");
                        break;
                    }
                case 119:
                    if (value >= 40) {
                        int temp3 = value - 40;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(temp3 + "℃");
                        break;
                    } else {
                        int temp4 = 40 - value;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText("-" + temp4 + "℃");
                        break;
                    }
                case 120:
                    int temp5 = (value * 10) / 4;
                    ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_voltage_value)).setText((temp5 / 10.0f) + "V");
                    break;
                case 121:
                    int temp6 = value * 59;
                    ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(temp6 / 100) + "." + ((temp6 % 100) / 10) + "Kpa");
                    break;
                case 122:
                    if ((value & 128) == 128) {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 123:
                    ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 124:
                    if ((value & 128) == 128) {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("R:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("L:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 126:
                    if ((value & 32768) == 32768) {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_altitude_value)).setText("-" + (value & 32767) + "m");
                        break;
                    } else {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.od_havalh9_altitude_value)).setText((value & 32767) + "m");
                        break;
                    }
                case 140:
                    if ((value & 32768) == 32768) {
                        int value2 = (((65536 - value) / 2) * 33) / 540;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("L:%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + "°");
                        break;
                    } else {
                        int value3 = ((value / 2) * 33) / 540;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct_HP.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("R:%d.%d", Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10))) + "°");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String platform = SystemProperties.get("ro.fyt.platform", "");
        if ("6315".equals(platform) || "6312".equals(platform) || "6521".equals(platform) || "6316".equals(platform) || "6318".equals(platform)) {
            //setContentView(R.layout.layout_0439_od_havalh9carinfo_hp);
        } else {
            //setContentView(R.layout.layout_0439_od_havalh9carinfo_hp_old);
        }
        init();
    }

    @Override
    public void init() {
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
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[121].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[122].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[123].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[123].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
    }
}
