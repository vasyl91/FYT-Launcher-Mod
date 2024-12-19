package com.syu.carinfo.dj.havalh8;

import android.os.Bundle;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Dj_0439_HavalH8CarinfoAct extends BaseActivity {
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.dj.havalh8.Dj_0439_HavalH8CarinfoAct.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 51:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_condensate_value)).setText(String.valueOf(value) + "℃");
                    break;
                case 52:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_oiltemp_value)).setText(String.valueOf(value) + "℃");
                    break;
                case 53:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_voltage_value)).setText(String.valueOf(value / 10) + "." + (value % 10) + "V");
                    break;
                case 54:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_pressure_value)).setText(String.valueOf(value) + "hPA");
                    break;
                case 55:
                    if ((value & 128) == 128) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("下:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_slope_value)).setText(String.valueOf(String.format("上:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 56:
                    ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_torque_value)).setText(String.valueOf(String.format("%d", Integer.valueOf(value))) + "%");
                    break;
                case 57:
                    if ((value & 128) == 128) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("右:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_inclination_value)).setText(String.valueOf(String.format("左:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    }
                case 58:
                    if (value == 1) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_mount_set);
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_trailer_value)).setText(R.string.str_nomount_set);
                        break;
                    }
                case 59:
                    if ((value & 32768) == 32768) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText("-" + (value & 32767) + "m");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.od_havalh9_altitude_value)).setText((value & 32767) + "m");
                        break;
                    }
                case 80:
                    if ((value & 128) == 128) {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("右:%d", Integer.valueOf(value & 127))) + "°");
                        break;
                    } else {
                        ((TextView) Dj_0439_HavalH8CarinfoAct.this.findViewById(R.id.tv_text1)).setText(String.valueOf(String.format("左:%d", Integer.valueOf(value))) + "°");
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
        DataCanbus.PROXY.cmd(7, new int[]{16}, null, null);
        DataCanbus.PROXY.cmd(7, new int[]{17}, null, null);
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
