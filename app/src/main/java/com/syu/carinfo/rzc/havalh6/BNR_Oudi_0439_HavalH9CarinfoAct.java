package com.syu.carinfo.rzc.havalh6;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

@SuppressWarnings({"deprecation", "unchecked"})
public class BNR_Oudi_0439_HavalH9CarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 112:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(value) + "hPA");
                    break;
                case 113:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText(String.valueOf(value) + "℃");
                    break;
                case 114:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(value + "℃");
                    break;
                case 115:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText((value / 10.0f) + "V");
                    break;
                case 116:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 117:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                        break;
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                        break;
                    }
                case 118:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("R:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("L:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 119:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("R:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("L:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 120:
                    if ((value & 128) == 128) {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("+%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 142:
                    ((TextView) BNR_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText(String.valueOf(value) + "m");
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
        DataCanbus.NOTIFY_EVENTS[112].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[120].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[116].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[118].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[117].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[119].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[113].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[114].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[115].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[112].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[116].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[118].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[117].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[119].removeNotify(this.mNotifyCanbus);
    }
}
