package com.syu.carinfo.camry2012.xp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.BaseActivity;
import com.syu.canbus.R;
import com.syu.module.IUiNotify;
import com.syu.module.canbus.DataCanbus;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class CamryMeterActi extends BaseActivity {
    int carid = 0;
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryMeterActi.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 0:
                    CamryMeterActi.this.mUpdaterAveSpeed();
                    break;
                case 5:
                    CamryMeterActi.this.unit = (value >> 24) & 255;
                    break;
                case 48:
                    CamryMeterActi.this.mUpdaterRearLock();
                    break;
                case 49:
                    CamryMeterActi.this.mUpdaterFRLock();
                    break;
                case 50:
                    CamryMeterActi.this.mUpdaterFLLock();
                    break;
                case 51:
                    CamryMeterActi.this.mUpdaterDomer();
                    break;
                case 52:
                    CamryMeterActi.this.mUpdaterTripTotal();
                    break;
                case 53:
                    CamryMeterActi.this.mUpdaterTripLast();
                    break;
                case 54:
                    CamryMeterActi.this.mUpdaterTripA();
                    break;
                case 55:
                    CamryMeterActi.this.mUpdaterTripB();
                    break;
                case 56:
                    CamryMeterActi.this.mUpdaterCurSpeed();
                    break;
                case 57:
                    CamryMeterActi.this.mUpdaterEngine();
                    break;
                case 58:
                    CamryMeterActi.this.mUpdaterOutTemp();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_base_info);
        findViewById(R.id.camry_light).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamryMeterActi.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(CamryMeterActi.this, CamryLightActi.class);
                    CamryMeterActi.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.carid = (DataCanbus.DATA[1000] >> 16) & 65535;
    }

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DataCanbus.PROXY.cmd(20, new int[]{65}, null, null);
        addNotify();
    }

    @Override // com.syu.canbus.BaseActivity
    public void addNotify() {
        DataCanbus.NOTIFY_EVENTS[52].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[53].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[54].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[55].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[56].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[0].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[57].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[58].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[48].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[49].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[5].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[55].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[56].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[0].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[57].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[58].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[48].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[49].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[5].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripTotal() {
        int value = DataCanbus.DATA[52];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_total)).setText(String.valueOf(value) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_total)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_total)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_total)).setText("--.-- km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripLast() {
        int value = DataCanbus.DATA[53];
        if (this.unit == 1) {
            if (value > 0 && value < 10000) {
                ((TextView) findViewById(R.id.camry_meter_mile)).setText(String.valueOf(value) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_mile)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0 && value < 10000) {
            ((TextView) findViewById(R.id.camry_meter_mile)).setText(String.valueOf(value) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_mile)).setText("--.-- km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripA() {
        int value = DataCanbus.DATA[54];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_a)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_a)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_a)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_a)).setText("--.-- km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripB() {
        int value = DataCanbus.DATA[55];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " miles");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- miles");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_b)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km");
        } else {
            ((TextView) findViewById(R.id.camry_meter_b)).setText("--.-- km");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterCurSpeed() {
        int value = DataCanbus.DATA[56];
        if (this.unit == 1) {
            if (value > 0) {
                ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " mph");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText("--.-- mph");
                return;
            }
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " km/h");
        } else {
            ((TextView) findViewById(R.id.camry_meter_curr_speed)).setText("--.-- km/h");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterAveSpeed() {
        int value = DataCanbus.DATA[0];
        if (this.unit == 1) {
            if (value > 0) {
                if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
                    ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " mph");
                    return;
                } else {
                    ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " mph");
                    return;
                }
            }
            ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText("--.-- mph");
            return;
        }
        if (value > 0) {
            if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
                ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 100), Integer.valueOf(value % 100))) + " km/h");
                return;
            } else {
                ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText(String.valueOf(String.format("%d.%d", Integer.valueOf(value / 10), Integer.valueOf(value % 10))) + " km/h");
                return;
            }
        }
        ((TextView) findViewById(R.id.camry_meter_ave_speed)).setText("--.-- km/h");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterEngine() {
        int value = DataCanbus.DATA[57];
        if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
            value /= 4;
        }
        if (value > 0) {
            ((TextView) findViewById(R.id.camry_meter_engine_speed)).setText(String.valueOf(value) + " RPM");
        } else {
            ((TextView) findViewById(R.id.camry_meter_engine_speed)).setText("--.-- RPM");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterOutTemp() {
        int value = DataCanbus.DATA[58];
        if ((DataCanbus.DATA[1000] & 65535) == 112 || ((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77)) {
            if (value == 0) {
                ((TextView) findViewById(R.id.camry_meter_out_temp)).setText("--.-- °C");
                return;
            }
            if (value < 80) {
                int value2 = 400 - (value * 5);
                ((TextView) findViewById(R.id.camry_meter_out_temp)).setText("-" + (value2 / 10) + "." + (value2 % 10) + " °C");
                return;
            } else {
                if (value >= 80) {
                    int value3 = (value * 5) - 400;
                    ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value3 / 10) + "." + (value3 % 10) + " °C");
                    return;
                }
                return;
            }
        }
        if (value > -1 && value < 100) {
            ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value) + " °C");
        } else if (value > 100) {
            ((TextView) findViewById(R.id.camry_meter_out_temp)).setText(String.valueOf(value - 256) + " °C");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterRearLock() {
        int i = R.drawable.ic_camry_lock_lock;
        int value = DataCanbus.DATA[48];
        if (((DataCanbus.DATA[1000] & 65535) == 397 && this.carid >= 42 && this.carid <= 77) || (DataCanbus.DATA[1000] & 65535) == 112) {
            ((TextView) findViewById(R.id.camry_lock_rear_left)).setBackgroundResource((value & 2) == 0 ? 2130839342 : 2130839343);
            TextView textView = (TextView) findViewById(R.id.camry_lock_rear_right);
            if ((value & 1) != 0) {
                i = 2130839343;
            }
            textView.setBackgroundResource(i);
            return;
        }
        ((TextView) findViewById(R.id.camry_lock_rear_left)).setBackgroundResource(value == 0 ? 2130839342 : 2130839343);
        TextView textView2 = (TextView) findViewById(R.id.camry_lock_rear_right);
        if (value != 0) {
            i = 2130839343;
        }
        textView2.setBackgroundResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFRLock() {
        int value = DataCanbus.DATA[49];
        ((TextView) findViewById(R.id.camry_lock_front_right)).setBackgroundResource(value == 0 ? R.drawable.ic_camry_lock_lock : R.drawable.ic_camry_lock_unlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFLLock() {
        int value = DataCanbus.DATA[50];
        ((TextView) findViewById(R.id.camry_lock_front_left)).setBackgroundResource(value == 0 ? R.drawable.ic_camry_lock_lock : R.drawable.ic_camry_lock_unlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDomer() {
        int value = DataCanbus.DATA[51];
        switch (value) {
            case 1:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText(R.string.camry_dormer_open);
                break;
            case 2:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText(R.string.camry_dormer_close);
                break;
            case 3:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText(R.string.camry_dormer_half_open);
                break;
            default:
                ((TextView) findViewById(R.id.camry_dormer_status)).setText("--");
                break;
        }
    }
}
