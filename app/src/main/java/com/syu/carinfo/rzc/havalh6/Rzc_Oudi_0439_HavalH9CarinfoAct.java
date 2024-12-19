package com.syu.carinfo.rzc.havalh6;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Rzc_Oudi_0439_HavalH9CarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_HavalH9CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 51:
                    if (value >= 64) {
                        int temp = ((value * 30) / 4) - 480;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText((temp / 10.0f) + "℃");
                        break;
                    } else {
                        int temp2 = 480 - ((value * 30) / 4);
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText("-" + (temp2 / 10.0f) + "℃");
                        break;
                    }
                case 52:
                    if (value >= 40) {
                        int temp3 = value - 40;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(temp3 + "℃");
                        break;
                    } else {
                        int temp4 = 40 - value;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText("-" + temp4 + "℃");
                        break;
                    }
                case 53:
                    int temp5 = (value * 10) / 4;
                    ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText((temp5 / 10.0f) + "V");
                    break;
                case 54:
                    int temp6 = value * 59;
                    ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(temp6 / 100) + "." + ((temp6 % 100) / 10) + "Kpa");
                    break;
                case 55:
                    if ((value & 128) == 128) {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("-%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 56:
                    ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 57:
                    if ((value & 128) == 128) {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("R:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("L:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 58:
                    if (Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value) != null) {
                        if ((value & 128) == 128) {
                            ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                            break;
                        } else {
                            ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                            break;
                        }
                    }
                    break;
                case 59:
                    if ((value & 32768) == 32768) {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText("-" + (value & 32767) + "m");
                        break;
                    } else {
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText((value & 32767) + "m");
                        break;
                    }
                case 80:
                    if ((value & 32768) == 32768) {
                        int value2 = (((65536 - value) / 2) * 33) / 540;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("L:%d.%d", Integer.valueOf(value2 / 10), Integer.valueOf(value2 % 10))) + "°");
                        break;
                    } else {
                        int value3 = ((value / 2) * 33) / 540;
                        ((TextView) Rzc_Oudi_0439_HavalH9CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("R:%d.%d", Integer.valueOf(value3 / 10), Integer.valueOf(value3 % 10))) + "°");
                        break;
                    }
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_0439_od_havalh9carinfo);
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
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[59].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[80].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[59].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[80].removeNotify(this.mNotifyCanbus);
    }
}
