package com.syu.carinfo.dj.havalh8;

import android.os.Bundle;
import android.widget.TextView;

import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

public class Dj_0439_HavalH8CarinfoAct extends BaseActivity {
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 118:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText(value + "℃");
                    break;
                case 119:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(value + "℃");
                    break;
                case 120:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText(value / 10 + "." + (value % 10) + "V");
                    break;
                case 121:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(value + "hPA");
                    break;
                case 122:
                    if ((value & 128) == 128) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.format("下:%d", Integer.valueOf(value & 127)) + "°");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.format("上:%d", Integer.valueOf(value & 127)) + "°");
                        break;
                    }
                case 124:
                    if ((value & 128) == 128) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.format("右:%d", Integer.valueOf(value & 127)) + "°");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.format("左:%d", Integer.valueOf(value & 127)) + "°");
                        break;
                    }
                case 125:
                    if (value == 1) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                        break;
                    }
                case 126:
                    if ((value & 32768) == 32768) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText("-" + (value & 32767) + "m");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText((value & 32767) + "m");
                        break;
                    }
                case 150:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.format("%d", Integer.valueOf(value)) + "%");
                    break;
                case 151:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.tv_text1)).setText(value + "%");
                    break;
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
        if (findViewById(R.id.layout_text_view1) != null) {
            ((TextView) findViewById(R.id.layout_text_view1)).setText(R.string.str_battery_power);
        }
        if (findViewById(R.id.layout_text_view10) != null) {
            ((TextView) findViewById(R.id.layout_text_view10)).setText(R.string.str_battery_health);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(7, new int[]{16}, null, null);
        DataCanbus.PROXY.cmd(7, new int[]{17}, null, null);
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
        DataCanbus.NOTIFY_EVENTS[150].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[124].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[125].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[126].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[151].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[121].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[122].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[150].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[124].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[125].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[126].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[151].removeNotify(this.mNotifyCanbus);
    }
}
