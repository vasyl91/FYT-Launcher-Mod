package com.syu.carinfo.havah6;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class WC_0320_HavalH9CarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 99:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText(String.valueOf(value / 10.0f) + "V");
                    break;
                case 100:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText(String.valueOf(value - 40) + "℃");
                    break;
                case 101:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(String.valueOf(value) + "℃");
                    break;
                case 110:
                    int temp = value * 45;
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(temp / 10) + "." + (temp % 10) + "Kpa");
                    break;
                case 111:
                    if ((value & 128) == 128) {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 112:
                    ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 113:
                    if ((value & 128) == 128) {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 114:
                    if (WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value) != null) {
                        if ((value & 128) == 128) {
                            ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                            break;
                        } else {
                            ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                            break;
                        }
                    }
                    break;
                case 115:
                    if ((value & 32768) == 32768) {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText("-" + (value & 32767) + "m");
                        break;
                    } else {
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText((value & 32767) + "m");
                        break;
                    }
                case 156:
                    if ((value & 32768) == 32768) {
                        int value2 = (((65536 - value) / 2) * 33) / 54;
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("L:%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + "°");
                        break;
                    } else {
                        int value3 = ((value / 2) * 33) / 54;
                        ((TextView) WC_0320_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("R:%d.%d", Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10))) + "°");
                        break;
                    }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_0439_od_havalh9carinfo);
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
        DataCanbus.NOTIFY_EVENTS[100].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[101].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[99].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[110].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[111].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[113].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[114].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[115].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[156].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[100].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[101].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[99].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[110].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[111].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[156].removeNotify(this.mNotifyCanbus);
    }
}
