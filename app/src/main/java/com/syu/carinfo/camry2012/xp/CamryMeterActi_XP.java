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
public class CamryMeterActi_XP extends BaseActivity {
    int carid = 0;
    int unit = 0;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.carinfo.camry2012.xp.CamryMeterActi_XP.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int value = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 86:
                    CamryMeterActi_XP.this.mUpdaterAveSpeed();
                    break;
                case 91:
                    CamryMeterActi_XP.this.unit = (value >> 24) & 255;
                    break;
                case 134:
                    CamryMeterActi_XP.this.mUpdaterRearLock();
                    break;
                case 135:
                    CamryMeterActi_XP.this.mUpdaterFRLock();
                    break;
                case 136:
                    CamryMeterActi_XP.this.mUpdaterFLLock();
                    break;
                case 137:
                    CamryMeterActi_XP.this.mUpdaterDomer();
                    break;
                case 138:
                    CamryMeterActi_XP.this.mUpdaterTripTotal();
                    break;
                case 139:
                    CamryMeterActi_XP.this.mUpdaterTripLast();
                    break;
                case 140:
                    CamryMeterActi_XP.this.mUpdaterTripA();
                    break;
                case 141:
                    CamryMeterActi_XP.this.mUpdaterTripB();
                    break;
                case 142:
                    CamryMeterActi_XP.this.mUpdaterCurSpeed();
                    break;
                case 143:
                    CamryMeterActi_XP.this.mUpdaterEngine();
                    break;
                case 144:
                    CamryMeterActi_XP.this.mUpdaterOutTemp();
                    break;
            }
        }
    };

    @Override // com.syu.canbus.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_camry_base_info);
        findViewById(R.id.camry_light).setOnClickListener(new View.OnClickListener() { // from class: com.syu.carinfo.camry2012.xp.CamryMeterActi_XP.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setClass(CamryMeterActi_XP.this, CamryLightActi_XP.class);
                    CamryMeterActi_XP.this.startActivity(intent);
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
        DataCanbus.NOTIFY_EVENTS[138].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[139].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[140].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[141].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[142].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[86].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[143].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[144].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[134].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[135].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[136].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[137].addNotify(this.mNotifyCanbus, 1);
        DataCanbus.NOTIFY_EVENTS[91].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.canbus.BaseActivity
    public void removeNotify() {
        DataCanbus.NOTIFY_EVENTS[138].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[139].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[140].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[141].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[142].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[86].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[143].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[144].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[134].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[135].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[136].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[137].removeNotify(this.mNotifyCanbus);
        DataCanbus.NOTIFY_EVENTS[91].removeNotify(this.mNotifyCanbus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterTripTotal() {
        int value = DataCanbus.DATA[138];
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
        int value = DataCanbus.DATA[139];
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
        int value = DataCanbus.DATA[140];
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
        int value = DataCanbus.DATA[141];
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
        int value = DataCanbus.DATA[142];
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
        int value = DataCanbus.DATA[86];
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
        int value = DataCanbus.DATA[143];
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
        int value = DataCanbus.DATA[144];
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
        int value = DataCanbus.DATA[134];
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
        int value = DataCanbus.DATA[135];
        ((TextView) findViewById(R.id.camry_lock_front_right)).setBackgroundResource(value == 0 ? R.drawable.ic_camry_lock_lock : R.drawable.ic_camry_lock_unlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterFLLock() {
        int value = DataCanbus.DATA[136];
        ((TextView) findViewById(R.id.camry_lock_front_left)).setBackgroundResource(value == 0 ? R.drawable.ic_camry_lock_lock : R.drawable.ic_camry_lock_unlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mUpdaterDomer() {
        int value = DataCanbus.DATA[137];
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
